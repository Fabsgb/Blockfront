package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ot, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ot.class */
public final class C0398ot {
    static final /* synthetic */ boolean fR;

    static {
        fR = !C0398ot.class.desiredAssertionStatus();
    }

    public static void a(@NotNull PlayerEvent.PlayerLoggedInEvent playerLoggedInEvent) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fR && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        ServerPlayer entity = playerLoggedInEvent.getEntity();
        Level levelServerLevel = entity.serverLevel();
        UUID uuid = entity.getUUID();
        com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
        MinecraftServer server = entity.getServer();
        if ((abstractC0264juM166a instanceof xw) && ((xw) abstractC0264juM166a).f() && server != null && server.isDedicatedServer()) {
            oR.a((com.boehmod.blockfront.common.player.c<?>) cVarM531a, (ServerLevel) levelServerLevel, entity);
            oR.a(abstractC0264juM166a, (com.boehmod.blockfront.common.player.c<?>) cVarM531a, (ServerLevel) levelServerLevel, entity);
            abstractC0264juM166a.m529b().m484a().b(RequestType.PLAYER_DATA, uuid);
        }
        cVarM531a.a(abstractC0264juM166a, levelServerLevel);
    }
}
