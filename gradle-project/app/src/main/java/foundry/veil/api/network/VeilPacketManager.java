package foundry.veil.api.network;

import foundry.veil.api.network.handler.ClientPacketContext;
import foundry.veil.api.network.handler.PacketContext;
import foundry.veil.api.network.handler.ServerPacketContext;
import foundry.veil.impl.network.ClientPacketSink;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBundlePacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/network/VeilPacketManager.class */
public interface VeilPacketManager {
    public static final Factory FACTORY = (Factory) ServiceLoader.load(Factory.class).findFirst().orElseThrow(() -> {
        return new RuntimeException("Failed to load packet provider");
    });

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/network/VeilPacketManager$Factory.class */
    @ApiStatus.Internal
    public interface Factory {
        VeilPacketManager create(String str, String str2);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/network/VeilPacketManager$PacketHandler.class */
    @FunctionalInterface
    public interface PacketHandler<T extends PacketContext, P extends CustomPacketPayload> {
        void handlePacket(P p, T t);
    }

    <T extends CustomPacketPayload> void registerClientbound(CustomPacketPayload.Type<T> type, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec, PacketHandler<ClientPacketContext, T> packetHandler, boolean z);

    <T extends CustomPacketPayload> void registerServerbound(CustomPacketPayload.Type<T> type, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec, PacketHandler<ServerPacketContext, T> packetHandler, boolean z);

    static VeilPacketManager create(String modId, String version) {
        return FACTORY.create(modId, version);
    }

    default <T extends CustomPacketPayload> void registerClientbound(CustomPacketPayload.Type<T> id, StreamCodec<? super RegistryFriendlyByteBuf, T> codec, PacketHandler<ClientPacketContext, T> handler) {
        registerClientbound(id, codec, handler, false);
    }

    default <T extends CustomPacketPayload> void registerServerbound(CustomPacketPayload.Type<T> id, StreamCodec<? super RegistryFriendlyByteBuf, T> codec, PacketHandler<ServerPacketContext, T> handler) {
        registerServerbound(id, codec, handler, false);
    }

    static PacketSink server() {
        return ClientPacketSink.INSTANCE;
    }

    static PacketSink player(ServerPlayer player) {
        return (PacketSink) player;
    }

    static PacketSink level(ServerLevel level) {
        return (PacketSink) level;
    }

    static PacketSink around(@Nullable ServerPlayer excluded, ServerLevel level, double x, double y, double z, double radius) {
        return packet -> {
            level.getServer().getPlayerList().broadcast(excluded, x, y, z, radius, level.dimension(), packet);
        };
    }

    static PacketSink all(MinecraftServer server) {
        return (PacketSink) server;
    }

    static PacketSink tracking(Entity entity) {
        ServerChunkCache chunkSource = entity.level().getChunkSource();
        if (!(chunkSource instanceof ServerChunkCache)) {
            throw new IllegalStateException("Cannot send clientbound payloads on the client");
        }
        ServerChunkCache chunkCache = chunkSource;
        return packet -> {
            chunkCache.broadcast(entity, packet);
        };
    }

    static PacketSink trackingAndSelf(Entity entity) {
        ServerChunkCache chunkSource = entity.level().getChunkSource();
        if (!(chunkSource instanceof ServerChunkCache)) {
            throw new IllegalStateException("Cannot send clientbound payloads on the client");
        }
        ServerChunkCache chunkCache = chunkSource;
        return packet -> {
            chunkCache.broadcastAndSend(entity, packet);
        };
    }

    static PacketSink tracking(ServerLevel level, ChunkPos pos) {
        return packet -> {
            for (ServerPlayer player : level.getChunkSource().chunkMap.getPlayers(pos, false)) {
                player.connection.send(packet);
            }
        };
    }

    static PacketSink tracking(ServerLevel level, BlockPos pos) {
        return tracking(level, new ChunkPos(pos));
    }

    static PacketSink tracking(ServerLevel level, BlockPos min, BlockPos max) {
        return packet -> {
            ChunkPos.rangeClosed(new ChunkPos(min), new ChunkPos(max)).flatMap(pos -> {
                return level.getChunkSource().chunkMap.getPlayers(pos, false).stream();
            }).distinct().forEach(player -> {
                player.connection.send(packet);
            });
        };
    }

    static PacketSink tracking(BlockEntity blockEntity) {
        ServerLevel level = blockEntity.getLevel();
        if (!(level instanceof ServerLevel)) {
            throw new IllegalArgumentException("Only supported on server levels!");
        }
        ServerLevel serverLevel = level;
        return tracking(serverLevel, blockEntity.getBlockPos());
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/network/VeilPacketManager$PacketSink.class */
    @FunctionalInterface
    public interface PacketSink {
        void sendPacket(Packet<?> packet);

        default void sendPacket(CustomPacketPayload... payloads) {
            if (payloads.length == 0) {
                return;
            }
            if (payloads.length == 1) {
                sendPacket((Packet<?>) new ClientboundCustomPayloadPacket(payloads[0]));
                return;
            }
            List<Packet<? super ClientGamePacketListener>> packets = new ArrayList<>();
            for (CustomPacketPayload payload : payloads) {
                packets.add(new ClientboundCustomPayloadPacket(payload));
            }
            sendPacket((Packet<?>) new ClientboundBundlePacket(packets));
        }
    }
}
