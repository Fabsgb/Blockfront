package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemSticker;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jh.class */
public class C0251jh extends C0247jd<CloudItemSticker> {
    @Override // com.boehmod.blockfront.C0247jd, com.boehmod.blockfront.AbstractC0244ja
    public void a(@NotNull CloudItemSticker cloudItemSticker, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f) {
        C0040bk.b(poseStack, guiGraphics, C0265jv.d("textures/stickers/" + cloudItemSticker.getSuffixForDisplay() + ".png"), i / 2, i2 / 2, 150.0f * 0.75f, 150.0f * 0.75f);
    }

    @Override // com.boehmod.blockfront.C0247jd, com.boehmod.blockfront.AbstractC0244ja
    public void a(@NotNull CloudItemSticker cloudItemSticker, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3) {
        poseStack.pushPose();
        C0040bk.b(poseStack, guiGraphics, C0265jv.d("textures/stickers/" + cloudItemSticker.getSuffixForDisplay() + ".png"), f + (i3 / 2), (i2 + (i4 / 2)) - 7, 22.0f, 22.0f, 0.0f);
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.C0247jd, com.boehmod.blockfront.AbstractC0244ja
    public void a(@NotNull CloudItemSticker cloudItemSticker, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        poseStack.pushPose();
        C0040bk.b(poseStack, guiGraphics, C0265jv.d("textures/stickers/" + cloudItemSticker.getSuffixForDisplay() + ".png"), i + (i3 / 2), (i2 + (i4 / 2)) - 4, 57.0f, 57.0f, 0.0f, 6.0f);
        poseStack.popPose();
    }
}
