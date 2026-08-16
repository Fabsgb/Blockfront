package com.boehmod.bflib.cloud.common;

import com.boehmod.bflib.cloud.common.p001mm.SearchGame;
import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/MatchData.class */
public class MatchData {

    @NotNull
    private final ObjectSet<UUID> players;

    @NotNull
    private final ObjectSet<UUID> spectators;

    @NotNull
    private final UUID uuid;

    @NotNull
    private final String mapName;

    @NotNull
    private final SearchGame game;
    private final int maxPlayerCount;

    @NotNull
    private final MatchSettings matchSettings;
    private final boolean acceptingPlayers;

    public MatchData(@NotNull Set<UUID> players, @NotNull UUID uuid, @NotNull String mapName, @NotNull SearchGame game, int maxPlayerCount, @NotNull MatchSettings matchSettings, boolean acceptingPlayers) {
        this.players = new ObjectOpenHashSet();
        this.spectators = new ObjectOpenHashSet();
        addPlayers(players);
        this.uuid = uuid;
        this.mapName = mapName;
        this.game = game;
        this.maxPlayerCount = maxPlayerCount;
        this.matchSettings = matchSettings;
        this.acceptingPlayers = acceptingPlayers;
    }

    public MatchData(@NotNull ByteBuf byteBuffer) throws IOException {
        this.players = new ObjectOpenHashSet();
        this.spectators = new ObjectOpenHashSet();
        this.uuid = IPacket.readUUID(byteBuffer);
        this.mapName = IPacket.readString(byteBuffer);
        this.game = (SearchGame) IPacket.readEnum(byteBuffer, SearchGame.class);
        this.maxPlayerCount = byteBuffer.readInt();
        this.matchSettings = new MatchSettings();
        this.matchSettings.read(byteBuffer);
        this.acceptingPlayers = IPacket.readBoolean(byteBuffer);
        this.players.clear();
        addPlayers(IPacket.readUUIDSet(byteBuffer));
        this.spectators.clear();
        addSpectators(IPacket.readUUIDSet(byteBuffer));
    }

    @NotNull
    public MatchData copy() {
        MatchSettings settings = new MatchSettings();
        settings.copyFrom(this.matchSettings);
        MatchData copy = new MatchData(new ObjectOpenHashSet(this.players), this.uuid, this.mapName, this.game, this.maxPlayerCount, settings, this.acceptingPlayers);
        copy.addSpectators(this.spectators);
        return copy;
    }

    public void write(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.uuid);
        IPacket.writeString(byteBuffer, this.mapName);
        IPacket.writeEnum(byteBuffer, this.game);
        byteBuffer.writeInt(this.maxPlayerCount);
        this.matchSettings.write(byteBuffer);
        IPacket.writeBoolean(byteBuffer, this.acceptingPlayers);
        IPacket.writeUUIDSet(byteBuffer, this.players);
        IPacket.writeUUIDSet(byteBuffer, this.spectators);
    }

    @NotNull
    public static MatchData readInstanceFromStream(@NotNull ByteBuf byteBuffer) throws IOException {
        return new MatchData(byteBuffer);
    }

    public boolean isFull() {
        return this.matchSettings.hasTeamSizeLimit() && this.players.size() >= this.maxPlayerCount;
    }

    public boolean canSpectate() {
        return this.matchSettings.allowsSpectators() && this.spectators.size() < this.matchSettings.getMaxSpectators();
    }

    @NotNull
    public UUID getUUID() {
        return this.uuid;
    }

    @NotNull
    public String getMapName() {
        return this.mapName;
    }

    @NotNull
    public SearchGame getGame() {
        return this.game;
    }

    public int getPlayerCount() {
        return this.players.size();
    }

    public int getMaxPlayerCount() {
        return this.maxPlayerCount;
    }

    @NotNull
    public MatchSettings getMatchSettings() {
        return this.matchSettings;
    }

    public boolean isAcceptingPlayers() {
        return this.acceptingPlayers;
    }

    @NotNull
    public Set<UUID> getPlayers() {
        return Collections.unmodifiableSet(this.players);
    }

    public void addPlayers(@NotNull Set<UUID> players) {
        this.players.addAll(players);
    }

    public boolean hasPlayers() {
        return !this.players.isEmpty();
    }

    public boolean hasPlayer(@NotNull UUID playerUUID) {
        return this.players.contains(playerUUID);
    }

    public void removePlayer(@NotNull UUID uuid) {
        this.players.remove(uuid);
    }

    @NotNull
    public Set<UUID> getSpectators() {
        return Collections.unmodifiableSet(this.spectators);
    }

    public void addSpectators(@NotNull Set<UUID> spectators) {
        this.spectators.addAll(spectators);
    }

    public int getSpectatorCount() {
        return this.spectators.size();
    }

    public boolean hasSpectator(@NotNull UUID spectatorUUID) {
        return this.spectators.contains(spectatorUUID);
    }

    public void removeSpectator(@NotNull UUID uuid) {
        this.spectators.remove(uuid);
    }
}
