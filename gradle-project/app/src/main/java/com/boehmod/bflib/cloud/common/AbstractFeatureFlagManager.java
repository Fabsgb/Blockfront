package com.boehmod.bflib.cloud.common;

import com.boehmod.bflib.common.util.MapDifferenceChecker;
import it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import it.unimi.dsi.fastutil.objects.Object2BooleanMaps;
import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;
import java.util.Map;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/AbstractFeatureFlagManager.class */
public abstract class AbstractFeatureFlagManager {

    @NotNull
    private static final Logger LOGGER = LogManager.getLogger("FeatureFlags");

    @NotNull
    protected final Object2BooleanMap<String> featureFlags = new Object2BooleanOpenHashMap();

    protected abstract void featureFlagsChanged();

    @NotNull
    public Object2BooleanMap<String> getFeatureFlags() {
        return Object2BooleanMaps.unmodifiable(this.featureFlags);
    }

    @OverridingMethodsMustInvokeSuper
    public void setFeatureFlags(@NotNull Map<String, Boolean> featureFlags) {
        this.featureFlags.clear();
        this.featureFlags.putAll(featureFlags);
        featureFlagsChanged();
    }

    @OverridingMethodsMustInvokeSuper
    public void setFeatureFlag(@NotNull String featureId, boolean value) {
        MapDifferenceChecker<String, Boolean> mapDifference = new MapDifferenceChecker<>(this.featureFlags);
        this.featureFlags.put(featureId, value);
        if (mapDifference.isDifferent(this.featureFlags)) {
            featureFlagsChanged();
        }
        LOGGER.info("Setting feature flag '{}' to '{}'", featureId, value ? "Enabled" : "Disabled");
    }

    public boolean isEnabled(@NotNull String featureId) {
        return isEnabled(featureId, false);
    }

    public boolean isEnabled(@NotNull String featureId, boolean defaultValue) {
        return this.featureFlags.getOrDefault(featureId, defaultValue);
    }

    public void ifEnabled(@NotNull String featureId, @NotNull Runnable action) {
        if (isEnabled(featureId)) {
            action.run();
        }
    }
}
