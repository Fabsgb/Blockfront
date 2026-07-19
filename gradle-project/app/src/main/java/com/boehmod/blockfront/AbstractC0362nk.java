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

/* JADX INFO: renamed from: com.boehmod.blockfront.nk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nk.class */
public abstract class AbstractC0362nk extends C0371nt {
    private static final EntityDataAccessor<Optional<UUID>> v;
    public boolean eR;
    public boolean eS;
    public int lL;
    public int lM;
    public double as;
    static final /* synthetic */ boolean eT;

    abstract void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerPlayer serverPlayer, @NotNull oF<?, ?, ?> oFVar, @NotNull oI<?> oIVar);

    static {
        eT = !AbstractC0362nk.class.desiredAssertionStatus();
        v = SynchedEntityData.defineId(AbstractC0362nk.class, EntityDataSerializers.OPTIONAL_UUID);
    }

    public AbstractC0362nk(@NotNull EntityType<? extends AbstractC0362nk> entityType, @NotNull Level level) {
        super(entityType, level);
        this.eR = false;
        this.eS = false;
        this.lL = 1200;
        this.lM = 0;
        this.as = 1.5d;
    }

    @Override // com.boehmod.blockfront.C0371nt, com.boehmod.blockfront.mA
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(v, Optional.empty());
    }

    @Override // com.boehmod.blockfront.mA
    public void a(@NotNull ServerPlayer serverPlayer, float f, @NotNull ItemStack itemStack) {
        super.a(serverPlayer, f, itemStack);
        this.entityData.set(v, Optional.of(serverPlayer.getUUID()));
    }

    public Optional<UUID> d() {
        return (Optional) this.entityData.get(v);
    }

    @Override // com.boehmod.blockfront.mA
    protected float ap() {
        return 0.4f;
    }

    @Override // com.boehmod.blockfront.mA
    protected float aq() {
        return 0.4f;
    }

    @Override // com.boehmod.blockfront.C0371nt, com.boehmod.blockfront.mA
    public void tick() {
        super.tick();
        Level level = level();
        if (level.isClientSide()) {
            return;
        }
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!eT && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        oF<?, ?, ?> oFVarA = this.f236a != null ? abstractC0264juM166a.a(this.f236a) : null;
        if (this.eR) {
            int i = this.lM;
            this.lM = i - 1;
            if (i <= 0 && oFVarA != null) {
                oI oIVarB = oFVarA.b();
                this.lM = 80;
                level.getEntitiesOfClass(ServerPlayer.class, getBoundingBox().inflate(this.as)).forEach(serverPlayer -> {
                    b(abstractC0264juM166a, serverPlayer, oFVarA, oIVarB);
                });
            }
        }
        int i2 = this.lL;
        this.lL = i2 - 1;
        if (i2 <= 0) {
            level.playSound((Player) null, getX(), getY(), getZ(), SoundEvents.ARMOR_EQUIP_LEATHER, SoundSource.NEUTRAL, 1.0f, 1.0f);
            discard();
        }
    }

    @Override // com.boehmod.blockfront.C0371nt, com.boehmod.blockfront.mA
    public float ar() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.C0371nt
    protected DeferredHolder<SoundEvent, SoundEvent> a(@NotNull SoundType soundType) {
        return C0624xc.tT;
    }

    @Override // com.boehmod.blockfront.mA
    public void bu() {
        if (this.ew) {
            return;
        }
        this.eR = true;
        this.ew = true;
    }

    void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerPlayer serverPlayer, @NotNull oF<?, ?, ?> oFVar, @NotNull oI<?> oIVar) {
        a(abstractC0264ju, serverPlayer, oFVar, oIVar);
    }

    @Override // com.boehmod.blockfront.C0371nt
    public void bS() {
    }

    @Override // com.boehmod.blockfront.C0371nt
    protected void bT() {
        this.eS = true;
    }

    @Override // com.boehmod.blockfront.C0371nt, com.boehmod.blockfront.mA
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("hasBurst", this.eR);
        compoundTag.putBoolean("hasStopped", this.eS);
        compoundTag.putInt("activeTimer", this.lL);
    }

    @Override // com.boehmod.blockfront.C0371nt, com.boehmod.blockfront.mA
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.eR = compoundTag.getBoolean("hasBurst");
        this.eS = compoundTag.getBoolean("hasStopped");
        this.lL = compoundTag.getInt("activeTimer");
    }
}
