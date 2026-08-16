package com.boehmod.bflib.cloud.packet.common.news;

import com.boehmod.bflib.cloud.common.news.NewsArticleSummary;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/news/PacketNewsListResponse.class */
public final class PacketNewsListResponse extends Record implements IPacket {

    @NotNull
    private final List<NewsArticleSummary> articles;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f85ID = new PacketIdentifier("PacketNewsListResponse");

    public PacketNewsListResponse(@NotNull List<NewsArticleSummary> articles) {
        this.articles = articles;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketNewsListResponse.class), PacketNewsListResponse.class, "articles", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsListResponse;->articles:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketNewsListResponse.class), PacketNewsListResponse.class, "articles", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsListResponse;->articles:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketNewsListResponse.class, Object.class), PacketNewsListResponse.class, "articles", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/news/PacketNewsListResponse;->articles:Ljava/util/List;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public List<NewsArticleSummary> articles() {
        return this.articles;
    }

    public PacketNewsListResponse(@NotNull ByteBuf byteBuffer) throws IOException {
        this((List<NewsArticleSummary>) IPacket.readList(byteBuffer, NewsArticleSummary::read));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeCollection(byteBuffer, this.articles, (buffer, article) -> {
            article.write(buffer);
        });
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f85ID;
    }
}
