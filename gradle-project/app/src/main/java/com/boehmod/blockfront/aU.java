package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aU.class */
public final class aU extends aO {
    private static final float bf = 45.0f;
    private static final double C = 0.800000011920929d;
    private static final float bg = 0.4f;
    public static final float bh = 0.15f;
    public static final float bi = 12.0f;
    public static final double D = 0.1d;
    public static final double E = 0.1d;

    /* JADX INFO: renamed from: bf, reason: collision with other field name */
    private static final int f43bf = 2;
    private static final float bj = 0.1f;

    /* JADX INFO: renamed from: bg, reason: collision with other field name */
    private static final int f44bg = 3;
    public static final float bk = 0.35f;
    public static float bl;
    public static float bm;
    public static float bn;
    public static float bp;
    public static float br;
    public static float bt;
    public static float bv;
    public static float bx;
    public static float bz;
    public static float bB;
    public static float bC;
    public static float bD;
    private float bH;

    @NotNull
    public static final List<AbstractC0075cs> k = new ObjectArrayList();
    public static final Vec3 g = new Vec3(0.5d, 0.0d, 0.0d);
    public static float bo = 0.0f;
    public static float bq = 0.0f;
    public static float bs = 0.0f;
    public static float bu = 0.0f;
    public static boolean af = false;
    public static float bw = 0.0f;
    public static float by = 0.0f;
    public static float bA = 0.0f;
    public static float bE = 0.0f;
    public static float bF = 0.0f;

    @Nullable
    public C0229im a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public C0223ig f45a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public C0558ur f46a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public C0224ih f47a = null;
    public float bG = 0.0f;
    private float bI = 0.0f;
    private float bJ = 0.0f;
    private boolean ag = false;

    /* JADX INFO: renamed from: bh, reason: collision with other field name */
    private int f48bh = 0;
    private float bK = 0.0f;

    private static void a(@NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull SoundManager soundManager, @NotNull Random random) {
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        bw = bv;
        if (!mainHandItem.isEmpty()) {
            Item item = mainHandItem.getItem();
            if ((item instanceof C0558ur) && ((C0558ur) item).cw()) {
                boolean z = false;
                boolean z2 = Mth.abs(localPlayer.getXRot()) > bf;
                if (localPlayer.isCrouching() && !z2) {
                    Vec3 vec3Add = localPlayer.getEyePosition().add(g.yRot((float) Math.toRadians((-localPlayer.getYHeadRot()) - 90.0f)));
                    z = clientLevel.clip(new ClipContext(vec3Add, vec3Add.add(0.0d, -0.800000011920929d, 0.0d), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, localPlayer)).getType() == HitResult.Type.BLOCK;
                }
                boolean z3 = z && ((double) bp) < 0.1d && ((double) bx) < 0.1d;
                a(z3, soundManager, random);
                bv = Mth.lerp(0.4f, bv, z3 ? 1.0f : 0.0f);
                return;
            }
        }
        bv = 0.0f;
        a(false, soundManager, random);
    }

    private static float e(float f) {
        if (!C0132ew.J()) {
            return C0634xm.d(f, 0.0f, 0.1f);
        }
        int iAa = C0132ew.aa();
        int iAb = C0132ew.ab();
        int i = iAb / 4;
        if (i > 0 && iAa > 0 && iAa < iAb && iAa % i == 0) {
            return 1.0f;
        }
        return C0634xm.d(f, 0.0f, 0.1f);
    }

