package com.boehmod.blockfront;

import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.sx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sx.class */
public class C0510sx extends AbstractC0524tk<C0506st, C0508sv> implements InterfaceC0522ti<C0506st, C0508sv> {
    private static final int qZ = 10;

    @NotNull
    private final oP i = new oP(10, 0).a(20);

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<C0506st, C0508sv> c0525tl) {
        oR.a(c0525tl.m(), hU.a().b(uW.START_GENERIC).a(5));
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void b(@NotNull C0525tl<C0506st, C0508sv> c0525tl) {
        this.i.c(c0525tl.m());
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    /* JADX INFO: renamed from: a */
    public boolean mo1022a(@NotNull C0525tl<C0506st, C0508sv> c0525tl) {
        return ((C0508sv) c0525tl.m1161c()).a(c0525tl.a(), c0525tl.m(), this.i) != null;
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<C0506st, C0508sv> a(@NotNull C0506st c0506st) {
        return new C0509sw();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public oN a() {
        return oN.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<C0506st, C0508sv> c0525tl, @NotNull oS oSVar, @NotNull ServerPlayer serverPlayer) {
        oR.a(serverPlayer.getUUID(), hU.a().b(uW.START_GENERIC).a(5));
    }

    @Override // com.boehmod.blockfront.InterfaceC0522ti
    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public oP mo1035a(@NotNull C0506st c0506st) {
        return this.i;
    }
}
