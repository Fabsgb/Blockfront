package foundry.veil.api.client.render.post.stage;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.Veil;
import foundry.veil.api.client.registry.PostPipelineStageRegistry;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.FramebufferManager;
import foundry.veil.api.client.render.framebuffer.VeilFramebuffers;
import foundry.veil.api.client.render.post.PostPipeline;
import foundry.veil.api.client.render.post.uniform.UniformValue;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/post/stage/BlitPostStage.class */
public class BlitPostStage extends FramebufferPostStage {
    public static final MapCodec<BlitPostStage> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("shader").forGetter((v0) -> {
            return v0.getShaderId();
        }), Codec.unboundedMap(Codec.STRING, UniformValue.CODEC).optionalFieldOf("uniforms", Collections.emptyMap()).forGetter((v0) -> {
            return v0.getUniforms();
        }), FramebufferManager.FRAMEBUFFER_CODEC.optionalFieldOf("in").forGetter(stage -> {
            return Optional.ofNullable(stage.getIn());
        }), FramebufferManager.FRAMEBUFFER_CODEC.optionalFieldOf("out", VeilFramebuffers.POST).forGetter((v0) -> {
            return v0.getOut();
        }), Codec.BOOL.optionalFieldOf("clear", true).forGetter((v0) -> {
            return v0.clearOut();
        })).apply(instance, (shader, uniforms, in, out, clear) -> {
            return new BlitPostStage(shader, uniforms, (ResourceLocation) in.orElse(null), out, clear.booleanValue());
        });
    }).flatXmap(stage -> {
        if (stage.getOut().equals(stage.getIn())) {
            return DataResult.error(() -> {
                return "Input and output targets cannot be the same";
            });
        }
        return DataResult.success(stage);
    }, (v0) -> {
        return DataResult.success(v0);
    });
    private final ResourceLocation shader;
    private final Map<String, UniformValue> uniforms;
    private boolean printedError;

    public BlitPostStage(ResourceLocation shader, Map<String, UniformValue> uniforms, @Nullable ResourceLocation in, ResourceLocation out, boolean clear) {
        super(in, out, clear);
        this.shader = shader;
        this.uniforms = uniforms;
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline
    public void apply(PostPipeline.Context context) {
        ShaderProgram shader = VeilRenderSystem.renderer().getShaderManager().getShader(this.shader);
        if (shader == null) {
            if (!this.printedError) {
                this.printedError = true;
                Veil.LOGGER.warn("Failed to find post shader: {}", this.shader);
                return;
            }
            return;
        }
        shader.bind();
        context.applySamplers(shader);
        setupFramebuffer(context, shader);
        shader.setDefaultUniforms(VertexFormat.Mode.TRIANGLE_STRIP);
        shader.bindSamplers(context, 0);
        for (Map.Entry<String, UniformValue> entry : this.uniforms.entrySet()) {
            entry.getValue().apply(shader.getUniform((CharSequence) entry.getKey()));
        }
        VeilRenderSystem.drawScreenQuad();
        context.clearSamplers(shader);
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline
    public PostPipelineStageRegistry.PipelineType<? extends PostPipeline> getType() {
        return PostPipelineStageRegistry.BLIT.get();
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline, foundry.veil.api.client.render.shader.program.UniformAccess
    public boolean hasUniform(CharSequence name) {
        ShaderProgram shader = getShader();
        return shader != null && shader.hasUniform(name);
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline, foundry.veil.api.client.render.shader.program.UniformAccess
    @Nullable
    public ShaderUniformAccess getUniform(CharSequence name) {
        ShaderProgram shader = getShader();
        if (shader != null) {
            return shader.getUniform(name);
        }
        return null;
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline, foundry.veil.api.client.render.shader.program.UniformAccess
    public ShaderUniformAccess getUniformSafe(CharSequence name) {
        ShaderProgram shader = getShader();
        return shader != null ? shader.getUniform(name) : ShaderUniformAccess.EMPTY;
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline, foundry.veil.api.client.render.shader.program.UniformAccess
    public boolean hasUniformBlock(CharSequence name) {
        ShaderProgram shader = getShader();
        return shader != null && shader.hasUniformBlock(name);
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline, foundry.veil.api.client.render.shader.program.UniformAccess
    public boolean hasStorageBlock(CharSequence name) {
        ShaderProgram shader = getShader();
        return shader != null && shader.hasStorageBlock(name);
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline, foundry.veil.api.client.render.shader.program.UniformAccess
    public void setUniformBlock(CharSequence name, int binding) {
        ShaderProgram shader = getShader();
        if (shader != null) {
            shader.setUniformBlock(name, binding);
        }
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline, foundry.veil.api.client.render.shader.program.UniformAccess
    public void setStorageBlock(CharSequence name, int binding) {
        ShaderProgram shader = getShader();
        if (shader != null) {
            shader.setStorageBlock(name, binding);
        }
    }

    @Nullable
    public ShaderProgram getShader() {
        return VeilRenderSystem.renderer().getShaderManager().getShader(this.shader);
    }

    public ResourceLocation getShaderId() {
        return this.shader;
    }

    public Map<String, UniformValue> getUniforms() {
        return this.uniforms;
    }
}
