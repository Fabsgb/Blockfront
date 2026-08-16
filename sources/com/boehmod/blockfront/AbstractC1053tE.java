package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import java.util.Set;
import java.util.UUID;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tE.class */
public abstract class AbstractC1053tE<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> extends AbstractC1056tH<G, P> implements InterfaceC1054tF<G, P> {

    /* JADX INFO: renamed from: tv */
    public final int f5709tv;

    /* JADX INFO: renamed from: m */
    @NotNull
    private final C0873pl f5710m;

    public AbstractC1053tE(int i) {
        this.f5709tv = i;
        this.f5710m = new C0873pl(0, i).m4326a(10);
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5312a(@NotNull C1057tI<G, P> c1057tI) {
        C0875pn.m4361a(c1057tI.m5874m(), C0502il.m2254a().m2257c(EnumC1203vw.WARMUP));
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5317a(@NotNull C1057tI<G, P> c1057tI, @NotNull EnumC0876po enumC0876po, @NotNull ServerPlayer serverPlayer) {
        C0875pn.m4362a(serverPlayer.getUUID(), C0502il.m2254a().m2257c(EnumC1203vw.WARMUP));
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0871pj mo5316a() {
        return EnumC0871pj.PRE_GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: b */
    public void mo5313b(@NotNull C1057tI<G, P> c1057tI) {
        Set<UUID> setM5874m = c1057tI.m5874m();
        if (c1057tI.m5869c().m4054a(setM5874m)) {
            this.f5710m.m4328c(setM5874m);
        } else {
            this.f5710m.m4331B(this.f5709tv);
            C0875pn.m4393b(c1057tI.m5872b(), setM5874m);
        }
        if (this.f5710m.m4332bC() && this.f5710m.m4335bq() <= 5) {
            C0875pn.m4392a(c1057tI.m5872b(), setM5874m);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public boolean mo5314a(@NotNull C1057tI<G, P> c1057tI) {
        return c1057tI.m5874m().isEmpty() || !this.f5710m.m4332bC();
    }

    @Override // com.boehmod.blockfront.InterfaceC1054tF
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public C0873pl mo5608a(@NotNull G g) {
        return this.f5710m;
    }
}
