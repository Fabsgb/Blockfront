package com.boehmod.blockfront;

import com.boehmod.blockfront.C0691mP;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.mE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mE.class */
public class C0680mE extends C0727mz {

    /* JADX INFO: renamed from: kQ */
    private static final int f3627kQ = 10;

    /* JADX INFO: renamed from: kR */
    private static final int f3628kR = 80;

    /* JADX INFO: renamed from: ah */
    private static final double f3629ah = 4.0d;

    /* JADX INFO: renamed from: ix */
    private static final float f3630ix = 0.8f;

    /* JADX INFO: renamed from: iy */
    private static final float f3631iy = 0.5f;

    /* JADX INFO: renamed from: iz */
    private static final float f3632iz = 0.4f;

    /* JADX INFO: renamed from: iA */
    private static final float f3633iA = 0.8f;

    /* JADX INFO: renamed from: ai */
    private static final double f3634ai = 64.0d;

    /* JADX INFO: renamed from: iB */
    private static final float f3635iB = 1.0f;

    /* JADX INFO: renamed from: iC */
    private static final float f3636iC = 4.0f;

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final EntityDataAccessor<String> f3637e;

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final EntityDataAccessor<Boolean> f3638f;

    /* JADX INFO: renamed from: g */
    @NotNull
    private static final EntityDataAccessor<Integer> f3639g;

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final EntityDataAccessor<Integer> f3640h;

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final EntityDataAccessor<Integer> f3641i;

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final EntityDataAccessor<Boolean> f3642j;

    /* JADX INFO: renamed from: k */
    @NotNull
    private static final EntityDataAccessor<String> f3643k;

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final EntityDataAccessor<ItemStack> f3644l;

    /* JADX INFO: renamed from: m */
    @NotNull
    private static final EntityDataAccessor<ItemStack> f3645m;

    /* JADX INFO: renamed from: n */
    @NotNull
    private static final EntityDataAccessor<Integer> f3646n;

    /* JADX INFO: renamed from: o */
    @NotNull
    private static final EntityDataAccessor<Boolean> f3647o;

    /* JADX INFO: renamed from: p */
    @NotNull
    private static final EntityDataAccessor<BlockPos> f3648p;

    /* JADX INFO: renamed from: q */
    @NotNull
    private static final EntityDataAccessor<Integer> f3649q;

    /* JADX INFO: renamed from: r */
    @NotNull
    private static final EntityDataAccessor<Float> f3650r;

    /* JADX INFO: renamed from: I */
    @NotNull
    public final Map<LivingEntity, C0691mP.a> f3651I;

    /* JADX INFO: renamed from: kS */
    private final int f3652kS;

    /* JADX INFO: renamed from: iD */
    private final float f3653iD;

    /* JADX INFO: renamed from: eA */
    public boolean f3654eA;

    /* JADX INFO: renamed from: eB */
    public boolean f3655eB;

    /* JADX INFO: renamed from: iE */
    public float f3656iE;

    /* JADX INFO: renamed from: iF */
    public float f3657iF;

    /* JADX INFO: renamed from: eC */
    public boolean f3658eC;

    /* JADX INFO: renamed from: kT */
    public int f3659kT;

    /* JADX INFO: renamed from: kU */
    private int f3660kU;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractSoundInstance f3661a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private SimpleSoundInstance f3662a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private AbstractSoundInstance f3663b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0681mF f3664a;

    /* JADX INFO: renamed from: ds */
    @Nullable
    private ResourceLocation f3665ds;

    /* JADX INFO: renamed from: c */
    @Nullable
    private C0796oO f3666c;

    /* JADX INFO: renamed from: eD */
    private boolean f3667eD;

    /* JADX INFO: renamed from: kV */
    private int f3668kV;

    /* JADX INFO: renamed from: kW */
    private int f3669kW;

    /* JADX INFO: renamed from: kX */
    private int f3670kX;

    /* JADX INFO: renamed from: kY */
    private int f3671kY;

    /* JADX INFO: renamed from: kZ */
    private int f3672kZ;

    /* JADX INFO: renamed from: eE */
    private boolean f3673eE;

