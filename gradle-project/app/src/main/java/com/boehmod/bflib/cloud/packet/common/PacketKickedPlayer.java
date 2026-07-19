package com.boehmod.bflib.cloud.packet.common;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/PacketKickedPlayer.class */
public final class PacketKickedPlayer extends Record implements IPacket {

    @NotNull
    private final String username;
    private final int time;

    @NotNull
    private final TimeUnit timeUnit;

    @NotNull
    private final String reason;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketKickedPlayer");

    public PacketKickedPlayer(@NotNull String username, int time, @NotNull TimeUnit timeUnit, @NotNull String reason) {
        this.username = username;
        this.time = time;
        this.timeUnit = timeUnit;
        this.reason = reason;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketKickedPlayer.class), PacketKickedPlayer.class, "username;time;timeUnit;reason", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketKickedPlayer;->username:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketKickedPlayer;->time:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketKickedPlayer;->timeUnit:Ljava/util/concurrent/TimeUnit;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketKickedPlayer;->reason:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketKickedPlayer.class), PacketKickedPlayer.class, "username;time;timeUnit;reason", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketKickedPlayer;->username:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketKickedPlayer;->time:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketKickedPlayer;->timeUnit:Ljava/util/concurrent/TimeUnit;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketKickedPlayer;->reason:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketKickedPlayer.class, Object.class), PacketKickedPlayer.class, "username;time;timeUnit;reason", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketKickedPlayer;->username:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketKickedPlayer;->time:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketKickedPlayer;->timeUnit:Ljava/util/concurrent/TimeUnit;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketKickedPlayer;->reason:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public String username() {
        return this.username;
    }

    public int time() {
        return this.time;
    }

    @NotNull
    public TimeUnit timeUnit() {
        return this.timeUnit;
    }

    @NotNull
    public String reason() {
        return this.reason;
    }

    public PacketKickedPlayer(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readString(byteBuffer), byteBuffer.readInt(), (TimeUnit) IPacket.readEnum(byteBuffer, TimeUnit.class), IPacket.readString(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeString(byteBuffer, this.username);
        byteBuffer.writeInt(this.time);
        IPacket.writeEnum(byteBuffer, this.timeUnit);
        IPacket.writeString(byteBuffer, this.reason);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
