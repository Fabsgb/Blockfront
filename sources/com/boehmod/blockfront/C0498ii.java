package com.boehmod.blockfront;

import javax.annotation.Nonnull;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;

/* JADX INFO: renamed from: com.boehmod.blockfront.ii */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ii.class */
public class C0498ii extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: jA */
    public static final int f2994jA = 6;

    /* JADX INFO: renamed from: cR */
    private boolean f2995cR;

    /* JADX INFO: renamed from: gz */
    private final float f2996gz;

    public C0498ii(@Nonnull SoundEvent soundEvent, @Nonnull SoundSource soundSource, @Nonnull SoundInstance.Attenuation attenuation, float f, float f2, RandomSource randomSource, double d, double d2, double d3) {
        super(soundEvent, soundSource, randomSource);
        this.f2995cR = false;
        this.volume = f;
        this.pitch = f2;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.looping = false;
        this.delay = 0;
        this.attenuation = attenuation;
        this.relative = false;
        this.f2996gz = f / 6.0f;
    }

    /* JADX INFO: renamed from: aS */
    public void m2239aS() {
        this.f2995cR = true;
    }

    public void tick() {
        if (this.f2995cR) {
            this.volume = C1290xm.m7835d(this.volume, 0.0f, this.f2996gz);
        }
        if (this.volume <= 0.0f) {
            stop();
        }
    }
}
