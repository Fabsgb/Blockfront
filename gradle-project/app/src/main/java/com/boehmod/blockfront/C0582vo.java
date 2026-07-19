package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vo.class */
public final class C0582vo {
    public static void a(@NotNull CustomPacketPayload customPacketPayload, @NotNull ServerPlayer serverPlayer) {
        du();
        PacketDistributor.sendToPlayer(serverPlayer, customPacketPayload, new CustomPacketPayload[0]);
    }

    public static void b(@NotNull CustomPacketPayload customPacketPayload) {
        PacketDistributor.sendToAllPlayers(customPacketPayload, new CustomPacketPayload[0]);
    }

    public static void a(@NotNull CustomPacketPayload customPacketPayload, @NotNull List<ServerPlayer> list) {
        list.forEach(serverPlayer -> {
            a(customPacketPayload, serverPlayer);
        });
    }

    public static void a(@NotNull CustomPacketPayload customPacketPayload, @NotNull oF<?, ?, ?> oFVar) {
        Iterator<UUID> it = oFVar.b().j().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerA = oR.a(it.next());
            if (serverPlayerA != null) {
                a(customPacketPayload, serverPlayerA);
            }
        }
    }

    public static void a(@NotNull CustomPacketPayload customPacketPayload, @NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid) {
        ServerPlayer serverPlayerA;
        for (UUID uuid2 : oFVar.b().j()) {
            if (!uuid2.equals(uuid) && (serverPlayerA = oR.a(uuid2)) != null) {
                a(customPacketPayload, serverPlayerA);
            }
        }
    }

    public static void c(@NotNull CustomPacketPayload customPacketPayload) {
        du();
        PacketDistributor.sendToServer(customPacketPayload, new CustomPacketPayload[0]);
    }

    private static void du() {
    }
}