    /* JADX INFO: renamed from: a */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    private C0327fW<C0680mE> f3674a;

    /* JADX INFO: renamed from: la */
    private int f3675la;

    /* JADX INFO: renamed from: lb */
    private int f3676lb;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C1014sU f3677a;

    /* JADX INFO: renamed from: dt */
    @Nullable
    private ResourceLocation f3678dt;

    /* JADX INFO: renamed from: du */
    @Nullable
    private ResourceLocation f3679du;

    /* JADX INFO: renamed from: aj */
    private static final double f3680aj = 64.0d;

    /* JADX INFO: renamed from: ak */
    private double f3681ak;

    /* JADX INFO: renamed from: al */
    private static final double f3682al = 3.0d;

    /* JADX INFO: renamed from: eF */
    static final /* synthetic */ boolean f3683eF;

    static {
        f3683eF = !C0680mE.class.desiredAssertionStatus();
        f3637e = SynchedEntityData.defineId(C0680mE.class, EntityDataSerializers.STRING);
        f3638f = SynchedEntityData.defineId(C0680mE.class, EntityDataSerializers.BOOLEAN);
        f3639g = SynchedEntityData.defineId(C0680mE.class, EntityDataSerializers.INT);
        f3640h = SynchedEntityData.defineId(C0680mE.class, EntityDataSerializers.INT);
        f3641i = SynchedEntityData.defineId(C0680mE.class, EntityDataSerializers.INT);
        f3642j = SynchedEntityData.defineId(C0680mE.class, EntityDataSerializers.BOOLEAN);
        f3643k = SynchedEntityData.defineId(C0680mE.class, EntityDataSerializers.STRING);
        f3644l = SynchedEntityData.defineId(C0680mE.class, EntityDataSerializers.ITEM_STACK);
        f3645m = SynchedEntityData.defineId(C0680mE.class, EntityDataSerializers.ITEM_STACK);
        f3646n = SynchedEntityData.defineId(C0680mE.class, EntityDataSerializers.INT);
        f3647o = SynchedEntityData.defineId(C0680mE.class, EntityDataSerializers.BOOLEAN);
        f3648p = SynchedEntityData.defineId(C0680mE.class, EntityDataSerializers.BLOCK_POS);
        f3649q = SynchedEntityData.defineId(C0680mE.class, EntityDataSerializers.INT);
        f3650r = SynchedEntityData.defineId(C0680mE.class, EntityDataSerializers.FLOAT);
    }

