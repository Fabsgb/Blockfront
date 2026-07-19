package com.boehmod.blockfront;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/* JADX INFO: renamed from: com.boehmod.blockfront.nu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nu.class */
public class C0372nu extends C0371nt {
    private static final int lT = 20;
    private static final int lU = 6;

    public C0372nu(EntityType<? extends C0372nu> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.C0371nt, com.boehmod.blockfront.mA
    public void tick() {
        super.tick();
        Level level = level();
        if (level.isClientSide) {
            if (Math.random() < 0.4000000059604645d) {
                Vec3 vec3Position = position();
                level.addParticle(ParticleTypes.CLOUD, true, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
                return;
            }
            return;
        }
        if (at() == 20) {
            Vec3 vec3Position2 = position();
            playSound((SoundEvent) C0624xc.tS.get(), 4.0f, 1.0f);
            for (LivingEntity livingEntity : level.getEntitiesOfClass(LivingEntity.class, getBoundingBox().inflate(6.0d))) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, -3));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 5));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 40));
            }
            level.addParticle(ParticleTypes.FLASH, vec3Position2.x, vec3Position2.y, vec3Position2.z, 0.0d, 0.0d, 0.0d);
        }
    }

    @Override // com.boehmod.blockfront.C0371nt, com.boehmod.blockfront.mA
    protected float at() {
        return 6.5f;
    }
}
