package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemGun;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.je */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/je.class */
public class C0547je extends C0546jd<CloudItemGun> {

    /* JADX INFO: renamed from: hi */
    private static final float f3170hi = -45.0f;

    /* JADX INFO: renamed from: hj */
    public static final float f3171hj = 8.0f;

    /* JADX INFO: renamed from: hk */
    public static final float f3172hk = 2.0f;

    @Override // com.boehmod.blockfront.C0546jd, com.boehmod.blockfront.AbstractC0543ja
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2228a(@NotNull CloudItemGun cloudItemGun, @NotNull CloudItemStack cloudItemStack, @NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f) {
        float guiScale = (float) (7.0d * minecraft.getWindow().getGuiScale());
        ItemStack itemStackM2203a = C0483iT.m2203a(cloudItemGun, cloudItemStack);
        C0239do.f1982dQ = (-65.0f) * ((-0.5f) + (i4 / i2));
        C0239do.f1983dR = 85.0f * ((-0.5f) + (i3 / i));
        C0119bk.m501a(poseStack, guiGraphics, itemStackM2203a, i / 2, i2 / 2, guiScale);
    }

    @Override // com.boehmod.blockfront.C0546jd
    /* JADX INFO: renamed from: Y */
    protected float mo2474Y() {
        return f3170hi;
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
