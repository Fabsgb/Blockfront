package com.boehmod.bflib.cloud.packet.common.news;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/news/PacketNewsArticleResponse.class */
public final class PacketNewsArticleResponse extends Record implements IPacket {

    /* JADX INFO: renamed from: id */
    private final long f78id;

    @NotNull
    private final String body;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f79ID = new PacketIdentifier("PacketNewsArticleResponse");

    public PacketNewsArticleResponse(long id, @NotNull String body) {
        this.f78id = id;
        this.body = body;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketNewsArticleResponse.class), PacketNewsArticleResponse.class, "id;body", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsArticleResponse;->id:J", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsArticleResponse;->body:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketNewsArticleResponse.class), PacketNewsArticleResponse.class, "id;body", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsArticleResponse;->id:J", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsArticleResponse;->body:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketNewsArticleResponse.class, Object.class), PacketNewsArticleResponse.class, "id;body", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsArticleResponse;->id:J", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsArticleResponse;->body:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: id */
    public long m2id() {
        return this.f78id;
    }

    @NotNull
    public String body() {
        return this.body;
    }

    public PacketNewsArticleResponse(@NotNull ByteBuf byteBuffer) {
        this(byteBuffer.readLong(), IPacket.readString(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) {
        byteBuffer.writeLong(this.f78id);
        IPacket.writeString(byteBuffer, this.body);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f79ID;
    }
}
