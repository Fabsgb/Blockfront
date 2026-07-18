package com.boehmod.bflib.cloud.packet.common.inventory;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemRemoved.class */
public final class PacketInventoryItemRemoved extends Record implements IPacket {

    @NotNull
    private final ObjectSet<UUID> uuids;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f57ID = new PacketIdentifier("PacketInventoryItemRemoved");

    public PacketInventoryItemRemoved(@NotNull ObjectSet<UUID> uuids) {
        this.uuids = uuids;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketInventoryItemRemoved.class), PacketInventoryItemRemoved.class, "uuids", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemRemoved;->uuids:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketInventoryItemRemoved.class), PacketInventoryItemRemoved.class, "uuids", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemRemoved;->uuids:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketInventoryItemRemoved.class, Object.class), PacketInventoryItemRemoved.class, "uuids", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryItemRemoved;->uuids:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public ObjectSet<UUID> uuids() {
        return this.uuids;
    }

    public PacketInventoryItemRemoved(@NotNull UUID uuid) {
        this((ObjectSet<UUID>) ObjectSet.of(uuid));
    }

    public PacketInventoryItemRemoved(@NotNull CloudItemStack cloudItemStack) {
        this((ObjectSet<UUID>) ObjectSet.of(cloudItemStack.getUUID()));
    }

    public PacketInventoryItemRemoved(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUIDSet(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUIDSet(byteBuffer, this.uuids);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f57ID;
    }
}
