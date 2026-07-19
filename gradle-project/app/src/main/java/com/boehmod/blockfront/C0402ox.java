package com.boehmod.blockfront;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ox, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ox.class */
public final class C0402ox {
    static final /* synthetic */ boolean fT;

    static {
        fT = !C0402ox.class.desiredAssertionStatus();
    }

    public static void a(@NotNull PlayerEvent.PlayerRespawnEvent playerRespawnEvent) {
        ServerPlayer entity = playerRespawnEvent.getEntity();
        ServerLevel serverLevel = entity.serverLevel();
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fT && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        abstractC0264juM166a.a(abstractC0264juM166a, abstractC0264juM166a.m531a(), serverLevel, entity, entity.getUUID());
    }
}
