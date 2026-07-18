package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.VeilRenderBridge;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.VeilFramebuffers;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.ResourceLocationException;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/rendertype/layer/OutputLayer.class */
public final class OutputLayer extends Record implements RenderTypeLayer {
    private final LayerTemplateValue<ResourceLocation> framebufferId;
    public static final MapCodec<OutputLayer> CODEC = LayerTemplateValue.LOCATION_CODEC.fieldOf("framebuffer").xmap(OutputLayer::new, (v0) -> {
        return v0.framebufferId();
    });

    public OutputLayer(LayerTemplateValue<ResourceLocation> framebufferId) {
        this.framebufferId = framebufferId;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, OutputLayer.class), OutputLayer.class, "framebufferId", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/OutputLayer;->framebufferId:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, OutputLayer.class), OutputLayer.class, "framebufferId", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/OutputLayer;->framebufferId:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, OutputLayer.class, Object.class), OutputLayer.class, "framebufferId", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/OutputLayer;->framebufferId:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public LayerTemplateValue<ResourceLocation> framebufferId() {
        return this.framebufferId;
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) throws ResourceLocationException {
        ResourceLocation id = this.framebufferId.parse(params);
        if (VeilFramebuffers.BLOOM.equals(id)) {
            builder.outputState(VeilRenderSystem.BLOOM_SHARD);
        } else {
            builder.outputState(VeilRenderBridge.outputState(id));
        }
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.OUTPUT.get();
    }
}
