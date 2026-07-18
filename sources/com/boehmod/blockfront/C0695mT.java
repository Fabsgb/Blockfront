package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.mT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mT.class */
public class C0695mT extends C0692mQ {

    /* JADX INFO: renamed from: u */
    private static final EntityDataAccessor<Boolean> f3747u = SynchedEntityData.defineId(C0695mT.class, EntityDataSerializers.BOOLEAN);

    /* JADX INFO: renamed from: ly */
    private int f3748ly;

    public C0695mT(EntityType<? extends C0695mT> entityType, Level level) {
        super(entityType, level);
        this.f3748ly = 0;
    }

    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3132a() {
        return C0692mQ.m3115a();
    }

    /* JADX INFO: renamed from: aL */
    public boolean m3133aL() {
        return ((Boolean) this.entityData.get(f3747u)).booleanValue();
    }

    /* JADX INFO: renamed from: bP */
    public void m3134bP() {
        Level level = level();
        this.entityData.set(f3747u, true);
        Vec3 eyePosition = getEyePosition();
        for (int i = 0; i < 5; i++) {
            level.addParticle(ParticleTypes.LAVA, true, eyePosition.x, eyePosition.y, eyePosition.z, 0.0d, 0.0d, 0.0d);
        }
        level.addParticle((ParticleOptions) C1232wZ.f7293nu.get(), true, eyePosition.x, eyePosition.y, eyePosition.z, 0.0d, 0.0d, 0.0d);
        playSound((SoundEvent) C1280xc.f7521oE.get());
        playSound((SoundEvent) C1280xc.f7520oD.get());
    }

    /* JADX INFO: renamed from: bQ */
    public void m3135bQ() {
        Vec3 eyePosition = getEyePosition();
        if (Math.random() < 0.2d) {
            level().addParticle(ParticleTypes.LAVA, eyePosition.x, eyePosition.y, eyePosition.z, 0.0d, 0.0d, 0.0d);
        }
    }

    public void tick() {
        if (level().isClientSide() && isAlive() && m3133aL()) {
            m3135bQ();
            this.f3748ly++;
        }
        super.tick();
    }

    public boolean hurt(@NotNull DamageSource damageSource, float f) {
        if (super.hurt(damageSource, f)) {
            m3134bP();
            return true;
        }
        return false;
    }

    public boolean doHurtTarget(@NotNull Entity entity) {
        boolean zDoHurtTarget = super.doHurtTarget(entity);
        if (zDoHurtTarget) {
            entity.setRemainingFireTicks(3);
            m3134bP();
        }
        return zDoHurtTarget;
    }

    @Override // com.boehmod.blockfront.C0727mz
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("ignited", m3133aL());
    }

    @Override // com.boehmod.blockfront.C0727mz
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.getBoolean("ignited")) {
            m3134bP();
        }
    }

    @Override // com.boehmod.blockfront.C0692mQ
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(f3747u, false);
    }

    @Override // com.boehmod.blockfront.C0692mQ
    /* JADX INFO: renamed from: G */
    public String mo3120G() {
        return "stalker";
    }

    @Override // com.boehmod.blockfront.C0692mQ
    /* JADX INFO: renamed from: aB */
    public int mo3121aB() {
        return 0;
    }

    @Override // com.boehmod.blockfront.C0692mQ
    /* JADX INFO: renamed from: a */
    public void mo3119a(@NotNull AbstractC0183c<?> abstractC0183c, float f) {
        super.mo3119a(abstractC0183c, f);
    }

    @Override // com.boehmod.blockfront.C0692mQ
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
    }

    @Override // com.boehmod.blockfront.C0692mQ
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.C0692mQ
    @NotNull
    public String getScoreboardName() {
        return String.valueOf(ChatFormatting.RED) + "Infected Stalker";
    }

    @Override // com.boehmod.blockfront.C0692mQ
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3127a(C0254eC c0254eC, float f) {
        boolean zM3133aL = m3133aL();
        float fSin = (zM3133aL ? 1.2f : 0.4f) * Mth.sin(f / 12.0f);
        ModelPart modelPart = c0254eC.leftArm;
        float f2 = (-1.4f) + fSin;
        c0254eC.leftSleeve.xRot = f2;
        modelPart.xRot = f2;
        ModelPart modelPart2 = c0254eC.rightArm;
        float f3 = (-1.4f) - fSin;
        c0254eC.rightSleeve.xRot = f3;
        modelPart2.xRot = f3;
        if (zM3133aL) {
            float fSin2 = Mth.sin(f / 10.0f) * 1.2f;
            float fSin3 = Mth.sin(f / 15.0f) * 1.5f;
            ModelPart modelPart3 = c0254eC.leftArm;
            float f4 = (-1.1f) + fSin2;
            c0254eC.leftSleeve.yRot = f4;
            modelPart3.yRot = f4;
            ModelPart modelPart4 = c0254eC.rightArm;
            float f5 = 1.1f + fSin3;
            c0254eC.rightSleeve.yRot = f5;
            modelPart4.yRot = f5;
            float fSin4 = Mth.sin(f / 2.0f);
            float fSin5 = Mth.sin(f / 1.5f);
            ModelPart modelPart5 = c0254eC.head;
            ModelPart modelPart6 = c0254eC.hat;
            float f6 = modelPart6.xRot - 0.2f;
            modelPart6.xRot = f6;
            modelPart5.xRot = f6;
            ModelPart modelPart7 = c0254eC.head;
            float f7 = fSin4 / 8.0f;
            c0254eC.hat.yRot = f7;
            modelPart7.yRot = f7;
            ModelPart modelPart8 = c0254eC.head;
            float f8 = fSin5 / 10.0f;
            c0254eC.hat.zRot = f8;
            modelPart8.zRot = f8;
            return;
        }
        float fSin6 = 0.2f * Mth.sin(f / 4.0f);
        float fSin7 = 0.1f * Mth.sin(f / 7.0f);
        ModelPart modelPart9 = c0254eC.head;
        c0254eC.hat.xRot = fSin6;
        modelPart9.xRot = fSin6;
        ModelPart modelPart10 = c0254eC.head;
        c0254eC.hat.zRot = fSin7;
        modelPart10.zRot = fSin7;
    }

    @Override // com.boehmod.blockfront.C0692mQ
    @NotNull
    /* JADX INFO: renamed from: t */
    public ResourceLocation mo3117t() {
        return C0564jv.m2555d("textures/models/entities/infected/stalker/stalker" + (m3133aL() ? "_ignited_" + (this.f3748ly % 2) : "") + ".png");
    }

    @Override // com.boehmod.blockfront.C0692mQ
    @NotNull
    /* JADX INFO: renamed from: u */
    public ResourceLocation mo3128u() {
        return C0564jv.m2555d("textures/models/entities/infected/stalker/stalker" + (m3133aL() ? "_ignited_" + (this.f3748ly % 2) : "") + "_bright.png");
    }
}
