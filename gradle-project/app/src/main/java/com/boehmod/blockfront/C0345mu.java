package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0066cj;
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
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mu.class */
public class C0345mu {
    private static final int kF = 256;
    private static final int kG = 16;
    private static final int kH = 10;
    private static final int kI = 4;
    private static final int kJ = 4;
    private static final float it = 1.0f;
    private static final float iu = 10.0f;
    private static final float iv = 5.0f;
    public static final int kK = 16;
    public static final int kL = 8;
    static final /* synthetic */ boolean et;

    static {
        et = !C0345mu.class.desiredAssertionStatus();
    }

    public static void b(@NotNull String str, @NotNull Vec3 vec3) {
        C0297l c0297lB;
        String[] strArrSplit = str.substring(10, str.length() - 2).split(",");
        if (strArrSplit.length != 4) {
            return;
        }
        try {
            oE oEVarValueOf = oE.valueOf(strArrSplit[0].trim());
            float f = Float.parseFloat(strArrSplit[1].trim());
            float f2 = Float.parseFloat(strArrSplit[2].trim());
            float f3 = Float.parseFloat(strArrSplit[3].trim());
            Minecraft minecraft = Minecraft.getInstance();
            ClientLevel clientLevel = minecraft.level;
            if (clientLevel == null || (c0297lB = C0297l.b()) == null) {
                return;
            }
            a(minecraft, c0297lB, clientLevel, oEVarValueOf, vec3.add(f, f2, f3));
        } catch (IllegalArgumentException e) {
            C0263jt.logError("Failed to parse explosion instruction: " + str, new Object[0]);
        }
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull oE oEVar, @NotNull Vec3 vec3) {
        int i;
        LocalPlayer localPlayer = minecraft.player;
        if (!et && localPlayer == null) {
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
        boolean zA = oR.a((BlockAndTintGetter) clientLevel, blockPosContaining);
        iG.a(minecraft, c0297l, clientLevel, (SimpleParticleType) wZ.nu.get(), vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
        boolean zUseFancyGraphics = Minecraft.useFancyGraphics();
        if (oEVar == oE.GORE_EXPLOSION) {
            a(minecraft, c0297l, clientLevel, vec3, zUseFancyGraphics);
        } else {
            blockPosContaining.below();
            a(minecraft, c0297l, clientLevel, clientLevel.getBlockState(blockPosContaining).isAir(), vec3, oEVar);
            C0164ga.a(new PointLightData().setPosition(vec3.x, vec3.y, vec3.z).setBrightness(6.0f).setRadius(16.0f).setColor(ColorReferences.COLOR_BULLET_TRACER), 0);
            C0164ga.a(new PointLightData().setPosition(vec3.x, vec3.y, vec3.z).setBrightness(8.0f).setRadius(6.0f).setColor(ColorReferences.COLOR_BULLET_TRACER), 0);
        }
        C0066cj.b.a aVar = C0066cj.b.a.DIRT;
        if (oEVar.shouldDisplayBlockDamage() && zUseFancyGraphics) {
            a(clientLevel, vec3, oEVar.getBlockDamageMotion(), threadLocalRandomCurrent, oEVar.getBlockDamageRadius());
        }
        if ((clientLevel.clip(new ClipContext(eyePosition, vec3, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, localPlayer)).getType() == HitResult.Type.MISS) && (i = (int) fSqrt) <= 10) {
            int i2 = 10 - i;
            for (int i3 = 0; i3 < i2; i3++) {
                C0069cm.p.add(new C0066cj.b(threadLocalRandomCurrent, aVar));
            }
        }
        boolean z = false;
        float maxDistance = oEVar.getMaxDistance();
        hG shakeNodeData = oEVar.getShakeNodeData();
        if (shakeNodeData != null) {
            hE.a(shakeNodeData, localPlayer, vec3, maxDistance);
        }
        hG shakeNodeFaintData = oEVar.getShakeNodeFaintData();
        if (shakeNodeFaintData != null) {
            hE.a(shakeNodeFaintData, localPlayer, vec3, maxDistance * 3.0f);
        }
        if (fSqrt <= maxDistance) {
            z = true;
        }
        oC audioConfig = oEVar.getAudioConfig();
        if (oEVar == oE.VEHICLE_EXPLOSION) {
            clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) C0624xc.rf.get(), SoundSource.AMBIENT, 10.0f, 1.0f, false);
        }
        if (oEVar == oE.GORE_EXPLOSION) {
            a(clientLevel, vec3, threadLocalRandomCurrent);
        } else {
            a(minecraft, vec3, audioConfig, randomSourceCreate, z, zA);
            a(clientLevel, blockPosContaining, threadLocalRandomCurrent);
            a((Level) clientLevel, vec3);
        }
        if (oEVar.emitsLight()) {
            C0164ga.a(new PointLightData().setPosition(vec3.x, vec3.y, vec3.z).setBrightness(oEVar.getLightBrightness()).setRadius(oEVar.getLightRadius()).setColor(ColorReferences.COLOR_WHITE), 1);
        }
    }

