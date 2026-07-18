package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import java.util.Set;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tf.class */
public abstract class AbstractC1079tf<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> extends AbstractC1084tk<G, P> implements InterfaceC1082ti<G, P> {

    /* JADX INFO: renamed from: jy */
    @NotNull
    public static final Component f5659jy = Component.translatable("bf.message.disconnect.mm.restarting");

    /* JADX INFO: renamed from: a */
    @NotNull
    public C0797oP f5660a = new C0797oP(1, 0).m3890a(15);

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5141a(@NotNull C1085tl<G, P> c1085tl) {
        c1085tl.m5989c().m3629a().m6029d(c1085tl.m5991b());
        C0799oR.m3956a(c1085tl.m5992b(), c1085tl.m5994m());
        mo5199c(c1085tl);
    }

    /* JADX INFO: renamed from: c */
    protected void mo5199c(@NotNull C1085tl<G, P> c1085tl) {
        Set<UUID> setM5994m = c1085tl.m5994m();
        C0864pd c0864pdMo3824a = c1085tl.m5990c().mo3824a(c1085tl.m5993a(), setM5994m, (C0797oP) null);
        if (c0864pdMo3824a != null) {
            c1085tl.m5989c().m3574a(c1085tl.m5993a(), c1085tl.m5991b(), C1089tp.f5695l, true, c0864pdMo3824a, setM5994m);
            C0799oR.m3925a(setM5994m, C0431hU.m2020a().m2022b(EnumC1123uW.CONCLUDE_GENERIC).m2025a(5));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: b */
    public void mo5142b(@NotNull C1085tl<G, P> c1085tl) {
        this.f5660a.m3892c(c1085tl.m5994m());
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public boolean mo5143a(@NotNull C1085tl<G, P> c1085tl) {
        return c1085tl.m5994m().isEmpty() || !this.f5660a.m3896bs();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: e */
    public void mo5222e(@NotNull C1085tl<G, P> c1085tl) {
        AbstractC0787oF abstractC0787oFM5989c = c1085tl.m5989c();
        C0799oR.m3957b(c1085tl.m5992b(), c1085tl.m5994m());
        if (!abstractC0787oFM5989c.m3629a().m6032a(c1085tl.m5991b(), c1085tl.m5990c(), c1085tl.m5993a())) {
            C0799oR.m3960a(c1085tl.m5994m(), f5659jy);
        }
        abstractC0787oFM5989c.m3603d(c1085tl.m5993a());
        abstractC0787oFM5989c.m3604c(c1085tl.m5991b());
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5146a(@NotNull C1085tl<G, P> c1085tl, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerPlayer serverPlayer) {
        C0799oR.m3958a(c1085tl.m5992b(), serverPlayer);
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1084tk<G, P> mo5148a(@NotNull G g) {
        return g.mo3563a();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0795oN mo5145a() {
        return EnumC0795oN.POST_GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC1082ti
    /* JADX INFO: renamed from: a */
    public C0797oP mo5202a(@NotNull G g) {
        return this.f5660a;
    }
}
