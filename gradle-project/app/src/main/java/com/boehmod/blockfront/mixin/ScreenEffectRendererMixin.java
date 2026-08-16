package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0623l;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mixin/ScreenEffectRendererMixin.class */
@Mixin({ScreenEffectRenderer.class})
public class ScreenEffectRendererMixin {
    @Inject(method = {"renderScreenEffect"}, at = {@At("HEAD")}, cancellable = true)
    private static void blockFrontAll$suppressDuringCinematic(Minecraft minecraft, PoseStack poseStack, CallbackInfo callbackInfo) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b != null && c0623lM2852b.m2895a().m3074aJ()) {
            callbackInfo.cancel();
        }
    }
}
