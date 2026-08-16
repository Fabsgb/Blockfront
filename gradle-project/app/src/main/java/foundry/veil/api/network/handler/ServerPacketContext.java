package foundry.veil.api.network.handler;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/network/handler/ServerPacketContext.class */
public interface ServerPacketContext extends PacketContext {
    @Override // foundry.veil.api.network.handler.PacketContext
    @NotNull
    /* JADX INFO: renamed from: player, reason: merged with bridge method [inline-methods] */
    ServerPlayer mo9446player();

    default MinecraftServer server() {
        return mo9446player().getServer();
    }

    @Override // foundry.veil.api.network.handler.PacketContext
    @NotNull
    default Level level() {
        return mo9446player().level();
    }
}
