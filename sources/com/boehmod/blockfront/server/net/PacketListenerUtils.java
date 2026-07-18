package com.boehmod.blockfront.server.net;

import com.boehmod.blockfront.C0561js;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import java.net.SocketAddress;
import javax.annotation.Nullable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/server/net/PacketListenerUtils.class */
public class PacketListenerUtils {
    @Nullable
    public static ServerPlayer getServerPlayerFromConnection(@NotNull Channel channel) {
        if (!(channel instanceof AbstractChannel)) {
            return null;
        }
        SocketAddress socketAddressRemoteAddress = ((AbstractChannel) channel).remoteAddress();
        MinecraftServer minecraftServerM2514a = C0561js.m2514a();
        if (minecraftServerM2514a == null) {
            return null;
        }
        return findPlayerByAddress(minecraftServerM2514a.getPlayerList(), socketAddressRemoteAddress);
    }

    @Nullable
    private static ServerPlayer findPlayerByAddress(@NotNull PlayerList playerList, @NotNull SocketAddress socketAddress) {
        for (ServerPlayer serverPlayer : playerList.getPlayers()) {
            if (socketAddress.equals(serverPlayer.connection.getConnection().getRemoteAddress())) {
                return serverPlayer;
            }
        }
        return null;
    }
}
