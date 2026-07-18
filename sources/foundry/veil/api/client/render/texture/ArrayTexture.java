package foundry.veil.api.client.render.texture;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.ext.AbstractTextureExtension;
import foundry.veil.mixin.pipeline.accessor.PipelineNativeImageAccessor;
import net.minecraft.client.renderer.texture.AbstractTexture;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.GL12C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/texture/ArrayTexture.class */
public abstract class ArrayTexture extends AbstractTexture implements AbstractTextureExtension {
    private int width;
    private int height;

    protected void init(int format, int mipmapLevel, int width, int height, int depth) {
        RenderSystem.assertOnRenderThreadOrInit();
        bind();
        if (mipmapLevel >= 0) {
            GlStateManager._texParameter(35866, 33085, mipmapLevel);
            GlStateManager._texParameter(35866, 33082, 0);
            GlStateManager._texParameter(35866, 33083, mipmapLevel);
            GlStateManager._texParameter(35866, 34049, 0.0f);
        }
        this.width = width;
        this.height = height;
        for (int i = 0; i <= mipmapLevel; i++) {
            GL12C.glTexImage3D(35866, i, format, width >> i, height >> i, depth, 0, 6408, 5121, 0L);
        }
    }

    protected void upload(NativeImage... images) {
        bind();
        for (int i = 0; i < images.length; i++) {
            NativeImage image = images[i];
            if (image.getWidth() != this.width || image.getHeight() != this.height) {
                throw new IllegalArgumentException("Image dimensions don't match");
            }
            GL12C.glTexSubImage3D(35866, 0, 0, 0, i, image.getWidth(), image.getHeight(), 1, image.format().glFormat(), 5121, ((PipelineNativeImageAccessor) image).getPixels());
        }
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
            int id = getId();
            ARBDirectStateAccess.glTextureParameteri(id, 10241, minFilter);
            ARBDirectStateAccess.glTextureParameteri(id, 10240, magFilter);
        } else {
            bind();
            GL12C.glTexParameteri(35866, 10241, minFilter);
            GL12C.glTexParameteri(35866, 10240, magFilter);
        }
    }

    public int getId() {
        RenderSystem.assertOnRenderThreadOrInit();
        if (this.id == -1) {
            this.id = VeilRenderSystem.createTextures(35866);
        }
        return this.id;
    }

    public void bind() {
        GL12C.glBindTexture(35866, getId());
    }

    @Override // foundry.veil.ext.AbstractTextureExtension
    public int getTextureTarget() {
        return 35866;
    }
}
