package foundry.veil.mixin.network;

import foundry.veil.api.network.VeilPacketManager;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/network/NetworkServerPlayerMixin.class */
@Mixin({ServerPlayer.class})
public class NetworkServerPlayerMixin implements VeilPacketManager.PacketSink {

    @Shadow
    public ServerGamePacketListenerImpl connection;

    @Override // foundry.veil.api.network.VeilPacketManager.PacketSink
    public void sendPacket(Packet<?> packet) {
        this.connection.send(packet);
    }
}
