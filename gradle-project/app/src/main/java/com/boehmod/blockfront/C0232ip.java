package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ip, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ip.class */
public class C0232ip extends AbstractTickableSoundInstance {
    private static final float gE = 2.0f;

    @NotNull
    private final Vec3 t;

    @NotNull
    private final Vec3 u;
    private final int jD;
    private int jE;

    public C0232ip(@NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, @NotNull Vec3 vec3, @NotNull Vec3 vec32, int i, float f) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.jE = 0;
        this.t = vec3;
        this.u = vec32;
        this.jD = i;
        this.looping = false;
        this.pitch = f;
        this.volume = 2.0f;
        this.x = vec3.x;
        this.y = vec3.y;
        this.z = vec3.z;
        this.attenuation = SoundInstance.Attenuation.NONE;
    }

    public void tick() {
        this.jE++;
        float f = this.jE / this.jD;
        this.x = Mth.lerp(f, this.t.x, this.u.x);
        this.y = Mth.lerp(f, this.t.y, this.u.y);
        this.z = Mth.lerp(f, this.t.z, this.u.z);
        if (Minecraft.getInstance().getDebugOverlay().showDebugScreen()) {
            aT.i.add(new U(new Vec3(this.x, this.y, this.z).subtract(0.0d, 0.5d, 0.0d), new Vec3(this.x, this.y, this.z).subtract(0.0d, -0.5d, 0.0d), 200, true, ColorReferences.COLOR_WHITE));
        }
    }
}
