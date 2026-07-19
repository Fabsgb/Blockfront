package com.boehmod.bflib.cloud.common;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.cloud.packet.PacketRegistry;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/AbstractClanData.class */
public class AbstractClanData {
    public static final int MAX_CLAN_INVITES = 10;

    @NotNull
    public static final AbstractClanData EMPTY_CLAN_DATA = new AbstractClanData(PacketRegistry.EMPTY_UUID, UUID.randomUUID(), "Unknown");
    public static final int MAX_SIZE = 6;
    public static final int MAX_CLAN_NAME_LENGTH = 4;
    public static final int MIN_CLAN_NAME_LENGTH = 2;

    @NotNull
    private final UUID clanId;

    @NotNull
    private UUID owner;

    @NotNull
    private final Set<UUID> members = new ObjectOpenHashSet();

    @NotNull
    private final String name;

    public AbstractClanData(@NotNull UUID clanId, @NotNull UUID owner, @NotNull String name) {
        this.clanId = clanId;
        this.owner = owner;
        this.name = name;
    }

    public boolean isEmpty() {
        return this == EMPTY_CLAN_DATA;
    }

    @NotNull
    public UUID getClanId() {
        return this.clanId;
    }

    public void addMember(@NotNull UUID member) {
        this.members.add(member);
    }

    public void removeMember(@NotNull UUID member) {
        this.members.remove(member);
    }

    @NotNull
    public Set<UUID> getMembers() {
        return Collections.unmodifiableSet(this.members);
    }

    public void setOwner(@NotNull UUID owner) {
        this.owner = owner;
    }

    @NotNull
    public UUID getOwner() {
        return this.owner;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public static AbstractClanData read(@NotNull ByteBuf byteBuffer) throws IOException {
        UUID clanId = IPacket.readUUID(byteBuffer);
        UUID owner = IPacket.readUUID(byteBuffer);
        String name = IPacket.readString(byteBuffer);
        AbstractClanData clanData = new AbstractClanData(clanId, owner, name);
        int membersCount = byteBuffer.readInt();
        for (int i = 0; i < membersCount; i++) {
            clanData.addMember(IPacket.readUUID(byteBuffer));
        }
        return clanData;
    }

    public void write(@NotNull ByteBuf byteBuffer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.clanId);
        IPacket.writeUUID(byteBuffer, this.owner);
        IPacket.writeString(byteBuffer, this.name);
        byteBuffer.writeInt(this.members.size());
        for (UUID member : this.members) {
            IPacket.writeUUID(byteBuffer, member);
        }
    }
}
