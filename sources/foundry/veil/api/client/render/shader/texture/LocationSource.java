package foundry.veil.api.client.render.shader.texture;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.render.texture.TextureFilter;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/texture/LocationSource.class */
public final class LocationSource extends Record implements ShaderTextureSource {
    private final ResourceLocation location;

    @Nullable
    private final TextureFilter filter;
    public static final MapCodec<LocationSource> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("location").forGetter((v0) -> {
            return v0.location();
        }), TextureFilter.REPEAT_DEFAULT_CODEC.optionalFieldOf("filter").forGetter(source -> {
            return Optional.ofNullable(source.filter);
        })).apply(instance, (location, filter) -> {
            return new LocationSource(location, (TextureFilter) filter.orElse(null));
        });
    });

    public LocationSource(ResourceLocation location, @Nullable TextureFilter filter) {
        this.location = location;
        this.filter = filter;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, LocationSource.class), LocationSource.class, "location;filter", "FIELD:Lfoundry/veil/api/client/render/shader/texture/LocationSource;->location:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/texture/LocationSource;->filter:Lfoundry/veil/api/client/render/texture/TextureFilter;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, LocationSource.class), LocationSource.class, "location;filter", "FIELD:Lfoundry/veil/api/client/render/shader/texture/LocationSource;->location:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/texture/LocationSource;->filter:Lfoundry/veil/api/client/render/texture/TextureFilter;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, LocationSource.class, Object.class), LocationSource.class, "location;filter", "FIELD:Lfoundry/veil/api/client/render/shader/texture/LocationSource;->location:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/texture/LocationSource;->filter:Lfoundry/veil/api/client/render/texture/TextureFilter;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public ResourceLocation location() {
        return this.location;
    }

    @Override // foundry.veil.api.client.render.shader.texture.ShaderTextureSource
    @Nullable
    public TextureFilter filter() {
        return this.filter;
    }

    @Override // foundry.veil.api.client.render.shader.texture.ShaderTextureSource
    public int getId(ShaderTextureSource.Context context) {
        return context.getTexture(this.location);
    }

    @Override // foundry.veil.api.client.render.shader.texture.ShaderTextureSource
    public int getTarget(ShaderTextureSource.Context context) {
        return context.getTextureTarget(this.location);
    }

    @Override // foundry.veil.api.client.render.shader.texture.ShaderTextureSource
    public ShaderTextureSource.Type type() {
        return ShaderTextureSource.Type.LOCATION;
    }
}
