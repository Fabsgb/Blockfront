package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.CubeMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dy.class */
public class C0107dy extends AbstractC0100dr {
    private static float dW;
    private static float dY;
    private static final ResourceLocation bF = C0265jv.d("textures/gui/background/panorama/armory/panorama");
    private static final ResourceLocation bG = C0265jv.d("textures/gui/background/smoke.png");
    private static final ResourceLocation bH = C0265jv.d("textures/gui/background/smoke2.png");
    private static final CubeMap a = new CubeMap(bF);
    private static float dV = 0.0f;
    private static float dX = 0.0f;

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull Minecraft minecraft, @NotNull C0080cx c0080cx, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        if (c0080cx instanceof Cdo) {
            poseStack.pushPose();
            RenderSystem.disableDepthTest();
            a.render(minecraft, -Cdo.dQ, -Cdo.dR, 1.0f);
            RenderSystem.disableDepthTest();
            poseStack.popPose();
            C0040bk.b(minecraft, f2);
        }
        if (minecraft.level == null) {
            float fE = C0634xm.e(dV, dW, f2);
            float fSin = Mth.sin(f / 100.0f);
            float fSin2 = Mth.sin(f / 120.0f);
            float fE2 = C0634xm.e(dX, dY, f2);
            poseStack.pushPose();
            poseStack.scale(1.6f, 1.6f, 1.6f);
            float f3 = 20.0f * fSin;
            C0040bk.a(poseStack, guiGraphics, bG, fE, f3, i, i2, 0.1f);
            C0040bk.a(poseStack, guiGraphics, bG, fE + i, f3, i, i2, 0.0f, 0.1f);
            float f4 = 20.0f * fSin2;
            C0040bk.a(poseStack, guiGraphics, bH, fE2, f4, i, i2, 0.0f, 0.1f);
            C0040bk.a(poseStack, guiGraphics, bH, fE2 - i, f4, i, i2, 0.0f, 0.1f);
            poseStack.popPose();
            C0040bk.a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 0.15f * c0297l.m596a().c(f2));
            C0040bk.a(poseStack, guiGraphics, Cdo.aN, 0, 0, i, i2, 0.5f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, iS iSVar, @NotNull C0080cx c0080cx, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull C0080cx c0080cx, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull C0080cx c0080cx, float f) {
        if (dV > (-c0080cx.width)) {
            dW = dV;
            dV -= 1.0f;
        } else {
            dW = 0.0f;
            dV = 0.0f;
        }
        if (dX < c0080cx.width) {
            dY = dX;
            dX += 0.4f;
        } else {
            dY = 0.0f;
            dX = 0.0f;
        }
    }
}
