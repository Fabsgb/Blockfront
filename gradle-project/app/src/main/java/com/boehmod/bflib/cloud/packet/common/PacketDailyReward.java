package com.boehmod.bflib.cloud.packet.common;

import com.boehmod.bflib.cloud.common.reward.RewardRegistry;
import com.boehmod.bflib.cloud.common.reward.RewardType;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/common/PacketDailyReward.class */
public final class PacketDailyReward extends Record implements IPacket {
    private final int streak;
    private final boolean graced;

    @NotNull
    private final ObjectList<RewardType> rewards;

    @NotNull
    public static final PacketIdentifier ID = new PacketIdentifier("PacketDailyReward");

    public PacketDailyReward(int streak, boolean graced, @NotNull ObjectList<RewardType> rewards) {
        this.streak = streak;
        this.graced = graced;
        this.rewards = rewards;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PacketDailyReward.class), PacketDailyReward.class, "streak;graced;rewards", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketDailyReward;->streak:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketDailyReward;->graced:Z", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketDailyReward;->rewards:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PacketDailyReward.class), PacketDailyReward.class, "streak;graced;rewards", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketDailyReward;->streak:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketDailyReward;->graced:Z", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketDailyReward;->rewards:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PacketDailyReward.class, Object.class), PacketDailyReward.class, "streak;graced;rewards", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketDailyReward;->streak:I", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketDailyReward;->graced:Z", "FIELD:Lcom/boehmod/bflib/cloud/packet/common/PacketDailyReward;->rewards:Lit/unimi/dsi/fastutil/objects/ObjectList;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public int streak() {
        return this.streak;
    }

    public boolean graced() {
        return this.graced;
    }

    @NotNull
    public ObjectList<RewardType> rewards() {
        return this.rewards;
    }

    public PacketDailyReward(@NotNull ByteBuf byteBuffer) throws IOException {
        this(byteBuffer.readInt(), byteBuffer.readBoolean(), RewardRegistry.readRewardTypeList(byteBuffer));
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    public void writePacketToBuffer(@NotNull ByteBuf byteBuffer) throws IOException {
        byteBuffer.writeInt(this.streak);
        byteBuffer.writeBoolean(this.graced);
        RewardRegistry.writeRewardTypeList(byteBuffer, this.rewards);
    }

    @Override // com.boehmod.bflib.cloud.packet.IPacket
    @NotNull
    public PacketIdentifier getPacketIdentifier() {
        return ID;
    }
}
