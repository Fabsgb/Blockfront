package foundry.veil.mixin.debug.client;

import foundry.veil.Veil;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/debug/client/DebugMinecraftMixin.class */
@Mixin({Minecraft.class})
public class DebugMinecraftMixin {
    @ModifyArg(method = {"<init>"}, at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;initRenderer(IZ)V", remap = false), index = 0)
    private int modifyDebugVerbosity(int debugVerbosity) {
        if (Veil.DEBUG) {
            return 100;
        }
        return debugVerbosity;
    }

    @ModifyArg(method = {"<init>"}, at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;initRenderer(IZ)V", remap = false), index = 1)
    private boolean modifySynchronousDebug(boolean synchronous) {
        return synchronous || Veil.DEBUG;
    }
}
