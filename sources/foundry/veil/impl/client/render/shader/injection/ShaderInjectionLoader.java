package foundry.veil.impl.client.render.shader.injection;

import com.google.gson.Gson;
import foundry.veil.Veil;
import foundry.veil.impl.client.render.shader.injection.util.ShaderInjectionDefinition;
import foundry.veil.impl.client.render.shader.injection.util.ValidationResult;
import java.io.Reader;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/injection/ShaderInjectionLoader.class */
@ApiStatus.Internal
public final class ShaderInjectionLoader {
    public static final FileToIdConverter INJECTION_LISTER = new FileToIdConverter("pinwheel/shader_injection", ".json");
    private static final Gson GSON = ShaderInjectionDefinition.createGson();

    public static LoadedPatches load(ResourceManager resourceManager) {
        List<LoadedPatch> patches = new LinkedList<>();
        Map<ResourceLocation, List<LoadedPatch>> byTarget = new LinkedHashMap<>();
        for (Map.Entry<ResourceLocation, Resource> entry : INJECTION_LISTER.listMatchingResources(resourceManager).entrySet()) {
            ResourceLocation file = entry.getKey();
            ResourceLocation defaultId = INJECTION_LISTER.fileToId(file);
            try {
                Reader reader = entry.getValue().openAsReader();
                try {
                    ShaderInjectionDefinition definition = ((ShaderInjectionDefinition) GSON.fromJson(reader, ShaderInjectionDefinition.class)).withDefaultId(defaultId);
                    ValidationResult validation = ShaderInjectionValidator.validate(definition, file.toString());
                    if (!validation.isValid()) {
                        Veil.LOGGER.warn("Skipping invalid shader injection {} from {}: {}", new Object[]{defaultId, file, validation.diagnostics()});
                        if (reader != null) {
                            reader.close();
                        }
                    } else {
                        patches.add(new LoadedPatch(file, definition));
                        if (reader != null) {
                            reader.close();
                        }
                    }
                } catch (Throwable th) {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e) {
                Veil.LOGGER.error("Couldn't load shader injection {} from {}", new Object[]{defaultId, file, e});
            }
        }
        for (LoadedPatch patch : patches) {
            for (ResourceLocation target : patch.definition().targets()) {
                byTarget.computeIfAbsent(target, k -> {
                    return new ArrayList();
                }).add(patch);
            }
        }
        byTarget.values().forEach(g -> {
            g.sort(Comparator.comparingInt(p -> {
                return p.definition().priority();
            }));
        });
        byTarget.replaceAll((t, g2) -> {
            return List.copyOf(g2);
        });
        return new LoadedPatches(byTarget);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/injection/ShaderInjectionLoader$LoadedPatches.class */
    public static final class LoadedPatches extends Record {
        private final Map<ResourceLocation, List<LoadedPatch>> byTarget;

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, LoadedPatches.class), LoadedPatches.class, "byTarget", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionLoader$LoadedPatches;->byTarget:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, LoadedPatches.class), LoadedPatches.class, "byTarget", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionLoader$LoadedPatches;->byTarget:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, LoadedPatches.class, Object.class), LoadedPatches.class, "byTarget", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionLoader$LoadedPatches;->byTarget:Ljava/util/Map;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public Map<ResourceLocation, List<LoadedPatch>> byTarget() {
            return this.byTarget;
        }

        public LoadedPatches(Map<ResourceLocation, List<LoadedPatch>> byTarget) {
            this.byTarget = Map.copyOf(byTarget);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/injection/ShaderInjectionLoader$LoadedPatch.class */
    public static final class LoadedPatch extends Record {
        private final ResourceLocation resourceLocation;
        private final ShaderInjectionDefinition definition;

        public LoadedPatch(ResourceLocation resourceLocation, ShaderInjectionDefinition definition) {
            this.resourceLocation = resourceLocation;
            this.definition = definition;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, LoadedPatch.class), LoadedPatch.class, "resourceLocation;definition", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionLoader$LoadedPatch;->resourceLocation:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionLoader$LoadedPatch;->definition:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, LoadedPatch.class), LoadedPatch.class, "resourceLocation;definition", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionLoader$LoadedPatch;->resourceLocation:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionLoader$LoadedPatch;->definition:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, LoadedPatch.class, Object.class), LoadedPatch.class, "resourceLocation;definition", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionLoader$LoadedPatch;->resourceLocation:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionLoader$LoadedPatch;->definition:Lfoundry/veil/impl/client/render/shader/injection/util/ShaderInjectionDefinition;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public ResourceLocation resourceLocation() {
            return this.resourceLocation;
        }

        public ShaderInjectionDefinition definition() {
            return this.definition;
        }
    }
}
