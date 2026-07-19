package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mF.class */
public class mF {

    @NotNull
    private final mE a;

    @Nullable
    private Vec3 K = null;
    private int lc = 0;
    private double am = 0.0d;

    public mF(@NotNull mE mEVar) {
        this.a = mEVar;
    }

    public void a(@NotNull RandomSource randomSource) {
        Entity target = this.a.getTarget();
        if (target != null && (this.a.getSensing().hasLineOfSight(target) || this.a.hasLineOfSight(target))) {
            this.am = target.getEyeY();
            this.K = target.position();
            this.lc = -1;
            return;
        }
        if (this.lc == -1) {
            this.lc = randomSource.nextInt(7) * 20;
        }
        int i = this.lc;
        this.lc = i - 1;
        if (i == 0) {
            this.K = null;
        }
    }

    @Nullable
    public Vec3 k() {
        return this.K;
    }

    public double o() {
        return this.am;
    }

    public boolean aE() {
        return this.K != null;
    }

    public void bf() {
        this.K = null;
        this.lc = 0;
    }
}
