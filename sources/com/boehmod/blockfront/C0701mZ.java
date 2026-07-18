package com.boehmod.blockfront;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniond;

/* JADX INFO: renamed from: com.boehmod.blockfront.mZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mZ.class */
public class C0701mZ extends Entity {

    /* JADX INFO: renamed from: a */
    @NotNull
    private EnumC0755na f3759a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public Quaterniond f3760b;

    public C0701mZ(@NotNull EntityType<? extends C0701mZ> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f3759a = EnumC0755na.NONE;
        this.f3760b = new Quaterniond();
    }

    /* JADX INFO: renamed from: a */
    public void m3148a(@NotNull EnumC0755na enumC0755na) {
        this.f3759a = enumC0755na;
    }

    /* JADX INFO: renamed from: a */
    public EnumC0755na m3149a() {
        return this.f3759a;
    }

    public void tick() {
        super.tick();
        if (this.f3759a == EnumC0755na.NONE) {
            C0562jt.log("Camera not assigned a type! Discarding.", new Object[0]);
            discard();
        }
    }

    public boolean isNoGravity() {
        return true;
    }

    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
    }

    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
