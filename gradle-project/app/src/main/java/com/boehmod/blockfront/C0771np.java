package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.np */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/np.class */
public class C0771np extends C0768nm {

    /* JADX INFO: renamed from: u */
    private static final EntityDataAccessor<Boolean> f4310u = SynchedEntityData.defineId(C0771np.class, EntityDataSerializers.BOOLEAN);

    /* JADX INFO: renamed from: nw */
    private int f4311nw;

    public C0771np(EntityType<? extends C0771np> entityType, Level level) {
        super(entityType, level);
        this.f4311nw = 0;
    }

    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3639a() {
        return C0768nm.m3622a();
    }

    /* JADX INFO: renamed from: aV */
    public boolean m3640aV() {
        return ((Boolean) this.entityData.get(f4310u)).booleanValue();
    }

    /* JADX INFO: renamed from: ca */
    public void m3641ca() {
        Level level = level();
        this.entityData.set(f4310u, true);
        Vec3 eyePosition = getEyePosition();
        for (int i = 0; i < 5; i++) {
            level.addParticle(ParticleTypes.LAVA, true, eyePosition.x, eyePosition.y, eyePosition.z, 0.0d, 0.0d, 0.0d);
        }
        level.addParticle((ParticleOptions) C1309xw.f7858nu.get(), true, eyePosition.x, eyePosition.y, eyePosition.z, 0.0d, 0.0d, 0.0d);
        playSound((SoundEvent) C1312xz.f7933oG.get());
        playSound((SoundEvent) C1312xz.f7932oF.get());
    }

    /* JADX INFO: renamed from: cb */
    public void m3642cb() {
        Vec3 eyePosition = getEyePosition();
        if (Math.random() < 0.2d) {
            level().addParticle(ParticleTypes.LAVA, eyePosition.x, eyePosition.y, eyePosition.z, 0.0d, 0.0d, 0.0d);
        }
    }

    public void tick() {
        if (level().isClientSide() && isAlive() && m3640aV()) {
            m3642cb();
            this.f4311nw++;
        }
        super.tick();
    }

    public boolean hurt(@NotNull DamageSource damageSource, float f) {
        if (super.hurt(damageSource, f)) {
            m3641ca();
            return true;
        }
        return false;
    }

    public boolean doHurtTarget(@NotNull Entity entity) {
        boolean zDoHurtTarget = super.doHurtTarget(entity);
        if (zDoHurtTarget) {
            entity.setRemainingFireTicks(3);
            m3641ca();
        }
        return zDoHurtTarget;
    }

    @Override // com.boehmod.blockfront.C0698mV
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("ignited", m3640aV());
    }

    @Override // com.boehmod.blockfront.C0698mV
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.getBoolean("ignited")) {
            m3641ca();
        }
    }

    @Override // com.boehmod.blockfront.C0768nm
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(f4310u, false);
    }

    @Override // com.boehmod.blockfront.C0768nm
    /* JADX INFO: renamed from: N */
    public String mo3627N() {
        return "stalker";
    }

    @Override // com.boehmod.blockfront.C0768nm
    /* JADX INFO: renamed from: aQ */
    public int mo3628aQ() {
        return 0;
    }

    @Override // com.boehmod.blockfront.C0768nm
    /* JADX INFO: renamed from: a */
    public void mo3626a(@NotNull AbstractC0184c<?> abstractC0184c, float f) {
        super.mo3626a(abstractC0184c, f);
    }

    @Override // com.boehmod.blockfront.C0768nm
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
    }

    @Override // com.boehmod.blockfront.C0768nm
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.C0768nm
    @NotNull
    public String getScoreboardName() {
        return String.valueOf(ChatFormatting.RED) + "Infected Stalker";
    }

    @Override // com.boehmod.blockfront.C0768nm
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3634a(C0268eP c0268eP, float f) {
        boolean zM3640aV = m3640aV();
        float fSin = (zM3640aV ? 1.2f : 0.4f) * Mth.sin(f / 12.0f);
        ModelPart modelPart = c0268eP.leftArm;
        float f2 = (-1.4f) + fSin;
        c0268eP.leftSleeve.xRot = f2;
        modelPart.xRot = f2;
        ModelPart modelPart2 = c0268eP.rightArm;
        float f3 = (-1.4f) - fSin;
        c0268eP.rightSleeve.xRot = f3;
        modelPart2.xRot = f3;
        if (zM3640aV) {
            float fSin2 = Mth.sin(f / 10.0f) * 1.2f;
            float fSin3 = Mth.sin(f / 15.0f) * 1.5f;
            ModelPart modelPart3 = c0268eP.leftArm;
            float f4 = (-1.1f) + fSin2;
            c0268eP.leftSleeve.yRot = f4;
            modelPart3.yRot = f4;
            ModelPart modelPart4 = c0268eP.rightArm;
            float f5 = 1.1f + fSin3;
            c0268eP.rightSleeve.yRot = f5;
            modelPart4.yRot = f5;
            float fSin4 = Mth.sin(f / 2.0f);
            float fSin5 = Mth.sin(f / 1.5f);
            ModelPart modelPart5 = c0268eP.head;
            ModelPart modelPart6 = c0268eP.hat;
            float f6 = modelPart6.xRot - 0.2f;
            modelPart6.xRot = f6;
            modelPart5.xRot = f6;
            ModelPart modelPart7 = c0268eP.head;
            float f7 = fSin4 / 8.0f;
            c0268eP.hat.yRot = f7;
            modelPart7.yRot = f7;
            ModelPart modelPart8 = c0268eP.head;
            float f8 = fSin5 / 10.0f;
            c0268eP.hat.zRot = f8;
            modelPart8.zRot = f8;
            return;
        }
        float fSin6 = 0.2f * Mth.sin(f / 4.0f);
        float fSin7 = 0.1f * Mth.sin(f / 7.0f);
        ModelPart modelPart9 = c0268eP.head;
        c0268eP.hat.xRot = fSin6;
        modelPart9.xRot = fSin6;
        ModelPart modelPart10 = c0268eP.head;
        c0268eP.hat.zRot = fSin7;
        modelPart10.zRot = fSin7;
    }

    @Override // com.boehmod.blockfront.C0768nm
    @NotNull
    /* JADX INFO: renamed from: u */
    public ResourceLocation mo3624u() {
        return C0532jO.m2378d("textures/models/entities/infected/stalker/stalker" + (m3640aV() ? "_ignited_" + (this.f4311nw % 2) : "") + ".png");
    }

    @Override // com.boehmod.blockfront.C0768nm
    @NotNull
    /* JADX INFO: renamed from: v */
    public ResourceLocation mo3635v() {
        return C0532jO.m2378d("textures/models/entities/infected/stalker/stalker" + (m3640aV() ? "_ignited_" + (this.f4311nw % 2) : "") + "_bright.png");
    }
}
