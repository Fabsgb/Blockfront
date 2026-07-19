package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fW.class */
public class fW<E extends LivingEntity> {
    private static final double ac = 1024.0d;
    private static final int iI = 4;
    private static final boolean cn = false;

    @NotNull
    private static final String Z = "in range";

    @NotNull
    private static final String aa = "line of sight";
    private boolean co = true;
    private int iJ = 0;
    private volatile boolean cp = false;
    private int iK = 0;
    private int iL = 0;

    public void a(boolean z, @NotNull LocalPlayer localPlayer, @NotNull E e) {
        if (z || (e instanceof bQ)) {
            this.co = true;
            return;
        }
        if (e.distanceToSqr(localPlayer) <= ac) {
            a(true, (LivingEntity) e, Z);
            this.iJ = 0;
            return;
        }
        boolean z2 = this.cp;
        this.cp = false;
        if (z2) {
            int i = this.iJ;
            this.iJ = i - 1;
            if (i <= 0) {
                this.iJ = 4;
                a(localPlayer.hasLineOfSight(e), e, aa);
            }
        }
    }

    public void aI() {
        this.cp = true;
    }

    public boolean O() {
        return this.co;
    }

    private void a(boolean z, @NotNull E e, @NotNull String str) {
        this.co = z;
    }

    private static double a(@NotNull LivingEntity livingEntity) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return -1.0d;
        }
        return livingEntity.distanceToSqr(localPlayer);
    }

    private void b(@NotNull E e) {
        int i = this.iL;
        this.iL = i - 1;
        if (i <= 0) {
            this.iL = 100;
            if (this.iK > 0) {
                C0263jt.log("GunCull: %s ran %d ray-casts in last 5s (visible=%b)", e.getName().getString(), Integer.valueOf(this.iK), Boolean.valueOf(this.co));
            }
            this.iK = 0;
        }
    }
}
