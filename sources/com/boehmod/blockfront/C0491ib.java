package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ib */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ib.class */
public class C0491ib extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Entity f2984a;

    /* JADX INFO: renamed from: cO */
    private final boolean f2985cO;

    /* JADX INFO: renamed from: gy */
    private final float f2986gy;

    public C0491ib(@NotNull Entity entity, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, boolean z, float f) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.f2984a = entity;
        this.looping = true;
        this.volume = 0.0f;
        this.f2985cO = z;
        this.f2986gy = f;
        Vec3 vec3Position = entity.position();
        this.x = vec3Position.x;
        this.y = vec3Position.y;
        this.z = vec3Position.z;
    }

    public boolean canPlaySound() {
        return !this.f2984a.isSilent();
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        float f;
        if (!this.f2984a.isRemoved() && this.f2984a.isAlive()) {
            LivingEntity livingEntity = this.f2984a;
            if (!(livingEntity instanceof LivingEntity) || livingEntity.getHealth() > 0.0f) {
                if (this.f2985cO) {
                    double x = this.f2984a.getX() - this.f2984a.xOld;
                    double z = this.f2984a.getZ() - this.f2984a.zOld;
                    float fSqrt = (float) Math.sqrt((x * x) + (z * z));
                    if (this.f2984a.onGround() && !this.f2984a.isShiftKeyDown() && fSqrt > 0.01f) {
                        f = this.f2986gy;
                    } else {
                        f = 0.0f;
                    }
                } else {
                    f = this.f2986gy;
                }
                this.volume = C1290xm.m7835d(this.volume, f, 0.05f);
                Vec3 vec3Position = this.f2984a.position();
                this.x = vec3Position.x;
                this.y = vec3Position.y;
                this.z = vec3Position.z;
                return;
            }
        }
        stop();
    }
}
