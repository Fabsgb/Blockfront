package foundry.veil.api.client.render.post.stage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.registry.PostPipelineStageRegistry;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.FramebufferDefinition;
import foundry.veil.api.client.render.post.PostPipeline;
import foundry.veil.api.client.render.shader.texture.ShaderTextureSource;
import foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess;
import foundry.veil.api.event.VeilRenderLevelStageEvent;
import foundry.veil.impl.client.render.shader.injection.util.ShaderInjectionDefinition;
import foundry.veil.impl.client.render.shader.program.ShaderProgramImpl;
import gg.moonflower.molangcompiler.api.MolangRuntime;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/post/stage/CompositePostPipeline.class */
public final class CompositePostPipeline implements PostPipeline {
    private static final Codec<Map<ResourceLocation, FramebufferDefinition>> FRAMEBUFFER_CODEC = Codec.unboundedMap(Codec.STRING.xmap(name -> {
        return ResourceLocation.fromNamespaceAndPath("temp", name);
    }, (v0) -> {
        return v0.getPath();
    }), FramebufferDefinition.CODEC);
    public static final Codec<CompositePostPipeline> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(PostPipeline.CODEC.listOf().fieldOf("stages").forGetter(pipeline -> {
            return Arrays.asList(pipeline.getStages());
        }), Codec.unboundedMap(Codec.STRING, ShaderTextureSource.CODEC).optionalFieldOf("textures", Collections.emptyMap()).forGetter((v0) -> {
            return v0.getTextureSources();
        }), FRAMEBUFFER_CODEC.optionalFieldOf("framebuffers", Collections.emptyMap()).forGetter((v0) -> {
            return v0.getFramebuffers();
        }), VeilRenderLevelStageEvent.Stage.CODEC.optionalFieldOf("renderStage").forGetter(pipeline2 -> {
            return Optional.ofNullable(pipeline2.getRenderStage());
        }), DynamicBufferType.PACKED_LIST_CODEC.optionalFieldOf("dynamicBuffers", 0).forGetter((v0) -> {
            return v0.getDynamicBuffersMask();
        }), Codec.INT.optionalFieldOf("priority", Integer.valueOf(ShaderInjectionDefinition.DEFAULT_PRIORITY)).forGetter((v0) -> {
            return v0.getPriority();
        }), Codec.BOOL.optionalFieldOf("replace", false).forGetter((v0) -> {
            return v0.isReplace();
        })).apply(instance, (pipelines, textures, framebuffers, renderStage, dynamicBuffers, priority, replace) -> {
            return new CompositePostPipeline((PostPipeline[]) pipelines.toArray(x$0 -> {
                return new PostPipeline[x$0];
            }), textures, framebuffers, (VeilRenderLevelStageEvent.Stage) renderStage.orElse(null), dynamicBuffers.intValue(), priority.intValue(), replace.booleanValue());
        });
    });
    private final PostPipeline[] stages;
    private final Map<String, ShaderTextureSource> textureSources;
    private final Map<String, ShaderProgramImpl.ShaderTexture> samplers;
    private final Map<ResourceLocation, FramebufferDefinition> framebufferDefinitions;
    private final VeilRenderLevelStageEvent.Stage renderStage;
    private final Map<ResourceLocation, AdvancedFbo> framebuffers;
    private final Map<String, ShaderUniformAccess> uniforms;
    private final DynamicBufferType[] dynamicBuffers;
    private final int dynamicBuffersMask;
    private final int priority;
    private final boolean replace;
    private int screenWidth;
    private int screenHeight;

    private CompositePostPipeline(PostPipeline[] stages, Map<String, ShaderTextureSource> samplers, Map<ResourceLocation, FramebufferDefinition> framebufferDefinitions, @Nullable VeilRenderLevelStageEvent.Stage renderStage, int dynamicBuffers, int priority, boolean replace) {
        this.screenWidth = -1;
        this.screenHeight = -1;
        this.stages = stages;
        this.textureSources = Collections.unmodifiableMap(samplers);
        this.samplers = new Object2ObjectArrayMap(samplers.size());
        Minecraft.getInstance().execute(() -> {
            for (Map.Entry<String, ShaderTextureSource> entry : samplers.entrySet()) {
                this.samplers.put(entry.getKey(), ShaderProgramImpl.ShaderTexture.create(entry.getValue()));
            }
        });
        this.framebufferDefinitions = Collections.unmodifiableMap(framebufferDefinitions);
        this.renderStage = renderStage;
        this.framebuffers = new Object2ObjectArrayMap();
        this.uniforms = new Object2ObjectArrayMap();
        this.dynamicBuffers = DynamicBufferType.decode(dynamicBuffers);
        this.dynamicBuffersMask = dynamicBuffers;
        this.priority = priority;
        this.replace = replace;
    }

    public CompositePostPipeline(PostPipeline[] stages, Map<String, ShaderTextureSource> samplers, Map<ResourceLocation, FramebufferDefinition> framebufferDefinitions, @Nullable VeilRenderLevelStageEvent.Stage renderStage, int dynamicBuffers) {
        this(stages, samplers, framebufferDefinitions, renderStage, dynamicBuffers, ShaderInjectionDefinition.DEFAULT_PRIORITY, false);
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline
    public void apply(PostPipeline.Context context) {
        AdvancedFbo main = context.getDrawFramebuffer();
        if (this.screenWidth != main.getWidth() || this.screenHeight != main.getHeight()) {
            this.screenWidth = main.getWidth();
            this.screenHeight = main.getHeight();
            this.framebuffers.values().forEach((v0) -> {
                v0.free();
            });
            this.framebuffers.clear();
            MolangRuntime runtime = (MolangRuntime) MolangRuntime.runtime().setQuery("screen_width", this.screenWidth).setQuery("screen_height", this.screenHeight).create();
            this.framebufferDefinitions.forEach((name, definition) -> {
                this.framebuffers.put(name, definition.createBuilder(runtime).setDebugLabel("Temp " + String.valueOf(name)).build(true));
            });
        }
        Map<ResourceLocation, AdvancedFbo> map = this.framebuffers;
        Objects.requireNonNull(context);
        map.forEach(context::setFramebuffer);
        for (DynamicBufferType buffer : this.dynamicBuffers) {
            context.setTexture(buffer.getSourceName(), 3553, VeilRenderSystem.renderer().getDynamicBufferManger().getBufferTexture(buffer), 0);
        }
        for (Map.Entry<String, ShaderProgramImpl.ShaderTexture> entry : this.samplers.entrySet()) {
            ShaderProgramImpl.ShaderTexture texture = entry.getValue();
            ShaderTextureSource source = texture.textureSource();
            context.setTexture(entry.getKey(), source.getTarget(context), source.getId(context), texture.samplerId());
        }
        for (PostPipeline pipeline : this.stages) {
            pipeline.apply(context);
        }
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline
    public void free() {
        for (PostPipeline pipeline : this.stages) {
            pipeline.free();
        }
        this.framebuffers.values().forEach((v0) -> {
            v0.free();
        });
        this.framebuffers.clear();
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline
    public PostPipelineStageRegistry.PipelineType<? extends PostPipeline> getType() {
        throw new UnsupportedOperationException("Composite pipelines cannot be encoded");
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline, foundry.veil.api.client.render.shader.program.UniformAccess
    public boolean hasUniform(CharSequence name) {
        ShaderUniformAccess uniform = this.uniforms.get(name.toString());
        if (uniform != null && uniform.isValid()) {
            return true;
        }
        for (PostPipeline pipeline : this.stages) {
            if (pipeline.hasUniform(name)) {
                return true;
            }
        }
        return false;
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline, foundry.veil.api.client.render.shader.program.UniformAccess
    public ShaderUniformAccess getUniform(CharSequence name) {
        return getUniformSafe(name);
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline, foundry.veil.api.client.render.shader.program.UniformAccess
    public ShaderUniformAccess getUniformSafe(CharSequence name) {
        return this.uniforms.computeIfAbsent(name.toString(), key -> {
            ShaderUniformAccess[] uniforms = (ShaderUniformAccess[]) Arrays.stream(this.stages).map(pipeline -> {
                return ShaderUniformAccess.wrapped(() -> {
                    return pipeline.getUniformSafe(key);
                });
            }).toArray(x$0 -> {
                return new ShaderUniformAccess[x$0];
            });
            return ShaderUniformAccess.m8340of(uniforms);
        });
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline, foundry.veil.api.client.render.shader.program.UniformAccess
    public boolean hasUniformBlock(CharSequence name) {
        for (PostPipeline pipeline : this.stages) {
            if (pipeline.hasUniformBlock(name)) {
                return true;
            }
        }
        return false;
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline, foundry.veil.api.client.render.shader.program.UniformAccess
    public boolean hasStorageBlock(CharSequence name) {
        for (PostPipeline pipeline : this.stages) {
            if (pipeline.hasStorageBlock(name)) {
                return true;
            }
        }
        return false;
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline, foundry.veil.api.client.render.shader.program.UniformAccess
    public void setUniformBlock(CharSequence name, int binding) {
        for (PostPipeline pipeline : this.stages) {
            pipeline.setUniformBlock(name, binding);
        }
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline, foundry.veil.api.client.render.shader.program.UniformAccess
    public void setStorageBlock(CharSequence name, int binding) {
        for (PostPipeline pipeline : this.stages) {
            pipeline.setStorageBlock(name, binding);
        }
    }

    public PostPipeline[] getStages() {
        return this.stages;
    }

    public Map<String, ShaderTextureSource> getTextureSources() {
        return this.textureSources;
    }

    public Map<ResourceLocation, FramebufferDefinition> getFramebuffers() {
        return this.framebufferDefinitions;
    }

    public DynamicBufferType[] getDynamicBuffers() {
        return this.dynamicBuffers;
    }

    @Nullable
    public VeilRenderLevelStageEvent.Stage getRenderStage() {
        return this.renderStage;
    }

    public int getDynamicBuffersMask() {
        return this.dynamicBuffersMask;
    }

    public int getPriority() {
        return this.priority;
    }

    public boolean isReplace() {
        return this.replace;
    }
}
