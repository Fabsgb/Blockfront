package com.boehmod.bflib.cloud.common.mm;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/mm/SearchRegion.class */
public enum SearchRegion {
    ALL("all"),
    EU("eu"),
    US("us");


    @NotNull
    private final String id;

    SearchRegion(@NotNull String id) {
        this.id = id;
    }

    @NotNull
    public static SearchRegion fromId(@NotNull String id) {
        return (SearchRegion) Arrays.stream(values()).filter(region -> {
            return region.id.equalsIgnoreCase(id);
        }).findFirst().orElse(ALL);
    }

    @NotNull
    public String getId() {
        return this.id;
    }
}
