package com.boehmod.bflib.cloud.packet.common.requests;

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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/requests/PacketRequestedItemShowcase.class */
public final class PacketRequestedItemShowcase extends Record implements IPacket {

    @NotNull
    private final UUID uuid;

    @NotNull
    private final ObjectSet<UUID> itemStacks;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f105ID = new PacketIdentifier("PacketRequestedItemShowcase");

    public PacketRequestedItemShowcase(@NotNull UUID uuid, @NotNull ObjectSet<UUID> itemStacks) {
        this.uuid = uuid;
        this.itemStacks = itemStacks;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketRequestedItemShowcase.class), PacketRequestedItemShowcase.class, "uuid;itemStacks", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedItemShowcase;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedItemShowcase;->itemStacks:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketRequestedItemShowcase.class), PacketRequestedItemShowcase.class, "uuid;itemStacks", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedItemShowcase;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedItemShowcase;->itemStacks:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketRequestedItemShowcase.class, Object.class), PacketRequestedItemShowcase.class, "uuid;itemStacks", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedItemShowcase;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedItemShowcase;->itemStacks:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID uuid() {
        return this.uuid;
    }

    @NotNull
    public ObjectSet<UUID> itemStacks() {
        return this.itemStacks;
    }

    public PacketRequestedItemShowcase(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readUUIDSet(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.uuid);
        IPacket.writeUUIDSet(byteBuffer, this.itemStacks);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f105ID;
    }
}
