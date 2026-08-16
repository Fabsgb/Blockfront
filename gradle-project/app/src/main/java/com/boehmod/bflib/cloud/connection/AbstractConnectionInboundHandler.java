package com.boehmod.bflib.cloud.connection;

import com.boehmod.bflib.cloud.connection.Connection;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/connection/AbstractConnectionInboundHandler.class */
public abstract class AbstractConnectionInboundHandler<C extends Connection<?>> extends ChannelInboundHandlerAdapter {

    @NotNull
    protected final C connectionHandler;

    @NotNull
    private final String remoteClosedReason;

    protected abstract void onIdleTimeout();

    protected AbstractConnectionInboundHandler(@NotNull C connectionHandler, @NotNull String remoteClosedReason) {
        this.connectionHandler = connectionHandler;
        this.remoteClosedReason = remoteClosedReason;
    }

    public void channelInactive(@NotNull ChannelHandlerContext ctx) {
        this.connectionHandler.disconnect(this.remoteClosedReason, false);
    }

    public void userEventTriggered(@NotNull ChannelHandlerContext ctx, @NotNull Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            onIdleTimeout();
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
}
