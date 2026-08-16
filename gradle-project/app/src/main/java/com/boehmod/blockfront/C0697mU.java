package com.boehmod.blockfront;

import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mU.class */
public class C0697mU extends Entity implements InterfaceC0694mR {

    /* JADX INFO: renamed from: a */
    @Nullable
    protected AbstractC0863pb<?, ?, ?> f3853a;

    /* JADX INFO: renamed from: eO */
    static final /* synthetic */ boolean f3854eO;

    static {
        f3854eO = !C0697mU.class.desiredAssertionStatus();
    }

    public C0697mU(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public void tick() {
        super.tick();
        if (!level().isClientSide) {
            m3120bD();
        }
    }

    /* JADX INFO: renamed from: bD */
    public void m3120bD() {
        Level level = level();
        if (level.getServer() == null || !level.getServer().isDedicatedServer()) {
            return;
        }
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f3854eO && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (this.f3853a == null || abstractC0531jNM179a.m2361b(this.f3853a.m4064e()) == null || this.f3853a.m4023a() == EnumC0871pj.POST_GAME) {
            C0530jM.log("Failed to load match for mini-game mob '" + getId() + "'. Discarding.", new Object[0]);
            discard();
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0694mR
    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0863pb<?, ?, ?> mo3116a() {
        return this.f3853a;
    }

    @Override // com.boehmod.blockfront.InterfaceC0694mR
    /* JADX INFO: renamed from: e */
    public void mo3117e(@Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        this.f3853a = abstractC0863pb;
    }

    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
    }

    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        compoundTag.putUUID("gameId", this.f3853a != null ? this.f3853a.m4064e() : UUID.randomUUID());
    }

    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f3854eO && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (compoundTag.contains("gameId")) {
            mo3117e(abstractC0531jNM179a.m2361b(compoundTag.getUUID("gameId")));
        }
    }
}
