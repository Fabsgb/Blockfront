package com.boehmod.bflib.cloud.packet.common.server;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataSetValue.class */
public final class PacketPlayerDataSetValue extends Record implements IPacket {

    @NotNull
    private final UUID uuid;

    @NotNull
    private final String value;
    private final int amount;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f97ID = new PacketIdentifier("PacketPlayerDataSetValue");

    public PacketPlayerDataSetValue(@NotNull UUID uuid, @NotNull String value, int amount) {
        this.uuid = uuid;
        this.value = value;
        this.amount = amount;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketPlayerDataSetValue.class), PacketPlayerDataSetValue.class, "uuid;value;amount", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataSetValue;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataSetValue;->value:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataSetValue;->amount:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketPlayerDataSetValue.class), PacketPlayerDataSetValue.class, "uuid;value;amount", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataSetValue;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataSetValue;->value:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataSetValue;->amount:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketPlayerDataSetValue.class, Object.class), PacketPlayerDataSetValue.class, "uuid;value;amount", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataSetValue;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataSetValue;->value:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataSetValue;->amount:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID uuid() {
        return this.uuid;
    }

    @NotNull
    public String value() {
        return this.value;
    }

    public int amount() {
        return this.amount;
    }

    public PacketPlayerDataSetValue(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readString(byteBuffer), byteBuffer.readInt());
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.uuid);
        IPacket.writeString(byteBuffer, this.value);
        byteBuffer.writeInt(this.amount);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f97ID;
    }
}
