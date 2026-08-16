package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemGun;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jx.class */
public class C0567jx extends C0566jw<CloudItemGun> {

    /* JADX INFO: renamed from: hE */
    private static final float f3325hE = -45.0f;

    /* JADX INFO: renamed from: hF */
    public static final float f3326hF = 8.0f;

    /* JADX INFO: renamed from: hG */
    public static final float f3327hG = 2.0f;

    @Override // com.boehmod.blockfront.C0566jw, com.boehmod.blockfront.AbstractC0563jt
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2304a(@NotNull CloudItemGun cloudItemGun, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f) {
        float guiScale = (float) (7.0d * minecraft.getWindow().getGuiScale());
        ItemStack itemStackM2530a = C0556jm.m2530a(cloudItemGun, cloudItemStack);
        C0249dx.f2046dT = (-65.0f) * ((-0.5f) + (i4 / i2));
        C0249dx.f2047dU = 85.0f * ((-0.5f) + (i3 / i));
        C0129bt.m601b(poseStack, guiGraphics, itemStackM2530a, i / 2, i2 / 2, guiScale);
    }

    @Override // com.boehmod.blockfront.C0566jw
    /* JADX INFO: renamed from: Z */
    protected float mo2562Z() {
        return f3325hE;
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
