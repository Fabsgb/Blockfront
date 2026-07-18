package de.jcm.discordgamesdk.impl.commands;

import de.jcm.discordgamesdk.ApplicationManager;
import de.jcm.discordgamesdk.user.DiscordUser;
import java.util.Date;
import java.util.Set;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/Authenticate.class */
public class Authenticate {
    private Authenticate() {
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/Authenticate$Response.class */
    public static class Response {
        public String access_token;
        public Set<String> scopes;
        public Date expires;
        public DiscordUser user;
        public Application application;

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/Authenticate$Response$Application.class */
        public static class Application {

            /* JADX INFO: renamed from: id */
            String f8720id;
            String name;
            String icon;
            String description;
            String type;
            String cover_image;
            String summary;
            boolean is_monetized;
            boolean is_verified;
            String verify_key;
            int flags;
            boolean hook;
            boolean storefront_available;

            public ApplicationManager.Application toApplication() {
                return new ApplicationManager.Application(Long.parseLong(this.f8720id), this.name, this.icon, this.description, this.type, this.cover_image, this.summary, this.is_monetized, this.is_verified, this.verify_key, this.flags, this.hook, this.storefront_available);
            }
        }

        public ApplicationManager.DiscordOAuth2Token toDiscordOAuth2Token() {
            return new ApplicationManager.DiscordOAuth2Token(this.access_token, this.scopes, this.expires);
        }
    }
}