    private static void a(boolean z, @NotNull SoundManager soundManager, @NotNull Random random) {
        if (z && !af) {
            af = true;
            hE.a(hH.u);
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.xI.get(), 1.0f, 0.9f + (0.1f * random.nextFloat())));
            return;
        }
        if (!z && af) {
            af = false;
            hE.a(hH.t);
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.xJ.get(), 1.0f, 0.9f + (0.1f * random.nextFloat())));
        }
    }

    @Override // com.boehmod.blockfront.aO
    public void a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull fT fTVar, @NotNull iS iSVar, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable oF<?, ?, ?> oFVar, boolean z, float f) {
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        Item item = mainHandItem.getItem();
        a(soundManager, mainHandItem);
        if (localPlayer.onGround()) {
            if (!this.ag) {
                this.ag = true;
                if (this.bJ >= 1.0f) {
                    soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.sw.get(), 0.9f + (0.2f * random.nextFloat()), 0.3f));
                    hE.a(hH.v);
                    BlockPos onPos = localPlayer.getOnPos();
                    SoundType soundType = clientLevel.getBlockState(onPos).getSoundType(clientLevel, onPos, (Entity) null);
                    soundManager.play(SimpleSoundInstance.forUI(soundType.getStepSound(), 1.0f, 0.3f));
                    soundManager.play(SimpleSoundInstance.forUI(soundType.getHitSound(), 1.0f, 0.3f));
                }
            }
        } else {
            this.ag = false;
        }
        this.bJ = localPlayer.fallDistance;
        boolean z2 = wM.c.isDown() && (item instanceof tO) && ((tO) item).ci() && !C0558ur.m1202f(mainHandItem) && !C0558ur.hR;
        by = bx;
        bx = Mth.lerp(0.15f, bx, z2 ? 1.0f : 0.0f);
        bo = bn;
        bq = bp;
        bs = br;
        bu = bt;
        bA = bz;
        bz = e(bz);
        C0027ay.aj = C0027ay.ai;
        C0027ay.al = C0027ay.ak;
        C0027ay.an = C0027ay.am;
        C0027ay.ai = Mth.lerp(0.15f, C0027ay.ai, Mth.clamp(C0027ay.af, -12.0f, 12.0f));
        C0027ay.ak = Mth.lerp(0.15f, C0027ay.ak, Mth.clamp(C0027ay.ag, -12.0f, 12.0f));
        C0027ay.am = Mth.lerp(0.15f, C0027ay.am, Mth.clamp(C0027ay.ah, -12.0f, 12.0f));
        int i = this.f48bh;
        this.f48bh = i - 1;
        if (i <= 0) {
            this.f48bh = 2;
            this.bK = 0.0f;
            if (!localPlayer.isCreative()) {
                BlockHitResult blockHitResult = minecraft.hitResult;
                if (blockHitResult instanceof BlockHitResult) {
                    BlockHitResult blockHitResult2 = blockHitResult;
                    double dDistanceTo = minecraft.hitResult.getLocation().distanceTo(localPlayer.getEyePosition());
                    boolean z3 = false;
                    BlockPos blockPos2 = blockHitResult2.getBlockPos();
                    BlockState blockState = clientLevel.getBlockState(blockPos2);
                    Block block = blockState.getBlock();
                    boolean zIsSolid = blockState.isSolid();
                    if ((block instanceof InterfaceC0320lw) || !zIsSolid) {
                        z3 = true;
                    }
                    if (!zIsSolid || !blockState.canOcclude()) {
                        z3 = true;
                    }
                    if (!z3 && wI.a(clientLevel, blockState, blockPos2).cE()) {
                        z3 = true;
                    }
                    if (!z3 && dDistanceTo <= 1.0d) {
                        this.bK = (float) (1.0d - dDistanceTo);
                    }
                }
            }
        }
        C0198hh.P.removeIf((v0) -> {
            return v0.l();
        });
        a(localPlayer, clientLevel, soundManager, random);
        bF = Mth.lerp(0.1f, bF, 1.0f);
        float fBt = 0.35f;
        if (item instanceof C0558ur) {
            fBt = ((C0558ur) item).bt();
        }
        bp = Mth.lerp(fBt, bp, this.bK);
        if (hN.m.T()) {
            C0038bi.a(minecraft, localPlayer, clientLevel);
        }
        Entity vehicle = localPlayer.getVehicle();
        if (vehicle instanceof AbstractC0376ny) {
            AbstractC0376ny abstractC0376ny = (AbstractC0376ny) vehicle;
            nD nDVarA = abstractC0376ny.a((Entity) localPlayer);
            if (nDVarA != null) {
                bn = Mth.lerp(0.1f, bn, abstractC0376ny.ax());
                nA.fk = minecraft.mouseHandler.isRightPressed() && nDVarA.jA > 0.0f;
            }
        } else {
            nA.fk = false;
            bn = Mth.lerp(0.1f, bn, 0.0f);
        }
        br = Mth.lerp(0.2f, br, (item instanceof C0558ur) && C0558ur.m1202f(mainHandItem) ? 1.0f : 0.0f);
        bt = Mth.lerp(0.2f, bt, localPlayer.isSprinting() ? 1.0f : 0.0f);
        bm = bl;
        bl = Mth.lerp(0.02f, bl, 0.0f);
        if (this.bG > localPlayer.moveDist + 2.0f) {
            this.bG = localPlayer.moveDist + 1.0f;
        }
        bD = bB;
        bE = bC;
        bB += (this.bH - localPlayer.getXRot()) * 3.0f;
        bC += (this.bI - localPlayer.yHeadRot) * 3.0f;
        this.bH = localPlayer.getXRot();
        this.bI = localPlayer.getYRot();
        bB *= 0.5f;
        bC *= 0.5f;
        boolean z4 = !mainHandItem.isEmpty() && (item instanceof C0543uc);
        C0543uc.mM = C0543uc.mL;
        C0543uc.mL = Mth.lerp(0.5f, C0543uc.mL, z4 ? 1.0f : 0.0f);
        if (localPlayer.moveDist > this.bG) {
            this.bG = localPlayer.moveDist + 1.0f;
            SoundEvent soundEventC = null;
            BlockPos onPos2 = localPlayer.getOnPos();
            BlockState blockState2 = clientLevel.getBlockState(onPos2);
            BlockState blockState3 = clientLevel.getBlockState(onPos2.above());
            kF block2 = blockState2.getBlock();
            if (block2 instanceof kF) {
                soundEventC = block2.c();
            }
            kF block3 = blockState3.getBlock();
            if (block3 instanceof kF) {
                soundEventC = block3.c();
            }
            if (soundEventC != null) {
                localPlayer.playSound(soundEventC, localPlayer.isSprinting() ? 1.0f : 0.35f, 1.0f);
            }
        }
        if (oFVar != null) {
            k.removeIf((v0) -> {
                return v0.k();
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(@org.jetbrains.annotations.NotNull net.minecraft.client.sounds.SoundManager r7, @org.jetbrains.annotations.NotNull net.minecraft.world.item.ItemStack r8) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.boehmod.blockfront.aU.a(net.minecraft.client.sounds.SoundManager, net.minecraft.world.item.ItemStack):void");
    }
}
