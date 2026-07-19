package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mR.class */
public class mR extends mQ {
    public mR(EntityType<mR> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder a() {
        return Mob.createMobAttributes().add(Attributes.FOLLOW_RANGE, 128.0d).add(Attributes.ATTACK_DAMAGE, 6.0d).add(Attributes.MOVEMENT_SPEED, 0.6d).add(Attributes.MAX_HEALTH, 100.0d);
    }

    @Override // com.boehmod.blockfront.mQ, com.boehmod.blockfront.C0350mz
    public void baseTick() {
        super.baseTick();
        if (!level().isClientSide && isAlive() && Math.random() < 0.05d) {
            playAmbientSound();
        }
    }

    @Override // com.boehmod.blockfront.mQ
    protected SoundEvent getAmbientSound() {
        return (SoundEvent) C0624xc.sH.get();
    }

    @Override // com.boehmod.blockfront.mQ
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.mQ
    @NotNull
    public String getScoreboardName() {
        return String.valueOf(ChatFormatting.RED) + "Infected Hound";
    }
}
