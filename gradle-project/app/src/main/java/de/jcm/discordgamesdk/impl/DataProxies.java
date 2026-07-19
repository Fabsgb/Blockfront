package de.jcm.discordgamesdk.impl;

import de.jcm.discordgamesdk.activity.Activity;
import de.jcm.discordgamesdk.activity.ActivityType;
import de.jcm.discordgamesdk.user.DiscordUser;
import de.jcm.discordgamesdk.user.OnlineStatus;
import de.jcm.discordgamesdk.user.Presence;
import de.jcm.discordgamesdk.user.Relationship;
import de.jcm.discordgamesdk.user.RelationshipType;
import java.util.Optional;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/DataProxies.class */
public class DataProxies {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/DataProxies$EmojiImpl.class */
    public static class EmojiImpl {
        private String name;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/DataProxies$ActivityImpl.class */
    public static class ActivityImpl {
        private String created_at;
        private EmojiImpl emoji;
        private String id;
        private String name;
        private String state;
        private int type;

        public Activity toActivity() {
            Activity activity = new Activity();
            activity.setState(this.state);
            activity.setType(ActivityType.values()[this.type]);
            return activity;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/DataProxies$PresenceImpl.class */
    public static class PresenceImpl {
        private String status;
        private ActivityImpl activity;

        public Presence toPresence() {
            OnlineStatus onlineStatus;
            switch (this.status) {
                case "dnd":
                    onlineStatus = OnlineStatus.DO_NO_DISTURB;
                    break;
                case "idle":
                    onlineStatus = OnlineStatus.IDLE;
                    break;
                case "online":
                    onlineStatus = OnlineStatus.ONLINE;
                    break;
                default:
                    onlineStatus = OnlineStatus.OFFLINE;
                    break;
            }
            OnlineStatus s = onlineStatus;
            return new Presence(s, (Activity) Optional.ofNullable(this.activity).map((v0) -> {
                return v0.toActivity();
            }).orElse(null));
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/DataProxies$RelationshipImpl.class */
    public static class RelationshipImpl {
        public int type;
        public DiscordUser user;
        public PresenceImpl presence;

        public Relationship toRelationship() {
            return new Relationship(RelationshipType.values()[this.type], this.user, this.presence.toPresence());
        }
    }
}
