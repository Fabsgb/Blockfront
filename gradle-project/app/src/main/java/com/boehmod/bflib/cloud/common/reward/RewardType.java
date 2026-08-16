package com.boehmod.bflib.cloud.common.reward;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/reward/RewardType.class */
public abstract class RewardType {
    public abstract void write(@NotNull ByteBuf byteBuf) throws IOException;

    @NotNull
    public abstract String getDescription();

    public RewardType() {
    }

    public RewardType(@NotNull ByteBuf byteBuffer) throws IOException {
    }
}
