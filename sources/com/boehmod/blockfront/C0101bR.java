package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.bR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bR.class */
public final class C0101bR implements InterfaceC0102bS {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final IntList f666a = new IntArrayList();

    /* JADX INFO: renamed from: dI */
    private final int f667dI;

    /* JADX INFO: renamed from: dJ */
    private final int f668dJ;

    /* JADX INFO: renamed from: dK */
    private int f669dK;

    /* JADX INFO: renamed from: dL */
    private int f670dL;

    /* JADX INFO: renamed from: dM */
    private int f671dM;

    /* JADX INFO: renamed from: dN */
    private int f672dN;

    /* JADX INFO: renamed from: df */
    private float f673df;

    /* JADX INFO: renamed from: dj */
    private float f674dj;

    /* JADX INFO: renamed from: dg */
    private float f675dg;

    /* JADX INFO: renamed from: dk */
    private float f676dk;

    /* JADX INFO: renamed from: aI */
    private float f677aI;

    /* JADX INFO: renamed from: dl */
    private float f678dl;

    static {
        f666a.add(-74);
        f666a.add(-884443);
        f666a.add(-2389168);
        f666a.add(-1007569);
        f666a.add(-5019);
    }

    public C0101bR(float f, float f2) {
        this(((Integer) C1267xG.m7152a((List) f666a)).intValue(), f, f2);
    }

    public C0101bR(int i, float f, float f2) {
        this.f667dI = ThreadLocalRandom.current().nextInt(ShaderInjectionDefinition.DEFAULT_PRIORITY);
        this.f672dN = 0;
        this.f677aI = 1.0f;
        this.f678dl = 0.5f;
        this.f668dJ = i;
        this.f674dj = f;
        this.f673df = f;
        this.f676dk = f2;
        this.f675dg = f2;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0101bR m399a(int i, int i2, int i3, int i4) {
        this.f669dK = i;
        this.f670dL = i2;
        this.f671dM = i3;
        this.f672dN = i4;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0101bR m400a(float f) {
        this.f678dl = f;
        return this;
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: n */
    public void mo394n(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: a */
    public boolean mo395a(float f) {
        float fSin = Mth.sin((f + this.f667dI) / 10.0f) * 0.5f;
        this.f674dj = this.f673df;
        this.f676dk = this.f675dg;
        this.f675dg -= this.f678dl;
        this.f673df -= fSin;
        this.f677aI = C1270xJ.m7161d(this.f677aI, 0.0f, 0.01f);
        return this.f677aI <= 0.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: a */
    public void mo396a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
        float fHashCode = f + (hashCode() / 10.0f);
        boolean z = (this.f671dM == 0 || this.f672dN == 0) ? false : true;
        if (z) {
            C0129bt.m618a(guiGraphics, this.f669dK, this.f670dL, this.f671dM, this.f672dN);
        }
        float fSin = 0.5f * Mth.sin(fHashCode / 5.0f);
        float fSin2 = (1.0f + (0.5f * Mth.sin(fHashCode / 2.0f) * Mth.sin(fHashCode / 8.0f))) * this.f677aI;
        float fM7170f = C1270xJ.m7170f(this.f673df, this.f674dj, f2);
        float fM7170f2 = C1270xJ.m7170f(this.f675dg, this.f676dk, f2);
        C0129bt.m536a(poseStack, guiGraphics, C0143cG.f1041aL, (fM7170f - 22.5f) + 4.0f, (fM7170f2 - 22.5f) + 4.0f, 45.0f, 45.0f, 0.0f, fSin2, this.f668dJ);
        C0129bt.m536a(poseStack, guiGraphics, C0129bt.f865B, fM7170f, fM7170f2, 8.0f, 8.0f, fSin, fSin2, this.f668dJ);
        if (z) {
            guiGraphics.disableScissor();
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: b */
    public void mo397b(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0102bS.a mo398a() {
        return InterfaceC0102bS.a.BACKGROUND;
    }
}
