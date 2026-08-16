package com.boehmod.blockfront;

import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.sU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sU.class */
public class C1015sU extends AbstractC1056tH<C1011sQ, C1013sS> implements InterfaceC1054tF<C1011sQ, C1013sS> {

    /* JADX INFO: renamed from: ta */
    private static final int f5580ta = 10;

    /* JADX INFO: renamed from: i */
    @NotNull
    private final C0873pl f5581i = new C0873pl(10, 0).m4326a(20);

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5312a(@NotNull C1057tI<C1011sQ, C1013sS> c1057tI) {
        C0875pn.m4361a(c1057tI.m5874m(), C0502il.m2254a().m2256b(EnumC1203vw.START_GENERIC).m2259a(5));
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: b */
    public void mo5313b(@NotNull C1057tI<C1011sQ, C1013sS> c1057tI) {
        this.f5581i.m4328c(c1057tI.m5874m());
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public boolean mo5314a(@NotNull C1057tI<C1011sQ, C1013sS> c1057tI) {
        return ((C1013sS) c1057tI.m5870c()).mo4260a(c1057tI.m5873a(), c1057tI.m5874m(), this.f5581i) != null;
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1056tH<C1011sQ, C1013sS> mo5319a(@NotNull C1011sQ c1011sQ) {
        return new C1014sT();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0871pj mo5316a() {
        return EnumC0871pj.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5317a(@NotNull C1057tI<C1011sQ, C1013sS> c1057tI, @NotNull EnumC0876po enumC0876po, @NotNull ServerPlayer serverPlayer) {
        C0875pn.m4362a(serverPlayer.getUUID(), C0502il.m2254a().m2256b(EnumC1203vw.START_GENERIC).m2259a(5));
    }

    @Override // com.boehmod.blockfront.InterfaceC1054tF
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0873pl mo5608a(@NotNull C1011sQ c1011sQ) {
        return this.f5581i;
    }
}
