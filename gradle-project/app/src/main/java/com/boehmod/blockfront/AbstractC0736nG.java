package com.boehmod.blockfront;

import java.util.Optional;
import java.util.UUID;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nG.class */
public abstract class AbstractC0736nG extends C0745nP {

    /* JADX INFO: renamed from: v */
    private static final EntityDataAccessor<Optional<UUID>> f4050v;

    /* JADX INFO: renamed from: fl */
    public boolean f4051fl;

    /* JADX INFO: renamed from: fm */
    public boolean f4052fm;

    /* JADX INFO: renamed from: nJ */
    public int f4053nJ;

    /* JADX INFO: renamed from: nK */
    public int f4054nK;

    /* JADX INFO: renamed from: aF */
    public double f4055aF;

    /* JADX INFO: renamed from: fn */
    static final /* synthetic */ boolean f4056fn;

    /* JADX INFO: renamed from: a */
    abstract void mo3367a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0866pe<?> abstractC0866pe);

    static {
        f4056fn = !AbstractC0736nG.class.desiredAssertionStatus();
        f4050v = SynchedEntityData.defineId(AbstractC0736nG.class, EntityDataSerializers.OPTIONAL_UUID);
    }

    public AbstractC0736nG(@NotNull EntityType<? extends AbstractC0736nG> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f4051fl = false;
        this.f4052fm = false;
        this.f4053nJ = 1200;
        this.f4054nK = 0;
        this.f4055aF = 1.5d;
    }

    @Override // com.boehmod.blockfront.C0745nP, com.boehmod.blockfront.AbstractC0699mW
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(f4050v, Optional.empty());
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: a */
    public void mo3123a(@NotNull ServerPlayer serverPlayer, float f, @NotNull ItemStack itemStack) {
        super.mo3123a(serverPlayer, f, itemStack);
        this.entityData.set(f4050v, Optional.of(serverPlayer.getUUID()));
    }

    /* JADX INFO: renamed from: d */
    public Optional<UUID> m3369d() {
        return (Optional) this.entityData.get(f4050v);
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: av */
    protected float mo3125av() {
        return 0.4f;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: aw */
    protected float mo3126aw() {
        return 0.4f;
    }

    @Override // com.boehmod.blockfront.C0745nP, com.boehmod.blockfront.AbstractC0699mW
    public void tick() {
        super.tick();
        Level level = level();
        if (level.isClientSide()) {
            return;
        }
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4056fn && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2353a = this.f3861a != null ? abstractC0531jNM179a.m2353a(this.f3861a) : null;
        if (this.f4051fl) {
            int i = this.f4054nK;
            this.f4054nK = i - 1;
            if (i <= 0 && abstractC0863pbM2353a != null) {
                AbstractC0866pe abstractC0866peM4018b = abstractC0863pbM2353a.m4018b();
                this.f4054nK = 80;
                level.getEntitiesOfClass(ServerPlayer.class, getBoundingBox().inflate(this.f4055aF)).forEach(serverPlayer -> {
                    m3370b(abstractC0531jNM179a, serverPlayer, abstractC0863pbM2353a, abstractC0866peM4018b);
                });
            }
        }
        int i2 = this.f4053nJ;
        this.f4053nJ = i2 - 1;
        if (i2 <= 0) {
            level.playSound((Player) null, getX(), getY(), getZ(), SoundEvents.ARMOR_EQUIP_LEATHER, SoundSource.NEUTRAL, 1.0f, 1.0f);
            discard();
        }
    }

    @Override // com.boehmod.blockfront.C0745nP, com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: ax */
    public float mo3139ax() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.C0745nP
    /* JADX INFO: renamed from: a */
    protected DeferredHolder<SoundEvent, SoundEvent> mo3366a(@NotNull SoundType soundType) {
        return C1312xz.f8207tU;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: bF */
    public void mo3132bF() {
        if (this.f3862eQ) {
            return;
        }
        this.f4051fl = true;
        this.f3862eQ = true;
    }

    /* JADX INFO: renamed from: b */
    void m3370b(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0866pe<?> abstractC0866pe) {
        mo3367a(abstractC0531jN, serverPlayer, abstractC0863pb, abstractC0866pe);
    }

    @Override // com.boehmod.blockfront.C0745nP
    /* JADX INFO: renamed from: cd */
    public void mo3371cd() {
    }

    @Override // com.boehmod.blockfront.C0745nP
    /* JADX INFO: renamed from: ce */
    protected void mo3372ce() {
        this.f4052fm = true;
    }

    @Override // com.boehmod.blockfront.C0745nP, com.boehmod.blockfront.AbstractC0699mW
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("hasBurst", this.f4051fl);
        compoundTag.putBoolean("hasStopped", this.f4052fm);
        compoundTag.putInt("activeTimer", this.f4053nJ);
    }

    @Override // com.boehmod.blockfront.C0745nP, com.boehmod.blockfront.AbstractC0699mW
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.f4051fl = compoundTag.getBoolean("hasBurst");
        this.f4052fm = compoundTag.getBoolean("hasStopped");
        this.f4053nJ = compoundTag.getInt("activeTimer");
    }
}
