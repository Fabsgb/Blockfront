package com.boehmod.bflib.cloud.packet.common.inventory;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemAdded.class */
public final class PacketInventoryItemAdded extends Record implements IPacket {

    @NotNull
    private final List<CloudItemStack> stacks;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketInventoryItemAdded");

    public PacketInventoryItemAdded(@NotNull List<CloudItemStack> stacks) {
        this.stacks = stacks;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketInventoryItemAdded.class), PacketInventoryItemAdded.class, "stacks", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemAdded;->stacks:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketInventoryItemAdded.class), PacketInventoryItemAdded.class, "stacks", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemAdded;->stacks:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketInventoryItemAdded.class, Object.class), PacketInventoryItemAdded.class, "stacks", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemAdded;->stacks:Ljava/util/List;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public List<CloudItemStack> stacks() {
        return this.stacks;
    }

    public PacketInventoryItemAdded(@NotNull ByteBuf byteBuffer) throws IOException {
        this((List<CloudItemStack>) IPacket.readCloudItemStackList(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeCloudItemStackList(byteBuffer, this.stacks);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
