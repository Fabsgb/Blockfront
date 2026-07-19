package com.boehmod.blockfront.cloud.connection;

import com.boehmod.bflib.cloud.packet.PacketCodec;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cloud/connection/ModConnectionChannelInitializer.class */
public class ModConnectionChannelInitializer extends ChannelInitializer<SocketChannel> {
    private static final int READER_IDLE_TIME = 30;

    @NotNull
    private final ModConnection connectionHandler;

    public ModConnectionChannelInitializer(@NotNull ModConnection modConnection) {
        this.connectionHandler = modConnection;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initChannel(SocketChannel socketChannel) {
        socketChannel.pipeline().addLast("idleStateHandler", new IdleStateHandler(30L, 0L, 0L, TimeUnit.SECONDS)).addLast("frameDecoder", PacketCodec.createFrameDecoder()).addLast("frameEncoder", PacketCodec.createFrameEncoder()).addLast("packetDecoder", new PacketCodec.PacketDecoder()).addLast("packetEncoder", new PacketCodec.PacketEncoder()).addLast("handler", new ModConnectionInboundHandler(this.connectionHandler));
    }
}
