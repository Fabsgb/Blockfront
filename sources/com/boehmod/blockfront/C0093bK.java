package com.boehmod.blockfront;

import com.boehmod.blockfront.InterfaceC0092bJ;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bK.class */
public final class C0093bK implements InterfaceC0092bJ {

    /* JADX INFO: renamed from: cW */
    private final int f610cW;

    /* JADX INFO: renamed from: cS */
    private int f611cS;

    /* JADX INFO: renamed from: cT */
    private int f612cT;

    /* JADX INFO: renamed from: cU */
    private int f613cU;

    /* JADX INFO: renamed from: cZ */
    private float f615cZ;

    /* JADX INFO: renamed from: dd */
    private float f616dd;

    /* JADX INFO: renamed from: da */
    private float f617da;

    /* JADX INFO: renamed from: de */
    private float f618de;

    /* JADX INFO: renamed from: cV */
    private int f614cV = 0;

    /* JADX INFO: renamed from: aD */
    private float f619aD = 1.0f;

    /* JADX INFO: renamed from: cX */
    private int f620cX = 300;

    public C0093bK(float f, float f2) {
        this.f616dd = f;
        this.f615cZ = f;
        this.f618de = f2;
        this.f617da = f2;
        IntArrayList intArrayList = new IntArrayList();
        intArrayList.add(-3407872);
        intArrayList.add(-8454144);
        intArrayList.add(-5427152);
        this.f610cW = intArrayList.getInt(ThreadLocalRandom.current().nextInt(intArrayList.size()));
    }

    /* JADX INFO: renamed from: a */
    public C0093bK m296a(int i, int i2, int i3, int i4) {
        this.f611cS = i;
        this.f612cT = i2;
        this.f613cU = i3;
        this.f614cV = i4;
        return this;
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: m */
    public void mo289m(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: a */
    public boolean mo290a(float f) {
        float fSin = Mth.sin((f + (hashCode() / 15.0f)) / 30.0f);
        this.f616dd = this.f615cZ;
        this.f618de = this.f617da;
        this.f617da -= 0.85f;
        this.f615cZ -= fSin;
        this.f619aD = Mth.lerp(0.01f, this.f619aD, 0.0f);
        int i = this.f620cX;
        this.f620cX = i - 1;
        return i <= 0 || this.f619aD <= 0.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: a */
    public void mo291a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
        float fHashCode = f + (hashCode() / 10.0f);
        boolean z = (this.f613cU == 0 || this.f614cV == 0) ? false : true;
        if (z) {
            C0119bk.m517a(guiGraphics, this.f611cS, this.f612cT, this.f613cU, this.f614cV);
        }
        C0119bk.m436a(poseStack, guiGraphics, C0119bk.f730B, C1290xm.m7843e(this.f615cZ, this.f616dd, f2), C1290xm.m7843e(this.f617da, this.f618de, f2), 16.0f, 16.0f, 0.5f * Mth.sin(fHashCode / 5.0f), (1.0f + (0.5f * Mth.sin(fHashCode / 2.0f) * Mth.sin(fHashCode / 8.0f))) * this.f619aD, this.f610cW);
        if (z) {
            guiGraphics.disableScissor();
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: b */
    public void mo292b(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0092bJ.a mo293a() {
        return InterfaceC0092bJ.a.BACKGROUND;
    }
}
