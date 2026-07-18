package io.github.ocelot.glslprocessor.api.grammar;

import com.boehmod.bflib.cloud.common.ProgressionValues;
import com.boehmod.blockfront.AbstractC0851pQ;
import com.boehmod.blockfront.AbstractC0877pq;
import com.boehmod.blockfront.C0862pb;
import com.boehmod.blockfront.C0965rY;
import com.boehmod.blockfront.C1011sR;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslTypeSpecifier.class */
public interface GlslTypeSpecifier extends GlslType {
    String getName();

    default boolean isNamed() {
        return false;
    }

    default boolean isStruct() {
        return false;
    }

    default GlslStructSpecifier asStructSpecifier() throws IllegalStateException {
        GlslTypeSpecifier specifier;
        GlslTypeSpecifier specifier2 = this;
        while (true) {
            specifier = specifier2;
            if (!(specifier instanceof Array)) {
                break;
            }
            Array array = (Array) specifier;
            specifier2 = array.getSpecifier();
        }
        if (!(specifier instanceof GlslStructSpecifier)) {
            throw new IllegalStateException("Type specifier is not a struct");
        }
        GlslStructSpecifier structSpecifier = (GlslStructSpecifier) specifier;
        return structSpecifier;
    }

    static GlslTypeSpecifier named(String name) {
        return new Name(name);
    }

    static GlslTypeSpecifier array(GlslTypeSpecifier specifier, @Nullable GlslNode size) {
        return new Array(specifier, size);
    }

    static GlslStructSpecifier struct(String name, Collection<GlslStructField> fields) {
        return new GlslStructSpecifier(name, (Collection<GlslStructField>) new ArrayList(fields));
    }

