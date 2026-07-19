package com.boehmod.blockfront;

import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rM.class */
public class rM extends AbstractC0524tk<rI, rK> implements InterfaceC0522ti<rI, rK> {
    private static final int pQ = 10;

    @NotNull
    private final oP c = new oP(10, 0).a(20);

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<rI, rK> c0525tl) {
        oR.a(c0525tl.m(), hU.a().b(uW.START_GENERIC).a(5));
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void b(@NotNull C0525tl<rI, rK> c0525tl) {
        this.c.c(c0525tl.m());
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    /* JADX INFO: renamed from: a */
    public boolean mo1022a(@NotNull C0525tl<rI, rK> c0525tl) {
        return ((rK) c0525tl.m1161c()).a(c0525tl.a(), c0525tl.m(), this.c) != null;
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void e(@NotNull C0525tl<rI, rK> c0525tl) {
        oR.a(c0525tl.m1162b(), c0525tl.m());
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<rI, rK> a(@NotNull rI rIVar) {
        return new rL();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public oN a() {
        return oN.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<rI, rK> c0525tl, @NotNull oS oSVar, @NotNull ServerPlayer serverPlayer) {
        oR.a(serverPlayer.getUUID(), hU.a().b(uW.START_GENERIC).a(5));
    }

    @Override // com.boehmod.blockfront.InterfaceC0522ti
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public oP mo1035a(@NotNull rI rIVar) {
        return this.c;
    }
}
