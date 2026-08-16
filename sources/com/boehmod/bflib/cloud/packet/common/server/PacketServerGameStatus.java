package com.boehmod.bflib.cloud.packet.common.server;

import com.boehmod.bflib.cloud.common.MatchData;
import com.boehmod.bflib.cloud.common.p001mm.SearchRegion;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/server/PacketServerGameStatus.class */
public final class PacketServerGameStatus extends Record implements IPacket {

    @NotNull
    private final ObjectList<MatchData> matches;

    @NotNull
    private final SearchRegion region;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f113ID = new PacketIdentifier("PacketServerGameStatus");

    public PacketServerGameStatus(@NotNull ObjectList<MatchData> matches, @NotNull SearchRegion region) {
        this.matches = matches;
        this.region = region;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketServerGameStatus.class), PacketServerGameStatus.class, "matches;region", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketServerGameStatus;->matches:Lit/unimi/dsi/fastutil/objects/ObjectList;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketServerGameStatus;->region:Lcom/boehmod/bflib/cloud/common/mm/SearchRegion;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketServerGameStatus.class), PacketServerGameStatus.class, "matches;region", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketServerGameStatus;->matches:Lit/unimi/dsi/fastutil/objects/ObjectList;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketServerGameStatus;->region:Lcom/boehmod/bflib/cloud/common/mm/SearchRegion;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketServerGameStatus.class, Object.class), PacketServerGameStatus.class, "matches;region", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketServerGameStatus;->matches:Lit/unimi/dsi/fastutil/objects/ObjectList;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketServerGameStatus;->region:Lcom/boehmod/bflib/cloud/common/mm/SearchRegion;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public ObjectList<MatchData> matches() {
        return this.matches;
    }

    @NotNull
    public SearchRegion region() {
        return this.region;
    }

    public PacketServerGameStatus(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readMatchDataList(byteBuffer), (SearchRegion) IPacket.readEnum(byteBuffer, SearchRegion.class));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeMatchDataList(byteBuffer, this.matches);
        IPacket.writeEnum(byteBuffer, this.region);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f113ID;
    }
}
