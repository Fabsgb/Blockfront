package com.boehmod.bflib.cloud.common.player;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.p000mm.MatchParty;
import com.boehmod.bflib.cloud.common.player.AbstractCloudInventory;
import com.boehmod.bflib.cloud.common.player.PlayerDataContext;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import com.boehmod.bflib.cloud.common.player.challenge.Challenge;
import com.boehmod.bflib.cloud.common.player.status.PlayerStatus;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.common.util.ModLibraryMathHelper;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntMaps;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.ints.IntSets;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectCollection;
import it.unimi.dsi.fastutil.objects.ObjectCollections;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/AbstractPlayerCloudData.class */
public abstract class AbstractPlayerCloudData<I extends AbstractCloudInventory<?>, S extends PlayerStatus> {
    public static final int MAX_PRESTIGE_LEVEL = 5;

    @NotNull
    protected static final String DEFAULT_USERNAME = "Unknown";

    @NotNull
    private final UUID uuid;
    private final I inventory = (I) createInventory();

    @NotNull
    private final IntSet achievements = new IntOpenHashSet();

    @NotNull
    private final Int2IntMap classExp = new Int2IntOpenHashMap();

    @NotNull
    private final ObjectList<Booster> boosters = new ObjectArrayList();

    @NotNull
    private final ObjectList<Challenge> challenges = new ObjectArrayList();

    @NotNull
    private final Object2ObjectMap<UUID, Punishment> punishments = new Object2ObjectOpenHashMap();

    @NotNull
    private String username = DEFAULT_USERNAME;
    private int exp = 0;
    private int trophies = 0;
    private int prestigeLevel = 0;
    private int matchKarma = 0;
    private int totalGames = 0;
    private int timePlayed = 0;
    private boolean completedBootcamp = false;

    @Nullable
    private MatchParty party = null;

    @NotNull
    private S status = (S) createStatus();

    @Nullable
    private UUID clanId = null;
    private int casesOpened = 0;
    private int kills = 0;
    private int assists = 0;
    private int infectedKills = 0;
    private int vehicleKills = 0;
    private int botKills = 0;
    private int deaths = 0;
    private int backStabs = 0;
    private int headShots = 0;
    private int noScopes = 0;
    private int firstBloods = 0;
    private int fireKills = 0;
    private int killStreak = 0;
    private int deathStreak = 0;
    private int infectedRoundsWon = 0;
    private int infectedMatchesWon = 0;

    @Nullable
    public abstract AbstractClanData getClanData();

    @NotNull
    protected abstract I createInventory();

    @NotNull
    protected abstract S createStatus();

    @NotNull
    public abstract Optional<PlayerGroup> getGroup();

    public abstract void setGroup(@Nullable PlayerGroup playerGroup);

    public AbstractPlayerCloudData(@NotNull UUID uuid) {
        this.uuid = uuid;
    }

    @NotNull
    public I getInventory() {
        return this.inventory;
    }

    @NotNull
    public UUID getUUID() {
        return this.uuid;
    }

    @NotNull
    public String getUsername() {
        return this.username;
    }

    @OverridingMethodsMustInvokeSuper
    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    @NotNull
    public S getStatus() {
        return this.status;
    }

    @OverridingMethodsMustInvokeSuper
    public void setStatus(@NotNull S status) {
        this.status = status;
    }

    public int getExp() {
        return this.exp;
    }

    public void setExp(int amount) {
        this.exp = amount;
    }

    public int getCasesOpened() {
        return this.casesOpened;
    }

    public void setCasesOpened(int value) {
        this.casesOpened = value;
    }

    @OverridingMethodsMustInvokeSuper
    public void addExp(int amount) {
        this.exp += amount;
    }

    @NotNull
    public PlayerRank getRank() {
        return PlayerRank.getRankFromEXP(getExp());
    }

    @NotNull
    public Optional<MatchParty> getParty() {
        return Optional.ofNullable(this.party);
    }

    @OverridingMethodsMustInvokeSuper
    public void setParty(@Nullable MatchParty party) {
        this.party = party;
    }

