package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.tJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tJ.class */
public class C1058tJ<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> {

    /* JADX INFO: renamed from: tw */
    private static final int f5718tw = 20;

    /* JADX INFO: renamed from: k */
    @NotNull
    private final G f5719k;

    /* JADX INFO: renamed from: a */
    @NotNull
    private AbstractC1056tH<G, P> f5720a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C1057tI<G, P> f5721a;

    /* JADX INFO: renamed from: rB */
    private int f5722rB = 0;

    /* JADX INFO: renamed from: hT */
    private boolean f5723hT = false;

    public C1058tJ(@NotNull G g) {
        this.f5719k = g;
        this.f5720a = g.mo3999a();
    }

    /* JADX INFO: renamed from: b */
    public void m5875b(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel) {
        C1057tI<G, P> c1057tIM5877a = m5877a(abstractC0531jN, abstractC0184c, serverLevel);
        if (this.f5720a.mo5314a((C1057tI) c1057tIM5877a) || this.f5723hT) {
            this.f5723hT = false;
            this.f5722rB = 0;
            C0530jM.log("[STAGE] Stage '%s' has ended for game '%s'!", this.f5720a.getClass().getSimpleName(), this.f5719k.m4025S());
            this.f5720a.mo5605e(c1057tIM5877a);
            this.f5720a = this.f5720a.mo5319a(this.f5719k);
            this.f5720a.mo5312a((C1057tI) c1057tIM5877a);
            C0530jM.log("[STAGE] Stage '%s' has started for game '%s'!", this.f5720a.getClass().getSimpleName(), this.f5719k.m4025S());
        }
        this.f5719k.m4024a(this.f5720a.mo5316a());
        int i = this.f5722rB;
        this.f5722rB = i + 1;
        if (i >= 20) {
            this.f5722rB = 0;
            this.f5720a.mo5313b(c1057tIM5877a);
            C1169vO.m6646a(new C1220wM(this.f5719k, false), (AbstractC0863pb<?, ?, ?>) this.f5719k);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5876a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull EnumC0876po enumC0876po, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer) {
        this.f5720a.mo5317a(m5877a(abstractC0531jN, abstractC0184c, serverLevel), enumC0876po, serverPlayer);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private C1057tI<G, P> m5877a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull ServerLevel serverLevel) {
        C1057tI<G, P> c1057tI = this.f5721a;
        if (c1057tI == null || c1057tI.m5873a() != serverLevel) {
            AbstractC0866pe abstractC0866peM4018b = this.f5719k.m4018b();
            c1057tI = new C1057tI<>(this.f5719k, abstractC0866peM4018b, abstractC0531jN, abstractC0184c, serverLevel, abstractC0866peM4018b.m4245h());
            this.f5721a = c1057tI;
        }
        return c1057tI;
    }

    /* JADX INFO: renamed from: dt */
    public void m5878dt() {
        this.f5723hT = true;
    }

    /* JADX INFO: renamed from: bd */
    public void m5879bd() {
        this.f5720a = this.f5719k.mo3999a();
        this.f5721a = null;
        this.f5722rB = 0;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public AbstractC1056tH<G, P> m5880b() {
        return this.f5720a;
    }
}
