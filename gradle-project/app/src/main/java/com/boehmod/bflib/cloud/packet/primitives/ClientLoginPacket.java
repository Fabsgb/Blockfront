package com.boehmod.bflib.cloud.packet.primitives;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/primitives/ClientLoginPacket.class */
public final class ClientLoginPacket extends Record implements IPacket {

    @NotNull
    private final String token;
    private final int port;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("ClientLoginPacket");

    public ClientLoginPacket(@NotNull String token, int port) {
        this.token = token;
        this.port = port;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ClientLoginPacket.class), ClientLoginPacket.class, "token;port", "FIELD:Lcom/boehmod/bflib/cloud/packet/primitives/ClientLoginPacket;->token:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/primitives/ClientLoginPacket;->port:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ClientLoginPacket.class), ClientLoginPacket.class, "token;port", "FIELD:Lcom/boehmod/bflib/cloud/packet/primitives/ClientLoginPacket;->token:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/primitives/ClientLoginPacket;->port:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ClientLoginPacket.class, Object.class), ClientLoginPacket.class, "token;port", "FIELD:Lcom/boehmod/bflib/cloud/packet/primitives/ClientLoginPacket;->token:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/primitives/ClientLoginPacket;->port:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public String token() {
        return this.token;
    }

    public int port() {
        return this.port;
    }

    public ClientLoginPacket(@NotNull ByteBuf byteBuffer) {
        this(IPacket.readString(byteBuffer), byteBuffer.readInt());
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeString(byteBuffer, this.token);
        byteBuffer.writeInt(this.port);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
