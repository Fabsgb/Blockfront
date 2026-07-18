package com.boehmod.bflib.cloud.common.player.status;

import com.boehmod.bflib.common.ColorReferences;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/status/OnlineStatus.class */
public enum OnlineStatus {
    ONLINE("bf.status.online", 9633658),
    OFFLINE("bf.status.offline", ColorReferences.COLOR_STATUS_OFFLINE);


    @NotNull
    private final String label;
    private final int color;

    OnlineStatus(@NotNull String label, int color) {
        this.label = label;
        this.color = color;
    }

    @NotNull
    public String getLabel() {
        return this.label;
    }

    public int getColor() {
        return this.color;
    }

    public boolean isOnline() {
        return this == ONLINE;
    }
}
