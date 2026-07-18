package software.bernie.geckolib.cache.texture;

import com.mojang.blaze3d.pipeline.RenderCall;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.platform.TextureUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibServices;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/cache/texture/GeoAbstractTexture.class */
public abstract class GeoAbstractTexture extends AbstractTexture {
    @Nullable
    protected abstract RenderCall loadTexture(ResourceManager resourceManager, Minecraft minecraft) throws IOException;

    protected static void generateTexture(ResourceLocation texturePath, Consumer<TextureManager> textureManagerConsumer) {
        if (!RenderSystem.isOnRenderThreadOrInit()) {
            throw new IllegalThreadStateException("Texture loading called outside of the render thread! This should DEFINITELY not be happening.");
        }
        TextureManager textureManager = Minecraft.getInstance().getTextureManager();
        if (!(textureManager.getTexture(texturePath, MissingTextureAtlasSprite.getTexture()) instanceof GeoAbstractTexture)) {
            textureManagerConsumer.accept(textureManager);
        }
    }

    public final void load(ResourceManager resourceManager) throws IOException {
        RenderCall renderCall = loadTexture(resourceManager, Minecraft.getInstance());
        if (renderCall == null) {
            return;
        }
        if (!RenderSystem.isOnRenderThreadOrInit()) {
            RenderSystem.recordRenderCall(renderCall);
        } else {
            renderCall.execute();
        }
    }

    protected void printDebugImageToDisk(ResourceLocation id, NativeImage newImage) {
        try {
            File file = new File(GeckoLibServices.PLATFORM.getGameDir().toFile(), "GeoTexture Debug Printouts");
            if (!file.exists()) {
                file.mkdirs();
            } else if (!file.isDirectory()) {
                file.delete();
                file.mkdirs();
            }
            File file2 = new File(file, id.getPath().replace('/', '.'));
            if (!file2.exists()) {
                file2.createNewFile();
            }
            newImage.writeToFile(file2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void uploadSimple(int texture, NativeImage image, boolean blur, boolean clamp) {
        TextureUtil.prepareImage(texture, 0, image.getWidth(), image.getHeight());
        image.upload(0, 0, 0, 0, 0, image.getWidth(), image.getHeight(), blur, clamp, false, true);
    }

    public static ResourceLocation appendToPath(ResourceLocation location, String suffix) {
        String path = location.getPath();
        int i = path.lastIndexOf(46);
        return ResourceLocation.fromNamespaceAndPath(location.getNamespace(), path.substring(0, i) + suffix + path.substring(i));
    }
}
