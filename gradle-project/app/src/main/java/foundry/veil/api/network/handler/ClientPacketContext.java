package foundry.veil.api.network.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/network/handler/ClientPacketContext.class */
public interface ClientPacketContext extends PacketContext {
    Minecraft client();

    @Override // foundry.veil.api.network.handler.PacketContext
    @Nullable
    /* JADX INFO: renamed from: player, reason: merged with bridge method [inline-methods] */
    LocalPlayer mo1889player();
}
