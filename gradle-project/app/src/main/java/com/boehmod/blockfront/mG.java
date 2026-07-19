package com.boehmod.blockfront;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mG.class */
public enum mG {
    CAUCASIAN("caucasian"),
    BLACK("black"),
    ASIAN("asian");

    private final String skin;

    mG(@NotNull String str) {
        this.skin = str;
    }

    public String getSkin() {
        return this.skin;
    }
}
