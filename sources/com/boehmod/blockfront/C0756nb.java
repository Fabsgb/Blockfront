package com.boehmod.blockfront;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/* JADX INFO: renamed from: com.boehmod.blockfront.nb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nb.class */
public class C0756nb extends C0760nf {
    public C0756nb(EntityType<? extends C0756nb> entityType, Level level) {
        super(entityType, level);
        m3431a((SoundEvent) C1280xc.f7726sB.get());
    }

    /* JADX INFO: renamed from: aE */
    public int mo3424aE() {
        return 5;
    }

    @Override // com.boehmod.blockfront.C0760nf, com.boehmod.blockfront.AbstractC0676mA
    public void tick() {
        super.tick();
        setDeltaMovement(0.0d, -mo3424aE(), 0.0d);
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: at */
    protected float mo2991at() {
        return 4.5f;
    }

    @Override // com.boehmod.blockfront.C0760nf
    /* JADX INFO: renamed from: aF */
    public int mo3425aF() {
        return 300;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: bu */
    public void mo2981bu() {
        super.mo2981bu();
        Level level = level();
        level.addParticle(ParticleTypes.FLASH, getX(), getY(), getZ(), 0.0d, 0.0d, 0.0d);
        level.playSound((Player) null, blockPosition(), (SoundEvent) C1280xc.f8274Dd.get(), SoundSource.AMBIENT, 10.0f, 1.0f);
        level.setSkyFlashTime(1);
    }

    @Override // com.boehmod.blockfront.C0760nf
    /* JADX INFO: renamed from: aM */
    protected boolean mo3426aM() {
        return false;
    }
}
