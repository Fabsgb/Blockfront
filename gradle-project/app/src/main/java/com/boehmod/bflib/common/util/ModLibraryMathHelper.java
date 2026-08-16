package com.boehmod.bflib.common.util;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/common/util/ModLibraryMathHelper.class */
public class ModLibraryMathHelper {
    private ModLibraryMathHelper() {
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        long factor = (long) Math.pow(10.0d, places);
        return Math.round(value * factor) / factor;
    }
}
