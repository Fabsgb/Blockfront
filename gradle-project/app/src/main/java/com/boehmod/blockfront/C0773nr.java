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

/* JADX INFO: renamed from: com.boehmod.blockfront.nr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nr.class */
public class C0773nr extends AbstractC0774ns {
    public C0773nr(EntityType<? extends C0773nr> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.AbstractC0774ns
    /* JADX INFO: renamed from: O */
    public String mo3644O() {
        return C1307xu.f7575ev;
    }

    @Override // com.boehmod.blockfront.AbstractC0774ns
    /* JADX INFO: renamed from: a */
    public Holder<SoundEvent> mo3645a() {
        return C1312xz.f9006Jn;
    }

    @Override // com.boehmod.blockfront.AbstractC0774ns
    /* JADX INFO: renamed from: aS */
    public int mo3646aS() {
        return 90;
    }

    @Override // com.boehmod.blockfront.AbstractC0774ns
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
