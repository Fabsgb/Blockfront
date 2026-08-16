package com.boehmod.blockfront;

import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.re */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/re.class */
public enum EnumC0972re {
    LINEAR(EnumC0972re::linearInterpolation);


    @NotNull
    private final a interpolator;

    /* JADX INFO: renamed from: com.boehmod.blockfront.re$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/re$a.class */
    @FunctionalInterface
    public interface a {
        @NotNull
        Vec3 interpolate(@NotNull C0973rf c0973rf, float f);
    }

    EnumC0972re(a aVar) {
        this.interpolator = aVar;
    }

    @NotNull
    public static Vec3 linearInterpolation(@NotNull C0973rf c0973rf, float f) {
        return C1270xJ.m7163a(c0973rf.f5446c, c0973rf.m5523v(), f);
    }

    @NotNull
    public Vec3 interpolate(@NotNull C0973rf c0973rf, float f) {
        return this.interpolator.interpolate(c0973rf, f);
    }
}
