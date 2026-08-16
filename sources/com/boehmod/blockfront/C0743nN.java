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

/* JADX INFO: renamed from: com.boehmod.blockfront.nN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nN.class */
public class C0743nN extends AbstractC0741nL {

    /* JADX INFO: renamed from: nO */
    private static final int f4079nO = 10;

    /* JADX INFO: renamed from: nP */
    private static final int f4080nP = 40;

    public C0743nN(EntityType<? extends C0745nP> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.AbstractC0741nL
    /* JADX INFO: renamed from: aB */
    protected float mo3387aB() {
        return 2.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.AbstractC0741nL
    /* JADX INFO: renamed from: a */
    protected void mo3388a(Entity entity) {
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).hurt(new C0726mx(level().damageSources().inFire().typeHolder(), this.f3861a, getItem()), 3.0f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0741nL
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: cj */
    protected void mo3389cj() {
        Level level = level();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Vec3 vec3Position = position();
        for (int i = 0; i < 10; i++) {
            float fMo3387aB = mo3387aB() * this.f4075jR * threadLocalRandomCurrent.nextFloat();
            float fNextFloat = (Math.random() < 0.5d ? fMo3387aB : -fMo3387aB) + threadLocalRandomCurrent.nextFloat();
            float fNextFloat2 = (float) (((double) threadLocalRandomCurrent.nextFloat()) * 3.141592653589793d);
            float fCos = (float) (Math.cos(fNextFloat2) * ((double) fNextFloat));
            float fSin = (float) (Math.sin(fNextFloat2) * ((double) fNextFloat));
            level.addParticle(ParticleTypes.FLAME, true, vec3Position.x + ((double) fCos), vec3Position.y + 0.1d, vec3Position.z + ((double) fSin), 0.0d, Math.random() < 0.05d ? 0.05d : 0.0d, 0.0d);
            if (Math.random() < 0.1d) {
                level.addParticle(ParticleTypes.LAVA, true, vec3Position.x + ((double) fCos), vec3Position.y + 0.1d, vec3Position.z + ((double) fSin), 0.0d, Math.random() < 0.05d ? 0.05d : 0.0d, 0.0d);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0741nL
    /* JADX INFO: renamed from: g */
    protected SoundEvent mo3390g() {
        return (SoundEvent) C1312xz.f8202tP.get();
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
        if (level.isClientSide()) {
            Vec3 vec3Position = position();
            double d = (14.0d * ((double) this.f4075jR)) + 0.1d;
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

    @Override // com.boehmod.blockfront.C0745nP
    /* JADX INFO: renamed from: cd */
    public void mo3371cd() {
        if (!this.f4073fr) {
            level().addParticle(ParticleTypes.FLAME, true, getX(), getY() + ((double) getEyeHeight()), getZ(), 0.0d, 0.0d, 0.0d);
        }
    }
}
