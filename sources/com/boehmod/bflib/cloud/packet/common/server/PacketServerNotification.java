package com.boehmod.bflib.cloud.packet.common.server;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Optional;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/server/PacketServerNotification.class */
public final class PacketServerNotification extends Record implements IPacket {

    @NotNull
    private final String message;

    @NotNull
    private final Optional<UUID> match;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f99ID = new PacketIdentifier("PacketServerNotification");

    public PacketServerNotification(@NotNull String message, @NotNull Optional<UUID> match) {
        this.message = message;
        this.match = match;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketServerNotification.class), PacketServerNotification.class, "message;match", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketServerNotification;->message:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketServerNotification;->match:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketServerNotification.class), PacketServerNotification.class, "message;match", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketServerNotification;->message:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketServerNotification;->match:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketServerNotification.class, Object.class), PacketServerNotification.class, "message;match", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketServerNotification;->message:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketServerNotification;->match:Ljava/util/Optional;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public String message() {
        return this.message;
    }

    @NotNull
    public Optional<UUID> match() {
        return this.match;
    }

    public PacketServerNotification(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readString(byteBuffer), IPacket.readUUIDOptional(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeString(byteBuffer, this.message);
        IPacket.writeOptionalUUID(byteBuffer, this.match.orElse(null));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f99ID;
    }
}
