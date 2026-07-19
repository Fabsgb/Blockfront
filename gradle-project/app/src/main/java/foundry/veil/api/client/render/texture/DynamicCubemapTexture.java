package foundry.veil.api.client.render.texture;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.mixin.pipeline.accessor.PipelineNativeImageAccessor;
import java.io.IOException;
import net.minecraft.core.Direction;
import net.minecraft.server.packs.resources.ResourceManager;
import org.lwjgl.opengl.GL12C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/texture/DynamicCubemapTexture.class */
public class DynamicCubemapTexture extends CubemapTexture {
    private final int[] width = new int[6];
    private final int[] height = new int[6];

    private void init(int face, int width, int height) {
        this.width[face] = width;
        this.height[face] = height;
        RenderSystem.assertOnRenderThreadOrInit();
        GL12C.glTexImage2D(34069 + face, 0, 32856, width, height, 0, 6408, 5121, 0L);
    }

    public void init(int width, int height) {
        bind();
        setFilter(false, false);
        GlStateManager._texParameter(34067, 33085, 0);
        GlStateManager._texParameter(34067, 33082, 0);
        GlStateManager._texParameter(34067, 33083, 0);
        GlStateManager._texParameter(34067, 34049, 0.0f);
        RenderSystem.assertOnRenderThreadOrInit();
        for (int i = 0; i < 6; i++) {
            init(i, width, height);
        }
    }

    public void upload(NativeImage image) {
        init(image.getWidth(), image.getHeight());
        int width = image.getWidth();
        int height = image.getHeight();
        RenderSystem.assertOnRenderThreadOrInit();
        PipelineNativeImageAccessor accessor = (PipelineNativeImageAccessor) image;
        accessor.invokeCheckAllocated();
        GlStateManager._pixelStore(3314, 0);
        GlStateManager._pixelStore(3315, 0);
        GlStateManager._pixelStore(3316, 0);
        NativeImage.Format format = image.format();
        format.setUnpackPixelStoreState();
        for (int i = 0; i < 6; i++) {
            GlStateManager._texSubImage2D(34069 + i, 0, 0, 0, width, height, format.glFormat(), 5121, accessor.getPixels());
        }
    }

    public void upload(Direction face, NativeImage image) {
        upload(getGlFace(face), image);
    }

    public void upload(int face, NativeImage image) {
        if (this.id == -1) {
            init(image.getWidth(), image.getHeight());
        } else if (this.width[face - 34069] != image.getWidth() || this.height[face - 34069] != image.getHeight()) {
            init(face, image.getWidth(), image.getHeight());
        } else {
            bind();
        }
        int width = image.getWidth();
        int height = image.getHeight();
        RenderSystem.assertOnRenderThreadOrInit();
        PipelineNativeImageAccessor accessor = (PipelineNativeImageAccessor) image;
        accessor.invokeCheckAllocated();
        GlStateManager._pixelStore(3314, 0);
        GlStateManager._pixelStore(3315, 0);
        GlStateManager._pixelStore(3316, 0);
        NativeImage.Format format = image.format();
        format.setUnpackPixelStoreState();
        GlStateManager._texSubImage2D(face, 0, 0, 0, width, height, format.glFormat(), 5121, accessor.getPixels());
    }

    public void load(ResourceManager resourceManager) throws IOException {
    }
}
