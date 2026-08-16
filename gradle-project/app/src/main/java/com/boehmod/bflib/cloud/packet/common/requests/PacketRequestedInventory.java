package com.boehmod.bflib.cloud.packet.common.requests;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventory.class */
public final class PacketRequestedInventory extends Record implements IPacket {

    @NotNull
    private final UUID uuid;

    @NotNull
    private final List<CloudItemStack> stacks;
    private final int section;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f102ID = new PacketIdentifier("PacketRequestedInventory");

    public PacketRequestedInventory(@NotNull UUID uuid, @NotNull List<CloudItemStack> stacks, int section) {
        this.uuid = uuid;
        this.stacks = stacks;
        this.section = section;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketRequestedInventory.class), PacketRequestedInventory.class, "uuid;stacks;section", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventory;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventory;->stacks:Ljava/util/List;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventory;->section:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketRequestedInventory.class), PacketRequestedInventory.class, "uuid;stacks;section", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventory;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventory;->stacks:Ljava/util/List;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventory;->section:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketRequestedInventory.class, Object.class), PacketRequestedInventory.class, "uuid;stacks;section", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventory;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventory;->stacks:Ljava/util/List;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventory;->section:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID uuid() {
        return this.uuid;
    }

    @NotNull
    public List<CloudItemStack> stacks() {
        return this.stacks;
    }

    public int section() {
        return this.section;
    }

    public PacketRequestedInventory(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readCloudItemStackList(byteBuffer), byteBuffer.readByte());
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.uuid);
        IPacket.writeCloudItemStackList(byteBuffer, this.stacks);
        byteBuffer.writeByte((byte) this.section);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f102ID;
    }
}
