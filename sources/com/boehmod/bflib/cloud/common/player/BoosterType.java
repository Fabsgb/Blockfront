package com.boehmod.bflib.cloud.common.player;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/BoosterType.class */
public enum BoosterType {
    EXP("EXP"),
    EMERALDS("Emeralds");


    @NotNull
    private final String title;

    BoosterType(@NotNull String title) {
        this.title = title;
    }

    @NotNull
    public String getTitle() {
        return this.title;
    }
}
