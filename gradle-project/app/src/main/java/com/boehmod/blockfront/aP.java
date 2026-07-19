package com.boehmod.blockfront;

import com.boehmod.blockfront.C0066cj;
import com.boehmod.blockfront.C0565uy;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aP.class */
public final class aP {
    private static final float aR = 0.2f;
    private static final float aS = 16.0f;
    private static final int aV = 128;
    private static final float aT = 0.75f;
    private static final float aU = 3.0f;
    private static final int aW = 2;
    private static final int aX = 1;
    private static final int aY = 6;
    private static final int aZ = 32;

    /* JADX INFO: renamed from: aV, reason: collision with other field name */
    private static final float f35aV = 16.0f;

    /* JADX INFO: renamed from: aW, reason: collision with other field name */
    private static final float f36aW = 0.1f;

    /* JADX INFO: renamed from: aX, reason: collision with other field name */
    public static final float f37aX = 1.5f;

    /* JADX INFO: renamed from: aY, reason: collision with other field name */
    public static final float f38aY = 6.0f;

    /* JADX INFO: renamed from: aZ, reason: collision with other field name */
    private static final float f39aZ = 0.5f;
    private static final float ba = 64.0f;
    private static final double A = 10.0d;

    /* JADX INFO: renamed from: ba, reason: collision with other field name */
    private static final int f40ba = 20;
    private static final float bb = 0.35f;

    /* JADX INFO: renamed from: bb, reason: collision with other field name */
    private static final int f41bb = -30720;
    private static final int bc = -16711681;
    private static final double B = 16.0d;

