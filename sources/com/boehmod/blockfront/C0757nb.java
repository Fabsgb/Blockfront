package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nb.class */
public class C0757nb {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0756na f4247a;

    /* JADX INFO: renamed from: L */
    @Nullable
    private Vec3 f4248L = null;

    /* JADX INFO: renamed from: na */
    private int f4249na = 0;

    /* JADX INFO: renamed from: az */
    private double f4250az = 0.0d;

    public C0757nb(@NotNull C0756na c0756na) {
        this.f4247a = c0756na;
    }

    /* JADX INFO: renamed from: a */
    public void m3593a(@NotNull RandomSource randomSource) {
        Entity target = this.f4247a.getTarget();
        if (target != null && (this.f4247a.getSensing().hasLineOfSight(target) || this.f4247a.hasLineOfSight(target))) {
            this.f4250az = target.getEyeY();
            this.f4248L = target.position();
            this.f4249na = -1;
            return;
        }
        if (this.f4249na == -1) {
            this.f4249na = randomSource.nextInt(7) * 20;
        }
        int i = this.f4249na;
        this.f4249na = i - 1;
        if (i == 0) {
            this.f4248L = null;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: l */
    public Vec3 m3594l() {
        return this.f4248L;
    }

    /* JADX INFO: renamed from: q */
    public double m3595q() {
        return this.f4250az;
    }

    /* JADX INFO: renamed from: aP */
    public boolean m3596aP() {
        return this.f4248L != null;
    }

    /* JADX INFO: renamed from: bd */
    public void m3597bd() {
        this.f4248L = null;
        this.f4249na = 0;
    }
}
