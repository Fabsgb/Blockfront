package foundry.veil.api.client.render.texture;

import com.boehmod.blockfront.InterfaceC1274xN;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.color.Color;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.util.EnumCodec;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Optional;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.GL14C;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.system.MemoryStack;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/texture/TextureFilter.class */
public final class TextureFilter extends Record {
    private final boolean blur;
    private final boolean mipmap;
    private final float anisotropy;

    @Nullable
    private final CompareFunction compareFunction;
    private final Wrap wrapX;
    private final Wrap wrapY;
    private final Wrap wrapZ;
    private final int borderColor;
    private final EdgeType borderType;
    private final boolean seamless;
    public static final Codec<TextureFilter> REPEAT_DEFAULT_CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.BOOL.optionalFieldOf("blur", false).forGetter((v0) -> {
            return v0.blur();
        }), Codec.BOOL.optionalFieldOf("mipmap", false).forGetter((v0) -> {
            return v0.mipmap();
        }), Codec.FLOAT.optionalFieldOf("anisotropy", Float.valueOf(1.0f)).forGetter((v0) -> {
            return v0.anisotropy();
        }), CompareFunction.CODEC.optionalFieldOf("compareFunction").forGetter(options -> {
            return Optional.ofNullable(options.compareFunction());
        }), Wrap.CODEC.optionalFieldOf("wrapX", Wrap.REPEAT).forGetter((v0) -> {
            return v0.wrapX();
        }), Wrap.CODEC.optionalFieldOf("wrapY", Wrap.REPEAT).forGetter((v0) -> {
            return v0.wrapY();
        }), Wrap.CODEC.optionalFieldOf("wrapZ", Wrap.REPEAT).forGetter((v0) -> {
            return v0.wrapZ();
        }), Color.ARGB_INT_CODEC.optionalFieldOf("borderColor", -16777216).forGetter((v0) -> {
            return v0.borderColor();
        }), EdgeType.CODEC.optionalFieldOf("borderType", EdgeType.FLOAT).forGetter((v0) -> {
            return v0.borderType();
        }), Codec.BOOL.optionalFieldOf("seamless", false).forGetter((v0) -> {
            return v0.seamless();
        })).apply(instance, (blur, mipmap, anisotropy, compareFunction, wrapX, wrapY, wrapZ, edgeColor, edgeType, seamless) -> {
            return new TextureFilter(blur.booleanValue(), mipmap.booleanValue(), anisotropy.floatValue(), (CompareFunction) compareFunction.orElse(null), wrapX, wrapY, wrapZ, edgeColor.intValue(), edgeType, seamless.booleanValue());
        });
    });
    public static final Codec<TextureFilter> CLAMP_DEFAULT_CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.BOOL.optionalFieldOf("blur", false).forGetter((v0) -> {
            return v0.blur();
        }), Codec.BOOL.optionalFieldOf("mipmap", false).forGetter((v0) -> {
            return v0.mipmap();
        }), Codec.FLOAT.optionalFieldOf("anisotropy", Float.valueOf(1.0f)).forGetter((v0) -> {
            return v0.anisotropy();
        }), CompareFunction.CODEC.optionalFieldOf("compareFunction").forGetter(options -> {
            return Optional.ofNullable(options.compareFunction());
        }), Wrap.CODEC.optionalFieldOf("wrapX", Wrap.CLAMP_TO_EDGE).forGetter((v0) -> {
            return v0.wrapX();
        }), Wrap.CODEC.optionalFieldOf("wrapY", Wrap.CLAMP_TO_EDGE).forGetter((v0) -> {
            return v0.wrapY();
        }), Wrap.CODEC.optionalFieldOf("wrapZ", Wrap.CLAMP_TO_EDGE).forGetter((v0) -> {
            return v0.wrapZ();
        }), Color.ARGB_INT_CODEC.optionalFieldOf("borderColor", -16777216).forGetter((v0) -> {
            return v0.borderColor();
        }), EdgeType.CODEC.optionalFieldOf("borderType", EdgeType.FLOAT).forGetter((v0) -> {
            return v0.borderType();
        }), Codec.BOOL.optionalFieldOf("seamless", false).forGetter((v0) -> {
            return v0.seamless();
        })).apply(instance, (blur, mipmap, anisotropy, compareFunction, wrapX, wrapY, wrapZ, edgeColor, edgeType, seamless) -> {
            return new TextureFilter(blur.booleanValue(), mipmap.booleanValue(), anisotropy.floatValue(), (CompareFunction) compareFunction.orElse(null), wrapX, wrapY, wrapZ, edgeColor.intValue(), edgeType, seamless.booleanValue());
        });
    });
    public static final TextureFilter REPEAT = new TextureFilter(false, false, 1.0f, null, Wrap.REPEAT, Wrap.REPEAT, Wrap.REPEAT, -16777216, EdgeType.FLOAT, false);
    public static final TextureFilter CLAMP = new TextureFilter(false, false, 1.0f, null, Wrap.CLAMP_TO_EDGE, Wrap.CLAMP_TO_EDGE, Wrap.CLAMP_TO_EDGE, -16777216, EdgeType.FLOAT, false);

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/texture/TextureFilter$EdgeType.class */
    public enum EdgeType {
        FLOAT,
        INT,
        UINT;

        public static final Codec<EdgeType> CODEC = EnumCodec.builder("Edge Data Type").values(EdgeType.class).build();
    }

    public TextureFilter(boolean blur, boolean mipmap, float anisotropy, @Nullable CompareFunction compareFunction, Wrap wrapX, Wrap wrapY, Wrap wrapZ, int borderColor, EdgeType borderType, boolean seamless) {
        this.blur = blur;
        this.mipmap = mipmap;
        this.anisotropy = anisotropy;
        this.compareFunction = compareFunction;
        this.wrapX = wrapX;
        this.wrapY = wrapY;
        this.wrapZ = wrapZ;
        this.borderColor = borderColor;
        this.borderType = borderType;
        this.seamless = seamless;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, TextureFilter.class), TextureFilter.class, "blur;mipmap;anisotropy;compareFunction;wrapX;wrapY;wrapZ;borderColor;borderType;seamless", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->blur:Z", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->mipmap:Z", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->anisotropy:F", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->compareFunction:Lfoundry/veil/api/client/render/texture/TextureFilter$CompareFunction;", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->wrapX:Lfoundry/veil/api/client/render/texture/TextureFilter$Wrap;", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->wrapY:Lfoundry/veil/api/client/render/texture/TextureFilter$Wrap;", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->wrapZ:Lfoundry/veil/api/client/render/texture/TextureFilter$Wrap;", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->borderColor:I", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->borderType:Lfoundry/veil/api/client/render/texture/TextureFilter$EdgeType;", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->seamless:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, TextureFilter.class), TextureFilter.class, "blur;mipmap;anisotropy;compareFunction;wrapX;wrapY;wrapZ;borderColor;borderType;seamless", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->blur:Z", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->mipmap:Z", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->anisotropy:F", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->compareFunction:Lfoundry/veil/api/client/render/texture/TextureFilter$CompareFunction;", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->wrapX:Lfoundry/veil/api/client/render/texture/TextureFilter$Wrap;", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->wrapY:Lfoundry/veil/api/client/render/texture/TextureFilter$Wrap;", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->wrapZ:Lfoundry/veil/api/client/render/texture/TextureFilter$Wrap;", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->borderColor:I", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->borderType:Lfoundry/veil/api/client/render/texture/TextureFilter$EdgeType;", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->seamless:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, TextureFilter.class, Object.class), TextureFilter.class, "blur;mipmap;anisotropy;compareFunction;wrapX;wrapY;wrapZ;borderColor;borderType;seamless", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->blur:Z", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->mipmap:Z", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->anisotropy:F", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->compareFunction:Lfoundry/veil/api/client/render/texture/TextureFilter$CompareFunction;", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->wrapX:Lfoundry/veil/api/client/render/texture/TextureFilter$Wrap;", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->wrapY:Lfoundry/veil/api/client/render/texture/TextureFilter$Wrap;", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->wrapZ:Lfoundry/veil/api/client/render/texture/TextureFilter$Wrap;", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->borderColor:I", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->borderType:Lfoundry/veil/api/client/render/texture/TextureFilter$EdgeType;", "FIELD:Lfoundry/veil/api/client/render/texture/TextureFilter;->seamless:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public boolean blur() {
        return this.blur;
    }

    public boolean mipmap() {
        return this.mipmap;
    }

    @Nullable
    public CompareFunction compareFunction() {
        return this.compareFunction;
    }

    public Wrap wrapX() {
        return this.wrapX;
    }

    public Wrap wrapY() {
        return this.wrapY;
    }

    public Wrap wrapZ() {
        return this.wrapZ;
    }

    public int borderColor() {
        return this.borderColor;
    }

    public EdgeType borderType() {
        return this.borderType;
    }

    public boolean seamless() {
        return this.seamless;
    }

    public float anisotropy() {
        return Math.min(this.anisotropy, VeilRenderSystem.maxTextureAnisotropy());
    }

    public int minFilter() {
        if (this.blur) {
            return this.mipmap ? 9987 : 9729;
        }
        return this.mipmap ? 9986 : 9728;
    }

    public int magFilter() {
        return this.blur ? 9729 : 9728;
    }

    public void applyToTextureTarget(int target) {
        GL14C.glTexParameteri(target, 10241, minFilter());
        GL14C.glTexParameteri(target, 10240, magFilter());
        if (VeilRenderSystem.textureAnisotropySupported()) {
            GL14C.glTexParameterf(target, 34046, anisotropy());
        }
        if (this.compareFunction != null) {
            GL14C.glTexParameteri(target, 34892, 34894);
            GL14C.glTexParameteri(target, 34893, this.compareFunction.f9140id);
        } else {
            GL14C.glTexParameteri(target, 34892, 0);
        }
        GL14C.glTexParameteri(target, 10242, this.wrapX.f9141id);
        GL14C.glTexParameteri(target, 10243, this.wrapY.f9141id);
        GL14C.glTexParameteri(target, 32882, this.wrapZ.f9141id);
        MemoryStack stack = MemoryStack.stackPush();
        try {
            switch (this.borderType) {
                case FLOAT:
                    GL14C.glTexParameterfv(target, 4100, stack.floats(((this.borderColor >> 16) & 255) / 255.0f, ((this.borderColor >> 8) & 255) / 255.0f, (this.borderColor & 255) / 255.0f, ((this.borderColor >> 24) & 255) / 255.0f));
                    break;
                case INT:
                    GL33C.glTexParameterIiv(target, 4100, stack.ints((this.borderColor >> 16) & 255, (this.borderColor >> 8) & 255, this.borderColor & 255, (this.borderColor >> 24) & 255));
                    break;
                case UINT:
                    GL33C.glTexParameterIuiv(target, 4100, stack.ints((this.borderColor >> 16) & 255, (this.borderColor >> 8) & 255, this.borderColor & 255, (this.borderColor >> 24) & 255));
                    break;
            }
            if (stack != null) {
                stack.close();
            }
            if (VeilRenderSystem.textureCubeMapSeamlessSupported()) {
                GL14C.glTexParameteri(target, 34895, this.seamless ? 1 : 0);
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void applyToTexture(int texture) {
        ARBDirectStateAccess.glTextureParameteri(texture, 10241, minFilter());
        ARBDirectStateAccess.glTextureParameteri(texture, 10240, magFilter());
        if (VeilRenderSystem.textureAnisotropySupported()) {
            ARBDirectStateAccess.glTextureParameterf(texture, 34046, anisotropy());
        }
        if (this.compareFunction != null) {
            ARBDirectStateAccess.glTextureParameteri(texture, 34892, 34894);
            ARBDirectStateAccess.glTextureParameteri(texture, 34893, this.compareFunction.f9140id);
        } else {
            ARBDirectStateAccess.glTextureParameteri(texture, 34892, 0);
        }
        ARBDirectStateAccess.glTextureParameteri(texture, 10242, this.wrapX.f9141id);
        ARBDirectStateAccess.glTextureParameteri(texture, 10243, this.wrapY.f9141id);
        ARBDirectStateAccess.glTextureParameteri(texture, 32882, this.wrapZ.f9141id);
        MemoryStack stack = MemoryStack.stackPush();
        try {
            switch (this.borderType) {
                case FLOAT:
                    ARBDirectStateAccess.glTextureParameterfv(texture, 4100, stack.floats(((this.borderColor >> 16) & 255) / 255.0f, ((this.borderColor >> 8) & 255) / 255.0f, (this.borderColor & 255) / 255.0f, ((this.borderColor >> 24) & 255) / 255.0f));
                    break;
                case INT:
                    ARBDirectStateAccess.glTextureParameterIiv(texture, 4100, stack.ints((this.borderColor >> 16) & 255, (this.borderColor >> 8) & 255, this.borderColor & 255, (this.borderColor >> 24) & 255));
                    break;
                case UINT:
                    ARBDirectStateAccess.glTextureParameterIuiv(texture, 4100, stack.ints((this.borderColor >> 16) & 255, (this.borderColor >> 8) & 255, this.borderColor & 255, (this.borderColor >> 24) & 255));
                    break;
            }
            if (stack != null) {
                stack.close();
            }
            if (VeilRenderSystem.textureCubeMapSeamlessSupported()) {
                ARBDirectStateAccess.glTextureParameteri(texture, 34895, this.seamless ? 1 : 0);
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/texture/TextureFilter$CompareFunction.class */
    public enum CompareFunction {
        NEVER(InterfaceC1274xN.f6852vU),
        ALWAYS(519),
        LESS(513),
        LEQUAL(515),
        EQUAL(514),
        NOT_EQUAL(517),
        GEQUAL(518),
        GREATER(516);

        public static final Codec<CompareFunction> CODEC = EnumCodec.builder("Compare Function").values(CompareFunction.class).build();

        /* JADX INFO: renamed from: id */
        private final int f9140id;

        CompareFunction(int id) {
            this.f9140id = id;
        }

        public int getId() {
            return this.f9140id;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/texture/TextureFilter$Wrap.class */
    public enum Wrap {
        CLAMP_TO_EDGE(33071),
        CLAMP_TO_BORDER(33069),
        MIRRORED_REPEAT(33648),
        REPEAT(10497),
        MIRROR_CLAMP_TO_EDGE(34627);

        public static final Codec<Wrap> CODEC = EnumCodec.builder("Texture Wrap").values(Wrap.class).build();
        public static final Int2ObjectMap<Wrap> BY_GL_ID;

        /* JADX INFO: renamed from: id */
        private final int f9141id;

        static {
            Int2ObjectArrayMap int2ObjectArrayMap = new Int2ObjectArrayMap();
            for (Wrap filter : values()) {
                int2ObjectArrayMap.put(filter.f9141id, filter);
            }
            BY_GL_ID = Int2ObjectMaps.unmodifiable(int2ObjectArrayMap);
        }

        Wrap(int id) {
            this.f9141id = id;
        }

        public int getId() {
            if (this != MIRROR_CLAMP_TO_EDGE || VeilRenderSystem.textureMirrorClampToEdgeSupported()) {
                return this.f9141id;
            }
            return 33071;
        }
    }
}
