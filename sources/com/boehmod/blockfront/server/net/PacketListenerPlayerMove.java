package com.boehmod.blockfront.server.net;

import com.boehmod.blockfront.AbstractC0531jN;
import com.boehmod.blockfront.C0030a;
import com.boehmod.blockfront.C1280xT;
import com.boehmod.blockfront.C1326ym;
import com.boehmod.blockfront.C1328yo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/server/net/PacketListenerPlayerMove.class */
public class PacketListenerPlayerMove extends SimpleChannelInboundHandler<ServerboundMovePlayerPacket> {
    /* JADX INFO: Access modifiers changed from: protected */
    public void channelRead0(ChannelHandlerContext channelHandlerContext, ServerboundMovePlayerPacket serverboundMovePlayerPacket) {
        markPlayerMovement(channelHandlerContext, serverboundMovePlayerPacket);
        channelHandlerContext.fireChannelRead(serverboundMovePlayerPacket);
    }

    private void markPlayerMovement(@NotNull ChannelHandlerContext channelHandlerContext, @NotNull ServerboundMovePlayerPacket serverboundMovePlayerPacket) {
        Player serverPlayerFromConnection = PacketListenerUtils.getServerPlayerFromConnection(channelHandlerContext.channel());
        if (serverPlayerFromConnection == null) {
            return;
        }
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (abstractC0531jNM179a instanceof C1280xT) {
            C1326ym c1326ym = (C1326ym) ((C1328yo) ((C1280xT) abstractC0531jNM179a).m7277a()).m1150a(serverPlayerFromConnection);
            double x = serverPlayerFromConnection.getX();
            double y = serverPlayerFromConnection.getY();
            double z = serverPlayerFromConnection.getZ();
            float yRot = serverPlayerFromConnection.getYRot();
            float xRot = serverPlayerFromConnection.getXRot();
            boolean z2 = serverboundMovePlayerPacket.hasPosition() && !(serverboundMovePlayerPacket.getX(x) == x && serverboundMovePlayerPacket.getY(y) == y && serverboundMovePlayerPacket.getZ(z) == z);
            boolean z3 = serverboundMovePlayerPacket.hasRotation() && !(serverboundMovePlayerPacket.getYRot(yRot) == yRot && serverboundMovePlayerPacket.getXRot(xRot) == xRot);
            if (z2 || z3) {
                c1326ym.m8299a().m8276dV();
            }
        }
    }
}
