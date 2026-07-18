package foundry.veil.api.client.render.framebuffer;

import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.ext.VeilDebug;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.GL30;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/framebuffer/AdvancedFboRenderAttachment.class */
public class AdvancedFboRenderAttachment implements AdvancedFboAttachment {

    /* JADX INFO: renamed from: id */
    private int f8743id;
    private final int attachmentType;
    private final int attachmentFormat;
    private final int width;
    private final int height;
    private final int samples;

    public AdvancedFboRenderAttachment(int attachmentType, int attachmentFormat, int width, int height, int samples) {
        this.attachmentType = attachmentType;
        this.attachmentFormat = attachmentFormat;
        this.width = width;
        this.height = height;
        Validate.inclusiveBetween(1L, VeilRenderSystem.maxSamples(), samples);
        this.samples = samples;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public void create() {
        if (VeilRenderSystem.directStateAccessSupported()) {
            int id = getId();
            if (this.samples == 1) {
                ARBDirectStateAccess.glNamedRenderbufferStorage(id, this.attachmentFormat, this.width, this.height);
                return;
            } else {
                ARBDirectStateAccess.glNamedRenderbufferStorageMultisample(id, this.samples, this.attachmentFormat, this.width, this.height);
                return;
            }
        }
        bindAttachment();
        if (this.samples == 1) {
            GL30.glRenderbufferStorage(36161, this.attachmentFormat, this.width, this.height);
        } else {
            GL30.glRenderbufferStorageMultisample(36161, this.samples, this.attachmentFormat, this.width, this.height);
        }
        unbindAttachment();
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public void attach(AdvancedFbo framebuffer, int attachment) {
        String str;
        Validate.isTrue(this.attachmentType < 36096 || attachment == 0, "Only one depth buffer attachment is supported.", new Object[0]);
        int id = getId();
        if (VeilRenderSystem.directStateAccessSupported()) {
            ARBDirectStateAccess.glNamedFramebufferRenderbuffer(framebuffer.getId(), this.attachmentType, 36161, id);
        } else {
            GL30.glFramebufferRenderbuffer(36160, this.attachmentType, 36161, id);
        }
        String debugLabel = framebuffer.getDebugLabel();
        if (debugLabel != null) {
            switch (this.attachmentType) {
                case 33306:
                    str = "Advanced Fbo " + debugLabel + " Depth Stencil Texture";
                    break;
                case 36096:
                    str = "Advanced Fbo " + debugLabel + " Depth Texture";
                    break;
                default:
                    str = "Advanced Fbo " + debugLabel + " Texture " + attachment;
                    break;
            }
            String label = str;
            VeilDebug.get().objectLabel(36161, id, label);
        }
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public void bindAttachment() {
        VeilRenderSystem.renderThreadExecutor().execute(() -> {
            GL30.glBindRenderbuffer(36161, getId());
        });
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public void unbindAttachment() {
        VeilRenderSystem.renderThreadExecutor().execute(() -> {
            GL30.glBindRenderbuffer(36161, 0);
        });
    }

    public int getId() {
        RenderSystem.assertOnRenderThreadOrInit();
        if (this.f8743id == 0) {
            this.f8743id = VeilRenderSystem.directStateAccessSupported() ? ARBDirectStateAccess.glCreateRenderbuffers() : GL30.glGenRenderbuffers();
        }
        return this.f8743id;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public int getAttachmentType() {
        return this.attachmentType;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public int getFormat() {
        return this.attachmentFormat;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public int getLevels() {
        return this.samples;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public boolean canSample() {
        return false;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    @Nullable
    public String getName() {
        return null;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    @NotNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AdvancedFboAttachment m8945clone() {
        return new AdvancedFboRenderAttachment(this.attachmentType, this.attachmentFormat, this.width, this.height, this.samples);
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdvancedFboRenderAttachment that = (AdvancedFboRenderAttachment) o;
        return this.f8743id == that.f8743id && this.attachmentType == that.attachmentType && this.attachmentFormat == that.attachmentFormat && this.width == that.width && this.height == that.height && this.samples == that.samples;
    }

    public int hashCode() {
        int result = this.f8743id;
        return (31 * ((31 * ((31 * ((31 * ((31 * result) + this.attachmentType)) + this.attachmentFormat)) + this.width)) + this.height)) + this.samples;
    }

    public void free() {
        if (this.f8743id != 0) {
            GL30.glDeleteRenderbuffers(this.f8743id);
        }
        this.f8743id = 0;
    }
}
