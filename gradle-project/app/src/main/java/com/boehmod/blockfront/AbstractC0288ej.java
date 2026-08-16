package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0298et;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ej */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ej.class */
public abstract class AbstractC0288ej<S extends AbstractC0298et> extends C0088bE {

    /* JADX INFO: renamed from: ix */
    protected static final int f2256ix = 40;

    /* JADX INFO: renamed from: iy */
    protected static final int f2257iy = 6;

    /* JADX INFO: renamed from: iz */
    protected static final int f2258iz = 2;

    /* JADX INFO: renamed from: iA */
    protected int f2259iA;

    /* JADX INFO: renamed from: iB */
    protected int f2260iB;

    /* JADX INFO: renamed from: iC */
    protected int f2261iC;

    /* JADX INFO: renamed from: iD */
    protected int f2262iD;

    /* JADX INFO: renamed from: E */
    @NotNull
    protected final List<S> f2263E;

    /* JADX INFO: renamed from: iE */
    protected int f2264iE;

    /* JADX INFO: renamed from: bR */
    protected boolean f2265bR;

    /* JADX INFO: renamed from: bS */
    protected boolean f2266bS;

    /* JADX INFO: renamed from: dn */
    protected int f2267dn;

    /* JADX INFO: renamed from: iF */
    protected int f2268iF;

    /* JADX INFO: renamed from: iG */
    protected int f2269iG;

    /* JADX INFO: renamed from: iH */
    protected int f2270iH;

    /* JADX INFO: renamed from: iI */
    protected int f2271iI;

    /* JADX INFO: renamed from: iJ */
    protected int f2272iJ;

    /* JADX INFO: renamed from: ac */
    abstract int mo1566ac();

    /* JADX INFO: renamed from: a */
    abstract void mo1570a(GuiGraphics guiGraphics, float f, int i, int i2);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo1571a(@NotNull AbstractC0298et abstractC0298et, int i, int i2);

    /* JADX INFO: renamed from: j */
    public abstract float mo1572j(float f);

    /* JADX INFO: renamed from: aq */
    abstract void mo1567aq();

    /* JADX INFO: renamed from: ad */
    abstract int mo1569ad();

