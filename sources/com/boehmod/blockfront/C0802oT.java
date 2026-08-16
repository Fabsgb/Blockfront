package com.boehmod.blockfront;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oT.class */
public final class C0802oT {

    /* JADX INFO: renamed from: gn */
    static final /* synthetic */ boolean f4346gn;

    static {
        f4346gn = !C0802oT.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m3688a(@NotNull PlayerEvent.PlayerRespawnEvent playerRespawnEvent) {
        ServerPlayer entity = playerRespawnEvent.getEntity();
        ServerLevel serverLevel = entity.serverLevel();
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4346gn && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        abstractC0531jNM179a.m2357a(abstractC0531jNM179a, abstractC0531jNM179a.m2351a(), serverLevel, entity, entity.getUUID());
    }
}
