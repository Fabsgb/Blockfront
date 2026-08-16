package com.boehmod.bflib.cloud.packet;

import com.boehmod.bflib.cloud.common.ConnectionType;
import com.boehmod.bflib.cloud.common.player.AbstractPlayerCloudData;
import com.boehmod.bflib.cloud.connection.Connection;
import com.boehmod.bflib.cloud.packet.common.PacketChatMessageFromCloud;
import com.boehmod.bflib.cloud.packet.common.PacketClientMessagePopup;
import com.boehmod.bflib.cloud.packet.common.PacketClientRequest;
import com.boehmod.bflib.cloud.packet.common.PacketClientSound;
import com.boehmod.bflib.cloud.packet.common.PacketClientState;
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
import com.boehmod.bflib.cloud.packet.common.news.PacketNewsArticleRequest;
import com.boehmod.bflib.cloud.packet.common.news.PacketNewsArticleResponse;
import com.boehmod.bflib.cloud.packet.common.news.PacketNewsImageRequest;
import com.boehmod.bflib.cloud.packet.common.news.PacketNewsImageResponse;
import com.boehmod.bflib.cloud.packet.common.news.PacketNewsListRequest;
import com.boehmod.bflib.cloud.packet.common.news.PacketNewsListResponse;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMChatReport;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMJoinServer;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMMapRating;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMMatchReport;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMPlayerAimVerdict;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMPlayerLeft;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMPlayerSuspicious;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMSchedulePlayer;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMSearch;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMSearchCloudCanceled;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMSearchHostCanceled;
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
import com.boehmod.bflib.cloud.packet.common.server.PacketPlayerDataIncreaseValueBatch;
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
import java.util.Map;
import java.util.UUID;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/PacketRegistry.class */
public final class PacketRegistry {
    private static boolean logErrors = true;

    @NotNull
    private static final Logger LOGGER = LogManager.getLogger("Packet");

    @NotNull
    public static final UUID EMPTY_UUID = new UUID(0, 0);

    @NotNull
    private static final Int2ObjectOpenHashMap<PacketFactory<?>> PACKET_FACTORIES = new Int2ObjectOpenHashMap<>();

    @NotNull
    private static final Map<Class<? extends IPacket>, PacketIdentifier> PACKET_CLASS_TO_IDENTIFIER_MAP = new Object2ObjectOpenHashMap();

    @NotNull
    private static final Map<Class<? extends IPacket>, PacketHandler<?, ?>> PACKET_HANDLER_MAP = new Object2ObjectOpenHashMap();

