package de.jcm.discordgamesdk.activity;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/activity/ActivityButton.class */
public class ActivityButton {
    private String label;
    private String url;

    public ActivityButton() {
    }

    public ActivityButton(String label, String url) {
        this.label = label;
        this.url = url;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
