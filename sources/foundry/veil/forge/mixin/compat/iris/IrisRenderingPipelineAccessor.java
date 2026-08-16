package foundry.veil.forge.mixin.compat.iris;

import java.util.Set;
import net.irisshaders.iris.pipeline.IrisRenderingPipeline;
import net.irisshaders.iris.targets.RenderTargets;
import net.minecraft.client.renderer.ShaderInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/compat/iris/IrisRenderingPipelineAccessor.class */
@Mixin({IrisRenderingPipeline.class})
public interface IrisRenderingPipelineAccessor {
    @Accessor(remap = false)
    RenderTargets getRenderTargets();

    @Accessor(remap = false)
    Set<ShaderInstance> getLoadedShaders();
}
