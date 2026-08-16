package foundry.veil.api.client.render.shader.texture;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.texture.TextureFilter;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/texture/FramebufferSource.class */
public final class FramebufferSource extends Record implements ShaderTextureSource {
    private final ResourceLocation name;
    private final int sampler;
    private final boolean depth;

    @Nullable
    private final TextureFilter filter;
    public static final MapCodec<FramebufferSource> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.fieldOf("name").forGetter(source -> {
            return source.name.toString();
        }), Codec.INT.optionalFieldOf("sampler", 0).forGetter((v0) -> {
            return v0.sampler();
        }), TextureFilter.REPEAT_DEFAULT_CODEC.optionalFieldOf("filter").forGetter(source2 -> {
            return Optional.ofNullable(source2.filter);
        })).apply(instance, (name, sampler, filter) -> {
            boolean depth = name.endsWith(":depth");
            String path = depth ? name.substring(0, name.length() - 6) : name;
            ResourceLocation location = name.contains(":") ? ResourceLocation.parse(path) : ResourceLocation.fromNamespaceAndPath("temp", name);
            return new FramebufferSource(location, depth ? 0 : sampler.intValue(), depth, (TextureFilter) filter.orElse(null));
        });
    });

    public FramebufferSource(ResourceLocation name, int sampler, boolean depth, @Nullable TextureFilter filter) {
        this.name = name;
        this.sampler = sampler;
        this.depth = depth;
        this.filter = filter;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FramebufferSource.class), FramebufferSource.class, "name;sampler;depth;filter", "FIELD:Lfoundry/veil/api/client/render/shader/texture/FramebufferSource;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/texture/FramebufferSource;->sampler:I", "FIELD:Lfoundry/veil/api/client/render/shader/texture/FramebufferSource;->depth:Z", "FIELD:Lfoundry/veil/api/client/render/shader/texture/FramebufferSource;->filter:Lfoundry/veil/api/client/render/texture/TextureFilter;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FramebufferSource.class), FramebufferSource.class, "name;sampler;depth;filter", "FIELD:Lfoundry/veil/api/client/render/shader/texture/FramebufferSource;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/texture/FramebufferSource;->sampler:I", "FIELD:Lfoundry/veil/api/client/render/shader/texture/FramebufferSource;->depth:Z", "FIELD:Lfoundry/veil/api/client/render/shader/texture/FramebufferSource;->filter:Lfoundry/veil/api/client/render/texture/TextureFilter;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FramebufferSource.class, Object.class), FramebufferSource.class, "name;sampler;depth;filter", "FIELD:Lfoundry/veil/api/client/render/shader/texture/FramebufferSource;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/api/client/render/shader/texture/FramebufferSource;->sampler:I", "FIELD:Lfoundry/veil/api/client/render/shader/texture/FramebufferSource;->depth:Z", "FIELD:Lfoundry/veil/api/client/render/shader/texture/FramebufferSource;->filter:Lfoundry/veil/api/client/render/texture/TextureFilter;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public ResourceLocation name() {
        return this.name;
    }

    public int sampler() {
        return this.sampler;
    }

    public boolean depth() {
        return this.depth;
    }

    @Override // foundry.veil.api.client.render.shader.texture.ShaderTextureSource
    @Nullable
    public TextureFilter filter() {
        return this.filter;
    }

    @Override // foundry.veil.api.client.render.shader.texture.ShaderTextureSource
    public int getId(ShaderTextureSource.Context context) {
        AdvancedFbo framebuffer = context.getFramebuffer(this.name);
        if (framebuffer == null) {
            return 0;
        }
        if (this.depth) {
            if (framebuffer.isDepthTextureAttachment()) {
                return framebuffer.getDepthTextureAttachment().getId();
            }
            return 0;
        }
        if (framebuffer.isColorTextureAttachment(this.sampler)) {
            return framebuffer.getColorTextureAttachment(this.sampler).getId();
        }
        return 0;
    }

    @Override // foundry.veil.api.client.render.shader.texture.ShaderTextureSource
    public int getTarget(ShaderTextureSource.Context context) {
        return 3553;
    }

    @Override // foundry.veil.api.client.render.shader.texture.ShaderTextureSource
    public ShaderTextureSource.Type type() {
        return ShaderTextureSource.Type.FRAMEBUFFER;
    }
}
