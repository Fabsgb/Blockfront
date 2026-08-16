package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.de */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/de.class */
public class C0230de extends AbstractC0229dd {

    /* JADX INFO: renamed from: du */
    private static final Component f1856du = Component.translatable("bf.message.game.match.summary.progress.subtitle").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: dv */
    private static final Component f1857dv = Component.translatable("bf.message.game.match.summary.progress.subtitle").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: dw */
    private static final Component f1858dw = Component.translatable("bf.message.game.match.summary.progress.subtitle.tip");

    /* JADX INFO: renamed from: gB */
    private static final int f1859gB = 290;

    /* JADX INFO: renamed from: gC */
    private static final int f1860gC = 40;

    /* JADX INFO: renamed from: gD */
    private static final int f1861gD = 200;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0259eG f1862a;

    /* JADX INFO: renamed from: bp */
    private boolean f1863bp;

    public C0230de(@NotNull UUID uuid, @NotNull AbstractC0864pc<?, ?> abstractC0864pc) {
        super(uuid);
        this.f1863bp = false;
        this.f1862a = new C0259eG(0, 0, 0, 0, abstractC0864pc.m4182a().m5899ci(), this.f1056a.m1886a(this.f1058a).getExp());
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        int i = this.width / 2;
        int i2 = i - 145;
        int i3 = (this.height / 2) - 20;
        this.f1862a.setX(i2);
        this.f1862a.setY(i3);
        this.f1862a.setWidth(290);
        this.f1862a.setHeight(40);
        addRenderableWidget(this.f1862a);
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    @NotNull
    /* JADX INFO: renamed from: a */
    protected SoundEvent mo1337a() {
        return (SoundEvent) C1312xz.f7944oR.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    /* JADX INFO: renamed from: K */
    protected int mo1338K() {
        return 200;
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    @NotNull
    /* JADX INFO: renamed from: g */
    protected Component mo1339g() {
        return f1856du;
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    @NotNull
    /* JADX INFO: renamed from: h */
    protected Component mo1340h() {
        return f1857dv;
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    @NotNull
    /* JADX INFO: renamed from: i */
    protected Component mo1341i() {
        return f1858dw;
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    /* JADX INFO: renamed from: ac */
    public void mo1349ac() {
        super.mo1349ac();
        this.f1863bp = true;
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    /* JADX INFO: renamed from: y */
    public boolean mo1347y() {
        if (this.f1863bp) {
            return true;
        }
        return this.f1862a.m1473J() && super.mo1347y();
    }
}
