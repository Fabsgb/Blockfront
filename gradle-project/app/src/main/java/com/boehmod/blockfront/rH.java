package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rH.class */
public class rH extends AbstractC0520tg<rB, rE> {
    public static final int pM = 45;

    public rH() {
        super(45);
    }

    @Override // com.boehmod.blockfront.AbstractC0521th, com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<rB, rE> c0525tl) {
        super.a((C0525tl) c0525tl);
        Iterator<UUID> it = c0525tl.m().iterator();
        while (it.hasNext()) {
            rB.a((rB) c0525tl.c(), c0525tl.b(), it.next(), false);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0520tg
    protected void d(@NotNull C0525tl<rB, rE> c0525tl) {
        ((rB) c0525tl.c()).e(c0525tl.a());
        g(c0525tl);
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<rB, rE> a(@NotNull rB rBVar) {
        return new rG();
    }

    @Override // com.boehmod.blockfront.AbstractC0521th, com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<rB, rE> c0525tl, @NotNull oS oSVar, @NotNull ServerPlayer serverPlayer) {
        if (oSVar == oS.NEW) {
            rB.a((rB) c0525tl.c(), c0525tl.b(), serverPlayer.getUUID(), false);
            oR.a(serverPlayer.getUUID(), hU.a().c(uW.WARMUP));
        }
    }
}
