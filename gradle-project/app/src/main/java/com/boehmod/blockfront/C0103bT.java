package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bT.class */
public final class C0103bT implements InterfaceC0102bS {

    /* JADX INFO: renamed from: dO */
    private final int f679dO;

    /* JADX INFO: renamed from: dK */
    private int f680dK;

    /* JADX INFO: renamed from: dL */
    private int f681dL;

    /* JADX INFO: renamed from: dM */
    private int f682dM;

    /* JADX INFO: renamed from: df */
    private float f684df;

    /* JADX INFO: renamed from: dj */
    private float f685dj;

    /* JADX INFO: renamed from: dg */
    private float f686dg;

    /* JADX INFO: renamed from: dk */
    private float f687dk;

    /* JADX INFO: renamed from: dN */
    private int f683dN = 0;

    /* JADX INFO: renamed from: aI */
    private float f688aI = 1.0f;

    /* JADX INFO: renamed from: dP */
    private int f689dP = 300;

    public C0103bT(float f, float f2) {
        this.f685dj = f;
        this.f684df = f;
        this.f687dk = f2;
        this.f686dg = f2;
        IntArrayList intArrayList = new IntArrayList();
        intArrayList.add(-3407872);
        intArrayList.add(-8454144);
        intArrayList.add(-5427152);
        this.f679dO = intArrayList.getInt(ThreadLocalRandom.current().nextInt(intArrayList.size()));
    }

    /* JADX INFO: renamed from: a */
    public C0103bT m401a(int i, int i2, int i3, int i4) {
        this.f680dK = i;
        this.f681dL = i2;
        this.f682dM = i3;
        this.f683dN = i4;
        return this;
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: n */
    public void mo394n(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: a */
    public boolean mo395a(float f) {
        float fSin = Mth.sin((f + (hashCode() / 15.0f)) / 30.0f);
        this.f685dj = this.f684df;
        this.f687dk = this.f686dg;
        this.f686dg -= 0.85f;
        this.f684df -= fSin;
        this.f688aI = Mth.lerp(0.01f, this.f688aI, 0.0f);
        int i = this.f689dP;
        this.f689dP = i - 1;
        return i <= 0 || this.f688aI <= 0.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: a */
    public void mo396a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
        float fHashCode = f + (hashCode() / 10.0f);
        boolean z = (this.f682dM == 0 || this.f683dN == 0) ? false : true;
        if (z) {
            C0129bt.m618a(guiGraphics, this.f680dK, this.f681dL, this.f682dM, this.f683dN);
        }
        C0129bt.m536a(poseStack, guiGraphics, C0129bt.f865B, C1270xJ.m7170f(this.f684df, this.f685dj, f2), C1270xJ.m7170f(this.f686dg, this.f687dk, f2), 16.0f, 16.0f, 0.5f * Mth.sin(fHashCode / 5.0f), (1.0f + (0.5f * Mth.sin(fHashCode / 2.0f) * Mth.sin(fHashCode / 8.0f))) * this.f688aI, this.f679dO);
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
