package com.boehmod.bflib.cloud.packet.common;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/PacketScreenshotResponse.class */
public final class PacketScreenshotResponse extends Record implements IPacket {

    @NotNull
    private final UUID requestId;
    private final byte[] imageData;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f36ID = new PacketIdentifier("PacketScreenshotResponse");

    public PacketScreenshotResponse(@NotNull UUID requestId, byte[] imageData) {
        this.requestId = requestId;
        this.imageData = imageData;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketScreenshotResponse.class), PacketScreenshotResponse.class, "requestId;imageData", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketScreenshotResponse;->requestId:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketScreenshotResponse;->imageData:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketScreenshotResponse.class), PacketScreenshotResponse.class, "requestId;imageData", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketScreenshotResponse;->requestId:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketScreenshotResponse;->imageData:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketScreenshotResponse.class, Object.class), PacketScreenshotResponse.class, "requestId;imageData", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketScreenshotResponse;->requestId:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketScreenshotResponse;->imageData:[B").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID requestId() {
        return this.requestId;
    }

    public byte[] imageData() {
        return this.imageData;
    }

    public PacketScreenshotResponse(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readByteArray(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.requestId);
        IPacket.writeByteArray(byteBuffer, this.imageData);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f36ID;
    }
}
