package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mT.class */
public class mT extends mQ {
    private static final EntityDataAccessor<Boolean> u = SynchedEntityData.defineId(mT.class, EntityDataSerializers.BOOLEAN);
    private int ly;

    public mT(EntityType<? extends mT> entityType, Level level) {
        super(entityType, level);
        this.ly = 0;
    }

    public static AttributeSupplier.Builder a() {
        return mQ.a();
    }

    public boolean aL() {
        return ((Boolean) this.entityData.get(u)).booleanValue();
    }

    public void bP() {
        Level level = level();
        this.entityData.set(u, true);
        Vec3 eyePosition = getEyePosition();
        for (int i = 0; i < 5; i++) {
            level.addParticle(ParticleTypes.LAVA, true, eyePosition.x, eyePosition.y, eyePosition.z, 0.0d, 0.0d, 0.0d);
        }
        level.addParticle((ParticleOptions) wZ.nu.get(), true, eyePosition.x, eyePosition.y, eyePosition.z, 0.0d, 0.0d, 0.0d);
        playSound((SoundEvent) C0624xc.oE.get());
        playSound((SoundEvent) C0624xc.oD.get());
    }

    public void bQ() {
        Vec3 eyePosition = getEyePosition();
        if (Math.random() < 0.2d) {
            level().addParticle(ParticleTypes.LAVA, eyePosition.x, eyePosition.y, eyePosition.z, 0.0d, 0.0d, 0.0d);
        }
    }

    public void tick() {
        if (level().isClientSide() && isAlive() && aL()) {
            bQ();
            this.ly++;
        }
        super.tick();
    }

    public boolean hurt(@NotNull DamageSource damageSource, float f) {
        if (super.hurt(damageSource, f)) {
            bP();
            return true;
        }
        return false;
    }

    public boolean doHurtTarget(@NotNull Entity entity) {
        boolean zDoHurtTarget = super.doHurtTarget(entity);
        if (zDoHurtTarget) {
            entity.setRemainingFireTicks(3);
            bP();
        }
        return zDoHurtTarget;
    }

    @Override // com.boehmod.blockfront.C0350mz
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("ignited", aL());
    }

    @Override // com.boehmod.blockfront.C0350mz
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.getBoolean("ignited")) {
            bP();
        }
    }

    @Override // com.boehmod.blockfront.mQ
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(u, false);
    }

    @Override // com.boehmod.blockfront.mQ
    public String G() {
        return "stalker";
    }

    @Override // com.boehmod.blockfront.mQ
    public int aB() {
        return 0;
    }

    @Override // com.boehmod.blockfront.mQ
    public void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, float f) {
        super.a(cVar, f);
    }

    @Override // com.boehmod.blockfront.mQ
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
    }

    @Override // com.boehmod.blockfront.mQ
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.mQ
    @NotNull
    public String getScoreboardName() {
        return String.valueOf(ChatFormatting.RED) + "Infected Stalker";
    }

    @Override // com.boehmod.blockfront.mQ
    @OnlyIn(Dist.CLIENT)
    public void a(eC eCVar, float f) {
        boolean zAL = aL();
        float fSin = (zAL ? 1.2f : 0.4f) * Mth.sin(f / 12.0f);
        ModelPart modelPart = eCVar.leftArm;
        float f2 = (-1.4f) + fSin;
        eCVar.leftSleeve.xRot = f2;
        modelPart.xRot = f2;
        ModelPart modelPart2 = eCVar.rightArm;
        float f3 = (-1.4f) - fSin;
        eCVar.rightSleeve.xRot = f3;
        modelPart2.xRot = f3;
        if (zAL) {
            float fSin2 = Mth.sin(f / 10.0f) * 1.2f;
            float fSin3 = Mth.sin(f / 15.0f) * 1.5f;
            ModelPart modelPart3 = eCVar.leftArm;
            float f4 = (-1.1f) + fSin2;
            eCVar.leftSleeve.yRot = f4;
            modelPart3.yRot = f4;
            ModelPart modelPart4 = eCVar.rightArm;
            float f5 = 1.1f + fSin3;
            eCVar.rightSleeve.yRot = f5;
            modelPart4.yRot = f5;
            float fSin4 = Mth.sin(f / 2.0f);
            float fSin5 = Mth.sin(f / 1.5f);
            ModelPart modelPart5 = eCVar.head;
            ModelPart modelPart6 = eCVar.hat;
            float f6 = modelPart6.xRot - 0.2f;
            modelPart6.xRot = f6;
            modelPart5.xRot = f6;
            ModelPart modelPart7 = eCVar.head;
            float f7 = fSin4 / 8.0f;
            eCVar.hat.yRot = f7;
            modelPart7.yRot = f7;
            ModelPart modelPart8 = eCVar.head;
            float f8 = fSin5 / 10.0f;
            eCVar.hat.zRot = f8;
            modelPart8.zRot = f8;
            return;
        }
        float fSin6 = 0.2f * Mth.sin(f / 4.0f);
        float fSin7 = 0.1f * Mth.sin(f / 7.0f);
        ModelPart modelPart9 = eCVar.head;
        eCVar.hat.xRot = fSin6;
        modelPart9.xRot = fSin6;
        ModelPart modelPart10 = eCVar.head;
        eCVar.hat.zRot = fSin7;
        modelPart10.zRot = fSin7;
    }

    @Override // com.boehmod.blockfront.mQ
    @NotNull
    public ResourceLocation t() {
        return C0265jv.d("textures/models/entities/infected/stalker/stalker" + (aL() ? "_ignited_" + (this.ly % 2) : "") + ".png");
    }

    @Override // com.boehmod.blockfront.mQ
    @NotNull
    public ResourceLocation u() {
        return C0265jv.d("textures/models/entities/infected/stalker/stalker" + (aL() ? "_ignited_" + (this.ly % 2) : "") + "_bright.png");
    }
}
