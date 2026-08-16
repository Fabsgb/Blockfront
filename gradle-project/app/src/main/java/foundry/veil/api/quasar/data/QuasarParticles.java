package foundry.veil.api.quasar.data;

import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.particle.ParticleEmitter;
import foundry.veil.api.resource.VeilDynamicRegistry;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/data/QuasarParticles.class */
public final class QuasarParticles {
    public static final ResourceKey<Registry<ParticleModuleData>> MODULES = createRegistryKey("quasar/modules/module");
    public static final ResourceKey<Registry<QuasarParticleData>> PARTICLE_DATA = createRegistryKey("quasar/modules/particle_data");
    public static final ResourceKey<Registry<ParticleSettings>> PARTICLE_SETTINGS = createRegistryKey("quasar/modules/emitter/particle");
    public static final ResourceKey<Registry<EmitterShapeSettings>> EMITTER_SHAPE_SETTINGS = createRegistryKey("quasar/modules/emitter/shape");
    public static final ResourceKey<Registry<ParticleEmitterData>> EMITTER = createRegistryKey("quasar/emitters");
    private static final SuggestionProvider<?> EMITTER_SUGGESTION_PROVIDER = (unused, builder) -> {
        return (CompletableFuture) registryAccess().registry(EMITTER).map(registry -> {
            return SharedSuggestionProvider.suggestResource(registry.keySet(), builder);
        }).orElseGet(Suggestions::empty);
    };
    private static final List<RegistryDataLoader.RegistryData<?>> REGISTRIES = List.of(new RegistryDataLoader.RegistryData(MODULES, ParticleModuleData.DIRECT_CODEC, false), new RegistryDataLoader.RegistryData(PARTICLE_DATA, QuasarParticleData.DIRECT_CODEC, false), new RegistryDataLoader.RegistryData(PARTICLE_SETTINGS, ParticleSettings.DIRECT_CODEC, false), new RegistryDataLoader.RegistryData(EMITTER_SHAPE_SETTINGS, EmitterShapeSettings.DIRECT_CODEC, false), new RegistryDataLoader.RegistryData(EMITTER, ParticleEmitterData.DIRECT_CODEC, false));
    private static RegistryAccess registryAccess = RegistryAccess.EMPTY;

    private QuasarParticles() {
    }

    @ApiStatus.Internal
    public static void bootstrap() {
    }

    private static <T> ResourceKey<Registry<T>> createRegistryKey(String name) {
        return ResourceKey.createRegistryKey(Veil.veilPath(name));
    }

    public static <T extends SharedSuggestionProvider> SuggestionProvider<T> emitterSuggestionProvider() {
        return (SuggestionProvider<T>) EMITTER_SUGGESTION_PROVIDER;
    }

    public static RegistryAccess registryAccess() {
        return registryAccess;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/data/QuasarParticles$Reloader.class */
    @ApiStatus.Internal
    public static class Reloader implements PreparableReloadListener {
        @NotNull
        public CompletableFuture<Void> reload(PreparableReloadListener.PreparationBarrier preparationBarrier, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller preparationsProfiler, @NotNull ProfilerFiller reloadProfiler, @NotNull Executor backgroundExecutor, @NotNull Executor gameExecutor) {
            CompletableFuture<VeilDynamicRegistry.Data> completableFutureLoadRegistries = VeilDynamicRegistry.loadRegistries(resourceManager, QuasarParticles.REGISTRIES, backgroundExecutor);
            Objects.requireNonNull(preparationBarrier);
            return completableFutureLoadRegistries.thenCompose((v1) -> {
                return r1.wait(v1);
            }).thenAcceptAsync((Consumer<? super U>) data -> {
                QuasarParticles.registryAccess = data.registryAccess();
                ParticleEmitter.clearErrors();
                String msg = VeilDynamicRegistry.printErrors(data.errors());
                if (msg != null) {
                    Veil.LOGGER.error("Quasar registry loading errors:{}", msg);
                }
                Registry<ParticleModuleData> modulesRegistry = QuasarParticles.registryAccess.registryOrThrow(QuasarParticles.MODULES);
                for (Map.Entry<ResourceKey<ParticleModuleData>, ParticleModuleData> entry : modulesRegistry.entrySet()) {
                    ParticleModuleData moduleData = entry.getValue();
                    ModuleType.DeprecationStatus status = moduleData.getType().deprecationStatus();
                    if (status != null) {
                        Veil.LOGGER.error("{} is deprecated and will be removed in {}", entry.getKey(), status.removeVersion());
                        String reason = status.reason();
                        if (reason != null) {
                            Veil.LOGGER.error("Reason: {}", reason);
                        }
                    }
                }
                Veil.LOGGER.info("Loaded {} quasar particles", Integer.valueOf(QuasarParticles.registryAccess.registryOrThrow(QuasarParticles.EMITTER).size()));
                VeilRenderSystem.renderer().getParticleManager().clear();
            }, gameExecutor);
        }

        @NotNull
        public String getName() {
            return QuasarParticles.class.getSimpleName();
        }
    }
}
