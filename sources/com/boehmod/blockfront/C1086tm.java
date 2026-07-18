package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.tm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tm.class */
public class C1086tm<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> {

    /* JADX INFO: renamed from: rv */
    private static final int f5671rv = 20;

    /* JADX INFO: renamed from: k */
    @NotNull
    private final G f5672k;

    /* JADX INFO: renamed from: a */
    @NotNull
    private AbstractC1084tk<G, P> f5673a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C1085tl<G, P> f5674a;

    /* JADX INFO: renamed from: pC */
    private int f5675pC = 0;

    /* JADX INFO: renamed from: hz */
    private boolean f5676hz = false;

    public C1086tm(@NotNull G g) {
        this.f5672k = g;
        this.f5673a = g.mo3563a();
    }

    /* JADX INFO: renamed from: b */
    public void m5995b(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel) {
        C1085tl<G, P> c1085tlM5997a = m5997a(abstractC0563ju, abstractC0183c, serverLevel);
        if (this.f5673a.mo5143a((C1085tl) c1085tlM5997a) || this.f5676hz) {
            this.f5676hz = false;
            this.f5675pC = 0;
            C0562jt.log("[STAGE] Stage '%s' has ended for game '%s'!", this.f5673a.getClass().getSimpleName(), this.f5672k.m3589L());
            this.f5673a.mo5222e(c1085tlM5997a);
            this.f5673a = this.f5673a.mo5148a(this.f5672k);
            this.f5673a.mo5141a((C1085tl) c1085tlM5997a);
            C0562jt.log("[STAGE] Stage '%s' has started for game '%s'!", this.f5673a.getClass().getSimpleName(), this.f5672k.m3589L());
        }
        this.f5672k.m3588a(this.f5673a.mo5145a());
        int i = this.f5675pC;
        this.f5675pC = i + 1;
        if (i >= 20) {
            this.f5675pC = 0;
            this.f5673a.mo5142b(c1085tlM5997a);
            C1194vo.m6651a(new C1247wo(this.f5672k, false), (AbstractC0787oF<?, ?, ?>) this.f5672k);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5996a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        this.f5673a.mo5146a(m5997a(abstractC0563ju, abstractC0183c, serverLevel), enumC0800oS, serverPlayer);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private C1085tl<G, P> m5997a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull ServerLevel serverLevel) {
        C1085tl<G, P> c1085tl = this.f5674a;
        if (c1085tl == null || c1085tl.m5993a() != serverLevel) {
            AbstractC0790oI abstractC0790oIM3582b = this.f5672k.m3582b();
            c1085tl = new C1085tl<>(this.f5672k, abstractC0790oIM3582b, abstractC0563ju, abstractC0183c, serverLevel, abstractC0790oIM3582b.m3809h());
            this.f5674a = c1085tl;
        }
        return c1085tl;
    }

    /* JADX INFO: renamed from: dh */
    public void m5998dh() {
        this.f5676hz = true;
    }

    /* JADX INFO: renamed from: bf */
    public void m5999bf() {
        this.f5673a = this.f5672k.mo3563a();
        this.f5674a = null;
        this.f5675pC = 0;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public AbstractC1084tk<G, P> m6000b() {
        return this.f5673a;
    }
}
