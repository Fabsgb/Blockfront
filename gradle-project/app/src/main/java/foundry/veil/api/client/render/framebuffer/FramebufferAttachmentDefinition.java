package foundry.veil.api.client.render.framebuffer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.render.texture.TextureFilter;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Optional;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition.class */
public final class FramebufferAttachmentDefinition extends Record {
    private final Type type;
    private final Format format;
    private final boolean depth;
    private final TextureFilter filter;
    private final int levels;

    @Nullable
    private final String name;
    public static final Codec<FramebufferAttachmentDefinition> COLOR_CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(Type.CODEC.optionalFieldOf("type", Type.TEXTURE).forGetter((v0) -> {
            return v0.type();
        }), Format.CODEC.optionalFieldOf("format", Format.RGBA8).forGetter((v0) -> {
            return v0.format();
        }), TextureFilter.CLAMP_DEFAULT_CODEC.optionalFieldOf("filter", TextureFilter.CLAMP).forGetter((v0) -> {
            return v0.filter();
        }), Codec.intRange(1, Integer.MAX_VALUE).optionalFieldOf("levels", 1).forGetter((v0) -> {
            return v0.levels();
        }), Codec.STRING.optionalFieldOf("name").forGetter(attachment -> {
            return Optional.ofNullable(attachment.name());
        })).apply(instance, (type, format, filter, levels, name) -> {
            return new FramebufferAttachmentDefinition(type, format, false, filter, levels.intValue(), (String) name.orElse(null));
        });
    });
    public static final Codec<FramebufferAttachmentDefinition> DEPTH_CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(Type.CODEC.optionalFieldOf("type", Type.TEXTURE).forGetter((v0) -> {
            return v0.type();
        }), Format.CODEC.optionalFieldOf("format", Format.DEPTH_COMPONENT).forGetter((v0) -> {
            return v0.format();
        }), TextureFilter.CLAMP_DEFAULT_CODEC.optionalFieldOf("filter", TextureFilter.CLAMP).forGetter((v0) -> {
            return v0.filter();
        }), Codec.intRange(1, Integer.MAX_VALUE).optionalFieldOf("levels", 1).forGetter((v0) -> {
            return v0.levels();
        }), Codec.STRING.optionalFieldOf("name").forGetter(attachment -> {
            return Optional.ofNullable(attachment.name());
        })).apply(instance, (type, format, filter, levels, name) -> {
            return new FramebufferAttachmentDefinition(type, format, true, filter, levels.intValue(), (String) name.orElse(null));
        });
    });

    public FramebufferAttachmentDefinition(Type type, Format format, boolean depth, TextureFilter filter, int levels, @Nullable String name) {
        this.type = type;
        this.format = format;
        this.depth = depth;
        this.filter = filter;
        this.levels = levels;
        this.name = name;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FramebufferAttachmentDefinition.class), FramebufferAttachmentDefinition.class, "type;format;depth;filter;levels;name", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->type:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition$Type;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->format:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition$Format;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->depth:Z", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->filter:Lfoundry/veil/api/client/render/texture/TextureFilter;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->levels:I", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->name:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FramebufferAttachmentDefinition.class), FramebufferAttachmentDefinition.class, "type;format;depth;filter;levels;name", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->type:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition$Type;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->format:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition$Format;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->depth:Z", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->filter:Lfoundry/veil/api/client/render/texture/TextureFilter;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->levels:I", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->name:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FramebufferAttachmentDefinition.class, Object.class), FramebufferAttachmentDefinition.class, "type;format;depth;filter;levels;name", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->type:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition$Type;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->format:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition$Format;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->depth:Z", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->filter:Lfoundry/veil/api/client/render/texture/TextureFilter;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->levels:I", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition;->name:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Type type() {
        return this.type;
    }

    public Format format() {
        return this.format;
    }

    public boolean depth() {
        return this.depth;
    }

    public TextureFilter filter() {
        return this.filter;
    }

    public int levels() {
        return this.levels;
    }

    @Nullable
    public String name() {
        return this.name;
    }

    public boolean isCompactDepthAttachment() {
        return this.type == Type.TEXTURE && this.format == Format.DEPTH_COMPONENT && this.filter.equals(TextureFilter.CLAMP) && this.levels == 1 && this.name == null;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition$Type.class */
    public enum Type {
        TEXTURE("Texture"),
        RENDER_BUFFER("Render Buffer");

        public static final Type[] VALUES = values();
        public static final Codec<Type> CODEC = Codec.STRING.flatXmap(name -> {
            for (Type type : VALUES) {
                if (type.name().equalsIgnoreCase(name)) {
                    return DataResult.success(type);
                }
            }
            return DataResult.error(() -> {
                return "Unknown attachment type: " + name;
            });
        }, type -> {
            return DataResult.success(type.name());
        });
        private final String displayName;

        Type(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return this.displayName;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/framebuffer/FramebufferAttachmentDefinition$Format.class */
    public enum Format {
        RED(6403, 6403),
        RG(33319, 33319),
        RGB(6407, 6407),
        BGR(32992, 32992),
        RGBA(6408, 6408),
        BGRA(32993, 32993),
        DEPTH_COMPONENT(6402, 6402),
        DEPTH_STENCIL(34041, 34041),
        R8(6403, 33321),
        R8_SNORM(6403, 36756),
        R16(6403, 33322),
        R16_SNORM(6403, 36760),
        RG8(33319, 33323),
        RG8_SNORM(33319, 36757),
        RG16(33319, 33324),
        RG16_SNORM(33319, 36761),
        R3_G3_B2(6407, 10768),
        RGB4(6407, 32847),
        RGB5(6407, 32848),
        RGB565(6407, 36194),
        RGB8(6407, 32849),
        RGB8_SNORM(6407, 36758),
        RGB10(6407, 32850),
        RGB12(6407, 32851),
        RGB16(6407, 32852),
        RGB16_SNORM(6407, 36762),
        RGBA2(6408, 32853),
        RGBA4(6408, 32854),
        RGB5_A1(6408, 32855),
        RGBA8(6408, 32856),
        RGBA8_SNORM(6408, 36759),
        RGB10_A2(6408, 32857),
        RGB10_A2UI(36249, 36975),
        RGBA12(6408, 32858),
        RGBA16(6408, 32859),
        RGBA16_SNORM(6408, 36763),
        SRGB(6407, 35904),
        SRGB8(6407, 35905),
        SRGB_ALPHA(6408, 35906),
        SRGB8_ALPHA8(6408, 35907),
        COMPRESSED_SRGB(6407, 35912),
        COMPRESSED_SRGB_ALPHA(6408, 35913),
        R16F(6403, 33325),
        RG16F(33319, 33327),
        RGB16F(6407, 34843),
        RGBA16F(6408, 34842),
        R32F(6403, 33326),
        RG32F(33319, 33326),
        RGB32F(6407, 34837),
        RGB9_E5(6407, 35901),
        RGBA32F(6408, 34836),
        R11F_G11F_B10F(6408, 35898),
        R8I(36244, 33329),
        R8UI(36244, 33330),
        R16I(36244, 33331),
        R16UI(36244, 33332),
        R32I(36244, 33333),
        R32UI(36244, 33334),
        RG8I(33320, 33335),
        RG8UI(33320, 33336),
        RG16I(33320, 33337),
        RG16UI(33320, 33338),
        RG32I(33320, 33339),
        RG32UI(33320, 33340),
        RGB8I(36248, 36239),
        RGB8UI(36248, 36221),
        RGB16I(36248, 36233),
        RGB16UI(36248, 36215),
        RGB32I(36248, 36227),
        RGB32UI(36248, 36209),
        RGBA8I(36249, 36238),
        RGBA8UI(36249, 36220),
        RGBA16I(36249, 36232),
        RGBA16UI(36249, 36214),
        RGBA32I(36249, 36226),
        RGBA32UI(36249, 36208),
        DEPTH_COMPONENT16(6402, 33189),
        DEPTH_COMPONENT24(6402, 33190),
        DEPTH_COMPONENT32(6402, 33191),
        DEPTH_COMPONENT32F(6402, 36012),
        DEPTH24_STENCIL8(34041, 35056),
        DEPTH32F_STENCIL8(34041, 36013);

        public static final Format[] VALUES = values();
        public static final Codec<Format> CODEC = Codec.STRING.flatXmap(name -> {
            for (Format type : VALUES) {
                if (type.name().equalsIgnoreCase(name)) {
                    return DataResult.success(type);
                }
            }
            return DataResult.error(() -> {
                return "Unknown attachment format: " + name;
            });
        }, type -> {
            return DataResult.success(type.name());
        });

        /* JADX INFO: renamed from: id */
        private final int f9132id;
        private final int internalId;

        Format(int id, int internalId) {
            this.f9132id = id;
            this.internalId = internalId;
        }

        public int getFormat() {
            return this.f9132id;
        }

        public int getInternalFormat() {
            return this.internalId;
        }
    }
}
