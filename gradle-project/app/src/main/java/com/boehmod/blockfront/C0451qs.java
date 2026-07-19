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

/* JADX INFO: renamed from: com.boehmod.blockfront.qs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qs.class */
public final class C0451qs extends pA {

    @NotNull
    public static final MapCodec<C0451qs> E = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("sound", "").forGetter(c0451qs -> {
            return c0451qs.a != null ? C0636xo.f(c0451qs.a.get()) : "";
        }), Codec.INT.fieldOf("maxTime").forGetter(c0451qs2 -> {
            return Integer.valueOf(c0451qs2.ne);
        }), Codec.FLOAT.fieldOf("volume").forGetter(c0451qs3 -> {
            return Float.valueOf(c0451qs3.gr);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0451qs4 -> {
            return Float.valueOf(c0451qs4.fZ);
        }), Codec.FLOAT.fieldOf("activationDistance").forGetter(c0451qs5 -> {
            return Float.valueOf(c0451qs5.kF);
        })).apply(instance, (str, num, f, f2, f3) -> {
            C0451qs c0451qs6 = new C0451qs();
            c0451qs6.a = str.isEmpty() ? null : C0636xo.d(str);
            c0451qs6.ne = num.intValue();
            c0451qs6.gr = f.floatValue();
            c0451qs6.fZ = f2.floatValue();
            c0451qs6.kF = f3.floatValue();
            return c0451qs6;
        });
    });

    @NotNull
    private static final ResourceLocation ev = C0265jv.d("textures/misc/debug/mapeffect/sound_looping.png");

    @Nullable
    public Supplier<SoundEvent> a;
    public int ne;
    public int Z;
    public float gr;
    public float fZ;
    public float kF;
    private SimpleSoundInstance c;

    public C0451qs() {
        this(C0624xc.Dr, Vec3.ZERO, 0);
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    public C0451qs(@NotNull Supplier<SoundEvent> supplier, @NotNull Vec3 vec3, int i) {
        super(vec3);
        this.Z = 0;
        this.gr = 1.5f;
        this.fZ = 1.0f;
        this.kF = 25.0f;
        this.a = supplier;
        this.ne = i;
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.Z;
        this.Z = i - 1;
        if (i > 0) {
            return;
        }
        this.Z = this.ne;
        if (this.a != null && Mth.sqrt((float) localPlayer.distanceToSqr(this.c)) <= this.kF) {
            this.c = new SimpleSoundInstance(this.a.get(), SoundSource.AMBIENT, this.gr, this.fZ, clientLevel.random, this.c.x, this.c.y, this.c.z);
            minecraft.getSoundManager().play(this.c);
        }
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
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
        objectArrayList.add(new pT(Component.literal("Max Time"), () -> {
            return Integer.valueOf(this.ne);
        }, num -> {
            this.ne = num.intValue();
        }, 0, 24000));
        objectArrayList.add(new pS(Component.literal("Volume"), () -> {
            return Float.valueOf(this.gr);
        }, f -> {
            this.gr = f.floatValue();
        }, 0.0f, 2560.0f));
        objectArrayList.add(new pS(Component.literal("Pitch"), () -> {
            return Float.valueOf(this.fZ);
        }, f2 -> {
            this.fZ = f2.floatValue();
        }, 0.0f, 2.0f));
        objectArrayList.add(new pS(Component.literal("Activation Distance"), () -> {
            return Float.valueOf(this.kF);
        }, f3 -> {
            this.kF = f3.floatValue();
        }, 0.0f, 512.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        SoundEvent soundEvent = this.a != null ? this.a.get() : null;
        list.add(Component.literal("Timed Sound: " + (soundEvent != null ? C0636xo.f(soundEvent) : "none")));
        list.add(Component.literal(String.format("Volume: %.2f, Pitch: %.2f, Distance: %.1f", Float.valueOf(this.gr), Float.valueOf(this.fZ), Float.valueOf(this.kF))));
        list.add(Component.literal("Timer: " + this.Z + "/" + this.ne));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return ev;
    }

    @Override // com.boehmod.blockfront.pA
    public boolean bw() {
        return true;
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
        if (this.c != null) {
            minecraft.getSoundManager().stop(this.c);
            this.c = null;
        }
        this.Z = 0;
    }
}
