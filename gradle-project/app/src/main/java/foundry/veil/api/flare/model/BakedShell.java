package foundry.veil.api.flare.model;

import foundry.veil.api.client.render.vertex.VertexArray;
import foundry.veil.api.flare.data.model.FlareBakedQuad;
import java.util.Collection;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/model/BakedShell.class */
public interface BakedShell extends NativeResource {
    Collection<FlareBakedQuad> getQuads();

    VertexArray getVertexArray();
}
