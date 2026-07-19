package com.boehmod.bflib.cloud.common.mm.report;

import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer.class */
public final class MatchReportPlayer extends Record {

    @NotNull
    private final UUID uuid;

    @Nullable
    private final String team;

    @NotNull
    private final MatchResult result;
    private final int placement;
    private final int kills;
    private final int deaths;
    private final int assists;
    private final int score;

    @NotNull
    private final Object2IntMap<String> extraStats;

    public MatchReportPlayer(@NotNull UUID uuid, @Nullable String team, @NotNull MatchResult result, int placement, int kills, int deaths, int assists, int score, @NotNull Object2IntMap<String> extraStats) {
        this.uuid = uuid;
        this.team = team;
        this.result = result;
        this.placement = placement;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.score = score;
        this.extraStats = extraStats;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, MatchReportPlayer.class), MatchReportPlayer.class, "uuid;team;result;placement;kills;deaths;assists;score;extraStats", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->team:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->result:Lcom/boehmod/bflib/cloud/common/mm/report/MatchResult;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->placement:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->kills:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->deaths:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->assists:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->score:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->extraStats:Lit/unimi/dsi/fastutil/objects/Object2IntMap;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, MatchReportPlayer.class), MatchReportPlayer.class, "uuid;team;result;placement;kills;deaths;assists;score;extraStats", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->team:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->result:Lcom/boehmod/bflib/cloud/common/mm/report/MatchResult;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->placement:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->kills:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->deaths:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->assists:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->score:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->extraStats:Lit/unimi/dsi/fastutil/objects/Object2IntMap;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, MatchReportPlayer.class, Object.class), MatchReportPlayer.class, "uuid;team;result;placement;kills;deaths;assists;score;extraStats", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->uuid:Ljava/util/UUID;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->team:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->result:Lcom/boehmod/bflib/cloud/common/mm/report/MatchResult;", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->placement:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->kills:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->deaths:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->assists:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->score:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/MatchReportPlayer;->extraStats:Lit/unimi/dsi/fastutil/objects/Object2IntMap;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public UUID uuid() {
        return this.uuid;
    }

    @Nullable
    public String team() {
        return this.team;
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

    @NotNull
    public Object2IntMap<String> extraStats() {
        return this.extraStats;
    }

    public MatchReportPlayer(@NotNull ByteBuf byteBuffer) throws IOException {
        this(IPacket.readUUID(byteBuffer), IPacket.readOptionalString(byteBuffer), (MatchResult) IPacket.readEnum(byteBuffer, MatchResult.class), byteBuffer.readInt(), byteBuffer.readInt(), byteBuffer.readInt(), byteBuffer.readInt(), byteBuffer.readInt(), readExtraStats(byteBuffer));
    }

    public void write(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.uuid);
        IPacket.writeOptionalString(byteBuffer, this.team);
        IPacket.writeEnum(byteBuffer, this.result);
        byteBuffer.writeInt(this.placement);
        byteBuffer.writeInt(this.kills);
        byteBuffer.writeInt(this.deaths);
        byteBuffer.writeInt(this.assists);
        byteBuffer.writeInt(this.score);
        writeExtraStats(byteBuffer, this.extraStats);
    }

    public static void writeList(@NotNull ByteBuf byteBuffer, @NotNull ObjectList<MatchReportPlayer> players) throws IOException {
        byteBuffer.writeInt(players.size());
        ObjectListIterator it = players.iterator();
        while (it.hasNext()) {
            MatchReportPlayer player = (MatchReportPlayer) it.next();
            player.write(byteBuffer);
        }
    }

    @NotNull
    public static ObjectList<MatchReportPlayer> readList(@NotNull ByteBuf byteBuffer) throws IOException {
        int size = IPacket.readSize(byteBuffer);
        ObjectArrayList objectArrayList = new ObjectArrayList(size);
        for (int i = 0; i < size; i++) {
            objectArrayList.add(new MatchReportPlayer(byteBuffer));
        }
        return objectArrayList;
    }

    private static void writeExtraStats(@NotNull ByteBuf byteBuffer, @NotNull Object2IntMap<String> extraStats) {
        byteBuffer.writeInt(extraStats.size());
        ObjectIterator it = extraStats.object2IntEntrySet().iterator();
        while (it.hasNext()) {
            Object2IntMap.Entry<String> entry = (Object2IntMap.Entry) it.next();
            IPacket.writeString(byteBuffer, (String) entry.getKey());
            byteBuffer.writeInt(entry.getIntValue());
        }
    }

    @NotNull
    private static Object2IntMap<String> readExtraStats(@NotNull ByteBuf byteBuffer) {
        int size = IPacket.readSize(byteBuffer);
        Object2IntOpenHashMap object2IntOpenHashMap = new Object2IntOpenHashMap(size);
        for (int i = 0; i < size; i++) {
            String key = IPacket.readString(byteBuffer);
            object2IntOpenHashMap.put(key, byteBuffer.readInt());
        }
        return object2IntOpenHashMap;
    }
}
