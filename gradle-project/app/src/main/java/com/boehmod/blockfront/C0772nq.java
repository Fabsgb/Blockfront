package com.boehmod.blockfront;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nq.class */
public class C0772nq extends C0698mV {
    public C0772nq(EntityType<? extends C0772nq> entityType, Level level) {
        super(entityType, level);
    }

    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3643a() {
        return Mob.createMobAttributes().add(Attributes.FOLLOW_RANGE, 32.0d).add(Attributes.MOVEMENT_SPEED, 0.7d).add(Attributes.MAX_HEALTH, 40.0d);
    }

    public void tick() {
        super.tick();
        ItemStack mainHandItem = getMainHandItem();
        if (mainHandItem.isEmpty() || mainHandItem.getItem() != C1308xv.f7775lT.get()) {
            setItemInHand(InteractionHand.MAIN_HAND, new ItemStack((ItemLike) C1308xv.f7775lT.get()));
        }
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0f));
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent) C1312xz.f8130sv.get();
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
