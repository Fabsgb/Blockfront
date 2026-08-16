package com.boehmod.blockfront.server.net;

import io.netty.channel.Channel;
import javax.annotation.Nullable;
import net.minecraft.network.Connection;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/server/net/PacketListenerUtils.class */
public class PacketListenerUtils {
    @Nullable
    public static ServerPlayer getServerPlayerFromConnection(@NotNull Channel channel) {
        Connection connection = channel.pipeline().get("packet_handler");
        if (!(connection instanceof Connection)) {
            return null;
        }
        ServerGamePacketListenerImpl packetListener = connection.getPacketListener();
        if (packetListener instanceof ServerGamePacketListenerImpl) {
            return packetListener.player;
        }
        return null;
    }
}
