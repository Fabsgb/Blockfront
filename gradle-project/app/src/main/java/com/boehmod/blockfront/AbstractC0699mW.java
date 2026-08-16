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

/* JADX INFO: renamed from: com.boehmod.blockfront.mW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mW.class */
public abstract class AbstractC0699mW extends ThrowableProjectile implements ItemSupplier {

    /* JADX INFO: renamed from: a */
    private static final EntityDataAccessor<ItemStack> f3857a;

    /* JADX INFO: renamed from: jp */
    private static final float f3858jp = 5.0f;

    /* JADX INFO: renamed from: as */
    private static final double f3859as = 0.8d;

    /* JADX INFO: renamed from: at */
    private static final double f3860at = 0.1d;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected Player f3861a;

    /* JADX INFO: renamed from: eQ */
    protected boolean f3862eQ;

    /* JADX INFO: renamed from: eR */
    private boolean f3863eR;

    /* JADX INFO: renamed from: eS */
    static final /* synthetic */ boolean f3864eS;

    /* JADX INFO: renamed from: aL */
    protected abstract boolean mo3135aL();

    /* JADX INFO: renamed from: ax */
    public abstract float mo3139ax();

    /* JADX INFO: renamed from: ay */
    public abstract float mo3140ay();

    static {
        f3864eS = !AbstractC0699mW.class.desiredAssertionStatus();
        f3857a = SynchedEntityData.defineId(AbstractC0699mW.class, EntityDataSerializers.ITEM_STACK);
    }

