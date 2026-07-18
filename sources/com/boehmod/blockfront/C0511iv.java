package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;

/* JADX INFO: renamed from: com.boehmod.blockfront.iv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iv.class */
public class C0511iv extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: gI */
    private static final float f3034gI = 0.025f;

    /* JADX INFO: renamed from: gD */
    private float f3035gD;

    public C0511iv(SoundEvent soundEvent) {
        super(soundEvent, SoundSource.AMBIENT, SoundInstance.createUnseededRandom());
        this.f3035gD = 0.0f;
        this.looping = true;
        this.volume = 0.0f;
        this.attenuation = SoundInstance.Attenuation.NONE;
    }

    /* JADX INFO: renamed from: h */
    public void m2253h(float f) {
        this.f3035gD = Mth.clamp(f, 0.0f, 1.0f);
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        this.volume = C1290xm.m7835d(this.volume, this.f3035gD, 0.025f);
    }
}
