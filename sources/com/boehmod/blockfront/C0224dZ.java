package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0284eg;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dZ.class */
public final class C0224dZ<S extends AbstractC0284eg> extends AbstractC0223dY<S> {
    public C0224dZ(int i, int i2, int i3, int i4, @NotNull Screen screen) {
        super(i, i2, i3, i4, screen);
    }

    @Override // com.boehmod.blockfront.AbstractC0223dY, com.boehmod.blockfront.C0130bv
    /* JADX INFO: renamed from: a */
    public void mo685a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0326fV c0326fV) {
        super.mo685a(minecraft, c0622l, c0326fV);
        this.f1818hq = (this.f940bm + this.f942cM) - 10;
        this.f1821ht = this.f1818hq;
        mo1306al();
    }

    @Override // com.boehmod.blockfront.AbstractC0223dY
    /* JADX INFO: renamed from: T */
    int mo1305T() {
        return this.f941bn + 4;
    }

    @Override // com.boehmod.blockfront.AbstractC0223dY
    /* JADX INFO: renamed from: al */
    public void mo1306al() {
        int iHeight = 0;
        int size = this.f1822C.size();
        for (int i = 0; i < size; i++) {
            S s = this.f1822C.get(i);
            s.m1496a(this, i, this.f940bm, this.f941bn + iHeight + s.mo1299R());
            iHeight += s.height() + s.mo1300S() + s.mo1299R();
        }
        this.f1830hy = iHeight;
        if (this.f1830hy > this.f943cN) {
            this.f1829hx = ((this.f941bn + this.f943cN) - 4) - 40;
        } else {
            this.f1829hx = this.f1828hw;
        }
        if (this.f1820hs > this.f1829hx) {
            this.f1820hs = this.f1829hx;
            this.f1819hr = this.f1820hs;
        }
    }

    /* JADX INFO: renamed from: j */
    private void m1327j(int i) {
        this.f1820hs = m1314e(i);
    }

    @Override // com.boehmod.blockfront.AbstractC0223dY
    /* JADX INFO: renamed from: U */
    protected int mo1308U() {
        return this.f1831hz == -1 ? this.f1820hs : this.f1831hz;
    }

    @Override // com.boehmod.blockfront.C0130bv
    /* JADX INFO: renamed from: a */
    public boolean mo691a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, double d, double d2, int i) {
        if (C0119bk.m473b(this.f1818hq, this.f1820hs, 6.0d, 40.0d, d, d2)) {
            this.f1831hz = -1;
            this.f1827hv = ((int) d2) - this.f1820hs;
            this.f1824bK = true;
            return true;
        }
        for (S s : this.f1822C) {
            if (s.m1499D()) {
                if (s.mo811v()) {
                    m1322b(s);
                }
                s.mo817a(minecraft, c0622l, c0326fV, (int) d, (int) d2, i);
                return true;
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0223dY, com.boehmod.blockfront.C0130bv
    /* JADX INFO: renamed from: a */
    public void mo686a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, float f) {
        int iYpos;
        super.mo686a(minecraft, c0622l, c0326fV, f);
        if (this.f1824bK) {
            m1327j(((int) ((minecraft.mouseHandler.ypos() * ((double) minecraft.getWindow().getGuiScaledHeight())) / ((double) minecraft.getWindow().getScreenHeight()))) - this.f1827hv);
            return;
        }
        if (this.f1825bL && this.f1830hy > this.f943cN && (iYpos = (int) ((minecraft.mouseHandler.ypos() * ((double) minecraft.getWindow().getGuiScaledHeight())) / ((double) minecraft.getWindow().getScreenHeight()))) >= this.f941bn && iYpos <= this.f941bn + this.f943cN) {
            this.f1831hz = m1314e(this.f1828hw + Math.round(Mth.clamp((iYpos - this.f941bn) / this.f943cN, 0.0f, 1.0f) * (this.f1829hx - this.f1828hw)));
        }
        if (this.f1831hz != -1) {
            double d = ((double) (this.f1831hz - this.f1820hs)) / 6.0d;
            m1327j((int) (((double) this.f1820hs) + (d <= 0.0d ? Math.floor(d) : Math.ceil(d))));
            if (this.f1820hs == this.f1831hz) {
                this.f1831hz = -1;
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0223dY, com.boehmod.blockfront.C0130bv
    /* JADX INFO: renamed from: a */
    public void mo687a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, @NotNull C0482iS c0482iS, int i, int i2, float f, float f2) {
        super.mo687a(minecraft, c0622l, c0326fV, poseStack, guiGraphics, font, c0482iS, i, i2, f, f2);
        C0119bk.m517a(guiGraphics, this.f940bm, this.f941bn, this.f942cM - 15, this.f943cN);
        float fMo1311k = mo1311k(f2);
        poseStack.pushPose();
        poseStack.translate(0.0f, -fMo1311k, 0.0f);
        m1319a(poseStack, minecraft, c0622l, c0326fV, guiGraphics, font, i, i2, fMo1311k, f, f2);
        poseStack.popPose();
        guiGraphics.disableScissor();
        m1320b(poseStack, minecraft, c0622l, c0326fV, guiGraphics, font, i, i2, fMo1311k, f, f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0223dY
    /* JADX INFO: renamed from: a */
    public void mo1309a(GuiGraphics guiGraphics, float f, int i, int i2) {
        PoseStack poseStackPose = guiGraphics.pose();
        if (this.f1830hy > this.f943cN) {
            float fM7843e = C1290xm.m7843e(this.f1818hq, this.f1821ht, f);
            float fM7843e2 = C1290xm.m7843e(this.f1820hs, this.f1819hr, f);
            float f2 = this.f1824bK || C0119bk.m473b((double) this.f1818hq, (double) this.f1820hs, 6.0d, 40.0d, (double) i, (double) i2) ? 0.5f : 0.1f;
            poseStackPose.pushPose();
            C0119bk.m416a(poseStackPose, guiGraphics, fM7843e - 2.0f, this.f941bn + 2, 10.0f, this.f943cN - 4, 0, 0.5f);
            C0119bk.m416a(poseStackPose, guiGraphics, fM7843e, fM7843e2, 6.0f, 40.0f, ColorReferences.COLOR_WHITE, f2);
            poseStackPose.popPose();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0223dY
    /* JADX INFO: renamed from: a */
    public boolean mo1310a(@NotNull AbstractC0284eg abstractC0284eg, int i, int i2) {
        if (Minecraft.getInstance().screen != m683a() || !C0119bk.m473b(this.f940bm, this.f941bn, this.f942cM, this.f943cN, i, i2)) {
            return false;
        }
        return C0119bk.m473b(abstractC0284eg.f2166hI, abstractC0284eg.f2167hJ, abstractC0284eg.mo812t(), abstractC0284eg.height(), i, i2 + mo1311k(1.0f));
    }

    @Override // com.boehmod.blockfront.AbstractC0223dY
    /* JADX INFO: renamed from: k */
    public float mo1311k(float f) {
        if (this.f1830hy <= this.f943cN) {
            return 0.0f;
        }
        int i = this.f1830hy - this.f943cN;
        float fM7843e = C1290xm.m7843e(this.f1820hs, this.f1819hr, f);
        if (this.f1829hx == this.f1828hw) {
            return 0.0f;
        }
        return (int) (((fM7843e - this.f1828hw) / (this.f1829hx - this.f1828hw)) * i);
    }
}
