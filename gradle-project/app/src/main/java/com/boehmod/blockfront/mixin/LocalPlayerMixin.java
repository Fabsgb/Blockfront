package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0297l;
import com.boehmod.blockfront.oF;
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
        oF<?, ?, ?> oFVarM591a;
        C0297l c0297lB = C0297l.b();
        if (c0297lB != null && (oFVarM591a = c0297lB.m591a()) != null) {
            Player player = Minecraft.getInstance().player;
            if (!$assertionsDisabled && player == null) {
                throw new AssertionError();
            }
            if (!oFVarM591a.b().a(player, player.getMainHandItem())) {
                callbackInfoReturnable.setReturnValue(false);
            }
        }
    }
}
