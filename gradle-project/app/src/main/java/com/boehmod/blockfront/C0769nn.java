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

/* JADX INFO: renamed from: com.boehmod.blockfront.nn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nn.class */
public class C0769nn extends C0768nm {
    public C0769nn(EntityType<C0769nn> entityType, Level level) {
        super(entityType, level);
    }

    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3637a() {
        return Mob.createMobAttributes().add(Attributes.FOLLOW_RANGE, 128.0d).add(Attributes.ATTACK_DAMAGE, 6.0d).add(Attributes.MOVEMENT_SPEED, 0.6d).add(Attributes.MAX_HEALTH, 100.0d);
    }

    @Override // com.boehmod.blockfront.C0768nm, com.boehmod.blockfront.C0698mV
    public void baseTick() {
        super.baseTick();
        if (!level().isClientSide && isAlive() && Math.random() < 0.05d) {
            playAmbientSound();
        }
    }

    @Override // com.boehmod.blockfront.C0768nm
    protected SoundEvent getAmbientSound() {
        return (SoundEvent) C1312xz.f8143sI.get();
    }

    @Override // com.boehmod.blockfront.C0768nm
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.C0768nm
    @NotNull
    public String getScoreboardName() {
        return String.valueOf(ChatFormatting.RED) + "Infected Hound";
    }
}
