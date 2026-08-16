package de.jcm.discordgamesdk.impl.channel;

import de.jcm.discordgamesdk.GameSDKException;
import de.jcm.discordgamesdk.Result;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/channel/NoSuchInstanceException.class */
public class NoSuchInstanceException extends GameSDKException {

    /* JADX INFO: renamed from: i */
    private int f9105i;

    public NoSuchInstanceException(int i) {
        super(Result.NOT_RUNNING);
        this.f9105i = i;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "no such instance: " + this.f9105i;
    }
}
