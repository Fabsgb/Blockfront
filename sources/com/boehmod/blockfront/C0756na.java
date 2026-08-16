package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.na */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/na.class */
public class C0756na extends C0698mV {

    /* JADX INFO: renamed from: mO */
    private static final int f4190mO = 10;

    /* JADX INFO: renamed from: mP */
    private static final int f4191mP = 80;

    /* JADX INFO: renamed from: au */
    private static final double f4192au = 4.0d;

    /* JADX INFO: renamed from: jq */
    private static final float f4193jq = 0.8f;

    /* JADX INFO: renamed from: jr */
    private static final float f4194jr = 0.5f;

    /* JADX INFO: renamed from: js */
    private static final float f4195js = 0.4f;

    /* JADX INFO: renamed from: jt */
    private static final float f4196jt = 0.8f;

    /* JADX INFO: renamed from: av */
    private static final double f4197av = 64.0d;

    /* JADX INFO: renamed from: ju */
    private static final float f4198ju = 1.0f;

    /* JADX INFO: renamed from: jv */
    private static final float f4199jv = 4.0f;

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final EntityDataAccessor<String> f4200e;

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final EntityDataAccessor<Boolean> f4201f;

    /* JADX INFO: renamed from: g */
    @NotNull
    private static final EntityDataAccessor<Integer> f4202g;

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final EntityDataAccessor<Integer> f4203h;

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final EntityDataAccessor<Integer> f4204i;

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final EntityDataAccessor<Boolean> f4205j;

    /* JADX INFO: renamed from: k */
    @NotNull
    private static final EntityDataAccessor<String> f4206k;

    /* JADX INFO: renamed from: l */
    @NotNull
    private static final EntityDataAccessor<ItemStack> f4207l;

    /* JADX INFO: renamed from: m */
    @NotNull
    private static final EntityDataAccessor<ItemStack> f4208m;

    /* JADX INFO: renamed from: n */
    @NotNull
    private static final EntityDataAccessor<Integer> f4209n;

    /* JADX INFO: renamed from: o */
    @NotNull
    private static final EntityDataAccessor<Boolean> f4210o;

    /* JADX INFO: renamed from: p */
    @NotNull
    private static final EntityDataAccessor<BlockPos> f4211p;

    /* JADX INFO: renamed from: q */
    @NotNull
    private static final EntityDataAccessor<Integer> f4212q;

    /* JADX INFO: renamed from: r */
    @NotNull
    private static final EntityDataAccessor<Float> f4213r;

    /* JADX INFO: renamed from: I */
    @NotNull
    public final Map<LivingEntity, C0767nl.a> f4214I;

    /* JADX INFO: renamed from: mQ */
    private final int f4215mQ;

    /* JADX INFO: renamed from: jw */
    private final float f4216jw;

    /* JADX INFO: renamed from: eU */
    public boolean f4217eU;

    /* JADX INFO: renamed from: eV */
    public boolean f4218eV;

    /* JADX INFO: renamed from: jx */
    public float f4219jx;

    /* JADX INFO: renamed from: jy */
    public float f4220jy;

    /* JADX INFO: renamed from: eW */
    public boolean f4221eW;

    /* JADX INFO: renamed from: mR */
    public int f4222mR;

    /* JADX INFO: renamed from: mS */
    private int f4223mS;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractSoundInstance f4224a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private SimpleSoundInstance f4225a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private AbstractSoundInstance f4226b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0757nb f4227a;

    /* JADX INFO: renamed from: dq */
    @Nullable
    private ResourceLocation f4228dq;

    /* JADX INFO: renamed from: c */
    @Nullable
    private C0872pk f4229c;

    /* JADX INFO: renamed from: eX */
    private boolean f4230eX;

    /* JADX INFO: renamed from: mT */
    private int f4231mT;

    /* JADX INFO: renamed from: mU */
    private int f4232mU;

    /* JADX INFO: renamed from: mV */
    private int f4233mV;

    /* JADX INFO: renamed from: mW */
    private int f4234mW;

    /* JADX INFO: renamed from: mX */
    private int f4235mX;

