package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nl.class */
public class C0363nl extends ThrowableProjectile implements InterfaceC0347mw {
    protected float iW;
    protected int lN;
    protected boolean eU;
    protected boolean eV;
    protected Player a;
    private ItemStack c;

    public C0363nl(EntityType<C0363nl> entityType, Level level) {
        super(entityType, level);
        this.iW = 0.6f;
        this.lN = 0;
        this.eU = true;
        this.eV = false;
        this.c = null;
    }

    public void tick() {
        super.tick();
        Level level = level();
        Vec3 vec3Position = position();
        if (this.eV) {
            setDeltaMovement(0.0d, 0.0d, 0.0d);
        }
        if (isInWater()) {
            level.addParticle(ParticleTypes.LARGE_SMOKE, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
            if (level.isClientSide()) {
                level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0f, 1.0f, false);
            }
            discard();
            return;
        }
        if (this.tickCount > 80) {
            discard();
            return;
        }
        level.addParticle(ParticleTypes.LARGE_SMOKE, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
        level.addParticle(ParticleTypes.FLAME, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
        level.addParticle(ParticleTypes.SMALL_FLAME, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
        if (!this.eV && Math.random() < 0.10000000149011612d) {
            level.addParticle((ParticleOptions) wZ.nC.get(), vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
        }
        if (this.eU && this.tickCount > 5) {
            if (level.isClientSide()) {
                if (Math.random() < 0.05000000074505806d) {
                    level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, Math.random() < 0.5d ? SoundEvents.FIRE_AMBIENT : (SoundEvent) C0624xc.sP.get(), SoundSource.PLAYERS, 1.5f, (float) (1.0d + (0.20000000298023224d * Math.random())), false);
                }
                if (Math.random() < 0.25d) {
                    level.addParticle(ParticleTypes.LAVA, true, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
                    return;
                }
                return;
            }
            AABB aabbInflate = getBoundingBox().inflate(0.75d, 0.75d, 0.75d);
            for (C0363nl c0363nl : level.getEntitiesOfClass(C0363nl.class, aabbInflate)) {
                if (Math.random() < 0.75d && !c0363nl.eU) {
                    c0363nl.bU();
                }
            }
            for (C0371nt c0371nt : level.getEntitiesOfClass(C0371nt.class, aabbInflate)) {
                if (!c0371nt.aC()) {
                    c0371nt.bu();
                }
            }
            List<LivingEntity> entitiesOfClass = level.getEntitiesOfClass(LivingEntity.class, aabbInflate.inflate(2.0d, 2.0d, 2.0d));
            C0326mb c0326mb = new C0326mb(level.damageSources().inFire().typeHolder(), this.a, this.c != null ? this.c : new ItemStack((ItemLike) wY.W.get()));
            for (LivingEntity livingEntity : entitiesOfClass) {
                if (Math.random() < 0.20000000298023224d) {
                    livingEntity.hurt(c0326mb, 4.0f);
                }
            }
        }
    }

    protected void onHit(@NotNull HitResult hitResult) {
        Vec3 vec3Scale;
        Level level = level();
        this.iW *= 0.8f;
        if (hitResult instanceof BlockHitResult) {
            BlockHitResult blockHitResult = (BlockHitResult) hitResult;
            if (hitResult.getType().equals(HitResult.Type.BLOCK)) {
                Vec3 deltaMovement = getDeltaMovement();
                if (this.lN >= 3) {
                    vec3Scale = deltaMovement.scale(0.25d);
                } else {
                    vec3Scale = deltaMovement.scale(0.5d);
                }
                double d = vec3Scale.x;
                double d2 = vec3Scale.y;
                double d3 = vec3Scale.z;
                Vec3 vec3Position = position();
                level.addParticle(ParticleTypes.LAVA, vec3Position.x, vec3Position.y, vec3Position.z, 0.0d, 0.0d, 0.0d);
                switch (AnonymousClass1.m[blockHitResult.getDirection().ordinal()]) {
                    case 1:
                        setDeltaMovement(vec3Scale.x, ((double) (-this.iW)) * d2, vec3Scale.z);
                        break;
                    case 2:
                        setDeltaMovement(vec3Scale.x, ((double) (-this.iW)) * d2, vec3Scale.z);
                        break;
                    case 3:
                        setDeltaMovement(vec3Scale.x, vec3Scale.y, ((double) (-this.iW)) * d3);
                        break;
                    case 4:
                        setDeltaMovement(((double) (-this.iW)) * d, vec3Scale.y, vec3Scale.z);
                        break;
                    case 5:
                        setDeltaMovement(vec3Scale.x, vec3Scale.y, ((double) (-this.iW)) * d3);
                        break;
                    case 6:
                        setDeltaMovement(((double) (-this.iW)) * d, vec3Scale.y, vec3Scale.z);
                        break;
                }
                bV();
            }
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.nl$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nl$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] m = new int[Direction.values().length];

        static {
            try {
                m[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                m[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                m[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                m[Direction.EAST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                m[Direction.SOUTH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                m[Direction.WEST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.InterfaceC0347mw
    public void a(@NotNull Player player, float f, @NotNull ItemStack itemStack, float f2, float f3) {
        this.a = player;
        this.c = itemStack;
        double d = f / 2.5f;
        a(player.position().add(((double) (-Mth.sin((player.getYRot() + 15.0f) * 0.017453292f))) / 2.0d, player.getEyeHeight(), ((double) Mth.cos((player.getYRot() + 15.0f) * 0.017453292f)) / 2.0d), player.getYRot() + (f2 / 5.0f), player.getXRot() + (f3 / 5.0f), d, d);
    }

    @Override // com.boehmod.blockfront.InterfaceC0347mw
    public void a(@NotNull Vec3 vec3, float f, @NotNull ItemStack itemStack, float f2, float f3) {
    }

    public void bU() {
        this.eU = true;
    }

    protected void bV() {
        if (Math.random() < 0.20000000298023224d) {
            this.eV = true;
        }
    }

    protected void a(@NotNull Vec3 vec3, float f, float f2, double d, double d2) {
        float f3 = f * 0.017453292f;
        float f4 = f2 * 0.017453292f;
        setRot(f, 0.0f);
        float f5 = -Mth.sin(f3);
        float fCos = Mth.cos(f3);
        float fCos2 = Mth.cos(f4);
        float fSin = Mth.sin(f4);
        if (d2 == 0.0d && d > 0.0d) {
            d2 = d;
        }
        Vec3 deltaMovement = getDeltaMovement();
        setDeltaMovement(deltaMovement.x + (d * ((double) f5) * ((double) fCos2)), deltaMovement.y + ((-d2) * ((double) fSin)), deltaMovement.z + (d * ((double) fCos) * ((double) fCos2)));
        setPos(vec3.x + (((double) f5) * 0.8d), vec3.y + ((((double) (-((int) f2))) * 2.0d) / 90.0d), vec3.z + (((double) fCos) * 0.8d));
        Vec3 vec3Position = position();
        this.xOld = vec3Position.x;
        this.yOld = vec3Position.y;
        this.zOld = vec3Position.z;
    }
}
