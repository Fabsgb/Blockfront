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

/* JADX INFO: renamed from: com.boehmod.blockfront.nv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nv.class */
public class C0777nv extends Entity {

    /* JADX INFO: renamed from: a */
    @NotNull
    private EnumC0778nw f4322a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public Quaterniond f4323b;

    public C0777nv(@NotNull EntityType<? extends C0777nv> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f4322a = EnumC0778nw.NONE;
        this.f4323b = new Quaterniond();
    }

    /* JADX INFO: renamed from: a */
    public void m3655a(@NotNull EnumC0778nw enumC0778nw) {
        this.f4322a = enumC0778nw;
    }

    /* JADX INFO: renamed from: a */
    public EnumC0778nw m3656a() {
        return this.f4322a;
    }

    public void tick() {
        super.tick();
        if (this.f4322a == EnumC0778nw.NONE) {
            C0530jM.log("Camera not assigned a type! Discarding.", new Object[0]);
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
