package com.boehmod.bflib.cloud.common.player.challenge;

import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/challenge/KillCountChallenge.class */
public class KillCountChallenge extends Challenge {

    /* JADX INFO: renamed from: ID */
    public static final PacketIdentifier f16ID = new PacketIdentifier("KillCountChallenge");
    private final int amountRequired;
    private int amount;

    public KillCountChallenge(int amountRequired, int amount) {
        this.amountRequired = amountRequired;
        this.amount = amount;
    }

    public KillCountChallenge(int amountRequired) {
        this(amountRequired, 0);
    }

    public KillCountChallenge(@NotNull ByteBuf byteBuffer) throws IOException {
        this(byteBuffer.readInt(), byteBuffer.readInt());
    }

    public KillCountChallenge(@NotNull JsonObject jsonObject) {
        this(jsonObject.get("amountRequired").getAsInt(), jsonObject.get("amount").getAsInt());
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

    @Override // com.boehmod.bflib.cloud.common.player.challenge.Challenge
    public boolean isCompleted() {
        return this.amount >= this.amountRequired;
    }

    @Override // com.boehmod.bflib.cloud.common.player.challenge.Challenge
    public void writeChallenge(@NotNull ByteBuf byteBuffer) throws IOException {
        byteBuffer.writeInt(this.amountRequired);
        byteBuffer.writeInt(this.amount);
    }

    @Override // com.boehmod.bflib.cloud.common.player.challenge.Challenge
    public void writeChallenge(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty("amountRequired", Integer.valueOf(this.amountRequired));
        jsonObject.addProperty("amount", Integer.valueOf(this.amount));
    }

    @Override // com.boehmod.bflib.cloud.common.player.challenge.Challenge
    public boolean updateChallenge(@NotNull String value, int amount, @NotNull ChallengeContext context) {
        if (!value.equals("kills")) {
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
