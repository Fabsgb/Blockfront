package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.BlockUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ny */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ny.class */
public abstract class AbstractC0779ny extends C0726my {

    /* JADX INFO: renamed from: lZ */
    private static final int f4162lZ = 25;

    /* JADX INFO: renamed from: y */
    private static final EntityDataAccessor<Float> f4163y;

    /* JADX INFO: renamed from: z */
    private static final EntityDataAccessor<Boolean> f4164z;

    /* JADX INFO: renamed from: A */
    private static final EntityDataAccessor<String> f4165A;

    /* JADX INFO: renamed from: B */
    private static final EntityDataAccessor<Boolean> f4166B;

    /* JADX INFO: renamed from: C */
    private static final EntityDataAccessor<Boolean> f4167C;

    /* JADX INFO: renamed from: D */
    private static final EntityDataAccessor<Boolean> f4168D;

    /* JADX INFO: renamed from: E */
    private static final EntityDataAccessor<Boolean> f4169E;

    /* JADX INFO: renamed from: F */
    private static final EntityDataAccessor<Boolean> f4170F;

    /* JADX INFO: renamed from: G */
    private static final EntityDataAccessor<Boolean> f4171G;

    /* JADX INFO: renamed from: H */
    private static final EntityDataAccessor<Float> f4172H;

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C0731nC f4173a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0636lN f4174a;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0636lN f4175b;

    /* JADX INFO: renamed from: ma */
    private int f4176ma;

    /* JADX INFO: renamed from: av */
    private double f4177av;

    /* JADX INFO: renamed from: aw */
    private double f4178aw;

    /* JADX INFO: renamed from: ax */
    private double f4179ax;

    /* JADX INFO: renamed from: ay */
    private double f4180ay;

    /* JADX INFO: renamed from: az */
    private double f4181az;

    /* JADX INFO: renamed from: fh */
    private boolean f4182fh;

    /* JADX INFO: renamed from: mb */
    private int f4183mb;

    /* JADX INFO: renamed from: mc */
    private int f4184mc;

    /* JADX INFO: renamed from: md */
    private int f4185md;

    /* JADX INFO: renamed from: me */
    private int f4186me;

    /* JADX INFO: renamed from: fi */
    private boolean f4187fi;

    /* JADX INFO: renamed from: jn */
    private float f4188jn;

    /* JADX INFO: renamed from: jo */
    private float f4189jo;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C1074ta f4190b;

    /* JADX INFO: renamed from: o */
    @Nullable
    private UUID f4191o;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0733nE<AbstractC0779ny> f4192a;

    /* JADX INFO: renamed from: fj */
    static final /* synthetic */ boolean f4193fj;

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract C0733nE<AbstractC0779ny> mo3422a();

    /* JADX INFO: renamed from: a */
    public abstract C0744nP<?> mo3293a();

    /* JADX INFO: renamed from: a */
    public abstract Packet<ClientGamePacketListener> mo3423a(ServerEntity serverEntity);

    /* JADX INFO: renamed from: ax */
    public abstract float mo3294ax();

    static {
        f4193fj = !AbstractC0779ny.class.desiredAssertionStatus();
        f4163y = SynchedEntityData.defineId(AbstractC0779ny.class, EntityDataSerializers.FLOAT);
        f4164z = SynchedEntityData.defineId(AbstractC0779ny.class, EntityDataSerializers.BOOLEAN);
        f4165A = SynchedEntityData.defineId(AbstractC0779ny.class, EntityDataSerializers.STRING);
        f4166B = SynchedEntityData.defineId(AbstractC0779ny.class, EntityDataSerializers.BOOLEAN);
        f4167C = SynchedEntityData.defineId(AbstractC0779ny.class, EntityDataSerializers.BOOLEAN);
        f4168D = SynchedEntityData.defineId(AbstractC0779ny.class, EntityDataSerializers.BOOLEAN);
        f4169E = SynchedEntityData.defineId(AbstractC0779ny.class, EntityDataSerializers.BOOLEAN);
        f4170F = SynchedEntityData.defineId(AbstractC0779ny.class, EntityDataSerializers.BOOLEAN);
        f4171G = SynchedEntityData.defineId(AbstractC0779ny.class, EntityDataSerializers.BOOLEAN);
        f4172H = SynchedEntityData.defineId(AbstractC0779ny.class, EntityDataSerializers.FLOAT);
    }

