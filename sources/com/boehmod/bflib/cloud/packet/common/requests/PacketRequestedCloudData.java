package com.boehmod.bflib.cloud.packet.common.requests;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.io.IOException;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/requests/PacketRequestedCloudData.class */
public class PacketRequestedCloudData implements IPacket {

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f86ID = new PacketIdentifier("PacketRequestedCloudData");
    private final int usersOnline;

    @NotNull
    private final Object2IntMap<String> gamePlayerCount;
    private final long scoreboardResetTime;

    @NotNull
    private final Object2IntMap<UUID> clanScores;

    @NotNull
    private final Object2IntMap<UUID> playerScores;

    public PacketRequestedCloudData(int usersOnline, @NotNull Object2IntMap<String> gamePlayerCount, long scoreboardResetTime, @NotNull Object2IntMap<UUID> clanScores, @NotNull Object2IntMap<UUID> playerScores) {
        this.usersOnline = usersOnline;
        this.gamePlayerCount = gamePlayerCount;
        this.scoreboardResetTime = scoreboardResetTime;
        this.clanScores = clanScores;
        this.playerScores = playerScores;
    }

    public PacketRequestedCloudData(@NotNull ByteBuf byteBuffer) {
        this.usersOnline = byteBuffer.readInt();
        int gameModeSize = byteBuffer.readInt();
        this.gamePlayerCount = new Object2IntOpenHashMap();
        for (int i = 0; i < gameModeSize; i++) {
            String gameMode = IPacket.readString(byteBuffer);
            int playerCount = byteBuffer.readInt();
            this.gamePlayerCount.put(gameMode, playerCount);
        }
        this.scoreboardResetTime = byteBuffer.readLong();
        int clanScoreSize = byteBuffer.readInt();
        this.clanScores = new Object2IntOpenHashMap();
        for (int i2 = 0; i2 < clanScoreSize; i2++) {
            UUID clanUUID = new UUID(byteBuffer.readLong(), byteBuffer.readLong());
            int score = byteBuffer.readInt();
            this.clanScores.put(clanUUID, score);
        }
        int playerScoreSize = byteBuffer.readInt();
        this.playerScores = new Object2IntOpenHashMap();
        for (int i3 = 0; i3 < playerScoreSize; i3++) {
            UUID playerUUID = new UUID(byteBuffer.readLong(), byteBuffer.readLong());
            int score2 = byteBuffer.readInt();
            this.playerScores.put(playerUUID, score2);
        }
    }

    public int getUsersOnline() {
        return this.usersOnline;
    }

    @NotNull
    public Object2IntMap<String> getGamePlayerCount() {
        return this.gamePlayerCount;
    }

    public long getScoreboardResetTime() {
        return this.scoreboardResetTime;
    }

    @NotNull
    public Object2IntMap<UUID> getClanScores() {
        return this.clanScores;
    }

    @NotNull
    public Object2IntMap<UUID> getPlayerScores() {
        return this.playerScores;
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        byteBuffer.writeInt(this.usersOnline);
        byteBuffer.writeInt(this.gamePlayerCount.size());
        ObjectIterator it = this.gamePlayerCount.object2IntEntrySet().iterator();
        while (it.hasNext()) {
            Object2IntMap.Entry<String> entry = (Object2IntMap.Entry) it.next();
            IPacket.writeString(byteBuffer, (String) entry.getKey());
            byteBuffer.writeInt(entry.getIntValue());
        }
        byteBuffer.writeLong(this.scoreboardResetTime);
        byteBuffer.writeInt(this.clanScores.size());
        ObjectIterator it2 = this.clanScores.object2IntEntrySet().iterator();
        while (it2.hasNext()) {
            Object2IntMap.Entry<UUID> entry2 = (Object2IntMap.Entry) it2.next();
            byteBuffer.writeLong(((UUID) entry2.getKey()).getMostSignificantBits());
            byteBuffer.writeLong(((UUID) entry2.getKey()).getLeastSignificantBits());
            byteBuffer.writeInt(entry2.getIntValue());
        }
        byteBuffer.writeInt(this.playerScores.size());
        ObjectIterator it3 = this.playerScores.object2IntEntrySet().iterator();
        while (it3.hasNext()) {
            Object2IntMap.Entry<UUID> entry3 = (Object2IntMap.Entry) it3.next();
            byteBuffer.writeLong(((UUID) entry3.getKey()).getMostSignificantBits());
            byteBuffer.writeLong(((UUID) entry3.getKey()).getLeastSignificantBits());
            byteBuffer.writeInt(entry3.getIntValue());
        }
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return f86ID;
    }
}
