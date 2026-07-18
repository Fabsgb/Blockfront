package de.jcm.discordgamesdk.impl.events;

import com.boehmod.blockfront.C1230wX;
import com.google.gson.JsonObject;
import de.jcm.discordgamesdk.Core;
import de.jcm.discordgamesdk.impl.Command;
import de.jcm.discordgamesdk.impl.EventHandler;
import de.jcm.discordgamesdk.user.DiscordUser;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/ActivityJoinRequestEvent.class */
public class ActivityJoinRequestEvent {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/ActivityJoinRequestEvent$Handler.class */
    public static class Handler extends EventHandler<DiscordUser> {
        public Handler(Core.CorePrivate core) {
            super(core);
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public void handle(Command command, DiscordUser discordUser) {
            JsonObject data = command.getData().getAsJsonObject();
            JsonObject userData = data.getAsJsonObject("user");
            long userID = 0;
            String username = null;
            String discriminator = null;
            String avatar = null;
            boolean bot = false;
            if (!userData.get("id").isJsonNull()) {
                userID = Long.parseLong(userData.get("id").getAsString());
            }
            if (!userData.get("username").isJsonNull()) {
                username = userData.get("username").getAsString();
            }
            if (!userData.get("discriminator").isJsonNull()) {
                discriminator = userData.get("discriminator").getAsString();
            }
            if (!userData.get("avatar").isJsonNull()) {
                avatar = userData.get("avatar").getAsString();
            }
            if (!userData.get(C1230wX.f7003ed).isJsonNull()) {
                bot = userData.get(C1230wX.f7003ed).getAsBoolean();
            }
            DiscordUser user = new DiscordUser(userID, username, discriminator, avatar, Boolean.valueOf(bot));
            this.core.getEventAdapter().onActivityJoinRequest(user);
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public Class<?> getDataClass() {
            return DiscordUser.class;
        }
    }
}
