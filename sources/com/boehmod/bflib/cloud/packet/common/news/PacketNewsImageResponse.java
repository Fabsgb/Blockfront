package com.boehmod.bflib.cloud.packet.common.news;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/news/PacketNewsImageResponse.class */
public final class PacketNewsImageResponse extends Record implements IPacket {

    /* JADX INFO: renamed from: id */
    private final long f82id;
    private final byte[] imageData;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f83ID = new PacketIdentifier("PacketNewsImageResponse");

    public PacketNewsImageResponse(long id, byte[] imageData) {
        this.f82id = id;
        this.imageData = imageData;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketNewsImageResponse.class), PacketNewsImageResponse.class, "id;imageData", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsImageResponse;->id:J", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsImageResponse;->imageData:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketNewsImageResponse.class), PacketNewsImageResponse.class, "id;imageData", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsImageResponse;->id:J", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsImageResponse;->imageData:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketNewsImageResponse.class, Object.class), PacketNewsImageResponse.class, "id;imageData", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsImageResponse;->id:J", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsImageResponse;->imageData:[B").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: id */
    public long m4id() {
        return this.f82id;
    }

    public byte[] imageData() {
        return this.imageData;
    }

    public PacketNewsImageResponse(@NotNull ByteBuf byteBuffer) {
        this(byteBuffer.readLong(), IPacket.readByteArray(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) {
        byteBuffer.writeLong(this.f82id);
        IPacket.writeByteArray(byteBuffer, this.imageData);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f83ID;
    }
}
