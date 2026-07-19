package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0376ny;
import it.unimi.dsi.fastutil.floats.FloatFloatPair;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iu.class */
public class C0237iu<V extends AbstractC0376ny> extends SimpleSoundInstance implements TickableSoundInstance {
    final V b;

    public C0237iu(@NotNull V v, @NotNull SoundEvent soundEvent, @NotNull Vec3 vec3, float f, float f2) {
        super(soundEvent, SoundSource.AMBIENT, f, f2, SoundInstance.createUnseededRandom(), vec3.x, vec3.y, vec3.z);
        this.b = v;
        this.looping = true;
    }

    public void f(float f) {
        this.pitch = f;
    }

    public void g(float f) {
        this.volume = f;
    }

    public boolean isStopped() {
        return !this.b.isAlive();
    }

    public void tick() {
        Vec3 vec3Position = this.b.position();
        this.x = vec3Position.x;
        this.y = vec3Position.y;
        this.z = vec3Position.z;
        FloatFloatPair floatFloatPairA = this.b.a.a();
        this.volume = Mth.lerp(0.3f, this.volume, (floatFloatPairA.firstFloat() > 0.01f ? 1 : (floatFloatPairA.firstFloat() == 0.01f ? 0 : -1)) > 0 || (floatFloatPairA.secondFloat() > 0.01f ? 1 : (floatFloatPairA.secondFloat() == 0.01f ? 0 : -1)) > 0 ? 1.0f : 0.0f);
    }
}
