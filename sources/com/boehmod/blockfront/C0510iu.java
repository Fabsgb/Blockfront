package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0779ny;
import it.unimi.dsi.fastutil.floats.FloatFloatPair;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iu.class */
public class C0510iu<V extends AbstractC0779ny> extends SimpleSoundInstance implements TickableSoundInstance {

    /* JADX INFO: renamed from: b */
    final V f3033b;

    public C0510iu(@NotNull V v, @NotNull SoundEvent soundEvent, @NotNull Vec3 vec3, float f, float f2) {
        super(soundEvent, SoundSource.AMBIENT, f, f2, SoundInstance.createUnseededRandom(), vec3.x, vec3.y, vec3.z);
        this.f3033b = v;
        this.looping = true;
    }

    /* JADX INFO: renamed from: f */
    public void m2251f(float f) {
        this.pitch = f;
    }

    /* JADX INFO: renamed from: g */
    public void m2252g(float f) {
        this.volume = f;
    }

    public boolean isStopped() {
        return !this.f3033b.isAlive();
    }

    public void tick() {
        Vec3 vec3Position = this.f3033b.position();
        this.x = vec3Position.x;
        this.y = vec3Position.y;
        this.z = vec3Position.z;
        FloatFloatPair floatFloatPairM3310a = this.f3033b.f4173a.m3310a();
        this.volume = Mth.lerp(0.3f, this.volume, (floatFloatPairM3310a.firstFloat() > 0.01f ? 1 : (floatFloatPairM3310a.firstFloat() == 0.01f ? 0 : -1)) > 0 || (floatFloatPairM3310a.secondFloat() > 0.01f ? 1 : (floatFloatPairM3310a.secondFloat() == 0.01f ? 0 : -1)) > 0 ? 1.0f : 0.0f);
    }
}
