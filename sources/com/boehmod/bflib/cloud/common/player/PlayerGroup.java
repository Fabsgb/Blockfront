package com.boehmod.bflib.cloud.common.player;

import com.boehmod.bflib.cloud.common.GroupRecord;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.common.ColorReferences;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/PlayerGroup.class */
public final class PlayerGroup {

    @NotNull
    private String name;

    @NotNull
    private String tag;
    private int color;
    private long discordRoleId;

    @NotNull
    private ObjectList<String> permissions;

    public PlayerGroup(@NotNull ByteBuf byteBuffer) {
        this.permissions = new ObjectArrayList();
        this.name = IPacket.readString(byteBuffer);
        this.tag = IPacket.readString(byteBuffer);
        this.color = byteBuffer.readInt();
        this.permissions = IPacket.readStringList(byteBuffer);
        this.discordRoleId = byteBuffer.readLong();
    }

    public PlayerGroup(@NotNull GroupRecord groupRecord) {
        this.permissions = new ObjectArrayList();
        this.name = groupRecord.name();
        this.tag = groupRecord.tag();
        this.color = groupRecord.color().isEmpty() ? ColorReferences.COLOR_WHITE : new BigInteger(groupRecord.color().replaceFirst("#", ""), 16).intValue();
        this.discordRoleId = groupRecord.discordRoleId();
    }

    public void setPermissions(@NotNull List<String> permissions) {
        this.permissions.clear();
        this.permissions.addAll(permissions);
    }

    public void encode(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeString(byteBuffer, this.name);
        IPacket.writeString(byteBuffer, this.tag);
        byteBuffer.writeInt(this.color);
        IPacket.writeStringList(byteBuffer, this.permissions);
        byteBuffer.writeLong(this.discordRoleId);
    }

    public void process(@NotNull String key, @NotNull String value) {
        switch (key) {
            case "color":
                this.color = value.isEmpty() ? ColorReferences.COLOR_WHITE : new BigInteger(value.replaceFirst("#", ""), 16).intValue();
                break;
            case "tag":
                this.tag = value;
                break;
            case "perm":
                this.permissions.add(value);
                break;
            case "discord_role_id":
                this.discordRoleId = Long.parseLong(value);
                break;
        }
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getTag() {
        return this.tag;
    }

    public int getColor() {
        return this.color;
    }

    public long getDiscordRoleId() {
        return this.discordRoleId;
    }

    public boolean hasPermission(@NotNull String permission) {
        return this.permissions.contains(permission) || this.permissions.contains("*");
    }

    @NotNull
    public List<String> getPermissions() {
        return Collections.unmodifiableList(this.permissions);
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }
}
