package com.boehmod.blockfront;

import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mz.class */
public class C0727mz extends PathfinderMob implements InterfaceC0723mv {

    /* JADX INFO: renamed from: a */
    @Nullable
    protected AbstractC0787oF<?, ?, ?> f3896a;

    /* JADX INFO: renamed from: ev */
    static final /* synthetic */ boolean f3897ev;

    static {
        f3897ev = !C0727mz.class.desiredAssertionStatus();
    }

    protected C0727mz(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.InterfaceC0723mv
    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0787oF<?, ?, ?> mo3281a() {
        return this.f3896a;
    }

    @Override // com.boehmod.blockfront.InterfaceC0723mv
    /* JADX INFO: renamed from: e */
    public void mo3282e(@Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        this.f3896a = abstractC0787oF;
    }

    /* JADX INFO: renamed from: b */
    public void mo3040b(@NotNull ServerLevel serverLevel) {
        if (serverLevel.getServer().isDedicatedServer()) {
            if (this.f3896a == null || this.f3896a.m3587a() == EnumC0795oN.POST_GAME || this.f3896a.m3587a() == EnumC0795oN.IDLE) {
                C0562jt.logError("Failed to load match for mini-game mob '" + getId() + "'. Discarding.", new Object[0]);
                discard();
            }
        }
    }

    public void baseTick() {
        super.baseTick();
        Level level = level();
        if (level instanceof ServerLevel) {
            mo3040b((ServerLevel) level);
        }
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putUUID("gameId", this.f3896a != null ? this.f3896a.m3628e() : UUID.randomUUID());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f3897ev && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (compoundTag.contains("gameId")) {
            mo3282e(abstractC0563juM168a.m2538b(compoundTag.getUUID("gameId")));
        }
    }

    public void checkDespawn() {
    }
}
