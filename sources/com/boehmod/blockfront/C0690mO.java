package com.boehmod.blockfront;

import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mO.class */
public class C0690mO extends C0686mK {

    /* JADX INFO: renamed from: ln */
    private static final int f3720ln = 100;

    /* JADX INFO: renamed from: lo */
    private static final int f3721lo = 5;

    /* JADX INFO: renamed from: lp */
    private static final int f3722lp = 3;

    /* JADX INFO: renamed from: lq */
    private static final int f3723lq = 7;

    /* JADX INFO: renamed from: iN */
    private static final float f3724iN = 2.0f;

    /* JADX INFO: renamed from: iO */
    private static final float f3725iO = 3.0f;

    /* JADX INFO: renamed from: iP */
    private static final float f3726iP = 0.2f;

    /* JADX INFO: renamed from: aq */
    private static final double f3727aq = 0.15d;

    /* JADX INFO: renamed from: c */
    @NotNull
    protected final PathNavigation f3728c;

    /* JADX INFO: renamed from: ar */
    private final double f3729ar;

    /* JADX INFO: renamed from: a */
    private BlockPos f3730a;

    /* JADX INFO: renamed from: lr */
    private int f3731lr;

    /* JADX INFO: renamed from: L */
    private Vec3 f3732L;

    /* JADX INFO: renamed from: eJ */
    private boolean f3733eJ;

    public C0690mO(@NotNull C0680mE c0680mE, double d) {
        super(c0680mE);
        this.f3731lr = 0;
        this.f3733eJ = true;
        this.f3729ar = d;
        setFlags(EnumSet.of(Goal.Flag.MOVE));
        this.f3728c = c0680mE.getNavigation();
    }

    @Override // com.boehmod.blockfront.C0686mK
    public boolean canUse() {
        int i = this.f3731lr - 1;
        this.f3731lr = i;
        if (i > 0 || this.f3696b.getTarget() != null) {
            return false;
        }
        AttributeSupplier.Builder builderA = this.f3696b.m3008a();
        if (builderA instanceof InterfaceC0899qL) {
            this.f3730a = ((InterfaceC0899qL) builderA).mo4661a(this.f3696b);
            if (this.f3730a == null) {
                return false;
            }
            Vec3 vec3AtBottomCenterOf = Vec3.atBottomCenterOf(this.f3730a);
            double dSqrt = Math.sqrt(this.f3696b.distanceToSqr(vec3AtBottomCenterOf));
            this.f3731lr = Math.max(5, (int) (100.0d * Math.min(1.0d, dSqrt / 100.0d)));
            if (dSqrt <= 2.0d + (Math.random() * 1.0d)) {
                return false;
            }
            this.f3732L = LandRandomPos.getPosTowards(this.f3696b, (int) dSqrt, (int) Math.max(3.0d, Math.min(7.0d, dSqrt / 4.0d)), vec3AtBottomCenterOf);
            return this.f3732L != null && this.f3733eJ;
        }
        return false;
    }

    public boolean canContinueToUse() {
        if (this.f3696b.m3068aI() || this.f3696b.getTarget() != null) {
            this.f3728c.stop();
            this.f3733eJ = true;
            return false;
        }
        if (this.f3696b.m3008a() == null || this.f3696b.m3008a().m3587a() != EnumC0795oN.POST_GAME) {
            return !this.f3728c.isDone();
        }
        this.f3733eJ = true;
        return false;
    }

    public void stop() {
        super.stop();
        this.f3730a = null;
        this.f3732L = null;
        this.f3733eJ = true;
    }

    public void start() {
        super.start();
        if (this.f3696b.getTarget() != null || this.f3730a == null || this.f3732L == null || !this.f3733eJ) {
            return;
        }
        this.f3728c.moveTo(this.f3732L.x, this.f3732L.y, this.f3732L.z, this.f3729ar * (0.85d + (Math.random() * f3727aq * 2.0d)));
        this.f3696b.m3075b(this.f3730a);
        this.f3733eJ = false;
        if (Math.random() < 0.20000000298023224d) {
            this.f3696b.m3077c().ifPresent(c1014sU -> {
                this.f3696b.m3029a(c1014sU.m5503d());
            });
        }
    }
}
