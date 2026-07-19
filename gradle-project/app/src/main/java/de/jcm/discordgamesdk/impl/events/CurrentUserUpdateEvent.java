package de.jcm.discordgamesdk.impl.events;

import de.jcm.discordgamesdk.Core;
import de.jcm.discordgamesdk.impl.Command;
import de.jcm.discordgamesdk.impl.EventHandler;
import de.jcm.discordgamesdk.user.DiscordUser;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/CurrentUserUpdateEvent.class */
public class CurrentUserUpdateEvent {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/CurrentUserUpdateEvent$Handler.class */
    public static class Handler extends EventHandler<DiscordUser> {
        public Handler(Core.CorePrivate core) {
            super(core);
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public void handle(Command command, DiscordUser user) {
            this.core.currentUser = user;
            this.core.getEventAdapter().onCurrentUserUpdate();
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public Class<?> getDataClass() {
            return DiscordUser.class;
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public boolean shouldRegister() {
            return false;
        }
    }
}
