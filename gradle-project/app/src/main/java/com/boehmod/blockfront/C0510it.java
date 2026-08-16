package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.it */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/it.class */
public class C0510it extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: kU */
    public static final int f3144kU = 4;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0403gs f3145a;

    /* JADX INFO: renamed from: cY */
    private boolean f3146cY;

    public C0510it(@NotNull C0403gs c0403gs, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.f3146cY = false;
        this.f3145a = c0403gs;
        this.looping = false;
        this.pitch = f;
        this.volume = f2;
        Vec3 vec3M1921c = c0403gs.m1921c();
        this.x = vec3M1921c.x;
        this.y = vec3M1921c.y;
        this.z = vec3M1921c.z;
        this.attenuation = SoundInstance.Attenuation.NONE;
    }

    public boolean canPlaySound() {
        return true;
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        if (this.f3145a.m1915R()) {
            if (!this.f3146cY) {
                this.f3146cY = true;
                LocalPlayer localPlayer = Minecraft.getInstance().player;
                double dSqrt = 0.0d;
                if (localPlayer != null) {
                    dSqrt = Mth.sqrt((float) localPlayer.distanceToSqr(this.x, this.y, this.z));
                }
                if (dSqrt <= 4.0d) {
                    stop();
                    return;
                }
                return;
            }
            return;
        }
        Vec3 vec3M1921c = this.f3145a.m1921c();
        this.x = vec3M1921c.x;
        this.y = vec3M1921c.y;
        this.z = vec3M1921c.z;
        this.volume = 1.0f;
    }
}
