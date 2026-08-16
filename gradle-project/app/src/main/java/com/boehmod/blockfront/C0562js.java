package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCape;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.js */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/js.class */
public class C0562js extends C0566jw<CloudItemCape> {
    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2303a(@NotNull CloudItemCape cloudItemCape, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3) {
        ResourceLocation resourceLocationM2378d = C0532jO.m2378d("textures/models/capes/" + cloudItemCape.getSuffixForDisplay() + ".png");
        C0249dx.f2046dT = 25.0f * ((-0.5f) + (i6 / i4));
        C0249dx.f2047dU = 65.0f * ((-0.5f) + (i5 / i3));
        C0129bt.m642B();
        guiGraphics.blit(resourceLocationM2378d, (i + (i3 / 2)) - 5, i2 + 4, 1.0f, 0.0f, 10, 17, 64, 32);
    }

    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2302a(@NotNull CloudItemCape cloudItemCape, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        poseStack.pushPose();
        poseStack.translate((i + (i3 / 2)) - 4, i2 + (i4 / 2) + 15, 0.0f);
        poseStack.pushPose();
        C0129bt.m642B();
        guiGraphics.blit(C0532jO.m2378d("textures/models/capes/" + cloudItemCape.getSuffixForDisplay() + ".png"), -10, -55, 3.0f, 0.0f, 30, 51, 192, 96);
        poseStack.popPose();
        poseStack.popPose();
    }
}
