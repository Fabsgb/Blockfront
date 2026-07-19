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
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMJoinServer;
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMMapRating;
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMMatchReport;
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMPlayerLeft;
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMPlayerSuspicious;
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMSchedulePlayer;
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMSearch;
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMSearchCloudCanceled;
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMSearchHostCanceled;
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
        registerPacket(ClientLoginPacket.ID, ClientLoginPacket.class);
        registerPacket(ClientHeartBeatPacket.ID, ClientHeartBeatPacket.class);
        registerPacket(ClientLogoutPacket.ID, ClientLogoutPacket.class);
        registerPacket(CloudHeartBeatPacket.ID, CloudHeartBeatPacket.class);
        registerPacket(CloudDisconnectedPacket.ID, CloudDisconnectedPacket.class);
        registerPacket(CloudConnectionStatusPacket.ID, CloudConnectionStatusPacket.class);
        registerPacket(EncryptionKeyExchangePacket.ID, EncryptionKeyExchangePacket.class);
        registerPacket(EncryptionReadyPacket.ID, EncryptionReadyPacket.class);
        registerPacketHandler(CloudDisconnectedPacket.class, CloudDisconnectedPacket::handle, Connection.class);
        registerPacketHandler(CloudConnectionStatusPacket.class, CloudConnectionStatusPacket::handle, Connection.class);
        registerPacketHandler(EncryptionReadyPacket.class, EncryptionReadyPacket::handle, Connection.class);
        registerPacket(PacketClientRequest.ID, PacketClientRequest.class);
        registerPacket(PacketClientUpdateStatus.ID, PacketClientUpdateStatus.class);
        registerPacket(PacketPunishPlayer.ID, PacketPunishPlayer.class);
        registerPacket(PacketNotificationFromCloud.ID, PacketNotificationFromCloud.class);
        registerPacket(PacketClientSound.ID, PacketClientSound.class);
        registerPacket(PacketTriggerNewRank.ID, PacketTriggerNewRank.class);
        registerPacket(PacketClientMessagePopup.ID, PacketClientMessagePopup.class);
        registerPacket(PacketDailyReward.ID, PacketDailyReward.class);
        registerPacket(PacketScreenshotRequest.ID, PacketScreenshotRequest.class);
        registerPacket(PacketScreenshotResponse.ID, PacketScreenshotResponse.class);
        registerPacket(PacketInventoryItemAdded.ID, PacketInventoryItemAdded.class);
        registerPacket(PacketInventoryItemDeleteRequest.ID, PacketInventoryItemDeleteRequest.class);
        registerPacket(PacketInventoryItemRemoved.ID, PacketInventoryItemRemoved.class);
        registerPacket(PacketInventorySetItemDefault.ID, PacketInventorySetItemDefault.class);
        registerPacket(PacketInventoryOpenCase.ID, PacketInventoryOpenCase.class);
        registerPacket(PacketInventoryCaseResults.ID, PacketInventoryCaseResults.class);
        registerPacket(PacketInventoryActivateItem.ID, PacketInventoryActivateItem.class);
        registerPacket(PacketInventoryItemStickerAdd.ID, PacketInventoryItemStickerAdd.class);
        registerPacket(PacketInventoryItemStickerRemove.ID, PacketInventoryItemStickerRemove.class);
        registerPacket(PacketInventoryItemShowcase.ID, PacketInventoryItemShowcase.class);
        registerPacket(PacketRequestedPlayerData.ID, PacketRequestedPlayerData.class);
        registerPacket(PacketRequestedPlayerDataSet.ID, PacketRequestedPlayerDataSet.class);
        registerPacket(PacketRequestedInventory.ID, PacketRequestedInventory.class);
        registerPacket(PacketRequestedInventoryMinimal.ID, PacketRequestedInventoryMinimal.class);
        registerPacket(PacketRequestedFriends.ID, PacketRequestedFriends.class);
        registerPacket(PacketRequestedCloudData.ID, PacketRequestedCloudData.class);
        registerPacket(PacketRequestedItemDefault.ID, PacketRequestedItemDefault.class);
        registerPacket(PacketRequestedItemShowcase.ID, PacketRequestedItemShowcase.class);
        registerPacket(PacketRequestedClanData.ID, PacketRequestedClanData.class);
        registerPacket(PacketRequestedChallenges.ID, PacketRequestedChallenges.class);
        registerPacket(PacketRequestedPlayerStatusSet.ID, PacketRequestedPlayerStatusSet.class);
        registerPacket(PacketRequestedRecentMatches.ID, PacketRequestedRecentMatches.class);
        registerPacket(PacketPartyCreate.ID, PacketPartyCreate.class);
        registerPacket(PacketPartyEditSettings.ID, PacketPartyEditSettings.class);
        registerPacket(PacketPartyLeave.ID, PacketPartyLeave.class);
        registerPacket(PacketPartyInvite.ID, PacketPartyInvite.class);
        registerPacket(PacketPartyJoin.ID, PacketPartyJoin.class);
        registerPacket(PacketPartyJoined.ID, PacketPartyJoined.class);
        registerPacket(PacketPartyKick.ID, PacketPartyKick.class);
        registerPacket(PacketFriendRequest.ID, PacketFriendRequest.class);
        registerPacket(PacketFriendRequestAccept.ID, PacketFriendRequestAccept.class);
        registerPacket(PacketFriendRemove.ID, PacketFriendRemove.class);
        registerPacket(PacketFriendJoinGame.ID, PacketFriendJoinGame.class);
        registerPacket(PacketFriendSpectateGame.ID, PacketFriendSpectateGame.class);
        registerPacket(PacketCheckPrestige.ID, PacketCheckPrestige.class);
        registerPacket(PacketSkipBootcamp.ID, PacketSkipBootcamp.class);
        registerPacket(PacketMMJoinServer.ID, PacketMMJoinServer.class);
        registerPacket(PacketMMSearch.ID, PacketMMSearch.class);
        registerPacket(PacketMMSearchCloudCanceled.ID, PacketMMSearchCloudCanceled.class);
        registerPacket(PacketMMSearchHostCanceled.ID, PacketMMSearchHostCanceled.class);
        registerPacket(PacketMMMatchReport.ID, PacketMMMatchReport.class);
        registerPacket(PacketMMSchedulePlayer.ID, PacketMMSchedulePlayer.class);
        registerPacket(PacketMMPlayerLeft.ID, PacketMMPlayerLeft.class);
        registerPacket(PacketMMPlayerSuspicious.ID, PacketMMPlayerSuspicious.class);
        registerPacket(PacketMMMapRating.ID, PacketMMMapRating.class);
        registerPacket(PacketDiscordLinkRequest.ID, PacketDiscordLinkRequest.class);
        registerPacket(PacketDiscordLinkResponse.ID, PacketDiscordLinkResponse.class);
        registerPacket(PacketDiscordUnlinkRequest.ID, PacketDiscordUnlinkRequest.class);
        registerPacket(PacketDiscordVCPlayers.ID, PacketDiscordVCPlayers.class);
        registerPacket(PacketPatreonLinkRequest.ID, PacketPatreonLinkRequest.class);
        registerPacket(PacketPatreonLinkResponse.ID, PacketPatreonLinkResponse.class);
        registerPacket(PacketPatreonUnlinkRequest.ID, PacketPatreonUnlinkRequest.class);
        registerPacket(PacketPlayerDataIncreaseValue.ID, PacketPlayerDataIncreaseValue.class);
        registerPacket(PacketPlayerRandomDrop.ID, PacketPlayerRandomDrop.class);
        registerPacket(PacketServerGameStatus.ID, PacketServerGameStatus.class);
        registerPacket(PacketServerNotification.ID, PacketServerNotification.class);
        registerPacket(PacketKickedPlayer.ID, PacketKickedPlayer.class);
        registerPacket(PacketPlayerDataSetValue.ID, PacketPlayerDataSetValue.class);
        registerPacket(PacketProfanity.ID, PacketProfanity.class);
        registerPacket(PacketChatMessageFromCloud.ID, PacketChatMessageFromCloud.class);
        registerPacket(PacketFeatureFlags.ID, PacketFeatureFlags.class);
        registerPacket(PacketProfanitySync.ID, PacketProfanitySync.class);
        registerPacket(PacketClanCreate.ID, PacketClanCreate.class);
        registerPacket(PacketClanDelete.ID, PacketClanDelete.class);
        registerPacket(PacketClanInvite.ID, PacketClanInvite.class);
        registerPacket(PacketClanResponse.ID, PacketClanResponse.class);
        registerPacket(PacketClanKick.ID, PacketClanKick.class);
        registerPacket(PacketClanLeave.ID, PacketClanLeave.class);
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
