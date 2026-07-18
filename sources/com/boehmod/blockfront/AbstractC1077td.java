package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.td */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/td.class */
public abstract class AbstractC1077td {

    /* JADX INFO: renamed from: rt */
    private static final int f5652rt = 200;

    /* JADX INFO: renamed from: aD */
    private float f5653aD = 0.0f;

    /* JADX INFO: renamed from: aE */
    private float f5654aE = 0.0f;

    /* JADX INFO: renamed from: ei */
    private int f5655ei = 0;

    /* JADX INFO: renamed from: a */
    public abstract void mo5983a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, int i, int i2, int i3, int i4, int i5, int i6, float f);

    /* JADX INFO: renamed from: k */
    public boolean m5984k() {
        this.f5655ei++;
        this.f5654aE = this.f5653aD;
        if (this.f5655ei < 200) {
            this.f5653aD = C1290xm.m7835d(this.f5653aD, 1.0f, 0.1f);
        } else {
            this.f5653aD = C1290xm.m7835d(this.f5653aD, 0.0f, 0.1f);
        }
        return this.f5655ei > 200 && this.f5653aD + this.f5654aE == 0.0f;
    }

    /* JADX INFO: renamed from: bf */
    public void m5985bf() {
        this.f5655ei = 0;
        this.f5653aD = 0.0f;
        this.f5654aE = 0.0f;
    }

    /* JADX INFO: renamed from: B */
    public final float m5986B(float f) {
        return C1290xm.m7843e(this.f5653aD, this.f5654aE, f);
    }
}
