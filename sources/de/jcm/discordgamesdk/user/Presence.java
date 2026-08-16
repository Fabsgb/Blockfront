package de.jcm.discordgamesdk.user;

import de.jcm.discordgamesdk.activity.Activity;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/user/Presence.class */
public class Presence {
    private final OnlineStatus status;
    private final Activity activity;

    public Presence(OnlineStatus status, Activity activity) {
        this.status = status;
        this.activity = activity;
    }

    public OnlineStatus getStatus() {
        return this.status;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public String toString() {
        return "Presence{status=" + this.status + ", activity=" + this.activity + "}";
    }
}
