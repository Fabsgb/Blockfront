package de.jcm.discordgamesdk.impl.events;

import de.jcm.discordgamesdk.Core;
import de.jcm.discordgamesdk.impl.Command;
import de.jcm.discordgamesdk.impl.EventHandler;
import de.jcm.discordgamesdk.user.DiscordUser;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/ReadyEvent.class */
public class ReadyEvent {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/ReadyEvent$Data.class */
    public static class Data {
        int v;
        Config config;
        DiscordUser user;

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/ReadyEvent$Data$Config.class */
        static class Config {
            String cdn_host;
            String api_endpoint;
            String environment;

            Config() {
            }

            public String toString() {
                return "Config{cdn_host='" + this.cdn_host + "', api_endpoint='" + this.api_endpoint + "', environment='" + this.environment + "'}";
            }
        }

        public String toString() {
            return "ReadyData{v=" + this.v + ", config=" + this.config + ", user=" + this.user + "}";
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/ReadyEvent$Handler.class */
    public static class Handler extends EventHandler<Data> {
        public Handler(Core.CorePrivate core) {
            super(core);
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public void handle(Command command, Data data) {
            this.core.ready();
            this.core.currentUser = data.user;
            this.core.workQueue.add(() -> {
                this.core.getEventAdapter().onCurrentUserUpdate();
            });
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public Class<?> getDataClass() {
            return Data.class;
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public boolean shouldRegister() {
            return false;
        }
    }
}
