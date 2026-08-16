package foundry.veil.api.client.render.framebuffer;

import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.ext.VeilDebug;
import foundry.veil.api.client.render.texture.TextureFilter;
import java.nio.ByteBuffer;
import java.util.Objects;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.server.packs.resources.ResourceManager;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.GL30C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/framebuffer/AdvancedFboTextureAttachment.class */
public class AdvancedFboTextureAttachment extends AbstractTexture implements AdvancedFboAttachment {
    private final int attachmentType;
    private final int format;
    private final int internalFormat;
    private final int width;
    private final int height;
    private final int mipmapLevels;
    private final TextureFilter filter;
    private final String name;

    public AdvancedFboTextureAttachment(int attachmentType, int internalFormat, int format, int width, int height, int mipmapLevels, TextureFilter filter, @Nullable String name) {
        this.attachmentType = attachmentType;
        this.format = format;
        this.internalFormat = internalFormat;
        this.width = width;
        this.height = height;
        this.mipmapLevels = mipmapLevels;
        this.filter = filter;
        this.name = name;
    }

    public void setFilter(boolean blur, boolean mipmap) {
        int minFilter;
        int magFilter;
        RenderSystem.assertOnRenderThreadOrInit();
        this.blur = blur;
        this.mipmap = mipmap;
        if (blur) {
            minFilter = mipmap ? 9987 : 9729;
            magFilter = 9729;
        } else {
            minFilter = mipmap ? 9986 : 9728;
            magFilter = 9728;
        }
        if (VeilRenderSystem.directStateAccessSupported()) {
            int texture = getId();
            ARBDirectStateAccess.glTextureParameteri(texture, 10241, minFilter);
            ARBDirectStateAccess.glTextureParameteri(texture, 10240, magFilter);
        } else {
            bind();
            GL30C.glTexParameteri(3553, 10241, minFilter);
            GL30C.glTexParameteri(3553, 10240, magFilter);
        }
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public void attach(AdvancedFbo framebuffer, int attachment) {
        String str;
        Validate.isTrue(this.attachmentType < 36096 || attachment == 0, "Only one depth buffer attachment is supported.", new Object[0]);
        int id = getId();
        if (VeilRenderSystem.directStateAccessSupported()) {
            ARBDirectStateAccess.glNamedFramebufferTexture(framebuffer.getId(), this.attachmentType + attachment, id, 0);
        } else {
            GL30C.glFramebufferTexture2D(36160, this.attachmentType + attachment, 3553, id, 0);
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
                    str = "Advanced Fbo " + debugLabel + " Texture " + String.valueOf(this.name != null ? this.name : Integer.valueOf(attachment));
                    break;
            }
            String label = str;
            VeilDebug.get().objectLabel(5890, id, label);
        }
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public void create() {
        bind();
        setFilter(this.filter.blur(), this.filter.mipmap());
        GL30C.glTexParameteri(3553, 33085, this.mipmapLevels - 1);
        GL30C.glTexParameteri(3553, 33082, 0);
        GL30C.glTexParameteri(3553, 33083, this.mipmapLevels - 1);
        GL30C.glTexParameterf(3553, 34049, 0.0f);
        this.filter.applyToTextureTarget(3553);
        for (int i = 0; i < this.mipmapLevels; i++) {
            GL30C.glTexImage2D(3553, i, this.internalFormat, this.width >> i, this.height >> i, 0, this.format, 5121, (ByteBuffer) null);
        }
    }

    public int getId() {
        RenderSystem.assertOnRenderThreadOrInit();
        if (this.id == -1) {
            this.id = VeilRenderSystem.createTextures(3553);
        }
        return this.id;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AdvancedFboTextureAttachment mo9329clone() {
        return new AdvancedFboTextureAttachment(this.attachmentType, this.internalFormat, this.format, this.width, this.height, this.mipmapLevels, this.filter, this.name);
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdvancedFboTextureAttachment that = (AdvancedFboTextureAttachment) o;
        return this.attachmentType == that.attachmentType && this.internalFormat == that.internalFormat && this.width == that.width && this.height == that.height && this.mipmapLevels == that.mipmapLevels && this.filter.equals(that.filter) && Objects.equals(this.name, that.name);
    }

    public int hashCode() {
        int result = this.attachmentType;
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * result) + this.internalFormat)) + this.width)) + this.height)) + this.mipmapLevels)) + this.filter.hashCode())) + Objects.hashCode(this.name);
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public void bindAttachment() {
        bind();
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public void unbindAttachment() {
        VeilRenderSystem.renderThreadExecutor().execute(() -> {
            RenderSystem.bindTexture(0);
        });
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public int getAttachmentType() {
        return this.attachmentType;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public int getFormat() {
        return this.internalFormat;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public int getLevels() {
        return this.mipmapLevels;
    }

    public TextureFilter getFilter() {
        return this.filter;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    public boolean canSample() {
        return true;
    }

    @Override // foundry.veil.api.client.render.framebuffer.AdvancedFboAttachment
    @Nullable
    public String getName() {
        return this.name;
    }

    public void free() {
        releaseId();
    }

    public void load(@NotNull ResourceManager manager) {
    }
}
