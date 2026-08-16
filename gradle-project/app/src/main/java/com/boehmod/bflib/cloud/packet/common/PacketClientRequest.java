package com.boehmod.bflib.cloud.packet.common;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.EnumSet;
import java.util.Map;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/PacketClientRequest.class */
public final class PacketClientRequest extends Record implements IPacket {

    @NotNull
    private final EnumSet<RequestType> types;

    @NotNull
    private final ObjectList<Map.Entry<UUID, EnumSet<RequestType>>> identifiableTypes;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f25ID = new PacketIdentifier("PacketClientRequest");

    public PacketClientRequest(@NotNull EnumSet<RequestType> types, @NotNull ObjectList<Map.Entry<UUID, EnumSet<RequestType>>> identifiableTypes) {
        this.types = types;
        this.identifiableTypes = identifiableTypes;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketClientRequest.class), PacketClientRequest.class, "types;identifiableTypes", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientRequest;->types:Ljava/util/EnumSet;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientRequest;->identifiableTypes:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketClientRequest.class), PacketClientRequest.class, "types;identifiableTypes", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientRequest;->types:Ljava/util/EnumSet;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientRequest;->identifiableTypes:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketClientRequest.class, Object.class), PacketClientRequest.class, "types;identifiableTypes", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientRequest;->types:Ljava/util/EnumSet;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientRequest;->identifiableTypes:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public EnumSet<RequestType> types() {
        return this.types;
    }

    @NotNull
    public ObjectList<Map.Entry<UUID, EnumSet<RequestType>>> identifiableTypes() {
        return this.identifiableTypes;
    }

    public PacketClientRequest(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readEnumSet(byteBuffer, RequestType.class), IPacket.readEnumSetMap(byteBuffer, RequestType.class));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeEnumSet(byteBuffer, this.types);
        IPacket.writeEnumSetMap(byteBuffer, this.identifiableTypes);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f25ID;
    }
}