    public int getTrophies() {
        return this.trophies;
    }

    public void addTrophies(int trophies) {
        this.trophies += trophies;
    }

    public void setTrophies(int value) {
        this.trophies = value;
    }

    public int getPrestigeLevel() {
        return this.prestigeLevel;
    }

    public void setPrestigeLevel(int prestigeLevel) {
        this.prestigeLevel = prestigeLevel;
    }

    public void incrementPrestigeLevel() {
        this.prestigeLevel++;
    }

    public int getMatchKarma() {
        return this.matchKarma;
    }

    public void addMatchKarma(int amount) {
        this.matchKarma += amount;
    }

    public void setMatchKarma(int value) {
        this.matchKarma = value;
    }

    public int getTotalGames() {
        return this.totalGames;
    }

    public void addTotalGames(int amount) {
        this.totalGames += amount;
    }

    public void setTotalGames(int value) {
        this.totalGames = value;
    }

    public boolean hasAchievement(int id) {
        return this.achievements.contains(id);
    }

    public boolean hasAchievement(@NotNull CloudAchievement achievement) {
        return hasAchievement(achievement.getId());
    }

    public void addAchievement(int achievement) {
        this.achievements.add(achievement);
    }

    public void addAchievements(@NotNull CloudRegistry cloudRegistry, @NotNull Set<Integer> achievements) {
        this.achievements.addAll(achievements);
        this.achievements.removeIf(integer -> {
            return cloudRegistry.getAchievement(integer) == null;
        });
    }

    @NotNull
    public IntSet getAchievements() {
        return IntSets.unmodifiable(this.achievements);
    }

    @NotNull
    public List<Booster> getActiveBoosters() {
        return this.boosters.stream().filter((v0) -> {
            return v0.isActive();
        }).toList();
    }

    @NotNull
    public ObjectList<Challenge> getChallenges() {
        return ObjectLists.unmodifiable(this.challenges);
    }

    @NotNull
    public ObjectList<Challenge> getIncompleteChallenges() {
        return (ObjectList) this.challenges.stream().filter(challenge -> {
            return !challenge.isCompleted();
        }).collect(Collectors.toCollection(ObjectArrayList::new));
    }

    public void clearChallenges() {
        this.challenges.clear();
    }

    public void addChallenge(@NotNull Challenge challenge) {
        this.challenges.add(challenge);
    }

    public void setChallenges(@NotNull List<Challenge> challenges) {
        this.challenges.clear();
        this.challenges.addAll(challenges);
    }

    public void addBooster(@NotNull Booster booster) {
        this.boosters.add(booster);
    }

    @OverridingMethodsMustInvokeSuper
    public void addEXPForClass(int classType, int amount) {
        this.classExp.put(classType, this.classExp.getOrDefault(classType, 0) + amount);
    }

    public int getExpForClass(int classOrdinal) {
        return this.classExp.getOrDefault(classOrdinal, 0);
    }

    @NotNull
    public Int2IntMap getClassExp() {
        return Int2IntMaps.unmodifiable(this.classExp);
    }

    public void setClassExp(int classId, int exp) {
        this.classExp.put(classId, exp);
    }

    public double getHoursPlayed() {
        double hoursPlayed = (((double) this.timePlayed) / 60.0d) / 60.0d;
        return ModLibraryMathHelper.round(hoursPlayed, 1);
    }

    public double getMinutesPlayed() {
        double minutesPlayed = ((double) this.timePlayed) / 60.0d;
        return ModLibraryMathHelper.round(minutesPlayed, 1);
    }

    @NotNull
    public Optional<Punishment> getPunishment(@NotNull UUID uuid) {
        return Optional.ofNullable((Punishment) this.punishments.get(uuid));
    }

    public void removePunishment(@NotNull UUID uuid) {
        this.punishments.remove(uuid);
    }

    public void addPunishment(@NotNull Punishment punishment) {
        this.punishments.put(punishment.getId(), punishment);
    }

    public void clearPunishments() {
        this.punishments.clear();
    }

    @NotNull
    public ObjectCollection<Punishment> getPunishments() {
        return ObjectCollections.unmodifiable(this.punishments.values());
    }

