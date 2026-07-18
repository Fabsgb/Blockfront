package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jd.class */
public class C0546jd<T extends CloudItem<?>> extends AbstractC0543ja<T> {

    /* JADX INFO: renamed from: hg */
    private static final float f3168hg = 3.0f;

    /* JADX INFO: renamed from: hh */
    private static final float f3169hh = 1.5f;

    @Override // com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a */
    public void mo2465a(@NotNull T t, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
    }

    @Override // com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a */
    public void mo2466a(@NotNull T t, @NotNull CloudItemStack cloudItemStack, @NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
    }

    @Override // com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a */
    public void mo2228a(@NotNull T t, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f) {
        C0119bk.m501a(poseStack, guiGraphics, C0483iT.m2203a(t, cloudItemStack), i / 2, (i2 / 2) - 10.0f, 6.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a */
    public void mo2227a(@NotNull T t, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3) {
        float fMo2475Z = mo2475Z();
        ItemStack itemStackM2203a = C0483iT.m2203a(t, cloudItemStack);
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, mo2474Y());
        C0119bk.m501a(poseStack, guiGraphics, itemStackM2203a, f + (i3 / 2), (i2 + (i4 / 2)) - 7.5f, fMo2475Z);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: Y */
    protected float mo2474Y() {
        return 0.0f;
    }

    /* JADX INFO: renamed from: Z */
    protected float mo2475Z() {
        return 1.5f;
    }

    @Override // com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a */
    public void mo2226a(@NotNull T t, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        C0119bk.m501a(poseStack, guiGraphics, C0483iT.m2203a(t, cloudItemStack), (i + (i3 / 2)) - 4.0f, i2 + (i4 / 2), mo2476aa());
    }

    /* JADX INFO: renamed from: aa */
    protected float mo2476aa() {
        return 3.0f;
    }
}
