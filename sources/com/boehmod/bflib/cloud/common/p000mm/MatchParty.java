package com.boehmod.bflib.cloud.common.p000mm;

import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/mm/MatchParty.class */
public class MatchParty {
    public static final int MAX_PLAYERS = 5;
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";

    @NotNull
    private final Set<UUID> members;

    /* JADX INFO: renamed from: id */
    @NotNull
    private final UUID f2id;

    @NotNull
    private UUID host;

    @NotNull
    private String joinSecret;
    private boolean searching;

    @NotNull
    private SearchGame game;

    @NotNull
    private SearchRegion region;

    public MatchParty(@NotNull UUID host) {
        this(UUID.randomUUID(), host);
    }

    public MatchParty(@NotNull UUID id, @NotNull UUID host) {
        this.members = new ObjectOpenHashSet();
        this.joinSecret = generateSecret();
        this.searching = false;
        this.game = SearchGame.DOMINATION;
        this.region = SearchRegion.ALL;
        this.f2id = id;
        this.host = host;
    }

    public MatchParty(@NotNull ByteBuf byteBuffer) throws IOException {
        this.members = new ObjectOpenHashSet();
        this.joinSecret = generateSecret();
        this.searching = false;
        this.game = SearchGame.DOMINATION;
        this.region = SearchRegion.ALL;
        this.f2id = IPacket.readUUID(byteBuffer);
        this.host = IPacket.readUUID(byteBuffer);
        this.joinSecret = IPacket.readString(byteBuffer);
        this.members.clear();
        int membersSize = byteBuffer.readInt();
        for (int i = 0; i < membersSize; i++) {
            this.members.add(IPacket.readUUID(byteBuffer));
        }
        this.searching = IPacket.readBoolean(byteBuffer);
        IPacket.readEnum(byteBuffer, SearchGame.class);
        IPacket.readEnum(byteBuffer, SearchRegion.class);
    }

    @NotNull
    public static MatchParty readMatchParty(@NotNull ByteBuf byteBuffer) throws IOException {
        return new MatchParty(byteBuffer);
    }

    @NotNull
    private static String generateSecret() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        StringBuilder sb = new StringBuilder(40);
        for (int i = 0; i < 40; i++) {
            sb.append(ALPHA_NUMERIC_STRING.charAt(random.nextInt(ALPHA_NUMERIC_STRING.length())));
        }
        return sb.toString();
    }

    public void regenerateJoinSecret() {
        this.joinSecret = generateSecret();
    }

    @NotNull
    public Set<UUID> getPartyUUIDs() {
        return (Set) Stream.concat(Stream.of(this.host), this.members.stream()).collect(Collectors.toSet());
    }

    public boolean isPresent(@NotNull UUID playerUUID) {
        return this.host.equals(playerUUID) || this.members.contains(playerUUID);
    }

    public boolean isHost(@NotNull UUID playerUUID) {
        return this.host.equals(playerUUID);
    }

    @NotNull
    public Set<UUID> getMembers() {
        return Collections.unmodifiableSet(this.members);
    }

    @NotNull
    public UUID getHost() {
        return this.host;
    }

    public void setHost(@NotNull UUID host) {
        this.host = host;
    }

    @NotNull
    public SearchGame getGame() {
        return this.game;
    }

    public void setGame(@NotNull SearchGame game) {
        this.game = game;
    }

    @NotNull
    public SearchRegion getRegion() {
        return this.region;
    }

    public void setRegion(@NotNull SearchRegion region) {
        this.region = region;
    }

    @NotNull
    public Set<UUID> getPlayers() {
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        objectOpenHashSet.add(this.host);
        objectOpenHashSet.addAll(this.members);
        return Collections.unmodifiableSet(objectOpenHashSet);
    }

    @NotNull
    public UUID getId() {
        return this.f2id;
    }

    @NotNull
    public String getJoinSecret() {
        return this.joinSecret;
    }

    public boolean isSearching() {
        return this.searching;
    }

    public void setSearching(boolean searching) {
        this.searching = searching;
    }

    public void addMember(@NotNull UUID playerUUID) {
        this.members.add(playerUUID);
    }

    public void removeMember(@NotNull UUID playerUUID) {
        this.members.remove(playerUUID);
    }

    public void encode(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.f2id);
        IPacket.writeUUID(byteBuffer, this.host);
        IPacket.writeString(byteBuffer, this.joinSecret);
        byteBuffer.writeInt(this.members.size());
        for (UUID member : this.members) {
            IPacket.writeUUID(byteBuffer, member);
        }
        IPacket.writeBoolean(byteBuffer, this.searching);
        IPacket.writeEnum(byteBuffer, this.game);
        IPacket.writeEnum(byteBuffer, this.region);
    }
}
