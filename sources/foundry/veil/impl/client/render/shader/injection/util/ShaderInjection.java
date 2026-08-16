package foundry.veil.impl.client.render.shader.injection.util;

import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import java.io.IOException;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/injection/util/ShaderInjection.class */
@ApiStatus.Internal
public interface ShaderInjection {
    void inject(GlslTree glslTree, boolean z) throws GlslSyntaxException, IOException;

    int priority();
}
