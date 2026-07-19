package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievements;
import java.util.Iterator;
import java.util.UUID;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mA.class */
public abstract class mA extends ThrowableProjectile implements ItemSupplier {
    private static final EntityDataAccessor<ItemStack> a;
    private static final float iw = 5.0f;
    private static final double af = 0.8d;
    private static final double ag = 0.1d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    protected Player f236a;
    protected boolean ew;
    private boolean ex;
    static final /* synthetic */ boolean ey;

    protected abstract boolean aA();

    public abstract float ar();

    public abstract float as();

    static {
        ey = !mA.class.desiredAssertionStatus();
        a = SynchedEntityData.defineId(mA.class, EntityDataSerializers.ITEM_STACK);
    }

    protected mA(@NotNull EntityType<? extends ThrowableProjectile> entityType, @NotNull Level level) {
        super(entityType, level);
        this.ew = false;
        this.ex = true;
    }

    public mA a(@NotNull ItemStack itemStack) {
        this.entityData.set(a, itemStack);
        return this;
    }

    @NotNull
    public ItemStack getItem() {
        return (ItemStack) this.entityData.get(a);
    }

    @OverridingMethodsMustInvokeSuper
    public void a(@NotNull ServerPlayer serverPlayer, float f, @NotNull ItemStack itemStack) {
        a(itemStack);
        c((Player) serverPlayer);
        float f2 = f;
        if (serverPlayer.getDeltaMovement().y > 0.0d) {
            f2 += 0.3f;
        }
        a(serverPlayer.getEyePosition(), serverPlayer.getYRot(), serverPlayer.getXRot(), Math.min(f, ap()), Math.min(f2, aq()));
    }

    private static void a(@NotNull Level level, @NotNull BlockPos blockPos) {
        BlockState blockState = level.getBlockState(blockPos);
        wW block = blockState.getBlock();
        boolean z = (block instanceof wW) && block.dq();
        if (block instanceof DoorBlock) {
            wW wWVar = block;
            if (!block.equals(Blocks.IRON_DOOR) && !z && !((Boolean) blockState.getValue(DoorBlock.OPEN)).booleanValue()) {
                wWVar.setOpen((Entity) null, level, blockState, blockPos, true);
                level.sendBlockUpdated(blockPos, blockState, blockState, 1);
                level.playLocalSound(blockPos.getX(), blockPos.getY(), blockPos.getZ(), SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR, SoundSource.BLOCKS, 1.0f, 0.75f, false);
            }
        }
    }

    protected float ap() {
        return 1.5f;
    }

    protected float aq() {
        return 1.5f;
    }

    public void bt() {
        this.ex = false;
    }

    public void c(@Nullable Player player) {
        this.f236a = player;
    }

