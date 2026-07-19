package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
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
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qb.class */
public class C0434qb extends pA implements pI {

    @NotNull
    private static final ResourceLocation dY = C0265jv.d("textures/misc/debug/mapeffect/flyby.png");

    @NotNull
    public static final MapCodec<C0434qb> n = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("spawnInterval").forGetter(c0434qb -> {
            return Integer.valueOf(c0434qb.oc);
        }), Codec.FLOAT.fieldOf("speed").forGetter(c0434qb2 -> {
            return Float.valueOf(c0434qb2.fl);
        }), pB.C.fieldOf("min0").forGetter(c0434qb3 -> {
            return c0434qb3.P;
        }), pB.C.fieldOf("min1").forGetter(c0434qb4 -> {
            return c0434qb4.f290Q;
        }), pB.C.fieldOf("max0").forGetter(c0434qb5 -> {
            return c0434qb5.f291R;
        }), pB.C.fieldOf("max1").forGetter(c0434qb6 -> {
            return c0434qb6.S;
        }), ResourceLocation.CODEC.optionalFieldOf("soundEvent").forGetter(c0434qb7 -> {
            return Optional.ofNullable(c0434qb7.a != null ? C0636xo.a(c0434qb7.a.get()) : null);
        }), Codec.INT.optionalFieldOf("soundDistanceMin", -1).forGetter(c0434qb8 -> {
            return Integer.valueOf(c0434qb8.od);
        }), ResourceLocation.CODEC.listOf().fieldOf("blocks").forGetter(c0434qb9 -> {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            ObjectListIterator it = c0434qb9.Q.iterator();
            while (it.hasNext()) {
                objectArrayList.add(C0636xo.a((Block) ((Supplier) it.next()).get()));
            }
            return objectArrayList;
        }), Codec.INT.optionalFieldOf("maxPlanesPerSpawn", 2).forGetter(c0434qb10 -> {
            return Integer.valueOf(c0434qb10.oe);
        })).apply(instance, (num, f, vec3, vec32, vec33, vec34, optional, num2, list, num3) -> {
            C0434qb c0434qb11 = new C0434qb(num.intValue(), f.floatValue(), vec3, vec32, vec33, vec34);
            c0434qb11.a = (Supplier) optional.map(C0636xo::d).orElse(null);
            c0434qb11.od = num2.intValue();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c0434qb11.Q.add(C0636xo.b((ResourceLocation) it.next()));
            }
            c0434qb11.oe = num3.intValue();
            return c0434qb11;
        });
    });

    @NotNull
    private final ObjectList<Supplier<Block>> Q;

    @NotNull
    private final ObjectList<a> R;
    private int oc;
    private float fl;
    private Vec3 P;

    /* JADX INFO: renamed from: Q, reason: collision with other field name */
    private Vec3 f290Q;

    /* JADX INFO: renamed from: R, reason: collision with other field name */
    private Vec3 f291R;
    private Vec3 S;
    private int od;
    private int oe;

    @Nullable
    private Supplier<? extends SoundEvent> a;
    private int of;

    public C0434qb() {
        this(0, 0.0f, Vec3.ZERO, 0, 0);
    }

    public C0434qb(int i, float f, @NotNull Vec3 vec3, int i2, int i3) {
        this(i, f, vec3.add(i2, i3, i2), vec3.add(i2, -i3, -i2), vec3.add(-i2, -i3, i2), vec3.add(-i2, i3, -i2));
    }

    public C0434qb(int i, float f, @NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Vec3 vec33, @NotNull Vec3 vec34) {
        this.Q = new ObjectArrayList();
        this.R = new ObjectArrayList();
        this.od = -1;
        this.oe = 2;
        this.a = C0624xc.qR;
        this.of = 0;
        this.oc = i;
        this.fl = f;
        this.P = vec3;
        this.f290Q = vec32;
        this.f291R = vec33;
        this.S = vec34;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    private void b(@NotNull RandomSource randomSource) {
        if (this.Q.isEmpty()) {
            return;
        }
        Vec3 vec3 = new Vec3(Mth.randomBetween(randomSource, (float) this.P.x, (float) this.f290Q.x), Mth.randomBetween(randomSource, (float) this.P.y, (float) this.f290Q.y), Mth.randomBetween(randomSource, (float) this.P.z, (float) this.f290Q.z));
        Vec3 vec32 = new Vec3(Mth.randomBetween(randomSource, (float) this.f291R.x, (float) this.S.x), Mth.randomBetween(randomSource, (float) this.f291R.y, (float) this.S.y), Mth.randomBetween(randomSource, (float) this.f291R.z, (float) this.S.z));
        boolean zNextBoolean = randomSource.nextBoolean();
        this.R.add(new a(this.a, this.fl, (Block) ((Supplier) this.Q.getFirst()).get(), zNextBoolean ? vec3 : vec32, zNextBoolean ? vec32 : vec3, this.od));
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        this.R.removeIf(aVar -> {
            return aVar.a(minecraft, localPlayer, randomSource);
        });
        int i = this.of;
        this.of = i + 1;
        if (i >= this.oc) {
            this.of = 0;
            int iNextInt = this.oe > 0 ? randomSource.nextInt(this.oe + 1) : 0;
            for (int i2 = 0; i2 < iNextInt; i2++) {
                b(randomSource);
            }
        }
    }

    @Override // com.boehmod.blockfront.pI
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        ObjectListIterator it = this.R.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(poseStack, clientLevel, blockRenderDispatcher, bufferSource, f2);
        }
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        ObjectListIterator it = this.R.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            C0040bk.a(camera, poseStack, aVar.U, aVar.o, 1.0f, 16729156);
            C0040bk.a(camera, poseStack, aVar.o, aVar.T, 1.0f, 4521796);
        }
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal("FlyBy: " + this.R.size() + " active, " + this.Q.size() + " plane types, speed=" + this.fl));
        list.add(Component.literal("Spawn timer: " + this.of + "/" + this.oc + " ticks"));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return dY;
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pT(Component.literal("Spawn Interval"), () -> {
            return Integer.valueOf(this.oc);
        }, num -> {
            this.oc = num.intValue();
        }, 0, 24000));
        objectArrayList.add(new pS(Component.literal("Speed"), () -> {
            return Float.valueOf(this.fl);
        }, f -> {
            this.fl = f.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new pY(Component.literal("Min 0"), () -> {
            return this.P;
        }, vec3 -> {
            this.P = vec3;
        }));
        objectArrayList.add(new pY(Component.literal("Min 1"), () -> {
            return this.f290Q;
        }, vec32 -> {
            this.f290Q = vec32;
        }));
        objectArrayList.add(new pY(Component.literal("Max 0"), () -> {
            return this.f291R;
        }, vec33 -> {
            this.f291R = vec33;
        }));
        objectArrayList.add(new pY(Component.literal("Max 1"), () -> {
            return this.S;
        }, vec34 -> {
            this.S = vec34;
        }));
        objectArrayList.add(new pV(Component.literal("Sound"), () -> {
            if (this.a != null) {
                return this.a.get();
            }
            return null;
        }, soundEvent -> {
            this.a = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        objectArrayList.add(new pT(Component.literal("Sound Distance Min"), () -> {
            return Integer.valueOf(this.od);
        }, num2 -> {
            this.od = num2.intValue();
        }, -1, InterfaceC0638xq.tR));
        objectArrayList.add(new pU(Component.literal("Plane Block"), () -> {
            if (this.Q.isEmpty()) {
                return null;
            }
            return (Block) ((Supplier) this.Q.getFirst()).get();
        }, block -> {
            this.Q.clear();
            if (block != null) {
                this.Q.add(() -> {
                    return block;
                });
            }
        }, Component.literal("Select Plane Block"), () -> {
            return new ObjectArrayList(BuiltInRegistries.BLOCK.stream().toList());
        }, block2 -> {
            return BuiltInRegistries.BLOCK.getKey(block2).toString();
        }, block3 -> {
            return Component.literal(BuiltInRegistries.BLOCK.getKey(block3).toString());
        }));
        objectArrayList.add(new pT(Component.literal("Max Planes Per Spawn"), () -> {
            return Integer.valueOf(this.oe);
        }, num3 -> {
            this.oe = num3.intValue();
        }, 0, 16));
        return objectArrayList;
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
        this.R.clear();
        this.of = 0;
    }

    @Override // com.boehmod.blockfront.pI
    @OnlyIn(Dist.CLIENT)
    public RenderLevelStageEvent.Stage a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.qb$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qb$a.class */
    private static class a {
        private final float kI;
        private final Block a;
        private final Vec3 T;

        @Nullable
        private final Supplier<? extends SoundEvent> f;
        private final int og;
        private final Vec3 U;
        private Vec3 o;
        private Vec3 p;
        private boolean bE = false;

        public a(@Nullable Supplier<? extends SoundEvent> supplier, float f, @NotNull Block block, @NotNull Vec3 vec3, @NotNull Vec3 vec32, int i) {
            this.kI = f;
            this.a = block;
            this.f = supplier;
            this.og = i;
            this.p = vec3;
            this.o = vec3;
            this.U = vec3;
            this.T = vec32;
        }

        public void b(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
            this.bE = true;
            if (this.f != null) {
                minecraft.getSoundManager().play(new b(this, this.f.get(), 0.9f + (0.2f * randomSource.nextFloat()), 0.25f));
            }
        }

        public boolean a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull RandomSource randomSource) {
            this.p = this.o;
            this.o = C0634xm.a(this.o, this.T, this.kI);
            if (!this.bE) {
                double dSqrt = Mth.sqrt((float) localPlayer.distanceToSqr(this.o.x, this.o.y, this.o.z));
                double d = this.kI * 4.0f * 20.0f;
                if (this.og != -1.0f) {
                    if (dSqrt <= this.og) {
                        b(minecraft, randomSource);
                    }
                } else if (dSqrt <= d) {
                    b(minecraft, randomSource);
                }
            }
            return this.o.distanceTo(this.T) <= 1.0d;
        }

        public void a(@NotNull PoseStack poseStack, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, float f) {
            double d = this.T.x - this.o.x;
            double d2 = this.T.y - this.o.y;
            double d3 = this.T.z - this.o.z;
            float f2 = (float) (-(Mth.atan2(d2, Mth.sqrt((float) ((d * d) + (d3 * d3)))) * 57.2957763671875d));
            float fAtan2 = ((float) (Mth.atan2(d3, d) * 57.2957763671875d)) + 90.0f;
            Vec3 vec3B = C0634xm.b(this.o, this.p, f);
            C0040bk.a(clientLevel, blockRenderDispatcher, bufferSource, this.a.defaultBlockState(), poseStack, vec3B.x, vec3B.y, vec3B.z, f2, -fAtan2, 0.0f);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.qb$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qb$b.class */
    @OnlyIn(Dist.CLIENT)
    public static class b extends AbstractTickableSoundInstance {

        @NotNull
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
