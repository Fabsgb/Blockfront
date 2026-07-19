package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rU.class */
public class rU extends AbstractC0520tg<rO, rR> {
    public static final int pU = 20;

    public rU() {
        super(20);
    }

    @Override // com.boehmod.blockfront.AbstractC0520tg
    protected void f(@NotNull C0525tl<rO, rR> c0525tl) {
        Iterator<UUID> it = c0525tl.m().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerA = oR.a(it.next());
            if (serverPlayerA != null) {
                ((rR) c0525tl.m1161c()).g(serverPlayerA);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<rO, rR> a(@NotNull rO rOVar) {
        return new rT();
    }
}
