package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.se */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/se.class */
public class C1025se extends AbstractC1052tD<C0966rY, C1022sb> {

    /* JADX INFO: renamed from: rN */
    public static final int f5615rN = 45;

    public C1025se() {
        super(45);
    }

    @Override // com.boehmod.blockfront.AbstractC1053tE, com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5312a(@NotNull C1057tI<C0966rY, C1022sb> c1057tI) {
        super.mo5312a((C1057tI) c1057tI);
        Iterator<UUID> it = c1057tI.m5874m().iterator();
        while (it.hasNext()) {
            C0966rY.m5320a((C0966rY) c1057tI.m5869c(), c1057tI.m5871b(), it.next(), false);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1052tD
    /* JADX INFO: renamed from: d */
    protected void mo5693d(@NotNull C1057tI<C0966rY, C1022sb> c1057tI) {
        ((C0966rY) c1057tI.m5869c()).mo5332e(c1057tI.m5873a());
        m5868g(c1057tI);
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1056tH<C0966rY, C1022sb> mo5319a(@NotNull C0966rY c0966rY) {
        return new C1024sd();
    }

    @Override // com.boehmod.blockfront.AbstractC1053tE, com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5317a(@NotNull C1057tI<C0966rY, C1022sb> c1057tI, @NotNull EnumC0876po enumC0876po, @NotNull ServerPlayer serverPlayer) {
        if (enumC0876po == EnumC0876po.NEW) {
            C0966rY.m5320a((C0966rY) c1057tI.m5869c(), c1057tI.m5871b(), serverPlayer.getUUID(), false);
            C0875pn.m4362a(serverPlayer.getUUID(), C0502il.m2254a().m2257c(EnumC1203vw.WARMUP));
        }
    }
}
