package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundSource;

/* JADX INFO: renamed from: com.boehmod.blockfront.ik, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ik.class */
public class C0227ik extends SimpleSoundInstance implements TickableSoundInstance {
    static final /* synthetic */ boolean cT;

    static {
        cT = !C0227ik.class.desiredAssertionStatus();
    }

    public C0227ik() {
        super(C0624xc.ol.getId(), SoundSource.MUSIC, 0.5f, 1.0f, SoundInstance.createUnseededRandom(), true, 0, SoundInstance.Attenuation.NONE, 0.0d, 0.0d, 0.0d, true);
        this.volume = 0.0f;
    }

    public boolean isStopped() {
        return false;
    }

    public void tick() {
        C0297l c0297lB = C0297l.b();
        if (!cT && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        this.volume = C0634xm.d(this.volume, c0297lB.m596a().m544c() ? 1.0f : 0.0f, 0.01f);
    }
}