    public boolean hasActivePunishment(@NotNull PunishmentType punishmentType) {
        return this.punishments.values().stream().anyMatch(punishment -> {
            return punishment.getType() == punishmentType && punishment.isActive();
        });
    }

    public int getPunishmentCount(@NotNull PunishmentType punishmentType) {
        return (int) this.punishments.values().stream().filter(punishment -> {
            return punishment.getType() == punishmentType;
        }).count();
    }

    public int getActivePunishmentCount(@NotNull PunishmentType punishmentType) {
        return (int) this.punishments.values().stream().filter(punishment -> {
            return punishment.getType() == punishmentType && punishment.isActive();
        }).count();
    }

    @NotNull
    public List<Punishment> getActivePunishments() {
        return (List) this.punishments.values().stream().filter((v0) -> {
            return v0.isActive();
        }).collect(Collectors.toCollection(ObjectArrayList::new));
    }

    public boolean hasCompletedBootcamp() {
        return this.completedBootcamp;
    }

    public void addTimePlayed(int time) {
        this.timePlayed += time;
    }

    public int getTimePlayed() {
        return this.timePlayed;
    }

    public void setTimePlayed(int value) {
        this.timePlayed = value;
    }

    public void setCompletedBootcamp(boolean completed) {
        this.completedBootcamp = completed;
    }

    public int getKills() {
        return this.kills;
    }

    public void setKills(int value) {
        this.kills = value;
    }

    public void addTotalKills(int value) {
        this.kills += value;
    }

    public int getAssists() {
        return this.assists;
    }

    public void setAssists(int value) {
        this.assists = value;
    }

    public void addTotalAssists(int value) {
        this.assists += value;
    }

    public int getBotKills() {
        return this.botKills;
    }

    public void setBotKills(int value) {
        this.botKills = value;
    }

    public void addTotalKillsBots(int value) {
        this.botKills += value;
    }

    public int getInfectedKills() {
        return this.infectedKills;
    }

    public void setInfectedKills(int value) {
        this.infectedKills = value;
    }

    public void addTotalKillsInfected(int value) {
        this.infectedKills += value;
    }

    public int getVehicleKills() {
        return this.vehicleKills;
    }

    public void setVehicleKills(int value) {
        this.vehicleKills = value;
    }

    public void addTotalKillsVehicles(int value) {
        this.vehicleKills += value;
    }

    public int getKillStreak() {
        return this.killStreak;
    }

    public void setKillStreak(int value) {
        this.killStreak = value;
    }

    public int getDeathStreak() {
        return this.deathStreak;
    }

    public void setDeathStreak(int value) {
        this.deathStreak = value;
    }

    public int getInfectedRoundsWon() {
        return this.infectedRoundsWon;
    }

    public void setInfectedRoundsWon(int value) {
        this.infectedRoundsWon = value;
    }

    public void addInfectedRoundsWon(int value) {
        this.infectedRoundsWon += value;
    }

    public int getInfectedMatchesWon() {
        return this.infectedMatchesWon;
    }

    public void setInfectedMatchesWon(int value) {
        this.infectedMatchesWon = value;
    }

    public void addInfectedMatchesWon(int value) {
        this.infectedMatchesWon += value;
    }

    public int getDeaths() {
        return this.deaths;
    }

    public void setDeaths(int value) {
        this.deaths = value;
    }

    public void addTotalDeaths(int value) {
        this.deaths += value;
    }

    public int getBackStabs() {
        return this.backStabs;
    }

    public void setBackStabs(int value) {
        this.backStabs = value;
    }

    public void addBackStabs(int value) {
        this.backStabs += value;
    }

    public int getHeadShots() {
        return this.headShots;
    }

    public void setHeadShots(int value) {
        this.headShots = value;
    }

    public void addHeadshots(int value) {
        this.headShots += value;
    }

    public int getNoScopes() {
        return this.noScopes;
    }

    public void setNoScopes(int value) {
        this.noScopes = value;
    }

    public void addNoScopes(int value) {
        this.noScopes += value;
    }

