package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.player.PlayerDataContext;
import com.boehmod.bflib.cloud.common.player.status.PublicPlayerStatus;
import com.boehmod.bflib.cloud.common.profanity.Profanity;
import com.boehmod.bflib.cloud.connection.Connection;
import com.boehmod.bflib.cloud.packet.PacketRegistry;
import com.boehmod.bflib.cloud.packet.common.PacketFeatureFlags;
import com.boehmod.bflib.cloud.packet.common.PacketProfanitySync;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedInventory;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedInventoryMinimal;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedItemDefault;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedItemShowcase;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedPlayerData;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedPlayerDataSet;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedPlayerStatusSet;
import com.boehmod.bflib.cloud.packet.common.server.PacketServerNotification;
import com.boehmod.blockfront.cloud.connection.ModConnection;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.Pair;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jj.class */
public class C0552jj {

    /* JADX INFO: renamed from: ia */
    private static final Component f3173ia;

    /* JADX INFO: renamed from: du */
    static final /* synthetic */ boolean f3174du;

    static {
        f3174du = !C0552jj.class.desiredAssertionStatus();
        f3173ia = Component.literal(String.valueOf((char) 57362)).append(" ");
    }

    /* JADX INFO: renamed from: ba */
    public static void m2492ba() {
        C0562jt.log("[Cloud] Registering common cloud packet handlers...", new Object[0]);
        PacketRegistry.registerPacketHandler(PacketServerNotification.class, (v0, v1) -> {
            m2500a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedPlayerData.class, (v0, v1) -> {
            m2493a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedPlayerDataSet.class, (v0, v1) -> {
            m2494a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedInventory.class, (v0, v1) -> {
            m2496a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedInventoryMinimal.class, (v0, v1) -> {
            m2499a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedItemDefault.class, (v0, v1) -> {
            m2497a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedItemShowcase.class, (v0, v1) -> {
            m2498a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedPlayerStatusSet.class, (v0, v1) -> {
            m2495a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketFeatureFlags.class, (v0, v1) -> {
            m2502a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketProfanitySync.class, (v0, v1) -> {
            m2501a(v0, v1);
        }, ModConnection.class);
        C0562jt.log("[Cloud] Finished registering common cloud packet handlers.", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    private static void m2493a(@NotNull PacketRequestedPlayerData packetRequestedPlayerData, @NotNull Connection<?> connection) throws IOException {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a == null) {
            return;
        }
        AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer(packetRequestedPlayerData.data());
        try {
            abstractC0183cM2528a.m1132a(packetRequestedPlayerData.uuid()).read(packetRequestedPlayerData.context(), byteBufWrappedBuffer);
            byteBufWrappedBuffer.release();
        } catch (Throwable th) {
            byteBufWrappedBuffer.release();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2494a(@NotNull PacketRequestedPlayerDataSet packetRequestedPlayerDataSet, @NotNull Connection<?> connection) throws IOException {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a == null) {
            return;
        }
        AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        for (Map.Entry<UUID, Pair<PlayerDataContext, byte[]>> entry : packetRequestedPlayerDataSet.dataSet().entrySet()) {
            UUID key = entry.getKey();
            Pair<PlayerDataContext, byte[]> value = entry.getValue();
            PlayerDataContext playerDataContext = (PlayerDataContext) value.left();
            ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer((byte[]) value.right());
            try {
                abstractC0183cM2528a.m1132a(key).read(playerDataContext, byteBufWrappedBuffer);
                abstractC0563juM168a.m2520b().m2145a().m2163a(RequestType.PLAYER_DATA, key);
                byteBufWrappedBuffer.release();
            } catch (Throwable th) {
                byteBufWrappedBuffer.release();
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2495a(@NotNull PacketRequestedPlayerStatusSet packetRequestedPlayerStatusSet, @NotNull Connection<?> connection) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a == null) {
            return;
        }
        AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        for (Map.Entry<UUID, PublicPlayerStatus> entry : packetRequestedPlayerStatusSet.statusSet().entrySet()) {
            abstractC0183cM2528a.m1132a(entry.getKey()).setStatus(entry.getValue());
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2496a(@NotNull PacketRequestedInventory packetRequestedInventory, @NotNull Connection<?> connection) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a == null) {
            return;
        }
        abstractC0563juM168a.m2528a().m1132a(packetRequestedInventory.uuid()).getInventory().onReceiveSection(packetRequestedInventory.stacks(), packetRequestedInventory.section());
    }

    /* JADX INFO: renamed from: a */
    private static void m2497a(@NotNull PacketRequestedItemDefault packetRequestedItemDefault, @NotNull Connection<?> connection) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a == null) {
            return;
        }
        abstractC0563juM168a.m2528a().m1132a(packetRequestedItemDefault.uuid()).getInventory().populateEquippedItems(abstractC0563juM168a.m2550a(), packetRequestedItemDefault.itemStacks());
    }

    /* JADX INFO: renamed from: a */
    private static void m2498a(@NotNull PacketRequestedItemShowcase packetRequestedItemShowcase, @NotNull Connection<?> connection) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a == null) {
            return;
        }
        abstractC0563juM168a.m2528a().m1132a(packetRequestedItemShowcase.uuid()).getInventory().populateShowcasedItems(packetRequestedItemShowcase.itemStacks());
    }

    /* JADX INFO: renamed from: a */
    private static void m2499a(@NotNull PacketRequestedInventoryMinimal packetRequestedInventoryMinimal, @NotNull Connection<?> connection) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a == null) {
            return;
        }
        CloudRegistry cloudRegistryM2550a = abstractC0563juM168a.m2550a();
        C0477iN inventory = abstractC0563juM168a.m2528a().m1132a(packetRequestedInventoryMinimal.uuid()).getInventory();
        inventory.onReceiveMinimalStacks(packetRequestedInventoryMinimal.stacks());
        inventory.populateShowcasedItems(packetRequestedInventoryMinimal.showcased());
        inventory.populateEquippedItems(cloudRegistryM2550a, packetRequestedInventoryMinimal.equipped());
    }

    /* JADX INFO: renamed from: a */
    private static void m2500a(@NotNull PacketServerNotification packetServerNotification, @NotNull Connection<?> connection) {
        Optional<UUID> optionalMatch = packetServerNotification.match();
        MutableComponent mutableComponentFromJson = Component.Serializer.fromJson(packetServerNotification.message(), RegistryAccess.EMPTY);
        if (mutableComponentFromJson == null) {
            return;
        }
        UUID uuidOrElse = optionalMatch.orElse(null);
        if (uuidOrElse == null) {
            C0562jt.log("[Cloud Notification] %s", mutableComponentFromJson.getString());
        } else {
            C0562jt.log("[Cloud Notification] For player/match '%s': %s", optionalMatch.get().toString(), mutableComponentFromJson.getString());
        }
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f3174du && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        Iterator it = abstractC0563juM168a.m2549b().m2375a(C0792oK.class).m2358d().values().iterator();
        while (it.hasNext()) {
            AbstractC0787oF<?, ?, ?> abstractC0787oFM3836a = ((C0792oK) it.next()).m3836a();
            if (abstractC0787oFM3836a != null) {
                Set<UUID> setM3809h = abstractC0787oFM3836a.m3582b().m3809h();
                if (uuidOrElse == null || abstractC0787oFM3836a.m3628e().equals(uuidOrElse) || setM3809h.contains(uuidOrElse)) {
                    C0799oR.m3983a(abstractC0787oFM3836a, f3173ia, (Component) mutableComponentFromJson);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2501a(@NotNull PacketProfanitySync packetProfanitySync, @NotNull Connection<?> connection) {
        List<Profanity> listProfanities = packetProfanitySync.profanities();
        C0562jt.log("Received %d profanity definitions from the cloud!", Integer.valueOf(listProfanities.size()));
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a instanceof C1300xw) {
            ((C1300xw) abstractC0563juM168a).m7951a().setProfanities(listProfanities);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2502a(@NotNull PacketFeatureFlags packetFeatureFlags, @NotNull Connection<?> connection) {
        Map<String, Boolean> mapFeatureFlags = packetFeatureFlags.featureFlags();
        C0562jt.log("Received %d feature flags from the cloud!", Integer.valueOf(mapFeatureFlags.size()));
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f3174du && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        abstractC0563juM168a.m2520b().m2145a().m2168a().setFeatureFlags(mapFeatureFlags);
    }
}
