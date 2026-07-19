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

/* JADX INFO: renamed from: com.boehmod.blockfront.jj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jj.class */
public class C0253jj {
    private static final Component ia;
    static final /* synthetic */ boolean du;

    static {
        du = !C0253jj.class.desiredAssertionStatus();
        ia = Component.literal(String.valueOf((char) 57362)).append(" ");
    }

    public static void ba() {
        C0263jt.log("[Cloud] Registering common cloud packet handlers...", new Object[0]);
        PacketRegistry.registerPacketHandler(PacketServerNotification.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedPlayerData.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedPlayerDataSet.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedInventory.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedInventoryMinimal.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedItemDefault.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedItemShowcase.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketRequestedPlayerStatusSet.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketFeatureFlags.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        PacketRegistry.registerPacketHandler(PacketProfanitySync.class, (v0, v1) -> {
            a(v0, v1);
        }, ModConnection.class);
        C0263jt.log("[Cloud] Finished registering common cloud packet handlers.", new Object[0]);
    }

    private static void a(@NotNull PacketRequestedPlayerData packetRequestedPlayerData, @NotNull Connection<?> connection) throws IOException {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a == null) {
            return;
        }
        com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
        ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer(packetRequestedPlayerData.data());
        try {
            cVarM531a.a(packetRequestedPlayerData.uuid()).read(packetRequestedPlayerData.context(), byteBufWrappedBuffer);
            byteBufWrappedBuffer.release();
        } catch (Throwable th) {
            byteBufWrappedBuffer.release();
            throw th;
        }
    }

    private static void a(@NotNull PacketRequestedPlayerDataSet packetRequestedPlayerDataSet, @NotNull Connection<?> connection) throws IOException {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a == null) {
            return;
        }
        com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
        for (Map.Entry<UUID, Pair<PlayerDataContext, byte[]>> entry : packetRequestedPlayerDataSet.dataSet().entrySet()) {
            UUID key = entry.getKey();
            Pair<PlayerDataContext, byte[]> value = entry.getValue();
            PlayerDataContext playerDataContext = (PlayerDataContext) value.left();
            ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer((byte[]) value.right());
            try {
                cVarM531a.a(key).read(playerDataContext, byteBufWrappedBuffer);
                abstractC0264juM166a.m529b().m484a().a(RequestType.PLAYER_DATA, key);
                byteBufWrappedBuffer.release();
            } catch (Throwable th) {
                byteBufWrappedBuffer.release();
                throw th;
            }
        }
    }

    private static void a(@NotNull PacketRequestedPlayerStatusSet packetRequestedPlayerStatusSet, @NotNull Connection<?> connection) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a == null) {
            return;
        }
        com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
        for (Map.Entry<UUID, PublicPlayerStatus> entry : packetRequestedPlayerStatusSet.statusSet().entrySet()) {
            cVarM531a.a(entry.getKey()).setStatus(entry.getValue());
        }
    }

    private static void a(@NotNull PacketRequestedInventory packetRequestedInventory, @NotNull Connection<?> connection) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a == null) {
            return;
        }
        abstractC0264juM166a.m531a().a(packetRequestedInventory.uuid()).getInventory().onReceiveSection(packetRequestedInventory.stacks(), packetRequestedInventory.section());
    }

    private static void a(@NotNull PacketRequestedItemDefault packetRequestedItemDefault, @NotNull Connection<?> connection) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a == null) {
            return;
        }
        abstractC0264juM166a.m531a().a(packetRequestedItemDefault.uuid()).getInventory().populateEquippedItems(abstractC0264juM166a.m537a(), packetRequestedItemDefault.itemStacks());
    }

    private static void a(@NotNull PacketRequestedItemShowcase packetRequestedItemShowcase, @NotNull Connection<?> connection) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a == null) {
            return;
        }
        abstractC0264juM166a.m531a().a(packetRequestedItemShowcase.uuid()).getInventory().populateShowcasedItems(packetRequestedItemShowcase.itemStacks());
    }

    private static void a(@NotNull PacketRequestedInventoryMinimal packetRequestedInventoryMinimal, @NotNull Connection<?> connection) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a == null) {
            return;
        }
        CloudRegistry cloudRegistryM537a = abstractC0264juM166a.m537a();
        iN inventory = abstractC0264juM166a.m531a().a(packetRequestedInventoryMinimal.uuid()).getInventory();
        inventory.onReceiveMinimalStacks(packetRequestedInventoryMinimal.stacks());
        inventory.populateShowcasedItems(packetRequestedInventoryMinimal.showcased());
        inventory.populateEquippedItems(cloudRegistryM537a, packetRequestedInventoryMinimal.equipped());
    }

    private static void a(@NotNull PacketServerNotification packetServerNotification, @NotNull Connection<?> connection) {
        Optional<UUID> optionalMatch = packetServerNotification.match();
        MutableComponent mutableComponentFromJson = Component.Serializer.fromJson(packetServerNotification.message(), RegistryAccess.EMPTY);
        if (mutableComponentFromJson == null) {
            return;
        }
        UUID uuidOrElse = optionalMatch.orElse(null);
        if (uuidOrElse == null) {
            C0263jt.log("[Cloud Notification] %s", mutableComponentFromJson.getString());
        } else {
            C0263jt.log("[Cloud Notification] For player/match '%s': %s", optionalMatch.get().toString(), mutableComponentFromJson.getString());
        }
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!du && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        Iterator it = abstractC0264juM166a.m536b().a(oK.class).d().values().iterator();
        while (it.hasNext()) {
            oF<?, ?, ?> oFVarA = ((oK) it.next()).a();
            if (oFVarA != null) {
                Set<UUID> setH = oFVarA.b().h();
                if (uuidOrElse == null || oFVarA.m757e().equals(uuidOrElse) || setH.contains(uuidOrElse)) {
                    oR.a(oFVarA, ia, (Component) mutableComponentFromJson);
                }
            }
        }
    }

    private static void a(@NotNull PacketProfanitySync packetProfanitySync, @NotNull Connection<?> connection) {
        List<Profanity> listProfanities = packetProfanitySync.profanities();
        C0263jt.log("Received %d profanity definitions from the cloud!", Integer.valueOf(listProfanities.size()));
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a instanceof xw) {
            ((xw) abstractC0264juM166a).m1709a().setProfanities(listProfanities);
        }
    }

    private static void a(@NotNull PacketFeatureFlags packetFeatureFlags, @NotNull Connection<?> connection) {
        Map<String, Boolean> mapFeatureFlags = packetFeatureFlags.featureFlags();
        C0263jt.log("Received %d feature flags from the cloud!", Integer.valueOf(mapFeatureFlags.size()));
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!du && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        abstractC0264juM166a.m529b().m484a().a().setFeatureFlags(mapFeatureFlags);
    }
}
