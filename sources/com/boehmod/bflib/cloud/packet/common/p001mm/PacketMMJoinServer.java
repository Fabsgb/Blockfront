package com.boehmod.bflib.cloud.packet.common.p001mm;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.net.InetSocketAddress;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/mm/PacketMMJoinServer.class */
public final class PacketMMJoinServer extends Record implements IPacket {

    @NotNull
    private final InetSocketAddress address;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f63ID = new PacketIdentifier("PacketMMJoinServer");

    public PacketMMJoinServer(@NotNull InetSocketAddress address) {
        this.address = address;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketMMJoinServer.class), PacketMMJoinServer.class, "address", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMJoinServer;->address:Ljava/net/InetSocketAddress;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketMMJoinServer.class), PacketMMJoinServer.class, "address", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMJoinServer;->address:Ljava/net/InetSocketAddress;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketMMJoinServer.class, Object.class), PacketMMJoinServer.class, "address", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMJoinServer;->address:Ljava/net/InetSocketAddress;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public InetSocketAddress address() {
        return this.address;
    }

    public PacketMMJoinServer(@NotNull ByteBuf byteBuffer) {
        this(IPacket.readInetSocketAddress(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeInetSocketAddress(byteBuffer, this.address);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f63ID;
    }
}
