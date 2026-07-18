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

/* JADX INFO: renamed from: com.boehmod.blockfront.mU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mU.class */
public class C0696mU extends C0727mz {
    public C0696mU(EntityType<? extends C0696mU> entityType, Level level) {
        super(entityType, level);
    }

    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3136a() {
        return Mob.createMobAttributes().add(Attributes.FOLLOW_RANGE, 32.0d).add(Attributes.MOVEMENT_SPEED, 0.7d).add(Attributes.MAX_HEALTH, 40.0d);
    }

    public void tick() {
        super.tick();
        ItemStack mainHandItem = getMainHandItem();
        if (mainHandItem.isEmpty() || mainHandItem.getItem() != C1231wY.f7210lT.get()) {
            setItemInHand(InteractionHand.MAIN_HAND, new ItemStack((ItemLike) C1231wY.f7210lT.get()));
        }
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0f));
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent) C1280xc.f7719su.get();
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
