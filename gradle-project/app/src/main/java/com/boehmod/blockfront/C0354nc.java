package com.boehmod.blockfront;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/* JADX INFO: renamed from: com.boehmod.blockfront.nc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nc.class */
public class C0354nc extends C0357nf implements InterfaceC0347mw {
    public C0354nc(EntityType<? extends C0354nc> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.C0357nf, com.boehmod.blockfront.mA
    public float ar() {
        return 0.05f;
    }

    @Override // com.boehmod.blockfront.C0357nf
    public int aF() {
        return 15;
    }

    @Override // com.boehmod.blockfront.C0357nf
    protected boolean aM() {
        return false;
    }
}
