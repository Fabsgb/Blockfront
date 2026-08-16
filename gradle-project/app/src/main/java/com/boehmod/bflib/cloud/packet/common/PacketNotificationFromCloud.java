package com.boehmod.bflib.cloud.packet.common;

import com.boehmod.bflib.cloud.common.NotificationType;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/PacketNotificationFromCloud.class */
public final class PacketNotificationFromCloud extends Record implements IPacket {

    @NotNull
    private final String message;

    @NotNull
    private final NotificationType type;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f32ID = new PacketIdentifier("PacketNotificationFromCloud");

    public PacketNotificationFromCloud(@NotNull String message, @NotNull NotificationType type) {
        this.message = message;
        this.type = type;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketNotificationFromCloud.class), PacketNotificationFromCloud.class, "message;type", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketNotificationFromCloud;->message:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketNotificationFromCloud;->type:Lcom/boehmod/bflib/cloud/common/NotificationType;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketNotificationFromCloud.class), PacketNotificationFromCloud.class, "message;type", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketNotificationFromCloud;->message:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketNotificationFromCloud;->type:Lcom/boehmod/bflib/cloud/common/NotificationType;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketNotificationFromCloud.class, Object.class), PacketNotificationFromCloud.class, "message;type", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketNotificationFromCloud;->message:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketNotificationFromCloud;->type:Lcom/boehmod/bflib/cloud/common/NotificationType;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public String message() {
        return this.message;
    }

    @NotNull
    public NotificationType type() {
        return this.type;
    }

    public PacketNotificationFromCloud(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readString(byteBuffer), (NotificationType) IPacket.readEnum(byteBuffer, NotificationType.class));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeString(byteBuffer, this.message);
        IPacket.writeEnum(byteBuffer, this.type);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f32ID;
    }
}
