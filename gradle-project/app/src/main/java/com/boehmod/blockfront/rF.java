package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rF.class */
public class rF extends AbstractC0519tf<rB, rE> {
    @Override // com.boehmod.blockfront.AbstractC0519tf, com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<rB, rE> c0525tl) {
        super.a((C0525tl) c0525tl);
        C0332mh c0332mhD = ((rB) c0525tl.c()).d();
        if (c0332mhD != null) {
            oR.a(c0525tl.b(), c0332mhD, (C0337mm) null, c0525tl.m());
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0519tf
    protected void c(@NotNull C0525tl<rB, rE> c0525tl) {
        C0409pd c0409pdA = ((rE) c0525tl.m1161c()).a(c0525tl.a(), c0525tl.m(), (oP) null);
        if (c0409pdA != null) {
            ((rB) c0525tl.c()).a(c0525tl.a(), c0525tl.b(), C0529tp.l, true, c0409pdA, c0525tl.m());
        }
        oR.a(c0525tl.m(), hU.a().a(uW.CONCLUDE));
    }
}
