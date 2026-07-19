package com.boehmod.blockfront;

import com.boehmod.blockfront.mP;
import foundry.veil.impl.client.render.shader.injection.util.ShaderInjectionDefinition;
import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mE.class */
public class mE extends C0350mz {
    private static final int kQ = 10;
    private static final int kR = 80;
    private static final double ah = 4.0d;
    private static final float ix = 0.8f;
    private static final float iy = 0.5f;
    private static final float iz = 0.4f;
    private static final float iA = 0.8f;
    private static final double ai = 64.0d;
    private static final float iB = 1.0f;
    private static final float iC = 4.0f;

    @NotNull
    private static final EntityDataAccessor<String> e;

    @NotNull
    private static final EntityDataAccessor<Boolean> f;

    @NotNull
    private static final EntityDataAccessor<Integer> g;

    @NotNull
    private static final EntityDataAccessor<Integer> h;

    @NotNull
    private static final EntityDataAccessor<Integer> i;

    @NotNull
    private static final EntityDataAccessor<Boolean> j;

    @NotNull
    private static final EntityDataAccessor<String> k;

    @NotNull
    private static final EntityDataAccessor<ItemStack> l;

    @NotNull
    private static final EntityDataAccessor<ItemStack> m;

    @NotNull
    private static final EntityDataAccessor<Integer> n;

    @NotNull
    private static final EntityDataAccessor<Boolean> o;

    @NotNull
    private static final EntityDataAccessor<BlockPos> p;

    @NotNull
    private static final EntityDataAccessor<Integer> q;

    @NotNull
    private static final EntityDataAccessor<Float> r;

    @NotNull
    public final Map<LivingEntity, mP.a> I;
    private final int kS;
    private final float iD;
    public boolean eA;
    public boolean eB;
    public float iE;
    public float iF;
    public boolean eC;
    public int kT;
    private int kU;

    @Nullable
    private AbstractSoundInstance a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private SimpleSoundInstance f238a;

    @Nullable
    private AbstractSoundInstance b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final mF f239a;

    @Nullable
    private ResourceLocation ds;

    @Nullable
    private oO c;
    private boolean eD;
    private int kV;
    private int kW;
    private int kX;
    private int kY;
    private int kZ;
    private boolean eE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    private fW<mE> f240a;
    private int la;
    private int lb;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private sU f241a;

    @Nullable
    private ResourceLocation dt;

    @Nullable
    private ResourceLocation du;
    private static final double aj = 64.0d;
    private double ak;
    private static final double al = 3.0d;
    static final /* synthetic */ boolean eF;

    static {
        eF = !mE.class.desiredAssertionStatus();
        e = SynchedEntityData.defineId(mE.class, EntityDataSerializers.STRING);
        f = SynchedEntityData.defineId(mE.class, EntityDataSerializers.BOOLEAN);
        g = SynchedEntityData.defineId(mE.class, EntityDataSerializers.INT);
        h = SynchedEntityData.defineId(mE.class, EntityDataSerializers.INT);
        i = SynchedEntityData.defineId(mE.class, EntityDataSerializers.INT);
        j = SynchedEntityData.defineId(mE.class, EntityDataSerializers.BOOLEAN);
        k = SynchedEntityData.defineId(mE.class, EntityDataSerializers.STRING);
        l = SynchedEntityData.defineId(mE.class, EntityDataSerializers.ITEM_STACK);
        m = SynchedEntityData.defineId(mE.class, EntityDataSerializers.ITEM_STACK);
        n = SynchedEntityData.defineId(mE.class, EntityDataSerializers.INT);
        o = SynchedEntityData.defineId(mE.class, EntityDataSerializers.BOOLEAN);
        p = SynchedEntityData.defineId(mE.class, EntityDataSerializers.BLOCK_POS);
        q = SynchedEntityData.defineId(mE.class, EntityDataSerializers.INT);
        r = SynchedEntityData.defineId(mE.class, EntityDataSerializers.FLOAT);
    }

