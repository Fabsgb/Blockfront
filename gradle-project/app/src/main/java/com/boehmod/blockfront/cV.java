package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cV.class */
public class cV extends cU {
    private static final Component ds = Component.translatable("bf.message.game.match.summary.progress.subtitle").withStyle(C0266jw.b);
    private static final Component dt = Component.translatable("bf.message.game.match.summary.progress.subtitle").withStyle(ChatFormatting.BOLD);
    private static final Component du = Component.translatable("bf.message.game.match.summary.progress.subtitle.tip");
    private static final int fB = 290;
    private static final int fC = 40;
    private static final int fD = 200;

    @NotNull
    private final C0129et a;
    private boolean bl;

    public cV(@NotNull UUID uuid, @NotNull oG<?, ?> oGVar) {
        super(uuid);
        this.bl = false;
        this.a = new C0129et(0, 0, 0, 0, oGVar.m774a().bT(), this.a.m404a(this.b).getExp());
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void E() {
        super.E();
        int i = this.width / 2;
        int i2 = i - 145;
        int i3 = (this.height / 2) - 20;
        this.a.setX(i2);
        this.a.setY(i3);
        this.a.setWidth(290);
        this.a.setHeight(40);
        addRenderableWidget(this.a);
    }

    @Override // com.boehmod.blockfront.cU
    @NotNull
    protected SoundEvent a() {
        return (SoundEvent) C0624xc.oP.get();
    }

    @Override // com.boehmod.blockfront.cU
    protected int G() {
        return 200;
    }

    @Override // com.boehmod.blockfront.cU
    @NotNull
    protected Component g() {
        return ds;
    }

    @Override // com.boehmod.blockfront.cU
    @NotNull
    protected Component h() {
        return dt;
    }

    @Override // com.boehmod.blockfront.cU
    @NotNull
    protected Component i() {
        return du;
    }

    @Override // com.boehmod.blockfront.cU
    public void Y() {
        super.Y();
        this.bl = true;
    }

    @Override // com.boehmod.blockfront.cU
    public boolean x() {
        if (this.bl) {
            return true;
        }
        return this.a.I() && super.x();
    }
}
