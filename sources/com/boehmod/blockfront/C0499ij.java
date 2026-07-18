package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundSource;

/* JADX INFO: renamed from: com.boehmod.blockfront.ij */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ij.class */
public class C0499ij extends SimpleSoundInstance implements TickableSoundInstance {

    /* JADX INFO: renamed from: cS */
    static final /* synthetic */ boolean f2997cS;

    static {
        f2997cS = !C0499ij.class.desiredAssertionStatus();
    }

    public C0499ij() {
        super(C1280xc.f7501ok.getId(), SoundSource.MUSIC, 0.5f, 1.0f, SoundInstance.createUnseededRandom(), true, 0, SoundInstance.Attenuation.NONE, 0.0d, 0.0d, 0.0d, true);
    }

    public boolean isStopped() {
        return false;
    }

    public void tick() {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2997cS && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        this.volume = C1290xm.m7835d(this.volume, c0622lM2667b.m2699a().m2597c() || c0622lM2667b.m2684a().m2564ae() ? 0.0f : 1.0f, 0.005f);
    }
}
