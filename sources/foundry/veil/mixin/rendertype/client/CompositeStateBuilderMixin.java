package foundry.veil.mixin.rendertype.client;

import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import foundry.veil.ext.CompositeStateExtension;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/rendertype/client/CompositeStateBuilderMixin.class */
@Mixin({RenderType.CompositeState.CompositeStateBuilder.class})
public abstract class CompositeStateBuilderMixin implements VeilRenderTypeBuilder {

    @Unique
    private List<RenderStateShard> veil$layers;

    @Shadow
    public abstract RenderType.CompositeState.CompositeStateBuilder setTextureState(RenderStateShard.EmptyTextureStateShard emptyTextureStateShard);

    @Shadow
    public abstract RenderType.CompositeState.CompositeStateBuilder setShaderState(RenderStateShard.ShaderStateShard shaderStateShard);

    @Shadow
    public abstract RenderType.CompositeState.CompositeStateBuilder setTransparencyState(RenderStateShard.TransparencyStateShard transparencyStateShard);

    @Shadow
    public abstract RenderType.CompositeState.CompositeStateBuilder setDepthTestState(RenderStateShard.DepthTestStateShard depthTestStateShard);

    @Shadow
    public abstract RenderType.CompositeState.CompositeStateBuilder setLightmapState(RenderStateShard.LightmapStateShard lightmapStateShard);

    @Shadow
    public abstract RenderType.CompositeState.CompositeStateBuilder setCullState(RenderStateShard.CullStateShard cullStateShard);

    @Shadow
    public abstract RenderType.CompositeState.CompositeStateBuilder setOverlayState(RenderStateShard.OverlayStateShard overlayStateShard);

    @Shadow
    public abstract RenderType.CompositeState.CompositeStateBuilder setLayeringState(RenderStateShard.LayeringStateShard layeringStateShard);

    @Shadow
    public abstract RenderType.CompositeState.CompositeStateBuilder setOutputState(RenderStateShard.OutputStateShard outputStateShard);

    @Shadow
    public abstract RenderType.CompositeState.CompositeStateBuilder setTexturingState(RenderStateShard.TexturingStateShard texturingStateShard);

    @Shadow
    public abstract RenderType.CompositeState.CompositeStateBuilder setWriteMaskState(RenderStateShard.WriteMaskStateShard writeMaskStateShard);

    @Shadow
    public abstract RenderType.CompositeState.CompositeStateBuilder setLineState(RenderStateShard.LineStateShard lineStateShard);

    @Shadow
    public abstract RenderType.CompositeState.CompositeStateBuilder setColorLogicState(RenderStateShard.ColorLogicStateShard colorLogicStateShard);

    @Shadow
    public abstract RenderType.CompositeState createCompositeState(RenderType.OutlineProperty outlineProperty);

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder
    public VeilRenderTypeBuilder textureState(RenderStateShard.EmptyTextureStateShard state) {
        setTextureState(state);
        return this;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder
    public VeilRenderTypeBuilder shaderState(RenderStateShard.ShaderStateShard state) {
        setShaderState(state);
        return this;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder
    public VeilRenderTypeBuilder transparencyState(RenderStateShard.TransparencyStateShard state) {
        setTransparencyState(state);
        return this;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder
    public VeilRenderTypeBuilder depthTestState(RenderStateShard.DepthTestStateShard state) {
        setDepthTestState(state);
        return this;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder
    public VeilRenderTypeBuilder cullState(RenderStateShard.CullStateShard state) {
        setCullState(state);
        return this;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder
    public VeilRenderTypeBuilder lightmapState(RenderStateShard.LightmapStateShard state) {
        setLightmapState(state);
        return this;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder
    public VeilRenderTypeBuilder overlayState(RenderStateShard.OverlayStateShard state) {
        setOverlayState(state);
        return this;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder
    public VeilRenderTypeBuilder layeringState(RenderStateShard.LayeringStateShard state) {
        setLayeringState(state);
        return this;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder
    public VeilRenderTypeBuilder outputState(RenderStateShard.OutputStateShard state) {
        setOutputState(state);
        return this;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder
    public VeilRenderTypeBuilder texturingState(RenderStateShard.TexturingStateShard state) {
        setTexturingState(state);
        return this;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder
    public VeilRenderTypeBuilder writeMaskState(RenderStateShard.WriteMaskStateShard state) {
        setWriteMaskState(state);
        return this;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder
    public VeilRenderTypeBuilder lineState(RenderStateShard.LineStateShard state) {
        setLineState(state);
        return this;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder
    public VeilRenderTypeBuilder colorLogicState(RenderStateShard.ColorLogicStateShard state) {
        setColorLogicState(state);
        return this;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder
    public VeilRenderTypeBuilder addLayer(RenderStateShard shard) {
        if (this.veil$layers == null) {
            this.veil$layers = new LinkedList();
        }
        this.veil$layers.add(shard);
        return this;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder
    public RenderType.CompositeState create(RenderType.OutlineProperty outlineProperty) {
        return createCompositeState(outlineProperty);
    }

    @Inject(method = {"createCompositeState(Lnet/minecraft/client/renderer/RenderType$OutlineProperty;)Lnet/minecraft/client/renderer/RenderType$CompositeState;"}, at = {@At("RETURN")})
    public void addLayers(CallbackInfoReturnable<RenderType.CompositeState> cir) {
        if (this.veil$layers != null) {
            ((CompositeStateExtension) cir.getReturnValue()).veil$addShards(this.veil$layers);
        }
    }
}
