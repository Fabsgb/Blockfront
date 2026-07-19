package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;
import net.minecraft.client.renderer.RenderStateShard;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/rendertype/layer/MultiTextureLayer.class */
public final class MultiTextureLayer extends Record implements RenderTypeLayer {
    private final TextureLayer[] textures;
    public static final MapCodec<MultiTextureLayer> CODEC = TextureLayer.CODEC.codec().listOf(2, 12).fieldOf("textures").xmap(textures -> {
        return new MultiTextureLayer((TextureLayer[]) textures.toArray(x$0 -> {
            return new TextureLayer[x$0];
        }));
    }, layer -> {
        return Arrays.asList(layer.textures);
    });

    public MultiTextureLayer(TextureLayer[] textures) {
        this.textures = textures;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, MultiTextureLayer.class), MultiTextureLayer.class, "textures", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/MultiTextureLayer;->textures:[Lfoundry/veil/api/client/render/rendertype/layer/TextureLayer;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, MultiTextureLayer.class), MultiTextureLayer.class, "textures", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/MultiTextureLayer;->textures:[Lfoundry/veil/api/client/render/rendertype/layer/TextureLayer;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, MultiTextureLayer.class, Object.class), MultiTextureLayer.class, "textures", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/MultiTextureLayer;->textures:[Lfoundry/veil/api/client/render/rendertype/layer/TextureLayer;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public TextureLayer[] textures() {
        return this.textures;
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) {
        RenderStateShard.MultiTextureStateShard.Builder textureBuilder = RenderStateShard.MultiTextureStateShard.builder();
        for (TextureLayer texture : this.textures) {
            textureBuilder.add(texture.texture().parse(params), texture.blur(), texture.mipmap());
        }
        builder.textureState(textureBuilder.build());
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.MULTI_TEXTURE.get();
    }
}
