package com.boehmod.bflib.cloud.packet;

import com.boehmod.bflib.cloud.common.ConnectionType;
import com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData;
import com.boehmod.bflib.cloud.connection.Connection;
import com.boehmod.bflib.cloud.packet.common.PacketChatMessageFromCloud;
import com.boehmod.bflib.cloud.packet.common.PacketClientMessagePopup;
import com.boehmod.bflib.cloud.packet.common.PacketClientRequest;
import com.boehmod.bflib.cloud.packet.common.PacketClientSound;
import com.boehmod.bflib.cloud.packet.common.PacketClientUpdateStatus;
import com.boehmod.bflib.cloud.packet.common.PacketDailyReward;
import com.boehmod.bflib.cloud.packet.common.PacketFeatureFlags;
import com.boehmod.bflib.cloud.packet.common.PacketKickedPlayer;
import com.boehmod.bflib.cloud.packet.common.PacketNotificationFromCloud;
import com.boehmod.bflib.cloud.packet.common.PacketPlayerRandomDrop;
import com.boehmod.bflib.cloud.packet.common.PacketProfanity;
import com.boehmod.bflib.cloud.packet.common.PacketProfanitySync;
import com.boehmod.bflib.cloud.packet.common.PacketPunishPlayer;
import com.boehmod.bflib.cloud.packet.common.PacketScreenshotRequest;
import com.boehmod.bflib.cloud.packet.common.PacketScreenshotResponse;
import com.boehmod.bflib.cloud.packet.common.PacketTriggerNewRank;
import com.boehmod.bflib.cloud.packet.common.clan.PacketClanCreate;
import com.boehmod.bflib.cloud.packet.common.clan.PacketClanDelete;
import com.boehmod.bflib.cloud.packet.common.clan.PacketClanInvite;
import com.boehmod.bflib.cloud.packet.common.clan.PacketClanKick;
import com.boehmod.bflib.cloud.packet.common.clan.PacketClanLeave;
import com.boehmod.bflib.cloud.packet.common.clan.PacketClanResponse;
import com.boehmod.bflib.cloud.packet.common.discord.PacketDiscordLinkRequest;
import com.boehmod.bflib.cloud.packet.common.discord.PacketDiscordLinkResponse;
import com.boehmod.bflib.cloud.packet.common.discord.PacketDiscordUnlinkRequest;
import com.boehmod.bflib.cloud.packet.common.discord.PacketDiscordVCPlayers;
import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendJoinGame;
import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendRemove;
import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendRequest;
import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendRequestAccept;
import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendSpectateGame;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryActivateItem;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryCaseResults;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemAdded;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemDeleteRequest;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemRemoved;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemShowcase;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemStickerAdd;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemStickerRemove;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryOpenCase;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventorySetItemDefault;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMJoinServer;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMMapRating;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMMatchReport;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMPlayerLeft;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMPlayerSuspicious;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMSchedulePlayer;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMSearch;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMSearchCloudCanceled;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMSearchHostCanceled;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyCreate;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyEditSettings;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyInvite;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyJoin;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyJoined;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyKick;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyLeave;
import com.boehmod.bflib.cloud.packet.common.patreon.PacketPatreonLinkRequest;
import com.boehmod.bflib.cloud.packet.common.patreon.PacketPatreonLinkResponse;
import com.boehmod.bflib.cloud.packet.common.patreon.PacketPatreonUnlinkRequest;
import com.boehmod.bflib.cloud.packet.common.profile.PacketCheckPrestige;
import com.boehmod.bflib.cloud.packet.common.profile.PacketSkipBootcamp;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedChallenges;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedClanData;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedCloudData;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedFriends;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedInventory;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedInventoryMinimal;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedItemDefault;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedItemShowcase;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedPlayerData;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedPlayerDataSet;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedPlayerStatusSet;
import com.boehmod.bflib.cloud.packet.common.requests.PacketRequestedRecentMatches;
import com.boehmod.bflib.cloud.packet.common.server.PacketPlayerDataIncreaseValue;
import com.boehmod.bflib.cloud.packet.common.server.PacketPlayerDataSetValue;
import com.boehmod.bflib.cloud.packet.common.server.PacketServerGameStatus;
import com.boehmod.bflib.cloud.packet.common.server.PacketServerNotification;
import com.boehmod.bflib.cloud.packet.primitives.ClientHeartBeatPacket;
import com.boehmod.bflib.cloud.packet.primitives.ClientLoginPacket;
import com.boehmod.bflib.cloud.packet.primitives.ClientLogoutPacket;
import com.boehmod.bflib.cloud.packet.primitives.CloudConnectionStatusPacket;
import com.boehmod.bflib.cloud.packet.primitives.CloudDisconnectedPacket;
import com.boehmod.bflib.cloud.packet.primitives.CloudHeartBeatPacket;
import com.boehmod.bflib.cloud.packet.primitives.EncryptionKeyExchangePacket;
import com.boehmod.bflib.cloud.packet.primitives.EncryptionReadyPacket;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/PacketRegistry.class */
public final class PacketRegistry {
    private static boolean logErrors = true;

