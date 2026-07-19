package foundry.veil.mixin.debug;

import foundry.veil.Veil;
import net.minecraft.server.packs.resources.SimpleReloadInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/debug/SimpleReloadInstanceMixin.class */
@Mixin({SimpleReloadInstance.class})
public class SimpleReloadInstanceMixin {
    @ModifyVariable(method = {"create"}, at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static boolean create(boolean debug) {
        return debug || Veil.DEBUG;
    }
}
