package de.jcm.discordgamesdk;

import de.jcm.discordgamesdk.user.DiscordUser;
import de.jcm.discordgamesdk.user.Relationship;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/DiscordEventHandler.class */
public class DiscordEventHandler extends DiscordEventAdapter {
    private final List<DiscordEventAdapter> listeners = new CopyOnWriteArrayList();

    public void addListener(DiscordEventAdapter listener) {
        this.listeners.add(listener);
    }

    public boolean removeListener(DiscordEventAdapter listener) {
        return this.listeners.remove(listener);
    }

    public void removeAllListeners() {
        this.listeners.clear();
    }

    @Override // de.jcm.discordgamesdk.DiscordEventAdapter
    public void onActivityJoin(String secret) {
        this.listeners.forEach(l -> {
            l.onActivityJoin(secret);
        });
    }

    @Override // de.jcm.discordgamesdk.DiscordEventAdapter
    public void onActivitySpectate(String secret) {
        this.listeners.forEach(l -> {
            l.onActivitySpectate(secret);
        });
    }

    @Override // de.jcm.discordgamesdk.DiscordEventAdapter
    public void onActivityJoinRequest(DiscordUser user) {
        this.listeners.forEach(l -> {
            l.onActivityJoinRequest(user);
        });
    }

    @Override // de.jcm.discordgamesdk.DiscordEventAdapter
    public void onCurrentUserUpdate() {
        this.listeners.forEach((v0) -> {
            v0.onCurrentUserUpdate();
        });
    }

    @Override // de.jcm.discordgamesdk.DiscordEventAdapter
    public void onOverlayToggle(boolean locked) {
        this.listeners.forEach(l -> {
            l.onOverlayToggle(locked);
        });
    }

    @Override // de.jcm.discordgamesdk.DiscordEventAdapter
    public void onRelationshipRefresh() {
        this.listeners.forEach((v0) -> {
            v0.onRelationshipRefresh();
        });
    }

    @Override // de.jcm.discordgamesdk.DiscordEventAdapter
    public void onRelationshipUpdate(Relationship relationship) {
        this.listeners.forEach(l -> {
            l.onRelationshipUpdate(relationship);
        });
    }
}
