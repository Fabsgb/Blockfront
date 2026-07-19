package com.boehmod.bflib.cloud.common.player;

import foundry.veil.impl.client.render.shader.injection.util.ShaderInjectionDefinition;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectRBTreeMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/PlayerRank.class */
public class PlayerRank {

    @NotNull
    public static final Int2ObjectMap<PlayerRank> PLAYER_RANK_MAP = new Int2ObjectRBTreeMap();
    public static final PlayerRank RECRUIT = new PlayerRank(0, "Recruit", "recruit", 0, 909929889505882132L, 57600);
    public static final PlayerRank PRIVATE = new PlayerRank(1, "Private", "private", 1, 909929962931388486L, 57601);
    public static final PlayerRank PRIVATE_SECOND_CLASS = new PlayerRank(2, "Pvt. 2nd Class", "private_2nd_class", ShaderInjectionDefinition.DEFAULT_PRIORITY, 909929997366599720L, 57602);
    public static final PlayerRank PRIVATE_FIRST_CLASS = new PlayerRank(3, "Pvt. 1st Class", "private_1st_class", 2000, 909930054363017296L, 57603);
    public static final PlayerRank CORPORAL = new PlayerRank(4, "Corporal", "corporal", 3000, 909930111560740895L, 57604);
    public static final PlayerRank SERGEANT = new PlayerRank(5, "Sergeant", "sergeant", 4000, 909930164819992626L, 57605);
    public static final PlayerRank STAFF_SERGEANT = new PlayerRank(6, "Staff Sgt.", "staff_sergeant", 6000, 909930195153207366L, 57606);
    public static final PlayerRank SERGEANT_FIRST_CLASS = new PlayerRank(7, "Sgt. 1st Class", "sergeant_1st_class", 7500, 909930230393757747L, 57607);
    public static final PlayerRank MASTER_SERGEANT = new PlayerRank(8, "Master Sgt.", "master_sergeant", 9000, 909930267450413138L, 57608);
    public static final PlayerRank FIRST_SERGEANT = new PlayerRank(9, "1st Sergeant", "1st_sergeant", 10500, 909930316431515668L, 57609);
    public static final PlayerRank SECOND_LIEUTENANT = new PlayerRank(10, "2nd Lieutenant", "2nd_lieutenant", 12000, 909930359234379777L, 57616);
    public static final PlayerRank FIRST_LIEUTENANT = new PlayerRank(11, "1st Lieutenant", "1st_lieutenant", 14000, 909930400246296598L, 57617);
    public static final PlayerRank CAPTAIN = new PlayerRank(12, "Captain", "captain", 16000, 909930478927216670L, 57618);
    public static final PlayerRank MAJOR = new PlayerRank(13, "Major", "major", 18000, 909930516336234496L, 57619);
    public static final PlayerRank LIEUTENANT_COLONEL = new PlayerRank(14, "Lt. Colonel", "lieutenant_colonel", 20000, 909930549005672488L, 57620);
    public static final PlayerRank COLONEL = new PlayerRank(15, "Colonel", "colonel", 22000, 909930599626723349L, 57621);
    public static final PlayerRank BRIGADIER_GENERAL = new PlayerRank(16, "Bgt. General", "brigadier_general", 24000, 909930648087703572L, 57622);
    public static final PlayerRank MAJOR_GENERAL = new PlayerRank(17, "Maj. General", "major_general", 26000, 909930702202626148L, 57623);
    public static final PlayerRank LIEUTENANT_GENERAL = new PlayerRank(18, "Lt. General", "lieutenant_general", 28000, 909930750864945212L, 57624);
    public static final PlayerRank GENERAL = new PlayerRank(19, "General", "general", 30000, 909930794649276416L, 57625);
    private final int id;

    @NotNull
    private final String title;

    @NotNull
    private final String texture;
    private final int expRequired;
    private final long roleID;
    private final char graphic;

    public PlayerRank(int id, @NotNull String title, @NotNull String texture, int expRequired, long roleID, char graphic) {
        this.id = id;
        this.title = title;
        this.texture = texture;
        this.expRequired = expRequired;
        this.roleID = roleID;
        this.graphic = graphic;
        PLAYER_RANK_MAP.put(id, this);
    }

    @NotNull
    public static PlayerRank getNextRank(int index) {
        return (PlayerRank) PLAYER_RANK_MAP.get(Math.min(PLAYER_RANK_MAP.size() - 1, index + 1));
    }

    @NotNull
    public static PlayerRank getRankFromEXP(int exp) {
        int added = 0;
        int rankSize = PLAYER_RANK_MAP.size();
        for (int i = 0; i < rankSize; i++) {
            PlayerRank rank = (PlayerRank) PLAYER_RANK_MAP.get(i);
            if (rank != null) {
                added += rank.getEXPRequired();
                if (exp < added) {
                    return (PlayerRank) PLAYER_RANK_MAP.get(Math.max(0, i - 1));
                }
            }
        }
        return exp > added ? GENERAL : RECRUIT;
    }

    public static int getExpRequiredForNextRank(@NotNull PlayerRank currentRank) {
        PlayerRank nextRank = getNextRank(currentRank.getID());
        if (nextRank == currentRank) {
            return 0;
        }
        return nextRank.getEXPRequired() - currentRank.getEXPRequired();
    }

    public static float getProgressRequiredForNextRank(@NotNull PlayerRank currentRank, int currentExp) {
        PlayerRank nextRank = getNextRank(currentRank.getID());
        if (nextRank == currentRank) {
            return 1.0f;
        }
        int currentRankTotalExp = getTotalRequiredEXPForRank(currentRank);
        int nextRankTotalExp = getTotalRequiredEXPForRank(nextRank);
        int expRange = nextRankTotalExp - currentRankTotalExp;
        if (expRange == 0) {
            return 1.0f;
        }
        int currentProgressExp = currentExp - currentRankTotalExp;
        return Math.clamp(currentProgressExp / expRange, 0.0f, 1.0f);
    }

    public static int getTotalRequiredEXPForRank(@NotNull PlayerRank rank) {
        return PLAYER_RANK_MAP.values().stream().filter(playerRank -> {
            return playerRank.getID() <= rank.getID();
        }).mapToInt(playerRank2 -> {
            return playerRank2.expRequired;
        }).sum();
    }

    public int getID() {
        return this.id;
    }

    public char getGraphic() {
        return this.graphic;
    }

    public long getRoleId() {
        return this.roleID;
    }

    @NotNull
    public String getTitle() {
        return this.title;
    }

    @NotNull
    public String getTexture() {
        return this.texture;
    }

    public int getEXPRequired() {
        return this.expRequired;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerRank)) {
            return super.equals(obj);
        }
        PlayerRank playerRank = (PlayerRank) obj;
        return playerRank.id == this.id;
    }
}
