package de.jcm.discordgamesdk.impl.commands;

import de.jcm.discordgamesdk.impl.DataProxies;
import java.util.List;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/GetRelationships.class */
public class GetRelationships {
    private GetRelationships() {
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/discord-game-sdk4j-08b2bf45a6db310fd54ef0b72bb86ca73a770895.jar:de/jcm/discordgamesdk/impl/commands/GetRelationships$Response.class */
    public static class Response {
        private List<DataProxies.RelationshipImpl> relationships;

        public List<DataProxies.RelationshipImpl> getRelationships() {
            return this.relationships;
        }
    }
}
