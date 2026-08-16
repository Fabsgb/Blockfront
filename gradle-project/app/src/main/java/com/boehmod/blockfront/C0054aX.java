package com.boehmod.blockfront;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.aX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aX.class */
public final class C0054aX {

    /* JADX INFO: renamed from: aW */
    private static final float f377aW = 0.2f;

    /* JADX INFO: renamed from: aX */
    private static final float f378aX = 16.0f;

    /* JADX INFO: renamed from: bJ */
    private static final int f379bJ = 128;

    /* JADX INFO: renamed from: aY */
    private static final float f380aY = 0.75f;

    /* JADX INFO: renamed from: aZ */
    private static final float f381aZ = 3.0f;

    /* JADX INFO: renamed from: bK */
    private static final int f382bK = 2;

    /* JADX INFO: renamed from: bL */
    private static final int f383bL = 1;

    /* JADX INFO: renamed from: bM */
    private static final int f384bM = 6;

    /* JADX INFO: renamed from: bN */
    private static final int f385bN = 32;

    /* JADX INFO: renamed from: ba */
    private static final float f386ba = 16.0f;

    /* JADX INFO: renamed from: bb */
    private static final float f387bb = 0.1f;

    /* JADX INFO: renamed from: bc */
    public static final float f388bc = 1.5f;

    /* JADX INFO: renamed from: bd */
    private static final float f389bd = 0.5f;

    /* JADX INFO: renamed from: bO */
    private static final int f390bO = 5;

    /* JADX INFO: renamed from: bP */
    private static final int f391bP = 40;

    /* JADX INFO: renamed from: be */
    public static final float f392be = 6.0f;

    /* JADX INFO: renamed from: bf */
    private static final float f393bf = 0.5f;

    /* JADX INFO: renamed from: bg */
    private static final float f394bg = 64.0f;

    /* JADX INFO: renamed from: H */
    private static final double f395H = 10.0d;

    /* JADX INFO: renamed from: bQ */
    private static final int f396bQ = 20;

    /* JADX INFO: renamed from: bh */
    private static final float f397bh = 0.35f;

    /* JADX INFO: renamed from: bR */
    private static final int f398bR = -30720;

    /* JADX INFO: renamed from: bS */
    private static final int f399bS = -16711681;

    /* JADX INFO: renamed from: I */
    private static final double f400I = 16.0d;

