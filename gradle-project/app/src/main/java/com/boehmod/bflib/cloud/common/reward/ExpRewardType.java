package com.boehmod.bflib.cloud.common.reward;

import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/reward/ExpRewardType.class */
public class ExpRewardType extends RewardType {

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f20ID = new PacketIdentifier("ExpRewardType");
    private final int amount;

    public ExpRewardType(int amount) {
        this.amount = amount;
    }

    public ExpRewardType(@NotNull ByteBuf byteBuffer) throws IOException {
        this(byteBuffer.readInt());
    }

    public int getAmount() {
        return this.amount;
    }

    @Override // com.boehmod.bflib.cloud.common.reward.RewardType
    public void write(@NotNull ByteBuf byteBuffer) throws IOException {
        byteBuffer.writeInt(this.amount);
    }

    @Override // com.boehmod.bflib.cloud.common.reward.RewardType
    @NotNull
    public String getDescription() {
        return this.amount + " XP";
    }
}
