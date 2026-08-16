package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Optional;
import java.util.OptionalDouble;
import net.minecraft.client.renderer.RenderStateShard;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/layer/LineLayer.class */
public final class LineLayer extends Record implements RenderTypeLayer {
    private final OptionalDouble width;
    public static final MapCodec<LineLayer> CODEC = Codec.DOUBLE.optionalFieldOf("width").xmap(width -> {
        return new LineLayer((OptionalDouble) width.map((v0) -> {
            return OptionalDouble.of(v0);
        }).orElseGet(OptionalDouble::empty));
    }, layer -> {
        return layer.width().isPresent() ? Optional.of(Double.valueOf(layer.width().getAsDouble())) : Optional.empty();
    });

    public LineLayer(OptionalDouble width) {
        this.width = width;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, LineLayer.class), LineLayer.class, "width", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LineLayer;->width:Ljava/util/OptionalDouble;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, LineLayer.class), LineLayer.class, "width", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LineLayer;->width:Ljava/util/OptionalDouble;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, LineLayer.class, Object.class), LineLayer.class, "width", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/LineLayer;->width:Ljava/util/OptionalDouble;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public OptionalDouble width() {
        return this.width;
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) {
        builder.lineState(new RenderStateShard.LineStateShard(this.width));
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.LINE.get();
    }
}
