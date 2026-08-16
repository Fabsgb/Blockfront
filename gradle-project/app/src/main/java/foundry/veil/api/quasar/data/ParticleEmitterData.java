package foundry.veil.api.quasar.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.Holder;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/data/ParticleEmitterData.class */
public final class ParticleEmitterData extends Record {
    private final int maxLifetime;
    private final boolean loop;
    private final int rate;
    private final int count;
    private final int maxParticles;
    private final EmitterSettings emitterSettings;
    private final Holder<QuasarParticleData> particleDataHolder;
    public static final Codec<ParticleEmitterData> DIRECT_CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.INT.fieldOf("max_lifetime").forGetter((v0) -> {
            return v0.maxLifetime();
        }), Codec.BOOL.optionalFieldOf("loop", false).forGetter((v0) -> {
            return v0.loop();
        }), Codec.INT.fieldOf("rate").forGetter((v0) -> {
            return v0.rate();
        }), Codec.INT.fieldOf("count").forGetter((v0) -> {
            return v0.count();
        }), Codec.intRange(0, Integer.MAX_VALUE).optionalFieldOf("max_particles", Integer.MAX_VALUE).forGetter((v0) -> {
            return v0.maxParticles();
        }), EmitterSettings.CODEC.fieldOf("emitter_settings").forGetter((v0) -> {
            return v0.emitterSettings();
        }), QuasarParticleData.CODEC.fieldOf("particle_data").forGetter((v0) -> {
            return v0.particleDataHolder();
        })).apply(instance, (v1, v2, v3, v4, v5, v6, v7) -> {
            return new ParticleEmitterData(v1, v2, v3, v4, v5, v6, v7);
        });
    });
    public static final Codec<Holder<ParticleEmitterData>> CODEC = RegistryFileCodec.create(QuasarParticles.EMITTER, DIRECT_CODEC);

    public ParticleEmitterData(int maxLifetime, boolean loop, int rate, int count, int maxParticles, EmitterSettings emitterSettings, Holder<QuasarParticleData> particleDataHolder) {
        this.maxLifetime = maxLifetime;
        this.loop = loop;
        this.rate = rate;
        this.count = count;
        this.maxParticles = maxParticles;
        this.emitterSettings = emitterSettings;
        this.particleDataHolder = particleDataHolder;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ParticleEmitterData.class), ParticleEmitterData.class, "maxLifetime;loop;rate;count;maxParticles;emitterSettings;particleDataHolder", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->maxLifetime:I", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->loop:Z", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->rate:I", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->count:I", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->maxParticles:I", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->emitterSettings:Lfoundry/veil/api/quasar/data/EmitterSettings;", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->particleDataHolder:Lnet/minecraft/core/Holder;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ParticleEmitterData.class), ParticleEmitterData.class, "maxLifetime;loop;rate;count;maxParticles;emitterSettings;particleDataHolder", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->maxLifetime:I", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->loop:Z", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->rate:I", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->count:I", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->maxParticles:I", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->emitterSettings:Lfoundry/veil/api/quasar/data/EmitterSettings;", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->particleDataHolder:Lnet/minecraft/core/Holder;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ParticleEmitterData.class, Object.class), ParticleEmitterData.class, "maxLifetime;loop;rate;count;maxParticles;emitterSettings;particleDataHolder", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->maxLifetime:I", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->loop:Z", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->rate:I", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->count:I", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->maxParticles:I", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->emitterSettings:Lfoundry/veil/api/quasar/data/EmitterSettings;", "FIELD:Lfoundry/veil/api/quasar/data/ParticleEmitterData;->particleDataHolder:Lnet/minecraft/core/Holder;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public int maxLifetime() {
        return this.maxLifetime;
    }

    public boolean loop() {
        return this.loop;
    }

    public int rate() {
        return this.rate;
    }

    public int count() {
        return this.count;
    }

    public int maxParticles() {
        return this.maxParticles;
    }

    public EmitterSettings emitterSettings() {
        return this.emitterSettings;
    }

    public Holder<QuasarParticleData> particleDataHolder() {
        return this.particleDataHolder;
    }

    public QuasarParticleData particleData() {
        return (QuasarParticleData) this.particleDataHolder.value();
    }

    @Nullable
    public ResourceLocation getRegistryId() {
        return particleData().getRegistryId();
    }
}
