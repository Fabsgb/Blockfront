package com.boehmod.bflib.cloud.common;

import com.boehmod.bflib.common.ColorReferences;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/PopupType.class */
public enum PopupType {
    SUCCESS(ColorReferences.COLOR_TEAM_ALLIES, "player"),
    FAIL(ColorReferences.COLOR_THEME_RED, "player_error"),
    UPDATE(ColorReferences.COLOR_THEME_YELLOW, "player"),
    RULES(ColorReferences.COLOR_THEME_RED, "player"),
    DISCORD_LINK(ColorReferences.COLOR_THEME_DISCORD, "player");

    private final int color;

    @NotNull
    private final String image;

    PopupType(int color, @NotNull String image) {
        this.color = color;
        this.image = image;
    }

    public int getColor() {
        return this.color;
    }

    @NotNull
    public String getImage() {
        return this.image;
    }
}
