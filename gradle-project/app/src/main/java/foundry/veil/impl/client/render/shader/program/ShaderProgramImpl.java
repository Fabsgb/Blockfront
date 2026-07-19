package foundry.veil.impl.client.render.shader.program;

import com.google.common.base.Suppliers;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.shaders.Program;
import com.mojang.blaze3d.shaders.Shader;
import com.mojang.blaze3d.shaders.Uniform;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.ext.VeilDebug;
import foundry.veil.api.client.render.shader.ShaderFeature;
import foundry.veil.api.client.render.shader.ShaderSourceSet;
import foundry.veil.api.client.render.shader.block.ShaderBlock;
import foundry.veil.api.client.render.shader.compiler.CompiledShader;
import foundry.veil.api.client.render.shader.compiler.ShaderCompiler;
import foundry.veil.api.client.render.shader.compiler.ShaderException;
import foundry.veil.api.client.render.shader.compiler.VeilShaderSource;
import foundry.veil.api.client.render.shader.program.ProgramDefinition;
import foundry.veil.api.client.render.shader.program.ShaderBlendMode;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.api.client.render.shader.program.ShaderUniformCache;
import foundry.veil.api.client.render.shader.texture.ShaderTextureSource;
import foundry.veil.api.client.render.shader.uniform.ShaderUniform;
import foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess;
import foundry.veil.api.client.render.texture.SamplerObject;
import foundry.veil.api.client.render.texture.TextureFilter;
import foundry.veil.api.client.util.VertexFormatCodec;
import foundry.veil.ext.AbstractTextureExtension;
import foundry.veil.impl.client.render.shader.uniform.ShaderUniformImpl;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.lang.runtime.SwitchBootstraps;
import java.nio.IntBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.repository.KnownPack;
import net.minecraft.server.packs.resources.Resource;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix2f;
import org.joml.Matrix2fc;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Matrix4x3f;
import org.joml.Matrix4x3fc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4f;
import org.joml.Vector4fc;
import org.lwjgl.opengl.GL20C;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/program/ShaderProgramImpl.class */
@ApiStatus.Internal
public class ShaderProgramImpl implements ShaderProgram {
    public static final VeilShaderSource DUMMY_FRAGMENT_SHADER = new VeilShaderSource(null, "out vec4 fragColor;void main(){fragColor=vec4(1.0);}");
    private static final Matrix4f MODEL_VIEW_MATRIX = new Matrix4f();
    private static final Matrix4f PROJECTION_MATRIX = new Matrix4f();
    private static boolean restoreEquation = false;
    private static int srcColorFactor = -1;
    private static int dstColorFactor = -1;
    private static int srcAlphaFactor = -1;
    private static int dstAlphaFactor = -1;
    private final ResourceLocation name;
    private final ShaderTextureCache textures = new ShaderTextureCache(this);
    private final Int2ObjectMap<CompiledProgram> programs = new Int2ObjectArrayMap(1);
    private final Object2ObjectMap<String, ShaderTexture> definitionSamplers = new Object2ObjectArrayMap();
    private final ObjectSet<ShaderFeature> requiredFeatures = new ObjectArraySet();
    private final Object2ObjectMap<CharSequence, ShaderBlock<?>> shaderBlocks = new Object2ObjectArrayMap();
    private final Object2ObjectMap<String, ShaderUniformImpl> uniforms = new Object2ObjectArrayMap();
    private final Supplier<Wrapper> wrapper;
    private VertexFormat vertexFormat;
    private ProgramDefinition definition;
    private CompiledProgram compiledProgram;
    private boolean validated;

    public ShaderProgramImpl(ResourceLocation name) {
        this.name = name;
        this.wrapper = Suppliers.memoize(() -> {
            Wrapper.constructingProgram = this;
            try {
                try {
                    Wrapper wrapper = new Wrapper(this);
                    Wrapper.constructingProgram = null;
                    return wrapper;
                } catch (Exception e) {
                    throw new IllegalStateException("Failed to wrap shader program: " + String.valueOf(name), e);
                }
            } catch (Throwable th) {
                Wrapper.constructingProgram = null;
                throw th;
            }
        });
    }

