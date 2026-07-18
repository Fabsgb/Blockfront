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

/* JADX INFO: renamed from: com.boehmod.blockfront.ip */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ip.class */
public class C0505ip extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: gE */
    private static final float f3017gE = 2.0f;

    /* JADX INFO: renamed from: t */
    @NotNull
    private final Vec3 f3018t;

    /* JADX INFO: renamed from: u */
    @NotNull
    private final Vec3 f3019u;

    /* JADX INFO: renamed from: jD */
    private final int f3020jD;

    /* JADX INFO: renamed from: jE */
    private int f3021jE;

    public C0505ip(@NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, @NotNull Vec3 vec3, @NotNull Vec3 vec32, int i, float f) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.f3021jE = 0;
        this.f3018t = vec3;
        this.f3019u = vec32;
        this.f3020jD = i;
        this.looping = false;
        this.pitch = f;
        this.volume = 2.0f;
        this.x = vec3.x;
        this.y = vec3.y;
        this.z = vec3.z;
        this.attenuation = SoundInstance.Attenuation.NONE;
    }

    public void tick() {
        this.f3021jE++;
        float f = this.f3021jE / this.f3020jD;
        this.x = Mth.lerp(f, this.f3018t.x, this.f3019u.x);
        this.y = Mth.lerp(f, this.f3018t.y, this.f3019u.y);
        this.z = Mth.lerp(f, this.f3018t.z, this.f3019u.z);
        if (Minecraft.getInstance().getDebugOverlay().showDebugScreen()) {
            C0049aT.f304i.add(new C0023U(new Vec3(this.x, this.y, this.z).subtract(0.0d, 0.5d, 0.0d), new Vec3(this.x, this.y, this.z).subtract(0.0d, -0.5d, 0.0d), 200, true, ColorReferences.COLOR_WHITE));
        }
    }
}