    public mE(@NotNull EntityType<? extends mE> entityType, @NotNull Level level) {
        super(entityType, level);
        this.I = new Object2ObjectOpenHashMap();
        this.kS = ThreadLocalRandom.current().nextInt(5);
        this.iD = 1.0f - ((float) (0.10000000149011612d * Math.random()));
        this.eA = false;
        this.eB = false;
        this.iF = 0.0f;
        this.eC = false;
        this.kT = 0;
        this.kU = 0;
        this.f239a = new mF(this);
        this.ds = null;
        this.eD = false;
        this.kV = (int) (40.0d + (300.0d * Math.random()));
        this.kW = C0163g.g;
        this.kX = 0;
        this.kY = 0;
        this.kZ = 0;
        this.eE = false;
        this.la = 0;
        this.lb = 0;
        this.f241a = null;
        this.dt = null;
        this.du = null;
        this.ak = 64.0d;
    }

    public static AttributeSupplier.Builder a() {
        return Mob.createMobAttributes().add(Attributes.FOLLOW_RANGE, 32.0d).add(Attributes.ATTACK_DAMAGE, 0.5d).add(Attributes.MOVEMENT_SPEED, 0.6d).add(Attributes.MAX_HEALTH, 16.0d);
    }

    @NotNull
    protected PathNavigation createNavigation(@NotNull Level level) {
        GroundPathNavigation groundPathNavigation = new GroundPathNavigation(this, level);
        groundPathNavigation.setCanFloat(true);
        groundPathNavigation.setCanOpenDoors(true);
        groundPathNavigation.setMaxVisitedNodesMultiplier(10.0f);
        return groundPathNavigation;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public AbstractSoundInstance m668a() {
        return this.a;
    }

    public void a(@NotNull AbstractSoundInstance abstractSoundInstance) {
        this.a = abstractSoundInstance;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public SimpleSoundInstance m669a() {
        return this.f238a;
    }

    public void a(@NotNull SimpleSoundInstance simpleSoundInstance) {
        this.f238a = simpleSoundInstance;
    }

    public void b(@NotNull AbstractSoundInstance abstractSoundInstance) {
        this.b = abstractSoundInstance;
    }

    @OnlyIn(Dist.CLIENT)
    public void bx() {
        if (this.b == null) {
            return;
        }
        Minecraft.getInstance().getSoundManager().stop(this.b);
        this.b = null;
    }

    public int au() {
        return this.kS;
    }

    public boolean aE() {
        return this.f239a.aE();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Pair<Vec3, Double> m670a() {
        Vec3 vec3K = this.f239a.k();
        if (vec3K != null) {
            return Pair.of(vec3K, Double.valueOf(this.f239a.o()));
        }
        return null;
    }

    public void a(@NotNull Vec3 vec3, double d, float f2, float f3) {
        double x = vec3.x - getX();
        double z = vec3.z - getZ();
        double eyeY = d - getEyeY();
        double dSqrt = Math.sqrt((x * x) + (z * z));
        float fAtan2 = ((float) ((Mth.atan2(z, x) * 180.0d) / 3.1415927410125732d)) - 90.0f;
        setXRot(b(getXRot(), (float) (-((Mth.atan2(eyeY, dSqrt) * 180.0d) / 3.1415927410125732d)), f3));
        setYRot(b(getYRot(), fAtan2, f2));
    }

    private float b(float f2, float f3, float f4) {
        float fWrapDegrees = Mth.wrapDegrees(f3 - f2);
        if (fWrapDegrees > f4) {
            fWrapDegrees = f4;
        }
        if (fWrapDegrees < (-f4)) {
            fWrapDegrees = -f4;
        }
        return f2 + fWrapDegrees;
    }

    public void handleEntityEvent(byte b) {
        if (b != 60) {
            super.handleEntityEvent(b);
        }
    }

    @Override // com.boehmod.blockfront.C0350mz
    public void baseTick() {
        super.baseTick();
        Level level = level();
        bE();
        if (level.isClientSide()) {
            bB();
            return;
        }
        LivingEntity target = getTarget();
        if (target != null && !canAttack(target)) {
            setTarget(null);
            this.f239a.bf();
        }
        this.f239a.a(this.random);
        by();
        double dT = this.a != null ? this.a.m767a().t() : -1.0d;
        this.ak = dT > 0.0d ? Math.min(64.0d, dT) : 64.0d;
        int i2 = this.la + 1;
        this.la = i2;
        if (i2 >= 10) {
            this.la = 0;
            bz();
        }
        if (this.kV > 0) {
            this.kV--;
        }
        if (this.kW > 0) {
            this.kW--;
        }
        if (this.kX > 0) {
            this.kX--;
        }
        int i3 = this.lb + 1;
        this.lb = i3;
        if (i3 >= 80) {
            this.lb = 0;
            bA();
        }
        p(0);
        r(Math.max(0, ay() - 1));
        if (this.kU > 0) {
            this.kU--;
            if (this.kU == 0) {
                s(0);
            }
        }
        if (this.c != null && !E().equals(this.c.getName())) {
            s(this.c.getName());
        }
    }

    private void by() {
        if (this.eC) {
            int i2 = this.kT;
            this.kT = i2 - 1;
            if (i2 <= 0) {
                this.eC = false;
                if (this.a != null && this.c != null) {
                    InterfaceC0466rg.a(this.a, this.c.a(this.a), this, getUUID());
                    s(60);
                }
            }
        }
    }

    private void bz() {
        Iterator<Map.Entry<LivingEntity, mP.a>> it = this.I.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<LivingEntity, mP.a> next = it.next();
            LivingEntity key = next.getKey();
            mP.a value = next.getValue();
            if (key == null || !key.isAlive()) {
                it.remove();
            } else {
                if (oR.b((LivingEntity) this, key, distanceTo(key) < 16.0f ? C0163g.g : 90) && hasLineOfSight(key)) {
                    value.bN();
                    value.bL();
                } else {
                    value.bM();
                }
                if (value.aK()) {
                    it.remove();
                }
            }
        }
        float f2 = 0.0f;
        Iterator<mP.a> it2 = this.I.values().iterator();
        while (it2.hasNext()) {
            float fAA = it2.next().aA() / 2.0f;
            if (fAA > f2) {
                f2 = fAA;
            }
        }
        i(f2);
    }

    private void bA() {
        if (isAlive()) {
            if (level().getEntitiesOfClass(C0374nw.class, getBoundingBox().inflate(ah), (v0) -> {
                return v0.aO();
            }).isEmpty()) {
                return;
            }
            a((Holder<SoundEvent>) C0624xc.GN, SoundSource.HOSTILE, this.iD, 1.0f);
        }
    }

    public boolean hasLineOfSight(@NotNull Entity entity) {
        Level level = level();
        if (entity.level() != level) {
            return false;
        }
        Vec3 vec3 = new Vec3(getX(), getEyeY(), getZ());
        Vec3 vec32 = new Vec3(entity.getX(), entity.getEyeY(), entity.getZ());
        return (vec32.distanceTo(vec3) > this.ak || ((Boolean) BlockGetter.traverseBlocks(vec3, vec32, new ClipContext(vec3, vec32, ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, this), (clipContext, blockPos) -> {
            BlockState blockState = level.getBlockState(blockPos);
            if (blockState.isAir()) {
                return null;
            }
            C0563uw c0563uw = C0563uw.ak.get(blockState.getBlock());
            if (c0563uw == null) {
                c0563uw = C0563uw.al.get(blockState.getSoundType(level, blockPos, this));
            }
            if (c0563uw != null && c0563uw.cF()) {
                return null;
            }
            if (level.clipWithInteractionOverride(clipContext.getFrom(), clipContext.getTo(), blockPos, clipContext.getBlockShape(blockState, level, blockPos), blockState) != null) {
                return Boolean.TRUE;
            }
            return null;
        }, clipContext2 -> {
            return Boolean.FALSE;
        })).booleanValue() || a(level, vec3, vec32)) ? false : true;
    }

    private boolean a(@NotNull Level level, @NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Iterator it = level.getEntitiesOfClass(C0374nw.class, new AABB(vec3, vec32).inflate(al), (v0) -> {
            return v0.aO();
        }).iterator();
        while (it.hasNext()) {
            AABB aabbH = ((C0374nw) it.next()).h();
            if (aabbH.contains(vec3) || aabbH.contains(vec32) || aabbH.clip(vec3, vec32).isPresent()) {
                return true;
            }
        }
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    private void bB() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (this.kY > 0) {
            this.kY--;
        }
        if (az() > 0) {
            int i2 = this.kZ;
            this.kZ = i2 + 1;
            if (i2 >= (((double) threadLocalRandomCurrent.nextFloat()) < 0.5d ? 2 : 3)) {
                this.kZ = 0;
                this.eE = !this.eE;
            }
        }
        if (threadLocalRandomCurrent.nextFloat() < (this.eB ? 0.05f : 0.02f)) {
            bI();
            if (!this.eB) {
                this.eA = !this.eA;
                if (threadLocalRandomCurrent.nextFloat() < 0.5d) {
                    this.eB = true;
                }
            } else {
                this.eB = false;
            }
        }
        float f2 = this.eB ? this.eA ? -1.0f : 1.0f : 0.0f;
        this.iF = this.iE;
        this.iE = Mth.lerp(0.2f, this.iE, f2);
        bC();
    }

    @OnlyIn(Dist.CLIENT)
    private void bC() {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        if (this.f240a == null) {
            this.f240a = new fW<>();
        }
        this.f240a.a(false, localPlayer, this);
    }

    @OnlyIn(Dist.CLIENT)
    public void bD() {
        if (this.f240a != null) {
            this.f240a.aI();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public boolean N() {
        return this.f240a == null || this.f240a.O();
    }

    private void bE() {
        setItemInHand(InteractionHand.MAIN_HAND, b());
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(e, "").define(k, "Bot").define(f, false).define(j, false).define(g, 0).define(h, 0).define(i, 0).define(l, ItemStack.EMPTY).define(m, ItemStack.EMPTY).define(n, Integer.valueOf(sV.c().bN())).define(o, Boolean.valueOf(Math.random() < 0.5d)).define(q, Integer.valueOf(mG.CAUCASIAN.ordinal())).define(r, Float.valueOf(0.0f)).define(p, new BlockPos(0, 0, 0));
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(0, new mI(this, 4.0f));
        this.goalSelector.addGoal(0, new mJ(this, 8.0f));
        this.goalSelector.addGoal(1, new mL(this, 0.4f, 16.0f, 8.0f));
        this.goalSelector.addGoal(2, new mM(this));
        this.goalSelector.addGoal(3, new mN(this));
        this.goalSelector.addGoal(4, new mO(this, 0.5d));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, mE.class, true));
    }

    public boolean canAttack(LivingEntity livingEntity) {
        oO oOVarA;
        nD nDVarA;
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!eF && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (!livingEntity.isAlive() || livingEntity.tickCount <= 40) {
            return false;
        }
        if (livingEntity instanceof mE) {
            oO oOVarM671a = ((mE) livingEntity).m671a();
            return (oOVarM671a == null || oOVarM671a.equals(m671a())) ? false : true;
        }
        if (livingEntity instanceof Player) {
            Entity entity = (Player) livingEntity;
            if (entity.isCreative()) {
                return false;
            }
            com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
            UUID uuid = entity.getUUID();
            com.boehmod.blockfront.common.player.b bVarM305a = cVarM531a.m305a((Player) entity);
            Entity vehicle = entity.getVehicle();
            if (((vehicle instanceof AbstractC0376ny) && (nDVarA = ((AbstractC0376ny) vehicle).a(entity)) != null && (nDVarA.fq || nDVarA.fp)) || oR.a((Player) entity, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) bVarM305a)) {
                return false;
            }
            if (this.a != null && this.a.b().g(uuid)) {
                return false;
            }
            oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
            return oFVarMo604a == null || oFVarMo604a != this.a || (oOVarA = oFVarMo604a.b().a(uuid)) == null || !oOVarA.equals(m671a());
        }
        return false;
    }

    public void die(@NotNull DamageSource damageSource) {
        super.die(damageSource);
        Level level = level();
        a(damageSource.is(DamageTypeTags.IS_EXPLOSION) ? C0624xc.GG : this.random.nextInt(ShaderInjectionDefinition.DEFAULT_PRIORITY) == 0 ? C0624xc.GH : C0624xc.GF, SoundSource.HOSTILE, this.iD, 4.0f, 6);
        for (mE mEVar : level.getEntitiesOfClass(mE.class, getBoundingBox().inflate(8.0d, 1.0d, 8.0d))) {
            if (mEVar != null && !mEVar.equals(this) && mEVar.E().equals(E()) && this.random.nextFloat() < 0.2f) {
                mEVar.bH();
            }
        }
    }

    public boolean hurt(@NotNull DamageSource damageSource, float f2) {
        if (damageSource instanceof lZ) {
            bG();
            mE entity = ((lZ) damageSource).getEntity();
            if (entity instanceof mE) {
                mE mEVar = entity;
                mEVar.c().ifPresent(sUVar -> {
                    mEVar.a(sUVar.i());
                });
            }
        }
        return super.hurt(damageSource, f2);
    }

    @NotNull
    public String getScoreboardName() {
        return F();
    }

    public void a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        if (deferredHolder == null) {
            return;
        }
        int i2 = 30;
        if (((SoundEvent) deferredHolder.get()).toString().contains("bot.go")) {
            if (this.kW > 0) {
                return;
            } else {
                i2 = 15;
            }
        }
        this.kW = (int) (40.0d + (300.0d * Math.random()));
        if (this.kV > 0) {
            return;
        }
        this.kV = 40;
        if (this.a != null) {
            a((Holder<SoundEvent>) deferredHolder, SoundSource.HOSTILE, this.iD, 1.0f);
        }
        s(i2);
    }

