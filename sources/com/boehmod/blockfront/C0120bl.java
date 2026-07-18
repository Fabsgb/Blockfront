package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.report.MatchSummary;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.bl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bl.class */
public final class C0120bl {

    /* JADX INFO: renamed from: bP */
    private static final int f796bP = 2;

    /* JADX INFO: renamed from: cD */
    private static final float f797cD = 1.0f;

    /* JADX INFO: renamed from: cE */
    private static final float f798cE = 0.4f;

    /* JADX INFO: renamed from: bQ */
    private static final int f799bQ = 3;

    /* JADX INFO: renamed from: bR */
    private static final int f800bR = 10;

    /* JADX INFO: renamed from: bS */
    private static final int f801bS = 32;

    /* JADX INFO: renamed from: bT */
    private static final int f802bT = 4;

    /* JADX INFO: renamed from: bU */
    private static final int f803bU = 8;

    /* JADX INFO: renamed from: bV */
    private static final int f804bV = -5592406;

    /* JADX INFO: renamed from: bW */
    private static final int f805bW = 654311423;

    /* JADX INFO: renamed from: bX */
    private static final int f806bX = 1090519039;

    /* JADX INFO: renamed from: bY */
    private static final int f807bY = -7829368;

    /* JADX INFO: renamed from: J */
    @NotNull
    private static final ResourceLocation f808J = C0564jv.m2555d("textures/gui/backshadow_white.png");

    /* JADX INFO: renamed from: au */
    private final boolean f809au;

    /* JADX INFO: renamed from: i */
    @NotNull
    private final ObjectList<a> f810i;

    /* JADX INFO: renamed from: bZ */
    private final int f811bZ;

    /* JADX INFO: renamed from: ca */
    private final int f812ca;

    /* JADX INFO: renamed from: cb */
    private final int f813cb;

    /* JADX INFO: renamed from: cc */
    private final int f814cc;

    /* JADX INFO: renamed from: cd */
    private final int f815cd;

    /* JADX INFO: renamed from: ce */
    private final int f816ce;

    /* JADX INFO: renamed from: cf */
    private final int f817cf;

    /* JADX INFO: renamed from: cg */
    private final int f818cg;

    /* JADX INFO: renamed from: ch */
    private final int f819ch;

    /* JADX INFO: renamed from: ci */
    private int f820ci;

    /* JADX INFO: renamed from: cj */
    private int f821cj = -1;

    /* JADX INFO: renamed from: com.boehmod.blockfront.bl$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bl$b.class */
    public static final class b extends Record {

        /* JADX INFO: renamed from: B */
        @NotNull
        private final Component f829B;

        /* JADX INFO: renamed from: cl */
        private final int f830cl;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final ToDoubleFunction<MatchSummary> f831a;

