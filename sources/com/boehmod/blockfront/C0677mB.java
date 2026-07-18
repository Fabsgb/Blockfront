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

/* JADX INFO: renamed from: com.boehmod.blockfront.mB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mB.class */
public final class C0677mB extends C0726my {

    /* JADX INFO: renamed from: b */
    private static final EntityDataAccessor<Integer> f3615b = SynchedEntityData.defineId(C0677mB.class, EntityDataSerializers.INT);

    /* JADX INFO: renamed from: c */
    private static final EntityDataAccessor<Boolean> f3616c = SynchedEntityData.defineId(C0677mB.class, EntityDataSerializers.BOOLEAN);

    /* JADX INFO: renamed from: kM */
    private static final int f3617kM = 800;

    /* JADX INFO: renamed from: ew */
    private boolean f3618ew;

    /* JADX INFO: renamed from: kN */
    private int f3619kN;

    public C0677mB(@NotNull EntityType<? extends C0677mB> entityType, Level level) {
        super(entityType, level);
        this.f3619kN = 20;
    }

    /* JADX INFO: renamed from: d */
    private void m2995d(@NotNull Vec3 vec3) {
        Level level = level();
        level.playSound((Player) null, vec3.x, vec3.y, vec3.z, (SoundEvent) C1280xc.f7804ub.get(), SoundSource.NEUTRAL, 20.0f, 1.0f);
        if (!this.f3618ew) {
            if (this.f3894a != null) {
                C1194vo.m6651a(new C1200vu(EnumC0786oE.ARTILLERY_EXPLOSION, position()), this.f3894a);
                Object obj = this.f3894a;
                if (obj instanceof InterfaceC0898qK) {
                    ((InterfaceC0898qK) obj).m4651a(this, level);
                }
            }
            this.f3618ew = true;
        }
        discard();
    }

    /* JADX INFO: renamed from: bv */
    public void m2996bv() {
        m3001C(true);
        playSound((SoundEvent) C1280xc.f7809ug.get(), 1.0f + (5.0f * (1.0f - ((m2997at() / 45.0f) / 20.0f))), 1.0f);
    }

    /* JADX INFO: renamed from: at */
    public int m2997at() {
        return ((Integer) this.entityData.get(f3615b)).intValue();
    }

    /* JADX INFO: renamed from: o */
    public void m2998o(int i) {
        this.entityData.set(f3615b, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: bw */
    public void m2999bw() {
        int iM2997at = m2997at();
        if (iM2997at > 0) {
            this.entityData.set(f3615b, Integer.valueOf(iM2997at - 1));
        }
    }

    /* JADX INFO: renamed from: aD */
    public boolean m3000aD() {
        return ((Boolean) this.entityData.get(f3616c)).booleanValue();
    }

    /* JADX INFO: renamed from: C */
    public void m3001C(boolean z) {
        this.entityData.set(f3616c, Boolean.valueOf(z));
    }

    @Override // com.boehmod.blockfront.C0726my
    public void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(f3615b, Integer.valueOf(f3617kM)).define(f3616c, false);
    }

    @Override // com.boehmod.blockfront.C0726my
    public void tick() {
        super.tick();
        Level level = level();
        Vec3 vec3Position = position();
        int iM2997at = m2997at();
        setDeltaMovement(getDeltaMovement().add(0.0d, -0.10000000149011612d, 0.0d));
        move(MoverType.SELF, getDeltaMovement());
        if (m3000aD()) {
            return;
        }
        int i = this.f3619kN;
        this.f3619kN = i - 1;
        if (i <= 0) {
            float f = iM2997at / 45.0f;
            float f2 = 1.0f - (f / 20.0f);
            this.f3619kN = (int) (f * 2.0f);
            level.playSound((Player) null, vec3Position.x, vec3Position.y, vec3Position.z, (SoundEvent) C1280xc.f7802tZ.get(), SoundSource.NEUTRAL, 2.0f + (5.0f * f2), 1.0f + f2);
        }
        m2999bw();
        if (m2997at() <= 0) {
            m2995d(vec3Position);
        }
    }

    @Override // com.boehmod.blockfront.C0726my
    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @Override // com.boehmod.blockfront.C0726my
    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
