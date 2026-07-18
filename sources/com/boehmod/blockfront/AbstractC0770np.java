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

/* JADX INFO: renamed from: com.boehmod.blockfront.np */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/np.class */
public abstract class AbstractC0770np extends C0774nt {

    /* JADX INFO: renamed from: lO */
    public int f4117lO;

    /* JADX INFO: renamed from: eX */
    public boolean f4118eX;

    /* JADX INFO: renamed from: eY */
    public boolean f4119eY;

    /* JADX INFO: renamed from: iY */
    public float f4120iY;

    /* JADX INFO: renamed from: av */
    protected abstract float mo3464av();

    /* JADX INFO: renamed from: a */
    protected abstract void mo3465a(Entity entity);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: bY */
    protected abstract void mo3466bY();

    @Nullable
    /* JADX INFO: renamed from: g */
    protected abstract SoundEvent mo3467g();

    /* JADX INFO: renamed from: bZ */
    protected abstract void mo3468bZ();

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: ca */
    protected abstract void mo3469ca();

    public AbstractC0770np(EntityType<? extends C0774nt> entityType, Level level) {
        super(entityType, level);
        this.f4117lO = 300;
        this.f4118eX = false;
        this.f4119eY = false;
        this.f4120iY = 0.1f;
    }

    @Override // com.boehmod.blockfront.C0774nt, com.boehmod.blockfront.AbstractC0676mA
    public void tick() {
        super.tick();
        Level level = level();
        if (this.f3612ew) {
            this.f4120iY = C1290xm.m7835d(this.f4120iY, 1.0f, 0.025f);
            if (level.isClientSide() && this.tickCount <= this.f4117lO) {
                mo3466bY();
            }
            Iterator it = level.getEntitiesOfClass(Entity.class, m3463h()).iterator();
            while (it.hasNext()) {
                mo3465a((Entity) it.next());
            }
        }
        if (isUnderWater() && !this.f4118eX) {
            m3473cd();
        }
        if (this.tickCount > this.f4117lO + mo3470aJ()) {
            mo3468bZ();
            discard();
        }
    }

    /* JADX INFO: renamed from: aO */
    public boolean m3462aO() {
        return this.f3612ew && !this.f4118eX;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public AABB m3463h() {
        return getBoundingBox().inflate(mo3464av() * this.f4120iY).inflate(0.25d);
    }

    /* JADX INFO: renamed from: aJ */
    protected int mo3470aJ() {
        return 0;
    }

    @Override // com.boehmod.blockfront.C0774nt, com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: ar */
    public float mo2988ar() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: bu */
    public void mo2981bu() {
        if (this.f4118eX || this.f3612ew) {
            return;
        }
        m3471cb();
    }

    /* JADX INFO: renamed from: cb */
    protected void m3471cb() {
        this.f3612ew = true;
        mo3472cc();
        if (level().isClientSide()) {
            mo3469ca();
        }
    }

    /* JADX INFO: renamed from: cc */
    protected void mo3472cc() {
        SoundEvent soundEventMo3467g = mo3467g();
        if (soundEventMo3467g != null) {
            playSound(soundEventMo3467g, 3.0f, 1.0f);
        }
    }

    /* JADX INFO: renamed from: cd */
    public void m3473cd() {
        this.f4118eX = true;
        playSound(SoundEvents.FIRE_EXTINGUISH, 1.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.C0774nt
    /* JADX INFO: renamed from: bT */
    protected void mo3449bT() {
        this.f4119eY = true;
    }
}
