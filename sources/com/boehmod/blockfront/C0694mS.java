package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.mS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mS.class */
public class C0694mS extends C0692mQ implements RangedAttackMob {
    public C0694mS(EntityType<? extends C0694mS> entityType, Level level) {
        super(entityType, level);
    }

    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3131a() {
        return C0692mQ.m3115a();
    }

    @Override // com.boehmod.blockfront.C0692mQ
    /* JADX INFO: renamed from: G */
    public String mo3120G() {
        return "spitter";
    }

    @Override // com.boehmod.blockfront.C0692mQ
    /* JADX INFO: renamed from: aB */
    public int mo3121aB() {
        return 4;
    }

    @Override // com.boehmod.blockfront.C0692mQ
    /* JADX INFO: renamed from: a */
    public void mo3119a(@NotNull AbstractC0183c<?> abstractC0183c, float f) {
        super.mo3119a(abstractC0183c, f);
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, Math.min(f, 0.6f), 50, 10.0f));
    }

    @Override // com.boehmod.blockfront.C0692mQ
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
    }

    public void performRangedAttack(@NotNull LivingEntity livingEntity, float f) {
        if (hasLineOfSight(livingEntity)) {
            m3116bO();
            Level level = level();
            C0763ni c0763niCreate = ((EntityType) C1230wX.f7050kT.get()).create(level);
            if (c0763niCreate != null) {
                c0763niCreate.teleportTo(getX(), getEyeY(), getZ());
                double eyeY = livingEntity.getEyeY() - 1.100000023841858d;
                double x = livingEntity.getX() - getX();
                double y = eyeY - c0763niCreate.getY();
                double z = livingEntity.getZ() - getZ();
                c0763niCreate.shoot(x, y + ((double) (Mth.sqrt((float) ((x * x) + (z * z))) * 0.2f)), z, 0.8f, 1.0f);
                level.addFreshEntity(c0763niCreate);
                playSound((SoundEvent) C1280xc.f7734sJ.get(), 1.5f, 0.8f + (0.05f * ThreadLocalRandom.current().nextInt(4)));
            }
        }
    }

    @Override // com.boehmod.blockfront.C0692mQ
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.C0692mQ
    @NotNull
    public String getScoreboardName() {
        return String.valueOf(ChatFormatting.RED) + "Infected Spitter";
    }
}
