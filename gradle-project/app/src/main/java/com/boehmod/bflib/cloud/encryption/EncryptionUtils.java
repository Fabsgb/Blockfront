package com.boehmod.bflib.cloud.encryption;

import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.atomic.AtomicLong;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/encryption/EncryptionUtils.class */
public class EncryptionUtils {

    @NotNull
    private static final String EC_CURVE = "secp256r1";

    @NotNull
    private static final String KEY_PAIR_ALGORITHM = "EC";
    private static final int GCM_TAG_LENGTH = 128;
    public static final int GCM_IV_LENGTH = 12;

    @NotNull
    public static final String CIPHER_TRANSFORMATION = "AES/GCM/NoPadding";

    @NotNull
    public static final String KEY_AGREEMENT_ALGORITHM = "ECDH";
    public static final int ID_SERVER = 1397904978;
    public static final int ID_CLIENT = 1129074260;

    @NotNull
    public static final String PIPELINE_DECRYPTION = "decryption";

    @NotNull
    public static final String PIPELINE_ENCRYPTION = "encryption";

    @NotNull
    public static KeyPair generateECDHKeyPair() throws GeneralSecurityException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_PAIR_ALGORITHM);
        ECGenParameterSpec ecSpec = new ECGenParameterSpec(EC_CURVE);
        keyPairGenerator.initialize(ecSpec, new SecureRandom());
        return keyPairGenerator.generateKeyPair();
    }

    @NotNull
    public static SecretKey deriveSharedSecret(@NotNull PrivateKey privateKey, @NotNull PublicKey publicKey) throws GeneralSecurityException {
        KeyAgreement keyAgreement = KeyAgreement.getInstance(KEY_AGREEMENT_ALGORITHM);
        keyAgreement.init(privateKey);
        keyAgreement.doPhase(publicKey, true);
        byte[] sharedSecret = keyAgreement.generateSecret();
        MessageDigest sha256 = MessageDigest.getInstance(PacketIdentifier.HASH_ALGORITHM);
        byte[] aesKeyBytes = sha256.digest(sharedSecret);
        return new SecretKeySpec(aesKeyBytes, "AES");
    }

    public static byte[] encodePublicKey(@NotNull PublicKey publicKey) {
        return publicKey.getEncoded();
    }

    @NotNull
    public static PublicKey decodePublicKey(byte[] encodedKey) throws GeneralSecurityException {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_PAIR_ALGORITHM);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encodedKey);
        return keyFactory.generatePublic(keySpec);
    }

    @NotNull
    public static Cipher createAESGCMCipher(int mode, @NotNull SecretKey key, byte[] iv, int gcmTagLength, @NotNull String cipherTransformation) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(cipherTransformation);
        GCMParameterSpec gcmSpec = new GCMParameterSpec(gcmTagLength, iv);
        cipher.init(mode, key, gcmSpec);
        return cipher;
    }

    @NotNull
    public static Cipher createAESGCMCipher(int mode, @NotNull SecretKey key, byte[] iv) throws GeneralSecurityException {
        return createAESGCMCipher(mode, key, iv, 128, CIPHER_TRANSFORMATION);
    }

    @NotNull
    public static Cipher createAESGCMCipherInstance() throws GeneralSecurityException {
        return Cipher.getInstance(CIPHER_TRANSFORMATION);
    }

    public static void initAESGCMCipher(@NotNull Cipher cipher, int mode, @NotNull SecretKey key, byte[] iv) throws GeneralSecurityException {
        GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);
        cipher.init(mode, key, gcmSpec);
    }

    @NotNull
    public static byte[] generateIV(long counter, boolean isServer, int ivLength) {
        ByteBuffer iv = ByteBuffer.allocate(ivLength);
        iv.putInt(isServer ? ID_CLIENT : ID_SERVER);
        iv.putLong(counter);
        return iv.array();
    }

    @NotNull
    public static byte[] generateIV(long counter, boolean isServer) {
        return generateIV(counter, isServer, 12);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/encryption/EncryptionUtils$IVCounter.class */
    public static class IVCounter {

        @NotNull
        private final AtomicLong counter = new AtomicLong(0);
        private final boolean isServer;

        public IVCounter(boolean isServer) {
            this.isServer = isServer;
        }

        public byte[] nextIV() {
            return EncryptionUtils.generateIV(this.counter.incrementAndGet(), this.isServer, 12);
        }
    }
}
