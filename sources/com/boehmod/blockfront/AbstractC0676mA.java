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

/* JADX INFO: renamed from: com.boehmod.blockfront.mA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mA.class */
public abstract class AbstractC0676mA extends ThrowableProjectile implements ItemSupplier {

    /* JADX INFO: renamed from: a */
    private static final EntityDataAccessor<ItemStack> f3607a;

    /* JADX INFO: renamed from: iw */
    private static final float f3608iw = 5.0f;

    /* JADX INFO: renamed from: af */
    private static final double f3609af = 0.8d;

    /* JADX INFO: renamed from: ag */
    private static final double f3610ag = 0.1d;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected Player f3611a;

    /* JADX INFO: renamed from: ew */
    protected boolean f3612ew;

    /* JADX INFO: renamed from: ex */
    private boolean f3613ex;

    /* JADX INFO: renamed from: ey */
    static final /* synthetic */ boolean f3614ey;

    /* JADX INFO: renamed from: aA */
    protected abstract boolean mo2984aA();

    /* JADX INFO: renamed from: ar */
    public abstract float mo2988ar();

    /* JADX INFO: renamed from: as */
    public abstract float mo2989as();

    static {
        f3614ey = !AbstractC0676mA.class.desiredAssertionStatus();
        f3607a = SynchedEntityData.defineId(AbstractC0676mA.class, EntityDataSerializers.ITEM_STACK);
    }

