package com.boehmod.blockfront;

import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rT.class */
public class C0960rT extends AbstractC1084tk<C0955rO, C0958rR> implements InterfaceC1082ti<C0955rO, C0958rR> {

    /* JADX INFO: renamed from: pT */
    public static final int f5072pT = 15;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final C0797oP f5073d = new C0797oP(15, 0).m3890a(20);

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5141a(@NotNull C1085tl<C0955rO, C0958rR> c1085tl) {
        C0799oR.m3925a(c1085tl.m5994m(), C0431hU.m2020a().m2022b(EnumC1123uW.START_GENERIC).m2025a(5));
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: b */
    public void mo5142b(@NotNull C1085tl<C0955rO, C0958rR> c1085tl) {
        this.f5073d.m3892c(c1085tl.m5994m());
        C0799oR.m3957b(c1085tl.m5992b(), c1085tl.m5994m());
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public boolean mo5143a(@NotNull C1085tl<C0955rO, C0958rR> c1085tl) {
        return ((C0958rR) c1085tl.m5990c()).mo3824a(c1085tl.m5993a(), c1085tl.m5994m(), this.f5073d) != null;
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1084tk<C0955rO, C0958rR> mo5148a(@NotNull C0955rO c0955rO) {
        return new C0959rS();
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0795oN mo5145a() {
        return EnumC0795oN.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5146a(@NotNull C1085tl<C0955rO, C0958rR> c1085tl, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerPlayer serverPlayer) {
        C0799oR.m3926a(serverPlayer.getUUID(), C0431hU.m2020a().m2022b(EnumC1123uW.START_GENERIC).m2025a(5));
    }

    @Override // com.boehmod.blockfront.InterfaceC1082ti
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0797oP mo5202a(@NotNull C0955rO c0955rO) {
        return this.f5073d;
    }
}
