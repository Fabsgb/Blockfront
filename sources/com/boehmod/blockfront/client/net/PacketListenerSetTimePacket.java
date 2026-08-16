package com.boehmod.blockfront.client.net;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.C0623l;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.network.protocol.game.ClientboundSetTimePacket;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/client/net/PacketListenerSetTimePacket.class */
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
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!$assertionsDisabled && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (abstractC0863pbM2874a != null) {
            channelHandlerContext.fireChannelRead(new ClientboundSetTimePacket(clientboundSetTimePacket.getGameTime(), abstractC0863pbM2874a.m4089a().m6109by(), false));
        } else {
            channelHandlerContext.fireChannelRead(clientboundSetTimePacket);
        }
    }
}
