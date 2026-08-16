package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mZ.class */
public final class C0702mZ extends Goal {

    /* JADX INFO: renamed from: a */
    private final C0701mY f3873a;

    /* JADX INFO: renamed from: a */
    private final PathNavigation f3874a;

    /* JADX INFO: renamed from: eT */
    private boolean f3875eT = false;

    /* JADX INFO: renamed from: mN */
    private int f3876mN;

    public C0702mZ(@NotNull C0701mY c0701mY) {
        this.f3873a = c0701mY;
        this.f3874a = c0701mY.getNavigation();
    }

    public void start() {
        this.f3876mN = 0;
    }

    public boolean canUse() {
        return !this.f3873a.m3156v().isEmpty();
    }

    public void tick() {
        super.tick();
        List<C0836pA.a> listM3156v = this.f3873a.m3156v();
        int size = listM3156v.size();
        if (this.f3873a.f3871mM < 0) {
            this.f3875eT = false;
            this.f3873a.f3871mM = 0;
        }
        if (this.f3873a.f3871mM >= size) {
            this.f3875eT = true;
            this.f3873a.f3871mM = size - 1;
        }
        C0836pA.a aVar = listM3156v.get(this.f3873a.f3871mM);
        if (aVar != null) {
            if (this.f3873a.distanceToSqr(aVar.f4507o.x, aVar.f4507o.y, aVar.f4507o.z) <= 4.0d) {
                this.f3873a.f3871mM += this.f3875eT ? -1 : 1;
                return;
            }
            int i = this.f3876mN - 1;
            this.f3876mN = i;
            if (i <= 0) {
                this.f3876mN = 10;
                this.f3874a.moveTo(aVar.f4507o.x, aVar.f4507o.y, aVar.f4507o.z, 0.45d);
            }
        }
    }

    public boolean canContinueToUse() {
        return !this.f3874a.isDone();
    }

    public void stop() {
        super.stop();
        this.f3874a.stop();
    }
}
