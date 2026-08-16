package foundry.veil.api.client.util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.stb.STBImageWrite;
import org.lwjgl.system.MemoryUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/util/TextureDownloader.class */
public final class TextureDownloader {
    private TextureDownloader() {
    }

    public static CompletableFuture<?> save(String name, Path outputFolder, int texture, boolean flip) {
        GL11C.glBindTexture(3553, texture);
        int base = GL11C.glGetTexParameteri(3553, 33084);
        int max = GL11C.glGetTexParameteri(3553, 33085);
        if (max == 1000) {
            max = 0;
        }
        List<CompletableFuture<?>> result = new ArrayList<>((max - base) + 1);
        for (int level = base; level <= max; level++) {
            Path outputFile = outputFolder.resolve(name + (base == max ? "" : "-" + level) + ".png");
            if (!Files.exists(outputFile, new LinkOption[0])) {
                try {
                    Files.createFile(outputFile, new FileAttribute[0]);
                } catch (Exception e) {
                    result.add(CompletableFuture.failedFuture(e));
                }
            }
            int width = GL11C.glGetTexLevelParameteri(3553, level, 4096);
            int height = GL11C.glGetTexLevelParameteri(3553, level, 4097);
            int format = GL11C.glGetTexLevelParameteri(3553, level, 4099);
            boolean floating = format == 6402;
            int components = floating ? 1 : 4;
            ByteBuffer image = MemoryUtil.memAlloc(width * height * components);
            GL11C.glGetTexImage(3553, level, floating ? 6402 : 6408, 5121, image);
            CompletableFuture<?> future = CompletableFuture.runAsync(() -> {
                if (flip) {
                    STBImageWrite.stbi_flip_vertically_on_write(true);
                }
                boolean success = STBImageWrite.stbi_write_png(outputFile.toString(), width, height, components, image, 0);
                if (flip) {
                    STBImageWrite.stbi_flip_vertically_on_write(false);
                }
                MemoryUtil.memFree(image);
                if (!success) {
                    throw new CompletionException(new IOException("Failed to write image to: " + String.valueOf(outputFile)));
                }
            }, Util.ioPool());
            result.add(future);
        }
        return CompletableFuture.allOf((CompletableFuture[]) result.toArray(x$0 -> {
            return new CompletableFuture[x$0];
        }));
    }

    public static CompletableFuture<?> save(String name, Path outputFolder, AbstractTexture texture, boolean flip) {
        return save(name, outputFolder, texture.getId(), flip);
    }

    public static CompletableFuture<?> save(String name, Path outputFolder, ResourceLocation texture, boolean flip) {
        AbstractTexture abstractTexture = Minecraft.getInstance().getTextureManager().getTexture(texture);
        return save(name, outputFolder, abstractTexture != null ? abstractTexture : MissingTextureAtlasSprite.getTexture(), flip);
    }
}