    @NotNull
    private static final Logger LOGGER = LogManager.getLogger("Packet");

    @NotNull
    public static final UUID EMPTY_UUID = new UUID(0, 0);

    @NotNull
    private static final Int2ObjectOpenHashMap<Function<ByteBuf, IPacket>> PACKET_FACTORIES = new Int2ObjectOpenHashMap<>();

    @NotNull
    private static final Map<Class<? extends IPacket>, PacketIdentifier> PACKET_CLASS_TO_IDENTIFIER_MAP = new Object2ObjectOpenHashMap();

    @NotNull
    private static final Map<Class<? extends IPacket>, PacketHandler<?, ?>> PACKET_HANDLER_MAP = new Object2ObjectOpenHashMap();

    static {
        registerPacket(ClientLoginPacket.f101ID, ClientLoginPacket.class);
        registerPacket(ClientHeartBeatPacket.f100ID, ClientHeartBeatPacket.class);
        registerPacket(ClientLogoutPacket.f102ID, ClientLogoutPacket.class);
        registerPacket(CloudHeartBeatPacket.f105ID, CloudHeartBeatPacket.class);
        registerPacket(CloudDisconnectedPacket.f104ID, CloudDisconnectedPacket.class);
        registerPacket(CloudConnectionStatusPacket.f103ID, CloudConnectionStatusPacket.class);
        registerPacket(EncryptionKeyExchangePacket.f106ID, EncryptionKeyExchangePacket.class);
        registerPacket(EncryptionReadyPacket.f107ID, EncryptionReadyPacket.class);
        registerPacketHandler(CloudDisconnectedPacket.class, CloudDisconnectedPacket::handle, Connection.class);
        registerPacketHandler(CloudConnectionStatusPacket.class, CloudConnectionStatusPacket::handle, Connection.class);
        registerPacketHandler(EncryptionReadyPacket.class, EncryptionReadyPacket::handle, Connection.class);
        registerPacket(PacketClientRequest.f24ID, PacketClientRequest.class);
        registerPacket(PacketClientUpdateStatus.f26ID, PacketClientUpdateStatus.class);
        registerPacket(PacketPunishPlayer.f34ID, PacketPunishPlayer.class);
        registerPacket(PacketNotificationFromCloud.f30ID, PacketNotificationFromCloud.class);
        registerPacket(PacketClientSound.f25ID, PacketClientSound.class);
        registerPacket(PacketTriggerNewRank.f37ID, PacketTriggerNewRank.class);
        registerPacket(PacketClientMessagePopup.f23ID, PacketClientMessagePopup.class);
        registerPacket(PacketDailyReward.f27ID, PacketDailyReward.class);
        registerPacket(PacketScreenshotRequest.f35ID, PacketScreenshotRequest.class);
        registerPacket(PacketScreenshotResponse.f36ID, PacketScreenshotResponse.class);
        registerPacket(PacketInventoryItemAdded.f55ID, PacketInventoryItemAdded.class);
        registerPacket(PacketInventoryItemDeleteRequest.f56ID, PacketInventoryItemDeleteRequest.class);
        registerPacket(PacketInventoryItemRemoved.f57ID, PacketInventoryItemRemoved.class);
        registerPacket(PacketInventorySetItemDefault.f62ID, PacketInventorySetItemDefault.class);
        registerPacket(PacketInventoryOpenCase.f61ID, PacketInventoryOpenCase.class);
        registerPacket(PacketInventoryCaseResults.f54ID, PacketInventoryCaseResults.class);
        registerPacket(PacketInventoryActivateItem.f53ID, PacketInventoryActivateItem.class);
        registerPacket(PacketInventoryItemStickerAdd.f59ID, PacketInventoryItemStickerAdd.class);
        registerPacket(PacketInventoryItemStickerRemove.f60ID, PacketInventoryItemStickerRemove.class);
        registerPacket(PacketInventoryItemShowcase.f58ID, PacketInventoryItemShowcase.class);
        registerPacket(PacketRequestedPlayerData.f92ID, PacketRequestedPlayerData.class);
        registerPacket(PacketRequestedPlayerDataSet.f93ID, PacketRequestedPlayerDataSet.class);
        registerPacket(PacketRequestedInventory.f88ID, PacketRequestedInventory.class);
        registerPacket(PacketRequestedInventoryMinimal.f89ID, PacketRequestedInventoryMinimal.class);
        registerPacket(PacketRequestedFriends.f87ID, PacketRequestedFriends.class);
        registerPacket(PacketRequestedCloudData.f86ID, PacketRequestedCloudData.class);
        registerPacket(PacketRequestedItemDefault.f90ID, PacketRequestedItemDefault.class);
        registerPacket(PacketRequestedItemShowcase.f91ID, PacketRequestedItemShowcase.class);
        registerPacket(PacketRequestedClanData.f85ID, PacketRequestedClanData.class);
        registerPacket(PacketRequestedChallenges.f84ID, PacketRequestedChallenges.class);
        registerPacket(PacketRequestedPlayerStatusSet.f94ID, PacketRequestedPlayerStatusSet.class);
        registerPacket(PacketRequestedRecentMatches.f95ID, PacketRequestedRecentMatches.class);
        registerPacket(PacketPartyCreate.f72ID, PacketPartyCreate.class);
        registerPacket(PacketPartyEditSettings.f73ID, PacketPartyEditSettings.class);
        registerPacket(PacketPartyLeave.f78ID, PacketPartyLeave.class);
        registerPacket(PacketPartyInvite.f74ID, PacketPartyInvite.class);
        registerPacket(PacketPartyJoin.f75ID, PacketPartyJoin.class);
        registerPacket(PacketPartyJoined.f76ID, PacketPartyJoined.class);
        registerPacket(PacketPartyKick.f77ID, PacketPartyKick.class);
        registerPacket(PacketFriendRequest.f50ID, PacketFriendRequest.class);
        registerPacket(PacketFriendRequestAccept.f51ID, PacketFriendRequestAccept.class);
        registerPacket(PacketFriendRemove.f49ID, PacketFriendRemove.class);
        registerPacket(PacketFriendJoinGame.f48ID, PacketFriendJoinGame.class);
        registerPacket(PacketFriendSpectateGame.f52ID, PacketFriendSpectateGame.class);
        registerPacket(PacketCheckPrestige.f82ID, PacketCheckPrestige.class);
        registerPacket(PacketSkipBootcamp.f83ID, PacketSkipBootcamp.class);
        registerPacket(PacketMMJoinServer.f63ID, PacketMMJoinServer.class);
        registerPacket(PacketMMSearch.f69ID, PacketMMSearch.class);
        registerPacket(PacketMMSearchCloudCanceled.f70ID, PacketMMSearchCloudCanceled.class);
        registerPacket(PacketMMSearchHostCanceled.f71ID, PacketMMSearchHostCanceled.class);
        registerPacket(PacketMMMatchReport.f65ID, PacketMMMatchReport.class);
        registerPacket(PacketMMSchedulePlayer.f68ID, PacketMMSchedulePlayer.class);
        registerPacket(PacketMMPlayerLeft.f66ID, PacketMMPlayerLeft.class);
        registerPacket(PacketMMPlayerSuspicious.f67ID, PacketMMPlayerSuspicious.class);
        registerPacket(PacketMMMapRating.f64ID, PacketMMMapRating.class);
        registerPacket(PacketDiscordLinkRequest.f44ID, PacketDiscordLinkRequest.class);
        registerPacket(PacketDiscordLinkResponse.f45ID, PacketDiscordLinkResponse.class);
        registerPacket(PacketDiscordUnlinkRequest.f46ID, PacketDiscordUnlinkRequest.class);
        registerPacket(PacketDiscordVCPlayers.f47ID, PacketDiscordVCPlayers.class);
        registerPacket(PacketPatreonLinkRequest.f79ID, PacketPatreonLinkRequest.class);
        registerPacket(PacketPatreonLinkResponse.f80ID, PacketPatreonLinkResponse.class);
        registerPacket(PacketPatreonUnlinkRequest.f81ID, PacketPatreonUnlinkRequest.class);
        registerPacket(PacketPlayerDataIncreaseValue.f96ID, PacketPlayerDataIncreaseValue.class);
        registerPacket(PacketPlayerRandomDrop.f31ID, PacketPlayerRandomDrop.class);
        registerPacket(PacketServerGameStatus.f98ID, PacketServerGameStatus.class);
        registerPacket(PacketServerNotification.f99ID, PacketServerNotification.class);
        registerPacket(PacketKickedPlayer.f29ID, PacketKickedPlayer.class);
        registerPacket(PacketPlayerDataSetValue.f97ID, PacketPlayerDataSetValue.class);
        registerPacket(PacketProfanity.f32ID, PacketProfanity.class);
        registerPacket(PacketChatMessageFromCloud.f22ID, PacketChatMessageFromCloud.class);
        registerPacket(PacketFeatureFlags.f28ID, PacketFeatureFlags.class);
        registerPacket(PacketProfanitySync.f33ID, PacketProfanitySync.class);
        registerPacket(PacketClanCreate.f38ID, PacketClanCreate.class);
        registerPacket(PacketClanDelete.f39ID, PacketClanDelete.class);
        registerPacket(PacketClanInvite.f40ID, PacketClanInvite.class);
        registerPacket(PacketClanResponse.f43ID, PacketClanResponse.class);
        registerPacket(PacketClanKick.f41ID, PacketClanKick.class);
        registerPacket(PacketClanLeave.f42ID, PacketClanLeave.class);
    }

