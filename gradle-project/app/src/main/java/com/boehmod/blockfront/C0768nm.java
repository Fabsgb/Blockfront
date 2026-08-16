package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.nm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nm.class */
public class C0768nm extends C0698mV implements InterfaceC0696mT {

    /* JADX INFO: renamed from: s */
    private static final EntityDataAccessor<Integer> f4303s;

    /* JADX INFO: renamed from: t */
    private static final EntityDataAccessor<Integer> f4304t;

    /* JADX INFO: renamed from: nu */
    public static final int f4305nu = 20;

    /* JADX INFO: renamed from: nv */
    private int f4306nv;

    /* JADX INFO: renamed from: fe */
    private boolean f4307fe;

    /* JADX INFO: renamed from: lD */
    private int f4308lD;

    /* JADX INFO: renamed from: ff */
    static final /* synthetic */ boolean f4309ff;

    static {
        f4309ff = !C0768nm.class.desiredAssertionStatus();
        f4303s = SynchedEntityData.defineId(C0768nm.class, EntityDataSerializers.INT);
        f4304t = SynchedEntityData.defineId(C0768nm.class, EntityDataSerializers.INT);
    }

    public C0768nm(EntityType<? extends C0768nm> entityType, Level level) {
        super(entityType, level);
        this.f4306nv = 0;
        this.f4307fe = false;
        this.f4308lD = 0;
        m3630v(ThreadLocalRandom.current().nextInt(5));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3622a() {
        return Mob.createMobAttributes().add(Attributes.FOLLOW_RANGE, 128.0d).add(Attributes.ATTACK_DAMAGE, 9.0d).add(Attributes.MOVEMENT_SPEED, 0.6d).add(Attributes.MAX_HEALTH, 100.0d);
    }

    /* JADX INFO: renamed from: bZ */
    public void m3623bZ() {
        this.f4307fe = true;
        this.f4306nv = 0;
    }

    @NotNull
    /* JADX INFO: renamed from: u */
    public ResourceLocation mo3624u() {
        return C0532jO.m2378d("textures/models/entities/infected/" + mo3627N() + "/" + m3631aR() + ".png");
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m3625a(@NotNull Level level) {
    }

    /* JADX INFO: renamed from: a */
    public void mo3626a(@NotNull AbstractC0184c<?> abstractC0184c, float f) {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, Math.min(f, 0.6f), true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, 0, false, false, m3633a(abstractC0184c)));
    }

    /* JADX INFO: renamed from: N */
    public String mo3627N() {
        return "generic" + m3629aJ();
    }

    /* JADX INFO: renamed from: aQ */
    public int mo3628aQ() {
        return 2;
    }

    public String getSkin() {
        return "default";
    }

    /* JADX INFO: renamed from: aJ */
    public int m3629aJ() {
        return ((Integer) this.entityData.get(f4303s)).intValue();
    }

    /* JADX INFO: renamed from: v */
    public void m3630v(int i) {
        this.entityData.set(f4303s, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: aR */
    public int m3631aR() {
        return ((Integer) this.entityData.get(f4304t)).intValue();
    }

    /* JADX INFO: renamed from: w */
    public void m3632w(int i) {
        this.entityData.set(f4304t, Integer.valueOf(i));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Predicate<LivingEntity> m3633a(@NotNull AbstractC0184c<?> abstractC0184c) {
        return livingEntity -> {
            if (livingEntity instanceof Player) {
                Player player = (Player) livingEntity;
                AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
                if (!f4309ff && abstractC0531jNM179a == null) {
                    throw new AssertionError("Mod manager is null!");
                }
                AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(player.getUUID());
                return player.isAlive() && !abstractC0184c.m1153a(player).m1104dt() && abstractC0863pbMo2354a != null && abstractC0863pbMo2354a.equals(this.f3855a);
            }
            return false;
        };
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3634a(C0268eP c0268eP, float f) {
        float fSin = 0.4f * Mth.sin(f / 12.0f);
        float fSin2 = 0.2f * Mth.sin(f / 4.0f);
        float fSin3 = 0.1f * Mth.sin(f / 7.0f);
        ModelPart modelPart = c0268eP.head;
        c0268eP.hat.xRot = fSin2;
        modelPart.xRot = fSin2;
        ModelPart modelPart2 = c0268eP.head;
        c0268eP.hat.zRot = fSin3;
        modelPart2.zRot = fSin3;
        ModelPart modelPart3 = c0268eP.leftArm;
        float f2 = (-1.4f) + fSin;
        c0268eP.leftSleeve.xRot = f2;
        modelPart3.xRot = f2;
        ModelPart modelPart4 = c0268eP.rightArm;
        float f3 = (-1.4f) - fSin;
        c0268eP.rightSleeve.xRot = f3;
        modelPart4.xRot = f3;
    }

    @NotNull
    /* JADX INFO: renamed from: v */
    public ResourceLocation mo3635v() {
        return C0532jO.m2378d("textures/models/entities/infected/" + mo3627N() + "/" + m3631aR() + "_bright.png");
    }

    @NotNull
    public String getScoreboardName() {
        return String.valueOf(ChatFormatting.RED) + "Infected";
    }

    public boolean canAttack(LivingEntity livingEntity) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4309ff && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (livingEntity.isAlive() && livingEntity.tickCount > 40 && (livingEntity instanceof Player)) {
            return !abstractC0531jNM179a.m2351a().m1153a((Player) livingEntity).m1104dt();
        }
        return false;
    }

    public void playAmbientSound() {
        super.playAmbientSound();
        if (!level().isClientSide()) {
            m3623bZ();
        }
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent) C1312xz.f8141sG.get();
    }

    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return (SoundEvent) C1312xz.f8141sG.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent) C1312xz.f8142sH.get();
    }

    @Override // com.boehmod.blockfront.C0698mV
    public void baseTick() {
        super.baseTick();
        Level level = level();
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4309ff && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
        if (!level.isClientSide()) {
            LivingEntity target = getTarget();
            if (target instanceof Player) {
                Player player = (Player) target;
                if (abstractC0184cM2351a.m1153a(player).m1104dt() || !player.isAlive()) {
                    setTarget(null);
                    return;
                }
            }
            if (this.tickCount % 2 == 0) {
                if (this.f4307fe) {
                    if (this.f4306nv < mo3628aQ()) {
                        this.f4306nv++;
                    } else {
                        this.f4307fe = false;
                    }
                } else if (this.f4306nv > 0) {
                    this.f4306nv--;
                }
            }
            m3632w(this.f4306nv);
            return;
        }
        m3625a(level);
    }

    @Override // com.boehmod.blockfront.C0698mV
    /* JADX INFO: renamed from: b */
    public void mo3121b(@NotNull ServerLevel serverLevel) {
        super.mo3121b(serverLevel);
        int i = this.f4308lD;
        this.f4308lD = i - 1;
        if (i <= 0) {
            this.f4308lD = 20;
            Object obj = this.f3855a;
            if (obj instanceof InterfaceC0987rt) {
                ((InterfaceC0987rt) obj).mo5563a(serverLevel, this);
            }
        }
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(f4303s, 0).define(f4304t, 0);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
    }
}
