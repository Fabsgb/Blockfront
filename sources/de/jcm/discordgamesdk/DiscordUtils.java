package de.jcm.discordgamesdk;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/DiscordUtils.class */
public class DiscordUtils {
    private DiscordUtils() {
        throw new RuntimeException("DiscordUtils is a static class and no instance of it can be obtained.");
    }

    public static Consumer<Result> completer(CompletableFuture<Void> future) {
        return result -> {
            if (result == Result.OK) {
                future.complete(null);
            } else {
                future.completeExceptionally(new GameSDKException(result));
            }
        };
    }

    public static <T> BiConsumer<Result, T> returningCompleter(CompletableFuture<T> future) {
        return (result, t) -> {
            if (result == Result.OK) {
                future.complete(t);
            } else {
                future.completeExceptionally(new GameSDKException(result));
            }
        };
    }

    public static Instant dateTimeFromSnowflake(long snowflake) {
        long discordTime = snowflake >> 22;
        long unixTime = discordTime + 1420070400000L;
        return Instant.ofEpochMilli(unixTime);
    }
}
