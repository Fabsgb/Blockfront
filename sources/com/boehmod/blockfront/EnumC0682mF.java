package com.boehmod.blockfront;

import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mF.class */
public enum EnumC0682mF {
    LINEAR(f -> {
        return f;
    }),
    EASE_IN(f2 -> {
        return f2 * f2;
    }),
    EASE_OUT(f3 -> {
        return 1.0f - ((1.0f - f3) * (1.0f - f3));
    }),
    EASE_IN_OUT(f4 -> {
        return ((double) f4) < 0.5d ? 2.0f * f4 * f4 : (float) (1.0d - (Math.pow(((-2.0f) * f4) + 2.0f, 2.0d) / 2.0d));
    });


    @NotNull
    private final InterfaceC0683mG interpolator;

    EnumC0682mF(InterfaceC0683mG interfaceC0683mG) {
        this.interpolator = interfaceC0683mG;
    }

    public float apply(float f) {
        return this.interpolator.interpolate(Mth.clamp(f, 0.0f, 1.0f));
    }
}
