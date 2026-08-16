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

/* JADX INFO: renamed from: com.boehmod.blockfront.mX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mX.class */
public final class C0700mX extends C0697mU {

    /* JADX INFO: renamed from: b */
    private static final EntityDataAccessor<Integer> f3865b = SynchedEntityData.defineId(C0700mX.class, EntityDataSerializers.INT);

    /* JADX INFO: renamed from: c */
    private static final EntityDataAccessor<Boolean> f3866c = SynchedEntityData.defineId(C0700mX.class, EntityDataSerializers.BOOLEAN);

    /* JADX INFO: renamed from: mK */
    private static final int f3867mK = 800;

    /* JADX INFO: renamed from: eQ */
    private boolean f3868eQ;

    /* JADX INFO: renamed from: mL */
    private int f3869mL;

    public C0700mX(@NotNull EntityType<? extends C0700mX> entityType, Level level) {
        super(entityType, level);
        this.f3869mL = 20;
    }

    /* JADX INFO: renamed from: d */
    private void m3146d(@NotNull Vec3 vec3) {
        Level level = level();
        level.playSound((Player) null, vec3.x, vec3.y, vec3.z, (SoundEvent) C1312xz.f8215uc.get(), SoundSource.NEUTRAL, 20.0f, 1.0f);
        if (!this.f3868eQ) {
            if (this.f3853a != null) {
                C1169vO.m6646a(new C1175vU(EnumC0862pa.ARTILLERY_EXPLOSION, position()), this.f3853a);
                Object obj = this.f3853a;
                if (obj instanceof InterfaceC0975rh) {
                    ((InterfaceC0975rh) obj).m5546a(this, level);
                }
            }
            this.f3868eQ = true;
        }
        discard();
    }

    /* JADX INFO: renamed from: bG */
    public void m3147bG() {
        m3152C(true);
        playSound((SoundEvent) C1312xz.f8220uh.get(), 1.0f + (5.0f * (1.0f - ((m3148aI() / 45.0f) / 20.0f))), 1.0f);
    }

    /* JADX INFO: renamed from: aI */
    public int m3148aI() {
        return ((Integer) this.entityData.get(f3865b)).intValue();
    }

    /* JADX INFO: renamed from: p */
    public void m3149p(int i) {
        this.entityData.set(f3865b, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: bH */
    public void m3150bH() {
        int iM3148aI = m3148aI();
        if (iM3148aI > 0) {
            this.entityData.set(f3865b, Integer.valueOf(iM3148aI - 1));
        }
    }

    /* JADX INFO: renamed from: aO */
    public boolean m3151aO() {
        return ((Boolean) this.entityData.get(f3866c)).booleanValue();
    }

    /* JADX INFO: renamed from: C */
    public void m3152C(boolean z) {
        this.entityData.set(f3866c, Boolean.valueOf(z));
    }

    @Override // com.boehmod.blockfront.C0697mU
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(f3865b, Integer.valueOf(f3867mK)).define(f3866c, false);
    }

    @Override // com.boehmod.blockfront.C0697mU
    public void tick() {
        super.tick();
        Level level = level();
        Vec3 vec3Position = position();
        int iM3148aI = m3148aI();
        setDeltaMovement(getDeltaMovement().add(0.0d, -0.10000000149011612d, 0.0d));
        move(MoverType.SELF, getDeltaMovement());
        if (m3151aO()) {
            return;
        }
        int i = this.f3869mL;
        this.f3869mL = i - 1;
        if (i <= 0) {
            float f = iM3148aI / 45.0f;
            float f2 = 1.0f - (f / 20.0f);
            this.f3869mL = (int) (f * 2.0f);
            level.playSound((Player) null, vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1312xz.f8213ua.get(), SoundSource.NEUTRAL, 2.0f + (5.0f * f2), 1.0f + f2);
        }
        m3150bH();
        if (m3148aI() <= 0) {
            m3146d(vec3Position);
        }
    }

    @Override // com.boehmod.blockfront.C0697mU
    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @Override // com.boehmod.blockfront.C0697mU
    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
