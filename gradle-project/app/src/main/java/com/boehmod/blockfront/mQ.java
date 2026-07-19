package com.boehmod.blockfront;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mQ.class */
public class mQ extends C0350mz implements InterfaceC0348mx {
    private static final EntityDataAccessor<Integer> s;
    private static final EntityDataAccessor<Integer> t;
    public static final int lw = 20;
    private int lx;
    private boolean eK;
    private int jW;
    static final /* synthetic */ boolean eL;

    static {
        eL = !mQ.class.desiredAssertionStatus();
        s = SynchedEntityData.defineId(mQ.class, EntityDataSerializers.INT);
        t = SynchedEntityData.defineId(mQ.class, EntityDataSerializers.INT);
    }

    public mQ(EntityType<? extends mQ> entityType, Level level) {
        super(entityType, level);
        this.lx = 0;
        this.eK = false;
        this.jW = 0;
        u(ThreadLocalRandom.current().nextInt(5));
    }

    @NotNull
    public static AttributeSupplier.Builder a() {
        return Mob.createMobAttributes().add(Attributes.FOLLOW_RANGE, 128.0d).add(Attributes.ATTACK_DAMAGE, 9.0d).add(Attributes.MOVEMENT_SPEED, 0.6d).add(Attributes.MAX_HEALTH, 100.0d);
    }

    public void bO() {
        this.eK = true;
        this.lx = 0;
    }

    @NotNull
    public ResourceLocation t() {
        return C0265jv.d("textures/models/entities/infected/" + G() + "/" + aC() + ".png");
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull Level level) {
    }

    public void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, float f) {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, Math.min(f, 0.6f), true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, 0, false, false, a(cVar)));
    }

    public String G() {
        return "generic" + au();
    }

    public int aB() {
        return 2;
    }

    public String getSkin() {
        return "default";
    }

    public int au() {
        return ((Integer) this.entityData.get(s)).intValue();
    }

    public void u(int i) {
        this.entityData.set(s, Integer.valueOf(i));
    }

    public int aC() {
        return ((Integer) this.entityData.get(t)).intValue();
    }

    public void v(int i) {
        this.entityData.set(t, Integer.valueOf(i));
    }

    @NotNull
    public Predicate<LivingEntity> a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar) {
        return livingEntity -> {
            if (livingEntity instanceof Player) {
                Player player = (Player) livingEntity;
                AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
                if (!eL && abstractC0264juM166a == null) {
                    throw new AssertionError("Mod manager is null!");
                }
                oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(player.getUUID());
                return player.isAlive() && !cVar.m305a(player).dk() && oFVarMo604a != null && oFVarMo604a.equals(this.a);
            }
            return false;
        };
    }

    @OnlyIn(Dist.CLIENT)
    public void a(eC eCVar, float f) {
        float fSin = 0.4f * Mth.sin(f / 12.0f);
        float fSin2 = 0.2f * Mth.sin(f / 4.0f);
        float fSin3 = 0.1f * Mth.sin(f / 7.0f);
        ModelPart modelPart = eCVar.head;
        eCVar.hat.xRot = fSin2;
        modelPart.xRot = fSin2;
        ModelPart modelPart2 = eCVar.head;
        eCVar.hat.zRot = fSin3;
        modelPart2.zRot = fSin3;
        ModelPart modelPart3 = eCVar.leftArm;
        float f2 = (-1.4f) + fSin;
        eCVar.leftSleeve.xRot = f2;
        modelPart3.xRot = f2;
        ModelPart modelPart4 = eCVar.rightArm;
        float f3 = (-1.4f) - fSin;
        eCVar.rightSleeve.xRot = f3;
        modelPart4.xRot = f3;
    }

    @NotNull
    public ResourceLocation u() {
        return C0265jv.d("textures/models/entities/infected/" + G() + "/" + aC() + "_bright.png");
    }

    @NotNull
    public String getScoreboardName() {
        return String.valueOf(ChatFormatting.RED) + "Infected";
    }

    public boolean canAttack(LivingEntity livingEntity) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!eL && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (livingEntity.isAlive() && livingEntity.tickCount > 40 && (livingEntity instanceof Player)) {
            return !abstractC0264juM166a.m531a().m305a((Player) livingEntity).dk();
        }
        return false;
    }

    public void playAmbientSound() {
        super.playAmbientSound();
        if (!level().isClientSide()) {
            bO();
        }
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent) C0624xc.sF.get();
    }

    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return (SoundEvent) C0624xc.sF.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent) C0624xc.sG.get();
    }

    @Override // com.boehmod.blockfront.C0350mz
    public void baseTick() {
        super.baseTick();
        Level level = level();
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!eL && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
        if (!level.isClientSide()) {
            LivingEntity target = getTarget();
            if (target instanceof Player) {
                Player player = (Player) target;
                if (cVarM531a.m305a(player).dk() || !player.isAlive()) {
                    setTarget(null);
                    return;
                }
            }
            if (this.tickCount % 2 == 0) {
                if (this.eK) {
                    if (this.lx < aB()) {
                        this.lx++;
                    } else {
                        this.eK = false;
                    }
                } else if (this.lx > 0) {
                    this.lx--;
                }
            }
            v(this.lx);
            return;
        }
        a(level);
    }

    @Override // com.boehmod.blockfront.C0350mz
    public void b(@NotNull ServerLevel serverLevel) {
        super.b(serverLevel);
        int i = this.jW;
        this.jW = i - 1;
        if (i <= 0) {
            this.jW = 20;
            Object obj = this.a;
            if (obj instanceof qW) {
                ((qW) obj).a(serverLevel, this);
            }
        }
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(s, 0).define(t, 0);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
    }
}
