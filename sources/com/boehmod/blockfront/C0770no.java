package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.no */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/no.class */
public class C0770no extends C0768nm implements RangedAttackMob {
    public C0770no(EntityType<? extends C0770no> entityType, Level level) {
        super(entityType, level);
    }

    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3638a() {
        return C0768nm.m3622a();
    }

    @Override // com.boehmod.blockfront.C0768nm
    /* JADX INFO: renamed from: N */
    public String mo3627N() {
        return "spitter";
    }

    @Override // com.boehmod.blockfront.C0768nm
    /* JADX INFO: renamed from: aQ */
    public int mo3628aQ() {
        return 4;
    }

    @Override // com.boehmod.blockfront.C0768nm
    /* JADX INFO: renamed from: a */
    public void mo3626a(@NotNull AbstractC0184c<?> abstractC0184c, float f) {
        super.mo3626a(abstractC0184c, f);
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, Math.min(f, 0.6f), 50, 10.0f));
    }

    @Override // com.boehmod.blockfront.C0768nm
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
    }

    public void performRangedAttack(@NotNull LivingEntity livingEntity, float f) {
        if (hasLineOfSight(livingEntity)) {
            m3623bZ();
            Level level = level();
            C0734nE c0734nECreate = ((EntityType) C1307xu.f7615kT.get()).create(level);
            if (c0734nECreate != null) {
                c0734nECreate.teleportTo(getX(), getEyeY(), getZ());
                double eyeY = livingEntity.getEyeY() - 1.100000023841858d;
                double x = livingEntity.getX() - getX();
                double y = eyeY - c0734nECreate.getY();
                double z = livingEntity.getZ() - getZ();
                c0734nECreate.shoot(x, y + ((double) (Mth.sqrt((float) ((x * x) + (z * z))) * 0.2f)), z, 0.8f, 1.0f);
                level.addFreshEntity(c0734nECreate);
                playSound((SoundEvent) C1312xz.f8145sK.get(), 1.5f, 0.8f + (0.05f * ThreadLocalRandom.current().nextInt(4)));
            }
        }
    }

    @Override // com.boehmod.blockfront.C0768nm
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.C0768nm
    @NotNull
    public String getScoreboardName() {
        return String.valueOf(ChatFormatting.RED) + "Infected Spitter";
    }
}
