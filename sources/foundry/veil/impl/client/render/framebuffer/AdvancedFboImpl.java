package foundry.veil.impl.client.render.framebuffer;

import com.boehmod.blockfront.InterfaceC1294xq;
import com.google.common.base.Suppliers;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.VeilRenderBridge;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import net.minecraft.client.Minecraft;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.GL30C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/framebuffer/AdvancedFboImpl.class */
@ApiStatus.Internal
public abstract class AdvancedFboImpl implements AdvancedFbo {
    protected static final Map<Integer, String> ERRORS = Map.of(36054, "GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT", 36055, "GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT", 36059, "GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER", 36060, "GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER", 36061, "GL_FRAMEBUFFER_UNSUPPORTED", 36182, "GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE", 33305, "GL_FRAMEBUFFER_UNDEFINED", 1285, "GL_OUT_OF_MEMORY");
    public static final Supplier<AdvancedFbo> MAIN_WRAPPER = Suppliers.memoize(() -> {
        Minecraft minecraft = Minecraft.getInstance();
        Objects.requireNonNull(minecraft);
        return VeilRenderBridge.wrap((Supplier<RenderTarget>) minecraft::getMainRenderTarget);
    });

    /* JADX INFO: renamed from: id */
    protected int f8772id = -1;
    protected final int width;
    protected final int height;
    protected final AdvancedFboAttachment[] colorAttachments;
    protected final AdvancedFboAttachment depthAttachment;
    protected final boolean hasStencil;
    protected final String debugLabel;
    protected final int clearMask;
    protected final int[] drawBuffers;
    protected int[] currentDrawBuffers;
    protected final Supplier<Wrapper> wrapper;

