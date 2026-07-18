package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Random;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gX.class */
public class C0381gX {

    /* JADX INFO: renamed from: fH */
    private static final float f2514fH = 45.0f;

    /* JADX INFO: renamed from: fI */
    public static final float f2515fI = 0.7f;

    /* JADX INFO: renamed from: fJ */
    private static final float f2516fJ = 0.7f;

    /* JADX INFO: renamed from: fK */
    private static final float f2517fK = 0.4f;

    /* JADX INFO: renamed from: jh */
    private static final int f2518jh = 6;

    /* JADX INFO: renamed from: cQ */
    @NotNull
    private final ResourceLocation f2519cQ;

    /* JADX INFO: renamed from: fL */
    private float f2520fL;

    /* JADX INFO: renamed from: fM */
    private float f2521fM = 0.0f;

    /* JADX INFO: renamed from: aD */
    private float f2522aD = 0.7f;

    /* JADX INFO: renamed from: aE */
    private float f2523aE = 0.7f;

    /* JADX INFO: renamed from: aB */
    private float f2524aB = 0.4f;

    /* JADX INFO: renamed from: aC */
    private float f2525aC = 0.4f;

    /* JADX INFO: renamed from: ji */
    private int f2526ji = 2;

    /* JADX INFO: renamed from: cx */
    private final boolean f2527cx;

    public C0381gX(@NotNull Random random, boolean z) {
        this.f2519cQ = C0564jv.m2555d("textures/misc/muzzleflash/eject" + random.nextInt(6) + ".png");
        this.f2527cx = z;
    }

    /* JADX INFO: renamed from: S */
    public boolean m1833S() {
        int i = this.f2526ji;
        this.f2526ji = i - 1;
        if (i > 0) {
            return false;
        }
        this.f2523aE = this.f2522aD;
        this.f2521fM = this.f2520fL;
        this.f2525aC = this.f2524aB;
        this.f2520fL = C1290xm.m7835d(this.f2520fL, 1.0f, 0.3f);
        this.f2524aB = C1290xm.m7835d(this.f2524aB, 1.0f, 0.3f);
        this.f2522aD = C1290xm.m7835d(this.f2522aD, 0.0f, 0.3f);
        return this.f2522aD + this.f2523aE <= 0.0f;
    }

    /* JADX INFO: renamed from: a */
    public void m1834a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2) {
        float fM7843e = 0.5f * C1290xm.m7843e(this.f2520fL, this.f2521fM, f2);
        if (fM7843e <= 0.0f) {
            return;
        }
        float f3 = fM7843e + 0.1f;
        float fM7843e2 = C1290xm.m7843e(this.f2522aD, this.f2523aE, f2);
        float fM7843e3 = C1290xm.m7843e(this.f2524aB, this.f2525aC, f2);
        C0119bk.m444b(poseStack, guiGraphics, this.f2519cQ, this.f2527cx ? -f3 : f3, -f3, fM7843e3, fM7843e3, this.f2527cx ? -45.0f : f2514fH, 0.7f * fM7843e2 * f);
    }
}
