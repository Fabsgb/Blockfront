package com.boehmod.blockfront.server.net;

import com.boehmod.blockfront.AbstractC0563ju;
import com.boehmod.blockfront.C0029a;
import com.boehmod.blockfront.C1274xO;
import com.boehmod.blockfront.C1276xQ;
import com.boehmod.blockfront.C1300xw;
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
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (abstractC0563juM168a instanceof C1300xw) {
            C1274xO c1274xO = (C1274xO) ((C1276xQ) ((C1300xw) abstractC0563juM168a).m7950a()).m1133a(serverPlayerFromConnection);
            double x = serverPlayerFromConnection.getX();
            double z = serverPlayerFromConnection.getZ();
            double x2 = serverboundMovePlayerPacket.getX(0.0d);
            double z2 = serverboundMovePlayerPacket.getZ(0.0d);
            if (serverboundMovePlayerPacket.hasRotation() && x2 != x && z2 != z && x2 != 0.0d && z2 != 0.0d) {
                c1274xO.m7783a().m7760dL();
            }
            channelHandlerContext.fireChannelRead(serverboundMovePlayerPacket);
        }
    }
}
