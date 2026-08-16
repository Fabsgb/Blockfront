package com.boehmod.bflib.cloud.common.player.challenge;

import javax.annotation.Nonnull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/challenge/GunType.class */
public enum GunType {
    PISTOL,
    SMG,
    CARBINE,
    RIFLE,
    SHOTGUN,
    LMG,
    FLAMETHROWER,
    MG,
    AT,
    ROCKET;

    @Nonnull
    public String translationKey() {
        return "bf.guntype." + name().toLowerCase();
    }
}
