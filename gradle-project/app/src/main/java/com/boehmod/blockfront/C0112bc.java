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
import net.minecraft.sounds.SoundSource;
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
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bc.class */
public final class C0112bc extends AbstractC0053aW {

    /* JADX INFO: renamed from: bl */
    private static final float f721bl = 45.0f;

    /* JADX INFO: renamed from: J */
    private static final double f722J = 0.800000011920929d;

    /* JADX INFO: renamed from: bm */
    private static final float f723bm = 0.4f;

    /* JADX INFO: renamed from: bn */
    public static final float f724bn = 0.15f;

    /* JADX INFO: renamed from: bo */
    public static final float f725bo = 12.0f;

    /* JADX INFO: renamed from: K */
    public static final double f727K = 0.1d;

    /* JADX INFO: renamed from: L */
    public static final double f728L = 0.1d;

    /* JADX INFO: renamed from: bV */
    private static final int f729bV = 2;

    /* JADX INFO: renamed from: bp */
    private static final float f730bp = 0.1f;

    /* JADX INFO: renamed from: bW */
    private static final int f731bW = 3;

    /* JADX INFO: renamed from: bq */
    public static final float f732bq = 0.35f;

    /* JADX INFO: renamed from: br */
    public static float f733br;

    /* JADX INFO: renamed from: bs */
    public static float f734bs;

    /* JADX INFO: renamed from: bt */
    public static float f735bt;

    /* JADX INFO: renamed from: bv */
    public static float f737bv;

    /* JADX INFO: renamed from: bx */
    public static float f739bx;

    /* JADX INFO: renamed from: bz */
    public static float f741bz;

    /* JADX INFO: renamed from: bB */
    public static float f744bB;

    /* JADX INFO: renamed from: bD */
    public static float f746bD;

    /* JADX INFO: renamed from: bF */
    public static float f748bF;

    /* JADX INFO: renamed from: bH */
    public static float f750bH;

    /* JADX INFO: renamed from: bI */
    public static float f751bI;

    /* JADX INFO: renamed from: bJ */
    public static float f752bJ;

    /* JADX INFO: renamed from: bN */
    private float f760bN;

    /* JADX INFO: renamed from: l */
    @NotNull
    public static final List<AbstractC0138cB> f720l = new ObjectArrayList();

