package de.jcm.discordgamesdk;

import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/CreateParams.class */
public class CreateParams implements AutoCloseable {
    long flags;
    long clientID;
    DiscordEventAdapter eventAdapter;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/CreateParams$Flags.class */
    public enum Flags {
        DEFAULT(0),
        NO_REQUIRE_DISCORD(1),
        SUPPRESS_EXCEPTIONS(3);

        private final long value;

        Flags(long value) {
            this.value = value;
        }

        public static long toLong(Flags... flags) {
            long l = 0;
            for (Flags f : flags) {
                l |= f.value;
            }
            return l;
        }

        public static Flags[] fromLong(long l) {
            return (Flags[]) Stream.of((Object[]) values()).filter(f -> {
                return (l & f.value) != 0;
            }).toArray(x$0 -> {
                return new Flags[x$0];
            });
        }
    }

    public void setClientID(long id) {
        this.clientID = id;
    }

    public long getClientID() {
        return this.clientID;
    }

    public void setFlags(Flags... flags) {
        setFlags(Flags.toLong(flags));
    }

    public void setFlags(long flags) {
        this.flags = flags;
    }

    public long getFlags() {
        return this.flags;
    }

    public void registerEventHandler(DiscordEventAdapter eventHandler) {
        this.eventAdapter = eventHandler;
    }

    public static long getDefaultFlags() {
        return Flags.DEFAULT.value;
    }

    @Override // java.lang.AutoCloseable
    @Deprecated
    public void close() {
    }
}
