package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rN.class */
public class rN extends AbstractC0521th<rI, rK> {
    public static final int pR = 20;

    public rN() {
        super(20);
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void e(@NotNull C0525tl<rI, rK> c0525tl) {
        oR.b(c0525tl.m1162b(), c0525tl.m());
        ((rK) c0525tl.m1161c()).a(c0525tl.m1162b());
        oR.a(c0525tl.a(), (oF<?, ?, ?>) c0525tl.c(), c0525tl.m());
        oR.a(c0525tl.a(), c0525tl.m(), c0525tl.m1162b());
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<rI, rK> a(@NotNull rI rIVar) {
        return new rM();
    }
}