    protected AbstractC0699mW(@NotNull EntityType<? extends ThrowableProjectile> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f3862eQ = false;
        this.f3863eR = true;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0699mW mo3122a(@NotNull ItemStack itemStack) {
        this.entityData.set(f3857a, itemStack);
        return this;
    }

    @NotNull
    public ItemStack getItem() {
        return (ItemStack) this.entityData.get(f3857a);
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo3123a(@NotNull ServerPlayer serverPlayer, float f, @NotNull ItemStack itemStack) {
        mo3122a(itemStack);
        m3128c((Player) serverPlayer);
        float f2 = f;
        if (serverPlayer.getDeltaMovement().y > 0.0d) {
            f2 += 0.3f;
        }
        m3129a(serverPlayer.getEyePosition(), serverPlayer.getYRot(), serverPlayer.getXRot(), Math.min(f, mo3125av()), Math.min(f2, mo3126aw()));
    }

    /* JADX INFO: renamed from: a */
    private static void m3124a(@NotNull Level level, @NotNull BlockPos blockPos) {
        BlockState blockState = level.getBlockState(blockPos);
        C1306xt block = blockState.getBlock();
        boolean z = (block instanceof C1306xt) && block.m7953dz();
        if (block instanceof DoorBlock) {
            C1306xt c1306xt = block;
            if (!block.equals(Blocks.IRON_DOOR) && !z && !((Boolean) blockState.getValue(DoorBlock.OPEN)).booleanValue()) {
                c1306xt.setOpen((Entity) null, level, blockState, blockPos, true);
                level.sendBlockUpdated(blockPos, blockState, blockState, 1);
                level.playLocalSound(blockPos.getX(), blockPos.getY(), blockPos.getZ(), SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR, SoundSource.BLOCKS, 1.0f, 0.75f, false);
            }
        }
    }

    /* JADX INFO: renamed from: av */
    protected float mo3125av() {
        return 1.5f;
    }

    /* JADX INFO: renamed from: aw */
    protected float mo3126aw() {
        return 1.5f;
    }

    /* JADX INFO: renamed from: bE */
    public void m3127bE() {
        this.f3863eR = false;
    }

    /* JADX INFO: renamed from: c */
    public void m3128c(@Nullable Player player) {
        this.f3861a = player;
    }

    /* JADX INFO: renamed from: a */
    protected void m3129a(@NotNull Vec3 vec3, float f, float f2, float f3, float f4) {
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
        Vec3 vec4 = new Vec3(vec3.x + (((double) f5) * 0.8d), vec3.y + ((double) (((-f2) * 2.0f) / 90.0f)), vec3.z + (((double) fCos) * 0.8d));
        BlockHitResult blockHitResultClip = level().clip(new ClipContext(vec3, vec4, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
        if (blockHitResultClip.getType() != HitResult.Type.MISS) {
            vec4 = blockHitResultClip.getLocation().subtract(vec4.subtract(vec3).normalize().scale(0.1d));
        }
        teleportTo(vec4.x, vec4.y, vec4.z);
        Vec3 vec3Position = position();
        this.xOld = vec3Position.x;
        this.yOld = vec3Position.y;
        this.zOld = vec3Position.z;
    }

    /* JADX INFO: renamed from: c */
    public void m3130c(@NotNull LivingEntity livingEntity) {
        if (livingEntity instanceof ServerPlayer) {
            m3131a((ServerPlayer) livingEntity);
        }
        mo3132bF();
    }

    /* JADX INFO: renamed from: a */
    private void m3131a(@NotNull ServerPlayer serverPlayer) {
        if (onGround()) {
            return;
        }
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f3864eS && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        UUID uuid = serverPlayer.getUUID();
        AbstractC0863pb<?, ?, ?> abstractC0863pbMo2354a = abstractC0531jNM179a.mo2354a(uuid);
        if (abstractC0863pbMo2354a == null || this.f3861a == null) {
            return;
        }
        UUID uuid2 = this.f3861a.getUUID();
        if (abstractC0863pbMo2354a.equals(abstractC0531jNM179a.mo2354a(uuid2)) && !C0875pn.m4476a(abstractC0531jNM179a, uuid, uuid2)) {
            C0875pn.m4461a(abstractC0531jNM179a, uuid, CloudAchievements.ACH_USER_SHOOT_GRENADE);
        }
    }

    /* JADX INFO: renamed from: bF */
    public void mo3132bF() {
        if (this.f3862eQ) {
            return;
        }
        this.f3862eQ = true;
        Level level = level();
        BlockPos blockPosBlockPosition = blockPosition();
        Vec3 vec3AtCenterOf = Vec3.atCenterOf(blockPosBlockPosition);
        EnumC0862pa enumC0862pa = this instanceof C0779nx ? EnumC0862pa.ARTILLERY_EXPLOSION : EnumC0862pa.GENERIC;
        if (this.f3863eR) {
            if (level.isClientSide()) {
                m3133a(level, enumC0862pa, vec3AtCenterOf);
            } else {
                m3134a(level, vec3AtCenterOf, enumC0862pa, blockPosBlockPosition);
            }
        }
        discard();
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m3133a(@NotNull Level level, @NotNull EnumC0862pa enumC0862pa, @NotNull Vec3 vec3) {
        Minecraft minecraft = Minecraft.getInstance();
        if (level instanceof ClientLevel) {
            ClientLevel clientLevel = (ClientLevel) level;
            if (C0490iZ.m2214a(this)) {
                C0623l c0623lM2852b = C0623l.m2852b();
                if (!f3864eS && c0623lM2852b == null) {
                    throw new AssertionError("Client mod manager is null!");
                }
                C0693mQ.m3103a(minecraft, c0623lM2852b, clientLevel, enumC0862pa, vec3);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3134a(@NotNull Level level, @NotNull Vec3 vec3, @NotNull EnumC0862pa enumC0862pa, @NotNull BlockPos blockPos) {
        UUID uuid = this.f3861a != null ? this.f3861a.getUUID() : null;
        AABB boundingBox = getBoundingBox();
        if (m3136aM()) {
            Iterator it = level.getEntities(this, boundingBox.inflate(5.0d, 5.0d, 5.0d), entity -> {
                return entity instanceof C0745nP;
            }).iterator();
            while (it.hasNext()) {
                ((Entity) it.next()).m3407cq();
            }
        }
        if (mo3135aL()) {
            float fMo3140ay = mo3140ay();
            for (Entity entity2 : level.getEntities(this, boundingBox.inflate(fMo3140ay, fMo3140ay, fMo3140ay), entity3 -> {
                return entity3 instanceof AbstractC0750nU;
            })) {
                if (level.clip(new ClipContext(entity2.position(), position(), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity2)).getType().equals(HitResult.Type.MISS)) {
                    AbstractC0750nU abstractC0750nU = (AbstractC0750nU) entity2;
                    float fMax = Math.max(mo3139ax() * (1.0f - (distanceTo(abstractC0750nU) / fMo3140ay)), 0.0f);
                    if (fMax > 0.0f) {
                        abstractC0750nU.m3454a(getItem(), this.f3861a, fMax);
                    }
                }
            }
        }
        m3138a(this.f3861a, vec3, mo3142az());
        for (ServerPlayer serverPlayer : level.players()) {
            C1175vU c1175vU = new C1175vU(enumC0862pa, vec3);
            if (serverPlayer instanceof ServerPlayer) {
                C1169vO.m6643a(c1175vU, serverPlayer);
            }
        }
        if (uuid != null) {
            int iM3141aH = m3141aH();
            for (int i = -iM3141aH; i < iM3141aH; i++) {
                for (int i2 = -iM3141aH; i2 < iM3141aH; i2++) {
                    for (int i3 = -iM3141aH; i3 < iM3141aH; i3++) {
                        m3124a(level, new BlockPos(blockPos.getX() + i, blockPos.getY() + i2, blockPos.getZ() + i3));
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: aM */
    private boolean m3136aM() {
        return true;
    }

    /* JADX INFO: renamed from: aN */
    public final boolean m3137aN() {
        return this.f3862eQ;
    }

    /* JADX INFO: renamed from: a */
    protected void m3138a(@Nullable Entity entity, @NotNull Vec3 vec3, float f) {
        ItemStack item = getItem();
        if (entity == null || item.isEmpty()) {
            return;
        }
        Explosion explosionM4490a = C0875pn.m4490a(level(), (Entity) this, vec3, item, f);
        explosionM4490a.explode();
        explosionM4490a.finalizeExplosion(true);
        explosionM4490a.clearToBlow();
    }

    /* JADX INFO: renamed from: aH */
    protected int m3141aH() {
        return 4;
    }

    /* JADX INFO: renamed from: az */
    protected float mo3142az() {
        return 5.5f;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Player m3143a() {
        return this.f3861a;
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("exploded", this.f3862eQ);
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.f3862eQ = compoundTag.getBoolean("exploded");
    }

    public void tick() {
        super.tick();
        if (!level().isClientSide && this.f3861a == null) {
            discard();
        }
    }

    protected void onHit(@NotNull HitResult hitResult) {
    }

    public void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(f3857a, new ItemStack((ItemLike) C1308xv.f7718X.get()));
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
