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
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.jC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jC.class */
public class C0520jC {

    /* JADX INFO: renamed from: il */
    private static final Component f3156il;

    /* JADX INFO: renamed from: dF */
    static final /* synthetic */ boolean f3157dF;

    static {
        f3157dF = !C0520jC.class.desiredAssertionStatus();
        f3156il = Component.literal(String.valueOf((char) 57362)).append(" ");
    }

    /* JADX INFO: renamed from: bm */
    public static void m2312bm() {
        C0530jM.log("[Cloud] Registering common cloud packet handlers...", new Object[0]);
        PacketRegistry.registerPacketHandler(PacketServerNotification.class, (v0, v1) -> {
            m2320a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedPlayerData.class, (v0, v1) -> {
            m2313a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedPlayerDataSet.class, (v0, v1) -> {
            m2314a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedInventory.class, (v0, v1) -> {
            m2316a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedInventoryMinimal.class, (v0, v1) -> {
            m2319a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedItemDefault.class, (v0, v1) -> {
            m2317a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedItemShowcase.class, (v0, v1) -> {
            m2318a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedPlayerStatusSet.class, (v0, v1) -> {
            m2315a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketFeatureFlags.class, (v0, v1) -> {
            m2322a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketProfanitySync.class, (v0, v1) -> {
            m2321a(v0, v1);
        }, ModConnection.class);
        C0530jM.log("[Cloud] Finished registering common cloud packet handlers.", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    private static void m2313a(@NotNull PacketRequestedPlayerData packetRequestedPlayerData, @NotNull Connection<?> connection) throws IOException {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a == null) {
            return;
        }
        AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
        ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer(packetRequestedPlayerData.data());
        try {
            abstractC0184cM2351a.m1149a(packetRequestedPlayerData.uuid()).read(packetRequestedPlayerData.context(), byteBufWrappedBuffer);
        } finally {
            byteBufWrappedBuffer.release();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2314a(@NotNull PacketRequestedPlayerDataSet packetRequestedPlayerDataSet, @NotNull Connection<?> connection) throws IOException {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a == null) {
            return;
        }
        AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
        for (Map.Entry<UUID, Pair<PlayerDataContext, byte[]>> entry : packetRequestedPlayerDataSet.dataSet().entrySet()) {
            UUID key = entry.getKey();
            Pair<PlayerDataContext, byte[]> value = entry.getValue();
            PlayerDataContext playerDataContext = (PlayerDataContext) value.left();
            ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer((byte[]) value.right());
            try {
                abstractC0184cM2351a.m1149a(key).read(playerDataContext, byteBufWrappedBuffer);
                abstractC0531jNM179a.m2342b().m2472a().m2490a(RequestType.PLAYER_DATA, key);
                byteBufWrappedBuffer.release();
            } catch (Throwable th) {
                byteBufWrappedBuffer.release();
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2315a(@NotNull PacketRequestedPlayerStatusSet packetRequestedPlayerStatusSet, @NotNull Connection<?> connection) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a == null) {
            return;
        }
        AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
        for (Map.Entry<UUID, PublicPlayerStatus> entry : packetRequestedPlayerStatusSet.statusSet().entrySet()) {
            abstractC0184cM2351a.m1149a(entry.getKey()).setStatus(entry.getValue());
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2316a(@NotNull PacketRequestedInventory packetRequestedInventory, @NotNull Connection<?> connection) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a == null) {
            return;
        }
        abstractC0531jNM179a.m2351a().m1149a(packetRequestedInventory.uuid()).getInventory().onReceiveSection(packetRequestedInventory.stacks(), packetRequestedInventory.section());
    }

    /* JADX INFO: renamed from: a */
    private static void m2317a(@NotNull PacketRequestedItemDefault packetRequestedItemDefault, @NotNull Connection<?> connection) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a == null) {
            return;
        }
        abstractC0531jNM179a.m2351a().m1149a(packetRequestedItemDefault.uuid()).getInventory().populateEquippedItems(abstractC0531jNM179a.m2373a(), packetRequestedItemDefault.itemStacks());
    }

    /* JADX INFO: renamed from: a */
    private static void m2318a(@NotNull PacketRequestedItemShowcase packetRequestedItemShowcase, @NotNull Connection<?> connection) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a == null) {
            return;
        }
        abstractC0531jNM179a.m2351a().m1149a(packetRequestedItemShowcase.uuid()).getInventory().populateShowcasedItems(packetRequestedItemShowcase.itemStacks());
    }

    /* JADX INFO: renamed from: a */
    private static void m2319a(@NotNull PacketRequestedInventoryMinimal packetRequestedInventoryMinimal, @NotNull Connection<?> connection) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a == null) {
            return;
        }
        CloudRegistry cloudRegistryM2373a = abstractC0531jNM179a.m2373a();
        C0550jg inventory = abstractC0531jNM179a.m2351a().m1149a(packetRequestedInventoryMinimal.uuid()).getInventory();
        inventory.onReceiveMinimalStacks(packetRequestedInventoryMinimal.stacks());
        inventory.populateShowcasedItems(packetRequestedInventoryMinimal.showcased());
        inventory.populateEquippedItems(cloudRegistryM2373a, packetRequestedInventoryMinimal.equipped());
    }

    /* JADX INFO: renamed from: a */
    private static void m2320a(@NotNull PacketServerNotification packetServerNotification, @NotNull Connection<?> connection) {
        Optional<UUID> optionalMatch = packetServerNotification.match();
        MutableComponent mutableComponentFromJson = Component.Serializer.fromJson(packetServerNotification.message(), RegistryAccess.EMPTY);
        if (mutableComponentFromJson == null) {
            return;
        }
        UUID uuidOrElse = optionalMatch.orElse(null);
        if (uuidOrElse == null) {
            C0530jM.log("[Cloud Notification] %s", mutableComponentFromJson.getString());
        } else {
            C0530jM.log("[Cloud Notification] For player/match '%s': %s", optionalMatch.get().toString(), mutableComponentFromJson.getString());
        }
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f3157dF && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        Iterator it = abstractC0531jNM179a.m2372b().m2737a(C0868pg.class).m2720d().values().iterator();
        while (it.hasNext()) {
            AbstractC0863pb<?, ?, ?> abstractC0863pbM4272a = ((C0868pg) it.next()).m4272a();
            if (abstractC0863pbM4272a != null) {
                Set<UUID> setM4245h = abstractC0863pbM4272a.m4018b().m4245h();
                if (uuidOrElse == null || abstractC0863pbM4272a.m4064e().equals(uuidOrElse) || setM4245h.contains(uuidOrElse)) {
                    C0875pn.m4419a(abstractC0863pbM4272a, f3156il, (Component) mutableComponentFromJson);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2321a(@NotNull PacketProfanitySync packetProfanitySync, @NotNull Connection<?> connection) {
        List<Profanity> listProfanities = packetProfanitySync.profanities();
        C0530jM.log("Received %d profanity definitions from the cloud!", Integer.valueOf(listProfanities.size()));
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a instanceof C1280xT) {
            ((C1280xT) abstractC0531jNM179a).m7278a().setProfanities(listProfanities);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2322a(@NotNull PacketFeatureFlags packetFeatureFlags, @NotNull Connection<?> connection) {
        Map<String, Boolean> mapFeatureFlags = packetFeatureFlags.featureFlags();
        C0530jM.log("Received %d feature flags from the cloud!", Integer.valueOf(mapFeatureFlags.size()));
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f3157dF && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        abstractC0531jNM179a.m2342b().m2472a().m2495a().setFeatureFlags(mapFeatureFlags);
    }
}
