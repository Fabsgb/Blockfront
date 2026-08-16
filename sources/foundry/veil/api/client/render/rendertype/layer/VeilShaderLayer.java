package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.VeilRenderBridge;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/layer/VeilShaderLayer.class */
public final class VeilShaderLayer extends Record implements RenderTypeLayer {
    private final LayerTemplateValue<ResourceLocation> shaderId;
    public static final MapCodec<VeilShaderLayer> CODEC = LayerTemplateValue.LOCATION_CODEC.fieldOf("name").xmap(VeilShaderLayer::new, (v0) -> {
        return v0.shaderId();
    });

    public VeilShaderLayer(LayerTemplateValue<ResourceLocation> shaderId) {
        this.shaderId = shaderId;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, VeilShaderLayer.class), VeilShaderLayer.class, "shaderId", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/VeilShaderLayer;->shaderId:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, VeilShaderLayer.class), VeilShaderLayer.class, "shaderId", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/VeilShaderLayer;->shaderId:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, VeilShaderLayer.class, Object.class), VeilShaderLayer.class, "shaderId", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/VeilShaderLayer;->shaderId:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public LayerTemplateValue<ResourceLocation> shaderId() {
        return this.shaderId;
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) {
        builder.shaderState(VeilRenderBridge.shaderState(this.shaderId.parse(params)));
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.VEIL_SHADER.get();
    }
}
