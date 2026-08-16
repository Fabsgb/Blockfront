package foundry.veil.impl.client.render.shader.injection;

import foundry.veil.Veil;
import foundry.veil.impl.client.render.shader.injection.util.ShaderInjection;
import foundry.veil.impl.client.render.shader.injection.util.ShaderInjectionDefinition;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/injection/ShaderInjectionManager.class */
@ApiStatus.Internal
public class ShaderInjectionManager extends SimplePreparableReloadListener<Preparations> {
    private static final Pattern SHADER_EXTENSION = Pattern.compile("\\.(fsh|vsh|tcsh|tesh|gsh|comp)$");
    private Map<ResourceLocation, List<ShaderInjection>> shaders = Collections.emptyMap();
    private Map<ShaderInjection, ResourceLocation> names = Collections.emptyMap();
    private Map<ResourceLocation, ResourceLocation> replacements = Collections.emptyMap();

    public void applyModifiers(ResourceLocation shaderId, GlslTree tree, boolean applyVersion) {
        Collection<ShaderInjection> modifiers = getModifiers(shaderId);
        if (modifiers.isEmpty()) {
            return;
        }
        try {
            for (ShaderInjection modifier : modifiers) {
                modifier.inject(tree, applyVersion);
            }
        } catch (Exception e) {
            Veil.LOGGER.error("Failed to transform shader: {}", shaderId, e);
        }
    }

    public List<ShaderInjection> getModifiers(ResourceLocation shaderId) {
        return this.shaders.getOrDefault(shaderId, Collections.emptyList());
    }

    @Nullable
    public ResourceLocation getModifierId(ShaderInjection modification) {
        return this.names.get(modification);
    }

    @Nullable
    public ResourceLocation getReplacement(ResourceLocation target) {
        ResourceLocation stripped = stripShaderExtension(target);
        return this.replacements.get(stripped != null ? stripped : target);
    }

    @Nullable
    private static ResourceLocation stripShaderExtension(ResourceLocation location) {
        String path = location.getPath();
        String stripped = SHADER_EXTENSION.matcher(path).replaceFirst("");
        if (stripped.equals(path)) {
            return null;
        }
        return ResourceLocation.fromNamespaceAndPath(location.getNamespace(), stripped);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* JADX INFO: renamed from: prepare, reason: merged with bridge method [inline-methods] */
    public Preparations m9565prepare(@NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        Map<ResourceLocation, List<ShaderInjection>> modifiers = new HashMap<>();
        Map<ShaderInjection, ResourceLocation> names = new HashMap<>();
        Map<ResourceLocation, ResourceLocation> replacements = new HashMap<>();
        ShaderInjectionLoader.LoadedPatches loaded = ShaderInjectionLoader.load(resourceManager);
        for (Map.Entry<ResourceLocation, List<ShaderInjectionLoader.LoadedPatch>> entry : loaded.byTarget().entrySet()) {
            ResourceLocation target = entry.getKey();
            List<ShaderInjectionLoader.LoadedPatch> patches = entry.getValue();
            List<ShaderInjection> mods = modifiers.computeIfAbsent(target, k -> {
                return new LinkedList();
            });
            for (ShaderInjectionLoader.LoadedPatch patch : patches) {
                ShaderInjectionDefinition definition = patch.definition();
                if (definition.replace() != null) {
                    ResourceLocation replaceTarget = stripShaderExtension(target);
                    if (replaceTarget == null) {
                        replaceTarget = target;
                    }
                    replacements.put(replaceTarget, definition.replace());
                    if (definition.debug()) {
                        Veil.LOGGER.info("\n═══ Replace: {} ═══\n  Target:   {}\n  Replace:  {}\n  Source:   {}", new Object[]{replaceTarget, target, definition.replace(), patch.resourceLocation()});
                    }
                } else {
                    try {
                        for (ShaderInjection m : ShaderInjectionAdapter.toModifications(definition, resourceManager)) {
                            mods.add(m);
                            names.put(m, definition.m8348id() != null ? definition.m8348id() : patch.resourceLocation());
                        }
                    } catch (Throwable t) {
                        Veil.LOGGER.error("Couldn't adapt shader injection {}", patch.resourceLocation(), t);
                    }
                }
            }
        }
        return new Preparations(modifiers, names, replacements);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apply(@NotNull Preparations preparations, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller profilerFiller) {
        this.shaders = Collections.unmodifiableMap(preparations.shaders);
        this.names = Collections.unmodifiableMap(preparations.names);
        this.replacements = Collections.unmodifiableMap(preparations.replacements);
        Veil.LOGGER.info("Loaded {} shader redirects, {} replacements", Integer.valueOf(this.names.size()), Integer.valueOf(this.replacements.size()));
        if (!this.replacements.isEmpty()) {
            Veil.LOGGER.debug("Active shader replacements:");
            this.replacements.forEach((target, replacement) -> {
                Veil.LOGGER.debug("  {} -> {}", target, replacement);
            });
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/injection/ShaderInjectionManager$Preparations.class */
    @ApiStatus.Internal
    public static final class Preparations extends Record {
        private final Map<ResourceLocation, List<ShaderInjection>> shaders;
        private final Map<ShaderInjection, ResourceLocation> names;
        private final Map<ResourceLocation, ResourceLocation> replacements;

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Preparations.class), Preparations.class, "shaders;names;replacements", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionManager$Preparations;->shaders:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionManager$Preparations;->names:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionManager$Preparations;->replacements:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Preparations.class), Preparations.class, "shaders;names;replacements", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionManager$Preparations;->shaders:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionManager$Preparations;->names:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionManager$Preparations;->replacements:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Preparations.class, Object.class), Preparations.class, "shaders;names;replacements", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionManager$Preparations;->shaders:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionManager$Preparations;->names:Ljava/util/Map;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/ShaderInjectionManager$Preparations;->replacements:Ljava/util/Map;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public Map<ResourceLocation, List<ShaderInjection>> shaders() {
            return this.shaders;
        }

        public Map<ShaderInjection, ResourceLocation> names() {
            return this.names;
        }

        public Map<ResourceLocation, ResourceLocation> replacements() {
            return this.replacements;
        }

        public Preparations(Map<ResourceLocation, List<ShaderInjection>> shaders, Map<ShaderInjection, ResourceLocation> names, Map<ResourceLocation, ResourceLocation> replacements) {
            this.shaders = shaders;
            this.names = names;
            this.replacements = replacements;
        }
    }
}
