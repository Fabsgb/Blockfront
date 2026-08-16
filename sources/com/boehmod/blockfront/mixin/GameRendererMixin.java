package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC1140um;
import com.boehmod.blockfront.C0035aE;
import com.boehmod.blockfront.C0623l;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mixin/GameRendererMixin.class */
@Mixin({GameRenderer.class})
public class GameRendererMixin {
    @Shadow
    private void bobView(PoseStack poseStack, float f) {
    }

    @Redirect(method = {"renderItemInHand"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GameRenderer;bobView(Lcom/mojang/blaze3d/vertex/PoseStack;F)V"))
    private void bf$skipBobViewForSkinnableItems(GameRenderer gameRenderer, PoseStack poseStack, float f) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer != null && (localPlayer.getMainHandItem().getItem() instanceof AbstractC1140um)) {
            return;
        }
        bobView(poseStack, f);
    }

    @ModifyArg(method = {"render"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/Overlay;render(Lnet/minecraft/client/gui/GuiGraphics;IIF)V"), index = 3)
    private float bf$fixOverlayPartialTick(float f) {
        return Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);
    }

    @ModifyArg(method = {"render"}, at = @At(value = "INVOKE", target = "Lnet/neoforged/neoforge/client/ClientHooks;drawScreen(Lnet/minecraft/client/gui/screens/Screen;Lnet/minecraft/client/gui/GuiGraphics;IIF)V"), index = 4)
    private float bf$fixScreenPartialTick(float f) {
        return Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);
    }

    @Inject(method = {"renderItemInHand"}, at = {@At("HEAD")})
    private void bf$applyWorldFogToHand(CallbackInfo callbackInfo) {
        if (C0035aE.f303ad < Float.MAX_VALUE) {
            RenderSystem.setShaderFogStart(C0035aE.f303ad);
            RenderSystem.setShaderFogEnd(C0035aE.f304ae);
            RenderSystem.setShaderFogColor(C0035aE.f305af, C0035aE.f306ag, C0035aE.f307ah, 1.0f);
            RenderSystem.setShaderFogShape(C0035aE.f308a);
        }
    }

    @Inject(method = {"renderItemInHand"}, at = {@At("RETURN")})
    private void bf$resetFogAfterHand(CallbackInfo callbackInfo) {
        if (C0035aE.f303ad < Float.MAX_VALUE) {
            FogRenderer.setupNoFog();
        }
    }

    @Inject(method = {"getDarkenWorldAmount(F)F"}, at = {@At("RETURN")}, cancellable = true)
    private void bf$composeWeatherDarkness(float f, CallbackInfoReturnable<Float> callbackInfoReturnable) {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null || (abstractC0863pbM2874a = c0623lM2852b.m2874a()) == null) {
            return;
        }
        float fM6130be = abstractC0863pbM2874a.m4089a().m6130be();
        if (fM6130be <= 0.0f) {
            return;
        }
        callbackInfoReturnable.setReturnValue(Float.valueOf(1.0f - ((1.0f - callbackInfoReturnable.getReturnValueF()) * (1.0f - fM6130be))));
    }
}
