package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0169gf;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/LevelRendererMixin.class */
@Mixin({LevelRenderer.class})
public class LevelRendererMixin {

    @Shadow
    private ClientLevel level;

    @Shadow
    private int ticks;

    @Inject(method = {"renderClouds(Lcom/mojang/blaze3d/vertex/PoseStack;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;FDDD)V"}, at = {@At("HEAD")}, cancellable = true)
    private void bf$replaceRenderClouds(PoseStack poseStack, Matrix4f matrix4f, Matrix4f matrix4f2, float f, double d, double d2, double d3, CallbackInfo callbackInfo) {
        if (C0169gf.a(Minecraft.getInstance(), this.level, this.ticks, poseStack, matrix4f, matrix4f2, f, d, d2, d3)) {
            callbackInfo.cancel();
        }
    }
}
