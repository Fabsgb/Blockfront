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

/* JADX INFO: renamed from: com.boehmod.blockfront.dy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dy.class */
public class C0249dy extends AbstractC0242dr {

    /* JADX INFO: renamed from: dW */
    private static float f2041dW;

    /* JADX INFO: renamed from: dY */
    private static float f2043dY;

    /* JADX INFO: renamed from: bF */
    private static final ResourceLocation f2036bF = C0564jv.m2555d("textures/gui/background/panorama/armory/panorama");

    /* JADX INFO: renamed from: bG */
    private static final ResourceLocation f2037bG = C0564jv.m2555d("textures/gui/background/smoke.png");

    /* JADX INFO: renamed from: bH */
    private static final ResourceLocation f2038bH = C0564jv.m2555d("textures/gui/background/smoke2.png");

    /* JADX INFO: renamed from: a */
    private static final CubeMap f2039a = new CubeMap(f2036bF);

    /* JADX INFO: renamed from: dV */
    private static float f2040dV = 0.0f;

    /* JADX INFO: renamed from: dX */
    private static float f2042dX = 0.0f;

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1410a(@NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull Minecraft minecraft, @NotNull C0195cx c0195cx, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        if (c0195cx instanceof C0239do) {
            poseStack.pushPose();
            RenderSystem.disableDepthTest();
            f2039a.render(minecraft, -C0239do.f1982dQ, -C0239do.f1983dR, 1.0f);
            RenderSystem.disableDepthTest();
            poseStack.popPose();
            C0119bk.m526b(minecraft, f2);
        }
        if (minecraft.level == null) {
            float fM7843e = C1290xm.m7843e(f2040dV, f2041dW, f2);
            float fSin = Mth.sin(f / 100.0f);
            float fSin2 = Mth.sin(f / 120.0f);
            float fM7843e2 = C1290xm.m7843e(f2042dX, f2043dY, f2);
            poseStack.pushPose();
            poseStack.scale(1.6f, 1.6f, 1.6f);
            float f3 = 20.0f * fSin;
            C0119bk.m432a(poseStack, guiGraphics, f2037bG, fM7843e, f3, i, i2, 0.1f);
            C0119bk.m434a(poseStack, guiGraphics, f2037bG, fM7843e + i, f3, i, i2, 0.0f, 0.1f);
            float f4 = 20.0f * fSin2;
            C0119bk.m434a(poseStack, guiGraphics, f2038bH, fM7843e2, f4, i, i2, 0.0f, 0.1f);
            C0119bk.m434a(poseStack, guiGraphics, f2038bH, fM7843e2 - i, f4, i, i2, 0.0f, 0.1f);
            poseStack.popPose();
            C0119bk.m417a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 0.15f * c0622l.m2699a().m2596c(f2));
            C0119bk.m433a(poseStack, guiGraphics, C0239do.f1570aN, 0, 0, i, i2, 0.5f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1411a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0482iS c0482iS, @NotNull C0195cx c0195cx, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1412a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0195cx c0195cx, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1413a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0195cx c0195cx, float f) {
        if (f2040dV > (-c0195cx.width)) {
            f2041dW = f2040dV;
            f2040dV -= 1.0f;
        } else {
            f2041dW = 0.0f;
            f2040dV = 0.0f;
        }
        if (f2042dX < c0195cx.width) {
            f2043dY = f2042dX;
            f2042dX += 0.4f;
        } else {
            f2043dY = 0.0f;
            f2042dX = 0.0f;
        }
    }
}
