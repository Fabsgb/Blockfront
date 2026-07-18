package com.boehmod.blockfront.cloud.connection;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.primitives.EncryptionKeyExchangePacket;
import com.boehmod.blockfront.C0562jt;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cloud/connection/ModConnectionInboundHandler.class */
public class ModConnectionInboundHandler extends ChannelInboundHandlerAdapter {

    @Nullable
    private ByteBuf cumulativeBuffer = Unpooled.buffer();

    @NotNull
    private final ModConnection connectionHandler;

    public ModConnectionInboundHandler(@NotNull ModConnection modConnection) {
        this.connectionHandler = modConnection;
    }

    public void channelRead(@NotNull ChannelHandlerContext channelHandlerContext, @NotNull Object obj) {
        if (obj instanceof IPacket) {
            IPacket iPacket = (IPacket) obj;
            this.connectionHandler.bumpIdle();
            if (iPacket instanceof EncryptionKeyExchangePacket) {
                C0562jt.log("[Connection Handler] Received encryption key exchange packet", new Object[0]);
                this.connectionHandler.handleEncryptionKeyExchange((EncryptionKeyExchangePacket) iPacket);
                return;
            }
            this.connectionHandler.addIncomingPacket(iPacket);
        }
    }

    public void channelInactive(@NotNull ChannelHandlerContext channelHandlerContext) {
        C0562jt.log("[Connection Handler] Channel inactive", new Object[0]);
        this.connectionHandler.disconnect("Connection closed by server", false);
        if (this.cumulativeBuffer != null) {
            this.cumulativeBuffer.release();
            this.cumulativeBuffer = null;
        }
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        C0562jt.m2516a("[Connection Handler] Channel exception", th, new Object[0]);
        this.connectionHandler.disconnect("Channel error: " + th.getMessage(), false);
        if (this.cumulativeBuffer != null) {
            this.cumulativeBuffer.release();
            this.cumulativeBuffer = null;
        }
    }
}
