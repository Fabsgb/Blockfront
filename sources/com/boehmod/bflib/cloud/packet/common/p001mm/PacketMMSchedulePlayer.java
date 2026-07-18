package com.boehmod.bflib.cloud.packet.common.p001mm;

import com.boehmod.bflib.cloud.common.p000mm.MatchJoinIntent;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer.class */
public final class PacketMMSchedulePlayer extends Record implements IPacket {

    @NotNull
    private final UUID playerUUID;

    @NotNull
    private final UUID match;

    @NotNull
    private final MatchJoinIntent intent;

    @NotNull
    private final PlayerDataContext context;
    private final byte[] data;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f68ID = new PacketIdentifier("PacketMMSchedulePlayer");

    public PacketMMSchedulePlayer(@NotNull UUID playerUUID, @NotNull UUID match, @NotNull MatchJoinIntent intent, @NotNull PlayerDataContext context, byte[] data) {
        this.playerUUID = playerUUID;
        this.match = match;
        this.intent = intent;
        this.context = context;
        this.data = data;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketMMSchedulePlayer.class), PacketMMSchedulePlayer.class, "playerUUID;match;intent;context;data", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer;->playerUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer;->match:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer;->intent:Lcom/boehmod/bflib/cloud/common/mm/MatchJoinIntent;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer;->context:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer;->data:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketMMSchedulePlayer.class), PacketMMSchedulePlayer.class, "playerUUID;match;intent;context;data", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer;->playerUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer;->match:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer;->intent:Lcom/boehmod/bflib/cloud/common/mm/MatchJoinIntent;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer;->context:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer;->data:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketMMSchedulePlayer.class, Object.class), PacketMMSchedulePlayer.class, "playerUUID;match;intent;context;data", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer;->playerUUID:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer;->match:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer;->intent:Lcom/boehmod/bflib/cloud/common/mm/MatchJoinIntent;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer;->context:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMSchedulePlayer;->data:[B").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID playerUUID() {
        return this.playerUUID;
    }

    @NotNull
    public UUID match() {
        return this.match;
    }

    @NotNull
    public MatchJoinIntent intent() {
        return this.intent;
    }

    @NotNull
    public PlayerDataContext context() {
        return this.context;
    }

    public byte[] data() {
        return this.data;
    }

    public PacketMMSchedulePlayer(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readUUID(byteBuffer), (MatchJoinIntent) IPacket.readEnum(byteBuffer, MatchJoinIntent.class), IPacket.readPlayerDataContext(byteBuffer), IPacket.readByteArray(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.playerUUID);
        IPacket.writeUUID(byteBuffer, this.match);
        IPacket.writeEnum(byteBuffer, this.intent);
        IPacket.writePlayerDataContext(byteBuffer, this.context);
        IPacket.writeByteArray(byteBuffer, this.data);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f68ID;
    }
}
