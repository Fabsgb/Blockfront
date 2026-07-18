package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.VeilRenderBridge;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/rendertype/layer/PatchesLayer.class */
public final class PatchesLayer extends Record implements RenderTypeLayer {
    private final int patchVertices;
    public static final MapCodec<PatchesLayer> CODEC = Codec.intRange(1, Integer.MAX_VALUE).fieldOf("patchVertices").xmap((v1) -> {
        return new PatchesLayer(v1);
    }, (v0) -> {
        return v0.patchVertices();
    });

    public PatchesLayer(int patchVertices) {
        this.patchVertices = patchVertices;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PatchesLayer.class), PatchesLayer.class, "patchVertices", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/PatchesLayer;->patchVertices:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PatchesLayer.class), PatchesLayer.class, "patchVertices", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/PatchesLayer;->patchVertices:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PatchesLayer.class, Object.class), PatchesLayer.class, "patchVertices", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/PatchesLayer;->patchVertices:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public int patchVertices() {
        return this.patchVertices;
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) {
        builder.addLayer(VeilRenderBridge.patchState(this.patchVertices));
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.PATCHES.get();
    }
}
