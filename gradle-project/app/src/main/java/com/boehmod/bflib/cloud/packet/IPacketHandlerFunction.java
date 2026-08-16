package com.boehmod.bflib.cloud.packet;

import com.boehmod.bflib.cloud.connection.Connection;
import com.boehmod.bflib.cloud.packet.IPacket;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/IPacketHandlerFunction.class */
public interface IPacketHandlerFunction<T extends IPacket, H extends Connection> {
    void handle(@NotNull T t, @NotNull H h) throws IOException;
}
