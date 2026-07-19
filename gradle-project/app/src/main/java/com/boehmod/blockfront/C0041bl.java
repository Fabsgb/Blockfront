package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.report.MatchSummary;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.bl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bl.class */
public final class C0041bl {
    private static final int bP = 2;
    private static final float cD = 1.0f;
    private static final float cE = 0.4f;
    private static final int bQ = 3;
    private static final int bR = 10;
    private static final int bS = 32;
    private static final int bT = 4;
    private static final int bU = 8;
    private static final int bV = -5592406;
    private static final int bW = 654311423;
    private static final int bX = 1090519039;
    private static final int bY = -7829368;

    @NotNull
    private static final ResourceLocation J = C0265jv.d("textures/gui/backshadow_white.png");
    private final boolean au;

    @NotNull
    private final ObjectList<a> i;
    private final int bZ;
    private final int ca;
    private final int cb;
    private final int cc;
    private final int cd;
    private final int ce;
    private final int cf;
    private final int cg;
    private final int ch;
    private int ci;
    private int cj = -1;

    /* JADX INFO: renamed from: com.boehmod.blockfront.bl$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bl$b.class */
    public static final class b extends Record {

        @NotNull
        private final Component B;
        private final int cl;

        @NotNull
        private final ToDoubleFunction<MatchSummary> a;

        public b(@NotNull Component component, int i, @NotNull ToDoubleFunction<MatchSummary> toDoubleFunction) {
            this.B = component;
            this.cl = i;
            this.a = toDoubleFunction;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "label;color;extractor", "FIELD:Lcom/boehmod/blockfront/bl$b;->B:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bl$b;->cl:I", "FIELD:Lcom/boehmod/blockfront/bl$b;->a:Ljava/util/function/ToDoubleFunction;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "label;color;extractor", "FIELD:Lcom/boehmod/blockfront/bl$b;->B:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bl$b;->cl:I", "FIELD:Lcom/boehmod/blockfront/bl$b;->a:Ljava/util/function/ToDoubleFunction;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "label;color;extractor", "FIELD:Lcom/boehmod/blockfront/bl$b;->B:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bl$b;->cl:I", "FIELD:Lcom/boehmod/blockfront/bl$b;->a:Ljava/util/function/ToDoubleFunction;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        public Component c() {
            return this.B;
        }

        public int q() {
            return this.cl;
        }

        @NotNull
        public ToDoubleFunction<MatchSummary> a() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bl$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bl$a.class */
    private static final class a extends Record {

        @NotNull
        private final Component A;
        private final int ck;
        private final float cF;
        private final float cG;
        private final float cH;
        private final float cI;

        @NotNull
        private final ObjectList<C0035bf> j;

        private a(@NotNull Component component, int i, float f, float f2, float f3, float f4, @NotNull ObjectList<C0035bf> objectList) {
            this.A = component;
            this.ck = i;
            this.cF = f;
            this.cG = f2;
            this.cH = f3;
            this.cI = f4;
            this.j = objectList;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "label;color;axisMax;axisStep;latest;average;points", "FIELD:Lcom/boehmod/blockfront/bl$a;->A:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bl$a;->ck:I", "FIELD:Lcom/boehmod/blockfront/bl$a;->cF:F", "FIELD:Lcom/boehmod/blockfront/bl$a;->cG:F", "FIELD:Lcom/boehmod/blockfront/bl$a;->cH:F", "FIELD:Lcom/boehmod/blockfront/bl$a;->cI:F", "FIELD:Lcom/boehmod/blockfront/bl$a;->j:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "label;color;axisMax;axisStep;latest;average;points", "FIELD:Lcom/boehmod/blockfront/bl$a;->A:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bl$a;->ck:I", "FIELD:Lcom/boehmod/blockfront/bl$a;->cF:F", "FIELD:Lcom/boehmod/blockfront/bl$a;->cG:F", "FIELD:Lcom/boehmod/blockfront/bl$a;->cH:F", "FIELD:Lcom/boehmod/blockfront/bl$a;->cI:F", "FIELD:Lcom/boehmod/blockfront/bl$a;->j:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "label;color;axisMax;axisStep;latest;average;points", "FIELD:Lcom/boehmod/blockfront/bl$a;->A:Lnet/minecraft/network/chat/Component;", "FIELD:Lcom/boehmod/blockfront/bl$a;->ck:I", "FIELD:Lcom/boehmod/blockfront/bl$a;->cF:F", "FIELD:Lcom/boehmod/blockfront/bl$a;->cG:F", "FIELD:Lcom/boehmod/blockfront/bl$a;->cH:F", "FIELD:Lcom/boehmod/blockfront/bl$a;->cI:F", "FIELD:Lcom/boehmod/blockfront/bl$a;->j:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        public Component c() {
            return this.A;
        }

        public int q() {
            return this.ck;
        }

