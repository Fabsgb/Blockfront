package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;

/* JADX INFO: renamed from: com.boehmod.blockfront.iv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iv.class */
public class C0238iv extends AbstractTickableSoundInstance {
    private static final float gI = 0.025f;
    private float gD;

    public C0238iv(SoundEvent soundEvent) {
        super(soundEvent, SoundSource.AMBIENT, SoundInstance.createUnseededRandom());
        this.gD = 0.0f;
        this.looping = true;
        this.volume = 0.0f;
        this.attenuation = SoundInstance.Attenuation.NONE;
    }

    public void h(float f) {
        this.gD = Mth.clamp(f, 0.0f, 1.0f);
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        this.volume = C0634xm.d(this.volume, this.gD, 0.025f);
    }
}
