package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCallingCard;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jr.class */
public class C0561jr extends C0566jw<CloudItemCallingCard> {
    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2304a(@NotNull CloudItemCallingCard cloudItemCallingCard, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f) {
        int i5 = i / 2;
        ResourceLocation resourceLocationM2378d = C0532jO.m2378d("textures/gui/callingcard/" + cloudItemCallingCard.getSuffixForDisplay() + ".png");
        C0129bt.m592c(poseStack, guiGraphics, (i5 + 3) - 110.0f, 85.0f, 220.0f, 50.0f, 0, 0.5f);
        C0129bt.m540b(poseStack, guiGraphics, resourceLocationM2378d, i5 + 3, 110.0f, 220.0f, 50.0f);
    }

    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2303a(@NotNull CloudItemCallingCard cloudItemCallingCard, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3) {
        int i7 = i3 / 2;
        int i8 = i4 / 2;
        ResourceLocation resourceLocationM2378d = C0532jO.m2378d("textures/gui/callingcard/" + cloudItemCallingCard.getSuffixForDisplay() + ".png");
        C0129bt.m589b(poseStack, guiGraphics, f + i7, (i2 + i8) - 8, 40.0f, 10.0f, 0, 0.0f);
        C0129bt.m542b(poseStack, guiGraphics, resourceLocationM2378d, f + i7, (i2 + i8) - 8, 40.0f, 10.0f, 0.0f);
    }

    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2302a(@NotNull CloudItemCallingCard cloudItemCallingCard, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        ResourceLocation resourceLocationM2378d = C0532jO.m2378d("textures/gui/callingcard/" + cloudItemCallingCard.getSuffixForDisplay() + ".png");
        float f2 = i + (i3 / 2);
        float f3 = (i2 + (i4 / 2)) - 2;
        C0129bt.m590b(poseStack, guiGraphics, f2 - 90.0f, f3 - 22.5f, 180.0f, 45.0f, C0129bt.m465t());
        C0129bt.m540b(poseStack, guiGraphics, resourceLocationM2378d, f2, f3, 180.0f, 45.0f);
    }
}