    /* JADX INFO: renamed from: eY */
    private boolean f4236eY;

    /* JADX INFO: renamed from: a */
    @Nullable
    @OnlyIn(Dist.CLIENT)
    private C0397gm<C0756na> f4237a;

    /* JADX INFO: renamed from: mY */
    private int f4238mY;

    /* JADX INFO: renamed from: mZ */
    private int f4239mZ;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C1092tr f4240a;

    /* JADX INFO: renamed from: dr */
    @Nullable
    private ResourceLocation f4241dr;

    /* JADX INFO: renamed from: ds */
    @Nullable
    private ResourceLocation f4242ds;

    /* JADX INFO: renamed from: aw */
    private static final double f4243aw = 64.0d;

    /* JADX INFO: renamed from: ax */
    private double f4244ax;

    /* JADX INFO: renamed from: ay */
    private static final double f4245ay = 3.0d;

    /* JADX INFO: renamed from: eZ */
    static final /* synthetic */ boolean f4246eZ;

    static {
        f4246eZ = !C0756na.class.desiredAssertionStatus();
        f4200e = SynchedEntityData.defineId(C0756na.class, EntityDataSerializers.STRING);
        f4201f = SynchedEntityData.defineId(C0756na.class, EntityDataSerializers.BOOLEAN);
        f4202g = SynchedEntityData.defineId(C0756na.class, EntityDataSerializers.INT);
        f4203h = SynchedEntityData.defineId(C0756na.class, EntityDataSerializers.INT);
        f4204i = SynchedEntityData.defineId(C0756na.class, EntityDataSerializers.INT);
        f4205j = SynchedEntityData.defineId(C0756na.class, EntityDataSerializers.BOOLEAN);
        f4206k = SynchedEntityData.defineId(C0756na.class, EntityDataSerializers.STRING);
        f4207l = SynchedEntityData.defineId(C0756na.class, EntityDataSerializers.ITEM_STACK);
        f4208m = SynchedEntityData.defineId(C0756na.class, EntityDataSerializers.ITEM_STACK);
        f4209n = SynchedEntityData.defineId(C0756na.class, EntityDataSerializers.INT);
        f4210o = SynchedEntityData.defineId(C0756na.class, EntityDataSerializers.BOOLEAN);
        f4211p = SynchedEntityData.defineId(C0756na.class, EntityDataSerializers.BLOCK_POS);
        f4212q = SynchedEntityData.defineId(C0756na.class, EntityDataSerializers.INT);
        f4213r = SynchedEntityData.defineId(C0756na.class, EntityDataSerializers.FLOAT);
    }

    public C0756na(@NotNull EntityType<? extends C0756na> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f4214I = new Object2ObjectOpenHashMap();
        this.f4215mQ = ThreadLocalRandom.current().nextInt(5);
        this.f4216jw = 1.0f - ((float) (0.10000000149011612d * Math.random()));
        this.f4217eU = false;
        this.f4218eV = false;
        this.f4220jy = 0.0f;
        this.f4221eW = false;
        this.f4222mR = 0;
        this.f4223mS = 0;
        this.f4227a = new C0757nb(this);
        this.f4228dq = null;
        this.f4230eX = false;
        this.f4231mT = (int) (40.0d + (300.0d * Math.random()));
        this.f4232mU = C0358g.f2490g;
        this.f4233mV = 0;
        this.f4234mW = 0;
        this.f4235mX = 0;
        this.f4236eY = false;
        this.f4238mY = 0;
        this.f4239mZ = 0;
        this.f4240a = null;
        this.f4241dr = null;
        this.f4242ds = null;
        this.f4244ax = 64.0d;
    }

