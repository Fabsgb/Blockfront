package com.boehmod.bflib.cloud.packet.primitives;

import com.boehmod.bflib.cloud.connection.Connection;
import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.cloud.connection.ConnectionStatusContext;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/primitives/CloudConnectionStatusPacket.class */
public final class CloudConnectionStatusPacket extends Record implements IPacket {

    @NotNull
    private final ConnectionStatus connectionStatus;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("CloudConnectionStatusPacket");

    public CloudConnectionStatusPacket(@NotNull ConnectionStatus connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, CloudConnectionStatusPacket.class), CloudConnectionStatusPacket.class, "connectionStatus", "FIELD:Lcom/boehmod/bflib/cloud/packet/primitives/CloudConnectionStatusPacket;->connectionStatus:Lcom/boehmod/bflib/cloud/connection/ConnectionStatus;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, CloudConnectionStatusPacket.class), CloudConnectionStatusPacket.class, "connectionStatus", "FIELD:Lcom/boehmod/bflib/cloud/packet/primitives/CloudConnectionStatusPacket;->connectionStatus:Lcom/boehmod/bflib/cloud/connection/ConnectionStatus;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, CloudConnectionStatusPacket.class, Object.class), CloudConnectionStatusPacket.class, "connectionStatus", "FIELD:Lcom/boehmod/bflib/cloud/packet/primitives/CloudConnectionStatusPacket;->connectionStatus:Lcom/boehmod/bflib/cloud/connection/ConnectionStatus;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public ConnectionStatus connectionStatus() {
        return this.connectionStatus;
    }

    public CloudConnectionStatusPacket(@NotNull ByteBuf byteBuffer) throws IOException {
        this((ConnectionStatus) IPacket.readEnum(byteBuffer, ConnectionStatus.class));
    }

    public static void handle(@NotNull CloudConnectionStatusPacket packet, @NotNull Connection<?> connectionHandler) {
        connectionHandler.setStatus(packet.connectionStatus, ConnectionStatusContext.CLOUD);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeEnum(byteBuffer, this.connectionStatus);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
