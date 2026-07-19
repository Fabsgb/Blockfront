package foundry.veil.mixin.pipeline.client;

import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.impl.client.render.shader.program.ShaderProgramImpl;
import java.util.function.Supplier;
import net.minecraft.client.renderer.ShaderInstance;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/pipeline/client/PipelineRenderSystemMixin.class */
@Mixin({RenderSystem.class})
public class PipelineRenderSystemMixin {
    @Inject(method = {"setShader"}, at = {@At("TAIL")}, remap = false)
    private static void setShader(Supplier<ShaderInstance> shader, CallbackInfo ci) {
        if (!(shader.get() instanceof ShaderProgramImpl.Wrapper)) {
            VeilRenderSystem.shaderUpdate();
        }
    }

    @Inject(method = {"setShaderLights"}, at = {@At("HEAD")}, remap = false)
    private static void setShaderLights(Vector3f light0, Vector3f light1, CallbackInfo ci) {
        VeilRenderSystem.setShaderLights(light0, light1);
    }
}
