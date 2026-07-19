package com.boehmod.bflib.cloud.packet.common.requests;

import com.boehmod.bflib.cloud.common.player.challenge.Challenge;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/requests/PacketRequestedChallenges.class */
public final class PacketRequestedChallenges extends Record implements IPacket {

    @NotNull
    private final ObjectList<Challenge> challenges;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketRequestedChallenges");

    public PacketRequestedChallenges(@NotNull ObjectList<Challenge> challenges) {
        this.challenges = challenges;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketRequestedChallenges.class), PacketRequestedChallenges.class, "challenges", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedChallenges;->challenges:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketRequestedChallenges.class), PacketRequestedChallenges.class, "challenges", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedChallenges;->challenges:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketRequestedChallenges.class, Object.class), PacketRequestedChallenges.class, "challenges", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/requests/PacketRequestedChallenges;->challenges:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public ObjectList<Challenge> challenges() {
        return this.challenges;
    }

    public PacketRequestedChallenges(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readChallengeList(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeChallengeList(byteBuffer, this.challenges);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