    public static void saveBlendState(boolean saveEquation) {
        restoreEquation = saveEquation;
        srcColorFactor = GlStateManager.BLEND.srcRgb;
        dstColorFactor = GlStateManager.BLEND.dstRgb;
        srcAlphaFactor = GlStateManager.BLEND.srcAlpha;
        dstAlphaFactor = GlStateManager.BLEND.dstAlpha;
    }

    public static void restoreBlendState() {
        if (srcColorFactor == -1) {
            return;
        }
        if (restoreEquation) {
            GL20C.glBlendEquationSeparate(32774, 32774);
        }
        GlStateManager._blendFuncSeparate(srcColorFactor, dstColorFactor, srcAlphaFactor, dstAlphaFactor);
        srcColorFactor = -1;
        dstColorFactor = -1;
        srcAlphaFactor = -1;
        dstAlphaFactor = -1;
        restoreEquation = false;
    }

    protected void applyProgram(CompiledProgram program) {
        this.textures.clear();
        this.compiledProgram = program;
        this.vertexFormat = program.detectVertexFormat();
        this.validated = !Veil.platform().isDevelopmentEnvironment();
        Map<String, ShaderUniformImpl> old = new Object2ObjectArrayMap<>(this.uniforms);
        this.uniforms.clear();
        for (Map.Entry<String, ShaderUniformCache.Uniform> entry : this.compiledProgram.uniformCache.getUniforms().entrySet()) {
            ShaderUniformCache.Uniform data = entry.getValue();
            if (data.type() != 37595) {
                String name = entry.getKey();
                ShaderUniformImpl uniform = old.remove(name);
                if (uniform == null) {
                    uniform = new ShaderUniformImpl(this::getProgram, name);
                }
                uniform.set(data);
                this.uniforms.put(name, uniform);
            }
        }
        Iterator<ShaderUniformImpl> it = old.values().iterator();
        while (it.hasNext()) {
            it.next().free();
        }
        program.setup(this);
    }

    protected void attachShaders(CompiledProgram compiledProgram, ShaderSourceSet sourceSet, ShaderCompiler compiler) throws ShaderException, IOException {
        Int2ObjectMap<ResourceLocation> shaders = this.definition.shaders();
        ObjectIterator it = shaders.int2ObjectEntrySet().iterator();
        while (it.hasNext()) {
            Int2ObjectMap.Entry<ResourceLocation> entry = (Int2ObjectMap.Entry) it.next();
            int glType = entry.getIntKey();
            ResourceLocation source = (ResourceLocation) entry.getValue();
            compiledProgram.attachShader(glType, compiler.compile(glType, sourceSet.getTypeConverter(glType).idToFile(source)));
        }
        if (!shaders.containsKey(37305) && !shaders.containsKey(35632)) {
            compiledProgram.attachShader(35632, compiler.compile(35632, DUMMY_FRAGMENT_SHADER));
        }
    }

    public void compile(int activeBuffers, ShaderSourceSet sourceSet, @Nullable ProgramDefinition definition, ShaderCompiler compiler) throws ShaderException, IOException {
        ProgramDefinition old = this.definition;
        this.definition = definition;
        try {
            recompile(activeBuffers, sourceSet, compiler);
            this.definitionSamplers.values().forEach((v0) -> {
                v0.free();
            });
            this.definitionSamplers.clear();
            this.requiredFeatures.clear();
            if (this.definition != null) {
                for (Map.Entry<String, ShaderTextureSource> entry : this.definition.samplers().entrySet()) {
                    this.definitionSamplers.put(entry.getKey(), ShaderTexture.create(entry.getValue()));
                }
                this.requiredFeatures.addAll(Arrays.asList(this.definition.requiredFeatures()));
            }
        } catch (Throwable t) {
            if (old != null) {
                this.definition = old;
            }
            throw t;
        }
    }

    public void recompile(int activeBuffers, ShaderSourceSet sourceSet, ShaderCompiler compiler) throws Exception {
        CompiledProgram compiledProgram = CompiledProgram.create(this.name, activeBuffers);
        try {
            attachShaders(compiledProgram, sourceSet, compiler);
            CompiledProgram old = (CompiledProgram) this.programs.put(activeBuffers, compiledProgram);
            if (old != null) {
                old.free();
            }
            compiledProgram.link();
            applyProgram(compiledProgram);
        } catch (Exception e) {
            if (this.compiledProgram == null) {
                freeInternal();
            } else {
                compiledProgram.free();
            }
            throw e;
        }
    }

