package de.jcm.discordgamesdk.activity;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/activity/ActivityParty.class */
public class ActivityParty {

    /* JADX INFO: renamed from: id */
    private String f9101id;
    private int[] size = null;

    ActivityParty() {
    }

    public void setID(String id) {
        this.f9101id = id;
    }

    public String getID() {
        return this.f9101id;
    }

    public ActivityPartySize size() {
        if (this.size == null) {
            this.size = new int[2];
        }
        return new ActivityPartySize(this.size);
    }

    public String toString() {
        return "ActivityParty{id='" + this.f9101id + "', size=" + size() + "}";
    }
}
