package com.boehmod.bflib.cloud.packet.common.inventory;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.ints.IntList;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryCaseResults.class */
public final class PacketInventoryCaseResults extends Record implements IPacket {

    @NotNull
    private final IntList results;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketInventoryCaseResults");

    public PacketInventoryCaseResults(@NotNull IntList results) {
        this.results = results;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketInventoryCaseResults.class), PacketInventoryCaseResults.class, "results", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryCaseResults;->results:Lit/unimi/dsi/fastutil/ints/IntList;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketInventoryCaseResults.class), PacketInventoryCaseResults.class, "results", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryCaseResults;->results:Lit/unimi/dsi/fastutil/ints/IntList;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketInventoryCaseResults.class, Object.class), PacketInventoryCaseResults.class, "results", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/inventory/PacketInventoryCaseResults;->results:Lit/unimi/dsi/fastutil/ints/IntList;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public IntList results() {
        return this.results;
    }

    public PacketInventoryCaseResults(@NotNull ByteBuf byteBuffer) {
        this(IPacket.readIntList(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeIntList(byteBuffer, this.results);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
