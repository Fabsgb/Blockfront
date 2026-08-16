package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundSource;

/* JADX INFO: renamed from: com.boehmod.blockfront.iB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iB.class */
public class C0466iB extends SimpleSoundInstance implements TickableSoundInstance {

    /* JADX INFO: renamed from: dc */
    static final /* synthetic */ boolean f2894dc;

    static {
        f2894dc = !C0466iB.class.desiredAssertionStatus();
    }

    public C0466iB() {
        super(C1312xz.f7914on.getId(), SoundSource.MUSIC, 0.5f, 1.0f, SoundInstance.createUnseededRandom(), true, 0, SoundInstance.Attenuation.NONE, 0.0d, 0.0d, 0.0d, true);
        this.volume = 0.0f;
    }

    public boolean isStopped() {
        return false;
    }

    public void tick() {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2894dc && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        this.volume = C1270xJ.m7161d(this.volume, c0623lM2852b.m2885a().m2586c() ? 1.0f : 0.0f, 0.01f);
    }
}
