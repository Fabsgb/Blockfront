package com.boehmod.bflib.cloud.packet.common.p001mm;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/mm/PacketMMPlayerSuspicious.class */
public final class PacketMMPlayerSuspicious extends Record implements IPacket {

    @NotNull
    private final UUID playerUUID;

    @NotNull
    private final String message;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f67ID = new PacketIdentifier("PacketMMPlayerSuspicious");

    public PacketMMPlayerSuspicious(@NotNull UUID playerUUID, @NotNull String message) {
        this.playerUUID = playerUUID;
        this.message = message;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketMMPlayerSuspicious.class), PacketMMPlayerSuspicious.class, "playerUUID;message", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMPlayerSuspicious;->playerUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMPlayerSuspicious;->message:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketMMPlayerSuspicious.class), PacketMMPlayerSuspicious.class, "playerUUID;message", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMPlayerSuspicious;->playerUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMPlayerSuspicious;->message:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketMMPlayerSuspicious.class, Object.class), PacketMMPlayerSuspicious.class, "playerUUID;message", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMPlayerSuspicious;->playerUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMPlayerSuspicious;->message:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID playerUUID() {
        return this.playerUUID;
    }

    @NotNull
    public String message() {
        return this.message;
    }

    public PacketMMPlayerSuspicious(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readString(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.playerUUID);
        IPacket.writeString(byteBuffer, this.message);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f67ID;
    }
}
