package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.is, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/is.class */
public class C0235is<E extends Entity> extends AbstractTickableSoundInstance {

    @NotNull
    final E b;
    private final boolean cY;

    public C0235is(@NotNull E e, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        this(e, soundEvent, soundSource, f, f2, false);
    }

    public C0235is(@NotNull E e, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2, boolean z) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.b = e;
        this.cY = z;
        this.looping = false;
        this.pitch = f;
        this.volume = f2;
        this.x = e.getX();
        this.y = e.getY();
        this.z = e.getZ();
    }

    protected boolean W() {
        if (this.cY) {
            return false;
        }
        if (!this.b.isRemoved() && this.b.isAlive()) {
            LivingEntity livingEntity = this.b;
            if (!(livingEntity instanceof LivingEntity) || livingEntity.getHealth() > 0.0f) {
                return false;
            }
        }
        return true;
    }

    public boolean canPlaySound() {
        return !this.b.isSilent();
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        if (W()) {
            stop();
            return;
        }
        this.x = this.b.getX();
        this.y = this.b.getY();
        this.z = this.b.getZ();
    }
}
