package com.boehmod.bflib.cloud.encryption;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/encryption/AESDecryptionHandler.class */
public class AESDecryptionHandler extends ByteToMessageDecoder {

    @NotNull
    private static final Logger LOGGER = LogManager.getLogger("AESDecryption");
    private static final int GCM_TAG_LENGTH = 16;

    @NotNull
    private final SecretKey secretKey;
    private final int expectedIvPrefix;
    private long lastIvCounter = 0;
    private boolean decryptionActive = false;

    @NotNull
    private final Cipher cipher = EncryptionUtils.createAESGCMCipherInstance();

    public AESDecryptionHandler(@NotNull SecretKey secretKey, boolean isServer) throws GeneralSecurityException {
        this.secretKey = secretKey;
        this.expectedIvPrefix = isServer ? EncryptionUtils.ID_SERVER : EncryptionUtils.ID_CLIENT;
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
            return;
        }
        if (in.readableBytes() < ivLength + 16) {
            in.resetReaderIndex();
            return;
        }
        byte[] iv = new byte[ivLength];
        in.readBytes(iv);
        ByteBuffer ivBuffer = ByteBuffer.wrap(iv);
        int ivPrefix = ivBuffer.getInt();
        long ivCounter = ivBuffer.getLong();
        if (ivPrefix != this.expectedIvPrefix || ivCounter <= this.lastIvCounter) {
            LOGGER.error("Rejected IV with prefix '{}' and counter '{}' (expected prefix: '{}', last counter: '{}')", Integer.valueOf(ivPrefix), Long.valueOf(ivCounter), Integer.valueOf(this.expectedIvPrefix), Long.valueOf(this.lastIvCounter));
            in.skipBytes(in.readableBytes());
            ctx.close();
            return;
        }
        this.lastIvCounter = ivCounter;
        EncryptionUtils.initAESGCMCipher(this.cipher, 2, this.secretKey, iv);
        int ciphertextLength = in.readableBytes();
        ByteBuf plaintext = ctx.alloc().buffer(this.cipher.getOutputSize(ciphertextLength));
        try {
            ByteBuffer inputBuffer = in.nioBuffer(in.readerIndex(), ciphertextLength);
            ByteBuffer outputBuffer = plaintext.nioBuffer(plaintext.writerIndex(), plaintext.writableBytes());
            int written = this.cipher.doFinal(inputBuffer, outputBuffer);
            in.skipBytes(ciphertextLength);
            plaintext.writerIndex(plaintext.writerIndex() + written);
            if (LOGGER.isTraceEnabled()) {
                LOGGER.trace("Decrypted frame with IV counter {} ({} bytes)", Long.valueOf(ivCounter), Integer.valueOf(written));
            }
            out.add(plaintext);
        } catch (Exception e) {
            plaintext.release();
            LOGGER.error("Decryption failed", e);
            ctx.close();
            throw e;
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
