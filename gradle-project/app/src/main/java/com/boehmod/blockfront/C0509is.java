package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.is */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/is.class */
public class C0509is extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Entity f3141a;

    /* JADX INFO: renamed from: cX */
    private final boolean f3142cX;

    /* JADX INFO: renamed from: gT */
    private final float f3143gT;

    public C0509is(@NotNull Entity entity, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, boolean z, float f) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.f3141a = entity;
        this.looping = true;
        this.volume = 0.0f;
        this.f3142cX = z;
        this.f3143gT = f;
        Vec3 vec3Position = entity.position();
        this.x = vec3Position.x;
        this.y = vec3Position.y;
        this.z = vec3Position.z;
    }

    public boolean canPlaySound() {
        return !this.f3141a.isSilent();
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        float f;
        if (!this.f3141a.isRemoved() && this.f3141a.isAlive()) {
            LivingEntity livingEntity = this.f3141a;
            if (!(livingEntity instanceof LivingEntity) || livingEntity.getHealth() > 0.0f) {
                if (this.f3142cX) {
                    double x = this.f3141a.getX() - this.f3141a.xOld;
                    double z = this.f3141a.getZ() - this.f3141a.zOld;
                    float fSqrt = (float) Math.sqrt((x * x) + (z * z));
                    if (this.f3141a.onGround() && !this.f3141a.isShiftKeyDown() && fSqrt > 0.01f) {
                        f = this.f3143gT;
                    } else {
                        f = 0.0f;
                    }
                } else {
                    f = this.f3143gT;
                }
                this.volume = C1270xJ.m7161d(this.volume, f, 0.05f);
                Vec3 vec3Position = this.f3141a.position();
                this.x = vec3Position.x;
                this.y = vec3Position.y;
                this.z = vec3Position.z;
                return;
            }
        }
        stop();
    }
}
