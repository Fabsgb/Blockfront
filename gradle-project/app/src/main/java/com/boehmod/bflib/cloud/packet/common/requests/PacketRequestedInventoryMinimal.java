package com.boehmod.bflib.cloud.packet.common.requests;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventoryMinimal.class */
public final class PacketRequestedInventoryMinimal extends Record implements IPacket {

    @NotNull
    private final UUID uuid;

    @NotNull
    private final ObjectList<CloudItemStack> stacks;

    @NotNull
    private final ObjectSet<UUID> showcased;

    @NotNull
    private final ObjectSet<UUID> equipped;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketRequestedInventoryMinimal");

    public PacketRequestedInventoryMinimal(@NotNull UUID uuid, @NotNull ObjectList<CloudItemStack> stacks, @NotNull ObjectSet<UUID> showcased, @NotNull ObjectSet<UUID> equipped) {
        this.uuid = uuid;
        this.stacks = stacks;
        this.showcased = showcased;
        this.equipped = equipped;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketRequestedInventoryMinimal.class), PacketRequestedInventoryMinimal.class, "uuid;stacks;showcased;equipped", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventoryMinimal;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventoryMinimal;->stacks:Lit/unimi/dsi/fastutil/objects/ObjectList;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventoryMinimal;->showcased:Lit/unimi/dsi/fastutil/objects/ObjectSet;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventoryMinimal;->equipped:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketRequestedInventoryMinimal.class), PacketRequestedInventoryMinimal.class, "uuid;stacks;showcased;equipped", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventoryMinimal;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventoryMinimal;->stacks:Lit/unimi/dsi/fastutil/objects/ObjectList;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventoryMinimal;->showcased:Lit/unimi/dsi/fastutil/objects/ObjectSet;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventoryMinimal;->equipped:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketRequestedInventoryMinimal.class, Object.class), PacketRequestedInventoryMinimal.class, "uuid;stacks;showcased;equipped", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventoryMinimal;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventoryMinimal;->stacks:Lit/unimi/dsi/fastutil/objects/ObjectList;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventoryMinimal;->showcased:Lit/unimi/dsi/fastutil/objects/ObjectSet;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedInventoryMinimal;->equipped:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID uuid() {
        return this.uuid;
    }

    @NotNull
    public ObjectList<CloudItemStack> stacks() {
        return this.stacks;
    }

    @NotNull
    public ObjectSet<UUID> showcased() {
        return this.showcased;
    }

    @NotNull
    public ObjectSet<UUID> equipped() {
        return this.equipped;
    }

    public PacketRequestedInventoryMinimal(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readCloudItemStackList(byteBuffer), IPacket.readUUIDSet(byteBuffer), IPacket.readUUIDSet(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.uuid);
        IPacket.writeCloudItemStackList(byteBuffer, this.stacks);
        IPacket.writeUUIDSet(byteBuffer, this.showcased);
        IPacket.writeUUIDSet(byteBuffer, this.equipped);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
