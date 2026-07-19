package foundry.veil.impl.client.render.framebuffer;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment;
import foundry.veil.api.client.render.texture.TextureFilter;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL30C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/framebuffer/AdvancedFboMutableTextureAttachment.class */
@ApiStatus.Internal
public class AdvancedFboMutableTextureAttachment extends AdvancedFboTextureAttachment {
    private int textureId;
    private int layer;

    public AdvancedFboMutableTextureAttachment(int attachmentType, int textureId, int layer, String name) {
        super(attachmentType, 0, 0, 0, 0, 1, TextureFilter.CLAMP, name);
        setTexture(textureId, layer);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment, foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public void attach(AdvancedFbo framebuffer, int attachment) {
        int attachmentType = getAttachmentType();
        Validate.isTrue(attachmentType < 36096 || attachment == 0, "Only one depth buffer attachment is supported.", new Object[0]);
        if (VeilRenderSystem.directStateAccessSupported()) {
            if (this.layer == -1) {
                ARBDirectStateAccess.glNamedFramebufferTexture(framebuffer.getId(), attachmentType + attachment, this.textureId, 0);
                return;
            } else {
                ARBDirectStateAccess.glNamedFramebufferTextureLayer(framebuffer.getId(), attachmentType + attachment, this.textureId, 0, this.layer);
                return;
            }
        }
        if (this.layer == -1) {
            GL30C.glFramebufferTexture2D(36160, attachmentType + attachment, 3553, this.textureId, 0);
        } else {
            GL30.glFramebufferTextureLayer(36160, attachmentType + attachment, this.textureId, 0, this.layer);
        }
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment, foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public void create() {
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment
    /* JADX INFO: renamed from: clone */
    public AdvancedFboMutableTextureAttachment mo1772clone() {
        return new AdvancedFboMutableTextureAttachment(getAttachmentType(), this.textureId, this.layer, getName());
    }

    public void releaseId() {
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboTextureAttachment
    public int getId() {
        return this.textureId;
    }

    public void setTexture(int textureId, int layer) {
        this.textureId = textureId;
        this.layer = layer;
    }
}
