package foundry.veil.ext;

import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/ext/RenderTargetExtension.class */
@ApiStatus.Internal
public interface RenderTargetExtension {
    void veil$setWrapper(@Nullable AdvancedFbo advancedFbo);

    int veil$getTexture(int i);
}
