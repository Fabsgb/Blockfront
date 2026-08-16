package com.boehmod.blockfront;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nR.class */
public class C0747nR extends C0743nN {
    public C0747nR(EntityType<? extends C0745nP> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.C0743nN, com.boehmod.blockfront.AbstractC0699mW
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.AbstractC0741nL, com.boehmod.blockfront.C0745nP, com.boehmod.blockfront.AbstractC0699mW
    public void tick() {
        super.tick();
        if (this.f4090nL > 0) {
            mo3132bF();
        }
    }

    @Override // com.boehmod.blockfront.C0743nN, com.boehmod.blockfront.AbstractC0741nL
    /* JADX INFO: renamed from: g */
    protected SoundEvent mo3390g() {
        return (SoundEvent) C1312xz.f8203tQ.get();
    }

    @Override // com.boehmod.blockfront.C0745nP
    /* JADX INFO: renamed from: aW */
    public int mo3368aW() {
        return 1;
    }
}
