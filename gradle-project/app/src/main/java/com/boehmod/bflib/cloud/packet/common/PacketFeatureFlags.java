package com.boehmod.bflib.cloud.packet.common;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/PacketFeatureFlags.class */
public final class PacketFeatureFlags extends Record implements IPacket {

    @NotNull
    private final Map<String, Boolean> featureFlags;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketFeatureFlags");

    public PacketFeatureFlags(@NotNull Map<String, Boolean> featureFlags) {
        this.featureFlags = featureFlags;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketFeatureFlags.class), PacketFeatureFlags.class, "featureFlags", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketFeatureFlags;->featureFlags:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketFeatureFlags.class), PacketFeatureFlags.class, "featureFlags", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketFeatureFlags;->featureFlags:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketFeatureFlags.class, Object.class), PacketFeatureFlags.class, "featureFlags", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketFeatureFlags;->featureFlags:Ljava/util/Map;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public Map<String, Boolean> featureFlags() {
        return this.featureFlags;
    }

    public PacketFeatureFlags(@NotNull ByteBuf byteBuffer) {
        this(IPacket.readFeatureFlags(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeFeatureFlags(byteBuffer, this.featureFlags);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
