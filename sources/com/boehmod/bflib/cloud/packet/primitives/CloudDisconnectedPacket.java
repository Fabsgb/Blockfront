package com.boehmod.bflib.cloud.packet.primitives;

import com.boehmod.bflib.cloud.connection.Connection;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/primitives/CloudDisconnectedPacket.class */
public final class CloudDisconnectedPacket extends Record implements IPacket {

    @NotNull
    private final String reason;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f104ID = new PacketIdentifier("CloudDisconnectedPacket");

    public CloudDisconnectedPacket(@NotNull String reason) {
        this.reason = reason;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, CloudDisconnectedPacket.class), CloudDisconnectedPacket.class, "reason", "FIELD:Lcom/boehmod/bflib/cloud/packet/primitives/CloudDisconnectedPacket;->reason:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, CloudDisconnectedPacket.class), CloudDisconnectedPacket.class, "reason", "FIELD:Lcom/boehmod/bflib/cloud/packet/primitives/CloudDisconnectedPacket;->reason:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, CloudDisconnectedPacket.class, Object.class), CloudDisconnectedPacket.class, "reason", "FIELD:Lcom/boehmod/bflib/cloud/packet/primitives/CloudDisconnectedPacket;->reason:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public String reason() {
        return this.reason;
    }

    public CloudDisconnectedPacket(@NotNull ByteBuf byteBuffer) {
        this(IPacket.readString(byteBuffer));
    }

    public static void handle(@NotNull CloudDisconnectedPacket packet, @NotNull Connection<?> connectionHandler) {
        connectionHandler.disconnect("From Cloud: '" + packet.reason + "'", false);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeString(byteBuffer, this.reason);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f104ID;
    }
}
