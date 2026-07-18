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

/* JADX INFO: renamed from: com.boehmod.blockfront.ic */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ic.class */
public class C0492ic extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: jz */
    public static final int f2987jz = 4;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0386gc f2988a;

    /* JADX INFO: renamed from: cP */
    private boolean f2989cP;

    public C0492ic(@NotNull C0386gc c0386gc, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.f2989cP = false;
        this.f2988a = c0386gc;
        this.looping = false;
        this.pitch = f;
        this.volume = f2;
        Vec3 vec3M1856c = c0386gc.m1856c();
        this.x = vec3M1856c.x;
        this.y = vec3M1856c.y;
        this.z = vec3M1856c.z;
        this.attenuation = SoundInstance.Attenuation.NONE;
    }

    public boolean canPlaySound() {
        return true;
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        if (this.f2988a.m1851P()) {
            if (!this.f2989cP) {
                this.f2989cP = true;
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
        Vec3 vec3M1856c = this.f2988a.m1856c();
        this.x = vec3M1856c.x;
        this.y = vec3M1856c.y;
        this.z = vec3M1856c.z;
        this.volume = 1.0f;
    }
}
