package com.boehmod.bflib.cloud.connection;

import com.boehmod.bflib.cloud.common.ConnectionType;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.common.PatternReferences;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/connection/ConnectionCredentials.class */
public class ConnectionCredentials {

    @NotNull
    private final ConnectionType connectionType;

    @NotNull
    private final UUID uuid;

    @NotNull
    private final String username;

    @NotNull
    private final String version;

    @NotNull
    private final String versionHash;
    private final byte[] hardwareId;

    public ConnectionCredentials(@NotNull ConnectionType connectionType, @NotNull UUID uuid, @NotNull String username, @NotNull String version, @NotNull String versionHash, byte[] hardwareId) {
        if (!PatternReferences.MINECRAFT_USERNAME.matcher(username).matches()) {
            throw new IllegalArgumentException("Username cannot exceed 16 characters. ('" + username + "')");
        }
        this.connectionType = connectionType;
        this.uuid = uuid;
        this.username = username;
        this.version = version;
        this.versionHash = versionHash;
        this.hardwareId = hardwareId;
    }

    public ConnectionCredentials(@NotNull ByteBuf byteBuffer) throws IOException {
        this((ConnectionType) IPacket.readEnum(byteBuffer, ConnectionType.class), IPacket.readUUID(byteBuffer), IPacket.readString(byteBuffer), IPacket.readString(byteBuffer), IPacket.readString(byteBuffer), IPacket.readByteArray(byteBuffer));
    }

    public void writeCredentials(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeEnum(byteBuffer, this.connectionType);
        IPacket.writeUUID(byteBuffer, this.uuid);
        IPacket.writeString(byteBuffer, this.username);
        IPacket.writeString(byteBuffer, this.version);
        IPacket.writeString(byteBuffer, this.versionHash);
        IPacket.writeByteArray(byteBuffer, this.hardwareId);
    }

    @NotNull
    public ConnectionType getConnectionType() {
        return this.connectionType;
    }

    public byte[] getHardwareId() {
        return this.hardwareId;
    }

    @NotNull
    public String getUsername() {
        return this.username;
    }

    @NotNull
    public UUID getUuid() {
        return this.uuid;
    }

    @NotNull
    public String getVersion() {
        return this.version;
    }

    @NotNull
    public String getVersionHash() {
        return this.versionHash;
    }
}
