package com.boehmod.blockfront;

import com.boehmod.blockfront.InterfaceC0092bJ;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.bI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bI.class */
public final class C0091bI implements InterfaceC0092bJ {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final IntList f597a = new IntArrayList();

    /* JADX INFO: renamed from: cQ */
    private final int f598cQ;

    /* JADX INFO: renamed from: cR */
    private final int f599cR;

    /* JADX INFO: renamed from: cS */
    private int f600cS;

    /* JADX INFO: renamed from: cT */
    private int f601cT;

    /* JADX INFO: renamed from: cU */
    private int f602cU;

    /* JADX INFO: renamed from: cV */
    private int f603cV;

    /* JADX INFO: renamed from: cZ */
    private float f604cZ;

    /* JADX INFO: renamed from: dd */
    private float f605dd;

    /* JADX INFO: renamed from: da */
    private float f606da;

    /* JADX INFO: renamed from: de */
    private float f607de;

    /* JADX INFO: renamed from: aD */
    private float f608aD;

    /* JADX INFO: renamed from: df */
    private float f609df;

    static {
        f597a.add(-74);
        f597a.add(-884443);
        f597a.add(-2389168);
        f597a.add(-1007569);
        f597a.add(-5019);
    }

    public C0091bI(float f, float f2) {
        this(((Integer) C1287xj.m7828a((List) f597a)).intValue(), f, f2);
    }

    public C0091bI(int i, float f, float f2) {
        this.f598cQ = ThreadLocalRandom.current().nextInt(ShaderInjectionDefinition.DEFAULT_PRIORITY);
        this.f603cV = 0;
        this.f608aD = 1.0f;
        this.f609df = 0.5f;
        this.f599cR = i;
        this.f605dd = f;
        this.f604cZ = f;
        this.f607de = f2;
        this.f606da = f2;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0091bI m294a(int i, int i2, int i3, int i4) {
        this.f600cS = i;
        this.f601cT = i2;
        this.f602cU = i3;
        this.f603cV = i4;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0091bI m295a(float f) {
        this.f609df = f;
        return this;
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: m */
    public void mo289m(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: a */
    public boolean mo290a(float f) {
        float fSin = Mth.sin((f + this.f598cQ) / 10.0f) * 0.5f;
        this.f605dd = this.f604cZ;
        this.f607de = this.f606da;
        this.f606da -= this.f609df;
        this.f604cZ -= fSin;
        this.f608aD = C1290xm.m7835d(this.f608aD, 0.0f, 0.01f);
        return this.f608aD <= 0.0f;
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: a */
    public void mo291a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
        float fHashCode = f + (hashCode() / 10.0f);
        boolean z = (this.f602cU == 0 || this.f603cV == 0) ? false : true;
        if (z) {
            C0119bk.m517a(guiGraphics, this.f600cS, this.f601cT, this.f602cU, this.f603cV);
        }
        float fSin = 0.5f * Mth.sin(fHashCode / 5.0f);
        float fSin2 = (1.0f + (0.5f * Mth.sin(fHashCode / 2.0f) * Mth.sin(fHashCode / 8.0f))) * this.f608aD;
        float fM7843e = C1290xm.m7843e(this.f604cZ, this.f605dd, f2);
        float fM7843e2 = C1290xm.m7843e(this.f606da, this.f607de, f2);
        C0119bk.m436a(poseStack, guiGraphics, C0195cx.f1568aL, (fM7843e - 22.5f) + 4.0f, (fM7843e2 - 22.5f) + 4.0f, 45.0f, 45.0f, 0.0f, fSin2, this.f599cR);
        C0119bk.m436a(poseStack, guiGraphics, C0119bk.f730B, fM7843e, fM7843e2, 8.0f, 8.0f, fSin, fSin2, this.f599cR);
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
