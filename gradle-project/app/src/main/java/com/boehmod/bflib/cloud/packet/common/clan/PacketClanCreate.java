package com.boehmod.bflib.cloud.packet.common.clan;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/clan/PacketClanCreate.class */
public final class PacketClanCreate extends Record implements IPacket {

    @NotNull
    private final String clanName;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketClanCreate");

    public PacketClanCreate(@NotNull String clanName) {
        this.clanName = clanName;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketClanCreate.class), PacketClanCreate.class, "clanName", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/clan/PacketClanCreate;->clanName:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketClanCreate.class), PacketClanCreate.class, "clanName", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/clan/PacketClanCreate;->clanName:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketClanCreate.class, Object.class), PacketClanCreate.class, "clanName", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/clan/PacketClanCreate;->clanName:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public String clanName() {
        return this.clanName;
    }

    public PacketClanCreate(@NotNull ByteBuf byteBuffer) {
        this(IPacket.readString(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeString(byteBuffer, this.clanName);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
