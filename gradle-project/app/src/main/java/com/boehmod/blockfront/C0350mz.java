package com.boehmod.blockfront;

import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mz.class */
public class C0350mz extends PathfinderMob implements InterfaceC0346mv {

    @Nullable
    protected oF<?, ?, ?> a;
    static final /* synthetic */ boolean ev;

    static {
        ev = !C0350mz.class.desiredAssertionStatus();
    }

    protected C0350mz(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.InterfaceC0346mv
    @Nullable
    public oF<?, ?, ?> a() {
        return this.a;
    }

    @Override // com.boehmod.blockfront.InterfaceC0346mv
    public void e(@Nullable oF<?, ?, ?> oFVar) {
        this.a = oFVar;
    }

    public void b(@NotNull ServerLevel serverLevel) {
        if (serverLevel.getServer().isDedicatedServer()) {
            if (this.a == null || this.a.m750a() == oN.POST_GAME || this.a.m750a() == oN.IDLE) {
                C0263jt.logError("Failed to load match for mini-game mob '" + getId() + "'. Discarding.", new Object[0]);
                discard();
            }
        }
    }

    public void baseTick() {
        super.baseTick();
        Level level = level();
        if (level instanceof ServerLevel) {
            b((ServerLevel) level);
        }
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putUUID("gameId", this.a != null ? this.a.m757e() : UUID.randomUUID());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!ev && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (compoundTag.contains("gameId")) {
            e(abstractC0264juM166a.b(compoundTag.getUUID("gameId")));
        }
    }

    public void checkDespawn() {
    }
}
