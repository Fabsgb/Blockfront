package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gm.class */
public class C0397gm<E extends LivingEntity> {

    /* JADX INFO: renamed from: aj */
    private static final double f2572aj = 1024.0d;

    /* JADX INFO: renamed from: kd */
    private static final int f2573kd = 4;

    /* JADX INFO: renamed from: cw */
    private static final boolean f2574cw = false;

    /* JADX INFO: renamed from: ag */
    @NotNull
    private static final String f2575ag = "in range";

    /* JADX INFO: renamed from: ah */
    @NotNull
    private static final String f2576ah = "line of sight";

    /* JADX INFO: renamed from: cx */
    private boolean f2577cx = true;

    /* JADX INFO: renamed from: ke */
    private int f2578ke = 0;

    /* JADX INFO: renamed from: cy */
    private volatile boolean f2579cy = false;

    /* JADX INFO: renamed from: kf */
    private int f2580kf = 0;

    /* JADX INFO: renamed from: kg */
    private int f2581kg = 0;

    /* JADX INFO: renamed from: a */
    public void m1887a(boolean z, @NotNull LocalPlayer localPlayer, @NotNull E e) {
        if (z || (e instanceof C0109bZ)) {
            this.f2577cx = true;
            return;
        }
        if (e.distanceToSqr(localPlayer) <= f2572aj) {
            m1890a(true, (LivingEntity) e, f2575ag);
            this.f2578ke = 0;
            return;
        }
        boolean z2 = this.f2579cy;
        this.f2579cy = false;
        if (z2) {
            int i = this.f2578ke;
            this.f2578ke = i - 1;
            if (i <= 0) {
                this.f2578ke = 4;
                m1890a(localPlayer.hasLineOfSight(e), e, f2576ah);
            }
        }
    }

    /* JADX INFO: renamed from: aO */
    public void m1888aO() {
        this.f2579cy = true;
    }

    /* JADX INFO: renamed from: Q */
    public boolean m1889Q() {
        return this.f2577cx;
    }

    /* JADX INFO: renamed from: a */
    private void m1890a(boolean z, @NotNull E e, @NotNull String str) {
        this.f2577cx = z;
    }

    /* JADX INFO: renamed from: a */
    private static double m1891a(@NotNull LivingEntity livingEntity) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return -1.0d;
        }
        return livingEntity.distanceToSqr(localPlayer);
    }

    /* JADX INFO: renamed from: b */
    private void m1892b(@NotNull E e) {
        int i = this.f2581kg;
        this.f2581kg = i - 1;
        if (i <= 0) {
            this.f2581kg = 100;
            if (this.f2580kf > 0) {
                C0530jM.log("GunCull: %s ran %d ray-casts in last 5s (visible=%b)", e.getName().getString(), Integer.valueOf(this.f2580kf), Boolean.valueOf(this.f2577cx));
            }
            this.f2580kf = 0;
        }
    }
}
