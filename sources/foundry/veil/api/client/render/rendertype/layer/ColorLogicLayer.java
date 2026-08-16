package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/layer/ColorLogicLayer.class */
public final class ColorLogicLayer extends Record implements RenderTypeLayer {
    private final LayerTemplateValue<GlStateManager.LogicOp> operation;
    public static final MapCodec<ColorLogicLayer> CODEC = LayerTemplateValue.enumCodec(GlStateManager.LogicOp.class).fieldOf("operation").xmap(ColorLogicLayer::new, (v0) -> {
        return v0.operation();
    });

    public ColorLogicLayer(LayerTemplateValue<GlStateManager.LogicOp> operation) {
        this.operation = operation;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ColorLogicLayer.class), ColorLogicLayer.class, "operation", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/ColorLogicLayer;->operation:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ColorLogicLayer.class), ColorLogicLayer.class, "operation", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/ColorLogicLayer;->operation:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ColorLogicLayer.class, Object.class), ColorLogicLayer.class, "operation", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/ColorLogicLayer;->operation:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public LayerTemplateValue<GlStateManager.LogicOp> operation() {
        return this.operation;
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) {
        builder.colorLogicState(VeilRenderType.colorLogicStateShard(this.operation.parse(params)));
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.COLOR_LOGIC.get();
    }
}
