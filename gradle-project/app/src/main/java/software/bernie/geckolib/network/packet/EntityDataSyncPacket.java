package software.bernie.geckolib.network.packet;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.Consumer;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.GeoReplacedEntity;
import software.bernie.geckolib.constant.dataticket.SerializableDataTicket;
import software.bernie.geckolib.util.ClientUtil;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/network/packet/EntityDataSyncPacket.class */
public final class EntityDataSyncPacket<D> extends Record implements MultiloaderPacket {
    private final int entityId;
    private final boolean isReplacedEntity;
    private final SerializableDataTicket<D> dataTicket;
    private final D data;
    public static final CustomPacketPayload.Type<EntityDataSyncPacket<?>> TYPE = new CustomPacketPayload.Type<>(GeckoLibConstants.id("entity_data_sync"));
    public static final StreamCodec<RegistryFriendlyByteBuf, EntityDataSyncPacket<?>> CODEC = StreamCodec.of((buf, packet) -> {
        SerializableDataTicket.STREAM_CODEC.encode(buf, packet.dataTicket);
        buf.writeVarInt(packet.entityId);
        buf.writeBoolean(packet.isReplacedEntity);
        packet.dataTicket.streamCodec().encode(buf, packet.data);
    }, buf2 -> {
        SerializableDataTicket dataTicket = (SerializableDataTicket) SerializableDataTicket.STREAM_CODEC.decode(buf2);
        return new EntityDataSyncPacket(buf2.readVarInt(), buf2.readBoolean(), dataTicket, dataTicket.streamCodec().decode(buf2));
    });

    public EntityDataSyncPacket(int entityId, boolean isReplacedEntity, SerializableDataTicket<D> dataTicket, D data) {
        this.entityId = entityId;
        this.isReplacedEntity = isReplacedEntity;
        this.dataTicket = dataTicket;
        this.data = data;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, EntityDataSyncPacket.class), EntityDataSyncPacket.class, "entityId;isReplacedEntity;dataTicket;data", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityDataSyncPacket;->entityId:I", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityDataSyncPacket;->isReplacedEntity:Z", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityDataSyncPacket;->dataTicket:Lsoftware/bernie/geckolib/constant/dataticket/SerializableDataTicket;", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityDataSyncPacket;->data:Ljava/lang/Object;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, EntityDataSyncPacket.class), EntityDataSyncPacket.class, "entityId;isReplacedEntity;dataTicket;data", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityDataSyncPacket;->entityId:I", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityDataSyncPacket;->isReplacedEntity:Z", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityDataSyncPacket;->dataTicket:Lsoftware/bernie/geckolib/constant/dataticket/SerializableDataTicket;", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityDataSyncPacket;->data:Ljava/lang/Object;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, EntityDataSyncPacket.class, Object.class), EntityDataSyncPacket.class, "entityId;isReplacedEntity;dataTicket;data", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityDataSyncPacket;->entityId:I", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityDataSyncPacket;->isReplacedEntity:Z", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityDataSyncPacket;->dataTicket:Lsoftware/bernie/geckolib/constant/dataticket/SerializableDataTicket;", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityDataSyncPacket;->data:Ljava/lang/Object;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public int entityId() {
        return this.entityId;
    }

    public boolean isReplacedEntity() {
        return this.isReplacedEntity;
    }

    public SerializableDataTicket<D> dataTicket() {
        return this.dataTicket;
    }

    public D data() {
        return this.data;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    @Override // software.bernie.geckolib.network.packet.MultiloaderPacket
    public void receiveMessage(@Nullable Player sender, Consumer<Runnable> workQueue) {
        workQueue.accept(() -> {
            GeoEntity entity = ClientUtil.getLevel().getEntity(this.entityId);
            if (entity == null) {
                return;
            }
            if (!this.isReplacedEntity) {
                if (entity instanceof GeoEntity) {
                    GeoEntity geoEntity = entity;
                    geoEntity.setAnimData(this.dataTicket, this.data);
                    return;
                }
                return;
            }
            GeoAnimatable patt0$temp = RenderUtil.getReplacedAnimatable(entity.getType());
            if (patt0$temp instanceof GeoReplacedEntity) {
                GeoReplacedEntity replacedEntity = (GeoReplacedEntity) patt0$temp;
                replacedEntity.setAnimData(entity, this.dataTicket, this.data);
            }
        });
    }
}
