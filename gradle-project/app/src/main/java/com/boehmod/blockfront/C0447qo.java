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
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.qo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qo.class */
public class C0447qo extends AbstractC0430py {

    @NotNull
    private static final ResourceLocation er = C0265jv.d("textures/misc/debug/mapeffect/sound_looping.png");

    @NotNull
    public static final MapCodec<C0447qo> A = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("sound", "").forGetter(c0447qo -> {
            return c0447qo.a != null ? C0636xo.f(c0447qo.a.get()) : "";
        }), Codec.FLOAT.fieldOf("volume").forGetter(c0447qo2 -> {
            return Float.valueOf(c0447qo2.gr);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0447qo3 -> {
            return Float.valueOf(c0447qo3.fZ);
        }), Codec.FLOAT.fieldOf("activationDistance").forGetter(c0447qo4 -> {
            return Float.valueOf(c0447qo4.kF);
        })).apply(instance, (str, f, f2, f3) -> {
            C0447qo c0447qo5 = new C0447qo();
            c0447qo5.a = str.isEmpty() ? null : C0636xo.d(str);
            c0447qo5.gr = f.floatValue();
            c0447qo5.fZ = f2.floatValue();
            c0447qo5.kF = f3.floatValue();
            return c0447qo5;
        });
    });

    @Nullable
    public Supplier<SoundEvent> a;
    private float fZ;
    private float gr;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0222ie f296a;

    public C0447qo() {
        this(C0624xc.Dr, Vec3.ZERO);
    }

    public C0447qo(@NotNull Supplier<SoundEvent> supplier, @NotNull Vec3 vec3) {
        super(vec3);
        this.fZ = 1.0f;
        this.gr = 1.0f;
        this.a = supplier;
        this.kF = 16.0f;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0430py
    @OnlyIn(Dist.CLIENT)
    protected void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        a(minecraft, oFVar);
    }

    @Override // com.boehmod.blockfront.AbstractC0430py
    @OnlyIn(Dist.CLIENT)
    protected void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        a(minecraft, oFVar);
    }

    @Override // com.boehmod.blockfront.AbstractC0430py
    @OnlyIn(Dist.CLIENT)
    protected void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        E(minecraft);
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull Minecraft minecraft, @NotNull oF<?, ?, ?> oFVar) {
        if (this.a == null) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        if (this.f296a == null) {
            this.f296a = new C0222ie(this.a.get(), this.c, this.fZ, this.gr, oFVar.m757e());
        }
        if (!soundManager.isActive(this.f296a)) {
            soundManager.play(this.f296a);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void E(@NotNull Minecraft minecraft) {
        if (this.f296a != null) {
            minecraft.getSoundManager().stop(this.f296a);
            this.f296a = null;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0430py, com.boehmod.blockfront.pA
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
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0430py, com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        SoundEvent soundEvent = this.a != null ? this.a.get() : null;
        list.add(Component.literal("Looping Sound: " + (soundEvent != null ? C0636xo.f(soundEvent) : "none")));
        list.add(Component.literal(String.format("Volume: %.2f, Pitch: %.2f", Float.valueOf(this.gr), Float.valueOf(this.fZ))));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return er;
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
    }

    @Override // com.boehmod.blockfront.AbstractC0430py, com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
        E(minecraft);
    }
}
