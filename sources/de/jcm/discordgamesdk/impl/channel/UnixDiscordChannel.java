package de.jcm.discordgamesdk.impl.channel;

import java.io.File;
import java.io.IOException;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/channel/UnixDiscordChannel.class */
public class UnixDiscordChannel implements DiscordChannel {
    private final SocketChannel channel;
    private String path;

    private static String[] getSockets() {
        List<String> candidates = new ArrayList<>();
        candidates.add(System.getenv("XDG_RUNTIME_DIR"));
        candidates.add(System.getenv("TMPDIR"));
        candidates.add(System.getenv("TMP"));
        candidates.add(System.getenv("TEMP"));
        candidates.removeIf((v0) -> {
            return Objects.isNull(v0);
        });
        candidates.removeIf(p -> {
            return !new File(p).exists();
        });
        List<String> flatpakCandidates = candidates.stream().map(p2 -> {
            return p2 + "/app/com.discordapp.Discord";
        }).toList();
        List<String> snapCandidates = candidates.stream().map(p3 -> {
            return p3 + "/snap.discord";
        }).toList();
        List<String> additionalSnapCandidates = candidates.stream().flatMap(p4 -> {
            return Arrays.stream((File[]) Objects.requireNonNull(new File(p4).listFiles((file, name) -> {
                return name.startsWith("snap.discord_");
            }))).map((v0) -> {
                return v0.getAbsolutePath();
            });
        }).toList();
        candidates.addAll(flatpakCandidates);
        candidates.addAll(snapCandidates);
        candidates.addAll(additionalSnapCandidates);
        candidates.removeIf((v0) -> {
            return Objects.isNull(v0);
        });
        candidates.removeIf(p5 -> {
            return !new File(p5).exists();
        });
        return (String[]) candidates.stream().flatMap(p6 -> {
            return IntStream.iterate(0, x -> {
                return x + 1;
            }).mapToObj(i -> {
                return p6 + "/discord-ipc-" + i;
            }).takeWhile(pp -> {
                return new File(pp).exists();
            });
        }).toArray(x$0 -> {
            return new String[x$0];
        });
    }

    public UnixDiscordChannel() throws IOException {
        this.path = System.getenv("DISCORD_IPC_PATH");
        if (this.path == null) {
            String instance = System.getenv("DISCORD_INSTANCE_ID");
            int i = 0;
            i = instance != null ? Integer.parseInt(instance) : i;
            String[] sockets = getSockets();
            if (i < 0 || i >= sockets.length) {
                throw new NoSuchInstanceException(i);
            }
            this.path = sockets[i];
        }
        this.channel = SocketChannel.open(UnixDomainSocketAddress.of(this.path));
    }

    @Override // de.jcm.discordgamesdk.impl.channel.DiscordChannel
    public void close() throws IOException {
        this.channel.close();
    }

    @Override // de.jcm.discordgamesdk.impl.channel.DiscordChannel
    public void configureBlocking(boolean block) throws IOException {
        this.channel.configureBlocking(block);
    }

    @Override // de.jcm.discordgamesdk.impl.channel.DiscordChannel
    public boolean isAvailable() {
        return new File(this.path).exists() && this.channel.isConnected();
    }

    @Override // de.jcm.discordgamesdk.impl.channel.DiscordChannel
    public int read(ByteBuffer dst) throws IOException {
        return this.channel.read(dst);
    }

    @Override // de.jcm.discordgamesdk.impl.channel.DiscordChannel
    public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
        return this.channel.read(dsts, offset, length);
    }

    @Override // de.jcm.discordgamesdk.impl.channel.DiscordChannel
    public int write(ByteBuffer src) throws IOException {
        return this.channel.write(src);
    }
}
