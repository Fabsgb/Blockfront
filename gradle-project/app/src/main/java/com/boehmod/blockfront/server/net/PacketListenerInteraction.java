package com.boehmod.blockfront.server.net;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.network.protocol.game.ServerboundInteractPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/server/net/PacketListenerInteraction.class */
public class PacketListenerInteraction extends SimpleChannelInboundHandler<ServerboundInteractPacket> {
    /* JADX INFO: Access modifiers changed from: protected */
    public void channelRead0(ChannelHandlerContext channelHandlerContext, ServerboundInteractPacket serverboundInteractPacket) {
        Entity target;
        ServerPlayer serverPlayerFromConnection = PacketListenerUtils.getServerPlayerFromConnection(channelHandlerContext.channel());
        if (serverPlayerFromConnection != null && (target = serverboundInteractPacket.getTarget(serverPlayerFromConnection.serverLevel())) != null && target.getId() == serverPlayerFromConnection.getId()) {
            return;
        }
        channelHandlerContext.fireChannelRead(serverboundInteractPacket);
    }
}
