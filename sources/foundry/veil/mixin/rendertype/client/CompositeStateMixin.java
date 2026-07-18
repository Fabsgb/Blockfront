package foundry.veil.mixin.rendertype.client;

import com.google.common.collect.ImmutableList;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor;
import foundry.veil.ext.CompositeStateExtension;
import java.util.Collection;
import java.util.List;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/rendertype/client/CompositeStateMixin.class */
@Mixin({RenderType.CompositeState.class})
public class CompositeStateMixin implements VeilRenderTypeAccessor, CompositeStateExtension {

    @Shadow
    @Final
    RenderStateShard.EmptyTextureStateShard textureState;

    @Shadow
    @Final
    private RenderStateShard.ShaderStateShard shaderState;

    @Shadow
    @Final
    private RenderStateShard.TransparencyStateShard transparencyState;

    @Shadow
    @Final
    private RenderStateShard.DepthTestStateShard depthTestState;

    @Shadow
    @Final
    RenderStateShard.CullStateShard cullState;

    @Shadow
    @Final
    private RenderStateShard.LightmapStateShard lightmapState;

    @Shadow
    @Final
    private RenderStateShard.OverlayStateShard overlayState;

    @Shadow
    @Final
    private RenderStateShard.LayeringStateShard layeringState;

    @Shadow
    @Final
    private RenderStateShard.OutputStateShard outputState;

    @Shadow
    @Final
    private RenderStateShard.TexturingStateShard texturingState;

    @Shadow
    @Final
    private RenderStateShard.WriteMaskStateShard writeMaskState;

    @Shadow
    @Final
    private RenderStateShard.LineStateShard lineState;

    @Shadow
    @Final
    private RenderStateShard.ColorLogicStateShard colorLogicState;

    @Shadow
    @Final
    RenderType.OutlineProperty outlineProperty;

    @Mutable
    @Shadow
    @Final
    ImmutableList<RenderStateShard> states;

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor
    public RenderStateShard.EmptyTextureStateShard textureState() {
        return this.textureState;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor
    public RenderStateShard.ShaderStateShard shaderState() {
        return this.shaderState;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor
    public RenderStateShard.TransparencyStateShard transparencyState() {
        return this.transparencyState;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor
    public RenderStateShard.DepthTestStateShard depthTestState() {
        return this.depthTestState;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor
    public RenderStateShard.CullStateShard cullState() {
        return this.cullState;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor
    public RenderStateShard.LightmapStateShard lightmapState() {
        return this.lightmapState;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor
    public RenderStateShard.OverlayStateShard overlayState() {
        return this.overlayState;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor
    public RenderStateShard.LayeringStateShard layeringState() {
        return this.layeringState;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor
    public RenderStateShard.OutputStateShard outputState() {
        return this.outputState;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor
    public RenderStateShard.TexturingStateShard texturingState() {
        return this.texturingState;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor
    public RenderStateShard.WriteMaskStateShard writeMaskState() {
        return this.writeMaskState;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor
    public RenderStateShard.LineStateShard lineState() {
        return this.lineState;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor
    public RenderStateShard.ColorLogicStateShard colorLogicState() {
        return this.colorLogicState;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor
    public RenderType.OutlineProperty outlineProperty() {
        return this.outlineProperty;
    }

    @Override // foundry.veil.api.client.render.rendertype.VeilRenderTypeAccessor
    public List<RenderStateShard> states() {
        return this.states;
    }

    @Override // foundry.veil.ext.CompositeStateExtension
    public void veil$addShards(Collection<RenderStateShard> shards) {
        if (shards.isEmpty()) {
            return;
        }
        ImmutableList.Builder<RenderStateShard> builder = new ImmutableList.Builder<>();
        builder.addAll(this.states);
        builder.addAll(shards);
        this.states = builder.build();
    }
}
