package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.io */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/io.class */
public final class C0505io extends AbstractC0504in {

    /* JADX INFO: renamed from: ay */
    @NotNull
    public static final String f3109ay = "sound_event";

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final MapCodec<C0505io> f3110b = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.fieldOf("sound").forGetter(c0505io -> {
            return C1272xL.m7216f(c0505io.f3111a.get());
        }), Codec.FLOAT.optionalFieldOf("distance", Float.valueOf(32.0f)).forGetter(c0505io2 -> {
            return Float.valueOf(c0505io2.f3112gL);
        }), Codec.FLOAT.optionalFieldOf("volume", Float.valueOf(1.0f)).forGetter(c0505io3 -> {
            return Float.valueOf(c0505io3.f3113gM);
        }), Codec.FLOAT.optionalFieldOf("pitch", Float.valueOf(1.0f)).forGetter(c0505io4 -> {
            return Float.valueOf(c0505io4.f3114gN);
        }), C0859pX.f4599C.optionalFieldOf("offset", Vec3.ZERO).forGetter(c0505io5 -> {
            return c0505io5.f3115r;
        })).apply(instance, (str, f, f2, f3, vec3) -> {
            return new C0505io(C1272xL.m7215d(str), f.floatValue(), f2.floatValue(), f3.floatValue()).m2267a(vec3);
        });
    });

    /* JADX INFO: renamed from: a */
    private final Supplier<SoundEvent> f3111a;

    /* JADX INFO: renamed from: gL */
    private final float f3112gL;

    /* JADX INFO: renamed from: gM */
    private final float f3113gM;

    /* JADX INFO: renamed from: gN */
    private final float f3114gN;

    /* JADX INFO: renamed from: r */
    @NotNull
    private Vec3 f3115r = Vec3.ZERO;

    public C0505io(Supplier<SoundEvent> supplier, float f, float f2, float f3) {
        this.f3111a = supplier;
        this.f3112gL = f;
        this.f3113gM = f2;
        this.f3114gN = f3;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0505io m2267a(@NotNull Vec3 vec3) {
        this.f3115r = vec3;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0504in
    @NotNull
    /* JADX INFO: renamed from: v */
    public String mo2264v() {
        return f3109ay;
    }

    @Override // com.boehmod.blockfront.AbstractC0504in
    /* JADX INFO: renamed from: a */
    public void mo2265a(@NotNull Minecraft minecraft, @NotNull Vec3 vec3, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, float f) {
        SoundEvent soundEvent;
        if (this.f3111a == null || (soundEvent = this.f3111a.get()) == null) {
            return;
        }
        RandomSource randomSource = clientLevel.random;
        minecraft.getSoundManager().play(new C0511iu(soundEvent, new Vec3((randomSource.nextFloat() - 0.5f) * 2.0f * this.f3112gL, 0.0d, (randomSource.nextFloat() - 0.5f) * 2.0f * this.f3112gL).add(this.f3115r).add(vec3), this.f3113gM * f, (this.f3114gN - 0.05f) + (0.05f * randomSource.nextFloat()), randomSource));
    }
}
