package com.boehmod.blockfront;

import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.tm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tm.class */
public class C0526tm<G extends oF<G, P, ?>, P extends oI<G>> {
    private static final int rv = 20;

    @NotNull
    private final G k;

    @NotNull
    private AbstractC0524tk<G, P> a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private C0525tl<G, P> f303a;
    private int pC = 0;
    private boolean hz = false;

    public C0526tm(@NotNull G g) {
        this.k = g;
        this.a = g.mo749a();
    }

    public void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel) {
        C0525tl<G, P> c0525tlA = a(abstractC0264ju, cVar, serverLevel);
        if (this.a.mo1022a((C0525tl) c0525tlA) || this.hz) {
            this.hz = false;
            this.pC = 0;
            C0263jt.log("[STAGE] Stage '%s' has ended for game '%s'!", this.a.getClass().getSimpleName(), this.k.L());
            this.a.e(c0525tlA);
            this.a = this.a.a(this.k);
            this.a.a((C0525tl) c0525tlA);
            C0263jt.log("[STAGE] Stage '%s' has started for game '%s'!", this.a.getClass().getSimpleName(), this.k.L());
        }
        this.k.a(this.a.a());
        int i = this.pC;
        this.pC = i + 1;
        if (i >= 20) {
            this.pC = 0;
            this.a.b(c0525tlA);
            C0582vo.a(new C0609wo(this.k, false), (oF<?, ?, ?>) this.k);
        }
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull oS oSVar, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        this.a.a(a(abstractC0264ju, cVar, serverLevel), oSVar, serverPlayer);
    }

    @NotNull
    private C0525tl<G, P> a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull ServerLevel serverLevel) {
        C0525tl<G, P> c0525tl = this.f303a;
        if (c0525tl == null || c0525tl.a() != serverLevel) {
            oI oIVarB = this.k.b();
            c0525tl = new C0525tl<>(this.k, oIVarB, abstractC0264ju, cVar, serverLevel, oIVarB.h());
            this.f303a = c0525tl;
        }
        return c0525tl;
    }

    public void dh() {
        this.hz = true;
    }

    public void bf() {
        this.a = this.k.mo749a();
        this.f303a = null;
        this.pC = 0;
    }

    @NotNull
    public AbstractC0524tk<G, P> b() {
        return this.a;
    }
}
