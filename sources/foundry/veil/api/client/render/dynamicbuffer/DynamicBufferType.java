package foundry.veil.api.client.render.dynamicbuffer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import foundry.veil.api.client.render.framebuffer.FramebufferAttachmentDefinition;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeStringWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/dynamicbuffer/DynamicBufferType.class */
public enum DynamicBufferType {
    ALBEDO("Albedo", GlslTypeSpecifier.BuiltinType.VEC4, FramebufferAttachmentDefinition.Format.RGBA8),
    NORMAL("Normal", GlslTypeSpecifier.BuiltinType.VEC4, FramebufferAttachmentDefinition.Format.RGB8_SNORM),
    LIGHT_UV("LightUV", GlslTypeSpecifier.BuiltinType.VEC4, FramebufferAttachmentDefinition.Format.RG8),
    LIGHT_COLOR("LightColor", GlslTypeSpecifier.BuiltinType.VEC4, FramebufferAttachmentDefinition.Format.RGB8),
    DEBUG("Debug", GlslTypeSpecifier.BuiltinType.VEC4, FramebufferAttachmentDefinition.Format.RGBA16F);

    private static final DynamicBufferType[] BUFFERS = values();
    private static final int MASK = (1 << BUFFERS.length) - 1;
    public static final Codec<DynamicBufferType> CODEC = Codec.STRING.flatXmap(name -> {
        for (DynamicBufferType buffer : BUFFERS) {
            if (buffer.getName().equals(name)) {
                return DataResult.success(buffer);
            }
        }
        return DataResult.error(() -> {
            return "Unknown dynamic buffer: " + name + ". Valid buffers: " + ((String) Arrays.stream(BUFFERS).map((v0) -> {
                return v0.getName();
            }).collect(Collectors.joining(", ")));
        });
    }, buffer -> {
        return DataResult.success(buffer.getName());
    });
    public static final Codec<Integer> PACKED_LIST_CODEC = CODEC.listOf().xmap(buffers -> {
        int mask = 0;
        Iterator it = buffers.iterator();
        while (it.hasNext()) {
            DynamicBufferType buffer = (DynamicBufferType) it.next();
            mask |= buffer.mask;
        }
        return Integer.valueOf(mask);
    }, mask -> {
        return Arrays.asList(decode(mask.intValue()));
    });
    private final String sourceName;
    private final GlslTypeSpecifier.BuiltinType type;
    private final String typeGlsl;
    private final int internalFormat;
    private final int texelFormat;
    private final int mask;
    private final String name = name().toLowerCase(Locale.ROOT);
    private final String macroName = "VEIL_" + name();

    DynamicBufferType(String sourceName, GlslTypeSpecifier.BuiltinType type, FramebufferAttachmentDefinition.Format format) {
        this.sourceName = "VeilDynamic" + sourceName;
        this.type = type;
        GlslNodeStringWriter writer = new GlslNodeStringWriter(true);
        writer.visitTypeSpecifier(type);
        this.typeGlsl = writer.toString();
        this.internalFormat = format.getInternalFormat();
        this.texelFormat = format.getFormat();
        this.mask = 1 << ordinal();
    }

    public String getName() {
        return this.name;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public String getOutputDeclaration(int location) {
        return "layout(location = " + location + ") out " + this.typeGlsl + " " + this.sourceName;
    }

    public GlslTypeSpecifier.BuiltinType getType() {
        return this.type;
    }

    public String getTypeGlsl() {
        return this.typeGlsl;
    }

    public int getInternalFormat() {
        return this.internalFormat;
    }

    public int getTexelFormat() {
        return this.texelFormat;
    }

    public int getMask() {
        return this.mask;
    }

    public String getMacroName() {
        return this.macroName;
    }

    public static void addMacros(int mask, Map<String, String> map) {
        for (DynamicBufferType value : BUFFERS) {
            if ((value.mask & mask) != 0) {
                map.put(value.getMacroName(), "1");
            }
        }
    }

    public static int encode(DynamicBufferType... types) {
        int mask = 0;
        for (DynamicBufferType type : types) {
            mask |= type.mask;
        }
        return mask;
    }

    public static DynamicBufferType[] decode(int mask) {
        int next = 0;
        DynamicBufferType[] types = new DynamicBufferType[Integer.bitCount(mask & MASK)];
        for (DynamicBufferType value : BUFFERS) {
            if ((value.mask & mask) != 0) {
                int i = next;
                next++;
                types[i] = value;
            }
        }
        return types;
    }
}
