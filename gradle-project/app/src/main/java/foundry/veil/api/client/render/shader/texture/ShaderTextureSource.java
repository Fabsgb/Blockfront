package foundry.veil.api.client.render.shader.texture;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.VeilRenderer;
import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.texture.TextureFilter;
import foundry.veil.api.util.EnumCodec;
import foundry.veil.impl.client.render.dynamicbuffer.DynamicBufferManager;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/texture/ShaderTextureSource.class */
public interface ShaderTextureSource {
    public static final Codec<ShaderTextureSource> CODEC = Codec.either(ResourceLocation.CODEC, Type.CODEC.dispatch((v0) -> {
        return v0.type();
    }, (v0) -> {
        return v0.codec();
    })).xmap(either -> {
        return (ShaderTextureSource) either.map(name -> {
            return new LocationSource(name, null);
        }, right -> {
            return right;
        });
    }, source -> {
        if (!(source instanceof LocationSource)) {
            return Either.right(source);
        }
        LocationSource loc = (LocationSource) source;
        return Either.left(loc.location());
    });
    public static final Context GLOBAL_CONTEXT = name -> {
        return VeilRenderSystem.renderer().getFramebufferManager().getFramebuffer(name);
    };

    int getId(Context context);

    int getTarget(Context context);

    @Nullable
    TextureFilter filter();

    Type type();

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/texture/ShaderTextureSource$Type.class */
    public enum Type {
        LOCATION(LocationSource.CODEC),
        FRAMEBUFFER(FramebufferSource.CODEC);

        private final MapCodec<? extends ShaderTextureSource> codec;
        public static final Codec<Type> CODEC = EnumCodec.builder("texture type").values(Type.class).build();

        Type(MapCodec mapCodec) {
            this.codec = mapCodec;
        }

        public MapCodec<? extends ShaderTextureSource> codec() {
            return this.codec;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/texture/ShaderTextureSource$Context.class */
    @FunctionalInterface
    public interface Context {
        @Nullable
        AdvancedFbo getFramebuffer(ResourceLocation resourceLocation);

        default int getTexture(ResourceLocation name) {
            if (Veil.MODID.equals(name.getNamespace()) && name.getPath().startsWith("dynamic_buffer")) {
                DynamicBufferManager bufferManger = VeilRenderSystem.renderer().getDynamicBufferManger();
                if (name.equals(VeilRenderer.ALBEDO_BUFFER_TEXTURE)) {
                    return bufferManger.getBufferTexture(DynamicBufferType.ALBEDO);
                }
                if (name.equals(VeilRenderer.NORMAL_BUFFER_TEXTURE)) {
                    return bufferManger.getBufferTexture(DynamicBufferType.NORMAL);
                }
                if (name.equals(VeilRenderer.LIGHT_UV_BUFFER_TEXTURE)) {
                    return bufferManger.getBufferTexture(DynamicBufferType.LIGHT_UV);
                }
                if (name.equals(VeilRenderer.LIGHT_COLOR_BUFFER_TEXTURE)) {
                    return bufferManger.getBufferTexture(DynamicBufferType.LIGHT_COLOR);
                }
                if (name.equals(VeilRenderer.DEBUG_BUFFER_TEXTURE)) {
                    return bufferManger.getBufferTexture(DynamicBufferType.DEBUG);
                }
            }
            return Minecraft.getInstance().getTextureManager().getTexture(name).getId();
        }

        default int getTextureTarget(ResourceLocation name) {
            if (Veil.MODID.equals(name.getNamespace()) && name.getPath().startsWith("dynamic_buffer")) {
                return 3553;
            }
            return Minecraft.getInstance().getTextureManager().getTexture(name).getTextureTarget();
        }
    }
}
