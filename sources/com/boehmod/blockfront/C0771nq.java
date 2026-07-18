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

/* JADX INFO: renamed from: com.boehmod.blockfront.nq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nq.class */
public final class C0771nq extends C0774nt {

    /* JADX INFO: renamed from: lP */
    public int f4121lP;

    /* JADX INFO: renamed from: eY */
    public boolean f4122eY;

    /* JADX INFO: renamed from: b */
    private C1144ur f4123b;

    public C0771nq(EntityType<? extends C0771nq> entityType, Level level) {
        super(entityType, level);
        this.f4121lP = 400;
        this.f4122eY = false;
        this.f4123b = (C1144ur) C1231wY.f7205lQ.get();
    }

    /* JADX INFO: renamed from: a */
    public C1144ur m3474a() {
        return this.f4123b;
    }

    /* JADX INFO: renamed from: a */
    public C0771nq m3475a(C1144ur c1144ur) {
        this.f4123b = c1144ur;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: a */
    public void mo2972a(@NotNull ServerPlayer serverPlayer, float f, @NotNull ItemStack itemStack) {
        super.mo2972a(serverPlayer, f, itemStack);
        for (ItemStack itemStack2 : serverPlayer.getInventory().items) {
            if (itemStack2 != null && !itemStack2.isEmpty()) {
                Item item = itemStack2.getItem();
                if (item instanceof C1144ur) {
                    m3475a((C1144ur) item);
                    return;
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.C0774nt, com.boehmod.blockfront.AbstractC0676mA
    public void tick() {
        super.tick();
        Level level = level();
        if (this.f4123b == null) {
            discard();
            return;
        }
        Vec3 vec3Position = position();
        if (this.f3612ew && Math.random() < 0.05d && !level.isClientSide() && this.f3611a != null) {
            level.addParticle(ParticleTypes.NOTE, vec3Position.x, vec3Position.y + 0.25d, vec3Position.z, 0.0d, 0.0d, 0.0d);
            C1210wD c1210wD = new C1210wD(new ItemStack(this.f4123b), vec3Position, this.f3611a.getId(), false, true, true);
            for (ServerPlayer serverPlayer : level.players()) {
                if (serverPlayer instanceof ServerPlayer) {
                    C1194vo.m6648a(c1210wD, serverPlayer);
                }
            }
        }
        int i = this.f4121lP;
        this.f4121lP = i - 1;
        if (i <= 0) {
            if (level.isClientSide()) {
                level.addParticle(ParticleTypes.EXPLOSION, true, vec3Position.x, vec3Position.y + 0.25d, vec3Position.z, 0.0d, 0.0d, 0.0d);
                level.playLocalSound(vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1280xc.f7787tK.get(), SoundSource.BLOCKS, 3.0f, 2.0f, false);
            }
            discard();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    /* JADX INFO: renamed from: bu */
    public void mo2981bu() {
        if (!this.f3612ew) {
            this.f3612ew = true;
        }
    }

    @Override // com.boehmod.blockfront.C0774nt
    /* JADX INFO: renamed from: bT */
    protected void mo3449bT() {
        this.f4122eY = true;
    }

    @Override // com.boehmod.blockfront.C0774nt, com.boehmod.blockfront.AbstractC0676mA
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("hasStopped", this.f4122eY);
        compoundTag.putBoolean("hasItem", this.f4123b != null);
        new ItemStack(this.f4123b).save(registryAccess(), compoundTag);
    }

    @Override // com.boehmod.blockfront.C0774nt, com.boehmod.blockfront.AbstractC0676mA
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.f4122eY = compoundTag.getBoolean("hasStopped");
        if (compoundTag.getBoolean("hasItem")) {
            this.f4123b = (C1144ur) ItemStack.parseOptional(registryAccess(), compoundTag).getItem();
        }
    }
}
