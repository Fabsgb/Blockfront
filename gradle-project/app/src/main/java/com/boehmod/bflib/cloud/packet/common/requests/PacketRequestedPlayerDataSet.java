package com.boehmod.bflib.cloud.packet.common.requests;

import com.boehmod.bflib.cloud.common.player.PlayerDataContext;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerDataSet.class */
public final class PacketRequestedPlayerDataSet extends Record implements IPacket {

    @NotNull
    private final Map<UUID, Pair<PlayerDataContext, byte[]>> dataSet;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f107ID = new PacketIdentifier("PacketRequestedPlayerDataSet");

    public PacketRequestedPlayerDataSet(@NotNull Map<UUID, Pair<PlayerDataContext, byte[]>> dataSet) {
        this.dataSet = dataSet;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketRequestedPlayerDataSet.class), PacketRequestedPlayerDataSet.class, "dataSet", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerDataSet;->dataSet:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketRequestedPlayerDataSet.class), PacketRequestedPlayerDataSet.class, "dataSet", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerDataSet;->dataSet:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketRequestedPlayerDataSet.class, Object.class), PacketRequestedPlayerDataSet.class, "dataSet", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerDataSet;->dataSet:Ljava/util/Map;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public Map<UUID, Pair<PlayerDataContext, byte[]>> dataSet() {
        return this.dataSet;
    }

    public PacketRequestedPlayerDataSet(@NotNull ByteBuf byteBuffer) throws IOException {
        this(readDataSetWithContext(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        writeDataSetWithContext(byteBuffer, this.dataSet);
    }

    @NotNull
    private static Map<UUID, Pair<PlayerDataContext, byte[]>> readDataSetWithContext(@NotNull ByteBuf byteBuffer) throws IOException {
        int size = IPacket.readSize(byteBuffer);
        Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap(IPacket.presize(size));
        for (int i = 0; i < size; i++) {
            UUID uuid = IPacket.readUUID(byteBuffer);
            PlayerDataContext context = IPacket.readPlayerDataContext(byteBuffer);
            byte[] data = IPacket.readByteArray(byteBuffer);
            object2ObjectOpenHashMap.put(uuid, Pair.of(context, data));
        }
        return object2ObjectOpenHashMap;
    }

    private static void writeDataSetWithContext(@NotNull ByteBuf byteBuffer, @NotNull Map<UUID, Pair<PlayerDataContext, byte[]>> dataSet) throws IOException {
        byteBuffer.writeInt(dataSet.size());
        for (Map.Entry<UUID, Pair<PlayerDataContext, byte[]>> entry : dataSet.entrySet()) {
            Pair<PlayerDataContext, byte[]> pair = entry.getValue();
            IPacket.writeUUID(byteBuffer, entry.getKey());
            IPacket.writePlayerDataContext(byteBuffer, (PlayerDataContext) pair.left());
            IPacket.writeByteArray(byteBuffer, (byte[]) pair.right());
        }
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f107ID;
    }
}
