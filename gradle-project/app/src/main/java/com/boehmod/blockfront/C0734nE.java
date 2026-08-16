package com.boehmod.blockfront;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nE.class */
public class C0734nE extends ThrowableItemProjectile {
    public C0734nE(EntityType<C0734nE> entityType, Level level) {
        super(entityType, level);
    }

    public void baseTick() {
        super.baseTick();
        Level level = level();
        if (Math.random() < 0.5d) {
            level.addParticle((ParticleOptions) C1309xw.f7856ns.get(), getX(), getEyeY(), getZ(), 0.0d, 0.0d, 0.0d);
        }
    }

    protected void onHitEntity(@NotNull EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        Level level = level();
        level.playSound((Player) null, getX(), getY(), getZ(), SoundEvents.LAVA_EXTINGUISH, SoundSource.AMBIENT, 1.0f, 1.0f);
        entityHitResult.getEntity().hurt(level.damageSources().thrown(this, (Entity) null), 3.0f);
    }

    protected void onHit(@NotNull HitResult hitResult) {
        super.onHit(hitResult);
        Level level = level();
        if (!level.isClientSide()) {
            level.broadcastEntityEvent(this, (byte) 3);
            discard();
            level.playSound((Player) null, getX(), getY(), getZ(), (SoundEvent) C1312xz.f8146sL.get(), SoundSource.AMBIENT, 1.0f, 1.0f);
        }
    }

    @NotNull
    public Item getDefaultItem() {
        return (Item) C1308xv.f7689u.get();
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte b) {
        Level level = level();
        if (b == 3) {
            for (int i = 0; i < 8; i++) {
                level.addParticle((ParticleOptions) C1309xw.f7857nt.get(), getX(), getY(), getZ(), 0.0d, 0.0d, 0.0d);
            }
        }
    }
}
