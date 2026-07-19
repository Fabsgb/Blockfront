package foundry.veil.api.quasar.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.util.CodecUtil;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.Holder;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/data/ParticleSettings.class */
public final class ParticleSettings extends Record {
    private final float particleSpeed;
    private final float particleSize;
    private final float particleSizeVariation;
    private final int particleLifetime;
    private final float particleLifetimeVariation;
    private final Vector3fc initialDirection;
    private final boolean randomInitialDirection;
    private final Vector3fc initialRotation;
    private final boolean randomInitialRotation;
    private final boolean randomSpeed;
    private final boolean randomSize;
    private final boolean randomLifetime;
    public static final Codec<ParticleSettings> DIRECT_CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("particle_speed").forGetter((v0) -> {
            return v0.particleSpeed();
        }), Codec.FLOAT.fieldOf("base_particle_size").forGetter((v0) -> {
            return v0.particleSize();
        }), Codec.FLOAT.optionalFieldOf("particle_size_variation", Float.valueOf(0.0f)).forGetter((v0) -> {
            return v0.particleSizeVariation();
        }), Codec.INT.fieldOf("particle_lifetime").forGetter((v0) -> {
            return v0.particleLifetime();
        }), Codec.FLOAT.optionalFieldOf("particle_lifetime_variation", Float.valueOf(0.0f)).forGetter((v0) -> {
            return v0.particleLifetimeVariation();
        }), CodecUtil.VECTOR3FC_CODEC.optionalFieldOf("initial_direction", new Vector3f(1.0f)).forGetter((v0) -> {
            return v0.initialDirection();
        }), Codec.BOOL.optionalFieldOf("random_initial_direction", false).forGetter((v0) -> {
            return v0.randomInitialDirection();
        }), CodecUtil.VECTOR3FC_CODEC.optionalFieldOf("initial_rotation", new Vector3f(0.0f)).forGetter((v0) -> {
            return v0.initialRotation();
        }), Codec.BOOL.optionalFieldOf("random_initial_rotation", false).forGetter((v0) -> {
            return v0.randomInitialRotation();
        }), Codec.BOOL.optionalFieldOf("random_speed", false).forGetter((v0) -> {
            return v0.randomSpeed();
        }), Codec.BOOL.optionalFieldOf("random_size", false).forGetter((v0) -> {
            return v0.randomSize();
        }), Codec.BOOL.optionalFieldOf("random_lifetime", false).forGetter((v0) -> {
            return v0.randomLifetime();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12) -> {
            return new ParticleSettings(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12);
        });
    });
    public static final Codec<Holder<ParticleSettings>> CODEC = RegistryFileCodec.create(QuasarParticles.PARTICLE_SETTINGS, DIRECT_CODEC);

    public ParticleSettings(float particleSpeed, float particleSize, float particleSizeVariation, int particleLifetime, float particleLifetimeVariation, Vector3fc initialDirection, boolean randomInitialDirection, Vector3fc initialRotation, boolean randomInitialRotation, boolean randomSpeed, boolean randomSize, boolean randomLifetime) {
        this.particleSpeed = particleSpeed;
        this.particleSize = particleSize;
        this.particleSizeVariation = particleSizeVariation;
        this.particleLifetime = particleLifetime;
        this.particleLifetimeVariation = particleLifetimeVariation;
        this.initialDirection = initialDirection;
        this.randomInitialDirection = randomInitialDirection;
        this.initialRotation = initialRotation;
        this.randomInitialRotation = randomInitialRotation;
        this.randomSpeed = randomSpeed;
        this.randomSize = randomSize;
        this.randomLifetime = randomLifetime;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ParticleSettings.class), ParticleSettings.class, "particleSpeed;particleSize;particleSizeVariation;particleLifetime;particleLifetimeVariation;initialDirection;randomInitialDirection;initialRotation;randomInitialRotation;randomSpeed;randomSize;randomLifetime", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->particleSpeed:F", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->particleSize:F", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->particleSizeVariation:F", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->particleLifetime:I", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->particleLifetimeVariation:F", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->initialDirection:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->randomInitialDirection:Z", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->initialRotation:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->randomInitialRotation:Z", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->randomSpeed:Z", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->randomSize:Z", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->randomLifetime:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ParticleSettings.class), ParticleSettings.class, "particleSpeed;particleSize;particleSizeVariation;particleLifetime;particleLifetimeVariation;initialDirection;randomInitialDirection;initialRotation;randomInitialRotation;randomSpeed;randomSize;randomLifetime", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->particleSpeed:F", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->particleSize:F", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->particleSizeVariation:F", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->particleLifetime:I", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->particleLifetimeVariation:F", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->initialDirection:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->randomInitialDirection:Z", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->initialRotation:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->randomInitialRotation:Z", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->randomSpeed:Z", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->randomSize:Z", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->randomLifetime:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ParticleSettings.class, Object.class), ParticleSettings.class, "particleSpeed;particleSize;particleSizeVariation;particleLifetime;particleLifetimeVariation;initialDirection;randomInitialDirection;initialRotation;randomInitialRotation;randomSpeed;randomSize;randomLifetime", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->particleSpeed:F", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->particleSize:F", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->particleSizeVariation:F", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->particleLifetime:I", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->particleLifetimeVariation:F", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->initialDirection:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->randomInitialDirection:Z", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->initialRotation:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->randomInitialRotation:Z", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->randomSpeed:Z", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->randomSize:Z", "FIELD:Lfoundry/veil/api/quasar/data/ParticleSettings;->randomLifetime:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public float particleSpeed() {
        return this.particleSpeed;
    }

    public float particleSize() {
        return this.particleSize;
    }

    public float particleSizeVariation() {
        return this.particleSizeVariation;
    }

    public int particleLifetime() {
        return this.particleLifetime;
    }

    public float particleLifetimeVariation() {
        return this.particleLifetimeVariation;
    }

    public Vector3fc initialDirection() {
        return this.initialDirection;
    }

    public boolean randomInitialDirection() {
        return this.randomInitialDirection;
    }

    public Vector3fc initialRotation() {
        return this.initialRotation;
    }

    public boolean randomInitialRotation() {
        return this.randomInitialRotation;
    }

    public boolean randomSpeed() {
        return this.randomSpeed;
    }

    public boolean randomSize() {
        return this.randomSize;
    }

    public boolean randomLifetime() {
        return this.randomLifetime;
    }

    public float particleSpeed(RandomSource random) {
        return this.randomSpeed ? this.particleSpeed + (((random.nextFloat() * 0.5f) - 0.5f) * this.particleSpeed) : this.particleSpeed;
    }

    public float particleSize(RandomSource random) {
        return this.randomSize ? this.particleSize + (random.nextFloat() * this.particleSizeVariation) : this.particleSize;
    }

    public int particleLifetime(RandomSource random) {
        return this.randomLifetime ? this.particleLifetime + ((int) (random.nextFloat() * this.particleLifetimeVariation)) : this.particleLifetime;
    }

    public Vector3fc initialDirection(RandomSource random) {
        return this.randomInitialDirection ? this.initialDirection.mul((random.nextFloat() * 2.0f) - 1.0f, (random.nextFloat() * 2.0f) - 1.0f, (random.nextFloat() * 2.0f) - 1.0f, new Vector3f()) : this.initialDirection;
    }

    public Vector3fc initialRotation(RandomSource random) {
        return this.randomInitialRotation ? this.initialRotation.mul((random.nextFloat() * 2.0f) - 1.0f, (random.nextFloat() * 2.0f) - 1.0f, (random.nextFloat() * 2.0f) - 1.0f, new Vector3f()) : this.initialRotation;
    }

    public Vector3f particleDirection(RandomSource random) {
        return initialDirection(random).mul(particleSpeed(random), new Vector3f());
    }

    @Nullable
    public ResourceLocation getRegistryId() {
        return (ResourceLocation) QuasarParticles.registryAccess().registry(QuasarParticles.PARTICLE_SETTINGS).map(registry -> {
            return registry.getKey(this);
        }).orElse(null);
    }
}
