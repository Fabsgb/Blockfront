package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0116eg;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dY.class */
public abstract class dY<S extends AbstractC0116eg> extends C0051bv {
    protected static final int hn = 40;
    protected static final int ho = 6;
    protected static final int hp = 2;
    protected int hq;
    protected int hr;
    protected int hs;
    protected int ht;

    @NotNull
    protected final List<S> C;
    protected int hu;
    protected boolean bK;
    protected boolean bL;
    protected int cv;
    protected int hv;
    protected int hw;
    protected int hx;
    protected int hy;
    protected int hz;

    abstract int T();

    abstract void a(GuiGraphics guiGraphics, float f, int i, int i2);

    public abstract boolean a(@NotNull AbstractC0116eg abstractC0116eg, int i, int i2);

    public abstract float k(float f);

    abstract void al();

    abstract int U();

    public dY(int i, int i2, int i3, int i4, @NotNull Screen screen) {
        super(i, i2, i3, i4, screen);
        this.hq = 0;
        this.hr = 0;
        this.hs = 0;
        this.ht = 0;
        this.C = new ObjectArrayList();
        this.hu = -1;
        this.bK = false;
        this.bL = false;
        this.cv = ColorReferences.COLOR_BLACK_TRANSPARENT;
        this.hz = 0;
    }

    @NotNull
    public dY a(int i) {
        this.cv = i;
        return this;
    }

    @NotNull
    public dY a(boolean z) {
        this.bL = z;
        return this;
    }

    @Override // com.boehmod.blockfront.C0051bv
    @OverridingMethodsMustInvokeSuper
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, fV fVVar) {
        this.hw = T();
        this.hx = this.hw;
        this.hq = this.hw;
        this.ht = this.hq;
        this.hs = this.hw;
        this.hr = this.hs;
    }

    protected int e(int i) {
        return Mth.clamp(i, this.hw, this.hx);
    }

    @Override // com.boehmod.blockfront.C0051bv
    @OverridingMethodsMustInvokeSuper
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, float f) {
        try {
            this.C.forEach(abstractC0116eg -> {
                abstractC0116eg.n(minecraft);
            });
        } catch (ConcurrentModificationException e) {
        }
        this.ht = this.hq;
        this.hr = this.hs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(@NotNull List<String> list) {
        am();
        for (String strReplace : list) {
            if (!strReplace.startsWith("//")) {
                if (strReplace.contains("<image>")) {
                    String[] strArrSplit = strReplace.replace("<image>", "").split("<>");
                    C0113ed c0113ed = new C0113ed(strArrSplit[0], Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
                    c0113ed.a = this;
                    a(c0113ed);
                } else if (strReplace.contains("<link>")) {
                    String[] strArrSplit2 = strReplace.replace("<link>", "").split("<>");
                    C0117eh c0117ehA = new C0117eh(strArrSplit2[0]).a(strArrSplit2[1]);
                    c0117ehA.a = this;
                    a(c0117ehA);
                } else {
                    boolean z = false;
                    if (strReplace.startsWith("<s>")) {
                        z = true;
                        strReplace = strReplace.replace("<s>", "");
                    }
                    C0117eh c0117eh = new C0117eh(strReplace);
                    if (z) {
                        c0117eh.ao();
                    }
                    c0117eh.a = this;
                    a(c0117eh);
                }
            }
        }
    }

    public void a(@NotNull S s) {
        this.C.add(s);
        al();
    }

    public void am() {
        this.C.clear();
        al();
    }

    public void a(@NotNull Iterator<? extends S> it) {
        this.C.clear();
        try {
            Iterators.addAll(this.C, it);
            al();
        } catch (ConcurrentModificationException e) {
        }
    }

    protected void a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, fV fVVar, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, float f, float f2, float f3) {
        try {
            Iterator<S> it = this.C.iterator();
            while (it.hasNext()) {
                it.next().a(minecraft, c0297l, fVVar, poseStack, guiGraphics, font, i, i2, f3);
            }
        } catch (ConcurrentModificationException e) {
        }
        try {
            Iterator<S> it2 = this.C.iterator();
            while (it2.hasNext()) {
                it2.next().a(poseStack, minecraft, c0297l, guiGraphics, fVVar, font, i, i2, f2, f3);
            }
        } catch (ConcurrentModificationException e2) {
        }
    }

    protected void b(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, fV fVVar, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, float f, float f2, float f3) {
        try {
            Iterator<S> it = this.C.iterator();
            while (it.hasNext()) {
                it.next().b(poseStack, minecraft, c0297l, guiGraphics, fVVar, font, i, i2, f2, f3);
            }
        } catch (ConcurrentModificationException e) {
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m339a(@NotNull AbstractC0116eg abstractC0116eg) {
        return abstractC0116eg.Y() == this.hu;
    }

    void b(@NotNull AbstractC0116eg abstractC0116eg) {
        this.hu = abstractC0116eg.Y();
    }

    public int V() {
        return this.C.size();
    }

    @NotNull
    public List<S> g() {
        return this.C;
    }

    public void d(@NotNull List<S> list) {
        this.C.clear();
        this.C.addAll(list);
    }

    @Override // com.boehmod.blockfront.C0051bv
    @OverridingMethodsMustInvokeSuper
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, @NotNull iS iSVar, int i, int i2, float f, float f2) {
        super.a(minecraft, c0297l, fVVar, poseStack, guiGraphics, font, iSVar, i, i2, f, f2);
        a(guiGraphics, f2, i, i2);
    }

    @Override // com.boehmod.blockfront.C0051bv
    protected void a(@NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        super.a(minecraft, fVVar, poseStack, guiGraphics, i, i2, f, f2);
        C0040bk.a(guiGraphics, this.bm, this.bn, this.cM, this.cN, this.cv);
    }

    @Override // com.boehmod.blockfront.C0051bv
    public boolean mouseReleased(double d, double d2, int i) {
        this.bK = false;
        return true;
    }

    @Override // com.boehmod.blockfront.C0051bv
    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        float f = ((float) d4) * 150.0f;
        if (!this.bK && !this.C.isEmpty() && C0040bk.b(this.bm, this.bn, this.cM, this.cN, d, d2)) {
            this.hz = e((int) (U() - ((f / this.hy) * 30.0f)));
            return true;
        }
        return super.mouseScrolled(d, d2, d3, d4);
    }
}
