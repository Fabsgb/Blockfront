package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/layer/LightmapLayer.class */
public final class LightmapLayer extends Record implements RenderTypeLayer {
    private final boolean enabled;
    public static final MapCodec<LightmapLayer> CODEC = Codec.BOOL.optionalFieldOf("enabled", true).xmap((v1) -> {
        return new LightmapLayer(v1);
    }, (v0) -> {
        return v0.enabled();
    });

    public LightmapLayer(boolean enabled) {
        this.enabled = enabled;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, LightmapLayer.class), LightmapLayer.class, "enabled", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LightmapLayer;->enabled:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, LightmapLayer.class), LightmapLayer.class, "enabled", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LightmapLayer;->enabled:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, LightmapLayer.class, Object.class), LightmapLayer.class, "enabled", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LightmapLayer;->enabled:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public boolean enabled() {
        return this.enabled;
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) {
        builder.lightmapState(this.enabled ? VeilRenderType.lightmap() : VeilRenderType.noLightmap());
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.LIGHTMAP.get();
    }
}
