package com.boehmod.bflib.cloud.packet.common.news;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/news/PacketNewsImageRequest.class */
public final class PacketNewsImageRequest extends Record implements IPacket {

    /* JADX INFO: renamed from: id */
    private final long f80id;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f81ID = new PacketIdentifier("PacketNewsImageRequest");

    public PacketNewsImageRequest(long id) {
        this.f80id = id;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketNewsImageRequest.class), PacketNewsImageRequest.class, "id", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsImageRequest;->id:J").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketNewsImageRequest.class), PacketNewsImageRequest.class, "id", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsImageRequest;->id:J").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketNewsImageRequest.class, Object.class), PacketNewsImageRequest.class, "id", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsImageRequest;->id:J").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: id */
    public long m3id() {
        return this.f80id;
    }

    public PacketNewsImageRequest(@NotNull ByteBuf byteBuffer) {
        this(byteBuffer.readLong());
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) {
        byteBuffer.writeLong(this.f80id);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f81ID;
    }
}
