package com.boehmod.bflib.cloud.common.p001mm;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/mm/SearchRegion.class */
public enum SearchRegion {
    ALL("all"),
    EU("eu"),
    US("us");


    /* JADX INFO: renamed from: id */
    @NotNull
    private final String f6id;

    SearchRegion(String id) {
        this.f6id = id;
    }

    @NotNull
    public static SearchRegion fromId(@NotNull String id) {
        return (SearchRegion) Arrays.stream(values()).filter(region -> {
            return region.f6id.equalsIgnoreCase(id);
        }).findFirst().orElse(ALL);
    }

    @NotNull
    public String getId() {
        return this.f6id;
    }
}
