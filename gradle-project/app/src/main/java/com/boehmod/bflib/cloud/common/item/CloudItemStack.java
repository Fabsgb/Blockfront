package com.boehmod.bflib.cloud.common.item;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/CloudItemStack.class */
public class CloudItemStack {

    @NotNull
    private UUID uuid;
    private int itemID;
    private double mint;

    @NotNull
    private JsonObject metaData;

    @Nullable
    private CloudItem<?> cloudItem;

    public CloudItemStack(int itemID) {
        this(UUID.randomUUID(), itemID);
    }

    public CloudItemStack(@NotNull ByteBuf byteBuffer) throws IOException {
        this.metaData = new JsonObject();
        read(byteBuffer);
    }

    public CloudItemStack(@NotNull UUID uuid, int itemID) {
        this.metaData = new JsonObject();
        this.uuid = uuid;
        this.itemID = itemID;
        this.mint = mintStack(ThreadLocalRandom.current());
    }

    public CloudItemStack(@NotNull UUID uuid, int itemID, double mint) {
        this.metaData = new JsonObject();
        this.uuid = uuid;
        this.itemID = itemID;
        this.mint = mint;
    }

    public CloudItemStack(@NotNull CloudItem<?> cloudItem) {
        this.metaData = new JsonObject();
        this.uuid = UUID.randomUUID();
        this.itemID = cloudItem.getId();
        this.mint = mintStack(ThreadLocalRandom.current());
    }

    @NotNull
    public String getDisplayName(@NotNull CloudRegistry cloudRegistry) {
        return getDisplayName(cloudRegistry, false);
    }

    @NotNull
    public String getDisplayName(@NotNull CloudRegistry cloudRegistry, boolean reversed) {
        CloudItem<?> cloudItem = getCloudItem(cloudRegistry);
        return cloudItem == null ? "Unknown" : cloudItem.getDisplayName(reversed);
    }

    @Nullable
    public CloudItem<?> getCloudItem(@NotNull CloudRegistry cloudRegistry) {
        if (this.cloudItem != null) {
            return this.cloudItem;
        }
        CloudItem<?> item = cloudRegistry.getItem(this.itemID);
        this.cloudItem = item;
        return item;
    }

    @NotNull
    public UUID getUUID() {
        return this.uuid;
    }

    public int getItemId() {
        return this.itemID;
    }

    public void read(@NotNull ByteBuf byteBuffer) throws IOException {
        this.itemID = byteBuffer.readInt();
        this.uuid = IPacket.readUUID(byteBuffer);
        this.mint = byteBuffer.readDouble();
        String metaJson = IPacket.readString(byteBuffer);
        this.metaData = metaJson.isEmpty() ? new JsonObject() : JsonParser.parseString(metaJson).getAsJsonObject();
    }

    public void write(@NotNull ByteBuf byteBuffer) throws IOException {
        byteBuffer.writeInt(this.itemID);
        IPacket.writeUUID(byteBuffer, this.uuid);
        byteBuffer.writeDouble(this.mint);
        IPacket.writeString(byteBuffer, this.metaData.toString());
    }

    public void clearSticker(int index) {
        this.metaData.remove("sticker" + index);
    }

    public boolean hasSticker(int index) {
        return getSticker(index) != -1;
    }

    public void setSticker(int index, @NotNull CloudItem<?> sticker) {
        setSticker(index, sticker.getId());
    }

    public void setSticker(int index, int stickerId) {
        this.metaData.addProperty("sticker" + index, Integer.valueOf(stickerId));
    }

    public int getSticker(int index) {
        String key = "sticker" + index;
        if (this.metaData.has(key)) {
            return this.metaData.get(key).getAsInt();
        }
        return -1;
    }

    public double getMint() {
        return this.mint;
    }

    public void setMint(double mint) {
        this.mint = mint;
    }

    public static double mintStack(@Nonnull Random random) {
        return Math.sqrt(random.nextDouble());
    }

    @NotNull
    public JsonObject getMetaData() {
        return this.metaData;
    }

    @NotNull
    public CloudItemStack copy() {
        CloudItemStack cloudItemStack = new CloudItemStack(this.uuid, this.itemID);
        cloudItemStack.mint = this.mint;
        cloudItemStack.metaData = this.metaData.deepCopy();
        return cloudItemStack;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CloudItemStack)) {
            return false;
        }
        CloudItemStack itemStack = (CloudItemStack) obj;
        return itemStack.uuid.equals(this.uuid);
    }
}
