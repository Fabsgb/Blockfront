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

/* JADX INFO: renamed from: com.boehmod.blockfront.iG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iG.class */
public class C0471iG extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: gZ */
    private static final float f2913gZ = 2.0f;

    /* JADX INFO: renamed from: t */
    @NotNull
    private final Vec3 f2914t;

    /* JADX INFO: renamed from: u */
    @NotNull
    private final Vec3 f2915u;

    /* JADX INFO: renamed from: kY */
    private final int f2916kY;

    /* JADX INFO: renamed from: kZ */
    private int f2917kZ;

    public C0471iG(@NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, @NotNull Vec3 vec3, @NotNull Vec3 vec4, int i, float f) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.f2917kZ = 0;
        this.f2914t = vec3;
        this.f2915u = vec4;
        this.f2916kY = i;
        this.looping = false;
        this.pitch = f;
        this.volume = 2.0f;
        this.x = vec3.x;
        this.y = vec3.y;
        this.z = vec3.z;
        this.attenuation = SoundInstance.Attenuation.NONE;
    }

    public void tick() {
        this.f2917kZ++;
        float f = this.f2917kZ / this.f2916kY;
        this.x = Mth.lerp(f, this.f2914t.x, this.f2915u.x);
        this.y = Mth.lerp(f, this.f2914t.y, this.f2915u.y);
        this.z = Mth.lerp(f, this.f2914t.z, this.f2915u.z);
        if (Minecraft.getInstance().getDebugOverlay().showDebugScreen()) {
            C0111bb.f718j.add(new C0057aa(new Vec3(this.x, this.y, this.z).subtract(0.0d, 0.5d, 0.0d), new Vec3(this.x, this.y, this.z).subtract(0.0d, -0.5d, 0.0d), 200, true, ColorReferences.COLOR_WHITE));
        }
    }
}
