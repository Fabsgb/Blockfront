package com.boehmod.blockfront;

import com.boehmod.blockfront.C0171cj;
import com.boehmod.blockfront.C1151uy;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aP.class */
public final class C0045aP {

    /* JADX INFO: renamed from: aR */
    private static final float f277aR = 0.2f;

    /* JADX INFO: renamed from: aS */
    private static final float f278aS = 16.0f;

    /* JADX INFO: renamed from: aV */
    private static final int f279aV = 128;

    /* JADX INFO: renamed from: aT */
    private static final float f280aT = 0.75f;

    /* JADX INFO: renamed from: aU */
    private static final float f281aU = 3.0f;

    /* JADX INFO: renamed from: aW */
    private static final int f282aW = 2;

    /* JADX INFO: renamed from: aX */
    private static final int f283aX = 1;

    /* JADX INFO: renamed from: aY */
    private static final int f284aY = 6;

    /* JADX INFO: renamed from: aZ */
    private static final int f285aZ = 32;

    /* JADX INFO: renamed from: aV */
    private static final float f286aV = 16.0f;

    /* JADX INFO: renamed from: aW */
    private static final float f287aW = 0.1f;

    /* JADX INFO: renamed from: aX */
    public static final float f288aX = 1.5f;

    /* JADX INFO: renamed from: aY */
    public static final float f289aY = 6.0f;

    /* JADX INFO: renamed from: aZ */
    private static final float f290aZ = 0.5f;

    /* JADX INFO: renamed from: ba */
    private static final float f291ba = 64.0f;

    /* JADX INFO: renamed from: A */
    private static final double f292A = 10.0d;

    /* JADX INFO: renamed from: ba */
    private static final int f293ba = 20;

    /* JADX INFO: renamed from: bb */
    private static final float f294bb = 0.35f;

    /* JADX INFO: renamed from: bb */
    private static final int f295bb = -30720;

    /* JADX INFO: renamed from: bc */
    private static final int f296bc = -16711681;

    /* JADX INFO: renamed from: B */
    private static final double f297B = 16.0d;

