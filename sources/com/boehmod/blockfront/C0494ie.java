package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ie */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ie.class */
public class C0494ie extends AbstractSoundInstance implements TickableSoundInstance {

    /* JADX INFO: renamed from: k */
    @NotNull
    private final UUID f2990k;

    /* JADX INFO: renamed from: cQ */
    static final /* synthetic */ boolean f2991cQ;

    static {
        f2991cQ = !C0494ie.class.desiredAssertionStatus();
    }

    public C0494ie(@NotNull SoundEvent soundEvent, @NotNull Vec3 vec3, float f, float f2, @NotNull UUID uuid) {
        super(soundEvent, SoundSource.AMBIENT, SoundInstance.createUnseededRandom());
        this.pitch = f;
        this.volume = f2;
        this.f2990k = uuid;
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
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2991cQ && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        return abstractC0787oFM2688a == null || !abstractC0787oFM2688a.m3628e().equals(this.f2990k);
    }

    public void tick() {
    }
}
