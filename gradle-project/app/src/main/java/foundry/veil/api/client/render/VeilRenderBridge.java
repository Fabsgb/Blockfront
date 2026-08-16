package foundry.veil.api.client.render;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.vertex.PoseStack;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.impl.client.render.pipeline.AdvancedFboShard;
import foundry.veil.impl.client.render.pipeline.FlagShards;
import foundry.veil.impl.client.render.pipeline.PatchStateShard;
import foundry.veil.impl.client.render.pipeline.ShaderProgramShard;
import foundry.veil.impl.client.render.shader.program.ShaderProgramImpl;
import foundry.veil.impl.client.render.wrapper.DSAVanillaAdvancedFboWrapper;
import foundry.veil.impl.client.render.wrapper.LegacyVanillaAdvancedFboWrapper;
import java.util.function.Supplier;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/VeilRenderBridge.class */
public interface VeilRenderBridge {
    static ShaderInstance toShaderInstance(ShaderProgram program) {
        return ((ShaderProgramImpl) program).toShaderInstance();
    }

    @Nullable
    static ShaderProgram toShaderProgram(ShaderInstance instance) {
        if (!(instance instanceof ShaderProgramImpl.Wrapper)) {
            return null;
        }
        ShaderProgramImpl.Wrapper wrapper = (ShaderProgramImpl.Wrapper) instance;
        return wrapper.program();
    }

    static CullFrustum create(Frustum frustum) {
        return (CullFrustum) frustum;
    }

    static VeilRenderTypeBuilder create(RenderType.CompositeState.CompositeStateBuilder builder) {
        return (VeilRenderTypeBuilder) builder;
    }

    static MatrixStack create(PoseStack poseStack) {
        return (MatrixStack) poseStack;
    }

    static AdvancedFbo wrap(RenderTarget renderTarget) {
        return wrap((Supplier<RenderTarget>) () -> {
            return renderTarget;
        });
    }

    static AdvancedFbo wrap(Supplier<RenderTarget> renderTargetSupplier) {
        return VeilRenderSystem.directStateAccessSupported() ? new DSAVanillaAdvancedFboWrapper(renderTargetSupplier) : new LegacyVanillaAdvancedFboWrapper(renderTargetSupplier);
    }

    static RenderStateShard.ShaderStateShard shaderState(ResourceLocation shader) {
        return new ShaderProgramShard(shader);
    }

    static RenderStateShard.OutputStateShard outputState(ResourceLocation framebuffer) {
        return new AdvancedFboShard(framebuffer, () -> {
            return VeilRenderSystem.renderer().getFramebufferManager().getFramebuffer(framebuffer);
        });
    }

    static RenderStateShard.OutputStateShard outputState(AdvancedFbo framebuffer) {
        return new AdvancedFboShard(null, () -> {
            return framebuffer;
        });
    }

    static RenderStateShard.OutputStateShard outputState(Supplier<AdvancedFbo> framebuffer) {
        return new AdvancedFboShard(null, framebuffer);
    }

    static RenderStateShard patchState(int patchVertices) {
        return new PatchStateShard(patchVertices);
    }

    static RenderStateShard depthClampState() {
        return FlagShards.DEPTH_CLAMP;
    }

    static RenderStateShard multisampleState() {
        return FlagShards.MULTISAMPLE;
    }

    static RenderStateShard seamlessCubeMapState() {
        return FlagShards.TEXTURE_CUBE_MAP_SEAMLESS;
    }
}
