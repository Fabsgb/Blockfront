package com.boehmod.blockfront;

import net.minecraft.core.Holder;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mX.class */
public class mX extends mW {
    public mX(EntityType<? extends mX> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.mW
    public String H() {
        return wX.ej;
    }

    @Override // com.boehmod.blockfront.mW
    /* JADX INFO: renamed from: a */
    public Holder<SoundEvent> mo680a() {
        return C0624xc.st;
    }

    @Override // com.boehmod.blockfront.mW
    public int aD() {
        return 50;
    }

    @Override // com.boehmod.blockfront.mW
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
