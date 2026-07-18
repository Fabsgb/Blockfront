package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0171cj;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.mu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mu.class */
public class C0722mu {

    /* JADX INFO: renamed from: kF */
    private static final int f3881kF = 256;

    /* JADX INFO: renamed from: kG */
    private static final int f3882kG = 16;

    /* JADX INFO: renamed from: kH */
    private static final int f3883kH = 10;

    /* JADX INFO: renamed from: kI */
    private static final int f3884kI = 4;

    /* JADX INFO: renamed from: kJ */
    private static final int f3885kJ = 4;

    /* JADX INFO: renamed from: it */
    private static final float f3886it = 1.0f;

    /* JADX INFO: renamed from: iu */
    private static final float f3887iu = 10.0f;

    /* JADX INFO: renamed from: iv */
    private static final float f3888iv = 5.0f;

    /* JADX INFO: renamed from: kK */
    public static final int f3889kK = 16;

    /* JADX INFO: renamed from: kL */
    public static final int f3890kL = 8;

    /* JADX INFO: renamed from: et */
    static final /* synthetic */ boolean f3891et;

    static {
        f3891et = !C0722mu.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: b */
    public static void m3268b(@NotNull String str, @NotNull Vec3 vec3) {
        C0622l c0622lM2667b;
        String[] strArrSplit = str.substring(10, str.length() - 2).split(",");
        if (strArrSplit.length != 4) {
            return;
        }
        try {
            EnumC0786oE enumC0786oEValueOf = EnumC0786oE.valueOf(strArrSplit[0].trim());
            float f = Float.parseFloat(strArrSplit[1].trim());
            float f2 = Float.parseFloat(strArrSplit[2].trim());
            float f3 = Float.parseFloat(strArrSplit[3].trim());
            Minecraft minecraft = Minecraft.getInstance();
            ClientLevel clientLevel = minecraft.level;
            if (clientLevel == null || (c0622lM2667b = C0622l.m2667b()) == null) {
                return;
            }
            m3269a(minecraft, c0622lM2667b, clientLevel, enumC0786oEValueOf, vec3.add(f, f2, f3));
        } catch (IllegalArgumentException e) {
            C0562jt.logError("Failed to parse explosion instruction: " + str, new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3269a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull EnumC0786oE enumC0786oE, @NotNull Vec3 vec3) {
        int i;
        LocalPlayer localPlayer = minecraft.player;
        if (!f3891et && localPlayer == null) {
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
        boolean zM3915a = C0799oR.m3915a((BlockAndTintGetter) clientLevel, blockPosContaining);
        C0470iG.m2126a(minecraft, c0622l, clientLevel, (SimpleParticleType) C1232wZ.f7293nu.get(), vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
        boolean zUseFancyGraphics = Minecraft.useFancyGraphics();
        if (enumC0786oE == EnumC0786oE.GORE_EXPLOSION) {
            m3275a(minecraft, c0622l, clientLevel, vec3, zUseFancyGraphics);
        } else {
            blockPosContaining.below();
            m3276a(minecraft, c0622l, clientLevel, clientLevel.getBlockState(blockPosContaining).isAir(), vec3, enumC0786oE);
            C0384ga.m1842a(new PointLightData().setPosition(vec3.x, vec3.y, vec3.z).setBrightness(6.0f).setRadius(16.0f).setColor(ColorReferences.COLOR_BULLET_TRACER), 0);
            C0384ga.m1842a(new PointLightData().setPosition(vec3.x, vec3.y, vec3.z).setBrightness(8.0f).setRadius(6.0f).setColor(ColorReferences.COLOR_BULLET_TRACER), 0);
        }
        C0171cj.b.a aVar = C0171cj.b.a.DIRT;
        if (enumC0786oE.shouldDisplayBlockDamage() && zUseFancyGraphics) {
            m3277a(clientLevel, vec3, enumC0786oE.getBlockDamageMotion(), threadLocalRandomCurrent, enumC0786oE.getBlockDamageRadius());
        }
        if ((clientLevel.clip(new ClipContext(eyePosition, vec3, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, localPlayer)).getType() == HitResult.Type.MISS) && (i = (int) fSqrt) <= 10) {
            int i2 = 10 - i;
            for (int i3 = 0; i3 < i2; i3++) {
                C0178cm.f1457p.add(new C0171cj.b(threadLocalRandomCurrent, aVar));
            }
        }
        boolean z = false;
        float maxDistance = enumC0786oE.getMaxDistance();
        C0417hG shakeNodeData = enumC0786oE.getShakeNodeData();
        if (shakeNodeData != null) {
            C0415hE.m1963a(shakeNodeData, localPlayer, vec3, maxDistance);
        }
        C0417hG shakeNodeFaintData = enumC0786oE.getShakeNodeFaintData();
        if (shakeNodeFaintData != null) {
            C0415hE.m1963a(shakeNodeFaintData, localPlayer, vec3, maxDistance * 3.0f);
        }
        if (fSqrt <= maxDistance) {
            z = true;
        }
        C0784oC audioConfig = enumC0786oE.getAudioConfig();
        if (enumC0786oE == EnumC0786oE.VEHICLE_EXPLOSION) {
            clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) C1280xc.f7652rf.get(), SoundSource.AMBIENT, 10.0f, 1.0f, false);
        }
        if (enumC0786oE == EnumC0786oE.GORE_EXPLOSION) {
            m3274a(clientLevel, vec3, threadLocalRandomCurrent);
        } else {
            m3271a(minecraft, vec3, audioConfig, randomSourceCreate, z, zM3915a);
            m3272a(clientLevel, blockPosContaining, threadLocalRandomCurrent);
            m3270a((Level) clientLevel, vec3);
        }
        if (enumC0786oE.emitsLight()) {
            C0384ga.m1842a(new PointLightData().setPosition(vec3.x, vec3.y, vec3.z).setBrightness(enumC0786oE.getLightBrightness()).setRadius(enumC0786oE.getLightRadius()).setColor(ColorReferences.COLOR_WHITE), 1);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3270a(@NotNull Level level, @NotNull Vec3 vec3) {
        for (AbstractC0779ny abstractC0779ny : level.getEntitiesOfClass(AbstractC0779ny.class, AABB.ofSize(vec3, 16.0d, 16.0d, 16.0d))) {
            if (level.clip(new ClipContext(abstractC0779ny.position(), vec3, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, abstractC0779ny)).getType().equals(HitResult.Type.MISS)) {
                Vec3 vec3Position = abstractC0779ny.position();
                level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1280xc.f8405FE.get(), SoundSource.AMBIENT, 5.0f, 1.0f, false);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3271a(@NotNull Minecraft minecraft, @NotNull Vec3 vec3, @NotNull C0784oC c0784oC, @NotNull RandomSource randomSource, boolean z, boolean z2) {
        SoundManager soundManager = minecraft.getSoundManager();
        if (!z2) {
            soundManager.playDelayed(new SimpleSoundInstance((SoundEvent) c0784oC.f4212aT.get(), SoundSource.AMBIENT, 6.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z), 2);
        }
        SoundInstance simpleSoundInstance = new SimpleSoundInstance(z2 ? (SoundEvent) c0784oC.f4208aP.get() : (SoundEvent) c0784oC.f4207aO.get(), SoundSource.AMBIENT, 5.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
        SimpleSoundInstance simpleSoundInstance2 = new SimpleSoundInstance((SoundEvent) c0784oC.f4209aQ.get(), SoundSource.AMBIENT, 5.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
        soundManager.playDelayed(z ? simpleSoundInstance : new SimpleSoundInstance(z2 ? (SoundEvent) c0784oC.f4211aS.get() : (SoundEvent) c0784oC.f4210aR.get(), SoundSource.AMBIENT, 10.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z), 2);
        if (!z2 && z) {
            soundManager.playDelayed(simpleSoundInstance2, 6);
        }
        soundManager.playDelayed(z2 ? z ? new SimpleSoundInstance((SoundEvent) c0784oC.f4205aM.get(), SoundSource.AMBIENT, 5.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z) : new SimpleSoundInstance((SoundEvent) c0784oC.f4206aN.get(), SoundSource.AMBIENT, 10.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z) : z ? new SimpleSoundInstance((SoundEvent) c0784oC.f4201aI.get(), SoundSource.AMBIENT, 5.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z) : new SimpleSoundInstance((SoundEvent) c0784oC.f4202aJ.get(), SoundSource.AMBIENT, 10.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z), 2);
        SoundInstance simpleSoundInstance3 = new SimpleSoundInstance((SoundEvent) c0784oC.f4203aK.get(), SoundSource.AMBIENT, 5.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
        SoundInstance simpleSoundInstance4 = new SimpleSoundInstance((SoundEvent) c0784oC.f4204aL.get(), SoundSource.AMBIENT, 10.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z);
        for (int i = 0; i < 3; i++) {
            soundManager.playDelayed(z ? simpleSoundInstance3 : simpleSoundInstance4, 2);
        }
        soundManager.playDelayed(new SimpleSoundInstance(z2 ? (SoundEvent) C1280xc.f8398Fx.get() : (SoundEvent) C1280xc.f8397Fw.get(), SoundSource.AMBIENT, 1.0f, 1.0f, randomSource, vec3.x, vec3.y, vec3.z), 2);
    }

    /* JADX INFO: renamed from: a */
    private static void m3272a(@NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos, @NotNull Random random) {
        ObjectArrayList<a> objectArrayList = new ObjectArrayList();
        for (int i = -4; i < 4; i++) {
            for (int i2 = -4; i2 < 4; i2++) {
                for (int i3 = -4; i3 < 4; i3++) {
                    BlockPos blockPosOffset = blockPos.offset(i, i2, i3);
                    BlockState blockState = clientLevel.getBlockState(blockPosOffset);
                    if (!blockState.isAir() && m3273a(clientLevel, blockPosOffset)) {
                        C1151uy c1151uyM6440a = C1215wI.m6740a(clientLevel, blockState, blockPosOffset).m6440a();
                        SoundEvent soundEventM6458D = null;
                        if (c1151uyM6440a != null) {
                            soundEventM6458D = c1151uyM6440a.m6458D();
                        }
                        if (soundEventM6458D == null && random.nextFloat() < 0.1f) {
                            soundEventM6458D = (SoundEvent) C1280xc.f8400Fz.get();
                        }
                        if (soundEventM6458D != null) {
                            objectArrayList.add(new a(blockPosOffset, soundEventM6458D));
                        }
                    }
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (a aVar : objectArrayList) {
            ((List) linkedHashMap.computeIfAbsent(aVar.f3893a, soundEvent -> {
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
            Vec3 center = aVar2.f3892b.getCenter();
            clientLevel.playLocalSound(center.x, center.y, center.z, aVar2.f3893a, SoundSource.AMBIENT, 1.0f, 0.9f + (0.2f * random.nextFloat()), false);
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3273a(@NotNull ClientLevel clientLevel, @NotNull BlockPos blockPos) {
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
    private static void m3274a(@NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, @NotNull Random random) {
        SoundEvent soundEvent = (SoundEvent) C1280xc.f7520oD.get();
        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, soundEvent, SoundSource.AMBIENT, 5.0f, 1.0f, false);
        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, soundEvent, SoundSource.AMBIENT, 5.0f, 0.5f, false);
        clientLevel.playLocalSound(vec3.x, vec3.y, vec3.z, (SoundEvent) C1280xc.f7521oE.get(), SoundSource.AMBIENT, 5.0f, 0.85f + (0.2f * random.nextFloat()), false);
    }

    /* JADX INFO: renamed from: a */
    private static void m3275a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, boolean z) {
        if (C0424hN.f2742w.m1996T()) {
            C0470iG.m2124a(minecraft, c0622l, clientLevel, (ParticleOptions) C1232wZ.f7288np.get(), vec3, 0.0f, 1.0f, z ? 16 : 8, 0.1f);
            C0470iG.m2126a(minecraft, c0622l, clientLevel, (SimpleParticleType) C1232wZ.f7312nN.get(), vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3276a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, boolean z, @NotNull Vec3 vec3, @NotNull EnumC0786oE enumC0786oE) {
        float power = enumC0786oE.getPower();
        int i = (int) (5.0f * power);
        float f = 2.0f * power;
        clientLevel.addParticle(ParticleTypes.EXPLOSION_EMITTER, true, vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
        ParticleOptions[] particleOptionsArr = {(ParticleOptions) C1232wZ.f7321nW.get(), ParticleTypes.CLOUD};
        float[] fArr = {0.2f, 0.2f};
        int length = particleOptionsArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            ParticleOptions particleOptions = particleOptionsArr[i2];
            float f2 = fArr[i2];
            if (z) {
                C0470iG.m2124a(minecraft, c0622l, clientLevel, particleOptions, vec3, 1.0f, f, i, f2);
            } else {
                C0470iG.m2125b(minecraft, c0622l, clientLevel, particleOptions, vec3, 1.0f, f, i, f2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3277a(@NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, @NotNull Vec2 vec2, Random random, int i) {
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
                            C0470iG.m2121a((Entity) fallingBlockEntityFall, clientLevel);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.mu$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mu$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: b */
        private final BlockPos f3892b;

        /* JADX INFO: renamed from: a */
        private final SoundEvent f3893a;

        private a(BlockPos blockPos, SoundEvent soundEvent) {
            this.f3892b = blockPos;
            this.f3893a = soundEvent;
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

        /* JADX INFO: renamed from: a */
        public BlockPos m3279a() {
            return this.f3892b;
        }

        /* JADX INFO: renamed from: d */
        public SoundEvent m3280d() {
            return this.f3893a;
        }
    }
}
