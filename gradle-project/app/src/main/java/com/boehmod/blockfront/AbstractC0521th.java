package com.boehmod.blockfront;

import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import java.util.Set;
import java.util.UUID;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.th, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/th.class */
public abstract class AbstractC0521th<G extends oF<G, P, ?>, P extends oI<G>> extends AbstractC0524tk<G, P> implements InterfaceC0522ti<G, P> {
    public final int ru;

    @NotNull
    private final oP m;

    public AbstractC0521th(int i) {
        this.ru = i;
        this.m = new oP(0, i).a(10);
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<G, P> c0525tl) {
        oR.a(c0525tl.m(), hU.a().c(uW.WARMUP));
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<G, P> c0525tl, @NotNull oS oSVar, @NotNull ServerPlayer serverPlayer) {
        oR.a(serverPlayer.getUUID(), hU.a().c(uW.WARMUP));
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public oN a() {
        return oN.PRE_GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @OverridingMethodsMustInvokeSuper
    public void b(@NotNull C0525tl<G, P> c0525tl) {
        Set<UUID> setM = c0525tl.m();
        if (c0525tl.c().a(setM)) {
            this.m.c(setM);
        } else {
            this.m.A(this.ru);
            oR.b(c0525tl.m1162b(), setM);
        }
        if (this.m.bs() && this.m.bb() <= 5) {
            oR.a(c0525tl.m1162b(), setM);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public boolean mo1022a(@NotNull C0525tl<G, P> c0525tl) {
        return c0525tl.m().isEmpty() || !this.m.bs();
    }

    @Override // com.boehmod.blockfront.InterfaceC0522ti
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public oP mo1035a(@NotNull G g) {
        return this.m;
    }
}
