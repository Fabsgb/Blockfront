package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.mQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mQ.class */
public class C0692mQ extends C0727mz implements InterfaceC0725mx {

    /* JADX INFO: renamed from: s */
    private static final EntityDataAccessor<Integer> f3740s;

    /* JADX INFO: renamed from: t */
    private static final EntityDataAccessor<Integer> f3741t;

    /* JADX INFO: renamed from: lw */
    public static final int f3742lw = 20;

    /* JADX INFO: renamed from: lx */
    private int f3743lx;

    /* JADX INFO: renamed from: eK */
    private boolean f3744eK;

    /* JADX INFO: renamed from: jW */
    private int f3745jW;

    /* JADX INFO: renamed from: eL */
    static final /* synthetic */ boolean f3746eL;

    static {
        f3746eL = !C0692mQ.class.desiredAssertionStatus();
        f3740s = SynchedEntityData.defineId(C0692mQ.class, EntityDataSerializers.INT);
        f3741t = SynchedEntityData.defineId(C0692mQ.class, EntityDataSerializers.INT);
    }

    public C0692mQ(EntityType<? extends C0692mQ> entityType, Level level) {
        super(entityType, level);
        this.f3743lx = 0;
        this.f3744eK = false;
        this.f3745jW = 0;
        m3123u(ThreadLocalRandom.current().nextInt(5));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3115a() {
        return Mob.createMobAttributes().add(Attributes.FOLLOW_RANGE, 128.0d).add(Attributes.ATTACK_DAMAGE, 9.0d).add(Attributes.MOVEMENT_SPEED, 0.6d).add(Attributes.MAX_HEALTH, 100.0d);
    }

    /* JADX INFO: renamed from: bO */
    public void m3116bO() {
        this.f3744eK = true;
        this.f3743lx = 0;
    }

    @NotNull
    /* JADX INFO: renamed from: t */
    public ResourceLocation mo3117t() {
        return C0564jv.m2555d("textures/models/entities/infected/" + mo3120G() + "/" + m3124aC() + ".png");
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m3118a(@NotNull Level level) {
    }

    /* JADX INFO: renamed from: a */
    public void mo3119a(@NotNull AbstractC0183c<?> abstractC0183c, float f) {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, Math.min(f, 0.6f), true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, 0, false, false, m3126a(abstractC0183c)));
    }

    /* JADX INFO: renamed from: G */
    public String mo3120G() {
        return "generic" + m3122au();
    }

    /* JADX INFO: renamed from: aB */
    public int mo3121aB() {
        return 2;
    }

    public String getSkin() {
        return "default";
    }

    /* JADX INFO: renamed from: au */
    public int m3122au() {
        return ((Integer) this.entityData.get(f3740s)).intValue();
    }

    /* JADX INFO: renamed from: u */
    public void m3123u(int i) {
        this.entityData.set(f3740s, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: aC */
    public int m3124aC() {
        return ((Integer) this.entityData.get(f3741t)).intValue();
    }

    /* JADX INFO: renamed from: v */
    public void m3125v(int i) {
        this.entityData.set(f3741t, Integer.valueOf(i));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Predicate<LivingEntity> m3126a(@NotNull AbstractC0183c<?> abstractC0183c) {
        return livingEntity -> {
            if (livingEntity instanceof Player) {
                Player player = (Player) livingEntity;
                AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
                if (!f3746eL && abstractC0563juM168a == null) {
                    throw new AssertionError("Mod manager is null!");
                }
                AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(player.getUUID());
                return player.isAlive() && !abstractC0183c.m1136a(player).m1087dk() && abstractC0787oFMo2531a != null && abstractC0787oFMo2531a.equals(this.f3896a);
            }
            return false;
        };
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3127a(C0254eC c0254eC, float f) {
        float fSin = 0.4f * Mth.sin(f / 12.0f);
        float fSin2 = 0.2f * Mth.sin(f / 4.0f);
        float fSin3 = 0.1f * Mth.sin(f / 7.0f);
        ModelPart modelPart = c0254eC.head;
        c0254eC.hat.xRot = fSin2;
        modelPart.xRot = fSin2;
        ModelPart modelPart2 = c0254eC.head;
        c0254eC.hat.zRot = fSin3;
        modelPart2.zRot = fSin3;
        ModelPart modelPart3 = c0254eC.leftArm;
        float f2 = (-1.4f) + fSin;
        c0254eC.leftSleeve.xRot = f2;
        modelPart3.xRot = f2;
        ModelPart modelPart4 = c0254eC.rightArm;
        float f3 = (-1.4f) - fSin;
        c0254eC.rightSleeve.xRot = f3;
        modelPart4.xRot = f3;
    }

    @NotNull
    /* JADX INFO: renamed from: u */
    public ResourceLocation mo3128u() {
        return C0564jv.m2555d("textures/models/entities/infected/" + mo3120G() + "/" + m3124aC() + "_bright.png");
    }

    @NotNull
    public String getScoreboardName() {
        return String.valueOf(ChatFormatting.RED) + "Infected";
    }

    public boolean canAttack(LivingEntity livingEntity) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f3746eL && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (livingEntity.isAlive() && livingEntity.tickCount > 40 && (livingEntity instanceof Player)) {
            return !abstractC0563juM168a.m2528a().m1136a((Player) livingEntity).m1087dk();
        }
        return false;
    }

    public void playAmbientSound() {
        super.playAmbientSound();
        if (!level().isClientSide()) {
            m3116bO();
        }
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent) C1280xc.f7730sF.get();
    }

    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return (SoundEvent) C1280xc.f7730sF.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent) C1280xc.f7731sG.get();
    }

    @Override // com.boehmod.blockfront.C0727mz
    public void baseTick() {
        super.baseTick();
        Level level = level();
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f3746eL && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        if (!level.isClientSide()) {
            LivingEntity target = getTarget();
            if (target instanceof Player) {
                Player player = (Player) target;
                if (abstractC0183cM2528a.m1136a(player).m1087dk() || !player.isAlive()) {
                    setTarget(null);
                    return;
                }
            }
            if (this.tickCount % 2 == 0) {
                if (this.f3744eK) {
                    if (this.f3743lx < mo3121aB()) {
                        this.f3743lx++;
                    } else {
                        this.f3744eK = false;
                    }
                } else if (this.f3743lx > 0) {
                    this.f3743lx--;
                }
            }
            m3125v(this.f3743lx);
            return;
        }
        m3118a(level);
    }

    @Override // com.boehmod.blockfront.C0727mz
    /* JADX INFO: renamed from: b */
    public void mo3040b(@NotNull ServerLevel serverLevel) {
        super.mo3040b(serverLevel);
        int i = this.f3745jW;
        this.f3745jW = i - 1;
        if (i <= 0) {
            this.f3745jW = 20;
            Object obj = this.f3896a;
            if (obj instanceof InterfaceC0910qW) {
                ((InterfaceC0910qW) obj).mo4692a(serverLevel, this);
            }
        }
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(f3740s, 0).define(f3741t, 0);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
    }
}
