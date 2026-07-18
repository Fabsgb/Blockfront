package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemMelee;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jf.class */
public class C0548jf extends C0546jd<CloudItemMelee> {
    @Override // com.boehmod.blockfront.C0546jd, com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2228a(@NotNull CloudItemMelee cloudItemMelee, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f) {
        float guiScale = (float) (7.0d * minecraft.getWindow().getGuiScale());
        poseStack.pushPose();
        poseStack.translate(0.0f, -30.0f, 150.0f);
        C0239do.f1982dQ = 25.0f * ((-0.5f) + (i4 / i2));
        C0239do.f1983dR = 65.0f * ((-0.5f) + (i3 / i));
        C0119bk.m501a(poseStack, guiGraphics, C0483iT.m2203a(cloudItemMelee, cloudItemStack), i / 2, (i2 / 2) + 30, guiScale);
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.C0546jd
    /* JADX INFO: renamed from: Z */
    protected float mo2475Z() {
        return 2.0f;
    }

    @Override // com.boehmod.blockfront.C0546jd
    /* JADX INFO: renamed from: aa */
    protected float mo2476aa() {
        return 8.0f;
    }
}