    public void e(@Nullable Vec3 vec3) {
        if ((vec3 != null && position().distanceToSqr(vec3) <= 64.0d) && this.random.nextFloat() < 0.8f) {
            a(C0624xc.GO);
        } else {
            c().ifPresent(sUVar -> {
                a(sUVar.h());
            });
        }
    }

    public void bF() {
        if (this.random.nextFloat() < 0.4f) {
            a(C0624xc.GQ);
        } else {
            c().ifPresent(sUVar -> {
                a(sUVar.e());
            });
        }
    }

    public void bG() {
        if (this.random.nextFloat() < 0.8f) {
            b(C0624xc.GP);
        } else {
            c().ifPresent(sUVar -> {
                b(sUVar.f());
            });
        }
    }

    public void bH() {
        if (this.random.nextFloat() < 0.5f) {
            a(C0624xc.GO);
        } else {
            c().ifPresent(sUVar -> {
                a(sUVar.f());
            });
        }
    }

    public void b(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        a(deferredHolder, 0);
    }

    public void a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, int i2) {
        if (deferredHolder == null || this.a == null || this.kX > 0) {
            return;
        }
        this.kX = 15;
        this.kV = 40;
        a(deferredHolder, SoundSource.HOSTILE, this.iD, 1.0f, 1 | i2);
        s(30);
    }

    public void a(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, float f2, float f3) {
        a(holder, soundSource, f2, f3, 0);
    }

    public void a(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, float f2, float f3, int i2) {
        if (this.a == null) {
            return;
        }
        C0582vo.a(new C0587vt(holder, soundSource, getId(), f2, f3, i2), this.a);
    }

    public void bI() {
        this.kY = 4;
    }

    public int av() {
        return this.kY;
    }

    @Override // com.boehmod.blockfront.C0350mz
    public void b(@NotNull ServerLevel serverLevel) {
        super.b(serverLevel);
        Object obj = this.a;
        if (obj instanceof qL) {
            ((qL) obj).a(this);
        }
    }

    @Override // com.boehmod.blockfront.C0350mz
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putString("name", F());
        ItemStack itemStackB = b();
        compoundTag.putBoolean("hasPrimary", !itemStackB.isEmpty());
        if (!itemStackB.isEmpty()) {
            compoundTag.put("primary", itemStackB.save(registryAccess(), new CompoundTag()));
        }
        compoundTag.putInt("class", m673b().bN());
        compoundTag.putBoolean("respawn", this.eD);
        compoundTag.putString("team", E());
    }

    @Override // com.boehmod.blockfront.C0350mz
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        oO oOVarA;
        super.readAdditionalSaveData(compoundTag);
        t(compoundTag.getString("name"));
        if (compoundTag.getBoolean("hasPrimary")) {
            d(ItemStack.parseOptional(registryAccess(), compoundTag.getCompound("primary")));
        }
        a(sV.a(compoundTag.getInt("class")));
        this.eD = compoundTag.getBoolean("respawn");
        s(compoundTag.getString("team"));
        if (this.a == null || (oOVarA = this.a.b().a(E())) == null) {
            return;
        }
        a(this.a, oOVarA);
    }

    @Nullable
    public ResourceLocation a(@NotNull oF<?, ?, ?> oFVar) {
        if (this.dt != null) {
            return this.dt;
        }
        this.dt = a(oFVar, m673b().getKey());
        return this.dt;
    }

    @Nullable
    public ResourceLocation b(@NotNull oF<?, ?, ?> oFVar) {
        if (this.du != null) {
            return this.du;
        }
        this.du = a(oFVar, fT.Y);
        return this.du;
    }

    @Nullable
    private ResourceLocation a(@NotNull oF<?, ?, ?> oFVar, @NotNull String str) {
        oO oOVarA = oFVar.b().a(E());
        if (oOVarA == null) {
            return null;
        }
        C0514ta c0514taA = oOVarA.a(oFVar);
        return C0265jv.d("textures/skins/game/nations/" + c0514taA.m1156a().ao() + "/" + c0514taA.getSkin() + "/" + str + ".png");
    }

    public ResourceLocation s() {
        if (this.ds == null) {
            this.ds = C0265jv.d("textures/models/entities/bot/" + mG.values()[ax()].getSkin() + "/" + au() + ".png");
        }
        return this.ds;
    }

    public boolean aF() {
        return this.eE;
    }

    public String getSkin() {
        return "default";
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public oO m671a() {
        return this.c;
    }

    public boolean d(@NotNull Player player) {
        oO oOVarA;
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!eF && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        UUID uuid = player.getUUID();
        oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
        return (oFVarMo604a == null || (oOVarA = oFVarMo604a.b().a(uuid)) == null || !oOVarA.getName().equalsIgnoreCase(E())) ? false : true;
    }

    public void a(@NotNull oF<?, ?, ?> oFVar, @NotNull oO oOVar) {
        this.c = oOVar;
        this.f241a = (oOVar.bq() ? oFVar.m756b().m1156a() : oFVar.m755a().m1156a()).a();
    }

    /* JADX INFO: renamed from: au, reason: collision with other method in class */
    public final float m672au() {
        return ((Float) this.entityData.get(r)).floatValue();
    }

    public void i(float f2) {
        this.entityData.set(r, Float.valueOf(f2));
    }

    public ItemStack b() {
        return (ItemStack) this.entityData.get(l);
    }

    public void d(ItemStack itemStack) {
        this.entityData.set(l, itemStack);
    }

    public String E() {
        return (String) this.entityData.get(e);
    }

    public void s(String str) {
        this.entityData.set(e, str);
    }

    public String F() {
        return (String) this.entityData.get(k);
    }

    public void t(String str) {
        this.entityData.set(k, str);
    }

    public int aw() {
        return ((Integer) this.entityData.get(g)).intValue();
    }

    public void p(int i2) {
        this.entityData.set(g, Integer.valueOf(i2));
    }

    public int ax() {
        return ((Integer) this.entityData.get(q)).intValue();
    }

    public void q(int i2) {
        this.entityData.set(q, Integer.valueOf(i2));
    }

    public int ay() {
        return ((Integer) this.entityData.get(h)).intValue();
    }

    public void r(int i2) {
        this.entityData.set(h, Integer.valueOf(i2));
    }

    public boolean aG() {
        return ay() > 0;
    }

    public int az() {
        return ((Integer) this.entityData.get(i)).intValue();
    }

    public void s(int i2) {
        this.kU = i2;
        this.entityData.set(i, Integer.valueOf(i2));
    }

    public boolean aH() {
        return ((Boolean) this.entityData.get(f)).booleanValue();
    }

    public void D(boolean z) {
        this.entityData.set(f, Boolean.valueOf(z));
    }

    public boolean aI() {
        return ((Boolean) this.entityData.get(j)).booleanValue();
    }

    public void E(boolean z) {
        this.entityData.set(j, Boolean.valueOf(z));
    }

    public void F(boolean z) {
        this.eD = z;
    }

    public boolean aJ() {
        return this.eD;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public sV m673b() {
        return sV.a(((Integer) this.entityData.get(n)).intValue());
    }

    public void a(@NotNull sV sVVar) {
        this.entityData.set(n, Integer.valueOf(sVVar.bN()));
    }

    public boolean L() {
        return ((Boolean) this.entityData.get(o)).booleanValue();
    }

    public void b(BlockPos blockPos) {
        if (!((BlockPos) this.entityData.get(p)).equals(blockPos)) {
            this.entityData.set(p, blockPos);
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public BlockPos m674b() {
        return (BlockPos) this.entityData.get(p);
    }

    public Optional<sU> c() {
        return Optional.ofNullable(this.f241a);
    }

    public void knockback(double d, double d2, double d3) {
    }

    public void t(int i2) {
        this.eC = true;
        this.kT = i2;
    }
}
