package com.boehmod.blockfront;

import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import java.util.Set;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tf.class */
public abstract class AbstractC0519tf<G extends oF<G, P, ?>, P extends oI<G>> extends AbstractC0524tk<G, P> implements InterfaceC0522ti<G, P> {

    @NotNull
    public static final Component jy = Component.translatable("bf.message.disconnect.mm.restarting");

    @NotNull
    public oP a = new oP(1, 0).a(15);

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<G, P> c0525tl) {
        c0525tl.c().m758a().d(c0525tl.b());
        oR.a(c0525tl.m1162b(), c0525tl.m());
        c(c0525tl);
    }

    protected void c(@NotNull C0525tl<G, P> c0525tl) {
        Set<UUID> setM = c0525tl.m();
        C0409pd c0409pdA = c0525tl.m1161c().a(c0525tl.a(), setM, (oP) null);
        if (c0409pdA != null) {
            c0525tl.c().a(c0525tl.a(), c0525tl.b(), C0529tp.l, true, c0409pdA, setM);
            oR.a(setM, hU.a().b(uW.CONCLUDE_GENERIC).a(5));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void b(@NotNull C0525tl<G, P> c0525tl) {
        this.a.c(c0525tl.m());
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    /* JADX INFO: renamed from: a */
    public boolean mo1022a(@NotNull C0525tl<G, P> c0525tl) {
        return c0525tl.m().isEmpty() || !this.a.bs();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void e(@NotNull C0525tl<G, P> c0525tl) {
        oF oFVarC = c0525tl.c();
        oR.b(c0525tl.m1162b(), c0525tl.m());
        if (!oFVarC.m758a().a(c0525tl.b(), c0525tl.m1161c(), c0525tl.a())) {
            oR.a(c0525tl.m(), jy);
        }
        oFVarC.d(c0525tl.a());
        oFVarC.c(c0525tl.b());
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<G, P> c0525tl, @NotNull oS oSVar, @NotNull ServerPlayer serverPlayer) {
        oR.a(c0525tl.m1162b(), serverPlayer);
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<G, P> a(@NotNull G g) {
        return g.mo749a();
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public oN a() {
        return oN.POST_GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC0522ti
    /* JADX INFO: renamed from: a */
    public oP mo1035a(@NotNull G g) {
        return this.a;
    }
}
