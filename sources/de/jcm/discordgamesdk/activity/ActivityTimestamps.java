package de.jcm.discordgamesdk.activity;

import java.time.Instant;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/activity/ActivityTimestamps.class */
public class ActivityTimestamps {
    private Long start;
    private Long end;

    public void setStart(Instant start) {
        this.start = Long.valueOf(start.getEpochSecond());
    }

    public Instant getStart() {
        return Instant.ofEpochSecond(this.start.longValue());
    }

    public void setEnd(Instant end) {
        this.end = Long.valueOf(end.getEpochSecond());
    }

    public Instant getEnd() {
        return Instant.ofEpochSecond(this.end.longValue());
    }

    public void setStartAndEnd(Instant start, Instant end) {
        this.start = Long.valueOf(start.getEpochSecond());
        this.end = Long.valueOf(end.getEpochSecond());
    }

    public void clearStart() {
        this.start = null;
    }

    public void clearEnd() {
        this.end = null;
    }

    public void clear() {
        this.start = null;
        this.end = null;
    }
}
