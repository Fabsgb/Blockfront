package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.renderer.RenderStateShard;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/layer/LayeringLayer.class */
public final class LayeringLayer extends Record implements RenderTypeLayer {
    private final LayerTemplateValue<LayeringState> mode;
    public static final MapCodec<LayeringLayer> CODEC = LayerTemplateValue.enumCodec(LayeringState.class).optionalFieldOf("mode", LayerTemplateValue.raw(LayeringState.POLYGON_OFFSET)).xmap(LayeringLayer::new, (v0) -> {
        return v0.mode();
    });

    public LayeringLayer(LayerTemplateValue<LayeringState> mode) {
        this.mode = mode;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, LayeringLayer.class), LayeringLayer.class, "mode", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LayeringLayer;->mode:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, LayeringLayer.class), LayeringLayer.class, "mode", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LayeringLayer;->mode:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, LayeringLayer.class, Object.class), LayeringLayer.class, "mode", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LayeringLayer;->mode:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public LayerTemplateValue<LayeringState> mode() {
        return this.mode;
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) {
        builder.layeringState(this.mode.parse(params).shard);
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.LAYERING.get();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/layer/LayeringLayer$LayeringState.class */
    public enum LayeringState {
        NONE(VeilRenderType.noLayering()),
        POLYGON_OFFSET(VeilRenderType.polygonOffsetLayering()),
        VIEW_OFFSET(VeilRenderType.viewOffsetLayering());

        private final RenderStateShard.LayeringStateShard shard;

        LayeringState(RenderStateShard.LayeringStateShard shard) {
            this.shard = shard;
        }

        public RenderStateShard.LayeringStateShard getShard() {
            return this.shard;
        }
    }
}
