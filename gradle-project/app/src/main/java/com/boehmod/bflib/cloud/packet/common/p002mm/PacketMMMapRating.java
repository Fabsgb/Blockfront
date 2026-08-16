package com.boehmod.bflib.cloud.packet.common.p002mm;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating.class */
public final class PacketMMMapRating extends Record implements IPacket {

    @NotNull
    private final String mapName;

    @NotNull
    private final String gameMode;

    @NotNull
    private final String teamName;
    private final float rating;

    @NotNull
    private final UUID playerUuid;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f67ID = new PacketIdentifier("PacketMMMapRating");

    public PacketMMMapRating(@NotNull String mapName, @NotNull String gameMode, @NotNull String teamName, float rating, @NotNull UUID playerUuid) {
        this.mapName = mapName;
        this.gameMode = gameMode;
        this.teamName = teamName;
        this.rating = rating;
        this.playerUuid = playerUuid;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketMMMapRating.class), PacketMMMapRating.class, "mapName;gameMode;teamName;rating;playerUuid", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating;->mapName:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating;->gameMode:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating;->teamName:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating;->rating:F", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating;->playerUuid:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketMMMapRating.class), PacketMMMapRating.class, "mapName;gameMode;teamName;rating;playerUuid", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating;->mapName:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating;->gameMode:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating;->teamName:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating;->rating:F", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating;->playerUuid:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketMMMapRating.class, Object.class), PacketMMMapRating.class, "mapName;gameMode;teamName;rating;playerUuid", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating;->mapName:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating;->gameMode:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating;->teamName:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating;->rating:F", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMapRating;->playerUuid:Ljava/util/UUID;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public String mapName() {
        return this.mapName;
    }

    @NotNull
    public String gameMode() {
        return this.gameMode;
    }

    @NotNull
    public String teamName() {
        return this.teamName;
    }

    public float rating() {
        return this.rating;
    }

    @NotNull
    public UUID playerUuid() {
        return this.playerUuid;
    }

    public PacketMMMapRating(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readString(byteBuffer), IPacket.readString(byteBuffer), IPacket.readString(byteBuffer), byteBuffer.readFloat(), IPacket.readUUID(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeString(byteBuffer, this.mapName);
        IPacket.writeString(byteBuffer, this.gameMode);
        IPacket.writeString(byteBuffer, this.teamName);
        byteBuffer.writeFloat(this.rating);
        IPacket.writeUUID(byteBuffer, this.playerUuid);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f67ID;
    }
}
