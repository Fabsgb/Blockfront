package com.boehmod.blockfront;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nq.class */
public final class C0368nq extends C0371nt {
    public int lP;
    public boolean eY;
    private C0558ur b;

    public C0368nq(EntityType<? extends C0368nq> entityType, Level level) {
        super(entityType, level);
        this.lP = 400;
        this.eY = false;
        this.b = (C0558ur) wY.lQ.get();
    }

    public C0558ur a() {
        return this.b;
    }

    public C0368nq a(C0558ur c0558ur) {
        this.b = c0558ur;
        return this;
    }

    @Override // com.boehmod.blockfront.mA
    public void a(@NotNull ServerPlayer serverPlayer, float f, @NotNull ItemStack itemStack) {
        super.a(serverPlayer, f, itemStack);
        for (ItemStack itemStack2 : serverPlayer.getInventory().items) {
            if (itemStack2 != null && !itemStack2.isEmpty()) {
                Item item = itemStack2.getItem();
                if (item instanceof C0558ur) {
                    a((C0558ur) item);
                    return;
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.mA
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.C0371nt, com.boehmod.blockfront.mA
    public void tick() {
        super.tick();
        Level level = level();
        if (this.b == null) {
            discard();
            return;
        }
        Vec3 vec3Position = position();
        if (this.ew && Math.random() < 0.05d && !level.isClientSide() && this.f236a != null) {
            level.addParticle(ParticleTypes.NOTE, vec3Position.x, vec3Position.y + 0.25d, vec3Position.z, 0.0d, 0.0d, 0.0d);
            wD wDVar = new wD(new ItemStack(this.b), vec3Position, this.f236a.getId(), false, true, true);
            for (ServerPlayer serverPlayer : level.players()) {
                if (serverPlayer instanceof ServerPlayer) {
                    C0582vo.a(wDVar, serverPlayer);
                }
            }
        }
        int i = this.lP;
        this.lP = i - 1;
        if (i <= 0) {
            if (level.isClientSide()) {
                level.addParticle(ParticleTypes.EXPLOSION, true, vec3Position.x, vec3Position.y + 0.25d, vec3Position.z, 0.0d, 0.0d, 0.0d);
                level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C0624xc.tK.get(), SoundSource.BLOCKS, 3.0f, 2.0f, false);
            }
            discard();
        }
    }

    @Override // com.boehmod.blockfront.mA
    public void bu() {
        if (!this.ew) {
            this.ew = true;
        }
    }

    @Override // com.boehmod.blockfront.C0371nt
    protected void bT() {
        this.eY = true;
    }

    @Override // com.boehmod.blockfront.C0371nt, com.boehmod.blockfront.mA
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("hasStopped", this.eY);
        compoundTag.putBoolean("hasItem", this.b != null);
        new ItemStack(this.b).save(registryAccess(), compoundTag);
    }

    @Override // com.boehmod.blockfront.C0371nt, com.boehmod.blockfront.mA
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.eY = compoundTag.getBoolean("hasStopped");
        if (compoundTag.getBoolean("hasItem")) {
            this.b = (C0558ur) ItemStack.parseOptional(registryAccess(), compoundTag).getItem();
        }
    }
}
