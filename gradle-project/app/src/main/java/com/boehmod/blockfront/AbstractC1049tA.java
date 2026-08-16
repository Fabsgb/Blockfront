package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tA.class */
public abstract class AbstractC1049tA {

    /* JADX INFO: renamed from: tu */
    private static final int f5699tu = 200;

    /* JADX INFO: renamed from: aI */
    private float f5700aI = 0.0f;

    /* JADX INFO: renamed from: aJ */
    private float f5701aJ = 0.0f;

    /* JADX INFO: renamed from: fi */
    private int f5702fi = 0;

    /* JADX INFO: renamed from: a */
    public abstract void mo5865a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, int i, int i2, int i3, int i4, int i5, int i6, float f);

    /* JADX INFO: renamed from: l */
    public boolean m5863l() {
        this.f5702fi++;
        this.f5701aJ = this.f5700aI;
        if (this.f5702fi < 200) {
            this.f5700aI = C1270xJ.m7161d(this.f5700aI, 1.0f, 0.1f);
        } else {
            this.f5700aI = C1270xJ.m7161d(this.f5700aI, 0.0f, 0.1f);
        }
        return this.f5702fi > 200 && this.f5700aI + this.f5701aJ == 0.0f;
    }

    /* JADX INFO: renamed from: bd */
    public void m5864bd() {
        this.f5702fi = 0;
        this.f5700aI = 0.0f;
        this.f5701aJ = 0.0f;
    }

    /* JADX INFO: renamed from: E */
    public final float m5866E(float f) {
        return C1270xJ.m7170f(this.f5700aI, this.f5701aJ, f);
    }
}
