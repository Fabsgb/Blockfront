package software.bernie.geckolib.network.packet;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.Consumer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.constant.dataticket.SerializableDataTicket;
import software.bernie.geckolib.util.ClientUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/network/packet/BlockEntityDataSyncPacket.class */
public final class BlockEntityDataSyncPacket<D> extends Record implements MultiloaderPacket {
    private final BlockPos pos;
    private final SerializableDataTicket<D> dataTicket;
    private final D data;
    public static final CustomPacketPayload.Type<BlockEntityDataSyncPacket<?>> TYPE = new CustomPacketPayload.Type<>(GeckoLibConstants.m8005id("blockentity_data_sync"));
    public static final StreamCodec<RegistryFriendlyByteBuf, BlockEntityDataSyncPacket<?>> CODEC = StreamCodec.of((buf, packet) -> {
        SerializableDataTicket.STREAM_CODEC.encode(buf, packet.dataTicket);
        buf.writeBlockPos(packet.pos);
        packet.dataTicket.streamCodec().encode(buf, packet.data);
    }, buf2 -> {
        SerializableDataTicket dataTicket = (SerializableDataTicket) SerializableDataTicket.STREAM_CODEC.decode(buf2);
        return new BlockEntityDataSyncPacket(buf2.readBlockPos(), dataTicket, dataTicket.streamCodec().decode(buf2));
    });

    public BlockEntityDataSyncPacket(BlockPos pos, SerializableDataTicket<D> dataTicket, D data) {
        this.pos = pos;
        this.dataTicket = dataTicket;
        this.data = data;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, BlockEntityDataSyncPacket.class), BlockEntityDataSyncPacket.class, "pos;dataTicket;data", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityDataSyncPacket;->pos:Lnet/minecraft/core/BlockPos;", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityDataSyncPacket;->dataTicket:Lsoftware/bernie/geckolib/constant/dataticket/SerializableDataTicket;", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityDataSyncPacket;->data:Ljava/lang/Object;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, BlockEntityDataSyncPacket.class), BlockEntityDataSyncPacket.class, "pos;dataTicket;data", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityDataSyncPacket;->pos:Lnet/minecraft/core/BlockPos;", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityDataSyncPacket;->dataTicket:Lsoftware/bernie/geckolib/constant/dataticket/SerializableDataTicket;", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityDataSyncPacket;->data:Ljava/lang/Object;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, BlockEntityDataSyncPacket.class, Object.class), BlockEntityDataSyncPacket.class, "pos;dataTicket;data", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityDataSyncPacket;->pos:Lnet/minecraft/core/BlockPos;", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityDataSyncPacket;->dataTicket:Lsoftware/bernie/geckolib/constant/dataticket/SerializableDataTicket;", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityDataSyncPacket;->data:Ljava/lang/Object;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public BlockPos pos() {
        return this.pos;
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
            GeoBlockEntity blockEntity = ClientUtil.getLevel().getBlockEntity(this.pos);
            if (blockEntity instanceof GeoBlockEntity) {
                GeoBlockEntity blockEntity2 = blockEntity;
                blockEntity2.setAnimData(this.dataTicket, this.data);
            }
        });
    }
}