    public static void setLogErrors(boolean value) {
        logErrors = value;
    }

    public static void registerPacket(@NotNull PacketIdentifier identifier, @NotNull Class<? extends IPacket> packetClass) {
        Class<? extends IPacket> existing;
        int hash = identifier.hash();
        if (PACKET_FACTORIES.containsKey(hash) && (existing = (Class) PACKET_CLASS_TO_IDENTIFIER_MAP.entrySet().stream().filter(entry -> {
            return ((PacketIdentifier) entry.getValue()).hash() == hash;
        }).map((v0) -> {
            return v0.getKey();
        }).findFirst().orElse(null)) != null && !existing.equals(packetClass)) {
            LOGGER.error("[Packet] Collision detected! Hash '{}' is already assigned to '{}' and cannot be reassigned to '{}'.", Integer.valueOf(hash), existing.getName(), packetClass.getName());
            throw new IllegalStateException("Hash collision detected for packet identifier: " + String.valueOf(identifier));
        }
        LOGGER.info("[Packet] Registering packet mapping for '{}' with Hash '{}'", packetClass.getName(), Integer.valueOf(hash));
        try {
            Constructor<? extends IPacket> constructor = packetClass.getConstructor(ByteBuf.class);
            PACKET_FACTORIES.put(hash, byteBuf -> {
                try {
                    return (IPacket) constructor.newInstance(byteBuf);
                } catch (Exception e) {
                    if (logErrors) {
                        LOGGER.error("Failed to instantiate packet for class: {}", packetClass.getName(), e);
                        return null;
                    }
                    return null;
                }
            });
            PACKET_CLASS_TO_IDENTIFIER_MAP.put(packetClass, identifier);
        } catch (NoSuchMethodException e) {
            LOGGER.error("[Packet] Failed to find ByteBuf constructor for class: {}", packetClass.getName(), e);
            throw new IllegalArgumentException("Packet class must have a constructor accepting ByteBuf", e);
        }
    }

