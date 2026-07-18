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

/* JADX INFO: renamed from: com.boehmod.blockfront.aU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aU.class */
public final class C0050aU extends AbstractC0044aO {

    /* JADX INFO: renamed from: bf */
    private static final float f307bf = 45.0f;

    /* JADX INFO: renamed from: C */
    private static final double f308C = 0.800000011920929d;

    /* JADX INFO: renamed from: bg */
    private static final float f309bg = 0.4f;

    /* JADX INFO: renamed from: bh */
    public static final float f310bh = 0.15f;

    /* JADX INFO: renamed from: bi */
    public static final float f311bi = 12.0f;

    /* JADX INFO: renamed from: D */
    public static final double f313D = 0.1d;

    /* JADX INFO: renamed from: E */
    public static final double f314E = 0.1d;

    /* JADX INFO: renamed from: bf */
    private static final int f315bf = 2;

    /* JADX INFO: renamed from: bj */
    private static final float f316bj = 0.1f;

    /* JADX INFO: renamed from: bg */
    private static final int f317bg = 3;

    /* JADX INFO: renamed from: bk */
    public static final float f318bk = 0.35f;

    /* JADX INFO: renamed from: bl */
    public static float f319bl;

    /* JADX INFO: renamed from: bm */
    public static float f320bm;

    /* JADX INFO: renamed from: bn */
    public static float f321bn;

    /* JADX INFO: renamed from: bp */
    public static float f323bp;

    /* JADX INFO: renamed from: br */
    public static float f325br;

    /* JADX INFO: renamed from: bt */
    public static float f327bt;

    /* JADX INFO: renamed from: bv */
    public static float f330bv;

    /* JADX INFO: renamed from: bx */
    public static float f332bx;

    /* JADX INFO: renamed from: bz */
    public static float f334bz;

    /* JADX INFO: renamed from: bB */
    public static float f336bB;

    /* JADX INFO: renamed from: bC */
    public static float f337bC;

    /* JADX INFO: renamed from: bD */
    public static float f338bD;

    /* JADX INFO: renamed from: bH */
    private float f346bH;

    /* JADX INFO: renamed from: k */
    @NotNull
    public static final List<AbstractC0190cs> f306k = new ObjectArrayList();

