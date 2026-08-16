package software.bernie.geckolib.service;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.constant.dataticket.SerializableDataTicket;
import software.bernie.geckolib.network.packet.BlockEntityAnimTriggerPacket;
import software.bernie.geckolib.network.packet.BlockEntityDataSyncPacket;
import software.bernie.geckolib.network.packet.EntityAnimTriggerPacket;
import software.bernie.geckolib.network.packet.EntityDataSyncPacket;
import software.bernie.geckolib.network.packet.MultiloaderPacket;
import software.bernie.geckolib.network.packet.SingletonAnimTriggerPacket;
import software.bernie.geckolib.network.packet.SingletonDataSyncPacket;
import software.bernie.geckolib.network.packet.StatelessBlockEntityPlayAnimPacket;
import software.bernie.geckolib.network.packet.StatelessBlockEntityStopAnimPacket;
import software.bernie.geckolib.network.packet.StatelessEntityPlayAnimPacket;
import software.bernie.geckolib.network.packet.StatelessEntityStopAnimPacket;
import software.bernie.geckolib.network.packet.StatelessSingletonPlayAnimPacket;
import software.bernie.geckolib.network.packet.StatelessSingletonStopAnimPacket;
import software.bernie.geckolib.network.packet.StopTriggeredBlockEntityAnimPacket;
import software.bernie.geckolib.network.packet.StopTriggeredEntityAnimPacket;
import software.bernie.geckolib.network.packet.StopTriggeredSingletonAnimPacket;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/service/GeckoLibNetworking.class */
public interface GeckoLibNetworking {
    @ApiStatus.Internal
    <B extends FriendlyByteBuf, P extends MultiloaderPacket> void registerPacketInternal(CustomPacketPayload.Type<P> type, StreamCodec<B, P> streamCodec, boolean z);

    void sendToAllPlayersTrackingEntity(MultiloaderPacket multiloaderPacket, Entity entity);

    void sendToAllPlayersTrackingBlock(MultiloaderPacket multiloaderPacket, ServerLevel serverLevel, BlockPos blockPos);

    void sendToPlayer(MultiloaderPacket multiloaderPacket, ServerPlayer serverPlayer);

    static void init() {
        registerPacket(BlockEntityDataSyncPacket.TYPE, BlockEntityDataSyncPacket.CODEC, true);
        registerPacket(EntityDataSyncPacket.TYPE, EntityDataSyncPacket.CODEC, true);
        registerPacket(SingletonDataSyncPacket.TYPE, SingletonDataSyncPacket.CODEC, true);
        registerPacket(BlockEntityAnimTriggerPacket.TYPE, BlockEntityAnimTriggerPacket.CODEC, true);
        registerPacket(SingletonAnimTriggerPacket.TYPE, SingletonAnimTriggerPacket.CODEC, true);
        registerPacket(EntityAnimTriggerPacket.TYPE, EntityAnimTriggerPacket.CODEC, true);
        registerPacket(StopTriggeredBlockEntityAnimPacket.TYPE, StopTriggeredBlockEntityAnimPacket.CODEC, true);
        registerPacket(StopTriggeredEntityAnimPacket.TYPE, StopTriggeredEntityAnimPacket.CODEC, true);
        registerPacket(StopTriggeredSingletonAnimPacket.TYPE, StopTriggeredSingletonAnimPacket.CODEC, true);
        registerPacket(StatelessEntityPlayAnimPacket.TYPE, StatelessEntityPlayAnimPacket.CODEC, true);
        registerPacket(StatelessBlockEntityPlayAnimPacket.TYPE, StatelessBlockEntityPlayAnimPacket.CODEC, true);
        registerPacket(StatelessSingletonPlayAnimPacket.TYPE, StatelessSingletonPlayAnimPacket.CODEC, true);
        registerPacket(StatelessEntityStopAnimPacket.TYPE, StatelessEntityStopAnimPacket.CODEC, true);
        registerPacket(StatelessBlockEntityStopAnimPacket.TYPE, StatelessBlockEntityStopAnimPacket.CODEC, true);
        registerPacket(StatelessSingletonStopAnimPacket.TYPE, StatelessSingletonStopAnimPacket.CODEC, true);
    }

    @ApiStatus.Internal
    private static <B extends FriendlyByteBuf, P extends MultiloaderPacket> void registerPacket(CustomPacketPayload.Type<P> payloadType, StreamCodec<B, P> codec, boolean isClientBound) {
        GeckoLibServices.NETWORK.registerPacketInternal(payloadType, codec, isClientBound);
    }

