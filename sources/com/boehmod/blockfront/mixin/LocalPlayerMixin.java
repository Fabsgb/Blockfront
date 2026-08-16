package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.C0623l;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mixin/LocalPlayerMixin.class */
@Mixin({LocalPlayer.class})
public class LocalPlayerMixin {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !LocalPlayerMixin.class.desiredAssertionStatus();
    }

    @Inject(method = {"drop(Z)Z"}, at = {@At("HEAD")}, cancellable = true)
    private void bf$preDrop(boolean z, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b != null && (abstractC0863pbM2874a = c0623lM2852b.m2874a()) != null) {
            Player player = Minecraft.getInstance().player;
            if (!$assertionsDisabled && player == null) {
                throw new AssertionError();
            }
            if (!abstractC0863pbM2874a.m4018b().mo4223a(player, player.getMainHandItem())) {
                callbackInfoReturnable.setReturnValue(false);
            }
        }
    }
}
