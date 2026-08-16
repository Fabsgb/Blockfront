package com.boehmod.bflib.cloud.common.player.status;

import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/status/PlayerStatus.class */
public abstract class PlayerStatus {

    @NotNull
    private OnlineStatus onlineStatus = OnlineStatus.OFFLINE;

    @NotNull
    private PartyStatus partyStatus = PartyStatus.NONE;

    @NotNull
    public OnlineStatus getOnlineStatus() {
        return this.onlineStatus;
    }

    public void setOnlineStatus(@NotNull OnlineStatus onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    @NotNull
    public PartyStatus getPartyStatus() {
        return this.partyStatus;
    }

    public void setPartyStatus(@NotNull PartyStatus partyStatus) {
        this.partyStatus = partyStatus;
    }

    protected void encodeShared(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeEnum(byteBuffer, this.onlineStatus);
        IPacket.writeEnum(byteBuffer, this.partyStatus);
    }

    protected void decodeShared(@NotNull ByteBuf byteBuffer) throws IOException {
        this.onlineStatus = (OnlineStatus) IPacket.readEnum(byteBuffer, OnlineStatus.class);
        this.partyStatus = (PartyStatus) IPacket.readEnum(byteBuffer, PartyStatus.class);
    }

    public String toString() {
        return "PlayerStatus{onlineStatus=" + String.valueOf(this.onlineStatus) + ", partyStatus=" + String.valueOf(this.partyStatus) + "}";
    }
}
