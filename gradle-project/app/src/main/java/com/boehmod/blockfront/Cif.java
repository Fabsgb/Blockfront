package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.if, reason: invalid class name */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/if.class */
public class Cif extends AbstractTickableSoundInstance {
    private boolean cR;

    public Cif(@NotNull SoundEvent soundEvent, boolean z, boolean z2) {
        super(soundEvent, SoundSource.MUSIC, SoundInstance.createUnseededRandom());
        this.cR = false;
        this.looping = z;
        this.volume = z2 ? 1.0f : 0.0f;
    }

    public void y(boolean z) {
        this.cR = z;
    }

    public boolean U() {
        return this.cR;
    }

    public boolean isStopped() {
        return this.cR && this.volume <= 0.0f;
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        this.volume = C0634xm.d(this.volume, this.cR ? 0.0f : 1.0f, 0.015f);
    }
}
