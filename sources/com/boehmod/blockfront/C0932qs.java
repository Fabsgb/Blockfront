package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.qs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qs.class */
public final class C0932qs extends AbstractC0835pA {

    /* JADX INFO: renamed from: E */
    @NotNull
    public static final MapCodec<C0932qs> f4950E = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("sound", "").forGetter(c0932qs -> {
            return c0932qs.f4952a != null ? C1292xo.m7889f(c0932qs.f4952a.get()) : "";
        }), Codec.INT.fieldOf("maxTime").forGetter(c0932qs2 -> {
            return Integer.valueOf(c0932qs2.f4953ne);
        }), Codec.FLOAT.fieldOf("volume").forGetter(c0932qs3 -> {
            return Float.valueOf(c0932qs3.f4955gr);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0932qs4 -> {
            return Float.valueOf(c0932qs4.f4956fZ);
        }), Codec.FLOAT.fieldOf("activationDistance").forGetter(c0932qs5 -> {
            return Float.valueOf(c0932qs5.f4957kF);
        })).apply(instance, (str, num, f, f2, f3) -> {
            C0932qs c0932qs6 = new C0932qs();
            c0932qs6.f4952a = str.isEmpty() ? null : C1292xo.m7888d(str);
            c0932qs6.f4953ne = num.intValue();
            c0932qs6.f4955gr = f.floatValue();
            c0932qs6.f4956fZ = f2.floatValue();
            c0932qs6.f4957kF = f3.floatValue();
            return c0932qs6;
        });
    });

    /* JADX INFO: renamed from: ev */
    @NotNull
    private static final ResourceLocation f4951ev = C0564jv.m2555d("textures/misc/debug/mapeffect/sound_looping.png");

    /* JADX INFO: renamed from: a */
    @Nullable
    public Supplier<SoundEvent> f4952a;

    /* JADX INFO: renamed from: ne */
    public int f4953ne;

    /* JADX INFO: renamed from: Z */
    public int f4954Z;

    /* JADX INFO: renamed from: gr */
    public float f4955gr;

    /* JADX INFO: renamed from: fZ */
    public float f4956fZ;

    /* JADX INFO: renamed from: kF */
    public float f4957kF;

    /* JADX INFO: renamed from: c */
    private SimpleSoundInstance f4958c;

    public C0932qs() {
        this(C1280xc.f8288Dr, Vec3.ZERO, 0);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    public C0932qs(@NotNull Supplier<SoundEvent> supplier, @NotNull Vec3 vec3, int i) {
        super(vec3);
        this.f4954Z = 0;
        this.f4955gr = 1.5f;
        this.f4956fZ = 1.0f;
        this.f4957kF = 25.0f;
        this.f4952a = supplier;
        this.f4953ne = i;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f4954Z;
        this.f4954Z = i - 1;
        if (i > 0) {
            return;
        }
        this.f4954Z = this.f4953ne;
        if (this.f4952a != null && Mth.sqrt((float) localPlayer.distanceToSqr(this.f4464c)) <= this.f4957kF) {
            this.f4958c = new SimpleSoundInstance(this.f4952a.get(), SoundSource.AMBIENT, this.f4955gr, this.f4956fZ, clientLevel.random, this.f4464c.x, this.f4464c.y, this.f4464c.z);
            minecraft.getSoundManager().play(this.f4958c);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0856pV(Component.literal("Sound"), () -> {
            if (this.f4952a != null) {
                return this.f4952a.get();
            }
            return null;
        }, soundEvent -> {
            this.f4952a = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        objectArrayList.add(new C0854pT(Component.literal("Max Time"), () -> {
            return Integer.valueOf(this.f4953ne);
        }, num -> {
            this.f4953ne = num.intValue();
        }, 0, 24000));
        objectArrayList.add(new C0853pS(Component.literal("Volume"), () -> {
            return Float.valueOf(this.f4955gr);
        }, f -> {
            this.f4955gr = f.floatValue();
        }, 0.0f, 2560.0f));
        objectArrayList.add(new C0853pS(Component.literal("Pitch"), () -> {
            return Float.valueOf(this.f4956fZ);
        }, f2 -> {
            this.f4956fZ = f2.floatValue();
        }, 0.0f, 2.0f));
        objectArrayList.add(new C0853pS(Component.literal("Activation Distance"), () -> {
            return Float.valueOf(this.f4957kF);
        }, f3 -> {
            this.f4957kF = f3.floatValue();
        }, 0.0f, 512.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        SoundEvent soundEvent = this.f4952a != null ? this.f4952a.get() : null;
        list.add(Component.literal("Timed Sound: " + (soundEvent != null ? C1292xo.m7889f(soundEvent) : "none")));
        list.add(Component.literal(String.format("Volume: %.2f, Pitch: %.2f, Distance: %.1f", Float.valueOf(this.f4955gr), Float.valueOf(this.f4956fZ), Float.valueOf(this.f4957kF))));
        list.add(Component.literal("Timer: " + this.f4954Z + "/" + this.f4953ne));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4951ev;
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

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4225a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo4225a(minecraft, randomSource);
        if (this.f4958c != null) {
            minecraft.getSoundManager().stop(this.f4958c);
            this.f4958c = null;
        }
        this.f4954Z = 0;
    }
}
