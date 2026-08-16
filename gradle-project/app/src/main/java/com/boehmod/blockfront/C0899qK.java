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

/* JADX INFO: renamed from: com.boehmod.blockfront.qK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qK.class */
public class C0899qK extends AbstractC0856pU {

    /* JADX INFO: renamed from: ep */
    @NotNull
    private static final ResourceLocation f4993ep = C0532jO.m2378d("textures/misc/debug/mapeffect/sound_looping.png");

    /* JADX INFO: renamed from: A */
    @NotNull
    public static final MapCodec<C0899qK> f4994A = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("sound", "").forGetter(c0899qK -> {
            return c0899qK.f4995a != null ? C1272xL.m7216f(c0899qK.f4995a.get()) : "";
        }), Codec.FLOAT.fieldOf("volume").forGetter(c0899qK2 -> {
            return Float.valueOf(c0899qK2.f4997gM);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0899qK3 -> {
            return Float.valueOf(c0899qK3.f4996gN);
        }), Codec.FLOAT.fieldOf("activationDistance").forGetter(c0899qK4 -> {
            return Float.valueOf(c0899qK4.f4587lA);
        })).apply(instance, (str, f, f2, f3) -> {
            C0899qK c0899qK5 = new C0899qK();
            c0899qK5.f4995a = str.isEmpty() ? null : C1272xL.m7215d(str);
            c0899qK5.f4997gM = f.floatValue();
            c0899qK5.f4996gN = f2.floatValue();
            c0899qK5.f4587lA = f3.floatValue();
            return c0899qK5;
        });
    });

    /* JADX INFO: renamed from: a */
    @Nullable
    public Supplier<SoundEvent> f4995a;

    /* JADX INFO: renamed from: gN */
    private float f4996gN;

    /* JADX INFO: renamed from: gM */
    private float f4997gM;

    /* JADX INFO: renamed from: a */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0512iv f4998a;

    public C0899qK() {
        this(C1312xz.f8701Du, Vec3.ZERO);
    }

    public C0899qK(@NotNull Supplier<SoundEvent> supplier, @NotNull Vec3 vec3) {
        super(vec3);
        this.f4996gN = 1.0f;
        this.f4997gM = 1.0f;
        this.f4995a = supplier;
        this.f4587lA = 16.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0856pU
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo3941a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        m4821a(minecraft, abstractC0863pb);
    }

    @Override // com.boehmod.blockfront.AbstractC0856pU
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo3943b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        m4821a(minecraft, abstractC0863pb);
    }

    @Override // com.boehmod.blockfront.AbstractC0856pU
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo3942b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        m4822G(minecraft);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m4821a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        if (this.f4995a == null) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        if (this.f4998a == null) {
            this.f4998a = new C0512iv(this.f4995a.get(), this.f4593c, this.f4996gN, this.f4997gM, abstractC0863pb.m4064e());
        }
        if (!soundManager.isActive(this.f4998a)) {
            soundManager.play(this.f4998a);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: G */
    private void m4822G(@NotNull Minecraft minecraft) {
        if (this.f4998a != null) {
            minecraft.getSoundManager().stop(this.f4998a);
            this.f4998a = null;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0856pU, com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0932qr(Component.literal("Sound"), () -> {
            if (this.f4995a != null) {
                return this.f4995a.get();
            }
            return null;
        }, soundEvent -> {
            this.f4995a = soundEvent != null ? () -> {
                return soundEvent;
            } : null;
        }));
        objectArrayList.add(new C0929qo(Component.literal("Volume"), () -> {
            return Float.valueOf(this.f4997gM);
        }, f -> {
            this.f4997gM = f.floatValue();
        }, 0.0f, 2560.0f));
        objectArrayList.add(new C0929qo(Component.literal("Pitch"), () -> {
            return Float.valueOf(this.f4996gN);
        }, f2 -> {
            this.f4996gN = f2.floatValue();
        }, 0.0f, 2.0f));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0856pU, com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        SoundEvent soundEvent = this.f4995a != null ? this.f4995a.get() : null;
        list.add(Component.literal("Looping Sound: " + (soundEvent != null ? C1272xL.m7216f(soundEvent) : "none")));
        list.add(Component.literal(String.format("Volume: %.2f, Pitch: %.2f", Float.valueOf(this.f4997gM), Float.valueOf(this.f4996gN))));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f4993ep;
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
        m4822G(minecraft);
    }
}