    public int getFirstBloods() {
        return this.firstBloods;
    }

    public void setFirstBloods(int value) {
        this.firstBloods = value;
    }

    public void addStatFirstBloods(int value) {
        this.firstBloods += value;
    }

    public int getFireKills() {
        return this.fireKills;
    }

    public void setFireKills(int value) {
        this.fireKills = value;
    }

    public void addFireKills(int value) {
        this.fireKills += value;
    }

    @OverridingMethodsMustInvokeSuper
    public void read(@NotNull PlayerDataContext context, @NotNull ByteBuf byteBuffer) throws IOException {
        PlayerDataContext.PlayerDataContextType contextType = context.type();
        setUsername(IPacket.readString(byteBuffer));
        setExp(byteBuffer.readInt());
        setTrophies(byteBuffer.readInt());
        setPrestigeLevel(byteBuffer.readInt());
        setMatchKarma(byteBuffer.readInt());
        setTotalGames(byteBuffer.readInt());
        setTimePlayed(byteBuffer.readInt());
        setCompletedBootcamp(IPacket.readBoolean(byteBuffer));
        setKills(byteBuffer.readInt());
        setAssists(byteBuffer.readInt());
        setDeaths(byteBuffer.readInt());
        setBackStabs(byteBuffer.readInt());
        setCasesOpened(byteBuffer.readInt());
        setKillStreak(byteBuffer.readInt());
        setDeathStreak(byteBuffer.readInt());
        setInfectedRoundsWon(byteBuffer.readInt());
        setInfectedMatchesWon(byteBuffer.readInt());
        setBotKills(byteBuffer.readInt());
        setInfectedKills(byteBuffer.readInt());
        setVehicleKills(byteBuffer.readInt());
        setHeadShots(byteBuffer.readInt());
        setFirstBloods(byteBuffer.readInt());
        setFireKills(byteBuffer.readInt());
        setNoScopes(byteBuffer.readInt());
        if (IPacket.readBoolean(byteBuffer)) {
            setClanId(IPacket.readUUID(byteBuffer));
        }
        readAchievements(byteBuffer);
        readClasses(byteBuffer);
        readGroup(byteBuffer);
        if (context.isSelf()) {
            readParty(byteBuffer);
        }
        if (contextType == PlayerDataContext.PlayerDataContextType.SERVER_REQUEST || context.isSelf()) {
            readPunishments(byteBuffer);
        }
    }

    private void readGroup(@NotNull ByteBuf byteBuffer) {
        if (!IPacket.readBoolean(byteBuffer)) {
            setGroup(null);
        } else {
            setGroup(new PlayerGroup(byteBuffer));
        }
    }

    private void readParty(@NotNull ByteBuf byteBuffer) throws IOException {
        if (!IPacket.readBoolean(byteBuffer)) {
            setParty(null);
        } else {
            setParty(MatchParty.readMatchParty(byteBuffer));
        }
    }

    private void readAchievements(@NotNull ByteBuf byteBuffer) {
        this.achievements.clear();
        int achievementsSize = byteBuffer.readInt();
        for (int i = 0; i < achievementsSize; i++) {
            this.achievements.add(byteBuffer.readInt());
        }
    }

    private void readClasses(@NotNull ByteBuf byteBuffer) {
        this.classExp.clear();
        int classSize = byteBuffer.readInt();
        for (int i = 0; i < classSize; i++) {
            int classId = byteBuffer.readInt();
            int exp = byteBuffer.readInt();
            this.classExp.put(classId, exp);
        }
    }

    private void readPunishments(@NotNull ByteBuf byteBuffer) throws IOException {
        this.punishments.clear();
        int punishmentsSize = byteBuffer.readInt();
        for (int i = 0; i < punishmentsSize; i++) {
            Punishment punishment = new Punishment(byteBuffer);
            this.punishments.put(punishment.getId(), punishment);
        }
    }

