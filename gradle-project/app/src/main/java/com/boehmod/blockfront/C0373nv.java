package com.boehmod.blockfront;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nv.class */
public class C0373nv extends C0369nr {
    public C0373nv(EntityType<? extends C0371nt> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.C0369nr, com.boehmod.blockfront.mA
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.AbstractC0367np, com.boehmod.blockfront.C0371nt, com.boehmod.blockfront.mA
    public void tick() {
        super.tick();
        if (this.lN > 0) {
            bu();
        }
    }

    @Override // com.boehmod.blockfront.C0369nr, com.boehmod.blockfront.AbstractC0367np
    protected SoundEvent g() {
        return (SoundEvent) C0624xc.tP.get();
    }

    @Override // com.boehmod.blockfront.C0371nt
    public int aH() {
        return 1;
    }
}
