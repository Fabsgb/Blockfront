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

/* JADX INFO: renamed from: com.boehmod.blockfront.nk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nk.class */
public abstract class AbstractC0765nk extends C0774nt {

    /* JADX INFO: renamed from: v */
    private static final EntityDataAccessor<Optional<UUID>> f4095v;

    /* JADX INFO: renamed from: eR */
    public boolean f4096eR;

    /* JADX INFO: renamed from: eS */
    public boolean f4097eS;

    /* JADX INFO: renamed from: lL */
    public int f4098lL;

    /* JADX INFO: renamed from: lM */
    public int f4099lM;

    /* JADX INFO: renamed from: as */
    public double f4100as;

    /* JADX INFO: renamed from: eT */
    static final /* synthetic */ boolean f4101eT;

    /* JADX INFO: renamed from: a */
    abstract void mo3444a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0790oI<?> abstractC0790oI);

    static {
        f4101eT = !AbstractC0765nk.class.desiredAssertionStatus();
        f4095v = SynchedEntityData.defineId(AbstractC0765nk.class, EntityDataSerializers.OPTIONAL_UUID);
    }

    public AbstractC0765nk(@NotNull EntityType<? extends AbstractC0765nk> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f4096eR = false;
        this.f4097eS = false;
        this.f4098lL = 1200;
        this.f4099lM = 0;
        this.f4100as = 1.5d;
    }

    @Override // com.boehmod.blockfront.C0774nt, com.boehmod.blockfront.AbstractC0676mA
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(f4095v, Optional.empty());
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: a */
    public void mo2972a(@NotNull ServerPlayer serverPlayer, float f, @NotNull ItemStack itemStack) {
        super.mo2972a(serverPlayer, f, itemStack);
        this.entityData.set(f4095v, Optional.of(serverPlayer.getUUID()));
    }

    /* JADX INFO: renamed from: d */
    public Optional<UUID> m3446d() {
        return (Optional) this.entityData.get(f4095v);
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: ap */
    protected float mo2974ap() {
        return 0.4f;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: aq */
    protected float mo2975aq() {
        return 0.4f;
    }

    @Override // com.boehmod.blockfront.C0774nt, com.boehmod.blockfront.AbstractC0676mA
    public void tick() {
        super.tick();
        Level level = level();
        if (level.isClientSide()) {
            return;
        }
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f4101eT && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2530a = this.f3611a != null ? abstractC0563juM168a.m2530a(this.f3611a) : null;
        if (this.f4096eR) {
            int i = this.f4099lM;
            this.f4099lM = i - 1;
            if (i <= 0 && abstractC0787oFM2530a != null) {
                AbstractC0790oI abstractC0790oIM3582b = abstractC0787oFM2530a.m3582b();
                this.f4099lM = 80;
                level.getEntitiesOfClass(ServerPlayer.class, getBoundingBox().inflate(this.f4100as)).forEach(serverPlayer -> {
                    m3447b(abstractC0563juM168a, serverPlayer, abstractC0787oFM2530a, abstractC0790oIM3582b);
                });
            }
        }
        int i2 = this.f4098lL;
        this.f4098lL = i2 - 1;
        if (i2 <= 0) {
            level.playSound((Player) null, getX(), getY(), getZ(), SoundEvents.ARMOR_EQUIP_LEATHER, SoundSource.NEUTRAL, 1.0f, 1.0f);
            discard();
        }
    }

    @Override // com.boehmod.blockfront.C0774nt, com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: ar */
    public float mo2988ar() {
        return 0.0f;
    }

    @Override // com.boehmod.blockfront.C0774nt
    /* JADX INFO: renamed from: a */
    protected DeferredHolder<SoundEvent, SoundEvent> mo3443a(@NotNull SoundType soundType) {
        return C1280xc.f7796tT;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: bu */
    public void mo2981bu() {
        if (this.f3612ew) {
            return;
        }
        this.f4096eR = true;
        this.f3612ew = true;
    }

    /* JADX INFO: renamed from: b */
    void m3447b(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0790oI<?> abstractC0790oI) {
        mo3444a(abstractC0563ju, serverPlayer, abstractC0787oF, abstractC0790oI);
    }

    @Override // com.boehmod.blockfront.C0774nt
    /* JADX INFO: renamed from: bS */
    public void mo3448bS() {
    }

    @Override // com.boehmod.blockfront.C0774nt
    /* JADX INFO: renamed from: bT */
    protected void mo3449bT() {
        this.f4097eS = true;
    }

    @Override // com.boehmod.blockfront.C0774nt, com.boehmod.blockfront.AbstractC0676mA
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("hasBurst", this.f4096eR);
        compoundTag.putBoolean("hasStopped", this.f4097eS);
        compoundTag.putInt("activeTimer", this.f4098lL);
    }

    @Override // com.boehmod.blockfront.C0774nt, com.boehmod.blockfront.AbstractC0676mA
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.f4096eR = compoundTag.getBoolean("hasBurst");
        this.f4097eS = compoundTag.getBoolean("hasStopped");
        this.f4098lL = compoundTag.getInt("activeTimer");
    }
}
