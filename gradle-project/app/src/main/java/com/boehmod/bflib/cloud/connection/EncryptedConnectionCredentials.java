package com.boehmod.bflib.cloud.connection;

import com.boehmod.bflib.cloud.common.ConnectionType;
import com.boehmod.bflib.cloud.encryption.EncryptionUtils;
import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/connection/EncryptedConnectionCredentials.class */
public class EncryptedConnectionCredentials extends ConnectionCredentials {

    @Nullable
    private final PublicKey clientPublicKey;
    private final boolean encryptionEnabled;

    public EncryptedConnectionCredentials(@NotNull ConnectionType connectionType, @NotNull UUID uuid, @NotNull String username, @NotNull String version, @NotNull String versionHash, byte[] hardwareId, @Nullable PublicKey clientPublicKey) {
        super(connectionType, uuid, username, version, versionHash, hardwareId);
        this.clientPublicKey = clientPublicKey;
        this.encryptionEnabled = clientPublicKey != null;
    }

    public EncryptedConnectionCredentials(@NotNull ByteBuf byteBuffer) throws IOException {
        super(byteBuffer);
        this.encryptionEnabled = byteBuffer.readBoolean();
        if (this.encryptionEnabled) {
            byte[] publicKeyBytes = IPacket.readByteArray(byteBuffer);
            try {
                this.clientPublicKey = EncryptionUtils.decodePublicKey(publicKeyBytes);
                return;
            } catch (GeneralSecurityException e) {
                throw new IOException("Failed to decode client public key", e);
            }
        }
        this.clientPublicKey = null;
    }

    @Override // com.boehmod.bflib.cloud.connection.ConnectionCredentials
    public void writeCredentials(@NotNull ByteBuf byteBuffer) throws IOException {
        super.writeCredentials(byteBuffer);
        byteBuffer.writeBoolean(this.encryptionEnabled);
        if (this.encryptionEnabled && this.clientPublicKey != null) {
            byte[] publicKeyBytes = EncryptionUtils.encodePublicKey(this.clientPublicKey);
            IPacket.writeByteArray(byteBuffer, publicKeyBytes);
        }
    }

    @Nullable
    public PublicKey getClientPublicKey() {
        return this.clientPublicKey;
    }

    public boolean isEncryptionEnabled() {
        return this.encryptionEnabled;
    }
}
