package foundry.veil.impl.client.render.vertex;

import foundry.veil.api.client.render.vertex.VertexArray;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/vertex/ARBVertexArray.class */
@ApiStatus.Internal
public class ARBVertexArray extends VertexArray {
    public ARBVertexArray(int id) {
        super(id, ARBVertexAttribBindingBuilder::new);
    }
}
