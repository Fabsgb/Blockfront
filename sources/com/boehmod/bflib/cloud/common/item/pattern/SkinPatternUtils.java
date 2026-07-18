package com.boehmod.bflib.cloud.common.item.pattern;

import java.awt.Point;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/pattern/SkinPatternUtils.class */
public class SkinPatternUtils {
    @Nonnull
    public static Point decodeUV(double mint, @Nonnull SkinPattern pattern) {
        return decodeUV(mint, pattern.width(), pattern.height());
    }

    @Nonnull
    public static Point decodeUV(double mint, int width, int height) {
        long combined = (long) (mint * 9.007199254740991E15d);
        int packedX = (int) ((combined >> 26) & 67108863);
        int packedY = (int) (combined & 67108863);
        int x = (int) ((((double) packedX) / 6.7108863E7d) * ((double) (width - 1)));
        int y = (int) ((((double) packedY) / 6.7108863E7d) * ((double) (height - 1)));
        return new Point(x, y);
    }
}
