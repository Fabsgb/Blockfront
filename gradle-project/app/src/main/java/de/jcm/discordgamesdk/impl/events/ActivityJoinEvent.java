package de.jcm.discordgamesdk.impl.events;

import de.jcm.discordgamesdk.Core;
import de.jcm.discordgamesdk.impl.Command;
import de.jcm.discordgamesdk.impl.EventHandler;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/ActivityJoinEvent.class */
public class ActivityJoinEvent {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/ActivityJoinEvent$Data.class */
    public static class Data {
        String secret;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/ActivityJoinEvent$Handler.class */
    public static class Handler extends EventHandler<Data> {
        public Handler(Core.CorePrivate core) {
            super(core);
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public void handle(Command command, Data data) {
            this.core.getEventAdapter().onActivityJoin(data.secret);
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public Class<?> getDataClass() {
            return Data.class;
        }
    }
}