    public AdvancedFboImpl(int width, int height, AdvancedFboAttachment[] colorAttachments, @Nullable AdvancedFboAttachment depthAttachment, @Nullable String debugLabel) {
        this.width = width;
        this.height = height;
        this.colorAttachments = colorAttachments;
        this.depthAttachment = depthAttachment;
        this.hasStencil = depthAttachment != null && (depthAttachment.getFormat() == 34041 || depthAttachment.getFormat() == 35056 || depthAttachment.getFormat() == 36013);
        this.debugLabel = debugLabel;
        int mask = 0;
        mask = hasColorAttachment(0) ? 0 | InterfaceC1294xq.f8660tV : mask;
        mask = hasDepthAttachment() ? mask | 256 : mask;
        this.clearMask = hasStencilAttachment() ? mask | InterfaceC1294xq.f8656tR : mask;
        this.drawBuffers = IntStream.range(0, this.colorAttachments.length).map(i -> {
            return 36064 + i;
        }).toArray();
        this.wrapper = Suppliers.memoize(() -> {
            return new Wrapper(this);
        });
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void bind(boolean setViewport) {
        GlStateManager._glBindFramebuffer(36160, this.f8772id);
        if (setViewport) {
            RenderSystem.viewport(0, 0, this.width, this.height);
        }
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public void bindDraw(boolean setViewport) {
        GlStateManager._glBindFramebuffer(36009, this.f8772id);
        if (setViewport) {
            RenderSystem.viewport(0, 0, this.width, this.height);
        }
    }

    public void free() {
        if (this.f8772id == -1) {
            return;
        }
        GL30C.glDeleteFramebuffers(this.f8772id);
        this.f8772id = -1;
        for (AdvancedFboAttachment attachment : this.colorAttachments) {
            attachment.free();
        }
        if (this.depthAttachment != null) {
            this.depthAttachment.free();
        }
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public int getId() {
        return this.f8772id;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public int getWidth() {
        return this.width;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public int getHeight() {
        return this.height;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public int getColorAttachments() {
        return this.colorAttachments.length;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public int getClearMask() {
        return this.clearMask;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public int[] getDrawBuffers() {
        return this.drawBuffers;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public boolean hasColorAttachment(int attachment) {
        return attachment >= 0 && attachment < this.colorAttachments.length;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public boolean hasDepthAttachment() {
        return this.depthAttachment != null;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public boolean hasStencilAttachment() {
        return this.hasStencil;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public AdvancedFboAttachment getColorAttachment(int attachment) {
        Validate.isTrue(hasColorAttachment(attachment), "Color attachment " + attachment + " does not exist.", new Object[0]);
        return this.colorAttachments[attachment];
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    public AdvancedFboAttachment getDepthAttachment() {
        return (AdvancedFboAttachment) Objects.requireNonNull(this.depthAttachment, "Depth attachment does not exist.");
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    @Nullable
    public String getDebugLabel() {
        return this.debugLabel;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFbo
    /* JADX INFO: renamed from: toRenderTarget */
    public Wrapper mo9156toRenderTarget() {
        return this.wrapper.get();
    }

    @ApiStatus.Internal
    public static AdvancedFbo.Builder copy(RenderTarget parent) {
        if (parent instanceof Wrapper) {
            Wrapper wrapper = (Wrapper) parent;
            AdvancedFbo fbo = wrapper.fbo();
            return new AdvancedFbo.Builder(fbo.getWidth(), fbo.getHeight()).addAttachments(fbo);
        }
        return new AdvancedFbo.Builder(parent.width, parent.height).addAttachments(parent);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/framebuffer/AdvancedFboImpl$Wrapper.class */
    public static class Wrapper extends TextureTarget {
        private final float[] clearChannels;
        private final AdvancedFboImpl fbo;

        private Wrapper(AdvancedFboImpl fbo) {
            super(fbo.width, fbo.height, fbo.hasDepthAttachment(), Minecraft.ON_OSX);
            this.clearChannels = new float[]{1.0f, 1.0f, 1.0f, 0.0f};
            this.fbo = fbo;
            this.width = this.fbo.getWidth();
            this.height = this.fbo.getHeight();
            this.viewWidth = this.width;
            this.viewHeight = this.height;
            this.frameBufferId = this.fbo.f8772id;
            this.colorTextureId = this.fbo.isColorTextureAttachment(0) ? this.fbo.getColorTextureAttachment(0).getId() : 0;
            this.depthBufferId = this.fbo.isDepthTextureAttachment() ? this.fbo.getDepthTextureAttachment().getId() : 0;
        }

        public void resize(int width, int height, boolean onMac) {
        }

        public void destroyBuffers() {
            throw new UnsupportedOperationException("Cannot destroy advanced fbo from wrapper");
        }

        public void createBuffers(int width, int height, boolean onMac) {
        }

        public void setFilterMode(int framebufferFilter) {
            this.filterMode = framebufferFilter;
            if (VeilRenderSystem.directStateAccessSupported()) {
                for (int i = 0; i < this.fbo.getColorAttachments(); i++) {
                    int texture = this.fbo.getColorTextureAttachment(i).getId();
                    ARBDirectStateAccess.glTextureParameteri(texture, 10241, framebufferFilter);
                    ARBDirectStateAccess.glTextureParameteri(texture, 10240, framebufferFilter);
                    ARBDirectStateAccess.glTextureParameteri(texture, 10242, 33071);
                    ARBDirectStateAccess.glTextureParameteri(texture, 10243, 33071);
                }
                return;
            }
            for (int i2 = 0; i2 < this.fbo.getColorAttachments(); i2++) {
                this.fbo.getColorAttachment(i2).bindAttachment();
                GlStateManager._texParameter(3553, 10241, framebufferFilter);
                GlStateManager._texParameter(3553, 10240, framebufferFilter);
                GlStateManager._texParameter(3553, 10242, 33071);
                GlStateManager._texParameter(3553, 10243, 33071);
            }
            GlStateManager._bindTexture(0);
        }

        public void setClearColor(float red, float green, float blue, float alpha) {
            super.setClearColor(red, green, blue, alpha);
            this.clearChannels[0] = red;
            this.clearChannels[1] = green;
            this.clearChannels[2] = blue;
            this.clearChannels[3] = alpha;
        }

        public void clear(boolean clearError) {
            RenderSystem.assertOnRenderThreadOrInit();
            this.fbo.clear(this.clearChannels[0], this.clearChannels[1], this.clearChannels[2], this.clearChannels[3], this.fbo.getClearMask());
        }

        public void bindRead() {
            if (this.fbo.hasColorAttachment(0)) {
                this.fbo.getColorAttachment(0).bindAttachment();
            }
        }

        public void unbindRead() {
            if (this.fbo.hasColorAttachment(0)) {
                this.fbo.getColorAttachment(0).unbindAttachment();
            }
        }

        public void bindWrite(boolean setViewport) {
            this.fbo.bind(setViewport);
        }

        public AdvancedFboImpl fbo() {
            return this.fbo;
        }
    }
}
