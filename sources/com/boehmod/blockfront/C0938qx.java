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

/* JADX INFO: renamed from: com.boehmod.blockfront.qx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qx.class */
public class C0938qx extends AbstractC0858pW implements InterfaceC0919qe {

    /* JADX INFO: renamed from: dW */
    @NotNull
    private static final ResourceLocation f5148dW = C0532jO.m2378d("textures/misc/debug/mapeffect/flyby.png");

    /* JADX INFO: renamed from: n */
    @NotNull
    public static final MapCodec<C0938qx> f5149n = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.INT.fieldOf("spawnInterval").forGetter(c0938qx -> {
            return Integer.valueOf(c0938qx.f5152qb);
        }), Codec.FLOAT.fieldOf("speed").forGetter(c0938qx2 -> {
            return Float.valueOf(c0938qx2.f5153fv);
        }), C0859pX.f4599C.fieldOf("min0").forGetter(c0938qx3 -> {
            return c0938qx3.f5154Q;
        }), C0859pX.f4599C.fieldOf("min1").forGetter(c0938qx4 -> {
            return c0938qx4.f5155R;
        }), C0859pX.f4599C.fieldOf("max0").forGetter(c0938qx5 -> {
            return c0938qx5.f5156S;
        }), C0859pX.f4599C.fieldOf("max1").forGetter(c0938qx6 -> {
            return c0938qx6.f5157T;
        }), ResourceLocation.CODEC.optionalFieldOf("soundEvent").forGetter(c0938qx7 -> {
            return Optional.ofNullable(c0938qx7.f5160a != null ? C1272xL.m7227a(c0938qx7.f5160a.get()) : null);
        }), Codec.INT.optionalFieldOf("soundDistanceMin", -1).forGetter(c0938qx8 -> {
            return Integer.valueOf(c0938qx8.f5158qc);
        }), ResourceLocation.CODEC.listOf().fieldOf("blocks").forGetter(c0938qx9 -> {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            ObjectListIterator it = c0938qx9.f5150Z.iterator();
            while (it.hasNext()) {
                objectArrayList.add(C1272xL.m7223a((Block) ((Supplier) it.next()).get()));
            }
            return objectArrayList;
        }), Codec.INT.optionalFieldOf("maxPlanesPerSpawn", 2).forGetter(c0938qx10 -> {
            return Integer.valueOf(c0938qx10.f5159qd);
        })).apply(instance, (num, f, vec3, vec4, vec5, vec6, optional, num2, list, num3) -> {
            C0938qx c0938qx11 = new C0938qx(num.intValue(), f.floatValue(), vec3, vec4, vec5, vec6);
            c0938qx11.f5160a = (Supplier) optional.map(C1272xL::m7228d).orElse(null);
            c0938qx11.f5158qc = num2.intValue();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c0938qx11.f5150Z.add(C1272xL.m7224b((ResourceLocation) it.next()));
            }
            c0938qx11.f5159qd = num3.intValue();
            return c0938qx11;
        });
    });

    /* JADX INFO: renamed from: Z */
    @NotNull
    private final ObjectList<Supplier<Block>> f5150Z;

    /* JADX INFO: renamed from: aa */
    @NotNull
    private final ObjectList<a> f5151aa;

    /* JADX INFO: renamed from: qb */
    private int f5152qb;

    /* JADX INFO: renamed from: fv */
    private float f5153fv;

    /* JADX INFO: renamed from: Q */
    private Vec3 f5154Q;

    /* JADX INFO: renamed from: R */
    private Vec3 f5155R;

    /* JADX INFO: renamed from: S */
    private Vec3 f5156S;

    /* JADX INFO: renamed from: T */
    private Vec3 f5157T;

    /* JADX INFO: renamed from: qc */
    private int f5158qc;

    /* JADX INFO: renamed from: qd */
    private int f5159qd;

    /* JADX INFO: renamed from: a */
    @Nullable
    private Supplier<? extends SoundEvent> f5160a;

    /* JADX INFO: renamed from: qe */
    private int f5161qe;

    public C0938qx() {
        this(0, 0.0f, Vec3.ZERO, 0, 0);
    }

    public C0938qx(int i, float f, @NotNull Vec3 vec3, int i2, int i3) {
        this(i, f, vec3.add(i2, i3, i2), vec3.add(i2, -i3, -i2), vec3.add(-i2, -i3, i2), vec3.add(-i2, i3, -i2));
    }

    public C0938qx(int i, float f, @NotNull Vec3 vec3, @NotNull Vec3 vec4, @NotNull Vec3 vec5, @NotNull Vec3 vec6) {
        this.f5150Z = new ObjectArrayList();
        this.f5151aa = new ObjectArrayList();
        this.f5158qc = -1;
        this.f5159qd = 2;
        this.f5160a = C1312xz.f8050qT;
        this.f5161qe = 0;
        this.f5152qb = i;
        this.f5153fv = f;
        this.f5154Q = vec3;
        this.f5155R = vec4;
        this.f5156S = vec5;
        this.f5157T = vec6;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    /* JADX INFO: renamed from: b */
    private void m5095b(@NotNull RandomSource randomSource) {
        if (this.f5150Z.isEmpty()) {
            return;
        }
        Vec3 vec3 = new Vec3(Mth.randomBetween(randomSource, (float) this.f5154Q.x, (float) this.f5155R.x), Mth.randomBetween(randomSource, (float) this.f5154Q.y, (float) this.f5155R.y), Mth.randomBetween(randomSource, (float) this.f5154Q.z, (float) this.f5155R.z));
        Vec3 vec4 = new Vec3(Mth.randomBetween(randomSource, (float) this.f5156S.x, (float) this.f5157T.x), Mth.randomBetween(randomSource, (float) this.f5156S.y, (float) this.f5157T.y), Mth.randomBetween(randomSource, (float) this.f5156S.z, (float) this.f5157T.z));
        boolean zNextBoolean = randomSource.nextBoolean();
        this.f5151aa.add(new a(this.f5160a, this.f5153fv, (Block) ((Supplier) this.f5150Z.getFirst()).get(), zNextBoolean ? vec3 : vec4, zNextBoolean ? vec4 : vec3, this.f5158qc));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        this.f5151aa.removeIf(aVar -> {
            return aVar.m5135a(minecraft, localPlayer, randomSource);
        });
        int i = this.f5161qe;
        this.f5161qe = i + 1;
        if (i >= this.f5152qb) {
            this.f5161qe = 0;
            int iNextInt = this.f5159qd > 0 ? randomSource.nextInt(this.f5159qd + 1) : 0;
            for (int i2 = 0; i2 < iNextInt; i2++) {
                m5095b(randomSource);
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    /* JADX INFO: renamed from: a */
    public void mo4650a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Random random, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, float f, float f2) {
        ObjectListIterator it = this.f5151aa.iterator();
        while (it.hasNext()) {
            ((a) it.next()).m5136a(poseStack, clientLevel, blockRenderDispatcher, bufferSource, f2);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3944a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo3944a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        ObjectListIterator it = this.f5151aa.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            C0129bt.m574a(camera, poseStack, aVar.f5167V, aVar.f5168o, 1.0f, 16729156);
            C0129bt.m574a(camera, poseStack, aVar.f5168o, aVar.f5164U, 1.0f, 4521796);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal("FlyBy: " + this.f5151aa.size() + " active, " + this.f5150Z.size() + " plane types, speed=" + this.f5153fv));
        list.add(Component.literal("Spawn timer: " + this.f5161qe + "/" + this.f5152qb + " ticks"));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5148dW;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0930qp(Component.literal("Spawn Interval"), () -> {
            return Integer.valueOf(this.f5152qb);
        }, num -> {
            this.f5152qb = num.intValue();
        }, 0, 24000));
        objectArrayList.add(new C0929qo(Component.literal("Speed"), () -> {
            return Float.valueOf(this.f5153fv);
        }, f -> {
            this.f5153fv = f.floatValue();
        }, 0.0f, 64.0f));
        objectArrayList.add(new C0935qu(Component.literal("Min 0"), () -> {
            return this.f5154Q;
        }, vec3 -> {
            this.f5154Q = vec3;
        }));
        objectArrayList.add(new C0935qu(Component.literal("Min 1"), () -> {
            return this.f5155R;
        }, vec4 -> {
            this.f5155R = vec4;
        }));
        objectArrayList.add(new C0935qu(Component.literal("Max 0"), () -> {
            return this.f5156S;
        }, vec5 -> {
            this.f5156S = vec5;
        }));
        objectArrayList.add(new C0935qu(Component.literal("Max 1"), () -> {
            return this.f5157T;
        }, vec6 -> {
            this.f5157T = vec6;
        }));
        objectArrayList.add(new C0932qr(Component.literal("Sound"), () -> {
            if (this.f5160a != null) {
                return this.f5160a.get();
            }
            return null;
        }, soundEvent -> {
            this.f5160a = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        objectArrayList.add(new C0930qp(Component.literal("Sound Distance Min"), () -> {
            return Integer.valueOf(this.f5158qc);
        }, num2 -> {
            this.f5158qc = num2.intValue();
        }, -1, 1024));
        objectArrayList.add(new C0931qq(Component.literal("Plane Block"), () -> {
            if (this.f5150Z.isEmpty()) {
                return null;
            }
            return (Block) ((Supplier) this.f5150Z.getFirst()).get();
        }, block -> {
            this.f5150Z.clear();
            if (block != null) {
                this.f5150Z.add(() -> {
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
        objectArrayList.add(new C0930qp(Component.literal("Max Planes Per Spawn"), () -> {
            return Integer.valueOf(this.f5159qd);
        }, num3 -> {
            this.f5159qd = num3.intValue();
        }, 0, 16));
        return objectArrayList;
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
        this.f5151aa.clear();
        this.f5161qe = 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0919qe
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public RenderLevelStageEvent.Stage mo4651a() {
        return RenderLevelStageEvent.Stage.AFTER_PARTICLES;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.qx$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qx$a.class */
    private static class a {

        /* JADX INFO: renamed from: lD */
        private final float f5162lD;

        /* JADX INFO: renamed from: a */
        private final Block f5163a;

        /* JADX INFO: renamed from: U */
        private final Vec3 f5164U;

        /* JADX INFO: renamed from: f */
        @Nullable
        private final Supplier<? extends SoundEvent> f5165f;

        /* JADX INFO: renamed from: qf */
        private final int f5166qf;

        /* JADX INFO: renamed from: V */
        private final Vec3 f5167V;

        /* JADX INFO: renamed from: o */
        private Vec3 f5168o;

        /* JADX INFO: renamed from: p */
        private Vec3 f5169p;

        /* JADX INFO: renamed from: bL */
        private boolean f5170bL = false;

        public a(@Nullable Supplier<? extends SoundEvent> supplier, float f, @NotNull Block block, @NotNull Vec3 vec3, @NotNull Vec3 vec4, int i) {
            this.f5162lD = f;
            this.f5163a = block;
            this.f5165f = supplier;
            this.f5166qf = i;
            this.f5169p = vec3;
            this.f5168o = vec3;
            this.f5167V = vec3;
            this.f5164U = vec4;
        }

        /* JADX INFO: renamed from: b */
        public void m5134b(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
            this.f5170bL = true;
            if (this.f5165f != null) {
                minecraft.getSoundManager().play(new b(this, this.f5165f.get(), 0.9f + (0.2f * randomSource.nextFloat()), 0.25f));
            }
        }

        /* JADX INFO: renamed from: a */
        public boolean m5135a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull RandomSource randomSource) {
            this.f5169p = this.f5168o;
            this.f5168o = C1270xJ.m7163a(this.f5168o, this.f5164U, this.f5162lD);
            if (!this.f5170bL) {
                double dSqrt = Mth.sqrt((float) localPlayer.distanceToSqr(this.f5168o.x, this.f5168o.y, this.f5168o.z));
                double d = this.f5162lD * 4.0f * 20.0f;
                if (this.f5166qf != -1.0f) {
                    if (dSqrt <= this.f5166qf) {
                        m5134b(minecraft, randomSource);
                    }
                } else if (dSqrt <= d) {
                    m5134b(minecraft, randomSource);
                }
            }
            return this.f5168o.distanceTo(this.f5164U) <= 1.0d;
        }

        /* JADX INFO: renamed from: a */
        public void m5136a(@NotNull PoseStack poseStack, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, float f) {
            double d = this.f5164U.x - this.f5168o.x;
            double d2 = this.f5164U.y - this.f5168o.y;
            double d3 = this.f5164U.z - this.f5168o.z;
            float f2 = (float) (-(Mth.atan2(d2, Mth.sqrt((float) ((d * d) + (d3 * d3)))) * 57.2957763671875d));
            float fAtan2 = ((float) (Mth.atan2(d3, d) * 57.2957763671875d)) + 90.0f;
            Vec3 vec3M7172b = C1270xJ.m7172b(this.f5168o, this.f5169p, f);
            C0129bt.m634a(clientLevel, blockRenderDispatcher, bufferSource, this.f5163a.defaultBlockState(), poseStack, vec3M7172b.x, vec3M7172b.y, vec3M7172b.z, f2, -fAtan2, 0.0f);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.qx$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qx$b.class */
    @OnlyIn(Dist.CLIENT)
    public static class b extends AbstractTickableSoundInstance {

        /* JADX INFO: renamed from: a */
        @NotNull
        private final a f5171a;

        public b(@NotNull a aVar, @NotNull SoundEvent soundEvent, float f, float f2) {
            super(soundEvent, SoundSource.AMBIENT, SoundInstance.createUnseededRandom());
            this.f5171a = aVar;
            this.looping = false;
            this.pitch = f;
            this.volume = f2;
            this.x = (float) aVar.f5168o.x;
            this.y = (float) aVar.f5168o.y;
            this.z = (float) aVar.f5168o.z;
            this.attenuation = SoundInstance.Attenuation.NONE;
        }

        public void tick() {
            if (this.f5171a != null) {
                this.x = this.f5171a.f5168o.x;
                this.y = this.f5171a.f5168o.y;
                this.z = this.f5171a.f5168o.z;
            }
        }
    }
}
