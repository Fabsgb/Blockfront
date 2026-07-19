package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qc.class */
public class C0435qc extends pA implements pI {

    @NotNull
    private static final ResourceLocation dZ = C0265jv.d("textures/misc/debug/mapeffect/flyby_entities.png");

    @NotNull
    public static final MapCodec<C0435qc> o = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("spawnInterval").forGetter(c0435qc -> {
            return Integer.valueOf(c0435qc.oh);
        }), Codec.FLOAT.fieldOf("speed").forGetter(c0435qc2 -> {
            return Float.valueOf(c0435qc2.kJ);
        }), pB.C.fieldOf("min0").forGetter(c0435qc3 -> {
            return c0435qc3.V;
        }), pB.C.fieldOf("min1").forGetter(c0435qc4 -> {
            return c0435qc4.W;
        }), pB.C.fieldOf("max0").forGetter(c0435qc5 -> {
            return c0435qc5.X;
        }), pB.C.fieldOf("max1").forGetter(c0435qc6 -> {
            return c0435qc6.Y;
        }), ResourceLocation.CODEC.optionalFieldOf("soundEvent").forGetter(c0435qc7 -> {
            return Optional.ofNullable(c0435qc7.a != null ? C0636xo.a(c0435qc7.a.get()) : null);
        }), Codec.DOUBLE.optionalFieldOf("soundDistanceMin", Double.valueOf(128.0d)).forGetter(c0435qc8 -> {
            return Double.valueOf(c0435qc8.aC);
        }), c.I.listOf().fieldOf("planes").forGetter(c0435qc9 -> {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            for (int i = 0; i < c0435qc9.T.size(); i++) {
                ResourceLocation resourceLocationM1696b = C0636xo.m1696b((Supplier<? extends BlockEntityType<?>>) c0435qc9.T.get(i));
                ResourceLocation resourceLocationA = C0636xo.a((Block) ((Supplier) c0435qc9.U.get(i)).get());
                if (resourceLocationM1696b != null) {
                    objectArrayList.add(new c(resourceLocationM1696b, resourceLocationA));
                }
            }
            return objectArrayList;
        })).apply(instance, (num, f, vec3, vec32, vec33, vec34, optional, d, list) -> {
            C0435qc c0435qc10 = new C0435qc(num.intValue(), f.floatValue(), vec3, vec32, vec33, vec34);
            c0435qc10.a = (Supplier) optional.map(C0636xo::d).orElse(null);
            c0435qc10.aC = d.doubleValue();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                c0435qc10.T.add(C0636xo.c(cVar.A()));
                c0435qc10.U.add(C0636xo.b(cVar.B()));
            }
            return c0435qc10;
        });
    });
    private final ObjectList<a> S;
    private final ObjectList<Supplier<? extends BlockEntityType<?>>> T;
    private final ObjectList<Supplier<? extends Block>> U;
    private final int oh;
    private final float kJ;
    private final Vec3 V;
    private final Vec3 W;
    private final Vec3 X;
    private final Vec3 Y;

    @Nullable
    private Supplier<? extends SoundEvent> a;

    @Nullable
    private final Supplier<? extends SimpleParticleType> g;
    private int of;
    private double aC;

    /* JADX INFO: renamed from: com.boehmod.blockfront.qc$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qc$c.class */
    private static final class c extends Record {
        private final ResourceLocation ea;
        private final ResourceLocation eb;
        static final Codec<c> I = RecordCodecBuilder.create(instance -> {
            return instance.group(ResourceLocation.CODEC.fieldOf("blockEntity").forGetter((v0) -> {
                return v0.A();
            }), ResourceLocation.CODEC.fieldOf("block").forGetter((v0) -> {
                return v0.B();
            })).apply(instance, c::new);
        });

        private c(ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
            this.ea = resourceLocation;
            this.eb = resourceLocation2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "blockEntityKey;blockKey", "FIELD:Lcom/boehmod/blockfront/qc$c;->ea:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/qc$c;->eb:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "blockEntityKey;blockKey", "FIELD:Lcom/boehmod/blockfront/qc$c;->ea:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/qc$c;->eb:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "blockEntityKey;blockKey", "FIELD:Lcom/boehmod/blockfront/qc$c;->ea:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/qc$c;->eb:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ResourceLocation A() {
            return this.ea;
        }

        public ResourceLocation B() {
            return this.eb;
        }
    }

    public C0435qc() {
        this(0, 0.0f, Vec3.ZERO, 0, 0);
    }

    public C0435qc(int i, float f, @NotNull Vec3 vec3, int i2, int i3) {
        this(i, f, vec3.add(i2, i3, i2), vec3.add(i2, -i3, -i2), vec3.add(-i2, -i3, i2), vec3.add(-i2, i3, -i2));
    }

    public C0435qc(int i, float f, @NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Vec3 vec33, @NotNull Vec3 vec34) {
        this.S = new ObjectArrayList();
        this.T = new ObjectArrayList();
        this.U = new ObjectArrayList();
        this.a = C0624xc.qR;
        this.g = null;
        this.of = 0;
        this.aC = 128.0d;
        this.oh = i;
        this.kJ = f;
        this.V = vec3;
        this.W = vec32;
        this.X = vec33;
        this.Y = vec34;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    private void b(@NotNull RandomSource randomSource) {
        if (this.T.isEmpty()) {
            return;
        }
        Vec3 vec3 = new Vec3(Mth.randomBetween(randomSource, (float) this.V.x, (float) this.W.x), Mth.randomBetween(randomSource, (float) this.V.y, (float) this.W.y), Mth.randomBetween(randomSource, (float) this.V.z, (float) this.W.z));
        Vec3 vec32 = new Vec3(Mth.randomBetween(randomSource, (float) this.X.x, (float) this.Y.x), Mth.randomBetween(randomSource, (float) this.X.y, (float) this.Y.y), Mth.randomBetween(randomSource, (float) this.X.z, (float) this.Y.z));
        boolean zNextBoolean = randomSource.nextBoolean();
        Vec3 vec33 = zNextBoolean ? vec3 : vec32;
        Vec3 vec34 = zNextBoolean ? vec32 : vec3;
        int iNextInt = randomSource.nextInt(this.T.size());
        BlockEntity blockEntityCreate = ((BlockEntityType) ((Supplier) this.T.get(iNextInt)).get()).create(BlockPos.ZERO, ((Block) ((Supplier) this.U.get(iNextInt)).get()).defaultBlockState());
        if (blockEntityCreate != null) {
            this.S.add(new a(this.a, this.kJ, blockEntityCreate, vec33, vec34, this.aC, this.g));
        }
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        this.S.removeIf(aVar -> {
            return aVar.a(minecraft, c0297l, localPlayer, clientLevel, randomSource);
        });
        int i = this.of;
        this.of = i - 1;
        if (i <= 0) {
            this.of = this.oh;
            int iNextInt = randomSource.nextInt(3);
            for (int i2 = 0; i2 < iNextInt; i2++) {
                b(randomSource);
            }
        }
    }

    @Override // com.boehmod.blockfront.pI
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        ObjectListIterator it = this.S.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(poseStack, minecraft, clientLevel, f2);
        }
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        ObjectListIterator it = this.S.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            C0040bk.a(camera, poseStack, aVar.aa, aVar.o, 1.0f, 16729156);
            C0040bk.a(camera, poseStack, aVar.o, aVar.Z, 1.0f, 4521796);
        }
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal("FlyBy (Entities): " + this.S.size() + " active, " + this.U.size() + " plane types, speed=" + this.kJ));
        list.add(Component.literal("Spawn timer: " + this.of + "/" + this.oh + " ticks"));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return dZ;
    }

    @Override // com.boehmod.blockfront.pA
    public boolean bw() {
        return false;
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
        this.S.clear();
        this.of = 0;
    }

    @Override // com.boehmod.blockfront.pI
    @OnlyIn(Dist.CLIENT)
    public RenderLevelStageEvent.Stage a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.qc$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qc$a.class */
    private static class a {

        @Nullable
        private final Supplier<? extends SimpleParticleType> h;
        private final float kK;
        private final BlockEntity a;
        private final Vec3 Z;

        @Nullable
        private final Supplier<? extends SoundEvent> i;
        private final double aD;
        private final Vec3 aa;
        private Vec3 o;
        private Vec3 p;
        private boolean bE = false;
        private boolean gm = false;

        public a(@Nullable Supplier<? extends SoundEvent> supplier, float f, @NotNull BlockEntity blockEntity, @NotNull Vec3 vec3, @NotNull Vec3 vec32, double d, @Nullable Supplier<? extends SimpleParticleType> supplier2) {
            this.kK = f;
            this.a = blockEntity;
            this.i = supplier;
            this.aD = d;
            this.p = vec3;
            this.o = vec3;
            this.aa = vec3;
            this.Z = vec32;
            this.h = supplier2;
            BlockEntity blockEntity2 = this.a;
            if (blockEntity2 instanceof lN) {
                ((lN) blockEntity2).bq();
            }
        }

        public void b(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
            this.bE = true;
            if (this.i != null) {
                minecraft.getSoundManager().play(new b(this, this.i.get(), 0.9f + (0.2f * randomSource.nextFloat()), 1.0f));
            }
        }

        public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource) {
            this.p = this.o;
            this.o = C0634xm.a(this.o, this.Z, this.kK);
            double dSqrt = Mth.sqrt((float) localPlayer.distanceToSqr(this.o.x, this.o.y, this.o.z));
            double d = this.kK * 4.0f * 20.0f;
            if (!this.bE) {
                if (this.aD != -1.0d) {
                    if (dSqrt <= this.aD) {
                        b(minecraft, randomSource);
                    }
                } else if (dSqrt <= d) {
                    b(minecraft, randomSource);
                }
            }
            float x = ((float) this.o.x) - ((float) localPlayer.getX());
            float z = ((float) this.o.z) - ((float) localPlayer.getZ());
            float fSqrt = Mth.sqrt((x * x) + (z * z));
            if (!this.gm && fSqrt <= 20.0f) {
                this.gm = true;
                hE.a(hH.r);
            }
            if (this.h != null) {
                iG.a(minecraft, c0297l, clientLevel, this.h.get(), this.o.x, this.o.y, this.o.z, 0.0d, 0.0d, 0.0d);
            }
            return this.o.distanceTo(this.Z) <= 1.0d;
        }

        public void a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, float f) {
            if (this.a == null) {
                return;
            }
            Vec3 vec3Normalize = this.Z.subtract(this.o).normalize();
            float degrees = (float) Math.toDegrees(Math.asin(-vec3Normalize.y));
            float degrees2 = (float) Math.toDegrees(Math.atan2(vec3Normalize.x, vec3Normalize.z));
            Vec3 vec3B = C0634xm.b(this.o, this.p, f);
            C0040bk.a(minecraft, clientLevel, poseStack, this.a, vec3B.x, vec3B.y, vec3B.z, degrees, degrees2, f);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.qc$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qc$b.class */
    @OnlyIn(Dist.CLIENT)
    public static class b extends AbstractTickableSoundInstance {
        private final a a;

        public b(@NotNull a aVar, @NotNull SoundEvent soundEvent, float f, float f2) {
            super(soundEvent, SoundSource.AMBIENT, SoundInstance.createUnseededRandom());
            this.a = aVar;
            this.looping = false;
            this.pitch = f;
            this.volume = f2;
            this.x = (float) aVar.o.x;
            this.y = (float) aVar.o.y;
            this.z = (float) aVar.o.z;
            this.attenuation = SoundInstance.Attenuation.NONE;
        }

        public void tick() {
            if (this.a != null) {
                this.x = this.a.o.x;
                this.y = this.a.o.y;
                this.z = this.a.o.z;
            }
        }
    }
}
