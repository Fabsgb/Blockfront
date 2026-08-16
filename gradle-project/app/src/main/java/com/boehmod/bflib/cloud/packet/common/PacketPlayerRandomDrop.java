package com.boehmod.bflib.cloud.packet.common;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/PacketPlayerRandomDrop.class */
public final class PacketPlayerRandomDrop extends Record implements IPacket {

    @NotNull
    private final UUID uuid;

    @Nullable
    private final UUID matchUUID;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f33ID = new PacketIdentifier("PacketPlayerDataRandomDrop");

    public PacketPlayerRandomDrop(@NotNull UUID uuid, @Nullable UUID matchUUID) {
        this.uuid = uuid;
        this.matchUUID = matchUUID;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketPlayerRandomDrop.class), PacketPlayerRandomDrop.class, "uuid;matchUUID", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketPlayerRandomDrop;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketPlayerRandomDrop;->matchUUID:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketPlayerRandomDrop.class), PacketPlayerRandomDrop.class, "uuid;matchUUID", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketPlayerRandomDrop;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketPlayerRandomDrop;->matchUUID:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketPlayerRandomDrop.class, Object.class), PacketPlayerRandomDrop.class, "uuid;matchUUID", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketPlayerRandomDrop;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketPlayerRandomDrop;->matchUUID:Ljava/util/UUID;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID uuid() {
        return this.uuid;
    }

    @Nullable
    public UUID matchUUID() {
        return this.matchUUID;
    }

    public PacketPlayerRandomDrop(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readUUIDOptional(byteBuffer).orElse(null));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.uuid);
        IPacket.writeOptionalUUID(byteBuffer, this.matchUUID);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f33ID;
    }
}
