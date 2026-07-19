package de.jcm.discordgamesdk;

import de.jcm.discordgamesdk.Core;
import de.jcm.discordgamesdk.impl.Command;
import de.jcm.discordgamesdk.impl.commands.Authenticate;
import de.jcm.discordgamesdk.user.DiscordUser;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Date;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/ApplicationManager.class */
public class ApplicationManager {
    private final Core.CorePrivate core;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/ApplicationManager$DiscordOAuth2Token.class */
    public static final class DiscordOAuth2Token extends Record {
        private final String accessToken;
        private final Set<String> scopes;
        private final Date expires;

        public DiscordOAuth2Token(String accessToken, Set<String> scopes, Date expires) {
            this.accessToken = accessToken;
            this.scopes = scopes;
            this.expires = expires;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, DiscordOAuth2Token.class), DiscordOAuth2Token.class, "accessToken;scopes;expires", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$DiscordOAuth2Token;->accessToken:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$DiscordOAuth2Token;->scopes:Ljava/util/Set;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$DiscordOAuth2Token;->expires:Ljava/util/Date;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, DiscordOAuth2Token.class), DiscordOAuth2Token.class, "accessToken;scopes;expires", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$DiscordOAuth2Token;->accessToken:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$DiscordOAuth2Token;->scopes:Ljava/util/Set;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$DiscordOAuth2Token;->expires:Ljava/util/Date;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, DiscordOAuth2Token.class, Object.class), DiscordOAuth2Token.class, "accessToken;scopes;expires", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$DiscordOAuth2Token;->accessToken:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$DiscordOAuth2Token;->scopes:Ljava/util/Set;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$DiscordOAuth2Token;->expires:Ljava/util/Date;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public String accessToken() {
            return this.accessToken;
        }

        public Set<String> scopes() {
            return this.scopes;
        }

        public Date expires() {
            return this.expires;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/ApplicationManager$Application.class */
    public static final class Application extends Record {
        private final long id;
        private final String name;
        private final String icon;
        private final String description;
        private final String type;
        private final String coverImage;
        private final String summary;
        private final boolean monetized;
        private final boolean verified;
        private final String verifyKey;
        private final int flags;
        private final boolean hook;
        private final boolean storefrontAvailable;

        public Application(long id, String name, String icon, String description, String type, String coverImage, String summary, boolean monetized, boolean verified, String verifyKey, int flags, boolean hook, boolean storefrontAvailable) {
            this.id = id;
            this.name = name;
            this.icon = icon;
            this.description = description;
            this.type = type;
            this.coverImage = coverImage;
            this.summary = summary;
            this.monetized = monetized;
            this.verified = verified;
            this.verifyKey = verifyKey;
            this.flags = flags;
            this.hook = hook;
            this.storefrontAvailable = storefrontAvailable;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Application.class), Application.class, "id;name;icon;description;type;coverImage;summary;monetized;verified;verifyKey;flags;hook;storefrontAvailable", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->id:J", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->name:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->icon:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->description:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->type:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->coverImage:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->summary:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->monetized:Z", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->verified:Z", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->verifyKey:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->flags:I", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->hook:Z", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->storefrontAvailable:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Application.class), Application.class, "id;name;icon;description;type;coverImage;summary;monetized;verified;verifyKey;flags;hook;storefrontAvailable", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->id:J", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->name:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->icon:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->description:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->type:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->coverImage:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->summary:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->monetized:Z", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->verified:Z", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->verifyKey:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->flags:I", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->hook:Z", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->storefrontAvailable:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Application.class, Object.class), Application.class, "id;name;icon;description;type;coverImage;summary;monetized;verified;verifyKey;flags;hook;storefrontAvailable", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->id:J", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->name:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->icon:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->description:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->type:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->coverImage:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->summary:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->monetized:Z", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->verified:Z", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->verifyKey:Ljava/lang/String;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->flags:I", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->hook:Z", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$Application;->storefrontAvailable:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public long id() {
            return this.id;
        }

        public String name() {
            return this.name;
        }

        public String icon() {
            return this.icon;
        }

        public String description() {
            return this.description;
        }

        public String type() {
            return this.type;
        }

        public String coverImage() {
            return this.coverImage;
        }

        public String summary() {
            return this.summary;
        }

        public boolean monetized() {
            return this.monetized;
        }

        public boolean verified() {
            return this.verified;
        }

        public String verifyKey() {
            return this.verifyKey;
        }

        public int flags() {
            return this.flags;
        }

        public boolean hook() {
            return this.hook;
        }

        public boolean storefrontAvailable() {
            return this.storefrontAvailable;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/ApplicationManager$AuthenticationData.class */
    public static final class AuthenticationData extends Record {
        private final DiscordOAuth2Token token;
        private final Application application;
        private final DiscordUser user;

        public AuthenticationData(DiscordOAuth2Token token, Application application, DiscordUser user) {
            this.token = token;
            this.application = application;
            this.user = user;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, AuthenticationData.class), AuthenticationData.class, "token;application;user", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$AuthenticationData;->token:Lde/jcm/discordgamesdk/ApplicationManager$DiscordOAuth2Token;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$AuthenticationData;->application:Lde/jcm/discordgamesdk/ApplicationManager$Application;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$AuthenticationData;->user:Lde/jcm/discordgamesdk/user/DiscordUser;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, AuthenticationData.class), AuthenticationData.class, "token;application;user", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$AuthenticationData;->token:Lde/jcm/discordgamesdk/ApplicationManager$DiscordOAuth2Token;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$AuthenticationData;->application:Lde/jcm/discordgamesdk/ApplicationManager$Application;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$AuthenticationData;->user:Lde/jcm/discordgamesdk/user/DiscordUser;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, AuthenticationData.class, Object.class), AuthenticationData.class, "token;application;user", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$AuthenticationData;->token:Lde/jcm/discordgamesdk/ApplicationManager$DiscordOAuth2Token;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$AuthenticationData;->application:Lde/jcm/discordgamesdk/ApplicationManager$Application;", "FIELD:Lde/jcm/discordgamesdk/ApplicationManager$AuthenticationData;->user:Lde/jcm/discordgamesdk/user/DiscordUser;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public DiscordOAuth2Token token() {
            return this.token;
        }

        public Application application() {
            return this.application;
        }

        public DiscordUser user() {
            return this.user;
        }
    }

    ApplicationManager(Core.CorePrivate core) {
        this.core = core;
    }

    public void getOAuth2Token(BiConsumer<Result, DiscordOAuth2Token> callback) {
        this.core.sendCommand(Command.Type.AUTHENTICATE, new Object(), c -> {
            Result r = this.core.checkError(c);
            if (r != Result.OK) {
                callback.accept(r, null);
            } else {
                Authenticate.Response response = (Authenticate.Response) this.core.getGson().fromJson(c.getData(), Authenticate.Response.class);
                callback.accept(r, response.toDiscordOAuth2Token());
            }
        });
    }

    public void authenticate(BiConsumer<Result, AuthenticationData> callback) {
        this.core.sendCommand(Command.Type.AUTHENTICATE, new Object(), c -> {
            Result r = this.core.checkError(c);
            if (r != Result.OK) {
                callback.accept(r, null);
                return;
            }
            Authenticate.Response response = (Authenticate.Response) this.core.getGson().fromJson(c.getData(), Authenticate.Response.class);
            DiscordOAuth2Token token = response.toDiscordOAuth2Token();
            DiscordUser user = response.user;
            Application application = response.application.toApplication();
            callback.accept(r, new AuthenticationData(token, application, user));
        });
    }
}