    public boolean setActiveBuffers(int activeBuffers) {
        CompiledProgram compiledProgram = (CompiledProgram) this.programs.get(activeBuffers);
        if (compiledProgram != null) {
            if (this.compiledProgram != compiledProgram) {
                applyProgram(compiledProgram);
                return false;
            }
            return false;
        }
        return true;
    }

    @Override // foundry.veil.api.client.render.shader.program.ShaderProgram
    public void bind() {
        VeilRenderSystem.clearShaderBlocks();
        ObjectIterator it = this.shaderBlocks.object2ObjectEntrySet().iterator();
        while (it.hasNext()) {
            Object2ObjectMap.Entry<CharSequence, ShaderBlock<?>> entry = (Object2ObjectMap.Entry) it.next();
            VeilRenderSystem.bind((CharSequence) entry.getKey(), (ShaderBlock) entry.getValue());
        }
        ShaderBlendMode blendMode = this.definition != null ? this.definition.blendMode() : null;
        if (blendMode != null) {
            saveBlendState(blendMode.hasEquation());
            blendMode.apply();
        }
        super.bind();
        if (this.compiledProgram != null && !this.validated) {
            this.compiledProgram.validate(this);
            this.validated = true;
        }
    }

    @Override // foundry.veil.api.client.render.shader.program.ShaderProgram
    public void setDefaultUniforms(VertexFormat.Mode mode, Matrix4fc modelViewMatrix, Matrix4fc projectionMatrix) {
        this.wrapper.get().setDefaultUniforms(mode, MODEL_VIEW_MATRIX.set(modelViewMatrix), PROJECTION_MATRIX.set(projectionMatrix), Minecraft.getInstance().getWindow());
    }

    public void freeInternal() {
        this.textures.clear();
        ObjectIterator it = this.programs.values().iterator();
        while (it.hasNext()) {
            CompiledProgram program = (CompiledProgram) it.next();
            program.free();
        }
        this.uniforms.values().forEach((v0) -> {
            v0.free();
        });
        this.uniforms.clear();
        this.definitionSamplers.values().forEach((v0) -> {
            v0.free();
        });
        this.definitionSamplers.clear();
        this.vertexFormat = null;
        this.compiledProgram = null;
    }

    public void free() {
        freeInternal();
    }

    @Override // foundry.veil.api.client.render.shader.program.ShaderProgram
    public Int2ObjectMap<CompiledShader> getShaders() {
        return this.compiledProgram != null ? this.compiledProgram.shaders : Int2ObjectMaps.emptyMap();
    }

    @Override // foundry.veil.api.client.render.shader.program.ShaderProgram
    public boolean isValid() {
        return this.compiledProgram != null;
    }

    @Override // foundry.veil.api.client.render.shader.program.ShaderProgram
    public Set<ShaderFeature> getRequiredFeatures() {
        return this.requiredFeatures;
    }

    @Override // foundry.veil.api.client.render.shader.program.ShaderProgram
    @Nullable
    public VertexFormat getFormat() {
        return this.vertexFormat;
    }

    @Override // foundry.veil.api.client.render.shader.program.ShaderProgram
    public Set<String> getDefinitionDependencies() {
        return this.compiledProgram != null ? this.compiledProgram.definitionDependencies : Collections.emptySet();
    }

    @Override // foundry.veil.api.client.render.shader.program.ShaderProgram
    public ResourceLocation getName() {
        return this.name;
    }

