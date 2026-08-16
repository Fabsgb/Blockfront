package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iv.class */
public class C0512iv extends AbstractSoundInstance implements TickableSoundInstance {

    /* JADX INFO: renamed from: k */
    @NotNull
    private final UUID f3147k;

    /* JADX INFO: renamed from: cZ */
    static final /* synthetic */ boolean f3148cZ;

    static {
        f3148cZ = !C0512iv.class.desiredAssertionStatus();
    }

    public C0512iv(@NotNull SoundEvent soundEvent, @NotNull Vec3 vec3, float f, float f2, @NotNull UUID uuid) {
        super(soundEvent, SoundSource.AMBIENT, SoundInstance.createUnseededRandom());
        this.pitch = f;
        this.volume = f2;
        this.f3147k = uuid;
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
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f3148cZ && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        return abstractC0863pbM2874a == null || !abstractC0863pbM2874a.m4064e().equals(this.f3147k);
    }

    public void tick() {
    }
}
