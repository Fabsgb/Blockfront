package com.boehmod.bflib.cloud.packet.common.inventory;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerRemove.class */
public final class PacketInventoryItemStickerRemove extends Record implements IPacket {

    @NotNull
    private final UUID stack;
    private final int index;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f62ID = new PacketIdentifier("PacketInventoryItemStickerRemove");

    public PacketInventoryItemStickerRemove(@NotNull UUID stack, int index) {
        this.stack = stack;
        this.index = index;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketInventoryItemStickerRemove.class), PacketInventoryItemStickerRemove.class, "stack;index", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerRemove;->stack:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerRemove;->index:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketInventoryItemStickerRemove.class), PacketInventoryItemStickerRemove.class, "stack;index", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerRemove;->stack:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerRemove;->index:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketInventoryItemStickerRemove.class, Object.class), PacketInventoryItemStickerRemove.class, "stack;index", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerRemove;->stack:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerRemove;->index:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID stack() {
        return this.stack;
    }

    public int index() {
        return this.index;
    }

    public PacketInventoryItemStickerRemove(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), byteBuffer.readInt());
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.stack);
        byteBuffer.writeInt(this.index);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f62ID;
    }
}
