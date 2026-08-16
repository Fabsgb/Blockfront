package foundry.veil.impl.network;

import foundry.veil.api.network.VeilPacketManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/network/ClientPacketSink.class */
@ApiStatus.Internal
public enum ClientPacketSink implements VeilPacketManager.PacketSink {
    INSTANCE;

    @Override // foundry.veil.api.network.VeilPacketManager.PacketSink
    public void sendPacket(CustomPacketPayload... payloads) {
        for (CustomPacketPayload payload : payloads) {
            sendPacket((Packet<?>) new ServerboundCustomPayloadPacket(payload));
        }
    }

    @Override // foundry.veil.api.network.VeilPacketManager.PacketSink
    public void sendPacket(Packet<?> packet) {
        ClientPacketListener connection = Minecraft.getInstance().getConnection();
        if (connection == null) {
            throw new IllegalStateException("Cannot send client packets while not connected to a server");
        }
        connection.send(packet);
    }
}
