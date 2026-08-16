package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.renderer.RenderStateShard;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/layer/TransparencyLayer.class */
public final class TransparencyLayer extends Record implements RenderTypeLayer {
    private final LayerTemplateValue<BlendState> mode;
    public static final MapCodec<TransparencyLayer> CODEC = LayerTemplateValue.enumCodec(BlendState.class).fieldOf("mode").xmap(TransparencyLayer::new, (v0) -> {
        return v0.mode();
    });

    public TransparencyLayer(LayerTemplateValue<BlendState> mode) {
        this.mode = mode;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, TransparencyLayer.class), TransparencyLayer.class, "mode", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/TransparencyLayer;->mode:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, TransparencyLayer.class), TransparencyLayer.class, "mode", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/TransparencyLayer;->mode:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, TransparencyLayer.class, Object.class), TransparencyLayer.class, "mode", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/TransparencyLayer;->mode:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public LayerTemplateValue<BlendState> mode() {
        return this.mode;
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) {
        builder.transparencyState(this.mode.parse(params).shard);
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.TRANSPARENCY.get();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/layer/TransparencyLayer$BlendState.class */
    public enum BlendState {
        NONE(VeilRenderType.noTransparencyShard()),
        ADDITIVE(VeilRenderType.additiveTransparencyShard()),
        LIGHTNING(VeilRenderType.lightningTransparencyShard()),
        GLINT(VeilRenderType.glintTransparencyShard()),
        CRUMBLING(VeilRenderType.crumblingTransparencyShard()),
        TRANSLUCENT(VeilRenderType.translucentTransparencyShard());

        private final RenderStateShard.TransparencyStateShard shard;

        BlendState(RenderStateShard.TransparencyStateShard shard) {
            this.shard = shard;
        }

        public RenderStateShard.TransparencyStateShard getShard() {
            return this.shard;
        }
    }
}
