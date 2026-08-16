package com.boehmod.blockfront;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/* JADX INFO: renamed from: com.boehmod.blockfront.ny */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ny.class */
public class C0780ny extends C0731nB implements InterfaceC0695mS {
    public C0780ny(EntityType<? extends C0780ny> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.C0731nB, com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: ax */
    public float mo3139ax() {
        return 0.05f;
    }

    @Override // com.boehmod.blockfront.C0731nB
    /* JADX INFO: renamed from: aU */
    public int mo3352aU() {
        return 15;
    }

    @Override // com.boehmod.blockfront.C0731nB
    /* JADX INFO: renamed from: aW */
    protected boolean mo3351aW() {
        return false;
    }
}
