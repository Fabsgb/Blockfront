package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.nU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nU.class */
public abstract class AbstractC0750nU extends C0697mU {

    /* JADX INFO: renamed from: nX */
    private static final int f4119nX = 25;

    /* JADX INFO: renamed from: y */
    private static final EntityDataAccessor<Float> f4120y;

    /* JADX INFO: renamed from: z */
    private static final EntityDataAccessor<Boolean> f4121z;

    /* JADX INFO: renamed from: A */
    private static final EntityDataAccessor<String> f4122A;

    /* JADX INFO: renamed from: B */
    private static final EntityDataAccessor<Boolean> f4123B;

    /* JADX INFO: renamed from: C */
    private static final EntityDataAccessor<Boolean> f4124C;

    /* JADX INFO: renamed from: D */
    private static final EntityDataAccessor<Boolean> f4125D;

    /* JADX INFO: renamed from: E */
    private static final EntityDataAccessor<Boolean> f4126E;

    /* JADX INFO: renamed from: F */
    private static final EntityDataAccessor<Boolean> f4127F;

    /* JADX INFO: renamed from: G */
    private static final EntityDataAccessor<Boolean> f4128G;

    /* JADX INFO: renamed from: H */
    private static final EntityDataAccessor<Float> f4129H;

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C0754nY f4130a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0712mj f4131a;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0712mj f4132b;

    /* JADX INFO: renamed from: nY */
    private int f4133nY;

    /* JADX INFO: renamed from: aI */
    private double f4134aI;

    /* JADX INFO: renamed from: aJ */
    private double f4135aJ;

    /* JADX INFO: renamed from: aK */
    private double f4136aK;

    /* JADX INFO: renamed from: aL */
    private double f4137aL;

    /* JADX INFO: renamed from: aM */
    private double f4138aM;

    /* JADX INFO: renamed from: fB */
    private boolean f4139fB;

    /* JADX INFO: renamed from: nZ */
    private int f4140nZ;

    /* JADX INFO: renamed from: oa */
    private int f4141oa;

    /* JADX INFO: renamed from: ob */
    private int f4142ob;

    /* JADX INFO: renamed from: oc */
    private int f4143oc;

    /* JADX INFO: renamed from: fC */
    private boolean f4144fC;

    /* JADX INFO: renamed from: kg */
    private float f4145kg;

    /* JADX INFO: renamed from: kh */
    private float f4146kh;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C1098tx f4147b;

    /* JADX INFO: renamed from: o */
    @Nullable
    private UUID f4148o;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0809oa<AbstractC0750nU> f4149a;

    /* JADX INFO: renamed from: fD */
    static final /* synthetic */ boolean f4150fD;

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract C0809oa<AbstractC0750nU> mo3432a();

    /* JADX INFO: renamed from: a */
    public abstract C0820ol<?> mo3433a();

    /* JADX INFO: renamed from: a */
    public abstract Packet<ClientGamePacketListener> mo3434a(ServerEntity serverEntity);

    /* JADX INFO: renamed from: aD */
    public abstract float mo3435aD();

    static {
        f4150fD = !AbstractC0750nU.class.desiredAssertionStatus();
        f4120y = SynchedEntityData.defineId(AbstractC0750nU.class, EntityDataSerializers.FLOAT);
        f4121z = SynchedEntityData.defineId(AbstractC0750nU.class, EntityDataSerializers.BOOLEAN);
        f4122A = SynchedEntityData.defineId(AbstractC0750nU.class, EntityDataSerializers.STRING);
        f4123B = SynchedEntityData.defineId(AbstractC0750nU.class, EntityDataSerializers.BOOLEAN);
        f4124C = SynchedEntityData.defineId(AbstractC0750nU.class, EntityDataSerializers.BOOLEAN);
        f4125D = SynchedEntityData.defineId(AbstractC0750nU.class, EntityDataSerializers.BOOLEAN);
        f4126E = SynchedEntityData.defineId(AbstractC0750nU.class, EntityDataSerializers.BOOLEAN);
        f4127F = SynchedEntityData.defineId(AbstractC0750nU.class, EntityDataSerializers.BOOLEAN);
        f4128G = SynchedEntityData.defineId(AbstractC0750nU.class, EntityDataSerializers.BOOLEAN);
        f4129H = SynchedEntityData.defineId(AbstractC0750nU.class, EntityDataSerializers.FLOAT);
    }

