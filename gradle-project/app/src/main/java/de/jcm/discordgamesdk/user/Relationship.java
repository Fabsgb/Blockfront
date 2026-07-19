package de.jcm.discordgamesdk.user;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/user/Relationship.class */
public class Relationship {
    private final RelationshipType type;
    private final DiscordUser user;
    private final Presence presence;

    public Relationship(RelationshipType type, DiscordUser user, Presence presence) {
        this.type = type;
        this.user = user;
        this.presence = presence;
    }

    public RelationshipType getType() {
        return this.type;
    }

    public DiscordUser getUser() {
        return this.user;
    }

    public Presence getPresence() {
        return this.presence;
    }

    public String toString() {
        return "Relationship{type=" + this.type + ", user=" + this.user + ", presence=" + this.presence + "}";
    }
}
