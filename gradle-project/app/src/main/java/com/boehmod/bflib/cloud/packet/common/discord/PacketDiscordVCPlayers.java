package com.boehmod.bflib.cloud.packet.common.discord;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/discord/PacketDiscordVCPlayers.class */
public final class PacketDiscordVCPlayers extends Record implements IPacket {

    @NotNull
    private final ObjectSet<UUID> voiceChannelPlayers;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketDiscordVCPlayers");

    public PacketDiscordVCPlayers(@NotNull ObjectSet<UUID> voiceChannelPlayers) {
        this.voiceChannelPlayers = voiceChannelPlayers;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketDiscordVCPlayers.class), PacketDiscordVCPlayers.class, "voiceChannelPlayers", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/discord/PacketDiscordVCPlayers;->voiceChannelPlayers:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketDiscordVCPlayers.class), PacketDiscordVCPlayers.class, "voiceChannelPlayers", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/discord/PacketDiscordVCPlayers;->voiceChannelPlayers:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketDiscordVCPlayers.class, Object.class), PacketDiscordVCPlayers.class, "voiceChannelPlayers", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/discord/PacketDiscordVCPlayers;->voiceChannelPlayers:Lit/unimi/dsi/fastutil/objects/ObjectSet;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public ObjectSet<UUID> voiceChannelPlayers() {
        return this.voiceChannelPlayers;
    }

    public PacketDiscordVCPlayers(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUIDSet(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUIDSet(byteBuffer, this.voiceChannelPlayers);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
