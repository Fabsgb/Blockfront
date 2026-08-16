package com.boehmod.bflib.cloud.packet.common;

import com.boehmod.bflib.cloud.common.profanity.Profanity;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/PacketProfanitySync.class */
public final class PacketProfanitySync extends Record implements IPacket {

    @NotNull
    private final List<Profanity> profanities;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f35ID = new PacketIdentifier("PacketProfanitySync");

    public PacketProfanitySync(@NotNull List<Profanity> profanities) {
        this.profanities = profanities;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketProfanitySync.class), PacketProfanitySync.class, "profanities", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketProfanitySync;->profanities:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketProfanitySync.class), PacketProfanitySync.class, "profanities", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketProfanitySync;->profanities:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketProfanitySync.class, Object.class), PacketProfanitySync.class, "profanities", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketProfanitySync;->profanities:Ljava/util/List;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public List<Profanity> profanities() {
        return this.profanities;
    }

    public PacketProfanitySync(@NotNull ByteBuf byteBuffer) {
        this((List<Profanity>) IPacket.readProfanityList(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeProfanityList(byteBuffer, this.profanities);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f35ID;
    }
}
