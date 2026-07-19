package com.boehmod.blockfront;

import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.my, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/my.class */
public class C0349my extends Entity implements InterfaceC0346mv {

    @Nullable
    protected oF<?, ?, ?> a;
    static final /* synthetic */ boolean eu;

    static {
        eu = !C0349my.class.desiredAssertionStatus();
    }

    public C0349my(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public void tick() {
        super.tick();
        if (!level().isClientSide) {
            bs();
        }
    }

    public void bs() {
        Level level = level();
        if (level.getServer() == null || !level.getServer().isDedicatedServer()) {
            return;
        }
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!eu && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (this.a == null || abstractC0264juM166a.b(this.a.m757e()) == null || this.a.m750a() == oN.POST_GAME) {
            C0263jt.log("Failed to load match for mini-game mob '" + getId() + "'. Discarding.", new Object[0]);
            discard();
        }
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

    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
    }

    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        compoundTag.putUUID("gameId", this.a != null ? this.a.m757e() : UUID.randomUUID());
    }

    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!eu && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        if (compoundTag.contains("gameId")) {
            e(abstractC0264juM166a.b(compoundTag.getUUID("gameId")));
        }
    }
}
