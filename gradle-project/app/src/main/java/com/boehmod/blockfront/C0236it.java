package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0376ny;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.it, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/it.class */
public class C0236it<V extends AbstractC0376ny> extends SimpleSoundInstance implements TickableSoundInstance {
    public static final float gF = 2.5f;
    public static final float gG = 6.0f;

    @NotNull
    final V a;
    private final boolean cZ;
    private final boolean da;
    private final boolean db;
    private float gH;

    public C0236it(@NotNull V v, boolean z, boolean z2, boolean z3, boolean z4, @NotNull SoundEvent soundEvent, @NotNull Vec3 vec3, float f, float f2) {
        super(soundEvent, SoundSource.AMBIENT, f, f2, SoundInstance.createUnseededRandom(), vec3.x, vec3.y, vec3.z);
        this.gH = 0.0f;
        this.cZ = z;
        this.da = z2;
        this.db = z3;
        this.a = v;
        this.looping = z4;
        this.volume = 0.0f;
    }

    public void f(float f) {
        this.pitch = f;
    }

    public void g(float f) {
        this.volume = f;
    }

    public boolean canStartSilent() {
        return true;
    }

    public boolean isStopped() {
        return !this.a.isAlive() || this.a.isRemoved();
    }

    public void tick() {
        boolean zAR = this.a.aR();
        boolean z = this.a.aS() || this.a.aT();
        boolean zAW = this.a.aW();
        boolean z2 = this.a.aU() || this.a.aV();
        boolean zAP = this.a.aP();
        boolean z3 = false;
        Vec3 vec3Position = this.a.position();
        this.x = vec3Position.x;
        this.y = vec3Position.y;
        this.z = vec3Position.z;
        this.gH = Mth.clamp(this.gH + ((this.db || zAR) ? 0.1f : -0.025f), 0.0f, 1.0f);
        if (this.da) {
            if (z2) {
                z3 = true;
            }
        } else if (this.db) {
            if (zAP) {
                z3 = true;
            }
        } else if (this.cZ && z) {
            z3 = true;
        } else if (!this.cZ && !z) {
            z3 = true;
        }
        this.pitch = C0634xm.d(this.pitch, (!zAW || z2) ? 1.0f : 1.1f, 0.01f);
        this.volume = Mth.clamp(this.volume + (z3 ? 0.05f : -0.05f), 0.0f, 1.0f) * this.gH;
    }
}
