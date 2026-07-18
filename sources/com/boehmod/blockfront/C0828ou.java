package com.boehmod.blockfront;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ou */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ou.class */
public final class C0828ou {

    /* JADX INFO: renamed from: fS */
    static final /* synthetic */ boolean f4454fS;

    static {
        f4454fS = !C0828ou.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m4197a(@NotNull PlayerEvent.PlayerLoggedOutEvent playerLoggedOutEvent) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4454fS && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        abstractC0563juM168a.m2528a().m1139a(abstractC0563juM168a, playerLoggedOutEvent.getEntity().level());
    }
}
