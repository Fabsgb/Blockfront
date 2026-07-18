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

/* JADX INFO: renamed from: com.boehmod.blockfront.cS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cS.class */
public class C0154cS extends AbstractC0156cU {

    /* JADX INFO: renamed from: fe */
    private static final int f1242fe = 600;

    /* JADX INFO: renamed from: ff */
    public static final int f1247ff = 640;

    /* JADX INFO: renamed from: fg */
    public static final int f1248fg = 360;

    /* JADX INFO: renamed from: fh */
    public static final int f1249fh = 5;

    /* JADX INFO: renamed from: fi */
    public static final int f1250fi = 6;

    /* JADX INFO: renamed from: fj */
    private static final int f1251fj = 50;

    /* JADX INFO: renamed from: fk */
    private static final int f1252fk = 15;

    /* JADX INFO: renamed from: fl */
    private static final int f1253fl = 81;

    /* JADX INFO: renamed from: fm */
    private static final int f1254fm = 82;

    /* JADX INFO: renamed from: fn */
    private static final int f1255fn = 80;

    /* JADX INFO: renamed from: fo */
    private static final int f1256fo = 35;

    /* JADX INFO: renamed from: fp */
    private static final int f1257fp = 50;

    /* JADX INFO: renamed from: fq */
    private static final int f1258fq = 116;

    /* JADX INFO: renamed from: fr */
    private static final int f1259fr = 131;

    /* JADX INFO: renamed from: fs */
    private static final int f1260fs = 197;

    /* JADX INFO: renamed from: ft */
    private static final int f1261ft = 208;

    /* JADX INFO: renamed from: bg */
    private boolean f1262bg;

    /* JADX INFO: renamed from: bh */
    private boolean f1263bh;

    /* JADX INFO: renamed from: aD */
    private float f1264aD;

    /* JADX INFO: renamed from: aE */
    private float f1265aE;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0289el f1266a;

    /* JADX INFO: renamed from: bi */
    private boolean f1267bi;

    /* JADX INFO: renamed from: dn */
    private static final Component f1238dn = Component.translatable("bf.message.game.match.summary.vote.subtitle").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: do */
    private static final Component f1239do = Component.translatable("bf.message.game.match.summary.vote.subtitle.tip");

    /* JADX INFO: renamed from: dp */
    private static final Component f1240dp = Component.translatable("bf.message.map.vote.no.maps.title").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: dq */
    private static final Component f1241dq = Component.translatable("bf.message.map.vote.no.maps.message").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: dr */
    private static final Component f1243dr = Component.translatable("bf.message.game.match.summary.vote.title").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: d */
    @Nonnull
    private static final MutableComponent f1244d = Component.translatable("bf.message.game.match.summary.vote.title.gamemode.same");

    /* JADX INFO: renamed from: e */
    @Nonnull
    private static final MutableComponent f1245e = Component.translatable("bf.message.game.match.summary.vote.title.gamemode.other");

    /* JADX INFO: renamed from: f */
    @Nonnull
    private static final MutableComponent f1246f = Component.translatable("bf.message.game.match.summary.vote.title.rate");

    public C0154cS(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        this(abstractC0787oF, C1089tp.f5695l);
    }

