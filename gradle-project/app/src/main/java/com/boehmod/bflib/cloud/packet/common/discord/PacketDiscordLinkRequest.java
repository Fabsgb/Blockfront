package com.boehmod.bflib.cloud.packet.common.discord;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/discord/PacketDiscordLinkRequest.class */
public final class PacketDiscordLinkRequest extends Record implements IPacket {

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketDiscordLinkRequest");

    public PacketDiscordLinkRequest() {
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketDiscordLinkRequest.class), PacketDiscordLinkRequest.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketDiscordLinkRequest.class), PacketDiscordLinkRequest.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketDiscordLinkRequest.class, Object.class), PacketDiscordLinkRequest.class, "").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public PacketDiscordLinkRequest(@NotNull ByteBuf byteBuffer) {
        this();
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) {
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