        public float k() {
            return this.cF;
        }

        public float l() {
            return this.cG;
        }

        public float m() {
            return this.cH;
        }

        public float n() {
            return this.cI;
        }

        @NotNull
        public ObjectList<C0035bf> a() {
            return this.j;
        }
    }

    public C0041bl(@NotNull ObjectList<MatchSummary> objectList, @NotNull List<b> list, int i, int i2, int i3, int i4) {
        this.au = list.size() == 1;
        int size = objectList.size();
        this.bZ = size;
        this.ca = i + 8;
        this.cb = (i + i3) - 8;
        this.cc = i2 + 6;
        this.cd = this.ca + 22;
        this.ce = this.cb - this.cd;
        this.cf = i2 + 22;
        this.cg = (i2 + i4) - 12;
        this.ch = this.cg - this.cf;
        int i5 = this.cd + 6;
        int i6 = this.ce - 12;
        float f = size > 1 ? i6 / (size - 1) : 0.0f;
        MatchSummary[] matchSummaryArr = new MatchSummary[size];
        int[] iArr = new int[size];
        for (int i7 = 0; i7 < size; i7++) {
            matchSummaryArr[i7] = (MatchSummary) objectList.get((size - 1) - i7);
            iArr[i7] = size == 1 ? i5 + (i6 / 2) : Math.round(i5 + (i7 * f));
        }
        this.i = new ObjectArrayList(list.size());
        for (b bVar : list) {
            float[] fArr = new float[size];
            float f2 = 0.0f;
            float fMax = 1.0E-4f;
            for (int i8 = 0; i8 < size; i8++) {
                float fApplyAsDouble = (float) bVar.a().applyAsDouble(matchSummaryArr[i8]);
                fArr[i8] = fApplyAsDouble;
                f2 += fApplyAsDouble;
                fMax = Math.max(fMax, fApplyAsDouble);
            }
            float f3 = size > 0 ? f2 / size : 0.0f;
            float f4 = size > 0 ? fArr[size - 1] : 0.0f;
            float fA = C0634xm.a(fMax, 4);
            float fMax2 = Math.max(fA, (float) (Math.ceil(fMax / fA) * ((double) fA)));
            ObjectArrayList objectArrayList = new ObjectArrayList(size);
            for (int i9 = 0; i9 < size; i9++) {
                objectArrayList.add(new C0035bf(matchSummaryArr[i9], iArr[i9], Math.round(this.cg - ((fArr[i9] / fMax2) * this.ch))));
            }
            this.i.add(new a(bVar.c(), bVar.q(), fMax2, fA, f4, f3, objectArrayList));
        }
    }

