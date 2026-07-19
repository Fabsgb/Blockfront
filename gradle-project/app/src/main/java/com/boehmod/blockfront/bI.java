package com.boehmod.blockfront;

import com.boehmod.blockfront.bJ;
import com.mojang.blaze3d.vertex.PoseStack;
import foundry.veil.impl.client.render.shader.injection.util.ShaderInjectionDefinition;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bI.class */
public final class bI implements bJ {

    @NotNull
    private static final IntList a = new IntArrayList();
    private final int cQ;
    private final int cR;
    private int cS;
    private int cT;
    private int cU;
    private int cV;
    private float cZ;
    private float dd;
    private float da;

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    private float f408de;
    private float aD;
    private float df;

    static {
        a.add(-74);
        a.add(-884443);
        a.add(-2389168);
        a.add(-1007569);
        a.add(-5019);
    }

    public bI(float f, float f2) {
        this(((Integer) C0631xj.a((List) a)).intValue(), f, f2);
    }

    public bI(int i, float f, float f2) {
        this.cQ = ThreadLocalRandom.current().nextInt(ShaderInjectionDefinition.DEFAULT_PRIORITY);
        this.cV = 0;
        this.aD = 1.0f;
        this.df = 0.5f;
        this.cR = i;
        this.dd = f;
        this.cZ = f;
        this.f408de = f2;
        this.da = f2;
    }

    @NotNull
    public bI a(int i, int i2, int i3, int i4) {
        this.cS = i;
        this.cT = i2;
        this.cU = i3;
        this.cV = i4;
        return this;
    }

    @NotNull
    public bI a(float f) {
        this.df = f;
        return this;
    }

    @Override // com.boehmod.blockfront.bJ
    public void m(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.bJ
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo206a(float f) {
        float fSin = Mth.sin((f + this.cQ) / 10.0f) * 0.5f;
        this.dd = this.cZ;
        this.f408de = this.da;
        this.da -= this.df;
        this.cZ -= fSin;
        this.aD = C0634xm.d(this.aD, 0.0f, 0.01f);
        return this.aD <= 0.0f;
    }

    @Override // com.boehmod.blockfront.bJ
    public void a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
        float fHashCode = f + (hashCode() / 10.0f);
        boolean z = (this.cU == 0 || this.cV == 0) ? false : true;
        if (z) {
            C0040bk.a(guiGraphics, this.cS, this.cT, this.cU, this.cV);
        }
        float fSin = 0.5f * Mth.sin(fHashCode / 5.0f);
        float fSin2 = (1.0f + (0.5f * Mth.sin(fHashCode / 2.0f) * Mth.sin(fHashCode / 8.0f))) * this.aD;
        float fE = C0634xm.e(this.cZ, this.dd, f2);
        float fE2 = C0634xm.e(this.da, this.f408de, f2);
        C0040bk.a(poseStack, guiGraphics, C0080cx.aL, (fE - 22.5f) + 4.0f, (fE2 - 22.5f) + 4.0f, 45.0f, 45.0f, 0.0f, fSin2, this.cR);
        C0040bk.a(poseStack, guiGraphics, C0040bk.B, fE, fE2, 8.0f, 8.0f, fSin, fSin2, this.cR);
        if (z) {
            guiGraphics.disableScissor();
        }
    }

    @Override // com.boehmod.blockfront.bJ
    public void b(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.bJ
    @NotNull
    public bJ.a a() {
        return bJ.a.BACKGROUND;
    }
}
