package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCoin;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jc.class */
public class C0545jc extends C0546jd<CloudItemCoin> {
    @Override // com.boehmod.blockfront.C0546jd, com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2465a(@NotNull CloudItemCoin cloudItemCoin, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
        mo2466a(cloudItemCoin, cloudItemStack, poseStack, minecraft, guiGraphics, f, f2, f3, f4, f5);
    }

    @Override // com.boehmod.blockfront.C0546jd, com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2466a(@NotNull CloudItemCoin cloudItemCoin, @NotNull CloudItemStack cloudItemStack, @NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
        C0119bk.m440b(poseStack, guiGraphics, C0564jv.m2555d("textures/coins/" + cloudItemCoin.getSuffixForDisplay() + ".png"), f, f2, f3 * f5, f4 * f5);
    }

    @Override // com.boehmod.blockfront.C0546jd, com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2228a(@NotNull CloudItemCoin cloudItemCoin, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f) {
        C0239do.f1982dQ = 25.0f * ((-0.5f) + (i4 / i2));
        C0239do.f1983dR = 65.0f * ((-0.5f) + (i3 / i));
        C0119bk.m442b(poseStack, guiGraphics, C0564jv.m2555d("textures/coins/" + cloudItemCoin.getSuffixForDisplay() + ".png"), i / 2, (i2 / 2) - 8, 112.0f, 112.0f, 0.0f);
    }

    @Override // com.boehmod.blockfront.C0546jd, com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2227a(@NotNull CloudItemCoin cloudItemCoin, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3) {
        C0119bk.m442b(poseStack, guiGraphics, C0564jv.m2555d("textures/coins/" + cloudItemCoin.getSuffixForDisplay() + ".png"), i + (i3 / 2), (i2 + (i4 / 2)) - 7, 19.2f, 19.2f, 0.0f);
    }

    @Override // com.boehmod.blockfront.C0546jd, com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2226a(@NotNull CloudItemCoin cloudItemCoin, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        C0119bk.m442b(poseStack, guiGraphics, C0564jv.m2555d("textures/coins/" + cloudItemCoin.getSuffixForDisplay() + ".png"), i + (i3 / 2), (i2 + (i4 / 2)) - 3, 48.0f, 48.0f, 0.0f);
    }
}
