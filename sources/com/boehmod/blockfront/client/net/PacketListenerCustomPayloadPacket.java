package com.boehmod.blockfront.client.net;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.C0623l;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.payload.ClientboundCustomSetTimePayload;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/client/net/PacketListenerCustomPayloadPacket.class */
public class PacketListenerCustomPayloadPacket extends SimpleChannelInboundHandler<ClientboundCustomPayloadPacket> {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !PacketListenerCustomPayloadPacket.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void channelRead0(ChannelHandlerContext channelHandlerContext, ClientboundCustomPayloadPacket clientboundCustomPayloadPacket) {
        if (clientboundCustomPayloadPacket == null) {
            return;
        }
        CustomPacketPayload customPacketPayloadPayload = clientboundCustomPayloadPacket.payload();
        if ((customPacketPayloadPayload instanceof ClientboundCustomSetTimePayload) && onReadTimePayload(channelHandlerContext, (ClientboundCustomSetTimePayload) customPacketPayloadPayload)) {
            return;
        }
        channelHandlerContext.fireChannelRead(clientboundCustomPayloadPacket);
    }

    private boolean onReadTimePayload(@NotNull ChannelHandlerContext channelHandlerContext, @NotNull ClientboundCustomSetTimePayload clientboundCustomSetTimePayload) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!$assertionsDisabled && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (abstractC0863pbM2874a != null) {
            channelHandlerContext.fireChannelRead(new ClientboundCustomPayloadPacket(new ClientboundCustomSetTimePayload(clientboundCustomSetTimePayload.gameTime(), abstractC0863pbM2874a.m4089a().m6109by(), clientboundCustomSetTimePayload.gameRule(), clientboundCustomSetTimePayload.dayTimeFraction(), clientboundCustomSetTimePayload.dayTimePerTick())));
            return true;
        }
        return false;
    }
}
