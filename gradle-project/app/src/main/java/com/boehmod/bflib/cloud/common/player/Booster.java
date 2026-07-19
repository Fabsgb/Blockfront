package com.boehmod.bflib.cloud.common.player;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/Booster.class */
public class Booster {

    @NotNull
    private final BoosterType type;
    private final int maxMinutes;
    private final int multiplier;

    @NotNull
    private final Timestamp dateStarted = Timestamp.from(Instant.now());

    public Booster(@NotNull BoosterType type, int maxMinutes, int multiplier) {
        this.type = type;
        this.maxMinutes = maxMinutes;
        this.multiplier = multiplier;
    }

    @NotNull
    public BoosterType getType() {
        return this.type;
    }

    public int getTimeRemainingInMinutes() {
        return this.maxMinutes - ((int) Duration.between(this.dateStarted.toInstant(), Instant.now()).toMinutes());
    }

    public boolean isActive() {
        return getTimeRemainingInMinutes() > 0;
    }

    public int getMaxMinutes() {
        return this.maxMinutes;
    }

    public int getMultiplier() {
        return this.multiplier;
    }
}
