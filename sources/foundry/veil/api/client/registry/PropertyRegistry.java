package foundry.veil.api.client.registry;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import foundry.veil.Veil;
import foundry.veil.api.client.property.Property;
import foundry.veil.api.client.property.properties.BoolProperty;
import foundry.veil.api.client.property.properties.FloatProperty;
import foundry.veil.api.client.property.properties.IntProperty;
import foundry.veil.api.client.property.properties.Mat3Property;
import foundry.veil.api.client.property.properties.Mat4Property;
import foundry.veil.api.client.property.properties.Sampler2DProperty;
import foundry.veil.api.client.property.properties.Vec2Property;
import foundry.veil.api.client.property.properties.Vec3Property;
import foundry.veil.api.client.property.properties.Vec4Property;
import foundry.veil.api.util.CodecUtil;
import foundry.veil.platform.registry.RegistrationProvider;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.Supplier;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.jetbrains.annotations.ApiStatus;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/registry/PropertyRegistry.class */
public final class PropertyRegistry {
    public static final ResourceKey<Registry<PropertyType<?, ?>>> REGISTRY_KEY = ResourceKey.createRegistryKey(Veil.veilPath("property"));
    private static final RegistrationProvider<PropertyType<?, ?>> PROVIDER = RegistrationProvider.get(REGISTRY_KEY, Veil.MODID);
    public static final Registry<PropertyType<?, ?>> REGISTRY = PROVIDER.asVanillaRegistry();
    public static final Supplier<PropertyType<Float, FloatProperty>> FLOAT = register("float", Property.createCodec((v1) -> {
        return new FloatProperty(v1);
    }, Codec.FLOAT), GlslTypeSpecifier.BuiltinType.FLOAT);
    public static final Supplier<PropertyType<Integer, IntProperty>> INT = register("int", Property.createCodec((v1) -> {
        return new IntProperty(v1);
    }, Codec.INT), GlslTypeSpecifier.BuiltinType.INT);
    public static final Supplier<PropertyType<Boolean, BoolProperty>> BOOL = register("bool", Property.createCodec((v1) -> {
        return new BoolProperty(v1);
    }, Codec.BOOL), GlslTypeSpecifier.BuiltinType.BOOL);
    public static final Supplier<PropertyType<Vector2f, Vec2Property>> VEC2 = register("vec2", Property.createCodec((v1) -> {
        return new Vec2Property(v1);
    }, CodecUtil.VECTOR2F_CODEC), GlslTypeSpecifier.BuiltinType.VEC2);
    public static final Supplier<PropertyType<Vector3f, Vec3Property>> VEC3 = register("vec3", Property.createCodec((v1) -> {
        return new Vec3Property(v1);
    }, CodecUtil.VECTOR3F_CODEC), GlslTypeSpecifier.BuiltinType.VEC3);
    public static final Supplier<PropertyType<Vector4f, Vec4Property>> VEC4 = register("vec4", Property.createCodec((v1) -> {
        return new Vec4Property(v1);
    }, CodecUtil.VECTOR4F_CODEC), GlslTypeSpecifier.BuiltinType.VEC4);
    public static final Supplier<PropertyType<Matrix3f, Mat3Property>> MAT3 = register("mat3", Property.createCodec((v1) -> {
        return new Mat3Property(v1);
    }, CodecUtil.MATRIX3F_CODEC), GlslTypeSpecifier.BuiltinType.MAT3);
    public static final Supplier<PropertyType<Matrix4f, Mat4Property>> MAT4 = register("mat4", Property.createCodec((v1) -> {
        return new Mat4Property(v1);
    }, CodecUtil.MATRIX4F_CODEC), GlslTypeSpecifier.BuiltinType.MAT4);
    public static final Supplier<PropertyType<AbstractTexture, Sampler2DProperty>> SAMPLER2D = register("sampler2d", Sampler2DProperty.CODEC, GlslTypeSpecifier.BuiltinType.SAMPLER2D);

    private static <T, M extends Property<T>> Supplier<PropertyType<T, M>> register(String str, MapCodec<M> mapCodec, GlslTypeSpecifier.BuiltinType builtinType) {
        return PROVIDER.register(str, () -> {
            return new PropertyType(mapCodec, builtinType);
        });
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/registry/PropertyRegistry$PropertyType.class */
    public static final class PropertyType<T, M extends Property<T>> extends Record {
        private final MapCodec<M> codec;
        private final GlslTypeSpecifier.BuiltinType glType;

        public PropertyType(MapCodec<M> codec, GlslTypeSpecifier.BuiltinType glType) {
            this.codec = codec;
            this.glType = glType;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PropertyType.class), PropertyType.class, "codec;glType", "FIELD:Lfoundry/veil/api/client/registry/PropertyRegistry$PropertyType;->codec:Lcom/mojang/serialization/MapCodec;", "FIELD:Lfoundry/veil/api/client/registry/PropertyRegistry$PropertyType;->glType:Lio/github/ocelot/glslprocessor/api/grammar/GlslTypeSpecifier$BuiltinType;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PropertyType.class), PropertyType.class, "codec;glType", "FIELD:Lfoundry/veil/api/client/registry/PropertyRegistry$PropertyType;->codec:Lcom/mojang/serialization/MapCodec;", "FIELD:Lfoundry/veil/api/client/registry/PropertyRegistry$PropertyType;->glType:Lio/github/ocelot/glslprocessor/api/grammar/GlslTypeSpecifier$BuiltinType;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PropertyType.class, Object.class), PropertyType.class, "codec;glType", "FIELD:Lfoundry/veil/api/client/registry/PropertyRegistry$PropertyType;->codec:Lcom/mojang/serialization/MapCodec;", "FIELD:Lfoundry/veil/api/client/registry/PropertyRegistry$PropertyType;->glType:Lio/github/ocelot/glslprocessor/api/grammar/GlslTypeSpecifier$BuiltinType;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public MapCodec<M> codec() {
            return this.codec;
        }

        public GlslTypeSpecifier.BuiltinType glType() {
            return this.glType;
        }
    }

    private PropertyRegistry() {
    }

    @ApiStatus.Internal
    public static void bootstrap() {
    }
}