    public AbstractC0750nU(@NotNull EntityType<? extends AbstractC0750nU> entityType, @NotNull Level level, @NotNull BlockEntityType<? extends C0712mj> blockEntityType, @NotNull BlockState blockState, @NotNull BlockEntityType<? extends C0712mj> blockEntityType2, @NotNull BlockState blockState2) {
        super(entityType, level);
        this.f4130a = new C0754nY();
        this.f4139fB = false;
        this.f4140nZ = 1200;
        this.f4141oa = 0;
        this.f4142ob = 1200;
        this.f4143oc = 25;
        this.f4144fC = false;
        this.f4146kh = 0.0f;
        this.f4147b = null;
        this.f4148o = null;
        this.f4131a = (C0712mj) blockEntityType.create(BlockPos.ZERO, blockState);
        this.f4132b = (C0712mj) blockEntityType2.create(BlockPos.ZERO, blockState2);
        if (this.f4131a != null) {
            this.f4131a.m3240a(this);
        }
        if (this.f4132b != null) {
            this.f4132b.m3240a(this);
        }
        this.blocksBuilding = true;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3426a(@NotNull Entity entity, @NotNull Entity entity2) {
        return (entity2.canBeCollidedWith() || entity2.isPushable()) && !entity.isPassengerOfSameVehicle(entity2);
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public UUID m3427d() {
        return this.f4148o;
    }

    /* JADX INFO: renamed from: b */
    public void m3428b(@Nullable UUID uuid) {
        this.f4148o = uuid;
    }

    /* JADX INFO: renamed from: a */
    public void m3429a(@Nullable C1098tx c1098tx) {
        this.f4147b = c1098tx;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0712mj m3430a() {
        return this.f4131a;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0712mj m3431b() {
        return this.f4132b;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0809oa<AbstractC0750nU> m3436b() {
        if (this.f4149a == null) {
            this.f4149a = mo3432a();
        }
        return this.f4149a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0754nY m3437a() {
        return this.f4130a;
    }

    /* JADX INFO: renamed from: cr */
    public void m3438cr() {
        if (m3441aZ() || this.f3853a == null) {
            return;
        }
        if (!getPassengers().isEmpty()) {
            this.f4140nZ = 0;
            this.f4139fB = true;
            return;
        }
        if (this.f4139fB) {
            int i = this.f4140nZ;
            this.f4140nZ = i + 1;
            if (i >= m3474bb()) {
                int i2 = this.f4141oa;
                this.f4141oa = i2 + 1;
                if (i2 >= m3475bc()) {
                    this.f4141oa = 0;
                    m3454a(null, null, 1.0f);
                }
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: P */
    private String m3439P() {
        UUID uuid;
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a;
        C0872pk c0872pkM4229a;
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4150fD && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        for (Player player : getPassengers()) {
            if ((player instanceof Player) && (abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a((uuid = player.getUUID()))) != null && (c0872pkM4229a = abstractC0863pbMo2354a.m4018b().m4229a(uuid)) != null) {
                return c0872pkM4229a.getName();
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: cs */
    public void m3440cs() {
        int i = this.f4142ob;
        this.f4142ob = i - 1;
        if (i > 0) {
            return;
        }
        Level level = level();
        discard();
        for (ServerPlayer serverPlayer : level.players()) {
            if (serverPlayer instanceof ServerPlayer) {
                C1169vO.m6643a(new C1175vU(EnumC0862pa.VEHICLE_EXPLOSION, new Vec3(getX(), getY(), getZ())), serverPlayer);
            }
        }
    }

    /* JADX INFO: renamed from: aZ */
    public boolean m3441aZ() {
        return m3444aF() <= 0.0f;
    }

    /* JADX INFO: renamed from: aE */
    public float m3442aE() {
        C0809oa<AbstractC0750nU> c0809oaM3436b = m3436b();
        if (c0809oaM3436b.f4370a == null) {
            return 0.0f;
        }
        return (level().isClientSide && m3470bi()) ? c0809oaM3436b.f4370a.f4103jW : ((Float) this.entityData.get(f4129H)).floatValue();
    }

    /* JADX INFO: renamed from: i */
    public void m3443i(float f) {
        this.entityData.set(f4129H, Float.valueOf(f));
    }

    /* JADX INFO: renamed from: aF */
    public float m3444aF() {
        return ((Float) this.entityData.get(f4120y)).floatValue();
    }

    /* JADX INFO: renamed from: j */
    public void m3445j(float f) {
        this.entityData.set(f4120y, Float.valueOf(f));
    }

    /* JADX INFO: renamed from: ba */
    public boolean m3446ba() {
        return !m3441aZ() && m3444aF() < m3436b().f4377kv * 0.25f;
    }

    /* JADX INFO: renamed from: bb */
    public boolean m3447bb() {
        return ((Boolean) this.entityData.get(f4121z)).booleanValue();
    }

    /* JADX INFO: renamed from: H */
    public void m3448H(boolean z) {
        if (z == m3447bb()) {
            return;
        }
        this.entityData.set(f4121z, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: d */
    public boolean m3449d(@NotNull Player player) {
        C0872pk c0872pkM4229a;
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4150fD && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is not null!");
        }
        UUID uuid = player.getUUID();
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
        return (abstractC0863pbMo2354a == null || (c0872pkM4229a = abstractC0863pbMo2354a.m4018b().m4229a(uuid)) == null || !c0872pkM4229a.getName().equals(m3456Q())) ? false : true;
    }

    /* JADX INFO: renamed from: k */
    public boolean m3450k(@NotNull Entity entity) {
        C0755nZ c0755nZM3472a = m3472a(entity);
        return c0755nZM3472a != null && c0755nZM3472a.f4185fK;
    }

    /* JADX INFO: renamed from: l */
    public boolean m3451l(@NotNull Entity entity) {
        C0755nZ c0755nZM3472a = m3472a(entity);
        return c0755nZM3472a != null && c0755nZM3472a.f4184fJ;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Entity m3452a() {
        C0809oa<AbstractC0750nU> c0809oaM3436b = m3436b();
        List passengers = getPassengers();
        int iM3730bd = c0809oaM3436b.m3730bd();
        if (iM3730bd > -1 && iM3730bd < passengers.size()) {
            return (Entity) passengers.get(iM3730bd);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    protected void m3453a(@NotNull Entity entity, @NotNull C0755nZ c0755nZ) {
        float fM3781aK = 0.0f;
        if (hasPassenger(entity)) {
            int iIndexOf = getPassengers().indexOf(entity);
            Iterator it = m3436b().f4373ar.iterator();
            while (it.hasNext()) {
                AbstractC0818oj abstractC0818oj = (AbstractC0818oj) it.next();
                if (abstractC0818oj.f4435ok == iIndexOf || abstractC0818oj.f4436b.contains(iIndexOf)) {
                    fM3781aK += abstractC0818oj.m3781aK();
                }
            }
        }
        float yRot = getYRot() + fM3781aK;
        entity.setYBodyRot(yRot);
        float fWrapDegrees = Mth.wrapDegrees((entity.getYRot() - yRot) + c0755nZ.f4178kq);
        float fClamp = Mth.clamp(fWrapDegrees, -c0755nZ.f4183ks, c0755nZ.f4183ks);
        float fWrapDegrees2 = Mth.wrapDegrees(entity.getXRot());
        float fClamp2 = Mth.clamp(fWrapDegrees2, -c0755nZ.f4182kr, c0755nZ.f4182kr);
        entity.yRotO += fClamp - fWrapDegrees;
        entity.setYRot((entity.getYRot() + fClamp) - fWrapDegrees);
        entity.setYHeadRot(entity.getYRot());
        entity.xRotO += fClamp2 - fWrapDegrees2;
        entity.setXRot((entity.getXRot() + fClamp2) - fWrapDegrees2);
    }

    /* JADX INFO: renamed from: a */
    public void m3454a(@Nullable ItemStack itemStack, @Nullable Player player, float f) {
        C0820ol<?> c0820olMo3433a = mo3433a();
        playSound((SoundEvent) c0820olMo3433a.f4460aq.get(), 2.0f, 1.0f);
        playSound((SoundEvent) c0820olMo3433a.f4461ar.get(), 15.0f, 1.0f);
        if (c0820olMo3433a.f4462as != null) {
            SoundEvent soundEvent = (SoundEvent) c0820olMo3433a.f4462as.get();
            for (ServerPlayer serverPlayer : getPassengers()) {
                if (serverPlayer instanceof ServerPlayer) {
                    serverPlayer.playNotifySound(soundEvent, SoundSource.NEUTRAL, 15.0f, 1.0f);
                }
            }
        }
        if (!m3441aZ()) {
            boolean z = false;
            float fMax = Math.max(m3444aF() - f, 0.0f);
            m3445j(fMax);
            if (fMax <= 0.0f) {
                m3455a(itemStack, player);
                z = true;
            }
            if (player instanceof ServerPlayer) {
                C1169vO.m6643a(new C1180vZ(z), (ServerPlayer) player);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3455a(@Nullable ItemStack itemStack, @Nullable Player player) {
        UUID uuid;
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a;
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4150fD && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        Level level = level();
        C1169vO.m6644b(new C1175vU(EnumC0862pa.VEHICLE_EXPLOSION, position()));
        if (player != null && (abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a((uuid = player.getUUID()))) != null) {
            C0875pn.m4450a(abstractC0531jNM179a, abstractC0863pbMo2354a, uuid, C1062tN.f5768F);
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(getPassengers());
        ejectPassengers();
        DamageSources damageSources = level.damageSources();
        DamageSource damageSourceGeneric = damageSources.generic();
        if (player != null) {
            DamageSource damageSourcePlayerAttack = damageSources.playerAttack(player);
            if (itemStack != null) {
                damageSourceGeneric = new C0726mx(damageSourcePlayerAttack.typeHolder(), player, itemStack);
            } else {
                damageSourceGeneric = damageSourcePlayerAttack;
            }
        }
        ObjectListIterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            ((Entity) it.next()).hurt(damageSourceGeneric, Float.MAX_VALUE);
        }
    }

    /* JADX INFO: renamed from: Q */
    public String m3456Q() {
        return (String) this.entityData.get(f4122A);
    }

    /* JADX INFO: renamed from: ct */
    public void m3457ct() {
        String strM3439P = m3439P();
        this.entityData.set(f4122A, strM3439P == null ? "" : strM3439P);
    }

    /* JADX INFO: renamed from: bc */
    public boolean m3458bc() {
        C0809oa<AbstractC0750nU> c0809oaM3436b = m3436b();
        if (c0809oaM3436b.f4370a == null) {
            return false;
        }
        return (level().isClientSide && m3470bi()) ? c0809oaM3436b.f4370a.f4105fv : ((Boolean) this.entityData.get(f4123B)).booleanValue();
    }

    /* JADX INFO: renamed from: I */
    public void m3459I(boolean z) {
        this.entityData.set(f4123B, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: bd */
    public boolean m3460bd() {
        C0809oa<AbstractC0750nU> c0809oaM3436b = m3436b();
        if (c0809oaM3436b.f4370a == null) {
            return false;
        }
        return (level().isClientSide && m3470bi()) ? c0809oaM3436b.f4370a.f4106fw : ((Boolean) this.entityData.get(f4124C)).booleanValue();
    }

    /* JADX INFO: renamed from: J */
    public void m3461J(boolean z) {
        this.entityData.set(f4124C, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: be */
    public boolean m3462be() {
        C0809oa<AbstractC0750nU> c0809oaM3436b = m3436b();
        if (c0809oaM3436b.f4370a == null) {
            return false;
        }
        return (level().isClientSide && m3470bi()) ? c0809oaM3436b.f4370a.f4107fx : ((Boolean) this.entityData.get(f4125D)).booleanValue();
    }

    /* JADX INFO: renamed from: K */
    public void m3463K(boolean z) {
        this.entityData.set(f4125D, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: bf */
    public boolean m3464bf() {
        C0809oa<AbstractC0750nU> c0809oaM3436b = m3436b();
        if (c0809oaM3436b.f4370a == null) {
            return false;
        }
        return (level().isClientSide && m3470bi()) ? c0809oaM3436b.f4370a.f4108fy : ((Boolean) this.entityData.get(f4126E)).booleanValue();
    }

    /* JADX INFO: renamed from: L */
    public void m3465L(boolean z) {
        this.entityData.set(f4126E, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: bg */
    public boolean m3466bg() {
        C0809oa<AbstractC0750nU> c0809oaM3436b = m3436b();
        if (c0809oaM3436b.f4370a == null) {
            return false;
        }
        return (level().isClientSide && m3470bi()) ? c0809oaM3436b.f4370a.f4109fz : ((Boolean) this.entityData.get(f4127F)).booleanValue();
    }

    /* JADX INFO: renamed from: M */
    public void m3467M(boolean z) {
        this.entityData.set(f4127F, Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: bh */
    public boolean m3468bh() {
        C0809oa<AbstractC0750nU> c0809oaM3436b = m3436b();
        if (c0809oaM3436b.f4370a == null) {
            return false;
        }
        return (level().isClientSide && m3470bi()) ? c0809oaM3436b.f4370a.f4110fA : ((Boolean) this.entityData.get(f4128G)).booleanValue();
    }

    /* JADX INFO: renamed from: N */
    public void m3469N(boolean z) {
        this.entityData.set(f4128G, Boolean.valueOf(z));
    }

    public float maxUpStep() {
        return 1.0f;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: bi */
    public boolean m3470bi() {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        return localPlayer != null && localPlayer.equals(m3452a());
    }

    @Override // com.boehmod.blockfront.C0697mU
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        builder.define(f4120y, Float.valueOf(m3436b().f4377kv)).define(f4121z, false).define(f4122A, "").define(f4123B, false).define(f4124C, false).define(f4125D, false).define(f4126E, false).define(f4127F, false).define(f4128G, false).define(f4129H, Float.valueOf(0.0f));
    }

    @Override // com.boehmod.blockfront.C0697mU
    public void tick() {
        super.tick();
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4150fD && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is not null!");
        }
        m3473cu();
        Level level = level();
        C0809oa<AbstractC0750nU> c0809oaM3436b = m3436b();
        List<ServerPlayer> passengers = getPassengers();
        boolean zM3441aZ = m3441aZ();
        Entity entityM3452a = m3452a();
        m3448H(entityM3452a != null);
        if (entityM3452a == null) {
            m3459I(false);
            m3461J(false);
            m3463K(false);
            m3465L(false);
            m3467M(false);
            m3443i(0.0f);
        }
        this.f4130a.m3489c(this);
        if (level.isClientSide) {
            this.f4146kh = this.f4145kg;
            this.f4145kg = Mth.lerp(0.2f, this.f4145kg, 0.0f);
            mo3433a().m3793B(Minecraft.getInstance());
            Iterator it = c0809oaM3436b.f4373ar.iterator();
            while (it.hasNext()) {
                ((AbstractC0818oj) it.next()).mo3778f(this);
            }
            Iterator it2 = c0809oaM3436b.f4375as.iterator();
            while (it2.hasNext()) {
                ((AbstractC0814of) it2.next()).m3750f(this);
            }
            if (m3441aZ()) {
                if (this.tickCount % 4 == 0) {
                    float x = (float) (getX() + ((double) ((this.random.nextBoolean() ? 1.0f : -1.0f) * this.random.nextFloat())));
                    float z = (float) (getZ() + ((double) ((this.random.nextBoolean() ? 1.0f : -1.0f) * this.random.nextFloat())));
                    level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, true, x, getY() + 0.5d, z, 0.0d, 0.10000000149011612d, 0.0d);
                    level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, true, x, getY(), z + 0.5f, 0.0d, 0.10000000149011612d, 0.0d);
                }
                if (this.tickCount % 2 == 0) {
                    float x2 = (float) (getX() + ((double) ((this.random.nextBoolean() ? 1.0f : -1.0f) * this.random.nextFloat())));
                    float z2 = (float) (getZ() + ((double) ((this.random.nextBoolean() ? 1.0f : -1.0f) * this.random.nextFloat())));
                    level.addParticle(ParticleTypes.LARGE_SMOKE, true, x2, getY() + 0.5d, z2, 0.0d, 0.10000000149011612d, 0.0d);
                    level.addParticle(ParticleTypes.LARGE_SMOKE, true, x2, getY(), z2 + 0.5f, 0.0d, 0.10000000149011612d, 0.0d);
                }
                level.addParticle(ParticleTypes.LAVA, true, getX(), getY() + 1.5d, getZ(), 0.0d, 0.10000000149011612d, 0.0d);
            }
        } else {
            m3457ct();
            m3438cr();
            if (!this.f4144fC) {
                this.f4144fC = true;
                Iterator it3 = c0809oaM3436b.f4373ar.iterator();
                while (it3.hasNext()) {
                    AbstractC0818oj abstractC0818oj = (AbstractC0818oj) it3.next();
                    if (abstractC0818oj instanceof C0816oh) {
                        C0816oh c0816oh = (C0816oh) abstractC0818oj;
                        if (this instanceof AbstractC0752nW) {
                            AbstractC0752nW abstractC0752nW = (AbstractC0752nW) this;
                            abstractC0752nW.m3479a(c0816oh).m3485a(abstractC0752nW.entityData, c0816oh.m3777bf());
                        }
                    }
                }
            }
            if (m3446ba()) {
                int i = this.f4143oc;
                this.f4143oc = i - 1;
                if (i <= 0) {
                    this.f4143oc = 25;
                    DeferredHolder<SoundEvent, SoundEvent> deferredHolder = mo3433a().f4457an;
                    DeferredHolder<SoundEvent, SoundEvent> deferredHolder2 = mo3433a().f4458ao;
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
            Iterator it4 = c0809oaM3436b.f4373ar.iterator();
            while (it4.hasNext()) {
                ((AbstractC0818oj) it4.next()).mo3779c(this);
            }
            Iterator it5 = c0809oaM3436b.f4375as.iterator();
            while (it5.hasNext()) {
                ((AbstractC0814of) it5.next()).m3749c(this);
            }
            if (zM3441aZ) {
                m3440cs();
            }
        }
        if (isControlledByLocalInstance()) {
            if (level.isClientSide) {
                m3471a(c0809oaM3436b, entityM3452a);
            }
        } else {
            setDeltaMovement(Vec3.ZERO);
        }
        if (c0809oaM3436b.f4370a != null) {
            c0809oaM3436b.f4370a.m3417b(this);
        }
        AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
        for (ServerPlayer serverPlayer2 : passengers) {
            if (serverPlayer2 instanceof ServerPlayer) {
                ServerPlayer serverPlayer3 = serverPlayer2;
                serverPlayer3.getAbilities().mayfly = true;
                if (C0875pn.m4488a((Player) serverPlayer3, (AbstractC0183b<?, ?, ?, ?>) abstractC0184cM2351a.m1153a((Player) serverPlayer3))) {
                    serverPlayer2.stopRiding();
                }
            }
        }
        if (zM3441aZ || isRemoved()) {
            ejectPassengers();
        }
        checkInsideBlocks();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m3471a(@NotNull C0809oa<AbstractC0750nU> c0809oa, @Nullable Entity entity) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer != null && c0809oa.f4370a != null) {
            c0809oa.f4370a.m3419a(localPlayer, this, localPlayer.equals(entity));
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0755nZ m3472a(@NotNull Entity entity) {
        C0809oa<AbstractC0750nU> c0809oaM3436b = m3436b();
        if (hasPassenger(entity)) {
            return c0809oaM3436b.m3731a(getPassengers().indexOf(entity));
        }
        return null;
    }

    /* JADX INFO: renamed from: cu */
    private void m3473cu() {
        Vec3 vec3Position = position();
        if (isControlledByLocalInstance()) {
            this.f4133nY = 0;
            syncPacketPositionCodec(getX(), getY(), getZ());
        }
        if (this.f4133nY > 0) {
            float xRot = getXRot();
            float yRot = getYRot();
            double d = vec3Position.x + ((this.f4134aI - vec3Position.x) / ((double) this.f4133nY));
            double d2 = vec3Position.y + ((this.f4135aJ - vec3Position.y) / ((double) this.f4133nY));
            double d3 = vec3Position.z + ((this.f4136aK - vec3Position.z) / ((double) this.f4133nY));
            setYRot(yRot + (((float) Mth.wrapDegrees(this.f4137aL - ((double) yRot))) / this.f4133nY));
            setXRot(xRot + (((float) (this.f4138aM - ((double) xRot))) / this.f4133nY));
            this.f4133nY--;
            setPos(d, d2, d3);
            setRot(yRot, xRot);
        }
    }

    /* JADX INFO: renamed from: bb */
    public int m3474bb() {
        return 1200;
    }

    /* JADX INFO: renamed from: bc */
    public int m3475bc() {
        return 60;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3476a(@NotNull ServerPlayer serverPlayer, @NotNull String str) {
        C0872pk c0872pkM4229a;
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4150fD && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
        UUID uuid = serverPlayer.getUUID();
        AbstractC0183b abstractC0183bM1153a = abstractC0184cM2351a.m1153a((Player) serverPlayer);
        if (abstractC0183bM1153a.f1411vf > 0 || C0875pn.m4488a((Player) serverPlayer, (AbstractC0183b<?, ?, ?, ?>) abstractC0183bM1153a)) {
            return false;
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
        if (abstractC0863pbMo2354a != null && (c0872pkM4229a = abstractC0863pbMo2354a.m4018b().m4229a(uuid)) != null) {
            if (!str.isEmpty() && !c0872pkM4229a.getName().equalsIgnoreCase(str)) {
                return false;
            }
            C1098tx c1098txM4296a = c0872pkM4229a.m4296a(abstractC0863pbMo2354a);
            if (this.f4147b == null || c1098txM4296a.f5988a == this.f4147b.f5988a) {
                return true;
            }
            MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.vehicle.wrong.team").withStyle(ChatFormatting.RED);
            C0875pn.m4364a(serverPlayer, (SoundEvent) C1312xz.f7963pk.get(), SoundSource.MASTER);
            C0875pn.m4406c(serverPlayer, (Component) mutableComponentWithStyle);
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: u */
    public void m3477u(@NotNull String str) {
        Object objM3732a = m3436b().m3732a(str);
        if (objM3732a instanceof C0816oh) {
            C0816oh c0816oh = (C0816oh) objM3732a;
            c0816oh.m3771c(level());
            if (c0816oh.m3763a() == EnumC0817oi.SHELL) {
                this.f4145kg = 1.0f;
            }
        }
    }

    /* JADX INFO: renamed from: y */
    public float m3478y(float f) {
        return C1270xJ.m7170f(this.f4145kg, this.f4146kh, f);
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        LivingEntity livingEntityM3452a = m3452a();
        if (livingEntityM3452a instanceof LivingEntity) {
            return livingEntityM3452a;
        }
        return null;
    }

    public void lerpTo(double d, double d2, double d3, float f, float f2, int i) {
        super.lerpTo(d, d2, d3, f, f2, i);
        this.f4134aI = d;
        this.f4135aJ = d2;
        this.f4136aK = d3;
        this.f4137aL = f;
        this.f4138aM = f2;
        this.f4133nY = 10;
    }

    protected void addPassenger(@NotNull Entity entity) {
        super.addPassenger(entity);
        C0820ol<?> c0820olMo3433a = mo3433a();
        if (isControlledByLocalInstance() && this.f4133nY > 0) {
            this.f4133nY = 0;
            absMoveTo(this.f4134aI, this.f4135aJ, this.f4136aK, (float) this.f4137aL, (float) this.f4138aM);
        }
        level().playLocalSound(this, (SoundEvent) c0820olMo3433a.f4459ap.get(), SoundSource.NEUTRAL, 1.0f, 0.8f + (0.2f * this.random.nextFloat()));
    }

    protected void removePassenger(@NotNull Entity entity) {
        super.removePassenger(entity);
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4150fD && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (!player.isCreative()) {
                player.getAbilities().mayfly = false;
            }
            abstractC0184cM2351a.m1153a(player).f1411vf = 60;
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
        C0755nZ c0755nZM3472a = m3472a(entity);
        if (c0755nZM3472a == null) {
            return;
        }
        int iIndexOf = passengers.indexOf(entity);
        float fM3781aK = 0.0f;
        Iterator it = m3436b().f4373ar.iterator();
        while (it.hasNext()) {
            AbstractC0818oj abstractC0818oj = (AbstractC0818oj) it.next();
            if (abstractC0818oj.f4435ok == iIndexOf || abstractC0818oj.f4436b.contains(iIndexOf)) {
                fM3781aK += abstractC0818oj.m3781aK();
            }
        }
        float yRot = getYRot();
        float f = (-this.f4130a.m3495aG()) / 5.0f;
        float fM3496aH = this.f4130a.m3496aH() / 5.0f;
        entity.setPos(position().add(new Vec3(c0755nZM3472a.f4180m).xRot(f).zRot(fM3496aH).yRot((-yRot) * 0.017453292f)).add(new Vec3(c0755nZM3472a.f4179e).xRot(f).zRot(fM3496aH).yRot((-(fM3781aK + yRot)) * 0.017453292f)));
        m3453a(entity, c0755nZM3472a);
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
        C0755nZ c0755nZM3472a = m3472a(entity);
        if (c0755nZM3472a != null) {
            m3453a(entity, c0755nZM3472a);
        }
    }

    protected boolean canAddPassenger(@NotNull Entity entity) {
        String strM3560L;
        if (m3441aZ()) {
            return false;
        }
        String strM3456Q = m3456Q();
        if (entity instanceof ServerPlayer) {
            if (!m3476a((ServerPlayer) entity, strM3456Q)) {
                return false;
            }
        } else if (entity instanceof C0756na) {
            C0756na c0756na = (C0756na) entity;
            if (!strM3456Q.isEmpty() && ((strM3560L = c0756na.m3560L()) == null || !strM3560L.equalsIgnoreCase(strM3456Q))) {
                return false;
            }
        }
        return getPassengers().size() < m3436b().f4372aq.size();
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
        return m3426a(this, entity);
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    @Override // com.boehmod.blockfront.C0697mU
    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @Override // com.boehmod.blockfront.C0697mU
    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return mo3434a(serverEntity);
    }

    @NotNull
    public AABB getBoundingBoxForCulling() {
        return super.getBoundingBoxForCulling().inflate(3.0d);
    }
}