    static {
        registerPacket(ClientLoginPacket.f116ID, ClientLoginPacket.class, ClientLoginPacket::new);
        registerPacket(ClientHeartBeatPacket.f115ID, ClientHeartBeatPacket.class, ClientHeartBeatPacket::new);
        registerPacket(ClientLogoutPacket.f117ID, ClientLogoutPacket.class, ClientLogoutPacket::new);
        registerPacket(CloudHeartBeatPacket.f120ID, CloudHeartBeatPacket.class, CloudHeartBeatPacket::new);
        registerPacket(CloudDisconnectedPacket.f119ID, CloudDisconnectedPacket.class, CloudDisconnectedPacket::new);
        registerPacket(CloudConnectionStatusPacket.f118ID, CloudConnectionStatusPacket.class, CloudConnectionStatusPacket::new);
        registerPacket(EncryptionKeyExchangePacket.f121ID, EncryptionKeyExchangePacket.class, EncryptionKeyExchangePacket::new);
        registerPacket(EncryptionReadyPacket.f122ID, EncryptionReadyPacket.class, EncryptionReadyPacket::new);
        registerPacketHandler(CloudDisconnectedPacket.class, CloudDisconnectedPacket::handle, Connection.class);
        registerPacketHandler(CloudConnectionStatusPacket.class, CloudConnectionStatusPacket::handle, Connection.class);
        registerPacketHandler(EncryptionReadyPacket.class, EncryptionReadyPacket::handle, Connection.class);
        registerPacket(PacketClientRequest.f25ID, PacketClientRequest.class, PacketClientRequest::new);
        registerPacket(PacketClientUpdateStatus.f28ID, PacketClientUpdateStatus.class, PacketClientUpdateStatus::new);
        registerPacket(PacketPunishPlayer.f36ID, PacketPunishPlayer.class, PacketPunishPlayer::new);
        registerPacket(PacketNotificationFromCloud.f32ID, PacketNotificationFromCloud.class, PacketNotificationFromCloud::new);
        registerPacket(PacketClientSound.f26ID, PacketClientSound.class, PacketClientSound::new);
        registerPacket(PacketTriggerNewRank.f39ID, PacketTriggerNewRank.class, PacketTriggerNewRank::new);
        registerPacket(PacketClientMessagePopup.f24ID, PacketClientMessagePopup.class, PacketClientMessagePopup::new);
        registerPacket(PacketDailyReward.f29ID, PacketDailyReward.class, PacketDailyReward::new);
        registerPacket(PacketScreenshotRequest.f37ID, PacketScreenshotRequest.class, PacketScreenshotRequest::new);
        registerPacket(PacketScreenshotResponse.f38ID, PacketScreenshotResponse.class, PacketScreenshotResponse::new);
        registerPacket(PacketClientState.f27ID, PacketClientState.class, PacketClientState::new);
        registerPacket(PacketInventoryItemAdded.f57ID, PacketInventoryItemAdded.class, PacketInventoryItemAdded::new);
        registerPacket(PacketInventoryItemDeleteRequest.f58ID, PacketInventoryItemDeleteRequest.class, PacketInventoryItemDeleteRequest::new);
        registerPacket(PacketInventoryItemRemoved.f59ID, PacketInventoryItemRemoved.class, PacketInventoryItemRemoved::new);
        registerPacket(PacketInventorySetItemDefault.f64ID, PacketInventorySetItemDefault.class, PacketInventorySetItemDefault::new);
        registerPacket(PacketInventoryOpenCase.f63ID, PacketInventoryOpenCase.class, PacketInventoryOpenCase::new);
        registerPacket(PacketInventoryCaseResults.f56ID, PacketInventoryCaseResults.class, PacketInventoryCaseResults::new);
        registerPacket(PacketInventoryActivateItem.f55ID, PacketInventoryActivateItem.class, PacketInventoryActivateItem::new);
        registerPacket(PacketInventoryItemStickerAdd.f61ID, PacketInventoryItemStickerAdd.class, PacketInventoryItemStickerAdd::new);
        registerPacket(PacketInventoryItemStickerRemove.f62ID, PacketInventoryItemStickerRemove.class, PacketInventoryItemStickerRemove::new);
        registerPacket(PacketInventoryItemShowcase.f60ID, PacketInventoryItemShowcase.class, PacketInventoryItemShowcase::new);
        registerPacket(PacketRequestedPlayerData.f106ID, PacketRequestedPlayerData.class, PacketRequestedPlayerData::new);
        registerPacket(PacketRequestedPlayerDataSet.f107ID, PacketRequestedPlayerDataSet.class, PacketRequestedPlayerDataSet::new);
        registerPacket(PacketRequestedInventory.f102ID, PacketRequestedInventory.class, PacketRequestedInventory::new);
        registerPacket(PacketRequestedInventoryMinimal.f103ID, PacketRequestedInventoryMinimal.class, PacketRequestedInventoryMinimal::new);
        registerPacket(PacketRequestedFriends.f101ID, PacketRequestedFriends.class, PacketRequestedFriends::new);
        registerPacket(PacketRequestedCloudData.f100ID, PacketRequestedCloudData.class, PacketRequestedCloudData::new);
        registerPacket(PacketRequestedItemDefault.f104ID, PacketRequestedItemDefault.class, PacketRequestedItemDefault::new);
        registerPacket(PacketRequestedItemShowcase.f105ID, PacketRequestedItemShowcase.class, PacketRequestedItemShowcase::new);
        registerPacket(PacketRequestedClanData.f99ID, PacketRequestedClanData.class, PacketRequestedClanData::new);
        registerPacket(PacketRequestedChallenges.f98ID, PacketRequestedChallenges.class, PacketRequestedChallenges::new);
        registerPacket(PacketRequestedPlayerStatusSet.f108ID, PacketRequestedPlayerStatusSet.class, PacketRequestedPlayerStatusSet::new);
        registerPacket(PacketRequestedRecentMatches.f109ID, PacketRequestedRecentMatches.class, PacketRequestedRecentMatches::new);
        registerPacket(PacketPartyCreate.f86ID, PacketPartyCreate.class, PacketPartyCreate::new);
        registerPacket(PacketPartyEditSettings.f87ID, PacketPartyEditSettings.class, PacketPartyEditSettings::new);
        registerPacket(PacketPartyLeave.f92ID, PacketPartyLeave.class, PacketPartyLeave::new);
        registerPacket(PacketPartyInvite.f88ID, PacketPartyInvite.class, PacketPartyInvite::new);
        registerPacket(PacketPartyJoin.f89ID, PacketPartyJoin.class, PacketPartyJoin::new);
        registerPacket(PacketPartyJoined.f90ID, PacketPartyJoined.class, PacketPartyJoined::new);
        registerPacket(PacketPartyKick.f91ID, PacketPartyKick.class, PacketPartyKick::new);
        registerPacket(PacketFriendRequest.f52ID, PacketFriendRequest.class, PacketFriendRequest::new);
        registerPacket(PacketFriendRequestAccept.f53ID, PacketFriendRequestAccept.class, PacketFriendRequestAccept::new);
        registerPacket(PacketFriendRemove.f51ID, PacketFriendRemove.class, PacketFriendRemove::new);
        registerPacket(PacketFriendJoinGame.f50ID, PacketFriendJoinGame.class, PacketFriendJoinGame::new);
        registerPacket(PacketFriendSpectateGame.f54ID, PacketFriendSpectateGame.class, PacketFriendSpectateGame::new);
        registerPacket(PacketCheckPrestige.f96ID, PacketCheckPrestige.class, PacketCheckPrestige::new);
        registerPacket(PacketSkipBootcamp.f97ID, PacketSkipBootcamp.class, PacketSkipBootcamp::new);
        registerPacket(PacketMMJoinServer.f66ID, PacketMMJoinServer.class, PacketMMJoinServer::new);
        registerPacket(PacketMMSearch.f73ID, PacketMMSearch.class, PacketMMSearch::new);
        registerPacket(PacketMMSearchCloudCanceled.f74ID, PacketMMSearchCloudCanceled.class, PacketMMSearchCloudCanceled::new);
        registerPacket(PacketMMSearchHostCanceled.f75ID, PacketMMSearchHostCanceled.class, PacketMMSearchHostCanceled::new);
        registerPacket(PacketMMMatchReport.f68ID, PacketMMMatchReport.class, PacketMMMatchReport::new);
        registerPacket(PacketMMSchedulePlayer.f72ID, PacketMMSchedulePlayer.class, PacketMMSchedulePlayer::new);
        registerPacket(PacketMMPlayerLeft.f70ID, PacketMMPlayerLeft.class, PacketMMPlayerLeft::new);
        registerPacket(PacketMMPlayerSuspicious.f71ID, PacketMMPlayerSuspicious.class, PacketMMPlayerSuspicious::new);
        registerPacket(PacketMMPlayerAimVerdict.f69ID, PacketMMPlayerAimVerdict.class, PacketMMPlayerAimVerdict::new);
        registerPacket(PacketMMMapRating.f67ID, PacketMMMapRating.class, PacketMMMapRating::new);
        registerPacket(PacketMMChatReport.f65ID, PacketMMChatReport.class, PacketMMChatReport::new);
        registerPacket(PacketDiscordLinkRequest.f46ID, PacketDiscordLinkRequest.class, PacketDiscordLinkRequest::new);
        registerPacket(PacketDiscordLinkResponse.f47ID, PacketDiscordLinkResponse.class, PacketDiscordLinkResponse::new);
        registerPacket(PacketDiscordUnlinkRequest.f48ID, PacketDiscordUnlinkRequest.class, PacketDiscordUnlinkRequest::new);
        registerPacket(PacketDiscordVCPlayers.f49ID, PacketDiscordVCPlayers.class, PacketDiscordVCPlayers::new);
        registerPacket(PacketNewsListRequest.f84ID, PacketNewsListRequest.class, PacketNewsListRequest::new);
        registerPacket(PacketNewsListResponse.f85ID, PacketNewsListResponse.class, PacketNewsListResponse::new);
        registerPacket(PacketNewsImageRequest.f81ID, PacketNewsImageRequest.class, PacketNewsImageRequest::new);
        registerPacket(PacketNewsImageResponse.f83ID, PacketNewsImageResponse.class, PacketNewsImageResponse::new);
        registerPacket(PacketNewsArticleRequest.f77ID, PacketNewsArticleRequest.class, PacketNewsArticleRequest::new);
        registerPacket(PacketNewsArticleResponse.f79ID, PacketNewsArticleResponse.class, PacketNewsArticleResponse::new);
        registerPacket(PacketPatreonLinkRequest.f93ID, PacketPatreonLinkRequest.class, PacketPatreonLinkRequest::new);
        registerPacket(PacketPatreonLinkResponse.f94ID, PacketPatreonLinkResponse.class, PacketPatreonLinkResponse::new);
        registerPacket(PacketPatreonUnlinkRequest.f95ID, PacketPatreonUnlinkRequest.class, PacketPatreonUnlinkRequest::new);
        registerPacket(PacketPlayerDataIncreaseValue.f110ID, PacketPlayerDataIncreaseValue.class, PacketPlayerDataIncreaseValue::new);
        registerPacket(PacketPlayerDataIncreaseValueBatch.f111ID, PacketPlayerDataIncreaseValueBatch.class, PacketPlayerDataIncreaseValueBatch::new);
        registerPacket(PacketPlayerRandomDrop.f33ID, PacketPlayerRandomDrop.class, PacketPlayerRandomDrop::new);
        registerPacket(PacketServerGameStatus.f113ID, PacketServerGameStatus.class, PacketServerGameStatus::new);
        registerPacket(PacketServerNotification.f114ID, PacketServerNotification.class, PacketServerNotification::new);
        registerPacket(PacketKickedPlayer.f31ID, PacketKickedPlayer.class, PacketKickedPlayer::new);
        registerPacket(PacketPlayerDataSetValue.f112ID, PacketPlayerDataSetValue.class, PacketPlayerDataSetValue::new);
        registerPacket(PacketProfanity.f34ID, PacketProfanity.class, PacketProfanity::new);
        registerPacket(PacketChatMessageFromCloud.f23ID, PacketChatMessageFromCloud.class, PacketChatMessageFromCloud::new);
        registerPacket(PacketFeatureFlags.f30ID, PacketFeatureFlags.class, PacketFeatureFlags::new);
        registerPacket(PacketProfanitySync.f35ID, PacketProfanitySync.class, PacketProfanitySync::new);
        registerPacket(PacketClanCreate.f40ID, PacketClanCreate.class, PacketClanCreate::new);
        registerPacket(PacketClanDelete.f41ID, PacketClanDelete.class, PacketClanDelete::new);
        registerPacket(PacketClanInvite.f42ID, PacketClanInvite.class, PacketClanInvite::new);
        registerPacket(PacketClanResponse.f45ID, PacketClanResponse.class, PacketClanResponse::new);
        registerPacket(PacketClanKick.f43ID, PacketClanKick.class, PacketClanKick::new);
        registerPacket(PacketClanLeave.f44ID, PacketClanLeave.class, PacketClanLeave::new);
    }

    public static void setLogErrors(boolean value) {
        logErrors = value;
    }

    public static <P extends IPacket> void registerPacket(@NotNull PacketIdentifier identifier, @NotNull Class<P> packetClass, @NotNull PacketFactory<P> factory) {
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
        PACKET_FACTORIES.put(hash, factory);
        PACKET_CLASS_TO_IDENTIFIER_MAP.put(packetClass, identifier);
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
            PacketFactory<?> factory = (PacketFactory) PACKET_FACTORIES.get(packetHash);
            if (factory == null) {
                if (logErrors) {
                    LOGGER.error("Failed to find packet factory for hash: {}", Integer.valueOf(packetHash));
                    return null;
                }
                return null;
            }
            return factory.create(byteBuf);
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
