package foundry.veil.impl.client.render.vertex;

import foundry.veil.api.client.render.vertex.VertexArray;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/vertex/LegacyVertexArray.class */
@ApiStatus.Internal
public class LegacyVertexArray extends VertexArray {
    public LegacyVertexArray(int id) {
        super(id, LegacyVertexAttribBindingBuilder::new);
    }
}
