package foundry.veil.ext;

import java.util.Collection;
import net.minecraft.client.renderer.RenderStateShard;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/ext/CompositeStateExtension.class */
@ApiStatus.Internal
public interface CompositeStateExtension {
    void veil$addShards(Collection<RenderStateShard> collection);
}
