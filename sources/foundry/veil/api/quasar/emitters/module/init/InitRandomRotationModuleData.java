package foundry.veil.api.quasar.emitters.module.init;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import foundry.veil.api.util.CodecUtil;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.ApiStatus;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/emitters/module/init/InitRandomRotationModuleData.class */
@ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
@Deprecated
public final class InitRandomRotationModuleData extends Record implements ParticleModuleData {
    private final Vector3fc minDegrees;
    private final Vector3fc maxDegrees;
    public static final MapCodec<InitRandomRotationModuleData> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(CodecUtil.VECTOR3FC_CODEC.fieldOf("min_degrees").forGetter((v0) -> {
            return v0.minDegrees();
        }), CodecUtil.VECTOR3FC_CODEC.fieldOf("max_degrees").forGetter((v0) -> {
            return v0.maxDegrees();
        })).apply(instance, InitRandomRotationModuleData::new);
    });

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, InitRandomRotationModuleData.class), InitRandomRotationModuleData.class, "minDegrees;maxDegrees", "FIELD:Lfoundry/veil/api/quasar/emitters/module/init/InitRandomRotationModuleData;->minDegrees:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/quasar/emitters/module/init/InitRandomRotationModuleData;->maxDegrees:Lorg/joml/Vector3fc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, InitRandomRotationModuleData.class), InitRandomRotationModuleData.class, "minDegrees;maxDegrees", "FIELD:Lfoundry/veil/api/quasar/emitters/module/init/InitRandomRotationModuleData;->minDegrees:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/quasar/emitters/module/init/InitRandomRotationModuleData;->maxDegrees:Lorg/joml/Vector3fc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, InitRandomRotationModuleData.class, Object.class), InitRandomRotationModuleData.class, "minDegrees;maxDegrees", "FIELD:Lfoundry/veil/api/quasar/emitters/module/init/InitRandomRotationModuleData;->minDegrees:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/quasar/emitters/module/init/InitRandomRotationModuleData;->maxDegrees:Lorg/joml/Vector3fc;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Vector3fc minDegrees() {
        return this.minDegrees;
    }

    public Vector3fc maxDegrees() {
        return this.maxDegrees;
    }

    public InitRandomRotationModuleData(Vector3fc minDegrees, Vector3fc maxDegrees) {
        this.minDegrees = minDegrees;
        this.maxDegrees = maxDegrees;
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public void addModules(ParticleModuleSet.Builder builder) {
        builder.addModule(particle -> {
            Vector3f rot = this.minDegrees.lerp(this.maxDegrees, particle.getRandomSource().nextFloat(), new Vector3f());
            particle.getRotation().add((float) Math.toRadians(rot.x), (float) Math.toRadians(rot.y), (float) Math.toRadians(rot.z));
        });
    }

    @Override // foundry.veil.api.quasar.data.module.ParticleModuleData
    public ModuleType<?> getType() {
        return ParticleModuleTypeRegistry.INIT_RANDOM_ROTATION;
    }
}
