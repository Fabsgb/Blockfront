package de.jcm.discordgamesdk.impl.events;

import de.jcm.discordgamesdk.Core;
import de.jcm.discordgamesdk.impl.Command;
import de.jcm.discordgamesdk.impl.DataProxies;
import de.jcm.discordgamesdk.impl.EventHandler;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/RelationshipUpdateEvent.class */
public class RelationshipUpdateEvent {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/events/RelationshipUpdateEvent$Handler.class */
    public static class Handler extends EventHandler<DataProxies.RelationshipImpl> {
        public Handler(Core.CorePrivate core) {
            super(core);
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public void handle(Command command, DataProxies.RelationshipImpl data) {
            this.core.relationships.put(Long.valueOf(data.user.getUserId()), data.toRelationship());
            this.core.getEventAdapter().onRelationshipUpdate(data.toRelationship());
        }

        @Override // de.jcm.discordgamesdk.impl.EventHandler
        public Class<?> getDataClass() {
            return DataProxies.RelationshipImpl.class;
        }
    }
}
