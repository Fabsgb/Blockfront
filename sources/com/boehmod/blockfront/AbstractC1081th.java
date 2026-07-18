package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import java.util.Set;
import java.util.UUID;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.th */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/th.class */
public abstract class AbstractC1081th<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> extends AbstractC1084tk<G, P> implements InterfaceC1082ti<G, P> {

    /* JADX INFO: renamed from: ru */
    public final int f5662ru;

    /* JADX INFO: renamed from: m */
    @NotNull
    private final C0797oP f5663m;

    public AbstractC1081th(int i) {
        this.f5662ru = i;
        this.f5663m = new C0797oP(0, i).m3890a(10);
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5141a(@NotNull C1085tl<G, P> c1085tl) {
        C0799oR.m3925a(c1085tl.m5994m(), C0431hU.m2020a().m2023c(EnumC1123uW.WARMUP));
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5146a(@NotNull C1085tl<G, P> c1085tl, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerPlayer serverPlayer) {
        C0799oR.m3926a(serverPlayer.getUUID(), C0431hU.m2020a().m2023c(EnumC1123uW.WARMUP));
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0795oN mo5145a() {
        return EnumC0795oN.PRE_GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: b */
    public void mo5142b(@NotNull C1085tl<G, P> c1085tl) {
        Set<UUID> setM5994m = c1085tl.m5994m();
        if (c1085tl.m5989c().m3618a(setM5994m)) {
            this.f5663m.m3892c(setM5994m);
        } else {
            this.f5663m.m3895A(this.f5662ru);
            C0799oR.m3957b(c1085tl.m5992b(), setM5994m);
        }
        if (this.f5663m.m3896bs() && this.f5663m.m3899bb() <= 5) {
            C0799oR.m3956a(c1085tl.m5992b(), setM5994m);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public boolean mo5143a(@NotNull C1085tl<G, P> c1085tl) {
        return c1085tl.m5994m().isEmpty() || !this.f5663m.m3896bs();
    }

    @Override // com.boehmod.blockfront.InterfaceC1082ti
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public C0797oP mo5202a(@NotNull G g) {
        return this.f5663m;
    }
}
