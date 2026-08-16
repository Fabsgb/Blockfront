package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCoin;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jv.class */
public class C0565jv extends C0566jw<CloudItemCoin> {
    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2311a(@NotNull CloudItemCoin cloudItemCoin, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
        mo2310a(cloudItemCoin, cloudItemStack, poseStack, minecraft, guiGraphics, f, f2, f3, f4, f5);
    }

    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2310a(@NotNull CloudItemCoin cloudItemCoin, @NotNull CloudItemStack cloudItemStack, @NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
        C0129bt.m540b(poseStack, guiGraphics, C0532jO.m2378d("textures/coins/" + cloudItemCoin.getSuffixForDisplay() + ".png"), f, f2, f3 * f5, f4 * f5);
    }

    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2304a(@NotNull CloudItemCoin cloudItemCoin, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f) {
        C0249dx.f2046dT = 25.0f * ((-0.5f) + (i4 / i2));
        C0249dx.f2047dU = 65.0f * ((-0.5f) + (i3 / i));
        C0129bt.m542b(poseStack, guiGraphics, C0532jO.m2378d("textures/coins/" + cloudItemCoin.getSuffixForDisplay() + ".png"), i / 2, (i2 / 2) - 8, 112.0f, 112.0f, 0.0f);
    }

    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2303a(@NotNull CloudItemCoin cloudItemCoin, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3) {
        C0129bt.m542b(poseStack, guiGraphics, C0532jO.m2378d("textures/coins/" + cloudItemCoin.getSuffixForDisplay() + ".png"), i + (i3 / 2), (i2 + (i4 / 2)) - 7, 19.2f, 19.2f, 0.0f);
    }

    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2302a(@NotNull CloudItemCoin cloudItemCoin, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        C0129bt.m542b(poseStack, guiGraphics, C0532jO.m2378d("textures/coins/" + cloudItemCoin.getSuffixForDisplay() + ".png"), i + (i3 / 2), (i2 + (i4 / 2)) - 3, 48.0f, 48.0f, 0.0f);
    }
}