    /* JADX INFO: renamed from: a */
    public static void m247a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @Nullable LivingEntity livingEntity, @NotNull C1114uM c1114uM, int i) {
        Vec3 vec3M6245A = c1114uM.m6245A();
        Entity cameraEntity = minecraft.getCameraEntity();
        boolean z = true;
        if (cameraEntity != null) {
            int iDistanceTo = (int) cameraEntity.position().distanceTo(vec3M6245A);
            if (iDistanceTo > 128) {
                return;
            } else {
                z = iDistanceTo <= 32;
            }
        }
        Direction directionM6244b = c1114uM.m6244b();
        BlockPos blockPosM6243a = c1114uM.m6243a();
        BlockState blockState = clientLevel.getBlockState(blockPosM6243a);
        SoundType soundType = blockState.getSoundType(clientLevel, blockPosM6243a, localPlayer);
        InterfaceC0650la block = blockState.getBlock();
        ItemStack mainHandItem = ItemStack.EMPTY;
        C1117uP c1117uP = null;
        if (livingEntity != null) {
            mainHandItem = livingEntity.getMainHandItem();
            Item item = mainHandItem.getItem();
            c1117uP = item instanceof C1117uP ? (C1117uP) item : null;
        }
        C1191vk c1191vkM6371a = c1117uP != null ? c1117uP.m6371a() : C1192vl.f6490b;
        C1124uW c1124uWM7328a = C1292xf.m7328a(clientLevel, blockState, blockPosM6243a);
        if (blockState.isAir()) {
            return;
        }
        if (soundType == SoundType.EMPTY && c1124uWM7328a.m6426a() == null) {
            return;
        }
        if (z && soundType != SoundType.EMPTY) {
            clientLevel.playLocalSound(blockPosM6243a.getX(), blockPosM6243a.getY(), blockPosM6243a.getZ(), soundType.getBreakSound(), SoundSource.BLOCKS, 1.0f, 1.0f, false);
        }
        C1126uY c1126uYM6426a = c1124uWM7328a.m6426a();
        Vec3 vec3Add = new Vec3(blockPosM6243a.getX(), blockPosM6243a.getY(), blockPosM6243a.getZ()).add(0.5d, 0.5d, 0.5d);
        boolean z2 = (block instanceof InterfaceC0650la) || !(block instanceof InterfaceC0642lS);
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (block instanceof InterfaceC0650la) {
            block.mo2615a(minecraft, c0623l, clientLevel, i, vec3M6245A, blockPosM6243a, blockState, directionM6244b);
        }
        if (c1126uYM6426a != null && z) {
            m248a(clientLevel, c1126uYM6426a, vec3Add, threadLocalRandomCurrent);
        }
        if (z2) {
            Vec3 eyePosition = localPlayer.getEyePosition();
            if (z && c1117uP != null) {
                m249a(clientLevel, c1117uP, mainHandItem, vec3Add, vec3M6245A, eyePosition, threadLocalRandomCurrent);
            }
            m250a(clientLevel, (LivingEntity) localPlayer, c1124uWM7328a, eyePosition, vec3M6245A, randomSource, (Random) threadLocalRandomCurrent, vec3Add);
            if (c1126uYM6426a != null) {
                if (c1126uYM6426a.m6452cQ()) {
                    C0490iZ.m2221a(minecraft, c0623l, clientLevel, blockPosM6243a, vec3M6245A, directionM6244b, blockState, 1.0f);
                }
                if (c1126uYM6426a.m6453cR() && C0495ie.f3054H.m2230U() && (!(block instanceof InterfaceC0650la) || block.mo2616au())) {
                    C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) c1191vkM6371a.m6779q().get(), vec3M6245A.x, vec3M6245A.y, vec3M6245A.z, directionM6244b.ordinal(), 0.0d, 0.0d);
                }
                List<C1126uY.a> listM6455aM = c1126uYM6426a.m6455aM();
                for (C1126uY.a aVar : listM6455aM) {
                    ParticleOptions particleOptionsM6462a = aVar.m6462a();
                    int iM6463ct = aVar.m6463ct();
                    for (int i2 = 0; i2 < iM6463ct; i2++) {
                        C0490iZ.m2220a(minecraft, c0623l, clientLevel, vec3M6245A.add(Mth.nextFloat(randomSource, -0.1f, 0.1f), Mth.nextFloat(randomSource, -0.1f, 0.1f), Mth.nextFloat(randomSource, -0.1f, 0.1f)), directionM6244b, particleOptionsM6462a, 0.45f, 0.1f);
                    }
                }
                if (C0549jf.f3273dv && !listM6455aM.isEmpty()) {
                    C0490iZ.m2220a(minecraft, c0623l, clientLevel, vec3M6245A.add(Mth.nextFloat(randomSource, -0.1f, 0.1f), Mth.nextFloat(randomSource, -0.1f, 0.1f), Mth.nextFloat(randomSource, -0.1f, 0.1f)), directionM6244b, (ParticleOptions) C1309xw.f7871nH.get(), 0.45f, 0.1f);
                }
                for (C1126uY.a aVar2 : c1126uYM6426a.m6454aL()) {
                    ParticleOptions particleOptionsM6462a2 = aVar2.m6462a();
                    int iM6463ct2 = aVar2.m6463ct();
                    for (int i3 = 0; i3 < iM6463ct2; i3++) {
                        C0490iZ.m2218a(minecraft, c0623l, clientLevel, particleOptionsM6462a2, vec3M6245A.x, vec3M6245A.y, vec3M6245A.z, 0.0d, 0.0d, 0.0d);
                    }
                }
                C0490iZ.m2220a(minecraft, c0623l, clientLevel, vec3M6245A, directionM6244b, (ParticleOptions) c1191vkM6371a.m6777p().get(), 0.0f, 0.25f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m248a(@NotNull ClientLevel clientLevel, @NotNull C1126uY c1126uY, @NotNull Vec3 vec3, @NotNull ThreadLocalRandom threadLocalRandom) {
        if (c1126uY.m6451cP()) {
            clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) C1312xz.f8224ul.get(), SoundSource.BLOCKS, 1.5f, 0.95f + (0.2f * threadLocalRandom.nextFloat()), false);
            LocalPlayer localPlayer = Minecraft.getInstance().player;
            if (localPlayer != null) {
                float fDistanceTo = (float) localPlayer.position().distanceTo(vec3);
                if (fDistanceTo <= 6.0f) {
                    clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) C1312xz.f8225um.get(), SoundSource.BLOCKS, 1.0f - (fDistanceTo / 6.0f), 1.0f, false);
                }
            }
        }
        SoundEvent soundEventM6442B = c1126uY.m6442B();
        if (soundEventM6442B != null) {
            clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, soundEventM6442B, SoundSource.BLOCKS, 1.5f, 0.95f + (0.1f * threadLocalRandom.nextFloat()), false);
        }
        SoundEvent soundEventM6443C = c1126uY.m6443C();
        if (soundEventM6443C != null) {
            clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, soundEventM6443C, SoundSource.BLOCKS, 1.5f, 0.8f + (0.4f * threadLocalRandom.nextFloat()), false);
        }
        SoundEvent soundEventM6444D = c1126uY.m6444D();
        if (soundEventM6444D != null && threadLocalRandom.nextFloat() < 0.5f) {
            float fNextFloat = 0.8f + (0.4f * threadLocalRandom.nextFloat());
            int iNextInt = 5 + threadLocalRandom.nextInt(36);
            Minecraft.getInstance().getSoundManager().playDelayed(new SimpleSoundInstance(soundEventM6444D, SoundSource.BLOCKS, 1.5f, fNextFloat, SoundInstance.createUnseededRandom(), vec3.x, vec3.y, vec3.z), iNextInt);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m249a(@NotNull ClientLevel clientLevel, @NotNull C1117uP c1117uP, @NotNull ItemStack itemStack, @NotNull Vec3 vec3, @NotNull Vec3 vec4, @NotNull Vec3 vec5, @NotNull ThreadLocalRandom threadLocalRandom) {
        C1198vr c1198vrM6384a = c1117uP.m6384a(itemStack);
        if (c1198vrM6384a != null) {
            float fNextFloat = 0.95f + (0.1f * threadLocalRandom.nextFloat());
            if (threadLocalRandom.nextFloat() < c1198vrM6384a.m6873bO()) {
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6861U = c1198vrM6384a.m6861U();
                if (deferredHolderM6861U != null) {
                    clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) deferredHolderM6861U.get(), SoundSource.BLOCKS, 1.5f, fNextFloat, false);
                }
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6862V = c1198vrM6384a.m6862V();
                if (deferredHolderM6862V != null) {
                    float fDistanceTo = (float) vec5.distanceTo(vec4);
                    if (fDistanceTo <= 16.0f) {
                        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) deferredHolderM6862V.get(), SoundSource.BLOCKS, 1.0f - (fDistanceTo / 16.0f), fNextFloat, false);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m250a(@NotNull ClientLevel clientLevel, @NotNull LivingEntity livingEntity, @Nullable C1124uW c1124uW, @NotNull Vec3 vec3, @NotNull Vec3 vec4, @NotNull RandomSource randomSource, @NotNull Random random, @NotNull Vec3 vec5) {
        C0191cs.b.a aVarM6450a;
        int iDistanceTo;
        if (c1124uW == null || c1124uW.m6426a() == null || (aVarM6450a = c1124uW.m6426a().m6450a()) == null) {
            return;
        }
        if ((clientLevel.clip(new ClipContext(vec3, vec4, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, livingEntity)).getType() == HitResult.Type.MISS) && randomSource.nextFloat() < 0.2f && (iDistanceTo = (int) vec3.distanceTo(vec5)) <= 6) {
            int i = 6 - iDistanceTo;
            for (int i2 = 0; i2 < i; i2++) {
                C0194cv.f1564y.add(new C0191cs.b(random, aVarM6450a));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m251a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Random random, @NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2, @NotNull Vec3 vec3, @NotNull Direction direction, boolean z) {
        float fNextFloat = 0.9f + (randomSource.nextFloat() * 0.2f);
        Vec3 vec3Position = livingEntity2.position();
        Vec3 eyePosition = livingEntity.getEyePosition();
        float fDistanceTo = (float) eyePosition.distanceTo(vec3);
        if (fDistanceTo >= 128.0f) {
            return;
        }
        if (z) {
            clientLevel.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1312xz.f8241uC.get(), SoundSource.BLOCKS, 1.5f, fNextFloat, false);
            clientLevel.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1312xz.f8243uE.get(), SoundSource.BLOCKS, 1.5f, fNextFloat, false);
        } else {
            clientLevel.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1312xz.f8240uB.get(), SoundSource.BLOCKS, 1.5f, fNextFloat, false);
        }
        clientLevel.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1312xz.f8245uG.get(), SoundSource.BLOCKS, 1.5f, 1.0f, false);
        if (fDistanceTo <= 16.0f) {
            clientLevel.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1312xz.f8244uF.get(), SoundSource.BLOCKS, 1.0f - (fDistanceTo / 16.0f), fNextFloat, false);
        }
        if (C0495ie.f3043w.m2230U()) {
            SimpleParticleType simpleParticleType = (SimpleParticleType) C1309xw.f7853np.get();
            int i = z ? 2 : 1;
            for (int i2 = 0; i2 < i; i2++) {
                C0490iZ.m2218a(minecraft, c0623l, clientLevel, simpleParticleType, vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
            }
            C0490iZ.m2219a(minecraft, c0623l, clientLevel, vec3, direction, (ParticleOptions) C1309xw.f7877nN.get(), -0.45f);
            if (randomSource.nextFloat() < 0.75f && Mth.sqrt((float) eyePosition.distanceToSqr(vec3)) <= 3.0f) {
                C0194cv.f1564y.add(new C0191cs.b(random, C0191cs.b.a.BLOOD));
            }
        }
        if (randomSource.nextBoolean()) {
            C0490iZ.m2219a(minecraft, c0623l, clientLevel, vec3, direction, (ParticleOptions) C1309xw.f7886nW.get(), 0.1f);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m252a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull C1114uM c1114uM, @NotNull Vec3 vec3, @NotNull RandomSource randomSource) {
        C1126uY c1126uYM6426a;
        if (randomSource.nextFloat() <= 0.5f && (c1126uYM6426a = C1292xf.m7328a(clientLevel, clientLevel.getBlockState(c1114uM.m6243a()), c1114uM.m6243a()).m6426a()) != null && c1126uYM6426a.m6451cP()) {
            Vec3 vec3M6245A = c1114uM.m6245A();
            clientLevel.playLocalSound(vec3M6245A.x, vec3M6245A.y, vec3M6245A.z, (SoundEvent) C1312xz.f8223uk.get(), SoundSource.BLOCKS, 1.5f, 0.95f + (0.2f * randomSource.nextFloat()), false);
            LocalPlayer localPlayer = minecraft.player;
            if (localPlayer != null && localPlayer.position().distanceTo(vec3M6245A) <= f400I) {
                Vec3 vec3AtLowerCornerOf = Vec3.atLowerCornerOf(c1114uM.m6244b().getNormal());
                Vec3 vec3Normalize = vec3M6245A.subtract(vec3).normalize();
                Vec3 vec3Normalize2 = vec3Normalize.subtract(vec3AtLowerCornerOf.scale(2.0d * vec3Normalize.dot(vec3AtLowerCornerOf))).normalize().add(new Vec3(Mth.nextFloat(randomSource, -0.35f, 0.35f), Mth.nextFloat(randomSource, -0.35f, 0.35f), Mth.nextFloat(randomSource, -0.35f, 0.35f))).normalize();
                Vec3 vec3Add = vec3M6245A.add(vec3AtLowerCornerOf.scale(0.05d));
                BlockHitResult blockHitResultClip = clientLevel.clip(new ClipContext(vec3Add, vec3Add.add(vec3Normalize2.scale(64.0d)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, localPlayer));
                Vec3 location = blockHitResultClip.getLocation();
                if (vec3Add.distanceTo(location) < f395H) {
                    return;
                }
                boolean z = blockHitResultClip.getType() == HitResult.Type.BLOCK;
                if (minecraft.getDebugOverlay().showDebugScreen()) {
                    C0111bb.f718j.add(new C0057aa(vec3Add, location, 200, true, z ? f398bR : f399bS));
                }
                minecraft.getSoundManager().play(new C0471iG(z ? (SoundEvent) C1312xz.f8258uT.get() : (SoundEvent) C1312xz.f8257uS.get(), SoundSource.BLOCKS, vec3Add, location, 20, 0.9f + (randomSource.nextFloat() * 0.2f)));
            }
        }
    }
}
