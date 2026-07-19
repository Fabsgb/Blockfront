package com.boehmod.bflib.cloud.common.player.challenge;

import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/challenge/ItemKillChallenge.class */
public class ItemKillChallenge extends Challenge {
    public static final PacketIdentifier ID = new PacketIdentifier("ItemKillChallenge");

    @NotNull
    private final CloudResourceLocation item;
    private final int amountRequired;
    private int amount;

    public ItemKillChallenge(@NotNull ByteBuf byteBuffer) {
        this(CloudResourceLocation.readFromByteBuffer(byteBuffer), byteBuffer.readInt(), byteBuffer.readInt());
    }

    public ItemKillChallenge(@NotNull JsonObject jsonObject) {
        this(CloudResourceLocation.readFromJson(jsonObject), jsonObject.get("amountRequired").getAsInt(), jsonObject.get("amount").getAsInt());
    }

    public ItemKillChallenge(@NotNull CloudResourceLocation item, int amountRequired, int amount) {
        this.item = item;
        this.amountRequired = amountRequired;
        this.amount = amount;
    }

    public ItemKillChallenge(@NotNull CloudResourceLocation item, int amountRequired) {
        this(item, amountRequired, 0);
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getAmountRequired() {
        return this.amountRequired;
    }

    public CloudResourceLocation getItem() {
        return this.item;
    }

    @Override // com.boehmod.bflib.cloud.common.player.challenge.Challenge
    public boolean isCompleted() {
        return this.amount >= this.amountRequired;
    }

    @Override // com.boehmod.bflib.cloud.common.player.challenge.Challenge
    public void writeChallenge(@NotNull ByteBuf byteBuffer) {
        this.item.writeToByteBuffer(byteBuffer);
        byteBuffer.writeInt(this.amountRequired);
        byteBuffer.writeInt(this.amount);
    }

    @Override // com.boehmod.bflib.cloud.common.player.challenge.Challenge
    public void writeChallenge(@NotNull JsonObject jsonObject) {
        this.item.writeToJson(jsonObject);
        jsonObject.addProperty("amountRequired", Integer.valueOf(this.amountRequired));
        jsonObject.addProperty("amount", Integer.valueOf(this.amount));
    }

    @Override // com.boehmod.bflib.cloud.common.player.challenge.Challenge
    public boolean updateChallenge(@NotNull String value, int amount, @NotNull ChallengeContext context) {
        CloudResourceLocation contextItem;
        if (!value.equals("kills") || (contextItem = context.item()) == null || !contextItem.equals(this.item)) {
            return false;
        }
        this.amount += amount;
        return true;
    }

    @Override // com.boehmod.bflib.cloud.common.player.challenge.Challenge
    public int getExpReward() {
        return 20 * this.amountRequired;
    }
}
