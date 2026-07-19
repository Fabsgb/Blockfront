package com.boehmod.bflib.cloud.encryption;

import com.boehmod.bflib.cloud.encryption.EncryptionUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/encryption/AESEncryptionHandler.class */
public class AESEncryptionHandler extends MessageToByteEncoder<ByteBuf> {

    @NotNull
    private static final Logger LOGGER = LogManager.getLogger("AESEncryption");

    @NotNull
    private final SecretKey secretKey;

    @NotNull
    private final EncryptionUtils.IVCounter ivCounter;
    private boolean encryptionActive = false;

    @NotNull
    private final Cipher cipher = EncryptionUtils.createAESGCMCipherInstance();

    public AESEncryptionHandler(@NotNull SecretKey secretKey, boolean isServer) throws GeneralSecurityException {
        this.secretKey = secretKey;
        this.ivCounter = new EncryptionUtils.IVCounter(isServer);
    }

    public void activateEncryption() {
        this.encryptionActive = true;
        LOGGER.debug("Encryption activated");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void encode(ChannelHandlerContext ctx, @NotNull ByteBuf msg, @NotNull ByteBuf out) throws Exception {
        if (!this.encryptionActive) {
            out.writeBytes(msg);
            return;
        }
        try {
            byte[] iv = this.ivCounter.nextIV();
            EncryptionUtils.initAESGCMCipher(this.cipher, 1, this.secretKey, iv);
            byte[] plaintext = new byte[msg.readableBytes()];
            msg.readBytes(plaintext);
            byte[] ciphertext = this.cipher.doFinal(plaintext);
            out.writeByte(iv.length);
            out.writeBytes(iv);
            out.writeBytes(ciphertext);
        } catch (Exception e) {
            LOGGER.error("Encryption failed", e);
            throw e;
        }
    }

    public void exceptionCaught(@NotNull ChannelHandlerContext ctx, Throwable cause) {
        LOGGER.error("Encryption handler exception", cause);
        ctx.close();
    }
}
