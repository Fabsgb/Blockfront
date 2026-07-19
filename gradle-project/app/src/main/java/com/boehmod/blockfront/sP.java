package com.boehmod.blockfront;

import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sP.class */
public class sP extends AbstractC0521th<sA, sC> {
    public static final int rd = 20;

    public sP() {
        super(20);
    }

    @Override // com.boehmod.blockfront.AbstractC0521th, com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<sA, sC> c0525tl) {
    }

    @Override // com.boehmod.blockfront.AbstractC0521th, com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<sA, sC> c0525tl, @NotNull oS oSVar, @NotNull ServerPlayer serverPlayer) {
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<sA, sC> a(@NotNull sA sAVar) {
        return new sO();
    }
}
