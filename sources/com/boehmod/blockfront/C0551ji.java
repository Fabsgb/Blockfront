package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemTrophy;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ji */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ji.class */
public class C0551ji extends C0546jd<CloudItemTrophy> {
    @Override // com.boehmod.blockfront.C0546jd, com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2465a(@NotNull CloudItemTrophy cloudItemTrophy, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
        mo2466a(cloudItemTrophy, cloudItemStack, poseStack, minecraft, guiGraphics, f, f2, f3, f4, 0.5f);
    }

    @Override // com.boehmod.blockfront.C0546jd, com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2466a(@NotNull CloudItemTrophy cloudItemTrophy, @NotNull CloudItemStack cloudItemStack, @NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5) {
        C0119bk.m501a(poseStack, guiGraphics, C0483iT.m2203a(cloudItemTrophy, cloudItemStack), f, f2, f5);
    }

    @Override // com.boehmod.blockfront.C0546jd, com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2228a(@NotNull CloudItemTrophy cloudItemTrophy, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f) {
        float guiScale = (float) (3.0d * minecraft.getWindow().getGuiScale());
        poseStack.pushPose();
        poseStack.translate(0.0f, -15.0f, 150.0f);
        C0239do.f1982dQ = 25.0f * ((-0.5f) + (i4 / i2));
        C0239do.f1983dR = 65.0f * ((-0.5f) + (i3 / i));
        C0119bk.m501a(poseStack, guiGraphics, C0483iT.m2203a(cloudItemTrophy, cloudItemStack), i / 2, i2 / 2, guiScale);
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.C0546jd, com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2227a(@NotNull CloudItemTrophy cloudItemTrophy, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3) {
        C0119bk.m501a(poseStack, guiGraphics, C0483iT.m2203a(cloudItemTrophy, cloudItemStack), i + (i3 / 2), (i2 + (i4 / 2)) - 8, 1.2f);
    }

    @Override // com.boehmod.blockfront.C0546jd, com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2226a(@NotNull CloudItemTrophy cloudItemTrophy, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        C0119bk.m501a(poseStack, guiGraphics, C0483iT.m2203a(cloudItemTrophy, cloudItemStack), i + (i3 / 2), (i2 + (i4 / 2)) - 3, 3.5f);
    }
}
