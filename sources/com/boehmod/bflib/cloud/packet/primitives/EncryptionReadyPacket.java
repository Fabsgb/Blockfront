package com.boehmod.bflib.cloud.packet.primitives;

import com.boehmod.bflib.cloud.connection.Connection;
import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.cloud.connection.ConnectionStatusContext;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/primitives/EncryptionReadyPacket.class */
public final class EncryptionReadyPacket implements IPacket {

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f107ID = new PacketIdentifier("EncryptionReadyPacket");

    public EncryptionReadyPacket() {
    }

    public EncryptionReadyPacket(@NotNull ByteBuf byteBuffer) {
    }

    public static void handle(@NotNull EncryptionReadyPacket packet, @NotNull Connection<?> connectionHandler) {
        connectionHandler.setStatus(ConnectionStatus.CONNECTED_NOT_VERIFIED, ConnectionStatusContext.CLOUD);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f107ID;
    }
}
