package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0284eg;
import com.google.common.collect.Iterators;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dY.class */
public abstract class AbstractC0223dY<S extends AbstractC0284eg> extends C0130bv {

    /* JADX INFO: renamed from: hn */
    protected static final int f1815hn = 40;

    /* JADX INFO: renamed from: ho */
    protected static final int f1816ho = 6;

    /* JADX INFO: renamed from: hp */
    protected static final int f1817hp = 2;

    /* JADX INFO: renamed from: hq */
    protected int f1818hq;

    /* JADX INFO: renamed from: hr */
    protected int f1819hr;

    /* JADX INFO: renamed from: hs */
    protected int f1820hs;

    /* JADX INFO: renamed from: ht */
    protected int f1821ht;

    /* JADX INFO: renamed from: C */
    @NotNull
    protected final List<S> f1822C;

    /* JADX INFO: renamed from: hu */
    protected int f1823hu;

    /* JADX INFO: renamed from: bK */
    protected boolean f1824bK;

    /* JADX INFO: renamed from: bL */
    protected boolean f1825bL;

    /* JADX INFO: renamed from: cv */
    protected int f1826cv;

    /* JADX INFO: renamed from: hv */
    protected int f1827hv;

    /* JADX INFO: renamed from: hw */
    protected int f1828hw;

    /* JADX INFO: renamed from: hx */
    protected int f1829hx;

    /* JADX INFO: renamed from: hy */
    protected int f1830hy;

    /* JADX INFO: renamed from: hz */
    protected int f1831hz;

    /* JADX INFO: renamed from: T */
    abstract int mo1305T();

    /* JADX INFO: renamed from: a */
    abstract void mo1309a(GuiGraphics guiGraphics, float f, int i, int i2);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo1310a(@NotNull AbstractC0284eg abstractC0284eg, int i, int i2);

    /* JADX INFO: renamed from: k */
    public abstract float mo1311k(float f);

    /* JADX INFO: renamed from: al */
    abstract void mo1306al();

    /* JADX INFO: renamed from: U */
    abstract int mo1308U();

