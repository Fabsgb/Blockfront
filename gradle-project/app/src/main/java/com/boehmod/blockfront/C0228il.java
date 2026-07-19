package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.il, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/il.class */
public class C0228il extends SimpleSoundInstance implements TickableSoundInstance {

    @NotNull
    final qI a;
    private final boolean cU;
    private float gA;
    static final /* synthetic */ boolean cV;

    static {
        cV = !C0228il.class.desiredAssertionStatus();
    }

    public C0228il(@NotNull qI qIVar, @NotNull SoundEvent soundEvent, @NotNull Vec3 vec3, boolean z, float f, float f2) {
        super(soundEvent, SoundSource.AMBIENT, f, f2, SoundInstance.createUnseededRandom(), vec3.x, vec3.y, vec3.z);
        this.gA = 0.0f;
        this.a = qIVar;
        this.cU = z;
        this.looping = true;
    }

    public void f(float f) {
        this.pitch = f;
    }

    public void g(float f) {
        this.volume = f;
    }

    public boolean isStopped() {
        C0297l c0297lB = C0297l.b();
        if (cV || c0297lB != null) {
            return c0297lB.m591a() == null;
        }
        throw new AssertionError();
    }

    public void tick() {
        boolean z = !this.a.be();
        this.gA = Mth.clamp(this.gA + 0.1f, 0.0f, 1.0f);
        this.x = this.a.c.x;
        this.y = this.a.c.y;
        this.z = this.a.c.z;
        this.pitch = C0634xm.d(this.pitch, 1.0f, 0.01f);
        float f = z ? 0.05f : -0.05f;
        if (this.cU) {
            f = -f;
        }
        this.volume = Mth.clamp(this.volume + f, 0.0f, 1.0f) * this.gA;
    }
}
