package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.Codec;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/rendertype/layer/RenderTypeLayer.class */
public interface RenderTypeLayer {
    public static final Codec<RenderTypeLayer> CODEC = RenderTypeLayerRegistry.REGISTRY.byNameCodec().dispatch((v0) -> {
        return v0.getType();
    }, (v0) -> {
        return v0.codec();
    });

    void addShard(VeilRenderTypeBuilder veilRenderTypeBuilder, Object... objArr);

    RenderTypeLayerRegistry.LayerType<?> getType();
}