    public static <P extends IPacket, H extends Connection<? extends AbstractPlayerCloudData<?, ?>>> void registerPacketHandler(@NotNull Class<P> packetClass, @NotNull IPacketHandlerFunction<P, H> handler, @NotNull Class<H> handlerType) {
        registerPacketHandler(packetClass, null, handler, handlerType);
    }

    public static <P extends IPacket, H extends Connection<?>> void registerPacketHandler(@NotNull Class<P> packetClass, @Nullable ConnectionType connectionType, @NotNull IPacketHandlerFunction<P, H> handler, @NotNull Class<H> handlerType) {
        PACKET_HANDLER_MAP.put(packetClass, new PacketHandler<>(connectionType, handler, handlerType));
    }

    public static void processPacket(@NotNull IPacket packet, @NotNull ConnectionType connectionType, @NotNull Connection<?> connectionHandler) throws IOException {
        Class<?> cls = packet.getClass();
        PacketHandler<?, ?> packetHandler = PACKET_HANDLER_MAP.get(cls);
        if (packetHandler == null) {
            return;
        }
        ConnectionType packetHandlerConnectionType = packetHandler.connectionType();
        if (packetHandlerConnectionType != null && packetHandlerConnectionType != connectionType) {
            connectionHandler.onIllegalPacket(packet, connectionType, packetHandlerConnectionType);
            connectionHandler.disconnect("Illegal packet " + cls.getSimpleName() + " sent on channel " + String.valueOf(connectionType), true);
        } else if (!packetHandler.handlerType().isInstance(connectionHandler)) {
            connectionHandler.disconnect("Illegal connection handler type for packet", true);
        } else {
            packetHandler.function().handle(packet, connectionHandler);
        }
    }

