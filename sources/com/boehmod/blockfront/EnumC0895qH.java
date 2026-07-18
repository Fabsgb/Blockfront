package com.boehmod.blockfront;

import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qH.class */
public enum EnumC0895qH {
    LINEAR(EnumC0895qH::linearInterpolation);


    @NotNull
    private final a interpolator;

    /* JADX INFO: renamed from: com.boehmod.blockfront.qH$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qH$a.class */
    @FunctionalInterface
    public interface a {
        @NotNull
        Vec3 interpolate(@NotNull C0896qI c0896qI, float f);
    }

    EnumC0895qH(@NotNull a aVar) {
        this.interpolator = aVar;
    }

    @NotNull
    public static Vec3 linearInterpolation(@NotNull C0896qI c0896qI, float f) {
        return C1290xm.m7837a(c0896qI.f4716c, c0896qI.m4628u(), f);
    }

    @NotNull
    public Vec3 interpolate(@NotNull C0896qI c0896qI, float f) {
        return this.interpolator.interpolate(c0896qI, f);
    }
}
