package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC1062tO;
import com.boehmod.blockfront.C0079ax;
import com.boehmod.blockfront.C0622l;
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
        if (localPlayer != null && (localPlayer.getMainHandItem().getItem() instanceof AbstractC1062tO)) {
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
        if (C0079ax.f481Y < Float.MAX_VALUE) {
            RenderSystem.setShaderFogStart(C0079ax.f481Y);
            RenderSystem.setShaderFogEnd(C0079ax.f482Z);
            RenderSystem.setShaderFogColor(C0079ax.f483aa, C0079ax.f484ab, C0079ax.f485ac, 1.0f);
            RenderSystem.setShaderFogShape(C0079ax.f486a);
        }
    }

    @Inject(method = {"renderItemInHand"}, at = {@At("RETURN")})
    private void bf$resetFogAfterHand(CallbackInfo callbackInfo) {
        if (C0079ax.f481Y < Float.MAX_VALUE) {
            FogRenderer.setupNoFog();
        }
    }

    @Inject(method = {"getDarkenWorldAmount(F)F"}, at = {@At("RETURN")}, cancellable = true)
    private void bf$composeWeatherDarkness(float f, CallbackInfoReturnable<Float> callbackInfoReturnable) {
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null || (abstractC0787oFM2688a = c0622lM2667b.m2688a()) == null) {
            return;
        }
        float fM5642aY = abstractC0787oFM2688a.m3653a().m5642aY();
        if (fM5642aY <= 0.0f) {
            return;
        }
        callbackInfoReturnable.setReturnValue(Float.valueOf(1.0f - ((1.0f - callbackInfoReturnable.getReturnValueF()) * (1.0f - fM5642aY))));
    }
}
