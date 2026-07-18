package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0779ny;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.it */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/it.class */
public class C0509it<V extends AbstractC0779ny> extends SimpleSoundInstance implements TickableSoundInstance {

    /* JADX INFO: renamed from: gF */
    public static final float f3026gF = 2.5f;

    /* JADX INFO: renamed from: gG */
    public static final float f3027gG = 6.0f;

    /* JADX INFO: renamed from: a */
    @NotNull
    final V f3028a;

    /* JADX INFO: renamed from: cZ */
    private final boolean f3029cZ;

    /* JADX INFO: renamed from: da */
    private final boolean f3030da;

    /* JADX INFO: renamed from: db */
    private final boolean f3031db;

    /* JADX INFO: renamed from: gH */
    private float f3032gH;

    public C0509it(@NotNull V v, boolean z, boolean z2, boolean z3, boolean z4, @NotNull SoundEvent soundEvent, @NotNull Vec3 vec3, float f, float f2) {
        super(soundEvent, SoundSource.AMBIENT, f, f2, SoundInstance.createUnseededRandom(), vec3.x, vec3.y, vec3.z);
        this.f3032gH = 0.0f;
        this.f3029cZ = z;
        this.f3030da = z2;
        this.f3031db = z3;
        this.f3028a = v;
        this.looping = z4;
        this.volume = 0.0f;
    }

    /* JADX INFO: renamed from: f */
    public void m2249f(float f) {
        this.pitch = f;
    }

    /* JADX INFO: renamed from: g */
    public void m2250g(float f) {
        this.volume = f;
    }

    public boolean canStartSilent() {
        return true;
    }

    public boolean isStopped() {
        return !this.f3028a.isAlive() || this.f3028a.isRemoved();
    }

    public void tick() {
        boolean zM3510aR = this.f3028a.m3510aR();
        boolean z = this.f3028a.m3521aS() || this.f3028a.m3523aT();
        boolean zM3529aW = this.f3028a.m3529aW();
        boolean z2 = this.f3028a.m3525aU() || this.f3028a.m3527aV();
        boolean zM3504aP = this.f3028a.m3504aP();
        boolean z3 = false;
        Vec3 vec3Position = this.f3028a.position();
        this.x = vec3Position.x;
        this.y = vec3Position.y;
        this.z = vec3Position.z;
        this.f3032gH = Mth.clamp(this.f3032gH + ((this.f3031db || zM3510aR) ? 0.1f : -0.025f), 0.0f, 1.0f);
        if (this.f3030da) {
            if (z2) {
                z3 = true;
            }
        } else if (this.f3031db) {
            if (zM3504aP) {
                z3 = true;
            }
        } else if (this.f3029cZ && z) {
            z3 = true;
        } else if (!this.f3029cZ && !z) {
            z3 = true;
        }
        this.pitch = C1290xm.m7835d(this.pitch, (!zM3529aW || z2) ? 1.0f : 1.1f, 0.01f);
        this.volume = Mth.clamp(this.volume + (z3 ? 0.05f : -0.05f), 0.0f, 1.0f) * this.f3032gH;
    }
}
