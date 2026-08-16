package com.boehmod.bflib.cloud.packet.common.p002mm;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport.class */
public final class PacketMMChatReport extends Record implements IPacket {

    @NotNull
    private final UUID reporterUUID;

    @NotNull
    private final UUID messageUUID;

    @NotNull
    private final UUID senderUUID;

    @NotNull
    private final String senderUsername;

    @NotNull
    private final String message;

    @NotNull
    private final ObjectList<String> contextMessages;

    @NotNull
    private final String matchContext;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f65ID = new PacketIdentifier("PacketMMChatReport");

    public PacketMMChatReport(@NotNull UUID reporterUUID, @NotNull UUID messageUUID, @NotNull UUID senderUUID, @NotNull String senderUsername, @NotNull String message, @NotNull ObjectList<String> contextMessages, @NotNull String matchContext) {
        this.reporterUUID = reporterUUID;
        this.messageUUID = messageUUID;
        this.senderUUID = senderUUID;
        this.senderUsername = senderUsername;
        this.message = message;
        this.contextMessages = contextMessages;
        this.matchContext = matchContext;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketMMChatReport.class), PacketMMChatReport.class, "reporterUUID;messageUUID;senderUUID;senderUsername;message;contextMessages;matchContext", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->reporterUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->messageUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->senderUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->senderUsername:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->message:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->contextMessages:Lit/unimi/dsi/fastutil/objects/ObjectList;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->matchContext:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketMMChatReport.class), PacketMMChatReport.class, "reporterUUID;messageUUID;senderUUID;senderUsername;message;contextMessages;matchContext", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->reporterUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->messageUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->senderUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->senderUsername:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->message:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->contextMessages:Lit/unimi/dsi/fastutil/objects/ObjectList;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->matchContext:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketMMChatReport.class, Object.class), PacketMMChatReport.class, "reporterUUID;messageUUID;senderUUID;senderUsername;message;contextMessages;matchContext", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->reporterUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->messageUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->senderUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->senderUsername:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->message:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->contextMessages:Lit/unimi/dsi/fastutil/objects/ObjectList;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMChatReport;->matchContext:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID reporterUUID() {
        return this.reporterUUID;
    }

    @NotNull
    public UUID messageUUID() {
        return this.messageUUID;
    }

    @NotNull
    public UUID senderUUID() {
        return this.senderUUID;
    }

    @NotNull
    public String senderUsername() {
        return this.senderUsername;
    }

    @NotNull
    public String message() {
        return this.message;
    }

    @NotNull
    public ObjectList<String> contextMessages() {
        return this.contextMessages;
    }

    @NotNull
    public String matchContext() {
        return this.matchContext;
    }

    public PacketMMChatReport(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readUUID(byteBuffer), IPacket.readUUID(byteBuffer), IPacket.readString(byteBuffer), IPacket.readString(byteBuffer), IPacket.readStringList(byteBuffer), IPacket.readString(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.reporterUUID);
        IPacket.writeUUID(byteBuffer, this.messageUUID);
        IPacket.writeUUID(byteBuffer, this.senderUUID);
        IPacket.writeString(byteBuffer, this.senderUsername);
        IPacket.writeString(byteBuffer, this.message);
        IPacket.writeStringList(byteBuffer, this.contextMessages);
        IPacket.writeString(byteBuffer, this.matchContext);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f65ID;
    }
}
