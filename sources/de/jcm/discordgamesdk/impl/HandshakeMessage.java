package de.jcm.discordgamesdk.impl;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/HandshakeMessage.class */
public class HandshakeMessage {

    /* JADX INFO: renamed from: v */
    private final int f9104v;
    private final String client_id;

    public int getVersion() {
        return this.f9104v;
    }

    public String getClientID() {
        return this.client_id;
    }

    public HandshakeMessage(String client_id) {
        this.f9104v = 1;
        this.client_id = client_id;
    }

    public HandshakeMessage(int version, String client_id) {
        this.f9104v = version;
        this.client_id = client_id;
    }
}
