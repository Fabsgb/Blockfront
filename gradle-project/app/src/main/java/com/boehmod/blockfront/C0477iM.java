package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;

/* JADX INFO: renamed from: com.boehmod.blockfront.iM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iM.class */
public class C0477iM extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: hd */
    private static final float f2930hd = 0.025f;

    /* JADX INFO: renamed from: gY */
    private float f2931gY;

    public C0477iM(SoundEvent soundEvent) {
        super(soundEvent, SoundSource.AMBIENT, SoundInstance.createUnseededRandom());
        this.f2931gY = 0.0f;
        this.looping = true;
        this.volume = 0.0f;
        this.attenuation = SoundInstance.Attenuation.NONE;
    }

    /* JADX INFO: renamed from: f */
    public void m2142f(float f) {
        this.f2931gY = Mth.clamp(f, 0.0f, 1.0f);
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        this.volume = C1270xJ.m7161d(this.volume, this.f2931gY, 0.025f);
    }
}
