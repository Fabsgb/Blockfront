package com.boehmod.blockfront;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oQ.class */
public final class C0799oQ {

    /* JADX INFO: renamed from: gm */
    static final /* synthetic */ boolean f4345gm;

    static {
        f4345gm = !C0799oQ.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m3685a(@NotNull PlayerEvent.PlayerLoggedOutEvent playerLoggedOutEvent) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4345gm && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        abstractC0531jNM179a.m2351a().m1156a(abstractC0531jNM179a, playerLoggedOutEvent.getEntity().level());
    }
}
