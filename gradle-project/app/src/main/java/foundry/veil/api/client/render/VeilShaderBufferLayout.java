package foundry.veil.api.client.render;

import foundry.veil.api.client.render.shader.block.ShaderBlock;
import io.github.ocelot.glslprocessor.api.grammar.GlslSpecifiedType;
import io.github.ocelot.glslprocessor.api.grammar.GlslStructField;
import io.github.ocelot.glslprocessor.api.grammar.GlslStructSpecifier;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeQualifier;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslNewFieldNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslStructDeclarationNode;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix2dc;
import org.joml.Matrix2fc;
import org.joml.Matrix3dc;
import org.joml.Matrix3fc;
import org.joml.Matrix3x2dc;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4dc;
import org.joml.Matrix4fc;
import org.joml.Matrix4x3dc;
import org.joml.Matrix4x3fc;
import org.joml.Vector2dc;
import org.joml.Vector2fc;
import org.joml.Vector2ic;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.joml.Vector3ic;
import org.joml.Vector4dc;
import org.joml.Vector4fc;
import org.joml.Vector4ic;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/VeilShaderBufferLayout.class */
public final class VeilShaderBufferLayout<T> extends Record {
    private final String name;
    private final Map<String, FieldSerializer<T>> fields;
    private final ShaderBlock.BufferBinding requestedBinding;
    private final ShaderBlock.MemoryLayout memoryLayout;
    private final GlslStructSpecifier structSpecifier;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/VeilShaderBufferLayout$FieldSerializer.class */
    @FunctionalInterface
    public interface FieldSerializer<T> {
        void write(T t, int i, ByteBuffer byteBuffer);
    }