    public AbstractC0223dY(int i, int i2, int i3, int i4, @NotNull Screen screen) {
        super(i, i2, i3, i4, screen);
        this.f1818hq = 0;
        this.f1819hr = 0;
        this.f1820hs = 0;
        this.f1821ht = 0;
        this.f1822C = new ObjectArrayList();
        this.f1823hu = -1;
        this.f1824bK = false;
        this.f1825bL = false;
        this.f1826cv = ColorReferences.COLOR_BLACK_TRANSPARENT;
        this.f1831hz = 0;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0223dY m1312a(int i) {
        this.f1826cv = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0223dY m1313a(boolean z) {
        this.f1825bL = z;
        return this;
    }

    @Override // com.boehmod.blockfront.C0130bv
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo685a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0326fV c0326fV) {
        this.f1828hw = mo1305T();
        this.f1829hx = this.f1828hw;
        this.f1818hq = this.f1828hw;
        this.f1821ht = this.f1818hq;
        this.f1820hs = this.f1828hw;
        this.f1819hr = this.f1820hs;
    }

    /* JADX INFO: renamed from: e */
    protected int m1314e(int i) {
        return Mth.clamp(i, this.f1828hw, this.f1829hx);
    }

    @Override // com.boehmod.blockfront.C0130bv
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo686a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, float f) {
        try {
            this.f1822C.forEach(abstractC0284eg -> {
                abstractC0284eg.mo810n(minecraft);
            });
        } catch (ConcurrentModificationException e) {
        }
        this.f1821ht = this.f1818hq;
        this.f1819hr = this.f1820hs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: c */
    public void m1315c(@NotNull List<String> list) {
        m1317am();
        for (String strReplace : list) {
            if (!strReplace.startsWith("//")) {
                if (strReplace.contains("<image>")) {
                    String[] strArrSplit = strReplace.replace("<image>", "").split("<>");
                    C0281ed c0281ed = new C0281ed(strArrSplit[0], Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
                    c0281ed.f2165a = this;
                    m1316a(c0281ed);
                } else if (strReplace.contains("<link>")) {
                    String[] strArrSplit2 = strReplace.replace("<link>", "").split("<>");
                    C0285eh c0285ehM1504a = new C0285eh(strArrSplit2[0]).m1504a(strArrSplit2[1]);
                    c0285ehM1504a.f2165a = this;
                    m1316a(c0285ehM1504a);
                } else {
                    boolean z = false;
                    if (strReplace.startsWith("<s>")) {
                        z = true;
                        strReplace = strReplace.replace("<s>", "");
                    }
                    C0285eh c0285eh = new C0285eh(strReplace);
                    if (z) {
                        c0285eh.m1505ao();
                    }
                    c0285eh.f2165a = this;
                    m1316a(c0285eh);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1316a(@NotNull S s) {
        this.f1822C.add(s);
        mo1306al();
    }

    /* JADX INFO: renamed from: am */
    public void m1317am() {
        this.f1822C.clear();
        mo1306al();
    }

    /* JADX INFO: renamed from: a */
    public void m1318a(@NotNull Iterator<? extends S> it) {
        this.f1822C.clear();
        try {
            Iterators.addAll(this.f1822C, it);
            mo1306al();
        } catch (ConcurrentModificationException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m1319a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0326fV c0326fV, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, float f, float f2, float f3) {
        try {
            Iterator<S> it = this.f1822C.iterator();
            while (it.hasNext()) {
                it.next().mo1480a(minecraft, c0622l, c0326fV, poseStack, guiGraphics, font, i, i2, f3);
            }
        } catch (ConcurrentModificationException e) {
        }
        try {
            Iterator<S> it2 = this.f1822C.iterator();
            while (it2.hasNext()) {
                it2.next().mo800a(poseStack, minecraft, c0622l, guiGraphics, c0326fV, font, i, i2, f2, f3);
            }
        } catch (ConcurrentModificationException e2) {
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m1320b(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0326fV c0326fV, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, float f, float f2, float f3) {
        try {
            Iterator<S> it = this.f1822C.iterator();
            while (it.hasNext()) {
                it.next().mo1479b(poseStack, minecraft, c0622l, guiGraphics, c0326fV, font, i, i2, f2, f3);
            }
        } catch (ConcurrentModificationException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m1321a(@NotNull AbstractC0284eg abstractC0284eg) {
        return abstractC0284eg.m1501Y() == this.f1823hu;
    }

    /* JADX INFO: renamed from: b */
    void m1322b(@NotNull AbstractC0284eg abstractC0284eg) {
        this.f1823hu = abstractC0284eg.m1501Y();
    }

    /* JADX INFO: renamed from: V */
    public int m1323V() {
        return this.f1822C.size();
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public List<S> m1324g() {
        return this.f1822C;
    }

    /* JADX INFO: renamed from: d */
    public void m1325d(@NotNull List<S> list) {
        this.f1822C.clear();
        this.f1822C.addAll(list);
    }

    @Override // com.boehmod.blockfront.C0130bv
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo687a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, @NotNull C0482iS c0482iS, int i, int i2, float f, float f2) {
        super.mo687a(minecraft, c0622l, c0326fV, poseStack, guiGraphics, font, c0482iS, i, i2, f, f2);
        mo1309a(guiGraphics, f2, i, i2);
    }

    @Override // com.boehmod.blockfront.C0130bv
    /* JADX INFO: renamed from: a */
    protected void mo689a(@NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        super.mo689a(minecraft, c0326fV, poseStack, guiGraphics, i, i2, f, f2);
        C0119bk.m415a(guiGraphics, this.f940bm, this.f941bn, this.f942cM, this.f943cN, this.f1826cv);
    }

    @Override // com.boehmod.blockfront.C0130bv
    public boolean mouseReleased(double d, double d2, int i) {
        this.f1824bK = false;
        return true;
    }

    @Override // com.boehmod.blockfront.C0130bv
    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        float f = ((float) d4) * 150.0f;
        if (!this.f1824bK && !this.f1822C.isEmpty() && C0119bk.m473b(this.f940bm, this.f941bn, this.f942cM, this.f943cN, d, d2)) {
            this.f1831hz = m1314e((int) (mo1308U() - ((f / this.f1830hy) * 30.0f)));
            return true;
        }
        return super.mouseScrolled(d, d2, d3, d4);
    }
}
