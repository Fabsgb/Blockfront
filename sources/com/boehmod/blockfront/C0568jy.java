package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemMelee;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jy.class */
public class C0568jy extends C0566jw<CloudItemMelee> {
    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2304a(@NotNull CloudItemMelee cloudItemMelee, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f) {
        float guiScale = (float) (7.0d * minecraft.getWindow().getGuiScale());
        poseStack.pushPose();
        poseStack.translate(0.0f, -30.0f, 150.0f);
        C0249dx.f2046dT = 25.0f * ((-0.5f) + (i4 / i2));
        C0249dx.f2047dU = 65.0f * ((-0.5f) + (i3 / i));
        C0129bt.m601b(poseStack, guiGraphics, C0556jm.m2530a(cloudItemMelee, cloudItemStack), i / 2, (i2 / 2) + 30, guiScale);
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.C0566jw
    /* JADX INFO: renamed from: aa */
    protected float mo2563aa() {
        return 2.0f;
    }

    @Override // com.boehmod.blockfront.C0566jw
    /* JADX INFO: renamed from: ab */
    protected float mo2564ab() {
        return 8.0f;
    }
}
