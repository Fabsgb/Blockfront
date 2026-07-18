package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.renderer.RenderStateShard;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/rendertype/layer/DepthTestLayer.class */
public final class DepthTestLayer extends Record implements RenderTypeLayer {
    private final LayerTemplateValue<DepthState> mode;
    public static final MapCodec<DepthTestLayer> CODEC = LayerTemplateValue.enumCodec(DepthState.class).fieldOf("mode").xmap(DepthTestLayer::new, (v0) -> {
        return v0.mode();
    });

    public DepthTestLayer(LayerTemplateValue<DepthState> mode) {
        this.mode = mode;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, DepthTestLayer.class), DepthTestLayer.class, "mode", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/DepthTestLayer;->mode:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, DepthTestLayer.class), DepthTestLayer.class, "mode", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/DepthTestLayer;->mode:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, DepthTestLayer.class, Object.class), DepthTestLayer.class, "mode", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/DepthTestLayer;->mode:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public LayerTemplateValue<DepthState> mode() {
        return this.mode;
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) {
        builder.depthTestState(this.mode.parse(params).shard);
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.DEPTH_TEST.get();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/rendertype/layer/DepthTestLayer$DepthState.class */
    public enum DepthState {
        NEVER(VeilRenderType.NEVER_DEPTH_TEST),
        LESS(VeilRenderType.LESS_DEPTH_TEST),
        EQUAL(VeilRenderType.equalDepthTestShard()),
        LEQUAL(VeilRenderType.lequalDepthTestShard()),
        GREATER(VeilRenderType.greaterDepthTestShard()),
        NOTEQUAL(VeilRenderType.NOTEQUAL_DEPTH_TEST),
        GEQUAL(VeilRenderType.GEQUAL_DEPTH_TEST),
        ALWAYS(VeilRenderType.noDepthTestShard());

        private final RenderStateShard.DepthTestStateShard shard;

        DepthState(RenderStateShard.DepthTestStateShard shard) {
            this.shard = shard;
        }

        public RenderStateShard.DepthTestStateShard getShard() {
            return this.shard;
        }
    }
}
