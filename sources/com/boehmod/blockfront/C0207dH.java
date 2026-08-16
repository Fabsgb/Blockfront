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

/* JADX INFO: renamed from: com.boehmod.blockfront.dH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dH.class */
public class C0207dH extends AbstractC0200dA {

    /* JADX INFO: renamed from: dZ */
    private static float f1606dZ;

    /* JADX INFO: renamed from: eb */
    private static float f1608eb;

    /* JADX INFO: renamed from: bD */
    private static final ResourceLocation f1601bD = C0532jO.m2378d("textures/gui/background/panorama/armory/panorama");

    /* JADX INFO: renamed from: bE */
    private static final ResourceLocation f1602bE = C0532jO.m2378d("textures/gui/background/smoke.png");

    /* JADX INFO: renamed from: bF */
    private static final ResourceLocation f1603bF = C0532jO.m2378d("textures/gui/background/smoke2.png");

    /* JADX INFO: renamed from: a */
    private static final CubeMap f1604a = new CubeMap(f1601bD);

    /* JADX INFO: renamed from: dY */
    private static float f1605dY = 0.0f;

    /* JADX INFO: renamed from: ea */
    private static float f1607ea = 0.0f;

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1236a(@NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull Minecraft minecraft, @NotNull C0143cG c0143cG, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        if (c0143cG instanceof C0249dx) {
            poseStack.pushPose();
            RenderSystem.disableDepthTest();
            f1604a.render(minecraft, -C0249dx.f2046dT, -C0249dx.f2047dU, 1.0f);
            RenderSystem.disableDepthTest();
            poseStack.popPose();
            C0129bt.m628b(minecraft, f2);
        }
        if (minecraft.level == null) {
            float fM7170f = C1270xJ.m7170f(f1605dY, f1606dZ, f2);
            float fSin = Mth.sin(f / 100.0f);
            float fSin2 = Mth.sin(f / 120.0f);
            float fM7170f2 = C1270xJ.m7170f(f1607ea, f1608eb, f2);
            poseStack.pushPose();
            poseStack.scale(1.6f, 1.6f, 1.6f);
            float f3 = 20.0f * fSin;
            C0129bt.m532a(poseStack, guiGraphics, f1602bE, fM7170f, f3, i, i2, 0.1f);
            C0129bt.m534a(poseStack, guiGraphics, f1602bE, fM7170f + i, f3, i, i2, 0.0f, 0.1f);
            float f4 = 20.0f * fSin2;
            C0129bt.m534a(poseStack, guiGraphics, f1603bF, fM7170f2, f4, i, i2, 0.0f, 0.1f);
            C0129bt.m534a(poseStack, guiGraphics, f1603bF, fM7170f2 - i, f4, i, i2, 0.0f, 0.1f);
            poseStack.popPose();
            C0129bt.m517a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 0.15f * c0623l.m2885a().m2585c(f2));
            C0129bt.m533a(poseStack, guiGraphics, C0249dx.f1043aN, 0, 0, i, i2, 0.5f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1237a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0555jl c0555jl, @NotNull C0143cG c0143cG, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1238a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0143cG c0143cG, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1239a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0143cG c0143cG, float f) {
        if (f1605dY > (-c0143cG.width)) {
            f1606dZ = f1605dY;
            f1605dY -= 1.0f;
        } else {
            f1606dZ = 0.0f;
            f1605dY = 0.0f;
        }
        if (f1607ea < c0143cG.width) {
            f1608eb = f1607ea;
            f1607ea += 0.4f;
        } else {
            f1608eb = 0.0f;
            f1607ea = 0.0f;
        }
    }
}
