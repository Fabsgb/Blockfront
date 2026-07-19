package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.ny, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ny.class */
public abstract class AbstractC0376ny extends C0349my {
    private static final int lZ = 25;
    private static final EntityDataAccessor<Float> y;
    private static final EntityDataAccessor<Boolean> z;
    private static final EntityDataAccessor<String> A;
    private static final EntityDataAccessor<Boolean> B;
    private static final EntityDataAccessor<Boolean> C;
    private static final EntityDataAccessor<Boolean> D;
    private static final EntityDataAccessor<Boolean> E;
    private static final EntityDataAccessor<Boolean> F;
    private static final EntityDataAccessor<Boolean> G;
    private static final EntityDataAccessor<Float> H;

    @NotNull
    public final nC a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final lN f258a;

    @NotNull
    private final lN b;
    private int ma;
    private double av;
    private double aw;
    private double ax;
    private double ay;
    private double az;
    private boolean fh;
    private int mb;
    private int mc;
    private int md;
    private int me;
    private boolean fi;
    private float jn;
    private float jo;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    private C0514ta f259b;

    @Nullable
    private UUID o;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private nE<AbstractC0376ny> f260a;
    static final /* synthetic */ boolean fj;

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    protected abstract nE<AbstractC0376ny> mo739a();

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract nP<?> mo740a();

    public abstract Packet<ClientGamePacketListener> a(ServerEntity serverEntity);

    public abstract float ax();

    static {
        fj = !AbstractC0376ny.class.desiredAssertionStatus();
        y = SynchedEntityData.defineId(AbstractC0376ny.class, EntityDataSerializers.FLOAT);
        z = SynchedEntityData.defineId(AbstractC0376ny.class, EntityDataSerializers.BOOLEAN);
        A = SynchedEntityData.defineId(AbstractC0376ny.class, EntityDataSerializers.STRING);
        B = SynchedEntityData.defineId(AbstractC0376ny.class, EntityDataSerializers.BOOLEAN);
        C = SynchedEntityData.defineId(AbstractC0376ny.class, EntityDataSerializers.BOOLEAN);
        D = SynchedEntityData.defineId(AbstractC0376ny.class, EntityDataSerializers.BOOLEAN);
        E = SynchedEntityData.defineId(AbstractC0376ny.class, EntityDataSerializers.BOOLEAN);
        F = SynchedEntityData.defineId(AbstractC0376ny.class, EntityDataSerializers.BOOLEAN);
        G = SynchedEntityData.defineId(AbstractC0376ny.class, EntityDataSerializers.BOOLEAN);
        H = SynchedEntityData.defineId(AbstractC0376ny.class, EntityDataSerializers.FLOAT);
    }

    public AbstractC0376ny(@NotNull EntityType<? extends AbstractC0376ny> entityType, @NotNull Level level, @NotNull BlockEntityType<? extends lN> blockEntityType, @NotNull BlockState blockState, @NotNull BlockEntityType<? extends lN> blockEntityType2, @NotNull BlockState blockState2) {
        super(entityType, level);
        this.a = new nC();
        this.fh = false;
        this.mb = 1200;
        this.mc = 0;
        this.md = 1200;
        this.me = 25;
        this.fi = false;
        this.jo = 0.0f;
        this.f259b = null;
        this.o = null;
        this.f258a = (lN) blockEntityType.create(BlockPos.ZERO, blockState);
        this.b = (lN) blockEntityType2.create(BlockPos.ZERO, blockState2);
        if (this.f258a != null) {
            this.f258a.a(this);
        }
        if (this.b != null) {
            this.b.a(this);
        }
        this.blocksBuilding = true;
    }

    public static boolean a(@NotNull Entity entity, @NotNull Entity entity2) {
        return (entity2.canBeCollidedWith() || entity2.isPushable()) && !entity.isPassengerOfSameVehicle(entity2);
    }

    @Nullable
    public UUID d() {
        return this.o;
    }

