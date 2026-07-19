package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sq.class */
public class C0503sq extends AbstractC0524tk<C0496sj, C0500sn> implements InterfaceC0522ti<C0496sj, C0500sn> {
    public static final int qS = 10;
    private final int qT;

    @NotNull
    private final oP g = new oP(0, 10);

    public C0503sq(int i) {
        this.qT = i;
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<C0496sj, C0500sn> c0525tl) {
        C0496sj c0496sj = (C0496sj) c0525tl.c();
        oR.a(c0525tl.m1162b(), c0525tl.m());
        boolean zBO = c0496sj.bO();
        oO oOVarF = zBO ? c0496sj.f() : c0496sj.m1123g();
        oO oOVarM1123g = zBO ? c0496sj.m1123g() : c0496sj.f();
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.of.round.won").withStyle(new ChatFormatting[]{ChatFormatting.GREEN, ChatFormatting.BOLD});
        MutableComponent mutableComponentWithStyle2 = Component.translatable("bf.message.gamemode.of.round.lost").withStyle(new ChatFormatting[]{ChatFormatting.RED, ChatFormatting.BOLD});
        if (oOVarF != null) {
            oR.a((oI<?>) c0525tl.m1161c(), oOVarF, (Component) mutableComponentWithStyle, 200, "of.roundend");
            oR.a(((C0500sn) c0525tl.m1161c()).a(oOVarF, oT.ALL), (SoundEvent) C0624xc.pW.get(), SoundSource.MASTER, 1.0f, 1.0f);
        }
        if (oOVarM1123g != null) {
            oR.a((oI<?>) c0525tl.m1161c(), oOVarM1123g, (Component) mutableComponentWithStyle2, 200, "of.roundend");
            oR.a(((C0500sn) c0525tl.m1161c()).a(oOVarM1123g, oT.ALL), (SoundEvent) C0624xc.qy.get(), SoundSource.MASTER, 1.0f, 1.0f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void b(@NotNull C0525tl<C0496sj, C0500sn> c0525tl) {
        this.g.c(c0525tl.m());
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    /* JADX INFO: renamed from: a */
    public boolean mo1022a(@NotNull C0525tl<C0496sj, C0500sn> c0525tl) {
        return !this.g.bs();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<C0496sj, C0500sn> a(@NotNull C0496sj c0496sj) {
        return this.qT >= 2 ? new C0501so() : new C0502sp();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public oN a() {
        return oN.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC0522ti
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public oP mo1035a(@NotNull C0496sj c0496sj) {
        return this.g;
    }
}
