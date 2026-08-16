package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2f;

/* JADX INFO: renamed from: com.boehmod.blockfront.ho */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ho.class */
public class C0452ho {

    /* JADX INFO: renamed from: fX */
    private static final float f2866fX = 0.075f;

    /* JADX INFO: renamed from: cR */
    @NotNull
    private final ResourceLocation f2867cR;

    /* JADX INFO: renamed from: df */
    private float f2868df;

    /* JADX INFO: renamed from: dg */
    private float f2870dg;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Vector2f f2872a;
    private int ticks;

    /* JADX INFO: renamed from: cH */
    private final boolean f2876cH;

    /* JADX INFO: renamed from: fY */
    private float f2869fY = 0.0f;

    /* JADX INFO: renamed from: fZ */
    private float f2871fZ = 0.0f;

    /* JADX INFO: renamed from: kE */
    private int f2875kE = 0;

    /* JADX INFO: renamed from: aI */
    private float f2873aI = 1.0f;

    /* JADX INFO: renamed from: aJ */
    private float f2874aJ = 1.0f;

    public C0452ho(@NotNull Vector2f vector2f, @NotNull String str, boolean z) {
        this.f2872a = vector2f;
        this.f2867cR = C0532jO.m2378d("textures/misc/muzzleflash/bullet_" + str + ".png");
        this.f2876cH = z;
    }

    /* JADX INFO: renamed from: T */
    public boolean m2091T() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        this.f2869fY = this.f2868df;
        this.f2871fZ = this.f2870dg;
        this.f2875kE = this.ticks;
        this.f2874aJ = this.f2873aI;
        this.f2872a.add(0.0f, 0.2f).mul(1.0f - (0.01f * this.f2872a.length())).add(threadLocalRandomCurrent.nextFloat() * 0.1f, threadLocalRandomCurrent.nextFloat() * 0.1f).mul(0.99f);
        this.f2873aI = Mth.lerp(0.2f, this.f2873aI, 0.0f);
        m2092aT();
        int i = this.ticks;
        this.ticks = i + 1;
        return i > 20;
    }

    /* JADX INFO: renamed from: aT */
    private void m2092aT() {
        if (this.f2876cH) {
            this.f2868df -= this.f2872a.x * 0.15f;
        } else {
            this.f2868df += this.f2872a.x * 0.15f;
        }
        this.f2870dg += this.f2872a.y * 0.2f;
    }

    /* JADX INFO: renamed from: c */
    public void m2093c(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f) {
        C0129bt.m544b(poseStack, guiGraphics, this.f2867cR, C1270xJ.m7170f(this.f2868df, this.f2869fY, f), C1270xJ.m7170f(this.f2870dg, this.f2871fZ, f), f2866fX, f2866fX, (-100.0f) * C1270xJ.m7170f(this.ticks, this.f2875kE, f), C1270xJ.m7170f(this.f2873aI, this.f2874aJ, f));
    }
}
