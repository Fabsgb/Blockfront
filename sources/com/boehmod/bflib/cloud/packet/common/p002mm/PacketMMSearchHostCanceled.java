package com.boehmod.bflib.cloud.packet.common.p002mm;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/mm/PacketMMSearchHostCanceled.class */
public final class PacketMMSearchHostCanceled extends Record implements IPacket {

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f75ID = new PacketIdentifier("PacketMMSearchHostCanceled");

    public PacketMMSearchHostCanceled() {
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketMMSearchHostCanceled.class), PacketMMSearchHostCanceled.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketMMSearchHostCanceled.class), PacketMMSearchHostCanceled.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketMMSearchHostCanceled.class, Object.class), PacketMMSearchHostCanceled.class, "").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public PacketMMSearchHostCanceled(@NotNull ByteBuf byteBuffer) {
        this();
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) {
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f75ID;
    }
}
