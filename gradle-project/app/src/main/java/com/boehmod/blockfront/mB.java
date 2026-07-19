package com.boehmod.blockfront;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mB.class */
public final class mB extends C0349my {
    private static final EntityDataAccessor<Integer> b = SynchedEntityData.defineId(mB.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> c = SynchedEntityData.defineId(mB.class, EntityDataSerializers.BOOLEAN);
    private static final int kM = 800;
    private boolean ew;
    private int kN;

    public mB(@NotNull EntityType<? extends mB> entityType, Level level) {
        super(entityType, level);
        this.kN = 20;
    }

    private void d(@NotNull Vec3 vec3) {
        Level level = level();
        level.playSound((Player) null, vec3.x, vec3.y, vec3.z, (SoundEvent) C0624xc.ub.get(), SoundSource.NEUTRAL, 20.0f, 1.0f);
        if (!this.ew) {
            if (this.a != null) {
                C0582vo.a(new C0588vu(oE.ARTILLERY_EXPLOSION, position()), this.a);
                Object obj = this.a;
                if (obj instanceof qK) {
                    ((qK) obj).a(this, level);
                }
            }
            this.ew = true;
        }
        discard();
    }

    public void bv() {
        C(true);
        playSound((SoundEvent) C0624xc.ug.get(), 1.0f + (5.0f * (1.0f - ((at() / 45.0f) / 20.0f))), 1.0f);
    }

    public int at() {
        return ((Integer) this.entityData.get(b)).intValue();
    }

    public void o(int i) {
        this.entityData.set(b, Integer.valueOf(i));
    }

    public void bw() {
        int iAt = at();
        if (iAt > 0) {
            this.entityData.set(b, Integer.valueOf(iAt - 1));
        }
    }

    public boolean aD() {
        return ((Boolean) this.entityData.get(c)).booleanValue();
    }

    public void C(boolean z) {
        this.entityData.set(c, Boolean.valueOf(z));
    }

    @Override // com.boehmod.blockfront.C0349my
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(b, Integer.valueOf(kM)).define(c, false);
    }

    @Override // com.boehmod.blockfront.C0349my
    public void tick() {
        super.tick();
        Level level = level();
        Vec3 vec3Position = position();
        int iAt = at();
        setDeltaMovement(getDeltaMovement().add(0.0d, -0.10000000149011612d, 0.0d));
        move(MoverType.SELF, getDeltaMovement());
        if (aD()) {
            return;
        }
        int i = this.kN;
        this.kN = i - 1;
        if (i <= 0) {
            float f = iAt / 45.0f;
            float f2 = 1.0f - (f / 20.0f);
            this.kN = (int) (f * 2.0f);
            level.playSound((Player) null, vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C0624xc.tZ.get(), SoundSource.NEUTRAL, 2.0f + (5.0f * f2), 1.0f + f2);
        }
        bw();
        if (at() <= 0) {
            d(vec3Position);
        }
    }

    @Override // com.boehmod.blockfront.C0349my
    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @Override // com.boehmod.blockfront.C0349my
    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
