package foundry.veil.api.resource;

import com.mojang.serialization.Lifecycle;
import foundry.veil.mixin.registry.accessor.RegistryDataAccessor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;
import net.minecraft.Util;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/VeilDynamicRegistry.class */
public class VeilDynamicRegistry {
    private static final ThreadLocal<Boolean> LOADING = ThreadLocal.withInitial(() -> {
        return false;
    });

    public static CompletableFuture<Data> loadRegistries(ResourceManager resourceManager, Collection<RegistryDataLoader.RegistryData<?>> registries, Executor executor) {
        Map<ResourceKey<?>, Exception> errors = new ConcurrentHashMap<>();
        List<RegistryDataLoader.Loader<?>> loaders = registries.stream().map(data -> {
            return ((RegistryDataAccessor) data).invokeCreate(Lifecycle.stable(), errors);
        }).toList();
        RegistryOps.RegistryInfoLookup ctx = RegistryDataLoader.createContext(RegistryAccess.EMPTY, loaders);
        return Util.sequence(loaders.stream().map(loader -> {
            return CompletableFuture.supplyAsync(() -> {
                LOADING.set(true);
                loader.loadFromResources(resourceManager, ctx);
                LOADING.set(false);
                WritableRegistry writableRegistryRegistry = loader.registry();
                try {
                    writableRegistryRegistry.freeze();
                } catch (Exception e) {
                    errors.put(writableRegistryRegistry.key(), e);
                }
                if (loader.data().requiredNonEmpty() && writableRegistryRegistry.size() == 0) {
                    errors.put(writableRegistryRegistry.key(), new IllegalStateException("Registry must be non-empty"));
                }
                return writableRegistryRegistry;
            }, executor);
        }).toList()).thenApply(list -> {
            return new Data(new RegistryAccess.ImmutableRegistryAccess(list).freeze(), Collections.unmodifiableMap(errors));
        });
    }

    @Nullable
    public static String printErrors(Map<ResourceKey<?>, Exception> errors) {
        if (errors.isEmpty()) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        Map<ResourceLocation, Map<ResourceLocation, Exception>> sortedErrors = (Map) errors.entrySet().stream().collect(Collectors.groupingBy(entry -> {
            return ((ResourceKey) entry.getKey()).registry();
        }, Collectors.toMap(entry2 -> {
            return ((ResourceKey) entry2.getKey()).location();
        }, (v0) -> {
            return v0.getValue();
        })));
        sortedErrors.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(registryError -> {
            printWriter.printf("%n> %d Errors in registry %s:", Integer.valueOf(((Map) registryError.getValue()).size()), registryError.getKey());
            ((Map) registryError.getValue()).entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(elementError -> {
                Throwable cause = (Throwable) elementError.getValue();
                while (true) {
                    Throwable error = cause;
                    if (error.getCause() != null) {
                        cause = error.getCause();
                    } else {
                        printWriter.printf("%n>> Error in element %s: %s", elementError.getKey(), error.getMessage());
                        return;
                    }
                }
            });
        });
        printWriter.flush();
        return stringWriter.toString();
    }

    @ApiStatus.Internal
    public static boolean isLoading() {
        return LOADING.get().booleanValue();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/resource/VeilDynamicRegistry$Data.class */
    public static final class Data extends Record {
        private final RegistryAccess registryAccess;
        private final Map<ResourceKey<?>, Exception> errors;

        public Data(RegistryAccess registryAccess, Map<ResourceKey<?>, Exception> errors) {
            this.registryAccess = registryAccess;
            this.errors = errors;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Data.class), Data.class, "registryAccess;errors", "FIELD:Lfoundry/veil/api/resource/VeilDynamicRegistry$Data;->registryAccess:Lnet/minecraft/core/RegistryAccess;", "FIELD:Lfoundry/veil/api/resource/VeilDynamicRegistry$Data;->errors:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Data.class), Data.class, "registryAccess;errors", "FIELD:Lfoundry/veil/api/resource/VeilDynamicRegistry$Data;->registryAccess:Lnet/minecraft/core/RegistryAccess;", "FIELD:Lfoundry/veil/api/resource/VeilDynamicRegistry$Data;->errors:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Data.class, Object.class), Data.class, "registryAccess;errors", "FIELD:Lfoundry/veil/api/resource/VeilDynamicRegistry$Data;->registryAccess:Lnet/minecraft/core/RegistryAccess;", "FIELD:Lfoundry/veil/api/resource/VeilDynamicRegistry$Data;->errors:Ljava/util/Map;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public RegistryAccess registryAccess() {
            return this.registryAccess;
        }

        public Map<ResourceKey<?>, Exception> errors() {
            return this.errors;
        }
    }
}
