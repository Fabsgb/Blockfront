package foundry.veil.api.client.render.rendertype;

import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/rendertype/VeilRenderTypeBuilder.class */
public interface VeilRenderTypeBuilder {
    VeilRenderTypeBuilder textureState(RenderStateShard.EmptyTextureStateShard emptyTextureStateShard);

    VeilRenderTypeBuilder shaderState(RenderStateShard.ShaderStateShard shaderStateShard);

    VeilRenderTypeBuilder transparencyState(RenderStateShard.TransparencyStateShard transparencyStateShard);

    VeilRenderTypeBuilder depthTestState(RenderStateShard.DepthTestStateShard depthTestStateShard);

    VeilRenderTypeBuilder cullState(RenderStateShard.CullStateShard cullStateShard);

    VeilRenderTypeBuilder lightmapState(RenderStateShard.LightmapStateShard lightmapStateShard);

    VeilRenderTypeBuilder overlayState(RenderStateShard.OverlayStateShard overlayStateShard);

    VeilRenderTypeBuilder layeringState(RenderStateShard.LayeringStateShard layeringStateShard);

    VeilRenderTypeBuilder outputState(RenderStateShard.OutputStateShard outputStateShard);

    VeilRenderTypeBuilder texturingState(RenderStateShard.TexturingStateShard texturingStateShard);

    VeilRenderTypeBuilder writeMaskState(RenderStateShard.WriteMaskStateShard writeMaskStateShard);

    VeilRenderTypeBuilder lineState(RenderStateShard.LineStateShard lineStateShard);

    VeilRenderTypeBuilder colorLogicState(RenderStateShard.ColorLogicStateShard colorLogicStateShard);

    VeilRenderTypeBuilder addLayer(RenderStateShard renderStateShard);

    RenderType.CompositeState create(RenderType.OutlineProperty outlineProperty);

    default RenderType.CompositeState create(boolean affectsOutline) {
        return create(affectsOutline ? RenderType.OutlineProperty.AFFECTS_OUTLINE : RenderType.OutlineProperty.NONE);
    }
}
