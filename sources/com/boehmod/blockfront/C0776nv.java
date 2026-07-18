package com.boehmod.blockfront;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nv.class */
public class C0776nv extends C0772nr {
    public C0776nv(EntityType<? extends C0774nt> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.C0772nr, com.boehmod.blockfront.AbstractC0676mA
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.AbstractC0770np, com.boehmod.blockfront.C0774nt, com.boehmod.blockfront.AbstractC0676mA
    public void tick() {
        super.tick();
        if (this.f4135lN > 0) {
            mo2981bu();
        }
    }

    @Override // com.boehmod.blockfront.C0772nr, com.boehmod.blockfront.AbstractC0770np
    /* JADX INFO: renamed from: g */
    protected SoundEvent mo3467g() {
        return (SoundEvent) C1280xc.f7792tP.get();
    }

    @Override // com.boehmod.blockfront.C0774nt
    /* JADX INFO: renamed from: aH */
    public int mo3445aH() {
        return 1;
    }
}
