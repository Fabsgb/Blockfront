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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hX.class */
public final class hX extends hW {

    @NotNull
    public static final String as = "sound_event";

    @NotNull
    public static final MapCodec<hX> b = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.fieldOf("sound").forGetter(hXVar -> {
            return C0636xo.f(hXVar.a.get());
        }), Codec.FLOAT.optionalFieldOf("distance", Float.valueOf(32.0f)).forGetter(hXVar2 -> {
            return Float.valueOf(hXVar2.gq);
        }), Codec.FLOAT.optionalFieldOf("volume", Float.valueOf(1.0f)).forGetter(hXVar3 -> {
            return Float.valueOf(hXVar3.gr);
        }), Codec.FLOAT.optionalFieldOf("pitch", Float.valueOf(1.0f)).forGetter(hXVar4 -> {
            return Float.valueOf(hXVar4.gs);
        }), pB.C.optionalFieldOf("offset", Vec3.ZERO).forGetter(hXVar5 -> {
            return hXVar5.r;
        })).apply(instance, (str, f, f2, f3, vec3) -> {
            return new hX(C0636xo.d(str), f.floatValue(), f2.floatValue(), f3.floatValue()).a(vec3);
        });
    });
    private final Supplier<SoundEvent> a;
    private final float gq;
    private final float gr;
    private final float gs;

    @NotNull
    private Vec3 r = Vec3.ZERO;

    public hX(Supplier<SoundEvent> supplier, float f, float f2, float f3) {
        this.a = supplier;
        this.gq = f;
        this.gr = f2;
        this.gs = f3;
    }

    @NotNull
    public hX a(@NotNull Vec3 vec3) {
        this.r = vec3;
        return this;
    }

    @Override // com.boehmod.blockfront.hW
    @NotNull
    public String r() {
        return as;
    }

    @Override // com.boehmod.blockfront.hW
    public void a(@NotNull Minecraft minecraft, @NotNull Vec3 vec3, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, float f) {
        SoundEvent soundEvent;
        if (this.a == null || (soundEvent = this.a.get()) == null) {
            return;
        }
        RandomSource randomSource = clientLevel.random;
        minecraft.getSoundManager().play(new C0221id(soundEvent, new Vec3((randomSource.nextFloat() - 0.5f) * 2.0f * this.gq, 0.0d, (randomSource.nextFloat() - 0.5f) * 2.0f * this.gq).add(this.r).add(vec3), this.gr * f, (this.gs - 0.05f) + (0.05f * randomSource.nextFloat()), randomSource));
    }
}
