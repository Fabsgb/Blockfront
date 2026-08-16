package com.boehmod.bflib.cloud.common.player.challenge;

import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/challenge/WeaponTypeKillChallenge.class */
public class WeaponTypeKillChallenge extends Challenge {

    /* JADX INFO: renamed from: ID */
    public static final PacketIdentifier f18ID = new PacketIdentifier("WeaponTypeKillChallenge");

    @NotNull
    private final GunType gunType;
    private final int amountRequired;
    private int amount;

    public WeaponTypeKillChallenge(@NotNull ByteBuf byteBuffer) {
        this(GunType.values()[byteBuffer.readInt()], byteBuffer.readInt(), byteBuffer.readInt());
    }

    public WeaponTypeKillChallenge(@NotNull JsonObject jsonObject) {
        this(GunType.values()[jsonObject.get("gunType").getAsInt()], jsonObject.get("amountRequired").getAsInt(), jsonObject.get("amount").getAsInt());
    }

    public WeaponTypeKillChallenge(@NotNull GunType gunType, int amountRequired, int amount) {
        this.gunType = gunType;
        this.amountRequired = amountRequired;
        this.amount = amount;
    }

    public WeaponTypeKillChallenge(@NotNull GunType gunType, int amountRequired) {
        this(gunType, amountRequired, 0);
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

    @NotNull
    public GunType getGunType() {
        return this.gunType;
    }

    @Override // com.boehmod.bflib.cloud.common.player.challenge.Challenge
    public boolean isCompleted() {
        return this.amount >= this.amountRequired;
    }

    @Override // com.boehmod.bflib.cloud.common.player.challenge.Challenge
    public void writeChallenge(@NotNull ByteBuf byteBuffer) {
        byteBuffer.writeInt(this.gunType.ordinal());
        byteBuffer.writeInt(this.amountRequired);
        byteBuffer.writeInt(this.amount);
    }

    @Override // com.boehmod.bflib.cloud.common.player.challenge.Challenge
    public void writeChallenge(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty("gunType", Integer.valueOf(this.gunType.ordinal()));
        jsonObject.addProperty("amountRequired", Integer.valueOf(this.amountRequired));
        jsonObject.addProperty("amount", Integer.valueOf(this.amount));
    }

    @Override // com.boehmod.bflib.cloud.common.player.challenge.Challenge
    public boolean updateChallenge(@NotNull String value, int amount, @NotNull ChallengeContext context) {
        if (!value.equals("kills")) {
            return false;
        }
        GunType contextGunType = context.gunType();
        if (contextGunType != this.gunType) {
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
