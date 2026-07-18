package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.VeilRenderBridge;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/rendertype/layer/MultisampleLayer.class */
public final class MultisampleLayer extends Record implements RenderTypeLayer {
    private final boolean enabled;
    public static final MapCodec<MultisampleLayer> CODEC = Codec.BOOL.optionalFieldOf("enabled", true).xmap((v1) -> {
        return new MultisampleLayer(v1);
    }, (v0) -> {
        return v0.enabled();
    });

    public MultisampleLayer(boolean enabled) {
        this.enabled = enabled;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, MultisampleLayer.class), MultisampleLayer.class, "enabled", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/MultisampleLayer;->enabled:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, MultisampleLayer.class), MultisampleLayer.class, "enabled", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/MultisampleLayer;->enabled:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, MultisampleLayer.class, Object.class), MultisampleLayer.class, "enabled", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/MultisampleLayer;->enabled:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public boolean enabled() {
        return this.enabled;
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) {
        if (this.enabled) {
            builder.addLayer(VeilRenderBridge.multisampleState());
        }
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.MULTISAMPLE.get();
    }
}
