package com.boehmod.bflib.cloud.common.player.status;

import com.boehmod.bflib.cloud.common.MatchData;
import java.util.UUID;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/status/InternalPlayerStatus.class */
public class InternalPlayerStatus extends PlayerStatus {

    @Nullable
    private UUID serverOn = null;

    @Nullable
    private MatchData matchData = null;
    private boolean spectating = false;

    @Nullable
    public UUID getServerOn() {
        return this.serverOn;
    }

    public void setServerOn(@Nullable UUID serverOn) {
        this.serverOn = serverOn;
    }

    @Nullable
    public MatchData getMatchData() {
        return this.matchData;
    }

    public void setMatchData(@Nullable MatchData matchData) {
        this.matchData = matchData;
    }

    public boolean isInGame() {
        return this.serverOn != null;
    }

    public boolean isSpectating() {
        return this.spectating;
    }

    public void setSpectating(boolean spectating) {
        this.spectating = spectating;
    }

    @NotNull
    public PublicPlayerStatus toPublic() {
        PublicPlayerStatus publicStatus = new PublicPlayerStatus();
        publicStatus.setOnlineStatus(getOnlineStatus());
        publicStatus.setPartyStatus(getPartyStatus());
        publicStatus.setInGame(this.serverOn != null);
        publicStatus.setSpectating(this.spectating);
        if (this.matchData != null) {
            publicStatus.setMatchSummary(this.matchData.getGame(), this.matchData.getMapName(), this.matchData.getPlayerCount(), this.matchData.getMaxPlayerCount());
        }
        return publicStatus;
    }
}
