package com.boehmod.bflib.cloud.packet.common;

import com.boehmod.bflib.cloud.common.ReportType;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/PacketPunishPlayer.class */
public final class PacketPunishPlayer extends Record implements IPacket {

    @NotNull
    private final UUID uuid;

    @NotNull
    private final ReportType type;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f34ID = new PacketIdentifier("PacketPunishPlayer");

    public PacketPunishPlayer(@NotNull UUID uuid, @NotNull ReportType type) {
        this.uuid = uuid;
        this.type = type;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketPunishPlayer.class), PacketPunishPlayer.class, "uuid;type", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketPunishPlayer;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketPunishPlayer;->type:Lcom/boehmod/bflib/cloud/common/ReportType;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketPunishPlayer.class), PacketPunishPlayer.class, "uuid;type", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketPunishPlayer;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketPunishPlayer;->type:Lcom/boehmod/bflib/cloud/common/ReportType;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketPunishPlayer.class, Object.class), PacketPunishPlayer.class, "uuid;type", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketPunishPlayer;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketPunishPlayer;->type:Lcom/boehmod/bflib/cloud/common/ReportType;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID uuid() {
        return this.uuid;
    }

    @NotNull
    public ReportType type() {
        return this.type;
    }

    public PacketPunishPlayer(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), (ReportType) IPacket.readEnum(byteBuffer, ReportType.class));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.uuid);
        IPacket.writeEnum(byteBuffer, this.type);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f34ID;
    }
}
