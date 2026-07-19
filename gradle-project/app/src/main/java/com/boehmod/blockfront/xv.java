package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.PacketRegistry;
import com.boehmod.bflib.cloud.packet.common.discord.PacketDiscordVCPlayers;
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMSchedulePlayer;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedClanData;
import com.boehmod.blockfront.cloud.connection.ModConnection;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.io.IOException;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xv.class */
public class xv {
    public static void c(@NotNull xw xwVar) {
        C0263jt.log("[Cloud] Registering server-specific cloud packet handlers...", new Object[0]);
        PacketRegistry.registerPacketHandler(PacketDiscordVCPlayers.class, (packetDiscordVCPlayers, modConnection) -> {
            a(xwVar, packetDiscordVCPlayers);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedClanData.class, (packetRequestedClanData, modConnection2) -> {
            a(xwVar, packetRequestedClanData);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketMMSchedulePlayer.class, (packetMMSchedulePlayer, modConnection3) -> {
            a(xwVar, packetMMSchedulePlayer);
        }, ModConnection.class);
        C0263jt.log("[Cloud] Finished registering server-specific cloud packet handlers.", new Object[0]);
    }

    public static void a(@NotNull xw xwVar, @NotNull PacketDiscordVCPlayers packetDiscordVCPlayers) {
        xQ xQVar = (xQ) xwVar.a();
        ObjectSet<UUID> objectSetVoiceChannelPlayers = packetDiscordVCPlayers.voiceChannelPlayers();
        MinecraftServer minecraftServerA = C0262js.a();
        if (minecraftServerA != null) {
            for (ServerPlayer serverPlayer : minecraftServerA.getPlayerList().getPlayers()) {
                ((xO) xQVar.a((Player) serverPlayer)).ac(objectSetVoiceChannelPlayers.contains(serverPlayer.getUUID()));
            }
        }
    }

    public static void a(@NotNull xw xwVar, @NotNull PacketRequestedClanData packetRequestedClanData) {
        ((xQ) xwVar.a()).a(packetRequestedClanData.uuid(), packetRequestedClanData.clanData());
    }

    public static void a(@NotNull xw xwVar, @NotNull PacketMMSchedulePlayer packetMMSchedulePlayer) {
        xt xtVarM1710a = xwVar.m1710a();
        UUID uuidPlayerUUID = packetMMSchedulePlayer.playerUUID();
        xtVarM1710a.a(uuidPlayerUUID, packetMMSchedulePlayer.match(), packetMMSchedulePlayer.intent());
        try {
            ((xQ) xwVar.a()).a(uuidPlayerUUID, packetMMSchedulePlayer.context(), packetMMSchedulePlayer.data());
        } catch (IOException e) {
            C0263jt.a("Failed to prime cloud data for scheduled player '" + String.valueOf(uuidPlayerUUID) + "'", e, new Object[0]);
        }
        C0263jt.log("Received MM schedule for player '%s' to join match '%s'", uuidPlayerUUID.toString(), packetMMSchedulePlayer.match().toString());
    }
}
