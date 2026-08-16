package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ns */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ns.class */
public abstract class AbstractC0774ns extends C0698mV {

    /* JADX INFO: renamed from: c */
    private final Predicate<LivingEntity> f4312c;

    /* JADX INFO: renamed from: kN */
    private int f4313kN;

    /* JADX INFO: renamed from: nx */
    private int f4314nx;

    /* JADX INFO: renamed from: ab */
    private int f4315ab;

    /* JADX INFO: renamed from: fg */
    static final /* synthetic */ boolean f4316fg;

    /* JADX INFO: renamed from: O */
    public abstract String mo3644O();

    /* JADX INFO: renamed from: a */
    public abstract Holder<SoundEvent> mo3645a();

    /* JADX INFO: renamed from: aS */
    public abstract int mo3646aS();

    static {
        f4316fg = !AbstractC0774ns.class.desiredAssertionStatus();
    }

    public AbstractC0774ns(EntityType<? extends AbstractC0774ns> entityType, Level level) {
        super(entityType, level);
        this.f4312c = livingEntity -> {
            if (livingEntity instanceof ServerPlayer) {
                Player player = (ServerPlayer) livingEntity;
                AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
                if (!f4316fg && abstractC0531jNM179a == null) {
                    throw new AssertionError("Mod manager is null!");
                }
                AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
                UUID uuid = player.getUUID();
                if (abstractC0184cM2351a.m1153a(player).m1104dt() || !player.isAlive()) {
                    return false;
                }
                AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
                if (abstractC0863pbMo2354a == null || this.f3855a == null) {
                    return true;
                }
                return abstractC0863pbMo2354a.m4064e().equals(this.f3855a.m4064e());
            }
            return false;
        };
        this.f4313kN = 0;
        this.f4314nx = 0;
        this.f4315ab = 0;
    }

    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3647a() {
        return Mob.createMobAttributes().add(Attributes.FOLLOW_RANGE, 256.0d).add(Attributes.ATTACK_DAMAGE, 100.0d).add(Attributes.MOVEMENT_SPEED, 1.0d).add(Attributes.ATTACK_KNOCKBACK, 5.0d).add(Attributes.MAX_HEALTH, 800.0d);
    }

    protected void registerGoals() {
        super.registerGoals();
        getNavigation().setCanOpenDoors(true);
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal(this, Player.class, false, this.f4312c));
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 0.4300000071525574d, true));
    }

    @Override // com.boehmod.blockfront.C0698mV
    public void baseTick() {
        super.baseTick();
        Level level = level();
        if (level.isClientSide) {
            return;
        }
        int i = this.f4314nx;
        this.f4314nx = i - 1;
        if (i <= 0) {
            this.f4314nx = 3;
            Iterator it = level.getNearbyPlayers(TargetingConditions.forCombat(), this, getBoundingBox().inflate(1.5d, 1.5d, 1.5d)).iterator();
            while (it.hasNext()) {
                ((Player) it.next()).hurt(level.damageSources().mobAttack(this), 50.0f);
            }
        }
        int i2 = this.f4313kN;
        this.f4313kN = i2 - 1;
        if (i2 <= 0) {
            this.f4313kN = mo3646aS();
            level.playSeededSound((Player) null, this, mo3645a(), SoundSource.HOSTILE, 3.0f, 1.0f, 0L);
        }
        int i3 = this.f4315ab;
        this.f4315ab = i3 - 1;
        if (i3 <= 0) {
            this.f4315ab = 10;
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
            return this.f4312c.test(livingEntity);
        }
        return false;
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
