package foundry.veil.api.client.render.post;

import com.mojang.serialization.Codec;
import foundry.veil.api.client.registry.PostPipelineStageRegistry;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.api.client.render.shader.program.TextureUniformAccess;
import foundry.veil.api.client.render.shader.program.UniformAccess;
import foundry.veil.api.client.render.shader.texture.ShaderTextureSource;
import foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/post/PostPipeline.class */
public interface PostPipeline extends UniformAccess, NativeResource {
    public static final Codec<PostPipeline> CODEC = PostPipelineStageRegistry.REGISTRY.byNameCodec().dispatch((v0) -> {
        return v0.getType();
    }, (v0) -> {
        return v0.codec();
    });

    @ApiStatus.OverrideOnly
    void apply(Context context);

    PostPipelineStageRegistry.PipelineType<? extends PostPipeline> getType();

    default void free() {
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    default int getUniformLocation(CharSequence name) {
        throw new UnsupportedOperationException("Cannot get values from post pipelines");
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    @Nullable
    default ShaderUniformAccess getUniform(CharSequence name) {
        return null;
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    default ShaderUniformAccess getUniformSafe(CharSequence name) {
        return ShaderUniformAccess.EMPTY;
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    default int getUniformBlock(CharSequence name) {
        throw new UnsupportedOperationException("Cannot get values from post pipelines");
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    default int getStorageBlock(CharSequence name) {
        throw new UnsupportedOperationException("Cannot get values from post pipelines");
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    default boolean hasUniform(CharSequence name) {
        return false;
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    default boolean hasUniformBlock(CharSequence name) {
        return false;
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    default boolean hasStorageBlock(CharSequence name) {
        return false;
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    default void setUniformBlock(CharSequence name, int binding) {
    }

    @Override // foundry.veil.api.client.render.shader.program.UniformAccess
    default void setStorageBlock(CharSequence name, int binding) {
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/post/PostPipeline$Context.class */
    @ApiStatus.NonExtendable
    public interface Context extends ShaderTextureSource.Context {
        void setTexture(CharSequence charSequence, int i, int i2, int i3);

        void setFramebuffer(ResourceLocation resourceLocation, AdvancedFbo advancedFbo);

        void applySamplers(TextureUniformAccess textureUniformAccess);

        void clearSamplers(TextureUniformAccess textureUniformAccess);

        AdvancedFbo getDrawFramebuffer();

        default AdvancedFbo getFramebufferOrDraw(ResourceLocation name) {
            AdvancedFbo fbo = getFramebuffer(name);
            return fbo != null ? fbo : getDrawFramebuffer();
        }

        @Nullable
        default PostPipeline getPipeline(ResourceLocation name) {
            return VeilRenderSystem.renderer().getPostProcessingManager().getPipeline(name);
        }

        @Nullable
        default ShaderProgram getShader(ResourceLocation name) {
            return VeilRenderSystem.renderer().getShaderManager().getShader(name);
        }
    }
}
