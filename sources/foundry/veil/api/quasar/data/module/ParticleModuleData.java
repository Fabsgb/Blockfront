package foundry.veil.api.quasar.data.module;

import com.mojang.serialization.Codec;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.QuasarParticles;
import foundry.veil.api.quasar.particle.ParticleModuleSet;
import net.minecraft.core.Holder;
import net.minecraft.resources.RegistryFileCodec;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/data/module/ParticleModuleData.class */
public interface ParticleModuleData {
    public static final Codec<ParticleModuleData> DIRECT_CODEC = ParticleModuleTypeRegistry.CODEC.dispatch("module", (v0) -> {
        return v0.getType();
    }, (v0) -> {
        return v0.codec();
    });

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final Codec<ParticleModuleData> INIT_DIRECT_CODEC = DIRECT_CODEC;

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final Codec<ParticleModuleData> UPDATE_DIRECT_CODEC = DIRECT_CODEC;

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final Codec<ParticleModuleData> RENDER_DIRECT_CODEC = DIRECT_CODEC;
    public static final Codec<Holder<ParticleModuleData>> CODEC = RegistryFileCodec.create(QuasarParticles.MODULES, DIRECT_CODEC);

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final Codec<Holder<ParticleModuleData>> INIT_CODEC = CODEC;

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final Codec<Holder<ParticleModuleData>> UPDATE_CODEC = CODEC;

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final Codec<Holder<ParticleModuleData>> RENDER_CODEC = CODEC;

    void addModules(ParticleModuleSet.Builder builder);

    ModuleType<?> getType();
}
