package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0485iU;
import com.boehmod.blockfront.C0623l;
import net.minecraft.ChatFormatting;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mixin/KeyboardHandlerMixin.class */
@Mixin({KeyboardHandler.class})
public class KeyboardHandlerMixin {

    @Unique
    private static final Component BF$COMPONENT_MESSAGE_DEBUG_COMBO = Component.translatable("bf.message.debug.combo").withStyle(ChatFormatting.RED);

    @Unique
    private static final long BF$MESSAGE_COOLDOWN_MS = 1000;

    @Shadow
    private long debugCrashKeyTime;

    @Unique
    private long bf$lastBlockedMessageTime = 0;

    @Unique
    private static boolean bf$isDebugBlocked() {
        C0623l c0623lM2852b;
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        return (localPlayer == null || localPlayer.isCreative() || (c0623lM2852b = C0623l.m2852b()) == null || c0623lM2852b.m2878a() == null) ? false : true;
    }

    @Inject(method = {"handleDebugKeys"}, at = {@At("HEAD")}, cancellable = true)
    private void bf$blockDebugCombos(int i, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (bf$isDebugBlocked()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.bf$lastBlockedMessageTime >= BF$MESSAGE_COOLDOWN_MS) {
                this.bf$lastBlockedMessageTime = jCurrentTimeMillis;
                C0485iU.m2172c(Minecraft.getInstance(), BF$COMPONENT_MESSAGE_DEBUG_COMBO);
            }
            callbackInfoReturnable.setReturnValue(true);
        }
    }

    @Inject(method = {"tick"}, at = {@At("HEAD")})
    private void bf$disarmDebugCrash(CallbackInfo callbackInfo) {
        if (this.debugCrashKeyTime > 0 && bf$isDebugBlocked()) {
            this.debugCrashKeyTime = -1L;
        }
    }
}
