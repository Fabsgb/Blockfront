package com.boehmod.bflib.cloud.common.p001mm;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/mm/SearchGame.class */
public enum SearchGame {
    BOOT("boot", "Boot Camp"),
    DOMINATION("dom", "Domination"),
    TEAM_DEATHMATCH("tdm", "Team Deathmatch"),
    GUN_GAME("gg", "Gun Game"),
    FREE_FOR_ALL("ffa", "Free For All"),
    OFFENSIVE("of", "Offensive"),
    INFECT("inf", "Infection"),
    SURVIVAL_GAMES("sg", "Survival Games"),
    TROUBLE_TOWN("ttt", "Trouble in Terrorist Town"),
    DEFUSAL("def", "Defusal"),
    MOVIE_STUDIO("mov", "Movie Studio"),
    CAMPAIGN("camp", "Campaign"),
    LOBBY("lob", "Lobby");


    /* JADX INFO: renamed from: id */
    @NotNull
    private final String f3id;

    @NotNull
    private final String displayName;

    SearchGame(String id, String displayName) {
        this.f3id = id;
        this.displayName = displayName;
    }

    @NotNull
    public String getId() {
        return this.f3id;
    }

    @NotNull
    public String getDisplayName() {
        return this.displayName;
    }

    @Nullable
    public static SearchGame fromId(@NotNull String id) {
        for (SearchGame searchGame : values()) {
            if (searchGame.f3id.equals(id)) {
                return searchGame;
            }
        }
        return null;
    }
}