    public static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @Nullable LivingEntity livingEntity, @NotNull C0555uo c0555uo, int i) {
        Vec3 vec3Z = c0555uo.z();
        Entity cameraEntity = minecraft.getCameraEntity();
        boolean z = true;
        if (cameraEntity != null) {
            int iDistanceTo = (int) cameraEntity.position().distanceTo(vec3Z);
            if (iDistanceTo > 128) {
                return;
            } else {
                z = iDistanceTo <= 32;
            }
        }
        Direction directionB = c0555uo.b();
        BlockPos blockPosA = c0555uo.a();
        BlockState blockState = clientLevel.getBlockState(blockPosA);
        SoundType soundType = blockState.getSoundType(clientLevel, blockPosA, localPlayer);
        kE block = blockState.getBlock();
        ItemStack mainHandItem = ItemStack.EMPTY;
        C0558ur c0558ur = null;
        if (livingEntity != null) {
            mainHandItem = livingEntity.getMainHandItem();
            Item item = mainHandItem.getItem();
            c0558ur = item instanceof C0558ur ? (C0558ur) item : null;
        }
        uK uKVarM1217a = c0558ur != null ? c0558ur.m1217a() : uL.b;
        C0563uw c0563uwA = wI.a(clientLevel, blockState, blockPosA);
        if (blockState.isAir()) {
            return;
        }
        if (soundType == SoundType.EMPTY && c0563uwA.m1232a() == null) {
            return;
        }
        if (z && soundType != SoundType.EMPTY) {
            clientLevel.playLocalSound(blockPosA.getX(), blockPosA.getY(), blockPosA.getZ(), soundType.getBreakSound(), SoundSource.BLOCKS, 1.0f, 1.0f, false);
        }
        C0565uy c0565uyM1232a = c0563uwA.m1232a();
        Vec3 vec3Add = new Vec3(blockPosA.getX(), blockPosA.getY(), blockPosA.getZ()).add(0.5d, 0.5d, 0.5d);
        boolean z2 = (block instanceof kE) || !(block instanceof InterfaceC0320lw);
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (block instanceof kE) {
            block.a(minecraft, c0297l, clientLevel, i, vec3Z, blockPosA, blockState, directionB);
        }
        if (c0565uyM1232a != null && z) {
            a(clientLevel, c0565uyM1232a, vec3Add, threadLocalRandomCurrent);
        }
        if (z2) {
            Vec3 eyePosition = localPlayer.getEyePosition();
            if (z && c0558ur != null) {
                a(clientLevel, c0558ur, mainHandItem, vec3Add, vec3Z, eyePosition, threadLocalRandomCurrent);
            }
            a(clientLevel, (LivingEntity) localPlayer, c0563uwA, eyePosition, vec3Z, randomSource, (Random) threadLocalRandomCurrent, vec3Add);
            if (c0565uyM1232a != null) {
                if (c0565uyM1232a.cH()) {
                    iG.a(minecraft, c0297l, clientLevel, blockPosA, vec3Z, directionB, blockState, 1.0f);
                }
                if (c0565uyM1232a.cI() && hN.H.T() && (!(block instanceof kE) || block.ak())) {
                    iG.a(minecraft, c0297l, clientLevel, (SimpleParticleType) uKVarM1217a.q().get(), vec3Z.x, vec3Z.y, vec3Z.z, directionB.ordinal(), 0.0d, 0.0d);
                }
                List<C0565uy.a> listAI = c0565uyM1232a.aI();
                for (C0565uy.a aVar : listAI) {
                    ParticleOptions particleOptionsA = aVar.a();
                    int iCd = aVar.cd();
                    for (int i2 = 0; i2 < iCd; i2++) {
                        iG.a(minecraft, c0297l, clientLevel, vec3Z.add(Mth.nextFloat(randomSource, -0.1f, 0.1f), Mth.nextFloat(randomSource, -0.1f, 0.1f), Mth.nextFloat(randomSource, -0.1f, 0.1f)), directionB, particleOptionsA, 0.45f, 0.1f);
                    }
                }
                if (iM.dk && !listAI.isEmpty()) {
                    iG.a(minecraft, c0297l, clientLevel, vec3Z.add(Mth.nextFloat(randomSource, -0.1f, 0.1f), Mth.nextFloat(randomSource, -0.1f, 0.1f), Mth.nextFloat(randomSource, -0.1f, 0.1f)), directionB, (ParticleOptions) wZ.nH.get(), 0.45f, 0.1f);
                }
                for (C0565uy.a aVar2 : c0565uyM1232a.aH()) {
                    ParticleOptions particleOptionsA2 = aVar2.a();
                    int iCd2 = aVar2.cd();
                    for (int i3 = 0; i3 < iCd2; i3++) {
                        iG.a(minecraft, c0297l, clientLevel, particleOptionsA2, vec3Z.x, vec3Z.y, vec3Z.z, 0.0d, 0.0d, 0.0d);
                    }
                }
                iG.a(minecraft, c0297l, clientLevel, vec3Z, directionB, (ParticleOptions) uKVarM1217a.p().get(), 0.0f, 0.25f);
            }
        }
    }

    private static void a(@NotNull ClientLevel clientLevel, @NotNull C0565uy c0565uy, @NotNull Vec3 vec3, @NotNull ThreadLocalRandom threadLocalRandom) {
        if (c0565uy.cG()) {
            clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) C0624xc.uk.get(), SoundSource.BLOCKS, 1.5f, 0.95f + (0.2f * threadLocalRandom.nextFloat()), false);
            LocalPlayer localPlayer = Minecraft.getInstance().player;
            if (localPlayer != null) {
                float fDistanceTo = (float) localPlayer.position().distanceTo(vec3);
                if (fDistanceTo <= 6.0f) {
                    clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) C0624xc.ul.get(), SoundSource.BLOCKS, 1.0f - (fDistanceTo / 6.0f), 1.0f, false);
                }
            }
        }
        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, c0565uy.B(), SoundSource.BLOCKS, 1.5f, 0.8f + (0.1f * threadLocalRandom.nextInt(4)), false);
        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, c0565uy.C(), SoundSource.BLOCKS, 1.5f, 0.8f + (0.1f * threadLocalRandom.nextInt(4)), false);
    }

    private static void a(@NotNull ClientLevel clientLevel, @NotNull C0558ur c0558ur, @NotNull ItemStack itemStack, @NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Vec3 vec33, @NotNull ThreadLocalRandom threadLocalRandom) {
        uR uRVarM1221a = c0558ur.m1221a(itemStack);
        if (uRVarM1221a != null) {
            float fNextFloat = 0.95f + (0.1f * threadLocalRandom.nextFloat());
            if (threadLocalRandom.nextFloat() < uRVarM1221a.bI()) {
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderU = uRVarM1221a.U();
                if (deferredHolderU != null) {
                    clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) deferredHolderU.get(), SoundSource.BLOCKS, 1.5f, fNextFloat, false);
                }
                DeferredHolder<SoundEvent, SoundEvent> deferredHolderV = uRVarM1221a.V();
                if (deferredHolderV != null) {
                    float fDistanceTo = (float) vec33.distanceTo(vec32);
                    if (fDistanceTo <= 16.0f) {
                        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) deferredHolderV.get(), SoundSource.BLOCKS, 1.0f - (fDistanceTo / 16.0f), fNextFloat, false);
                    }
                }
            }
        }
    }

    private static void a(@NotNull ClientLevel clientLevel, @NotNull LivingEntity livingEntity, @Nullable C0563uw c0563uw, @NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull RandomSource randomSource, @NotNull Random random, @NotNull Vec3 vec33) {
        C0066cj.b.a aVarA;
        int iDistanceTo;
        if (c0563uw == null || c0563uw.m1232a() == null || (aVarA = c0563uw.m1232a().a()) == null) {
            return;
        }
        if ((clientLevel.clip(new ClipContext(vec3, vec32, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, livingEntity)).getType() == HitResult.Type.MISS) && aVarA != null && randomSource.nextFloat() < 0.2f && (iDistanceTo = (int) vec3.distanceTo(vec33)) <= 6) {
            int i = 6 - iDistanceTo;
            for (int i2 = 0; i2 < i; i2++) {
                C0069cm.p.add(new C0066cj.b(random, aVarA));
            }
        }
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Random random, @NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2, @NotNull Vec3 vec3, @NotNull Direction direction, boolean z) {
        float fNextFloat = 0.9f + (randomSource.nextFloat() * 0.2f);
        Vec3 vec3Position = livingEntity2.position();
        Vec3 eyePosition = livingEntity.getEyePosition();
        float fDistanceTo = (float) eyePosition.distanceTo(vec3);
        if (fDistanceTo >= 128.0f) {
            return;
        }
        if (z) {
            clientLevel.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C0624xc.uz.get(), SoundSource.BLOCKS, 1.5f, fNextFloat, false);
            clientLevel.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C0624xc.uB.get(), SoundSource.BLOCKS, 1.5f, fNextFloat, false);
        } else {
            clientLevel.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C0624xc.uy.get(), SoundSource.BLOCKS, 1.5f, fNextFloat, false);
        }
        clientLevel.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C0624xc.uD.get(), SoundSource.BLOCKS, 1.5f, 1.0f, false);
        if (fDistanceTo <= 16.0f) {
            clientLevel.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C0624xc.uC.get(), SoundSource.BLOCKS, 1.0f - (fDistanceTo / 16.0f), fNextFloat, false);
        }
        if (hN.w.T()) {
            SimpleParticleType simpleParticleType = (SimpleParticleType) wZ.np.get();
            int i = z ? 2 : 1;
            for (int i2 = 0; i2 < i; i2++) {
                iG.a(minecraft, c0297l, clientLevel, simpleParticleType, vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
            }
            iG.a(minecraft, c0297l, clientLevel, vec3, direction, (ParticleOptions) wZ.nN.get(), -0.45f);
            if (randomSource.nextFloat() < 0.75f && Mth.sqrt((float) eyePosition.distanceToSqr(vec3)) <= 3.0f) {
                C0069cm.p.add(new C0066cj.b(random, C0066cj.b.a.BLOOD));
            }
        }
        if (randomSource.nextBoolean()) {
            iG.a(minecraft, c0297l, clientLevel, vec3, direction, (ParticleOptions) wZ.nW.get(), 0.1f);
        }
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull C0555uo c0555uo, @NotNull Vec3 vec3, @NotNull RandomSource randomSource) {
        C0565uy c0565uyM1232a;
        if (randomSource.nextFloat() <= 0.5f && (c0565uyM1232a = wI.a(clientLevel, clientLevel.getBlockState(c0555uo.a()), c0555uo.a()).m1232a()) != null && c0565uyM1232a.cG()) {
            Vec3 vec3Z = c0555uo.z();
            clientLevel.playLocalSound(vec3Z.x, vec3Z.y, vec3Z.z, (SoundEvent) C0624xc.uj.get(), SoundSource.BLOCKS, 1.5f, 0.95f + (0.2f * randomSource.nextFloat()), false);
            LocalPlayer localPlayer = minecraft.player;
            if (localPlayer != null && localPlayer.position().distanceTo(vec3Z) <= B) {
                Vec3 vec3AtLowerCornerOf = Vec3.atLowerCornerOf(c0555uo.b().getNormal());
                Vec3 vec3Normalize = vec3Z.subtract(vec3).normalize();
                Vec3 vec3Normalize2 = vec3Normalize.subtract(vec3AtLowerCornerOf.scale(2.0d * vec3Normalize.dot(vec3AtLowerCornerOf))).normalize().add(new Vec3(Mth.nextFloat(randomSource, -0.35f, 0.35f), Mth.nextFloat(randomSource, -0.35f, 0.35f), Mth.nextFloat(randomSource, -0.35f, 0.35f))).normalize();
                Vec3 vec3Add = vec3Z.add(vec3AtLowerCornerOf.scale(0.05d));
                BlockHitResult blockHitResultClip = clientLevel.clip(new ClipContext(vec3Add, vec3Add.add(vec3Normalize2.scale(64.0d)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, localPlayer));
                Vec3 location = blockHitResultClip.getLocation();
                if (vec3Add.distanceTo(location) < A) {
                    return;
                }
                boolean z = blockHitResultClip.getType() == HitResult.Type.BLOCK;
                if (minecraft.getDebugOverlay().showDebugScreen()) {
                    aT.i.add(new U(vec3Add, location, 200, true, z ? f41bb : bc));
                }
                minecraft.getSoundManager().play(new C0232ip(z ? (SoundEvent) C0624xc.uQ.get() : (SoundEvent) C0624xc.uP.get(), SoundSource.BLOCKS, vec3Add, location, 20, 0.9f + (randomSource.nextFloat() * 0.2f)));
            }
        }
    }
}
