package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0298et;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ei */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ei.class */
public final class C0287ei<S extends AbstractC0298et> extends AbstractC0288ej<S> {
    public C0287ei(int i, int i2, int i3, int i4, @NotNull Screen screen) {
        super(i, i2, i3, i4, screen);
    }

    @Override // com.boehmod.blockfront.AbstractC0288ej, com.boehmod.blockfront.C0088bE
    /* JADX INFO: renamed from: a */
    public void mo360a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0396gl c0396gl) {
        super.mo360a(minecraft, c0623l, c0396gl);
        this.f2261iC = (this.f580cd + this.f582dF) - 10;
        this.f2260iB = this.f2261iC;
        mo1567aq();
    }

    @Override // com.boehmod.blockfront.AbstractC0288ej
    /* JADX INFO: renamed from: ac */
    int mo1566ac() {
        return this.f579cc + 4;
    }

    @Override // com.boehmod.blockfront.AbstractC0288ej
    /* JADX INFO: renamed from: aq */
    public void mo1567aq() {
        int iMo866x = 0;
        int size = this.f2263E.size();
        for (int i = 0; i < size; i++) {
            S s = this.f2263E.get(i);
            s.m1612a(this, i, this.f579cc + iMo866x + s.mo1603ah(), this.f580cd);
            iMo866x += s.mo866x() + s.mo1602ag();
        }
        this.f2271iI = iMo866x;
        if (this.f2271iI > this.f581dE) {
            this.f2270iH = ((this.f579cc + this.f581dE) - 4) - 40;
        } else {
            this.f2270iH = this.f2269iG;
        }
        if (this.f2259iA > this.f2270iH) {
            this.f2259iA = this.f2270iH;
            this.f2262iD = this.f2259iA;
        }
    }

    /* JADX INFO: renamed from: j */
    private void m1568j(int i) {
        this.f2259iA = m1575e(i);
    }

    @Override // com.boehmod.blockfront.AbstractC0288ej
    /* JADX INFO: renamed from: ad */
    protected int mo1569ad() {
        return this.f2272iJ == -1 ? this.f2259iA : this.f2272iJ;
    }

    @Override // com.boehmod.blockfront.C0088bE
    /* JADX INFO: renamed from: a */
    public boolean mo366a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, double d, double d2, int i) {
        if (C0129bt.m573b(this.f2259iA, this.f2261iC, 40.0d, 6.0d, d, d2)) {
            this.f2272iJ = -1;
            this.f2268iF = ((int) d) - this.f2259iA;
            this.f2265bR = true;
            return true;
        }
        for (S s : this.f2263E) {
            if (s.m1615E()) {
                if (s.mo865w()) {
                    m1583b(s);
                }
                s.mo871a(minecraft, c0623l, c0396gl, (int) d, (int) d2, i);
                return true;
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0288ej, com.boehmod.blockfront.C0088bE
    /* JADX INFO: renamed from: a */
    public void mo361a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, float f) {
        super.mo361a(minecraft, c0623l, c0396gl, f);
        if (this.f2265bR) {
            m1568j(((int) ((minecraft.mouseHandler.xpos() * ((double) minecraft.getWindow().getGuiScaledWidth())) / ((double) minecraft.getWindow().getScreenWidth()))) - this.f2268iF);
            return;
        }
        if (this.f2272iJ != -1) {
            double d = ((double) (this.f2272iJ - this.f2259iA)) / 6.0d;
            m1568j((int) (((double) this.f2259iA) + (d <= 0.0d ? Math.floor(d) : Math.ceil(d))));
            if (this.f2259iA == this.f2272iJ) {
                this.f2272iJ = -1;
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0288ej, com.boehmod.blockfront.C0088bE
    /* JADX INFO: renamed from: a */
    public void mo362a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, @NotNull C0555jl c0555jl, int i, int i2, float f, float f2) {
        super.mo362a(minecraft, c0623l, c0396gl, poseStack, guiGraphics, font, c0555jl, i, i2, f, f2);
        C0129bt.m618a(guiGraphics, this.f579cc, this.f580cd, this.f581dE, this.f582dF);
        float fMo1572j = mo1572j(f2);
        poseStack.pushPose();
        poseStack.translate(-fMo1572j, 0.0f, 0.0f);
        m1580a(poseStack, minecraft, c0623l, c0396gl, guiGraphics, font, i, i2, fMo1572j, f, f2);
        poseStack.popPose();
        guiGraphics.disableScissor();
        m1581b(poseStack, minecraft, c0623l, c0396gl, guiGraphics, font, i, i2, fMo1572j, f, f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0288ej
    /* JADX INFO: renamed from: a */
    public void mo1570a(GuiGraphics guiGraphics, float f, int i, int i2) {
        PoseStack poseStackPose = guiGraphics.pose();
        if (this.f2271iI > this.f581dE) {
            float fM7170f = C1270xJ.m7170f(this.f2259iA, this.f2262iD, f);
            float fM7170f2 = C1270xJ.m7170f(this.f2261iC, this.f2260iB, f);
            float f2 = this.f2265bR || C0129bt.m573b((double) this.f2259iA, (double) this.f2261iC, 40.0d, 6.0d, (double) i, (double) i2) ? 0.5f : 0.1f;
            poseStackPose.pushPose();
            C0129bt.m517a(guiGraphics, this.f579cc + 2, (this.f580cd + this.f582dF) - 11, this.f581dE - 4, 10, 0, 0.5f);
            C0129bt.m516a(poseStackPose, guiGraphics, fM7170f, fM7170f2 + 1.0f, 40.0f, 6.0f, ColorReferences.COLOR_WHITE, f2);
            poseStackPose.popPose();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0288ej
    /* JADX INFO: renamed from: a */
    public boolean mo1571a(@NotNull AbstractC0298et abstractC0298et, int i, int i2) {
        if (Minecraft.getInstance().screen != m358a() || !C0129bt.m573b(this.f579cc, this.f580cd, this.f581dE, this.f582dF, i, i2)) {
            return false;
        }
        return C0129bt.m573b(abstractC0298et.f2339iY, abstractC0298et.f2340iZ, abstractC0298et.mo866x(), abstractC0298et.height(), i + mo1572j(1.0f), i2);
    }

    @Override // com.boehmod.blockfront.AbstractC0288ej
    /* JADX INFO: renamed from: j */
    public float mo1572j(float f) {
        if (this.f2271iI <= this.f581dE) {
            return 0.0f;
        }
        int i = this.f2271iI - this.f581dE;
        float fM7170f = C1270xJ.m7170f(this.f2259iA, this.f2262iD, f);
        if (this.f2270iH == this.f2269iG) {
            return 0.0f;
        }
        return ((fM7170f - this.f2269iG) / (this.f2270iH - this.f2269iG)) * i;
    }
}
