package com.boehmod.bflib.cloud.common.reward;

import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/reward/ItemRewardType.class */
public class ItemRewardType extends AbstractItemRewardType {

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("ItemRewardType");
    private final int itemId;

    public ItemRewardType(int itemId) {
        this.itemId = itemId;
    }

    public ItemRewardType(@NotNull ByteBuf byteBuffer) throws IOException {
        super(byteBuffer);
        this.itemId = byteBuffer.readInt();
    }

    public int getItemId() {
        return this.itemId;
    }

    @Override // com.boehmod.bflib.cloud.common.reward.RewardType
    public void write(@NotNull ByteBuf byteBuffer) throws IOException {
        writeGrantedStack(byteBuffer);
        byteBuffer.writeInt(this.itemId);
    }

    @Override // com.boehmod.bflib.cloud.common.reward.RewardType
    @NotNull
    public String getDescription() {
        return "Item #" + this.itemId;
    }
}
