package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.il */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/il.class */
public class C0501il extends SimpleSoundInstance implements TickableSoundInstance {

    /* JADX INFO: renamed from: a */
    @NotNull
    final C0896qI f2999a;

    /* JADX INFO: renamed from: cU */
    private final boolean f3000cU;

    /* JADX INFO: renamed from: gA */
    private float f3001gA;

    /* JADX INFO: renamed from: cV */
    static final /* synthetic */ boolean f3002cV;

    static {
        f3002cV = !C0501il.class.desiredAssertionStatus();
    }

    public C0501il(@NotNull C0896qI c0896qI, @NotNull SoundEvent soundEvent, @NotNull Vec3 vec3, boolean z, float f, float f2) {
        super(soundEvent, SoundSource.AMBIENT, f, f2, SoundInstance.createUnseededRandom(), vec3.x, vec3.y, vec3.z);
        this.f3001gA = 0.0f;
        this.f2999a = c0896qI;
        this.f3000cU = z;
        this.looping = true;
    }

    /* JADX INFO: renamed from: f */
    public void m2240f(float f) {
        this.pitch = f;
    }

    /* JADX INFO: renamed from: g */
    public void m2241g(float f) {
        this.volume = f;
    }

    public boolean isStopped() {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (f3002cV || c0622lM2667b != null) {
            return c0622lM2667b.m2688a() == null;
        }
        throw new AssertionError();
    }

    public void tick() {
        boolean z = !this.f2999a.m4629be();
        this.f3001gA = Mth.clamp(this.f3001gA + 0.1f, 0.0f, 1.0f);
        this.x = this.f2999a.f4716c.x;
        this.y = this.f2999a.f4716c.y;
        this.z = this.f2999a.f4716c.z;
        this.pitch = C1290xm.m7835d(this.pitch, 1.0f, 0.01f);
        float f = z ? 0.05f : -0.05f;
        if (this.f3000cU) {
            f = -f;
        }
        this.volume = Mth.clamp(this.volume + f, 0.0f, 1.0f) * this.f3001gA;
    }
}
