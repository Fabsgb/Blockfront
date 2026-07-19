package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0026ax;
import com.boehmod.blockfront.C0297l;
import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.tO;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/GameRendererMixin.class */
@Mixin({GameRenderer.class})
public class GameRendererMixin {
    @Shadow
    private void bobView(PoseStack poseStack, float f) {
    }

    @Redirect(method = {"renderItemInHand"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GameRenderer;bobView(Lcom/mojang/blaze3d/vertex/PoseStack;F)V"))
    private void bf$skipBobViewForSkinnableItems(GameRenderer gameRenderer, PoseStack poseStack, float f) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer != null && (localPlayer.getMainHandItem().getItem() instanceof tO)) {
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
        if (C0026ax.Y < Float.MAX_VALUE) {
            RenderSystem.setShaderFogStart(C0026ax.Y);
            RenderSystem.setShaderFogEnd(C0026ax.Z);
            RenderSystem.setShaderFogColor(C0026ax.aa, C0026ax.ab, C0026ax.ac, 1.0f);
            RenderSystem.setShaderFogShape(C0026ax.a);
        }
    }

    @Inject(method = {"renderItemInHand"}, at = {@At("RETURN")})
    private void bf$resetFogAfterHand(CallbackInfo callbackInfo) {
        if (C0026ax.Y < Float.MAX_VALUE) {
            FogRenderer.setupNoFog();
        }
    }

    @Inject(method = {"getDarkenWorldAmount(F)F"}, at = {@At("RETURN")}, cancellable = true)
    private void bf$composeWeatherDarkness(float f, CallbackInfoReturnable<Float> callbackInfoReturnable) {
        oF<?, ?, ?> oFVarM591a;
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null || (oFVarM591a = c0297lB.m591a()) == null) {
            return;
        }
        float fAY = oFVarM591a.m767a().aY();
        if (fAY <= 0.0f) {
            return;
        }
        callbackInfoReturnable.setReturnValue(Float.valueOf(1.0f - ((1.0f - callbackInfoReturnable.getReturnValueF()) * (1.0f - fAY))));
    }
}
