package com.boehmod.bflib.cloud.packet.common.mm;

import com.boehmod.bflib.cloud.common.mm.SearchGame;
import com.boehmod.bflib.cloud.common.mm.report.IMatchReportData;
import com.boehmod.bflib.cloud.common.mm.report.MatchReportDataRegistry;
import com.boehmod.bflib.cloud.common.mm.report.MatchReportPlayer;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport.class */
public final class PacketMMMatchReport extends Record implements IPacket {

    @NotNull
    private final UUID matchId;

    @NotNull
    private final SearchGame gameMode;

    @NotNull
    private final String mapName;

    @NotNull
    private final String environment;
    private final int durationSeconds;
    private final boolean teamBased;

    @Nullable
    private final String winnerTeam;
    private final int axisScore;
    private final int alliedScore;
    private final int axisCasualties;
    private final int alliedCasualties;

    @NotNull
    private final ObjectList<MatchReportPlayer> players;

    @Nullable
    private final IMatchReportData data;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketMMMatchReport");

    public PacketMMMatchReport(@NotNull UUID matchId, @NotNull SearchGame gameMode, @NotNull String mapName, @NotNull String environment, int durationSeconds, boolean teamBased, @Nullable String winnerTeam, int axisScore, int alliedScore, int axisCasualties, int alliedCasualties, @NotNull ObjectList<MatchReportPlayer> players, @Nullable IMatchReportData data) {
        this.matchId = matchId;
        this.gameMode = gameMode;
        this.mapName = mapName;
        this.environment = environment;
        this.durationSeconds = durationSeconds;
        this.teamBased = teamBased;
        this.winnerTeam = winnerTeam;
        this.axisScore = axisScore;
        this.alliedScore = alliedScore;
        this.axisCasualties = axisCasualties;
        this.alliedCasualties = alliedCasualties;
        this.players = players;
        this.data = data;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketMMMatchReport.class), PacketMMMatchReport.class, "matchId;gameMode;mapName;environment;durationSeconds;teamBased;winnerTeam;axisScore;alliedScore;axisCasualties;alliedCasualties;players;data", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->matchId:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->gameMode:Lcom/boehmod/bflib/cloud/common/mm/SearchGame;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->mapName:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->environment:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->durationSeconds:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->teamBased:Z", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->winnerTeam:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->axisScore:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->alliedScore:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->axisCasualties:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->alliedCasualties:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->players:Lit/unimi/dsi/fastutil/objects/ObjectList;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->data:Lcom/boehmod/bflib/cloud/common/mm/report/IMatchReportData;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketMMMatchReport.class), PacketMMMatchReport.class, "matchId;gameMode;mapName;environment;durationSeconds;teamBased;winnerTeam;axisScore;alliedScore;axisCasualties;alliedCasualties;players;data", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->matchId:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->gameMode:Lcom/boehmod/bflib/cloud/common/mm/SearchGame;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->mapName:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->environment:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->durationSeconds:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->teamBased:Z", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->winnerTeam:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->axisScore:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->alliedScore:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->axisCasualties:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->alliedCasualties:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->players:Lit/unimi/dsi/fastutil/objects/ObjectList;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->data:Lcom/boehmod/bflib/cloud/common/mm/report/IMatchReportData;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketMMMatchReport.class, Object.class), PacketMMMatchReport.class, "matchId;gameMode;mapName;environment;durationSeconds;teamBased;winnerTeam;axisScore;alliedScore;axisCasualties;alliedCasualties;players;data", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->matchId:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->gameMode:Lcom/boehmod/bflib/cloud/common/mm/SearchGame;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->mapName:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->environment:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->durationSeconds:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->teamBased:Z", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->winnerTeam:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->axisScore:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->alliedScore:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->axisCasualties:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->alliedCasualties:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->players:Lit/unimi/dsi/fastutil/objects/ObjectList;", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/mm/PacketMMMatchReport;->data:Lcom/boehmod/bflib/cloud/common/mm/report/IMatchReportData;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
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

    public int durationSeconds() {
        return this.durationSeconds;
    }

    public boolean teamBased() {
        return this.teamBased;
    }

    @Nullable
    public String winnerTeam() {
        return this.winnerTeam;
    }

    public int axisScore() {
        return this.axisScore;
    }

    public int alliedScore() {
        return this.alliedScore;
    }

    public int axisCasualties() {
        return this.axisCasualties;
    }

    public int alliedCasualties() {
        return this.alliedCasualties;
    }

    @NotNull
    public ObjectList<MatchReportPlayer> players() {
        return this.players;
    }

    @Nullable
    public IMatchReportData data() {
        return this.data;
    }

    public PacketMMMatchReport(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), (SearchGame) IPacket.readEnum(byteBuffer, SearchGame.class), IPacket.readString(byteBuffer), IPacket.readString(byteBuffer), byteBuffer.readInt(), IPacket.readBoolean(byteBuffer), IPacket.readOptionalString(byteBuffer), byteBuffer.readInt(), byteBuffer.readInt(), byteBuffer.readInt(), byteBuffer.readInt(), MatchReportPlayer.readList(byteBuffer), readOptionalData(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.matchId);
        IPacket.writeEnum(byteBuffer, this.gameMode);
        IPacket.writeString(byteBuffer, this.mapName);
        IPacket.writeString(byteBuffer, this.environment);
        byteBuffer.writeInt(this.durationSeconds);
        IPacket.writeBoolean(byteBuffer, this.teamBased);
        IPacket.writeOptionalString(byteBuffer, this.winnerTeam);
        byteBuffer.writeInt(this.axisScore);
        byteBuffer.writeInt(this.alliedScore);
        byteBuffer.writeInt(this.axisCasualties);
        byteBuffer.writeInt(this.alliedCasualties);
        MatchReportPlayer.writeList(byteBuffer, this.players);
        writeOptionalData(byteBuffer, this.data);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }

    private static void writeOptionalData(@NotNull ByteBuf byteBuffer, @Nullable IMatchReportData data) throws IOException {
        IPacket.writeBoolean(byteBuffer, data != null);
        if (data != null) {
            MatchReportDataRegistry.writeMatchReportData(data, byteBuffer);
        }
    }

    @Nullable
    private static IMatchReportData readOptionalData(@NotNull ByteBuf byteBuffer) throws IOException {
        if (IPacket.readBoolean(byteBuffer)) {
            return MatchReportDataRegistry.readMatchReportData(byteBuffer);
        }
        return null;
    }
}