    /* JADX INFO: renamed from: a */
    public static AttributeSupplier.Builder m3516a() {
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
    public AbstractSoundInstance m3517a() {
        return this.f4224a;
    }

    /* JADX INFO: renamed from: a */
    public void m3518a(@NotNull AbstractSoundInstance abstractSoundInstance) {
        this.f4224a = abstractSoundInstance;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public SimpleSoundInstance m3519a() {
        return this.f4225a;
    }

    /* JADX INFO: renamed from: a */
    public void m3520a(@NotNull SimpleSoundInstance simpleSoundInstance) {
        this.f4225a = simpleSoundInstance;
    }

    /* JADX INFO: renamed from: b */
    public void m3521b(@NotNull AbstractSoundInstance abstractSoundInstance) {
        this.f4226b = abstractSoundInstance;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: bI */
    public void m3522bI() {
        if (this.f4226b == null) {
            return;
        }
        Minecraft.getInstance().getSoundManager().stop(this.f4226b);
        this.f4226b = null;
    }

    /* JADX INFO: renamed from: aJ */
    public int m3523aJ() {
        return this.f4215mQ;
    }

    /* JADX INFO: renamed from: aP */
    public boolean m3524aP() {
        return this.f4227a.m3596aP();
    }

    /* JADX INFO: renamed from: a */
    public Pair<Vec3, Double> m3525a() {
        Vec3 vec3M3594l = this.f4227a.m3594l();
        if (vec3M3594l != null) {
            return Pair.of(vec3M3594l, Double.valueOf(this.f4227a.m3595q()));
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m3526a(@NotNull Vec3 vec3, double d, float f, float f2) {
        double x = vec3.x - getX();
        double z = vec3.z - getZ();
        double eyeY = d - getEyeY();
        double dSqrt = Math.sqrt((x * x) + (z * z));
        float fAtan2 = ((float) ((Mth.atan2(z, x) * 180.0d) / 3.1415927410125732d)) - 90.0f;
        setXRot(m3527b(getXRot(), (float) (-((Mth.atan2(eyeY, dSqrt) * 180.0d) / 3.1415927410125732d)), f2));
        setYRot(m3527b(getYRot(), fAtan2, f));
    }

    /* JADX INFO: renamed from: b */
    private float m3527b(float f, float f2, float f3) {
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

    @Override // com.boehmod.blockfront.C0698mV
    public void baseTick() {
        super.baseTick();
        Level level = level();
        m3536bP();
        if (level.isClientSide()) {
            m3532bM();
            return;
        }
        LivingEntity target = getTarget();
        if (target != null && !canAttack(target)) {
            setTarget(null);
            this.f4227a.m3597bd();
        }
        this.f4227a.m3593a(this.random);
        m3528bJ();
        double dM6080v = this.f3855a != null ? this.f3855a.m4089a().m6080v() : -1.0d;
        this.f4244ax = dM6080v > 0.0d ? Math.min(64.0d, dM6080v) : 64.0d;
        int i = this.f4238mY + 1;
        this.f4238mY = i;
        if (i >= 10) {
            this.f4238mY = 0;
            m3529bK();
        }
        if (this.f4231mT > 0) {
            this.f4231mT--;
        }
        if (this.f4232mU > 0) {
            this.f4232mU--;
        }
        if (this.f4233mV > 0) {
            this.f4233mV--;
        }
        int i2 = this.f4239mZ + 1;
        this.f4239mZ = i2;
        if (i2 >= 80) {
            this.f4239mZ = 0;
            m3530bL();
        }
        m3565q(0);
        m3569s(Math.max(0, m3568aN() - 1));
        if (this.f4223mS > 0) {
            this.f4223mS--;
            if (this.f4223mS == 0) {
                m3572t(0);
            }
        }
        if (this.f4229c != null && !m3560L().equals(this.f4229c.getName())) {
            m3561s(this.f4229c.getName());
        }
    }

    /* JADX INFO: renamed from: bJ */
    private void m3528bJ() {
        if (this.f4221eW) {
            int i = this.f4222mR;
            this.f4222mR = i - 1;
            if (i <= 0) {
                this.f4221eW = false;
                if (this.f3855a != null && this.f4229c != null) {
                    InterfaceC0945rD.m5183a(this.f3855a, this.f4229c.m4296a(this.f3855a), this, getUUID());
                    m3572t(60);
                }
            }
        }
    }

    /* JADX INFO: renamed from: bK */
    private void m3529bK() {
        Iterator<Map.Entry<LivingEntity, C0767nl.a>> it = this.f4214I.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<LivingEntity, C0767nl.a> next = it.next();
            LivingEntity key = next.getKey();
            C0767nl.a value = next.getValue();
            if (key == null || !key.isAlive()) {
                it.remove();
            } else {
                if (C0875pn.m4483b((LivingEntity) this, key, distanceTo(key) < 16.0f ? C0358g.f2490g : 90) && hasLineOfSight(key)) {
                    value.m3620bY();
                    value.m3618bW();
                } else {
                    value.m3619bX();
                }
                if (value.m3621aU()) {
                    it.remove();
                }
            }
        }
        float f = 0.0f;
        Iterator<C0767nl.a> it2 = this.f4214I.values().iterator();
        while (it2.hasNext()) {
            float fM3617aP = it2.next().m3617aP() / 2.0f;
            if (fM3617aP > f) {
                f = fM3617aP;
            }
        }
        m3557h(f);
    }

    /* JADX INFO: renamed from: bL */
    private void m3530bL() {
        if (isAlive()) {
            if (level().getEntitiesOfClass(C0748nS.class, getBoundingBox().inflate(f4192au), (v0) -> {
                return v0.m3385aY();
            }).isEmpty()) {
                return;
            }
            m3544a((Holder<SoundEvent>) C1312xz.f8880GR, SoundSource.HOSTILE, this.f4216jw, 1.0f);
        }
    }

    public boolean hasLineOfSight(@NotNull Entity entity) {
        Level level = level();
        if (entity.level() != level) {
            return false;
        }
        Vec3 vec3 = new Vec3(getX(), getEyeY(), getZ());
        Vec3 vec4 = new Vec3(entity.getX(), entity.getEyeY(), entity.getZ());
        return (vec4.distanceTo(vec3) > this.f4244ax || ((Boolean) BlockGetter.traverseBlocks(vec3, vec4, new ClipContext(vec3, vec4, ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, this), (clipContext, blockPos) -> {
            BlockState blockState = level.getBlockState(blockPos);
            if (blockState.isAir()) {
                return null;
            }
            C1124uW c1124uW = C1124uW.f6154ak.get(blockState.getBlock());
            if (c1124uW == null) {
                c1124uW = C1124uW.f6155al.get(blockState.getSoundType(level, blockPos, this));
            }
            if (c1124uW != null && c1124uW.m6430cO()) {
                return null;
            }
            if (level.clipWithInteractionOverride(clipContext.getFrom(), clipContext.getTo(), blockPos, clipContext.getBlockShape(blockState, level, blockPos), blockState) != null) {
                return Boolean.TRUE;
            }
            return null;
        }, clipContext2 -> {
            return Boolean.FALSE;
        })).booleanValue() || m3531a(level, vec3, vec4)) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3531a(@NotNull Level level, @NotNull Vec3 vec3, @NotNull Vec3 vec4) {
        Iterator it = level.getEntitiesOfClass(C0748nS.class, new AABB(vec3, vec4).inflate(f4245ay), (v0) -> {
            return v0.m3385aY();
        }).iterator();
        while (it.hasNext()) {
            AABB aabbH = ((C0748nS) it.next()).m3386h();
            if (aabbH.contains(vec3) || aabbH.contains(vec4) || aabbH.clip(vec3, vec4).isPresent()) {
                return true;
            }
        }
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: bM */
    private void m3532bM() {
        float f;
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        if (this.f4234mW > 0) {
            this.f4234mW--;
        }
        if (m3571aO() > 0) {
            int i = this.f4235mX;
            this.f4235mX = i + 1;
            if (i >= (((double) threadLocalRandomCurrent.nextFloat()) < 0.5d ? 2 : 3)) {
                this.f4235mX = 0;
                this.f4236eY = !this.f4236eY;
            }
        }
        if (threadLocalRandomCurrent.nextFloat() < (this.f4218eV ? 0.05f : 0.02f)) {
            m3546bT();
            if (!this.f4218eV) {
                this.f4217eU = !this.f4217eU;
                if (threadLocalRandomCurrent.nextFloat() < 0.5d) {
                    this.f4218eV = true;
                }
            } else {
                this.f4218eV = false;
            }
        }
        if (this.f4218eV) {
            f = this.f4217eU ? -1.0f : 1.0f;
        } else {
            f = 0.0f;
        }
        this.f4220jy = this.f4219jx;
        this.f4219jx = Mth.lerp(0.2f, this.f4219jx, f);
        m3533bN();
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: bN */
    private void m3533bN() {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        if (this.f4237a == null) {
            this.f4237a = new C0397gm<>();
        }
        this.f4237a.m1887a(false, localPlayer, this);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: bO */
    public void m3534bO() {
        if (this.f4237a != null) {
            this.f4237a.m1888aO();
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: P */
    public boolean m3535P() {
        return this.f4237a == null || this.f4237a.m1889Q();
    }

    /* JADX INFO: renamed from: bP */
    private void m3536bP() {
        setItemInHand(InteractionHand.MAIN_HAND, m3558d());
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(f4200e, "").define(f4206k, "Bot").define(f4201f, false).define(f4205j, false).define(f4202g, 0).define(f4203h, 0).define(f4204i, 0).define(f4207l, ItemStack.EMPTY).define(f4208m, ItemStack.EMPTY).define(f4209n, Integer.valueOf(C1093ts.m6002c().m6011cc())).define(f4210o, Boolean.valueOf(Math.random() < 0.5d)).define(f4212q, Integer.valueOf(EnumC0758nc.CAUCASIAN.ordinal())).define(f4213r, Float.valueOf(0.0f)).define(f4211p, new BlockPos(0, 0, 0));
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(0, new C0760ne(this, 4.0f));
        this.goalSelector.addGoal(0, new C0761nf(this, 8.0f));
        this.goalSelector.addGoal(1, new C0763nh(this, 0.4f, 16.0f, 8.0f));
        this.goalSelector.addGoal(2, new C0764ni(this));
        this.goalSelector.addGoal(3, new C0765nj(this));
        this.goalSelector.addGoal(4, new C0766nk(this, 0.5d));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, C0756na.class, true));
    }

    public boolean canAttack(LivingEntity livingEntity) {
        C0872pk c0872pkM4229a;
        C0755nZ c0755nZM3472a;
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4246eZ && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (!livingEntity.isAlive() || livingEntity.tickCount <= 40) {
            return false;
        }
        if (livingEntity instanceof C0756na) {
            C0872pk c0872pkM3553a = ((C0756na) livingEntity).m3553a();
            return (c0872pkM3553a == null || c0872pkM3553a.equals(m3553a())) ? false : true;
        }
        if (livingEntity instanceof Player) {
            Entity entity = (Player) livingEntity;
            if (entity.isCreative()) {
                return false;
            }
            AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
            UUID uuid = entity.getUUID();
            AbstractC0183b abstractC0183bM1153a = abstractC0184cM2351a.m1153a((Player) entity);
            Entity vehicle = entity.getVehicle();
            if (((vehicle instanceof AbstractC0750nU) && (c0755nZM3472a = ((AbstractC0750nU) vehicle).m3472a(entity)) != null && (c0755nZM3472a.f4185fK || c0755nZM3472a.f4184fJ)) || C0875pn.m4488a((Player) entity, (AbstractC0183b<?, ?, ?, ?>) abstractC0183bM1153a)) {
                return false;
            }
            if (this.f3855a != null && this.f3855a.m4018b().m4247g(uuid)) {
                return false;
            }
            AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
            return abstractC0863pbMo2354a == null || abstractC0863pbMo2354a != this.f3855a || (c0872pkM4229a = abstractC0863pbMo2354a.m4018b().m4229a(uuid)) == null || !c0872pkM4229a.equals(m3553a());
        }
        return false;
    }

    public void die(@NotNull DamageSource damageSource) {
        super.die(damageSource);
        Level level = level();
        m3545a(damageSource.is(DamageTypeTags.IS_EXPLOSION) ? C1312xz.f8873GK : this.random.nextInt(ShaderInjectionDefinition.DEFAULT_PRIORITY) == 0 ? C1312xz.f8874GL : C1312xz.f8872GJ, SoundSource.HOSTILE, this.f4216jw, 4.0f, 6);
        for (C0756na c0756na : level.getEntitiesOfClass(C0756na.class, getBoundingBox().inflate(8.0d, 1.0d, 8.0d))) {
            if (c0756na != null && !c0756na.equals(this) && c0756na.m3560L().equals(m3560L()) && this.random.nextFloat() < 0.2f) {
                c0756na.m3541bS();
            }
        }
    }

    public boolean hurt(@NotNull DamageSource damageSource, float f) {
        if (damageSource instanceof C0724mv) {
            m3540bR();
            C0756na entity = ((C0724mv) damageSource).getEntity();
            if (entity instanceof C0756na) {
                C0756na c0756na = entity;
                c0756na.m3584c().ifPresent(c1092tr -> {
                    c0756na.m3537a(c1092tr.m5996i());
                });
            }
        }
        return super.hurt(damageSource, f);
    }

    @NotNull
    public String getScoreboardName() {
        return m3562M();
    }

    /* JADX INFO: renamed from: a */
    public void m3537a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        if (deferredHolder == null) {
            return;
        }
        int i = 30;
        if (((SoundEvent) deferredHolder.get()).toString().contains("bot.go")) {
            if (this.f4232mU > 0) {
                return;
            } else {
                i = 15;
            }
        }
        this.f4232mU = (int) (40.0d + (300.0d * Math.random()));
        if (this.f4231mT > 0) {
            return;
        }
        this.f4231mT = 40;
        if (this.f3855a != null) {
            m3544a((Holder<SoundEvent>) deferredHolder, SoundSource.HOSTILE, this.f4216jw, 1.0f);
        }
        m3572t(i);
    }

    /* JADX INFO: renamed from: e */
    public void m3538e(@Nullable Vec3 vec3) {
        if ((vec3 != null && position().distanceToSqr(vec3) <= 64.0d) && this.random.nextFloat() < 0.8f) {
            m3537a(C1312xz.f8881GS);
        } else {
            m3584c().ifPresent(c1092tr -> {
                m3537a(c1092tr.m5995h());
            });
        }
    }

    /* JADX INFO: renamed from: bQ */
    public void m3539bQ() {
        if (this.random.nextFloat() < 0.4f) {
            m3537a(C1312xz.f8883GU);
        } else {
            m3584c().ifPresent(c1092tr -> {
                m3537a(c1092tr.m5992e());
            });
        }
    }

    /* JADX INFO: renamed from: bR */
    public void m3540bR() {
        if (this.random.nextFloat() < 0.8f) {
            m3542b(C1312xz.f8882GT);
        } else {
            m3584c().ifPresent(c1092tr -> {
                m3542b(c1092tr.m5993f());
            });
        }
    }

    /* JADX INFO: renamed from: bS */
    public void m3541bS() {
        if (this.random.nextFloat() < 0.5f) {
            m3537a(C1312xz.f8881GS);
        } else {
            m3584c().ifPresent(c1092tr -> {
                m3537a(c1092tr.m5993f());
            });
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3542b(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        m3543a(deferredHolder, 0);
    }

    /* JADX INFO: renamed from: a */
    public void m3543a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, int i) {
        if (deferredHolder == null || this.f3855a == null || this.f4233mV > 0) {
            return;
        }
        this.f4233mV = 15;
        this.f4231mT = 40;
        m3545a(deferredHolder, SoundSource.HOSTILE, this.f4216jw, 1.0f, 1 | i);
        m3572t(30);
    }

    /* JADX INFO: renamed from: a */
    public void m3544a(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, float f, float f2) {
        m3545a(holder, soundSource, f, f2, 0);
    }

    /* JADX INFO: renamed from: a */
    public void m3545a(@NotNull Holder<SoundEvent> holder, @NotNull SoundSource soundSource, float f, float f2, int i) {
        if (this.f3855a == null) {
            return;
        }
        C1169vO.m6646a(new C1174vT(holder, soundSource, getId(), f, f2, i), this.f3855a);
    }

    /* JADX INFO: renamed from: bT */
    public void m3546bT() {
        this.f4234mW = 4;
    }

    /* JADX INFO: renamed from: aK */
    public int m3547aK() {
        return this.f4234mW;
    }

    @Override // com.boehmod.blockfront.C0698mV
    /* JADX INFO: renamed from: b */
    public void mo3121b(@NotNull ServerLevel serverLevel) {
        super.mo3121b(serverLevel);
        Object obj = this.f3855a;
        if (obj instanceof InterfaceC0976ri) {
            ((InterfaceC0976ri) obj).mo5336a(this);
        }
    }

    @Override // com.boehmod.blockfront.C0698mV
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putString("name", m3562M());
        ItemStack itemStackM3558d = m3558d();
        compoundTag.putBoolean("hasPrimary", !itemStackM3558d.isEmpty());
        if (!itemStackM3558d.isEmpty()) {
            compoundTag.put("primary", itemStackM3558d.save(registryAccess(), new CompoundTag()));
        }
        compoundTag.putInt("class", m3579b().m6011cc());
        compoundTag.putBoolean("respawn", this.f4230eX);
        compoundTag.putString("team", m3560L());
    }

    @Override // com.boehmod.blockfront.C0698mV
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        C0872pk c0872pkM4242a;
        super.readAdditionalSaveData(compoundTag);
        m3563t(compoundTag.getString("name"));
        if (compoundTag.getBoolean("hasPrimary")) {
            m3559d(ItemStack.parseOptional(registryAccess(), compoundTag.getCompound("primary")));
        }
        m3580a(C1093ts.m6016a(compoundTag.getInt("class")));
        this.f4230eX = compoundTag.getBoolean("respawn");
        m3561s(compoundTag.getString("team"));
        if (this.f3855a == null || (c0872pkM4242a = this.f3855a.m4018b().m4242a(m3560L())) == null) {
            return;
        }
        m3555a(this.f3855a, c0872pkM4242a);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public ResourceLocation m3548a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        if (this.f4241dr != null) {
            return this.f4241dr;
        }
        this.f4241dr = m3550a(abstractC0863pb, m3579b().getKey());
        return this.f4241dr;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public ResourceLocation m3549b(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        if (this.f4242ds != null) {
            return this.f4242ds;
        }
        this.f4242ds = m3550a(abstractC0863pb, C0394gj.f2552af);
        return this.f4242ds;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private ResourceLocation m3550a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull String str) {
        C0872pk c0872pkM4242a = abstractC0863pb.m4018b().m4242a(m3560L());
        if (c0872pkM4242a == null) {
            return null;
        }
        C1098tx c1098txM4296a = c0872pkM4242a.m4296a(abstractC0863pb);
        return C0532jO.m2378d("textures/skins/game/nations/" + c1098txM4296a.m6179a().m6157av() + "/" + c1098txM4296a.getSkin() + "/" + str + ".png");
    }

    /* JADX INFO: renamed from: t */
    public ResourceLocation m3551t() {
        if (this.f4228dq == null) {
            this.f4228dq = C0532jO.m2378d("textures/models/entities/bot/" + EnumC0758nc.values()[m3566aM()].getSkin() + "/" + m3523aJ() + ".png");
        }
        return this.f4228dq;
    }

    /* JADX INFO: renamed from: aQ */
    public boolean m3552aQ() {
        return this.f4236eY;
    }

    public String getSkin() {
        return "default";
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0872pk m3553a() {
        return this.f4229c;
    }

    /* JADX INFO: renamed from: d */
    public boolean m3554d(@NotNull Player player) {
        C0872pk c0872pkM4229a;
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4246eZ && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        UUID uuid = player.getUUID();
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
        return (abstractC0863pbMo2354a == null || (c0872pkM4229a = abstractC0863pbMo2354a.m4018b().m4229a(uuid)) == null || !c0872pkM4229a.getName().equalsIgnoreCase(m3560L())) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public void m3555a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0872pk c0872pk) {
        this.f4229c = c0872pk;
        this.f4240a = (c0872pk.m4317bA() ? abstractC0863pb.m4060b().m6179a() : abstractC0863pb.m4059a().m6179a()).m6164a();
    }

    /* JADX INFO: renamed from: aA */
    public final float m3556aA() {
        return ((Float) this.entityData.get(f4213r)).floatValue();
    }

    /* JADX INFO: renamed from: h */
    public void m3557h(float f) {
        this.entityData.set(f4213r, Float.valueOf(f));
    }

    /* JADX INFO: renamed from: d */
    public ItemStack m3558d() {
        return (ItemStack) this.entityData.get(f4207l);
    }

    /* JADX INFO: renamed from: d */
    public void m3559d(ItemStack itemStack) {
        this.entityData.set(f4207l, itemStack);
    }

    /* JADX INFO: renamed from: L */
    public String m3560L() {
        return (String) this.entityData.get(f4200e);
    }

    /* JADX INFO: renamed from: s */
    public void m3561s(String str) {
        this.entityData.set(f4200e, str);
    }

    /* JADX INFO: renamed from: M */
    public String m3562M() {
        return (String) this.entityData.get(f4206k);
    }

    /* JADX INFO: renamed from: t */
    public void m3563t(String str) {
        this.entityData.set(f4206k, str);
    }

    /* JADX INFO: renamed from: aL */
    public int m3564aL() {
        return ((Integer) this.entityData.get(f4202g)).intValue();
    }

    /* JADX INFO: renamed from: q */
    public void m3565q(int i) {
        this.entityData.set(f4202g, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: aM */
    public int m3566aM() {
        return ((Integer) this.entityData.get(f4212q)).intValue();
    }

    /* JADX INFO: renamed from: r */
    public void m3567r(int i) {
        this.entityData.set(f4212q, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: aN */
    public int m3568aN() {
        return ((Integer) this.entityData.get(f4203h)).intValue();
    }

    /* JADX INFO: renamed from: s */
    public void m3569s(int i) {
        this.entityData.set(f4203h, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: aR */
    public boolean m3570aR() {
        return m3568aN() > 0;
    }

    /* JADX INFO: renamed from: aO */
    public int m3571aO() {
        return ((Integer) this.entityData.get(f4204i)).intValue();
    }

    /* JADX INFO: renamed from: t */
    public void m3572t(int i) {
        this.f4223mS = i;
        this.entityData.set(f4204i, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: aa */
    public boolean m3573aa() {
        return ((Boolean) this.entityData.get(f4201f)).booleanValue();
    }

    /* JADX INFO: renamed from: D */
    public void m3574D(boolean z) {
        this.entityData.set(f4201f, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: aS */
    public boolean m3575aS() {
        return ((Boolean) this.entityData.get(f4205j)).booleanValue();
    }

    /* JADX INFO: renamed from: E */
    public void m3576E(boolean z) {
        this.entityData.set(f4205j, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: F */
    public void m3577F(boolean z) {
        this.f4230eX = z;
    }

    /* JADX INFO: renamed from: aT */
    public boolean m3578aT() {
        return this.f4230eX;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1093ts m3579b() {
        return C1093ts.m6016a(((Integer) this.entityData.get(f4209n)).intValue());
    }

    /* JADX INFO: renamed from: a */
    public void m3580a(@NotNull C1093ts c1093ts) {
        this.entityData.set(f4209n, Integer.valueOf(c1093ts.m6011cc()));
    }

    /* JADX INFO: renamed from: M */
    public boolean m3581M() {
        return ((Boolean) this.entityData.get(f4210o)).booleanValue();
    }

    /* JADX INFO: renamed from: b */
    public void m3582b(BlockPos blockPos) {
        if (!((BlockPos) this.entityData.get(f4211p)).equals(blockPos)) {
            this.entityData.set(f4211p, blockPos);
        }
    }

    /* JADX INFO: renamed from: b */
    public BlockPos m3583b() {
        return (BlockPos) this.entityData.get(f4211p);
    }

    /* JADX INFO: renamed from: c */
    public Optional<C1092tr> m3584c() {
        return Optional.ofNullable(this.f4240a);
    }

    public void knockback(double d, double d2, double d3) {
    }

    /* JADX INFO: renamed from: u */
    public void m3585u(int i) {
        this.f4221eW = true;
        this.f4222mR = i;
    }
}
