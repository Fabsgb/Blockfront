package com.boehmod.bflib.cloud.packet;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/ByteBufWriter.class */
@FunctionalInterface
public interface ByteBufWriter<T> {
    void write(@NotNull ByteBuf byteBuf, T t) throws IOException;
}
