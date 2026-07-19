package com.boehmod.blockfront;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/* JADX INFO: renamed from: com.boehmod.blockfront.nb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nb.class */
public class C0353nb extends C0357nf {
    public C0353nb(EntityType<? extends C0353nb> entityType, Level level) {
        super(entityType, level);
        a((SoundEvent) C0624xc.sB.get());
    }

    public int aE() {
        return 5;
    }

    @Override // com.boehmod.blockfront.C0357nf, com.boehmod.blockfront.mA
    public void tick() {
        super.tick();
        setDeltaMovement(0.0d, -aE(), 0.0d);
    }

    @Override // com.boehmod.blockfront.mA
    protected float at() {
        return 4.5f;
    }

    @Override // com.boehmod.blockfront.C0357nf
    public int aF() {
        return 300;
    }

    @Override // com.boehmod.blockfront.mA
    public void bu() {
        super.bu();
        Level level = level();
        level.addParticle(ParticleTypes.FLASH, getX(), getY(), getZ(), 0.0d, 0.0d, 0.0d);
        level.playSound((Player) null, blockPosition(), (SoundEvent) C0624xc.Dd.get(), SoundSource.AMBIENT, 10.0f, 1.0f);
        level.setSkyFlashTime(1);
    }

    @Override // com.boehmod.blockfront.C0357nf
    protected boolean aM() {
        return false;
    }
}
