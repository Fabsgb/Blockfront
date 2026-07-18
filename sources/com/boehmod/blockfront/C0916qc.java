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

/* JADX INFO: renamed from: com.boehmod.blockfront.qc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qc.class */
public class C0916qc extends AbstractC0835pA implements InterfaceC0843pI {

    /* JADX INFO: renamed from: dZ */
    @NotNull
    private static final ResourceLocation f4757dZ = C0564jv.m2555d("textures/misc/debug/mapeffect/flyby_entities.png");

    /* JADX INFO: renamed from: o */
    @NotNull
    public static final MapCodec<C0916qc> f4758o = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("spawnInterval").forGetter(c0916qc -> {
            return Integer.valueOf(c0916qc.f4762oh);
        }), Codec.FLOAT.fieldOf("speed").forGetter(c0916qc2 -> {
            return Float.valueOf(c0916qc2.f4763kJ);
        }), C0836pB.f4470C.fieldOf("min0").forGetter(c0916qc3 -> {
            return c0916qc3.f4764V;
        }), C0836pB.f4470C.fieldOf("min1").forGetter(c0916qc4 -> {
            return c0916qc4.f4765W;
        }), C0836pB.f4470C.fieldOf("max0").forGetter(c0916qc5 -> {
            return c0916qc5.f4766X;
        }), C0836pB.f4470C.fieldOf("max1").forGetter(c0916qc6 -> {
            return c0916qc6.f4767Y;
        }), ResourceLocation.CODEC.optionalFieldOf("soundEvent").forGetter(c0916qc7 -> {
            return Optional.ofNullable(c0916qc7.f4768a != null ? C1292xo.m7900a(c0916qc7.f4768a.get()) : null);
        }), Codec.DOUBLE.optionalFieldOf("soundDistanceMin", Double.valueOf(128.0d)).forGetter(c0916qc8 -> {
            return Double.valueOf(c0916qc8.f4771aC);
        }), c.f4786I.listOf().fieldOf("planes").forGetter(c0916qc9 -> {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            for (int i = 0; i < c0916qc9.f4760T.size(); i++) {
                ResourceLocation resourceLocationM7898b = C1292xo.m7898b((Supplier<? extends BlockEntityType<?>>) c0916qc9.f4760T.get(i));
                ResourceLocation resourceLocationM7896a = C1292xo.m7896a((Block) ((Supplier) c0916qc9.f4761U.get(i)).get());
                if (resourceLocationM7898b != null) {
                    objectArrayList.add(new c(resourceLocationM7898b, resourceLocationM7896a));
                }
            }
            return objectArrayList;
        })).apply(instance, (num, f, vec3, vec32, vec33, vec34, optional, d, list) -> {
            C0916qc c0916qc10 = new C0916qc(num.intValue(), f.floatValue(), vec3, vec32, vec33, vec34);
            c0916qc10.f4768a = (Supplier) optional.map(C1292xo::m7901d).orElse(null);
            c0916qc10.f4771aC = d.doubleValue();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                c0916qc10.f4760T.add(C1292xo.m7899c(cVar.m4769A()));
                c0916qc10.f4761U.add(C1292xo.m7897b(cVar.m4770B()));
            }
            return c0916qc10;
        });
    });

    /* JADX INFO: renamed from: S */
    private final ObjectList<a> f4759S;

    /* JADX INFO: renamed from: T */
    private final ObjectList<Supplier<? extends BlockEntityType<?>>> f4760T;

    /* JADX INFO: renamed from: U */
    private final ObjectList<Supplier<? extends Block>> f4761U;

    /* JADX INFO: renamed from: oh */
    private final int f4762oh;

    /* JADX INFO: renamed from: kJ */
    private final float f4763kJ;

    /* JADX INFO: renamed from: V */
    private final Vec3 f4764V;

    /* JADX INFO: renamed from: W */
    private final Vec3 f4765W;

    /* JADX INFO: renamed from: X */
    private final Vec3 f4766X;

    /* JADX INFO: renamed from: Y */
    private final Vec3 f4767Y;

    /* JADX INFO: renamed from: a */
    @Nullable
    private Supplier<? extends SoundEvent> f4768a;

    /* JADX INFO: renamed from: g */
    @Nullable
    private final Supplier<? extends SimpleParticleType> f4769g;

    /* JADX INFO: renamed from: of */
    private int f4770of;

    /* JADX INFO: renamed from: aC */
    private double f4771aC;

    /* JADX INFO: renamed from: com.boehmod.blockfront.qc$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qc$c.class */
    private static final class c extends Record {

        /* JADX INFO: renamed from: ea */
        private final ResourceLocation f4784ea;

        /* JADX INFO: renamed from: eb */
        private final ResourceLocation f4785eb;

        /* JADX INFO: renamed from: I */
        static final Codec<c> f4786I = RecordCodecBuilder.create(instance -> {
            return instance.group(ResourceLocation.CODEC.fieldOf("blockEntity").forGetter((v0) -> {
                return v0.m4769A();
            }), ResourceLocation.CODEC.fieldOf("block").forGetter((v0) -> {
                return v0.m4770B();
            })).apply(instance, c::new);
        });

        private c(ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
            this.f4784ea = resourceLocation;
            this.f4785eb = resourceLocation2;
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

        /* JADX INFO: renamed from: A */
        public ResourceLocation m4769A() {
            return this.f4784ea;
        }

        /* JADX INFO: renamed from: B */
        public ResourceLocation m4770B() {
            return this.f4785eb;
        }
    }

    public C0916qc() {
        this(0, 0.0f, Vec3.ZERO, 0, 0);
    }

    public C0916qc(int i, float f, @NotNull Vec3 vec3, int i2, int i3) {
        this(i, f, vec3.add(i2, i3, i2), vec3.add(i2, -i3, -i2), vec3.add(-i2, -i3, i2), vec3.add(-i2, i3, -i2));
    }

    public C0916qc(int i, float f, @NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Vec3 vec33, @NotNull Vec3 vec34) {
        this.f4759S = new ObjectArrayList();
        this.f4760T = new ObjectArrayList();
        this.f4761U = new ObjectArrayList();
        this.f4768a = C1280xc.f7638qR;
        this.f4769g = null;
        this.f4770of = 0;
        this.f4771aC = 128.0d;
        this.f4762oh = i;
        this.f4763kJ = f;
        this.f4764V = vec3;
        this.f4765W = vec32;
        this.f4766X = vec33;
        this.f4767Y = vec34;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    /* JADX INFO: renamed from: b */
    private void m4753b(@NotNull RandomSource randomSource) {
        if (this.f4760T.isEmpty()) {
            return;
        }
        Vec3 vec3 = new Vec3(Mth.randomBetween(randomSource, (float) this.f4764V.x, (float) this.f4765W.x), Mth.randomBetween(randomSource, (float) this.f4764V.y, (float) this.f4765W.y), Mth.randomBetween(randomSource, (float) this.f4764V.z, (float) this.f4765W.z));
        Vec3 vec32 = new Vec3(Mth.randomBetween(randomSource, (float) this.f4766X.x, (float) this.f4767Y.x), Mth.randomBetween(randomSource, (float) this.f4766X.y, (float) this.f4767Y.y), Mth.randomBetween(randomSource, (float) this.f4766X.z, (float) this.f4767Y.z));
        boolean zNextBoolean = randomSource.nextBoolean();
        Vec3 vec33 = zNextBoolean ? vec3 : vec32;
        Vec3 vec34 = zNextBoolean ? vec32 : vec3;
        int iNextInt = randomSource.nextInt(this.f4760T.size());
        BlockEntity blockEntityCreate = ((BlockEntityType) ((Supplier) this.f4760T.get(iNextInt)).get()).create(BlockPos.ZERO, ((Block) ((Supplier) this.f4761U.get(iNextInt)).get()).defaultBlockState());
        if (blockEntityCreate != null) {
            this.f4759S.add(new a(this.f4768a, this.f4763kJ, blockEntityCreate, vec33, vec34, this.f4771aC, this.f4769g));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        this.f4759S.removeIf(aVar -> {
            return aVar.m4767a(minecraft, c0622l, localPlayer, clientLevel, randomSource);
        });
        int i = this.f4770of;
        this.f4770of = i - 1;
        if (i <= 0) {
            this.f4770of = this.f4762oh;
            int iNextInt = randomSource.nextInt(3);
            for (int i2 = 0; i2 < iNextInt; i2++) {
                m4753b(randomSource);
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    /* JADX INFO: renamed from: a */
    public void mo4270a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        ObjectListIterator it = this.f4759S.iterator();
        while (it.hasNext()) {
            ((a) it.next()).m4768a(poseStack, minecraft, clientLevel, f2);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4221a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo4221a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        ObjectListIterator it = this.f4759S.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            C0119bk.m474a(camera, poseStack, aVar.f4778aa, aVar.f4779o, 1.0f, 16729156);
            C0119bk.m474a(camera, poseStack, aVar.f4779o, aVar.f4775Z, 1.0f, 4521796);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("FlyBy (Entities): " + this.f4759S.size() + " active, " + this.f4761U.size() + " plane types, speed=" + this.f4763kJ));
        list.add(Component.literal("Spawn timer: " + this.f4770of + "/" + this.f4762oh + " ticks"));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4757dZ;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: bw */
    public boolean mo4223bw() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: cA */
    public void mo4224cA() {
        super.mo4224cA();
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4225a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo4225a(minecraft, randomSource);
        this.f4759S.clear();
        this.f4770of = 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4269a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.qc$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qc$a.class */
    private static class a {

        /* JADX INFO: renamed from: h */
        @Nullable
        private final Supplier<? extends SimpleParticleType> f4772h;

        /* JADX INFO: renamed from: kK */
        private final float f4773kK;

        /* JADX INFO: renamed from: a */
        private final BlockEntity f4774a;

        /* JADX INFO: renamed from: Z */
        private final Vec3 f4775Z;

        /* JADX INFO: renamed from: i */
        @Nullable
        private final Supplier<? extends SoundEvent> f4776i;

        /* JADX INFO: renamed from: aD */
        private final double f4777aD;

        /* JADX INFO: renamed from: aa */
        private final Vec3 f4778aa;

        /* JADX INFO: renamed from: o */
        private Vec3 f4779o;

        /* JADX INFO: renamed from: p */
        private Vec3 f4780p;

        /* JADX INFO: renamed from: bE */
        private boolean f4781bE = false;

        /* JADX INFO: renamed from: gm */
        private boolean f4782gm = false;

        public a(@Nullable Supplier<? extends SoundEvent> supplier, float f, @NotNull BlockEntity blockEntity, @NotNull Vec3 vec3, @NotNull Vec3 vec32, double d, @Nullable Supplier<? extends SimpleParticleType> supplier2) {
            this.f4773kK = f;
            this.f4774a = blockEntity;
            this.f4776i = supplier;
            this.f4777aD = d;
            this.f4780p = vec3;
            this.f4779o = vec3;
            this.f4778aa = vec3;
            this.f4775Z = vec32;
            this.f4772h = supplier2;
            BlockEntity blockEntity2 = this.f4774a;
            if (blockEntity2 instanceof C0636lN) {
                ((C0636lN) blockEntity2).m2805bq();
            }
        }

        /* JADX INFO: renamed from: b */
        public void m4766b(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
            this.f4781bE = true;
            if (this.f4776i != null) {
                minecraft.getSoundManager().play(new b(this, this.f4776i.get(), 0.9f + (0.2f * randomSource.nextFloat()), 1.0f));
            }
        }

        /* JADX INFO: renamed from: a */
        public boolean m4767a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource) {
            this.f4780p = this.f4779o;
            this.f4779o = C1290xm.m7837a(this.f4779o, this.f4775Z, this.f4773kK);
            double dSqrt = Mth.sqrt((float) localPlayer.distanceToSqr(this.f4779o.x, this.f4779o.y, this.f4779o.z));
            double d = this.f4773kK * 4.0f * 20.0f;
            if (!this.f4781bE) {
                if (this.f4777aD != -1.0d) {
                    if (dSqrt <= this.f4777aD) {
                        m4766b(minecraft, randomSource);
                    }
                } else if (dSqrt <= d) {
                    m4766b(minecraft, randomSource);
                }
            }
            float x = ((float) this.f4779o.x) - ((float) localPlayer.getX());
            float z = ((float) this.f4779o.z) - ((float) localPlayer.getZ());
            float fSqrt = Mth.sqrt((x * x) + (z * z));
            if (!this.f4782gm && fSqrt <= 20.0f) {
                this.f4782gm = true;
                C0415hE.m1960a(C0418hH.f2675r);
            }
            if (this.f4772h != null) {
                C0470iG.m2126a(minecraft, c0622l, clientLevel, this.f4772h.get(), this.f4779o.x, this.f4779o.y, this.f4779o.z, 0.0d, 0.0d, 0.0d);
            }
            return this.f4779o.distanceTo(this.f4775Z) <= 1.0d;
        }

        /* JADX INFO: renamed from: a */
        public void m4768a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, float f) {
            if (this.f4774a == null) {
                return;
            }
            Vec3 vec3Normalize = this.f4775Z.subtract(this.f4779o).normalize();
            float degrees = (float) Math.toDegrees(Math.asin(-vec3Normalize.y));
            float degrees2 = (float) Math.toDegrees(Math.atan2(vec3Normalize.x, vec3Normalize.z));
            Vec3 vec3M7845b = C1290xm.m7845b(this.f4779o, this.f4780p, f);
            C0119bk.m533a(minecraft, clientLevel, poseStack, this.f4774a, vec3M7845b.x, vec3M7845b.y, vec3M7845b.z, degrees, degrees2, f);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.qc$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qc$b.class */
    @OnlyIn(Dist.CLIENT)
    public static class b extends AbstractTickableSoundInstance {

        /* JADX INFO: renamed from: a */
        private final a f4783a;

        public b(@NotNull a aVar, @NotNull SoundEvent soundEvent, float f, float f2) {
            super(soundEvent, SoundSource.AMBIENT, SoundInstance.createUnseededRandom());
            this.f4783a = aVar;
            this.looping = false;
            this.pitch = f;
            this.volume = f2;
            this.x = (float) aVar.f4779o.x;
            this.y = (float) aVar.f4779o.y;
            this.z = (float) aVar.f4779o.z;
            this.attenuation = SoundInstance.Attenuation.NONE;
        }

        public void tick() {
            if (this.f4783a != null) {
                this.x = this.f4783a.f4779o.x;
                this.y = this.f4783a.f4779o.y;
                this.z = this.f4783a.f4779o.z;
            }
        }
    }
}
