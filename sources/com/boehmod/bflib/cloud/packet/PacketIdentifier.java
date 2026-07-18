package com.boehmod.bflib.cloud.packet;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/PacketIdentifier.class */
public final class PacketIdentifier extends Record {

    @NotNull
    private final String identifier;
    private final int hash;
    public static final String HASH_ALGORITHM = "SHA-256";

    public PacketIdentifier(@NotNull String identifier, int hash) {
        this.identifier = identifier;
        this.hash = hash;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketIdentifier.class), PacketIdentifier.class, "identifier;hash", "FIELD:Lcom/boehmod/bflib/cloud/packet/PacketIdentifier;->identifier:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/PacketIdentifier;->hash:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketIdentifier.class), PacketIdentifier.class, "identifier;hash", "FIELD:Lcom/boehmod/bflib/cloud/packet/PacketIdentifier;->identifier:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/PacketIdentifier;->hash:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketIdentifier.class, Object.class), PacketIdentifier.class, "identifier;hash", "FIELD:Lcom/boehmod/bflib/cloud/packet/PacketIdentifier;->identifier:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/PacketIdentifier;->hash:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public String identifier() {
        return this.identifier;
    }

    public int hash() {
        return this.hash;
    }

    public PacketIdentifier(@NotNull String identifier) {
        this(identifier, computeHash(identifier));
    }

    private static int computeHash(@NotNull String identifier) {
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] hash = digest.digest(identifier.getBytes(StandardCharsets.UTF_8));
            return bytesToInt(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to compute hash for identifier", e);
        }
    }

    private static int bytesToInt(byte[] bytes) {
        int bound = Math.min(bytes.length, 4);
        int result = 0;
        for (int i = 0; i < bound; i++) {
            result = (result << 8) | (bytes[i] & 255);
        }
        return result;
    }
}
