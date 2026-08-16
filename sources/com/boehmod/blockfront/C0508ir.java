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

/* JADX INFO: renamed from: com.boehmod.blockfront.ir */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ir.class */
public class C0508ir {

    /* JADX INFO: renamed from: gO */
    public static final float f3127gO = 8.0f;

    /* JADX INFO: renamed from: kM */
    public static final int f3128kM = 32;

    /* JADX INFO: renamed from: cW */
    private boolean f3134cW;

    /* JADX INFO: renamed from: kN */
    private int f3129kN = 0;

    /* JADX INFO: renamed from: gP */
    private float f3130gP = 0.0f;

    /* JADX INFO: renamed from: gQ */
    private float f3131gQ = 0.0f;

    /* JADX INFO: renamed from: gR */
    private float f3132gR = 0.0f;

    /* JADX INFO: renamed from: gS */
    private float f3133gS = 0.0f;

    /* JADX INFO: renamed from: kO */
    private int f3135kO = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: kP */
    private int f3136kP = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: kQ */
    private int f3137kQ = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: kR */
    private int f3138kR = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: kS */
    private int f3139kS = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: kT */
    private int f3140kT = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: a */
    public boolean m2286a(@Nullable ClientLevel clientLevel, @Nullable LocalPlayer localPlayer) {
        if (clientLevel == null || localPlayer == null) {
            return false;
        }
        int blockX = localPlayer.getBlockX();
        int blockZ = localPlayer.getBlockZ();
        int iFloor = Mth.floor((float) localPlayer.getY());
        if (blockX != this.f3135kO || blockZ != this.f3136kP || iFloor != this.f3137kQ) {
            this.f3135kO = blockX;
            this.f3136kP = blockZ;
            this.f3137kQ = iFloor;
            this.f3134cW = C0875pn.m4352a((Level) clientLevel, blockX, blockZ, iFloor);
        }
        return this.f3134cW;
    }

    /* JADX INFO: renamed from: b */
    public void m2287b(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer) {
        this.f3132gR = this.f3131gQ;
        this.f3131gQ = Mth.lerp(0.1f, this.f3131gQ, this.f3130gP);
        int i = this.f3129kN;
        this.f3129kN = i - 1;
        if (i >= 0) {
            return;
        }
        this.f3129kN = 5;
        int blockX = localPlayer.getBlockX();
        int blockY = localPlayer.getBlockY();
        int blockZ = localPlayer.getBlockZ();
        if (blockX != this.f3138kR || blockY != this.f3139kS || blockZ != this.f3140kT) {
            this.f3138kR = blockX;
            this.f3139kS = blockY;
            this.f3140kT = blockZ;
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
                                        C0111bb.f718j.add(new C0057aa(center, location, 10, true, -16711936));
                                        C0111bb.f718j.add(new C0057aa(center, location2, 10, true, -16776961));
                                    }
                                }
                                i2++;
                            }
                        }
                    }
                }
                this.f3130gP = i2 > 0 ? i3 / i2 : 0.0f;
                this.f3133gS = i2 > 0 ? i4 / i2 : 0.0f;
            }
        }
    }

    /* JADX INFO: renamed from: n */
    public float m2288n(float f) {
        return C1270xJ.m7170f(this.f3131gQ, this.f3132gR, f);
    }

    /* JADX INFO: renamed from: O */
    public float m2289O() {
        return this.f3130gP;
    }

    /* JADX INFO: renamed from: P */
    public float m2290P() {
        return this.f3133gS;
    }
}
