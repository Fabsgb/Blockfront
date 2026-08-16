package com.boehmod.bflib.cloud.common.news;

import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/news/NewsArticleSummary.class */
public final class NewsArticleSummary extends Record {

    /* JADX INFO: renamed from: id */
    private final long f10id;

    @NotNull
    private final String title;

    @NotNull
    private final String author;
    private final long timestamp;

    @NotNull
    private final String snippet;

    public NewsArticleSummary(long id, @NotNull String title, @NotNull String author, long timestamp, @NotNull String snippet) {
        this.f10id = id;
        this.title = title;
        this.author = author;
        this.timestamp = timestamp;
        this.snippet = snippet;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, NewsArticleSummary.class), NewsArticleSummary.class, "id;title;author;timestamp;snippet", "FIELD:Lcom/boehmod/bflib/cloud/common/news/NewsArticleSummary;->id:J", "FIELD:Lcom/boehmod/bflib/cloud/common/news/NewsArticleSummary;->title:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/news/NewsArticleSummary;->author:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/news/NewsArticleSummary;->timestamp:J", "FIELD:Lcom/boehmod/bflib/cloud/common/news/NewsArticleSummary;->snippet:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, NewsArticleSummary.class), NewsArticleSummary.class, "id;title;author;timestamp;snippet", "FIELD:Lcom/boehmod/bflib/cloud/common/news/NewsArticleSummary;->id:J", "FIELD:Lcom/boehmod/bflib/cloud/common/news/NewsArticleSummary;->title:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/news/NewsArticleSummary;->author:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/news/NewsArticleSummary;->timestamp:J", "FIELD:Lcom/boehmod/bflib/cloud/common/news/NewsArticleSummary;->snippet:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, NewsArticleSummary.class, Object.class), NewsArticleSummary.class, "id;title;author;timestamp;snippet", "FIELD:Lcom/boehmod/bflib/cloud/common/news/NewsArticleSummary;->id:J", "FIELD:Lcom/boehmod/bflib/cloud/common/news/NewsArticleSummary;->title:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/news/NewsArticleSummary;->author:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/news/NewsArticleSummary;->timestamp:J", "FIELD:Lcom/boehmod/bflib/cloud/common/news/NewsArticleSummary;->snippet:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: id */
    public long m0id() {
        return this.f10id;
    }

    @NotNull
    public String title() {
        return this.title;
    }

    @NotNull
    public String author() {
        return this.author;
    }

    public long timestamp() {
        return this.timestamp;
    }

    @NotNull
    public String snippet() {
        return this.snippet;
    }

    public void write(@NotNull ByteBuf byteBuffer) {
        byteBuffer.writeLong(this.f10id);
        IPacket.writeString(byteBuffer, this.title);
        IPacket.writeString(byteBuffer, this.author);
        byteBuffer.writeLong(this.timestamp);
        IPacket.writeString(byteBuffer, this.snippet);
    }

    @NotNull
    public static NewsArticleSummary read(@NotNull ByteBuf byteBuffer) {
        long id = byteBuffer.readLong();
        String title = IPacket.readString(byteBuffer);
        String author = IPacket.readString(byteBuffer);
        long timestamp = byteBuffer.readLong();
        String snippet = IPacket.readString(byteBuffer);
        return new NewsArticleSummary(id, title, author, timestamp, snippet);
    }
}
