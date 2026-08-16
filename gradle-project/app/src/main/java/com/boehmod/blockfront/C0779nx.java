package com.boehmod.blockfront;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/* JADX INFO: renamed from: com.boehmod.blockfront.nx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nx.class */
public class C0779nx extends C0731nB {
    public C0779nx(EntityType<? extends C0779nx> entityType, Level level) {
        super(entityType, level);
        m3354a((SoundEvent) C1312xz.f8137sC.get());
    }

    /* JADX INFO: renamed from: aT */
    public int mo3348aT() {
        return 5;
    }

    @Override // com.boehmod.blockfront.C0731nB, com.boehmod.blockfront.AbstractC0699mW
    public void tick() {
        super.tick();
        setDeltaMovement(0.0d, -mo3348aT(), 0.0d);
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: az */
    protected float mo3142az() {
        return 4.5f;
    }

    @Override // com.boehmod.blockfront.C0731nB
    /* JADX INFO: renamed from: aU */
    public int mo3352aU() {
        return 300;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: bF */
    public void mo3132bF() {
        super.mo3132bF();
        Level level = level();
        level.addParticle(ParticleTypes.FLASH, getX(), getY(), getZ(), 0.0d, 0.0d, 0.0d);
        level.playSound((Player) null, blockPosition(), (SoundEvent) C1312xz.f8687Dg.get(), SoundSource.AMBIENT, 10.0f, 1.0f);
        level.setSkyFlashTime(1);
    }

    @Override // com.boehmod.blockfront.C0731nB
    /* JADX INFO: renamed from: aW */
    protected boolean mo3351aW() {
        return false;
    }
}
