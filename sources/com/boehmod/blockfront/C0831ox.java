package com.boehmod.blockfront;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ox */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ox.class */
public final class C0831ox {

    /* JADX INFO: renamed from: fT */
    static final /* synthetic */ boolean f4455fT;

    static {
        f4455fT = !C0831ox.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m4200a(@NotNull PlayerEvent.PlayerRespawnEvent playerRespawnEvent) {
        ServerPlayer entity = playerRespawnEvent.getEntity();
        ServerLevel serverLevel = entity.serverLevel();
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4455fT && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        abstractC0563juM168a.m2534a(abstractC0563juM168a, abstractC0563juM168a.m2528a(), serverLevel, entity, entity.getUUID());
    }
}
