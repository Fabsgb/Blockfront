package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gY.class */
public class gY {
    private static final float fN = 0.075f;

    @NotNull
    private final ResourceLocation cR;
    private float cZ;
    private float da;

    @NotNull
    private final Vector2f a;
    private int ticks;
    private final boolean cy;
    private float fO = 0.0f;
    private float fP = 0.0f;
    private int jj = 0;
    private float aD = 1.0f;
    private float aE = 1.0f;

    public gY(@NotNull Vector2f vector2f, @NotNull String str, boolean z) {
        this.a = vector2f;
        this.cR = C0265jv.d("textures/misc/muzzleflash/bullet_" + str + ".png");
        this.cy = z;
    }

    public boolean S() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        this.fO = this.cZ;
        this.fP = this.da;
        this.jj = this.ticks;
        this.aE = this.aD;
        this.a.add(0.0f, 0.2f).mul(1.0f - (0.01f * this.a.length())).add(threadLocalRandomCurrent.nextFloat() * 0.1f, threadLocalRandomCurrent.nextFloat() * 0.1f).mul(0.99f);
        this.aD = Mth.lerp(0.2f, this.aD, 0.0f);
        aN();
        int i = this.ticks;
        this.ticks = i + 1;
        return i > 20;
    }

    private void aN() {
        if (this.cy) {
            this.cZ -= this.a.x * 0.15f;
        } else {
            this.cZ += this.a.x * 0.15f;
        }
        this.da += this.a.y * 0.2f;
    }

    public void c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f) {
        C0040bk.b(poseStack, guiGraphics, this.cR, C0634xm.e(this.cZ, this.fO, f), C0634xm.e(this.da, this.fP, f), fN, fN, (-100.0f) * C0634xm.e(this.ticks, this.jj, f), C0634xm.e(this.aD, this.aE, f));
    }
}
