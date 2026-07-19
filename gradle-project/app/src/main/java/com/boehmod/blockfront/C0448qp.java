package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
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
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qp.class */
public class C0448qp extends AbstractC0430py {

    @NotNull
    private static final ResourceLocation es = C0265jv.d("textures/misc/debug/mapeffect/particle.png");

    @NotNull
    public static final MapCodec<C0448qp> B = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.fieldOf("particleType").forGetter(c0448qp -> {
            return C0636xo.a((ParticleType<?>) c0448qp.a);
        }), Codec.INT.fieldOf("maxTick").forGetter(c0448qp2 -> {
            return Integer.valueOf(c0448qp2.oz);
        }), Codec.STRING.optionalFieldOf("sound", "").forGetter(c0448qp3 -> {
            return c0448qp3.j != null ? C0636xo.f(c0448qp3.j.get()) : "";
        }), Codec.FLOAT.fieldOf("soundVolume").forGetter(c0448qp4 -> {
            return Float.valueOf(c0448qp4.kT);
        }), Codec.FLOAT.optionalFieldOf("spreadXZ", Float.valueOf(2.0f)).forGetter(c0448qp5 -> {
            return Float.valueOf(c0448qp5.lo);
        }), Codec.FLOAT.optionalFieldOf("spreadY", Float.valueOf(0.0f)).forGetter(c0448qp6 -> {
            return Float.valueOf(c0448qp6.lp);
        }), Codec.FLOAT.optionalFieldOf("activationDistance", Float.valueOf(512.0f)).forGetter(c0448qp7 -> {
            return Float.valueOf(c0448qp7.kF);
        })).apply(instance, (str, num, str2, f, f2, f3, f4) -> {
            C0448qp c0448qp8 = new C0448qp();
            c0448qp8.a = C0636xo.e(str).get();
            c0448qp8.oz = num.intValue();
            c0448qp8.j = str2.isEmpty() ? null : C0636xo.d(str2);
            c0448qp8.kT = f.floatValue();
            c0448qp8.lo = f2.floatValue();
            c0448qp8.lp = f3.floatValue();
            c0448qp8.kF = f4.floatValue();
            return c0448qp8;
        });
    });

    @NotNull
    private SimpleParticleType a;
    private int oz;
    private int oA;

    @Nullable
    private Supplier<SoundEvent> j;
    private float kT;
    private float lo;
    private float lp;

    public C0448qp() {
        this((SimpleParticleType) wZ.no.get(), Vec3.ZERO, 0);
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    public C0448qp(@NotNull SimpleParticleType simpleParticleType, @NotNull Vec3 vec3, int i) {
        super(vec3);
        this.oA = 0;
        this.j = null;
        this.lo = 2.0f;
        this.lp = 0.0f;
        this.a = simpleParticleType;
        this.oz = i;
    }

    @Override // com.boehmod.blockfront.AbstractC0430py
    @OnlyIn(Dist.CLIENT)
    protected void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.oA;
        this.oA = i + 1;
        if (i <= this.oz) {
            return;
        }
        this.oA = 0;
        iG.a(minecraft, c0297l, clientLevel, this.a, this.c.x + ((double) ((randomSource.nextFloat() - 0.5f) * this.lo)), this.c.y + ((double) ((randomSource.nextFloat() - 0.5f) * this.lp)), this.c.z + ((double) ((randomSource.nextFloat() - 0.5f) * this.lo)), 0.0d, 0.0d, 0.0d);
        if (this.j != null) {
            clientLevel.playLocalSound(this.c.x, this.c.y, this.c.z, this.j.get(), SoundSource.AMBIENT, this.kT, 1.0f, false);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0430py, com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal("Particle: " + C0636xo.a((ParticleType<?>) this.a) + ", tick " + this.oA + "/" + this.oz));
        SoundEvent soundEvent = this.j != null ? this.j.get() : null;
        if (soundEvent != null) {
            list.add(Component.literal(String.format("Sound: %s (vol %.2f)", C0636xo.f(soundEvent), Float.valueOf(this.kT))));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0430py, com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        LevelRenderer.renderLineBox(poseStack, bufferSource.getBuffer(RenderType.lines()), AABB.ofSize(this.c, this.lo, this.lp, this.lo), 1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0430py, com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pU(Component.literal("Particle Type"), () -> {
            return this.a;
        }, simpleParticleType -> {
            this.a = simpleParticleType;
        }, Component.literal("Select Particle Type"), () -> {
            ObjectArrayList objectArrayList2 = new ObjectArrayList();
            BuiltInRegistries.PARTICLE_TYPE.forEach(particleType -> {
                if (particleType instanceof SimpleParticleType) {
                    objectArrayList2.add((SimpleParticleType) particleType);
                }
            });
            return objectArrayList2;
        }, simpleParticleType2 -> {
            return BuiltInRegistries.PARTICLE_TYPE.getKey(simpleParticleType2).toString();
        }, simpleParticleType3 -> {
            return Component.literal(BuiltInRegistries.PARTICLE_TYPE.getKey(simpleParticleType3).toString());
        }));
        objectArrayList.add(new pT(Component.literal("Max Tick"), () -> {
            return Integer.valueOf(this.oz);
        }, num -> {
            this.oz = num.intValue();
        }, 0, 12000));
        objectArrayList.add(new pS(Component.literal("Spread X/Z"), () -> {
            return Float.valueOf(this.lo);
        }, f -> {
            this.lo = f.floatValue();
        }, 0.0f, 512.0f));
        objectArrayList.add(new pS(Component.literal("Spread Y"), () -> {
            return Float.valueOf(this.lp);
        }, f2 -> {
            this.lp = f2.floatValue();
        }, 0.0f, 512.0f));
        objectArrayList.add(new pV(Component.literal("Sound"), () -> {
            if (this.j != null) {
                return this.j.get();
            }
            return null;
        }, soundEvent -> {
            this.j = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        objectArrayList.add(new pS(Component.literal("Sound Volume"), () -> {
            return Float.valueOf(this.kT);
        }, f3 -> {
            this.kT = f3.floatValue();
        }, 0.0f, 4.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return es;
    }

    @Override // com.boehmod.blockfront.pA
    public boolean bw() {
        return true;
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
    }

    @Override // com.boehmod.blockfront.AbstractC0430py, com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
        this.oA = 0;
    }
}
