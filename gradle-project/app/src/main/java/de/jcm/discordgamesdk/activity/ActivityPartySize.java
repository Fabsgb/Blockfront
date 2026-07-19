package de.jcm.discordgamesdk.activity;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/activity/ActivityPartySize.class */
public class ActivityPartySize {
    private final int[] size;

    ActivityPartySize(int[] size) {
        this.size = size;
    }

    public void setCurrentSize(int size) {
        this.size[0] = size;
    }

    public int getCurrentSize() {
        return this.size[0];
    }

    public void setMaxSize(int size) {
        this.size[1] = size;
    }

    public int getMaxSize() {
        return this.size[1];
    }

    public String toString() {
        return "ActivityPartySize{currentSize=" + this.size[0] + ", maxSize=" + this.size[1] + "}";
    }
}
