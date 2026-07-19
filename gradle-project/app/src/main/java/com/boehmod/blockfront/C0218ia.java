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

/* JADX INFO: renamed from: com.boehmod.blockfront.ia, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ia.class */
public class C0218ia {
    public static final float gt = 8.0f;
    public static final int jr = 32;
    private boolean cN;
    private int js = 0;
    private float gu = 0.0f;
    private float gv = 0.0f;
    private float gw = 0.0f;
    private float gx = 0.0f;
    private int jt = Integer.MIN_VALUE;
    private int ju = Integer.MIN_VALUE;
    private int jv = Integer.MIN_VALUE;
    private int jw = Integer.MIN_VALUE;
    private int jx = Integer.MIN_VALUE;
    private int jy = Integer.MIN_VALUE;

    public boolean a(@Nullable ClientLevel clientLevel, @Nullable LocalPlayer localPlayer) {
        if (clientLevel == null || localPlayer == null) {
            return false;
        }
        int blockX = localPlayer.getBlockX();
        int blockZ = localPlayer.getBlockZ();
        int iFloor = Mth.floor((float) localPlayer.getY());
        if (blockX != this.jt || blockZ != this.ju || iFloor != this.jv) {
            this.jt = blockX;
            this.ju = blockZ;
            this.jv = iFloor;
            this.cN = oR.a((Level) clientLevel, blockX, blockZ, iFloor);
        }
        return this.cN;
    }

    public void b(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer) {
        this.gw = this.gv;
        this.gv = Mth.lerp(0.1f, this.gv, this.gu);
        int i = this.js;
        this.js = i - 1;
        if (i >= 0) {
            return;
        }
        this.js = 5;
        int blockX = localPlayer.getBlockX();
        int blockY = localPlayer.getBlockY();
        int blockZ = localPlayer.getBlockZ();
        if (blockX != this.jw || blockY != this.jx || blockZ != this.jy) {
            this.jw = blockX;
            this.jx = blockY;
            this.jy = blockZ;
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
                                        aT.i.add(new U(center, location, 10, true, -16711936));
                                        aT.i.add(new U(center, location2, 10, true, -16776961));
                                    }
                                }
                                i2++;
                            }
                        }
                    }
                }
                this.gu = i2 > 0 ? i3 / i2 : 0.0f;
                this.gx = i2 > 0 ? i4 / i2 : 0.0f;
            }
        }
    }

    public float n(float f) {
        return C0634xm.e(this.gv, this.gw, f);
    }

    public float O() {
        return this.gu;
    }

    public float P() {
        return this.gx;
    }
}
