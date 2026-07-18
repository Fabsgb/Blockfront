package com.boehmod.bflib.cloud.common.p000mm.report;

import com.boehmod.bflib.common.ColorReferences;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/mm/report/MatchResult.class */
public enum MatchResult {
    WIN(ColorReferences.COLOR_THEME_GREEN_HOVERED_SOLID),
    LOSS(ColorReferences.COLOR_THEME_RED_SOLID),
    DRAW(ColorReferences.COLOR_WHITE_SOLID);

    private final int color;

    MatchResult(int color) {
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }

    @NotNull
    public String getId() {
        return name().toLowerCase(Locale.ROOT);
    }

    @Nullable
    public static MatchResult fromId(@NotNull String id) {
        for (MatchResult result : values()) {
            if (result.getId().equals(id)) {
                return result;
            }
        }
        return null;
    }
}
