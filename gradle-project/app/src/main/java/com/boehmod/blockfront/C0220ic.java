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

/* JADX INFO: renamed from: com.boehmod.blockfront.ic, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ic.class */
public class C0220ic extends AbstractTickableSoundInstance {
    public static final int jz = 4;

    @NotNull
    private final C0166gc a;
    private boolean cP;

    public C0220ic(@NotNull C0166gc c0166gc, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.cP = false;
        this.a = c0166gc;
        this.looping = false;
        this.pitch = f;
        this.volume = f2;
        Vec3 vec3C = c0166gc.c();
        this.x = vec3C.x;
        this.y = vec3C.y;
        this.z = vec3C.z;
        this.attenuation = SoundInstance.Attenuation.NONE;
    }

    public boolean canPlaySound() {
        return true;
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        if (this.a.P()) {
            if (!this.cP) {
                this.cP = true;
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
        Vec3 vec3C = this.a.c();
        this.x = vec3C.x;
        this.y = vec3C.y;
        this.z = vec3C.z;
        this.volume = 1.0f;
    }
}
