package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sp.class */
public class C0502sp extends AbstractC0524tk<C0496sj, C0500sn> implements InterfaceC0522ti<C0496sj, C0500sn> {
    public static final int qR = 8;

    @NotNull
    private final oP f = new oP(0, 8).a(8);

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<C0496sj, C0500sn> c0525tl) {
        oR.a(c0525tl.m1162b(), c0525tl.m());
        oR.a((oF<?, ?, ?>) c0525tl.c(), (Component) Component.translatable("bf.message.gamemode.of.intermission").withColor(ColorReferences.COLOR_STOPWATCH), 80, "of.intermission");
        ((C0496sj) c0525tl.c()).a(c0525tl.b(), c0525tl.a(), c0525tl.m1162b());
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void b(@NotNull C0525tl<C0496sj, C0500sn> c0525tl) {
        this.f.c(c0525tl.m());
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    /* JADX INFO: renamed from: a */
    public boolean mo1022a(@NotNull C0525tl<C0496sj, C0500sn> c0525tl) {
        return !this.f.bs();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void e(@NotNull C0525tl<C0496sj, C0500sn> c0525tl) {
        oR.b(c0525tl.m1162b(), c0525tl.m());
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<C0496sj, C0500sn> a(@NotNull C0496sj c0496sj) {
        return new C0504sr(2);
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public oN a() {
        return oN.GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC0522ti
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public oP mo1035a(@NotNull C0496sj c0496sj) {
        return this.f;
    }
}
