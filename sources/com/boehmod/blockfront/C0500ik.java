package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundSource;

/* JADX INFO: renamed from: com.boehmod.blockfront.ik */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ik.class */
public class C0500ik extends SimpleSoundInstance implements TickableSoundInstance {

    /* JADX INFO: renamed from: cT */
    static final /* synthetic */ boolean f2998cT;

    static {
        f2998cT = !C0500ik.class.desiredAssertionStatus();
    }

    public C0500ik() {
        super(C1280xc.f7502ol.getId(), SoundSource.MUSIC, 0.5f, 1.0f, SoundInstance.createUnseededRandom(), true, 0, SoundInstance.Attenuation.NONE, 0.0d, 0.0d, 0.0d, true);
        this.volume = 0.0f;
    }

    public boolean isStopped() {
        return false;
    }

    public void tick() {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2998cT && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        this.volume = C1290xm.m7835d(this.volume, c0622lM2667b.m2699a().m2597c() ? 1.0f : 0.0f, 0.01f);
    }
}
