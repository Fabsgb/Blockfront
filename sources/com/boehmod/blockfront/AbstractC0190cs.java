package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cs.class */
public abstract class AbstractC0190cs {

    /* JADX INFO: renamed from: dz */
    public final float f1533dz;

    /* JADX INFO: renamed from: dA */
    public final float f1534dA;

    /* JADX INFO: renamed from: aE */
    public float f1536aE = 1.0f;

    /* JADX INFO: renamed from: aD */
    public float f1535aD = 1.0f;

    /* JADX INFO: renamed from: a */
    public abstract void mo1171a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f);

    public AbstractC0190cs(float f, float f2) {
        this.f1533dz = f;
        this.f1534dA = f2;
    }

    /* JADX INFO: renamed from: k */
    public boolean m1172k() {
        this.f1536aE = this.f1535aD;
        this.f1535aD -= 0.05f;
        return this.f1535aD <= 0.0f;
    }
}
