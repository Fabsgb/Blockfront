package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mF.class */
public class C0681mF {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0680mE f3684a;

    /* JADX INFO: renamed from: K */
    @Nullable
    private Vec3 f3685K = null;

    /* JADX INFO: renamed from: lc */
    private int f3686lc = 0;

    /* JADX INFO: renamed from: am */
    private double f3687am = 0.0d;

    public C0681mF(@NotNull C0680mE c0680mE) {
        this.f3684a = c0680mE;
    }

    /* JADX INFO: renamed from: a */
    public void m3086a(@NotNull RandomSource randomSource) {
        Entity target = this.f3684a.getTarget();
        if (target != null && (this.f3684a.getSensing().hasLineOfSight(target) || this.f3684a.hasLineOfSight(target))) {
            this.f3687am = target.getEyeY();
            this.f3685K = target.position();
            this.f3686lc = -1;
            return;
        }
        if (this.f3686lc == -1) {
            this.f3686lc = randomSource.nextInt(7) * 20;
        }
        int i = this.f3686lc;
        this.f3686lc = i - 1;
        if (i == 0) {
            this.f3685K = null;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: k */
    public Vec3 m3087k() {
        return this.f3685K;
    }

    /* JADX INFO: renamed from: o */
    public double m3088o() {
        return this.f3687am;
    }

    /* JADX INFO: renamed from: aE */
    public boolean m3089aE() {
        return this.f3685K != null;
    }

    /* JADX INFO: renamed from: bf */
    public void m3090bf() {
        this.f3685K = null;
        this.f3686lc = 0;
    }
}
