package com.boehmod.blockfront;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ng, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ng.class */
public class C0358ng extends C0357nf {
    private static final int lG = 5;
    private static final int lH = 2;
    public static final int lI = 400;
    private int lJ;

    public C0358ng(EntityType<? extends C0358ng> entityType, Level level) {
        super(entityType, level);
        this.lJ = 400;
        a((SoundEvent) C0624xc.sB.get());
        bt();
    }

    public void w(int i) {
        this.lJ = i;
    }

    public int aE() {
        return 5;
    }

    @Override // com.boehmod.blockfront.C0357nf, com.boehmod.blockfront.mA
    public void tick() {
        super.tick();
        setDeltaMovement(0.0d, -aE(), 0.0d);
    }

    @Override // com.boehmod.blockfront.C0357nf
    public int aF() {
        return 300;
    }

    @Override // com.boehmod.blockfront.C0357nf
    protected boolean aM() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0357nf, com.boehmod.blockfront.mA
    public float ar() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.mA
    public void bu() {
        if (this.ew) {
            return;
        }
        Level level = level();
        if (level instanceof ServerLevel) {
            c((ServerLevel) level);
        }
        super.bu();
    }

    private void c(@NotNull ServerLevel serverLevel) {
        C0374nw c0374nwCreate = ((EntityType) wX.kL.get()).create(serverLevel);
        if (c0374nwCreate == null) {
            return;
        }
        c0374nwCreate.a(ItemStack.EMPTY);
        c0374nwCreate.c(this.f236a);
        c0374nwCreate.lO = this.lJ;
        c0374nwCreate.o(0);
        c0374nwCreate.y(2);
        c0374nwCreate.setPos(getX(), getY(), getZ());
        serverLevel.addFreshEntity(c0374nwCreate);
    }
}
