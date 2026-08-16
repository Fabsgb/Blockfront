package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0750nU;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iK.class */
public class C0475iK<V extends AbstractC0750nU> extends SimpleSoundInstance implements TickableSoundInstance {

    /* JADX INFO: renamed from: ha */
    public static final float f2922ha = 2.5f;

    /* JADX INFO: renamed from: hb */
    public static final float f2923hb = 6.0f;

    /* JADX INFO: renamed from: a */
    @NotNull
    final V f2924a;

    /* JADX INFO: renamed from: di */
    private final boolean f2925di;

    /* JADX INFO: renamed from: dj */
    private final boolean f2926dj;

    /* JADX INFO: renamed from: dk */
    private final boolean f2927dk;

    /* JADX INFO: renamed from: hc */
    private float f2928hc;

    public C0475iK(@NotNull V v, boolean z, boolean z2, boolean z3, boolean z4, @NotNull SoundEvent soundEvent, @NotNull Vec3 vec3, float f, float f2) {
        super(soundEvent, SoundSource.AMBIENT, f, f2, SoundInstance.createUnseededRandom(), vec3.x, vec3.y, vec3.z);
        this.f2928hc = 0.0f;
        this.f2925di = z;
        this.f2926dj = z2;
        this.f2927dk = z3;
        this.f2924a = v;
        this.looping = z4;
        this.volume = 0.0f;
    }

    /* JADX INFO: renamed from: d */
    public void m2138d(float f) {
        this.pitch = f;
    }

    /* JADX INFO: renamed from: e */
    public void m2139e(float f) {
        this.volume = f;
    }

    public boolean canStartSilent() {
        return true;
    }

    public boolean isStopped() {
        return !this.f2924a.isAlive() || this.f2924a.isRemoved();
    }

    public void tick() {
        boolean zM3447bb = this.f2924a.m3447bb();
        boolean z = this.f2924a.m3458bc() || this.f2924a.m3460bd();
        boolean zM3466bg = this.f2924a.m3466bg();
        boolean z2 = this.f2924a.m3462be() || this.f2924a.m3464bf();
        boolean zM3441aZ = this.f2924a.m3441aZ();
        boolean z3 = false;
        Vec3 vec3Position = this.f2924a.position();
        this.x = vec3Position.x;
        this.y = vec3Position.y;
        this.z = vec3Position.z;
        this.f2928hc = Mth.clamp(this.f2928hc + ((this.f2927dk || zM3447bb) ? 0.1f : -0.025f), 0.0f, 1.0f);
        if (this.f2926dj) {
            if (z2) {
                z3 = true;
            }
        } else if (this.f2927dk) {
            if (zM3441aZ) {
                z3 = true;
            }
        } else if (this.f2925di && z) {
            z3 = true;
        } else if (!this.f2925di && !z) {
            z3 = true;
        }
        this.pitch = C1270xJ.m7161d(this.pitch, (!zM3466bg || z2) ? 1.0f : 1.1f, 0.01f);
        this.volume = Mth.clamp(this.volume + (z3 ? 0.05f : -0.05f), 0.0f, 1.0f) * this.f2928hc;
    }
}
