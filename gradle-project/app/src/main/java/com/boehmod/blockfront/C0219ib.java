package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ib, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ib.class */
public class C0219ib extends AbstractTickableSoundInstance {

    @NotNull
    private final Entity a;
    private final boolean cO;
    private final float gy;

    public C0219ib(@NotNull Entity entity, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, boolean z, float f) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.a = entity;
        this.looping = true;
        this.volume = 0.0f;
        this.cO = z;
        this.gy = f;
        Vec3 vec3Position = entity.position();
        this.x = vec3Position.x;
        this.y = vec3Position.y;
        this.z = vec3Position.z;
    }

    public boolean canPlaySound() {
        return !this.a.isSilent();
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        float f;
        if (!this.a.isRemoved() && this.a.isAlive()) {
            LivingEntity livingEntity = this.a;
            if (!(livingEntity instanceof LivingEntity) || livingEntity.getHealth() > 0.0f) {
                if (this.cO) {
                    double x = this.a.getX() - this.a.xOld;
                    double z = this.a.getZ() - this.a.zOld;
                    float fSqrt = (float) Math.sqrt((x * x) + (z * z));
                    if (this.a.onGround() && !this.a.isShiftKeyDown() && fSqrt > 0.01f) {
                        f = this.gy;
                    } else {
                        f = 0.0f;
                    }
                } else {
                    f = this.gy;
                }
                this.volume = C0634xm.d(this.volume, f, 0.05f);
                Vec3 vec3Position = this.a.position();
                this.x = vec3Position.x;
                this.y = vec3Position.y;
                this.z = vec3Position.z;
                return;
            }
        }
        stop();
    }
}
