package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iw.class */
public class C0513iw extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: da */
    private boolean f3149da;

    public C0513iw(@NotNull SoundEvent soundEvent, boolean z, boolean z2) {
        super(soundEvent, SoundSource.MUSIC, SoundInstance.createUnseededRandom());
        this.f3149da = false;
        this.looping = z;
        this.volume = z2 ? 1.0f : 0.0f;
    }

    /* JADX INFO: renamed from: y */
    public void m2291y(boolean z) {
        this.f3149da = z;
    }

    /* JADX INFO: renamed from: V */
    public boolean m2292V() {
        return this.f3149da;
    }

    public boolean isStopped() {
        return this.f3149da && this.volume <= 0.0f;
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        this.volume = C1270xJ.m7161d(this.volume, this.f3149da ? 0.0f : 1.0f, 0.015f);
    }
}
