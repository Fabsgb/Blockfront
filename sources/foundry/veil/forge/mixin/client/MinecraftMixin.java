package foundry.veil.forge.mixin.client;

import foundry.veil.forge.event.ForgeFreeNativeResourcesEvent;
import net.minecraft.client.Minecraft;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/client/MinecraftMixin.class */
@Mixin({Minecraft.class})
public class MinecraftMixin {
    @Inject(method = {"close"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/Util;shutdownExecutors()V", shift = At.Shift.BEFORE)})
    public void close(CallbackInfo ci) {
        NeoForge.EVENT_BUS.post(new ForgeFreeNativeResourcesEvent());
    }
}
