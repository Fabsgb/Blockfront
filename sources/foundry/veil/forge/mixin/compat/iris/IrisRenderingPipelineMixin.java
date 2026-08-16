package foundry.veil.forge.mixin.compat.iris;

import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.ext.iris.IrisRenderingPipelineExtension;
import net.irisshaders.iris.pipeline.IrisRenderingPipeline;
import net.irisshaders.iris.targets.RenderTarget;
import net.irisshaders.iris.targets.RenderTargets;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/compat/iris/IrisRenderingPipelineMixin.class */
@Mixin({IrisRenderingPipeline.class})
public class IrisRenderingPipelineMixin implements IrisRenderingPipelineExtension {

    @Shadow
    @Final
    private RenderTargets renderTargets;

    @Unique
    private AdvancedFbo veil$simpleFbo;

    @Override // foundry.veil.ext.iris.IrisRenderingPipelineExtension
    public void veil$bindSimpleFramebuffer() {
        RenderTarget mainColorBuffer = this.renderTargets.getOrCreate(0);
        if (this.veil$simpleFbo == null || this.veil$simpleFbo.getWidth() != mainColorBuffer.getWidth() || this.veil$simpleFbo.getHeight() != mainColorBuffer.getHeight()) {
            if (this.veil$simpleFbo != null) {
                this.veil$simpleFbo.free();
            }
            this.veil$simpleFbo = AdvancedFbo.withSize(mainColorBuffer.getWidth(), mainColorBuffer.getHeight()).addColorTextureWrapper(mainColorBuffer.getMainTexture()).setDepthTextureWrapper(this.renderTargets.getDepthTexture()).build(true);
        }
        this.veil$simpleFbo.bind(false);
    }

    @Inject(method = {"destroy"}, at = {@At("TAIL")}, remap = false)
    public void destroy(CallbackInfo ci) {
        if (this.veil$simpleFbo != null) {
            this.veil$simpleFbo.free();
            this.veil$simpleFbo = null;
        }
    }
}
