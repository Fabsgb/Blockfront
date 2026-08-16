package com.boehmod.bflib.cloud.packet.common.friend;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/friend/PacketFriendRequestAccept.class */
public final class PacketFriendRequestAccept extends Record implements IPacket {

    @NotNull
    private final UUID uuid;
    private final boolean action;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f53ID = new PacketIdentifier("PacketFriendRequestAccept");

    public PacketFriendRequestAccept(@NotNull UUID uuid, boolean action) {
        this.uuid = uuid;
        this.action = action;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketFriendRequestAccept.class), PacketFriendRequestAccept.class, "uuid;action", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/friend/PacketFriendRequestAccept;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/friend/PacketFriendRequestAccept;->action:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketFriendRequestAccept.class), PacketFriendRequestAccept.class, "uuid;action", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/friend/PacketFriendRequestAccept;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/friend/PacketFriendRequestAccept;->action:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketFriendRequestAccept.class, Object.class), PacketFriendRequestAccept.class, "uuid;action", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/friend/PacketFriendRequestAccept;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/friend/PacketFriendRequestAccept;->action:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID uuid() {
        return this.uuid;
    }

    public boolean action() {
        return this.action;
    }

    public PacketFriendRequestAccept(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readBoolean(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.uuid);
        IPacket.writeBoolean(byteBuffer, this.action);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f53ID;
    }
}