    public AbstractC0779ny(@NotNull EntityType<? extends AbstractC0779ny> entityType, @NotNull Level level, @NotNull BlockEntityType<? extends C0636lN> blockEntityType, @NotNull BlockState blockState, @NotNull BlockEntityType<? extends C0636lN> blockEntityType2, @NotNull BlockState blockState2) {
        super(entityType, level);
        this.f4173a = new C0731nC();
        this.f4182fh = false;
        this.f4183mb = 1200;
        this.f4184mc = 0;
        this.f4185md = 1200;
        this.f4186me = 25;
        this.f4187fi = false;
        this.f4189jo = 0.0f;
        this.f4190b = null;
        this.f4191o = null;
        this.f4174a = (C0636lN) blockEntityType.create(BlockPos.ZERO, blockState);
        this.f4175b = (C0636lN) blockEntityType2.create(BlockPos.ZERO, blockState2);
        if (this.f4174a != null) {
            this.f4174a.m2809a(this);
        }
        if (this.f4175b != null) {
            this.f4175b.m2809a(this);
        }
        this.blocksBuilding = true;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3493a(@NotNull Entity entity, @NotNull Entity entity2) {
        return (entity2.canBeCollidedWith() || entity2.isPushable()) && !entity.isPassengerOfSameVehicle(entity2);
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public UUID m3494d() {
        return this.f4191o;
    }

    /* JADX INFO: renamed from: b */
    public void m3495b(@Nullable UUID uuid) {
        this.f4191o = uuid;
    }

    /* JADX INFO: renamed from: a */
    public void m3496a(@Nullable C1074ta c1074ta) {
        this.f4190b = c1074ta;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0636lN m3497a() {
        return this.f4174a;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0636lN m3498b() {
        return this.f4175b;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0733nE<AbstractC0779ny> m3499b() {
        if (this.f4192a == null) {
            this.f4192a = mo3422a();
        }
        return this.f4192a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0731nC m3500a() {
        return this.f4173a;
    }

    /* JADX INFO: renamed from: cf */
    public void m3501cf() {
        if (m3504aP() || this.f3894a == null) {
            return;
        }
        if (!getPassengers().isEmpty()) {
            this.f4183mb = 0;
            this.f4182fh = true;
            return;
        }
        if (this.f4182fh) {
            int i = this.f4183mb;
            this.f4183mb = i + 1;
            if (i >= m3537aM()) {
                int i2 = this.f4184mc;
                this.f4184mc = i2 + 1;
                if (i2 >= m3538aN()) {
                    this.f4184mc = 0;
                    m3517a(null, null, 1.0f);
                }
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: I */
    private String m3502I() {
        UUID uuid;
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a;
        C0796oO c0796oOM3793a;
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4193fj && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        for (Player player : getPassengers()) {
            if ((player instanceof Player) && (abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a((uuid = player.getUUID()))) != null && (c0796oOM3793a = abstractC0787oFMo2531a.m3582b().m3793a(uuid)) != null) {
                return c0796oOM3793a.getName();
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: cg */
    public void m3503cg() {
        int i = this.f4185md;
        this.f4185md = i - 1;
        if (i > 0) {
            return;
        }
        Level level = level();
        discard();
        for (ServerPlayer serverPlayer : level.players()) {
            if (serverPlayer instanceof ServerPlayer) {
                C1194vo.m6648a(new C1200vu(EnumC0786oE.VEHICLE_EXPLOSION, new Vec3(getX(), getY(), getZ())), serverPlayer);
            }
        }
    }

    /* JADX INFO: renamed from: aP */
    public boolean m3504aP() {
        return m3507az() <= 0.0f;
    }

    /* JADX INFO: renamed from: ay */
    public float m3505ay() {
        C0733nE<AbstractC0779ny> c0733nEM3499b = m3499b();
        if (c0733nEM3499b.f3942a == null) {
            return 0.0f;
        }
        return (level().isClientSide && m3533aY()) ? c0733nEM3499b.f3942a.f4146jd : ((Float) this.entityData.get(f4172H)).floatValue();
    }

    /* JADX INFO: renamed from: j */
    public void m3506j(float f) {
        this.entityData.set(f4172H, Float.valueOf(f));
    }

    /* JADX INFO: renamed from: az */
    public float m3507az() {
        return ((Float) this.entityData.get(f4163y)).floatValue();
    }

    /* JADX INFO: renamed from: k */
    public void m3508k(float f) {
        this.entityData.set(f4163y, Float.valueOf(f));
    }

    /* JADX INFO: renamed from: aQ */
    public boolean m3509aQ() {
        return !m3504aP() && m3507az() < m3499b().f3949jC * 0.25f;
    }

    /* JADX INFO: renamed from: aR */
    public boolean m3510aR() {
        return ((Boolean) this.entityData.get(f4164z)).booleanValue();
    }

    /* JADX INFO: renamed from: G */
    public void m3511G(boolean z) {
        if (z == m3510aR()) {
            return;
        }
        this.entityData.set(f4164z, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: d */
    public boolean m3512d(@NotNull Player player) {
        C0796oO c0796oOM3793a;
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4193fj && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is not null!");
        }
        UUID uuid = player.getUUID();
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
        return (abstractC0787oFMo2531a == null || (c0796oOM3793a = abstractC0787oFMo2531a.m3582b().m3793a(uuid)) == null || !c0796oOM3793a.getName().equals(m3519J())) ? false : true;
    }

    /* JADX INFO: renamed from: k */
    public boolean m3513k(@NotNull Entity entity) {
        C0732nD c0732nDM3535a = m3535a(entity);
        return c0732nDM3535a != null && c0732nDM3535a.f3937fq;
    }

    /* JADX INFO: renamed from: l */
    public boolean m3514l(@NotNull Entity entity) {
        C0732nD c0732nDM3535a = m3535a(entity);
        return c0732nDM3535a != null && c0732nDM3535a.f3936fp;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Entity m3515a() {
        C0733nE<AbstractC0779ny> c0733nEM3499b = m3499b();
        List passengers = getPassengers();
        int iM3352aO = c0733nEM3499b.m3352aO();
        if (iM3352aO > -1 && iM3352aO < passengers.size()) {
            return (Entity) passengers.get(iM3352aO);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    protected void m3516a(@NotNull Entity entity, @NotNull C0732nD c0732nD) {
        float fM3409aE = 0.0f;
        if (hasPassenger(entity)) {
            int iIndexOf = getPassengers().indexOf(entity);
            Iterator it = m3499b().f3945ak.iterator();
            while (it.hasNext()) {
                AbstractC0742nN abstractC0742nN = (AbstractC0742nN) it.next();
                if (abstractC0742nN.f4007mm == iIndexOf || abstractC0742nN.f4008b.contains(iIndexOf)) {
                    fM3409aE += abstractC0742nN.m3409aE();
                }
            }
        }
        float yRot = getYRot() + fM3409aE;
        entity.setYBodyRot(yRot);
        float fWrapDegrees = Mth.wrapDegrees((entity.getYRot() - yRot) + c0732nD.f3930jx);
        float fClamp = Mth.clamp(fWrapDegrees, -c0732nD.f3935jz, c0732nD.f3935jz);
        float fWrapDegrees2 = Mth.wrapDegrees(entity.getXRot());
        float fClamp2 = Mth.clamp(fWrapDegrees2, -c0732nD.f3934jy, c0732nD.f3934jy);
        entity.yRotO += fClamp - fWrapDegrees;
        entity.setYRot((entity.getYRot() + fClamp) - fWrapDegrees);
        entity.setYHeadRot(entity.getYRot());
        entity.xRotO += fClamp2 - fWrapDegrees2;
        entity.setXRot((entity.getXRot() + fClamp2) - fWrapDegrees2);
    }

    /* JADX INFO: renamed from: a */
    public void m3517a(@Nullable ItemStack itemStack, @Nullable Player player, float f) {
        C0744nP<?> c0744nPMo3293a = mo3293a();
        playSound((SoundEvent) c0744nPMo3293a.f4032aq.get(), 2.0f, 1.0f);
        playSound((SoundEvent) c0744nPMo3293a.f4033ar.get(), 15.0f, 1.0f);
        if (c0744nPMo3293a.f4034as != null) {
            SoundEvent soundEvent = (SoundEvent) c0744nPMo3293a.f4034as.get();
            for (ServerPlayer serverPlayer : getPassengers()) {
                if (serverPlayer instanceof ServerPlayer) {
                    serverPlayer.playNotifySound(soundEvent, SoundSource.NEUTRAL, 15.0f, 1.0f);
                }
            }
        }
        if (!m3504aP()) {
            boolean z = false;
            float fMax = Math.max(m3507az() - f, 0.0f);
            m3508k(fMax);
            if (fMax <= 0.0f) {
                m3518a(itemStack, player);
                z = true;
            }
            if (player instanceof ServerPlayer) {
                C1194vo.m6648a(new C1154vA(z), (ServerPlayer) player);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3518a(@Nullable ItemStack itemStack, @Nullable Player player) {
        UUID uuid;
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a;
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4193fj && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        Level level = level();
        C1194vo.m6649b(new C1200vu(EnumC0786oE.VEHICLE_EXPLOSION, position()));
        if (player != null && (abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a((uuid = player.getUUID()))) != null) {
            C0799oR.m4014a(abstractC0563juM168a, abstractC0787oFMo2531a, uuid, C1089tp.f5715F);
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(getPassengers());
        ejectPassengers();
        DamageSources damageSources = level.damageSources();
        DamageSource damageSourceGeneric = damageSources.generic();
        if (player != null) {
            DamageSource damageSourcePlayerAttack = damageSources.playerAttack(player);
            if (itemStack != null) {
                damageSourceGeneric = new C0703mb(damageSourcePlayerAttack.typeHolder(), player, itemStack);
            } else {
                damageSourceGeneric = damageSourcePlayerAttack;
            }
        }
        ObjectListIterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            ((Entity) it.next()).hurt(damageSourceGeneric, Float.MAX_VALUE);
        }
    }

    /* JADX INFO: renamed from: J */
    public String m3519J() {
        return (String) this.entityData.get(f4165A);
    }

    /* JADX INFO: renamed from: ch */
    public void m3520ch() {
        String strM3502I = m3502I();
        this.entityData.set(f4165A, strM3502I == null ? "" : strM3502I);
    }

    /* JADX INFO: renamed from: aS */
    public boolean m3521aS() {
        C0733nE<AbstractC0779ny> c0733nEM3499b = m3499b();
        if (c0733nEM3499b.f3942a == null) {
            return false;
        }
        return (level().isClientSide && m3533aY()) ? c0733nEM3499b.f3942a.f4148fb : ((Boolean) this.entityData.get(f4166B)).booleanValue();
    }

    /* JADX INFO: renamed from: H */
    public void m3522H(boolean z) {
        this.entityData.set(f4166B, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: aT */
    public boolean m3523aT() {
        C0733nE<AbstractC0779ny> c0733nEM3499b = m3499b();
        if (c0733nEM3499b.f3942a == null) {
            return false;
        }
        return (level().isClientSide && m3533aY()) ? c0733nEM3499b.f3942a.f4149fc : ((Boolean) this.entityData.get(f4167C)).booleanValue();
    }

    /* JADX INFO: renamed from: I */
    public void m3524I(boolean z) {
        this.entityData.set(f4167C, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: aU */
    public boolean m3525aU() {
        C0733nE<AbstractC0779ny> c0733nEM3499b = m3499b();
        if (c0733nEM3499b.f3942a == null) {
            return false;
        }
        return (level().isClientSide && m3533aY()) ? c0733nEM3499b.f3942a.f4150fd : ((Boolean) this.entityData.get(f4168D)).booleanValue();
    }

    /* JADX INFO: renamed from: J */
    public void m3526J(boolean z) {
        this.entityData.set(f4168D, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: aV */
    public boolean m3527aV() {
        C0733nE<AbstractC0779ny> c0733nEM3499b = m3499b();
        if (c0733nEM3499b.f3942a == null) {
            return false;
        }
        return (level().isClientSide && m3533aY()) ? c0733nEM3499b.f3942a.f4151fe : ((Boolean) this.entityData.get(f4169E)).booleanValue();
    }

    /* JADX INFO: renamed from: K */
    public void m3528K(boolean z) {
        this.entityData.set(f4169E, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: aW */
    public boolean m3529aW() {
        C0733nE<AbstractC0779ny> c0733nEM3499b = m3499b();
        if (c0733nEM3499b.f3942a == null) {
            return false;
        }
        return (level().isClientSide && m3533aY()) ? c0733nEM3499b.f3942a.f4152ff : ((Boolean) this.entityData.get(f4170F)).booleanValue();
    }

    /* JADX INFO: renamed from: L */
    public void m3530L(boolean z) {
        this.entityData.set(f4170F, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: aX */
    public boolean m3531aX() {
        C0733nE<AbstractC0779ny> c0733nEM3499b = m3499b();
        if (c0733nEM3499b.f3942a == null) {
            return false;
        }
        return (level().isClientSide && m3533aY()) ? c0733nEM3499b.f3942a.f4153fg : ((Boolean) this.entityData.get(f4171G)).booleanValue();
    }

    /* JADX INFO: renamed from: M */
    public void m3532M(boolean z) {
        this.entityData.set(f4171G, Boolean.valueOf(z));
    }

    public float maxUpStep() {
        return 1.0f;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: aY */
    public boolean m3533aY() {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        return localPlayer != null && localPlayer.equals(m3515a());
    }

    @Override // com.boehmod.blockfront.C0726my
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        builder.define(f4163y, Float.valueOf(m3499b().f3949jC)).define(f4164z, false).define(f4165A, "").define(f4166B, false).define(f4167C, false).define(f4168D, false).define(f4169E, false).define(f4170F, false).define(f4171G, false).define(f4172H, Float.valueOf(0.0f));
    }

    @Override // com.boehmod.blockfront.C0726my
    public void tick() {
        super.tick();
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4193fj && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is not null!");
        }
        m3536ci();
        Level level = level();
        C0733nE<AbstractC0779ny> c0733nEM3499b = m3499b();
        List<ServerPlayer> passengers = getPassengers();
        boolean zM3504aP = m3504aP();
        Entity entityM3515a = m3515a();
        m3511G(entityM3515a != null);
        if (entityM3515a == null) {
            m3522H(false);
            m3524I(false);
            m3526J(false);
            m3528K(false);
            m3530L(false);
            m3506j(0.0f);
        }
        this.f4173a.m3302c(this);
        if (level.isClientSide) {
            this.f4189jo = this.f4188jn;
            this.f4188jn = Mth.lerp(0.2f, this.f4188jn, 0.0f);
            mo3293a().m3421z(Minecraft.getInstance());
            Iterator it = c0733nEM3499b.f3945ak.iterator();
            while (it.hasNext()) {
                ((AbstractC0742nN) it.next()).mo3406f(this);
            }
            Iterator it2 = c0733nEM3499b.f3947al.iterator();
            while (it2.hasNext()) {
                ((AbstractC0738nJ) it2.next()).m3378f(this);
            }
            if (m3504aP()) {
                if (this.tickCount % 4 == 0) {
                    float x = (float) (getX() + ((double) ((this.random.nextBoolean() ? 1.0f : -1.0f) * this.random.nextFloat())));
                    level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, true, x, getY() + 0.5d, (float) (getZ() + ((double) ((this.random.nextBoolean() ? 1.0f : -1.0f) * this.random.nextFloat()))), 0.0d, 0.10000000149011612d, 0.0d);
                    level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, true, x, getY(), r0 + 0.5f, 0.0d, 0.10000000149011612d, 0.0d);
                }
                if (this.tickCount % 2 == 0) {
                    float x2 = (float) (getX() + ((double) ((this.random.nextBoolean() ? 1.0f : -1.0f) * this.random.nextFloat())));
                    level.addParticle(ParticleTypes.LARGE_SMOKE, true, x2, getY() + 0.5d, (float) (getZ() + ((double) ((this.random.nextBoolean() ? 1.0f : -1.0f) * this.random.nextFloat()))), 0.0d, 0.10000000149011612d, 0.0d);
                    level.addParticle(ParticleTypes.LARGE_SMOKE, true, x2, getY(), r0 + 0.5f, 0.0d, 0.10000000149011612d, 0.0d);
                }
                level.addParticle(ParticleTypes.LAVA, true, getX(), getY() + 1.5d, getZ(), 0.0d, 0.10000000149011612d, 0.0d);
            }
        } else {
            m3520ch();
            m3501cf();
            if (!this.f4187fi) {
                this.f4187fi = true;
                Iterator it3 = c0733nEM3499b.f3945ak.iterator();
                while (it3.hasNext()) {
                    AbstractC0742nN abstractC0742nN = (AbstractC0742nN) it3.next();
                    if (abstractC0742nN instanceof C0740nL) {
                        C0740nL c0740nL = (C0740nL) abstractC0742nN;
                        if (this instanceof AbstractC0729nA) {
                            AbstractC0729nA abstractC0729nA = (AbstractC0729nA) this;
                            abstractC0729nA.m3290a(c0740nL).m3298a(abstractC0729nA.entityData, c0740nL.m3405aQ());
                        }
                    }
                }
            }
            if (m3509aQ()) {
                int i = this.f4186me;
                this.f4186me = i - 1;
                if (i <= 0) {
                    this.f4186me = 25;
                    DeferredHolder<SoundEvent, SoundEvent> deferredHolder = mo3293a().f4029an;
                    DeferredHolder<SoundEvent, SoundEvent> deferredHolder2 = mo3293a().f4030ao;
                    if (deferredHolder != null) {
                        playSound((SoundEvent) deferredHolder.get(), 1.0f, 1.0f);
                    }
                    if (deferredHolder2 != null) {
                        SoundEvent soundEvent = (SoundEvent) deferredHolder2.get();
                        for (ServerPlayer serverPlayer : passengers) {
                            if (serverPlayer instanceof ServerPlayer) {
                                serverPlayer.playNotifySound(soundEvent, SoundSource.AMBIENT, 1.0f, 1.0f);
                            }
                        }
                    }
                }
            }
            Iterator it4 = c0733nEM3499b.f3945ak.iterator();
            while (it4.hasNext()) {
                ((AbstractC0742nN) it4.next()).mo3407c(this);
            }
            Iterator it5 = c0733nEM3499b.f3947al.iterator();
            while (it5.hasNext()) {
                ((AbstractC0738nJ) it5.next()).m3377c(this);
            }
            if (zM3504aP) {
                m3503cg();
            }
        }
        if (isControlledByLocalInstance()) {
            if (level.isClientSide) {
                m3534a(c0733nEM3499b, entityM3515a);
            }
        } else {
            setDeltaMovement(Vec3.ZERO);
        }
        if (c0733nEM3499b.f3942a != null) {
            c0733nEM3499b.f3942a.m3490b(this);
        }
        AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        for (ServerPlayer serverPlayer2 : passengers) {
            if (serverPlayer2 instanceof ServerPlayer) {
                ServerPlayer serverPlayer3 = serverPlayer2;
                serverPlayer3.getAbilities().mayfly = true;
                if (C0799oR.m4052a((Player) serverPlayer3, (AbstractC0182b<?, ?, ?, ?>) abstractC0183cM2528a.m1136a((Player) serverPlayer3))) {
                    serverPlayer2.stopRiding();
                }
            }
        }
        if (zM3504aP || isRemoved()) {
            ejectPassengers();
        }
        checkInsideBlocks();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m3534a(@NotNull C0733nE<AbstractC0779ny> c0733nE, @Nullable Entity entity) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer != null && c0733nE.f3942a != null) {
            c0733nE.f3942a.m3491a(localPlayer, this, localPlayer.equals(entity));
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0732nD m3535a(@NotNull Entity entity) {
        C0733nE<AbstractC0779ny> c0733nEM3499b = m3499b();
        if (hasPassenger(entity)) {
            return c0733nEM3499b.m3353a(getPassengers().indexOf(entity));
        }
        return null;
    }

    /* JADX INFO: renamed from: ci */
    private void m3536ci() {
        Vec3 vec3Position = position();
        if (isControlledByLocalInstance()) {
            this.f4176ma = 0;
            syncPacketPositionCodec(getX(), getY(), getZ());
        }
        if (this.f4176ma > 0) {
            float xRot = getXRot();
            float yRot = getYRot();
            double d = vec3Position.x + ((this.f4177av - vec3Position.x) / ((double) this.f4176ma));
            double d2 = vec3Position.y + ((this.f4178aw - vec3Position.y) / ((double) this.f4176ma));
            double d3 = vec3Position.z + ((this.f4179ax - vec3Position.z) / ((double) this.f4176ma));
            setYRot(yRot + (((float) Mth.wrapDegrees(this.f4180ay - ((double) yRot))) / this.f4176ma));
            setXRot(xRot + (((float) (this.f4181az - ((double) xRot))) / this.f4176ma));
            this.f4176ma--;
            setPos(d, d2, d3);
            setRot(yRot, xRot);
        }
    }

    /* JADX INFO: renamed from: aM */
    public int m3537aM() {
        return 1200;
    }

    /* JADX INFO: renamed from: aN */
    public int m3538aN() {
        return 60;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3539a(@NotNull ServerPlayer serverPlayer, @NotNull String str) {
        C0796oO c0796oOM3793a;
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4193fj && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        UUID uuid = serverPlayer.getUUID();
        AbstractC0182b abstractC0182bM1136a = abstractC0183cM2528a.m1136a((Player) serverPlayer);
        if (abstractC0182bM1136a.f1489tb > 0 || C0799oR.m4052a((Player) serverPlayer, (AbstractC0182b<?, ?, ?, ?>) abstractC0182bM1136a)) {
            return false;
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
        if (abstractC0787oFMo2531a != null && (c0796oOM3793a = abstractC0787oFMo2531a.m3582b().m3793a(uuid)) != null) {
            if (!str.isEmpty() && !c0796oOM3793a.getName().equalsIgnoreCase(str)) {
                return false;
            }
            C1074ta c1074taM3860a = c0796oOM3793a.m3860a(abstractC0787oFMo2531a);
            if (this.f4190b == null || c1074taM3860a.f5643a == this.f4190b.f5643a) {
                return true;
            }
            MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.vehicle.wrong.team").withStyle(ChatFormatting.RED);
            C0799oR.m3928a(serverPlayer, (SoundEvent) C1280xc.f7551pi.get(), SoundSource.MASTER);
            C0799oR.m3970c(serverPlayer, (Component) mutableComponentWithStyle);
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: u */
    public void m3540u(@NotNull String str) {
        Object objM3354a = m3499b().m3354a(str);
        if (objM3354a instanceof C0740nL) {
            C0740nL c0740nL = (C0740nL) objM3354a;
            c0740nL.m3399c(level());
            if (c0740nL.m3391a() == EnumC0741nM.SHELL) {
                this.f4188jn = 1.0f;
            }
        }
    }

    /* JADX INFO: renamed from: v */
    public float m3541v(float f) {
        return C1290xm.m7843e(this.f4188jn, this.f4189jo, f);
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        LivingEntity livingEntityM3515a = m3515a();
        if (livingEntityM3515a instanceof LivingEntity) {
            return livingEntityM3515a;
        }
        return null;
    }

    public void lerpTo(double d, double d2, double d3, float f, float f2, int i) {
        super.lerpTo(d, d2, d3, f, f2, i);
        this.f4177av = d;
        this.f4178aw = d2;
        this.f4179ax = d3;
        this.f4180ay = f;
        this.f4181az = f2;
        this.f4176ma = 10;
    }

    protected void addPassenger(@NotNull Entity entity) {
        super.addPassenger(entity);
        C0744nP<?> c0744nPMo3293a = mo3293a();
        if (isControlledByLocalInstance() && this.f4176ma > 0) {
            this.f4176ma = 0;
            absMoveTo(this.f4177av, this.f4178aw, this.f4179ax, (float) this.f4180ay, (float) this.f4181az);
        }
        level().playLocalSound(this, (SoundEvent) c0744nPMo3293a.f4031ap.get(), SoundSource.NEUTRAL, 1.0f, 0.8f + (0.2f * this.random.nextFloat()));
    }

    protected void removePassenger(@NotNull Entity entity) {
        super.removePassenger(entity);
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4193fj && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (!player.isCreative()) {
                player.getAbilities().mayfly = false;
            }
            abstractC0183cM2528a.m1136a(player).f1489tb = 60;
        }
    }

    @NotNull
    public InteractionResult interact(@NotNull Player player, @NotNull InteractionHand interactionHand) {
        if (player.isSecondaryUseActive()) {
            return InteractionResult.PASS;
        }
        if (level().isClientSide) {
            return InteractionResult.SUCCESS;
        }
        return player.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
    }

    public void positionRider(@NotNull Entity entity, @NotNull Entity.MoveFunction moveFunction) {
        List passengers = getPassengers();
        C0732nD c0732nDM3535a = m3535a(entity);
        if (c0732nDM3535a == null) {
            return;
        }
        int iIndexOf = passengers.indexOf(entity);
        float fM3409aE = 0.0f;
        Iterator it = m3499b().f3945ak.iterator();
        while (it.hasNext()) {
            AbstractC0742nN abstractC0742nN = (AbstractC0742nN) it.next();
            if (abstractC0742nN.f4007mm == iIndexOf || abstractC0742nN.f4008b.contains(iIndexOf)) {
                fM3409aE += abstractC0742nN.m3409aE();
            }
        }
        float yRot = getYRot();
        float f = (-this.f4173a.m3308aA()) / 5.0f;
        float fM3309aB = this.f4173a.m3309aB() / 5.0f;
        entity.setPos(position().add(new Vec3(c0732nDM3535a.f3932k).xRot(f).zRot(fM3309aB).yRot((-yRot) * 0.017453292f)).add(new Vec3(c0732nDM3535a.f3931e).xRot(f).zRot(fM3309aB).yRot((-(fM3409aE + yRot)) * 0.017453292f)));
        m3516a(entity, c0732nDM3535a);
        if (entity instanceof Animal) {
            Animal animal = (Animal) entity;
            if (passengers.size() > 1) {
                int i = entity.getId() % 2 == 0 ? 90 : Token.IDENTIFIER;
                entity.setYBodyRot(animal.yBodyRot + i);
                entity.setYHeadRot(entity.getYHeadRot() + i);
            }
        }
    }

    public void onPassengerTurned(@NotNull Entity entity) {
        C0732nD c0732nDM3535a = m3535a(entity);
        if (c0732nDM3535a != null) {
            m3516a(entity, c0732nDM3535a);
        }
    }

    protected boolean canAddPassenger(@NotNull Entity entity) {
        String strM3053E;
        if (m3504aP()) {
            return false;
        }
        String strM3519J = m3519J();
        if (entity instanceof ServerPlayer) {
            if (!m3539a((ServerPlayer) entity, strM3519J)) {
                return false;
            }
        } else if (entity instanceof C0680mE) {
            C0680mE c0680mE = (C0680mE) entity;
            if (!strM3519J.isEmpty() && ((strM3053E = c0680mE.m3053E()) == null || !strM3053E.equalsIgnoreCase(strM3519J))) {
                return false;
            }
        }
        return getPassengers().size() < m3499b().f3944aj.size();
    }

    @NotNull
    public Direction getMotionDirection() {
        return getDirection().getClockWise();
    }

    public boolean isPickable() {
        return !isRemoved();
    }

    @NotNull
    public Vec3 getRelativePortalPosition(@NotNull Direction.Axis axis, @NotNull BlockUtil.FoundRectangle foundRectangle) {
        return LivingEntity.resetForwardDirectionOfRelativePortalPosition(super.getRelativePortalPosition(axis, foundRectangle));
    }

    @NotNull
    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.EVENTS;
    }

    public boolean canCollideWith(@NotNull Entity entity) {
        return m3493a(this, entity);
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    @Override // com.boehmod.blockfront.C0726my
    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @Override // com.boehmod.blockfront.C0726my
    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return mo3423a(serverEntity);
    }

    @NotNull
    public AABB getBoundingBoxForCulling() {
        return super.getBoundingBoxForCulling().inflate(3.0d);
    }
}
