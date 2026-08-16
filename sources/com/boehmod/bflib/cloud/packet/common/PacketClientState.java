package com.boehmod.bflib.cloud.packet.common;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/PacketClientState.class */
public final class PacketClientState extends Record implements IPacket {
    private final int key;

    @NotNull
    private final String value;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f27ID = new PacketIdentifier("PacketClientState");

    public PacketClientState(int key, @NotNull String value) {
        this.key = key;
        this.value = value;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketClientState.class), PacketClientState.class, "key;value", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientState;->key:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientState;->value:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketClientState.class), PacketClientState.class, "key;value", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientState;->key:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientState;->value:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketClientState.class, Object.class), PacketClientState.class, "key;value", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientState;->key:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientState;->value:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public int key() {
        return this.key;
    }

    @NotNull
    public String value() {
        return this.value;
    }

    public PacketClientState(@NotNull ByteBuf byteBuffer) {
        this(byteBuffer.readInt(), IPacket.readString(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) {
        byteBuffer.writeInt(this.key);
        IPacket.writeString(byteBuffer, this.value);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f27ID;
    }
}
