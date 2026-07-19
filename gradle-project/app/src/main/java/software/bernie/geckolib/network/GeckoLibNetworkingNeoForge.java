package software.bernie.geckolib.network;

import java.util.Objects;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ChunkPos;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.network.packet.MultiloaderPacket;
import software.bernie.geckolib.service.GeckoLibNetworking;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/network/GeckoLibNetworkingNeoForge.class */
public class GeckoLibNetworkingNeoForge implements GeckoLibNetworking {
    private static PayloadRegistrar registrar = null;

    public static void init(IEventBus modBus) {
        modBus.addListener(event -> {
            registrar = event.registrar(GeckoLibConstants.MODID);
            GeckoLibNetworking.init();
            registrar = null;
        });
    }

    @Override // software.bernie.geckolib.service.GeckoLibNetworking
    public <B extends FriendlyByteBuf, P extends MultiloaderPacket> void registerPacketInternal(CustomPacketPayload.Type<P> payloadType, StreamCodec<B, P> codec, boolean isClientBound) {
        if (isClientBound) {
            registrar.playToClient(payloadType, codec, (packet, context) -> {
                Player player = context.player();
                Objects.requireNonNull(context);
                packet.receiveMessage(player, context::enqueueWork);
            });
        } else {
            registrar.playToServer(payloadType, codec, (packet2, context2) -> {
                Player player = context2.player();
                Objects.requireNonNull(context2);
                packet2.receiveMessage(player, context2::enqueueWork);
            });
        }
    }

    @Override // software.bernie.geckolib.service.GeckoLibNetworking
    public void sendToAllPlayersTrackingEntity(MultiloaderPacket packet, Entity trackingEntity) {
        PacketDistributor.sendToPlayersTrackingEntityAndSelf(trackingEntity, packet, new CustomPacketPayload[0]);
    }

    @Override // software.bernie.geckolib.service.GeckoLibNetworking
    public void sendToAllPlayersTrackingBlock(MultiloaderPacket packet, ServerLevel level, BlockPos pos) {
        PacketDistributor.sendToPlayersTrackingChunk(level, new ChunkPos(pos), packet, new CustomPacketPayload[0]);
    }

    @Override // software.bernie.geckolib.service.GeckoLibNetworking
    public void sendToPlayer(MultiloaderPacket packet, ServerPlayer player) {
        PacketDistributor.sendToPlayer(player, packet, new CustomPacketPayload[0]);
    }
}
