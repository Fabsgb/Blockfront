package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/* JADX INFO: renamed from: com.boehmod.blockfront.ne, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ne.class */
public final class C0356ne extends C0353nb {
    private static final float iS = 4.0f;

    public C0356ne(EntityType<? extends C0356ne> entityType, Level level) {
        super(entityType, level);
        a((SoundEvent) C0624xc.sB.get());
    }

    @Override // com.boehmod.blockfront.C0357nf, com.boehmod.blockfront.mA
    public float ar() {
        return 4.0f;
    }

    @Override // com.boehmod.blockfront.C0353nb
    public int aE() {
        return 10;
    }

    @Override // com.boehmod.blockfront.C0353nb, com.boehmod.blockfront.mA
    protected float at() {
        return 8.5f;
    }
}
