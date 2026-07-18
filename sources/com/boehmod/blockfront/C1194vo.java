package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vo.class */
public final class C1194vo {
    /* JADX INFO: renamed from: a */
    public static void m6648a(@NotNull CustomPacketPayload customPacketPayload, @NotNull ServerPlayer serverPlayer) {
        m6654du();
        PacketDistributor.sendToPlayer(serverPlayer, customPacketPayload, new CustomPacketPayload[0]);
    }

    /* JADX INFO: renamed from: b */
    public static void m6649b(@NotNull CustomPacketPayload customPacketPayload) {
        PacketDistributor.sendToAllPlayers(customPacketPayload, new CustomPacketPayload[0]);
    }

    /* JADX INFO: renamed from: a */
    public static void m6650a(@NotNull CustomPacketPayload customPacketPayload, @NotNull List<ServerPlayer> list) {
        list.forEach(serverPlayer -> {
            m6648a(customPacketPayload, serverPlayer);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m6651a(@NotNull CustomPacketPayload customPacketPayload, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        Iterator<UUID> it = abstractC0787oF.m3582b().m3812j().iterator();
        while (it.hasNext()) {
            ServerPlayer serverPlayerM3963a = C0799oR.m3963a(it.next());
            if (serverPlayerM3963a != null) {
                m6648a(customPacketPayload, serverPlayerM3963a);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m6652a(@NotNull CustomPacketPayload customPacketPayload, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid) {
        ServerPlayer serverPlayerM3963a;
        for (UUID uuid2 : abstractC0787oF.m3582b().m3812j()) {
            if (!uuid2.equals(uuid) && (serverPlayerM3963a = C0799oR.m3963a(uuid2)) != null) {
                m6648a(customPacketPayload, serverPlayerM3963a);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m6653c(@NotNull CustomPacketPayload customPacketPayload) {
        m6654du();
        PacketDistributor.sendToServer(customPacketPayload, new CustomPacketPayload[0]);
    }

    /* JADX INFO: renamed from: du */
    private static void m6654du() {
    }
}