    public void l(@NotNull Minecraft minecraft) {
        this.ci++;
        for (int i = 0; i < this.bZ; i++) {
            boolean z = this.ci >= i * 2;
            boolean z2 = false;
            ObjectListIterator it = this.i.iterator();
            while (it.hasNext()) {
                C0035bf c0035bf = (C0035bf) ((a) it.next()).a().get(i);
                if (!c0035bf.m() && z) {
                    c0035bf.x();
                    z2 = true;
                }
                c0035bf.tick();
            }
            if (z2) {
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.AMETHYST_BLOCK_STEP, this.bZ > 1 ? 0.8f + ((i / (this.bZ - 1)) * 0.4f) : 1.0f));
            }
        }
    }

    public void a(@NotNull GuiGraphics guiGraphics, @NotNull Minecraft minecraft, @NotNull Font font, int i, int i2, float f) {
        a(guiGraphics, font);
        b(guiGraphics, font);
        float f2 = this.ci + f;
        int iA = a(i, i2);
        if (iA != this.cj) {
            if (iA >= 0) {
                C0130eu.q(minecraft);
            }
            this.cj = iA;
        }
        if (!this.au && iA >= 0) {
            C0040bk.a(guiGraphics, ((C0035bf) ((a) this.i.get(0)).a().get(iA)).n(), this.cf, 1, this.ch, bX);
        }
        ObjectListIterator it = this.i.iterator();
        while (it.hasNext()) {
            a(guiGraphics, (a) it.next(), f2);
        }
        ObjectListIterator it2 = this.i.iterator();
        while (it2.hasNext()) {
            a(guiGraphics, (a) it2.next(), iA, f);
        }
        if (iA >= 0) {
            guiGraphics.renderComponentTooltip(font, C0114ee.a(((C0035bf) ((a) this.i.get(0)).a().get(iA)).a()), i, i2);
        }
    }

    private void a(@NotNull GuiGraphics guiGraphics, @NotNull Font font) {
        if (this.au) {
            a aVar = (a) this.i.get(0);
            C0040bk.a(font, guiGraphics, (Component) Component.empty().append(aVar.c()).withStyle(ChatFormatting.BOLD), this.ca, this.cc, aVar.q());
            MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.matches.chart.average", new Object[]{C0637xp.d(aVar.m()), C0637xp.d(aVar.n())});
            C0040bk.a(font, guiGraphics, (Component) mutableComponentTranslatable, this.cb - font.width(mutableComponentTranslatable), this.cc, bV);
            return;
        }
        int iWidth = this.ca;
        ObjectListIterator it = this.i.iterator();
        while (it.hasNext()) {
            a aVar2 = (a) it.next();
            MutableComponent mutableComponentWithStyle = Component.empty().append(aVar2.c()).withStyle(ChatFormatting.BOLD);
            C0040bk.a(font, guiGraphics, (Component) mutableComponentWithStyle, iWidth, this.cc, aVar2.q());
            iWidth += font.width(mutableComponentWithStyle) + 8;
        }
    }

    private void b(@NotNull GuiGraphics guiGraphics, @NotNull Font font) {
        if (this.au) {
            a aVar = (a) this.i.get(0);
            float fL = 0.0f;
            while (true) {
                float f = fL;
                if (f <= aVar.k() + (aVar.l() * 0.001f)) {
                    int iRound = Math.round(this.cg - ((f / aVar.k()) * this.ch));
                    C0040bk.a(guiGraphics, this.cd, iRound, this.ce, 1, bW);
                    MutableComponent mutableComponentLiteral = Component.literal(C0637xp.d(f));
                    C0040bk.a(font, guiGraphics, (Component) mutableComponentLiteral, (this.cd - 3) - font.width(mutableComponentLiteral), iRound - 4, bY);
                    fL = f + aVar.l();
                } else {
                    return;
                }
            }
        } else {
            for (int i = 0; i <= 4; i++) {
                C0040bk.a(guiGraphics, this.cd, this.cg - Math.round((i / 4.0f) * this.ch), this.ce, 1, bW);
            }
        }
    }

    private void a(@NotNull GuiGraphics guiGraphics, @NotNull a aVar, float f) {
        ObjectList<C0035bf> objectListA = aVar.a();
        for (int i = 0; i < this.bZ - 1; i++) {
            if (((C0035bf) objectListA.get(i)).m()) {
                C0035bf c0035bf = (C0035bf) objectListA.get(i + 1);
                float fMax = Math.max(0.0f, Math.min(1.0f, (f - (i * 2)) / 2.0f));
                C0040bk.a(guiGraphics, r0.n(), r0.o(), r0.n() + ((c0035bf.n() - r0.n()) * fMax), r0.o() + ((c0035bf.o() - r0.o()) * fMax), 1.0f, aVar.q(), 0.4f);
            } else {
                return;
            }
        }
    }

    private void a(@NotNull GuiGraphics guiGraphics, @NotNull a aVar, int i, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        ObjectList<C0035bf> objectListA = aVar.a();
        int i2 = 0;
        while (i2 < this.bZ) {
            C0035bf c0035bf = (C0035bf) objectListA.get(i2);
            if (c0035bf.m()) {
                boolean z = i2 == i;
                float f2 = c0035bf.f(f);
                if (f2 > 0.0f || z) {
                    C0040bk.b(poseStackPose, guiGraphics, J, c0035bf.n(), c0035bf.o(), 32, 32, 0.0f, z ? 0.5f : f2 * 0.5f, aVar.q());
                }
                int iN = c0035bf.n() - 1;
                int iO = c0035bf.o() - 1;
                C0040bk.a(guiGraphics, iN - 1, iO - 1, 5, 5, z ? aVar.q() : ColorReferences.COLOR_BLACK_SOLID);
                C0040bk.a(guiGraphics, iN, iO, 3, 3, z ? ColorReferences.COLOR_WHITE_SOLID : aVar.q());
                if (z && this.au) {
                    C0040bk.a(guiGraphics, iN + 1, iO - 10, 1, 10, ColorReferences.COLOR_BLACK_TRANSPARENT, aVar.q());
                    C0040bk.a(guiGraphics, iN + 1, iO + 3, 1, 10, aVar.q(), ColorReferences.COLOR_BLACK_TRANSPARENT);
                }
            }
            i2++;
        }
    }

    private int a(int i, int i2) {
        int iAbs;
        if (i < this.cd || i > this.cd + this.ce || i2 < this.cf || i2 > this.cg || this.i.isEmpty()) {
            return -1;
        }
        ObjectList<C0035bf> objectListA = ((a) this.i.get(0)).a();
        int iMax = Math.max(8, this.ce / Math.max(1, this.bZ));
        int i3 = -1;
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < this.bZ; i5++) {
            C0035bf c0035bf = (C0035bf) objectListA.get(i5);
            if (c0035bf.m() && (iAbs = Math.abs(i - c0035bf.n())) < i4 && iAbs <= iMax) {
                i3 = i5;
                i4 = iAbs;
            }
        }
        return i3;
    }
}
