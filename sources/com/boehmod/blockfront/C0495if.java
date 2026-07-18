package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.if */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/if.class */
public class C0495if extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: cR */
    private boolean f2992cR;

    public C0495if(@NotNull SoundEvent soundEvent, boolean z, boolean z2) {
        super(soundEvent, SoundSource.MUSIC, SoundInstance.createUnseededRandom());
        this.f2992cR = false;
        this.looping = z;
        this.volume = z2 ? 1.0f : 0.0f;
    }

    /* JADX INFO: renamed from: y */
    public void m2236y(boolean z) {
        this.f2992cR = z;
    }

    /* JADX INFO: renamed from: U */
    public boolean m2237U() {
        return this.f2992cR;
    }

    public boolean isStopped() {
        return this.f2992cR && this.volume <= 0.0f;
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        this.volume = C1290xm.m7835d(this.volume, this.f2992cR ? 0.0f : 1.0f, 0.015f);
    }
}
