package foundry.veil.api.quasar.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.util.CodecUtil;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.core.Holder;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/data/EmitterSettings.class */
public final class EmitterSettings extends Record {
    private final List<Holder<EmitterShapeSettings>> emitterShapeSettingsHolders;
    private final Holder<ParticleSettings> particleSettingsHolder;
    private final boolean forceSpawn;
    public static final Codec<EmitterSettings> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(CodecUtil.singleOrList(EmitterShapeSettings.CODEC).fieldOf("shape").forGetter((v0) -> {
            return v0.emitterShapeSettingsHolders();
        }), ParticleSettings.CODEC.fieldOf("particle_settings").forGetter((v0) -> {
            return v0.particleSettingsHolder();
        }), Codec.BOOL.optionalFieldOf("force_spawn", false).forGetter((v0) -> {
            return v0.forceSpawn();
        })).apply(instance, (v1, v2, v3) -> {
            return new EmitterSettings(v1, v2, v3);
        });
    });

    public EmitterSettings(List<Holder<EmitterShapeSettings>> emitterShapeSettingsHolders, Holder<ParticleSettings> particleSettingsHolder, boolean forceSpawn) {
        this.emitterShapeSettingsHolders = emitterShapeSettingsHolders;
        this.particleSettingsHolder = particleSettingsHolder;
        this.forceSpawn = forceSpawn;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, EmitterSettings.class), EmitterSettings.class, "emitterShapeSettingsHolders;particleSettingsHolder;forceSpawn", "FIELD:Lfoundry/veil/api/quasar/data/EmitterSettings;->emitterShapeSettingsHolders:Ljava/util/List;", "FIELD:Lfoundry/veil/api/quasar/data/EmitterSettings;->particleSettingsHolder:Lnet/minecraft/core/Holder;", "FIELD:Lfoundry/veil/api/quasar/data/EmitterSettings;->forceSpawn:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, EmitterSettings.class), EmitterSettings.class, "emitterShapeSettingsHolders;particleSettingsHolder;forceSpawn", "FIELD:Lfoundry/veil/api/quasar/data/EmitterSettings;->emitterShapeSettingsHolders:Ljava/util/List;", "FIELD:Lfoundry/veil/api/quasar/data/EmitterSettings;->particleSettingsHolder:Lnet/minecraft/core/Holder;", "FIELD:Lfoundry/veil/api/quasar/data/EmitterSettings;->forceSpawn:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, EmitterSettings.class, Object.class), EmitterSettings.class, "emitterShapeSettingsHolders;particleSettingsHolder;forceSpawn", "FIELD:Lfoundry/veil/api/quasar/data/EmitterSettings;->emitterShapeSettingsHolders:Ljava/util/List;", "FIELD:Lfoundry/veil/api/quasar/data/EmitterSettings;->particleSettingsHolder:Lnet/minecraft/core/Holder;", "FIELD:Lfoundry/veil/api/quasar/data/EmitterSettings;->forceSpawn:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public List<Holder<EmitterShapeSettings>> emitterShapeSettingsHolders() {
        return this.emitterShapeSettingsHolders;
    }

    public Holder<ParticleSettings> particleSettingsHolder() {
        return this.particleSettingsHolder;
    }

    public boolean forceSpawn() {
        return this.forceSpawn;
    }

    public List<EmitterShapeSettings> emitterShapeSettings() {
        return this.emitterShapeSettingsHolders.stream().map((v0) -> {
            return v0.value();
        }).toList();
    }

    public ParticleSettings particleSettings() {
        return (ParticleSettings) this.particleSettingsHolder.value();
    }
}
