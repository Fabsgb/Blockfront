package foundry.veil.api.client.util;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/util/TextureDownloader.class */
public final class TextureDownloader {
    private TextureDownloader() {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.concurrent.CompletableFuture<?> save(java.lang.String r7, java.nio.file.Path r8, int r9, boolean r10) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: foundry.veil.api.client.util.TextureDownloader.save(java.lang.String, java.nio.file.Path, int, boolean):java.util.concurrent.CompletableFuture");
    }

    public static CompletableFuture<?> save(String name, Path outputFolder, AbstractTexture texture, boolean flip) {
        return save(name, outputFolder, texture.getId(), flip);
    }

    public static CompletableFuture<?> save(String name, Path outputFolder, ResourceLocation texture, boolean flip) {
        AbstractTexture abstractTexture = Minecraft.getInstance().getTextureManager().getTexture(texture);
        return save(name, outputFolder, abstractTexture != null ? abstractTexture : MissingTextureAtlasSprite.getTexture(), flip);
    }
}
