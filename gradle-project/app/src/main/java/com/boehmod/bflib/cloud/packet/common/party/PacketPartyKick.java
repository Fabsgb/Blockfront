package com.boehmod.bflib.cloud.packet.common.party;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/party/PacketPartyKick.class */
public final class PacketPartyKick extends Record implements IPacket {

    @NotNull
    private final UUID uuid;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketPartyKick");

    public PacketPartyKick(@NotNull UUID uuid) {
        this.uuid = uuid;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketPartyKick.class), PacketPartyKick.class, "uuid", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/party/PacketPartyKick;->uuid:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketPartyKick.class), PacketPartyKick.class, "uuid", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/party/PacketPartyKick;->uuid:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketPartyKick.class, Object.class), PacketPartyKick.class, "uuid", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/party/PacketPartyKick;->uuid:Ljava/util/UUID;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID uuid() {
        return this.uuid;
    }

    public PacketPartyKick(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.uuid);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
