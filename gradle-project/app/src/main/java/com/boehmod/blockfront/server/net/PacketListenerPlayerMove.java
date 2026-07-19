package com.boehmod.blockfront.server.net;

import com.boehmod.blockfront.AbstractC0264ju;
import com.boehmod.blockfront.C0002a;
import com.boehmod.blockfront.xO;
import com.boehmod.blockfront.xQ;
import com.boehmod.blockfront.xw;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.world.entity.player.Player;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/server/net/PacketListenerPlayerMove.class */
public class PacketListenerPlayerMove extends SimpleChannelInboundHandler<ServerboundMovePlayerPacket> {
    /* JADX INFO: Access modifiers changed from: protected */
    public void channelRead0(ChannelHandlerContext channelHandlerContext, ServerboundMovePlayerPacket serverboundMovePlayerPacket) {
        Player serverPlayerFromConnection;
        if (serverboundMovePlayerPacket == null || (serverPlayerFromConnection = PacketListenerUtils.getServerPlayerFromConnection(channelHandlerContext.channel())) == null) {
            return;
        }
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (abstractC0264juM166a instanceof xw) {
            xO xOVar = (xO) ((xQ) ((xw) abstractC0264juM166a).a()).a(serverPlayerFromConnection);
            double x = serverPlayerFromConnection.getX();
            double z = serverPlayerFromConnection.getZ();
            double x2 = serverboundMovePlayerPacket.getX(0.0d);
            double z2 = serverboundMovePlayerPacket.getZ(0.0d);
            if (serverboundMovePlayerPacket.hasRotation() && x2 != x && z2 != z && x2 != 0.0d && z2 != 0.0d) {
                xOVar.m1674a().dL();
            }
            channelHandlerContext.fireChannelRead(serverboundMovePlayerPacket);
        }
    }
}
