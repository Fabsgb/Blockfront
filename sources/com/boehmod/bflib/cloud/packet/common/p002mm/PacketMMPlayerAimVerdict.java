package com.boehmod.bflib.cloud.packet.common.p002mm;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/mm/PacketMMPlayerAimVerdict.class */
public final class PacketMMPlayerAimVerdict extends Record implements IPacket {

    @NotNull
    private final UUID playerUUID;

    @NotNull
    private final String summary;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f69ID = new PacketIdentifier("PacketMMPlayerAimVerdict");

    public PacketMMPlayerAimVerdict(@NotNull UUID playerUUID, @NotNull String summary) {
        this.playerUUID = playerUUID;
        this.summary = summary;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketMMPlayerAimVerdict.class), PacketMMPlayerAimVerdict.class, "playerUUID;summary", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMPlayerAimVerdict;->playerUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMPlayerAimVerdict;->summary:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketMMPlayerAimVerdict.class), PacketMMPlayerAimVerdict.class, "playerUUID;summary", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMPlayerAimVerdict;->playerUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMPlayerAimVerdict;->summary:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketMMPlayerAimVerdict.class, Object.class), PacketMMPlayerAimVerdict.class, "playerUUID;summary", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMPlayerAimVerdict;->playerUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMPlayerAimVerdict;->summary:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID playerUUID() {
        return this.playerUUID;
    }

    @NotNull
    public String summary() {
        return this.summary;
    }

    public PacketMMPlayerAimVerdict(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readString(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.playerUUID);
        IPacket.writeString(byteBuffer, this.summary);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f69ID;
    }
}
