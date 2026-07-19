package com.boehmod.blockfront;

import com.boehmod.blockfront.bJ;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bK.class */
public final class bK implements bJ {
    private final int cW;
    private int cS;
    private int cT;
    private int cU;
    private float cZ;
    private float dd;
    private float da;

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    private float f409de;
    private int cV = 0;
    private float aD = 1.0f;
    private int cX = 300;

    public bK(float f, float f2) {
        this.dd = f;
        this.cZ = f;
        this.f409de = f2;
        this.da = f2;
        IntArrayList intArrayList = new IntArrayList();
        intArrayList.add(-3407872);
        intArrayList.add(-8454144);
        intArrayList.add(-5427152);
        this.cW = intArrayList.getInt(ThreadLocalRandom.current().nextInt(intArrayList.size()));
    }

    public bK a(int i, int i2, int i3, int i4) {
        this.cS = i;
        this.cT = i2;
        this.cU = i3;
        this.cV = i4;
        return this;
    }

    @Override // com.boehmod.blockfront.bJ
    public void m(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.bJ
    /* JADX INFO: renamed from: a */
    public boolean mo206a(float f) {
        float fSin = Mth.sin((f + (hashCode() / 15.0f)) / 30.0f);
        this.dd = this.cZ;
        this.f409de = this.da;
        this.da -= 0.85f;
        this.cZ -= fSin;
        this.aD = Mth.lerp(0.01f, this.aD, 0.0f);
        int i = this.cX;
        this.cX = i - 1;
        return i <= 0 || this.aD <= 0.0f;
    }

    @Override // com.boehmod.blockfront.bJ
    public void a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
        float fHashCode = f + (hashCode() / 10.0f);
        boolean z = (this.cU == 0 || this.cV == 0) ? false : true;
        if (z) {
            C0040bk.a(guiGraphics, this.cS, this.cT, this.cU, this.cV);
        }
        C0040bk.a(poseStack, guiGraphics, C0040bk.B, C0634xm.e(this.cZ, this.dd, f2), C0634xm.e(this.da, this.f409de, f2), 16.0f, 16.0f, 0.5f * Mth.sin(fHashCode / 5.0f), (1.0f + (0.5f * Mth.sin(fHashCode / 2.0f) * Mth.sin(fHashCode / 8.0f))) * this.aD, this.cW);
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