    public C0680mE(@NotNull EntityType<? extends C0680mE> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f3651I = new Object2ObjectOpenHashMap();
        this.f3652kS = ThreadLocalRandom.current().nextInt(5);
        this.f3653iD = 1.0f - ((float) (0.10000000149011612d * Math.random()));
        this.f3654eA = false;
        this.f3655eB = false;
        this.f3657iF = 0.0f;
        this.f3658eC = false;
        this.f3659kT = 0;
        this.f3660kU = 0;
        this.f3664a = new C0681mF(this);
        this.f3665ds = null;
        this.f3667eD = false;
        this.f3668kV = (int) (40.0d + (300.0d * Math.random()));
        this.f3669kW = C0357g.f2439g;
        this.f3670kX = 0;
        this.f3671kY = 0;
        this.f3672kZ = 0;
        this.f3673eE = false;
        this.f3675la = 0;
        this.f3676lb = 0;
        this.f3677a = null;
        this.f3678dt = null;
        this.f3679du = null;
        this.f3681ak = 64.0d;
    }

    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3008a() {
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
    /* JADX INFO: renamed from: a */
    public AbstractSoundInstance m3009a() {
        return this.f3661a;
    }

    /* JADX INFO: renamed from: a */
    public void m3010a(@NotNull AbstractSoundInstance abstractSoundInstance) {
        this.f3661a = abstractSoundInstance;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public SimpleSoundInstance m3011a() {
        return this.f3662a;
    }

    /* JADX INFO: renamed from: a */
    public void m3012a(@NotNull SimpleSoundInstance simpleSoundInstance) {
        this.f3662a = simpleSoundInstance;
    }

    /* JADX INFO: renamed from: b */
    public void m3013b(@NotNull AbstractSoundInstance abstractSoundInstance) {
        this.f3663b = abstractSoundInstance;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: bx */
    public void m3014bx() {
        if (this.f3663b == null) {
            return;
        }
        Minecraft.getInstance().getSoundManager().stop(this.f3663b);
        this.f3663b = null;
    }

    /* JADX INFO: renamed from: au */
    public int m3015au() {
        return this.f3652kS;
    }

    /* JADX INFO: renamed from: aE */
    public boolean m3016aE() {
        return this.f3664a.m3089aE();
    }

    /* JADX INFO: renamed from: a */
    public Pair<Vec3, Double> m3017a() {
        Vec3 vec3M3087k = this.f3664a.m3087k();
        if (vec3M3087k != null) {
            return Pair.of(vec3M3087k, Double.valueOf(this.f3664a.m3088o()));
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m3018a(@NotNull Vec3 vec3, double d, float f, float f2) {
        double x = vec3.x - getX();
        double z = vec3.z - getZ();
        double eyeY = d - getEyeY();
        double dSqrt = Math.sqrt((x * x) + (z * z));
        float fAtan2 = ((float) ((Mth.atan2(z, x) * 180.0d) / 3.1415927410125732d)) - 90.0f;
        setXRot(m3019b(getXRot(), (float) (-((Mth.atan2(eyeY, dSqrt) * 180.0d) / 3.1415927410125732d)), f2));
        setYRot(m3019b(getYRot(), fAtan2, f));
    }

    /* JADX INFO: renamed from: b */
    private float m3019b(float f, float f2, float f3) {
        float fWrapDegrees = Mth.wrapDegrees(f2 - f);
        if (fWrapDegrees > f3) {
            fWrapDegrees = f3;
        }
        if (fWrapDegrees < (-f3)) {
            fWrapDegrees = -f3;
        }
        return f + fWrapDegrees;
    }

    public void handleEntityEvent(byte b) {
        if (b != 60) {
            super.handleEntityEvent(b);
        }
    }

    @Override // com.boehmod.blockfront.C0727mz
    public void baseTick() {
        super.baseTick();
        Level level = level();
        m3028bE();
        if (level.isClientSide()) {
            m3024bB();
            return;
        }
        LivingEntity target = getTarget();
        if (target != null && !canAttack(target)) {
            setTarget(null);
            this.f3664a.m3090bf();
        }
        this.f3664a.m3086a(this.random);
        m3020by();
        double dM5592t = this.f3896a != null ? this.f3896a.m3653a().m5592t() : -1.0d;
        this.f3681ak = dM5592t > 0.0d ? Math.min(64.0d, dM5592t) : 64.0d;
        int i = this.f3675la + 1;
        this.f3675la = i;
        if (i >= 10) {
            this.f3675la = 0;
            m3021bz();
        }
        if (this.f3668kV > 0) {
            this.f3668kV--;
        }
        if (this.f3669kW > 0) {
            this.f3669kW--;
        }
        if (this.f3670kX > 0) {
            this.f3670kX--;
        }
        int i2 = this.f3676lb + 1;
        this.f3676lb = i2;
        if (i2 >= 80) {
            this.f3676lb = 0;
            m3022bA();
        }
        m3058p(0);
        m3062r(Math.max(0, m3061ay() - 1));
        if (this.f3660kU > 0) {
            this.f3660kU--;
            if (this.f3660kU == 0) {
                m3065s(0);
            }
        }
        if (this.f3666c != null && !m3053E().equals(this.f3666c.getName())) {
            m3054s(this.f3666c.getName());
        }
    }

    /* JADX INFO: renamed from: by */
    private void m3020by() {
        if (this.f3658eC) {
            int i = this.f3659kT;
            this.f3659kT = i - 1;
            if (i <= 0) {
                this.f3658eC = false;
                if (this.f3896a != null && this.f3666c != null) {
                    InterfaceC0973rg.m5310a(this.f3896a, this.f3666c.m3860a(this.f3896a), this, getUUID());
                    m3065s(60);
                }
            }
        }
    }

    /* JADX INFO: renamed from: bz */
    private void m3021bz() {
        Iterator<Map.Entry<LivingEntity, C0691mP.a>> it = this.f3651I.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<LivingEntity, C0691mP.a> next = it.next();
            LivingEntity key = next.getKey();
            C0691mP.a value = next.getValue();
            if (key == null || !key.isAlive()) {
                it.remove();
            } else {
                if (C0799oR.m4047b((LivingEntity) this, key, distanceTo(key) < 16.0f ? C0357g.f2439g : 90) && hasLineOfSight(key)) {
                    value.m3113bN();
                    value.m3111bL();
                } else {
                    value.m3112bM();
                }
                if (value.m3114aK()) {
                    it.remove();
                }
            }
        }
        float f = 0.0f;
        Iterator<C0691mP.a> it2 = this.f3651I.values().iterator();
        while (it2.hasNext()) {
            float fM3110aA = it2.next().m3110aA() / 2.0f;
            if (fM3110aA > f) {
                f = fM3110aA;
            }
        }
        m3050i(f);
    }

    /* JADX INFO: renamed from: bA */
    private void m3022bA() {
        if (isAlive()) {
            if (level().getEntitiesOfClass(C0777nw.class, getBoundingBox().inflate(f3629ah), (v0) -> {
                return v0.m3462aO();
            }).isEmpty()) {
                return;
            }
            m3036a((Holder<SoundEvent>) C1280xc.f8466GN, SoundSource.HOSTILE, this.f3653iD, 1.0f);
        }
    }

    public boolean hasLineOfSight(@NotNull Entity entity) {
        Level level = level();
        if (entity.level() != level) {
            return false;
        }
        Vec3 vec3 = new Vec3(getX(), getEyeY(), getZ());
        Vec3 vec32 = new Vec3(entity.getX(), entity.getEyeY(), entity.getZ());
        return (vec32.distanceTo(vec3) > this.f3681ak || ((Boolean) BlockGetter.traverseBlocks(vec3, vec32, new ClipContext(vec3, vec32, ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, this), (clipContext, blockPos) -> {
            BlockState blockState = level.getBlockState(blockPos);
            if (blockState.isAir()) {
                return null;
            }
            C1149uw c1149uw = C1149uw.f6085ak.get(blockState.getBlock());
            if (c1149uw == null) {
                c1149uw = C1149uw.f6086al.get(blockState.getSoundType(level, blockPos, this));
            }
            if (c1149uw != null && c1149uw.m6444cF()) {
                return null;
            }
            if (level.clipWithInteractionOverride(clipContext.getFrom(), clipContext.getTo(), blockPos, clipContext.getBlockShape(blockState, level, blockPos), blockState) != null) {
                return Boolean.TRUE;
            }
            return null;
        }, clipContext2 -> {
            return Boolean.FALSE;
        })).booleanValue() || m3023a(level, vec3, vec32)) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3023a(@NotNull Level level, @NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Iterator it = level.getEntitiesOfClass(C0777nw.class, new AABB(vec3, vec32).inflate(f3682al), (v0) -> {
            return v0.m3462aO();
        }).iterator();
        while (it.hasNext()) {
            AABB aabbH = ((C0777nw) it.next()).m3463h();
            if (aabbH.contains(vec3) || aabbH.contains(vec32) || aabbH.clip(vec3, vec32).isPresent()) {
                return true;
            }
        }
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: bB */
    private void m3024bB() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (this.f3671kY > 0) {
            this.f3671kY--;
        }
        if (m3064az() > 0) {
            int i = this.f3672kZ;
            this.f3672kZ = i + 1;
            if (i >= (((double) threadLocalRandomCurrent.nextFloat()) < 0.5d ? 2 : 3)) {
                this.f3672kZ = 0;
                this.f3673eE = !this.f3673eE;
            }
        }
        if (threadLocalRandomCurrent.nextFloat() < (this.f3655eB ? 0.05f : 0.02f)) {
            m3038bI();
            if (!this.f3655eB) {
                this.f3654eA = !this.f3654eA;
                if (threadLocalRandomCurrent.nextFloat() < 0.5d) {
                    this.f3655eB = true;
                }
            } else {
                this.f3655eB = false;
            }
        }
        float f = this.f3655eB ? this.f3654eA ? -1.0f : 1.0f : 0.0f;
        this.f3657iF = this.f3656iE;
        this.f3656iE = Mth.lerp(0.2f, this.f3656iE, f);
        m3025bC();
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: bC */
    private void m3025bC() {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        if (this.f3674a == null) {
            this.f3674a = new C0327fW<>();
        }
        this.f3674a.m1677a(false, localPlayer, this);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: bD */
    public void m3026bD() {
        if (this.f3674a != null) {
            this.f3674a.m1678aI();
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: N */
    public boolean m3027N() {
        return this.f3674a == null || this.f3674a.m1679O();
    }

    /* JADX INFO: renamed from: bE */
    private void m3028bE() {
        setItemInHand(InteractionHand.MAIN_HAND, m3051b());
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(f3637e, "").define(f3643k, "Bot").define(f3638f, false).define(f3642j, false).define(f3639g, 0).define(f3640h, 0).define(f3641i, 0).define(f3644l, ItemStack.EMPTY).define(f3645m, ItemStack.EMPTY).define(f3646n, Integer.valueOf(C1015sV.m5514c().m5523bN())).define(f3647o, Boolean.valueOf(Math.random() < 0.5d)).define(f3649q, Integer.valueOf(EnumC0682mG.CAUCASIAN.ordinal())).define(f3650r, Float.valueOf(0.0f)).define(f3648p, new BlockPos(0, 0, 0));
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(0, new C0684mI(this, 4.0f));
        this.goalSelector.addGoal(0, new C0685mJ(this, 8.0f));
        this.goalSelector.addGoal(1, new C0687mL(this, 0.4f, 16.0f, 8.0f));
        this.goalSelector.addGoal(2, new C0688mM(this));
        this.goalSelector.addGoal(3, new C0689mN(this));
        this.goalSelector.addGoal(4, new C0690mO(this, 0.5d));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, C0680mE.class, true));
    }

    public boolean canAttack(LivingEntity livingEntity) {
        C0796oO c0796oOM3793a;
        C0732nD c0732nDM3535a;
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f3683eF && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (!livingEntity.isAlive() || livingEntity.tickCount <= 40) {
            return false;
        }
        if (livingEntity instanceof C0680mE) {
            C0796oO c0796oOM3046a = ((C0680mE) livingEntity).m3046a();
            return (c0796oOM3046a == null || c0796oOM3046a.equals(m3046a())) ? false : true;
        }
        if (livingEntity instanceof Player) {
            Entity entity = (Player) livingEntity;
            if (entity.isCreative()) {
                return false;
            }
            AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
            UUID uuid = entity.getUUID();
            AbstractC0182b abstractC0182bM1136a = abstractC0183cM2528a.m1136a((Player) entity);
            Entity vehicle = entity.getVehicle();
            if (((vehicle instanceof AbstractC0779ny) && (c0732nDM3535a = ((AbstractC0779ny) vehicle).m3535a(entity)) != null && (c0732nDM3535a.f3937fq || c0732nDM3535a.f3936fp)) || C0799oR.m4052a((Player) entity, (AbstractC0182b<?, ?, ?, ?>) abstractC0182bM1136a)) {
                return false;
            }
            if (this.f3896a != null && this.f3896a.m3582b().m3811g(uuid)) {
                return false;
            }
            AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
            return abstractC0787oFMo2531a == null || abstractC0787oFMo2531a != this.f3896a || (c0796oOM3793a = abstractC0787oFMo2531a.m3582b().m3793a(uuid)) == null || !c0796oOM3793a.equals(m3046a());
        }
        return false;
    }

    public void die(@NotNull DamageSource damageSource) {
        super.die(damageSource);
        Level level = level();
        m3037a(damageSource.is(DamageTypeTags.IS_EXPLOSION) ? C1280xc.f8459GG : this.random.nextInt(ShaderInjectionDefinition.DEFAULT_PRIORITY) == 0 ? C1280xc.f8460GH : C1280xc.f8458GF, SoundSource.HOSTILE, this.f3653iD, 4.0f, 6);
        for (C0680mE c0680mE : level.getEntitiesOfClass(C0680mE.class, getBoundingBox().inflate(8.0d, 1.0d, 8.0d))) {
            if (c0680mE != null && !c0680mE.equals(this) && c0680mE.m3053E().equals(m3053E()) && this.random.nextFloat() < 0.2f) {
                c0680mE.m3033bH();
            }
        }
    }

    public boolean hurt(@NotNull DamageSource damageSource, float f) {
        if (damageSource instanceof C0648lZ) {
            m3032bG();
            C0680mE entity = ((C0648lZ) damageSource).getEntity();
            if (entity instanceof C0680mE) {
                C0680mE c0680mE = entity;
                c0680mE.m3077c().ifPresent(c1014sU -> {
                    c0680mE.m3029a(c1014sU.m5508i());
                });
            }
        }
        return super.hurt(damageSource, f);
    }

    @NotNull
    public String getScoreboardName() {
        return m3055F();
    }

    /* JADX INFO: renamed from: a */
    public void m3029a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        if (deferredHolder == null) {
            return;
        }
        int i = 30;
        if (((SoundEvent) deferredHolder.get()).toString().contains("bot.go")) {
            if (this.f3669kW > 0) {
                return;
            } else {
                i = 15;
            }
        }
        this.f3669kW = (int) (40.0d + (300.0d * Math.random()));
        if (this.f3668kV > 0) {
            return;
        }
        this.f3668kV = 40;
        if (this.f3896a != null) {
            m3036a((Holder<SoundEvent>) deferredHolder, SoundSource.HOSTILE, this.f3653iD, 1.0f);
        }
        m3065s(i);
    }

    /* JADX INFO: renamed from: e */
    public void m3030e(@Nullable Vec3 vec3) {
        if ((vec3 != null && position().distanceToSqr(vec3) <= 64.0d) && this.random.nextFloat() < 0.8f) {
            m3029a(C1280xc.f8467GO);
        } else {
            m3077c().ifPresent(c1014sU -> {
                m3029a(c1014sU.m5507h());
            });
        }
    }

    /* JADX INFO: renamed from: bF */
    public void m3031bF() {
        if (this.random.nextFloat() < 0.4f) {
            m3029a(C1280xc.f8469GQ);
        } else {
            m3077c().ifPresent(c1014sU -> {
                m3029a(c1014sU.m5504e());
            });
        }
    }

    /* JADX INFO: renamed from: bG */
    public void m3032bG() {
        if (this.random.nextFloat() < 0.8f) {
            m3034b(C1280xc.f8468GP);
        } else {
            m3077c().ifPresent(c1014sU -> {
                m3034b(c1014sU.m5505f());
            });
        }
    }

    /* JADX INFO: renamed from: bH */
    public void m3033bH() {
        if (this.random.nextFloat() < 0.5f) {
            m3029a(C1280xc.f8467GO);
        } else {
            m3077c().ifPresent(c1014sU -> {
                m3029a(c1014sU.m5505f());
            });
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3034b(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        m3035a(deferredHolder, 0);
    }

    /* JADX INFO: renamed from: a */
    public void m3035a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, int i) {
        if (deferredHolder == null || this.f3896a == null || this.f3670kX > 0) {
            return;
        }
        this.f3670kX = 15;
        this.f3668kV = 40;
        m3037a(deferredHolder, SoundSource.HOSTILE, this.f3653iD, 1.0f, 1 | i);
        m3065s(30);
    }

    /* JADX INFO: renamed from: a */
    public void m3036a(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, float f, float f2) {
        m3037a(holder, soundSource, f, f2, 0);
    }

    /* JADX INFO: renamed from: a */
    public void m3037a(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, float f, float f2, int i) {
        if (this.f3896a == null) {
            return;
        }
        C1194vo.m6651a(new C1199vt(holder, soundSource, getId(), f, f2, i), this.f3896a);
    }

    /* JADX INFO: renamed from: bI */
    public void m3038bI() {
        this.f3671kY = 4;
    }

    /* JADX INFO: renamed from: av */
    public int m3039av() {
        return this.f3671kY;
    }

    @Override // com.boehmod.blockfront.C0727mz
    /* JADX INFO: renamed from: b */
    public void mo3040b(@NotNull ServerLevel serverLevel) {
        super.mo3040b(serverLevel);
        Object obj = this.f3896a;
        if (obj instanceof InterfaceC0899qL) {
            ((InterfaceC0899qL) obj).mo4660a(this);
        }
    }

    @Override // com.boehmod.blockfront.C0727mz
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putString("name", m3055F());
        ItemStack itemStackM3051b = m3051b();
        compoundTag.putBoolean("hasPrimary", !itemStackM3051b.isEmpty());
        if (!itemStackM3051b.isEmpty()) {
            compoundTag.put("primary", itemStackM3051b.save(registryAccess(), new CompoundTag()));
        }
        compoundTag.putInt("class", m3072b().m5523bN());
        compoundTag.putBoolean("respawn", this.f3667eD);
        compoundTag.putString("team", m3053E());
    }

    @Override // com.boehmod.blockfront.C0727mz
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        C0796oO c0796oOM3806a;
        super.readAdditionalSaveData(compoundTag);
        m3056t(compoundTag.getString("name"));
        if (compoundTag.getBoolean("hasPrimary")) {
            m3052d(ItemStack.parseOptional(registryAccess(), compoundTag.getCompound("primary")));
        }
        m3073a(C1015sV.m5528a(compoundTag.getInt("class")));
        this.f3667eD = compoundTag.getBoolean("respawn");
        m3054s(compoundTag.getString("team"));
        if (this.f3896a == null || (c0796oOM3806a = this.f3896a.m3582b().m3806a(m3053E())) == null) {
            return;
        }
        m3048a(this.f3896a, c0796oOM3806a);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public ResourceLocation m3041a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        if (this.f3678dt != null) {
            return this.f3678dt;
        }
        this.f3678dt = m3043a(abstractC0787oF, m3072b().getKey());
        return this.f3678dt;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public ResourceLocation m3042b(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        if (this.f3679du != null) {
            return this.f3679du;
        }
        this.f3679du = m3043a(abstractC0787oF, C0324fT.f2357Y);
        return this.f3679du;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private ResourceLocation m3043a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull String str) {
        C0796oO c0796oOM3806a = abstractC0787oF.m3582b().m3806a(m3053E());
        if (c0796oOM3806a == null) {
            return null;
        }
        C1074ta c1074taM3860a = c0796oOM3806a.m3860a(abstractC0787oF);
        return C0564jv.m2555d("textures/skins/game/nations/" + c1074taM3860a.m5976a().m5669ao() + "/" + c1074taM3860a.getSkin() + "/" + str + ".png");
    }

    /* JADX INFO: renamed from: s */
    public ResourceLocation m3044s() {
        if (this.f3665ds == null) {
            this.f3665ds = C0564jv.m2555d("textures/models/entities/bot/" + EnumC0682mG.values()[m3059ax()].getSkin() + "/" + m3015au() + ".png");
        }
        return this.f3665ds;
    }

    /* JADX INFO: renamed from: aF */
    public boolean m3045aF() {
        return this.f3673eE;
    }

    public String getSkin() {
        return "default";
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0796oO m3046a() {
        return this.f3666c;
    }

    /* JADX INFO: renamed from: d */
    public boolean m3047d(@NotNull Player player) {
        C0796oO c0796oOM3793a;
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f3683eF && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        UUID uuid = player.getUUID();
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
        return (abstractC0787oFMo2531a == null || (c0796oOM3793a = abstractC0787oFMo2531a.m3582b().m3793a(uuid)) == null || !c0796oOM3793a.getName().equalsIgnoreCase(m3053E())) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public void m3048a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0796oO c0796oO) {
        this.f3666c = c0796oO;
        this.f3677a = (c0796oO.m3881bq() ? abstractC0787oF.m3624b().m5976a() : abstractC0787oF.m3623a().m5976a()).m5676a();
    }

    /* JADX INFO: renamed from: au */
    public final float m3049au() {
        return ((Float) this.entityData.get(f3650r)).floatValue();
    }

    /* JADX INFO: renamed from: i */
    public void m3050i(float f) {
        this.entityData.set(f3650r, Float.valueOf(f));
    }

    /* JADX INFO: renamed from: b */
    public ItemStack m3051b() {
        return (ItemStack) this.entityData.get(f3644l);
    }

    /* JADX INFO: renamed from: d */
    public void m3052d(ItemStack itemStack) {
        this.entityData.set(f3644l, itemStack);
    }

    /* JADX INFO: renamed from: E */
    public String m3053E() {
        return (String) this.entityData.get(f3637e);
    }

    /* JADX INFO: renamed from: s */
    public void m3054s(String str) {
        this.entityData.set(f3637e, str);
    }

    /* JADX INFO: renamed from: F */
    public String m3055F() {
        return (String) this.entityData.get(f3643k);
    }

    /* JADX INFO: renamed from: t */
    public void m3056t(String str) {
        this.entityData.set(f3643k, str);
    }

    /* JADX INFO: renamed from: aw */
    public int m3057aw() {
        return ((Integer) this.entityData.get(f3639g)).intValue();
    }

    /* JADX INFO: renamed from: p */
    public void m3058p(int i) {
        this.entityData.set(f3639g, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: ax */
    public int m3059ax() {
        return ((Integer) this.entityData.get(f3649q)).intValue();
    }

    /* JADX INFO: renamed from: q */
    public void m3060q(int i) {
        this.entityData.set(f3649q, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: ay */
    public int m3061ay() {
        return ((Integer) this.entityData.get(f3640h)).intValue();
    }

    /* JADX INFO: renamed from: r */
    public void m3062r(int i) {
        this.entityData.set(f3640h, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: aG */
    public boolean m3063aG() {
        return m3061ay() > 0;
    }

    /* JADX INFO: renamed from: az */
    public int m3064az() {
        return ((Integer) this.entityData.get(f3641i)).intValue();
    }

    /* JADX INFO: renamed from: s */
    public void m3065s(int i) {
        this.f3660kU = i;
        this.entityData.set(f3641i, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: aH */
    public boolean m3066aH() {
        return ((Boolean) this.entityData.get(f3638f)).booleanValue();
    }

    /* JADX INFO: renamed from: D */
    public void m3067D(boolean z) {
        this.entityData.set(f3638f, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: aI */
    public boolean m3068aI() {
        return ((Boolean) this.entityData.get(f3642j)).booleanValue();
    }

    /* JADX INFO: renamed from: E */
    public void m3069E(boolean z) {
        this.entityData.set(f3642j, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: F */
    public void m3070F(boolean z) {
        this.f3667eD = z;
    }

    /* JADX INFO: renamed from: aJ */
    public boolean m3071aJ() {
        return this.f3667eD;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1015sV m3072b() {
        return C1015sV.m5528a(((Integer) this.entityData.get(f3646n)).intValue());
    }

    /* JADX INFO: renamed from: a */
    public void m3073a(@NotNull C1015sV c1015sV) {
        this.entityData.set(f3646n, Integer.valueOf(c1015sV.m5523bN()));
    }

    /* JADX INFO: renamed from: L */
    public boolean m3074L() {
        return ((Boolean) this.entityData.get(f3647o)).booleanValue();
    }

    /* JADX INFO: renamed from: b */
    public void m3075b(BlockPos blockPos) {
        if (!((BlockPos) this.entityData.get(f3648p)).equals(blockPos)) {
            this.entityData.set(f3648p, blockPos);
        }
    }

    /* JADX INFO: renamed from: b */
    public BlockPos m3076b() {
        return (BlockPos) this.entityData.get(f3648p);
    }

    /* JADX INFO: renamed from: c */
    public Optional<C1014sU> m3077c() {
        return Optional.ofNullable(this.f3677a);
    }

    public void knockback(double d, double d2, double d3) {
    }

    /* JADX INFO: renamed from: t */
    public void m3078t(int i) {
        this.f3658eC = true;
        this.f3659kT = i;
    }
}
