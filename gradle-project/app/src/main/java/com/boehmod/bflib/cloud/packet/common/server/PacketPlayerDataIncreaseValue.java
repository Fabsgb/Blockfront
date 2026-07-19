package com.boehmod.bflib.cloud.packet.common.server;

import com.boehmod.bflib.cloud.common.player.PlayerStatExtra;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValue.class */
public final class PacketPlayerDataIncreaseValue extends Record implements IPacket {

    @NotNull
    private final PlayerStatExtra extra;

    @NotNull
    private final UUID uuid;

    @NotNull
    private final String value;
    private final int amount;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketPlayerDataIncreaseValue");

    public PacketPlayerDataIncreaseValue(@NotNull PlayerStatExtra extra, @NotNull UUID uuid, @NotNull String value, int amount) {
        this.extra = extra;
        this.uuid = uuid;
        this.value = value;
        this.amount = amount;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketPlayerDataIncreaseValue.class), PacketPlayerDataIncreaseValue.class, "extra;uuid;value;amount", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValue;->extra:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValue;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValue;->value:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValue;->amount:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketPlayerDataIncreaseValue.class), PacketPlayerDataIncreaseValue.class, "extra;uuid;value;amount", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValue;->extra:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValue;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValue;->value:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValue;->amount:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketPlayerDataIncreaseValue.class, Object.class), PacketPlayerDataIncreaseValue.class, "extra;uuid;value;amount", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValue;->extra:Lcom/boehmod/bflib/cloud/common/player/PlayerStatExtra;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValue;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValue;->value:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/server/PacketPlayerDataIncreaseValue;->amount:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public PlayerStatExtra extra() {
        return this.extra;
    }

    @NotNull
    public UUID uuid() {
        return this.uuid;
    }

    @NotNull
    public String value() {
        return this.value;
    }

    public int amount() {
        return this.amount;
    }

    public PacketPlayerDataIncreaseValue(@NotNull UUID uuid, @NotNull String value, int amount) {
        this(PlayerStatExtra.EMPTY, uuid, value, amount);
    }

    public PacketPlayerDataIncreaseValue(@NotNull ByteBuf byteBuffer) throws IOException {
        this(PlayerStatExtra.read(byteBuffer), IPacket.readUUID(byteBuffer), IPacket.readString(byteBuffer), byteBuffer.readInt());
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        this.extra.write(byteBuffer);
        IPacket.writeUUID(byteBuffer, this.uuid);
        IPacket.writeString(byteBuffer, this.value);
        byteBuffer.writeInt(this.amount);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
