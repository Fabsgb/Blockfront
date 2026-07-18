package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ia */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ia.class */
public class C0490ia {

    /* JADX INFO: renamed from: gt */
    public static final float f2970gt = 8.0f;

    /* JADX INFO: renamed from: jr */
    public static final int f2971jr = 32;

    /* JADX INFO: renamed from: cN */
    private boolean f2977cN;

    /* JADX INFO: renamed from: js */
    private int f2972js = 0;

    /* JADX INFO: renamed from: gu */
    private float f2973gu = 0.0f;

    /* JADX INFO: renamed from: gv */
    private float f2974gv = 0.0f;

    /* JADX INFO: renamed from: gw */
    private float f2975gw = 0.0f;

    /* JADX INFO: renamed from: gx */
    private float f2976gx = 0.0f;

    /* JADX INFO: renamed from: jt */
    private int f2978jt = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: ju */
    private int f2979ju = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: jv */
    private int f2980jv = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: jw */
    private int f2981jw = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: jx */
    private int f2982jx = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: jy */
    private int f2983jy = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: a */
    public boolean m2231a(@Nullable ClientLevel clientLevel, @Nullable LocalPlayer localPlayer) {
        if (clientLevel == null || localPlayer == null) {
            return false;
        }
        int blockX = localPlayer.getBlockX();
        int blockZ = localPlayer.getBlockZ();
        int iFloor = Mth.floor((float) localPlayer.getY());
        if (blockX != this.f2978jt || blockZ != this.f2979ju || iFloor != this.f2980jv) {
            this.f2978jt = blockX;
            this.f2979ju = blockZ;
            this.f2980jv = iFloor;
            this.f2977cN = C0799oR.m3916a((Level) clientLevel, blockX, blockZ, iFloor);
        }
        return this.f2977cN;
    }

    /* JADX INFO: renamed from: b */
    public void m2232b(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer) {
        this.f2975gw = this.f2974gv;
        this.f2974gv = Mth.lerp(0.1f, this.f2974gv, this.f2973gu);
        int i = this.f2972js;
        this.f2972js = i - 1;
        if (i >= 0) {
            return;
        }
        this.f2972js = 5;
        int blockX = localPlayer.getBlockX();
        int blockY = localPlayer.getBlockY();
        int blockZ = localPlayer.getBlockZ();
        if (blockX != this.f2981jw || blockY != this.f2982jx || blockZ != this.f2983jy) {
            this.f2981jw = blockX;
            this.f2982jx = blockY;
            this.f2983jy = blockZ;
            Entity cameraEntity = minecraft.getCameraEntity();
            if (cameraEntity == null) {
                return;
            }
            BlockPos onPos = cameraEntity.getOnPos();
            if (!localPlayer.isEyeInFluidType((FluidType) NeoForgeMod.WATER_TYPE.value())) {
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = -4; i5 < 4; i5++) {
                    for (int i6 = -4; i6 < 4; i6++) {
                        if (((i5 + i6) & 1) == 0) {
                            BlockPos blockPosOffset = onPos.offset(i5, 2, i6);
                            Vec3 center = blockPosOffset.getCenter();
                            if (clientLevel.getBlockState(blockPosOffset).isAir()) {
                                if (clientLevel.canSeeSky(blockPosOffset)) {
                                    i3++;
                                } else {
                                    Vec3 location = clientLevel.clip(new ClipContext(center, center.add(0.0d, 32.0d, 0.0d), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, localPlayer)).getLocation();
                                    float fDistanceTo = (float) location.distanceTo(center);
                                    Vec3 location2 = clientLevel.clip(new ClipContext(center, center.add(0.0d, -32.0d, 0.0d), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, localPlayer)).getLocation();
                                    if (fDistanceTo + ((float) location2.distanceTo(center)) >= 8.0f) {
                                        i4++;
                                    }
                                    if (minecraft.getDebugOverlay().showDebugScreen()) {
                                        C0049aT.f304i.add(new C0023U(center, location, 10, true, -16711936));
                                        C0049aT.f304i.add(new C0023U(center, location2, 10, true, -16776961));
                                    }
                                }
                                i2++;
                            }
                        }
                    }
                }
                this.f2973gu = i2 > 0 ? i3 / i2 : 0.0f;
                this.f2976gx = i2 > 0 ? i4 / i2 : 0.0f;
            }
        }
    }

    /* JADX INFO: renamed from: n */
    public float m2233n(float f) {
        return C1290xm.m7843e(this.f2974gv, this.f2975gw, f);
    }

    /* JADX INFO: renamed from: O */
    public float m2234O() {
        return this.f2973gu;
    }

    /* JADX INFO: renamed from: P */
    public float m2235P() {
        return this.f2976gx;
    }
}
