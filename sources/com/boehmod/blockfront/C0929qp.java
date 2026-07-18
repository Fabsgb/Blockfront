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

/* JADX INFO: renamed from: com.boehmod.blockfront.qp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qp.class */
public class C0929qp extends AbstractC0885py {

    /* JADX INFO: renamed from: es */
    @NotNull
    private static final ResourceLocation f4918es = C0564jv.m2555d("textures/misc/debug/mapeffect/particle.png");

    /* JADX INFO: renamed from: B */
    @NotNull
    public static final MapCodec<C0929qp> f4919B = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.fieldOf("particleType").forGetter(c0929qp -> {
            return C1292xo.m7891a((ParticleType<?>) c0929qp.f4920a);
        }), Codec.INT.fieldOf("maxTick").forGetter(c0929qp2 -> {
            return Integer.valueOf(c0929qp2.f4921oz);
        }), Codec.STRING.optionalFieldOf("sound", "").forGetter(c0929qp3 -> {
            return c0929qp3.f4923j != null ? C1292xo.m7889f(c0929qp3.f4923j.get()) : "";
        }), Codec.FLOAT.fieldOf("soundVolume").forGetter(c0929qp4 -> {
            return Float.valueOf(c0929qp4.f4924kT);
        }), Codec.FLOAT.optionalFieldOf("spreadXZ", Float.valueOf(2.0f)).forGetter(c0929qp5 -> {
            return Float.valueOf(c0929qp5.f4925lo);
        }), Codec.FLOAT.optionalFieldOf("spreadY", Float.valueOf(0.0f)).forGetter(c0929qp6 -> {
            return Float.valueOf(c0929qp6.f4926lp);
        }), Codec.FLOAT.optionalFieldOf("activationDistance", Float.valueOf(512.0f)).forGetter(c0929qp7 -> {
            return Float.valueOf(c0929qp7.f4618kF);
        })).apply(instance, (str, num, str2, f, f2, f3, f4) -> {
            C0929qp c0929qp8 = new C0929qp();
            c0929qp8.f4920a = C1292xo.m7890e(str).get();
            c0929qp8.f4921oz = num.intValue();
            c0929qp8.f4923j = str2.isEmpty() ? null : C1292xo.m7888d(str2);
            c0929qp8.f4924kT = f.floatValue();
            c0929qp8.f4925lo = f2.floatValue();
            c0929qp8.f4926lp = f3.floatValue();
            c0929qp8.f4618kF = f4.floatValue();
            return c0929qp8;
        });
    });

    /* JADX INFO: renamed from: a */
    @NotNull
    private SimpleParticleType f4920a;

    /* JADX INFO: renamed from: oz */
    private int f4921oz;

    /* JADX INFO: renamed from: oA */
    private int f4922oA;

    /* JADX INFO: renamed from: j */
    @Nullable
    private Supplier<SoundEvent> f4923j;

    /* JADX INFO: renamed from: kT */
    private float f4924kT;

    /* JADX INFO: renamed from: lo */
    private float f4925lo;

    /* JADX INFO: renamed from: lp */
    private float f4926lp;

    public C0929qp() {
        this((SimpleParticleType) C1232wZ.f7287no.get(), Vec3.ZERO, 0);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    public C0929qp(@NotNull SimpleParticleType simpleParticleType, @NotNull Vec3 vec3, int i) {
        super(vec3);
        this.f4922oA = 0;
        this.f4923j = null;
        this.f4925lo = 2.0f;
        this.f4926lp = 0.0f;
        this.f4920a = simpleParticleType;
        this.f4921oz = i;
    }

    @Override // com.boehmod.blockfront.AbstractC0885py
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo4452b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f4922oA;
        this.f4922oA = i + 1;
        if (i <= this.f4921oz) {
            return;
        }
        this.f4922oA = 0;
        C0470iG.m2126a(minecraft, c0622l, clientLevel, this.f4920a, this.f4464c.x + ((double) ((randomSource.nextFloat() - 0.5f) * this.f4925lo)), this.f4464c.y + ((double) ((randomSource.nextFloat() - 0.5f) * this.f4926lp)), this.f4464c.z + ((double) ((randomSource.nextFloat() - 0.5f) * this.f4925lo)), 0.0d, 0.0d, 0.0d);
        if (this.f4923j != null) {
            clientLevel.playLocalSound(this.f4464c.x, this.f4464c.y, this.f4464c.z, this.f4923j.get(), SoundSource.AMBIENT, this.f4924kT, 1.0f, false);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0885py, com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("Particle: " + C1292xo.m7891a((ParticleType<?>) this.f4920a) + ", tick " + this.f4922oA + "/" + this.f4921oz));
        SoundEvent soundEvent = this.f4923j != null ? this.f4923j.get() : null;
        if (soundEvent != null) {
            list.add(Component.literal(String.format("Sound: %s (vol %.2f)", C1292xo.m7889f(soundEvent), Float.valueOf(this.f4924kT))));
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0885py, com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4221a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) throws MatchException {
        super.mo4221a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        LevelRenderer.renderLineBox(poseStack, bufferSource.getBuffer(RenderType.lines()), AABB.ofSize(this.f4464c, this.f4925lo, this.f4926lp, this.f4925lo), 1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0885py, com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0855pU(Component.literal("Particle Type"), () -> {
            return this.f4920a;
        }, simpleParticleType -> {
            this.f4920a = simpleParticleType;
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
        objectArrayList.add(new C0854pT(Component.literal("Max Tick"), () -> {
            return Integer.valueOf(this.f4921oz);
        }, num -> {
            this.f4921oz = num.intValue();
        }, 0, 12000));
        objectArrayList.add(new C0853pS(Component.literal("Spread X/Z"), () -> {
            return Float.valueOf(this.f4925lo);
        }, f -> {
            this.f4925lo = f.floatValue();
        }, 0.0f, 512.0f));
        objectArrayList.add(new C0853pS(Component.literal("Spread Y"), () -> {
            return Float.valueOf(this.f4926lp);
        }, f2 -> {
            this.f4926lp = f2.floatValue();
        }, 0.0f, 512.0f));
        objectArrayList.add(new C0856pV(Component.literal("Sound"), () -> {
            if (this.f4923j != null) {
                return this.f4923j.get();
            }
            return null;
        }, soundEvent -> {
            this.f4923j = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        objectArrayList.add(new C0853pS(Component.literal("Sound Volume"), () -> {
            return Float.valueOf(this.f4924kT);
        }, f3 -> {
            this.f4924kT = f3.floatValue();
        }, 0.0f, 4.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4918es;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: bw */
    public boolean mo4223bw() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: cA */
    public void mo4224cA() {
        super.mo4224cA();
    }

    @Override // com.boehmod.blockfront.AbstractC0885py, com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4225a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo4225a(minecraft, randomSource);
        this.f4922oA = 0;
    }
}
