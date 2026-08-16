package foundry.veil.mixin.pipeline.client;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.ext.RenderTargetExtension;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/pipeline/client/PipelineRenderTargetMixin.class */
@Mixin({RenderTarget.class})
public abstract class PipelineRenderTargetMixin implements RenderTargetExtension {

    @Shadow
    public int frameBufferId;

    @Shadow
    public int width;

    @Shadow
    public int height;

    @Shadow
    public int viewWidth;

    @Shadow
    public int viewHeight;

    @Unique
    private AdvancedFbo veil$wrapper;

    @Unique
    private int veil$vanillaFramebufferId;

    @Unique
    private int veil$vanillaWidth;

    @Unique
    private int veil$vanillaHeight;

    @Unique
    private int veil$vanillaViewWidth;

    @Unique
    private int veil$vanillaViewHeight;

    @Unique
    private void veil$saveState() {
        this.veil$vanillaFramebufferId = this.frameBufferId;
        this.veil$vanillaWidth = this.width;
        this.veil$vanillaHeight = this.height;
        this.veil$vanillaViewWidth = this.viewWidth;
        this.veil$vanillaViewHeight = this.viewHeight;
    }

    @Unique
    private void veil$loadState() {
        this.frameBufferId = this.veil$vanillaFramebufferId;
        this.width = this.veil$vanillaWidth;
        this.height = this.veil$vanillaHeight;
        this.viewWidth = this.veil$vanillaViewWidth;
        this.viewHeight = this.veil$vanillaViewHeight;
    }

    @Inject(method = {"destroyBuffers"}, at = {@At("HEAD")})
    public void destroyBuffers(CallbackInfo ci) {
        if (this.veil$wrapper != null) {
            veil$loadState();
        }
    }

    @Inject(method = {"createBuffers"}, at = {@At("RETURN")})
    public void createBuffers(CallbackInfo ci) {
        if (this.veil$wrapper != null) {
            veil$saveState();
            this.frameBufferId = this.veil$wrapper.getId();
            this.width = this.veil$wrapper.getWidth();
            this.height = this.veil$wrapper.getHeight();
            this.viewWidth = this.width;
            this.viewHeight = this.height;
        }
    }

    @Override // foundry.veil.ext.RenderTargetExtension
    public void veil$setWrapper(@Nullable AdvancedFbo fbo) {
        if ((this.veil$wrapper == null) ^ (fbo == null)) {
            if (fbo != null) {
                veil$saveState();
                this.frameBufferId = fbo.getId();
                this.width = fbo.getWidth();
                this.height = fbo.getHeight();
                this.viewWidth = this.width;
                this.viewHeight = this.height;
            } else {
                veil$loadState();
            }
        }
        this.veil$wrapper = fbo;
    }

    @Override // foundry.veil.ext.RenderTargetExtension
    public int veil$getTexture(int buffer) {
        if (this.veil$wrapper != null && this.veil$wrapper.isColorTextureAttachment(buffer)) {
            return this.veil$wrapper.getColorTextureAttachment(buffer).getId();
        }
        return 0;
    }

    @Inject(method = {"bindRead"}, at = {@At("HEAD")}, cancellable = true)
    public void bindRead(CallbackInfo ci) {
        if (this.veil$wrapper != null) {
            if (this.veil$wrapper.isColorTextureAttachment(0)) {
                this.veil$wrapper.getColorTextureAttachment(0).bind();
            } else {
                GlStateManager._bindTexture(0);
            }
            ci.cancel();
        }
    }

    @Inject(method = {"bindWrite"}, at = {@At("HEAD")}, cancellable = true)
    public void bindWrite(boolean setViewport, CallbackInfo ci) {
        if (this.veil$wrapper != null) {
            this.veil$wrapper.bind(setViewport);
            ci.cancel();
        }
    }

    @Inject(method = {"getColorTextureId"}, at = {@At("HEAD")}, cancellable = true)
    public void getColorTextureId(CallbackInfoReturnable<Integer> cir) {
        if (this.veil$wrapper != null) {
            cir.setReturnValue(Integer.valueOf(this.veil$wrapper.getColorTextureAttachment(0).getId()));
        }
    }

    @Inject(method = {"getDepthTextureId"}, at = {@At("HEAD")}, cancellable = true)
    public void getDepthTextureId(CallbackInfoReturnable<Integer> cir) {
        if (this.veil$wrapper != null) {
            cir.setReturnValue(Integer.valueOf(this.veil$wrapper.getDepthTextureAttachment().getId()));
        }
    }
}
