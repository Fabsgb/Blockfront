package com.boehmod.blockfront;

import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mO.class */
public class mO extends mK {
    private static final int ln = 100;
    private static final int lo = 5;
    private static final int lp = 3;
    private static final int lq = 7;
    private static final float iN = 2.0f;
    private static final float iO = 3.0f;
    private static final float iP = 0.2f;
    private static final double aq = 0.15d;

    @NotNull
    protected final PathNavigation c;
    private final double ar;
    private BlockPos a;
    private int lr;
    private Vec3 L;
    private boolean eJ;

    public mO(@NotNull mE mEVar, double d) {
        super(mEVar);
        this.lr = 0;
        this.eJ = true;
        this.ar = d;
        setFlags(EnumSet.of(Goal.Flag.MOVE));
        this.c = mEVar.getNavigation();
    }

    @Override // com.boehmod.blockfront.mK
    public boolean canUse() {
        int i = this.lr - 1;
        this.lr = i;
        if (i > 0 || this.b.getTarget() != null) {
            return false;
        }
        AttributeSupplier.Builder builderA = this.b.a();
        if (builderA instanceof qL) {
            this.a = ((qL) builderA).mo920a(this.b);
            if (this.a == null) {
                return false;
            }
            Vec3 vec3AtBottomCenterOf = Vec3.atBottomCenterOf(this.a);
            double dSqrt = Math.sqrt(this.b.distanceToSqr(vec3AtBottomCenterOf));
            this.lr = Math.max(5, (int) (100.0d * Math.min(1.0d, dSqrt / 100.0d)));
            if (dSqrt <= 2.0d + (Math.random() * 1.0d)) {
                return false;
            }
            this.L = LandRandomPos.getPosTowards(this.b, (int) dSqrt, (int) Math.max(3.0d, Math.min(7.0d, dSqrt / 4.0d)), vec3AtBottomCenterOf);
            return this.L != null && this.eJ;
        }
        return false;
    }

    public boolean canContinueToUse() {
        if (this.b.aI() || this.b.getTarget() != null) {
            this.c.stop();
            this.eJ = true;
            return false;
        }
        if (this.b.a() == null || this.b.a().m750a() != oN.POST_GAME) {
            return !this.c.isDone();
        }
        this.eJ = true;
        return false;
    }

    public void stop() {
        super.stop();
        this.a = null;
        this.L = null;
        this.eJ = true;
    }

    public void start() {
        super.start();
        if (this.b.getTarget() != null || this.a == null || this.L == null || !this.eJ) {
            return;
        }
        this.c.moveTo(this.L.x, this.L.y, this.L.z, this.ar * (0.85d + (Math.random() * aq * 2.0d)));
        this.b.b(this.a);
        this.eJ = false;
        if (Math.random() < 0.20000000298023224d) {
            this.b.c().ifPresent(sUVar -> {
                this.b.a(sUVar.d());
            });
        }
    }
}
