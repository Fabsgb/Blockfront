package com.boehmod.blockfront;

import java.util.Iterator;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.np, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/np.class */
public abstract class AbstractC0367np extends C0371nt {
    public int lO;
    public boolean eX;
    public boolean eY;
    public float iY;

    protected abstract float av();

    protected abstract void a(Entity entity);

    @OnlyIn(Dist.CLIENT)
    protected abstract void bY();

    @Nullable
    protected abstract SoundEvent g();

    protected abstract void bZ();

    @OnlyIn(Dist.CLIENT)
    protected abstract void ca();

    public AbstractC0367np(EntityType<? extends C0371nt> entityType, Level level) {
        super(entityType, level);
        this.lO = 300;
        this.eX = false;
        this.eY = false;
        this.iY = 0.1f;
    }

    @Override // com.boehmod.blockfront.C0371nt, com.boehmod.blockfront.mA
    public void tick() {
        super.tick();
        Level level = level();
        if (this.ew) {
            this.iY = C0634xm.d(this.iY, 1.0f, 0.025f);
            if (level.isClientSide() && this.tickCount <= this.lO) {
                bY();
            }
            Iterator it = level.getEntitiesOfClass(Entity.class, h()).iterator();
            while (it.hasNext()) {
                a((Entity) it.next());
            }
        }
        if (isUnderWater() && !this.eX) {
            cd();
        }
        if (this.tickCount > this.lO + aJ()) {
            bZ();
            discard();
        }
    }

    public boolean aO() {
        return this.ew && !this.eX;
    }

    @NotNull
    public AABB h() {
        return getBoundingBox().inflate(av() * this.iY).inflate(0.25d);
    }

    protected int aJ() {
        return 0;
    }

    @Override // com.boehmod.blockfront.C0371nt, com.boehmod.blockfront.mA
    public float ar() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.mA
    public void bu() {
        if (this.eX || this.ew) {
            return;
        }
        cb();
    }

    protected void cb() {
        this.ew = true;
        cc();
        if (level().isClientSide()) {
            ca();
        }
    }

    protected void cc() {
        SoundEvent soundEventG = g();
        if (soundEventG != null) {
            playSound(soundEventG, 3.0f, 1.0f);
        }
    }

    public void cd() {
        this.eX = true;
        playSound(SoundEvents.FIRE_EXTINGUISH, 1.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.C0371nt
    protected void bT() {
        this.eY = true;
    }
}
