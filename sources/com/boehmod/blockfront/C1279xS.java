package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.PacketRegistry;
import com.boehmod.bflib.cloud.packet.common.discord.PacketDiscordVCPlayers;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMSchedulePlayer;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedClanData;
import com.boehmod.blockfront.cloud.connection.ModConnection;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.io.IOException;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xS.class */
public class C1279xS {
    /* JADX INFO: renamed from: c */
    public static void m7270c(@NotNull C1280xT c1280xT) {
        C0530jM.log("[Cloud] Registering server-specific cloud packet handlers...", new Object[0]);
        PacketRegistry.registerPacketHandler(PacketDiscordVCPlayers.class, (packetDiscordVCPlayers, modConnection) -> {
            m7271a(c1280xT, packetDiscordVCPlayers);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedClanData.class, (packetRequestedClanData, modConnection2) -> {
            m7272a(c1280xT, packetRequestedClanData);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketMMSchedulePlayer.class, (packetMMSchedulePlayer, modConnection3) -> {
            m7273a(c1280xT, packetMMSchedulePlayer);
        }, ModConnection.class);
        C0530jM.log("[Cloud] Finished registering server-specific cloud packet handlers.", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public static void m7271a(@NotNull C1280xT c1280xT, @NotNull PacketDiscordVCPlayers packetDiscordVCPlayers) {
        C1328yo c1328yo = (C1328yo) c1280xT.m7277a();
        ObjectSet<UUID> objectSetVoiceChannelPlayers = packetDiscordVCPlayers.voiceChannelPlayers();
        MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
        if (minecraftServerM2335a != null) {
            for (ServerPlayer serverPlayer : minecraftServerM2335a.getPlayerList().getPlayers()) {
                ((C1326ym) c1328yo.m1150a((Player) serverPlayer)).m8304ad(objectSetVoiceChannelPlayers.contains(serverPlayer.getUUID()));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7272a(@NotNull C1280xT c1280xT, @NotNull PacketRequestedClanData packetRequestedClanData) {
        ((C1328yo) c1280xT.m7277a()).m1151a(packetRequestedClanData.uuid(), packetRequestedClanData.clanData());
    }

    /* JADX INFO: renamed from: a */
    public static void m7273a(@NotNull C1280xT c1280xT, @NotNull PacketMMSchedulePlayer packetMMSchedulePlayer) {
        C1277xQ c1277xQM7279a = c1280xT.m7279a();
        UUID uuidPlayerUUID = packetMMSchedulePlayer.playerUUID();
        c1277xQM7279a.m7259a(uuidPlayerUUID, packetMMSchedulePlayer.match(), packetMMSchedulePlayer.intent());
        try {
            ((C1328yo) c1280xT.m7277a()).m1157a(uuidPlayerUUID, packetMMSchedulePlayer.context(), packetMMSchedulePlayer.data());
        } catch (IOException e) {
            C0530jM.m2338a("Failed to prime cloud data for scheduled player '" + String.valueOf(uuidPlayerUUID) + "'", e, new Object[0]);
        }
        C0530jM.log("Received MM schedule for player '%s' to join match '%s'", uuidPlayerUUID.toString(), packetMMSchedulePlayer.match().toString());
    }
}
