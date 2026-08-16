package foundry.veil.mixin.network;

import foundry.veil.api.network.VeilPacketManager;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/network/NetworkMinecraftServerMixin.class */
@Mixin({MinecraftServer.class})
public abstract class NetworkMinecraftServerMixin implements VeilPacketManager.PacketSink {
    @Shadow
    public abstract PlayerList getPlayerList();

    @Override // foundry.veil.api.network.VeilPacketManager.PacketSink
    public void sendPacket(Packet<?> packet) {
        getPlayerList().broadcastAll(packet);
    }
}
