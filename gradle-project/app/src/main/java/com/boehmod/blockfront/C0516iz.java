package com.boehmod.blockfront;

import javax.annotation.Nonnull;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;

/* JADX INFO: renamed from: com.boehmod.blockfront.iz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iz.class */
public class C0516iz extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: kV */
    public static final int f3151kV = 6;

    /* JADX INFO: renamed from: da */
    private boolean f3152da;

    /* JADX INFO: renamed from: gU */
    private final float f3153gU;

    public C0516iz(@Nonnull SoundEvent soundEvent, @Nonnull SoundSource soundSource, @Nonnull SoundInstance.Attenuation attenuation, float f, float f2, RandomSource randomSource, double d, double d2, double d3) {
        super(soundEvent, soundSource, randomSource);
        this.f3152da = false;
        this.volume = f;
        this.pitch = f2;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.looping = false;
        this.delay = 0;
        this.attenuation = attenuation;
        this.relative = false;
        this.f3153gU = f / 6.0f;
    }

    /* JADX INFO: renamed from: ba */
    public void m2294ba() {
        this.f3152da = true;
    }

    public void tick() {
        if (this.f3152da) {
            this.volume = C1270xJ.m7161d(this.volume, 0.0f, this.f3153gU);
        }
        if (this.volume <= 0.0f) {
            stop();
        }
    }
}
