package com.boehmod.blockfront;

import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.my */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/my.class */
public class C0726my extends Entity implements InterfaceC0723mv {

    /* JADX INFO: renamed from: a */
    @Nullable
    protected AbstractC0787oF<?, ?, ?> f3894a;

    /* JADX INFO: renamed from: eu */
    static final /* synthetic */ boolean f3895eu;

    static {
        f3895eu = !C0726my.class.desiredAssertionStatus();
    }

    public C0726my(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public void tick() {
        super.tick();
        if (!level().isClientSide) {
            m3285bs();
        }
    }

    /* JADX INFO: renamed from: bs */
    public void m3285bs() {
        Level level = level();
        if (level.getServer() == null || !level.getServer().isDedicatedServer()) {
            return;
        }
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f3895eu && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (this.f3894a == null || abstractC0563juM168a.m2538b(this.f3894a.m3628e()) == null || this.f3894a.m3587a() == EnumC0795oN.POST_GAME) {
            C0562jt.log("Failed to load match for mini-game mob '" + getId() + "'. Discarding.", new Object[0]);
            discard();
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0723mv
    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0787oF<?, ?, ?> mo3281a() {
        return this.f3894a;
    }

    @Override // com.boehmod.blockfront.InterfaceC0723mv
    /* JADX INFO: renamed from: e */
    public void mo3282e(@Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        this.f3894a = abstractC0787oF;
    }

    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
    }

    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        compoundTag.putUUID("gameId", this.f3894a != null ? this.f3894a.m3628e() : UUID.randomUUID());
    }

    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f3895eu && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (compoundTag.contains("gameId")) {
            mo3282e(abstractC0563juM168a.m2538b(compoundTag.getUUID("gameId")));
        }
    }
}