    @Override // foundry.veil.api.client.render.shader.program.ShaderProgram
    public Wrapper toShaderInstance() {
        return this.wrapper.get();
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    public int getUniformLocation(CharSequence name) {
        ShaderUniformCache.Uniform uniform;
        if (this.compiledProgram == null || (uniform = this.compiledProgram.uniformCache.getUniform(name)) == null) {
            return -1;
        }
        return uniform.location();
    }

    @Override // foundry.veil.api.client.render.shader.program.ShaderProgram, foundry.veil.api.client.render.shader.program.UniformAccess
    @Nullable
    public ShaderUniformImpl getUniform(CharSequence name) {
        ShaderUniformImpl uniform = (ShaderUniformImpl) this.uniforms.get(name.toString());
        if (uniform == null || !uniform.isValid()) {
            return null;
        }
        return uniform;
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    public ShaderUniformAccess getUniformSafe(CharSequence name) {
        ShaderUniformImpl uniform = (ShaderUniformImpl) this.uniforms.get(name.toString());
        return (uniform == null || !uniform.isValid()) ? ShaderUniformAccess.EMPTY : uniform;
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    public boolean hasUniform(CharSequence name) {
        return this.compiledProgram != null && this.compiledProgram.uniformCache.hasUniform(name.toString());
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    public int getUniformBlock(CharSequence name) {
        ShaderUniformCache.UniformBlock block;
        if (this.compiledProgram == null || (block = this.compiledProgram.uniformCache.getUniformBlock(name.toString())) == null) {
            return -1;
        }
        return block.index();
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    public boolean hasUniformBlock(CharSequence name) {
        return this.compiledProgram != null && this.compiledProgram.uniformCache.hasUniformBlock(name.toString());
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    public int getStorageBlock(CharSequence name) {
        ShaderUniformCache.StorageBlock block;
        if (this.compiledProgram == null || (block = this.compiledProgram.uniformCache.getStorageBlock(name.toString())) == null) {
            return -1;
        }
        return block.index();
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    public boolean hasStorageBlock(CharSequence name) {
        return this.compiledProgram != null && this.compiledProgram.uniformCache.hasStorageBlock(name.toString());
    }

    @Override // foundry.veil.api.client.render.shader.program.ShaderProgram
    public int getProgram() {
        if (this.compiledProgram != null) {
            return this.compiledProgram.program;
        }
        return 0;
    }

    @Override // foundry.veil.api.client.render.shader.program.ShaderProgram
    public int getActiveDynamicBuffers() {
        if (this.compiledProgram != null) {
            return this.compiledProgram.activeBuffers;
        }
        return 0;
    }

    @Override // foundry.veil.api.client.render.shader.program.ShaderProgram
    @Nullable
    public ProgramDefinition getDefinition() {
        return this.definition;
    }

    @Override // foundry.veil.api.client.render.shader.program.TextureUniformAccess
    public void bindSamplers(@Nullable ShaderTextureSource.Context context, int samplerStart) {
        if (this.compiledProgram == null) {
            return;
        }
        if (context != null) {
            ObjectIterator it = this.definitionSamplers.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, ShaderTexture> entry = (Map.Entry) it.next();
                ShaderTexture source = entry.getValue();
                setTexture(entry.getKey(), source.textureSource.getTarget(context), source.textureSource.getId(context), source.samplerId());
            }
        }
        this.textures.bind(this.compiledProgram.uniformCache, samplerStart);
    }

    @Override // foundry.veil.api.client.render.shader.program.TextureUniformAccess
    public void setTexture(CharSequence name, int target, int textureId, int samplerId) {
        if (this.compiledProgram != null && this.compiledProgram.uniformCache.hasSampler(name.toString())) {
            this.textures.put(name, target, textureId, samplerId);
        }
    }

    @Override // foundry.veil.api.client.render.shader.program.TextureUniformAccess
    public void removeTexture(CharSequence name) {
        this.textures.remove(name);
    }

    @Override // foundry.veil.api.client.render.shader.program.TextureUniformAccess
    public void clearSamplers() {
        this.textures.clear();
    }

    public void addShaderBlock(String name, ShaderBlock<?> block) {
        this.shaderBlocks.put(name, block);
    }

    public void clearShaderBlocks() {
        this.shaderBlocks.clear();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram.class */
    public static final class CompiledProgram extends Record implements NativeResource {
        private final int program;
        private final Int2ObjectMap<CompiledShader> shaders;
        private final Int2ObjectMap<CompiledShader> shadersView;
        private final ShaderUniformCache uniformCache;
        private final Set<String> definitionDependencies;
        private final int activeBuffers;

        public CompiledProgram(int program, Int2ObjectMap<CompiledShader> shaders, Int2ObjectMap<CompiledShader> shadersView, ShaderUniformCache uniformCache, Set<String> definitionDependencies, int activeBuffers) {
            this.program = program;
            this.shaders = shaders;
            this.shadersView = shadersView;
            this.uniformCache = uniformCache;
            this.definitionDependencies = definitionDependencies;
            this.activeBuffers = activeBuffers;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, CompiledProgram.class), CompiledProgram.class, "program;shaders;shadersView;uniformCache;definitionDependencies;activeBuffers", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->program:I", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->shaders:Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->shadersView:Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->uniformCache:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->definitionDependencies:Ljava/util/Set;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->activeBuffers:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, CompiledProgram.class), CompiledProgram.class, "program;shaders;shadersView;uniformCache;definitionDependencies;activeBuffers", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->program:I", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->shaders:Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->shadersView:Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->uniformCache:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->definitionDependencies:Ljava/util/Set;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->activeBuffers:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, CompiledProgram.class, Object.class), CompiledProgram.class, "program;shaders;shadersView;uniformCache;definitionDependencies;activeBuffers", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->program:I", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->shaders:Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->shadersView:Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->uniformCache:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->definitionDependencies:Ljava/util/Set;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$CompiledProgram;->activeBuffers:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public int program() {
            return this.program;
        }

        public Int2ObjectMap<CompiledShader> shaders() {
            return this.shaders;
        }

        public Int2ObjectMap<CompiledShader> shadersView() {
            return this.shadersView;
        }

        public ShaderUniformCache uniformCache() {
            return this.uniformCache;
        }

        public Set<String> definitionDependencies() {
            return this.definitionDependencies;
        }

        public int activeBuffers() {
            return this.activeBuffers;
        }

        public static CompiledProgram create(ResourceLocation id, int activeBuffers) {
            int program = GL20C.glCreateProgram();
            VeilDebug.get().objectLabel(33506, program, "Shader Program " + String.valueOf(id));
            Int2ObjectArrayMap int2ObjectArrayMap = new Int2ObjectArrayMap(2);
            Int2ObjectMap<CompiledShader> shadersView = Int2ObjectMaps.unmodifiable(int2ObjectArrayMap);
            ShaderUniformCache uniforms = new ShaderUniformCache(() -> {
                return program;
            });
            Set<String> definitionDependencies = new HashSet<>();
            return new CompiledProgram(program, int2ObjectArrayMap, shadersView, uniforms, definitionDependencies, activeBuffers);
        }

        public void attachShader(int glType, CompiledShader shader) {
            CompiledShader old = (CompiledShader) this.shaders.put(glType, shader);
            if (old != null) {
                old.free();
            }
            GL20C.glAttachShader(this.program, shader.id());
        }

        @Nullable
        public VertexFormat detectVertexFormat() {
            VertexFormat best = null;
            int bestElements = 0;
            int activeAttributes = GL20C.glGetProgrami(this.program, 35721);
            Int2ObjectArrayMap int2ObjectArrayMap = new Int2ObjectArrayMap(activeAttributes);
            MemoryStack stack = MemoryStack.stackPush();
            try {
                IntBuffer size = stack.mallocInt(1);
                IntBuffer type = stack.mallocInt(1);
                for (int i = 0; i < activeAttributes; i++) {
                    String name = GL20C.glGetActiveAttrib(this.program, i, size, type);
                    int2ObjectArrayMap.put(GL20C.glGetAttribLocation(this.program, name), name);
                }
                if (stack != null) {
                    stack.close();
                }
                for (VertexFormat format : VertexFormatCodec.getDefaultFormats().values()) {
                    List<VertexFormatElement> elements = format.getElements();
                    int foundElements = 0;
                    if (elements.size() <= activeAttributes) {
                        for (int i2 = 0; i2 < elements.size() && format.getElementName(elements.get(i2)).equals(int2ObjectArrayMap.get(i2)); i2++) {
                            foundElements++;
                        }
                        if (foundElements >= elements.size() && bestElements <= activeAttributes && foundElements > bestElements) {
                            best = format;
                            bestElements = foundElements;
                        }
                    }
                }
                return best;
            } catch (Throwable th) {
                if (stack != null) {
                    try {
                        stack.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public void validate(ShaderProgram shaderProgram) {
            GL20C.glValidateProgram(this.program);
            if (GL20C.glGetProgrami(this.program, 35715) != 1) {
                String log = StringUtils.trim(GL20C.glGetProgramInfoLog(this.program));
                Veil.LOGGER.warn("Failed to validate shader ({}) : {}", shaderProgram.getName(), log);
            }
        }

        public void link() throws ShaderException {
            GL20C.glLinkProgram(this.program);
            if (GL20C.glGetProgrami(this.program, 35714) != 1) {
                String log = StringUtils.trim(GL20C.glGetProgramInfoLog(this.program));
                throw new ShaderException("Failed to link shader", log);
            }
            this.uniformCache.clear();
            this.definitionDependencies.clear();
            this.shaders.values().forEach(shader -> {
                this.definitionDependencies.addAll(shader.definitionDependencies());
            });
        }

        public void setup(ShaderProgram shaderProgram) {
            this.shaders.values().forEach(shader -> {
                shader.apply(shaderProgram);
            });
        }

        public void free() {
            ObjectIterator it = this.shaders.values().iterator();
            while (it.hasNext()) {
                CompiledShader shader = (CompiledShader) it.next();
                shader.free();
            }
            this.shaders.clear();
            GL20C.glDeleteProgram(this.program);
            this.uniformCache.clear();
            this.definitionDependencies.clear();
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/program/ShaderProgramImpl$ShaderTexture.class */
    public static final class ShaderTexture extends Record implements NativeResource {
        private final ShaderTextureSource textureSource;

        @Nullable
        private final SamplerObject sampler;

        public ShaderTexture(ShaderTextureSource textureSource, @Nullable SamplerObject sampler) {
            this.textureSource = textureSource;
            this.sampler = sampler;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ShaderTexture.class), ShaderTexture.class, "textureSource;sampler", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$ShaderTexture;->textureSource:Lfoundry/veil/api/client/render/shader/texture/ShaderTextureSource;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$ShaderTexture;->sampler:Lfoundry/veil/api/client/render/texture/SamplerObject;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ShaderTexture.class), ShaderTexture.class, "textureSource;sampler", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$ShaderTexture;->textureSource:Lfoundry/veil/api/client/render/shader/texture/ShaderTextureSource;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$ShaderTexture;->sampler:Lfoundry/veil/api/client/render/texture/SamplerObject;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ShaderTexture.class, Object.class), ShaderTexture.class, "textureSource;sampler", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$ShaderTexture;->textureSource:Lfoundry/veil/api/client/render/shader/texture/ShaderTextureSource;", "FIELD:Lfoundry/veil/impl/client/render/shader/program/ShaderProgramImpl$ShaderTexture;->sampler:Lfoundry/veil/api/client/render/texture/SamplerObject;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public ShaderTextureSource textureSource() {
            return this.textureSource;
        }

        @Nullable
        public SamplerObject sampler() {
            return this.sampler;
        }

        public static ShaderTexture create(ShaderTextureSource source) {
            SamplerObject samplerObject;
            TextureFilter filter = source.filter();
            if (filter != null) {
                samplerObject = SamplerObject.create();
                samplerObject.setFilter(filter);
            } else {
                samplerObject = null;
            }
            return new ShaderTexture(source, samplerObject);
        }

        public void free() {
            if (this.sampler != null) {
                this.sampler.free();
            }
        }

        public int samplerId() {
            if (this.sampler != null) {
                return this.sampler.getId();
            }
            return 0;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/program/ShaderProgramImpl$DummyShaderResource.class */
    private static class DummyShaderResource extends Resource {
        private static final byte[] DUMMY_SHADER = "{\n    \"vertex\": \"dummy\",\n    \"fragment\": \"dummy\"\n}\n".getBytes(StandardCharsets.UTF_8);

        public DummyShaderResource() {
            super((PackResources) null, () -> {
                return new ByteArrayInputStream(DUMMY_SHADER);
            });
        }

        @NotNull
        public PackResources source() {
            throw new UnsupportedOperationException("No pack source");
        }

        @NotNull
        public String sourcePackId() {
            return "dummy";
        }

        @NotNull
        public Optional<KnownPack> knownPackInfo() {
            return Optional.empty();
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/program/ShaderProgramImpl$Wrapper.class */
    public static class Wrapper extends ShaderInstance {
        private static final Resource RESOURCE = new DummyShaderResource();
        private static final VertexFormat DUMMY_FORMAT = VertexFormat.builder().build();
        public static ShaderProgram constructingProgram = null;
        private final ShaderProgram program;

        private Wrapper(ShaderProgram program) throws IOException {
            super(name -> {
                return Optional.of(RESOURCE);
            }, "", DUMMY_FORMAT);
            this.program = program;
        }

        public void close() {
        }

        public void clear() {
            ShaderProgram.unbind();
        }

        public void apply() {
            this.program.bind();
            this.program.bindSamplers(0);
        }

        public void attachToProgram() {
            throw new UnsupportedOperationException("Cannot attach shader program wrapper");
        }

        public void markDirty() {
        }

        @Nullable
        /* JADX INFO: renamed from: getUniform, reason: merged with bridge method [inline-methods] */
        public UniformWrapper m2017getUniform(@NotNull String name) {
            if (this.program != null && !this.program.hasUniform(name)) {
                return null;
            }
            return (UniformWrapper) this.uniformMap.computeIfAbsent(name, unused -> {
                return new UniformWrapper(name, () -> {
                    return ((ShaderProgram) Objects.requireNonNull(this.program)).getUniform((CharSequence) name);
                });
            });
        }

        public void setSampler(@NotNull String name, Object value) {
            int target;
            int textureId;
            Objects.requireNonNull(value);
            switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), RenderTarget.class, AbstractTexture.class, Integer.class).dynamicInvoker().invoke(value, 0) /* invoke-custom */) {
                case 0:
                    RenderTarget renderTarget = (RenderTarget) value;
                    target = 3553;
                    textureId = renderTarget.getColorTextureId();
                    break;
                case 1:
                    AbstractTextureExtension abstractTextureExtension = (AbstractTexture) value;
                    target = abstractTextureExtension.getTextureTarget();
                    textureId = abstractTextureExtension.getId();
                    break;
                case 2:
                    Integer id = (Integer) value;
                    target = 3553;
                    textureId = id.intValue();
                    break;
                default:
                    return;
            }
            if (textureId == 0) {
                this.program.removeTexture(name);
            } else {
                this.program.setTexture(name, target, textureId);
            }
        }

        @NotNull
        public VertexFormat getVertexFormat() {
            VertexFormat format = this.program.getFormat();
            return format != null ? format : super.getVertexFormat();
        }

        public ShaderProgram program() {
            return this.program;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/program/ShaderProgramImpl$UniformWrapper.class */
    public static class UniformWrapper extends Uniform {
        private static final Matrix2f MAT2X2 = new Matrix2f();
        private static final Matrix3f MAT3X3 = new Matrix3f();
        private static final Matrix3x2f MAT3X2 = new Matrix3x2f();
        private static final Matrix4x3f MAT4X3 = new Matrix4x3f();
        private static final Matrix4f MAT4X4 = new Matrix4f();
        private final Supplier<ShaderUniform> uniform;

        public UniformWrapper(String name, Supplier<ShaderUniform> uniform) {
            super(name, 0, 0, (Shader) null);
            super.close();
            this.uniform = uniform;
        }

        private ShaderUniformAccess getUniform() {
            ShaderUniform uniform = this.uniform.get();
            return uniform != null ? uniform : ShaderUniformAccess.EMPTY;
        }

        public void setLocation(int location) {
        }

        public void set(int index, float value) {
            throw new UnsupportedOperationException("Use absolute set");
        }

        public void set(float value) {
            getUniform().setFloat(value);
        }

        public void set(float x, float y) {
            getUniform().setVector(x, y);
        }

        public void set(float x, float y, float z) {
            getUniform().setVector(x, y, z);
        }

        public void set(float x, float y, float z, float w) {
            getUniform().setVector(x, y, z, w);
        }

        public void set(@NotNull Vector3f value) {
            getUniform().setVector((Vector3fc) value);
        }

        public void set(@NotNull Vector4f value) {
            getUniform().setVector((Vector4fc) value);
        }

        public void setSafe(float x, float y, float z, float w) {
            set(x, y, z, w);
        }

        public void set(int value) {
            getUniform().setInt(value);
        }

        public void set(int x, int y) {
            getUniform().setVectorI(x, y);
        }

        public void set(int x, int y, int z) {
            getUniform().setVectorI(x, y, z);
        }

        public void set(int x, int y, int z, int w) {
            getUniform().setVectorI(x, y, z, w);
        }

        public void setSafe(int x, int y, int z, int w) {
            set(x, y, z, w);
        }

        public void set(float[] values) {
            getUniform().setVector(values);
        }

        public void setMat2x2(float m00, float m01, float m10, float m11) {
            getUniform().setMatrix((Matrix2fc) MAT2X2.set(m00, m01, m10, m11), false);
        }

        public void setMat2x3(float m00, float m01, float m02, float m10, float m11, float m12) {
            getUniform().setMatrix2x3((Matrix3x2fc) MAT3X2.set(m00, m10, m01, m11, m02, m12), false);
        }

        public void setMat2x4(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13) {
            throw new UnsupportedOperationException();
        }

        public void setMat3x2(float m00, float m01, float m10, float m11, float m20, float m21) {
            getUniform().setMatrix3x2((Matrix3x2fc) MAT3X2.set(m00, m01, m10, m11, m20, m21), false);
        }

        public void setMat3x3(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
            getUniform().setMatrix((Matrix3fc) MAT3X3.set(m00, m01, m02, m10, m11, m12, m20, m21, m22), false);
        }

        public void setMat3x4(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23) {
            getUniform().setMatrix3x4((Matrix4x3fc) MAT4X3.set(m00, m10, m20, m01, m11, m21, m02, m12, m22, m03, m13, m23), false);
        }

        public void setMat4x3(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23) {
            getUniform().setMatrix4x3((Matrix4x3fc) MAT4X3.set(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23), false);
        }

        public void setMat4x2(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13) {
            throw new UnsupportedOperationException();
        }

        public void setMat4x4(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) {
            getUniform().setMatrix((Matrix4fc) MAT4X4.set(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33), false);
        }

        public void set(@NotNull Matrix3f value) {
            getUniform().setMatrix((Matrix3fc) value, false);
        }

        public void set(@NotNull Matrix4f value) {
            getUniform().setMatrix((Matrix4fc) value, false);
        }

        public void upload() {
        }

        public void close() {
        }

        public int getLocation() {
            ShaderUniform uniform = this.uniform.get();
            if (uniform != null) {
                return uniform.getLocation();
            }
            return -1;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/program/ShaderProgramImpl$ShaderWrapper.class */
    public static class ShaderWrapper extends Program {
        private final Program.Type type;
        private final ShaderProgram program;

        public ShaderWrapper(Program.Type type, ShaderProgram program) {
            super(type, 0, getName(type, program));
            this.type = type;
            this.program = program;
        }

        private static String getName(Program.Type type, ShaderProgram program) {
            ProgramDefinition definition = program.getDefinition();
            if (definition != null) {
                switch (AnonymousClass1.$SwitchMap$com$mojang$blaze3d$shaders$Program$Type[type.ordinal()]) {
                    case 1:
                        ResourceLocation vertex = definition.vertex();
                        if (vertex != null) {
                            return vertex.toString();
                        }
                        break;
                    case 2:
                        ResourceLocation fragment = definition.fragment();
                        if (fragment != null) {
                            return fragment.toString();
                        }
                        break;
                }
            }
            return "veil:dummy_" + type.getName();
        }

        public void attachToShader(@NotNull Shader shader) {
        }

        public void close() {
        }

        @NotNull
        public String getName() {
            return getName(this.type, this.program);
        }

        public int getId() {
            switch (AnonymousClass1.$SwitchMap$com$mojang$blaze3d$shaders$Program$Type[this.type.ordinal()]) {
                case 1:
                    CompiledShader vertex = this.program.getVertexShader();
                    if (vertex != null) {
                        return vertex.id();
                    }
                    return 0;
                case 2:
                    CompiledShader fragment = this.program.getFragmentShader();
                    if (fragment != null) {
                        return fragment.id();
                    }
                    return 0;
                default:
                    return super.getId();
            }
        }
    }

    /* JADX INFO: renamed from: foundry.veil.impl.client.render.shader.program.ShaderProgramImpl$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/program/ShaderProgramImpl$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$mojang$blaze3d$shaders$Program$Type = new int[Program.Type.values().length];

        static {
            try {
                $SwitchMap$com$mojang$blaze3d$shaders$Program$Type[Program.Type.VERTEX.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mojang$blaze3d$shaders$Program$Type[Program.Type.FRAGMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }
}
