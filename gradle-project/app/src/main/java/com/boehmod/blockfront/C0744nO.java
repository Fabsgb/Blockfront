package com.boehmod.blockfront;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nO.class */
public final class C0744nO extends C0745nP {

    /* JADX INFO: renamed from: nQ */
    public static final int f4081nQ = 20;

    /* JADX INFO: renamed from: aG */
    private static final double f4082aG = 40.0d;

    /* JADX INFO: renamed from: jS */
    private static final float f4083jS = 11.0f;

    /* JADX INFO: renamed from: jT */
    private static final float f4084jT = 0.6f;

    /* JADX INFO: renamed from: aH */
    private static final double f4085aH = 10.0d;

    /* JADX INFO: renamed from: jU */
    private static final float f4086jU = 4.0f;

    /* JADX INFO: renamed from: jV */
    private static final float f4087jV = 60.0f;

    public C0744nO(EntityType<? extends C0744nO> entityType, Level level) {
        super(entityType, level);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3399a(Entity entity, LivingEntity livingEntity) {
        float yRot = livingEntity.getYRot();
        float xRot = livingEntity.getXRot();
        m3400a(livingEntity, entity, 360.0f, 360.0f);
        float yRot2 = livingEntity.getYRot();
        float xRot2 = livingEntity.getXRot();
        livingEntity.setYRot(yRot);
        livingEntity.setXRot(xRot);
        float yRot3 = livingEntity.getYRot() - f4087jV;
        float yRot4 = livingEntity.getYRot() + f4087jV;
        float xRot3 = livingEntity.getXRot() - f4087jV;
        float xRot4 = livingEntity.getXRot() + f4087jV;
        return ((yRot2 > yRot4 ? 1 : (yRot2 == yRot4 ? 0 : -1)) < 0 && (yRot2 > yRot3 ? 1 : (yRot2 == yRot3 ? 0 : -1)) > 0) && (((xRot3 > (-180.0f) ? 1 : (xRot3 == (-180.0f) ? 0 : -1)) <= 0 && ((xRot2 > (xRot3 + 360.0f) ? 1 : (xRot2 == (xRot3 + 360.0f) ? 0 : -1)) >= 0 || (xRot2 > xRot4 ? 1 : (xRot2 == xRot4 ? 0 : -1)) <= 0)) || (((xRot4 > 180.0f ? 1 : (xRot4 == 180.0f ? 0 : -1)) > 0 && ((xRot2 > (xRot4 - 360.0f) ? 1 : (xRot2 == (xRot4 - 360.0f) ? 0 : -1)) <= 0 || (xRot2 > xRot3 ? 1 : (xRot2 == xRot3 ? 0 : -1)) >= 0)) || ((xRot4 > 180.0f ? 1 : (xRot4 == 180.0f ? 0 : -1)) < 0 && (xRot3 > (-180.0f) ? 1 : (xRot3 == (-180.0f) ? 0 : -1)) >= 0 && (xRot2 > xRot4 ? 1 : (xRot2 == xRot4 ? 0 : -1)) <= 0 && (xRot2 > xRot3 ? 1 : (xRot2 == xRot3 ? 0 : -1)) >= 0))) && livingEntity.hasLineOfSight(entity);
    }

    /* JADX INFO: renamed from: a */
    public static void m3400a(LivingEntity livingEntity, Entity entity, float f, float f2) {
        double eyeHeight;
        Vec3 vec3Position = livingEntity.position();
        Vec3 vec3Position2 = entity.position();
        double d = vec3Position2.x - vec3Position.x;
        double d2 = vec3Position2.z - vec3Position.z;
        if (entity instanceof LivingEntity) {
            eyeHeight = (vec3Position2.y + ((double) ((LivingEntity) entity).getEyeHeight())) - (vec3Position.y + ((double) livingEntity.getEyeHeight()));
        } else {
            eyeHeight = ((entity.getBoundingBox().minY + entity.getBoundingBox().maxY) / 2.0d) - (vec3Position.y + ((double) livingEntity.getEyeHeight()));
        }
        double dSqrt = Mth.sqrt((float) ((d * d) + (d2 * d2)));
        float fAtan2 = ((float) ((Math.atan2(d2, d) * 180.0d) / 3.141592653589793d)) - 90.0f;
        livingEntity.setXRot(m3401c(livingEntity.getXRot(), (float) (-((Math.atan2(eyeHeight, dSqrt) * 180.0d) / 3.141592653589793d)), f2));
        livingEntity.setYRot(m3401c(livingEntity.getYRot(), fAtan2, f));
    }

    /* JADX INFO: renamed from: c */
    private static float m3401c(float f, float f2, float f3) {
        float fWrapDegrees = Mth.wrapDegrees(f2 - f);
        if (fWrapDegrees > f3) {
            fWrapDegrees = f3;
        }
        if (fWrapDegrees < (-f3)) {
            fWrapDegrees = -f3;
        }
        return f + fWrapDegrees;
    }

    @Override // com.boehmod.blockfront.C0745nP, com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: ax */
    public float mo3139ax() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: bF */
    public void mo3132bF() {
        float f;
        Level level = level();
        if (!this.f3862eQ) {
            Vec3 vec3Position = position();
            if (level.isClientSide()) {
                level.addParticle(ParticleTypes.FLASH, true, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
            }
            for (ServerPlayer serverPlayer : level.getEntitiesOfClass(Player.class, getBoundingBox().inflate(f4082aG))) {
                if (serverPlayer.hasLineOfSight(this)) {
                    float fDistanceTo = distanceTo(serverPlayer);
                    if (fDistanceTo < f4082aG) {
                        if (m3399a((Entity) this, (LivingEntity) serverPlayer)) {
                            f = (40.0f - fDistanceTo) * 0.6f;
                            if (f > f4083jS) {
                                f = 11.0f;
                            }
                        } else {
                            f = ((double) fDistanceTo) < f4085aH ? 4.0f : 0.0f;
                        }
                        if (!level.isClientSide() && (serverPlayer instanceof ServerPlayer)) {
                            ServerPlayer serverPlayer2 = serverPlayer;
                            if (f > 0.0f) {
                                C1169vO.m6643a(new C1230wW(f), serverPlayer2);
                            }
                        }
                    }
                }
            }
            ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
            playSound((SoundEvent) C1312xz.f8198tL.get(), 3.0f, (1.0f + ((threadLocalRandomCurrent.nextFloat() - threadLocalRandomCurrent.nextFloat()) * 0.2f)) * 0.7f);
            this.f3862eQ = true;
        }
        discard();
    }
}
