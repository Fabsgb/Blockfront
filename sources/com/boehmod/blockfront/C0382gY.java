package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2f;

/* JADX INFO: renamed from: com.boehmod.blockfront.gY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gY.class */
public class C0382gY {

    /* JADX INFO: renamed from: fN */
    private static final float f2528fN = 0.075f;

    /* JADX INFO: renamed from: cR */
    @NotNull
    private final ResourceLocation f2529cR;

    /* JADX INFO: renamed from: cZ */
    private float f2530cZ;

    /* JADX INFO: renamed from: da */
    private float f2532da;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Vector2f f2534a;
    private int ticks;

    /* JADX INFO: renamed from: cy */
    private final boolean f2538cy;

    /* JADX INFO: renamed from: fO */
    private float f2531fO = 0.0f;

    /* JADX INFO: renamed from: fP */
    private float f2533fP = 0.0f;

    /* JADX INFO: renamed from: jj */
    private int f2537jj = 0;

    /* JADX INFO: renamed from: aD */
    private float f2535aD = 1.0f;

    /* JADX INFO: renamed from: aE */
    private float f2536aE = 1.0f;

    public C0382gY(@NotNull Vector2f vector2f, @NotNull String str, boolean z) {
        this.f2534a = vector2f;
        this.f2529cR = C0564jv.m2555d("textures/misc/muzzleflash/bullet_" + str + ".png");
        this.f2538cy = z;
    }

    /* JADX INFO: renamed from: S */
    public boolean m1835S() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        this.f2531fO = this.f2530cZ;
        this.f2533fP = this.f2532da;
        this.f2537jj = this.ticks;
        this.f2536aE = this.f2535aD;
        this.f2534a.add(0.0f, 0.2f).mul(1.0f - (0.01f * this.f2534a.length())).add(threadLocalRandomCurrent.nextFloat() * 0.1f, threadLocalRandomCurrent.nextFloat() * 0.1f).mul(0.99f);
        this.f2535aD = Mth.lerp(0.2f, this.f2535aD, 0.0f);
        m1836aN();
        int i = this.ticks;
        this.ticks = i + 1;
        return i > 20;
    }

    /* JADX INFO: renamed from: aN */
    private void m1836aN() {
        if (this.f2538cy) {
            this.f2530cZ -= this.f2534a.x * 0.15f;
        } else {
            this.f2530cZ += this.f2534a.x * 0.15f;
        }
        this.f2532da += this.f2534a.y * 0.2f;
    }

    /* JADX INFO: renamed from: c */
    public void m1837c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f) {
        C0119bk.m444b(poseStack, guiGraphics, this.f2529cR, C1290xm.m7843e(this.f2530cZ, this.f2531fO, f), C1290xm.m7843e(this.f2532da, this.f2533fP, f), f2528fN, f2528fN, (-100.0f) * C1290xm.m7843e(this.ticks, this.f2537jj, f), C1290xm.m7843e(this.f2535aD, this.f2536aE, f));
    }
}
