package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iC.class */
public class C0467iC extends SimpleSoundInstance implements TickableSoundInstance {

    /* JADX INFO: renamed from: a */
    @NotNull
    final C0973rf f2895a;

    /* JADX INFO: renamed from: dd */
    private final boolean f2896dd;

    /* JADX INFO: renamed from: gV */
    private float f2897gV;

    /* JADX INFO: renamed from: de */
    static final /* synthetic */ boolean f2898de;

    static {
        f2898de = !C0467iC.class.desiredAssertionStatus();
    }

    public C0467iC(@NotNull C0973rf c0973rf, @NotNull SoundEvent soundEvent, @NotNull Vec3 vec3, boolean z, float f, float f2) {
        super(soundEvent, SoundSource.AMBIENT, f, f2, SoundInstance.createUnseededRandom(), vec3.x, vec3.y, vec3.z);
        this.f2897gV = 0.0f;
        this.f2895a = c0973rf;
        this.f2896dd = z;
        this.looping = true;
    }

    /* JADX INFO: renamed from: d */
    public void m2128d(float f) {
        this.pitch = f;
    }

    /* JADX INFO: renamed from: e */
    public void m2129e(float f) {
        this.volume = f;
    }

    public boolean isStopped() {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (f2898de || c0623lM2852b != null) {
            return c0623lM2852b.m2874a() == null;
        }
        throw new AssertionError();
    }

    public void tick() {
        boolean z = !this.f2895a.m5524bo();
        this.f2897gV = Mth.clamp(this.f2897gV + 0.1f, 0.0f, 1.0f);
        this.x = this.f2895a.f5446c.x;
        this.y = this.f2895a.f5446c.y;
        this.z = this.f2895a.f5446c.z;
        this.pitch = C1270xJ.m7161d(this.pitch, 1.0f, 0.01f);
        float f = z ? 0.05f : -0.05f;
        if (this.f2896dd) {
            f = -f;
        }
        this.volume = Mth.clamp(this.volume + f, 0.0f, 1.0f) * this.f2897gV;
    }
}
