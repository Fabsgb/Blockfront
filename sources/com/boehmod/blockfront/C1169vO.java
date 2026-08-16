package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vO.class */
public final class C1169vO {
    /* JADX INFO: renamed from: a */
    public static void m6643a(@NotNull CustomPacketPayload customPacketPayload, @NotNull ServerPlayer serverPlayer) {
        m6649dE();
        PacketDistributor.sendToPlayer(serverPlayer, customPacketPayload, new CustomPacketPayload[0]);
    }

    /* JADX INFO: renamed from: b */
    public static void m6644b(@NotNull CustomPacketPayload customPacketPayload) {
        PacketDistributor.sendToAllPlayers(customPacketPayload, new CustomPacketPayload[0]);
    }

    /* JADX INFO: renamed from: a */
    public static void m6645a(@NotNull CustomPacketPayload customPacketPayload, @NotNull List<ServerPlayer> list) {
        list.forEach(serverPlayer -> {
            m6643a(customPacketPayload, serverPlayer);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m6646a(@NotNull CustomPacketPayload customPacketPayload, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        Iterator<UUID> it = abstractC0863pb.m4018b().m4248j().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM4399a = C0875pn.m4399a(it.next());
            if (serverPlayerM4399a != null) {
                m6643a(customPacketPayload, serverPlayerM4399a);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m6647a(@NotNull CustomPacketPayload customPacketPayload, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid) {
        ServerPlayer serverPlayerM4399a;
        for (UUID uuid2 : abstractC0863pb.m4018b().m4248j()) {
            if (!uuid2.equals(uuid) && (serverPlayerM4399a = C0875pn.m4399a(uuid2)) != null) {
                m6643a(customPacketPayload, serverPlayerM4399a);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m6648c(@NotNull CustomPacketPayload customPacketPayload) {
        m6649dE();
        PacketDistributor.sendToServer(customPacketPayload, new CustomPacketPayload[0]);
    }

    /* JADX INFO: renamed from: dE */
    private static void m6649dE() {
    }
}
