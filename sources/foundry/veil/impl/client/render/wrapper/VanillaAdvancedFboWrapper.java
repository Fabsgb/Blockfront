package foundry.veil.impl.client.render.wrapper;

import com.google.common.base.Suppliers;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment;
import foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment;
import foundry.veil.api.client.render.texture.TextureFilter;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL30C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/wrapper/VanillaAdvancedFboWrapper.class */
@ApiStatus.Internal
public abstract class VanillaAdvancedFboWrapper implements AdvancedFbo {
    private final Supplier<RenderTarget> renderTargetSupplier;
    private final Supplier<AttachmentWrapper> colorBuffer = Suppliers.memoize(() -> {
        return new AttachmentWrapper(this, () -> {
            return mo9156toRenderTarget().getColorTextureId();
        }, 36064);
    });
    private final Supplier<AttachmentWrapper> depthBuffer = Suppliers.memoize(() -> {
        return new AttachmentWrapper(this, () -> {
            return mo9156toRenderTarget().getDepthTextureId();
        }, 36096);
    });
    private final int[] drawBuffers = {36064};
    private boolean hasStencil = false;
    private int depthTextureCache = 0;

    public VanillaAdvancedFboWrapper(Supplier<RenderTarget> renderTargetSupplier) {
        this.renderTargetSupplier = renderTargetSupplier;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void create() {
        throw new UnsupportedOperationException("Vanilla framebuffers cannot be created");
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void clear() {
        float[] clearChannels = mo9156toRenderTarget().getClearChannels();
        clear(clearChannels[0], clearChannels[1], clearChannels[2], clearChannels[3], getClearMask(), getDrawBuffers());
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void clear(int clearMask) {
        float[] clearChannels = mo9156toRenderTarget().getClearChannels();
        clear(clearChannels[0], clearChannels[1], clearChannels[2], clearChannels[3], clearMask, getDrawBuffers());
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void resetDrawBuffers() {
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void drawBuffers(int... buffers) {
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void bind(boolean setViewport) {
        mo9156toRenderTarget().bindWrite(setViewport);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void bindDraw(boolean setViewport) {
        RenderTarget renderTarget = mo9156toRenderTarget();
        GlStateManager._glBindFramebuffer(36009, renderTarget.frameBufferId);
        if (setViewport) {
            RenderSystem.viewport(0, 0, renderTarget.viewWidth, renderTarget.viewHeight);
        }
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public int getId() {
        return mo9156toRenderTarget().frameBufferId;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public int getWidth() {
        return mo9156toRenderTarget().width;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public int getHeight() {
        return mo9156toRenderTarget().height;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public int getColorAttachments() {
        return 1;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public int getClearMask() {
        return 16384 | (mo9156toRenderTarget().useDepth ? 256 : 0);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public int[] getDrawBuffers() {
        return this.drawBuffers;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public boolean hasColorAttachment(int attachment) {
        return attachment == 0;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public boolean hasDepthAttachment() {
        return mo9156toRenderTarget().useDepth;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public boolean hasStencilAttachment() {
        RenderTarget renderTarget = mo9156toRenderTarget();
        if (!renderTarget.useDepth) {
            return false;
        }
        int depthTextureId = renderTarget.getDepthTextureId();
        if (this.depthTextureCache == depthTextureId) {
            return this.hasStencil;
        }
        this.depthTextureCache = renderTarget.getDepthTextureId();
        GlStateManager._bindTexture(depthTextureId);
        int format = GL30C.glGetTexLevelParameteri(3553, 0, 4099);
        boolean z = format == 34041 || format == 35056 || format == 36013;
        this.hasStencil = z;
        return z;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public AdvancedFboAttachment getColorAttachment(int attachment) {
        Validate.isTrue(hasColorAttachment(attachment), "Color attachment " + attachment + " does not exist.", new Object[0]);
        return this.colorBuffer.get();
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public AdvancedFboAttachment getDepthAttachment() {
        Validate.isTrue(hasDepthAttachment(), "Depth attachment does not exist.", new Object[0]);
        return this.depthBuffer.get();
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    @Nullable
    public String getDebugLabel() {
        return null;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    /* JADX INFO: renamed from: toRenderTarget */
    public RenderTarget mo9156toRenderTarget() {
        return this.renderTargetSupplier.get();
    }

    public void free() {
        mo9156toRenderTarget().destroyBuffers();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/wrapper/VanillaAdvancedFboWrapper$AttachmentWrapper.class */
    private static class AttachmentWrapper extends AdvancedFboTextureAttachment {
        private final AdvancedFbo parent;

        /* JADX INFO: renamed from: id */
        private final IntSupplier f8777id;

        private AttachmentWrapper(AdvancedFbo parent, IntSupplier id, int type) {
            super(type, 0, 0, 0, 0, 1, TextureFilter.CLAMP, null);
            this.parent = parent;
            this.f8777id = id;
        }

        @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment, foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
        public void create() {
            throw new UnsupportedOperationException("Vanilla framebuffer attachments cannot be created");
        }

        @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment, foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
        public void attach(AdvancedFbo framebuffer, int attachment) {
            throw new UnsupportedOperationException("Vanilla framebuffer attachments cannot be attached");
        }

        @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment
        public int getId() {
            return this.f8777id.getAsInt();
        }

        @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment
        @NotNull
        /* JADX INFO: renamed from: clone */
        public AdvancedFboTextureAttachment mo8946clone() {
            return new AttachmentWrapper(this.parent, this.f8777id, getAttachmentType());
        }

        @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass() || !super.equals(o)) {
                return false;
            }
            AttachmentWrapper that = (AttachmentWrapper) o;
            return this.f8777id.getAsInt() == that.f8777id.getAsInt();
        }

        @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment
        public int hashCode() {
            return this.f8777id.getAsInt();
        }

        @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment
        public void free() {
            throw new UnsupportedOperationException("Vanilla framebuffer attachments cannot be deleted");
        }
    }
}
