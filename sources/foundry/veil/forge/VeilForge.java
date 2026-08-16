package foundry.veil.forge;

import foundry.veil.Veil;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/VeilForge.class */
@Mod(Veil.MODID)
@ApiStatus.Internal
public class VeilForge {
    public VeilForge() {
        Veil.init();
    }
}
