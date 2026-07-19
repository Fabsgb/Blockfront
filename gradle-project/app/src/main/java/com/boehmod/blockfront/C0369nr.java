package com.boehmod.blockfront;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nr.class */
public class C0369nr extends AbstractC0367np {
    private static final int lQ = 10;
    private static final int lR = 40;

    public C0369nr(EntityType<? extends C0371nt> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.AbstractC0367np
    protected float av() {
        return 2.0f;
    }

    @Override // com.boehmod.blockfront.mA
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.AbstractC0367np
    protected void a(Entity entity) {
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).hurt(new C0326mb(level().damageSources().inFire().typeHolder(), this.f236a, getItem()), 3.0f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0367np
    @OnlyIn(Dist.CLIENT)
    protected void bY() {
        Level level = level();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Vec3 vec3Position = position();
        for (int i = 0; i < 10; i++) {
            float fAv = av() * this.iY * threadLocalRandomCurrent.nextFloat();
            float fNextFloat = (Math.random() < 0.5d ? fAv : -fAv) + threadLocalRandomCurrent.nextFloat();
            float fNextFloat2 = (float) (((double) threadLocalRandomCurrent.nextFloat()) * 3.141592653589793d);
            float fCos = (float) (Math.cos(fNextFloat2) * ((double) fNextFloat));
            float fSin = (float) (Math.sin(fNextFloat2) * ((double) fNextFloat));
            level.addParticle(ParticleTypes.FLAME, true, vec3Position.x + ((double) fCos), vec3Position.y + 0.1d, vec3Position.z + ((double) fSin), 0.0d, Math.random() < 0.05d ? 0.05d : 0.0d, 0.0d);
            if (Math.random() < 0.1d) {
                level.addParticle(ParticleTypes.LAVA, true, vec3Position.x + ((double) fCos), vec3Position.y + 0.1d, vec3Position.z + ((double) fSin), 0.0d, Math.random() < 0.05d ? 0.05d : 0.0d, 0.0d);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0367np
    protected SoundEvent g() {
        return (SoundEvent) C0624xc.tO.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0367np
    protected void bZ() {
    }

    @Override // com.boehmod.blockfront.AbstractC0367np
    @OnlyIn(Dist.CLIENT)
    protected void ca() {
        Level level = level();
        if (level.isClientSide()) {
            Vec3 vec3Position = position();
            double d = (14.0d * ((double) this.iY)) + 0.1d;
            level.addParticle(ParticleTypes.FLASH, true, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
            for (int i = 0; i < 40; i++) {
                double dNextDouble = ThreadLocalRandom.current().nextDouble(1.0d, d);
                double dNextDouble2 = ((Math.random() < 0.5d ? dNextDouble : -dNextDouble) + this.random.nextDouble()) / 5.0d;
                double dNextDouble3 = this.random.nextDouble() * 3.141592653589793d;
                double dCos = Math.cos(dNextDouble3) * dNextDouble2;
                double dSin = Math.sin(dNextDouble3) * dNextDouble2;
                level.addParticle(ParticleTypes.FLAME, true, vec3Position.x + (dCos * 0.1d), vec3Position.y + 0.1d, vec3Position.z + (dSin * 0.1d), dCos, 0.0d, dSin);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0371nt
    public void bS() {
        if (!this.eX) {
            level().addParticle(ParticleTypes.FLAME, true, getX(), getY() + ((double) getEyeHeight()), getZ(), 0.0d, 0.0d, 0.0d);
        }
    }
}
