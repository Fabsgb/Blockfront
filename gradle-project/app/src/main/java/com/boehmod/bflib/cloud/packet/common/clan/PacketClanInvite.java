package com.boehmod.bflib.cloud.packet.common.clan;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/clan/PacketClanInvite.class */
public final class PacketClanInvite extends Record implements IPacket {

    @NotNull
    private final String player;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f42ID = new PacketIdentifier("PacketClanInvite");

    public PacketClanInvite(@NotNull String player) {
        this.player = player;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketClanInvite.class), PacketClanInvite.class, "player", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/clan/PacketClanInvite;->player:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketClanInvite.class), PacketClanInvite.class, "player", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/clan/PacketClanInvite;->player:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketClanInvite.class, Object.class), PacketClanInvite.class, "player", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/clan/PacketClanInvite;->player:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public String player() {
        return this.player;
    }

    public PacketClanInvite(@NotNull ByteBuf byteBuffer) {
        this(IPacket.readString(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeString(byteBuffer, this.player);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f42ID;
    }
}