    @OverridingMethodsMustInvokeSuper
    public void write(@NotNull PlayerDataContext context, @NotNull ByteBuf byteBuffer) throws IOException {
        PlayerDataContext.PlayerDataContextType contextType = context.type();
        IPacket.writeString(byteBuffer, this.username);
        byteBuffer.writeInt(this.exp);
        byteBuffer.writeInt(this.trophies);
        byteBuffer.writeInt(this.prestigeLevel);
        byteBuffer.writeInt(this.matchKarma);
        byteBuffer.writeInt(this.totalGames);
        byteBuffer.writeInt(this.timePlayed);
        IPacket.writeBoolean(byteBuffer, this.completedBootcamp);
        byteBuffer.writeInt(this.kills);
        byteBuffer.writeInt(this.assists);
        byteBuffer.writeInt(this.deaths);
        byteBuffer.writeInt(this.backStabs);
        byteBuffer.writeInt(this.casesOpened);
        byteBuffer.writeInt(this.killStreak);
        byteBuffer.writeInt(this.deathStreak);
        byteBuffer.writeInt(this.infectedRoundsWon);
        byteBuffer.writeInt(this.infectedMatchesWon);
        byteBuffer.writeInt(this.botKills);
        byteBuffer.writeInt(this.infectedKills);
        byteBuffer.writeInt(this.vehicleKills);
        byteBuffer.writeInt(this.headShots);
        byteBuffer.writeInt(this.firstBloods);
        byteBuffer.writeInt(this.fireKills);
        byteBuffer.writeInt(this.noScopes);
        IPacket.writeBoolean(byteBuffer, this.clanId != null);
        if (this.clanId != null) {
            IPacket.writeUUID(byteBuffer, this.clanId);
        }
        writeAchievements(byteBuffer);
        writeClasses(byteBuffer);
        writeGroup(byteBuffer);
        if (context.isSelf()) {
            writeParty(byteBuffer);
        }
        if (contextType == PlayerDataContext.PlayerDataContextType.SERVER_REQUEST || context.isSelf()) {
            boolean redactIssuer = contextType == PlayerDataContext.PlayerDataContextType.PLAYER_REQUEST;
            writePunishments(byteBuffer, redactIssuer);
        }
    }

    private void writeGroup(@NotNull ByteBuf byteBuffer) throws IOException {
        Optional<PlayerGroup> groupOptional = getGroup();
        if (groupOptional.isPresent()) {
            IPacket.writeBoolean(byteBuffer, true);
            PlayerGroup group = groupOptional.get();
            group.encode(byteBuffer);
            return;
        }
        IPacket.writeBoolean(byteBuffer, false);
    }

    private void writeAchievements(@NotNull ByteBuf byteBuffer) {
        byteBuffer.writeInt(this.achievements.size());
        IntIterator it = this.achievements.iterator();
        while (it.hasNext()) {
            Integer achievement = (Integer) it.next();
            byteBuffer.writeInt(achievement.intValue());
        }
    }

    private void writeParty(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeBoolean(byteBuffer, this.party != null);
        if (this.party != null) {
            this.party.encode(byteBuffer);
        }
    }

    private void writeClasses(@NotNull ByteBuf byteBuffer) {
        byteBuffer.writeInt(this.classExp.size());
        ObjectIterator it = this.classExp.int2IntEntrySet().iterator();
        while (it.hasNext()) {
            Int2IntMap.Entry c = (Int2IntMap.Entry) it.next();
            byteBuffer.writeInt(c.getIntKey());
            byteBuffer.writeInt(c.getIntValue());
        }
    }

    @Nullable
    public UUID getClanId() {
        return this.clanId;
    }

    public void setClanId(@Nullable UUID clanId) {
        this.clanId = clanId;
    }

    private void writePunishments(@NotNull ByteBuf byteBuffer, boolean redactIssuer) throws IOException {
        byteBuffer.writeInt(this.punishments.size());
        ObjectIterator it = this.punishments.values().iterator();
        while (it.hasNext()) {
            Punishment punishment = (Punishment) it.next();
            punishment.write(byteBuffer, redactIssuer);
        }
    }

    public boolean canPrestige() {
        return getRank() == PlayerRank.GENERAL && getPrestigeLevel() < 5;
    }
}
