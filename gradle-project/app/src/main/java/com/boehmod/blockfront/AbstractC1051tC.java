package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import java.util.Set;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tC.class */
public abstract class AbstractC1051tC<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> extends AbstractC1056tH<G, P> implements InterfaceC1054tF<G, P> {

    /* JADX INFO: renamed from: jL */
    @NotNull
    public static final Component f5706jL = Component.translatable("bf.message.disconnect.mm.restarting");

    /* JADX INFO: renamed from: a */
    @NotNull
    public C0873pl f5707a = new C0873pl(1, 0).m4326a(15);

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5312a(@NotNull C1057tI<G, P> c1057tI) {
        c1057tI.m5869c().m4065a().m5915d(c1057tI.m5871b());
        C0875pn.m4392a(c1057tI.m5872b(), c1057tI.m5874m());
        mo5604c(c1057tI);
    }

    /* JADX INFO: renamed from: c */
    protected void mo5604c(@NotNull C1057tI<G, P> c1057tI) {
        Set<UUID> setM5874m = c1057tI.m5874m();
        C0887pz c0887pzMo4260a = c1057tI.m5870c().mo4260a(c1057tI.m5873a(), setM5874m, (C0873pl) null);
        if (c0887pzMo4260a != null) {
            c1057tI.m5869c().m4010a(c1057tI.m5873a(), c1057tI.m5871b(), C1062tN.f5748l, true, c0887pzMo4260a, setM5874m);
            C0875pn.m4361a(setM5874m, C0502il.m2254a().m2256b(EnumC1203vw.CONCLUDE_GENERIC).m2259a(5));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: b */
    public void mo5313b(@NotNull C1057tI<G, P> c1057tI) {
        this.f5707a.m4328c(c1057tI.m5874m());
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public boolean mo5314a(@NotNull C1057tI<G, P> c1057tI) {
        return c1057tI.m5874m().isEmpty() || !this.f5707a.m4332bC();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: e */
    public void mo5605e(@NotNull C1057tI<G, P> c1057tI) {
        AbstractC0863pb abstractC0863pbM5869c = c1057tI.m5869c();
        C0875pn.m4393b(c1057tI.m5872b(), c1057tI.m5874m());
        if (!abstractC0863pbM5869c.m4065a().m5918a(c1057tI.m5871b(), c1057tI.m5870c(), c1057tI.m5873a())) {
            C0875pn.m4396a(c1057tI.m5874m(), f5706jL);
        }
        abstractC0863pbM5869c.m4039d(c1057tI.m5873a());
        abstractC0863pbM5869c.m4040c(c1057tI.m5871b());
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5317a(@NotNull C1057tI<G, P> c1057tI, @NotNull EnumC0876po enumC0876po, @NotNull ServerPlayer serverPlayer) {
        C0875pn.m4394a(c1057tI.m5872b(), serverPlayer);
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC1056tH<G, P> mo5319a(@NotNull G g) {
        return g.mo3999a();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0871pj mo5316a() {
        return EnumC0871pj.POST_GAME;
    }

    @Override // com.boehmod.blockfront.InterfaceC1054tF
    /* JADX INFO: renamed from: a */
    public C0873pl mo5608a(@NotNull G g) {
        return this.f5707a;
    }
}
