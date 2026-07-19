package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0297l;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/ScreenEffectRendererMixin.class */
@Mixin({ScreenEffectRenderer.class})
public class ScreenEffectRendererMixin {
    @Inject(method = {"renderScreenEffect"}, at = {@At("HEAD")}, cancellable = true)
    private static void blockFrontAll$suppressDuringCinematic(Minecraft minecraft, PoseStack poseStack, CallbackInfo callbackInfo) {
        C0297l c0297lB = C0297l.b();
        if (c0297lB != null && c0297lB.m602a().ay()) {
            callbackInfo.cancel();
        }
    }
}
