package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fW.class */
public class C0327fW<E extends LivingEntity> {

    /* JADX INFO: renamed from: ac */
    private static final double f2377ac = 1024.0d;

    /* JADX INFO: renamed from: iI */
    private static final int f2378iI = 4;

    /* JADX INFO: renamed from: cn */
    private static final boolean f2379cn = false;

    /* JADX INFO: renamed from: Z */
    @NotNull
    private static final String f2380Z = "in range";

    /* JADX INFO: renamed from: aa */
    @NotNull
    private static final String f2381aa = "line of sight";

    /* JADX INFO: renamed from: co */
    private boolean f2382co = true;

    /* JADX INFO: renamed from: iJ */
    private int f2383iJ = 0;

    /* JADX INFO: renamed from: cp */
    private volatile boolean f2384cp = false;

    /* JADX INFO: renamed from: iK */
    private int f2385iK = 0;

    /* JADX INFO: renamed from: iL */
    private int f2386iL = 0;

    /* JADX INFO: renamed from: a */
    public void m1677a(boolean z, @NotNull LocalPlayer localPlayer, @NotNull E e) {
        if (z || (e instanceof C0099bQ)) {
            this.f2382co = true;
            return;
        }
        if (e.distanceToSqr(localPlayer) <= f2377ac) {
            m1680a(true, (LivingEntity) e, f2380Z);
            this.f2383iJ = 0;
            return;
        }
        boolean z2 = this.f2384cp;
        this.f2384cp = false;
        if (z2) {
            int i = this.f2383iJ;
            this.f2383iJ = i - 1;
            if (i <= 0) {
                this.f2383iJ = 4;
                m1680a(localPlayer.hasLineOfSight(e), e, f2381aa);
            }
        }
    }

    /* JADX INFO: renamed from: aI */
    public void m1678aI() {
        this.f2384cp = true;
    }

    /* JADX INFO: renamed from: O */
    public boolean m1679O() {
        return this.f2382co;
    }

    /* JADX INFO: renamed from: a */
    private void m1680a(boolean z, @NotNull E e, @NotNull String str) {
        this.f2382co = z;
    }

    /* JADX INFO: renamed from: a */
    private static double m1681a(@NotNull LivingEntity livingEntity) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return -1.0d;
        }
        return livingEntity.distanceToSqr(localPlayer);
    }

    /* JADX INFO: renamed from: b */
    private void m1682b(@NotNull E e) {
        int i = this.f2386iL;
        this.f2386iL = i - 1;
        if (i <= 0) {
            this.f2386iL = 100;
            if (this.f2385iK > 0) {
                C0562jt.log("GunCull: %s ran %d ray-casts in last 5s (visible=%b)", e.getName().getString(), Integer.valueOf(this.f2385iK), Boolean.valueOf(this.f2382co));
            }
            this.f2385iK = 0;
        }
    }
}