        public b(@NotNull Component component, int i, @NotNull ToDoubleFunction<MatchSummary> toDoubleFunction) {
            this.f829B = component;
            this.f830cl = i;
            this.f831a = toDoubleFunction;
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
        /* JADX INFO: renamed from: c */
        public Component m609c() {
            return this.f829B;
        }

        /* JADX INFO: renamed from: q */
        public int m610q() {
            return this.f830cl;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public ToDoubleFunction<MatchSummary> m611a() {
            return this.f831a;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bl$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bl$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: A */
        @NotNull
        private final Component f822A;

        /* JADX INFO: renamed from: ck */
        private final int f823ck;

        /* JADX INFO: renamed from: cF */
        private final float f824cF;

        /* JADX INFO: renamed from: cG */
        private final float f825cG;

        /* JADX INFO: renamed from: cH */
        private final float f826cH;

        /* JADX INFO: renamed from: cI */
        private final float f827cI;

        /* JADX INFO: renamed from: j */
        @NotNull
        private final ObjectList<C0114bf> f828j;

        private a(@NotNull Component component, int i, float f, float f2, float f3, float f4, @NotNull ObjectList<C0114bf> objectList) {
            this.f822A = component;
            this.f823ck = i;
            this.f824cF = f;
            this.f825cG = f2;
            this.f826cH = f3;
            this.f827cI = f4;
            this.f828j = objectList;
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
        /* JADX INFO: renamed from: c */
        public Component m602c() {
            return this.f822A;
        }

        /* JADX INFO: renamed from: q */
        public int m603q() {
            return this.f823ck;
        }

        /* JADX INFO: renamed from: k */
        public float m604k() {
            return this.f824cF;
        }

        /* JADX INFO: renamed from: l */
        public float m605l() {
            return this.f825cG;
        }

        /* JADX INFO: renamed from: m */
        public float m606m() {
            return this.f826cH;
        }

        /* JADX INFO: renamed from: n */
        public float m607n() {
            return this.f827cI;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public ObjectList<C0114bf> m608a() {
            return this.f828j;
        }
    }

    public C0120bl(@NotNull ObjectList<MatchSummary> objectList, @NotNull List<b> list, int i, int i2, int i3, int i4) {
        this.f809au = list.size() == 1;
        int size = objectList.size();
        this.f811bZ = size;
        this.f812ca = i + 8;
        this.f813cb = (i + i3) - 8;
        this.f814cc = i2 + 6;
        this.f815cd = this.f812ca + 22;
        this.f816ce = this.f813cb - this.f815cd;
        this.f817cf = i2 + 22;
        this.f818cg = (i2 + i4) - 12;
        this.f819ch = this.f818cg - this.f817cf;
        int i5 = this.f815cd + 6;
        int i6 = this.f816ce - 12;
        float f = size > 1 ? i6 / (size - 1) : 0.0f;
        MatchSummary[] matchSummaryArr = new MatchSummary[size];
        int[] iArr = new int[size];
        for (int i7 = 0; i7 < size; i7++) {
            matchSummaryArr[i7] = (MatchSummary) objectList.get((size - 1) - i7);
            iArr[i7] = size == 1 ? i5 + (i6 / 2) : Math.round(i5 + (i7 * f));
        }
        this.f810i = new ObjectArrayList(list.size());
        for (b bVar : list) {
            float[] fArr = new float[size];
            float f2 = 0.0f;
            float fMax = 1.0E-4f;
            for (int i8 = 0; i8 < size; i8++) {
                float fApplyAsDouble = (float) bVar.m611a().applyAsDouble(matchSummaryArr[i8]);
                fArr[i8] = fApplyAsDouble;
                f2 += fApplyAsDouble;
                fMax = Math.max(fMax, fApplyAsDouble);
            }
            float f3 = size > 0 ? f2 / size : 0.0f;
            float f4 = size > 0 ? fArr[size - 1] : 0.0f;
            float fM7836a = C1290xm.m7836a(fMax, 4);
            float fMax2 = Math.max(fM7836a, (float) (Math.ceil(fMax / fM7836a) * ((double) fM7836a)));
            ObjectArrayList objectArrayList = new ObjectArrayList(size);
            for (int i9 = 0; i9 < size; i9++) {
                objectArrayList.add(new C0114bf(matchSummaryArr[i9], iArr[i9], Math.round(this.f818cg - ((fArr[i9] / fMax2) * this.f819ch))));
            }
            this.f810i.add(new a(bVar.m609c(), bVar.m610q(), fMax2, fM7836a, f4, f3, objectArrayList));
        }
    }

    /* JADX INFO: renamed from: l */
    public void m595l(@NotNull Minecraft minecraft) {
        this.f820ci++;
        for (int i = 0; i < this.f811bZ; i++) {
            boolean z = this.f820ci >= i * 2;
            boolean z2 = false;
            ObjectListIterator it = this.f810i.iterator();
            while (it.hasNext()) {
                C0114bf c0114bf = (C0114bf) ((a) it.next()).m608a().get(i);
                if (!c0114bf.m339m() && z) {
                    c0114bf.m338x();
                    z2 = true;
                }
                c0114bf.tick();
            }
            if (z2) {
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.AMETHYST_BLOCK_STEP, this.f811bZ > 1 ? 0.8f + ((i / (this.f811bZ - 1)) * 0.4f) : 1.0f));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m596a(@NotNull GuiGraphics guiGraphics, @NotNull Minecraft minecraft, @NotNull Font font, int i, int i2, float f) {
        m597a(guiGraphics, font);
        m598b(guiGraphics, font);
        float f2 = this.f820ci + f;
        int iM601a = m601a(i, i2);
        if (iM601a != this.f821cj) {
            if (iM601a >= 0) {
                C0298eu.m1576q(minecraft);
            }
            this.f821cj = iM601a;
        }
        if (!this.f809au && iM601a >= 0) {
            C0119bk.m415a(guiGraphics, ((C0114bf) ((a) this.f810i.get(0)).m608a().get(iM601a)).m341n(), this.f817cf, 1, this.f819ch, f806bX);
        }
        ObjectListIterator it = this.f810i.iterator();
        while (it.hasNext()) {
            m599a(guiGraphics, (a) it.next(), f2);
        }
        ObjectListIterator it2 = this.f810i.iterator();
        while (it2.hasNext()) {
            m600a(guiGraphics, (a) it2.next(), iM601a, f);
        }
        if (iM601a >= 0) {
            guiGraphics.renderComponentTooltip(font, C0282ee.m1491a(((C0114bf) ((a) this.f810i.get(0)).m608a().get(iM601a)).m343a()), i, i2);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m597a(@NotNull GuiGraphics guiGraphics, @NotNull Font font) {
        if (this.f809au) {
            a aVar = (a) this.f810i.get(0);
            C0119bk.m371a(font, guiGraphics, (Component) Component.empty().append(aVar.m602c()).withStyle(ChatFormatting.BOLD), this.f812ca, this.f814cc, aVar.m603q());
            MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.matches.chart.average", new Object[]{C1293xp.m7913d(aVar.m606m()), C1293xp.m7913d(aVar.m607n())});
            C0119bk.m371a(font, guiGraphics, (Component) mutableComponentTranslatable, this.f813cb - font.width(mutableComponentTranslatable), this.f814cc, f804bV);
            return;
        }
        int iWidth = this.f812ca;
        ObjectListIterator it = this.f810i.iterator();
        while (it.hasNext()) {
            a aVar2 = (a) it.next();
            MutableComponent mutableComponentWithStyle = Component.empty().append(aVar2.m602c()).withStyle(ChatFormatting.BOLD);
            C0119bk.m371a(font, guiGraphics, (Component) mutableComponentWithStyle, iWidth, this.f814cc, aVar2.m603q());
            iWidth += font.width(mutableComponentWithStyle) + 8;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m598b(@NotNull GuiGraphics guiGraphics, @NotNull Font font) {
        if (this.f809au) {
            a aVar = (a) this.f810i.get(0);
            float fM605l = 0.0f;
            while (true) {
                float f = fM605l;
                if (f <= aVar.m604k() + (aVar.m605l() * 0.001f)) {
                    int iRound = Math.round(this.f818cg - ((f / aVar.m604k()) * this.f819ch));
                    C0119bk.m415a(guiGraphics, this.f815cd, iRound, this.f816ce, 1, f805bW);
                    MutableComponent mutableComponentLiteral = Component.literal(C1293xp.m7913d(f));
                    C0119bk.m371a(font, guiGraphics, (Component) mutableComponentLiteral, (this.f815cd - 3) - font.width(mutableComponentLiteral), iRound - 4, f807bY);
                    fM605l = f + aVar.m605l();
                } else {
                    return;
                }
            }
        } else {
            for (int i = 0; i <= 4; i++) {
                C0119bk.m415a(guiGraphics, this.f815cd, this.f818cg - Math.round((i / 4.0f) * this.f819ch), this.f816ce, 1, f805bW);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m599a(@NotNull GuiGraphics guiGraphics, @NotNull a aVar, float f) {
        ObjectList<C0114bf> objectListM608a = aVar.m608a();
        for (int i = 0; i < this.f811bZ - 1; i++) {
            if (((C0114bf) objectListM608a.get(i)).m339m()) {
                C0114bf c0114bf = (C0114bf) objectListM608a.get(i + 1);
                float fMax = Math.max(0.0f, Math.min(1.0f, (f - (i * 2)) / 2.0f));
                C0119bk.m421a(guiGraphics, r0.m341n(), r0.m342o(), r0.m341n() + ((c0114bf.m341n() - r0.m341n()) * fMax), r0.m342o() + ((c0114bf.m342o() - r0.m342o()) * fMax), 1.0f, aVar.m603q(), 0.4f);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m600a(@NotNull GuiGraphics guiGraphics, @NotNull a aVar, int i, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        ObjectList<C0114bf> objectListM608a = aVar.m608a();
        int i2 = 0;
        while (i2 < this.f811bZ) {
            C0114bf c0114bf = (C0114bf) objectListM608a.get(i2);
            if (c0114bf.m339m()) {
                boolean z = i2 == i;
                float fM340f = c0114bf.m340f(f);
                if (fM340f > 0.0f || z) {
                    C0119bk.m447b(poseStackPose, guiGraphics, f808J, c0114bf.m341n(), c0114bf.m342o(), 32, 32, 0.0f, z ? 0.5f : fM340f * 0.5f, aVar.m603q());
                }
                int iM341n = c0114bf.m341n() - 1;
                int iM342o = c0114bf.m342o() - 1;
                C0119bk.m415a(guiGraphics, iM341n - 1, iM342o - 1, 5, 5, z ? aVar.m603q() : ColorReferences.COLOR_BLACK_SOLID);
                C0119bk.m415a(guiGraphics, iM341n, iM342o, 3, 3, z ? ColorReferences.COLOR_WHITE_SOLID : aVar.m603q());
                if (z && this.f809au) {
                    C0119bk.m423a(guiGraphics, iM341n + 1, iM342o - 10, 1, 10, ColorReferences.COLOR_BLACK_TRANSPARENT, aVar.m603q());
                    C0119bk.m423a(guiGraphics, iM341n + 1, iM342o + 3, 1, 10, aVar.m603q(), ColorReferences.COLOR_BLACK_TRANSPARENT);
                }
            }
            i2++;
        }
    }

    /* JADX INFO: renamed from: a */
    private int m601a(int i, int i2) {
        int iAbs;
        if (i < this.f815cd || i > this.f815cd + this.f816ce || i2 < this.f817cf || i2 > this.f818cg || this.f810i.isEmpty()) {
            return -1;
        }
        ObjectList<C0114bf> objectListM608a = ((a) this.f810i.get(0)).m608a();
        int iMax = Math.max(8, this.f816ce / Math.max(1, this.f811bZ));
        int i3 = -1;
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < this.f811bZ; i5++) {
            C0114bf c0114bf = (C0114bf) objectListM608a.get(i5);
            if (c0114bf.m339m() && (iAbs = Math.abs(i - c0114bf.m341n())) < i4 && iAbs <= iMax) {
                i3 = i5;
                i4 = iAbs;
            }
        }
        return i3;
    }
}
