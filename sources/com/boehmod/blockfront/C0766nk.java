package com.boehmod.blockfront;

import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nk.class */
public class C0766nk extends C0762ng {

    /* JADX INFO: renamed from: nl */
    private static final int f4283nl = 100;

    /* JADX INFO: renamed from: nm */
    private static final int f4284nm = 5;

    /* JADX INFO: renamed from: nn */
    private static final int f4285nn = 3;

    /* JADX INFO: renamed from: no */
    private static final int f4286no = 7;

    /* JADX INFO: renamed from: jG */
    private static final float f4287jG = 2.0f;

    /* JADX INFO: renamed from: jH */
    private static final float f4288jH = 3.0f;

    /* JADX INFO: renamed from: jI */
    private static final float f4289jI = 0.2f;

    /* JADX INFO: renamed from: aD */
    private static final double f4290aD = 0.15d;

    /* JADX INFO: renamed from: c */
    @NotNull
    protected final PathNavigation f4291c;

    /* JADX INFO: renamed from: aE */
    private final double f4292aE;

    /* JADX INFO: renamed from: a */
    private BlockPos f4293a;

    /* JADX INFO: renamed from: np */
    private int f4294np;

    /* JADX INFO: renamed from: M */
    private Vec3 f4295M;

    /* JADX INFO: renamed from: fd */
    private boolean f4296fd;

    public C0766nk(@NotNull C0756na c0756na, double d) {
        super(c0756na);
        this.f4294np = 0;
        this.f4296fd = true;
        this.f4292aE = d;
        setFlags(EnumSet.of(Goal.Flag.MOVE));
        this.f4291c = c0756na.getNavigation();
    }

    @Override // com.boehmod.blockfront.C0762ng
    public boolean canUse() {
        int i = this.f4294np - 1;
        this.f4294np = i;
        if (i > 0 || this.f4259b.getTarget() != null) {
            return false;
        }
        AttributeSupplier.Builder builderA = this.f4259b.m3516a();
        if (builderA instanceof InterfaceC0976ri) {
            this.f4293a = ((InterfaceC0976ri) builderA).mo5337a(this.f4259b);
            if (this.f4293a == null) {
                return false;
            }
            Vec3 vec3AtBottomCenterOf = Vec3.atBottomCenterOf(this.f4293a);
            double dSqrt = Math.sqrt(this.f4259b.distanceToSqr(vec3AtBottomCenterOf));
            this.f4294np = Math.max(5, (int) (100.0d * Math.min(1.0d, dSqrt / 100.0d)));
            if (dSqrt <= 2.0d + (Math.random() * 1.0d)) {
                return false;
            }
            this.f4295M = LandRandomPos.getPosTowards(this.f4259b, (int) dSqrt, (int) Math.max(3.0d, Math.min(7.0d, dSqrt / 4.0d)), vec3AtBottomCenterOf);
            return this.f4295M != null && this.f4296fd;
        }
        return false;
    }

    public boolean canContinueToUse() {
        if (this.f4259b.m3575aS() || this.f4259b.getTarget() != null) {
            this.f4291c.stop();
            this.f4296fd = true;
            return false;
        }
        if (this.f4259b.m3516a() == null || this.f4259b.m3516a().m4023a() != EnumC0871pj.POST_GAME) {
            return !this.f4291c.isDone();
        }
        this.f4296fd = true;
        return false;
    }

    public void stop() {
        super.stop();
        this.f4293a = null;
        this.f4295M = null;
        this.f4296fd = true;
    }

    public void start() {
        super.start();
        if (this.f4259b.getTarget() != null || this.f4293a == null || this.f4295M == null || !this.f4296fd) {
            return;
        }
        this.f4291c.moveTo(this.f4295M.x, this.f4295M.y, this.f4295M.z, this.f4292aE * (0.85d + (Math.random() * f4290aD * 2.0d)));
        this.f4259b.m3582b(this.f4293a);
        this.f4296fd = false;
        if (Math.random() < 0.20000000298023224d) {
            this.f4259b.m3584c().ifPresent(c1092tr -> {
                this.f4259b.m3537a(c1092tr.m5991d());
            });
        }
    }
}
