package foundry.veil.api.quasar.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.quasar.emitters.shape.EmitterShape;
import foundry.veil.api.util.CodecUtil;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.Holder;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/data/EmitterShapeSettings.class */
public final class EmitterShapeSettings extends Record {
    private final EmitterShape shape;
    private final Vector3fc dimensions;
    private final Vector3fc rotation;
    private final boolean fromSurface;
    public static final Codec<EmitterShapeSettings> DIRECT_CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(EmitterShape.CODEC.fieldOf("shape").forGetter((v0) -> {
            return v0.shape();
        }), CodecUtil.VECTOR3FC_CODEC.fieldOf("dimensions").forGetter((v0) -> {
            return v0.dimensions();
        }), CodecUtil.VECTOR3FC_CODEC.fieldOf("rotation").forGetter((v0) -> {
            return v0.rotation();
        }), Codec.BOOL.fieldOf("from_surface").forGetter((v0) -> {
            return v0.fromSurface();
        })).apply(instance, (v1, v2, v3, v4) -> {
            return new EmitterShapeSettings(v1, v2, v3, v4);
        });
    });
    public static final Codec<Holder<EmitterShapeSettings>> CODEC = RegistryFileCodec.create(QuasarParticles.EMITTER_SHAPE_SETTINGS, DIRECT_CODEC);

    public EmitterShapeSettings(EmitterShape shape, Vector3fc dimensions, Vector3fc rotation, boolean fromSurface) {
        this.shape = shape;
        this.dimensions = dimensions;
        this.rotation = rotation;
        this.fromSurface = fromSurface;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, EmitterShapeSettings.class), EmitterShapeSettings.class, "shape;dimensions;rotation;fromSurface", "FIELD:Lfoundry/veil/api/quasar/data/EmitterShapeSettings;->shape:Lfoundry/veil/api/quasar/emitters/shape/EmitterShape;", "FIELD:Lfoundry/veil/api/quasar/data/EmitterShapeSettings;->dimensions:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/quasar/data/EmitterShapeSettings;->rotation:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/quasar/data/EmitterShapeSettings;->fromSurface:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, EmitterShapeSettings.class), EmitterShapeSettings.class, "shape;dimensions;rotation;fromSurface", "FIELD:Lfoundry/veil/api/quasar/data/EmitterShapeSettings;->shape:Lfoundry/veil/api/quasar/emitters/shape/EmitterShape;", "FIELD:Lfoundry/veil/api/quasar/data/EmitterShapeSettings;->dimensions:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/quasar/data/EmitterShapeSettings;->rotation:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/quasar/data/EmitterShapeSettings;->fromSurface:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, EmitterShapeSettings.class, Object.class), EmitterShapeSettings.class, "shape;dimensions;rotation;fromSurface", "FIELD:Lfoundry/veil/api/quasar/data/EmitterShapeSettings;->shape:Lfoundry/veil/api/quasar/emitters/shape/EmitterShape;", "FIELD:Lfoundry/veil/api/quasar/data/EmitterShapeSettings;->dimensions:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/quasar/data/EmitterShapeSettings;->rotation:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/quasar/data/EmitterShapeSettings;->fromSurface:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public EmitterShape shape() {
        return this.shape;
    }

    public Vector3fc dimensions() {
        return this.dimensions;
    }

    public Vector3fc rotation() {
        return this.rotation;
    }

    public boolean fromSurface() {
        return this.fromSurface;
    }

    public Vector3d getPos(RandomSource randomSource, Vector3dc pos) {
        return this.shape.getPoint(randomSource, this.dimensions, this.rotation, pos, this.fromSurface);
    }

    @Nullable
    public ResourceLocation getRegistryId() {
        return (ResourceLocation) QuasarParticles.registryAccess().registry(QuasarParticles.EMITTER_SHAPE_SETTINGS).map(registry -> {
            return registry.getKey(this);
        }).orElse(null);
    }
}
