package software.bernie.geckolib.network.packet;

import java.util.function.Consumer;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/network/packet/MultiloaderPacket.class */
public interface MultiloaderPacket extends CustomPacketPayload {
    void receiveMessage(@Nullable Player player, Consumer<Runnable> consumer);
}
