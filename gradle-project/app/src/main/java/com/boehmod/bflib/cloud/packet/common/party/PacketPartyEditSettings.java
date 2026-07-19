package com.boehmod.bflib.cloud.packet.common.party;

import com.boehmod.bflib.cloud.common.mm.SearchGame;
import com.boehmod.bflib.cloud.common.mm.SearchRegion;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/party/PacketPartyEditSettings.class */
public final class PacketPartyEditSettings extends Record implements IPacket {

    @NotNull
    private final SearchGame game;

    @NotNull
    private final SearchRegion region;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketPartyEditSettings");

    public PacketPartyEditSettings(@NotNull SearchGame game, @NotNull SearchRegion region) {
        this.game = game;
        this.region = region;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketPartyEditSettings.class), PacketPartyEditSettings.class, "game;region", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/party/PacketPartyEditSettings;->game:Lcom/boehmod/bflib/cloud/common/mm/SearchGame;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/party/PacketPartyEditSettings;->region:Lcom/boehmod/bflib/cloud/common/mm/SearchRegion;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketPartyEditSettings.class), PacketPartyEditSettings.class, "game;region", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/party/PacketPartyEditSettings;->game:Lcom/boehmod/bflib/cloud/common/mm/SearchGame;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/party/PacketPartyEditSettings;->region:Lcom/boehmod/bflib/cloud/common/mm/SearchRegion;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketPartyEditSettings.class, Object.class), PacketPartyEditSettings.class, "game;region", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/party/PacketPartyEditSettings;->game:Lcom/boehmod/bflib/cloud/common/mm/SearchGame;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/party/PacketPartyEditSettings;->region:Lcom/boehmod/bflib/cloud/common/mm/SearchRegion;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public SearchGame game() {
        return this.game;
    }

    @NotNull
    public SearchRegion region() {
        return this.region;
    }

    public PacketPartyEditSettings(@NotNull ByteBuf byteBuffer) throws IOException {
        this((SearchGame) IPacket.readEnum(byteBuffer, SearchGame.class), (SearchRegion) IPacket.readEnum(byteBuffer, SearchRegion.class));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeEnum(byteBuffer, this.game);
        IPacket.writeEnum(byteBuffer, this.region);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
