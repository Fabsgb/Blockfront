package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemMelee;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jf.class */
public class C0249jf extends C0247jd<CloudItemMelee> {
    @Override // com.boehmod.blockfront.C0247jd, com.boehmod.blockfront.AbstractC0244ja
    public void a(@NotNull CloudItemMelee cloudItemMelee, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f) {
        float guiScale = (float) (7.0d * minecraft.getWindow().getGuiScale());
        poseStack.pushPose();
        poseStack.translate(0.0f, -30.0f, 150.0f);
        Cdo.dQ = 25.0f * ((-0.5f) + (i4 / i2));
        Cdo.dR = 65.0f * ((-0.5f) + (i3 / i));
        C0040bk.a(poseStack, guiGraphics, iT.a(cloudItemMelee, cloudItemStack), i / 2, (i2 / 2) + 30, guiScale);
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.C0247jd
    protected float Z() {
        return 2.0f;
    }

    @Override // com.boehmod.blockfront.C0247jd
    protected float aa() {
        return 8.0f;
    }
}
