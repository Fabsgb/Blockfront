package com.boehmod.bflib.cloud.common.reward;

import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/reward/RandomItemRewardType.class */
public class RandomItemRewardType extends AbstractItemRewardType {

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f22ID = new PacketIdentifier("RandomItemRewardType");

    public RandomItemRewardType() {
    }

    public RandomItemRewardType(@NotNull ByteBuf byteBuffer) throws IOException {
        super(byteBuffer);
    }

    @Override // com.boehmod.bflib.cloud.common.reward.RewardType
    public void write(@NotNull ByteBuf byteBuffer) throws IOException {
        writeGrantedStack(byteBuffer);
    }

    @Override // com.boehmod.bflib.cloud.common.reward.RewardType
    @NotNull
    public String getDescription() {
        return "Random Item";
    }
}
