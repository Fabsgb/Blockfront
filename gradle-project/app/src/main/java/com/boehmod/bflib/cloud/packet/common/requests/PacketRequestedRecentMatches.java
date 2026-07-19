package com.boehmod.bflib.cloud.packet.common.requests;

import com.boehmod.bflib.cloud.common.mm.report.MatchSummary;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/requests/PacketRequestedRecentMatches.class */
public final class PacketRequestedRecentMatches extends Record implements IPacket {

    @NotNull
    private final UUID player;

    @NotNull
    private final ObjectList<MatchSummary> matches;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketRequestedRecentMatches");

    public PacketRequestedRecentMatches(@NotNull UUID player, @NotNull ObjectList<MatchSummary> matches) {
        this.player = player;
        this.matches = matches;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketRequestedRecentMatches.class), PacketRequestedRecentMatches.class, "player;matches", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedRecentMatches;->player:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedRecentMatches;->matches:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketRequestedRecentMatches.class), PacketRequestedRecentMatches.class, "player;matches", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedRecentMatches;->player:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedRecentMatches;->matches:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketRequestedRecentMatches.class, Object.class), PacketRequestedRecentMatches.class, "player;matches", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedRecentMatches;->player:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedRecentMatches;->matches:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID player() {
        return this.player;
    }

    @NotNull
    public ObjectList<MatchSummary> matches() {
        return this.matches;
    }

    public PacketRequestedRecentMatches(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), MatchSummary.readList(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.player);
        MatchSummary.writeList(byteBuffer, this.matches);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