    /* JADX INFO: renamed from: g */
    public static final Vec3 f312g = new Vec3(0.5d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: bo */
    public static float f322bo = 0.0f;

    /* JADX INFO: renamed from: bq */
    public static float f324bq = 0.0f;

    /* JADX INFO: renamed from: bs */
    public static float f326bs = 0.0f;

    /* JADX INFO: renamed from: bu */
    public static float f328bu = 0.0f;

    /* JADX INFO: renamed from: af */
    public static boolean f329af = false;

    /* JADX INFO: renamed from: bw */
    public static float f331bw = 0.0f;

    /* JADX INFO: renamed from: by */
    public static float f333by = 0.0f;

    /* JADX INFO: renamed from: bA */
    public static float f335bA = 0.0f;

    /* JADX INFO: renamed from: bE */
    public static float f339bE = 0.0f;

    /* JADX INFO: renamed from: bF */
    public static float f340bF = 0.0f;

    /* JADX INFO: renamed from: a */
    @Nullable
    public C0502im f341a = null;

    /* JADX INFO: renamed from: a */
    @Nullable
    public C0496ig f342a = null;

    /* JADX INFO: renamed from: a */
    @Nullable
    public C1144ur f343a = null;

    /* JADX INFO: renamed from: a */
    @Nullable
    public C0497ih f344a = null;

    /* JADX INFO: renamed from: bG */
    public float f345bG = 0.0f;

    /* JADX INFO: renamed from: bI */
    private float f347bI = 0.0f;

    /* JADX INFO: renamed from: bJ */
    private float f348bJ = 0.0f;

    /* JADX INFO: renamed from: ag */
    private boolean f349ag = false;

    /* JADX INFO: renamed from: bh */
    private int f350bh = 0;

    /* JADX INFO: renamed from: bK */
    private float f351bK = 0.0f;

    /* JADX INFO: renamed from: a */
    private static void m214a(@NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull SoundManager soundManager, @NotNull Random random) {
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        f331bw = f330bv;
        if (!mainHandItem.isEmpty()) {
            Item item = mainHandItem.getItem();
            if ((item instanceof C1144ur) && ((C1144ur) item).m6391cw()) {
                boolean z = false;
                boolean z2 = Mth.abs(localPlayer.getXRot()) > f307bf;
                if (localPlayer.isCrouching() && !z2) {
                    Vec3 vec3Add = localPlayer.getEyePosition().add(f312g.yRot((float) Math.toRadians((-localPlayer.getYHeadRot()) - 90.0f)));
                    z = clientLevel.clip(new ClipContext(vec3Add, vec3Add.add(0.0d, -0.800000011920929d, 0.0d), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, localPlayer)).getType() == HitResult.Type.BLOCK;
                }
                boolean z3 = z && ((double) f323bp) < 0.1d && ((double) f332bx) < 0.1d;
                m216a(z3, soundManager, random);
                f330bv = Mth.lerp(0.4f, f330bv, z3 ? 1.0f : 0.0f);
                return;
            }
        }
        f330bv = 0.0f;
        m216a(false, soundManager, random);
    }

    /* JADX INFO: renamed from: e */
    private static float m215e(float f) {
        if (!C0300ew.m1583J()) {
            return C1290xm.m7835d(f, 0.0f, 0.1f);
        }
        int iM1585aa = C0300ew.m1585aa();
        int iM1586ab = C0300ew.m1586ab();
        int i = iM1586ab / 4;
        if (i > 0 && iM1585aa > 0 && iM1585aa < iM1586ab && iM1585aa % i == 0) {
            return 1.0f;
        }
        return C1290xm.m7835d(f, 0.0f, 0.1f);
    }

    /* JADX INFO: renamed from: a */
    private static void m216a(boolean z, @NotNull SoundManager soundManager, @NotNull Random random) {
        if (z && !f329af) {
            f329af = true;
            C0415hE.m1960a(C0418hH.f2678u);
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7993xI.get(), 1.0f, 0.9f + (0.1f * random.nextFloat())));
            return;
        }
        if (!z && f329af) {
            f329af = false;
            C0415hE.m1960a(C0418hH.f2677t);
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7994xJ.get(), 1.0f, 0.9f + (0.1f * random.nextFloat())));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0044aO
    /* JADX INFO: renamed from: a */
    public void mo204a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull C0482iS c0482iS, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, boolean z, float f) {
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        Item item = mainHandItem.getItem();
        m217a(soundManager, mainHandItem);
        if (localPlayer.onGround()) {
            if (!this.f349ag) {
                this.f349ag = true;
                if (this.f348bJ >= 1.0f) {
                    soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7721sw.get(), 0.9f + (0.2f * random.nextFloat()), 0.3f));
                    C0415hE.m1960a(C0418hH.f2679v);
                    BlockPos onPos = localPlayer.getOnPos();
                    SoundType soundType = clientLevel.getBlockState(onPos).getSoundType(clientLevel, onPos, (Entity) null);
                    soundManager.play(SimpleSoundInstance.forUI(soundType.getStepSound(), 1.0f, 0.3f));
                    soundManager.play(SimpleSoundInstance.forUI(soundType.getHitSound(), 1.0f, 0.3f));
                }
            }
        } else {
            this.f349ag = false;
        }
        this.f348bJ = localPlayer.fallDistance;
        boolean z2 = C1219wM.f6918c.isDown() && (item instanceof AbstractC1062tO) && ((AbstractC1062tO) item).mo5927ci() && !C1144ur.m6311f(mainHandItem) && !C1144ur.f5994hR;
        f333by = f332bx;
        f332bx = Mth.lerp(0.15f, f332bx, z2 ? 1.0f : 0.0f);
        f322bo = f321bn;
        f324bq = f323bp;
        f326bs = f325br;
        f328bu = f327bt;
        f335bA = f334bz;
        f334bz = m215e(f334bz);
        C0080ay.f499aj = C0080ay.f498ai;
        C0080ay.f501al = C0080ay.f500ak;
        C0080ay.f503an = C0080ay.f502am;
        C0080ay.f498ai = Mth.lerp(0.15f, C0080ay.f498ai, Mth.clamp(C0080ay.f495af, -12.0f, 12.0f));
        C0080ay.f500ak = Mth.lerp(0.15f, C0080ay.f500ak, Mth.clamp(C0080ay.f496ag, -12.0f, 12.0f));
        C0080ay.f502am = Mth.lerp(0.15f, C0080ay.f502am, Mth.clamp(C0080ay.f497ah, -12.0f, 12.0f));
        int i = this.f350bh;
        this.f350bh = i - 1;
        if (i <= 0) {
            this.f350bh = 2;
            this.f351bK = 0.0f;
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
                    if ((block instanceof InterfaceC0671lw) || !zIsSolid) {
                        z3 = true;
                    }
                    if (!zIsSolid || !blockState.canOcclude()) {
                        z3 = true;
                    }
                    if (!z3 && C1215wI.m6740a(clientLevel, blockState, blockPos2).m6443cE()) {
                        z3 = true;
                    }
                    if (!z3 && dDistanceTo <= 1.0d) {
                        this.f351bK = (float) (1.0d - dDistanceTo);
                    }
                }
            }
        }
        C0444hh.f2829P.removeIf((v0) -> {
            return v0.mo276l();
        });
        m214a(localPlayer, clientLevel, soundManager, random);
        f340bF = Mth.lerp(0.1f, f340bF, 1.0f);
        float fBt = 0.35f;
        if (item instanceof C1144ur) {
            fBt = ((C1144ur) item).m5949bt();
        }
        f323bp = Mth.lerp(fBt, f323bp, this.f351bK);
        if (C0424hN.f2732m.m1996T()) {
            C0117bi.m351a(minecraft, localPlayer, clientLevel);
        }
        Entity vehicle = localPlayer.getVehicle();
        if (vehicle instanceof AbstractC0779ny) {
            AbstractC0779ny abstractC0779ny = (AbstractC0779ny) vehicle;
            C0732nD c0732nDM3535a = abstractC0779ny.m3535a((Entity) localPlayer);
            if (c0732nDM3535a != null) {
                f321bn = Mth.lerp(0.1f, f321bn, abstractC0779ny.mo3294ax());
                AbstractC0729nA.f3904fk = minecraft.mouseHandler.isRightPressed() && c0732nDM3535a.f3941jA > 0.0f;
            }
        } else {
            AbstractC0729nA.f3904fk = false;
            f321bn = Mth.lerp(0.1f, f321bn, 0.0f);
        }
        f325br = Mth.lerp(0.2f, f325br, (item instanceof C1144ur) && C1144ur.m6311f(mainHandItem) ? 1.0f : 0.0f);
        f327bt = Mth.lerp(0.2f, f327bt, localPlayer.isSprinting() ? 1.0f : 0.0f);
        f320bm = f319bl;
        f319bl = Mth.lerp(0.02f, f319bl, 0.0f);
        if (this.f345bG > localPlayer.moveDist + 2.0f) {
            this.f345bG = localPlayer.moveDist + 1.0f;
        }
        f338bD = f336bB;
        f339bE = f337bC;
        f336bB += (this.f346bH - localPlayer.getXRot()) * 3.0f;
        f337bC += (this.f347bI - localPlayer.yHeadRot) * 3.0f;
        this.f346bH = localPlayer.getXRot();
        this.f347bI = localPlayer.getYRot();
        f336bB *= 0.5f;
        f337bC *= 0.5f;
        boolean z4 = !mainHandItem.isEmpty() && (item instanceof C1129uc);
        C1129uc.f5939mM = C1129uc.f5938mL;
        C1129uc.f5938mL = Mth.lerp(0.5f, C1129uc.f5938mL, z4 ? 1.0f : 0.0f);
        if (localPlayer.moveDist > this.f345bG) {
            this.f345bG = localPlayer.moveDist + 1.0f;
            SoundEvent soundEventMo2604c = null;
            BlockPos onPos2 = localPlayer.getOnPos();
            BlockState blockState2 = clientLevel.getBlockState(onPos2);
            BlockState blockState3 = clientLevel.getBlockState(onPos2.above());
            InterfaceC0575kF block2 = blockState2.getBlock();
            if (block2 instanceof InterfaceC0575kF) {
                soundEventMo2604c = block2.mo2604c();
            }
            InterfaceC0575kF block3 = blockState3.getBlock();
            if (block3 instanceof InterfaceC0575kF) {
                soundEventMo2604c = block3.mo2604c();
            }
            if (soundEventMo2604c != null) {
                localPlayer.playSound(soundEventMo2604c, localPlayer.isSprinting() ? 1.0f : 0.35f, 1.0f);
            }
        }
        if (abstractC0787oF != null) {
            f306k.removeIf((v0) -> {
                return v0.m1172k();
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0082  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m217a(@org.jetbrains.annotations.NotNull net.minecraft.client.sounds.SoundManager r7, @org.jetbrains.annotations.NotNull net.minecraft.world.item.ItemStack r8) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.boehmod.blockfront.C0050aU.m217a(net.minecraft.client.sounds.SoundManager, net.minecraft.world.item.ItemStack):void");
    }
}
