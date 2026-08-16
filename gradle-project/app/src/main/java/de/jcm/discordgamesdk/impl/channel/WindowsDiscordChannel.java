package de.jcm.discordgamesdk.impl.channel;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/channel/WindowsDiscordChannel.class */
public class WindowsDiscordChannel implements DiscordChannel {
    private final FileChannel channel;
    private boolean blocking = true;
    private String path;

    public WindowsDiscordChannel() throws IOException {
        this.path = System.getenv("DISCORD_IPC_PATH");
        if (this.path == null) {
            String instance = System.getenv("DISCORD_INSTANCE_ID");
            int i = 0;
            this.path = "\\\\.\\\\pipe\\\\discord-ipc-" + (instance != null ? Integer.parseInt(instance) : i);
        }
        RandomAccessFile raf = new RandomAccessFile(this.path, "rw");
        this.channel = raf.getChannel();
    }

    @Override // de.jcm.discordgamesdk.impl.channel.DiscordChannel
    public void close() throws IOException {
        this.channel.close();
    }

    @Override // de.jcm.discordgamesdk.impl.channel.DiscordChannel
    public void configureBlocking(boolean block) throws IOException {
        this.blocking = block;
    }

    @Override // de.jcm.discordgamesdk.impl.channel.DiscordChannel
    public boolean isAvailable() {
        return new File(this.path).exists() && this.channel.isOpen();
    }

    @Override // de.jcm.discordgamesdk.impl.channel.DiscordChannel
    public int read(ByteBuffer dst) throws IOException {
        int res = 0;
        if (this.blocking || this.channel.size() - this.channel.position() >= dst.remaining()) {
            res = this.channel.read(dst);
        }
        return res;
    }

    @Override // de.jcm.discordgamesdk.impl.channel.DiscordChannel
    public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
        long res = 0;
        long remaining = 0;
        for (int i = offset; !this.blocking && i < offset + length; i++) {
            remaining += (long) dsts[i].remaining();
        }
        if (this.blocking || this.channel.size() - this.channel.position() >= remaining) {
            res = this.channel.read(dsts, offset, length);
        }
        return res;
    }

    @Override // de.jcm.discordgamesdk.impl.channel.DiscordChannel
    public int write(ByteBuffer src) throws IOException {
        int res = this.channel.write(src);
        this.channel.force(false);
        return res;
    }
}
