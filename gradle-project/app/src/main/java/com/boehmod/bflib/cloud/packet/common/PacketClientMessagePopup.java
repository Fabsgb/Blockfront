package com.boehmod.bflib.cloud.packet.common;

import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/PacketClientMessagePopup.class */
public final class PacketClientMessagePopup extends Record implements IPacket {

    @NotNull
    private final String title;

    @NotNull
    private final String message;

    @NotNull
    private final PopupType type;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketClientMessagePopup");

    public PacketClientMessagePopup(@NotNull String title, @NotNull String message, @NotNull PopupType type) {
        this.title = title;
        this.message = message;
        this.type = type;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketClientMessagePopup.class), PacketClientMessagePopup.class, "title;message;type", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientMessagePopup;->title:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientMessagePopup;->message:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientMessagePopup;->type:Lcom/boehmod/bflib/cloud/common/PopupType;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketClientMessagePopup.class), PacketClientMessagePopup.class, "title;message;type", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientMessagePopup;->title:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientMessagePopup;->message:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientMessagePopup;->type:Lcom/boehmod/bflib/cloud/common/PopupType;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketClientMessagePopup.class, Object.class), PacketClientMessagePopup.class, "title;message;type", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientMessagePopup;->title:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientMessagePopup;->message:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientMessagePopup;->type:Lcom/boehmod/bflib/cloud/common/PopupType;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public String title() {
        return this.title;
    }

    @NotNull
    public String message() {
        return this.message;
    }

    @NotNull
    public PopupType type() {
        return this.type;
    }

    public PacketClientMessagePopup(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readString(byteBuffer), IPacket.readString(byteBuffer), (PopupType) IPacket.readEnum(byteBuffer, PopupType.class));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeString(byteBuffer, this.title);
        IPacket.writeString(byteBuffer, this.message);
        IPacket.writeEnum(byteBuffer, this.type);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
