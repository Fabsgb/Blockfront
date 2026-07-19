package com.boehmod.bflib.cloud.encryption;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.net.SocketException;
import java.security.GeneralSecurityException;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/encryption/AESDecryptionHandler.class */
public class AESDecryptionHandler extends ByteToMessageDecoder {

    @NotNull
    private static final Logger LOGGER = LogManager.getLogger("AESDecryption");
    private static final int GCM_TAG_LENGTH = 16;

    @NotNull
    private final SecretKey secretKey;
    private boolean decryptionActive = false;

    @NotNull
    private final Cipher cipher = EncryptionUtils.createAESGCMCipherInstance();

    public AESDecryptionHandler(@NotNull SecretKey secretKey) throws GeneralSecurityException {
        this.secretKey = secretKey;
    }

    public void activateDecryption() {
        this.decryptionActive = true;
        LOGGER.debug("Decryption activated");
    }

    protected void decode(@NotNull ChannelHandlerContext ctx, @NotNull ByteBuf in, @NotNull List<Object> out) throws Exception {
        if (!this.decryptionActive) {
            if (in.readableBytes() > 0) {
                out.add(in.readBytes(in.readableBytes()));
                return;
            }
            return;
        }
        if (in.readableBytes() < 1) {
            return;
        }
        in.markReaderIndex();
        int ivLength = in.readByte() & 255;
        if (ivLength != 12) {
            LOGGER.error("Invalid IV length: {}", Integer.valueOf(ivLength));
            in.skipBytes(in.readableBytes());
            ctx.close();
        } else {
            if (in.readableBytes() < ivLength + 16) {
                in.resetReaderIndex();
                return;
            }
            try {
                byte[] iv = new byte[ivLength];
                in.readBytes(iv);
                byte[] ciphertext = new byte[in.readableBytes()];
                in.readBytes(ciphertext);
                EncryptionUtils.initAESGCMCipher(this.cipher, 2, this.secretKey, iv);
                byte[] plaintext = this.cipher.doFinal(ciphertext);
                out.add(ctx.alloc().buffer(plaintext.length).writeBytes(plaintext));
            } catch (Exception e) {
                LOGGER.error("Decryption failed", e);
                ctx.close();
                throw e;
            }
        }
    }

    public void exceptionCaught(@NotNull ChannelHandlerContext ctx, Throwable cause) {
        if (cause instanceof SocketException) {
            LOGGER.warn("Failed to process decryption handler. ({})", cause.getMessage());
        } else {
            LOGGER.error("Decryption handler exception", cause);
        }
        ctx.close();
    }
}
