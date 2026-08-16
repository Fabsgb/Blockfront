package com.boehmod.bflib.cloud.common.reward;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/reward/AbstractItemRewardType.class */
public abstract class AbstractItemRewardType extends RewardType {

    @Nullable
    private CloudItemStack grantedStack;

    public AbstractItemRewardType() {
    }

    public AbstractItemRewardType(@NotNull ByteBuf byteBuffer) throws IOException {
        boolean hasGrantedStack = byteBuffer.readBoolean();
        if (hasGrantedStack) {
            this.grantedStack = new CloudItemStack(byteBuffer);
        }
    }

    @Nullable
    public final CloudItemStack getGrantedStack() {
        return this.grantedStack;
    }

    public final void setGrantedStack(@NotNull CloudItemStack grantedStack) {
        this.grantedStack = grantedStack;
    }

    protected final void writeGrantedStack(@NotNull ByteBuf byteBuffer) throws IOException {
        byteBuffer.writeBoolean(this.grantedStack != null);
        if (this.grantedStack != null) {
            this.grantedStack.write(byteBuffer);
        }
    }
}
