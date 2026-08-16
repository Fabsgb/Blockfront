package de.jcm.discordgamesdk;

import de.jcm.discordgamesdk.user.DiscordUser;
import de.jcm.discordgamesdk.user.Relationship;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/DiscordEventAdapter.class */
public abstract class DiscordEventAdapter {
    public void onActivityJoin(String secret) {
    }

    public void onActivitySpectate(String secret) {
    }

    public void onActivityJoinRequest(DiscordUser user) {
    }

    public void onCurrentUserUpdate() {
    }

    public void onOverlayToggle(boolean locked) {
    }

    public void onRelationshipRefresh() {
    }

    public void onRelationshipUpdate(Relationship relationship) {
    }
}
