package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.ResourceLocationException;
import net.minecraft.client.renderer.RenderStateShard;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/layer/CullLayer.class */
public final class CullLayer extends Record implements RenderTypeLayer {
    private final LayerTemplateValue<CullFace> face;
    public static final MapCodec<CullLayer> CODEC = LayerTemplateValue.enumCodec(CullFace.class).optionalFieldOf("face", LayerTemplateValue.raw(CullFace.BACK)).xmap(CullLayer::new, (v0) -> {
        return v0.face();
    });

    public CullLayer(LayerTemplateValue<CullFace> face) {
        this.face = face;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, CullLayer.class), CullLayer.class, "face", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CullLayer;->face:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, CullLayer.class), CullLayer.class, "face", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CullLayer;->face:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, CullLayer.class, Object.class), CullLayer.class, "face", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/CullLayer;->face:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public LayerTemplateValue<CullFace> face() {
        return this.face;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: net.minecraft.ResourceLocationException */
    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) throws ResourceLocationException {
        CullFace face = this.face.parse(params);
        if (face == CullFace.NONE) {
            builder.cullState(VeilRenderType.noCullShard());
        } else {
            builder.cullState(VeilRenderType.cullShard());
            builder.addLayer(face.shard);
        }
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.CULL.get();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/layer/CullLayer$CullFace.class */
    public enum CullFace {
        FRONT(VeilRenderType.CULL_FRONT),
        BACK(VeilRenderType.CULL_BACK),
        FRONT_AND_BACK(VeilRenderType.CULL_FRONT_AND_BACK),
        NONE(null);

        private final RenderStateShard shard;

        CullFace(RenderStateShard shard) {
            this.shard = shard;
        }

        public RenderStateShard getShard() {
            return this.shard;
        }
    }
}
