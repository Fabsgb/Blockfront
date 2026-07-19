package de.jcm.discordgamesdk.impl.channel;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/channel/DiscordChannel.class */
public interface DiscordChannel {
    void close() throws IOException;

    void configureBlocking(boolean z) throws IOException;

    int read(ByteBuffer byteBuffer) throws IOException;

    long read(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException;

    int write(ByteBuffer byteBuffer) throws IOException;

    boolean isAvailable();
}
