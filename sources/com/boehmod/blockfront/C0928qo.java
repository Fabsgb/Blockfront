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

/* JADX INFO: renamed from: com.boehmod.blockfront.qo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qo.class */
public class C0928qo extends AbstractC0885py {

    /* JADX INFO: renamed from: er */
    @NotNull
    private static final ResourceLocation f4912er = C0564jv.m2555d("textures/misc/debug/mapeffect/sound_looping.png");

    /* JADX INFO: renamed from: A */
    @NotNull
    public static final MapCodec<C0928qo> f4913A = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("sound", "").forGetter(c0928qo -> {
            return c0928qo.f4914a != null ? C1292xo.m7889f(c0928qo.f4914a.get()) : "";
        }), Codec.FLOAT.fieldOf("volume").forGetter(c0928qo2 -> {
            return Float.valueOf(c0928qo2.f4916gr);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0928qo3 -> {
            return Float.valueOf(c0928qo3.f4915fZ);
        }), Codec.FLOAT.fieldOf("activationDistance").forGetter(c0928qo4 -> {
            return Float.valueOf(c0928qo4.f4618kF);
        })).apply(instance, (str, f, f2, f3) -> {
            C0928qo c0928qo5 = new C0928qo();
            c0928qo5.f4914a = str.isEmpty() ? null : C1292xo.m7888d(str);
            c0928qo5.f4916gr = f.floatValue();
            c0928qo5.f4915fZ = f2.floatValue();
            c0928qo5.f4618kF = f3.floatValue();
            return c0928qo5;
        });
    });

    /* JADX INFO: renamed from: a */
    @Nullable
    public Supplier<SoundEvent> f4914a;

    /* JADX INFO: renamed from: fZ */
    private float f4915fZ;

    /* JADX INFO: renamed from: gr */
    private float f4916gr;

    /* JADX INFO: renamed from: a */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0494ie f4917a;

    public C0928qo() {
        this(C1280xc.f8288Dr, Vec3.ZERO);
    }

    public C0928qo(@NotNull Supplier<SoundEvent> supplier, @NotNull Vec3 vec3) {
        super(vec3);
        this.f4915fZ = 1.0f;
        this.f4916gr = 1.0f;
        this.f4914a = supplier;
        this.f4618kF = 16.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0885py
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo4450a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        m4944a(minecraft, abstractC0787oF);
    }

    @Override // com.boehmod.blockfront.AbstractC0885py
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo4452b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        m4944a(minecraft, abstractC0787oF);
    }

    @Override // com.boehmod.blockfront.AbstractC0885py
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo4451b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        m4945E(minecraft);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m4944a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        if (this.f4914a == null) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        if (this.f4917a == null) {
            this.f4917a = new C0494ie(this.f4914a.get(), this.f4464c, this.f4915fZ, this.f4916gr, abstractC0787oF.m3628e());
        }
        if (!soundManager.isActive(this.f4917a)) {
            soundManager.play(this.f4917a);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: E */
    private void m4945E(@NotNull Minecraft minecraft) {
        if (this.f4917a != null) {
            minecraft.getSoundManager().stop(this.f4917a);
            this.f4917a = null;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0885py, com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0856pV(Component.literal("Sound"), () -> {
            if (this.f4914a != null) {
                return this.f4914a.get();
            }
            return null;
        }, soundEvent -> {
            this.f4914a = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        objectArrayList.add(new C0853pS(Component.literal("Volume"), () -> {
            return Float.valueOf(this.f4916gr);
        }, f -> {
            this.f4916gr = f.floatValue();
        }, 0.0f, 2560.0f));
        objectArrayList.add(new C0853pS(Component.literal("Pitch"), () -> {
            return Float.valueOf(this.f4915fZ);
        }, f2 -> {
            this.f4915fZ = f2.floatValue();
        }, 0.0f, 2.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0885py, com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        SoundEvent soundEvent = this.f4914a != null ? this.f4914a.get() : null;
        list.add(Component.literal("Looping Sound: " + (soundEvent != null ? C1292xo.m7889f(soundEvent) : "none")));
        list.add(Component.literal(String.format("Volume: %.2f, Pitch: %.2f", Float.valueOf(this.f4916gr), Float.valueOf(this.f4915fZ))));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4912er;
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
        m4945E(minecraft);
    }
}
