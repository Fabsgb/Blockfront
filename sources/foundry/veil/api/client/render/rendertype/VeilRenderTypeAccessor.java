package foundry.veil.api.client.render.rendertype;

import foundry.veil.impl.client.render.pipeline.ShaderProgramShard;
import java.util.List;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/VeilRenderTypeAccessor.class */
public interface VeilRenderTypeAccessor {
    RenderStateShard.EmptyTextureStateShard textureState();

    RenderStateShard.ShaderStateShard shaderState();

    RenderStateShard.TransparencyStateShard transparencyState();

    RenderStateShard.DepthTestStateShard depthTestState();

    RenderStateShard.CullStateShard cullState();

    RenderStateShard.LightmapStateShard lightmapState();

    RenderStateShard.OverlayStateShard overlayState();

    RenderStateShard.LayeringStateShard layeringState();

    RenderStateShard.OutputStateShard outputState();

    RenderStateShard.TexturingStateShard texturingState();

    RenderStateShard.WriteMaskStateShard writeMaskState();

    RenderStateShard.LineStateShard lineState();

    RenderStateShard.ColorLogicStateShard colorLogicState();

    RenderType.OutlineProperty outlineProperty();

    List<RenderStateShard> states();

    @Nullable
    default ResourceLocation veilShaderId() {
        RenderStateShard.ShaderStateShard shaderStateShardShaderState = shaderState();
        if (shaderStateShardShaderState instanceof ShaderProgramShard) {
            ShaderProgramShard shard = (ShaderProgramShard) shaderStateShardShaderState;
            return shard.getShader();
        }
        return null;
    }
}
