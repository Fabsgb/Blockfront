package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.report.MatchSummary;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.function.ToDoubleFunction;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bu.class */
public final class C0130bu {

    /* JADX INFO: renamed from: cH */
    private static final int f931cH = 2;

    /* JADX INFO: renamed from: cJ */
    private static final float f932cJ = 1.0f;

    /* JADX INFO: renamed from: cK */
    private static final float f933cK = 0.4f;

    /* JADX INFO: renamed from: cI */
    private static final int f934cI = 3;

    /* JADX INFO: renamed from: cJ */
    private static final int f935cJ = 10;

    /* JADX INFO: renamed from: cK */
    private static final int f936cK = 32;

    /* JADX INFO: renamed from: cL */
    private static final int f937cL = 4;

    /* JADX INFO: renamed from: cM */
    private static final int f938cM = 8;

    /* JADX INFO: renamed from: cN */
    private static final int f939cN = -5592406;

    /* JADX INFO: renamed from: cO */
    private static final int f940cO = 654311423;

    /* JADX INFO: renamed from: cP */
    private static final int f941cP = 1090519039;

    /* JADX INFO: renamed from: cQ */
    private static final int f942cQ = -7829368;

    /* JADX INFO: renamed from: J */
    @NotNull
    private static final ResourceLocation f943J = C0532jO.m2378d("textures/gui/backshadow_white.png");

    /* JADX INFO: renamed from: az */
    private final boolean f944az;

    /* JADX INFO: renamed from: r */
    @NotNull
    private final ObjectList<a> f945r;

    /* JADX INFO: renamed from: cR */
    private final int f946cR;

    /* JADX INFO: renamed from: cS */
    private final int f947cS;

    /* JADX INFO: renamed from: cT */
    private final int f948cT;

    /* JADX INFO: renamed from: cU */
    private final int f949cU;

    /* JADX INFO: renamed from: cV */
    private final int f950cV;

    /* JADX INFO: renamed from: cW */
    private final int f951cW;

    /* JADX INFO: renamed from: cX */
    private final int f952cX;

    /* JADX INFO: renamed from: cY */
    private final int f953cY;

    /* JADX INFO: renamed from: cZ */
    private final int f954cZ;

    /* JADX INFO: renamed from: da */
    private int f955da;

    /* JADX INFO: renamed from: db */
    private int f956db = -1;

    /* JADX INFO: renamed from: com.boehmod.blockfront.bu$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bu$b.class */
    public static final class b extends Record {

        /* JADX INFO: renamed from: B */
        @NotNull
        private final Component f964B;

        /* JADX INFO: renamed from: dd */
        private final int f965dd;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final ToDoubleFunction<MatchSummary> f966a;