    public void b(@Nullable UUID uuid) {
        this.o = uuid;
    }

    public void a(@Nullable C0514ta c0514ta) {
        this.f259b = c0514ta;
    }

    @NotNull
    public lN a() {
        return this.f258a;
    }

    @NotNull
    public lN b() {
        return this.b;
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public nE<AbstractC0376ny> m741b() {
        if (this.f260a == null) {
            this.f260a = mo739a();
        }
        return this.f260a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public nC m742a() {
        return this.a;
    }

    public void cf() {
        if (aP() || this.a == null) {
            return;
        }
        if (!getPassengers().isEmpty()) {
            this.mb = 0;
            this.fh = true;
            return;
        }
        if (this.fh) {
            int i = this.mb;
            this.mb = i + 1;
            if (i >= aM()) {
                int i2 = this.mc;
                this.mc = i2 + 1;
                if (i2 >= aN()) {
                    this.mc = 0;
                    a(null, null, 1.0f);
                }
            }
        }
    }

    @Nullable
    private String I() {
        UUID uuid;
        oF<?, ?, ?> oFVarMo604a;
        oO oOVarA;
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fj && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        for (Player player : getPassengers()) {
            if ((player instanceof Player) && (oFVarMo604a = abstractC0264juM166a.mo604a((uuid = player.getUUID()))) != null && (oOVarA = oFVarMo604a.b().a(uuid)) != null) {
                return oOVarA.getName();
            }
        }
        return null;
    }

    public void cg() {
        int i = this.md;
        this.md = i - 1;
        if (i > 0) {
            return;
        }
        Level level = level();
        discard();
        for (ServerPlayer serverPlayer : level.players()) {
            if (serverPlayer instanceof ServerPlayer) {
                C0582vo.a(new C0588vu(oE.VEHICLE_EXPLOSION, new Vec3(getX(), getY(), getZ())), serverPlayer);
            }
        }
    }

    public boolean aP() {
        return az() <= 0.0f;
    }

    public float ay() {
        nE<AbstractC0376ny> nEVarM741b = m741b();
        if (nEVarM741b.a == null) {
            return 0.0f;
        }
        return (level().isClientSide && aY()) ? nEVarM741b.a.jd : ((Float) this.entityData.get(H)).floatValue();
    }

    public void j(float f) {
        this.entityData.set(H, Float.valueOf(f));
    }

    public float az() {
        return ((Float) this.entityData.get(y)).floatValue();
    }

    public void k(float f) {
        this.entityData.set(y, Float.valueOf(f));
    }

    public boolean aQ() {
        return !aP() && az() < m741b().jC * 0.25f;
    }

    public boolean aR() {
        return ((Boolean) this.entityData.get(z)).booleanValue();
    }

    public void G(boolean z2) {
        if (z2 == aR()) {
            return;
        }
        this.entityData.set(z, Boolean.valueOf(z2));
    }

    public boolean d(@NotNull Player player) {
        oO oOVarA;
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fj && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is not null!");
        }
        UUID uuid = player.getUUID();
        oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
        return (oFVarMo604a == null || (oOVarA = oFVarMo604a.b().a(uuid)) == null || !oOVarA.getName().equals(J())) ? false : true;
    }

    public boolean k(@NotNull Entity entity) {
        nD nDVarA = a(entity);
        return nDVarA != null && nDVarA.fq;
    }

    public boolean l(@NotNull Entity entity) {
        nD nDVarA = a(entity);
        return nDVarA != null && nDVarA.fp;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Entity m743a() {
        nE<AbstractC0376ny> nEVarM741b = m741b();
        List passengers = getPassengers();
        int iAO = nEVarM741b.aO();
        if (iAO > -1 && iAO < passengers.size()) {
            return (Entity) passengers.get(iAO);
        }
        return null;
    }

    protected void a(@NotNull Entity entity, @NotNull nD nDVar) {
        float fAE = 0.0f;
        if (hasPassenger(entity)) {
            int iIndexOf = getPassengers().indexOf(entity);
            Iterator it = m741b().ak.iterator();
            while (it.hasNext()) {
                nN nNVar = (nN) it.next();
                if (nNVar.mm == iIndexOf || nNVar.b.contains(iIndexOf)) {
                    fAE += nNVar.aE();
                }
            }
        }
        float yRot = getYRot() + fAE;
        entity.setYBodyRot(yRot);
        float fWrapDegrees = Mth.wrapDegrees((entity.getYRot() - yRot) + nDVar.jx);
        float fClamp = Mth.clamp(fWrapDegrees, -nDVar.jz, nDVar.jz);
        float fWrapDegrees2 = Mth.wrapDegrees(entity.getXRot());
        float fClamp2 = Mth.clamp(fWrapDegrees2, -nDVar.jy, nDVar.jy);
        entity.yRotO += fClamp - fWrapDegrees;
        entity.setYRot((entity.getYRot() + fClamp) - fWrapDegrees);
        entity.setYHeadRot(entity.getYRot());
        entity.xRotO += fClamp2 - fWrapDegrees2;
        entity.setXRot((entity.getXRot() + fClamp2) - fWrapDegrees2);
    }

    public void a(@Nullable ItemStack itemStack, @Nullable Player player, float f) {
        nP<?> nPVarMo740a = mo740a();
        playSound((SoundEvent) nPVarMo740a.aq.get(), 2.0f, 1.0f);
        playSound((SoundEvent) nPVarMo740a.ar.get(), 15.0f, 1.0f);
        if (nPVarMo740a.as != null) {
            SoundEvent soundEvent = (SoundEvent) nPVarMo740a.as.get();
            for (ServerPlayer serverPlayer : getPassengers()) {
                if (serverPlayer instanceof ServerPlayer) {
                    serverPlayer.playNotifySound(soundEvent, SoundSource.NEUTRAL, 15.0f, 1.0f);
                }
            }
        }
        if (!aP()) {
            boolean z2 = false;
            float fMax = Math.max(az() - f, 0.0f);
            k(fMax);
            if (fMax <= 0.0f) {
                a(itemStack, player);
                z2 = true;
            }
            if (player instanceof ServerPlayer) {
                C0582vo.a(new vA(z2), (ServerPlayer) player);
            }
        }
    }

    public void a(@Nullable ItemStack itemStack, @Nullable Player player) {
        UUID uuid;
        oF<?, ?, ?> oFVarMo604a;
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fj && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        Level level = level();
        C0582vo.b(new C0588vu(oE.VEHICLE_EXPLOSION, position()));
        if (player != null && (oFVarMo604a = abstractC0264juM166a.mo604a((uuid = player.getUUID()))) != null) {
            oR.a(abstractC0264juM166a, oFVarMo604a, uuid, C0529tp.F);
        }
        ObjectArrayList objectArrayList = new ObjectArrayList(getPassengers());
        ejectPassengers();
        DamageSources damageSources = level.damageSources();
        DamageSource damageSourceGeneric = damageSources.generic();
        if (player != null) {
            DamageSource damageSourcePlayerAttack = damageSources.playerAttack(player);
            if (itemStack != null) {
                damageSourceGeneric = new C0326mb(damageSourcePlayerAttack.typeHolder(), player, itemStack);
            } else {
                damageSourceGeneric = damageSourcePlayerAttack;
            }
        }
        ObjectListIterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            ((Entity) it.next()).hurt(damageSourceGeneric, Float.MAX_VALUE);
        }
    }

    public String J() {
        return (String) this.entityData.get(A);
    }

    public void ch() {
        String strI = I();
        this.entityData.set(A, strI == null ? "" : strI);
    }

    public boolean aS() {
        nE<AbstractC0376ny> nEVarM741b = m741b();
        if (nEVarM741b.a == null) {
            return false;
        }
        return (level().isClientSide && aY()) ? nEVarM741b.a.fb : ((Boolean) this.entityData.get(B)).booleanValue();
    }

    public void H(boolean z2) {
        this.entityData.set(B, Boolean.valueOf(z2));
    }

    public boolean aT() {
        nE<AbstractC0376ny> nEVarM741b = m741b();
        if (nEVarM741b.a == null) {
            return false;
        }
        return (level().isClientSide && aY()) ? nEVarM741b.a.fc : ((Boolean) this.entityData.get(C)).booleanValue();
    }

    public void I(boolean z2) {
        this.entityData.set(C, Boolean.valueOf(z2));
    }

    public boolean aU() {
        nE<AbstractC0376ny> nEVarM741b = m741b();
        if (nEVarM741b.a == null) {
            return false;
        }
        return (level().isClientSide && aY()) ? nEVarM741b.a.fd : ((Boolean) this.entityData.get(D)).booleanValue();
    }

    public void J(boolean z2) {
        this.entityData.set(D, Boolean.valueOf(z2));
    }

    public boolean aV() {
        nE<AbstractC0376ny> nEVarM741b = m741b();
        if (nEVarM741b.a == null) {
            return false;
        }
        return (level().isClientSide && aY()) ? nEVarM741b.a.fe : ((Boolean) this.entityData.get(E)).booleanValue();
    }

    public void K(boolean z2) {
        this.entityData.set(E, Boolean.valueOf(z2));
    }

    public boolean aW() {
        nE<AbstractC0376ny> nEVarM741b = m741b();
        if (nEVarM741b.a == null) {
            return false;
        }
        return (level().isClientSide && aY()) ? nEVarM741b.a.ff : ((Boolean) this.entityData.get(F)).booleanValue();
    }

    public void L(boolean z2) {
        this.entityData.set(F, Boolean.valueOf(z2));
    }

    public boolean aX() {
        nE<AbstractC0376ny> nEVarM741b = m741b();
        if (nEVarM741b.a == null) {
            return false;
        }
        return (level().isClientSide && aY()) ? nEVarM741b.a.fg : ((Boolean) this.entityData.get(G)).booleanValue();
    }

    public void M(boolean z2) {
        this.entityData.set(G, Boolean.valueOf(z2));
    }

    public float maxUpStep() {
        return 1.0f;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean aY() {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        return localPlayer != null && localPlayer.equals(m743a());
    }

    @Override // com.boehmod.blockfront.C0349my
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        builder.define(y, Float.valueOf(m741b().jC)).define(z, false).define(A, "").define(B, false).define(C, false).define(D, false).define(E, false).define(F, false).define(G, false).define(H, Float.valueOf(0.0f));
    }

    @Override // com.boehmod.blockfront.C0349my
    public void tick() {
        super.tick();
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fj && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is not null!");
        }
        ci();
        Level level = level();
        nE<AbstractC0376ny> nEVarM741b = m741b();
        List<ServerPlayer> passengers = getPassengers();
        boolean zAP = aP();
        Entity entityM743a = m743a();
        G(entityM743a != null);
        if (entityM743a == null) {
            H(false);
            I(false);
            J(false);
            K(false);
            L(false);
            j(0.0f);
        }
        this.a.c(this);
        if (level.isClientSide) {
            this.jo = this.jn;
            this.jn = Mth.lerp(0.2f, this.jn, 0.0f);
            mo740a().z(Minecraft.getInstance());
            Iterator it = nEVarM741b.ak.iterator();
            while (it.hasNext()) {
                ((nN) it.next()).f(this);
            }
            Iterator it2 = nEVarM741b.al.iterator();
            while (it2.hasNext()) {
                ((nJ) it2.next()).f(this);
            }
            if (aP()) {
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
            ch();
            cf();
            if (!this.fi) {
                this.fi = true;
                Iterator it3 = nEVarM741b.ak.iterator();
                while (it3.hasNext()) {
                    nN nNVar = (nN) it3.next();
                    if (nNVar instanceof nL) {
                        nL nLVar = (nL) nNVar;
                        if (this instanceof nA) {
                            nA nAVar = (nA) this;
                            nAVar.a(nLVar).a(nAVar.entityData, nLVar.aQ());
                        }
                    }
                }
            }
            if (aQ()) {
                int i = this.me;
                this.me = i - 1;
                if (i <= 0) {
                    this.me = 25;
                    DeferredHolder<SoundEvent, SoundEvent> deferredHolder = mo740a().an;
                    DeferredHolder<SoundEvent, SoundEvent> deferredHolder2 = mo740a().ao;
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
            Iterator it4 = nEVarM741b.ak.iterator();
            while (it4.hasNext()) {
                ((nN) it4.next()).c(this);
            }
            Iterator it5 = nEVarM741b.al.iterator();
            while (it5.hasNext()) {
                ((nJ) it5.next()).c(this);
            }
            if (zAP) {
                cg();
            }
        }
        if (isControlledByLocalInstance()) {
            if (level.isClientSide) {
                a(nEVarM741b, entityM743a);
            }
        } else {
            setDeltaMovement(Vec3.ZERO);
        }
        if (nEVarM741b.a != null) {
            nEVarM741b.a.b(this);
        }
        com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
        for (ServerPlayer serverPlayer2 : passengers) {
            if (serverPlayer2 instanceof ServerPlayer) {
                ServerPlayer serverPlayer3 = serverPlayer2;
                serverPlayer3.getAbilities().mayfly = true;
                if (oR.a((Player) serverPlayer3, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) cVarM531a.m305a((Player) serverPlayer3))) {
                    serverPlayer2.stopRiding();
                }
            }
        }
        if (zAP || isRemoved()) {
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
    public void a(@NotNull nE<AbstractC0376ny> nEVar, @Nullable Entity entity) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer != null && nEVar.a != null) {
            nEVar.a.a(localPlayer, this, localPlayer.equals(entity));
        }
    }

    @Nullable
    public nD a(@NotNull Entity entity) {
        nE<AbstractC0376ny> nEVarM741b = m741b();
        if (hasPassenger(entity)) {
            return nEVarM741b.m716a(getPassengers().indexOf(entity));
        }
        return null;
    }

    private void ci() {
        Vec3 vec3Position = position();
        if (isControlledByLocalInstance()) {
            this.ma = 0;
            syncPacketPositionCodec(getX(), getY(), getZ());
        }
        if (this.ma > 0) {
            float xRot = getXRot();
            float yRot = getYRot();
            double d = vec3Position.x + ((this.av - vec3Position.x) / ((double) this.ma));
            double d2 = vec3Position.y + ((this.aw - vec3Position.y) / ((double) this.ma));
            double d3 = vec3Position.z + ((this.ax - vec3Position.z) / ((double) this.ma));
            setYRot(yRot + (((float) Mth.wrapDegrees(this.ay - ((double) yRot))) / this.ma));
            setXRot(xRot + (((float) (this.az - ((double) xRot))) / this.ma));
            this.ma--;
            setPos(d, d2, d3);
            setRot(yRot, xRot);
        }
    }

    public int aM() {
        return 1200;
    }

    public int aN() {
        return 60;
    }

    private boolean a(@NotNull ServerPlayer serverPlayer, @NotNull String str) {
        oO oOVarA;
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fj && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
        UUID uuid = serverPlayer.getUUID();
        com.boehmod.blockfront.common.player.b bVarM305a = cVarM531a.m305a((Player) serverPlayer);
        if (bVarM305a.tb > 0 || oR.a((Player) serverPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) bVarM305a)) {
            return false;
        }
        oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
        if (oFVarMo604a != null && (oOVarA = oFVarMo604a.b().a(uuid)) != null) {
            if (!str.isEmpty() && !oOVarA.getName().equalsIgnoreCase(str)) {
                return false;
            }
            C0514ta c0514taA = oOVarA.a(oFVarMo604a);
            if (this.f259b == null || c0514taA.a == this.f259b.a) {
                return true;
            }
            MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.vehicle.wrong.team").withStyle(ChatFormatting.RED);
            oR.a(serverPlayer, (SoundEvent) C0624xc.pi.get(), SoundSource.MASTER);
            oR.c(serverPlayer, (Component) mutableComponentWithStyle);
            return false;
        }
        return true;
    }

    public void u(@NotNull String str) {
        Object objM717a = m741b().m717a(str);
        if (objM717a instanceof nL) {
            nL nLVar = (nL) objM717a;
            nLVar.c(level());
            if (nLVar.m724a() == nM.SHELL) {
                this.jn = 1.0f;
            }
        }
    }

    public float v(float f) {
        return C0634xm.e(this.jn, this.jo, f);
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        LivingEntity livingEntityM743a = m743a();
        if (livingEntityM743a instanceof LivingEntity) {
            return livingEntityM743a;
        }
        return null;
    }

    public void lerpTo(double d, double d2, double d3, float f, float f2, int i) {
        super.lerpTo(d, d2, d3, f, f2, i);
        this.av = d;
        this.aw = d2;
        this.ax = d3;
        this.ay = f;
        this.az = f2;
        this.ma = 10;
    }

    protected void addPassenger(@NotNull Entity entity) {
        super.addPassenger(entity);
        nP<?> nPVarMo740a = mo740a();
        if (isControlledByLocalInstance() && this.ma > 0) {
            this.ma = 0;
            absMoveTo(this.av, this.aw, this.ax, (float) this.ay, (float) this.az);
        }
        level().playLocalSound(this, (SoundEvent) nPVarMo740a.ap.get(), SoundSource.NEUTRAL, 1.0f, 0.8f + (0.2f * this.random.nextFloat()));
    }

    protected void removePassenger(@NotNull Entity entity) {
        super.removePassenger(entity);
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!fj && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        com.boehmod.blockfront.common.player.c cVarM531a = abstractC0264juM166a.m531a();
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (!player.isCreative()) {
                player.getAbilities().mayfly = false;
            }
            cVarM531a.m305a(player).tb = 60;
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
        nD nDVarA = a(entity);
        if (nDVarA == null) {
            return;
        }
        int iIndexOf = passengers.indexOf(entity);
        float fAE = 0.0f;
        Iterator it = m741b().ak.iterator();
        while (it.hasNext()) {
            nN nNVar = (nN) it.next();
            if (nNVar.mm == iIndexOf || nNVar.b.contains(iIndexOf)) {
                fAE += nNVar.aE();
            }
        }
        float yRot = getYRot();
        float f = (-this.a.aA()) / 5.0f;
        float fAB = this.a.aB() / 5.0f;
        entity.setPos(position().add(new Vec3(nDVarA.k).xRot(f).zRot(fAB).yRot((-yRot) * 0.017453292f)).add(new Vec3(nDVarA.e).xRot(f).zRot(fAB).yRot((-(fAE + yRot)) * 0.017453292f)));
        a(entity, nDVarA);
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
        nD nDVarA = a(entity);
        if (nDVarA != null) {
            a(entity, nDVarA);
        }
    }

    protected boolean canAddPassenger(@NotNull Entity entity) {
        String strE;
        if (aP()) {
            return false;
        }
        String strJ = J();
        if (entity instanceof ServerPlayer) {
            if (!a((ServerPlayer) entity, strJ)) {
                return false;
            }
        } else if (entity instanceof mE) {
            mE mEVar = (mE) entity;
            if (!strJ.isEmpty() && ((strE = mEVar.E()) == null || !strE.equalsIgnoreCase(strJ))) {
                return false;
            }
        }
        return getPassengers().size() < m741b().aj.size();
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
        return a(this, entity);
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    @Override // com.boehmod.blockfront.C0349my
    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @Override // com.boehmod.blockfront.C0349my
    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return a(serverEntity);
    }

    @NotNull
    public AABB getBoundingBoxForCulling() {
        return super.getBoundingBoxForCulling().inflate(3.0d);
    }
}
