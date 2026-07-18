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

/* JADX INFO: renamed from: com.boehmod.blockfront.qb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qb.class */
public class C0915qb extends AbstractC0835pA implements InterfaceC0843pI {

    /* JADX INFO: renamed from: dY */
    @NotNull
    private static final ResourceLocation f4733dY = C0564jv.m2555d("textures/misc/debug/mapeffect/flyby.png");

    /* JADX INFO: renamed from: n */
    @NotNull
    public static final MapCodec<C0915qb> f4734n = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("spawnInterval").forGetter(c0915qb -> {
            return Integer.valueOf(c0915qb.f4737oc);
        }), Codec.FLOAT.fieldOf("speed").forGetter(c0915qb2 -> {
            return Float.valueOf(c0915qb2.f4738fl);
        }), C0836pB.f4470C.fieldOf("min0").forGetter(c0915qb3 -> {
            return c0915qb3.f4739P;
        }), C0836pB.f4470C.fieldOf("min1").forGetter(c0915qb4 -> {
            return c0915qb4.f4740Q;
        }), C0836pB.f4470C.fieldOf("max0").forGetter(c0915qb5 -> {
            return c0915qb5.f4741R;
        }), C0836pB.f4470C.fieldOf("max1").forGetter(c0915qb6 -> {
            return c0915qb6.f4742S;
        }), ResourceLocation.CODEC.optionalFieldOf("soundEvent").forGetter(c0915qb7 -> {
            return Optional.ofNullable(c0915qb7.f4745a != null ? C1292xo.m7900a(c0915qb7.f4745a.get()) : null);
        }), Codec.INT.optionalFieldOf("soundDistanceMin", -1).forGetter(c0915qb8 -> {
            return Integer.valueOf(c0915qb8.f4743od);
        }), ResourceLocation.CODEC.listOf().fieldOf("blocks").forGetter(c0915qb9 -> {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            ObjectListIterator it = c0915qb9.f4735Q.iterator();
            while (it.hasNext()) {
                objectArrayList.add(C1292xo.m7896a((Block) ((Supplier) it.next()).get()));
            }
            return objectArrayList;
        }), Codec.INT.optionalFieldOf("maxPlanesPerSpawn", 2).forGetter(c0915qb10 -> {
            return Integer.valueOf(c0915qb10.f4744oe);
        })).apply(instance, (num, f, vec3, vec32, vec33, vec34, optional, num2, list, num3) -> {
            C0915qb c0915qb11 = new C0915qb(num.intValue(), f.floatValue(), vec3, vec32, vec33, vec34);
            c0915qb11.f4745a = (Supplier) optional.map(C1292xo::m7901d).orElse(null);
            c0915qb11.f4743od = num2.intValue();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c0915qb11.f4735Q.add(C1292xo.m7897b((ResourceLocation) it.next()));
            }
            c0915qb11.f4744oe = num3.intValue();
            return c0915qb11;
        });
    });

    /* JADX INFO: renamed from: Q */
    @NotNull
    private final ObjectList<Supplier<Block>> f4735Q;

    /* JADX INFO: renamed from: R */
    @NotNull
    private final ObjectList<a> f4736R;

    /* JADX INFO: renamed from: oc */
    private int f4737oc;

    /* JADX INFO: renamed from: fl */
    private float f4738fl;

    /* JADX INFO: renamed from: P */
    private Vec3 f4739P;

    /* JADX INFO: renamed from: Q */
    private Vec3 f4740Q;

    /* JADX INFO: renamed from: R */
    private Vec3 f4741R;

    /* JADX INFO: renamed from: S */
    private Vec3 f4742S;

    /* JADX INFO: renamed from: od */
    private int f4743od;

    /* JADX INFO: renamed from: oe */
    private int f4744oe;

    /* JADX INFO: renamed from: a */
    @Nullable
    private Supplier<? extends SoundEvent> f4745a;

    /* JADX INFO: renamed from: of */
    private int f4746of;

    public C0915qb() {
        this(0, 0.0f, Vec3.ZERO, 0, 0);
    }

    public C0915qb(int i, float f, @NotNull Vec3 vec3, int i2, int i3) {
        this(i, f, vec3.add(i2, i3, i2), vec3.add(i2, -i3, -i2), vec3.add(-i2, -i3, i2), vec3.add(-i2, i3, -i2));
    }

    public C0915qb(int i, float f, @NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Vec3 vec33, @NotNull Vec3 vec34) {
        this.f4735Q = new ObjectArrayList();
        this.f4736R = new ObjectArrayList();
        this.f4743od = -1;
        this.f4744oe = 2;
        this.f4745a = C1280xc.f7638qR;
        this.f4746of = 0;
        this.f4737oc = i;
        this.f4738fl = f;
        this.f4739P = vec3;
        this.f4740Q = vec32;
        this.f4741R = vec33;
        this.f4742S = vec34;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    /* JADX INFO: renamed from: b */
    private void m4711b(@NotNull RandomSource randomSource) {
        if (this.f4735Q.isEmpty()) {
            return;
        }
        Vec3 vec3 = new Vec3(Mth.randomBetween(randomSource, (float) this.f4739P.x, (float) this.f4740Q.x), Mth.randomBetween(randomSource, (float) this.f4739P.y, (float) this.f4740Q.y), Mth.randomBetween(randomSource, (float) this.f4739P.z, (float) this.f4740Q.z));
        Vec3 vec32 = new Vec3(Mth.randomBetween(randomSource, (float) this.f4741R.x, (float) this.f4742S.x), Mth.randomBetween(randomSource, (float) this.f4741R.y, (float) this.f4742S.y), Mth.randomBetween(randomSource, (float) this.f4741R.z, (float) this.f4742S.z));
        boolean zNextBoolean = randomSource.nextBoolean();
        this.f4736R.add(new a(this.f4745a, this.f4738fl, (Block) ((Supplier) this.f4735Q.getFirst()).get(), zNextBoolean ? vec3 : vec32, zNextBoolean ? vec32 : vec3, this.f4743od));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        this.f4736R.removeIf(aVar -> {
            return aVar.m4751a(minecraft, localPlayer, randomSource);
        });
        int i = this.f4746of;
        this.f4746of = i + 1;
        if (i >= this.f4737oc) {
            this.f4746of = 0;
            int iNextInt = this.f4744oe > 0 ? randomSource.nextInt(this.f4744oe + 1) : 0;
            for (int i2 = 0; i2 < iNextInt; i2++) {
                m4711b(randomSource);
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    /* JADX INFO: renamed from: a */
    public void mo4270a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        ObjectListIterator it = this.f4736R.iterator();
        while (it.hasNext()) {
            ((a) it.next()).m4752a(poseStack, clientLevel, blockRenderDispatcher, bufferSource, f2);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4221a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo4221a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        ObjectListIterator it = this.f4736R.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            C0119bk.m474a(camera, poseStack, aVar.f4752U, aVar.f4753o, 1.0f, 16729156);
            C0119bk.m474a(camera, poseStack, aVar.f4753o, aVar.f4749T, 1.0f, 4521796);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("FlyBy: " + this.f4736R.size() + " active, " + this.f4735Q.size() + " plane types, speed=" + this.f4738fl));
        list.add(Component.literal("Spawn timer: " + this.f4746of + "/" + this.f4737oc + " ticks"));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4733dY;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0854pT(Component.literal("Spawn Interval"), () -> {
            return Integer.valueOf(this.f4737oc);
        }, num -> {
            this.f4737oc = num.intValue();
        }, 0, 24000));
        objectArrayList.add(new C0853pS(Component.literal("Speed"), () -> {
            return Float.valueOf(this.f4738fl);
        }, f -> {
            this.f4738fl = f.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new C0859pY(Component.literal("Min 0"), () -> {
            return this.f4739P;
        }, vec3 -> {
            this.f4739P = vec3;
        }));
        objectArrayList.add(new C0859pY(Component.literal("Min 1"), () -> {
            return this.f4740Q;
        }, vec32 -> {
            this.f4740Q = vec32;
        }));
        objectArrayList.add(new C0859pY(Component.literal("Max 0"), () -> {
            return this.f4741R;
        }, vec33 -> {
            this.f4741R = vec33;
        }));
        objectArrayList.add(new C0859pY(Component.literal("Max 1"), () -> {
            return this.f4742S;
        }, vec34 -> {
            this.f4742S = vec34;
        }));
        objectArrayList.add(new C0856pV(Component.literal("Sound"), () -> {
            if (this.f4745a != null) {
                return this.f4745a.get();
            }
            return null;
        }, soundEvent -> {
            this.f4745a = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        objectArrayList.add(new C0854pT(Component.literal("Sound Distance Min"), () -> {
            return Integer.valueOf(this.f4743od);
        }, num2 -> {
            this.f4743od = num2.intValue();
        }, -1, InterfaceC1294xq.f8656tR));
        objectArrayList.add(new C0855pU(Component.literal("Plane Block"), () -> {
            if (this.f4735Q.isEmpty()) {
                return null;
            }
            return (Block) ((Supplier) this.f4735Q.getFirst()).get();
        }, block -> {
            this.f4735Q.clear();
            if (block != null) {
                this.f4735Q.add(() -> {
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
        objectArrayList.add(new C0854pT(Component.literal("Max Planes Per Spawn"), () -> {
            return Integer.valueOf(this.f4744oe);
        }, num3 -> {
            this.f4744oe = num3.intValue();
        }, 0, 16));
        return objectArrayList;
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
        this.f4736R.clear();
        this.f4746of = 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0843pI
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4269a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.qb$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qb$a.class */
    private static class a {

        /* JADX INFO: renamed from: kI */
        private final float f4747kI;

        /* JADX INFO: renamed from: a */
        private final Block f4748a;

        /* JADX INFO: renamed from: T */
        private final Vec3 f4749T;

        /* JADX INFO: renamed from: f */
        @Nullable
        private final Supplier<? extends SoundEvent> f4750f;

        /* JADX INFO: renamed from: og */
        private final int f4751og;

        /* JADX INFO: renamed from: U */
        private final Vec3 f4752U;

        /* JADX INFO: renamed from: o */
        private Vec3 f4753o;

        /* JADX INFO: renamed from: p */
        private Vec3 f4754p;

        /* JADX INFO: renamed from: bE */
        private boolean f4755bE = false;

        public a(@Nullable Supplier<? extends SoundEvent> supplier, float f, @NotNull Block block, @NotNull Vec3 vec3, @NotNull Vec3 vec32, int i) {
            this.f4747kI = f;
            this.f4748a = block;
            this.f4750f = supplier;
            this.f4751og = i;
            this.f4754p = vec3;
            this.f4753o = vec3;
            this.f4752U = vec3;
            this.f4749T = vec32;
        }

        /* JADX INFO: renamed from: b */
        public void m4750b(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
            this.f4755bE = true;
            if (this.f4750f != null) {
                minecraft.getSoundManager().play(new b(this, this.f4750f.get(), 0.9f + (0.2f * randomSource.nextFloat()), 0.25f));
            }
        }

        /* JADX INFO: renamed from: a */
        public boolean m4751a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull RandomSource randomSource) {
            this.f4754p = this.f4753o;
            this.f4753o = C1290xm.m7837a(this.f4753o, this.f4749T, this.f4747kI);
            if (!this.f4755bE) {
                double dSqrt = Mth.sqrt((float) localPlayer.distanceToSqr(this.f4753o.x, this.f4753o.y, this.f4753o.z));
                double d = this.f4747kI * 4.0f * 20.0f;
                if (this.f4751og != -1.0f) {
                    if (dSqrt <= this.f4751og) {
                        m4750b(minecraft, randomSource);
                    }
                } else if (dSqrt <= d) {
                    m4750b(minecraft, randomSource);
                }
            }
            return this.f4753o.distanceTo(this.f4749T) <= 1.0d;
        }

        /* JADX INFO: renamed from: a */
        public void m4752a(@NotNull PoseStack poseStack, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, float f) {
            double d = this.f4749T.x - this.f4753o.x;
            double d2 = this.f4749T.y - this.f4753o.y;
            double d3 = this.f4749T.z - this.f4753o.z;
            float f2 = (float) (-(Mth.atan2(d2, Mth.sqrt((float) ((d * d) + (d3 * d3)))) * 57.2957763671875d));
            float fAtan2 = ((float) (Mth.atan2(d3, d) * 57.2957763671875d)) + 90.0f;
            Vec3 vec3M7845b = C1290xm.m7845b(this.f4753o, this.f4754p, f);
            C0119bk.m532a(clientLevel, blockRenderDispatcher, bufferSource, this.f4748a.defaultBlockState(), poseStack, vec3M7845b.x, vec3M7845b.y, vec3M7845b.z, f2, -fAtan2, 0.0f);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.qb$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qb$b.class */
    @OnlyIn(Dist.CLIENT)
    public static class b extends AbstractTickableSoundInstance {

        /* JADX INFO: renamed from: a */
        @NotNull
        private final a f4756a;

        public b(@NotNull a aVar, @NotNull SoundEvent soundEvent, float f, float f2) {
            super(soundEvent, SoundSource.AMBIENT, SoundInstance.createUnseededRandom());
            this.f4756a = aVar;
            this.looping = false;
            this.pitch = f;
            this.volume = f2;
            this.x = (float) aVar.f4753o.x;
            this.y = (float) aVar.f4753o.y;
            this.z = (float) aVar.f4753o.z;
            this.attenuation = SoundInstance.Attenuation.NONE;
        }

        public void tick() {
            if (this.f4756a != null) {
                this.x = this.f4756a.f4753o.x;
                this.y = this.f4756a.f4753o.y;
                this.z = this.f4756a.f4753o.z;
            }
        }
    }
}