        public b(@NotNull Component component, int i, @NotNull ToDoubleFunction<MatchSummary> toDoubleFunction) {
            this.f964B = component;
            this.f965dd = i;
            this.f966a = toDoubleFunction;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "label;color;extractor", "FIELD:Lcom/boehmod/blockfront/bu$b;->B:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bu$b;->dd:I", "FIELD:Lcom/boehmod/blockfront/bu$b;->a:Ljava/util/function/ToDoubleFunction;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "label;color;extractor", "FIELD:Lcom/boehmod/blockfront/bu$b;->B:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bu$b;->dd:I", "FIELD:Lcom/boehmod/blockfront/bu$b;->a:Ljava/util/function/ToDoubleFunction;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "label;color;extractor", "FIELD:Lcom/boehmod/blockfront/bu$b;->B:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bu$b;->dd:I", "FIELD:Lcom/boehmod/blockfront/bu$b;->a:Ljava/util/function/ToDoubleFunction;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: c */
        public Component m714c() {
            return this.f964B;
        }

        /* JADX INFO: renamed from: u */
        public int m715u() {
            return this.f965dd;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public ToDoubleFunction<MatchSummary> m716a() {
            return this.f966a;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bu$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bu$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: A */
        @NotNull
        private final Component f957A;

        /* JADX INFO: renamed from: dc */
        private final int f958dc;

        /* JADX INFO: renamed from: cL */
        private final float f959cL;

        /* JADX INFO: renamed from: cM */
        private final float f960cM;

        /* JADX INFO: renamed from: cN */
        private final float f961cN;

        /* JADX INFO: renamed from: cO */
        private final float f962cO;

        /* JADX INFO: renamed from: s */
        @NotNull
        private final ObjectList<C0123bn> f963s;

        private a(@NotNull Component component, int i, float f, float f2, float f3, float f4, @NotNull ObjectList<C0123bn> objectList) {
            this.f957A = component;
            this.f958dc = i;
            this.f959cL = f;
            this.f960cM = f2;
            this.f961cN = f3;
            this.f962cO = f4;
            this.f963s = objectList;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "label;color;axisMax;axisStep;latest;average;points", "FIELD:Lcom/boehmod/blockfront/bu$a;->A:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bu$a;->dc:I", "FIELD:Lcom/boehmod/blockfront/bu$a;->cL:F", "FIELD:Lcom/boehmod/blockfront/bu$a;->cM:F", "FIELD:Lcom/boehmod/blockfront/bu$a;->cN:F", "FIELD:Lcom/boehmod/blockfront/bu$a;->cO:F", "FIELD:Lcom/boehmod/blockfront/bu$a;->s:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "label;color;axisMax;axisStep;latest;average;points", "FIELD:Lcom/boehmod/blockfront/bu$a;->A:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bu$a;->dc:I", "FIELD:Lcom/boehmod/blockfront/bu$a;->cL:F", "FIELD:Lcom/boehmod/blockfront/bu$a;->cM:F", "FIELD:Lcom/boehmod/blockfront/bu$a;->cN:F", "FIELD:Lcom/boehmod/blockfront/bu$a;->cO:F", "FIELD:Lcom/boehmod/blockfront/bu$a;->s:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "label;color;axisMax;axisStep;latest;average;points", "FIELD:Lcom/boehmod/blockfront/bu$a;->A:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bu$a;->dc:I", "FIELD:Lcom/boehmod/blockfront/bu$a;->cL:F", "FIELD:Lcom/boehmod/blockfront/bu$a;->cM:F", "FIELD:Lcom/boehmod/blockfront/bu$a;->cN:F", "FIELD:Lcom/boehmod/blockfront/bu$a;->cO:F", "FIELD:Lcom/boehmod/blockfront/bu$a;->s:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: c */
        public Component m707c() {
            return this.f957A;
        }

        /* JADX INFO: renamed from: u */
        public int m708u() {
            return this.f958dc;
        }

        /* JADX INFO: renamed from: k */
        public float m709k() {
            return this.f959cL;
        }

        /* JADX INFO: renamed from: l */
        public float m710l() {
            return this.f960cM;
        }

        /* JADX INFO: renamed from: m */
        public float m711m() {
            return this.f961cN;
        }

        /* JADX INFO: renamed from: n */
        public float m712n() {
            return this.f962cO;
        }

        @NotNull
        /* JADX INFO: renamed from: e */
        public ObjectList<C0123bn> m713e() {
            return this.f963s;
        }
    }

    public C0130bu(@NotNull ObjectList<MatchSummary> objectList, @NotNull List<b> list, int i, int i2, int i3, int i4) {
        this.f944az = list.size() == 1;
        int size = objectList.size();
        this.f946cR = size;
        this.f947cS = i + 8;
        this.f948cT = (i + i3) - 8;
        this.f949cU = i2 + 6;
        this.f950cV = this.f947cS + 22;
        this.f951cW = this.f948cT - this.f950cV;
        this.f952cX = i2 + 22;
        this.f953cY = (i2 + i4) - 12;
        this.f954cZ = this.f953cY - this.f952cX;
        int i5 = this.f950cV + 6;
        int i6 = this.f951cW - 12;
        float f = size > 1 ? i6 / (size - 1) : 0.0f;
        MatchSummary[] matchSummaryArr = new MatchSummary[size];
        int[] iArr = new int[size];
        for (int i7 = 0; i7 < size; i7++) {
            matchSummaryArr[i7] = (MatchSummary) objectList.get((size - 1) - i7);
            iArr[i7] = size == 1 ? i5 + (i6 / 2) : Math.round(i5 + (i7 * f));
        }
        this.f945r = new ObjectArrayList(list.size());
        for (b bVar : list) {
            float[] fArr = new float[size];
            float f2 = 0.0f;
            float fMax = 1.0E-4f;
            for (int i8 = 0; i8 < size; i8++) {
                float fApplyAsDouble = (float) bVar.m716a().applyAsDouble(matchSummaryArr[i8]);
                fArr[i8] = fApplyAsDouble;
                f2 += fApplyAsDouble;
                fMax = Math.max(fMax, fApplyAsDouble);
            }
            float f3 = size > 0 ? f2 / size : 0.0f;
            float f4 = size > 0 ? fArr[size - 1] : 0.0f;
            float fM7162a = C1270xJ.m7162a(fMax, 4);
            float fMax2 = Math.max(fM7162a, (float) (Math.ceil(fMax / fM7162a) * ((double) fM7162a)));
            ObjectArrayList objectArrayList = new ObjectArrayList(size);
            for (int i9 = 0; i9 < size; i9++) {
                objectArrayList.add(new C0123bn(matchSummaryArr[i9], iArr[i9], Math.round(this.f953cY - ((fArr[i9] / fMax2) * this.f954cZ))));
            }
            this.f945r.add(new a(bVar.m714c(), bVar.m715u(), fMax2, fM7162a, f4, f3, objectArrayList));
        }
    }

    /* JADX INFO: renamed from: m */
    public void m700m(@NotNull Minecraft minecraft) {
        this.f955da++;
        for (int i = 0; i < this.f946cR; i++) {
            boolean z = this.f955da >= i * 2;
            boolean z2 = false;
            ObjectListIterator it = this.f945r.iterator();
            while (it.hasNext()) {
                C0123bn c0123bn = (C0123bn) ((a) it.next()).m713e().get(i);
                if (!c0123bn.m432n() && z) {
                    c0123bn.m431A();
                    z2 = true;
                }
                c0123bn.tick();
            }
            if (z2) {
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.AMETHYST_BLOCK_STEP, this.f946cR > 1 ? 0.8f + ((i / (this.f946cR - 1)) * 0.4f) : 1.0f));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m701a(@NotNull GuiGraphics guiGraphics, @NotNull Minecraft minecraft, @NotNull Font font, int i, int i2, float f) {
        m702a(guiGraphics, font);
        m703b(guiGraphics, font);
        float f2 = this.f955da + f;
        int iM706b = m706b(i, i2);
        if (iM706b != this.f956db) {
            if (iM706b >= 0) {
                C0260eH.m1478r(minecraft);
            }
            this.f956db = iM706b;
        }
        if (!this.f944az && iM706b >= 0) {
            C0129bt.m515a(guiGraphics, ((C0123bn) ((a) this.f945r.get(0)).m713e().get(iM706b)).m434r(), this.f952cX, 1, this.f954cZ, f941cP);
        }
        ObjectListIterator it = this.f945r.iterator();
        while (it.hasNext()) {
            m704a(guiGraphics, (a) it.next(), f2);
        }
        ObjectListIterator it2 = this.f945r.iterator();
        while (it2.hasNext()) {
            m705a(guiGraphics, (a) it2.next(), iM706b, f);
        }
        if (iM706b >= 0) {
            guiGraphics.renderComponentTooltip(font, C0295eq.m1607a(((C0123bn) ((a) this.f945r.get(0)).m713e().get(iM706b)).m436a()), i, i2);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m702a(@NotNull GuiGraphics guiGraphics, @NotNull Font font) {
        if (this.f944az) {
            a aVar = (a) this.f945r.get(0);
            C0129bt.m471a(font, guiGraphics, (Component) Component.empty().append(aVar.m707c()).withStyle(ChatFormatting.BOLD), this.f947cS, this.f949cU, aVar.m708u());
            MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.matches.chart.average", new Object[]{C1273xM.m7240e(aVar.m711m()), C1273xM.m7240e(aVar.m712n())});
            C0129bt.m471a(font, guiGraphics, (Component) mutableComponentTranslatable, this.f948cT - font.width(mutableComponentTranslatable), this.f949cU, f939cN);
            return;
        }
        int iWidth = this.f947cS;
        ObjectListIterator it = this.f945r.iterator();
        while (it.hasNext()) {
            a aVar2 = (a) it.next();
            MutableComponent mutableComponentWithStyle = Component.empty().append(aVar2.m707c()).withStyle(ChatFormatting.BOLD);
            C0129bt.m471a(font, guiGraphics, (Component) mutableComponentWithStyle, iWidth, this.f949cU, aVar2.m708u());
            iWidth += font.width(mutableComponentWithStyle) + 8;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m703b(@NotNull GuiGraphics guiGraphics, @NotNull Font font) {
        if (this.f944az) {
            a aVar = (a) this.f945r.get(0);
            float fM710l = 0.0f;
            while (true) {
                float f = fM710l;
                if (f <= aVar.m709k() + (aVar.m710l() * 0.001f)) {
                    int iRound = Math.round(this.f953cY - ((f / aVar.m709k()) * this.f954cZ));
                    C0129bt.m515a(guiGraphics, this.f950cV, iRound, this.f951cW, 1, f940cO);
                    MutableComponent mutableComponentLiteral = Component.literal(C1273xM.m7240e(f));
                    C0129bt.m471a(font, guiGraphics, (Component) mutableComponentLiteral, (this.f950cV - 3) - font.width(mutableComponentLiteral), iRound - 4, f942cQ);
                    fM710l = f + aVar.m710l();
                } else {
                    return;
                }
            }
        } else {
            for (int i = 0; i <= 4; i++) {
                C0129bt.m515a(guiGraphics, this.f950cV, this.f953cY - Math.round((i / 4.0f) * this.f954cZ), this.f951cW, 1, f940cO);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m704a(@NotNull GuiGraphics guiGraphics, @NotNull a aVar, float f) {
        ObjectList<C0123bn> objectListM713e = aVar.m713e();
        for (int i = 0; i < this.f946cR - 1; i++) {
            C0123bn c0123bn = (C0123bn) objectListM713e.get(i);
            if (c0123bn.m432n()) {
                C0123bn c0123bn2 = (C0123bn) objectListM713e.get(i + 1);
                float fMax = Math.max(0.0f, Math.min(1.0f, (f - (i * 2)) / 2.0f));
                C0129bt.m521a(guiGraphics, c0123bn.m434r(), c0123bn.m435s(), c0123bn.m434r() + ((c0123bn2.m434r() - c0123bn.m434r()) * fMax), c0123bn.m435s() + ((c0123bn2.m435s() - c0123bn.m435s()) * fMax), 1.0f, aVar.m708u(), 0.4f);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m705a(@NotNull GuiGraphics guiGraphics, @NotNull a aVar, int i, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        ObjectList<C0123bn> objectListM713e = aVar.m713e();
        int i2 = 0;
        while (i2 < this.f946cR) {
            C0123bn c0123bn = (C0123bn) objectListM713e.get(i2);
            if (c0123bn.m432n()) {
                boolean z = i2 == i;
                float fM433f = c0123bn.m433f(f);
                if (fM433f > 0.0f || z) {
                    C0129bt.m547b(poseStackPose, guiGraphics, f943J, c0123bn.m434r(), c0123bn.m435s(), 32, 32, 0.0f, z ? 0.5f : fM433f * 0.5f, aVar.m708u());
                }
                int iM434r = c0123bn.m434r() - 1;
                int iM435s = c0123bn.m435s() - 1;
                C0129bt.m515a(guiGraphics, iM434r - 1, iM435s - 1, 5, 5, z ? aVar.m708u() : ColorReferences.COLOR_BLACK_SOLID);
                C0129bt.m515a(guiGraphics, iM434r, iM435s, 3, 3, z ? ColorReferences.COLOR_WHITE_SOLID : aVar.m708u());
                if (z && this.f944az) {
                    C0129bt.m523a(guiGraphics, iM434r + 1, iM435s - 10, 1, 10, ColorReferences.COLOR_BLACK_TRANSPARENT, aVar.m708u());
                    C0129bt.m523a(guiGraphics, iM434r + 1, iM435s + 3, 1, 10, aVar.m708u(), ColorReferences.COLOR_BLACK_TRANSPARENT);
                }
            }
            i2++;
        }
    }

    /* JADX INFO: renamed from: b */
    private int m706b(int i, int i2) {
        int iAbs;
        if (i < this.f950cV || i > this.f950cV + this.f951cW || i2 < this.f952cX || i2 > this.f953cY || this.f945r.isEmpty()) {
            return -1;
        }
        ObjectList<C0123bn> objectListM713e = ((a) this.f945r.get(0)).m713e();
        int iMax = Math.max(8, this.f951cW / Math.max(1, this.f946cR));
        int i3 = -1;
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < this.f946cR; i5++) {
            C0123bn c0123bn = (C0123bn) objectListM713e.get(i5);
            if (c0123bn.m432n() && (iAbs = Math.abs(i - c0123bn.m434r())) < i4 && iAbs <= iMax) {
                i3 = i5;
                i4 = iAbs;
            }
        }
        return i3;
    }
}