    /* JADX INFO: renamed from: a */
    public static void m205a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @Nullable LivingEntity livingEntity, @NotNull C1141uo c1141uo, int i) {
        Vec3 vec3M6281z = c1141uo.m6281z();
        Entity cameraEntity = minecraft.getCameraEntity();
        boolean z = true;
        if (cameraEntity != null) {
            int iDistanceTo = (int) cameraEntity.position().distanceTo(vec3M6281z);
            if (iDistanceTo > 128) {
                return;
            } else {
                z = iDistanceTo <= 32;
            }
        }
        Direction directionM6280b = c1141uo.m6280b();
        BlockPos blockPosM6279a = c1141uo.m6279a();
        BlockState blockState = clientLevel.getBlockState(blockPosM6279a);
        SoundType soundType = blockState.getSoundType(clientLevel, blockPosM6279a, localPlayer);
        InterfaceC0574kE block = blockState.getBlock();
        ItemStack mainHandItem = ItemStack.EMPTY;
        C1144ur c1144ur = null;
        if (livingEntity != null) {
            mainHandItem = livingEntity.getMainHandItem();
            Item item = mainHandItem.getItem();
            c1144ur = item instanceof C1144ur ? (C1144ur) item : null;
        }
        C1111uK c1111uKM6396a = c1144ur != null ? c1144ur.m6396a() : C1112uL.f5851b;
        C1149uw c1149uwM6740a = C1215wI.m6740a(clientLevel, blockState, blockPosM6279a);
        if (blockState.isAir()) {
            return;
        }
        if (soundType == SoundType.EMPTY && c1149uwM6740a.m6440a() == null) {
            return;
        }
        if (z && soundType != SoundType.EMPTY) {
            clientLevel.playLocalSound(blockPosM6279a.getX(), blockPosM6279a.getY(), blockPosM6279a.getZ(), soundType.getBreakSound(), SoundSource.BLOCKS, 1.0f, 1.0f, false);
        }
        C1151uy c1151uyM6440a = c1149uwM6740a.m6440a();
        Vec3 vec3Add = new Vec3(blockPosM6279a.getX(), blockPosM6279a.getY(), blockPosM6279a.getZ()).add(0.5d, 0.5d, 0.5d);
        boolean z2 = (block instanceof InterfaceC0574kE) || !(block instanceof InterfaceC0671lw);
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (block instanceof InterfaceC0574kE) {
            block.mo2601a(minecraft, c0622l, clientLevel, i, vec3M6281z, blockPosM6279a, blockState, directionM6280b);
        }
        if (c1151uyM6440a != null && z) {
            m206a(clientLevel, c1151uyM6440a, vec3Add, threadLocalRandomCurrent);
        }
        if (z2) {
            Vec3 eyePosition = localPlayer.getEyePosition();
            if (z && c1144ur != null) {
                m207a(clientLevel, c1144ur, mainHandItem, vec3Add, vec3M6281z, eyePosition, threadLocalRandomCurrent);
            }
            m208a(clientLevel, (LivingEntity) localPlayer, c1149uwM6740a, eyePosition, vec3M6281z, randomSource, (Random) threadLocalRandomCurrent, vec3Add);
            if (c1151uyM6440a != null) {
                if (c1151uyM6440a.m6464cH()) {
                    C0470iG.m2129a(minecraft, c0622l, clientLevel, blockPosM6279a, vec3M6281z, directionM6280b, blockState, 1.0f);
                }
                if (c1151uyM6440a.m6465cI() && C0424hN.f2753H.m1996T() && (!(block instanceof InterfaceC0574kE) || block.mo2602ak())) {
                    C0470iG.m2126a(minecraft, c0622l, clientLevel, (SimpleParticleType) c1111uKM6396a.m6126q().get(), vec3M6281z.x, vec3M6281z.y, vec3M6281z.z, directionM6280b.ordinal(), 0.0d, 0.0d);
                }
                List<C1151uy.a> listM6467aI = c1151uyM6440a.m6467aI();
                for (C1151uy.a aVar : listM6467aI) {
                    ParticleOptions particleOptionsM6473a = aVar.m6473a();
                    int iM6474cd = aVar.m6474cd();
                    for (int i2 = 0; i2 < iM6474cd; i2++) {
                        C0470iG.m2128a(minecraft, c0622l, clientLevel, vec3M6281z.add(Mth.nextFloat(randomSource, -0.1f, 0.1f), Mth.nextFloat(randomSource, -0.1f, 0.1f), Mth.nextFloat(randomSource, -0.1f, 0.1f)), directionM6280b, particleOptionsM6473a, 0.45f, 0.1f);
                    }
                }
                if (C0476iM.f2923dk && !listM6467aI.isEmpty()) {
                    C0470iG.m2128a(minecraft, c0622l, clientLevel, vec3M6281z.add(Mth.nextFloat(randomSource, -0.1f, 0.1f), Mth.nextFloat(randomSource, -0.1f, 0.1f), Mth.nextFloat(randomSource, -0.1f, 0.1f)), directionM6280b, (ParticleOptions) C1232wZ.f7306nH.get(), 0.45f, 0.1f);
                }
                for (C1151uy.a aVar2 : c1151uyM6440a.m6466aH()) {
                    ParticleOptions particleOptionsM6473a2 = aVar2.m6473a();
                    int iM6474cd2 = aVar2.m6474cd();
                    for (int i3 = 0; i3 < iM6474cd2; i3++) {
                        C0470iG.m2126a(minecraft, c0622l, clientLevel, particleOptionsM6473a2, vec3M6281z.x, vec3M6281z.y, vec3M6281z.z, 0.0d, 0.0d, 0.0d);
                    }
                }
                C0470iG.m2128a(minecraft, c0622l, clientLevel, vec3M6281z, directionM6280b, (ParticleOptions) c1111uKM6396a.m6124p().get(), 0.0f, 0.25f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m206a(@NotNull ClientLevel clientLevel, @NotNull C1151uy c1151uy, @NotNull Vec3 vec3, @NotNull ThreadLocalRandom threadLocalRandom) {
        if (c1151uy.m6463cG()) {
            clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) C1280xc.f7813uk.get(), SoundSource.BLOCKS, 1.5f, 0.95f + (0.2f * threadLocalRandom.nextFloat()), false);
            LocalPlayer localPlayer = Minecraft.getInstance().player;
            if (localPlayer != null) {
                float fDistanceTo = (float) localPlayer.position().distanceTo(vec3);
                if (fDistanceTo <= 6.0f) {
                    clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) C1280xc.f7814ul.get(), SoundSource.BLOCKS, 1.0f - (fDistanceTo / 6.0f), 1.0f, false);
                }
            }
        }
        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, c1151uy.m6456B(), SoundSource.BLOCKS, 1.5f, 0.8f + (0.1f * threadLocalRandom.nextInt(4)), false);
        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, c1151uy.m6457C(), SoundSource.BLOCKS, 1.5f, 0.8f + (0.1f * threadLocalRandom.nextInt(4)), false);
    }

    /* JADX INFO: renamed from: a */
    private static void m207a(@NotNull ClientLevel clientLevel, @NotNull C1144ur c1144ur, @NotNull ItemStack itemStack, @NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Vec3 vec33, @NotNull ThreadLocalRandom threadLocalRandom) {
        C1118uR c1118uRM6408a = c1144ur.m6408a(itemStack);
        if (c1118uRM6408a != null) {
            float fNextFloat = 0.95f + (0.1f * threadLocalRandom.nextFloat());
            if (threadLocalRandom.nextFloat() < c1118uRM6408a.m6220bI()) {
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6208U = c1118uRM6408a.m6208U();
                if (deferredHolderM6208U != null) {
                    clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) deferredHolderM6208U.get(), SoundSource.BLOCKS, 1.5f, fNextFloat, false);
                }
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6209V = c1118uRM6408a.m6209V();
                if (deferredHolderM6209V != null) {
                    float fDistanceTo = (float) vec33.distanceTo(vec32);
                    if (fDistanceTo <= 16.0f) {
                        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) deferredHolderM6209V.get(), SoundSource.BLOCKS, 1.0f - (fDistanceTo / 16.0f), fNextFloat, false);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m208a(@NotNull ClientLevel clientLevel, @NotNull LivingEntity livingEntity, @Nullable C1149uw c1149uw, @NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull RandomSource randomSource, @NotNull Random random, @NotNull Vec3 vec33) {
        C0171cj.b.a aVarM6462a;
        int iDistanceTo;
        if (c1149uw == null || c1149uw.m6440a() == null || (aVarM6462a = c1149uw.m6440a().m6462a()) == null) {
            return;
        }
        if ((clientLevel.clip(new ClipContext(vec3, vec32, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, livingEntity)).getType() == HitResult.Type.MISS) && aVarM6462a != null && randomSource.nextFloat() < 0.2f && (iDistanceTo = (int) vec3.distanceTo(vec33)) <= 6) {
            int i = 6 - iDistanceTo;
            for (int i2 = 0; i2 < i; i2++) {
                C0178cm.f1457p.add(new C0171cj.b(random, aVarM6462a));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m209a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Random random, @NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2, @NotNull Vec3 vec3, @NotNull Direction direction, boolean z) {
        float fNextFloat = 0.9f + (randomSource.nextFloat() * 0.2f);
        Vec3 vec3Position = livingEntity2.position();
        Vec3 eyePosition = livingEntity.getEyePosition();
        float fDistanceTo = (float) eyePosition.distanceTo(vec3);
        if (fDistanceTo >= 128.0f) {
            return;
        }
        if (z) {
            clientLevel.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1280xc.f7828uz.get(), SoundSource.BLOCKS, 1.5f, fNextFloat, false);
            clientLevel.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1280xc.f7830uB.get(), SoundSource.BLOCKS, 1.5f, fNextFloat, false);
        } else {
            clientLevel.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1280xc.f7827uy.get(), SoundSource.BLOCKS, 1.5f, fNextFloat, false);
        }
        clientLevel.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1280xc.f7832uD.get(), SoundSource.BLOCKS, 1.5f, 1.0f, false);
        if (fDistanceTo <= 16.0f) {
            clientLevel.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1280xc.f7831uC.get(), SoundSource.BLOCKS, 1.0f - (fDistanceTo / 16.0f), fNextFloat, false);
        }
        if (C0424hN.f2742w.m1996T()) {
            SimpleParticleType simpleParticleType = (SimpleParticleType) C1232wZ.f7288np.get();
            int i = z ? 2 : 1;
            for (int i2 = 0; i2 < i; i2++) {
                C0470iG.m2126a(minecraft, c0622l, clientLevel, simpleParticleType, vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
            }
            C0470iG.m2127a(minecraft, c0622l, clientLevel, vec3, direction, (ParticleOptions) C1232wZ.f7312nN.get(), -0.45f);
            if (randomSource.nextFloat() < 0.75f && Mth.sqrt((float) eyePosition.distanceToSqr(vec3)) <= 3.0f) {
                C0178cm.f1457p.add(new C0171cj.b(random, C0171cj.b.a.BLOOD));
            }
        }
        if (randomSource.nextBoolean()) {
            C0470iG.m2127a(minecraft, c0622l, clientLevel, vec3, direction, (ParticleOptions) C1232wZ.f7321nW.get(), 0.1f);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m210a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull C1141uo c1141uo, @NotNull Vec3 vec3, @NotNull RandomSource randomSource) {
        C1151uy c1151uyM6440a;
        if (randomSource.nextFloat() <= 0.5f && (c1151uyM6440a = C1215wI.m6740a(clientLevel, clientLevel.getBlockState(c1141uo.m6279a()), c1141uo.m6279a()).m6440a()) != null && c1151uyM6440a.m6463cG()) {
            Vec3 vec3M6281z = c1141uo.m6281z();
            clientLevel.playLocalSound(vec3M6281z.x, vec3M6281z.y, vec3M6281z.z, (SoundEvent) C1280xc.f7812uj.get(), SoundSource.BLOCKS, 1.5f, 0.95f + (0.2f * randomSource.nextFloat()), false);
            LocalPlayer localPlayer = minecraft.player;
            if (localPlayer != null && localPlayer.position().distanceTo(vec3M6281z) <= f297B) {
                Vec3 vec3AtLowerCornerOf = Vec3.atLowerCornerOf(c1141uo.m6280b().getNormal());
                Vec3 vec3Normalize = vec3M6281z.subtract(vec3).normalize();
                Vec3 vec3Normalize2 = vec3Normalize.subtract(vec3AtLowerCornerOf.scale(2.0d * vec3Normalize.dot(vec3AtLowerCornerOf))).normalize().add(new Vec3(Mth.nextFloat(randomSource, -0.35f, 0.35f), Mth.nextFloat(randomSource, -0.35f, 0.35f), Mth.nextFloat(randomSource, -0.35f, 0.35f))).normalize();
                Vec3 vec3Add = vec3M6281z.add(vec3AtLowerCornerOf.scale(0.05d));
                BlockHitResult blockHitResultClip = clientLevel.clip(new ClipContext(vec3Add, vec3Add.add(vec3Normalize2.scale(64.0d)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, localPlayer));
                Vec3 location = blockHitResultClip.getLocation();
                if (vec3Add.distanceTo(location) < f292A) {
                    return;
                }
                boolean z = blockHitResultClip.getType() == HitResult.Type.BLOCK;
                if (minecraft.getDebugOverlay().showDebugScreen()) {
                    C0049aT.f304i.add(new C0023U(vec3Add, location, 200, true, z ? f295bb : f296bc));
                }
                minecraft.getSoundManager().play(new C0505ip(z ? (SoundEvent) C1280xc.f7845uQ.get() : (SoundEvent) C1280xc.f7844uP.get(), SoundSource.BLOCKS, vec3Add, location, 20, 0.9f + (randomSource.nextFloat() * 0.2f)));
            }
        }
    }
}
