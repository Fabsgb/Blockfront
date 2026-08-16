package com.boehmod.bflib.cloud.packet.common;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/PacketClientSound.class */
public final class PacketClientSound extends Record implements IPacket {

    @NotNull
    private final String sound;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f26ID = new PacketIdentifier("PacketClientSound");

    public PacketClientSound(@NotNull String sound) {
        this.sound = sound;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketClientSound.class), PacketClientSound.class, "sound", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientSound;->sound:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketClientSound.class), PacketClientSound.class, "sound", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientSound;->sound:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketClientSound.class, Object.class), PacketClientSound.class, "sound", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketClientSound;->sound:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public String sound() {
        return this.sound;
    }

    public PacketClientSound(@NotNull ByteBuf byteBuffer) {
        this(IPacket.readString(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeString(byteBuffer, this.sound);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f26ID;
    }
}
