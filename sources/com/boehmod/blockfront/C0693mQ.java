package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import foundry.veil.api.client.render.light.data.PointLightData;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mQ.class */
public class C0693mQ {

    /* JADX INFO: renamed from: mA */
    private static final int f3833mA = 256;

    /* JADX INFO: renamed from: mB */
    private static final int f3834mB = 16;

    /* JADX INFO: renamed from: mC */
    private static final int f3835mC = 10;

    /* JADX INFO: renamed from: mD */
    private static final int f3836mD = 4;

    /* JADX INFO: renamed from: mE */
    private static final int f3837mE = 4;

    /* JADX INFO: renamed from: jl */
    private static final float f3838jl = 1.0f;

    /* JADX INFO: renamed from: jm */
    private static final float f3839jm = 10.0f;

    /* JADX INFO: renamed from: jn */
    private static final float f3840jn = 5.0f;

    /* JADX INFO: renamed from: mF */
    public static final int f3841mF = 16;

    /* JADX INFO: renamed from: mG */
    public static final int f3842mG = 8;

    /* JADX INFO: renamed from: mH */
    private static final int f3843mH = 8;

    /* JADX INFO: renamed from: jo */
    private static final float f3844jo = 2.5f;

    /* JADX INFO: renamed from: mI */
    private static final int f3845mI = 2;

    /* JADX INFO: renamed from: mJ */
    private static final int f3846mJ = 1;

    /* JADX INFO: renamed from: ap */
    private static final double f3847ap = 1.5d;

    /* JADX INFO: renamed from: aq */
    private static final double f3848aq = 2.5d;

    /* JADX INFO: renamed from: ar */
    private static final double f3849ar = 3.5d;

    /* JADX INFO: renamed from: eN */
    static final /* synthetic */ boolean f3850eN;

