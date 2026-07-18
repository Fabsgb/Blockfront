package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
import java.util.Iterator;
import java.util.UUID;
import java.util.function.Predicate;
import net.minecraft.core.Holder;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mW.class */
public abstract class AbstractC0698mW extends C0727mz {

    /* JADX INFO: renamed from: c */
    private final Predicate<LivingEntity> f3749c;

    /* JADX INFO: renamed from: js */
    private int f3750js;

    /* JADX INFO: renamed from: lz */
    private int f3751lz;

    /* JADX INFO: renamed from: z */
    private int f3752z;

    /* JADX INFO: renamed from: eM */
    static final /* synthetic */ boolean f3753eM;

    /* JADX INFO: renamed from: H */
    public abstract String mo3137H();

    /* JADX INFO: renamed from: a */
    public abstract Holder<SoundEvent> mo3138a();

    /* JADX INFO: renamed from: aD */
    public abstract int mo3139aD();

    static {
        f3753eM = !AbstractC0698mW.class.desiredAssertionStatus();
    }

    public AbstractC0698mW(EntityType<? extends AbstractC0698mW> entityType, Level level) {
        super(entityType, level);
        this.f3749c = livingEntity -> {
            if (livingEntity instanceof ServerPlayer) {
                Player player = (ServerPlayer) livingEntity;
                AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
                if (!f3753eM && abstractC0563juM168a == null) {
                    throw new AssertionError("Mod manager is null!");
                }
                AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
                UUID uuid = player.getUUID();
                if (abstractC0183cM2528a.m1136a(player).m1087dk() || !player.isAlive()) {
                    return false;
                }
                AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
                if (abstractC0787oFMo2531a == null || this.f3896a == null) {
                    return true;
                }
                return abstractC0787oFMo2531a.m3628e().equals(this.f3896a.m3628e());
            }
            return false;
        };
        this.f3750js = 0;
        this.f3751lz = 0;
        this.f3752z = 0;
    }

    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3140a() {
        return Mob.createMobAttributes().add(Attributes.FOLLOW_RANGE, 256.0d).add(Attributes.ATTACK_DAMAGE, 100.0d).add(Attributes.MOVEMENT_SPEED, 1.0d).add(Attributes.ATTACK_KNOCKBACK, 5.0d).add(Attributes.MAX_HEALTH, 800.0d);
    }

    protected void registerGoals() {
        super.registerGoals();
        getNavigation().setCanOpenDoors(true);
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal(this, Player.class, false, this.f3749c));
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 0.4300000071525574d, true));
    }

    @Override // com.boehmod.blockfront.C0727mz
    public void baseTick() {
        super.baseTick();
        Level level = level();
        if (level.isClientSide) {
            return;
        }
        int i = this.f3751lz;
        this.f3751lz = i - 1;
        if (i <= 0) {
            this.f3751lz = 3;
            Iterator it = level.getNearbyPlayers(TargetingConditions.forCombat(), this, getBoundingBox().inflate(1.5d, 1.5d, 1.5d)).iterator();
            while (it.hasNext()) {
                ((Player) it.next()).hurt(level.damageSources().mobAttack(this), 50.0f);
            }
        }
        int i2 = this.f3750js;
        this.f3750js = i2 - 1;
        if (i2 <= 0) {
            this.f3750js = mo3139aD();
            level.playSeededSound((Player) null, this, mo3138a(), SoundSource.HOSTILE, 3.0f, 1.0f, 0L);
        }
        int i3 = this.f3752z;
        this.f3752z = i3 - 1;
        if (i3 <= 0) {
            this.f3752z = 10;
            LivingEntity target = getTarget();
            if (target != null) {
                if (!canAttack(target)) {
                    setTarget(null);
                    return;
                }
                return;
            }
            double d = -1.0d;
            Player player = null;
            for (Player player2 : level.players()) {
                double dSqrt = Mth.sqrt(player2.distanceTo(this));
                if (d == -1.0d || dSqrt <= d) {
                    if (canAttack(player2)) {
                        d = dSqrt;
                        player = player2;
                    }
                }
            }
            if (player != null) {
                setTarget(player);
            }
        }
    }

    public float maxUpStep() {
        return 3.0f;
    }

    public boolean canAttack(@NotNull LivingEntity livingEntity) {
        if (super.canAttack(livingEntity)) {
            return this.f3749c.test(livingEntity);
        }
        return false;
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
