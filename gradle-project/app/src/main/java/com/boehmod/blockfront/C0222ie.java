package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ie, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ie.class */
public class C0222ie extends AbstractSoundInstance implements TickableSoundInstance {

    @NotNull
    private final UUID k;
    static final /* synthetic */ boolean cQ;

    static {
        cQ = !C0222ie.class.desiredAssertionStatus();
    }

    public C0222ie(@NotNull SoundEvent soundEvent, @NotNull Vec3 vec3, float f, float f2, @NotNull UUID uuid) {
        super(soundEvent, SoundSource.AMBIENT, SoundInstance.createUnseededRandom());
        this.pitch = f;
        this.volume = f2;
        this.k = uuid;
        this.x = vec3.x;
        this.y = vec3.y;
        this.z = vec3.z;
        this.looping = true;
        this.attenuation = SoundInstance.Attenuation.LINEAR;
    }

    public boolean canStartSilent() {
        return true;
    }

    public boolean isStopped() {
        C0297l c0297lB = C0297l.b();
        if (!cQ && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        return oFVarM591a == null || !oFVarM591a.m757e().equals(this.k);
    }

    public void tick() {
    }
}
