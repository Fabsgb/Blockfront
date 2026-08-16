package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Random;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hn.class */
public class C0451hn {

    /* JADX INFO: renamed from: fR */
    private static final float f2852fR = 45.0f;

    /* JADX INFO: renamed from: fS */
    public static final float f2853fS = 0.7f;

    /* JADX INFO: renamed from: fT */
    private static final float f2854fT = 0.7f;

    /* JADX INFO: renamed from: fU */
    private static final float f2855fU = 0.4f;

    /* JADX INFO: renamed from: kC */
    private static final int f2856kC = 6;

    /* JADX INFO: renamed from: cQ */
    @NotNull
    private final ResourceLocation f2857cQ;

    /* JADX INFO: renamed from: fV */
    private float f2858fV;

    /* JADX INFO: renamed from: fW */
    private float f2859fW = 0.0f;

    /* JADX INFO: renamed from: aI */
    private float f2860aI = 0.7f;

    /* JADX INFO: renamed from: aJ */
    private float f2861aJ = 0.7f;

    /* JADX INFO: renamed from: aG */
    private float f2862aG = 0.4f;

    /* JADX INFO: renamed from: aH */
    private float f2863aH = 0.4f;

    /* JADX INFO: renamed from: kD */
    private int f2864kD = 2;

    /* JADX INFO: renamed from: cG */
    private final boolean f2865cG;

    public C0451hn(@NotNull Random random, boolean z) {
        this.f2857cQ = C0532jO.m2378d("textures/misc/muzzleflash/eject" + random.nextInt(6) + ".png");
        this.f2865cG = z;
    }

    /* JADX INFO: renamed from: T */
    public boolean m2089T() {
        int i = this.f2864kD;
        this.f2864kD = i - 1;
        if (i > 0) {
            return false;
        }
        this.f2861aJ = this.f2860aI;
        this.f2859fW = this.f2858fV;
        this.f2863aH = this.f2862aG;
        this.f2858fV = C1270xJ.m7161d(this.f2858fV, 1.0f, 0.3f);
        this.f2862aG = C1270xJ.m7161d(this.f2862aG, 1.0f, 0.3f);
        this.f2860aI = C1270xJ.m7161d(this.f2860aI, 0.0f, 0.3f);
        return this.f2860aI + this.f2861aJ <= 0.0f;
    }

    /* JADX INFO: renamed from: a */
    public void m2090a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2) {
        float fM7170f = 0.5f * C1270xJ.m7170f(this.f2858fV, this.f2859fW, f2);
        if (fM7170f <= 0.0f) {
            return;
        }
        float f3 = fM7170f + 0.1f;
        float fM7170f2 = C1270xJ.m7170f(this.f2860aI, this.f2861aJ, f2);
        float fM7170f3 = C1270xJ.m7170f(this.f2862aG, this.f2863aH, f2);
        C0129bt.m544b(poseStack, guiGraphics, this.f2857cQ, this.f2865cG ? -f3 : f3, -f3, fM7170f3, fM7170f3, this.f2865cG ? -45.0f : f2852fR, 0.7f * fM7170f2 * f);
    }
}
