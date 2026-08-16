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

/* JADX INFO: renamed from: com.boehmod.blockfront.nM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nM.class */
public final class C0742nM extends C0745nP {

    /* JADX INFO: renamed from: nN */
    public int f4076nN;

    /* JADX INFO: renamed from: fs */
    public boolean f4077fs;

    /* JADX INFO: renamed from: b */
    private C1117uP f4078b;

    public C0742nM(EntityType<? extends C0742nM> entityType, Level level) {
        super(entityType, level);
        this.f4076nN = 400;
        this.f4077fs = false;
        this.f4078b = (C1117uP) C1308xv.f7770lQ.get();
    }

    /* JADX INFO: renamed from: a */
    public C1117uP m3397a() {
        return this.f4078b;
    }

    /* JADX INFO: renamed from: a */
    public C0742nM m3398a(C1117uP c1117uP) {
        this.f4078b = c1117uP;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: a */
    public void mo3123a(@NotNull ServerPlayer serverPlayer, float f, @NotNull ItemStack itemStack) {
        super.mo3123a(serverPlayer, f, itemStack);
        for (ItemStack itemStack2 : serverPlayer.getInventory().items) {
            if (itemStack2 != null && !itemStack2.isEmpty()) {
                Item item = itemStack2.getItem();
                if (item instanceof C1117uP) {
                    m3398a((C1117uP) item);
                    return;
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.C0745nP, com.boehmod.blockfront.AbstractC0699mW
    public void tick() {
        super.tick();
        Level level = level();
        if (this.f4078b == null) {
            discard();
            return;
        }
        Vec3 vec3Position = position();
        if (this.f3862eQ && Math.random() < 0.05d && !level.isClientSide() && this.f3861a != null) {
            level.addParticle(ParticleTypes.NOTE, vec3Position.x, vec3Position.y + 0.25d, vec3Position.z, 0.0d, 0.0d, 0.0d);
            C1287xa c1287xa = new C1287xa(new ItemStack(this.f4078b), vec3Position, this.f3861a.getId(), false, true, true);
            for (ServerPlayer serverPlayer : level.players()) {
                if (serverPlayer instanceof ServerPlayer) {
                    C1169vO.m6643a(c1287xa, serverPlayer);
                }
            }
        }
        int i = this.f4076nN;
        this.f4076nN = i - 1;
        if (i <= 0) {
            if (level.isClientSide()) {
                level.addParticle(ParticleTypes.EXPLOSION, true, vec3Position.x, vec3Position.y + 0.25d, vec3Position.z, 0.0d, 0.0d, 0.0d);
                level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1312xz.f8198tL.get(), SoundSource.BLOCKS, 3.0f, 2.0f, false);
            }
            discard();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    /* JADX INFO: renamed from: bF */
    public void mo3132bF() {
        if (!this.f3862eQ) {
            this.f3862eQ = true;
        }
    }

    @Override // com.boehmod.blockfront.C0745nP
    /* JADX INFO: renamed from: ce */
    protected void mo3372ce() {
        this.f4077fs = true;
    }

    @Override // com.boehmod.blockfront.C0745nP, com.boehmod.blockfront.AbstractC0699mW
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("hasStopped", this.f4077fs);
        compoundTag.putBoolean("hasItem", this.f4078b != null);
        new ItemStack(this.f4078b).save(registryAccess(), compoundTag);
    }

    @Override // com.boehmod.blockfront.C0745nP, com.boehmod.blockfront.AbstractC0699mW
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.f4077fs = compoundTag.getBoolean("hasStopped");
        if (compoundTag.getBoolean("hasItem")) {
            this.f4078b = (C1117uP) ItemStack.parseOptional(registryAccess(), compoundTag).getItem();
        }
    }
}
