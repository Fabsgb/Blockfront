package com.boehmod.bflib.cloud.packet;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/PacketObserver.class */
public interface PacketObserver {
    default void onPacketDecoded(@NotNull IPacket packet, int bytes) {
    }

    default void onPacketDecodeFailed(int packetHash, int bytes) {
    }

    default void onPacketEncoded(@NotNull IPacket packet, int bytes) {
    }

    default void onPacketEncodeFailed(@NotNull IPacket packet) {
    }
}
