package com.boehmod.bflib.cloud.common.player.challenge;

import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/challenge/Challenge.class */
public abstract class Challenge {
    public abstract boolean isCompleted();

    public abstract void writeChallenge(@NotNull ByteBuf byteBuf) throws IOException;

    public abstract void writeChallenge(@NotNull JsonObject jsonObject);

    public abstract boolean updateChallenge(@NotNull String str, int i, @NotNull ChallengeContext challengeContext);

    public abstract int getExpReward();

    public Challenge() {
    }

    Challenge(@NotNull ByteBuf byteBuf) throws IOException {
    }

    Challenge(@NotNull JsonObject jsonObject) {
    }
}
