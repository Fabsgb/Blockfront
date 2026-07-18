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

/* JADX INFO: renamed from: com.boehmod.blockfront.nn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nn.class */
public final class C0768nn extends C0774nt {

    /* JADX INFO: renamed from: eW */
    public boolean f4109eW;

    /* JADX INFO: renamed from: lL */
    private int f4110lL;

    /* JADX INFO: renamed from: z */
    private int f4111z;

    public C0768nn(EntityType<C0768nn> entityType, Level level) {
        super(entityType, level);
        this.f4109eW = false;
        this.f4110lL = C1089tp.f5684rx;
        this.f4111z = 0;
    }

    /* JADX INFO: renamed from: bW */
    public void m3454bW() {
        boolean z = false;
        Iterator<Entity> it = m3456a(0.5f).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Entity next = it.next();
            if ((next instanceof AbstractC0779ny) && m3455a((AbstractC0779ny) next)) {
                z = true;
                break;
            }
        }
        if (z) {
            mo2981bu();
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3455a(@NotNull AbstractC0779ny abstractC0779ny) {
        return !abstractC0779ny.m3504aP() && (this.f3611a == null || !abstractC0779ny.m3512d(this.f3611a));
    }

    /* JADX INFO: renamed from: a */
    public List<Entity> m3456a(float f) {
        return level().getEntitiesOfClass(Entity.class, getBoundingBox().inflate(f));
    }

    /* JADX INFO: renamed from: b */
    public List<AbstractC0779ny> m3457b(float f) {
        return level().getEntitiesOfClass(AbstractC0779ny.class, getBoundingBox().inflate(f));
    }

    public boolean ignoreExplosion(@NotNull Explosion explosion) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: ap */
    protected float mo2974ap() {
        return 0.4f;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: aq */
    protected float mo2975aq() {
        return 0.4f;
    }

    @Override // com.boehmod.blockfront.C0774nt
    /* JADX INFO: renamed from: bS */
    public void mo3448bS() {
    }

    @Override // com.boehmod.blockfront.C0774nt
    /* JADX INFO: renamed from: aH */
    public int mo3445aH() {
        return 1;
    }

    @Override // com.boehmod.blockfront.C0774nt, com.boehmod.blockfront.AbstractC0676mA
    public void tick() {
        super.tick();
        if (!level().isClientSide) {
            int i = this.f4111z;
            this.f4111z = i - 1;
            if (i <= 0) {
                this.f4111z = 10;
                if (this.tickCount > 40) {
                    m3454bW();
                }
            }
        }
        int i2 = this.f4110lL;
        this.f4110lL = i2 - 1;
        if (i2 <= 0) {
            discard();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: bu */
    public void mo2981bu() {
        if (!this.f3612ew) {
            m3458bX();
        }
        super.mo2981bu();
    }

    /* JADX INFO: renamed from: bX */
    private void m3458bX() {
        for (AbstractC0779ny abstractC0779ny : m3457b(1.0f)) {
            if (m3455a(abstractC0779ny)) {
                abstractC0779ny.m3517a(getItem(), this.f3611a, abstractC0779ny.m3499b().f3949jC);
                C1194vo.m6649b(new C1160vG(C0418hH.f2674q, position().toVector3f(), 32.0f));
            }
        }
    }

    @Override // com.boehmod.blockfront.C0774nt
    /* JADX INFO: renamed from: a */
    protected DeferredHolder<SoundEvent, SoundEvent> mo3443a(@NotNull SoundType soundType) {
        return C1280xc.f7799tW;
    }

    @Override // com.boehmod.blockfront.C0774nt
    /* JADX INFO: renamed from: aI */
    public int mo3459aI() {
        return Integer.MAX_VALUE;
    }
}
