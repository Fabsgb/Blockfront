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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cS.class */
public class cS extends cU {
    private static final int fe = 600;
    public static final int ff = 640;
    public static final int fg = 360;
    public static final int fh = 5;
    public static final int fi = 6;
    private static final int fj = 50;
    private static final int fk = 15;
    private static final int fl = 81;
    private static final int fm = 82;
    private static final int fn = 80;
    private static final int fo = 35;
    private static final int fp = 50;
    private static final int fq = 116;
    private static final int fr = 131;
    private static final int fs = 197;
    private static final int ft = 208;
    private boolean bg;
    private boolean bh;
    private float aD;
    private float aE;

    @Nullable
    private C0121el a;
    private boolean bi;
    private static final Component dn = Component.translatable("bf.message.game.match.summary.vote.subtitle").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private static final Component f87do = Component.translatable("bf.message.game.match.summary.vote.subtitle.tip");
    private static final Component dp = Component.translatable("bf.message.map.vote.no.maps.title").withStyle(ChatFormatting.BOLD);
    private static final Component dq = Component.translatable("bf.message.map.vote.no.maps.message").withStyle(ChatFormatting.GRAY);
    private static final Component dr = Component.translatable("bf.message.game.match.summary.vote.title").withStyle(C0266jw.b);

    @Nonnull
    private static final MutableComponent d = Component.translatable("bf.message.game.match.summary.vote.title.gamemode.same");

    @Nonnull
    private static final MutableComponent e = Component.translatable("bf.message.game.match.summary.vote.title.gamemode.other");

    @Nonnull
    private static final MutableComponent f = Component.translatable("bf.message.game.match.summary.vote.title.rate");

    public cS(@NotNull oF<?, ?, ?> oFVar) {
        this(oFVar, C0529tp.l);
    }

    public cS(@NotNull oF<?, ?, ?> oFVar, @NotNull C0528to c0528to) {
        super(oFVar.m757e());
        this.bg = false;
        this.bh = false;
        this.aE = 0.0f;
        this.a = null;
        this.bi = false;
    }

    @Override // com.boehmod.blockfront.cU, com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        if (this.a != null) {
            this.a.l(this.b);
        }
        oG<?, ?> oGVarM593a = this.e.m593a();
        if (oGVarM593a != null) {
            if ((oGVarM593a.a().bb() <= 8) && !this.bg) {
                this.bg = true;
                this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.oO.get(), 1.0f, 1.0f));
            }
            boolean z = oGVarM593a.a().bb() <= 2;
            if (z && !this.bh) {
                this.bh = true;
                this.e.m602a().a(new C0340mp(1.0f, 2.0f, 1.0f));
            }
            this.aE = this.aD;
            this.aD = C0634xm.d(this.aD, z ? 1.0f : 0.0f, 0.025f);
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        X();
        if (!this.e.m592d()) {
            this.a = new C0121el((this.width / 2) - 40, ft, 80, 16);
            addRenderableWidget(this.a);
        }
    }

    private void X() {
        oF<?, ?, ?> oFVarM591a = this.e.m591a();
        if (oFVarM591a == null) {
            return;
        }
        this.p.clear();
        int i = this.width / 2;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (C0531tr c0531tr : oFVarM591a.m758a().aE()) {
            if (c0531tr.ar().equals(oFVarM591a.M())) {
                objectArrayList.add(new cT(i, 50, 106, 60, this, c0531tr));
            }
        }
        int iSum = i - (objectArrayList.stream().mapToInt(cTVar -> {
            return cTVar.t() + 5;
        }).sum() / 2);
        int iT = 2;
        ObjectListIterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            cT cTVar2 = (cT) it.next();
            cTVar2.c(iSum + iT);
            a((C0051bv) cTVar2);
            iT += cTVar2.t() + 5;
        }
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        for (C0531tr c0531tr2 : oFVarM591a.m758a().aE()) {
            if (!c0531tr2.ar().equals(oFVarM591a.M())) {
                objectArrayList2.add(new cT(i, fr, 106, 60, this, c0531tr2));
            }
        }
        this.bi = !objectArrayList2.isEmpty();
        int iSum2 = i - (objectArrayList2.stream().mapToInt(cTVar3 -> {
            return cTVar3.t() + 5;
        }).sum() / 2);
        int iT2 = 2;
        ObjectListIterator it2 = objectArrayList2.iterator();
        while (it2.hasNext()) {
            cT cTVar4 = (cT) it2.next();
            cTVar4.c(iSum2 + iT2);
            a((C0051bv) cTVar4);
            iT2 += cTVar4.t() + 5;
        }
    }

    @Override // com.boehmod.blockfront.cU, com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f2) {
        super.render(guiGraphics, i, i2, f2);
        oF<?, ?, ?> oFVarM591a = this.e.m591a();
        if (oFVarM591a == null) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        if (oFVarM591a.m758a().aE().isEmpty()) {
            C0040bk.c(poseStackPose, this.font, guiGraphics, dp, i3, i4 - 35, 1.0f);
            C0040bk.c(poseStackPose, this.font, guiGraphics, dq, i3, i4 - 20, 0.5f);
        }
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, 0, C0634xm.e(this.aD, this.aE, f2));
        poseStackPose.popPose();
        C0040bk.a(poseStackPose, this.font, guiGraphics, (Component) Component.literal(C0637xp.p(d.getString())), i3, 35);
        if (this.bi) {
            C0040bk.a(poseStackPose, this.font, guiGraphics, (Component) Component.literal(C0637xp.p(e.getString())), i3, fq);
        }
        if (!this.e.m592d()) {
            C0040bk.a(poseStackPose, this.font, guiGraphics, (Component) Component.literal(C0637xp.p(f.getString())), i3, fs);
        }
    }

    @Override // com.boehmod.blockfront.cU
    @NotNull
    protected SoundEvent a() {
        return (SoundEvent) C0624xc.oN.get();
    }

    @Override // com.boehmod.blockfront.cU
    protected int G() {
        return 600;
    }

    @Override // com.boehmod.blockfront.cU
    @NotNull
    protected Component g() {
        return dr;
    }

    @Override // com.boehmod.blockfront.cU
    @NotNull
    protected Component h() {
        return dn;
    }

    @Override // com.boehmod.blockfront.cU
    @NotNull
    protected Component i() {
        return f87do;
    }
}
