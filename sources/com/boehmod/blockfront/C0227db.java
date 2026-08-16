package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.db */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/db.class */
public class C0227db extends AbstractC0229dd {

    /* JADX INFO: renamed from: ge */
    private static final int f1813ge = 600;

    /* JADX INFO: renamed from: gf */
    public static final int f1818gf = 640;

    /* JADX INFO: renamed from: gg */
    public static final int f1819gg = 360;

    /* JADX INFO: renamed from: gh */
    public static final int f1820gh = 5;

    /* JADX INFO: renamed from: gi */
    public static final int f1821gi = 6;

    /* JADX INFO: renamed from: gj */
    private static final int f1822gj = 50;

    /* JADX INFO: renamed from: gk */
    private static final int f1823gk = 15;

    /* JADX INFO: renamed from: gl */
    private static final int f1824gl = 81;

    /* JADX INFO: renamed from: gm */
    private static final int f1825gm = 82;

    /* JADX INFO: renamed from: gn */
    private static final int f1826gn = 80;

    /* JADX INFO: renamed from: go */
    private static final int f1827go = 35;

    /* JADX INFO: renamed from: gp */
    private static final int f1828gp = 50;

    /* JADX INFO: renamed from: gq */
    private static final int f1829gq = 116;

    /* JADX INFO: renamed from: gr */
    private static final int f1830gr = 131;

    /* JADX INFO: renamed from: gs */
    private static final int f1831gs = 197;

    /* JADX INFO: renamed from: gt */
    private static final int f1832gt = 208;

    /* JADX INFO: renamed from: bk */
    private boolean f1833bk;

    /* JADX INFO: renamed from: bl */
    private boolean f1834bl;

    /* JADX INFO: renamed from: aI */
    private float f1835aI;

    /* JADX INFO: renamed from: aJ */
    private float f1836aJ;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0303ey f1837a;

    /* JADX INFO: renamed from: bm */
    private boolean f1838bm;

    /* JADX INFO: renamed from: dp */
    private static final Component f1809dp = Component.translatable("bf.message.game.match.summary.vote.subtitle").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: dq */
    private static final Component f1810dq = Component.translatable("bf.message.game.match.summary.vote.subtitle.tip");

    /* JADX INFO: renamed from: dr */
    private static final Component f1811dr = Component.translatable("bf.message.map.vote.no.maps.title").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: ds */
    private static final Component f1812ds = Component.translatable("bf.message.map.vote.no.maps.message").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: dt */
    private static final Component f1814dt = Component.translatable("bf.message.game.match.summary.vote.title").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: d */
    @Nonnull
    private static final MutableComponent f1815d = Component.translatable("bf.message.game.match.summary.vote.title.gamemode.same");

    /* JADX INFO: renamed from: e */
    @Nonnull
    private static final MutableComponent f1816e = Component.translatable("bf.message.game.match.summary.vote.title.gamemode.other");

    /* JADX INFO: renamed from: f */
    @Nonnull
    private static final MutableComponent f1817f = Component.translatable("bf.message.game.match.summary.vote.title.rate");

    public C0227db(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        this(abstractC0863pb, C1062tN.f5748l);
    }

