package foundry.veil.impl.flare;

import foundry.veil.Veil;
import foundry.veil.api.flare.data.effect.FlareEffectTemplate;
import foundry.veil.api.flare.data.effect.FlareModule;
import foundry.veil.api.quasar.data.QuasarParticles;
import foundry.veil.api.resource.VeilDynamicRegistry;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/flare/FlareManager.class */
@ApiStatus.Internal
public class FlareManager {
    public static final ResourceKey<Registry<FlareEffectTemplate>> EFFECT_TEMPLATES = createRegistryKey("flare/templates");
    public static final ResourceKey<Registry<FlareModule>> EFFECT_MODULES = createRegistryKey("flare/modules");
    private static final List<RegistryDataLoader.RegistryData<?>> REGISTRIES = List.of(new RegistryDataLoader.RegistryData(EFFECT_TEMPLATES, FlareEffectTemplate.CODEC, false), new RegistryDataLoader.RegistryData(EFFECT_MODULES, FlareModule.CODEC, false));
    private static RegistryAccess registryAccess = RegistryAccess.EMPTY;

    private FlareManager() {
    }

    public static void bootstrap() {
    }

    private static <T> ResourceKey<Registry<T>> createRegistryKey(String name) {
        return ResourceKey.createRegistryKey(Veil.veilPath(name));
    }

    public static RegistryAccess registryAccess() {
        return registryAccess;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/flare/FlareManager$Reloader.class */
    public static class Reloader implements PreparableReloadListener {
        public static final Reloader INSTANCE = new Reloader();

        private Reloader() {
        }

        @NotNull
        public CompletableFuture<Void> reload(PreparableReloadListener.PreparationBarrier preparationBarrier, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller preparationsProfiler, @NotNull ProfilerFiller reloadProfiler, @NotNull Executor backgroundExecutor, @NotNull Executor gameExecutor) {
            CompletableFuture<VeilDynamicRegistry.Data> completableFutureLoadRegistries = VeilDynamicRegistry.loadRegistries(resourceManager, FlareManager.REGISTRIES, backgroundExecutor);
            Objects.requireNonNull(preparationBarrier);
            return completableFutureLoadRegistries.thenCompose((v1) -> {
                return r1.wait(v1);
            }).thenAcceptAsync((Consumer<? super U>) data -> {
                FlareManager.registryAccess = data.registryAccess();
                data.errors().values().forEach((v0) -> {
                    v0.printStackTrace();
                });
                String msg = VeilDynamicRegistry.printErrors(data.errors());
                if (msg != null) {
                    Veil.LOGGER.error("Flare registry loading errors:{}", msg);
                }
                Veil.LOGGER.info("Loaded {} templates", Integer.valueOf(FlareManager.registryAccess.registryOrThrow(FlareManager.EFFECT_TEMPLATES).size()));
                Veil.LOGGER.info("Loaded {} modules", Integer.valueOf(FlareManager.registryAccess.registryOrThrow(FlareManager.EFFECT_MODULES).size()));
            }, gameExecutor);
        }

        @NotNull
        public String getName() {
            return QuasarParticles.class.getSimpleName();
        }
    }
}
