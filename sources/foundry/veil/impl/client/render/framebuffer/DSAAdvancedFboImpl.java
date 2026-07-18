package foundry.veil.impl.client.render.framebuffer;

import com.mojang.blaze3d.pipeline.RenderTarget;
import foundry.veil.api.client.render.ext.VeilDebug;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment;
import java.util.Arrays;
import java.util.Locale;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.ARBDirectStateAccess;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/framebuffer/DSAAdvancedFboImpl.class */
@ApiStatus.Internal
public class DSAAdvancedFboImpl extends AdvancedFboImpl {
    public DSAAdvancedFboImpl(int width, int height, AdvancedFboAttachment[] colorAttachments, @Nullable AdvancedFboAttachment depthAttachment, @Nullable String debugLabel) {
        super(width, height, colorAttachments, depthAttachment, debugLabel);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void create() {
        for (AdvancedFboAttachment attachment : this.colorAttachments) {
            attachment.create();
        }
        if (this.depthAttachment != null) {
            this.depthAttachment.create();
        }
        this.f8772id = ARBDirectStateAccess.glCreateFramebuffers();
        if (this.debugLabel != null) {
            VeilDebug.get().objectLabel(36160, this.f8772id, "Advanced Fbo " + this.debugLabel);
        }
        for (int i = 0; i < this.colorAttachments.length; i++) {
            this.colorAttachments[i].attach(this, i);
        }
        if (this.depthAttachment != null) {
            this.depthAttachment.attach(this, 0);
        }
        int status = ARBDirectStateAccess.glCheckNamedFramebufferStatus(this.f8772id, 36160);
        if (status != 36053) {
            String error = ERRORS.containsKey(Integer.valueOf(status)) ? ERRORS.get(Integer.valueOf(status)) : "0x" + Integer.toHexString(status).toUpperCase(Locale.ROOT);
            throw new IllegalStateException("Advanced FBO status did not return GL_FRAMEBUFFER_COMPLETE. " + error);
        }
        this.currentDrawBuffers = this.drawBuffers;
        ARBDirectStateAccess.glNamedFramebufferDrawBuffers(this.f8772id, this.drawBuffers);
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x011c A[Catch: Throwable -> 0x01b8, TryCatch #1 {Throwable -> 0x01b8, blocks: (B:97:0x000b, B:99:0x0019, B:102:0x0038, B:104:0x004b, B:106:0x0055, B:108:0x0063, B:110:0x006b, B:111:0x0086, B:112:0x0094, B:113:0x009a, B:115:0x00a1, B:119:0x00af, B:121:0x00b8, B:133:0x00dd, B:141:0x00f3, B:143:0x0101, B:144:0x011c, B:147:0x0136, B:150:0x014d, B:153:0x016b, B:155:0x0179, B:156:0x0199), top: B:174:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0199 A[Catch: Throwable -> 0x01b8, TryCatch #1 {Throwable -> 0x01b8, blocks: (B:97:0x000b, B:99:0x0019, B:102:0x0038, B:104:0x004b, B:106:0x0055, B:108:0x0063, B:110:0x006b, B:111:0x0086, B:112:0x0094, B:113:0x009a, B:115:0x00a1, B:119:0x00af, B:121:0x00b8, B:133:0x00dd, B:141:0x00f3, B:143:0x0101, B:144:0x011c, B:147:0x0136, B:150:0x014d, B:153:0x016b, B:155:0x0179, B:156:0x0199), top: B:174:0x000b }] */
    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void clear(float r8, float r9, float r10, float r11, float r12, int r13, int... r14) {
        /*
            Method dump skipped, instruction units count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: foundry.veil.impl.client.render.framebuffer.DSAAdvancedFboImpl.clear(float, float, float, float, float, int, int[]):void");
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void resetDrawBuffers() {
        if (Arrays.mismatch(this.currentDrawBuffers, this.drawBuffers) >= 0) {
            this.currentDrawBuffers = this.drawBuffers;
            ARBDirectStateAccess.glNamedFramebufferDrawBuffers(this.f8772id, this.drawBuffers);
        }
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void drawBuffers(int... buffers) {
        if (Arrays.mismatch(this.currentDrawBuffers, buffers) >= 0) {
            if (this.currentDrawBuffers.length != buffers.length) {
                this.currentDrawBuffers = Arrays.copyOf(buffers, buffers.length);
            } else {
                System.arraycopy(buffers, 0, this.currentDrawBuffers, 0, buffers.length);
            }
            ARBDirectStateAccess.glNamedFramebufferDrawBuffers(this.f8772id, buffers);
        }
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void resolveToFbo(int id, int width, int height, int mask, int filtering) {
        ARBDirectStateAccess.glBlitNamedFramebuffer(this.f8772id, id, 0, 0, getWidth(), getHeight(), 0, 0, width, height, mask, filtering);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void resolveToAdvancedFbo(AdvancedFbo target, int mask, int filtering) {
        ARBDirectStateAccess.glBlitNamedFramebuffer(this.f8772id, target.getId(), 0, 0, getWidth(), getHeight(), 0, 0, target.getWidth(), target.getHeight(), mask, filtering);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void resolveToRenderTarget(RenderTarget target, int mask, int filtering) {
        ARBDirectStateAccess.glBlitNamedFramebuffer(this.f8772id, target.frameBufferId, 0, 0, getWidth(), getHeight(), 0, 0, target.width, target.height, mask, filtering);
    }
}
