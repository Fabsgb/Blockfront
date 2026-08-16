package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sr.class */
public class C1039sr extends AbstractC1052tD<C1033sl, C1036so> {

    /* JADX INFO: renamed from: rV */
    public static final int f5651rV = 20;

    public C1039sr() {
        super(20);
    }

    @Override // com.boehmod.blockfront.AbstractC1052tD
    /* JADX INFO: renamed from: f */
    protected void mo5782f(@NotNull C1057tI<C1033sl, C1036so> c1057tI) {
        Iterator<UUID> it = c1057tI.m5874m().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(it.next());
            if (serverPlayerM4399a != null) {
                ((C1036so) c1057tI.m5870c()).m5779g(serverPlayerM4399a);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1056tH<C1033sl, C1036so> mo5319a(@NotNull C1033sl c1033sl) {
        return new C1038sq();
    }
}
