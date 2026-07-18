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

/* JADX INFO: renamed from: com.boehmod.blockfront.hX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hX.class */
public final class C0434hX extends AbstractC0433hW {

    /* JADX INFO: renamed from: as */
    @NotNull
    public static final String f2807as = "sound_event";

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final MapCodec<C0434hX> f2808b = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.fieldOf("sound").forGetter(c0434hX -> {
            return C1292xo.m7889f(c0434hX.f2809a.get());
        }), Codec.FLOAT.optionalFieldOf("distance", Float.valueOf(32.0f)).forGetter(c0434hX2 -> {
            return Float.valueOf(c0434hX2.f2810gq);
        }), Codec.FLOAT.optionalFieldOf("volume", Float.valueOf(1.0f)).forGetter(c0434hX3 -> {
            return Float.valueOf(c0434hX3.f2811gr);
        }), Codec.FLOAT.optionalFieldOf("pitch", Float.valueOf(1.0f)).forGetter(c0434hX4 -> {
            return Float.valueOf(c0434hX4.f2812gs);
        }), C0836pB.f4470C.optionalFieldOf("offset", Vec3.ZERO).forGetter(c0434hX5 -> {
            return c0434hX5.f2813r;
        })).apply(instance, (str, f, f2, f3, vec3) -> {
            return new C0434hX(C1292xo.m7888d(str), f.floatValue(), f2.floatValue(), f3.floatValue()).m2033a(vec3);
        });
    });

    /* JADX INFO: renamed from: a */
    private final Supplier<SoundEvent> f2809a;

    /* JADX INFO: renamed from: gq */
    private final float f2810gq;

    /* JADX INFO: renamed from: gr */
    private final float f2811gr;

    /* JADX INFO: renamed from: gs */
    private final float f2812gs;

    /* JADX INFO: renamed from: r */
    @NotNull
    private Vec3 f2813r = Vec3.ZERO;

    public C0434hX(Supplier<SoundEvent> supplier, float f, float f2, float f3) {
        this.f2809a = supplier;
        this.f2810gq = f;
        this.f2811gr = f2;
        this.f2812gs = f3;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0434hX m2033a(@NotNull Vec3 vec3) {
        this.f2813r = vec3;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0433hW
    @NotNull
    /* JADX INFO: renamed from: r */
    public String mo2030r() {
        return f2807as;
    }

    @Override // com.boehmod.blockfront.AbstractC0433hW
    /* JADX INFO: renamed from: a */
    public void mo2031a(@NotNull Minecraft minecraft, @NotNull Vec3 vec3, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, float f) {
        SoundEvent soundEvent;
        if (this.f2809a == null || (soundEvent = this.f2809a.get()) == null) {
            return;
        }
        RandomSource randomSource = clientLevel.random;
        minecraft.getSoundManager().play(new C0493id(soundEvent, new Vec3((randomSource.nextFloat() - 0.5f) * 2.0f * this.f2810gq, 0.0d, (randomSource.nextFloat() - 0.5f) * 2.0f * this.f2810gq).add(this.f2813r).add(vec3), this.f2811gr * f, (this.f2812gs - 0.05f) + (0.05f * randomSource.nextFloat()), randomSource));
    }
}
