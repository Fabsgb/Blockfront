package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0750nU;
import it.unimi.dsi.fastutil.floats.FloatFloatPair;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iL.class */
public class C0476iL<V extends AbstractC0750nU> extends SimpleSoundInstance implements TickableSoundInstance {

    /* JADX INFO: renamed from: b */
    final V f2929b;

    public C0476iL(@NotNull V v, @NotNull SoundEvent soundEvent, @NotNull Vec3 vec3, float f, float f2) {
        super(soundEvent, SoundSource.AMBIENT, f, f2, SoundInstance.createUnseededRandom(), vec3.x, vec3.y, vec3.z);
        this.f2929b = v;
        this.looping = true;
    }

    /* JADX INFO: renamed from: d */
    public void m2140d(float f) {
        this.pitch = f;
    }

    /* JADX INFO: renamed from: e */
    public void m2141e(float f) {
        this.volume = f;
    }

    public boolean isStopped() {
        return !this.f2929b.isAlive();
    }

    public void tick() {
        Vec3 vec3Position = this.f2929b.position();
        this.x = vec3Position.x;
        this.y = vec3Position.y;
        this.z = vec3Position.z;
        FloatFloatPair floatFloatPairM3497a = this.f2929b.f4130a.m3497a();
        this.volume = Mth.lerp(0.3f, this.volume, (floatFloatPairM3497a.firstFloat() > 0.01f ? 1 : (floatFloatPairM3497a.firstFloat() == 0.01f ? 0 : -1)) > 0 || (floatFloatPairM3497a.secondFloat() > 0.01f ? 1 : (floatFloatPairM3497a.secondFloat() == 0.01f ? 0 : -1)) > 0 ? 1.0f : 0.0f);
    }
}
