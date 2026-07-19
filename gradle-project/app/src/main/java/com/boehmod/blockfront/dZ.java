package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0116eg;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dZ.class */
public final class dZ<S extends AbstractC0116eg> extends dY<S> {
    public dZ(int i, int i2, int i3, int i4, @NotNull Screen screen) {
        super(i, i2, i3, i4, screen);
    }

    @Override // com.boehmod.blockfront.dY, com.boehmod.blockfront.C0051bv
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, fV fVVar) {
        super.a(minecraft, c0297l, fVVar);
        this.hq = (this.bm + this.cM) - 10;
        this.ht = this.hq;
        al();
    }

    @Override // com.boehmod.blockfront.dY
    int T() {
        return this.bn + 4;
    }

    @Override // com.boehmod.blockfront.dY
    public void al() {
        int iHeight = 0;
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            S s = this.C.get(i);
            s.a(this, i, this.bm, this.bn + iHeight + s.R());
            iHeight += s.height() + s.S() + s.R();
        }
        this.hy = iHeight;
        if (this.hy > this.cN) {
            this.hx = ((this.bn + this.cN) - 4) - 40;
        } else {
            this.hx = this.hw;
        }
        if (this.hs > this.hx) {
            this.hs = this.hx;
            this.hr = this.hs;
        }
    }

    private void j(int i) {
        this.hs = e(i);
    }

    @Override // com.boehmod.blockfront.dY
    protected int U() {
        return this.hz == -1 ? this.hs : this.hz;
    }

    @Override // com.boehmod.blockfront.C0051bv
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, double d, double d2, int i) {
        if (C0040bk.b(this.hq, this.hs, 6.0d, 40.0d, d, d2)) {
            this.hz = -1;
            this.hv = ((int) d2) - this.hs;
            this.bK = true;
            return true;
        }
        for (S s : this.C) {
            if (s.D()) {
                if (s.v()) {
                    b(s);
                }
                s.a(minecraft, c0297l, fVVar, (int) d, (int) d2, i);
                return true;
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.dY, com.boehmod.blockfront.C0051bv
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, float f) {
        int iYpos;
        super.a(minecraft, c0297l, fVVar, f);
        if (this.bK) {
            j(((int) ((minecraft.mouseHandler.ypos() * ((double) minecraft.getWindow().getGuiScaledHeight())) / ((double) minecraft.getWindow().getScreenHeight()))) - this.hv);
            return;
        }
        if (this.bL && this.hy > this.cN && (iYpos = (int) ((minecraft.mouseHandler.ypos() * ((double) minecraft.getWindow().getGuiScaledHeight())) / ((double) minecraft.getWindow().getScreenHeight()))) >= this.bn && iYpos <= this.bn + this.cN) {
            this.hz = e(this.hw + Math.round(Mth.clamp((iYpos - this.bn) / this.cN, 0.0f, 1.0f) * (this.hx - this.hw)));
        }
        if (this.hz != -1) {
            double d = ((double) (this.hz - this.hs)) / 6.0d;
            j((int) (((double) this.hs) + (d <= 0.0d ? Math.floor(d) : Math.ceil(d))));
            if (this.hs == this.hz) {
                this.hz = -1;
            }
        }
    }

    @Override // com.boehmod.blockfront.dY, com.boehmod.blockfront.C0051bv
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, @NotNull iS iSVar, int i, int i2, float f, float f2) {
        super.a(minecraft, c0297l, fVVar, poseStack, guiGraphics, font, iSVar, i, i2, f, f2);
        C0040bk.a(guiGraphics, this.bm, this.bn, this.cM - 15, this.cN);
        float fK = k(f2);
        poseStack.pushPose();
        poseStack.translate(0.0f, -fK, 0.0f);
        a(poseStack, minecraft, c0297l, fVVar, guiGraphics, font, i, i2, fK, f, f2);
        poseStack.popPose();
        guiGraphics.disableScissor();
        b(poseStack, minecraft, c0297l, fVVar, guiGraphics, font, i, i2, fK, f, f2);
    }

    @Override // com.boehmod.blockfront.dY
    public void a(GuiGraphics guiGraphics, float f, int i, int i2) {
        PoseStack poseStackPose = guiGraphics.pose();
        if (this.hy > this.cN) {
            float fE = C0634xm.e(this.hq, this.ht, f);
            float fE2 = C0634xm.e(this.hs, this.hr, f);
            float f2 = this.bK || C0040bk.b((double) this.hq, (double) this.hs, 6.0d, 40.0d, (double) i, (double) i2) ? 0.5f : 0.1f;
            poseStackPose.pushPose();
            C0040bk.a(poseStackPose, guiGraphics, fE - 2.0f, this.bn + 2, 10.0f, this.cN - 4, 0, 0.5f);
            C0040bk.a(poseStackPose, guiGraphics, fE, fE2, 6.0f, 40.0f, ColorReferences.COLOR_WHITE, f2);
            poseStackPose.popPose();
        }
    }

    @Override // com.boehmod.blockfront.dY
    public boolean a(@NotNull AbstractC0116eg abstractC0116eg, int i, int i2) {
        if (Minecraft.getInstance().screen != a() || !C0040bk.b(this.bm, this.bn, this.cM, this.cN, i, i2)) {
            return false;
        }
        return C0040bk.b(abstractC0116eg.hI, abstractC0116eg.hJ, abstractC0116eg.mo265t(), abstractC0116eg.height(), i, i2 + k(1.0f));
    }

    @Override // com.boehmod.blockfront.dY
    public float k(float f) {
        if (this.hy <= this.cN) {
            return 0.0f;
        }
        int i = this.hy - this.cN;
        float fE = C0634xm.e(this.hs, this.hr, f);
        if (this.hx == this.hw) {
            return 0.0f;
        }
        return (int) (((fE - this.hw) / (this.hx - this.hw)) * i);
    }
}
