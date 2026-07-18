package com.boehmod.bflib.cloud.common.player.achievement;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.blockfront.C0203dE;
import com.boehmod.blockfront.C0357g;
import com.boehmod.blockfront.C0942rB;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectRBTreeMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/achievement/CloudAchievements.class */
public class CloudAchievements {

    @NotNull
    static final Int2ObjectMap<CloudAchievement> ACHIEVEMENTS = new Int2ObjectRBTreeMap();
    public static final CloudAchievement ACH_STATS_HEADSHOT_10 = new CloudAchievement(0, "bf.achievement.headshot_10");
    public static final CloudAchievement ACH_STATS_HEADSHOT_30 = new CloudAchievement(1, "bf.achievement.headshot_30");
    public static final CloudAchievement ACH_STATS_HEADSHOT_60 = new CloudAchievement(2, "bf.achievement.headshot_60");
    public static final CloudAchievement ACH_STATS_HEADSHOT_100 = new CloudAchievement(3, "bf.achievement.headshot_100");
    public static final CloudAchievement ACH_STATS_KILLS_20 = new CloudAchievement(20, "bf.achievement.kills_20");
    public static final CloudAchievement ACH_STATS_KILLS_50 = new CloudAchievement(21, "bf.achievement.kills_50");
    public static final CloudAchievement ACH_STATS_KILLS_100 = new CloudAchievement(22, "bf.achievement.kills_100");
    public static final CloudAchievement ACH_STATS_KILLS_300 = new CloudAchievement(23, "bf.achievement.kills_300");
    public static final CloudAchievement ACH_STATS_KILLS_800 = new CloudAchievement(24, "bf.achievement.kills_800");
    public static final CloudAchievement ACH_STATS_DEATHS_20 = new CloudAchievement(30, "bf.achievement.deaths_20");
    public static final CloudAchievement ACH_STATS_DEATHS_50 = new CloudAchievement(31, "bf.achievement.deaths_50");
    public static final CloudAchievement ACH_STATS_DEATHS_100 = new CloudAchievement(32, "bf.achievement.deaths_100");
    public static final CloudAchievement ACH_STATS_DEATHS_300 = new CloudAchievement(33, "bf.achievement.deaths_300");
    public static final CloudAchievement ACH_STATS_DEATHS_800 = new CloudAchievement(34, "bf.achievement.deaths_800");
    public static final CloudAchievement ACH_MATCH_WIN_TDM = new CloudAchievement(40, "bf.achievement.win_tdm");
    public static final CloudAchievement ACH_MATCH_WIN_DOM = new CloudAchievement(41, "bf.achievement.win_dom");
    public static final CloudAchievement ACH_MATCH_WIN_FFA = new CloudAchievement(42, "bf.achievement.win_ffa");
    public static final CloudAchievement ACH_MATCH_WIN_GG = new CloudAchievement(43, "bf.achievement.win_gg");
    public static final CloudAchievement ACH_MATCH_WIN_OF = new CloudAchievement(44, "bf.achievement.win_of");
    public static final CloudAchievement ACH_MATCH_WIN_INF = new CloudAchievement(45, "bf.achievement.win_inf");
    public static final CloudAchievement ACH_USER_PRESTIGE_1 = new CloudAchievement(50, "bf.achievement.prestige_1");
    public static final CloudAchievement ACH_USER_PRESTIGE_MAX = new CloudAchievement(51, "bf.achievement.prestige_max");
    public static final CloudAchievement ACH_USER_RAGEQUIT = new CloudAchievement(80, "bf.achievement.ragequit").disableReward();
    public static final CloudAchievement ACH_USER_BOOTCAMP = new CloudAchievement(81, "bf.achievement.bootcamp").disableReward();
    public static final CloudAchievement ACH_USER_SHOT_THE_SHERIFF = new CloudAchievement(82, "bf.achievement.shot_the_sheriff").disableReward();
    public static final CloudAchievement ACH_USER_SWITCH_TEAM = new CloudAchievement(83, "bf.achievement.switch_team").disableReward();
    public static final CloudAchievement ACH_USER_SHOOT_GRENADE = new CloudAchievement(84, "bf.achievement.shoot_grenade").disableReward();
    public static final CloudAchievement ACH_USER_END_STREAK = new CloudAchievement(85, "bf.achievement.end_streak").disableReward();
    public static final CloudAchievement ACH_USER_END_STREAK_SELF = new CloudAchievement(86, "bf.achievement.end_streak_self").disableReward();
    public static final CloudAchievement ACH_USER_LOSE_STREAK = new CloudAchievement(87, "bf.achievement.lose_streak").disableReward();
    public static final CloudAchievement ACH_STATS_INFECTED_KILLS_FIRST = new CloudAchievement(100, "bf.achievement.infected_kills_1");
    public static final CloudAchievement ACH_STATS_INFECTED_KILLS_50 = new CloudAchievement(101, "bf.achievement.infected_kills_50");
    public static final CloudAchievement ACH_STATS_INFECTED_KILLS_100 = new CloudAchievement(102, "bf.achievement.infected_kills_100");
    public static final CloudAchievement ACH_STATS_INFECTED_KILLS_500 = new CloudAchievement(103, "bf.achievement.infected_kills_500");
    public static final CloudAchievement ACH_STATS_INFECTED_KILLS_1000 = new CloudAchievement(104, "bf.achievement.infected_kills_1000");
    public static final CloudAchievement ACH_STATS_INFECTED_KILLS_5000 = new CloudAchievement(105, "bf.achievement.infected_kills_5000");
    public static final CloudAchievement ACH_STATS_ASSISTS_1 = new CloudAchievement(C0357g.f2439g, "bf.achievement.assists_1");
    public static final CloudAchievement ACH_STATS_ASSISTS_20 = new CloudAchievement(121, "bf.achievement.assists_20");
    public static final CloudAchievement ACH_STATS_ASSISTS_50 = new CloudAchievement(122, "bf.achievement.assists_50");
    public static final CloudAchievement ACH_STATS_ASSISTS_100 = new CloudAchievement(123, "bf.achievement.assists_100");
    public static final CloudAchievement ACH_STATS_ASSISTS_200 = new CloudAchievement(124, "bf.achievement.assists_200");
    public static final CloudAchievement ACH_STATS_ASSISTS_500 = new CloudAchievement(125, "bf.achievement.assists_500");
    public static final CloudAchievement ACH_STATS_ASSISTS_1000 = new CloudAchievement(126, "bf.achievement.assists_1000");
    public static final CloudAchievement ACH_STATS_BACKSTABS_20 = new CloudAchievement(130, "bf.achievement.backstabs_20");
    public static final CloudAchievement ACH_STATS_BACKSTABS_50 = new CloudAchievement(131, "bf.achievement.backstabs_50");
    public static final CloudAchievement ACH_STATS_BACKSTABS_100 = new CloudAchievement(132, "bf.achievement.backstabs_100");
    public static final CloudAchievement ACH_STATS_BACKSTABS_300 = new CloudAchievement(C0203dE.f1640gN, "bf.achievement.backstabs_300");
    public static final CloudAchievement ACH_STATS_BACKSTABS_800 = new CloudAchievement(134, "bf.achievement.backstabs_800");
    public static final CloudAchievement ACH_STATS_NOSCOPES_20 = new CloudAchievement(140, "bf.achievement.noscopes_20");
    public static final CloudAchievement ACH_STATS_NOSCOPES_50 = new CloudAchievement(141, "bf.achievement.noscopes_50");
    public static final CloudAchievement ACH_STATS_NOSCOPES_100 = new CloudAchievement(142, "bf.achievement.noscopes_100");
    public static final CloudAchievement ACH_STATS_NOSCOPES_200 = new CloudAchievement(143, "bf.achievement.noscopes_200");
    public static final CloudAchievement ACH_STATS_NOSCOPES_500 = new CloudAchievement(144, "bf.achievement.noscopes_500");
    public static final CloudAchievement ACH_CLAN_CREATE_FIRST = new CloudAchievement(200, "bf.achievement.clan_create");
    public static final CloudAchievement ACH_CLAN_FIRST_MEMBER = new CloudAchievement(201, "bf.achievement.clan_first_member");
    public static final CloudAchievement ACH_CLAN_FULL = new CloudAchievement(202, "bf.achievement.clan_full");
    public static final CloudAchievement ACH_CLAN_KICK_MEMBER = new CloudAchievement(203, "bf.achievement.clan_kick");
    public static final CloudAchievement ACH_STATS_FIRE_KILLS_1 = new CloudAchievement(400, "bf.achievement.fire_kills_1");
    public static final CloudAchievement ACH_STATS_FIRE_KILLS_10 = new CloudAchievement(401, "bf.achievement.fire_kills_10");
    public static final CloudAchievement ACH_STATS_FIRE_KILLS_30 = new CloudAchievement(402, "bf.achievement.fire_kills_30");
    public static final CloudAchievement ACH_STATS_FIRE_KILLS_60 = new CloudAchievement(403, "bf.achievement.fire_kills_60");
    public static final CloudAchievement ACH_STATS_FIRE_KILLS_100 = new CloudAchievement(404, "bf.achievement.fire_kills_100");
    public static final CloudAchievement ACH_STATS_FIRE_KILLS_300 = new CloudAchievement(405, "bf.achievement.fire_kills_300");
    public static final CloudAchievement ACH_USER_STREAK_3 = new CloudAchievement(C0942rB.f5014pJ, "bf.achievement.streak_3").disableReward();
    public static final CloudAchievement ACH_USER_STREAK_7 = new CloudAchievement(501, "bf.achievement.streak_7").disableReward();
    public static final CloudAchievement ACH_USER_STREAK_14 = new CloudAchievement(502, "bf.achievement.streak_14").disableReward();
    public static final CloudAchievement ACH_USER_STREAK_30 = new CloudAchievement(503, "bf.achievement.streak_30").disableReward();
    public static final CloudAchievement ACH_USER_STREAK_60 = new CloudAchievement(504, "bf.achievement.streak_60").disableReward();
    public static final CloudAchievement ACH_USER_STREAK_100 = new CloudAchievement(505, "bf.achievement.streak_100").disableReward();

    public static void registerAchievements(@NotNull CloudRegistry cloudRegistry) {
        cloudRegistry.registerAchievements(ACHIEVEMENTS.values());
    }
}
