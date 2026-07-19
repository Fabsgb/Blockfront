package com.boehmod.bflib.cloud.packet.primitives;

import com.boehmod.bflib.cloud.encryption.EncryptionUtils;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/primitives/EncryptionKeyExchangePacket.class */
public final class EncryptionKeyExchangePacket extends Record implements IPacket {

    @NotNull
    private final PublicKey serverPublicKey;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("EncryptionKeyExchangePacket");

    public EncryptionKeyExchangePacket(@NotNull PublicKey serverPublicKey) {
        this.serverPublicKey = serverPublicKey;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, EncryptionKeyExchangePacket.class), EncryptionKeyExchangePacket.class, "serverPublicKey", "FIELD:Lcom/boehmod/bflib/cloud/packet/primitives/EncryptionKeyExchangePacket;->serverPublicKey:Ljava/security/PublicKey;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, EncryptionKeyExchangePacket.class), EncryptionKeyExchangePacket.class, "serverPublicKey", "FIELD:Lcom/boehmod/bflib/cloud/packet/primitives/EncryptionKeyExchangePacket;->serverPublicKey:Ljava/security/PublicKey;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, EncryptionKeyExchangePacket.class, Object.class), EncryptionKeyExchangePacket.class, "serverPublicKey", "FIELD:Lcom/boehmod/bflib/cloud/packet/primitives/EncryptionKeyExchangePacket;->serverPublicKey:Ljava/security/PublicKey;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public PublicKey serverPublicKey() {
        return this.serverPublicKey;
    }

    public EncryptionKeyExchangePacket(@NotNull ByteBuf byteBuffer) throws IOException {
        this(readPublicKey(byteBuffer));
    }

    @NotNull
    private static PublicKey readPublicKey(@NotNull ByteBuf byteBuffer) throws IOException {
        byte[] publicKeyBytes = IPacket.readByteArray(byteBuffer);
        try {
            return EncryptionUtils.decodePublicKey(publicKeyBytes);
        } catch (GeneralSecurityException e) {
            throw new IOException("Failed to decode server public key", e);
        }
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        byte[] publicKeyBytes = EncryptionUtils.encodePublicKey(this.serverPublicKey);
        IPacket.writeByteArray(byteBuffer, publicKeyBytes);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