    default <D> void syncBlockEntityAnimData(BlockPos pos, SerializableDataTicket<D> dataTicket, D data, ServerLevel level) {
        sendToAllPlayersTrackingBlock(new BlockEntityDataSyncPacket(pos, dataTicket, data), level, pos);
    }

    default <D> void syncEntityAnimData(Entity entity, boolean isReplacedEntity, SerializableDataTicket<D> dataTicket, D data) {
        sendToAllPlayersTrackingEntity(new EntityDataSyncPacket(entity.getId(), isReplacedEntity, dataTicket, data), entity);
    }

    @Deprecated(forRemoval = true)
    default <D> void syncSingletonAnimData(long instanceId, SerializableDataTicket<D> dataTicket, D data, Entity entityToTrack) {
    }

    @Deprecated(forRemoval = true)
    default <D> void syncSingletonAnimData(Class<?> animatableClass, long instanceId, SerializableDataTicket<D> dataTicket, D data, Entity entityToTrack) {
    }

    default <D> void syncSingletonAnimData(GeoAnimatable animatable, long instanceId, SerializableDataTicket<D> dataTicket, D data, Entity entityToTrack) {
        sendToAllPlayersTrackingEntity(new SingletonDataSyncPacket(GeckoLibUtil.getSyncedSingletonAnimatableId(animatable), instanceId, dataTicket, data), entityToTrack);
    }

    default void triggerBlockEntityAnim(BlockPos pos, @Nullable String controllerName, String animName, ServerLevel level) {
        sendToAllPlayersTrackingBlock(new BlockEntityAnimTriggerPacket(pos, controllerName == null ? "" : controllerName, animName), level, pos);
    }

    default void triggerEntityAnim(Entity entity, boolean isReplacedEntity, @Nullable String controllerName, String animName) {
        sendToAllPlayersTrackingEntity(new EntityAnimTriggerPacket(entity.getId(), isReplacedEntity, controllerName == null ? "" : controllerName, animName), entity);
    }

    @Deprecated(forRemoval = true)
    default void triggerSingletonAnim(String animatableClassName, Entity entityToTrack, long instanceId, @Nullable String controllerName, String animName) {
        sendToAllPlayersTrackingEntity(new SingletonAnimTriggerPacket(animatableClassName, instanceId, controllerName, animName), entityToTrack);
    }

    @Deprecated(forRemoval = true)
    default void triggerSingletonAnim(Class<?> animatableClass, Entity entityToTrack, long instanceId, @Nullable String controllerName, String animName) {
    }

    default void triggerSingletonAnim(GeoAnimatable animatable, Entity entityToTrack, long instanceId, @Nullable String controllerName, String animName) {
        triggerSingletonAnim(GeckoLibUtil.getSyncedSingletonAnimatableId(animatable), entityToTrack, instanceId, controllerName == null ? "" : controllerName, animName);
    }

    default void stopTriggeredBlockEntityAnim(BlockPos pos, ServerLevel level, @Nullable String controllerName, @Nullable String animName) {
        sendToAllPlayersTrackingBlock(new StopTriggeredBlockEntityAnimPacket(pos, controllerName == null ? "" : controllerName, animName == null ? "" : animName), level, pos);
    }

    default void stopTriggeredEntityAnim(Entity entity, boolean isReplacedEntity, @Nullable String controllerName, @Nullable String animName) {
        sendToAllPlayersTrackingEntity(new StopTriggeredEntityAnimPacket(entity.getId(), isReplacedEntity, controllerName == null ? "" : controllerName, animName == null ? "" : animName), entity);
    }

    @Deprecated(forRemoval = true)
    default void stopTriggeredSingletonAnim(Class<?> animatableClass, Entity entityToTrack, long instanceId, @Nullable String controllerName, @Nullable String animName) {
        sendToAllPlayersTrackingEntity(new StopTriggeredSingletonAnimPacket(animatableClass.getName() + "0", instanceId, controllerName == null ? "" : controllerName, animName == null ? "" : animName), entityToTrack);
    }

    default void stopTriggeredSingletonAnim(GeoAnimatable animatable, Entity entityToTrack, long instanceId, @Nullable String controllerName, @Nullable String animName) {
        sendToAllPlayersTrackingEntity(new StopTriggeredSingletonAnimPacket(GeckoLibUtil.getSyncedSingletonAnimatableId(animatable), instanceId, controllerName == null ? "" : controllerName, animName == null ? "" : animName), entityToTrack);
    }
}
