package com.boehmod.bflib.cloud.packet.common.requests;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/requests/PacketRequestedClanData.class */
public final class PacketRequestedClanData extends Record implements IPacket {

    @NotNull
    private final UUID uuid;

    @NotNull
    private final AbstractClanData clanData;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f99ID = new PacketIdentifier("PacketRequestedClanData");

    public PacketRequestedClanData(@NotNull UUID uuid, @NotNull AbstractClanData clanData) {
        this.uuid = uuid;
        this.clanData = clanData;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketRequestedClanData.class), PacketRequestedClanData.class, "uuid;clanData", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedClanData;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedClanData;->clanData:Lcom/boehmod/bflib/cloud/common/AbstractClanData;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketRequestedClanData.class), PacketRequestedClanData.class, "uuid;clanData", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedClanData;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedClanData;->clanData:Lcom/boehmod/bflib/cloud/common/AbstractClanData;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketRequestedClanData.class, Object.class), PacketRequestedClanData.class, "uuid;clanData", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedClanData;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedClanData;->clanData:Lcom/boehmod/bflib/cloud/common/AbstractClanData;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID uuid() {
        return this.uuid;
    }

    @NotNull
    public AbstractClanData clanData() {
        return this.clanData;
    }

    public PacketRequestedClanData(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), AbstractClanData.read(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.uuid);
        this.clanData.write(byteBuffer);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f99ID;
    }
}
