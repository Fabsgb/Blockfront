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

/* JADX INFO: renamed from: com.boehmod.blockfront.mV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mV.class */
public class C0697mV extends AbstractC0698mW {
    public C0697mV(EntityType<? extends C0697mV> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.AbstractC0698mW
    /* JADX INFO: renamed from: H */
    public String mo3137H() {
        return C1230wX.f7010ek;
    }

    @Override // com.boehmod.blockfront.AbstractC0698mW
    /* JADX INFO: renamed from: a */
    public Holder<SoundEvent> mo3138a() {
        return C1280xc.f8592Jj;
    }

    @Override // com.boehmod.blockfront.AbstractC0698mW
    /* JADX INFO: renamed from: aD */
    public int mo3139aD() {
        return 90;
    }

    @Override // com.boehmod.blockfront.AbstractC0698mW
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
