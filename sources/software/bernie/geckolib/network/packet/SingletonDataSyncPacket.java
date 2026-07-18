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
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.constant.dataticket.SerializableDataTicket;
import software.bernie.geckolib.util.ClientUtil;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/network/packet/SingletonDataSyncPacket.class */
public final class SingletonDataSyncPacket<D> extends Record implements MultiloaderPacket {
    private final String syncableId;
    private final long instanceId;
    private final SerializableDataTicket<D> dataTicket;
    private final D data;
    public static final CustomPacketPayload.Type<SingletonDataSyncPacket<?>> TYPE = new CustomPacketPayload.Type<>(GeckoLibConstants.m8005id("singleton_data_sync"));
    public static final StreamCodec<RegistryFriendlyByteBuf, SingletonDataSyncPacket<?>> CODEC = StreamCodec.of((buf, packet) -> {
        SerializableDataTicket.STREAM_CODEC.encode(buf, packet.dataTicket);
        buf.writeUtf(packet.syncableId);
        buf.writeVarLong(packet.instanceId);
        packet.dataTicket.streamCodec().encode(buf, packet.data);
    }, buf2 -> {
        SerializableDataTicket dataTicket = (SerializableDataTicket) SerializableDataTicket.STREAM_CODEC.decode(buf2);
        return new SingletonDataSyncPacket(buf2.readUtf(), buf2.readVarLong(), dataTicket, dataTicket.streamCodec().decode(buf2));
    });

    public SingletonDataSyncPacket(String syncableId, long instanceId, SerializableDataTicket<D> dataTicket, D data) {
        this.syncableId = syncableId;
        this.instanceId = instanceId;
        this.dataTicket = dataTicket;
        this.data = data;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, SingletonDataSyncPacket.class), SingletonDataSyncPacket.class, "syncableId;instanceId;dataTicket;data", "FIELD:Lsoftware/bernie/geckolib/network/packet/SingletonDataSyncPacket;->syncableId:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/SingletonDataSyncPacket;->instanceId:J", "FIELD:Lsoftware/bernie/geckolib/network/packet/SingletonDataSyncPacket;->dataTicket:Lsoftware/bernie/geckolib/constant/dataticket/SerializableDataTicket;", "FIELD:Lsoftware/bernie/geckolib/network/packet/SingletonDataSyncPacket;->data:Ljava/lang/Object;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, SingletonDataSyncPacket.class), SingletonDataSyncPacket.class, "syncableId;instanceId;dataTicket;data", "FIELD:Lsoftware/bernie/geckolib/network/packet/SingletonDataSyncPacket;->syncableId:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/SingletonDataSyncPacket;->instanceId:J", "FIELD:Lsoftware/bernie/geckolib/network/packet/SingletonDataSyncPacket;->dataTicket:Lsoftware/bernie/geckolib/constant/dataticket/SerializableDataTicket;", "FIELD:Lsoftware/bernie/geckolib/network/packet/SingletonDataSyncPacket;->data:Ljava/lang/Object;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, SingletonDataSyncPacket.class, Object.class), SingletonDataSyncPacket.class, "syncableId;instanceId;dataTicket;data", "FIELD:Lsoftware/bernie/geckolib/network/packet/SingletonDataSyncPacket;->syncableId:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/SingletonDataSyncPacket;->instanceId:J", "FIELD:Lsoftware/bernie/geckolib/network/packet/SingletonDataSyncPacket;->dataTicket:Lsoftware/bernie/geckolib/constant/dataticket/SerializableDataTicket;", "FIELD:Lsoftware/bernie/geckolib/network/packet/SingletonDataSyncPacket;->data:Ljava/lang/Object;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public String syncableId() {
        return this.syncableId;
    }

    public long instanceId() {
        return this.instanceId;
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
            GeoAnimatable animatable = GeckoLibUtil.getSyncedAnimatable(this.syncableId);
            if (animatable instanceof SingletonGeoAnimatable) {
                SingletonGeoAnimatable singleton = (SingletonGeoAnimatable) animatable;
                singleton.setAnimData(ClientUtil.getClientPlayer(), this.instanceId, this.dataTicket, this.data);
            }
        });
    }
}
