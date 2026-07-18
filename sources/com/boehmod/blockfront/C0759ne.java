package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/* JADX INFO: renamed from: com.boehmod.blockfront.ne */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ne.class */
public final class C0759ne extends C0756nb {

    /* JADX INFO: renamed from: iS */
    private static final float f4071iS = 4.0f;

    public C0759ne(EntityType<? extends C0759ne> entityType, Level level) {
        super(entityType, level);
        m3431a((SoundEvent) C1280xc.f7726sB.get());
    }

    @Override // com.boehmod.blockfront.C0760nf, com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: ar */
    public float mo2988ar() {
        return 4.0f;
    }

    @Override // com.boehmod.blockfront.C0756nb
    /* JADX INFO: renamed from: aE */
    public int mo3424aE() {
        return 10;
    }

    @Override // com.boehmod.blockfront.C0756nb, com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: at */
    protected float mo2991at() {
        return 8.5f;
    }
}
