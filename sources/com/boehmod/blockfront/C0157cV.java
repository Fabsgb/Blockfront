package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cV.class */
public class C0157cV extends AbstractC0156cU {

    /* JADX INFO: renamed from: ds */
    private static final Component f1285ds = Component.translatable("bf.message.game.match.summary.progress.subtitle").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: dt */
    private static final Component f1286dt = Component.translatable("bf.message.game.match.summary.progress.subtitle").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: du */
    private static final Component f1287du = Component.translatable("bf.message.game.match.summary.progress.subtitle.tip");

    /* JADX INFO: renamed from: fB */
    private static final int f1288fB = 290;

    /* JADX INFO: renamed from: fC */
    private static final int f1289fC = 40;

    /* JADX INFO: renamed from: fD */
    private static final int f1290fD = 200;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0297et f1291a;

    /* JADX INFO: renamed from: bl */
    private boolean f1292bl;

    public C0157cV(@NotNull UUID uuid, @NotNull AbstractC0788oG<?, ?> abstractC0788oG) {
        super(uuid);
        this.f1292bl = false;
        this.f1291a = new C0297et(0, 0, 0, 0, abstractC0788oG.m3746a().m6013bT(), this.f1585a.m1676a(this.f1587b).getExp());
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        super.mo775E();
        int i = this.width / 2;
        int i2 = i - 145;
        int i3 = (this.height / 2) - 20;
        this.f1291a.setX(i2);
        this.f1291a.setY(i3);
        this.f1291a.setWidth(290);
        this.f1291a.setHeight(40);
        addRenderableWidget(this.f1291a);
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    @NotNull
    /* JADX INFO: renamed from: a */
    protected SoundEvent mo982a() {
        return (SoundEvent) C1280xc.f7532oP.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    /* JADX INFO: renamed from: G */
    protected int mo983G() {
        return 200;
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    @NotNull
    /* JADX INFO: renamed from: g */
    protected Component mo984g() {
        return f1285ds;
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    @NotNull
    /* JADX INFO: renamed from: h */
    protected Component mo985h() {
        return f1286dt;
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    @NotNull
    /* JADX INFO: renamed from: i */
    protected Component mo986i() {
        return f1287du;
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    /* JADX INFO: renamed from: Y */
    public void mo994Y() {
        super.mo994Y();
        this.f1292bl = true;
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    /* JADX INFO: renamed from: x */
    public boolean mo992x() {
        if (this.f1292bl) {
            return true;
        }
        return this.f1291a.m1571I() && super.mo992x();
    }
}
