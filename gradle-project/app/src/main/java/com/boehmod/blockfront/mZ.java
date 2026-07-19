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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mZ.class */
public class mZ extends Entity {

    @NotNull
    private EnumC0352na a;

    @NotNull
    public Quaterniond b;

    public mZ(@NotNull EntityType<? extends mZ> entityType, @NotNull Level level) {
        super(entityType, level);
        this.a = EnumC0352na.NONE;
        this.b = new Quaterniond();
    }

    public void a(@NotNull EnumC0352na enumC0352na) {
        this.a = enumC0352na;
    }

    public EnumC0352na a() {
        return this.a;
    }

    public void tick() {
        super.tick();
        if (this.a == EnumC0352na.NONE) {
            C0263jt.log("Camera not assigned a type! Discarding.", new Object[0]);
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