    @Override // io.github.ocelot.glslprocessor.api.grammar.GlslType
    default GlslSpecifiedType asSpecifiedType() {
        return new GlslSpecifiedType(this);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslTypeSpecifier$Name.class */
    public static final class Name implements GlslTypeSpecifier {
        private String name;

        Name(String name) {
            this.name = name;
        }

        @Override // io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier
        public String getName() {
            return this.name;
        }

        @Override // io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier
        public boolean isNamed() {
            return true;
        }

        public Name setName(String name) {
            this.name = name;
            return this;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Name)) {
                return false;
            }
            Name name = (Name) o;
            return this.name.equals(name.name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "Name[name=" + this.name + "]";
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslTypeSpecifier$Array.class */
    public static final class Array implements GlslTypeSpecifier {
        private GlslTypeSpecifier specifier;

        @Nullable
        private GlslNode size;

        Array(GlslTypeSpecifier specifier, @Nullable GlslNode size) {
            this.specifier = specifier;
            this.size = size;
        }

        public GlslTypeSpecifier getSpecifier() {
            return this.specifier;
        }

        @Nullable
        public GlslNode getSize() {
            return this.size;
        }

        @Override // io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier
        public String getName() {
            return this.specifier.getName();
        }

        @Override // io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier
        public boolean isNamed() {
            return this.specifier.isNamed();
        }

        @Override // io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier
        public boolean isStruct() {
            return this.specifier.isStruct();
        }

        public Array setSpecifier(GlslTypeSpecifier specifier) {
            this.specifier = specifier;
            return this;
        }

        public Array setSize(@Nullable GlslNode size) {
            this.size = size;
            return this;
        }

        @Deprecated(since = "0.2.0", forRemoval = true)
        public GlslTypeSpecifier specifier() {
            return this.specifier;
        }

        @Deprecated(since = "0.2.0", forRemoval = true)
        @Nullable
        public GlslNode size() {
            return this.size;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Array)) {
                return false;
            }
            Array array = (Array) o;
            return this.specifier.equals(array.specifier) && Objects.equals(this.size, array.size);
        }

        public int hashCode() {
            int result = this.specifier.hashCode();
            return (31 * result) + Objects.hashCode(this.size);
        }

        public String toString() {
            return "GlslTypeSpecifier.Array[specifier=" + this.specifier + ", size=" + this.size + "]";
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslTypeSpecifier$BuiltinType.class */
    public enum BuiltinType implements GlslTypeSpecifier {
        VOID("void"),
        FLOAT("float"),
        DOUBLE("double"),
        INT("int"),
        UINT("uint"),
        BOOL("bool"),
        VEC2("vec2"),
        VEC3("vec3"),
        VEC4("vec4"),
        DVEC2("dvec2"),
        DVEC3("dvec3"),
        DVEC4("dvec4"),
        BVEC2("bvec2"),
        BVEC3("bvec3"),
        BVEC4("bvec4"),
        IVEC2("ivec2"),
        IVEC3("ivec3"),
        IVEC4("ivec4"),
        UVEC2("uvec2"),
        UVEC3("uvec3"),
        UVEC4("uvec4"),
        MAT2("mat2"),
        MAT3("mat3"),
        MAT4("mat4"),
        MAT2X2("mat2x2"),
        MAT2X3("mat2x3"),
        MAT2X4("mat2x4"),
        MAT3X2("mat3x2"),
        MAT3X3("mat3x3"),
        MAT3X4("mat3x4"),
        MAT4X2("mat4x2"),
        MAT4X3("mat4x3"),
        MAT4X4("mat4x4"),
        DMAT2("dmat2"),
        DMAT3("dmat3"),
        DMAT4("dmat4"),
        DMAT2X2("dmat2x2"),
        DMAT2X3("dmat2x3"),
        DMAT2X4("dmat2x4"),
        DMAT3X2("dmat3x2"),
        DMAT3X3("dmat3x3"),
        DMAT3X4("dmat3x4"),
        DMAT4X2("dmat4x2"),
        DMAT4X3("dmat4x3"),
        DMAT4X4("dmat4x4"),
        ATOMIC_UINT("atomic_uint"),
        SAMPLER2D("sampler2D"),
        SAMPLER3D("sampler3D"),
        SAMPLERCUBE("samplerCube"),
        SAMPLER2DSHADOW("sampler2DShadow"),
        SAMPLERCUBESHADOW("samplerCubeShadow"),
        SAMPLER2DARRAY("sampler2DArray"),
        SAMPLER2DARRAYSHADOW("sampler2DArrayShadow"),
        SAMPLERCUBEARRAY("samplerCubeArray"),
        SAMPLERCUBEARRAYSHADOW("samplerCubeArrayShadow"),
        ISAMPLER2D("isampler2D"),
        ISAMPLER3D("isampler3D"),
        ISAMPLERCUBE("isamplerCube"),
        ISAMPLER2DARRAY("isampler2DArray"),
        ISAMPLERCUBEARRAY("isamplerCubeArray"),
        USAMPLER2D("usampler2D"),
        USAMPLER3D("usampler3D"),
        USAMPLERCUBE("usamplerCube"),
        USAMPLER2DARRAY("usampler2DArray"),
        USAMPLERCUBEARRAY("usamplerCubeArray"),
        SAMPLER1D("sampler1D"),
        SAMPLER1DSHADOW("sampler1DShadow"),
        SAMPLER1DARRAY("sampler1DArray"),
        SAMPLER1DARRAYSHADOW("sampler1DArrayShadow"),
        ISAMPLER1D("isampler1D"),
        ISAMPLER1DARRAY("isampler1DArray"),
        USAMPLER1D("usampler1D"),
        USAMPLER1DARRAY("usampler1DArray"),
        SAMPLER2DRECT("sampler2DRect"),
        SAMPLER2DRECTSHADOW("sampler2DRectShadow"),
        ISAMPLER2DRECT("isampler2DRect"),
        USAMPLER2DRECT("usampler2DRect"),
        SAMPLERBUFFER("samplerBuffer"),
        ISAMPLERBUFFER("isamplerBuffer"),
        USAMPLERBUFFER("usamplerBuffer"),
        SAMPLER2DMS("sampler2DMS"),
        ISAMPLER2DMS("isampler2DMS"),
        USAMPLER2DMS("usampler2DMS"),
        SAMPLER2DMSARRAY("sampler2DMSArray"),
        ISAMPLER2DMSARRAY("isampler2DMSArray"),
        USAMPLER2DMSARRAY("usampler2DMSArray"),
        IMAGE2D("image2D"),
        IIMAGE2D("iimage2D"),
        UIMAGE2D("uimage2D"),
        IMAGE3D("image3D"),
        IIMAGE3D("iimage3D"),
        UIMAGE3D("uimage3D"),
        IMAGECUBE("imageCube"),
        IIMAGECUBE("iimageCube"),
        UIMAGECUBE("uimageCube"),
        IMAGEBUFFER("imageBuffer"),
        IIMAGEBUFFER("iimageBuffer"),
        UIMAGEBUFFER("uimageBuffer"),
        IMAGE1D("image1D"),
        IIMAGE1D("iimage1D"),
        UIMAGE1D("uimage1D"),
        IMAGE1DARRAY("image1DArray"),
        IIMAGE1DARRAY("iimage1DArray"),
        UIMAGE1DARRAY("uimage1DArray"),
        IMAGE2DRECT("image2DRect"),
        IIMAGE2DRECT("iimage2DRect"),
        UIMAGE2DRECT("uimage2DRect"),
        IMAGE2DARRAY("image2DArray"),
        IIMAGE2DARRAY("iimage2DArray"),
        UIMAGE2DARRAY("uimage2DArray"),
        IMAGECUBEARRAY("imageCubeArray"),
        IIMAGECUBEARRAY("iimageCubeArray"),
        UIMAGECUBEARRAY("uimageCubeArray"),
        IMAGE2DMS("image2DMS"),
        IIMAGE2DMS("iimage2DMS"),
        UIMAGE2DMS("uimage2DMS"),
        IMAGE2DMSARRAY("image2DMSArray"),
        IIMAGE2DMSARRAY("iimage2DMSArray"),
        UIMAGE2DMSARRAY("uimage2DMSArray");

        private final String name;

        BuiltinType(String name) {
            this.name = name;
        }

        public String getConstant(double value) {
            switch (C14501.f8786x94a8c387[ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return Float.toString((float) value);
                case 5:
                case 6:
                case 7:
                case 8:
                    return Double.toString(value);
                case C0862pb.f4509nv /* 9 */:
                case 10:
                case AbstractC0877pq.f4599nO /* 11 */:
                case 12:
                    return Integer.toString((int) value);
                case C0862pb.f4508nu /* 13 */:
                case 14:
                case 15:
                case 16:
                    return ((int) value) + "u";
                default:
                    throw new IllegalStateException("Invalid constant type: " + this);
            }
        }

        public boolean isPrimitive() {
            switch (C14501.f8786x94a8c387[ordinal()]) {
                case 1:
                case 5:
                case C0862pb.f4509nv /* 9 */:
                case C0862pb.f4508nu /* 13 */:
                case 17:
                case 18:
                    return true;
                case 2:
                case 3:
                case 4:
                case 6:
                case 7:
                case 8:
                case 10:
                case AbstractC0877pq.f4599nO /* 11 */:
                case 12:
                case 14:
                case 15:
                case 16:
                default:
                    return false;
            }
        }

        public boolean isFloat() {
            switch (this) {
                case FLOAT:
                case VEC2:
                case VEC3:
                case VEC4:
                    return true;
                default:
                    return false;
            }
        }

        public boolean isDouble() {
            switch (this) {
                case DOUBLE:
                case DVEC2:
                case DVEC3:
                case DVEC4:
                    return true;
                default:
                    return false;
            }
        }

        public boolean isInteger() {
            switch (C14501.f8786x94a8c387[ordinal()]) {
                case C0862pb.f4509nv /* 9 */:
                case 10:
                case AbstractC0877pq.f4599nO /* 11 */:
                case 12:
                    return true;
                default:
                    return false;
            }
        }

        public boolean isUnsignedInteger() {
            switch (C14501.f8786x94a8c387[ordinal()]) {
                case C0862pb.f4508nu /* 13 */:
                case 14:
                case 15:
                case 16:
                    return true;
                default:
                    return false;
            }
        }

        public boolean isBool() {
            switch (this) {
                case BOOL:
                case BVEC2:
                case BVEC3:
                case BVEC4:
                    return true;
                case ATOMIC_UINT:
                default:
                    return false;
            }
        }

        public boolean isVector() {
            switch (C14501.f8786x94a8c387[ordinal()]) {
                case 2:
                case 3:
                case 4:
                case 6:
                case 7:
                case 8:
                case 10:
                case AbstractC0877pq.f4599nO /* 11 */:
                case 12:
                case 14:
                case 15:
                case 16:
                case 19:
                case 20:
                case 21:
                    return true;
                case 5:
                case C0862pb.f4509nv /* 9 */:
                case C0862pb.f4508nu /* 13 */:
                case 17:
                case 18:
                default:
                    return false;
            }
        }

        public boolean isMatrix() {
            switch (C14501.f8786x94a8c387[ordinal()]) {
                case 22:
                case C0862pb.f4510nw /* 23 */:
                case 24:
                case ProgressionValues.EXP_PER_INFECTED_ROUNDS_WON /* 25 */:
                case 26:
                case 27:
                case AbstractC0851pQ.f4482nU /* 28 */:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case C0965rY.f5110qj /* 35 */:
                case 36:
                case C1011sR.f5290rf /* 37 */:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case C1011sR.f5292rh /* 43 */:
                case 44:
                case 45:
                    return true;
                default:
                    return false;
            }
        }

        public int getComponents() {
            switch (C14501.f8786x94a8c387[ordinal()]) {
                case 1:
                case 5:
                case C0862pb.f4509nv /* 9 */:
                case C0862pb.f4508nu /* 13 */:
                case 17:
                case 18:
                    return 1;
                case 2:
                case 6:
                case 10:
                case 14:
                case 19:
                    return 2;
                case 3:
                case 7:
                case AbstractC0877pq.f4599nO /* 11 */:
                case 15:
                case 20:
                    return 3;
                case 4:
                case 8:
                case 12:
                case 16:
                case 21:
                case 22:
                case C0862pb.f4510nw /* 23 */:
                case 24:
                case ProgressionValues.EXP_PER_INFECTED_ROUNDS_WON /* 25 */:
                    return 4;
                case 26:
                case 27:
                case AbstractC0851pQ.f4482nU /* 28 */:
                case 29:
                    return 9;
                case 30:
                case 31:
                case 32:
                case 33:
                    return 16;
                case 34:
                case C0965rY.f5110qj /* 35 */:
                case 36:
                case C1011sR.f5290rf /* 37 */:
                    return 6;
                case 38:
                case 39:
                case 40:
                case 41:
                    return 8;
                case 42:
                case C1011sR.f5292rh /* 43 */:
                case 44:
                case 45:
                    return 12;
                default:
                    return 0;
            }
        }

        @Override // io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier
        public String getName() {
            return this.name;
        }
    }
}
