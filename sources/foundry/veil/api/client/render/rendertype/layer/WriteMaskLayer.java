package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.renderer.RenderStateShard;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/layer/WriteMaskLayer.class */
public final class WriteMaskLayer extends Record implements RenderTypeLayer {
    private final boolean color;
    private final boolean depth;
    public static final MapCodec<WriteMaskLayer> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.BOOL.optionalFieldOf("color", true).forGetter((v0) -> {
            return v0.color();
        }), Codec.BOOL.optionalFieldOf("depth", true).forGetter((v0) -> {
            return v0.depth();
        })).apply(instance, (v1, v2) -> {
            return new WriteMaskLayer(v1, v2);
        });
    });

    public WriteMaskLayer(boolean color, boolean depth) {
        this.color = color;
        this.depth = depth;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, WriteMaskLayer.class), WriteMaskLayer.class, "color;depth", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/WriteMaskLayer;->color:Z", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/WriteMaskLayer;->depth:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, WriteMaskLayer.class), WriteMaskLayer.class, "color;depth", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/WriteMaskLayer;->color:Z", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/WriteMaskLayer;->depth:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, WriteMaskLayer.class, Object.class), WriteMaskLayer.class, "color;depth", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/WriteMaskLayer;->color:Z", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/WriteMaskLayer;->depth:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public boolean color() {
        return this.color;
    }

    public boolean depth() {
        return this.depth;
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) {
        RenderStateShard.WriteMaskStateShard shard;
        if (this.color && this.depth) {
            shard = VeilRenderType.colorDepthWriteShard();
        } else if (this.color) {
            shard = VeilRenderType.colorWriteShard();
        } else if (this.depth) {
            shard = VeilRenderType.depthWriteShard();
        } else {
            shard = VeilRenderType.NO_WRITE;
        }
        builder.writeMaskState(shard);
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.WRITE_MASK.get();
    }
}
