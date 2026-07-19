package com.boehmod.bflib.cloud.common.player.status;

import com.boehmod.bflib.cloud.common.mm.SearchGame;
import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/status/PublicPlayerStatus.class */
public class PublicPlayerStatus extends PlayerStatus {
    private boolean inGame = false;
    private boolean spectating = false;

    @Nullable
    private SearchGame matchGame = null;

    @Nullable
    private String matchMapName = null;
    private int matchPlayerCount = 0;
    private int matchMaxPlayerCount = 0;

    public PublicPlayerStatus() {
    }

    public PublicPlayerStatus(@NotNull ByteBuf byteBuffer) throws IOException {
        decode(byteBuffer);
    }

    public boolean isInGame() {
        return this.inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public boolean isSpectating() {
        return this.spectating;
    }

    public void setSpectating(boolean spectating) {
        this.spectating = spectating;
    }

    public boolean hasMatchInfo() {
        return this.matchGame != null;
    }

    public void setMatchSummary(@NotNull SearchGame game, @NotNull String mapName, int playerCount, int maxPlayerCount) {
        this.matchGame = game;
        this.matchMapName = mapName;
        this.matchPlayerCount = playerCount;
        this.matchMaxPlayerCount = maxPlayerCount;
    }

    @Nullable
    public SearchGame getMatchGame() {
        return this.matchGame;
    }

    @Nullable
    public String getMatchMapName() {
        return this.matchMapName;
    }

    public int getMatchPlayerCount() {
        return this.matchPlayerCount;
    }

    public int getMatchMaxPlayerCount() {
        return this.matchMaxPlayerCount;
    }

    public void decode(@NotNull ByteBuf byteBuffer) throws IOException {
        decodeShared(byteBuffer);
        this.inGame = IPacket.readBoolean(byteBuffer);
        this.spectating = IPacket.readBoolean(byteBuffer);
        if (IPacket.readBoolean(byteBuffer)) {
            this.matchGame = (SearchGame) IPacket.readEnum(byteBuffer, SearchGame.class);
            this.matchMapName = IPacket.readString(byteBuffer);
            this.matchPlayerCount = byteBuffer.readInt();
            this.matchMaxPlayerCount = byteBuffer.readInt();
            return;
        }
        this.matchGame = null;
        this.matchMapName = null;
        this.matchPlayerCount = 0;
        this.matchMaxPlayerCount = 0;
    }

    public void encode(@NotNull ByteBuf byteBuffer) throws IOException {
        encodeShared(byteBuffer);
        IPacket.writeBoolean(byteBuffer, this.inGame);
        IPacket.writeBoolean(byteBuffer, this.spectating);
        IPacket.writeBoolean(byteBuffer, this.matchGame != null);
        if (this.matchGame != null) {
            IPacket.writeEnum(byteBuffer, this.matchGame);
            IPacket.writeString(byteBuffer, this.matchMapName);
            byteBuffer.writeInt(this.matchPlayerCount);
            byteBuffer.writeInt(this.matchMaxPlayerCount);
        }
    }

    @NotNull
    public String toString() {
        return "PublicPlayerStatus{onlineStatus=" + String.valueOf(getOnlineStatus()) + ", inGame=" + this.inGame + ", spectating=" + this.spectating + ", matchGame=" + String.valueOf(this.matchGame) + ", matchMapName=" + this.matchMapName + "}";
    }
}
