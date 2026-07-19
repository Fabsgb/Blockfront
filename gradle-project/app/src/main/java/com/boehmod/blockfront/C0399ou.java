package com.boehmod.blockfront;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ou, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ou.class */
public final class C0399ou {
    static final /* synthetic */ boolean fS;

    static {
        fS = !C0399ou.class.desiredAssertionStatus();
    }

    public static void a(@NotNull PlayerEvent.PlayerLoggedOutEvent playerLoggedOutEvent) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fS && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        abstractC0264juM166a.m531a().a(abstractC0264juM166a, playerLoggedOutEvent.getEntity().level());
    }
}
