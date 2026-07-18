package foundry.veil.mixin.performance.client;

import com.boehmod.blockfront.InterfaceC1294xq;
import com.mojang.blaze3d.pipeline.MainTarget;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.ext.PerformanceRenderTargetExtension;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.opengl.ARBClearTexture;
import org.lwjgl.opengl.ARBCopyImage;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.NVDrawTexture;
import org.lwjgl.system.MemoryStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/performance/client/PerformanceRenderTargetMixin.class */
@Mixin({RenderTarget.class})
public abstract class PerformanceRenderTargetMixin implements PerformanceRenderTargetExtension {

    @Unique
    private static final ResourceLocation veil$BLIT_SHADER = Veil.veilPath("blit_screen");

    @Shadow
    public int width;

    @Shadow
    public int height;

    @Shadow
    @Final
    private float[] clearChannels;

    @Shadow
    @Final
    public boolean useDepth;

    @Shadow
    public int frameBufferId;

    @Shadow
    public abstract int getColorTextureId();

    @Shadow
    public abstract int getDepthTextureId();

    @Shadow
    public abstract void bindWrite(boolean z);

    @Shadow
    public abstract void unbindWrite();

    @Inject(method = {"copyDepthFrom"}, at = {@At("HEAD")}, cancellable = true)
    public void copyDepthFrom(RenderTarget otherTarget, CallbackInfo ci) {
        if (!(getClass() instanceof MainTarget)) {
            return;
        }
        if (!this.useDepth || !otherTarget.useDepth) {
            ci.cancel();
            return;
        }
        if (VeilRenderSystem.copyImageSupported() && this.width == otherTarget.width && this.height == otherTarget.height) {
            ci.cancel();
            ARBCopyImage.glCopyImageSubData(otherTarget.getDepthTextureId(), 3553, 0, 0, 0, 0, getDepthTextureId(), 3553, 0, 0, 0, 0, this.width, this.height, 1);
        } else if (VeilRenderSystem.directStateAccessSupported()) {
            ci.cancel();
            ARBDirectStateAccess.glBlitNamedFramebuffer(otherTarget.frameBufferId, this.frameBufferId, 0, 0, otherTarget.width, otherTarget.height, 0, 0, this.width, this.height, 256, 9728);
        }
    }

    @Inject(method = {"clear"}, at = {@At("HEAD")}, cancellable = true)
    public void clear(boolean clearError, CallbackInfo ci) {
        if (!(getClass() instanceof MainTarget)) {
            return;
        }
        boolean clearTex = VeilRenderSystem.clearTextureSupported();
        if (!clearTex && !VeilRenderSystem.directStateAccessSupported()) {
            return;
        }
        ci.cancel();
        MemoryStack stack = MemoryStack.stackPush();
        try {
            if (clearTex) {
                ARBClearTexture.glClearTexImage(getColorTextureId(), 0, 6408, 5126, this.clearChannels);
            } else {
                ARBDirectStateAccess.glClearNamedFramebufferfv(this.frameBufferId, 6144, 0, this.clearChannels);
            }
            if (this.useDepth) {
                if (clearTex) {
                    ARBClearTexture.glClearTexImage(getDepthTextureId(), 0, 6402, 5126, stack.floats(1.0f));
                } else {
                    ARBDirectStateAccess.glClearNamedFramebufferfv(this.frameBufferId, 6145, 0, stack.floats(1.0f));
                }
            }
            if (stack != null) {
                stack.close();
            }
            if (clearError) {
                GL11C.glGetError();
            }
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

    @Inject(method = {"_blitToScreen"}, at = {@At("HEAD")}, cancellable = true)
    private void _blitToScreen(int width, int height, boolean disableBlend, CallbackInfo ci) {
        GlStateManager._disableDepthTest();
        if (VeilRenderSystem.nvDrawTextureSupported()) {
            ci.cancel();
            RenderSystem.assertOnRenderThread();
            GlStateManager._colorMask(true, true, true, false);
            GlStateManager._depthMask(false);
            if (disableBlend) {
                GlStateManager._disableBlend();
            }
            NVDrawTexture.glDrawTextureNV(getColorTextureId(), 0, 0.0f, 0.0f, width, height, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
            GlStateManager._colorMask(true, true, true, true);
            GlStateManager._depthMask(true);
            return;
        }
        if (disableBlend && VeilRenderSystem.directStateAccessSupported()) {
            ci.cancel();
            RenderSystem.assertOnRenderThread();
            int drawFramebuffer = GL11C.glGetInteger(36006);
            GlStateManager._colorMask(true, true, true, false);
            ARBDirectStateAccess.glBlitNamedFramebuffer(this.frameBufferId, drawFramebuffer, 0, 0, this.width, this.height, 0, 0, width, height, InterfaceC1294xq.f8660tV, 9728);
        } else {
            ShaderProgram shader = VeilRenderSystem.setShader(veil$BLIT_SHADER);
            if (shader == null) {
                return;
            }
            ci.cancel();
            RenderSystem.assertOnRenderThread();
            GlStateManager._viewport(0, 0, width, height);
            GlStateManager._colorMask(true, true, true, false);
            GlStateManager._depthMask(false);
            if (disableBlend) {
                GlStateManager._disableBlend();
            }
            int activeTexture = GlStateManager._getActiveTexture();
            GlStateManager._activeTexture(33984);
            GlStateManager._bindTexture(getColorTextureId());
            GlStateManager._activeTexture(activeTexture);
            shader.bind();
            VeilRenderSystem.drawScreenQuad();
            ShaderProgram.unbind();
        }
        GlStateManager._colorMask(true, true, true, true);
        GlStateManager._depthMask(true);
    }

    @Override // foundry.veil.ext.PerformanceRenderTargetExtension
    public void veil$clearColorBuffer(boolean clearError) {
        RenderSystem.assertOnRenderThreadOrInit();
        int colorTextureId = getColorTextureId();
        if (VeilRenderSystem.clearTextureSupported() && GL11C.glIsTexture(colorTextureId)) {
            ARBClearTexture.glClearTexImage(colorTextureId, 0, 6408, 5126, this.clearChannels);
        } else if (VeilRenderSystem.directStateAccessSupported()) {
            ARBDirectStateAccess.glClearNamedFramebufferfv(this.frameBufferId, 6144, 0, this.clearChannels);
        } else {
            bindWrite(true);
            GlStateManager._clearColor(this.clearChannels[0], this.clearChannels[1], this.clearChannels[2], this.clearChannels[3]);
            GlStateManager._clear(InterfaceC1294xq.f8660tV, clearError);
            unbindWrite();
        }
        if (clearError) {
            GL11C.glGetError();
        }
    }
}