    private static void a(@NotNull Level level, @NotNull Vec3 vec3) {
        for (AbstractC0376ny abstractC0376ny : level.getEntitiesOfClass(AbstractC0376ny.class, AABB.ofSize(vec3, 16.0d, 16.0d, 16.0d))) {
            if (level.clip(new ClipContext(abstractC0376ny.position(), vec3, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, abstractC0376ny)).getType().equals(HitResult.Type.MISS)) {
                Vec3 vec3Position = abstractC0376ny.position();
                level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C0624xc.FE.get(), SoundSource.AMBIENT, 5.0f, 1.0f, false);
            }
        }
    }

    private static void a(@NotNull Minecraft minecraft, @NotNull Vec3 vec3, @NotNull oC oCVar, @NotNull RandomSource randomSource, boolean z, boolean z2) {
        SoundManager soundManager = minecraft.getSoundManager();
        if (!z2) {
            soundManager.playDelayed(new SimpleSoundInstance((SoundEvent) oCVar.aT.get(), SoundSource.AMBIENT, 6.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z), 2);
        }
        SoundInstance simpleSoundInstance = new SimpleSoundInstance(z2 ? (SoundEvent) oCVar.aP.get() : (SoundEvent) oCVar.aO.get(), SoundSource.AMBIENT, 5.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
        SimpleSoundInstance simpleSoundInstance2 = new SimpleSoundInstance((SoundEvent) oCVar.aQ.get(), SoundSource.AMBIENT, 5.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
        soundManager.playDelayed(z ? simpleSoundInstance : new SimpleSoundInstance(z2 ? (SoundEvent) oCVar.aS.get() : (SoundEvent) oCVar.aR.get(), SoundSource.AMBIENT, 10.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z), 2);
        if (!z2 && z) {
            soundManager.playDelayed(simpleSoundInstance2, 6);
        }
        soundManager.playDelayed(z2 ? z ? new SimpleSoundInstance((SoundEvent) oCVar.aM.get(), SoundSource.AMBIENT, 5.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z) : new SimpleSoundInstance((SoundEvent) oCVar.aN.get(), SoundSource.AMBIENT, 10.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z) : z ? new SimpleSoundInstance((SoundEvent) oCVar.aI.get(), SoundSource.AMBIENT, 5.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z) : new SimpleSoundInstance((SoundEvent) oCVar.aJ.get(), SoundSource.AMBIENT, 10.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z), 2);
        SoundInstance simpleSoundInstance3 = new SimpleSoundInstance((SoundEvent) oCVar.aK.get(), SoundSource.AMBIENT, 5.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
        SoundInstance simpleSoundInstance4 = new SimpleSoundInstance((SoundEvent) oCVar.aL.get(), SoundSource.AMBIENT, 10.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
        for (int i = 0; i < 3; i++) {
            soundManager.playDelayed(z ? simpleSoundInstance3 : simpleSoundInstance4, 2);
        }
        soundManager.playDelayed(new SimpleSoundInstance(z2 ? (SoundEvent) C0624xc.Fx.get() : (SoundEvent) C0624xc.Fw.get(), SoundSource.AMBIENT, 1.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z), 2);
    }

    private static void a(@NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos, @NotNull Random random) {
        ObjectArrayList<a> objectArrayList = new ObjectArrayList();
        for (int i = -4; i < 4; i++) {
            for (int i2 = -4; i2 < 4; i2++) {
                for (int i3 = -4; i3 < 4; i3++) {
                    BlockPos blockPosOffset = blockPos.offset(i, i2, i3);
                    BlockState blockState = clientLevel.getBlockState(blockPosOffset);
                    if (!blockState.isAir() && a(clientLevel, blockPosOffset)) {
                        C0565uy c0565uyM1232a = wI.a(clientLevel, blockState, blockPosOffset).m1232a();
                        SoundEvent soundEventD = null;
                        if (c0565uyM1232a != null) {
                            soundEventD = c0565uyM1232a.D();
                        }
                        if (soundEventD == null && random.nextFloat() < 0.1f) {
                            soundEventD = (SoundEvent) C0624xc.Fz.get();
                        }
                        if (soundEventD != null) {
                            objectArrayList.add(new a(blockPosOffset, soundEventD));
                        }
                    }
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (a aVar : objectArrayList) {
            ((List) linkedHashMap.computeIfAbsent(aVar.a, soundEvent -> {
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
            Vec3 center = aVar2.b.getCenter();
            clientLevel.playLocalSound(center.x, center.y, center.z, aVar2.a, SoundSource.AMBIENT, 1.0f, 0.9f + (0.2f * random.nextFloat()), false);
        }
    }

    private static boolean a(@NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos) {
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

    private static void a(@NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, @NotNull Random random) {
        SoundEvent soundEvent = (SoundEvent) C0624xc.oD.get();
        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, soundEvent, SoundSource.AMBIENT, 5.0f, 1.0f, false);
        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, soundEvent, SoundSource.AMBIENT, 5.0f, 0.5f, false);
        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) C0624xc.oE.get(), SoundSource.AMBIENT, 5.0f, 0.85f + (0.2f * random.nextFloat()), false);
    }

    private static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, boolean z) {
        if (hN.w.T()) {
            iG.a(minecraft, c0297l, clientLevel, (ParticleOptions) wZ.np.get(), vec3, 0.0f, 1.0f, z ? 16 : 8, 0.1f);
            iG.a(minecraft, c0297l, clientLevel, (SimpleParticleType) wZ.nN.get(), vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
        }
    }

    private static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, boolean z, @NotNull Vec3 vec3, @NotNull oE oEVar) {
        float power = oEVar.getPower();
        int i = (int) (5.0f * power);
        float f = 2.0f * power;
        clientLevel.addParticle(ParticleTypes.EXPLOSION_EMITTER, true, vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
        ParticleOptions[] particleOptionsArr = {(ParticleOptions) wZ.nW.get(), ParticleTypes.CLOUD};
        float[] fArr = {0.2f, 0.2f};
        int length = particleOptionsArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            ParticleOptions particleOptions = particleOptionsArr[i2];
            float f2 = fArr[i2];
            if (z) {
                iG.a(minecraft, c0297l, clientLevel, particleOptions, vec3, 1.0f, f, i, f2);
            } else {
                iG.b(minecraft, c0297l, clientLevel, particleOptions, vec3, 1.0f, f, i, f2);
            }
        }
    }

    private static void a(@NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, @NotNull Vec2 vec2, Random random, int i) {
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
                            iG.a((Entity) fallingBlockEntityFall, clientLevel);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.mu$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mu$a.class */
    private static final class a extends Record {
        private final BlockPos b;
        private final SoundEvent a;

        private a(BlockPos blockPos, SoundEvent soundEvent) {
            this.b = blockPos;
            this.a = soundEvent;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "blockPos;soundEvent", "FIELD:Lcom/boehmod/blockfront/mu$a;->b:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/mu$a;->a:Lnet/minecraft/sounds/SoundEvent;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "blockPos;soundEvent", "FIELD:Lcom/boehmod/blockfront/mu$a;->b:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/mu$a;->a:Lnet/minecraft/sounds/SoundEvent;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "blockPos;soundEvent", "FIELD:Lcom/boehmod/blockfront/mu$a;->b:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/mu$a;->a:Lnet/minecraft/sounds/SoundEvent;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public BlockPos a() {
            return this.b;
        }

        public SoundEvent d() {
            return this.a;
        }
    }
}
