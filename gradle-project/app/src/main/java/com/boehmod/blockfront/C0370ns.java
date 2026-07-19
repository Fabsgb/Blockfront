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

/* JADX INFO: renamed from: com.boehmod.blockfront.ns, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ns.class */
public final class C0370ns extends C0371nt {
    public static final int lS = 20;
    private static final double at = 40.0d;
    private static final float iZ = 11.0f;
    private static final float ja = 0.6f;
    private static final double au = 10.0d;
    private static final float jb = 4.0f;
    private static final float jc = 60.0f;

    public C0370ns(EntityType<? extends C0370ns> entityType, Level level) {
        super(entityType, level);
    }

    private static boolean a(Entity entity, LivingEntity livingEntity) {
        float yRot = livingEntity.getYRot();
        float xRot = livingEntity.getXRot();
        a(livingEntity, entity, 360.0f, 360.0f);
        float yRot2 = livingEntity.getYRot();
        float xRot2 = livingEntity.getXRot();
        livingEntity.setYRot(yRot);
        livingEntity.setXRot(xRot);
        float yRot3 = livingEntity.getYRot() - jc;
        float yRot4 = livingEntity.getYRot() + jc;
        float xRot3 = livingEntity.getXRot() - jc;
        float xRot4 = livingEntity.getXRot() + jc;
        return ((yRot2 > yRot4 ? 1 : (yRot2 == yRot4 ? 0 : -1)) < 0 && (yRot2 > yRot3 ? 1 : (yRot2 == yRot3 ? 0 : -1)) > 0) && (((xRot3 > (-180.0f) ? 1 : (xRot3 == (-180.0f) ? 0 : -1)) <= 0 && ((xRot2 > (xRot3 + 360.0f) ? 1 : (xRot2 == (xRot3 + 360.0f) ? 0 : -1)) >= 0 || (xRot2 > xRot4 ? 1 : (xRot2 == xRot4 ? 0 : -1)) <= 0)) || (((xRot4 > 180.0f ? 1 : (xRot4 == 180.0f ? 0 : -1)) > 0 && ((xRot2 > (xRot4 - 360.0f) ? 1 : (xRot2 == (xRot4 - 360.0f) ? 0 : -1)) <= 0 || (xRot2 > xRot3 ? 1 : (xRot2 == xRot3 ? 0 : -1)) >= 0)) || ((xRot4 > 180.0f ? 1 : (xRot4 == 180.0f ? 0 : -1)) < 0 && (xRot3 > (-180.0f) ? 1 : (xRot3 == (-180.0f) ? 0 : -1)) >= 0 && (xRot2 > xRot4 ? 1 : (xRot2 == xRot4 ? 0 : -1)) <= 0 && (xRot2 > xRot3 ? 1 : (xRot2 == xRot3 ? 0 : -1)) >= 0))) && livingEntity.hasLineOfSight(entity);
    }

    public static void a(LivingEntity livingEntity, Entity entity, float f, float f2) {
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
        livingEntity.setXRot(c(livingEntity.getXRot(), (float) (-((Math.atan2(eyeHeight, dSqrt) * 180.0d) / 3.141592653589793d)), f2));
        livingEntity.setYRot(c(livingEntity.getYRot(), fAtan2, f));
    }

    private static float c(float f, float f2, float f3) {
        float fWrapDegrees = Mth.wrapDegrees(f2 - f);
        if (fWrapDegrees > f3) {
            fWrapDegrees = f3;
        }
        if (fWrapDegrees < (-f3)) {
            fWrapDegrees = -f3;
        }
        return f + fWrapDegrees;
    }

    @Override // com.boehmod.blockfront.C0371nt, com.boehmod.blockfront.mA
    public float ar() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.mA
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.mA
    public void bu() {
        float f;
        Level level = level();
        if (!this.ew) {
            Vec3 vec3Position = position();
            if (level.isClientSide()) {
                level.addParticle(ParticleTypes.FLASH, true, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
            }
            for (ServerPlayer serverPlayer : level.getEntitiesOfClass(Player.class, getBoundingBox().inflate(at))) {
                if (serverPlayer.hasLineOfSight(this)) {
                    float fDistanceTo = distanceTo(serverPlayer);
                    if (fDistanceTo < at) {
                        if (a((Entity) this, (LivingEntity) serverPlayer)) {
                            f = (40.0f - fDistanceTo) * 0.6f;
                            if (f > iZ) {
                                f = 11.0f;
                            }
                        } else {
                            f = ((double) fDistanceTo) < au ? 4.0f : 0.0f;
                        }
                        if (!level.isClientSide() && (serverPlayer instanceof ServerPlayer)) {
                            ServerPlayer serverPlayer2 = serverPlayer;
                            if (f > 0.0f) {
                                C0582vo.a(new C0619wy(f), serverPlayer2);
                            }
                        }
                    }
                }
            }
            ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
            playSound((SoundEvent) C0624xc.tK.get(), 3.0f, (1.0f + ((threadLocalRandomCurrent.nextFloat() - threadLocalRandomCurrent.nextFloat()) * 0.2f)) * 0.7f);
            this.ew = true;
        }
        discard();
    }
}
