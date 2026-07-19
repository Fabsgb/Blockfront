package foundry.veil.forge.compat.iris;

import foundry.veil.api.compat.IrisCompat;
import foundry.veil.ext.iris.IrisRenderTargetExtension;
import foundry.veil.forge.mixin.compat.iris.IrisRenderingPipelineAccessor;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import net.irisshaders.iris.Iris;
import net.irisshaders.iris.pipeline.WorldRenderingPipeline;
import net.irisshaders.iris.targets.RenderTargets;
import net.minecraft.client.renderer.ShaderInstance;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/compat/iris/VeilForgeIrisCompat.class */
public class VeilForgeIrisCompat implements IrisCompat {
    @Override // foundry.veil.api.compat.IrisCompat
    public Set<ShaderInstance> getLoadedShaders() {
        IrisRenderingPipelineAccessor pipelineNullable = Iris.getPipelineManager().getPipelineNullable();
        if (pipelineNullable instanceof IrisRenderingPipelineAccessor) {
            IrisRenderingPipelineAccessor accessor = pipelineNullable;
            return accessor.getLoadedShaders();
        }
        return Collections.emptySet();
    }

    @Override // foundry.veil.api.compat.IrisCompat
    public Map<String, IrisRenderTargetExtension> getRenderTargets() {
        IrisRenderingPipelineAccessor pipelineNullable = Iris.getPipelineManager().getPipelineNullable();
        if (pipelineNullable instanceof IrisRenderingPipelineAccessor) {
            IrisRenderingPipelineAccessor accessor = pipelineNullable;
            RenderTargets renderTargets = accessor.getRenderTargets();
            Object2ObjectArrayMap<String, IrisRenderTargetExtension> extensions = new Object2ObjectArrayMap<>(renderTargets.getRenderTargetCount());
            for (int i = 0; i < renderTargets.getRenderTargetCount(); i++) {
                IrisRenderTargetExtension ext = renderTargets.get(i);
                if (ext != null) {
                    extensions.put(ext.veil$getName(), ext);
                }
            }
            return extensions;
        }
        return Object2ObjectMaps.emptyMap();
    }

    @Override // foundry.veil.api.compat.IrisCompat
    public boolean areShadersLoaded() {
        return Iris.getCurrentPack().isPresent();
    }

    @Override // foundry.veil.api.compat.IrisCompat
    public void recompile() {
    }

    @Override // foundry.veil.api.compat.IrisCompat
    public Class<?> getPipelineClass() {
        return WorldRenderingPipeline.class;
    }
}