    public C0227db(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C1060tL c1060tL) {
        super(abstractC0863pb.m4064e());
        this.f1833bk = false;
        this.f1834bl = false;
        this.f1836aJ = 0.0f;
        this.f1837a = null;
        this.f1838bm = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd, com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        if (this.f1837a != null) {
            this.f1837a.m1638m(this.f1058a);
        }
        AbstractC0864pc<?, ?> abstractC0864pcM2878a = this.f1057f.m2878a();
        if (abstractC0864pcM2878a != null) {
            if ((abstractC0864pcM2878a.m4114a().m4335bq() <= 8) && !this.f1833bk) {
                this.f1833bk = true;
                this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7943oQ.get(), 1.0f, 1.0f));
            }
            boolean z = abstractC0864pcM2878a.m4114a().m4335bq() <= 2;
            if (z && !this.f1834bl) {
                this.f1834bl = true;
                this.f1057f.m2895a().m3052a(new C0688mL(1.0f, 2.0f, 1.0f));
            }
            this.f1836aJ = this.f1835aI;
            this.f1835aI = C1270xJ.m7161d(this.f1835aI, z ? 1.0f : 0.0f, 0.025f);
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        m1336ab();
        if (!this.f1057f.m2875d()) {
            this.f1837a = new C0303ey((this.width / 2) - 40, f1832gt, 80, 16);
            addRenderableWidget(this.f1837a);
        }
    }

    /* JADX INFO: renamed from: ab */
    private void m1336ab() {
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = this.f1057f.m2874a();
        if (abstractC0863pbM2874a == null) {
            return;
        }
        this.f1054r.clear();
        int i = this.width / 2;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C1064tP c1064tP : abstractC0863pbM2874a.m4065a().m5924aG()) {
            if (c1064tP.m5910ay().equals(abstractC0863pbM2874a.m4030T())) {
                objectArrayList.add(new C0228dc(i, 50, 106, 60, this, c1064tP));
            }
        }
        int iSum = i - (objectArrayList.stream().mapToInt(c0228dc -> {
            return c0228dc.m374x() + 5;
        }).sum() / 2);
        int iX = 2;
        ObjectListIterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            C0228dc c0228dc2 = (C0228dc) it.next();
            c0228dc2.m375c(iSum + iX);
            m794a((C0088bE) c0228dc2);
            iX += c0228dc2.m374x() + 5;
        }
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        for (C1064tP c1064tP2 : abstractC0863pbM2874a.m4065a().m5924aG()) {
            if (!c1064tP2.m5910ay().equals(abstractC0863pbM2874a.m4030T())) {
                objectArrayList2.add(new C0228dc(i, f1830gr, 106, 60, this, c1064tP2));
            }
        }
        this.f1838bm = !objectArrayList2.isEmpty();
        int iSum2 = i - (objectArrayList2.stream().mapToInt(c0228dc3 -> {
            return c0228dc3.m374x() + 5;
        }).sum() / 2);
        int iX2 = 2;
        ObjectListIterator it2 = objectArrayList2.iterator();
        while (it2.hasNext()) {
            C0228dc c0228dc4 = (C0228dc) it2.next();
            c0228dc4.m375c(iSum2 + iX2);
            m794a((C0088bE) c0228dc4);
            iX2 += c0228dc4.m374x() + 5;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd, com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = this.f1057f.m2874a();
        if (abstractC0863pbM2874a == null) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        if (abstractC0863pbM2874a.m4065a().m5924aG().isEmpty()) {
            C0129bt.m494c(poseStackPose, this.font, guiGraphics, f1811dr, i3, i4 - 35, 1.0f);
            C0129bt.m494c(poseStackPose, this.font, guiGraphics, f1812ds, i3, i4 - 20, 0.5f);
        }
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        C0129bt.m517a(guiGraphics, 0, 0, this.width, this.height, 0, C1270xJ.m7170f(this.f1835aI, this.f1836aJ, f));
        poseStackPose.popPose();
        C0129bt.m499a(poseStackPose, this.font, guiGraphics, (Component) Component.literal(C1273xM.m7244p(f1815d.getString())), i3, 35);
        if (this.f1838bm) {
            C0129bt.m499a(poseStackPose, this.font, guiGraphics, (Component) Component.literal(C1273xM.m7244p(f1816e.getString())), i3, f1829gq);
        }
        if (!this.f1057f.m2875d()) {
            C0129bt.m499a(poseStackPose, this.font, guiGraphics, (Component) Component.literal(C1273xM.m7244p(f1817f.getString())), i3, f1831gs);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    @NotNull
    /* JADX INFO: renamed from: a */
    protected SoundEvent mo1337a() {
        return (SoundEvent) C1312xz.f7942oP.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    /* JADX INFO: renamed from: K */
    protected int mo1338K() {
        return 600;
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    @NotNull
    /* JADX INFO: renamed from: g */
    protected Component mo1339g() {
        return f1814dt;
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    @NotNull
    /* JADX INFO: renamed from: h */
    protected Component mo1340h() {
        return f1809dp;
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    @NotNull
    /* JADX INFO: renamed from: i */
    protected Component mo1341i() {
        return f1810dq;
    }
}
