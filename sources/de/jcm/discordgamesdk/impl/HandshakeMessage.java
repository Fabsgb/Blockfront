package de.jcm.discordgamesdk.impl;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/HandshakeMessage.class */
public class HandshakeMessage {

    /* JADX INFO: renamed from: v */
    private final int f8718v;
    private final String client_id;

    public int getVersion() {
        return this.f8718v;
    }

    public String getClientID() {
        return this.client_id;
    }

    public HandshakeMessage(String client_id) {
        this.f8718v = 1;
        this.client_id = client_id;
    }

    public HandshakeMessage(int version, String client_id) {
        this.f8718v = version;
        this.client_id = client_id;
    }
}
