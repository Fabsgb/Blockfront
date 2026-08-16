package foundry.veil.ext;

import foundry.veil.api.client.render.texture.VeilPreloadedTexture;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/ext/TextureManagerExtension.class */
public interface TextureManagerExtension {
    <T extends AbstractTexture & VeilPreloadedTexture> CompletableFuture<?> veil$registerPreloadedTexture(ResourceLocation resourceLocation, T t, Executor executor);
}
