package com.boehmod.blockfront;

import java.util.Iterator;
import java.util.List;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nn.class */
public final class C0365nn extends C0371nt {
    public boolean eW;
    private int lL;
    private int z;

    public C0365nn(EntityType<C0365nn> entityType, Level level) {
        super(entityType, level);
        this.eW = false;
        this.lL = C0529tp.rx;
        this.z = 0;
    }

    public void bW() {
        boolean z = false;
        Iterator<Entity> it = a(0.5f).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Entity next = it.next();
            if ((next instanceof AbstractC0376ny) && a((AbstractC0376ny) next)) {
                z = true;
                break;
            }
        }
        if (z) {
            bu();
        }
    }

    private boolean a(@NotNull AbstractC0376ny abstractC0376ny) {
        return !abstractC0376ny.aP() && (this.f236a == null || !abstractC0376ny.d(this.f236a));
    }

    public List<Entity> a(float f) {
        return level().getEntitiesOfClass(Entity.class, getBoundingBox().inflate(f));
    }

    public List<AbstractC0376ny> b(float f) {
        return level().getEntitiesOfClass(AbstractC0376ny.class, getBoundingBox().inflate(f));
    }

    public boolean ignoreExplosion(@NotNull Explosion explosion) {
        return false;
    }

    @Override // com.boehmod.blockfront.mA
    protected float ap() {
        return 0.4f;
    }

    @Override // com.boehmod.blockfront.mA
    protected float aq() {
        return 0.4f;
    }

    @Override // com.boehmod.blockfront.C0371nt
    public void bS() {
    }

    @Override // com.boehmod.blockfront.C0371nt
    public int aH() {
        return 1;
    }

    @Override // com.boehmod.blockfront.C0371nt, com.boehmod.blockfront.mA
    public void tick() {
        super.tick();
        if (!level().isClientSide) {
            int i = this.z;
            this.z = i - 1;
            if (i <= 0) {
                this.z = 10;
                if (this.tickCount > 40) {
                    bW();
                }
            }
        }
        int i2 = this.lL;
        this.lL = i2 - 1;
        if (i2 <= 0) {
            discard();
        }
    }

    @Override // com.boehmod.blockfront.mA
    public void bu() {
        if (!this.ew) {
            bX();
        }
        super.bu();
    }

    private void bX() {
        for (AbstractC0376ny abstractC0376ny : b(1.0f)) {
            if (a(abstractC0376ny)) {
                abstractC0376ny.a(getItem(), this.f236a, abstractC0376ny.m741b().jC);
                C0582vo.b(new vG(hH.q, position().toVector3f(), 32.0f));
            }
        }
    }

    @Override // com.boehmod.blockfront.C0371nt
    protected DeferredHolder<SoundEvent, SoundEvent> a(@NotNull SoundType soundType) {
        return C0624xc.tW;
    }

    @Override // com.boehmod.blockfront.C0371nt
    public int aI() {
        return Integer.MAX_VALUE;
    }
}
