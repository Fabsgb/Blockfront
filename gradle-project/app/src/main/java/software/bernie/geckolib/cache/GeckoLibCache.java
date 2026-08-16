package software.bernie.geckolib.cache;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.loading.FileLoader;
import software.bernie.geckolib.loading.json.FormatVersion;
import software.bernie.geckolib.loading.json.raw.Model;
import software.bernie.geckolib.loading.json.typeadapter.BakedAnimationsAdapter;
import software.bernie.geckolib.loading.object.BakedAnimations;
import software.bernie.geckolib.loading.object.BakedModelFactory;
import software.bernie.geckolib.loading.object.GeometryTree;
import software.bernie.geckolib.util.CompoundException;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/cache/GeckoLibCache.class */
public final class GeckoLibCache {
    private static final Set<String> EXCLUDED_NAMESPACES = ObjectOpenHashSet.of("moreplayermodels", "customnpcs", "gunsrpg");
    private static Map<ResourceLocation, BakedAnimations> ANIMATIONS = Collections.emptyMap();
    private static Map<ResourceLocation, BakedGeoModel> MODELS = Collections.emptyMap();

    public static Map<ResourceLocation, BakedAnimations> getBakedAnimations() {
        return ANIMATIONS;
    }

    public static Map<ResourceLocation, BakedGeoModel> getBakedModels() {
        return MODELS;
    }

    public static void registerReloadListener() {
        Minecraft mc = Minecraft.getInstance();
        if (mc != null) {
            ReloadableResourceManager resourceManager = mc.getResourceManager();
            if (resourceManager instanceof ReloadableResourceManager) {
                ReloadableResourceManager resourceManager2 = resourceManager;
                resourceManager2.registerReloadListener(GeckoLibCache::reload);
            }
        }
    }

    public static CompletableFuture<Void> reload(PreparableReloadListener.PreparationBarrier stage, ResourceManager resourceManager, ProfilerFiller preparationsProfiler, ProfilerFiller reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
        Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap();
        Object2ObjectOpenHashMap object2ObjectOpenHashMap2 = new Object2ObjectOpenHashMap();
        Objects.requireNonNull(object2ObjectOpenHashMap);
        Objects.requireNonNull(object2ObjectOpenHashMap2);
        CompletableFuture<Void> completableFutureAllOf = CompletableFuture.allOf(loadAnimations(backgroundExecutor, resourceManager, (v1, v2) -> {
            r5.put(v1, v2);
        }), loadModels(backgroundExecutor, resourceManager, (v1, v2) -> {
            r5.put(v1, v2);
        }));
        Objects.requireNonNull(stage);
        return completableFutureAllOf.thenCompose((v1) -> {
            return r1.wait(v1);
        }).thenAcceptAsync((Consumer<? super U>) empty -> {
            ANIMATIONS = object2ObjectOpenHashMap;
            MODELS = object2ObjectOpenHashMap2;
        }, gameExecutor);
    }

    private static CompletableFuture<Void> loadAnimations(Executor backgroundExecutor, ResourceManager resourceManager, BiConsumer<ResourceLocation, BakedAnimations> elementConsumer) {
        return CompletableFuture.runAsync(() -> {
            BakedAnimationsAdapter.COMPRESSION_CACHE = new ConcurrentHashMap();
        }, backgroundExecutor).thenRunAsync(() -> {
            loadResources(backgroundExecutor, resourceManager, "animations", resource -> {
                try {
                    return FileLoader.loadAnimationsFile(resource, resourceManager);
                } catch (CompoundException ex) {
                    ex.withMessage(resource.toString() + ": Error loading animation file").printStackTrace();
                    return new BakedAnimations(new Object2ObjectOpenHashMap());
                } catch (Exception ex2) {
                    throw GeckoLibConstants.exception(resource, "Error loading animation file", ex2);
                }
            }, elementConsumer);
        }).thenRunAsync(() -> {
            BakedAnimationsAdapter.COMPRESSION_CACHE = null;
        });
    }

    private static CompletableFuture<Void> loadModels(Executor backgroundExecutor, ResourceManager resourceManager, BiConsumer<ResourceLocation, BakedGeoModel> elementConsumer) {
        return loadResources(backgroundExecutor, resourceManager, "geo", resource -> {
            try {
                Model model = FileLoader.loadModelFile(resource, resourceManager);
                FormatVersion selector0$temp = model.formatVersion();
                switch ((int) SwitchBootstraps.enumSwitch(MethodHandles.lookup(), "enumSwitch", MethodType.methodType(Integer.TYPE, FormatVersion.class, Integer.TYPE), "V_1_12_0", "V_1_14_0", "V_1_21_0").dynamicInvoker().invoke(selector0$temp, 0) /* invoke-custom */) {
                    case -1:
                    default:
                        GeckoLibConstants.LOGGER.warn("Unsupported geometry json version for model {}. Supported versions: 1.12.0", resource);
                        break;
                    case 0:
                        break;
                    case 1:
                        GeckoLibConstants.LOGGER.warn("Unsupported geometry json version: 1.14.0 for model {}. This model may not appear as expected", resource);
                        break;
                    case 2:
                        GeckoLibConstants.LOGGER.warn("Unsupported geometry json version: 1.21.0 for model {}. Supported versions: 1.12.0. Remove any rotated face UVs and re-export the model to fix", resource);
                        break;
                }
                return BakedModelFactory.getForNamespace(resource.getNamespace()).constructGeoModel(GeometryTree.fromModel(model));
            } catch (Exception ex) {
                throw GeckoLibConstants.exception(resource, "Error loading model file", ex);
            }
        }, elementConsumer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> CompletableFuture<Void> loadResources(Executor executor, ResourceManager resourceManager, String path, Function<ResourceLocation, T> loader, BiConsumer<ResourceLocation, T> map) {
        return CompletableFuture.supplyAsync(() -> {
            return resourceManager.listResources(path, fileName -> {
                return fileName.toString().endsWith(".json");
            });
        }, executor).thenApplyAsync(resources -> {
            Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap();
            for (ResourceLocation resource : resources.keySet()) {
                object2ObjectOpenHashMap.put(resource, CompletableFuture.supplyAsync(() -> {
                    return loader.apply(resource);
                }, executor));
            }
            return object2ObjectOpenHashMap;
        }, executor).thenAcceptAsync((Consumer) tasks -> {
            for (Map.Entry entry : tasks.entrySet()) {
                if (!EXCLUDED_NAMESPACES.contains(((ResourceLocation) entry.getKey()).getNamespace().toLowerCase(Locale.ROOT))) {
                    map.accept((ResourceLocation) entry.getKey(), ((CompletableFuture) entry.getValue()).join());
                }
            }
        }, executor);
    }

    public static synchronized void registerNamespaceExclusion(String namespace) {
        EXCLUDED_NAMESPACES.add(namespace);
    }
}
