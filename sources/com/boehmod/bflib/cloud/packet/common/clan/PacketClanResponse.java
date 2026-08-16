package com.boehmod.bflib.cloud.packet.common.clan;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/clan/PacketClanResponse.class */
public final class PacketClanResponse extends Record implements IPacket {

    @NotNull
    private final UUID clan;
    private final boolean response;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f45ID = new PacketIdentifier("PacketClanInviteResponse");

    public PacketClanResponse(@NotNull UUID clan, boolean response) {
        this.clan = clan;
        this.response = response;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketClanResponse.class), PacketClanResponse.class, "clan;response", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/clan/PacketClanResponse;->clan:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/clan/PacketClanResponse;->response:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketClanResponse.class), PacketClanResponse.class, "clan;response", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/clan/PacketClanResponse;->clan:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/clan/PacketClanResponse;->response:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketClanResponse.class, Object.class), PacketClanResponse.class, "clan;response", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/clan/PacketClanResponse;->clan:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/clan/PacketClanResponse;->response:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID clan() {
        return this.clan;
    }

    public boolean response() {
        return this.response;
    }

    public PacketClanResponse(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readBoolean(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.clan);
        IPacket.writeBoolean(byteBuffer, this.response);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f45ID;
    }
}
