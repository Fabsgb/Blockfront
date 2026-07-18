package foundry.veil.api.client.render;

import com.google.common.base.Suppliers;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.VertexBuffer;
import foundry.imgui.api.ImGuiMC;
import foundry.veil.Veil;
import foundry.veil.api.client.necromancer.render.NecromancerRenderer;
import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.api.client.render.ext.VeilDebug;
import foundry.veil.api.client.render.ext.VeilMultiBind;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.FramebufferManager;
import foundry.veil.api.client.render.framebuffer.FramebufferStack;
import foundry.veil.api.client.render.framebuffer.VeilFramebuffers;
import foundry.veil.api.client.render.light.renderer.LightRenderer;
import foundry.veil.api.client.render.post.PostPipeline;
import foundry.veil.api.client.render.post.PostProcessingManager;
import foundry.veil.api.client.render.profiler.RenderProfilerCounter;
import foundry.veil.api.client.render.profiler.VeilRenderProfiler;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.shader.ShaderManager;
import foundry.veil.api.client.render.shader.block.ShaderBlock;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.api.client.render.texture.VeilPreloadedTexture;
import foundry.veil.api.compat.SodiumCompat;
import foundry.veil.api.event.VeilRenderLevelStageEvent;
import foundry.veil.api.flare.modifier.RandomnessController;
import foundry.veil.ext.VertexBufferExtension;
import foundry.veil.impl.client.imgui.AdvancedFboImGuiAreaImpl;
import foundry.veil.impl.client.necromancer.render.NecromancerRenderDispatcher;
import foundry.veil.impl.client.render.dynamicbuffer.VanillaShaderCompiler;
import foundry.veil.impl.client.render.light.VoxelShadowGrid;
import foundry.veil.impl.client.render.pipeline.VeilBloomRenderer;
import foundry.veil.impl.client.render.pipeline.VeilShaderBlockState;
import foundry.veil.impl.client.render.pipeline.VeilShaderBufferCache;
import foundry.veil.impl.client.render.profiler.VeilRenderProfilerImpl;
import foundry.veil.impl.client.render.shader.program.ShaderProgramImpl;
import foundry.veil.mixin.pipeline.accessor.PipelineBufferSourceAccessor;
import foundry.veil.platform.VeilEventPlatform;
import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.MemoryUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/VeilRenderSystem.class */
public final class VeilRenderSystem {
    public static final RenderStateShard.OutputStateShard BLOOM_SHARD = new RenderStateShard.OutputStateShard("veil:bloom", VeilBloomRenderer::setupRenderState, VeilBloomRenderer::clearRenderState);
    private static final Executor RENDER_THREAD_EXECUTOR = task -> {
        if (!RenderSystem.isOnRenderThread()) {
            Objects.requireNonNull(task);
            RenderSystem.recordRenderCall(task::run);
        } else {
            task.run();
        }
    };
    private static final Set<ResourceLocation> ERRORED_SHADERS = new HashSet();
    private static final VeilShaderBlockState UNIFORM_BLOCK_STATE = new VeilShaderBlockState();
    private static final VeilShaderBufferCache SHADER_BUFFER_CACHE = new VeilShaderBufferCache();
    private static final BooleanSupplier TESSELLATION_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL40 || caps.GL_ARB_tessellation_shader);
    });
    private static final BooleanSupplier COMPUTE_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL43 || caps.GL_ARB_compute_shader);
    });
    private static final BooleanSupplier ATOMIC_COUNTER_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL42 || caps.GL_ARB_shader_atomic_counters);
    });
    private static final BooleanSupplier TRANSFORM_FEEDBACK_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL40 || caps.GL_ARB_transform_feedback3);
    });
    private static final BooleanSupplier MULTIBIND_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL44 || caps.GL_ARB_multi_bind);
    });
    private static final BooleanSupplier SPARSE_BUFFERS_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL44 || caps.GL_ARB_sparse_buffer);
    });
    private static final BooleanSupplier DIRECT_STATE_ACCESS_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL45 || caps.GL_ARB_direct_state_access);
    });
    private static final BooleanSupplier SEPARATE_SHADER_OBJECTS_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL41 || caps.GL_ARB_separate_shader_objects);
    });
    private static final BooleanSupplier CLEAR_TEXTURE_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL44 || caps.GL_ARB_clear_texture);
    });
    private static final BooleanSupplier COPY_IMAGE_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL43 || caps.GL_ARB_copy_image);
    });
    private static final BooleanSupplier SHADER_STORAGE_BLOCK_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL43 || caps.GL_ARB_shader_storage_buffer_object);
    });
    private static final BooleanSupplier PROGRAM_INTERFACE_QUERY_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL43 || caps.GL_ARB_program_interface_query);
    });
    private static final BooleanSupplier TEXTURE_ANISOTROPY_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL46 || caps.GL_ARB_texture_filter_anisotropic || caps.GL_EXT_texture_filter_anisotropic);
    });
    private static final BooleanSupplier TEXTURE_MIRROR_CLAMP_TO_EDGE_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL44 || caps.GL_ARB_texture_mirror_clamp_to_edge);
    });
    private static final BooleanSupplier TEXTURE_CUBE_MAP_SEAMLESS_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.GL_ARB_seamless_cubemap_per_texture);
    });
    private static final BooleanSupplier TEXTURE_CUBE_MAP_ARRAY_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL40 || caps.GL_ARB_texture_cube_map_array);
    });
    private static final BooleanSupplier NV_DRAW_TEXTURE_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.GL_NV_draw_texture);
    });
    private static final BooleanSupplier DRAW_INDIRECT_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL40 || caps.GL_ARB_draw_indirect);
    });
    private static final BooleanSupplier MULTI_DRAW_INDIRECT_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL43 || caps.GL_ARB_multi_draw_indirect);
    });
    private static final BooleanSupplier GPU_SHADER_FLOAT_64BIT_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL40 || caps.GL_ARB_gpu_shader_fp64);
    });
    private static final BooleanSupplier GPU_SHADER_INT_64BIT_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.GL_ARB_gpu_shader_int64);
    });
    private static final BooleanSupplier VERTEX_ATTRIB_64BIT_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL41 || caps.GL_ARB_vertex_attrib_64bit);
    });
    private static final BooleanSupplier BINDLESS_TEXTURE_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.GL_ARB_bindless_texture);
    });
    private static final BooleanSupplier VERTEX_TYPE_10F_11F_11F_REV_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.OpenGL44 || caps.GL_ARB_vertex_type_10f_11f_11f_rev);
    });
    private static final BooleanSupplier PIPELINE_STATISTICS_QUERY_SUPPORTED = glCapability(caps -> {
        return Boolean.valueOf(caps.GL_ARB_pipeline_statistics_query);
    });
    private static final IntSupplier MAX_COMBINED_TEXTURE_IMAGE_UNITS = glGetter(() -> {
        return GL11C.glGetInteger(35661);
    });
    private static final IntSupplier MAX_COLOR_ATTACHMENTS = glGetter(() -> {
        return GL11C.glGetInteger(36063);
    });
    private static final IntSupplier MAX_SAMPLES = glGetter(() -> {
        return GL11C.glGetInteger(36183);
    });
    private static final IntSupplier MAX_TRANSFORM_FEEDBACK_BUFFERS = glGetter(() -> {
        if (TRANSFORM_FEEDBACK_SUPPORTED.getAsBoolean()) {
            return GL11C.glGetInteger(36464);
        }
        return 0;
    });
    private static final IntSupplier MAX_UNIFORM_BUFFER_BINDINGS = glGetter(() -> {
        return GL11C.glGetInteger(35375);
    });
    private static final IntSupplier MAX_ATOMIC_COUNTER_BUFFER_BINDINGS = glGetter(() -> {
        return GL11C.glGetInteger(37596);
    });
    private static final IntSupplier MAX_SHADER_STORAGE_BUFFER_BINDINGS = glGetter(() -> {
        if (SHADER_STORAGE_BLOCK_SUPPORTED.getAsBoolean()) {
            return GL11C.glGetInteger(37085);
        }
        return 0;
    });
    private static final IntSupplier MAX_ARRAY_TEXTURE_LAYERS = glGetter(() -> {
        return GL11C.glGetInteger(35071);
    });
    private static final Supplier<Float> MAX_TEXTURE_ANISOTROPY = glGetter(() -> {
        return Float.valueOf(TEXTURE_ANISOTROPY_SUPPORTED.getAsBoolean() ? GL43C.glGetFloat(34047) : 1.0f);
    });
    private static final IntSupplier MAX_VERTEX_ATTRIBS = glGetter(() -> {
        return GL11C.glGetInteger(34921);
    });
    private static final IntSupplier MAX_VERTEX_ATTRIB_RELATIVE_OFFSET = glGetter(() -> {
        return Math.max(2047, GL11C.glGetInteger(33497));
    });
    private static final Supplier<VeilShaderLimits> VERTEX_SHADER_LIMITS = glGetter(() -> {
        GLCapabilities caps = GL.getCapabilities();
        return new VeilShaderLimits(caps, GL11C.glGetInteger(35658), GL11C.glGetInteger(35371), GL11C.glGetInteger(34921) * 4, GL11C.glGetInteger(37154), GL11C.glGetInteger(35660), 37066, 37586, 37580, 37078);
    });
    private static final Supplier<VeilShaderLimits> GL_TESS_CONTROL_SHADER_LIMITS = glGetter(() -> {
        GLCapabilities caps = GL.getCapabilities();
        return new VeilShaderLimits(caps, GL11C.glGetInteger(36479), GL11C.glGetInteger(36489), GL11C.glGetInteger(34924), GL11C.glGetInteger(36483), GL11C.glGetInteger(36481), 37067, 37587, 37581, 37080);
    });
    private static final Supplier<VeilShaderLimits> GL_TESS_EVALUATION_SHADER_LIMITS = glGetter(() -> {
        GLCapabilities caps = GL.getCapabilities();
        return new VeilShaderLimits(caps, GL11C.glGetInteger(36480), GL11C.glGetInteger(36490), GL11C.glGetInteger(34925), GL11C.glGetInteger(36486), GL11C.glGetInteger(36482), 37068, 37588, 37582, 37081);
    });
    private static final Supplier<VeilShaderLimits> GL_GEOMETRY_SHADER_LIMITS = glGetter(() -> {
        GLCapabilities caps = GL.getCapabilities();
        return new VeilShaderLimits(caps, GL11C.glGetInteger(36319), GL11C.glGetInteger(35372), GL11C.glGetInteger(37155), GL11C.glGetInteger(37156), GL11C.glGetInteger(35881), 37069, 37589, 37583, 37079);
    });
    private static final Supplier<VeilShaderLimits> GL_FRAGMENT_SHADER_LIMITS = glGetter(() -> {
        GLCapabilities caps = GL.getCapabilities();
        return new VeilShaderLimits(caps, GL11C.glGetInteger(35657), GL11C.glGetInteger(35373), GL11C.glGetInteger(37157), GL11C.glGetInteger(34852) * 4, GL11C.glGetInteger(34930), 37070, 37590, 37584, 37082);
    });
    private static final Supplier<VeilShaderLimits> GL_COMPUTE_SHADER_LIMITS = glGetter(() -> {
        GLCapabilities caps = GL.getCapabilities();
        return new VeilShaderLimits(caps, GL11C.glGetInteger(33379), GL11C.glGetInteger(37307), 0, 0, GL11C.glGetInteger(37308), 37309, 33381, 33380, 37083);
    });
    private static final Supplier<Vector2ic> MAX_FRAMEBUFFER_SIZE = Suppliers.memoize(() -> {
        RenderSystem.assertOnRenderThreadOrInit();
        if (!GL.getCapabilities().OpenGL43) {
            int maxSupportedTextureSize = RenderSystem.maxSupportedTextureSize();
            return new Vector2i(maxSupportedTextureSize, maxSupportedTextureSize);
        }
        int width = GL11C.glGetInteger(37653);
        int height = GL11C.glGetInteger(37654);
        return new Vector2i(width, height);
    });
    private static final Supplier<Vector3ic> MAX_COMPUTE_WORK_GROUP_COUNT = Suppliers.memoize(() -> {
        RenderSystem.assertOnRenderThreadOrInit();
        if (!COMPUTE_SUPPORTED.getAsBoolean()) {
            return new Vector3i();
        }
        int width = GL43C.glGetIntegeri(37310, 0);
        int height = GL43C.glGetIntegeri(37310, 1);
        int depth = GL43C.glGetIntegeri(37310, 2);
        return new Vector3i(width, height, depth);
    });
    private static final Supplier<Vector3ic> MAX_COMPUTE_WORK_GROUP_SIZE = Suppliers.memoize(() -> {
        RenderSystem.assertOnRenderThreadOrInit();
        if (!COMPUTE_SUPPORTED.getAsBoolean()) {
            return new Vector3i();
        }
        int width = GL43C.glGetIntegeri(37311, 0);
        int height = GL43C.glGetIntegeri(37311, 1);
        int depth = GL43C.glGetIntegeri(37311, 2);
        return new Vector3i(width, height, depth);
    });
    private static final IntSupplier MAX_COMPUTE_WORK_GROUP_INVOCATIONS = glGetter(() -> {
        if (COMPUTE_SUPPORTED.getAsBoolean()) {
            return GL11C.glGetInteger(37099);
        }
        return 0;
    });
    private static final LongSupplier MAX_UNIFORM_BLOCK_SIZE = glGetter(() -> {
        return GL43C.glGetInteger64(35376);
    });
    private static final IntSupplier UNIFORM_BUFFER_OFFSET_ALIGNMENT = glGetter(() -> {
        return GL11C.glGetInteger(35380);
    });
    private static final LongSupplier MAX_SHADER_STORAGE_BLOCK_SIZE = glGetter(() -> {
        if (SHADER_STORAGE_BLOCK_SUPPORTED.getAsBoolean()) {
            return GL43C.glGetInteger64(37086);
        }
        return 0L;
    });
    private static final Vector3f LIGHT0_DIRECTION = new Vector3f();
    private static final Vector3f LIGHT1_DIRECTION = new Vector3f();
    private static final Vector3f CAMERA_BOB_OFFSET = new Vector3f();
    private static VeilRenderer renderer;
    private static GpuVendor gpuVendor;
    private static ResourceLocation shaderLocation;
    private static int screenQuadVao;
    private static IntBuffer emptySamplers;

    private VeilRenderSystem() {
    }

    /* JADX INFO: renamed from: foundry.veil.api.client.render.VeilRenderSystem$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/VeilRenderSystem$1.class */
    class C13181 implements BooleanSupplier {
        private boolean value;
        private boolean initialized;
        final /* synthetic */ Function val$delegate;

        C13181(Function function) {
            function = function;
        }

        @Override // java.util.function.BooleanSupplier
        public boolean getAsBoolean() {
            RenderSystem.assertOnRenderThreadOrInit();
            if (!this.initialized) {
                this.initialized = true;
                boolean zBooleanValue = ((Boolean) function.apply(GL.getCapabilities())).booleanValue();
                this.value = zBooleanValue;
                return zBooleanValue;
            }
            return this.value;
        }
    }

    private static BooleanSupplier glCapability(Function<GLCapabilities, Boolean> delegate) {
        return new BooleanSupplier() { // from class: foundry.veil.api.client.render.VeilRenderSystem.1
            private boolean value;
            private boolean initialized;
            final /* synthetic */ Function val$delegate;

            C13181(Function delegate2) {
                function = delegate2;
            }

            @Override // java.util.function.BooleanSupplier
            public boolean getAsBoolean() {
                RenderSystem.assertOnRenderThreadOrInit();
                if (!this.initialized) {
                    this.initialized = true;
                    boolean zBooleanValue = ((Boolean) function.apply(GL.getCapabilities())).booleanValue();
                    this.value = zBooleanValue;
                    return zBooleanValue;
                }
                return this.value;
            }
        };
    }

    /* JADX INFO: renamed from: foundry.veil.api.client.render.VeilRenderSystem$2 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/VeilRenderSystem$2.class */
    class C13192 implements IntSupplier {
        private int value = Integer.MAX_VALUE;
        final /* synthetic */ IntSupplier val$delegate;

        C13192(IntSupplier intSupplier) {
            intSupplier = intSupplier;
        }

        @Override // java.util.function.IntSupplier
        public int getAsInt() {
            RenderSystem.assertOnRenderThreadOrInit();
            if (this.value == Integer.MAX_VALUE) {
                int asInt = intSupplier.getAsInt();
                this.value = asInt;
                return asInt;
            }
            return this.value;
        }
    }

    private static IntSupplier glGetter(IntSupplier delegate) {
        return new IntSupplier() { // from class: foundry.veil.api.client.render.VeilRenderSystem.2
            private int value = Integer.MAX_VALUE;
            final /* synthetic */ IntSupplier val$delegate;

            C13192(IntSupplier delegate2) {
                intSupplier = delegate2;
            }

            @Override // java.util.function.IntSupplier
            public int getAsInt() {
                RenderSystem.assertOnRenderThreadOrInit();
                if (this.value == Integer.MAX_VALUE) {
                    int asInt = intSupplier.getAsInt();
                    this.value = asInt;
                    return asInt;
                }
                return this.value;
            }
        };
    }

    /* JADX INFO: renamed from: foundry.veil.api.client.render.VeilRenderSystem$3 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/VeilRenderSystem$3.class */
    class C13203 implements LongSupplier {
        private long value = Long.MAX_VALUE;
        final /* synthetic */ LongSupplier val$delegate;

        C13203(LongSupplier longSupplier) {
            longSupplier = longSupplier;
        }

        @Override // java.util.function.LongSupplier
        public long getAsLong() {
            RenderSystem.assertOnRenderThreadOrInit();
            if (this.value == Long.MAX_VALUE) {
                long asLong = longSupplier.getAsLong();
                this.value = asLong;
                return asLong;
            }
            return this.value;
        }
    }

    private static LongSupplier glGetter(LongSupplier delegate) {
        return new LongSupplier() { // from class: foundry.veil.api.client.render.VeilRenderSystem.3
            private long value = Long.MAX_VALUE;
            final /* synthetic */ LongSupplier val$delegate;

            C13203(LongSupplier delegate2) {
                longSupplier = delegate2;
            }

            @Override // java.util.function.LongSupplier
            public long getAsLong() {
                RenderSystem.assertOnRenderThreadOrInit();
                if (this.value == Long.MAX_VALUE) {
                    long asLong = longSupplier.getAsLong();
                    this.value = asLong;
                    return asLong;
                }
                return this.value;
            }
        };
    }

    /* JADX INFO: renamed from: foundry.veil.api.client.render.VeilRenderSystem$4 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/VeilRenderSystem$4.class */
    class C13214<T> implements Supplier<T> {
        private T value = null;
        final /* synthetic */ Supplier val$delegate;

        C13214(Supplier supplier) {
            supplier = supplier;
        }

        @Override // java.util.function.Supplier
        public T get() {
            RenderSystem.assertOnRenderThreadOrInit();
            if (this.value == null) {
                T t = (T) supplier.get();
                this.value = t;
                return t;
            }
            return this.value;
        }
    }

    private static <T> Supplier<T> glGetter(Supplier<T> delegate) {
        return new Supplier<T>() { // from class: foundry.veil.api.client.render.VeilRenderSystem.4
            private T value = null;
            final /* synthetic */ Supplier val$delegate;

            C13214(Supplier delegate2) {
                supplier = delegate2;
            }

            @Override // java.util.function.Supplier
            public T get() {
                RenderSystem.assertOnRenderThreadOrInit();
                if (this.value == null) {
                    T t = (T) supplier.get();
                    this.value = t;
                    return t;
                }
                return this.value;
            }
        };
    }

    public static void bindTextures(int first, IntBuffer targets, IntBuffer textures) {
        VeilMultiBind.get().bindTextures(first, targets, textures);
    }

    public static void bindTextures(int first, int[] targets, int[] textures) {
        VeilMultiBind.get().bindTextures(first, targets, textures);
    }

    public static void bindSamplers(int first, IntBuffer textures) {
        VeilMultiBind.get().bindSamplers(first, textures);
    }

    public static void bindSamplers(int first, int... textures) {
        VeilMultiBind.get().bindSamplers(first, textures);
    }

    public static void unbindSamplers(int first, int count) {
        VeilMultiBind.get().bindSamplers(first, emptySamplers.limit(count));
    }

    public static <T extends AbstractTexture & VeilPreloadedTexture> CompletableFuture<?> registerPreloadedTexture(ResourceLocation path, T texture) {
        return registerPreloadedTexture(path, texture, Util.backgroundExecutor());
    }

    public static <T extends AbstractTexture & VeilPreloadedTexture> CompletableFuture<?> registerPreloadedTexture(ResourceLocation path, T texture, Executor executor) {
        return Minecraft.getInstance().getTextureManager().veil$registerPreloadedTexture(path, texture, executor);
    }

    public static void drawScreenQuad() {
        GlStateManager._glBindVertexArray(screenQuadVao);
        GL43C.glDrawArrays(5, 0, 3);
        VertexBuffer.unbind();
    }

    @Nullable
    public static ShaderProgram setShader(ResourceLocation shader) {
        ShaderManager shaderManager = renderer.getShaderManager();
        shaderLocation = shader;
        return setShader((Supplier<ShaderProgram>) () -> {
            return shaderManager.getShader(shader);
        });
    }

    @Nullable
    public static ShaderProgram setShader(@Nullable ShaderProgram shader) {
        shaderLocation = shader != null ? shader.getName() : null;
        return setShader((Supplier<ShaderProgram>) () -> {
            return shader;
        });
    }

    @Nullable
    public static ShaderProgram setShader(Supplier<ShaderProgram> shader) {
        RenderSystem.setShader(() -> {
            ShaderProgram program = (ShaderProgram) shader.get();
            if (program != null) {
                return VeilRenderBridge.toShaderInstance(program);
            }
            return null;
        });
        ShaderProgram value = getShader();
        if (value == null && shaderLocation != null && ERRORED_SHADERS.add(shaderLocation)) {
            Veil.LOGGER.error("Failed to apply shader: {}", shaderLocation);
        }
        return value;
    }

    public static void drawInstanced(VertexBuffer vbo, int instances) {
        ((VertexBufferExtension) vbo).veil$drawInstanced(instances);
    }

    public static void drawIndirect(VertexBuffer vbo, long indirect, int drawCount, int stride) {
        ((VertexBufferExtension) vbo).veil$drawIndirect(indirect, drawCount, stride);
    }

    public static void endLastBatch(MultiBufferSource.BufferSource source, String name) {
        if (source instanceof PipelineBufferSourceAccessor) {
            PipelineBufferSourceAccessor accessor = (PipelineBufferSourceAccessor) source;
            RenderType renderType = accessor.getLastSharedType();
            if (renderType != null && VeilRenderType.getName(renderType).equals(name)) {
                source.endLastBatch();
            }
        }
    }

    public static void endLastBatch(MultiBufferSource.BufferSource source, RenderType renderType) {
        if (source instanceof PipelineBufferSourceAccessor) {
            PipelineBufferSourceAccessor accessor = (PipelineBufferSourceAccessor) source;
            RenderType lastSharedType = accessor.getLastSharedType();
            if (lastSharedType != null && lastSharedType.equals(renderType)) {
                source.endLastBatch();
            }
        }
    }

    public static void rebuildChunks() {
        Minecraft.getInstance().levelRenderer.veil$markChunksDirty();
    }

    public static void printGlErrors(@Nullable String glCall) {
        while (true) {
            int error = GlStateManager._getError();
            if (error != 0) {
                if (glCall != null) {
                    Veil.LOGGER.error("[OpenGL Error] '{}' 0x{}", glCall, Integer.toHexString(error).toUpperCase(Locale.ROOT));
                } else {
                    Veil.LOGGER.error("[OpenGL Error] 0x{}", Integer.toHexString(error).toUpperCase(Locale.ROOT));
                }
            } else {
                return;
            }
        }
    }

    public static int getIndexCount(VertexBuffer vbo) {
        return ((VertexBufferExtension) vbo).veil$getIndexCount();
    }

    public static boolean tessellationSupported() {
        return TESSELLATION_SUPPORTED.getAsBoolean();
    }

    public static boolean computeSupported() {
        return COMPUTE_SUPPORTED.getAsBoolean();
    }

    public static boolean atomicCounterSupported() {
        return ATOMIC_COUNTER_SUPPORTED.getAsBoolean();
    }

    public static boolean transformFeedbackSupported() {
        return TRANSFORM_FEEDBACK_SUPPORTED.getAsBoolean();
    }

    public static boolean multibindSupported() {
        return MULTIBIND_SUPPORTED.getAsBoolean();
    }

    public static boolean sparseBuffersSupported() {
        return SPARSE_BUFFERS_SUPPORTED.getAsBoolean();
    }

    public static boolean directStateAccessSupported() {
        return DIRECT_STATE_ACCESS_SUPPORTED.getAsBoolean();
    }

    public static boolean separateShaderObjectsSupported() {
        return SEPARATE_SHADER_OBJECTS_SUPPORTED.getAsBoolean();
    }

    public static boolean clearTextureSupported() {
        return CLEAR_TEXTURE_SUPPORTED.getAsBoolean();
    }

    public static boolean copyImageSupported() {
        return COPY_IMAGE_SUPPORTED.getAsBoolean();
    }

    public static boolean shaderStorageBufferSupported() {
        return SHADER_STORAGE_BLOCK_SUPPORTED.getAsBoolean();
    }

    public static boolean programInterfaceQuerySupported() {
        return PROGRAM_INTERFACE_QUERY_SUPPORTED.getAsBoolean();
    }

    public static boolean textureAnisotropySupported() {
        return TEXTURE_ANISOTROPY_SUPPORTED.getAsBoolean();
    }

    public static boolean textureMirrorClampToEdgeSupported() {
        return TEXTURE_MIRROR_CLAMP_TO_EDGE_SUPPORTED.getAsBoolean();
    }

    public static boolean textureCubeMapSeamlessSupported() {
        return TEXTURE_CUBE_MAP_SEAMLESS_SUPPORTED.getAsBoolean();
    }

    public static boolean textureCubeMapArraySupported() {
        return TEXTURE_CUBE_MAP_ARRAY_SUPPORTED.getAsBoolean();
    }

    public static boolean nvDrawTextureSupported() {
        return NV_DRAW_TEXTURE_SUPPORTED.getAsBoolean();
    }

    public static boolean drawIndirectSupported() {
        return DRAW_INDIRECT_SUPPORTED.getAsBoolean();
    }

    public static boolean multiDrawIndirectSupported() {
        return MULTI_DRAW_INDIRECT_SUPPORTED.getAsBoolean();
    }

    public static boolean gpuShaderFloat64BitSupported() {
        return GPU_SHADER_FLOAT_64BIT_SUPPORTED.getAsBoolean();
    }

    public static boolean gpuShaderInt64BitSupported() {
        return GPU_SHADER_INT_64BIT_SUPPORTED.getAsBoolean();
    }

    public static boolean vertexAttribute64BitSupported() {
        return VERTEX_ATTRIB_64BIT_SUPPORTED.getAsBoolean();
    }

    public static boolean bindlessTextureSupported() {
        return BINDLESS_TEXTURE_SUPPORTED.getAsBoolean();
    }

    public static boolean vertexType10F11F11FRevSupported() {
        return VERTEX_TYPE_10F_11F_11F_REV_SUPPORTED.getAsBoolean();
    }

    public static boolean pipelineStatisticsQuerySupported() {
        return PIPELINE_STATISTICS_QUERY_SUPPORTED.getAsBoolean();
    }

    public static int maxCombinedTextureUnits() {
        return MAX_COMBINED_TEXTURE_IMAGE_UNITS.getAsInt();
    }

    public static int maxColorAttachments() {
        return MAX_COLOR_ATTACHMENTS.getAsInt();
    }

    public static int maxSamples() {
        return MAX_SAMPLES.getAsInt();
    }

    public static int maxTargetBindings(int target) {
        switch (target) {
            case 35345:
                return maxUniformBuffersBindings();
            case 35982:
                return maxTransformFeedbackBindings();
            case 37074:
                return maxShaderStorageBufferBindings();
            case 37568:
                return maxAtomicCounterBufferBindings();
            default:
                throw new IllegalArgumentException("Invalid Target: 0x" + Integer.toHexString(target).toUpperCase(Locale.ROOT));
        }
    }

    public static VeilShaderLimits shaderLimits(int shader) {
        switch (shader) {
            case 35632:
                return GL_FRAGMENT_SHADER_LIMITS.get();
            case 35633:
                return VERTEX_SHADER_LIMITS.get();
            case 36313:
                return GL_GEOMETRY_SHADER_LIMITS.get();
            case 36487:
                return GL_TESS_EVALUATION_SHADER_LIMITS.get();
            case 36488:
                return GL_TESS_CONTROL_SHADER_LIMITS.get();
            case 37305:
                return GL_COMPUTE_SHADER_LIMITS.get();
            default:
                throw new IllegalArgumentException("Invalid Shader Type: 0x" + Integer.toHexString(shader).toUpperCase(Locale.ROOT));
        }
    }

    public static int maxTransformFeedbackBindings() {
        return MAX_TRANSFORM_FEEDBACK_BUFFERS.getAsInt();
    }

    public static int maxUniformBuffersBindings() {
        return MAX_UNIFORM_BUFFER_BINDINGS.getAsInt();
    }

    public static int maxAtomicCounterBufferBindings() {
        return MAX_ATOMIC_COUNTER_BUFFER_BINDINGS.getAsInt();
    }

    public static int maxShaderStorageBufferBindings() {
        return MAX_SHADER_STORAGE_BUFFER_BINDINGS.getAsInt();
    }

    public static int maxArrayTextureLayers() {
        return MAX_ARRAY_TEXTURE_LAYERS.getAsInt();
    }

    public static float maxTextureAnisotropy() {
        return MAX_TEXTURE_ANISOTROPY.get().floatValue();
    }

    public static int maxVertexAttributes() {
        return MAX_VERTEX_ATTRIBS.getAsInt();
    }

    public static int maxVertexAttributeRelativeOffset() {
        return MAX_VERTEX_ATTRIB_RELATIVE_OFFSET.getAsInt();
    }

    public static int maxFramebufferWidth() {
        return MAX_FRAMEBUFFER_SIZE.get().x();
    }

    public static int maxFramebufferHeight() {
        return MAX_FRAMEBUFFER_SIZE.get().y();
    }

    public static int maxComputeWorkGroupCountX() {
        return MAX_COMPUTE_WORK_GROUP_COUNT.get().y();
    }

    public static int maxComputeWorkGroupCountY() {
        return MAX_COMPUTE_WORK_GROUP_COUNT.get().y();
    }

    public static int maxComputeWorkGroupCountZ() {
        return MAX_COMPUTE_WORK_GROUP_COUNT.get().y();
    }

    public static int maxComputeWorkGroupSizeX() {
        return MAX_COMPUTE_WORK_GROUP_SIZE.get().y();
    }

    public static int maxComputeWorkGroupSizeY() {
        return MAX_COMPUTE_WORK_GROUP_SIZE.get().y();
    }

    public static int maxComputeWorkGroupSizeZ() {
        return MAX_COMPUTE_WORK_GROUP_SIZE.get().y();
    }

    public static int maxComputeWorkGroupInvocations() {
        return MAX_COMPUTE_WORK_GROUP_INVOCATIONS.getAsInt();
    }

    public static long maxUniformBufferSize() {
        return MAX_UNIFORM_BLOCK_SIZE.getAsLong();
    }

    public static int uniformBufferAlignment() {
        return UNIFORM_BUFFER_OFFSET_ALIGNMENT.getAsInt();
    }

    public static long maxShaderStorageBufferSize() {
        return MAX_SHADER_STORAGE_BLOCK_SIZE.getAsLong();
    }

    public static void bind(CharSequence name, ShaderBlock<?> block) {
        RenderSystem.assertOnRenderThreadOrInit();
        UNIFORM_BLOCK_STATE.bind(name, block);
    }

    public static void bind(VeilShaderBufferLayout<?> layout) throws IllegalArgumentException {
        RenderSystem.assertOnRenderThreadOrInit();
        SHADER_BUFFER_CACHE.bind(layout);
    }

    public static void unbind(ShaderBlock<?> block) {
        RenderSystem.assertOnRenderThreadOrInit();
        UNIFORM_BLOCK_STATE.unbind(block);
    }

    public static void unbind(VeilShaderBufferLayout<?> layout) throws IllegalArgumentException {
        RenderSystem.assertOnRenderThreadOrInit();
        SHADER_BUFFER_CACHE.unbind(layout);
    }

    @Nullable
    public static <T> ShaderBlock<T> getBlock(VeilShaderBufferLayout<T> layout) throws IllegalArgumentException {
        RenderSystem.assertOnRenderThreadOrInit();
        return SHADER_BUFFER_CACHE.getBlock(layout);
    }

    public static void bindVertexArray(int vao) {
        BufferUploader.invalidate();
        GlStateManager._glBindVertexArray(vao);
    }

    public static int getBoundTexture(int target) {
        switch (target) {
            case 3552:
                return GL11C.glGetInteger(32872);
            case 3553:
                return GL11C.glGetInteger(32873);
            case 32879:
                return GL11C.glGetInteger(32874);
            case 34037:
                return GL11C.glGetInteger(34038);
            case 34067:
                return GL11C.glGetInteger(34068);
            case 35864:
                return GL11C.glGetInteger(35868);
            case 35866:
                return GL11C.glGetInteger(35869);
            case 35882:
                return GL11C.glGetInteger(35884);
            case 36873:
                return GL11C.glGetInteger(36874);
            case 37120:
                return GL11C.glGetInteger(37124);
            case 37122:
                return GL11C.glGetInteger(37125);
            default:
                throw new IllegalStateException("Not a texture target: " + target);
        }
    }

    public static int createTextures(int target) {
        if (directStateAccessSupported()) {
            return ARBDirectStateAccess.glCreateTextures(target);
        }
        return GL43C.glGenTextures();
    }

    public static void createTextures(int target, int[] textures) {
        if (directStateAccessSupported()) {
            ARBDirectStateAccess.glCreateTextures(target, textures);
        } else {
            GL43C.glGenTextures(textures);
        }
    }

    public static void createTextures(int target, IntBuffer textures) {
        if (directStateAccessSupported()) {
            ARBDirectStateAccess.glCreateTextures(target, textures);
        } else {
            GL43C.glGenTextures(textures);
        }
    }

    public static VeilRenderer renderer() {
        return renderer;
    }

    public static GpuVendor gpuVendor() {
        if (gpuVendor == null) {
            gpuVendor = detectVendor();
        }
        return gpuVendor;
    }

    public static Executor renderThreadExecutor() {
        return RENDER_THREAD_EXECUTOR;
    }

    @Nullable
    public static ShaderProgram getShader() {
        ShaderInstance shader = RenderSystem.getShader();
        if (!(shader instanceof ShaderProgramImpl.Wrapper)) {
            return null;
        }
        ShaderProgramImpl.Wrapper wrapper = (ShaderProgramImpl.Wrapper) shader;
        return wrapper.program();
    }

    public static Vector3fc getLight0Direction() {
        return LIGHT0_DIRECTION;
    }

    public static Vector3fc getLight1Direction() {
        return LIGHT1_DIRECTION;
    }

    public static Vector3fc getCameraBobOffset() {
        return CAMERA_BOB_OFFSET;
    }

    public static boolean hasImGui() {
        return Veil.IMGUIMC && ImGuiMC.isImguiLoaded();
    }

    public static CullFrustum getCullingFrustum() {
        return Minecraft.getInstance().levelRenderer.veil$getCullFrustum();
    }

    public static NecromancerRenderer getNecromancerRenderer() {
        return NecromancerRenderDispatcher.getRenderer();
    }

    @ApiStatus.Internal
    public static void bootstrap() {
        VeilEventPlatform.INSTANCE.onVeilShaderCompile((shaderManager, updatedPrograms) -> {
            UNIFORM_BLOCK_STATE.onShaderCompile();
            SHADER_BUFFER_CACHE.onShaderCompile(updatedPrograms);
            ERRORED_SHADERS.clear();
        });
        VeilEventPlatform.INSTANCE.onVeilRenderLevelStage((stage, levelRenderer, bufferSource, matrixStack, frustumMatrix, projectionMatrix, renderTick, deltaTracker, camera, frustum) -> {
            if (stage == VeilRenderLevelStageEvent.Stage.AFTER_CUTOUT_BLOCKS) {
                NecromancerRenderDispatcher.begin();
            } else if (stage == VeilRenderLevelStageEvent.Stage.AFTER_ENTITIES) {
                NecromancerRenderDispatcher.end();
            }
        });
        VeilEventPlatform.INSTANCE.onVeilDynamicBuffersChanged(change -> {
            if (SodiumCompat.INSTANCE != null) {
                SodiumCompat.INSTANCE.setActiveBuffers(change.enabledBuffersMask());
            }
            if (change.hasChanged(DynamicBufferType.NORMAL)) {
                rebuildChunks();
            }
            UNIFORM_BLOCK_STATE.onShaderCompile();
        });
        VeilEventPlatform.INSTANCE.onVeilRegisterGlobalControllers(registry -> {
            registry.registerGlobalController(RandomnessController.INSTANCE);
        });
    }

    @ApiStatus.Internal
    public static void init() {
        Minecraft client = Minecraft.getInstance();
        ReloadableResourceManager resourceManager = client.getResourceManager();
        if (!(resourceManager instanceof ReloadableResourceManager)) {
            throw new IllegalStateException("Client resource manager is " + String.valueOf(client.getResourceManager().getClass()));
        }
        ReloadableResourceManager resourceManager2 = resourceManager;
        Window window = client.getWindow();
        renderer = new VeilRenderer(resourceManager2, window);
        screenQuadVao = directStateAccessSupported() ? ARBDirectStateAccess.glCreateVertexArrays() : GL43C.glGenVertexArrays();
        VeilDebug.get().objectLabel(32884, screenQuadVao, "Screen Quad Vertex Array");
        emptySamplers = MemoryUtil.memCallocInt(maxCombinedTextureUnits());
    }

    @ApiStatus.Internal
    public static void beginFrame() {
        SHADER_BUFFER_CACHE.bind();
    }

    @ApiStatus.Internal
    public static void endFrame() {
        AdvancedFboImGuiAreaImpl.end();
        if (Veil.platform().hasErrors()) {
            return;
        }
        renderer.endFrame();
        if (!FramebufferStack.isEmpty()) {
            Veil.LOGGER.error("Did not pop all bound framebuffers");
            FramebufferStack.clear();
            AdvancedFbo.unbind();
        }
        VeilRenderProfilerImpl.endFrame();
        UNIFORM_BLOCK_STATE.clearUsedBindings();
        VanillaShaderCompiler.clear();
        VeilDebug.MESSAGE_ID.set(0);
    }

    @ApiStatus.Internal
    public static void clearShaderBlocks() {
        SHADER_BUFFER_CACHE.unbindPacked();
    }

    @ApiStatus.Internal
    public static void shaderUpdate() {
        shaderLocation = null;
    }

    @ApiStatus.Internal
    public static void resize(int width, int height) {
        if (renderer != null) {
            renderer.resize(width, height);
        }
    }

    @ApiStatus.Internal
    public static void close() {
        if (renderer != null) {
            renderer.free();
        }
        VoxelShadowGrid.close();
        GL43C.glDeleteVertexArrays(screenQuadVao);
        MemoryUtil.memFree(emptySamplers);
        SHADER_BUFFER_CACHE.free();
    }

    @ApiStatus.Internal
    public static void renderPost(@Nullable VeilRenderLevelStageEvent.Stage stage) {
        if (VeilBloomRenderer.hasRendered() && (stage == VeilRenderLevelStageEvent.Stage.AFTER_BLOCK_ENTITIES || stage == VeilRenderLevelStageEvent.Stage.AFTER_LEVEL)) {
            VeilDebug debug = VeilDebug.get();
            debug.pushDebugGroup("Veil Draw Bloom (" + String.valueOf(stage) + ")");
            VeilBloomRenderer.flush();
            debug.popDebugGroup();
        }
        renderer.getPostProcessingManager().runDefaultPipeline(stage);
    }

    @ApiStatus.Internal
    public static void setShaderLights(Vector3fc light0, Vector3fc light1) {
        LIGHT0_DIRECTION.set(light0);
        LIGHT1_DIRECTION.set(light1);
    }

    @ApiStatus.Internal
    public static void setCameraBobOffset(Vector3fc offset) {
        CAMERA_BOB_OFFSET.set(offset);
    }

    @ApiStatus.Internal
    public static boolean drawLights(ProfilerFiller profiler, CullFrustum cullFrustum) {
        FramebufferManager framebufferManager = renderer.getFramebufferManager();
        AdvancedFbo lightFbo = framebufferManager.getFramebuffer(VeilFramebuffers.LIGHT);
        if (lightFbo == null) {
            AdvancedFbo.unbind();
            return false;
        }
        VeilDebug debug = VeilDebug.get();
        debug.pushDebugGroup("Veil Draw Lights");
        VeilRenderProfiler renderProfiler = VeilRenderProfiler.get();
        renderProfiler.push("veil_lights", RenderProfilerCounter.VERTICES_SUBMITTED, RenderProfilerCounter.PRIMITIVES_SUBMITTED, RenderProfilerCounter.VERTEX_SHADER_INVOCATIONS, RenderProfilerCounter.FRAGMENT_SHADER_INVOCATIONS, RenderProfilerCounter.COMPUTE_SHADER_INVOCATIONS, RenderProfilerCounter.CLIPPING_INPUT_PRIMITIVES, RenderProfilerCounter.CLIPPING_OUTPUT_PRIMITIVES);
        LightRenderer lightRenderer = renderer.getLightRenderer();
        profiler.push("draw_lights");
        boolean rendered = lightRenderer.render(cullFrustum, lightFbo);
        profiler.pop();
        renderProfiler.pop();
        debug.popDebugGroup();
        return rendered;
    }

    @ApiStatus.Internal
    public static void compositeLights(ProfilerFiller profiler) {
        VeilDebug debug = VeilDebug.get();
        debug.pushDebugGroup("Veil Composite Lights");
        PostProcessingManager postProcessingManager = renderer.getPostProcessingManager();
        PostPipeline compositePipeline = postProcessingManager.getPipeline(VeilRenderer.COMPOSITE);
        if (compositePipeline != null) {
            profiler.push("composite_lights");
            postProcessingManager.runPipeline(compositePipeline);
            profiler.pop();
        }
        debug.popDebugGroup();
    }

    @ApiStatus.Internal
    public static void clearLevel() {
        NecromancerRenderDispatcher.delete();
        VoxelShadowGrid.clearLevel();
    }

    private static GpuVendor detectVendor() {
        String vendor = ((String) Objects.requireNonNull(GL43C.glGetString(7936))).toLowerCase(Locale.ROOT);
        if (vendor.contains("intel")) {
            return GpuVendor.INTEL;
        }
        if (vendor.contains("nvidia")) {
            return GpuVendor.NVIDIA;
        }
        if (vendor.contains("amd") || vendor.contains("ati")) {
            return GpuVendor.AMD;
        }
        if (vendor.contains("apple")) {
            return GpuVendor.APPLE;
        }
        return GpuVendor.OTHER;
    }
}
