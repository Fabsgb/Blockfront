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

/* JADX INFO: renamed from: com.boehmod.blockfront.nw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nw.class */
public class C0777nw extends AbstractC0770np {

    /* JADX INFO: renamed from: lV */
    public static final int f4141lV = 1;

    /* JADX INFO: renamed from: lW */
    private static final int f4142lW = 25;

    /* JADX INFO: renamed from: lX */
    private static final int f4143lX = 60;

    /* JADX INFO: renamed from: fa */
    static final /* synthetic */ boolean f4144fa;

    static {
        f4144fa = !C0777nw.class.desiredAssertionStatus();
    }

    public C0777nw(EntityType<? extends C0774nt> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.AbstractC0770np
    /* JADX INFO: renamed from: av */
    protected float mo3464av() {
        return 2.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0770np
    /* JADX INFO: renamed from: aJ */
    protected int mo3470aJ() {
        return 60;
    }

    @Override // com.boehmod.blockfront.AbstractC0770np
    /* JADX INFO: renamed from: a */
    protected void mo3465a(Entity entity) {
        if (entity instanceof C0772nr) {
            C0772nr c0772nr = (C0772nr) entity;
            if (!c0772nr.m2986aC() || c0772nr.f4118eX) {
                return;
            }
            c0772nr.m3473cd();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0770np
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: bY */
    protected void mo3466bY() {
        Minecraft minecraft = Minecraft.getInstance();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f4144fa && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (minecraft.level != null) {
            C0470iG.m2124a(minecraft, c0622lM2667b, minecraft.level, (ParticleOptions) C1232wZ.f7322nX.get(), position().add(0.0d, 0.5d, 0.0d), 0.0f, 2.0f, 1, 0.075f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0770np
    /* JADX INFO: renamed from: g */
    protected SoundEvent mo3467g() {
        return (SoundEvent) C1280xc.f7789tM.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0770np
    /* JADX INFO: renamed from: cc */
    protected void mo3472cc() {
        super.mo3472cc();
        playSound((SoundEvent) C1280xc.f7790tN.get(), 1.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0770np
    /* JADX INFO: renamed from: bZ */
    protected void mo3468bZ() {
    }

    @Override // com.boehmod.blockfront.AbstractC0770np
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: ca */
    protected void mo3469ca() {
        Level level = level();
        Vec3 vec3Position = position();
        Minecraft minecraft = Minecraft.getInstance();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f4144fa && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ClientLevel clientLevel = minecraft.level;
        if (clientLevel == null) {
            return;
        }
        double dMax = Math.max(1.1f, mo3464av() * this.f4120iY);
        level.addParticle(ParticleTypes.FLASH, true, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
        for (int i = 0; i < 25; i++) {
            double dNextDouble = ThreadLocalRandom.current().nextDouble(1.0d, dMax);
            double dNextDouble2 = ((Math.random() < 0.5d ? dNextDouble : -dNextDouble) + this.random.nextDouble()) / 5.0d;
            double dNextDouble3 = this.random.nextDouble() * 3.141592653589793d;
            double dCos = Math.cos(dNextDouble3) * dNextDouble2;
            double dSin = Math.sin(dNextDouble3) * dNextDouble2;
            C0470iG.m2126a(minecraft, c0622lM2667b, clientLevel, (SimpleParticleType) C1232wZ.f7323nY.get(), vec3Position.x + (dCos * 0.1d), vec3Position.y + 0.1d, vec3Position.z + (dSin * 0.1d), dCos, 0.0d, dSin);
        }
    }

    @Override // com.boehmod.blockfront.C0774nt
    /* JADX INFO: renamed from: bS */
    public void mo3448bS() {
        if (!this.f4118eX && !this.f3612ew) {
            level().addParticle(ParticleTypes.CLOUD, true, getX(), getY() + ((double) getEyeHeight()), getZ(), 0.0d, 0.0d, 0.0d);
        }
    }
}
