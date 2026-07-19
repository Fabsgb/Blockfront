package com.boehmod.blockfront;

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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mW.class */
public abstract class mW extends C0350mz {
    private final Predicate<LivingEntity> c;
    private int js;
    private int lz;
    private int z;
    static final /* synthetic */ boolean eM;

    public abstract String H();

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract Holder<SoundEvent> mo680a();

    public abstract int aD();

    static {
        eM = !mW.class.desiredAssertionStatus();
    }

    public mW(EntityType<? extends mW> entityType, Level level) {
        super(entityType, level);
        this.c = livingEntity -> {
            if (livingEntity instanceof ServerPlayer) {
                Player player = (ServerPlayer) livingEntity;
                AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
                if (!eM && abstractC0264juM166a == null) {
                    throw new AssertionError("Mod manager is null!");
                }
                com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
                UUID uuid = player.getUUID();
                if (cVarM531a.m305a(player).dk() || !player.isAlive()) {
                    return false;
                }
                oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
                if (oFVarMo604a == null || this.a == null) {
                    return true;
                }
                return oFVarMo604a.m757e().equals(this.a.m757e());
            }
            return false;
        };
        this.js = 0;
        this.lz = 0;
        this.z = 0;
    }

    public static AttributeSupplier.Builder a() {
        return Mob.createMobAttributes().add(Attributes.FOLLOW_RANGE, 256.0d).add(Attributes.ATTACK_DAMAGE, 100.0d).add(Attributes.MOVEMENT_SPEED, 1.0d).add(Attributes.ATTACK_KNOCKBACK, 5.0d).add(Attributes.MAX_HEALTH, 800.0d);
    }

    protected void registerGoals() {
        super.registerGoals();
        getNavigation().setCanOpenDoors(true);
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal(this, Player.class, false, this.c));
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 0.4300000071525574d, true));
    }

    @Override // com.boehmod.blockfront.C0350mz
    public void baseTick() {
        super.baseTick();
        Level level = level();
        if (level.isClientSide) {
            return;
        }
        int i = this.lz;
        this.lz = i - 1;
        if (i <= 0) {
            this.lz = 3;
            Iterator it = level.getNearbyPlayers(TargetingConditions.forCombat(), this, getBoundingBox().inflate(1.5d, 1.5d, 1.5d)).iterator();
            while (it.hasNext()) {
                ((Player) it.next()).hurt(level.damageSources().mobAttack(this), 50.0f);
            }
        }
        int i2 = this.js;
        this.js = i2 - 1;
        if (i2 <= 0) {
            this.js = aD();
            level.playSeededSound((Player) null, this, mo680a(), SoundSource.HOSTILE, 3.0f, 1.0f, 0L);
        }
        int i3 = this.z;
        this.z = i3 - 1;
        if (i3 <= 0) {
            this.z = 10;
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
            return this.c.test(livingEntity);
        }
        return false;
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
