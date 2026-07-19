package com.boehmod.blockfront;

import javax.annotation.Nonnull;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;

/* JADX INFO: renamed from: com.boehmod.blockfront.ii, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ii.class */
public class C0225ii extends AbstractTickableSoundInstance {
    public static final int jA = 6;
    private boolean cR;
    private final float gz;

    public C0225ii(@Nonnull SoundEvent soundEvent, @Nonnull SoundSource soundSource, @Nonnull SoundInstance.Attenuation attenuation, float f, float f2, RandomSource randomSource, double d, double d2, double d3) {
        super(soundEvent, soundSource, randomSource);
        this.cR = false;
        this.volume = f;
        this.pitch = f2;
        this.x = d;
        this.y = d2;
        this.z = d3;
        this.looping = false;
        this.delay = 0;
        this.attenuation = attenuation;
        this.relative = false;
        this.gz = f / 6.0f;
    }

    public void aS() {
        this.cR = true;
    }

    public void tick() {
        if (this.cR) {
            this.volume = C0634xm.d(this.volume, 0.0f, this.gz);
        }
        if (this.volume <= 0.0f) {
            stop();
        }
    }
}