    static {
        f3850eN = !C0693mQ.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: b */
    public static void m3102b(@NotNull String str, @NotNull Vec3 vec3) {
        C0623l c0623lM2852b;
        String[] strArrSplit = str.substring(10, str.length() - 2).split(",");
        if (strArrSplit.length != 4) {
            return;
        }
        try {
            EnumC0862pa enumC0862paValueOf = EnumC0862pa.valueOf(strArrSplit[0].trim());
            float f = Float.parseFloat(strArrSplit[1].trim());
            float f2 = Float.parseFloat(strArrSplit[2].trim());
            float f3 = Float.parseFloat(strArrSplit[3].trim());
            Minecraft minecraft = Minecraft.getInstance();
            ClientLevel clientLevel = minecraft.level;
            if (clientLevel == null || (c0623lM2852b = C0623l.m2852b()) == null) {
                return;
            }
            m3103a(minecraft, c0623lM2852b, clientLevel, enumC0862paValueOf, vec3.add(f, f2, f3));
        } catch (IllegalArgumentException e) {
            C0530jM.logError("Failed to parse explosion instruction: " + str, new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3103a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull EnumC0862pa enumC0862pa, @NotNull Vec3 vec3) {
        int i;
        LocalPlayer localPlayer = minecraft.player;
        if (!f3850eN && localPlayer == null) {
            throw new AssertionError();
        }
        float fSqrt = Mth.sqrt((float) localPlayer.distanceToSqr(vec3));
        if (fSqrt > 256.0f) {
            return;
        }
        BlockPos blockPosContaining = BlockPos.containing(vec3);
        RandomSource randomSourceCreate = RandomSource.create();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Vec3 eyePosition = localPlayer.getEyePosition();
        boolean zM4351a = C0875pn.m4351a((BlockAndTintGetter) clientLevel, blockPosContaining);
        C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7858nu.get(), vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
        boolean zUseFancyGraphics = Minecraft.useFancyGraphics();
        if (enumC0862pa == EnumC0862pa.GORE_EXPLOSION) {
            m3109a(minecraft, c0623l, clientLevel, vec3, zUseFancyGraphics);
        } else {
            blockPosContaining.below();
            m3110a(minecraft, c0623l, clientLevel, clientLevel.getBlockState(blockPosContaining).isAir(), vec3, enumC0862pa);
            C0401gq.m1906a(new PointLightData().setPosition(vec3.x, vec3.y, vec3.z).setBrightness(6.0f).setRadius(16.0f).setColor(ColorReferences.COLOR_BULLET_TRACER), 0);
            C0401gq.m1906a(new PointLightData().setPosition(vec3.x, vec3.y, vec3.z).setBrightness(8.0f).setRadius(6.0f).setColor(ColorReferences.COLOR_BULLET_TRACER), 0);
        }
        C0191cs.b.a aVar = C0191cs.b.a.DIRT;
        if (enumC0862pa.shouldDisplayBlockDamage() && zUseFancyGraphics) {
            m3112a(clientLevel, vec3, enumC0862pa.getBlockDamageMotion(), threadLocalRandomCurrent, enumC0862pa.getBlockDamageRadius());
        }
        if ((clientLevel.clip(new ClipContext(eyePosition, vec3, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, localPlayer)).getType() == HitResult.Type.MISS) && (i = (int) fSqrt) <= 10) {
            int i2 = 10 - i;
            for (int i3 = 0; i3 < i2; i3++) {
                C0194cv.f1564y.add(new C0191cs.b(threadLocalRandomCurrent, aVar));
            }
        }
        boolean z = false;
        float maxDistance = enumC0862pa.getMaxDistance();
        C0434hW shakeNodeData = enumC0862pa.getShakeNodeData();
        if (shakeNodeData != null) {
            C0432hU.m1989a(shakeNodeData, localPlayer, vec3, maxDistance);
        }
        C0434hW shakeNodeFaintData = enumC0862pa.getShakeNodeFaintData();
        if (shakeNodeFaintData != null) {
            C0432hU.m1989a(shakeNodeFaintData, localPlayer, vec3, maxDistance * 3.0f);
        }
        if (fSqrt <= maxDistance) {
            z = true;
        }
        C0807oY audioConfig = enumC0862pa.getAudioConfig();
        if (enumC0862pa == EnumC0862pa.VEHICLE_EXPLOSION) {
            clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) C1312xz.f8063rg.get(), SoundSource.AMBIENT, 10.0f, 1.0f, false);
        }
        if (enumC0862pa == EnumC0862pa.GORE_EXPLOSION) {
            m3108a(clientLevel, vec3, threadLocalRandomCurrent);
        } else {
            m3105a(minecraft, vec3, audioConfig, randomSourceCreate, z, zM4351a);
            m3106a(clientLevel, blockPosContaining, threadLocalRandomCurrent);
            m3104a((Level) clientLevel, vec3);
        }
        if (enumC0862pa.emitsLight()) {
            C0401gq.m1906a(new PointLightData().setPosition(vec3.x, vec3.y, vec3.z).setBrightness(enumC0862pa.getLightBrightness()).setRadius(enumC0862pa.getLightRadius()).setColor(ColorReferences.COLOR_WHITE), 1);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3104a(@NotNull Level level, @NotNull Vec3 vec3) {
        for (AbstractC0750nU abstractC0750nU : level.getEntitiesOfClass(AbstractC0750nU.class, AABB.ofSize(vec3, 16.0d, 16.0d, 16.0d))) {
            if (level.clip(new ClipContext(abstractC0750nU.position(), vec3, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, abstractC0750nU)).getType().equals(HitResult.Type.MISS)) {
                Vec3 vec3Position = abstractC0750nU.position();
                level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1312xz.f8819FI.get(), SoundSource.AMBIENT, 5.0f, 1.0f, false);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3105a(@NotNull Minecraft minecraft, @NotNull Vec3 vec3, @NotNull C0807oY c0807oY, @NotNull RandomSource randomSource, boolean z, boolean z2) {
        SoundManager soundManager = minecraft.getSoundManager();
        if (!z2) {
            soundManager.playDelayed(new SimpleSoundInstance((SoundEvent) c0807oY.f4367aT.get(), SoundSource.AMBIENT, 6.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z), 2);
        }
        SoundInstance simpleSoundInstance = new SimpleSoundInstance(z2 ? (SoundEvent) c0807oY.f4363aP.get() : (SoundEvent) c0807oY.f4362aO.get(), SoundSource.AMBIENT, 5.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
        SimpleSoundInstance simpleSoundInstance2 = new SimpleSoundInstance((SoundEvent) c0807oY.f4364aQ.get(), SoundSource.AMBIENT, 5.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
        soundManager.playDelayed(z ? simpleSoundInstance : new SimpleSoundInstance(z2 ? (SoundEvent) c0807oY.f4366aS.get() : (SoundEvent) c0807oY.f4365aR.get(), SoundSource.AMBIENT, 10.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z), 2);
        if (!z2 && z) {
            soundManager.playDelayed(simpleSoundInstance2, 6);
        }
        SoundInstance simpleSoundInstance3 = new SimpleSoundInstance((SoundEvent) c0807oY.f4356aI.get(), SoundSource.AMBIENT, 5.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
        SoundInstance simpleSoundInstance4 = new SimpleSoundInstance((SoundEvent) c0807oY.f4360aM.get(), SoundSource.AMBIENT, 5.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
        SoundInstance simpleSoundInstance5 = new SimpleSoundInstance((SoundEvent) c0807oY.f4357aJ.get(), SoundSource.AMBIENT, 10.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
        soundManager.playDelayed(z2 ? z ? simpleSoundInstance4 : new SimpleSoundInstance((SoundEvent) c0807oY.f4361aN.get(), SoundSource.AMBIENT, 10.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z) : z ? simpleSoundInstance3 : simpleSoundInstance5, 2);
        SoundInstance simpleSoundInstance6 = new SimpleSoundInstance((SoundEvent) c0807oY.f4358aK.get(), SoundSource.AMBIENT, 5.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
        SoundInstance simpleSoundInstance7 = new SimpleSoundInstance((SoundEvent) c0807oY.f4359aL.get(), SoundSource.AMBIENT, 10.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
        for (int i = 0; i < 3; i++) {
            soundManager.playDelayed(z ? simpleSoundInstance6 : simpleSoundInstance7, 2);
        }
        soundManager.playDelayed(new SimpleSoundInstance(z2 ? (SoundEvent) C1312xz.f8812FB.get() : (SoundEvent) C1312xz.f8811FA.get(), SoundSource.AMBIENT, 1.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z), 2);
    }

    /* JADX INFO: renamed from: a */
    private static void m3106a(@NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos, @NotNull Random random) {
        ObjectArrayList<a> objectArrayList = new ObjectArrayList();
        for (int i = -4; i < 4; i++) {
            for (int i2 = -4; i2 < 4; i2++) {
                for (int i3 = -4; i3 < 4; i3++) {
                    BlockPos blockPosOffset = blockPos.offset(i, i2, i3);
                    BlockState blockState = clientLevel.getBlockState(blockPosOffset);
                    if (!blockState.isAir() && m3107a(clientLevel, blockPosOffset)) {
                        C1126uY c1126uYM6426a = C1292xf.m7328a(clientLevel, blockState, blockPosOffset).m6426a();
                        SoundEvent soundEventM6445E = null;
                        if (c1126uYM6426a != null) {
                            soundEventM6445E = c1126uYM6426a.m6445E();
                        }
                        if (soundEventM6445E == null && random.nextFloat() < 0.1f) {
                            soundEventM6445E = (SoundEvent) C1312xz.f8814FD.get();
                        }
                        if (soundEventM6445E != null) {
                            objectArrayList.add(new a(blockPosOffset, soundEventM6445E));
                        }
                    }
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (a aVar : objectArrayList) {
            ((List) linkedHashMap.computeIfAbsent(aVar.f3852a, soundEvent -> {
                return new ObjectArrayList();
            })).add(aVar);
        }
        ObjectArrayList<a> objectArrayList2 = new ObjectArrayList();
        ObjectArrayList objectArrayList3 = new ObjectArrayList();
        for (List list : linkedHashMap.values()) {
            int iNextInt = random.nextInt(list.size());
            objectArrayList2.add((a) list.get(iNextInt));
            for (int i4 = 0; i4 < list.size(); i4++) {
                if (i4 != iNextInt) {
                    objectArrayList3.add((a) list.get(i4));
                }
            }
        }
        while (objectArrayList2.size() > 4) {
            objectArrayList2.remove(random.nextInt(objectArrayList2.size()));
        }
        while (objectArrayList2.size() < 4 && !objectArrayList3.isEmpty()) {
            objectArrayList2.add((a) objectArrayList3.remove(random.nextInt(objectArrayList3.size())));
        }
        for (a aVar2 : objectArrayList2) {
            Vec3 center = aVar2.f3851b.getCenter();
            clientLevel.playLocalSound(center.x, center.y, center.z, aVar2.f3852a, SoundSource.AMBIENT, 1.0f, 0.8f + (0.4f * random.nextFloat()), false);
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3107a(@NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos) {
        for (int i = -1; i < 2; i++) {
            for (int i2 = -1; i2 < 2; i2++) {
                for (int i3 = -1; i3 < 2; i3++) {
                    if (clientLevel.getBlockState(blockPos.offset(i, i2, i3)).isAir()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private static void m3108a(@NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, @NotNull Random random) {
        SoundEvent soundEvent = (SoundEvent) C1312xz.f7932oF.get();
        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, soundEvent, SoundSource.AMBIENT, 5.0f, 1.0f, false);
        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, soundEvent, SoundSource.AMBIENT, 5.0f, 0.5f, false);
        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) C1312xz.f7933oG.get(), SoundSource.AMBIENT, 5.0f, 0.85f + (0.2f * random.nextFloat()), false);
    }

    /* JADX INFO: renamed from: a */
    private static void m3109a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, boolean z) {
        if (C0495ie.f3043w.m2230U()) {
            C0490iZ.m2216a(minecraft, c0623l, clientLevel, (ParticleOptions) C1309xw.f7853np.get(), vec3, 0.0f, 1.0f, z ? 16 : 8, 0.1f);
            C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7877nN.get(), vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3110a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, boolean z, @NotNull Vec3 vec3, @NotNull EnumC0862pa enumC0862pa) {
        float power = enumC0862pa.getPower();
        int i = (int) (5.0f * power);
        float f = 2.0f * power;
        ParticleOptions[] particleOptionsArr = {(ParticleOptions) C1309xw.f7886nW.get(), ParticleTypes.CLOUD};
        float[] fArr = {0.2f, 0.2f};
        int length = particleOptionsArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            ParticleOptions particleOptions = particleOptionsArr[i2];
            float f2 = fArr[i2];
            if (z) {
                C0490iZ.m2216a(minecraft, c0623l, clientLevel, particleOptions, vec3, 1.0f, f, i, f2);
            } else {
                C0490iZ.m2217b(minecraft, c0623l, clientLevel, particleOptions, vec3, 1.0f, f, i, f2);
            }
        }
        m3111a(minecraft, c0623l, clientLevel, vec3, power);
    }

    /* JADX INFO: renamed from: a */
    private static void m3111a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, float f) {
        RandomSource randomSource = clientLevel.random;
        float f2 = 2.5f * f;
        int i = (int) (8.0f * f);
        int i2 = Minecraft.useFancyGraphics() ? 2 : 1;
        for (int i3 = 0; i3 < i; i3++) {
            double dNextDouble = 6.283185307179586d * randomSource.nextDouble();
            double dAcos = Math.acos((2.0d * randomSource.nextDouble()) - 1.0d);
            Vec3 vec4 = new Vec3(Math.sin(dAcos) * Math.cos(dNextDouble), Math.cos(dAcos), Math.sin(dAcos) * Math.sin(dNextDouble));
            BlockHitResult blockHitResultClip = clientLevel.clip(new ClipContext(vec3, vec3.add(vec4.scale(f2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, CollisionContext.empty()));
            double dDistanceTo = blockHitResultClip.getType() == HitResult.Type.MISS ? f2 : blockHitResultClip.getLocation().distanceTo(vec3);
            for (int i4 = 0; i4 < i2; i4++) {
                double dNextDouble2 = dDistanceTo * randomSource.nextDouble();
                double dNextDouble3 = (0.5d / ((dNextDouble2 / ((double) f)) + 0.1d)) * ((randomSource.nextDouble() * randomSource.nextDouble()) + 0.3d);
                Vec3 vec3Scale = vec4.scale(Math.min(dNextDouble3 * f3848aq, f3849ar));
                Vec3 vec3Scale2 = vec4.scale(Math.min(dNextDouble3, 1.5d));
                Vec3 vec3Add = vec3.add(vec4.scale(dNextDouble2 * 0.5d));
                Vec3 vec3Add2 = vec3.add(vec4.scale(dNextDouble2));
                C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7887nX.get(), vec3Add.x, vec3Add.y, vec3Add.z, vec3Scale.x, vec3Scale.y, vec3Scale.z);
                C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7888nY.get(), vec3Add2.x, vec3Add2.y, vec3Add2.z, vec3Scale2.x, vec3Scale2.y, vec3Scale2.z);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3112a(@NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, @NotNull Vec2 vec2, Random random, int i) {
        float f = vec2.x;
        float f2 = vec2.y;
        for (int i2 = -i; i2 < i; i2++) {
            for (int i3 = -i; i3 < i; i3++) {
                for (int i4 = -i; i4 < i; i4++) {
                    BlockPos blockPosOffset = BlockPos.containing(vec3).offset(i2, i3 - i, i4);
                    BlockState blockState = clientLevel.getBlockState(blockPosOffset);
                    BlockPos blockPosOffset2 = blockPosOffset.offset(0, 1, 0);
                    BlockState blockState2 = clientLevel.getBlockState(blockPosOffset2);
                    int i5 = 0;
                    while (!blockState2.isAir() && i5 < i) {
                        i5++;
                        blockPosOffset2 = blockPosOffset2.offset(0, 1, 0);
                        blockState2 = clientLevel.getBlockState(blockPosOffset2);
                    }
                    if (blockState.canOcclude() && !blockState.isAir() && !blockState.getFluidState().is(FluidTags.WATER) && !blockState.getFluidState().is(FluidTags.LAVA) && blockState2.isAir()) {
                        double dNextDouble = ((double) f) + (random.nextDouble() * ((double) (f2 - f)));
                        double dNextDouble2 = ((double) f) + (random.nextDouble() * ((double) (f2 - f)));
                        double dNextDouble3 = ((double) f) + (random.nextDouble() * ((double) (f2 - f)));
                        double d = dNextDouble2 * 0.1d;
                        double d2 = dNextDouble3 * 0.1d;
                        double d3 = d * ((double) i2);
                        double d4 = d2 * ((double) i4);
                        boolean zNextBoolean = random.nextBoolean();
                        boolean zNextBoolean2 = random.nextBoolean();
                        BlockPos blockPosOffset3 = blockPosOffset2.offset(0, 1, 0);
                        if (clientLevel.getBlockState(blockPosOffset3).isAir()) {
                            FallingBlockEntity fallingBlockEntityFall = FallingBlockEntity.fall(clientLevel, blockPosOffset3, blockState);
                            fallingBlockEntityFall.disableDrop();
                            fallingBlockEntityFall.dropItem = false;
                            fallingBlockEntityFall.fallDistance = 5.0f;
                            fallingBlockEntityFall.setDeltaMovement(zNextBoolean ? -d3 : d3, dNextDouble, zNextBoolean2 ? -d4 : d4);
                            fallingBlockEntityFall.setHurtsEntities(0.0f, 0);
                            C0490iZ.m2213a((Entity) fallingBlockEntityFall, clientLevel);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.mQ$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mQ$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: b */
        private final BlockPos f3851b;

        /* JADX INFO: renamed from: a */
        private final SoundEvent f3852a;

        private a(BlockPos blockPos, SoundEvent soundEvent) {
            this.f3851b = blockPos;
            this.f3852a = soundEvent;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "blockPos;soundEvent", "FIELD:Lcom/boehmod/blockfront/mQ$a;->b:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/mQ$a;->a:Lnet/minecraft/sounds/SoundEvent;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "blockPos;soundEvent", "FIELD:Lcom/boehmod/blockfront/mQ$a;->b:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/mQ$a;->a:Lnet/minecraft/sounds/SoundEvent;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "blockPos;soundEvent", "FIELD:Lcom/boehmod/blockfront/mQ$a;->b:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/mQ$a;->a:Lnet/minecraft/sounds/SoundEvent;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: a */
        public BlockPos m3114a() {
            return this.f3851b;
        }

        /* JADX INFO: renamed from: d */
        public SoundEvent m3115d() {
            return this.f3852a;
        }
    }
}
