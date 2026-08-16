package foundry.veil.impl.client.render.pipeline;

import foundry.veil.api.client.render.VeilRenderSystem;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/pipeline/ShaderProgramShard.class */
@ApiStatus.Internal
public class ShaderProgramShard extends RenderStateShard.ShaderStateShard {
    private final ResourceLocation shader;

    public ShaderProgramShard(ResourceLocation shader) {
        this.shader = shader;
    }

    public void setupRenderState() {
        VeilRenderSystem.setShader(this.shader);
    }

    public String toString() {
        return this.name + "[" + String.valueOf(this.shader) + "]";
    }

    public ResourceLocation getShader() {
        return this.shader;
    }
}
