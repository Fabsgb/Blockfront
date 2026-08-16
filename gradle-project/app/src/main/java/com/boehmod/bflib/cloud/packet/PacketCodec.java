package com.boehmod.bflib.cloud.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/PacketCodec.class */
public final class PacketCodec {
    public static final int DEFAULT_MAX_PACKET_SIZE = 1048576;
    public static final int DEFAULT_LENGTH_FIELD_SIZE = 4;

    @NotNull
    public static final String PIPELINE_FRAME_DECODER = "frameDecoder";

    @NotNull
    public static final String PIPELINE_FRAME_ENCODER = "frameEncoder";

    @NotNull
    public static final String PIPELINE_PACKET_DECODER = "packetDecoder";

    @NotNull
    public static final String PIPELINE_PACKET_ENCODER = "packetEncoder";

    @NotNull
    private static final Logger LOGGER = LogManager.getLogger("PacketCodec");

    @NotNull
    private static volatile PacketObserver observer = new PacketObserver() { // from class: com.boehmod.bflib.cloud.packet.PacketCodec.1
    };

    public static void setObserver(@NotNull PacketObserver newObserver) {
        observer = newObserver;
    }

    @NotNull
    static PacketObserver getObserver() {
        return observer;
    }

    @NotNull
    public static LengthFieldBasedFrameDecoder createFrameDecoder(int maxPacketSize, int lengthFieldSize) {
        return new LengthFieldBasedFrameDecoder(maxPacketSize, 0, lengthFieldSize, 0, lengthFieldSize);
    }

    @NotNull
    public static LengthFieldBasedFrameDecoder createFrameDecoder() {
        return createFrameDecoder(1048576, 4);
    }

    @NotNull
    public static LengthFieldPrepender createFrameEncoder(int lengthFieldSize) {
        return new LengthFieldPrepender(lengthFieldSize);
    }

    @NotNull
    public static LengthFieldPrepender createFrameEncoder() {
        return createFrameEncoder(4);
    }

    public static void installFrameCodec(@NotNull ChannelPipeline pipeline, int maxPacketSize, int lengthFieldSize) {
        pipeline.addLast(PIPELINE_FRAME_DECODER, createFrameDecoder(maxPacketSize, lengthFieldSize));
        pipeline.addLast(PIPELINE_FRAME_ENCODER, createFrameEncoder(lengthFieldSize));
    }

    public static void installFrameCodec(@NotNull ChannelPipeline pipeline) {
        installFrameCodec(pipeline, 1048576, 4);
    }

    public static void installPacketCodec(@NotNull ChannelPipeline pipeline) {
        pipeline.addLast(PIPELINE_PACKET_DECODER, new PacketDecoder());
        pipeline.addLast(PIPELINE_PACKET_ENCODER, new PacketEncoder());
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/PacketCodec$PacketDecoder.class */
    public static class PacketDecoder extends ChannelInboundHandlerAdapter {
        public static final int MAX_DECODE_FAILURES = 3;
        private int decodeFailures = 0;

        public void channelRead(@NotNull ChannelHandlerContext ctx, @NotNull Object msg) {
            ByteBuf buf = (ByteBuf) msg;
            try {
                int bytes = buf.readableBytes();
                int hashPeek = bytes >= 4 ? buf.getInt(buf.readerIndex()) : 0;
                IPacket packet = PacketRegistry.readPacket(buf);
                if (packet != null) {
                    if (PacketCodec.LOGGER.isTraceEnabled()) {
                        PacketCodec.LOGGER.trace("Decoded packet {} ({} bytes)", packet.getClass().getSimpleName(), Integer.valueOf(bytes));
                    }
                    PacketCodec.getObserver().onPacketDecoded(packet, bytes);
                    ctx.fireChannelRead(packet);
                } else {
                    PacketCodec.getObserver().onPacketDecodeFailed(hashPeek, bytes);
                    PacketCodec.LOGGER.warn("Failed to decode packet with {} bytes (hash: {})", Integer.valueOf(bytes), Integer.valueOf(hashPeek));
                    int i = this.decodeFailures + 1;
                    this.decodeFailures = i;
                    if (i >= 3) {
                        PacketCodec.LOGGER.warn("Closing connection after {} packet decode failures", Integer.valueOf(this.decodeFailures));
                        ctx.close();
                    }
                }
            } finally {
                buf.release();
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/PacketCodec$PacketEncoder.class */
    public static class PacketEncoder extends ChannelOutboundHandlerAdapter {
        public void write(@NotNull ChannelHandlerContext ctx, Object msg, @NotNull ChannelPromise promise) {
            if (msg instanceof IPacket) {
                IPacket packet = (IPacket) msg;
                ByteBuf buf = ctx.alloc().buffer();
                try {
                    PacketRegistry.writePacket(packet, buf);
                    PacketCodec.getObserver().onPacketEncoded(packet, buf.readableBytes());
                    ctx.write(buf, promise);
                    return;
                } catch (Exception e) {
                    PacketCodec.getObserver().onPacketEncodeFailed(packet);
                    PacketCodec.LOGGER.error("Failed to encode packet", e);
                    buf.release();
                    promise.setFailure(e);
                    return;
                }
            }
            ctx.write(msg, promise);
        }
    }

    private PacketCodec() {
        throw new UnsupportedOperationException("Utility class");
    }
}
