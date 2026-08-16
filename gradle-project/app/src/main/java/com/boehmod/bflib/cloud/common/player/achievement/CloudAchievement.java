package com.boehmod.bflib.cloud.common.player.achievement;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/achievement/CloudAchievement.class */
public class CloudAchievement {

    /* JADX INFO: renamed from: id */
    private final int f13id;

    @NotNull
    private final String translationKey;
    private boolean hasReward = false;

    public CloudAchievement(int id, @NotNull String translationKey) {
        this.f13id = id;
        this.translationKey = translationKey;
        if (CloudAchievements.ACHIEVEMENTS.containsKey(id)) {
            throw new IllegalArgumentException("Cloud achievement with ID " + id + " already exists!");
        }
        CloudAchievements.ACHIEVEMENTS.put(id, this);
    }

    public int getId() {
        return this.f13id;
    }

    @NotNull
    public String getTranslationKey() {
        return this.translationKey;
    }

    @NotNull
    public String getNameKey() {
        return this.translationKey + ".name";
    }

    @NotNull
    public String getDescriptionKey() {
        return this.translationKey + ".desc";
    }

    public boolean hasReward() {
        return this.hasReward;
    }

    @NotNull
    public CloudAchievement disableReward() {
        this.hasReward = false;
        return this;
    }
}
