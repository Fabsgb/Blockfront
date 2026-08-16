package com.boehmod.blockfront;

import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mV.class */
public class C0698mV extends PathfinderMob implements InterfaceC0694mR {

    /* JADX INFO: renamed from: a */
    @Nullable
    protected AbstractC0863pb<?, ?, ?> f3855a;

    /* JADX INFO: renamed from: eP */
    static final /* synthetic */ boolean f3856eP;

    static {
        f3856eP = !C0698mV.class.desiredAssertionStatus();
    }

    protected C0698mV(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.InterfaceC0694mR
    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0863pb<?, ?, ?> mo3116a() {
        return this.f3855a;
    }

    @Override // com.boehmod.blockfront.InterfaceC0694mR
    /* JADX INFO: renamed from: e */
    public void mo3117e(@Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        this.f3855a = abstractC0863pb;
    }

    /* JADX INFO: renamed from: b */
    public void mo3121b(@NotNull ServerLevel serverLevel) {
        if (serverLevel.getServer().isDedicatedServer()) {
            if (this.f3855a == null || this.f3855a.m4023a() == EnumC0871pj.POST_GAME || this.f3855a.m4023a() == EnumC0871pj.IDLE) {
                C0530jM.logError("Failed to load match for mini-game mob '" + getId() + "'. Discarding.", new Object[0]);
                discard();
            }
        }
    }

    public void baseTick() {
        super.baseTick();
        Level level = level();
        if (level instanceof ServerLevel) {
            mo3121b((ServerLevel) level);
        }
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putUUID("gameId", this.f3855a != null ? this.f3855a.m4064e() : UUID.randomUUID());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f3856eP && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (compoundTag.contains("gameId")) {
            mo3117e(abstractC0531jNM179a.m2361b(compoundTag.getUUID("gameId")));
        }
    }

    public void checkDespawn() {
    }
}
