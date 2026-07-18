package foundry.veil.api.client.registry;

import com.mojang.serialization.MapCodec;
import foundry.veil.Veil;
import foundry.veil.api.flare.data.FloatCurve;
import foundry.veil.api.flare.modifier.PropertyModifier;
import foundry.veil.api.flare.modifier.modifiers.FloatPropertyModifier;
import foundry.veil.api.flare.modifier.modifiers.Vec2PropertyModifier;
import foundry.veil.api.flare.modifier.modifiers.Vec3PropertyModifier;
import foundry.veil.api.flare.modifier.modifiers.Vec4PropertyModifier;
import foundry.veil.platform.registry.RegistrationProvider;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.jetbrains.annotations.ApiStatus;
import org.joml.Vector2fc;
import org.joml.Vector3fc;
import org.joml.Vector4fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/registry/PropertyModifierRegistry.class */
public final class PropertyModifierRegistry {
    public static final ResourceKey<Registry<PropertyModifierType<?, ?>>> REGISTRY_KEY = ResourceKey.createRegistryKey(Veil.veilPath("property_modifier"));
    private static final RegistrationProvider<PropertyModifierType<?, ?>> PROVIDER = RegistrationProvider.get(REGISTRY_KEY, Veil.MODID);
    public static final Registry<PropertyModifierType<?, ?>> REGISTRY = PROVIDER.asVanillaRegistry();
    public static final Supplier<PropertyModifierType<Float, FloatPropertyModifier>> FLOAT = register("float", PropertyModifier.createCodec(FloatPropertyModifier::new, (v0) -> {
        return v0.getCurve();
    }, FloatCurve.CODEC.optionalFieldOf("curve", FloatCurve.ZERO), 1));
    public static final Supplier<PropertyModifierType<Vector2fc, Vec2PropertyModifier>> VEC2 = register("vec2", PropertyModifier.createCodec(Vec2PropertyModifier::new, (v0) -> {
        return v0.getCurves();
    }, FloatCurve.CODEC.listOf(0, 2).fieldOf("curves"), 2));
    public static final Supplier<PropertyModifierType<Vector3fc, Vec3PropertyModifier>> VEC3 = register("vec3", PropertyModifier.createCodec(Vec3PropertyModifier::new, (v0) -> {
        return v0.getCurves();
    }, FloatCurve.CODEC.listOf(0, 3).fieldOf("curves"), 3));
    public static final Supplier<PropertyModifierType<Vector4fc, Vec4PropertyModifier>> VEC4 = register("vec4", PropertyModifier.createCodec(Vec4PropertyModifier::new, (v0) -> {
        return v0.getCurves();
    }, FloatCurve.CODEC.listOf(0, 4).fieldOf("curves"), 4));

    private static <T, M extends PropertyModifier<T>> Supplier<PropertyModifierType<T, M>> register(String str, MapCodec<M> mapCodec) {
        return PROVIDER.register(str, () -> {
            return new PropertyModifierType(mapCodec);
        });
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/registry/PropertyModifierRegistry$PropertyModifierType.class */
    public static final class PropertyModifierType<T, M extends PropertyModifier<T>> extends Record {
        private final MapCodec<M> codec;

        public PropertyModifierType(MapCodec<M> codec) {
            this.codec = codec;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PropertyModifierType.class), PropertyModifierType.class, "codec", "FIELD:Lfoundry/veil/api/client/registry/PropertyModifierRegistry$PropertyModifierType;->codec:Lcom/mojang/serialization/MapCodec;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PropertyModifierType.class), PropertyModifierType.class, "codec", "FIELD:Lfoundry/veil/api/client/registry/PropertyModifierRegistry$PropertyModifierType;->codec:Lcom/mojang/serialization/MapCodec;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PropertyModifierType.class, Object.class), PropertyModifierType.class, "codec", "FIELD:Lfoundry/veil/api/client/registry/PropertyModifierRegistry$PropertyModifierType;->codec:Lcom/mojang/serialization/MapCodec;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public MapCodec<M> codec() {
            return this.codec;
        }
    }

    private PropertyModifierRegistry() {
    }

    @ApiStatus.Internal
    public static void bootstrap() {
    }
}