    protected void a(@NotNull Vec3 vec3, float f, float f2, float f3, float f4) {
        setRot(f, f2);
        float f5 = -Mth.sin(f * 0.017453292f);
        float fCos = Mth.cos(f * 0.017453292f);
        float fCos2 = Mth.cos(f2 * 0.017453292f);
        float fSin = Mth.sin(f2 * 0.017453292f);
        Vec3 deltaMovement = getDeltaMovement();
        if (f4 == 0.0f && f3 > 0.0f) {
            f4 = f3;
        }
        setDeltaMovement(deltaMovement.x + ((double) (f3 * f5 * fCos2)), deltaMovement.y - ((double) (f4 * fSin)), deltaMovement.z + ((double) (f3 * fCos * fCos2)));
        Vec3 vec32 = new Vec3(vec3.x + (((double) f5) * 0.8d), vec3.y + ((double) (((-f2) * 2.0f) / 90.0f)), vec3.z + (((double) fCos) * 0.8d));
        BlockHitResult blockHitResultClip = level().clip(new ClipContext(vec3, vec32, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
        if (blockHitResultClip.getType() != HitResult.Type.MISS) {
            vec32 = blockHitResultClip.getLocation().subtract(vec32.subtract(vec3).normalize().scale(0.1d));
        }
        teleportTo(vec32.x, vec32.y, vec32.z);
        Vec3 vec3Position = position();
        this.xOld = vec3Position.x;
        this.yOld = vec3Position.y;
        this.zOld = vec3Position.z;
    }

    public void c(@NotNull LivingEntity livingEntity) {
        if (livingEntity instanceof ServerPlayer) {
            a((ServerPlayer) livingEntity);
        }
        bu();
    }

    private void a(@NotNull ServerPlayer serverPlayer) {
        if (onGround()) {
            return;
        }
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!ey && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        UUID uuid = serverPlayer.getUUID();
        oF<?, ?, ?> oFVarMo604a = abstractC0264juM166a.mo604a(uuid);
        if (oFVarMo604a == null || this.f236a == null) {
            return;
        }
        UUID uuid2 = this.f236a.getUUID();
        if (oFVarMo604a.equals(abstractC0264juM166a.mo604a(uuid2)) && !oR.a(abstractC0264juM166a, uuid, uuid2)) {
            oR.a(abstractC0264juM166a, uuid, CloudAchievements.ACH_USER_SHOOT_GRENADE);
        }
    }

    public void bu() {
        if (this.ew) {
            return;
        }
        this.ew = true;
        Level level = level();
        BlockPos blockPosBlockPosition = blockPosition();
        Vec3 vec3AtCenterOf = Vec3.atCenterOf(blockPosBlockPosition);
        oE oEVar = this instanceof C0353nb ? oE.ARTILLERY_EXPLOSION : oE.GENERIC;
        if (this.ex) {
            if (level.isClientSide()) {
                a(level, oEVar, vec3AtCenterOf);
            } else {
                a(level, vec3AtCenterOf, oEVar, blockPosBlockPosition);
            }
        }
        discard();
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull Level level, @NotNull oE oEVar, @NotNull Vec3 vec3) {
        Minecraft minecraft = Minecraft.getInstance();
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            if (iG.a(this)) {
                C0297l c0297lB = C0297l.b();
                if (!ey && c0297lB == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                C0345mu.a(minecraft, c0297lB, clientLevel, oEVar, vec3);
            }
        }
    }

    private void a(@NotNull Level level, @NotNull Vec3 vec3, @NotNull oE oEVar, @NotNull BlockPos blockPos) {
        UUID uuid = this.f236a != null ? this.f236a.getUUID() : null;
        AABB boundingBox = getBoundingBox();
        if (aB()) {
            Iterator it = level.getEntities(this, boundingBox.inflate(5.0d, 5.0d, 5.0d), entity -> {
                return entity instanceof C0371nt;
            }).iterator();
            while (it.hasNext()) {
                ((Entity) it.next()).bu();
            }
        }
        if (aA()) {
            float fAs = as();
            for (Entity entity2 : level.getEntities(this, boundingBox.inflate(fAs, fAs, fAs), entity3 -> {
                return entity3 instanceof AbstractC0376ny;
            })) {
                if (level.clip(new ClipContext(entity2.position(), position(), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity2)).getType().equals(HitResult.Type.MISS)) {
                    AbstractC0376ny abstractC0376ny = (AbstractC0376ny) entity2;
                    float fMax = Math.max(ar() * (1.0f - (distanceTo(abstractC0376ny) / fAs)), 0.0f);
                    if (fMax > 0.0f) {
                        abstractC0376ny.a(getItem(), this.f236a, fMax);
                    }
                }
            }
        }
        a(this.f236a, vec3, at());
        for (ServerPlayer serverPlayer : level.players()) {
            C0588vu c0588vu = new C0588vu(oEVar, vec3);
            if (serverPlayer instanceof ServerPlayer) {
                C0582vo.a(c0588vu, serverPlayer);
            }
        }
        if (uuid != null) {
            int iM664as = m664as();
            for (int i = -iM664as; i < iM664as; i++) {
                for (int i2 = -iM664as; i2 < iM664as; i2++) {
                    for (int i3 = -iM664as; i3 < iM664as; i3++) {
                        a(level, new BlockPos(blockPos.getX() + i, blockPos.getY() + i2, blockPos.getZ() + i3));
                    }
                }
            }
        }
    }

    private boolean aB() {
        return true;
    }

    public final boolean aC() {
        return this.ew;
    }

    protected void a(@Nullable Entity entity, @NotNull Vec3 vec3, float f) {
        ItemStack item = getItem();
        if (entity == null || item.isEmpty()) {
            return;
        }
        Explosion explosionA = oR.a(level(), (Entity) this, vec3, item, f);
        explosionA.explode();
        explosionA.finalizeExplosion(true);
        explosionA.clearToBlow();
    }

    /* JADX INFO: renamed from: as, reason: collision with other method in class */
    protected int m664as() {
        return 4;
    }

    protected float at() {
        return 5.5f;
    }

    @Nullable
    public Player a() {
        return this.f236a;
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("exploded", this.ew);
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.ew = compoundTag.getBoolean("exploded");
    }

    public void tick() {
        super.tick();
        if (!level().isClientSide && this.f236a == null) {
            discard();
        }
    }

    protected void onHit(@NotNull HitResult hitResult) {
    }

    public void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(a, new ItemStack((ItemLike) wY.X.get()));
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
