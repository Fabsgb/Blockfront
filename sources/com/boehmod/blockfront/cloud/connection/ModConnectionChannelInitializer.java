package com.boehmod.blockfront.cloud.connection;

import com.boehmod.bflib.cloud.packet.PacketCodec;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.flush.FlushConsolidationHandler;
import io.netty.handler.timeout.IdleStateHandler;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cloud/connection/ModConnectionChannelInitializer.class */
public class ModConnectionChannelInitializer extends ChannelInitializer<SocketChannel> {

    @NotNull
    private final ModConnection connectionHandler;

    public ModConnectionChannelInitializer(@NotNull ModConnection modConnection) {
        this.connectionHandler = modConnection;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initChannel(SocketChannel socketChannel) {
        ChannelPipeline channelPipelineAddLast = socketChannel.pipeline().addLast("idleTimeout", new IdleStateHandler(30L, 0L, 0L, TimeUnit.SECONDS)).addLast("flushConsolidation", new FlushConsolidationHandler(256, true));
        PacketCodec.installFrameCodec(channelPipelineAddLast);
        PacketCodec.installPacketCodec(channelPipelineAddLast);
        channelPipelineAddLast.addLast("handler", new ModConnectionInboundHandler(this.connectionHandler));
    }
}
