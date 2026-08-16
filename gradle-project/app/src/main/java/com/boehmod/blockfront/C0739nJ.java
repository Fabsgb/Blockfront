package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nJ.class */
public final class C0739nJ extends C0745nP {

    /* JADX INFO: renamed from: fq */
    public boolean f4064fq;

    /* JADX INFO: renamed from: nJ */
    private int f4065nJ;

    /* JADX INFO: renamed from: ab */
    private int f4066ab;

    public C0739nJ(EntityType<C0739nJ> entityType, Level level) {
        super(entityType, level);
        this.f4064fq = false;
        this.f4065nJ = C1062tN.f5737tA;
        this.f4066ab = 0;
    }

    /* JADX INFO: renamed from: ch */
    public void m3377ch() {
        boolean z = false;
        for (Entity entity : m3379a(0.5f)) {
            if ((entity instanceof AbstractC0750nU) && m3378a((AbstractC0750nU) entity)) {
                z = true;
                break;
            }
        }
        if (z) {
            mo3132bF();
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3378a(@NotNull AbstractC0750nU abstractC0750nU) {
        return !abstractC0750nU.m3441aZ() && (this.f3861a == null || !abstractC0750nU.m3449d(this.f3861a));
    }

    /* JADX INFO: renamed from: a */
    public List<Entity> m3379a(float f) {
        return level().getEntitiesOfClass(Entity.class, getBoundingBox().inflate(f));
    }

    /* JADX INFO: renamed from: b */
    public List<AbstractC0750nU> m3380b(float f) {
        return level().getEntitiesOfClass(AbstractC0750nU.class, getBoundingBox().inflate(f));
    }

    public boolean ignoreExplosion(@NotNull Explosion explosion) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: av */
    protected float mo3125av() {
        return 0.4f;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: aw */
    protected float mo3126aw() {
        return 0.4f;
    }

    @Override // com.boehmod.blockfront.C0745nP
    /* JADX INFO: renamed from: cd */
    public void mo3371cd() {
    }

    @Override // com.boehmod.blockfront.C0745nP
    /* JADX INFO: renamed from: aW */
    public int mo3368aW() {
        return 1;
    }

    @Override // com.boehmod.blockfront.C0745nP, com.boehmod.blockfront.AbstractC0699mW
    public void tick() {
        super.tick();
        if (!level().isClientSide) {
            int i = this.f4066ab;
            this.f4066ab = i - 1;
            if (i <= 0) {
                this.f4066ab = 10;
                if (this.tickCount > 40) {
                    m3377ch();
                }
            }
        }
        int i2 = this.f4065nJ;
        this.f4065nJ = i2 - 1;
        if (i2 <= 0) {
            discard();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: bF */
    public void mo3132bF() {
        if (!this.f3862eQ) {
            m3381ci();
        }
        super.mo3132bF();
    }

    /* JADX INFO: renamed from: ci */
    private void m3381ci() {
        for (AbstractC0750nU abstractC0750nU : m3380b(1.0f)) {
            if (m3378a(abstractC0750nU)) {
                abstractC0750nU.m3454a(getItem(), this.f3861a, abstractC0750nU.m3436b().f4377kv);
                C1169vO.m6644b(new C1239wf(C0435hX.f2767q, position().toVector3f(), 32.0f));
            }
        }
    }

    @Override // com.boehmod.blockfront.C0745nP
    /* JADX INFO: renamed from: a */
    protected DeferredHolder<SoundEvent, SoundEvent> mo3366a(@NotNull SoundType soundType) {
        return C1312xz.f8210tX;
    }

    @Override // com.boehmod.blockfront.C0745nP
    /* JADX INFO: renamed from: aX */
    public int mo3382aX() {
        return Integer.MAX_VALUE;
    }
}
