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

/* JADX INFO: renamed from: com.boehmod.blockfront.ns */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ns.class */
public final class C0773ns extends C0774nt {

    /* JADX INFO: renamed from: lS */
    public static final int f4126lS = 20;

    /* JADX INFO: renamed from: at */
    private static final double f4127at = 40.0d;

    /* JADX INFO: renamed from: iZ */
    private static final float f4128iZ = 11.0f;

    /* JADX INFO: renamed from: ja */
    private static final float f4129ja = 0.6f;

    /* JADX INFO: renamed from: au */
    private static final double f4130au = 10.0d;

    /* JADX INFO: renamed from: jb */
    private static final float f4131jb = 4.0f;

    /* JADX INFO: renamed from: jc */
    private static final float f4132jc = 60.0f;

    public C0773ns(EntityType<? extends C0773ns> entityType, Level level) {
        super(entityType, level);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3476a(Entity entity, LivingEntity livingEntity) {
        float yRot = livingEntity.getYRot();
        float xRot = livingEntity.getXRot();
        m3477a(livingEntity, entity, 360.0f, 360.0f);
        float yRot2 = livingEntity.getYRot();
        float xRot2 = livingEntity.getXRot();
        livingEntity.setYRot(yRot);
        livingEntity.setXRot(xRot);
        float yRot3 = livingEntity.getYRot() - f4132jc;
        float yRot4 = livingEntity.getYRot() + f4132jc;
        float xRot3 = livingEntity.getXRot() - f4132jc;
        float xRot4 = livingEntity.getXRot() + f4132jc;
        return ((yRot2 > yRot4 ? 1 : (yRot2 == yRot4 ? 0 : -1)) < 0 && (yRot2 > yRot3 ? 1 : (yRot2 == yRot3 ? 0 : -1)) > 0) && (((xRot3 > (-180.0f) ? 1 : (xRot3 == (-180.0f) ? 0 : -1)) <= 0 && ((xRot2 > (xRot3 + 360.0f) ? 1 : (xRot2 == (xRot3 + 360.0f) ? 0 : -1)) >= 0 || (xRot2 > xRot4 ? 1 : (xRot2 == xRot4 ? 0 : -1)) <= 0)) || (((xRot4 > 180.0f ? 1 : (xRot4 == 180.0f ? 0 : -1)) > 0 && ((xRot2 > (xRot4 - 360.0f) ? 1 : (xRot2 == (xRot4 - 360.0f) ? 0 : -1)) <= 0 || (xRot2 > xRot3 ? 1 : (xRot2 == xRot3 ? 0 : -1)) >= 0)) || ((xRot4 > 180.0f ? 1 : (xRot4 == 180.0f ? 0 : -1)) < 0 && (xRot3 > (-180.0f) ? 1 : (xRot3 == (-180.0f) ? 0 : -1)) >= 0 && (xRot2 > xRot4 ? 1 : (xRot2 == xRot4 ? 0 : -1)) <= 0 && (xRot2 > xRot3 ? 1 : (xRot2 == xRot3 ? 0 : -1)) >= 0))) && livingEntity.hasLineOfSight(entity);
    }

    /* JADX INFO: renamed from: a */
    public static void m3477a(LivingEntity livingEntity, Entity entity, float f, float f2) {
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
        livingEntity.setXRot(m3478c(livingEntity.getXRot(), (float) (-((Math.atan2(eyeHeight, dSqrt) * 180.0d) / 3.141592653589793d)), f2));
        livingEntity.setYRot(m3478c(livingEntity.getYRot(), fAtan2, f));
    }

    /* JADX INFO: renamed from: c */
    private static float m3478c(float f, float f2, float f3) {
        float fWrapDegrees = Mth.wrapDegrees(f2 - f);
        if (fWrapDegrees > f3) {
            fWrapDegrees = f3;
        }
        if (fWrapDegrees < (-f3)) {
            fWrapDegrees = -f3;
        }
        return f + fWrapDegrees;
    }

    @Override // com.boehmod.blockfront.C0774nt, com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: ar */
    public float mo2988ar() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: bu */
    public void mo2981bu() {
        float f;
        Level level = level();
        if (!this.f3612ew) {
            Vec3 vec3Position = position();
            if (level.isClientSide()) {
                level.addParticle(ParticleTypes.FLASH, true, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
            }
            for (ServerPlayer serverPlayer : level.getEntitiesOfClass(Player.class, getBoundingBox().inflate(f4127at))) {
                if (serverPlayer.hasLineOfSight(this)) {
                    float fDistanceTo = distanceTo(serverPlayer);
                    if (fDistanceTo < f4127at) {
                        if (m3476a((Entity) this, (LivingEntity) serverPlayer)) {
                            f = (40.0f - fDistanceTo) * 0.6f;
                            if (f > f4128iZ) {
                                f = 11.0f;
                            }
                        } else {
                            f = ((double) fDistanceTo) < f4130au ? 4.0f : 0.0f;
                        }
                        if (!level.isClientSide() && (serverPlayer instanceof ServerPlayer)) {
                            ServerPlayer serverPlayer2 = serverPlayer;
                            if (f > 0.0f) {
                                C1194vo.m6648a(new C1257wy(f), serverPlayer2);
                            }
                        }
                    }
                }
            }
            ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
            playSound((SoundEvent) C1280xc.f7787tK.get(), 3.0f, (1.0f + ((threadLocalRandomCurrent.nextFloat() - threadLocalRandomCurrent.nextFloat()) * 0.2f)) * 0.7f);
            this.f3612ew = true;
        }
        discard();
    }
}
