package com.boehmod.bflib.cloud.packet.common.requests;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/requests/PacketRequestedFriends.class */
public final class PacketRequestedFriends extends Record implements IPacket {

    @NotNull
    private final ObjectSet<UUID> friends;

    @NotNull
    private final ObjectSet<UUID> requests;

    @NotNull
    private final ObjectSet<UUID> clanRequests;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketRequestedFriends");

    public PacketRequestedFriends(@NotNull ObjectSet<UUID> friends, @NotNull ObjectSet<UUID> requests, @NotNull ObjectSet<UUID> clanRequests) {
        this.friends = friends;
        this.requests = requests;
        this.clanRequests = clanRequests;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketRequestedFriends.class), PacketRequestedFriends.class, "friends;requests;clanRequests", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedFriends;->friends:Lit/unimi/dsi/fastutil/objects/ObjectSet;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedFriends;->requests:Lit/unimi/dsi/fastutil/objects/ObjectSet;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedFriends;->clanRequests:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketRequestedFriends.class), PacketRequestedFriends.class, "friends;requests;clanRequests", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedFriends;->friends:Lit/unimi/dsi/fastutil/objects/ObjectSet;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedFriends;->requests:Lit/unimi/dsi/fastutil/objects/ObjectSet;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedFriends;->clanRequests:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketRequestedFriends.class, Object.class), PacketRequestedFriends.class, "friends;requests;clanRequests", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedFriends;->friends:Lit/unimi/dsi/fastutil/objects/ObjectSet;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedFriends;->requests:Lit/unimi/dsi/fastutil/objects/ObjectSet;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedFriends;->clanRequests:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public ObjectSet<UUID> friends() {
        return this.friends;
    }

    @NotNull
    public ObjectSet<UUID> requests() {
        return this.requests;
    }

    @NotNull
    public ObjectSet<UUID> clanRequests() {
        return this.clanRequests;
    }

    public PacketRequestedFriends(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUIDSet(byteBuffer), IPacket.readUUIDSet(byteBuffer), IPacket.readUUIDSet(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUIDSet(byteBuffer, this.friends);
        IPacket.writeUUIDSet(byteBuffer, this.requests);
        IPacket.writeUUIDSet(byteBuffer, this.clanRequests);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
