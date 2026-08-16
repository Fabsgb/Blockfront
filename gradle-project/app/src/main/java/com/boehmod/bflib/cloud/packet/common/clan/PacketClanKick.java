package com.boehmod.bflib.cloud.packet.common.clan;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/clan/PacketClanKick.class */
public final class PacketClanKick extends Record implements IPacket {

    @NotNull
    private final String username;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f43ID = new PacketIdentifier("PacketClanKick");

    public PacketClanKick(@NotNull String username) {
        this.username = username;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketClanKick.class), PacketClanKick.class, "username", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/clan/PacketClanKick;->username:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketClanKick.class), PacketClanKick.class, "username", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/clan/PacketClanKick;->username:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketClanKick.class, Object.class), PacketClanKick.class, "username", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/clan/PacketClanKick;->username:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public String username() {
        return this.username;
    }

    public PacketClanKick(@NotNull ByteBuf byteBuffer) {
        this(IPacket.readString(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeString(byteBuffer, this.username);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f43ID;
    }
}