    public C0154cS(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C1088to c1088to) {
        super(abstractC0787oF.m3628e());
        this.f1262bg = false;
        this.f1263bh = false;
        this.f1265aE = 0.0f;
        this.f1266a = null;
        this.f1267bi = false;
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU, com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        if (this.f1266a != null) {
            this.f1266a.m1527l(this.f1587b);
        }
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = this.f1586e.m2692a();
        if (abstractC0788oGM2692a != null) {
            if ((abstractC0788oGM2692a.m3678a().m3899bb() <= 8) && !this.f1262bg) {
                this.f1262bg = true;
                this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7531oO.get(), 1.0f, 1.0f));
            }
            boolean z = abstractC0788oGM2692a.m3678a().m3899bb() <= 2;
            if (z && !this.f1263bh) {
                this.f1263bh = true;
                this.f1586e.m2709a().m3221a(new C0717mp(1.0f, 2.0f, 1.0f));
            }
            this.f1265aE = this.f1264aD;
            this.f1264aD = C1290xm.m7835d(this.f1264aD, z ? 1.0f : 0.0f, 0.025f);
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        m981X();
        if (!this.f1586e.m2689d()) {
            this.f1266a = new C0289el((this.width / 2) - 40, f1261ft, 80, 16);
            addRenderableWidget(this.f1266a);
        }
    }

    /* JADX INFO: renamed from: X */
    private void m981X() {
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = this.f1586e.m2688a();
        if (abstractC0787oFM2688a == null) {
            return;
        }
        this.f1583p.clear();
        int i = this.width / 2;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C1091tr c1091tr : abstractC0787oFM2688a.m3629a().m6038aE()) {
            if (c1091tr.m6024ar().equals(abstractC0787oFM2688a.m3594M())) {
                objectArrayList.add(new C0155cT(i, 50, 106, 60, this, c1091tr));
            }
        }
        int iSum = i - (objectArrayList.stream().mapToInt(c0155cT -> {
            return c0155cT.m699t() + 5;
        }).sum() / 2);
        int iT = 2;
        ObjectListIterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            C0155cT c0155cT2 = (C0155cT) it.next();
            c0155cT2.m700c(iSum + iT);
            m1195a((C0130bv) c0155cT2);
            iT += c0155cT2.m699t() + 5;
        }
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        for (C1091tr c1091tr2 : abstractC0787oFM2688a.m3629a().m6038aE()) {
            if (!c1091tr2.m6024ar().equals(abstractC0787oFM2688a.m3594M())) {
                objectArrayList2.add(new C0155cT(i, f1259fr, 106, 60, this, c1091tr2));
            }
        }
        this.f1267bi = !objectArrayList2.isEmpty();
        int iSum2 = i - (objectArrayList2.stream().mapToInt(c0155cT3 -> {
            return c0155cT3.m699t() + 5;
        }).sum() / 2);
        int iT2 = 2;
        ObjectListIterator it2 = objectArrayList2.iterator();
        while (it2.hasNext()) {
            C0155cT c0155cT4 = (C0155cT) it2.next();
            c0155cT4.m700c(iSum2 + iT2);
            m1195a((C0130bv) c0155cT4);
            iT2 += c0155cT4.m699t() + 5;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU, com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = this.f1586e.m2688a();
        if (abstractC0787oFM2688a == null) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        if (abstractC0787oFM2688a.m3629a().m6038aE().isEmpty()) {
            C0119bk.m394c(poseStackPose, this.font, guiGraphics, f1240dp, i3, i4 - 35, 1.0f);
            C0119bk.m394c(poseStackPose, this.font, guiGraphics, f1241dq, i3, i4 - 20, 0.5f);
        }
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        C0119bk.m417a(guiGraphics, 0, 0, this.width, this.height, 0, C1290xm.m7843e(this.f1264aD, this.f1265aE, f));
        poseStackPose.popPose();
        C0119bk.m399a(poseStackPose, this.font, guiGraphics, (Component) Component.literal(C1293xp.m7917p(f1244d.getString())), i3, 35);
        if (this.f1267bi) {
            C0119bk.m399a(poseStackPose, this.font, guiGraphics, (Component) Component.literal(C1293xp.m7917p(f1245e.getString())), i3, f1258fq);
        }
        if (!this.f1586e.m2689d()) {
            C0119bk.m399a(poseStackPose, this.font, guiGraphics, (Component) Component.literal(C1293xp.m7917p(f1246f.getString())), i3, f1260fs);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    @NotNull
    /* JADX INFO: renamed from: a */
    protected SoundEvent mo982a() {
        return (SoundEvent) C1280xc.f7530oN.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    /* JADX INFO: renamed from: G */
    protected int mo983G() {
        return 600;
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    @NotNull
    /* JADX INFO: renamed from: g */
    protected Component mo984g() {
        return f1243dr;
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    @NotNull
    /* JADX INFO: renamed from: h */
    protected Component mo985h() {
        return f1238dn;
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    @NotNull
    /* JADX INFO: renamed from: i */
    protected Component mo986i() {
        return f1239do;
    }
}
