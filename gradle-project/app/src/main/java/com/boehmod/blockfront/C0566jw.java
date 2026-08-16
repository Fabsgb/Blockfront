package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jw.class */
public class C0566jw<T extends CloudItem<?>> extends AbstractC0563jt<T> {

    /* JADX INFO: renamed from: hC */
    private static final float f3323hC = 3.0f;

    /* JADX INFO: renamed from: hD */
    private static final float f3324hD = 1.5f;

    @Override // com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a */
    public void mo2311a(@NotNull T t, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
    }

    @Override // com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a */
    public void mo2310a(@NotNull T t, @NotNull CloudItemStack cloudItemStack, @NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
    }

    @Override // com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a */
    public void mo2304a(@NotNull T t, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f) {
        C0129bt.m601b(poseStack, guiGraphics, C0556jm.m2530a(t, cloudItemStack), i / 2, (i2 / 2) - 10.0f, 6.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a */
    public void mo2303a(@NotNull T t, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3) {
        float fMo2563aa = mo2563aa();
        ItemStack itemStackM2530a = C0556jm.m2530a(t, cloudItemStack);
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, mo2562Z());
        C0129bt.m601b(poseStack, guiGraphics, itemStackM2530a, f + (i3 / 2), (i2 + (i4 / 2)) - 7.5f, fMo2563aa);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: Z */
    protected float mo2562Z() {
        return 0.0f;
    }

    /* JADX INFO: renamed from: aa */
    protected float mo2563aa() {
        return 1.5f;
    }

    @Override // com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a */
    public void mo2302a(@NotNull T t, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        C0129bt.m601b(poseStack, guiGraphics, C0556jm.m2530a(t, cloudItemStack), (i + (i3 / 2)) - 4.0f, i2 + (i4 / 2), mo2564ab());
    }

    /* JADX INFO: renamed from: ab */
    protected float mo2564ab() {
        return 3.0f;
    }
}
