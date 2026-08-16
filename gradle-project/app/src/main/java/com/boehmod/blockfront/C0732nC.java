package com.boehmod.blockfront;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nC.class */
public class C0732nC extends C0731nB {

    /* JADX INFO: renamed from: nE */
    private static final int f4042nE = 5;

    /* JADX INFO: renamed from: nF */
    private static final int f4043nF = 2;

    /* JADX INFO: renamed from: nG */
    public static final int f4044nG = 400;

    /* JADX INFO: renamed from: nH */
    private int f4045nH;

    public C0732nC(EntityType<? extends C0732nC> entityType, Level level) {
        super(entityType, level);
        this.f4045nH = 400;
        m3354a((SoundEvent) C1312xz.f8137sC.get());
        m3127bE();
    }

    /* JADX INFO: renamed from: x */
    public void m3363x(int i) {
        this.f4045nH = i;
    }

    /* JADX INFO: renamed from: aT */
    public int m3364aT() {
        return 5;
    }

    @Override // com.boehmod.blockfront.C0731nB, com.boehmod.blockfront.AbstractC0699mW
    public void tick() {
        super.tick();
        setDeltaMovement(0.0d, -m3364aT(), 0.0d);
    }

    @Override // com.boehmod.blockfront.C0731nB
    /* JADX INFO: renamed from: aU */
    public int mo3352aU() {
        return 300;
    }

    @Override // com.boehmod.blockfront.C0731nB
    /* JADX INFO: renamed from: aW */
    protected boolean mo3351aW() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0731nB, com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: ax */
    public float mo3139ax() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: bF */
    public void mo3132bF() {
        if (this.f3862eQ) {
            return;
        }
        Level level = level();
        if (level instanceof ServerLevel) {
            m3365c((ServerLevel) level);
        }
        super.mo3132bF();
    }

    /* JADX INFO: renamed from: c */
    private void m3365c(@NotNull ServerLevel serverLevel) {
        C0748nS c0748nSCreate = ((EntityType) C1307xu.f7607kL.get()).create(serverLevel);
        if (c0748nSCreate == null) {
            return;
        }
        c0748nSCreate.mo3122a(ItemStack.EMPTY);
        c0748nSCreate.m3128c(this.f3861a);
        c0748nSCreate.f4072nM = this.f4045nH;
        c0748nSCreate.m3410p(0);
        c0748nSCreate.m3412z(2);
        c0748nSCreate.setPos(getX(), getY(), getZ());
        serverLevel.addFreshEntity(c0748nSCreate);
    }
}
