package com.boehmod.blockfront.client.net;

import com.boehmod.blockfront.C0297l;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.network.protocol.game.ClientboundSetTimePacket;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/client/net/PacketListenerSetTimePacket.class */
public class PacketListenerSetTimePacket extends SimpleChannelInboundHandler<ClientboundSetTimePacket> {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !PacketListenerSetTimePacket.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void channelRead0(ChannelHandlerContext channelHandlerContext, ClientboundSetTimePacket clientboundSetTimePacket) {
        if (clientboundSetTimePacket == null) {
            return;
        }
        C0297l c0297lB = C0297l.b();
        if (!$assertionsDisabled && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0297lB.m591a() != null) {
            channelHandlerContext.fireChannelRead(new ClientboundSetTimePacket(clientboundSetTimePacket.getGameTime(), r0.m767a().bj(), false));
        } else {
            channelHandlerContext.fireChannelRead(clientboundSetTimePacket);
        }
    }
}
