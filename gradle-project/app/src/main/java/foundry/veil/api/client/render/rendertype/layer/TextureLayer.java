package foundry.veil.api.client.render.rendertype.layer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.registry.RenderTypeLayerRegistry;
import foundry.veil.api.client.render.rendertype.VeilRenderTypeBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.ResourceLocationException;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/rendertype/layer/TextureLayer.class */
public final class TextureLayer extends Record implements RenderTypeLayer {
    private final LayerTemplateValue<ResourceLocation> texture;
    private final boolean blur;
    private final boolean mipmap;
    public static final MapCodec<TextureLayer> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(LayerTemplateValue.LOCATION_CODEC.fieldOf("texture").forGetter((v0) -> {
            return v0.texture();
        }), Codec.BOOL.optionalFieldOf("blur", false).forGetter((v0) -> {
            return v0.blur();
        }), Codec.BOOL.optionalFieldOf("mipmap", false).forGetter((v0) -> {
            return v0.mipmap();
        })).apply(instance, (v1, v2, v3) -> {
            return new TextureLayer(v1, v2, v3);
        });
    });

    public TextureLayer(LayerTemplateValue<ResourceLocation> texture, boolean blur, boolean mipmap) {
        this.texture = texture;
        this.blur = blur;
        this.mipmap = mipmap;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, TextureLayer.class), TextureLayer.class, "texture;blur;mipmap", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/TextureLayer;->texture:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/TextureLayer;->blur:Z", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/TextureLayer;->mipmap:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, TextureLayer.class), TextureLayer.class, "texture;blur;mipmap", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/TextureLayer;->texture:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/TextureLayer;->blur:Z", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/TextureLayer;->mipmap:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, TextureLayer.class, Object.class), TextureLayer.class, "texture;blur;mipmap", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/TextureLayer;->texture:Lfoundry/veil/api/client/render/rendertype/layer/LayerTemplateValue;", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/TextureLayer;->blur:Z", "FIELD:Lfoundry/veil/api/client/render/rendertype/layer/TextureLayer;->mipmap:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public LayerTemplateValue<ResourceLocation> texture() {
        return this.texture;
    }

    public boolean blur() {
        return this.blur;
    }

    public boolean mipmap() {
        return this.mipmap;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: net.minecraft.ResourceLocationException */
    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public void addShard(VeilRenderTypeBuilder builder, Object... params) throws ResourceLocationException {
        ResourceLocation location = this.texture.parse(params);
        builder.textureState(new RenderStateShard.TextureStateShard(location, this.blur, this.blur));
    }

    @Override // foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer
    public RenderTypeLayerRegistry.LayerType<?> getType() {
        return RenderTypeLayerRegistry.TEXTURE.get();
    }
}
