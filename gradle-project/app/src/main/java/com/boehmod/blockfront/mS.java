package com.boehmod.blockfront;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.ChatFormatting;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mS.class */
public class mS extends mQ implements RangedAttackMob {
    public mS(EntityType<? extends mS> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder a() {
        return mQ.a();
    }

    @Override // com.boehmod.blockfront.mQ
    public String G() {
        return "spitter";
    }

    @Override // com.boehmod.blockfront.mQ
    public int aB() {
        return 4;
    }

    @Override // com.boehmod.blockfront.mQ
    public void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, float f) {
        super.a(cVar, f);
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, Math.min(f, 0.6f), 50, 10.0f));
    }

    @Override // com.boehmod.blockfront.mQ
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
    }

    public void performRangedAttack(@NotNull LivingEntity livingEntity, float f) {
        if (hasLineOfSight(livingEntity)) {
            bO();
            Level level = level();
            C0360ni c0360niCreate = ((EntityType) wX.kT.get()).create(level);
            if (c0360niCreate != null) {
                c0360niCreate.teleportTo(getX(), getEyeY(), getZ());
                double eyeY = livingEntity.getEyeY() - 1.100000023841858d;
                double x = livingEntity.getX() - getX();
                double y = eyeY - c0360niCreate.getY();
                double z = livingEntity.getZ() - getZ();
                c0360niCreate.shoot(x, y + ((double) (Mth.sqrt((float) ((x * x) + (z * z))) * 0.2f)), z, 0.8f, 1.0f);
                level.addFreshEntity(c0360niCreate);
                playSound((SoundEvent) C0624xc.sJ.get(), 1.5f, 0.8f + (0.05f * ThreadLocalRandom.current().nextInt(4)));
            }
        }
    }

    @Override // com.boehmod.blockfront.mQ
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.mQ
    @NotNull
    public String getScoreboardName() {
        return String.valueOf(ChatFormatting.RED) + "Infected Spitter";
    }
}
