package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C1154v;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mixin/MouseHandlerMixin.class */
@Mixin({MouseHandler.class})
public class MouseHandlerMixin {

    @Shadow
    @Final
    private Minecraft minecraft;

    @Unique
    private LocalPlayer bf$turnPlayer;

    @Unique
    private float bf$turnYaw;

    @Unique
    private float bf$turnPitch;

    @Inject(method = {"handleAccumulatedMovement"}, at = {@At("HEAD")})
    private void bf$captureRotationBefore(CallbackInfo callbackInfo) {
        LocalPlayer localPlayer = this.minecraft.player;
        this.bf$turnPlayer = localPlayer;
        if (localPlayer != null) {
            this.bf$turnYaw = localPlayer.getYRot();
            this.bf$turnPitch = localPlayer.getXRot();
        }
    }

    @Inject(method = {"handleAccumulatedMovement"}, at = {@At("RETURN")})
    private void bf$creditRotationAfter(CallbackInfo callbackInfo) {
        LocalPlayer localPlayer = this.bf$turnPlayer;
        this.bf$turnPlayer = null;
        if (localPlayer == null || localPlayer != this.minecraft.player) {
            return;
        }
        C1154v.m6580a(localPlayer.getYRot() - this.bf$turnYaw, localPlayer.getXRot() - this.bf$turnPitch);
    }
}
