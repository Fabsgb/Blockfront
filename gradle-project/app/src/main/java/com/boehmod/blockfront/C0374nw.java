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

/* JADX INFO: renamed from: com.boehmod.blockfront.nw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nw.class */
public class C0374nw extends AbstractC0367np {
    public static final int lV = 1;
    private static final int lW = 25;
    private static final int lX = 60;
    static final /* synthetic */ boolean fa;

    static {
        fa = !C0374nw.class.desiredAssertionStatus();
    }

    public C0374nw(EntityType<? extends C0371nt> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.AbstractC0367np
    protected float av() {
        return 2.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0367np
    protected int aJ() {
        return 60;
    }

    @Override // com.boehmod.blockfront.AbstractC0367np
    protected void a(Entity entity) {
        if (entity instanceof C0369nr) {
            C0369nr c0369nr = (C0369nr) entity;
            if (!c0369nr.aC() || c0369nr.eX) {
                return;
            }
            c0369nr.cd();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0367np
    @OnlyIn(Dist.CLIENT)
    protected void bY() {
        Minecraft minecraft = Minecraft.getInstance();
        C0297l c0297lB = C0297l.b();
        if (!fa && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (minecraft.level != null) {
            iG.a(minecraft, c0297lB, minecraft.level, (ParticleOptions) wZ.nX.get(), position().add(0.0d, 0.5d, 0.0d), 0.0f, 2.0f, 1, 0.075f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0367np
    protected SoundEvent g() {
        return (SoundEvent) C0624xc.tM.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0367np
    protected void cc() {
        super.cc();
        playSound((SoundEvent) C0624xc.tN.get(), 1.0f, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0367np
    protected void bZ() {
    }

    @Override // com.boehmod.blockfront.AbstractC0367np
    @OnlyIn(Dist.CLIENT)
    protected void ca() {
        Level level = level();
        Vec3 vec3Position = position();
        Minecraft minecraft = Minecraft.getInstance();
        C0297l c0297lB = C0297l.b();
        if (!fa && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        ClientLevel clientLevel = minecraft.level;
        if (clientLevel == null) {
            return;
        }
        double dMax = Math.max(1.1f, av() * this.iY);
        level.addParticle(ParticleTypes.FLASH, true, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
        for (int i = 0; i < 25; i++) {
            double dNextDouble = ThreadLocalRandom.current().nextDouble(1.0d, dMax);
            double dNextDouble2 = ((Math.random() < 0.5d ? dNextDouble : -dNextDouble) + this.random.nextDouble()) / 5.0d;
            double dNextDouble3 = this.random.nextDouble() * 3.141592653589793d;
            double dCos = Math.cos(dNextDouble3) * dNextDouble2;
            double dSin = Math.sin(dNextDouble3) * dNextDouble2;
            iG.a(minecraft, c0297lB, clientLevel, (SimpleParticleType) wZ.nY.get(), vec3Position.x + (dCos * 0.1d), vec3Position.y + 0.1d, vec3Position.z + (dSin * 0.1d), dCos, 0.0d, dSin);
        }
    }

    @Override // com.boehmod.blockfront.C0371nt
    public void bS() {
        if (!this.eX && !this.ew) {
            level().addParticle(ParticleTypes.CLOUD, true, getX(), getY() + ((double) getEyeHeight()), getZ(), 0.0d, 0.0d, 0.0d);
        }
    }
}