    public VeilShaderBufferLayout(String name, Map<String, FieldSerializer<T>> fields, ShaderBlock.BufferBinding requestedBinding, ShaderBlock.MemoryLayout memoryLayout, GlslStructSpecifier structSpecifier) {
        this.name = name;
        this.fields = fields;
        this.requestedBinding = requestedBinding;
        this.memoryLayout = memoryLayout;
        this.structSpecifier = structSpecifier;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, VeilShaderBufferLayout.class), VeilShaderBufferLayout.class, "name;fields;requestedBinding;memoryLayout;structSpecifier", "FIELD:Lfoundry/veil/api/client/render/VeilShaderBufferLayout;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/VeilShaderBufferLayout;->fields:Ljava/util/Map;", "FIELD:Lfoundry/veil/api/client/render/VeilShaderBufferLayout;->requestedBinding:Lfoundry/veil/api/client/render/shader/block/ShaderBlock$BufferBinding;", "FIELD:Lfoundry/veil/api/client/render/VeilShaderBufferLayout;->memoryLayout:Lfoundry/veil/api/client/render/shader/block/ShaderBlock$MemoryLayout;", "FIELD:Lfoundry/veil/api/client/render/VeilShaderBufferLayout;->structSpecifier:Lio/github/ocelot/glslprocessor/api/grammar/GlslStructSpecifier;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, VeilShaderBufferLayout.class), VeilShaderBufferLayout.class, "name;fields;requestedBinding;memoryLayout;structSpecifier", "FIELD:Lfoundry/veil/api/client/render/VeilShaderBufferLayout;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/VeilShaderBufferLayout;->fields:Ljava/util/Map;", "FIELD:Lfoundry/veil/api/client/render/VeilShaderBufferLayout;->requestedBinding:Lfoundry/veil/api/client/render/shader/block/ShaderBlock$BufferBinding;", "FIELD:Lfoundry/veil/api/client/render/VeilShaderBufferLayout;->memoryLayout:Lfoundry/veil/api/client/render/shader/block/ShaderBlock$MemoryLayout;", "FIELD:Lfoundry/veil/api/client/render/VeilShaderBufferLayout;->structSpecifier:Lio/github/ocelot/glslprocessor/api/grammar/GlslStructSpecifier;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, VeilShaderBufferLayout.class, Object.class), VeilShaderBufferLayout.class, "name;fields;requestedBinding;memoryLayout;structSpecifier", "FIELD:Lfoundry/veil/api/client/render/VeilShaderBufferLayout;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/api/client/render/VeilShaderBufferLayout;->fields:Ljava/util/Map;", "FIELD:Lfoundry/veil/api/client/render/VeilShaderBufferLayout;->requestedBinding:Lfoundry/veil/api/client/render/shader/block/ShaderBlock$BufferBinding;", "FIELD:Lfoundry/veil/api/client/render/VeilShaderBufferLayout;->memoryLayout:Lfoundry/veil/api/client/render/shader/block/ShaderBlock$MemoryLayout;", "FIELD:Lfoundry/veil/api/client/render/VeilShaderBufferLayout;->structSpecifier:Lio/github/ocelot/glslprocessor/api/grammar/GlslStructSpecifier;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public String name() {
        return this.name;
    }

    public Map<String, FieldSerializer<T>> fields() {
        return this.fields;
    }

    public ShaderBlock.BufferBinding requestedBinding() {
        return this.requestedBinding;
    }

    public ShaderBlock.MemoryLayout memoryLayout() {
        return this.memoryLayout;
    }

    public GlslStructSpecifier structSpecifier() {
        return this.structSpecifier;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public GlslNode createNode(boolean shaderStorageSupported, @Nullable String interfaceName) throws MatchException {
        GlslTypeQualifier.StorageType storageType;
        GlslNode node;
        switch (this.requestedBinding) {
            case UNIFORM:
                storageType = GlslTypeQualifier.StorageType.UNIFORM;
                break;
            case SHADER_STORAGE:
                storageType = !shaderStorageSupported ? GlslTypeQualifier.StorageType.UNIFORM : GlslTypeQualifier.StorageType.BUFFER;
                break;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
        GlslTypeQualifier.StorageType storageType2 = storageType;
        GlslSpecifiedType structSpecifier = new GlslSpecifiedType(this.structSpecifier, GlslTypeQualifier.layout(this.memoryLayout.getLayoutId()), storageType2);
        if (interfaceName != null) {
            node = new GlslNewFieldNode(structSpecifier, interfaceName, null);
        } else {
            node = new GlslStructDeclarationNode(structSpecifier);
        }
        return node;
    }

    public ShaderBlock.BufferBinding binding() {
        return VeilRenderSystem.shaderStorageBufferSupported() ? this.requestedBinding : ShaderBlock.BufferBinding.UNIFORM;
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/VeilShaderBufferLayout$Builder.class */
    public static class Builder<T> {
        private static final Random RANDOM = new Random();
        private final String name = "VeilBuffer" + Math.abs(RANDOM.nextInt());
        private final List<GlslStructField> structFields = new ArrayList();
        private final Map<String, FieldSerializer<T>> fields = new Object2ObjectArrayMap();
        private ShaderBlock.BufferBinding binding = ShaderBlock.BufferBinding.UNIFORM;
        private ShaderBlock.MemoryLayout memoryLayout = ShaderBlock.MemoryLayout.SHARED;

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/VeilShaderBufferLayout$Builder$DoubleSerializer.class */
        @FunctionalInterface
        public interface DoubleSerializer<T> {
            double serialize(T t);
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/VeilShaderBufferLayout$Builder$FloatSerializer.class */
        @FunctionalInterface
        public interface FloatSerializer<T> {
            float serialize(T t);
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/VeilShaderBufferLayout$Builder$IntSerializer.class */
        @FunctionalInterface
        public interface IntSerializer<T> {
            int serialize(T t);
        }

        public Builder<T> binding(ShaderBlock.BufferBinding binding) {
            this.binding = binding;
            return this;
        }

        public Builder<T> memoryLayout(ShaderBlock.MemoryLayout memoryLayout) {
            this.memoryLayout = memoryLayout;
            return this;
        }

        public Builder<T> f32(String name, FloatSerializer<T> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.FLOAT, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putFloat(index, serializer.serialize(value));
            });
            return this;
        }

        public Builder<T> f64(String name, DoubleSerializer<T> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.DOUBLE, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putDouble(index, serializer.serialize(value));
            });
            return this;
        }

        public Builder<T> integer(String name, IntSerializer<T> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.INT, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putInt(index, serializer.serialize(value));
            });
            return this;
        }

        public Builder<T> uint(String name, IntSerializer<T> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.UINT, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putInt(index, serializer.serialize(value));
            });
            return this;
        }

        public Builder<T> vec2(String name, Function<T, Vector2fc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.VEC2, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Vector2fc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> vec2(String name, FloatSerializer<T> x, FloatSerializer<T> y) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.VEC2, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putFloat(index, x.serialize(value)).putFloat(index + 4, y.serialize(value));
            });
            return this;
        }

        public Builder<T> vec3(String name, Function<T, Vector3fc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.VEC3, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Vector3fc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> vec3(String name, FloatSerializer<T> x, FloatSerializer<T> y, FloatSerializer<T> z) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.VEC3, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putFloat(index, x.serialize(value)).putFloat(index + 4, y.serialize(value)).putFloat(index + 8, z.serialize(value));
            });
            return this;
        }

        public Builder<T> vec4(String name, Function<T, Vector4fc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.VEC4, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Vector4fc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> vec4(String name, FloatSerializer<T> x, FloatSerializer<T> y, FloatSerializer<T> z, FloatSerializer<T> w) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.VEC4, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putFloat(index, x.serialize(value)).putFloat(index + 4, y.serialize(value)).putFloat(index + 8, z.serialize(value)).putFloat(index + 12, w.serialize(value));
            });
            return this;
        }

        public Builder<T> dvec2(String name, Function<T, Vector2dc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.DVEC2, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Vector2dc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> dvec2(String name, DoubleSerializer<T> x, DoubleSerializer<T> y) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.DVEC2, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putDouble(index, x.serialize(value)).putDouble(index + 8, y.serialize(value));
            });
            return this;
        }

        public Builder<T> dvec3(String name, Function<T, Vector3dc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.DVEC3, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Vector3dc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> dvec3(String name, DoubleSerializer<T> x, DoubleSerializer<T> y, DoubleSerializer<T> z) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.DVEC3, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putDouble(index, x.serialize(value)).putDouble(index + 8, y.serialize(value)).putDouble(index + 16, z.serialize(value));
            });
            return this;
        }

        public Builder<T> dvec4(String name, Function<T, Vector4dc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.DVEC4, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Vector4dc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> dvec4(String name, DoubleSerializer<T> x, DoubleSerializer<T> y, DoubleSerializer<T> z, DoubleSerializer<T> w) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.DVEC4, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putDouble(index, x.serialize(value)).putDouble(index + 8, y.serialize(value)).putDouble(index + 16, z.serialize(value)).putDouble(index + 24, w.serialize(value));
            });
            return this;
        }

        public Builder<T> ivec2(String name, Function<T, Vector2ic> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.IVEC2, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Vector2ic) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> ivec2(String name, IntSerializer<T> x, IntSerializer<T> y) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.IVEC2, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putInt(index, x.serialize(value)).putInt(index + 4, y.serialize(value));
            });
            return this;
        }

        public Builder<T> ivec3(String name, Function<T, Vector3ic> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.IVEC3, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Vector3ic) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> ivec3(String name, IntSerializer<T> x, IntSerializer<T> y, IntSerializer<T> z) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.IVEC3, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putInt(index, x.serialize(value)).putInt(index + 4, y.serialize(value)).putInt(index + 8, z.serialize(value));
            });
            return this;
        }

        public Builder<T> ivec4(String name, Function<T, Vector4ic> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.IVEC4, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Vector4ic) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> ivec4(String name, IntSerializer<T> x, IntSerializer<T> y, IntSerializer<T> z, IntSerializer<T> w) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.IVEC4, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putInt(index, x.serialize(value)).putInt(index + 4, y.serialize(value)).putInt(index + 8, z.serialize(value)).putInt(index + 12, w.serialize(value));
            });
            return this;
        }

        public Builder<T> uvec2(String name, Function<T, Vector2ic> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.UVEC2, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Vector2ic) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> uvec2(String name, IntSerializer<T> x, IntSerializer<T> y) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.UVEC2, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putInt(index, x.serialize(value)).putInt(index + 4, y.serialize(value));
            });
            return this;
        }

        public Builder<T> uvec3(String name, Function<T, Vector3ic> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.UVEC3, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Vector3ic) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> uvec3(String name, IntSerializer<T> x, IntSerializer<T> y, IntSerializer<T> z) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.UVEC3, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putInt(index, x.serialize(value)).putInt(index + 4, y.serialize(value)).putInt(index + 8, z.serialize(value));
            });
            return this;
        }

        public Builder<T> uvec4(String name, Function<T, Vector4ic> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.UVEC4, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Vector4ic) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> uvec4(String name, IntSerializer<T> x, IntSerializer<T> y, IntSerializer<T> z, IntSerializer<T> w) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.UVEC4, name));
            this.fields.put(name, (value, index, buffer) -> {
                buffer.putInt(index, x.serialize(value)).putInt(index + 4, y.serialize(value)).putInt(index + 8, z.serialize(value)).putInt(index + 12, w.serialize(value));
            });
            return this;
        }

        public Builder<T> mat2(String name, Function<T, Matrix2fc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.MAT2, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Matrix2fc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> mat3(String name, Function<T, Matrix3fc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.MAT3, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Matrix3fc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> mat4(String name, Function<T, Matrix4fc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.MAT4, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Matrix4fc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> mat3x2(String name, Function<T, Matrix3x2fc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.MAT3X2, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Matrix3x2fc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> mat4x3(String name, Function<T, Matrix4x3fc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.MAT4X3, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Matrix4x3fc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> dmat2(String name, Function<T, Matrix2dc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.DMAT2, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Matrix2dc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> dmat3(String name, Function<T, Matrix3dc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.DMAT3, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Matrix3dc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> dmat4(String name, Function<T, Matrix4dc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.DMAT4, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Matrix4dc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> dmat3x2(String name, Function<T, Matrix3x2dc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.DMAT3X2, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Matrix3x2dc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public Builder<T> dmat4x3(String name, Function<T, Matrix4x3dc> serializer) {
            this.structFields.add(new GlslStructField(GlslTypeSpecifier.BuiltinType.DMAT4X3, name));
            this.fields.put(name, (value, index, buffer) -> {
                ((Matrix4x3dc) serializer.apply(value)).get(index, buffer);
            });
            return this;
        }

        public VeilShaderBufferLayout<T> build() {
            if (this.memoryLayout == ShaderBlock.MemoryLayout.STD430 && this.binding != ShaderBlock.BufferBinding.SHADER_STORAGE) {
                throw new IllegalArgumentException("std430 only supports shader storage buffers");
            }
            if (this.fields.isEmpty()) {
                throw new IllegalArgumentException("At least 1 field must be defined in a shader block");
            }
            return new VeilShaderBufferLayout<>(this.name, Collections.unmodifiableMap(this.fields), this.binding, this.memoryLayout, GlslTypeSpecifier.struct(this.name, this.structFields));
        }
    }
}
