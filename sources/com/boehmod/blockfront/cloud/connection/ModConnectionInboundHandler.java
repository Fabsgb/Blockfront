package com.boehmod.blockfront.cloud.connection;

import com.boehmod.bflib.cloud.connection.AbstractConnectionInboundHandler;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.primitives.EncryptionKeyExchangePacket;
import com.boehmod.blockfront.C0530jM;
import io.netty.channel.ChannelHandlerContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cloud/connection/ModConnectionInboundHandler.class */
public class ModConnectionInboundHandler extends AbstractConnectionInboundHandler<ModConnection> {
    public ModConnectionInboundHandler(@NotNull ModConnection modConnection) {
        super(modConnection, "Connection closed by server");
    }

    public void channelRead(@NotNull ChannelHandlerContext channelHandlerContext, @NotNull Object obj) {
        if (obj instanceof IPacket) {
            IPacket iPacket = (IPacket) obj;
            if (iPacket instanceof EncryptionKeyExchangePacket) {
                C0530jM.log("[Connection Handler] Received encryption key exchange packet", new Object[0]);
                ((ModConnection) this.connectionHandler).handleEncryptionKeyExchange((EncryptionKeyExchangePacket) iPacket);
                return;
            }
            ((ModConnection) this.connectionHandler).addIncomingPacket(iPacket);
        }
    }

    @Override // com.boehmod.bflib.cloud.connection.AbstractConnectionInboundHandler
    protected void onIdleTimeout() {
        ((ModConnection) this.connectionHandler).disconnect("Idle Timeout.", false);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        C0530jM.m2338a("[Connection Handler] Channel exception", th, new Object[0]);
        ((ModConnection) this.connectionHandler).disconnect("Channel error: " + th.getMessage(), false);
    }
}
