package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ot */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ot.class */
public final class C0827ot {

    /* JADX INFO: renamed from: fR */
    static final /* synthetic */ boolean f4453fR;

    static {
        f4453fR = !C0827ot.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m4196a(@NotNull PlayerEvent.PlayerLoggedInEvent playerLoggedInEvent) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4453fR && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        ServerPlayer entity = playerLoggedInEvent.getEntity();
        Level levelServerLevel = entity.serverLevel();
        UUID uuid = entity.getUUID();
        AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        MinecraftServer server = entity.getServer();
        if ((abstractC0563juM168a instanceof C1300xw) && ((C1300xw) abstractC0563juM168a).mo2551f() && server != null && server.isDedicatedServer()) {
            C0799oR.m3948a((AbstractC0183c<?>) abstractC0183cM2528a, (ServerLevel) levelServerLevel, entity);
            C0799oR.m4031a(abstractC0563juM168a, (AbstractC0183c<?>) abstractC0183cM2528a, (ServerLevel) levelServerLevel, entity);
            abstractC0563juM168a.m2520b().m2145a().m2165b(RequestType.PLAYER_DATA, uuid);
        }
        abstractC0183cM2528a.m1139a(abstractC0563juM168a, levelServerLevel);
    }
}
