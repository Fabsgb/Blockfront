package foundry.veil.api.network.handler;

import net.minecraft.network.PacketSendListener;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/network/handler/PacketContext.class */
public interface PacketContext {
    @Nullable
    /* JADX INFO: renamed from: player */
    Player mo9063player();

    Packet<?> createPacket(CustomPacketPayload customPacketPayload);

    void sendPacket(Packet<?> packet, @Nullable PacketSendListener packetSendListener);

    void disconnect(Component component);

    @Nullable
    default Level level() {
        Player player = mo9063player();
        if (player != null) {
            return player.level();
        }
        return null;
    }

    default void sendPacket(CustomPacketPayload payload) {
        sendPacket(createPacket(payload), (PacketSendListener) null);
    }

    default void sendPacket(CustomPacketPayload payload, @Nullable PacketSendListener callback) {
        sendPacket(createPacket(payload), callback);
    }

    default void sendPacket(Packet<?> packet) {
        sendPacket(packet, (PacketSendListener) null);
    }
}
