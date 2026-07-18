package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.C0622l;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/LocalPlayerMixin.class */
@Mixin({LocalPlayer.class})
public class LocalPlayerMixin {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !LocalPlayerMixin.class.desiredAssertionStatus();
    }

    @Inject(method = {"drop(Z)Z"}, at = {@At("HEAD")}, cancellable = true)
    private void bf$preDrop(boolean z, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b != null && (abstractC0787oFM2688a = c0622lM2667b.m2688a()) != null) {
            Player player = Minecraft.getInstance().player;
            if (!$assertionsDisabled && player == null) {
                throw new AssertionError();
            }
            if (!abstractC0787oFM2688a.m3582b().mo3787a(player, player.getMainHandItem())) {
                callbackInfoReturnable.setReturnValue(false);
            }
        }
    }
}
