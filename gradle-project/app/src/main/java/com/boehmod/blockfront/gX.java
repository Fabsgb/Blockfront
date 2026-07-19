package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Random;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gX.class */
public class gX {
    private static final float fH = 45.0f;
    public static final float fI = 0.7f;
    private static final float fJ = 0.7f;
    private static final float fK = 0.4f;
    private static final int jh = 6;

    @NotNull
    private final ResourceLocation cQ;
    private float fL;
    private float fM = 0.0f;
    private float aD = 0.7f;
    private float aE = 0.7f;
    private float aB = 0.4f;
    private float aC = 0.4f;
    private int ji = 2;
    private final boolean cx;

    public gX(@NotNull Random random, boolean z) {
        this.cQ = C0265jv.d("textures/misc/muzzleflash/eject" + random.nextInt(6) + ".png");
        this.cx = z;
    }

    public boolean S() {
        int i = this.ji;
        this.ji = i - 1;
        if (i > 0) {
            return false;
        }
        this.aE = this.aD;
        this.fM = this.fL;
        this.aC = this.aB;
        this.fL = C0634xm.d(this.fL, 1.0f, 0.3f);
        this.aB = C0634xm.d(this.aB, 1.0f, 0.3f);
        this.aD = C0634xm.d(this.aD, 0.0f, 0.3f);
        return this.aD + this.aE <= 0.0f;
    }

    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2) {
        float fE = 0.5f * C0634xm.e(this.fL, this.fM, f2);
        if (fE <= 0.0f) {
            return;
        }
        float f3 = fE + 0.1f;
        float fE2 = C0634xm.e(this.aD, this.aE, f2);
        float fE3 = C0634xm.e(this.aB, this.aC, f2);
        C0040bk.b(poseStack, guiGraphics, this.cQ, this.cx ? -f3 : f3, -f3, fE3, fE3, this.cx ? -45.0f : fH, 0.7f * fE2 * f);
    }
}
