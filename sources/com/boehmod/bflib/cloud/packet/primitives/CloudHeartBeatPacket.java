package com.boehmod.bflib.cloud.packet.primitives;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/primitives/CloudHeartBeatPacket.class */
public class CloudHeartBeatPacket implements IPacket {

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f120ID = new PacketIdentifier("CloudHeartBeatPacket");

    public CloudHeartBeatPacket() {
    }

    public CloudHeartBeatPacket(@NotNull ByteBuf byteBuffer) {
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) {
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f120ID;
    }
}
