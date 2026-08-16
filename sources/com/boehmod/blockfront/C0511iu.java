package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iu.class */
public class C0511iu extends AbstractSoundInstance {
    public C0511iu(@NotNull SoundEvent soundEvent, @NotNull Vec3 vec3, float f, float f2, @NotNull RandomSource randomSource) {
        super(soundEvent, SoundSource.AMBIENT, randomSource);
        this.volume = f;
        this.pitch = f2;
        this.x = vec3.x;
        this.y = vec3.y;
        this.z = vec3.z;
        this.attenuation = SoundInstance.Attenuation.NONE;
    }
}
