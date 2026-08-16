package foundry.veil.api.client.render.texture;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.logging.LogUtils;
import foundry.veil.mixin.pipeline.accessor.PipelineNativeImageAccessor;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import net.minecraft.Util;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.metadata.texture.TextureMetadataSection;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL12C;
import org.slf4j.Logger;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/texture/SimpleCubemapTexture.class */
public class SimpleCubemapTexture extends CubemapTexture implements VeilPreloadedTexture {
    private static final Logger LOGGER = LogUtils.getLogger();
    protected final ResourceLocation location;
    private CompletableFuture<TextureImage> imageFuture = null;

    public SimpleCubemapTexture(ResourceLocation location) {
        this.location = location;
    }

    @Override // foundry.veil.api.client.render.texture.VeilPreloadedTexture
    public CompletableFuture<?> preload(ResourceManager resourceManager, Executor backgroundExecutor) {
        if (this.imageFuture == null || this.imageFuture.isDone()) {
            this.imageFuture = CompletableFuture.supplyAsync(() -> {
                return TextureImage.load(resourceManager, this.location);
            }, backgroundExecutor);
        }
        return this.imageFuture;
    }

    public void load(@NotNull ResourceManager resourceManager) throws IOException {
        boolean blur;
        boolean clamp;
        TextureImage textureImages = getTextureImage(resourceManager);
        NativeImage image = textureImages.getImage();
        try {
            int width = image.getWidth();
            int height = image.getHeight();
            if (height != (width * 3) / 4) {
                throw new IOException("Expected cubemap image to be " + width + "x" + ((width * 3) / 4) + ". Was " + width + "x" + height);
            }
            TextureMetadataSection texturemetadatasection = textureImages.getTextureMetadata();
            if (texturemetadatasection != null) {
                blur = texturemetadatasection.isBlur();
                clamp = texturemetadatasection.isClamp();
            } else {
                blur = false;
                clamp = false;
            }
            setFilter(blur, clamp);
            if (!RenderSystem.isOnRenderThreadOrInit()) {
                RenderSystem.recordRenderCall(() -> {
                    loadImages(image);
                });
            } else {
                loadImages(image);
            }
            if (image != null) {
                image.close();
            }
        } catch (Throwable th) {
            if (image != null) {
                try {
                    image.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void loadImages(NativeImage image) {
        try {
            bind();
            GlStateManager._texParameter(34067, 33085, 0);
            GlStateManager._texParameter(34067, 33082, 0);
            GlStateManager._texParameter(34067, 33083, 0);
            GlStateManager._texParameter(34067, 34049, 0.0f);
            int tileSize = image.getWidth() / 4;
            PipelineNativeImageAccessor accessor = (PipelineNativeImageAccessor) image;
            accessor.invokeCheckAllocated();
            NativeImage.Format format = image.format();
            format.setUnpackPixelStoreState();
            long pixels = accessor.getPixels();
            GlStateManager._pixelStore(3314, image.getWidth());
            GlStateManager._pixelStore(3316, tileSize);
            GlStateManager._pixelStore(3315, 0);
            GL12C.glTexImage2D(getGlFace(Direction.UP), 0, 32856, tileSize, tileSize, 0, format.glFormat(), 5121, pixels);
            GlStateManager._pixelStore(3316, 0);
            GlStateManager._pixelStore(3315, tileSize);
            GL12C.glTexImage2D(getGlFace(Direction.WEST), 0, 32856, tileSize, tileSize, 0, format.glFormat(), 5121, pixels);
            GlStateManager._pixelStore(3316, tileSize);
            GlStateManager._pixelStore(3315, tileSize);
            GL12C.glTexImage2D(getGlFace(Direction.SOUTH), 0, 32856, tileSize, tileSize, 0, format.glFormat(), 5121, pixels);
            GlStateManager._pixelStore(3316, tileSize * 2);
            GlStateManager._pixelStore(3315, tileSize);
            GL12C.glTexImage2D(getGlFace(Direction.EAST), 0, 32856, tileSize, tileSize, 0, format.glFormat(), 5121, pixels);
            GlStateManager._pixelStore(3316, tileSize * 3);
            GlStateManager._pixelStore(3315, tileSize);
            GL12C.glTexImage2D(getGlFace(Direction.NORTH), 0, 32856, tileSize, tileSize, 0, format.glFormat(), 5121, pixels);
            GlStateManager._pixelStore(3316, tileSize);
            GlStateManager._pixelStore(3315, tileSize * 2);
            GL12C.glTexImage2D(getGlFace(Direction.DOWN), 0, 32856, tileSize, tileSize, 0, format.glFormat(), 5121, pixels);
            if (image != null) {
                image.close();
            }
        } catch (Throwable th) {
            if (image != null) {
                try {
                    image.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void reset(@NotNull TextureManager textureManager, @NotNull ResourceManager resourceManager, @NotNull ResourceLocation location, @NotNull Executor gameExecutor) {
        preload(resourceManager, Util.backgroundExecutor()).thenRunAsync(() -> {
            textureManager.register(location, this);
        }, gameExecutor);
    }

    protected TextureImage getTextureImage(ResourceManager resourceManager) {
        if (this.imageFuture != null) {
            TextureImage image = this.imageFuture.join();
            this.imageFuture = null;
            return image;
        }
        return TextureImage.load(resourceManager, this.location);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/texture/SimpleCubemapTexture$TextureImage.class */
    protected static class TextureImage implements Closeable {

        @Nullable
        private final TextureMetadataSection metadata;

        @Nullable
        private final NativeImage image;

        @Nullable
        private final IOException exception;

        public TextureImage(IOException exception) {
            this.exception = exception;
            this.metadata = null;
            this.image = null;
        }

        public TextureImage(@Nullable TextureMetadataSection metadata, NativeImage image) {
            this.exception = null;
            this.metadata = metadata;
            this.image = image;
        }

        public static TextureImage load(ResourceManager resourceManager, ResourceLocation location) {
            try {
                Resource resource = resourceManager.getResourceOrThrow(location);
                InputStream inputstream = resource.open();
                try {
                    NativeImage nativeimage = NativeImage.read(inputstream);
                    if (inputstream != null) {
                        inputstream.close();
                    }
                    TextureMetadataSection texturemetadatasection = null;
                    try {
                        texturemetadatasection = (TextureMetadataSection) resource.metadata().getSection(TextureMetadataSection.SERIALIZER).orElse(null);
                    } catch (RuntimeException runtimeexception) {
                        SimpleCubemapTexture.LOGGER.warn("Failed reading metadata of: {}", location, runtimeexception);
                    }
                    return new TextureImage(texturemetadatasection, nativeimage);
                } catch (Throwable th) {
                    if (inputstream != null) {
                        try {
                            inputstream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException ioexception) {
                return new TextureImage(ioexception);
            }
        }

        @Nullable
        public TextureMetadataSection getTextureMetadata() {
            return this.metadata;
        }

        public NativeImage getImage() throws IOException {
            if (this.exception != null) {
                throw this.exception;
            }
            return this.image;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.image != null) {
                this.image.close();
            }
        }

        public void throwIfError() throws IOException {
            if (this.exception != null) {
                throw this.exception;
            }
        }
    }
}
