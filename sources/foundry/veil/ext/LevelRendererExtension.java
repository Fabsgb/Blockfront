package foundry.veil.ext;

import foundry.veil.api.client.render.CullFrustum;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/ext/LevelRendererExtension.class */
@ApiStatus.Internal
public interface LevelRendererExtension extends LevelRendererBlockLayerExtension {
    void veil$markChunksDirty();

    CullFrustum veil$getCullFrustum();
}
