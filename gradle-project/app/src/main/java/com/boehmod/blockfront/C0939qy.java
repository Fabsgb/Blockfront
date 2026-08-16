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

/* JADX INFO: renamed from: com.boehmod.blockfront.qy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qy.class */
public class C0939qy extends AbstractC0858pW implements InterfaceC0919qe {

    /* JADX INFO: renamed from: dX */
    @NotNull
    private static final ResourceLocation f5172dX = C0532jO.m2378d("textures/misc/debug/mapeffect/flyby_entities.png");

    /* JADX INFO: renamed from: o */
    @NotNull
    public static final MapCodec<C0939qy> f5173o = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("spawnInterval").forGetter(c0939qy -> {
            return Integer.valueOf(c0939qy.f5177qg);
        }), Codec.FLOAT.fieldOf("speed").forGetter(c0939qy2 -> {
            return Float.valueOf(c0939qy2.f5178lE);
        }), C0859pX.f4599C.fieldOf("min0").forGetter(c0939qy3 -> {
            return c0939qy3.f5179W;
        }), C0859pX.f4599C.fieldOf("min1").forGetter(c0939qy4 -> {
            return c0939qy4.f5180X;
        }), C0859pX.f4599C.fieldOf("max0").forGetter(c0939qy5 -> {
            return c0939qy5.f5181Y;
        }), C0859pX.f4599C.fieldOf("max1").forGetter(c0939qy6 -> {
            return c0939qy6.f5182Z;
        }), ResourceLocation.CODEC.optionalFieldOf("soundEvent").forGetter(c0939qy7 -> {
            return Optional.ofNullable(c0939qy7.f5183a != null ? C1272xL.m7227a(c0939qy7.f5183a.get()) : null);
        }), Codec.DOUBLE.optionalFieldOf("soundDistanceMin", Double.valueOf(128.0d)).forGetter(c0939qy8 -> {
            return Double.valueOf(c0939qy8.f5186aP);
        }), c.f5201I.listOf().fieldOf("planes").forGetter(c0939qy9 -> {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            for (int i = 0; i < c0939qy9.f5175ac.size(); i++) {
                ResourceLocation resourceLocationM7225b = C1272xL.m7225b((Supplier<? extends BlockEntityType<?>>) c0939qy9.f5175ac.get(i));
                ResourceLocation resourceLocationM7223a = C1272xL.m7223a((Block) ((Supplier) c0939qy9.f5176ad.get(i)).get());
                if (resourceLocationM7225b != null) {
                    objectArrayList.add(new c(resourceLocationM7225b, resourceLocationM7223a));
                }
            }
            return objectArrayList;
        })).apply(instance, (num, f, vec3, vec4, vec5, vec6, optional, d, list) -> {
            C0939qy c0939qy10 = new C0939qy(num.intValue(), f.floatValue(), vec3, vec4, vec5, vec6);
            c0939qy10.f5183a = (Supplier) optional.map(C1272xL::m7228d).orElse(null);
            c0939qy10.f5186aP = d.doubleValue();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                c0939qy10.f5175ac.add(C1272xL.m7226c(cVar.m5156B()));
                c0939qy10.f5176ad.add(C1272xL.m7224b(cVar.m5157C()));
            }
            return c0939qy10;
        });
    });

    /* JADX INFO: renamed from: ab */
    private final ObjectList<a> f5174ab;

    /* JADX INFO: renamed from: ac */
    private final ObjectList<Supplier<? extends BlockEntityType<?>>> f5175ac;

    /* JADX INFO: renamed from: ad */
    private final ObjectList<Supplier<? extends Block>> f5176ad;

    /* JADX INFO: renamed from: qg */
    private final int f5177qg;

    /* JADX INFO: renamed from: lE */
    private final float f5178lE;

    /* JADX INFO: renamed from: W */
    private final Vec3 f5179W;

    /* JADX INFO: renamed from: X */
    private final Vec3 f5180X;

    /* JADX INFO: renamed from: Y */
    private final Vec3 f5181Y;

    /* JADX INFO: renamed from: Z */
    private final Vec3 f5182Z;

    /* JADX INFO: renamed from: a */
    @Nullable
    private Supplier<? extends SoundEvent> f5183a;

    /* JADX INFO: renamed from: g */
    @Nullable
    private final Supplier<? extends SimpleParticleType> f5184g;

    /* JADX INFO: renamed from: qe */
    private int f5185qe;

    /* JADX INFO: renamed from: aP */
    private double f5186aP;

    /* JADX INFO: renamed from: com.boehmod.blockfront.qy$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qy$c.class */
    private static final class c extends Record {

        /* JADX INFO: renamed from: dY */
        private final ResourceLocation f5199dY;

        /* JADX INFO: renamed from: dZ */
        private final ResourceLocation f5200dZ;

        /* JADX INFO: renamed from: I */
        static final Codec<c> f5201I = RecordCodecBuilder.create(instance -> {
            return instance.group(ResourceLocation.CODEC.fieldOf("blockEntity").forGetter((v0) -> {
                return v0.m5156B();
            }), ResourceLocation.CODEC.fieldOf("block").forGetter((v0) -> {
                return v0.m5157C();
            })).apply(instance, c::new);
        });

        private c(ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
            this.f5199dY = resourceLocation;
            this.f5200dZ = resourceLocation2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "blockEntityKey;blockKey", "FIELD:Lcom/boehmod/blockfront/qy$c;->dY:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/qy$c;->dZ:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "blockEntityKey;blockKey", "FIELD:Lcom/boehmod/blockfront/qy$c;->dY:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/qy$c;->dZ:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "blockEntityKey;blockKey", "FIELD:Lcom/boehmod/blockfront/qy$c;->dY:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/qy$c;->dZ:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: B */
        public ResourceLocation m5156B() {
            return this.f5199dY;
        }

        /* JADX INFO: renamed from: C */
        public ResourceLocation m5157C() {
            return this.f5200dZ;
        }
    }

    public C0939qy() {
        this(0, 0.0f, Vec3.ZERO, 0, 0);
    }

    public C0939qy(int i, float f, @NotNull Vec3 vec3, int i2, int i3) {
        this(i, f, vec3.add(i2, i3, i2), vec3.add(i2, -i3, -i2), vec3.add(-i2, -i3, i2), vec3.add(-i2, i3, -i2));
    }

    public C0939qy(int i, float f, @NotNull Vec3 vec3, @NotNull Vec3 vec4, @NotNull Vec3 vec5, @NotNull Vec3 vec6) {
        this.f5174ab = new ObjectArrayList();
        this.f5175ac = new ObjectArrayList();
        this.f5176ad = new ObjectArrayList();
        this.f5183a = C1312xz.f8050qT;
        this.f5184g = null;
        this.f5185qe = 0;
        this.f5186aP = 128.0d;
        this.f5177qg = i;
        this.f5178lE = f;
        this.f5179W = vec3;
        this.f5180X = vec4;
        this.f5181Y = vec5;
        this.f5182Z = vec6;
    }

    /* JADX INFO: renamed from: a */
    public C0939qy m5137a(@Nullable Supplier<? extends SoundEvent> supplier) {
        this.f5183a = supplier;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0939qy m5138a(double d) {
        this.f5186aP = d;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0939qy m5139a(@NotNull Supplier<? extends BlockEntityType<?>> supplier, @NotNull Supplier<? extends Block> supplier2) {
        this.f5175ac.add(supplier);
        this.f5176ad.add(supplier2);
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    /* JADX INFO: renamed from: b */
    private void m5140b(@NotNull RandomSource randomSource) {
        if (this.f5175ac.isEmpty()) {
            return;
        }
        Vec3 vec3 = new Vec3(Mth.randomBetween(randomSource, (float) this.f5179W.x, (float) this.f5180X.x), Mth.randomBetween(randomSource, (float) this.f5179W.y, (float) this.f5180X.y), Mth.randomBetween(randomSource, (float) this.f5179W.z, (float) this.f5180X.z));
        Vec3 vec4 = new Vec3(Mth.randomBetween(randomSource, (float) this.f5181Y.x, (float) this.f5182Z.x), Mth.randomBetween(randomSource, (float) this.f5181Y.y, (float) this.f5182Z.y), Mth.randomBetween(randomSource, (float) this.f5181Y.z, (float) this.f5182Z.z));
        boolean zNextBoolean = randomSource.nextBoolean();
        Vec3 vec5 = zNextBoolean ? vec3 : vec4;
        Vec3 vec6 = zNextBoolean ? vec4 : vec3;
        int iNextInt = randomSource.nextInt(this.f5175ac.size());
        BlockEntity blockEntityCreate = ((BlockEntityType) ((Supplier) this.f5175ac.get(iNextInt)).get()).create(BlockPos.ZERO, ((Block) ((Supplier) this.f5176ad.get(iNextInt)).get()).defaultBlockState());
        if (blockEntityCreate != null) {
            this.f5174ab.add(new a(this.f5183a, this.f5178lE, blockEntityCreate, vec5, vec6, this.f5186aP, this.f5184g));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        this.f5174ab.removeIf(aVar -> {
            return aVar.m5154a(minecraft, c0623l, localPlayer, clientLevel, randomSource);
        });
        int i = this.f5185qe;
        this.f5185qe = i - 1;
        if (i <= 0) {
            this.f5185qe = this.f5177qg;
            int iNextInt = randomSource.nextInt(3);
            for (int i2 = 0; i2 < iNextInt; i2++) {
                m5140b(randomSource);
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    /* JADX INFO: renamed from: a */
    public void mo4650a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        ObjectListIterator it = this.f5174ab.iterator();
        while (it.hasNext()) {
            ((a) it.next()).m5155a(poseStack, minecraft, clientLevel, f2);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3944a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo3944a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        ObjectListIterator it = this.f5174ab.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            C0129bt.m574a(camera, poseStack, aVar.f5193ab, aVar.f5194o, 1.0f, 16729156);
            C0129bt.m574a(camera, poseStack, aVar.f5194o, aVar.f5190aa, 1.0f, 4521796);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal("FlyBy (Entities): " + this.f5174ab.size() + " active, " + this.f5176ad.size() + " plane types, speed=" + this.f5178lE));
        list.add(Component.literal("Spawn timer: " + this.f5185qe + "/" + this.f5177qg + " ticks"));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5172dX;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: bG */
    public boolean mo3955bG() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: cM */
    public void mo3956cM() {
        super.mo3956cM();
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3939a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo3939a(minecraft, randomSource);
        this.f5174ab.clear();
        this.f5185qe = 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4651a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.qy$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qy$a.class */
    private static class a {

        /* JADX INFO: renamed from: h */
        @Nullable
        private final Supplier<? extends SimpleParticleType> f5187h;

        /* JADX INFO: renamed from: lF */
        private final float f5188lF;

        /* JADX INFO: renamed from: a */
        private final BlockEntity f5189a;

        /* JADX INFO: renamed from: aa */
        private final Vec3 f5190aa;

        /* JADX INFO: renamed from: i */
        @Nullable
        private final Supplier<? extends SoundEvent> f5191i;

        /* JADX INFO: renamed from: aQ */
        private final double f5192aQ;

        /* JADX INFO: renamed from: ab */
        private final Vec3 f5193ab;

        /* JADX INFO: renamed from: o */
        private Vec3 f5194o;

        /* JADX INFO: renamed from: p */
        private Vec3 f5195p;

        /* JADX INFO: renamed from: bL */
        private boolean f5196bL = false;

        /* JADX INFO: renamed from: gG */
        private boolean f5197gG = false;

        public a(@Nullable Supplier<? extends SoundEvent> supplier, float f, @NotNull BlockEntity blockEntity, @NotNull Vec3 vec3, @NotNull Vec3 vec4, double d, @Nullable Supplier<? extends SimpleParticleType> supplier2) {
            this.f5188lF = f;
            this.f5189a = blockEntity;
            this.f5191i = supplier;
            this.f5192aQ = d;
            this.f5195p = vec3;
            this.f5194o = vec3;
            this.f5193ab = vec3;
            this.f5190aa = vec4;
            this.f5187h = supplier2;
            BlockEntity blockEntity2 = this.f5189a;
            if (blockEntity2 instanceof C0712mj) {
                ((C0712mj) blockEntity2).m3236bB();
            }
        }

        /* JADX INFO: renamed from: b */
        public void m5153b(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
            this.f5196bL = true;
            if (this.f5191i != null) {
                minecraft.getSoundManager().play(new b(this, this.f5191i.get(), 0.9f + (0.2f * randomSource.nextFloat()), 1.0f));
            }
        }

        /* JADX INFO: renamed from: a */
        public boolean m5154a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource) {
            this.f5195p = this.f5194o;
            this.f5194o = C1270xJ.m7163a(this.f5194o, this.f5190aa, this.f5188lF);
            double dSqrt = Mth.sqrt((float) localPlayer.distanceToSqr(this.f5194o.x, this.f5194o.y, this.f5194o.z));
            double d = this.f5188lF * 4.0f * 20.0f;
            if (!this.f5196bL) {
                if (this.f5192aQ != -1.0d) {
                    if (dSqrt <= this.f5192aQ) {
                        m5153b(minecraft, randomSource);
                    }
                } else if (dSqrt <= d) {
                    m5153b(minecraft, randomSource);
                }
            }
            float x = ((float) this.f5194o.x) - ((float) localPlayer.getX());
            float z = ((float) this.f5194o.z) - ((float) localPlayer.getZ());
            float fSqrt = Mth.sqrt((x * x) + (z * z));
            if (!this.f5197gG && fSqrt <= 20.0f) {
                this.f5197gG = true;
                C0432hU.m1986a(C0435hX.f2768r);
            }
            if (this.f5187h != null) {
                C0490iZ.m2218a(minecraft, c0623l, clientLevel, this.f5187h.get(), this.f5194o.x, this.f5194o.y, this.f5194o.z, 0.0d, 0.0d, 0.0d);
            }
            return this.f5194o.distanceTo(this.f5190aa) <= 1.0d;
        }

        /* JADX INFO: renamed from: a */
        public void m5155a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, float f) {
            if (this.f5189a == null) {
                return;
            }
            Vec3 vec3Normalize = this.f5190aa.subtract(this.f5194o).normalize();
            float degrees = (float) Math.toDegrees(Math.asin(-vec3Normalize.y));
            float degrees2 = (float) Math.toDegrees(Math.atan2(vec3Normalize.x, vec3Normalize.z));
            Vec3 vec3M7172b = C1270xJ.m7172b(this.f5194o, this.f5195p, f);
            C0129bt.m636a(minecraft, clientLevel, poseStack, this.f5189a, vec3M7172b.x, vec3M7172b.y, vec3M7172b.z, degrees, degrees2, f, false);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.qy$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qy$b.class */
    @OnlyIn(Dist.CLIENT)
    public static class b extends AbstractTickableSoundInstance {

        /* JADX INFO: renamed from: a */
        private final a f5198a;

        public b(@NotNull a aVar, @NotNull SoundEvent soundEvent, float f, float f2) {
            super(soundEvent, SoundSource.AMBIENT, SoundInstance.createUnseededRandom());
            this.f5198a = aVar;
            this.looping = false;
            this.pitch = f;
            this.volume = f2;
            this.x = (float) aVar.f5194o.x;
            this.y = (float) aVar.f5194o.y;
            this.z = (float) aVar.f5194o.z;
            this.attenuation = SoundInstance.Attenuation.NONE;
        }

        public void tick() {
            if (this.f5198a != null) {
                this.x = this.f5198a.f5194o.x;
                this.y = this.f5198a.f5194o.y;
                this.z = this.f5198a.f5194o.z;
            }
        }
    }
}
