package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sr.class */
public class C0504sr extends AbstractC0524tk<C0496sj, C0500sn> implements InterfaceC0522ti<C0496sj, C0500sn> {
    private final int qU;
    private static final int qV = 5;

    @NotNull
    private final oP h = new oP(15, 0).a(20);
    private int qW = 15;
    private boolean hd = false;

    public C0504sr(int i) {
        this.qU = i;
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<C0496sj, C0500sn> c0525tl) {
        C0496sj c0496sj = (C0496sj) c0525tl.c();
        MutableComponent mutableComponentLiteral = Component.literal(Integer.toString(this.qU));
        oO oOVarF = c0496sj.f();
        oO oOVarM1123g = c0496sj.m1123g();
        if (oOVarF != null) {
            oR.a((oI<?>) c0525tl.m1161c(), oOVarF, (Component) Component.translatable("bf.message.gamemode.of.round.attack", new Object[]{mutableComponentLiteral}).withStyle(oOVarF.a()), 80, "of.round");
        }
        if (oOVarM1123g != null) {
            oR.a((oI<?>) c0525tl.m1161c(), oOVarM1123g, (Component) Component.translatable("bf.message.gamemode.of.round.defend", new Object[]{mutableComponentLiteral}).withStyle(oOVarM1123g.a()), 80, "of.round");
        }
        oR.a(c0525tl.m(), hU.a().a(uW.START).a(5));
        if (oOVarF != null) {
            oR.a(c0525tl.m1162b(), oOVarF.h());
        }
        c0496sj.G(this.qW);
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void b(@NotNull C0525tl<C0496sj, C0500sn> c0525tl) {
        C0496sj c0496sj = (C0496sj) c0525tl.c();
        Set<UUID> setM = c0525tl.m();
        com.boehmod.blockfront.common.player.c<?> cVarM1162b = c0525tl.m1162b();
        if (this.qW > 0) {
            c0496sj.G(this.qW);
            if (this.qW <= 5) {
                oP.a(setM, this.hd);
                this.hd = !this.hd;
            }
            this.qW--;
            return;
        }
        if (c0496sj.bK() > 0) {
            c0496sj.G(0);
            c0496sj.i(c0525tl.a());
        }
        this.h.c(setM);
        oR.b(cVarM1162b, setM);
        c0496sj.c(c0525tl.b(), cVarM1162b, c0525tl.a(), setM);
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    /* JADX INFO: renamed from: a */
    public boolean mo1022a(@NotNull C0525tl<C0496sj, C0500sn> c0525tl) {
        return ((C0496sj) c0525tl.c()).bN() || !this.h.bs();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void e(@NotNull C0525tl<C0496sj, C0500sn> c0525tl) {
        ((C0496sj) c0525tl.c()).cQ();
        ((C0496sj) c0525tl.c()).cP();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<C0496sj, C0500sn> a(@NotNull C0496sj c0496sj) {
        return new C0503sq(this.qU);
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public oN a() {
        return oN.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC0522ti
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public oP mo1035a(@NotNull C0496sj c0496sj) {
        return this.h;
    }
}
