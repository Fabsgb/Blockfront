package foundry.veil.forge.platform;

import foundry.veil.api.network.VeilPacketManager;
import foundry.veil.forge.network.NeoForgeVeilPacketManager;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/platform/NeoForgeVeilPacketManagerFactory.class */
@ApiStatus.Internal
public class NeoForgeVeilPacketManagerFactory implements VeilPacketManager.Factory {
    @Override // foundry.veil.api.network.VeilPacketManager.Factory
    public VeilPacketManager create(String modId, String version) {
        return new NeoForgeVeilPacketManager(modId, version);
    }
}
