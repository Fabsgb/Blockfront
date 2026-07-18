package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rU.class */
public class C0961rU extends AbstractC1080tg<C0955rO, C0958rR> {

    /* JADX INFO: renamed from: pU */
    public static final int f5074pU = 20;

    public C0961rU() {
        super(20);
    }

    @Override // com.boehmod.blockfront.AbstractC1080tg
    /* JADX INFO: renamed from: f */
    protected void mo5245f(@NotNull C1085tl<C0955rO, C0958rR> c1085tl) {
        Iterator<UUID> it = c1085tl.m5994m().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(it.next());
            if (serverPlayerM3963a != null) {
                ((C0958rR) c1085tl.m5990c()).m5242g(serverPlayerM3963a);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1084tk<C0955rO, C0958rR> mo5148a(@NotNull C0955rO c0955rO) {
        return new C0960rT();
    }
}
