package com.boehmod.bflib.cloud.common.p000mm.report;

import com.boehmod.bflib.cloud.common.p000mm.SearchGame;
import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/mm/report/MatchSummary.class */
public final class MatchSummary extends Record {

    @NotNull
    private final UUID matchId;

    @NotNull
    private final SearchGame gameMode;

    @NotNull
    private final String mapName;

    @NotNull
    private final String environment;
    private final long endedAtEpochMillis;
    private final int durationSeconds;

    @Nullable
    private final String winnerTeam;

    @Nullable
    private final String playerTeam;

    @NotNull
    private final MatchResult result;
    private final int placement;
    private final int kills;
    private final int deaths;
    private final int assists;
    private final int score;

    public MatchSummary(@NotNull UUID matchId, @NotNull SearchGame gameMode, @NotNull String mapName, @NotNull String environment, long endedAtEpochMillis, int durationSeconds, @Nullable String winnerTeam, @Nullable String playerTeam, @NotNull MatchResult result, int placement, int kills, int deaths, int assists, int score) {
        this.matchId = matchId;
        this.gameMode = gameMode;
        this.mapName = mapName;
        this.environment = environment;
        this.endedAtEpochMillis = endedAtEpochMillis;
        this.durationSeconds = durationSeconds;
        this.winnerTeam = winnerTeam;
        this.playerTeam = playerTeam;
        this.result = result;
        this.placement = placement;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.score = score;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, MatchSummary.class), MatchSummary.class, "matchId;gameMode;mapName;environment;endedAtEpochMillis;durationSeconds;winnerTeam;playerTeam;result;placement;kills;deaths;assists;score", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->matchId:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->gameMode:Lcom/boehmod/bflib/cloud/common/mm/SearchGame;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->mapName:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->environment:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->endedAtEpochMillis:J", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->durationSeconds:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->winnerTeam:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->playerTeam:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->result:Lcom/boehmod/bflib/cloud/common/mm/report/MatchResult;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->placement:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->kills:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->deaths:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->assists:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->score:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, MatchSummary.class), MatchSummary.class, "matchId;gameMode;mapName;environment;endedAtEpochMillis;durationSeconds;winnerTeam;playerTeam;result;placement;kills;deaths;assists;score", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->matchId:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->gameMode:Lcom/boehmod/bflib/cloud/common/mm/SearchGame;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->mapName:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->environment:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->endedAtEpochMillis:J", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->durationSeconds:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->winnerTeam:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->playerTeam:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->result:Lcom/boehmod/bflib/cloud/common/mm/report/MatchResult;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->placement:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->kills:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->deaths:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->assists:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->score:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, MatchSummary.class, Object.class), MatchSummary.class, "matchId;gameMode;mapName;environment;endedAtEpochMillis;durationSeconds;winnerTeam;playerTeam;result;placement;kills;deaths;assists;score", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->matchId:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->gameMode:Lcom/boehmod/bflib/cloud/common/mm/SearchGame;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->mapName:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->environment:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->endedAtEpochMillis:J", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->durationSeconds:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->winnerTeam:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->playerTeam:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->result:Lcom/boehmod/bflib/cloud/common/mm/report/MatchResult;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->placement:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->kills:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->deaths:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->assists:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchSummary;->score:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID matchId() {
        return this.matchId;
    }

    @NotNull
    public SearchGame gameMode() {
        return this.gameMode;
    }

    @NotNull
    public String mapName() {
        return this.mapName;
    }

    @NotNull
    public String environment() {
        return this.environment;
    }

    public long endedAtEpochMillis() {
        return this.endedAtEpochMillis;
    }

    public int durationSeconds() {
        return this.durationSeconds;
    }

    @Nullable
    public String winnerTeam() {
        return this.winnerTeam;
    }

    @Nullable
    public String playerTeam() {
        return this.playerTeam;
    }

    @NotNull
    public MatchResult result() {
        return this.result;
    }

    public int placement() {
        return this.placement;
    }

    public int kills() {
        return this.kills;
    }

    public int deaths() {
        return this.deaths;
    }

    public int assists() {
        return this.assists;
    }

    public int score() {
        return this.score;
    }

    public MatchSummary(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), (SearchGame) IPacket.readEnum(byteBuffer, SearchGame.class), IPacket.readString(byteBuffer), IPacket.readString(byteBuffer), byteBuffer.readLong(), byteBuffer.readInt(), IPacket.readOptionalString(byteBuffer), IPacket.readOptionalString(byteBuffer), (MatchResult) IPacket.readEnum(byteBuffer, MatchResult.class), byteBuffer.readInt(), byteBuffer.readInt(), byteBuffer.readInt(), byteBuffer.readInt(), byteBuffer.readInt());
    }

    public void write(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.matchId);
        IPacket.writeEnum(byteBuffer, this.gameMode);
        IPacket.writeString(byteBuffer, this.mapName);
        IPacket.writeString(byteBuffer, this.environment);
        byteBuffer.writeLong(this.endedAtEpochMillis);
        byteBuffer.writeInt(this.durationSeconds);
        IPacket.writeOptionalString(byteBuffer, this.winnerTeam);
        IPacket.writeOptionalString(byteBuffer, this.playerTeam);
        IPacket.writeEnum(byteBuffer, this.result);
        byteBuffer.writeInt(this.placement);
        byteBuffer.writeInt(this.kills);
        byteBuffer.writeInt(this.deaths);
        byteBuffer.writeInt(this.assists);
        byteBuffer.writeInt(this.score);
    }

    public static void writeList(@NotNull ByteBuf byteBuffer, @NotNull ObjectList<MatchSummary> summaries) throws IOException {
        byteBuffer.writeInt(summaries.size());
        ObjectListIterator it = summaries.iterator();
        while (it.hasNext()) {
            MatchSummary summary = (MatchSummary) it.next();
            summary.write(byteBuffer);
        }
    }

    @NotNull
    public static ObjectList<MatchSummary> readList(@NotNull ByteBuf byteBuffer) throws IOException {
        int size = IPacket.readSize(byteBuffer);
        ObjectArrayList objectArrayList = new ObjectArrayList(size);
        for (int i = 0; i < size; i++) {
            objectArrayList.add(new MatchSummary(byteBuffer));
        }
        return objectArrayList;
    }

    public float killDeathRatio() {
        return this.deaths == 0 ? this.kills : this.kills / this.deaths;
    }
}
