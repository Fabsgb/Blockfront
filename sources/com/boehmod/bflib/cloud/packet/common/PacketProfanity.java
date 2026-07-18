package com.boehmod.bflib.cloud.packet.common;

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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/PacketProfanity.class */
public final class PacketProfanity extends Record implements IPacket {

    @NotNull
    private final UUID player;

    @NotNull
    private final String message;

    @NotNull
    private final ObjectList<String> previousMessages;
    private final int severity;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f32ID = new PacketIdentifier("PacketProfanity");

    public PacketProfanity(@NotNull UUID player, @NotNull String message, @NotNull ObjectList<String> previousMessages, int severity) {
        this.player = player;
        this.message = message;
        this.previousMessages = previousMessages;
        this.severity = severity;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketProfanity.class), PacketProfanity.class, "player;message;previousMessages;severity", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketProfanity;->player:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketProfanity;->message:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketProfanity;->previousMessages:Lit/unimi/dsi/fastutil/objects/ObjectList;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketProfanity;->severity:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketProfanity.class), PacketProfanity.class, "player;message;previousMessages;severity", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketProfanity;->player:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketProfanity;->message:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketProfanity;->previousMessages:Lit/unimi/dsi/fastutil/objects/ObjectList;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketProfanity;->severity:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketProfanity.class, Object.class), PacketProfanity.class, "player;message;previousMessages;severity", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketProfanity;->player:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketProfanity;->message:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketProfanity;->previousMessages:Lit/unimi/dsi/fastutil/objects/ObjectList;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketProfanity;->severity:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID player() {
        return this.player;
    }

    @NotNull
    public String message() {
        return this.message;
    }

    @NotNull
    public ObjectList<String> previousMessages() {
        return this.previousMessages;
    }

    public int severity() {
        return this.severity;
    }

    public PacketProfanity(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readString(byteBuffer), IPacket.readStringList(byteBuffer), byteBuffer.readByte());
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.player);
        IPacket.writeString(byteBuffer, this.message);
        IPacket.writeStringList(byteBuffer, this.previousMessages);
        byteBuffer.writeByte((byte) this.severity);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f32ID;
    }
}