    public static boolean isKnownHash(int hash) {
        return PACKET_FACTORIES.containsKey(hash);
    }

    @Nullable
    public static IPacket readPacket(@NotNull ByteBuf byteBuf) {
        try {
            int packetHash = byteBuf.readInt();
            Function<ByteBuf, IPacket> factory = (Function) PACKET_FACTORIES.get(packetHash);
            if (factory == null) {
                if (logErrors) {
                    LOGGER.error("Failed to find packet factory for hash: {}", Integer.valueOf(packetHash));
                    return null;
                }
                return null;
            }
            return factory.apply(byteBuf);
        } catch (Exception e) {
            if (logErrors) {
                LOGGER.error("Failed to read packet data from ByteBuf.", e);
                return null;
            }
            return null;
        }
    }

    public static void writePacket(@NotNull IPacket packet, @NotNull ByteBuf byteBuf) throws Exception {
        PacketIdentifier identifier = packet.getPacketIdentifier();
        try {
            byteBuf.writeInt(identifier.hash());
            packet.writePacketToBuffer(byteBuf);
        } catch (Exception e) {
            PacketIdentifier pid = PACKET_CLASS_TO_IDENTIFIER_MAP.get(packet.getClass());
            String identifierInfo = pid != null ? pid.toString() : "Unknown identifier";
            LOGGER.error("Failed to write packet {} (Hash: {})", identifierInfo, Integer.valueOf(identifier.hash()), e);
            throw e;
        }
    }
}
