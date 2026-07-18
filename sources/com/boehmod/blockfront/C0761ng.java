package com.boehmod.blockfront;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ng */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ng.class */
public class C0761ng extends C0760nf {

    /* JADX INFO: renamed from: lG */
    private static final int f4087lG = 5;

    /* JADX INFO: renamed from: lH */
    private static final int f4088lH = 2;

    /* JADX INFO: renamed from: lI */
    public static final int f4089lI = 400;

    /* JADX INFO: renamed from: lJ */
    private int f4090lJ;

    public C0761ng(EntityType<? extends C0761ng> entityType, Level level) {
        super(entityType, level);
        this.f4090lJ = 400;
        m3431a((SoundEvent) C1280xc.f7726sB.get());
        m2976bt();
    }

    /* JADX INFO: renamed from: w */
    public void m3440w(int i) {
        this.f4090lJ = i;
    }

    /* JADX INFO: renamed from: aE */
    public int m3441aE() {
        return 5;
    }

    @Override // com.boehmod.blockfront.C0760nf, com.boehmod.blockfront.AbstractC0676mA
    public void tick() {
        super.tick();
        setDeltaMovement(0.0d, -m3441aE(), 0.0d);
    }

    @Override // com.boehmod.blockfront.C0760nf
    /* JADX INFO: renamed from: aF */
    public int mo3425aF() {
        return 300;
    }

    @Override // com.boehmod.blockfront.C0760nf
    /* JADX INFO: renamed from: aM */
    protected boolean mo3426aM() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0760nf, com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: ar */
    public float mo2988ar() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: bu */
    public void mo2981bu() {
        if (this.f3612ew) {
            return;
        }
        Level level = level();
        if (level instanceof ServerLevel) {
            m3442c((ServerLevel) level);
        }
        super.mo2981bu();
    }

    /* JADX INFO: renamed from: c */
    private void m3442c(@NotNull ServerLevel serverLevel) {
        C0777nw c0777nwCreate = ((EntityType) C1230wX.f7042kL.get()).create(serverLevel);
        if (c0777nwCreate == null) {
            return;
        }
        c0777nwCreate.mo2971a(ItemStack.EMPTY);
        c0777nwCreate.m2977c(this.f3611a);
        c0777nwCreate.f4117lO = this.f4090lJ;
        c0777nwCreate.m3483o(0);
        c0777nwCreate.m3485y(2);
        c0777nwCreate.setPos(getX(), getY(), getZ());
        serverLevel.addFreshEntity(c0777nwCreate);
    }
}
