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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerAdd.class */
public final class PacketInventoryItemStickerAdd extends Record implements IPacket {

    @NotNull
    private final UUID stack;

    @NotNull
    private final UUID sticker;
    private final int index;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketInventoryItemStickerAdd");

    public PacketInventoryItemStickerAdd(@NotNull UUID stack, @NotNull UUID sticker, int index) {
        this.stack = stack;
        this.sticker = sticker;
        this.index = index;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketInventoryItemStickerAdd.class), PacketInventoryItemStickerAdd.class, "stack;sticker;index", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerAdd;->stack:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerAdd;->sticker:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerAdd;->index:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketInventoryItemStickerAdd.class), PacketInventoryItemStickerAdd.class, "stack;sticker;index", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerAdd;->stack:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerAdd;->sticker:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerAdd;->index:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketInventoryItemStickerAdd.class, Object.class), PacketInventoryItemStickerAdd.class, "stack;sticker;index", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerAdd;->stack:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerAdd;->sticker:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemStickerAdd;->index:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID stack() {
        return this.stack;
    }

    @NotNull
    public UUID sticker() {
        return this.sticker;
    }

    public int index() {
        return this.index;
    }

    public PacketInventoryItemStickerAdd(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readUUID(byteBuffer), byteBuffer.readInt());
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.stack);
        IPacket.writeUUID(byteBuffer, this.sticker);
        byteBuffer.writeInt(this.index);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
