package com.boehmod.bflib.cloud.packet.common.requests;

import com.boehmod.bflib.cloud.common.player.PlayerDataContext;
import com.boehmod.bflib.cloud.common.player.status.PublicPlayerStatus;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerStatusSet.class */
public final class PacketRequestedPlayerStatusSet extends Record implements IPacket {

    @NotNull
    private final PlayerDataContext context;

    @NotNull
    private final Map<UUID, PublicPlayerStatus> statusSet;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketRequestedPlayerStatusSet");

    public PacketRequestedPlayerStatusSet(@NotNull PlayerDataContext context, @NotNull Map<UUID, PublicPlayerStatus> statusSet) {
        this.context = context;
        this.statusSet = statusSet;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketRequestedPlayerStatusSet.class), PacketRequestedPlayerStatusSet.class, "context;statusSet", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerStatusSet;->context:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerStatusSet;->statusSet:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketRequestedPlayerStatusSet.class), PacketRequestedPlayerStatusSet.class, "context;statusSet", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerStatusSet;->context:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerStatusSet;->statusSet:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketRequestedPlayerStatusSet.class, Object.class), PacketRequestedPlayerStatusSet.class, "context;statusSet", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerStatusSet;->context:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedPlayerStatusSet;->statusSet:Ljava/util/Map;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public PlayerDataContext context() {
        return this.context;
    }

    @NotNull
    public Map<UUID, PublicPlayerStatus> statusSet() {
        return this.statusSet;
    }

    public PacketRequestedPlayerStatusSet(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readPlayerDataContext(byteBuffer), IPacket.readStatusMap(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writePlayerDataContext(byteBuffer, this.context);
        IPacket.writeStatusMap(byteBuffer, this.statusSet);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