    public AbstractC0288ej(int i, int i2, int i3, int i4, @NotNull Screen screen) {
        super(i, i2, i3, i4, screen);
        this.f2259iA = 0;
        this.f2260iB = 0;
        this.f2261iC = 0;
        this.f2262iD = 0;
        this.f2263E = new ObjectArrayList();
        this.f2264iE = -1;
        this.f2265bR = false;
        this.f2266bS = false;
        this.f2267dn = ColorReferences.COLOR_BLACK_TRANSPARENT;
        this.f2272iJ = 0;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0288ej m1573a(int i) {
        this.f2267dn = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0288ej m1574a(boolean z) {
        this.f2266bS = z;
        return this;
    }

    @Override // com.boehmod.blockfront.C0088bE
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo360a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0396gl c0396gl) {
        this.f2269iG = mo1566ac();
        this.f2270iH = this.f2269iG;
        this.f2259iA = this.f2269iG;
        this.f2262iD = this.f2259iA;
        this.f2261iC = this.f2269iG;
        this.f2260iB = this.f2261iC;
    }

    /* JADX INFO: renamed from: e */
    protected int m1575e(int i) {
        return Mth.clamp(i, this.f2269iG, this.f2270iH);
    }

    @Override // com.boehmod.blockfront.C0088bE
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo361a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, float f) {
        try {
            this.f2263E.forEach(abstractC0298et -> {
                abstractC0298et.mo864o(minecraft);
            });
        } catch (ConcurrentModificationException e) {
        }
        this.f2262iD = this.f2259iA;
        this.f2260iB = this.f2261iC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: c */
    public void m1576c(@NotNull List<String> list) {
        m1578ar();
        for (String strReplace : list) {
            if (!strReplace.startsWith("//")) {
                if (strReplace.contains("<image>")) {
                    String[] strArrSplit = strReplace.replace("<image>", "").split("<>");
                    C0294ep c0294ep = new C0294ep(strArrSplit[0], Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
                    c0294ep.f2338a = this;
                    m1577a(c0294ep);
                } else if (strReplace.contains("<link>")) {
                    String[] strArrSplit2 = strReplace.replace("<link>", "").split("<>");
                    C0299eu c0299euM1620a = new C0299eu(strArrSplit2[0]).m1620a(strArrSplit2[1]);
                    c0299euM1620a.f2338a = this;
                    m1577a(c0299euM1620a);
                } else {
                    boolean z = false;
                    if (strReplace.startsWith("<s>")) {
                        z = true;
                        strReplace = strReplace.replace("<s>", "");
                    }
                    C0299eu c0299eu = new C0299eu(strReplace);
                    if (z) {
                        c0299eu.m1621at();
                    }
                    c0299eu.f2338a = this;
                    m1577a(c0299eu);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1577a(@NotNull S s) {
        this.f2263E.add(s);
        mo1567aq();
    }

    /* JADX INFO: renamed from: ar */
    public void m1578ar() {
        this.f2263E.clear();
        mo1567aq();
    }

    /* JADX INFO: renamed from: a */
    public void m1579a(@NotNull Iterator<? extends S> it) {
        this.f2263E.clear();
        try {
            Iterators.addAll(this.f2263E, it);
            mo1567aq();
        } catch (ConcurrentModificationException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m1580a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0396gl c0396gl, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, float f, float f2, float f3) {
        try {
            Iterator<S> it = this.f2263E.iterator();
            while (it.hasNext()) {
                it.next().mo1596a(minecraft, c0623l, c0396gl, poseStack, guiGraphics, font, i, i2, f3);
            }
        } catch (ConcurrentModificationException e) {
        }
        try {
            Iterator<S> it2 = this.f2263E.iterator();
            while (it2.hasNext()) {
                it2.next().mo854a(poseStack, minecraft, c0623l, guiGraphics, c0396gl, font, i, i2, f2, f3);
            }
        } catch (ConcurrentModificationException e2) {
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m1581b(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0396gl c0396gl, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, float f, float f2, float f3) {
        try {
            Iterator<S> it = this.f2263E.iterator();
            while (it.hasNext()) {
                it.next().mo1591b(poseStack, minecraft, c0623l, guiGraphics, c0396gl, font, i, i2, f2, f3);
            }
        } catch (ConcurrentModificationException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m1582a(@NotNull AbstractC0298et abstractC0298et) {
        return abstractC0298et.m1617ai() == this.f2264iE;
    }

    /* JADX INFO: renamed from: b */
    void m1583b(@NotNull AbstractC0298et abstractC0298et) {
        this.f2264iE = abstractC0298et.m1617ai();
    }

    /* JADX INFO: renamed from: ae */
    public int m1584ae() {
        return this.f2263E.size();
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public List<S> m1585h() {
        return this.f2263E;
    }

    /* JADX INFO: renamed from: d */
    public void m1586d(@NotNull List<S> list) {
        this.f2263E.clear();
        this.f2263E.addAll(list);
    }

    @Override // com.boehmod.blockfront.C0088bE
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo362a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, @NotNull C0555jl c0555jl, int i, int i2, float f, float f2) {
        super.mo362a(minecraft, c0623l, c0396gl, poseStack, guiGraphics, font, c0555jl, i, i2, f, f2);
        mo1570a(guiGraphics, f2, i, i2);
    }

    @Override // com.boehmod.blockfront.C0088bE
    /* JADX INFO: renamed from: a */
    protected void mo364a(@NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        super.mo364a(minecraft, c0396gl, poseStack, guiGraphics, i, i2, f, f2);
        C0129bt.m515a(guiGraphics, this.f579cc, this.f580cd, this.f581dE, this.f582dF, this.f2267dn);
    }

    @Override // com.boehmod.blockfront.C0088bE
    public boolean mouseReleased(double d, double d2, int i) {
        this.f2265bR = false;
        return true;
    }

    @Override // com.boehmod.blockfront.C0088bE
    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        float f = ((float) d4) * 150.0f;
        if (!this.f2265bR && !this.f2263E.isEmpty() && C0129bt.m573b(this.f579cc, this.f580cd, this.f581dE, this.f582dF, d, d2)) {
            this.f2272iJ = m1575e((int) (mo1569ad() - ((f / this.f2271iI) * 30.0f)));
            return true;
        }
        return super.mouseScrolled(d, d2, d3, d4);
    }
}
