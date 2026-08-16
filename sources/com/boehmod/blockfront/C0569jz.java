package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemPrestigeCard;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jz.class */
public class C0569jz extends C0566jw<CloudItemPrestigeCard> {
    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2311a(@NotNull CloudItemPrestigeCard cloudItemPrestigeCard, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
        mo2310a(cloudItemPrestigeCard, cloudItemStack, poseStack, minecraft, guiGraphics, f, f2, f3, f4, 0.5f);
    }

    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2310a(@NotNull CloudItemPrestigeCard cloudItemPrestigeCard, @NotNull CloudItemStack cloudItemStack, @NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
        C0129bt.m601b(poseStack, guiGraphics, C0556jm.m2530a(cloudItemPrestigeCard, cloudItemStack), f, f2, f5);
    }

    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2304a(@NotNull CloudItemPrestigeCard cloudItemPrestigeCard, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f) {
        float guiScale = (float) (3.0d * minecraft.getWindow().getGuiScale());
        poseStack.pushPose();
        poseStack.translate(0.0f, -15.0f, 150.0f);
        C0249dx.f2046dT = 25.0f * ((-0.5f) + (i4 / i2));
        C0249dx.f2047dU = 65.0f * ((-0.5f) + (i3 / i));
        C0129bt.m601b(poseStack, guiGraphics, C0556jm.m2530a(cloudItemPrestigeCard, cloudItemStack), i / 2, i2 / 2, guiScale);
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2303a(@NotNull CloudItemPrestigeCard cloudItemPrestigeCard, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3) {
        C0129bt.m601b(poseStack, guiGraphics, C0556jm.m2530a(cloudItemPrestigeCard, cloudItemStack), i + (i3 / 2), (i2 + (i4 / 2)) - 8, 1.2f);
    }

    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2302a(@NotNull CloudItemPrestigeCard cloudItemPrestigeCard, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        C0129bt.m601b(poseStack, guiGraphics, C0556jm.m2530a(cloudItemPrestigeCard, cloudItemStack), i + (i3 / 2), (i2 + (i4 / 2)) - 4, 3.5f);
    }
}
