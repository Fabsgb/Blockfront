package foundry.veil.impl;

import foundry.veil.Veil;
import foundry.veil.platform.VeilPlatform;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.ApiStatus;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/VeilMixinPlugin.class */
@ApiStatus.Internal
public abstract class VeilMixinPlugin implements IMixinConfigPlugin {
    private static final String PACKAGE_NAME = Veil.platform().getPlatformType().getMixinPackageName();
    private static final Set<String> COMPAT = Set.of("foundry.veil." + PACKAGE_NAME + ".mixin.client.stage", "foundry.veil." + PACKAGE_NAME + ".mixin.client.perspective", "foundry.veil." + PACKAGE_NAME + ".mixin.client.debug");
    private static final Map<String, Set<String>> INCOMPATIBLE_MIXINS = new Object2ObjectArrayMap();
    private final Map<String, Boolean> loadedMods = new HashMap();

    static {
        addModIncompatibility("affinity", "foundry.veil.mixin.performance.client.PerformanceRenderTargetMixin", "foundry.veil.mixin.performance.client.PerformanceLevelRendererMixin");
        addModIncompatibility("hdr_mod", "foundry.veil.mixin.performance.client.PerformanceRenderTargetMixin", "foundry.veil.mixin.performance.client.PerformanceLevelRendererMixin");
        addModIncompatibility("soulshade", "foundry.veil.mixin.performance.client.PerformanceRenderTargetMixin", "foundry.veil.mixin.performance.client.PerformanceLevelRendererMixin");
    }

    private static void addModIncompatibility(String modId, String... mixinClasses) {
        INCOMPATIBLE_MIXINS.computeIfAbsent(modId, a -> {
            return new ObjectArraySet();
        }).addAll(Arrays.asList(mixinClasses));
    }

    private boolean isModLoaded(String modId) {
        Map<String, Boolean> map = this.loadedMods;
        VeilPlatform veilPlatformPlatform = Veil.platform();
        Objects.requireNonNull(veilPlatformPlatform);
        return map.computeIfAbsent(modId, veilPlatformPlatform::isModLoaded).booleanValue();
    }

    public void onLoad(String mixinPackage) {
    }

    public String getRefMapperConfig() {
        return null;
    }

    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        for (String compat : COMPAT) {
            if (mixinClassName.startsWith(compat)) {
                if (Veil.SODIUM) {
                    return !mixinClassName.startsWith(compat + ".vanilla");
                }
                return !mixinClassName.startsWith(compat + ".sodium");
            }
        }
        if (Veil.IRIS && mixinClassName.startsWith("foundry.veil.mixin.dynamicbuffer")) {
            return false;
        }
        if (mixinClassName.startsWith("foundry.veil." + PACKAGE_NAME + ".mixin.compat")) {
            String[] parts = mixinClassName.split("\\.", 7);
            return isModLoaded(parts[5]);
        }
        for (Map.Entry<String, Set<String>> entry : INCOMPATIBLE_MIXINS.entrySet()) {
            if (isModLoaded(entry.getKey()) && entry.getValue().contains(mixinClassName)) {
                return false;
            }
        }
        return true;
    }

    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    public List<String> getMixins() {
        return null;
    }
}
