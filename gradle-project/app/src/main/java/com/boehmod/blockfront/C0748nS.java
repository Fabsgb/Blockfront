package com.boehmod.blockfront;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: com.boehmod.blockfront.nS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nS.class */
public class C0748nS extends AbstractC0741nL {

    /* JADX INFO: renamed from: nT */
    public static final int f4098nT = 1;

    /* JADX INFO: renamed from: nU */
    private static final int f4099nU = 25;

    /* JADX INFO: renamed from: nV */
    private static final int f4100nV = 60;

    /* JADX INFO: renamed from: fu */
    static final /* synthetic */ boolean f4101fu;

    static {
        f4101fu = !C0748nS.class.desiredAssertionStatus();
    }

    public C0748nS(EntityType<? extends C0745nP> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.AbstractC0741nL
    /* JADX INFO: renamed from: aB */
    protected float mo3387aB() {
        return 2.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0741nL
    /* JADX INFO: renamed from: aY */
    protected int mo3393aY() {
        return 60;
    }

    @Override // com.boehmod.blockfront.AbstractC0741nL
    /* JADX INFO: renamed from: a */
    protected void mo3388a(Entity entity) {
        if (entity instanceof C0743nN) {
            C0743nN c0743nN = (C0743nN) entity;
            if (!c0743nN.m3137aN() || c0743nN.f4073fr) {
                return;
            }
            c0743nN.m3396co();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0741nL
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: cj */
    protected void mo3389cj() {
        Minecraft minecraft = Minecraft.getInstance();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f4101fu && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (minecraft.level != null) {
            C0490iZ.m2216a(minecraft, c0623lM2852b, minecraft.level, (ParticleOptions) C1309xw.f7889nZ.get(), position().add(0.0d, 0.5d, 0.0d), 0.0f, 2.0f, 1, 0.075f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0741nL
    /* JADX INFO: renamed from: g */
    protected SoundEvent mo3390g() {
        return (SoundEvent) C1312xz.f8200tN.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0741nL
    /* JADX INFO: renamed from: cn */
    protected void mo3395cn() {
        super.mo3395cn();
        playSound((SoundEvent) C1312xz.f8201tO.get(), 1.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0741nL
    /* JADX INFO: renamed from: ck */
    protected void mo3391ck() {
    }

    @Override // com.boehmod.blockfront.AbstractC0741nL
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: cl */
    protected void mo3392cl() {
        Level level = level();
        Vec3 vec3Position = position();
        Minecraft minecraft = Minecraft.getInstance();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f4101fu && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ClientLevel clientLevel = minecraft.level;
        if (clientLevel == null) {
            return;
        }
        double dMax = Math.max(1.1f, mo3387aB() * this.f4075jR);
        level.addParticle(ParticleTypes.FLASH, true, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
        for (int i = 0; i < 25; i++) {
            double dNextDouble = ThreadLocalRandom.current().nextDouble(1.0d, dMax);
            double dNextDouble2 = ((Math.random() < 0.5d ? dNextDouble : -dNextDouble) + this.random.nextDouble()) / 5.0d;
            double dNextDouble3 = this.random.nextDouble() * 3.141592653589793d;
            double dCos = Math.cos(dNextDouble3) * dNextDouble2;
            double dSin = Math.sin(dNextDouble3) * dNextDouble2;
            C0490iZ.m2218a(minecraft, c0623lM2852b, clientLevel, (SimpleParticleType) C1309xw.f7890oa.get(), vec3Position.x + (dCos * 0.1d), vec3Position.y + 0.1d, vec3Position.z + (dSin * 0.1d), dCos, 0.0d, dSin);
        }
    }

    @Override // com.boehmod.blockfront.C0745nP
    /* JADX INFO: renamed from: cd */
    public void mo3371cd() {
        if (!this.f4073fr && !this.f3862eQ) {
            level().addParticle(ParticleTypes.CLOUD, true, getX(), getY() + ((double) getEyeHeight()), getZ(), 0.0d, 0.0d, 0.0d);
        }
    }
}
