package com.boehmod.blockfront;

import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sj.class */
public class C1031sj extends AbstractC1056tH<C1027sf, C1029sh> implements InterfaceC1054tF<C1027sf, C1029sh> {

    /* JADX INFO: renamed from: rR */
    private static final int f5624rR = 10;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0873pl f5625c = new C0873pl(10, 0).m4326a(20);

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5312a(@NotNull C1057tI<C1027sf, C1029sh> c1057tI) {
        C0875pn.m4361a(c1057tI.m5874m(), C0502il.m2254a().m2256b(EnumC1203vw.START_GENERIC).m2259a(5));
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: b */
    public void mo5313b(@NotNull C1057tI<C1027sf, C1029sh> c1057tI) {
        this.f5625c.m4328c(c1057tI.m5874m());
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public boolean mo5314a(@NotNull C1057tI<C1027sf, C1029sh> c1057tI) {
        return ((C1029sh) c1057tI.m5870c()).mo4260a(c1057tI.m5873a(), c1057tI.m5874m(), this.f5625c) != null;
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: e */
    public void mo5605e(@NotNull C1057tI<C1027sf, C1029sh> c1057tI) {
        C0875pn.m4392a(c1057tI.m5872b(), c1057tI.m5874m());
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1056tH<C1027sf, C1029sh> mo5319a(@NotNull C1027sf c1027sf) {
        return new C1030si();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0871pj mo5316a() {
        return EnumC0871pj.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5317a(@NotNull C1057tI<C1027sf, C1029sh> c1057tI, @NotNull EnumC0876po enumC0876po, @NotNull ServerPlayer serverPlayer) {
        C0875pn.m4362a(serverPlayer.getUUID(), C0502il.m2254a().m2256b(EnumC1203vw.START_GENERIC).m2259a(5));
    }

    @Override // com.boehmod.blockfront.InterfaceC1054tF
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0873pl mo5608a(@NotNull C1027sf c1027sf) {
        return this.f5625c;
    }
}
