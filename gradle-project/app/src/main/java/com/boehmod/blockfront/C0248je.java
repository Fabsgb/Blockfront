package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemGun;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.je, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/je.class */
public class C0248je extends C0247jd<CloudItemGun> {
    private static final float hi = -45.0f;
    public static final float hj = 8.0f;
    public static final float hk = 2.0f;

    @Override // com.boehmod.blockfront.C0247jd, com.boehmod.blockfront.AbstractC0244ja
    public void a(@NotNull CloudItemGun cloudItemGun, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f) {
        float guiScale = (float) (7.0d * minecraft.getWindow().getGuiScale());
        ItemStack itemStackA = iT.a(cloudItemGun, cloudItemStack);
        Cdo.dQ = (-65.0f) * ((-0.5f) + (i4 / i2));
        Cdo.dR = 85.0f * ((-0.5f) + (i3 / i));
        C0040bk.a(poseStack, guiGraphics, itemStackA, i / 2, i2 / 2, guiScale);
    }

    @Override // com.boehmod.blockfront.C0247jd
    protected float Y() {
        return hi;
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
