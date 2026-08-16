package foundry.veil.forge.mixin.client.perspective.iris;

import foundry.veil.api.client.render.VeilLevelPerspectiveRenderer;
import net.irisshaders.iris.pipeline.PipelineManager;
import net.irisshaders.iris.shaderpack.materialmap.NamespacedId;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/client/perspective/iris/PipelineManagerMixin.class */
@Mixin({PipelineManager.class})
public class PipelineManagerMixin {
    @ModifyVariable(method = {"preparePipeline"}, at = @At("HEAD"), argsOnly = true, remap = false)
    public NamespacedId modifyPipeline(NamespacedId value) {
        if (VeilLevelPerspectiveRenderer.isRenderingPerspective()) {
            return new NamespacedId(value.getNamespace(), "veil_perspective_" + value.getName());
        }
        return value;
    }
}
