package com.boehmod.blockfront;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.is */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/is.class */
public class C0508is<E extends Entity> extends AbstractTickableSoundInstance {

    /* JADX INFO: renamed from: b */
    @NotNull
    final E f3024b;

    /* JADX INFO: renamed from: cY */
    private final boolean f3025cY;

    public C0508is(@NotNull E e, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2) {
        this(e, soundEvent, soundSource, f, f2, false);
    }

    public C0508is(@NotNull E e, @NotNull SoundEvent soundEvent, @NotNull SoundSource soundSource, float f, float f2, boolean z) {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.f3024b = e;
        this.f3025cY = z;
        this.looping = false;
        this.pitch = f;
        this.volume = f2;
        this.x = e.getX();
        this.y = e.getY();
        this.z = e.getZ();
    }

    /* JADX INFO: renamed from: W */
    protected boolean mo2248W() {
        if (this.f3025cY) {
            return false;
        }
        if (!this.f3024b.isRemoved() && this.f3024b.isAlive()) {
            LivingEntity livingEntity = this.f3024b;
            if (!(livingEntity instanceof LivingEntity) || livingEntity.getHealth() > 0.0f) {
                return false;
            }
        }
        return true;
    }

    public boolean canPlaySound() {
        return !this.f3024b.isSilent();
    }

    public boolean canStartSilent() {
        return true;
    }

    public void tick() {
        if (mo2248W()) {
            stop();
            return;
        }
        this.x = this.f3024b.getX();
        this.y = this.f3024b.getY();
        this.z = this.f3024b.getZ();
    }
}
