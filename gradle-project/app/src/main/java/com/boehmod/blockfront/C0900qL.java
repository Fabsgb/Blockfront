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

/* JADX INFO: renamed from: com.boehmod.blockfront.qL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qL.class */
public class C0900qL extends AbstractC0856pU {

    /* JADX INFO: renamed from: eq */
    @NotNull
    private static final ResourceLocation f4999eq = C0532jO.m2378d("textures/misc/debug/mapeffect/particle.png");

    /* JADX INFO: renamed from: B */
    @NotNull
    public static final MapCodec<C0900qL> f5000B = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.fieldOf("particleType").forGetter(c0900qL -> {
            return C1272xL.m7218a((ParticleType<?>) c0900qL.f5001a);
        }), Codec.INT.fieldOf("maxTick").forGetter(c0900qL2 -> {
            return Integer.valueOf(c0900qL2.f5002qy);
        }), Codec.STRING.optionalFieldOf("sound", "").forGetter(c0900qL3 -> {
            return c0900qL3.f5004j != null ? C1272xL.m7216f(c0900qL3.f5004j.get()) : "";
        }), Codec.FLOAT.fieldOf("soundVolume").forGetter(c0900qL4 -> {
            return Float.valueOf(c0900qL4.f5005lO);
        }), Codec.FLOAT.optionalFieldOf("spreadXZ", Float.valueOf(2.0f)).forGetter(c0900qL5 -> {
            return Float.valueOf(c0900qL5.f5006ml);
        }), Codec.FLOAT.optionalFieldOf("spreadY", Float.valueOf(0.0f)).forGetter(c0900qL6 -> {
            return Float.valueOf(c0900qL6.f5007mm);
        }), Codec.FLOAT.optionalFieldOf("activationDistance", Float.valueOf(512.0f)).forGetter(c0900qL7 -> {
            return Float.valueOf(c0900qL7.f4587lA);
        })).apply(instance, (str, num, str2, f, f2, f3, f4) -> {
            C0900qL c0900qL8 = new C0900qL();
            c0900qL8.f5001a = C1272xL.m7217e(str).get();
            c0900qL8.f5002qy = num.intValue();
            c0900qL8.f5004j = str2.isEmpty() ? null : C1272xL.m7215d(str2);
            c0900qL8.f5005lO = f.floatValue();
            c0900qL8.f5006ml = f2.floatValue();
            c0900qL8.f5007mm = f3.floatValue();
            c0900qL8.f4587lA = f4.floatValue();
            return c0900qL8;
        });
    });

    /* JADX INFO: renamed from: a */
    @NotNull
    private SimpleParticleType f5001a;

    /* JADX INFO: renamed from: qy */
    private int f5002qy;

    /* JADX INFO: renamed from: qz */
    private int f5003qz;

    /* JADX INFO: renamed from: j */
    @Nullable
    private Supplier<SoundEvent> f5004j;

    /* JADX INFO: renamed from: lO */
    private float f5005lO;

    /* JADX INFO: renamed from: ml */
    private float f5006ml;

    /* JADX INFO: renamed from: mm */
    private float f5007mm;

    public C0900qL() {
        this((SimpleParticleType) C1309xw.f7852no.get(), Vec3.ZERO, 0);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    public C0900qL(@NotNull SimpleParticleType simpleParticleType, @NotNull Vec3 vec3, int i) {
        super(vec3);
        this.f5003qz = 0;
        this.f5004j = null;
        this.f5006ml = 2.0f;
        this.f5007mm = 0.0f;
        this.f5001a = simpleParticleType;
        this.f5002qy = i;
    }

    @Override // com.boehmod.blockfront.AbstractC0856pU
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo3943b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f5003qz;
        this.f5003qz = i + 1;
        if (i <= this.f5002qy) {
            return;
        }
        this.f5003qz = 0;
        C0490iZ.m2218a(minecraft, c0623l, clientLevel, this.f5001a, this.f4593c.x + ((double) ((randomSource.nextFloat() - 0.5f) * this.f5006ml)), this.f4593c.y + ((double) ((randomSource.nextFloat() - 0.5f) * this.f5007mm)), this.f4593c.z + ((double) ((randomSource.nextFloat() - 0.5f) * this.f5006ml)), 0.0d, 0.0d, 0.0d);
        if (this.f5004j != null) {
            clientLevel.playLocalSound(this.f4593c.x, this.f4593c.y, this.f4593c.z, this.f5004j.get(), SoundSource.AMBIENT, this.f5005lO, 1.0f, false);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0856pU, com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal("Particle: " + C1272xL.m7218a((ParticleType<?>) this.f5001a) + ", tick " + this.f5003qz + "/" + this.f5002qy));
        SoundEvent soundEvent = this.f5004j != null ? this.f5004j.get() : null;
        if (soundEvent != null) {
            list.add(Component.literal(String.format("Sound: %s (vol %.2f)", C1272xL.m7216f(soundEvent), Float.valueOf(this.f5005lO))));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0856pU, com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3944a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo3944a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        LevelRenderer.renderLineBox(poseStack, bufferSource.getBuffer(RenderType.lines()), AABB.ofSize(this.f4593c, this.f5006ml, this.f5007mm, this.f5006ml), 1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0856pU, com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0931qq(Component.literal("Particle Type"), () -> {
            return this.f5001a;
        }, simpleParticleType -> {
            this.f5001a = simpleParticleType;
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
        objectArrayList.add(new C0930qp(Component.literal("Max Tick"), () -> {
            return Integer.valueOf(this.f5002qy);
        }, num -> {
            this.f5002qy = num.intValue();
        }, 0, 12000));
        objectArrayList.add(new C0929qo(Component.literal("Spread X/Z"), () -> {
            return Float.valueOf(this.f5006ml);
        }, f -> {
            this.f5006ml = f.floatValue();
        }, 0.0f, 512.0f));
        objectArrayList.add(new C0929qo(Component.literal("Spread Y"), () -> {
            return Float.valueOf(this.f5007mm);
        }, f2 -> {
            this.f5007mm = f2.floatValue();
        }, 0.0f, 512.0f));
        objectArrayList.add(new C0932qr(Component.literal("Sound"), () -> {
            if (this.f5004j != null) {
                return this.f5004j.get();
            }
            return null;
        }, soundEvent -> {
            this.f5004j = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        objectArrayList.add(new C0929qo(Component.literal("Sound Volume"), () -> {
            return Float.valueOf(this.f5005lO);
        }, f3 -> {
            this.f5005lO = f3.floatValue();
        }, 0.0f, 4.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f4999eq;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: bG */
    public boolean mo3955bG() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: cM */
    public void mo3956cM() {
        super.mo3956cM();
    }

    @Override // com.boehmod.blockfront.AbstractC0856pU, com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3939a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo3939a(minecraft, randomSource);
        this.f5003qz = 0;
    }
}
