package com.boehmod.bflib.cloud.packet.common.requests;

import com.boehmod.bflib.cloud.common.player.PlayerDataContext;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerData.class */
public final class PacketRequestedPlayerData extends Record implements IPacket {

    @NotNull
    private final UUID uuid;

    @NotNull
    private final PlayerDataContext context;
    private final byte[] data;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f106ID = new PacketIdentifier("PacketRequestedPlayerData");

    public PacketRequestedPlayerData(@NotNull UUID uuid, @NotNull PlayerDataContext context, byte[] data) {
        this.uuid = uuid;
        this.context = context;
        this.data = data;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketRequestedPlayerData.class), PacketRequestedPlayerData.class, "uuid;context;data", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerData;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerData;->context:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerData;->data:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketRequestedPlayerData.class), PacketRequestedPlayerData.class, "uuid;context;data", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerData;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerData;->context:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerData;->data:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketRequestedPlayerData.class, Object.class), PacketRequestedPlayerData.class, "uuid;context;data", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerData;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerData;->context:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerData;->data:[B").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID uuid() {
        return this.uuid;
    }

    @NotNull
    public PlayerDataContext context() {
        return this.context;
    }

    public byte[] data() {
        return this.data;
    }

    public PacketRequestedPlayerData(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readPlayerDataContext(byteBuffer), IPacket.readByteArray(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.uuid);
        IPacket.writePlayerDataContext(byteBuffer, this.context);
        IPacket.writeByteArray(byteBuffer, this.data);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f106ID;
    }
}
