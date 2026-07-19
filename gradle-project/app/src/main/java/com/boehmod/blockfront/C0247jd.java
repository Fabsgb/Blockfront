package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jd.class */
public class C0247jd<T extends CloudItem<?>> extends AbstractC0244ja<T> {
    private static final float hg = 3.0f;
    private static final float hh = 1.5f;

    @Override // com.boehmod.blockfront.AbstractC0244ja
    public void a(@NotNull T t, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
    }

    @Override // com.boehmod.blockfront.AbstractC0244ja
    public void a(@NotNull T t, @NotNull CloudItemStack cloudItemStack, @NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
    }

    @Override // com.boehmod.blockfront.AbstractC0244ja
    public void a(@NotNull T t, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f) {
        C0040bk.a(poseStack, guiGraphics, iT.a(t, cloudItemStack), i / 2, (i2 / 2) - 10.0f, 6.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0244ja
    public void a(@NotNull T t, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3) {
        float fZ = Z();
        ItemStack itemStackA = iT.a(t, cloudItemStack);
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, Y());
        C0040bk.a(poseStack, guiGraphics, itemStackA, f + (i3 / 2), (i2 + (i4 / 2)) - 7.5f, fZ);
        poseStack.popPose();
    }

    protected float Y() {
        return 0.0f;
    }

    protected float Z() {
        return 1.5f;
    }

    @Override // com.boehmod.blockfront.AbstractC0244ja
    public void a(@NotNull T t, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        C0040bk.a(poseStack, guiGraphics, iT.a(t, cloudItemStack), (i + (i3 / 2)) - 4.0f, i2 + (i4 / 2), aa());
    }

    protected float aa() {
        return 3.0f;
    }
}
