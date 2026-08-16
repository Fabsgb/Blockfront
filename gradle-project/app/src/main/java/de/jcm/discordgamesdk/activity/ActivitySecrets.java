package de.jcm.discordgamesdk.activity;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/activity/ActivitySecrets.class */
public class ActivitySecrets {
    private String match;
    private String join;
    private String spectate;

    public void setMatchSecret(String secret) {
        this.match = secret;
    }

    public String getMatchSecret() {
        return this.match;
    }

    public void setJoinSecret(String secret) {
        this.join = secret;
    }

    public String getJoinSecret() {
        return this.join;
    }

    public void setSpectateSecret(String secret) {
        this.spectate = secret;
    }

    public String getSpectateSecret() {
        return this.spectate;
    }
}
