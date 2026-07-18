package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rH.class */
public class C0948rH extends AbstractC1080tg<C0942rB, C0945rE> {

    /* JADX INFO: renamed from: pM */
    public static final int f5039pM = 45;

    public C0948rH() {
        super(45);
    }

    @Override // com.boehmod.blockfront.AbstractC1081th, com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5141a(@NotNull C1085tl<C0942rB, C0945rE> c1085tl) {
        super.mo5141a((C1085tl) c1085tl);
        Iterator<UUID> it = c1085tl.m5994m().iterator();
        while (it.hasNext()) {
            C0942rB.m5149a((C0942rB) c1085tl.m5989c(), c1085tl.m5991b(), it.next(), false);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1080tg
    /* JADX INFO: renamed from: d */
    protected void mo5204d(@NotNull C1085tl<C0942rB, C0945rE> c1085tl) {
        ((C0942rB) c1085tl.m5989c()).mo4656e(c1085tl.m5993a());
        m5988g(c1085tl);
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1084tk<C0942rB, C0945rE> mo5148a(@NotNull C0942rB c0942rB) {
        return new C0947rG();
    }

    @Override // com.boehmod.blockfront.AbstractC1081th, com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5146a(@NotNull C1085tl<C0942rB, C0945rE> c1085tl, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerPlayer serverPlayer) {
        if (enumC0800oS == EnumC0800oS.NEW) {
            C0942rB.m5149a((C0942rB) c1085tl.m5989c(), c1085tl.m5991b(), serverPlayer.getUUID(), false);
            C0799oR.m3926a(serverPlayer.getUUID(), C0431hU.m2020a().m2023c(EnumC1123uW.WARMUP));
        }
    }
}