    protected AbstractC0676mA(@NotNull EntityType<? extends ThrowableProjectile> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f3612ew = false;
        this.f3613ex = true;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0676mA mo2971a(@NotNull ItemStack itemStack) {
        this.entityData.set(f3607a, itemStack);
        return this;
    }

    @NotNull
    public ItemStack getItem() {
        return (ItemStack) this.entityData.get(f3607a);
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo2972a(@NotNull ServerPlayer serverPlayer, float f, @NotNull ItemStack itemStack) {
        mo2971a(itemStack);
        m2977c((Player) serverPlayer);
        float f2 = f;
        if (serverPlayer.getDeltaMovement().y > 0.0d) {
            f2 += 0.3f;
        }
        m2978a(serverPlayer.getEyePosition(), serverPlayer.getYRot(), serverPlayer.getXRot(), Math.min(f, mo2974ap()), Math.min(f2, mo2975aq()));
    }

    /* JADX INFO: renamed from: a */
    private static void m2973a(@NotNull Level level, @NotNull BlockPos blockPos) {
        BlockState blockState = level.getBlockState(blockPos);
        C1229wW block = blockState.getBlock();
        boolean z = (block instanceof C1229wW) && block.m7362dq();
        if (block instanceof DoorBlock) {
            C1229wW c1229wW = block;
            if (!block.equals(Blocks.IRON_DOOR) && !z && !((Boolean) blockState.getValue(DoorBlock.OPEN)).booleanValue()) {
                c1229wW.setOpen((Entity) null, level, blockState, blockPos, true);
                level.sendBlockUpdated(blockPos, blockState, blockState, 1);
                level.playLocalSound(blockPos.getX(), blockPos.getY(), blockPos.getZ(), SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR, SoundSource.BLOCKS, 1.0f, 0.75f, false);
            }
        }
    }

    /* JADX INFO: renamed from: ap */
    protected float mo2974ap() {
        return 1.5f;
    }

    /* JADX INFO: renamed from: aq */
    protected float mo2975aq() {
        return 1.5f;
    }

    /* JADX INFO: renamed from: bt */
    public void m2976bt() {
        this.f3613ex = false;
    }

    /* JADX INFO: renamed from: c */
    public void m2977c(@Nullable Player player) {
        this.f3611a = player;
    }

    /* JADX INFO: renamed from: a */
    protected void m2978a(@NotNull Vec3 vec3, float f, float f2, float f3, float f4) {
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

    /* JADX INFO: renamed from: c */
    public void m2979c(@NotNull LivingEntity livingEntity) {
        if (livingEntity instanceof ServerPlayer) {
            m2980a((ServerPlayer) livingEntity);
        }
        mo2981bu();
    }

    /* JADX INFO: renamed from: a */
    private void m2980a(@NotNull ServerPlayer serverPlayer) {
        if (onGround()) {
            return;
        }
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f3614ey && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        UUID uuid = serverPlayer.getUUID();
        AbstractC0787oF<?, ?, ?> abstractC0787oFMo2531a = abstractC0563juM168a.mo2531a(uuid);
        if (abstractC0787oFMo2531a == null || this.f3611a == null) {
            return;
        }
        UUID uuid2 = this.f3611a.getUUID();
        if (abstractC0787oFMo2531a.equals(abstractC0563juM168a.mo2531a(uuid2)) && !C0799oR.m4040a(abstractC0563juM168a, uuid, uuid2)) {
            C0799oR.m4025a(abstractC0563juM168a, uuid, CloudAchievements.ACH_USER_SHOOT_GRENADE);
        }
    }

    /* JADX INFO: renamed from: bu */
    public void mo2981bu() {
        if (this.f3612ew) {
            return;
        }
        this.f3612ew = true;
        Level level = level();
        BlockPos blockPosBlockPosition = blockPosition();
        Vec3 vec3AtCenterOf = Vec3.atCenterOf(blockPosBlockPosition);
        EnumC0786oE enumC0786oE = this instanceof C0756nb ? EnumC0786oE.ARTILLERY_EXPLOSION : EnumC0786oE.GENERIC;
        if (this.f3613ex) {
            if (level.isClientSide()) {
                m2982a(level, enumC0786oE, vec3AtCenterOf);
            } else {
                m2983a(level, vec3AtCenterOf, enumC0786oE, blockPosBlockPosition);
            }
        }
        discard();
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m2982a(@NotNull Level level, @NotNull EnumC0786oE enumC0786oE, @NotNull Vec3 vec3) {
        Minecraft minecraft = Minecraft.getInstance();
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            if (C0470iG.m2122a(this)) {
                C0622l c0622lM2667b = C0622l.m2667b();
                if (!f3614ey && c0622lM2667b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                C0722mu.m3269a(minecraft, c0622lM2667b, clientLevel, enumC0786oE, vec3);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2983a(@NotNull Level level, @NotNull Vec3 vec3, @NotNull EnumC0786oE enumC0786oE, @NotNull BlockPos blockPos) {
        UUID uuid = this.f3611a != null ? this.f3611a.getUUID() : null;
        AABB boundingBox = getBoundingBox();
        if (m2985aB()) {
            Iterator it = level.getEntities(this, boundingBox.inflate(5.0d, 5.0d, 5.0d), entity -> {
                return entity instanceof C0774nt;
            }).iterator();
            while (it.hasNext()) {
                ((Entity) it.next()).mo2981bu();
            }
        }
        if (mo2984aA()) {
            float fMo2989as = mo2989as();
            for (Entity entity2 : level.getEntities(this, boundingBox.inflate(fMo2989as, fMo2989as, fMo2989as), entity3 -> {
                return entity3 instanceof AbstractC0779ny;
            })) {
                if (level.clip(new ClipContext(entity2.position(), position(), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity2)).getType().equals(HitResult.Type.MISS)) {
                    AbstractC0779ny abstractC0779ny = (AbstractC0779ny) entity2;
                    float fMax = Math.max(mo2988ar() * (1.0f - (distanceTo(abstractC0779ny) / fMo2989as)), 0.0f);
                    if (fMax > 0.0f) {
                        abstractC0779ny.m3517a(getItem(), this.f3611a, fMax);
                    }
                }
            }
        }
        m2987a(this.f3611a, vec3, mo2991at());
        for (ServerPlayer serverPlayer : level.players()) {
            C1200vu c1200vu = new C1200vu(enumC0786oE, vec3);
            if (serverPlayer instanceof ServerPlayer) {
                C1194vo.m6648a(c1200vu, serverPlayer);
            }
        }
        if (uuid != null) {
            int iM2990as = m2990as();
            for (int i = -iM2990as; i < iM2990as; i++) {
                for (int i2 = -iM2990as; i2 < iM2990as; i2++) {
                    for (int i3 = -iM2990as; i3 < iM2990as; i3++) {
                        m2973a(level, new BlockPos(blockPos.getX() + i, blockPos.getY() + i2, blockPos.getZ() + i3));
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: aB */
    private boolean m2985aB() {
        return true;
    }

    /* JADX INFO: renamed from: aC */
    public final boolean m2986aC() {
        return this.f3612ew;
    }

    /* JADX INFO: renamed from: a */
    protected void m2987a(@Nullable Entity entity, @NotNull Vec3 vec3, float f) {
        ItemStack item = getItem();
        if (entity == null || item.isEmpty()) {
            return;
        }
        Explosion explosionM4054a = C0799oR.m4054a(level(), (Entity) this, vec3, item, f);
        explosionM4054a.explode();
        explosionM4054a.finalizeExplosion(true);
        explosionM4054a.clearToBlow();
    }

    /* JADX INFO: renamed from: as */
    protected int m2990as() {
        return 4;
    }

    /* JADX INFO: renamed from: at */
    protected float mo2991at() {
        return 5.5f;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Player m2992a() {
        return this.f3611a;
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("exploded", this.f3612ew);
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.f3612ew = compoundTag.getBoolean("exploded");
    }

    public void tick() {
        super.tick();
        if (!level().isClientSide && this.f3611a == null) {
            discard();
        }
    }

    protected void onHit(@NotNull HitResult hitResult) {
    }

    public void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(f3607a, new ItemStack((ItemLike) C1231wY.f7153X.get()));
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
