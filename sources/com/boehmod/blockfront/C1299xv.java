package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.PacketRegistry;
import com.boehmod.bflib.cloud.packet.common.discord.PacketDiscordVCPlayers;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMSchedulePlayer;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedClanData;
import com.boehmod.blockfront.cloud.connection.ModConnection;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.io.IOException;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xv.class */
public class C1299xv {
    /* JADX INFO: renamed from: c */
    public static void m7943c(@NotNull C1300xw c1300xw) {
        C0562jt.log("[Cloud] Registering server-specific cloud packet handlers...", new Object[0]);
        PacketRegistry.registerPacketHandler(PacketDiscordVCPlayers.class, (packetDiscordVCPlayers, modConnection) -> {
            m7944a(c1300xw, packetDiscordVCPlayers);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedClanData.class, (packetRequestedClanData, modConnection2) -> {
            m7945a(c1300xw, packetRequestedClanData);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketMMSchedulePlayer.class, (packetMMSchedulePlayer, modConnection3) -> {
            m7946a(c1300xw, packetMMSchedulePlayer);
        }, ModConnection.class);
        C0562jt.log("[Cloud] Finished registering server-specific cloud packet handlers.", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public static void m7944a(@NotNull C1300xw c1300xw, @NotNull PacketDiscordVCPlayers packetDiscordVCPlayers) {
        C1276xQ c1276xQ = (C1276xQ) c1300xw.m7950a();
        ObjectSet<UUID> objectSetVoiceChannelPlayers = packetDiscordVCPlayers.voiceChannelPlayers();
        MinecraftServer minecraftServerM2514a = C0561js.m2514a();
        if (minecraftServerM2514a != null) {
            for (ServerPlayer serverPlayer : minecraftServerM2514a.getPlayerList().getPlayers()) {
                ((C1274xO) c1276xQ.m1133a((Player) serverPlayer)).m7788ac(objectSetVoiceChannelPlayers.contains(serverPlayer.getUUID()));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7945a(@NotNull C1300xw c1300xw, @NotNull PacketRequestedClanData packetRequestedClanData) {
        ((C1276xQ) c1300xw.m7950a()).m1134a(packetRequestedClanData.uuid(), packetRequestedClanData.clanData());
    }

    /* JADX INFO: renamed from: a */
    public static void m7946a(@NotNull C1300xw c1300xw, @NotNull PacketMMSchedulePlayer packetMMSchedulePlayer) {
        C1297xt c1297xtM7952a = c1300xw.m7952a();
        UUID uuidPlayerUUID = packetMMSchedulePlayer.playerUUID();
        c1297xtM7952a.m7932a(uuidPlayerUUID, packetMMSchedulePlayer.match(), packetMMSchedulePlayer.intent());
        try {
            ((C1276xQ) c1300xw.m7950a()).m1140a(uuidPlayerUUID, packetMMSchedulePlayer.context(), packetMMSchedulePlayer.data());
        } catch (IOException e) {
            C0562jt.m2516a("Failed to prime cloud data for scheduled player '" + String.valueOf(uuidPlayerUUID) + "'", e, new Object[0]);
        }
        C0562jt.log("Received MM schedule for player '%s' to join match '%s'", uuidPlayerUUID.toString(), packetMMSchedulePlayer.match().toString());
    }
}
