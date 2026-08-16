package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/* JADX INFO: renamed from: com.boehmod.blockfront.nA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nA.class */
public final class C0730nA extends C0779nx {

    /* JADX INFO: renamed from: jL */
    private static final float f4026jL = 4.0f;

    public C0730nA(EntityType<? extends C0730nA> entityType, Level level) {
        super(entityType, level);
        m3354a((SoundEvent) C1312xz.f8137sC.get());
    }

    @Override // com.boehmod.blockfront.C0731nB, com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: ax */
    public float mo3139ax() {
        return 4.0f;
    }

    @Override // com.boehmod.blockfront.C0779nx
    /* JADX INFO: renamed from: aT */
    public int mo3348aT() {
        return 10;
    }

    @Override // com.boehmod.blockfront.C0779nx, com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: az */
    protected float mo3142az() {
        return 8.5f;
    }
}
