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

/* JADX INFO: renamed from: com.boehmod.blockfront.nL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nL.class */
public abstract class AbstractC0741nL extends C0745nP {

    /* JADX INFO: renamed from: nM */
    public int f4072nM;

    /* JADX INFO: renamed from: fr */
    public boolean f4073fr;

    /* JADX INFO: renamed from: fs */
    public boolean f4074fs;

    /* JADX INFO: renamed from: jR */
    public float f4075jR;

    /* JADX INFO: renamed from: aB */
    protected abstract float mo3387aB();

    /* JADX INFO: renamed from: a */
    protected abstract void mo3388a(Entity entity);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: cj */
    protected abstract void mo3389cj();

    @Nullable
    /* JADX INFO: renamed from: g */
    protected abstract SoundEvent mo3390g();

    /* JADX INFO: renamed from: ck */
    protected abstract void mo3391ck();

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: cl */
    protected abstract void mo3392cl();

    public AbstractC0741nL(EntityType<? extends C0745nP> entityType, Level level) {
        super(entityType, level);
        this.f4072nM = 300;
        this.f4073fr = false;
        this.f4074fs = false;
        this.f4075jR = 0.1f;
    }

    @Override // com.boehmod.blockfront.C0745nP, com.boehmod.blockfront.AbstractC0699mW
    public void tick() {
        super.tick();
        Level level = level();
        if (this.f3862eQ) {
            this.f4075jR = C1270xJ.m7161d(this.f4075jR, 1.0f, 0.025f);
            if (level.isClientSide() && this.tickCount <= this.f4072nM) {
                mo3389cj();
            }
            Iterator it = level.getEntitiesOfClass(Entity.class, m3386h()).iterator();
            while (it.hasNext()) {
                mo3388a((Entity) it.next());
            }
        }
        if (isUnderWater() && !this.f4073fr) {
            m3396co();
        }
        if (this.tickCount > this.f4072nM + mo3393aY()) {
            mo3391ck();
            discard();
        }
    }

    /* JADX INFO: renamed from: aY */
    public boolean m3385aY() {
        return this.f3862eQ && !this.f4073fr;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public AABB m3386h() {
        return getBoundingBox().inflate(mo3387aB() * this.f4075jR).inflate(0.25d);
    }

    /* JADX INFO: renamed from: aY */
    protected int mo3393aY() {
        return 0;
    }

    @Override // com.boehmod.blockfront.C0745nP, com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: ax */
    public float mo3139ax() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: bF */
    public void mo3132bF() {
        if (this.f4073fr || this.f3862eQ) {
            return;
        }
        m3394cm();
    }

    /* JADX INFO: renamed from: cm */
    protected void m3394cm() {
        this.f3862eQ = true;
        if (m3411ba() != -1) {
            m3410p(m3411ba());
        }
        mo3395cn();
        if (level().isClientSide()) {
            mo3392cl();
        }
    }

    /* JADX INFO: renamed from: cn */
    protected void mo3395cn() {
        SoundEvent soundEventMo3390g = mo3390g();
        if (soundEventMo3390g != null) {
            playSound(soundEventMo3390g, 3.0f, 1.0f);
        }
    }

    /* JADX INFO: renamed from: co */
    public void m3396co() {
        this.f4073fr = true;
        playSound(SoundEvents.FIRE_EXTINGUISH, 1.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.C0745nP
    /* JADX INFO: renamed from: ce */
    protected void mo3372ce() {
        this.f4074fs = true;
    }
}
