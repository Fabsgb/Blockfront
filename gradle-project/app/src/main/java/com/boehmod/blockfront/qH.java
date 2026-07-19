package com.boehmod.blockfront;

import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qH.class */
public enum qH {
    LINEAR(qH::linearInterpolation);


    @NotNull
    private final a interpolator;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qH$a.class */
    @FunctionalInterface
    public interface a {
        @NotNull
        Vec3 interpolate(@NotNull qI qIVar, float f);
    }

    qH(@NotNull a aVar) {
        this.interpolator = aVar;
    }

    @NotNull
    public static Vec3 linearInterpolation(@NotNull qI qIVar, float f) {
        return C0634xm.a(qIVar.c, qIVar.u(), f);
    }

    @NotNull
    public Vec3 interpolate(@NotNull qI qIVar, float f) {
        return this.interpolator.interpolate(qIVar, f);
    }
}
