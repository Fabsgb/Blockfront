package foundry.veil.api.client.render.vertex;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import foundry.veil.api.client.render.VeilRenderSystem;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/vertex/VertexArrayBuilder.class */
public interface VertexArrayBuilder {
    VertexArray vertexArray();

    VertexArrayBuilder defineVertexBuffer(int i, int i2, int i3, int i4, int i5);

    VertexArrayBuilder setVertexAttribute(int i, int i2, int i3, DataType dataType, boolean z, int i4);

    VertexArrayBuilder setVertexIAttribute(int i, int i2, int i3, DataType dataType, int i4);

    VertexArrayBuilder setVertexLAttribute(int i, int i2, int i3, DataType dataType, int i4);

    VertexArrayBuilder removeVertexBuffer(int i);

    VertexArrayBuilder removeAttribute(int i);

    VertexArrayBuilder clearVertexBuffers();

    VertexArrayBuilder clearVertexAttributes();

    @ApiStatus.Internal
    static void validateRelativeOffset(int offset) {
        if (offset < 0 || offset > VeilRenderSystem.maxVertexAttributeRelativeOffset()) {
            throw new IllegalArgumentException("Vertex array attribute relative offset must be between 0 and " + VeilRenderSystem.maxVertexAttributeRelativeOffset() + ". Was " + offset);
        }
    }

    @ApiStatus.Internal
    static void validateFloatType(DataType type, int size) {
        if (!type.isSupported()) {
            throw new UnsupportedOperationException(String.valueOf(type) + " attributes not supported");
        }
        if (type == DataType.UNSIGNED_INT_10F_11F_11F_REV && size != 3) {
            throw new IllegalArgumentException("Invalid vertex attribute size. Must be 3: " + size);
        }
        if ((type == DataType.INT_2_10_10_10_REV || type == DataType.UNSIGNED_INT_2_10_10_10_REV) && size != 4 && size != 32993) {
            throw new IllegalArgumentException("Invalid vertex attribute size. Must be 4 or GL_BGRA: " + size);
        }
    }

    @ApiStatus.Internal
    static void validateIntType(DataType type) {
        if (!type.isSupported()) {
            throw new UnsupportedOperationException(String.valueOf(type) + " attributes not supported");
        }
    }

    @ApiStatus.Internal
    static void validateLongType(DataType type) {
        if (!type.isSupported()) {
            throw new UnsupportedOperationException(String.valueOf(type) + " attributes not supported");
        }
        if (!VeilRenderSystem.vertexAttribute64BitSupported()) {
            throw new UnsupportedOperationException("Long attributes not supported");
        }
    }

    default VertexArrayBuilder applyFrom(int bufferIndex, int buffer, int attributeStart, VertexFormat format) {
        defineVertexBuffer(bufferIndex, buffer, 0, format.getVertexSize(), 0);
        List<VertexFormatElement> elements = format.getElements();
        for (int i = 0; i < elements.size(); i++) {
            VertexFormatElement element = elements.get(i);
            VertexFormatElement.Usage usage = element.usage();
            if (usage == VertexFormatElement.Usage.UV && element.type() != VertexFormatElement.Type.FLOAT) {
                setVertexIAttribute(attributeStart + i, bufferIndex, element.count(), DataType.fromType(element.type()), format.getOffset(element));
            } else {
                setVertexAttribute(attributeStart + i, bufferIndex, element.count(), DataType.fromType(element.type()), usage == VertexFormatElement.Usage.NORMAL || usage == VertexFormatElement.Usage.COLOR, format.getOffset(element));
            }
        }
        return this;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/vertex/VertexArrayBuilder$DataType.class */
    public enum DataType {
        BYTE(5120),
        SHORT(5122),
        INT(5124),
        FIXED(5132),
        FLOAT(5126),
        HALF_FLOAT(5131),
        DOUBLE(5130),
        UNSIGNED_BYTE(5121),
        UNSIGNED_SHORT(5123),
        UNSIGNED_INT(5125),
        INT_2_10_10_10_REV(36255),
        UNSIGNED_INT_2_10_10_10_REV(33640),
        UNSIGNED_INT_10F_11F_11F_REV(35899),
        UNSIGNED_INT64_ARB(5135);

        private final int glType;

        DataType(int glType) {
            this.glType = glType;
        }

        public boolean isSupported() {
            if (this == UNSIGNED_INT_10F_11F_11F_REV) {
                return VeilRenderSystem.vertexType10F11F11FRevSupported();
            }
            if (this == UNSIGNED_INT64_ARB) {
                return VeilRenderSystem.bindlessTextureSupported();
            }
            return true;
        }

        public int getGlType() {
            return this.glType;
        }

        public static DataType fromType(VertexFormatElement.Type type) throws MatchException {
            switch (C13731.$SwitchMap$com$mojang$blaze3d$vertex$VertexFormatElement$Type[type.ordinal()]) {
                case 1:
                    return FLOAT;
                case 2:
                    return UNSIGNED_BYTE;
                case 3:
                    return BYTE;
                case 4:
                    return UNSIGNED_SHORT;
                case 5:
                    return SHORT;
                case 6:
                    return UNSIGNED_INT;
                case 7:
                    return INT;
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
        }
    }

    /* JADX INFO: renamed from: foundry.veil.api.client.render.vertex.VertexArrayBuilder$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/vertex/VertexArrayBuilder$1.class */
    static /* synthetic */ class C13731 {
        static final /* synthetic */ int[] $SwitchMap$com$mojang$blaze3d$vertex$VertexFormatElement$Type = new int[VertexFormatElement.Type.values().length];

        static {
            try {
                $SwitchMap$com$mojang$blaze3d$vertex$VertexFormatElement$Type[VertexFormatElement.Type.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mojang$blaze3d$vertex$VertexFormatElement$Type[VertexFormatElement.Type.UBYTE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$mojang$blaze3d$vertex$VertexFormatElement$Type[VertexFormatElement.Type.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$mojang$blaze3d$vertex$VertexFormatElement$Type[VertexFormatElement.Type.USHORT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$mojang$blaze3d$vertex$VertexFormatElement$Type[VertexFormatElement.Type.SHORT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$mojang$blaze3d$vertex$VertexFormatElement$Type[VertexFormatElement.Type.UINT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$mojang$blaze3d$vertex$VertexFormatElement$Type[VertexFormatElement.Type.INT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }
}
