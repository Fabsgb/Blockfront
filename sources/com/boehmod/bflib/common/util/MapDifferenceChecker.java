package com.boehmod.bflib.common.util;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/common/util/MapDifferenceChecker.class */
public class MapDifferenceChecker<K, V> {

    @NotNull
    private final Map<K, V> originalMap;

    public MapDifferenceChecker(@NotNull Map<K, V> originalMap) {
        this.originalMap = new Object2ObjectOpenHashMap(originalMap);
    }

    public boolean isDifferent(@NotNull Map<K, V> currentMap) {
        return !this.originalMap.equals(currentMap);
    }
}