    /* JADX INFO: renamed from: g */
    public static final Vec3 f726g = new Vec3(0.5d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: bu */
    public static float f736bu = 0.0f;

    /* JADX INFO: renamed from: bw */
    public static float f738bw = 0.0f;

    /* JADX INFO: renamed from: by */
    public static float f740by = 0.0f;

    /* JADX INFO: renamed from: bA */
    public static float f742bA = 0.0f;

    /* JADX INFO: renamed from: ak */
    public static boolean f743ak = false;

    /* JADX INFO: renamed from: bC */
    public static float f745bC = 0.0f;

    /* JADX INFO: renamed from: bE */
    public static float f747bE = 0.0f;

    /* JADX INFO: renamed from: bG */
    public static float f749bG = 0.0f;

    /* JADX INFO: renamed from: bK */
    public static float f753bK = 0.0f;

    /* JADX INFO: renamed from: bL */
    public static float f754bL = 0.0f;

    /* JADX INFO: renamed from: a */
    @Nullable
    public C0468iD f755a = null;

    /* JADX INFO: renamed from: a */
    @Nullable
    public C0514ix f756a = null;

    /* JADX INFO: renamed from: a */
    @Nullable
    public C1117uP f757a = null;

    /* JADX INFO: renamed from: a */
    @Nullable
    public C0515iy f758a = null;

    /* JADX INFO: renamed from: bM */
    public float f759bM = 0.0f;

    /* JADX INFO: renamed from: bO */
    private float f761bO = 0.0f;

    /* JADX INFO: renamed from: bP */
    private float f762bP = 0.0f;

    /* JADX INFO: renamed from: al */
    private boolean f763al = false;

    /* JADX INFO: renamed from: bX */
    private int f764bX = 0;

    /* JADX INFO: renamed from: bQ */
    private float f765bQ = 0.0f;

    /* JADX INFO: renamed from: a */
    private static void m417a(@NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull SoundManager soundManager, @NotNull Random random) {
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        f745bC = f744bB;
        if (!mainHandItem.isEmpty()) {
            Item item = mainHandItem.getItem();
            if ((item instanceof C1117uP) && ((C1117uP) item).m6366cF()) {
                boolean z = false;
                boolean z2 = Mth.abs(localPlayer.getXRot()) > f721bl;
                if (localPlayer.isCrouching() && !z2) {
                    Vec3 vec3Add = localPlayer.getEyePosition().add(f726g.yRot((float) Math.toRadians((-localPlayer.getYHeadRot()) - 90.0f)));
                    z = clientLevel.clip(new ClipContext(vec3Add, vec3Add.add(0.0d, -0.800000011920929d, 0.0d), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, localPlayer)).getType() == HitResult.Type.BLOCK;
                }
                boolean z3 = z && ((double) f737bv) < 0.1d && ((double) f746bD) < 0.1d;
                m419a(z3, soundManager, random);
                f744bB = Mth.lerp(0.4f, f744bB, z3 ? 1.0f : 0.0f);
                return;
            }
        }
        f744bB = 0.0f;
        m419a(false, soundManager, random);
    }

    /* JADX INFO: renamed from: e */
    private static float m418e(float f) {
        if (!C0262eJ.m1487K()) {
            return C1270xJ.m7161d(f, 0.0f, 0.1f);
        }
        int iM1489ak = C0262eJ.m1489ak();
        int iM1490al = C0262eJ.m1490al();
        int i = iM1490al / 4;
        if (i > 0 && iM1489ak > 0 && iM1489ak < iM1490al && iM1489ak % i == 0) {
            return 1.0f;
        }
        return C1270xJ.m7161d(f, 0.0f, 0.1f);
    }

    /* JADX INFO: renamed from: a */
    private static void m419a(boolean z, @NotNull SoundManager soundManager, @NotNull Random random) {
        if (z && !f743ak) {
            f743ak = true;
            C0432hU.m1986a(C0435hX.f2771u);
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f8406xL.get(), 1.0f, 0.9f + (0.1f * random.nextFloat())));
            return;
        }
        if (!z && f743ak) {
            f743ak = false;
            C0432hU.m1986a(C0435hX.f2770t);
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f8407xM.get(), 1.0f, 0.9f + (0.1f * random.nextFloat())));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0053aW
    /* JADX INFO: renamed from: a */
    public void mo246a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull C0555jl c0555jl, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, float f) {
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        Item item = mainHandItem.getItem();
        m420a(soundManager, mainHandItem);
        if (localPlayer.onGround()) {
            if (!this.f763al) {
                this.f763al = true;
                if (this.f762bP >= 1.0f) {
                    soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f8132sx.get(), 0.9f + (0.2f * random.nextFloat()), 0.3f));
                    C0432hU.m1986a(C0435hX.f2772v);
                    BlockPos onPos = localPlayer.getOnPos();
                    SoundType soundType = clientLevel.getBlockState(onPos).getSoundType(clientLevel, onPos, (Entity) null);
                    soundManager.play(SimpleSoundInstance.forUI(soundType.getStepSound(), 1.0f, 0.3f));
                    soundManager.play(SimpleSoundInstance.forUI(soundType.getHitSound(), 1.0f, 0.3f));
                }
            }
        } else {
            this.f763al = false;
        }
        this.f762bP = localPlayer.fallDistance;
        boolean z2 = C1296xj.f7481c.isDown() && (item instanceof AbstractC1140um) && ((AbstractC1140um) item).mo6194cs() && !C0486iV.m2182aa() && !C1117uP.f6063il;
        f747bE = f746bD;
        f746bD = Mth.lerp(0.15f, f746bD, z2 ? 1.0f : 0.0f);
        f736bu = f735bt;
        f738bw = f737bv;
        f740by = f739bx;
        f742bA = f741bz;
        f749bG = f748bF;
        f748bF = m418e(f748bF);
        C0036aF.f321ao = C0036aF.f320an;
        C0036aF.f323aq = C0036aF.f322ap;
        C0036aF.f325as = C0036aF.f324ar;
        C0036aF.f320an = Mth.lerp(0.15f, C0036aF.f320an, Mth.clamp(C0036aF.f317ak, -12.0f, 12.0f));
        C0036aF.f322ap = Mth.lerp(0.15f, C0036aF.f322ap, Mth.clamp(C0036aF.f318al, -12.0f, 12.0f));
        C0036aF.f324ar = Mth.lerp(0.15f, C0036aF.f324ar, Mth.clamp(C0036aF.f319am, -12.0f, 12.0f));
        int i = this.f764bX;
        this.f764bX = i - 1;
        if (i <= 0) {
            this.f764bX = 2;
            this.f765bQ = 0.0f;
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
                    if ((block instanceof InterfaceC0642lS) || !zIsSolid) {
                        z3 = true;
                    }
                    if (!zIsSolid || !blockState.canOcclude()) {
                        z3 = true;
                    }
                    if (!z3 && C1292xf.m7328a(clientLevel, blockState, blockPos2).m6429cN()) {
                        z3 = true;
                    }
                    if (!z3 && dDistanceTo <= 1.0d) {
                        this.f765bQ = (float) (1.0d - dDistanceTo);
                    }
                }
            }
        }
        C0461hx.f2881S.removeIf((v0) -> {
            return v0.mo203m();
        });
        m417a(localPlayer, clientLevel, soundManager, random);
        f754bL = Mth.lerp(0.1f, f754bL, 1.0f);
        float fBz = 0.35f;
        if (item instanceof C1117uP) {
            fBz = ((C1117uP) item).m6576bz();
            if (C1117uP.f6063il) {
                fBz *= 1.5f;
            }
        }
        f737bv = Mth.lerp(fBz, f737bv, this.f765bQ);
        if (C0495ie.f3033m.m2230U()) {
            C0127br.m451a(minecraft, localPlayer, clientLevel);
        }
        Entity vehicle = localPlayer.getVehicle();
        if (vehicle instanceof AbstractC0750nU) {
            AbstractC0750nU abstractC0750nU = (AbstractC0750nU) vehicle;
            C0755nZ c0755nZM3472a = abstractC0750nU.m3472a((Entity) localPlayer);
            if (c0755nZM3472a != null) {
                f735bt = Mth.lerp(0.1f, f735bt, abstractC0750nU.mo3435aD());
                AbstractC0752nW.f4152fE = minecraft.mouseHandler.isRightPressed() && c0755nZM3472a.f4189kt > 0.0f;
            }
        } else {
            AbstractC0752nW.f4152fE = false;
            f735bt = Mth.lerp(0.1f, f735bt, 0.0f);
        }
        f739bx = Mth.lerp(0.2f, f739bx, (item instanceof C1117uP) && C0486iV.m2182aa() ? 1.0f : 0.0f);
        f741bz = Mth.lerp(0.2f, f741bz, localPlayer.isSprinting() ? 1.0f : 0.0f);
        f734bs = f733br;
        f733br = Mth.lerp(0.02f, f733br, 0.0f);
        if (this.f759bM > localPlayer.moveDist + 2.0f) {
            this.f759bM = localPlayer.moveDist + 1.0f;
        }
        f752bJ = f750bH;
        f753bK = f751bI;
        f750bH += (this.f760bN - localPlayer.getXRot()) * 3.0f;
        f751bI += (this.f761bO - localPlayer.yHeadRot) * 3.0f;
        this.f760bN = localPlayer.getXRot();
        this.f761bO = localPlayer.getYRot();
        f750bH *= 0.5f;
        f751bI *= 0.5f;
        boolean z4 = !mainHandItem.isEmpty() && (item instanceof C1102uA);
        C1102uA.f6005nL = C1102uA.f6004nK;
        C1102uA.f6004nK = Mth.lerp(0.5f, C1102uA.f6004nK, z4 ? 1.0f : 0.0f);
        if (localPlayer.moveDist > this.f759bM) {
            this.f759bM = localPlayer.moveDist + 1.0f;
            SoundEvent soundEventMo2932c = null;
            BlockPos onPos2 = localPlayer.getOnPos();
            BlockState blockState2 = clientLevel.getBlockState(onPos2);
            BlockState blockState3 = clientLevel.getBlockState(onPos2.above());
            InterfaceC0651lb block2 = blockState2.getBlock();
            if (block2 instanceof InterfaceC0651lb) {
                soundEventMo2932c = block2.mo2932c();
            }
            InterfaceC0651lb block3 = blockState3.getBlock();
            if (block3 instanceof InterfaceC0651lb) {
                soundEventMo2932c = block3.mo2932c();
            }
            if (soundEventMo2932c != null) {
                localPlayer.playSound(soundEventMo2932c, localPlayer.isSprinting() ? 1.0f : 0.35f, 1.0f);
            }
        }
        if (abstractC0863pb != null) {
            f720l.removeIf((v0) -> {
                return v0.m769l();
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0082  */
    /* JADX INFO: renamed from: a */
    private void m420a(@NotNull SoundManager soundManager, @NotNull ItemStack itemStack) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6840K;
        if (this.f755a == null) {
            this.f755a = new C0468iD((SoundEvent) C1312xz.f8131sw.get());
        }
        if (!soundManager.isActive(this.f755a)) {
            soundManager.play(this.f755a);
        }
        if (this.f758a == null) {
            this.f758a = new C0515iy((SoundEvent) C1312xz.f8387xs.get(), SoundSource.PLAYERS);
        }
        if (!soundManager.isActive(this.f758a)) {
            soundManager.play(this.f758a);
        }
        if (itemStack.isEmpty()) {
            this.f757a = null;
        } else {
            Item item = itemStack.getItem();
            if (item instanceof C1117uP) {
                this.f757a = (C1117uP) item;
            } else {
                this.f757a = null;
            }
        }
        if (this.f757a == null) {
            if (this.f756a != null && soundManager.isActive(this.f756a)) {
                soundManager.stop(this.f756a);
                this.f756a = null;
                return;
            }
            return;
        }
        if (this.f756a != null && this.f756a.m2293a() != this.f757a) {
            soundManager.stop(this.f756a);
            this.f756a = null;
        }
        if ((this.f756a == null || !soundManager.isActive(this.f756a)) && (deferredHolderM6840K = this.f757a.m6384a(itemStack).m6840K()) != null) {
            this.f756a = new C0514ix((SoundEvent) deferredHolderM6840K.get(), this.f757a);
            soundManager.play(this.f756a);
        }
    }
}
