package com.boehmod.blockfront;

import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rT.class */
public class rT extends AbstractC0524tk<rO, rR> implements InterfaceC0522ti<rO, rR> {
    public static final int pT = 15;

    @NotNull
    private final oP d = new oP(15, 0).a(20);

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<rO, rR> c0525tl) {
        oR.a(c0525tl.m(), hU.a().b(uW.START_GENERIC).a(5));
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void b(@NotNull C0525tl<rO, rR> c0525tl) {
        this.d.c(c0525tl.m());
        oR.b(c0525tl.m1162b(), c0525tl.m());
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    /* JADX INFO: renamed from: a */
    public boolean mo1022a(@NotNull C0525tl<rO, rR> c0525tl) {
        return ((rR) c0525tl.m1161c()).a(c0525tl.a(), c0525tl.m(), this.d) != null;
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<rO, rR> a(@NotNull rO rOVar) {
        return new rS();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public oN a() {
        return oN.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<rO, rR> c0525tl, @NotNull oS oSVar, @NotNull ServerPlayer serverPlayer) {
        oR.a(serverPlayer.getUUID(), hU.a().b(uW.START_GENERIC).a(5));
    }

    @Override // com.boehmod.blockfront.InterfaceC0522ti
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public oP mo1035a(@NotNull rO rOVar) {
        return this.d;
    }
}
