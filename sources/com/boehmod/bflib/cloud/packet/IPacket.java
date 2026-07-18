package com.boehmod.bflib.cloud.packet;

import com.boehmod.bflib.cloud.common.MatchData;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.player.PlayerDataContext;
import com.boehmod.bflib.cloud.common.player.challenge.Challenge;
import com.boehmod.bflib.cloud.common.player.challenge.ChallengeRegistry;
import com.boehmod.bflib.cloud.common.player.status.PublicPlayerStatus;
import com.boehmod.bflib.cloud.common.profanity.Profanity;
import com.boehmod.bflib.exceptions.InvalidEnumReadException;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntListIterator;
import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/IPacket.class */
public interface IPacket {
    public static final int MAX_BYTE_ARRAY_SIZE = 10485760;

    void writePacketToBuffer(@NotNull ByteBuf byteBuf) throws IOException;

    @NotNull
    PacketIdentifier getPacketIdentifier();

    @NotNull
    static Map<UUID, PublicPlayerStatus> readStatusMap(@NotNull ByteBuf byteBuffer) throws IOException {
        int size = readSize(byteBuffer);
        Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap(size);
        for (int i = 0; i < size; i++) {
            UUID playerUUID = readUUID(byteBuffer);
            PublicPlayerStatus status = new PublicPlayerStatus(byteBuffer);
            object2ObjectOpenHashMap.put(playerUUID, status);
        }
        return object2ObjectOpenHashMap;
    }

    static void writeStatusMap(@NotNull ByteBuf byteBuffer, @NotNull Map<UUID, PublicPlayerStatus> statusMap) throws IOException {
        byteBuffer.writeInt(statusMap.size());
        for (Map.Entry<UUID, PublicPlayerStatus> entry : statusMap.entrySet()) {
            writeUUID(byteBuffer, entry.getKey());
            entry.getValue().encode(byteBuffer);
        }
    }

    static void writeBoolean(@NotNull ByteBuf byteBuffer, boolean value) {
        byteBuffer.writeByte((byte) (value ? 1 : 0));
    }

    static boolean readBoolean(@NotNull ByteBuf byteBuffer) {
        return byteBuffer.readByte() == 1;
    }

    @NotNull
    static PlayerDataContext readPlayerDataContext(@NotNull ByteBuf byteBuffer) throws IOException {
        return new PlayerDataContext(byteBuffer.readByte() == 1, (PlayerDataContext.PlayerDataContextType) readEnum(byteBuffer, PlayerDataContext.PlayerDataContextType.class));
    }

    static void writePlayerDataContext(@NotNull ByteBuf byteBuffer, @NotNull PlayerDataContext context) throws IOException {
        byteBuffer.writeByte((byte) (context.isSelf() ? 1 : 0));
        writeEnum(byteBuffer, context.type());
    }

    static int readSize(@NotNull ByteBuf byteBuffer) {
        int size = byteBuffer.readInt();
        if (size < 0 || size > byteBuffer.readableBytes()) {
            throw new IllegalArgumentException("Invalid length prefix " + size + " (readable bytes: " + byteBuffer.readableBytes() + ")");
        }
        return size;
    }

    static byte[] readByteArray(@NotNull ByteBuf byteBuffer) {
        int length = byteBuffer.readInt();
        if (length < 0 || length > 10485760 || length > byteBuffer.readableBytes()) {
            throw new IllegalArgumentException("Invalid byte array length: " + length);
        }
        byte[] data = new byte[length];
        byteBuffer.readBytes(data);
        return data;
    }

    static void writeByteArray(@NotNull ByteBuf byteBuffer, byte[] data) {
        byteBuffer.writeInt(data.length);
        byteBuffer.writeBytes(data);
    }

    @NotNull
    static ObjectList<String> readStringList(@NotNull ByteBuf byteBuffer) {
        int size = readSize(byteBuffer);
        ObjectArrayList objectArrayList = new ObjectArrayList(size);
        for (int i = 0; i < size; i++) {
            objectArrayList.add(readString(byteBuffer));
        }
        return objectArrayList;
    }

    static void writeStringList(@NotNull ByteBuf byteBuffer, @NotNull ObjectList<String> list) {
        byteBuffer.writeInt(list.size());
        ObjectListIterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            writeString(byteBuffer, str);
        }
    }

    @NotNull
    static Map<String, Boolean> readFeatureFlags(@NotNull ByteBuf byteBuffer) {
        int size = readSize(byteBuffer);
        Object2BooleanOpenHashMap object2BooleanOpenHashMap = new Object2BooleanOpenHashMap(size);
        for (int i = 0; i < size; i++) {
            String key = readString(byteBuffer);
            boolean value = byteBuffer.readByte() == 1;
            object2BooleanOpenHashMap.put(key, value);
        }
        return object2BooleanOpenHashMap;
    }

    static void writeFeatureFlags(@NotNull ByteBuf byteBuffer, @NotNull Map<String, Boolean> featureFlags) {
        byteBuffer.writeInt(featureFlags.size());
        for (Map.Entry<String, Boolean> entry : featureFlags.entrySet()) {
            writeString(byteBuffer, entry.getKey());
            byteBuffer.writeByte((byte) (entry.getValue().booleanValue() ? 1 : 0));
        }
    }

    @NotNull
    static ObjectList<Profanity> readProfanityList(@NotNull ByteBuf byteBuffer) {
        int size = readSize(byteBuffer);
        ObjectArrayList objectArrayList = new ObjectArrayList(size);
        for (int i = 0; i < size; i++) {
            objectArrayList.add(new Profanity(byteBuffer));
        }
        return objectArrayList;
    }

    static void writeProfanityList(@NotNull ByteBuf byteBuffer, @NotNull List<Profanity> profanities) {
        byteBuffer.writeInt(profanities.size());
        for (Profanity profanity : profanities) {
            profanity.write(byteBuffer);
        }
    }

    static void writeOptionalString(@NotNull ByteBuf byteBuffer, @Nullable String str) {
        byteBuffer.writeByte((byte) (str != null ? 1 : 0));
        if (str != null) {
            writeString(byteBuffer, str);
        }
    }

    @Nullable
    static String readOptionalString(@NotNull ByteBuf byteBuffer) {
        if (byteBuffer.readByte() == 1) {
            return readString(byteBuffer);
        }
        return null;
    }

    @NotNull
    static Optional<UUID> readUUIDOptional(@NotNull ByteBuf byteBuffer) throws IOException {
        return byteBuffer.readByte() == 1 ? Optional.of(readUUID(byteBuffer)) : Optional.empty();
    }

    static void writeOptionalUUID(@NotNull ByteBuf byteBuffer, @Nullable UUID uuid) throws IOException {
        byteBuffer.writeByte((byte) (uuid != null ? 1 : 0));
        if (uuid != null) {
            writeUUID(byteBuffer, uuid);
        }
    }

    @NotNull
    static InetSocketAddress readInetSocketAddress(@NotNull ByteBuf byteBuffer) {
        return new InetSocketAddress(readString(byteBuffer), byteBuffer.readInt());
    }

    static void writeInetSocketAddress(@NotNull ByteBuf byteBuffer, @NotNull InetSocketAddress address) {
        writeString(byteBuffer, address.getHostString());
        byteBuffer.writeInt(address.getPort());
    }

    @NotNull
    static IntList readIntList(@NotNull ByteBuf byteBuffer) {
        int size = readSize(byteBuffer);
        IntArrayList intArrayList = new IntArrayList(size);
        for (int i = 0; i < size; i++) {
            intArrayList.add(byteBuffer.readInt());
        }
        return intArrayList;
    }

    static void writeIntList(@NotNull ByteBuf byteBuffer, @NotNull IntList list) {
        byteBuffer.writeInt(list.size());
        IntListIterator it = list.iterator();
        while (it.hasNext()) {
            int i = ((Integer) it.next()).intValue();
            byteBuffer.writeInt(i);
        }
    }

    @NotNull
    static <T extends Enum<T>> T readEnum(@NotNull ByteBuf byteBuffer, @NotNull Class<T> enumClass) throws IOException {
        byte ordinal = byteBuffer.readByte();
        T[] values = enumClass.getEnumConstants();
        if (ordinal < 0 || ordinal >= values.length) {
            throw new InvalidEnumReadException("Invalid ordinal value for enum type " + enumClass.getName() + ": " + ordinal + " (valid range: 0 - " + (values.length - 1) + ")");
        }
        return values[ordinal];
    }

    static void writeEnum(@NotNull ByteBuf byteBuffer, @NotNull Enum<?> enumValue) throws IOException {
        byteBuffer.writeByte((byte) enumValue.ordinal());
    }

    @NotNull
    static UUID readUUID(@NotNull ByteBuf byteBuffer) throws IOException {
        return new UUID(byteBuffer.readLong(), byteBuffer.readLong());
    }

    static void writeUUID(@NotNull ByteBuf byteBuffer, @NotNull UUID uuid) throws IOException {
        byteBuffer.writeLong(uuid.getMostSignificantBits());
        byteBuffer.writeLong(uuid.getLeastSignificantBits());
    }

    @NotNull
    static ObjectSet<UUID> readUUIDSet(@NotNull ByteBuf byteBuffer) throws IOException {
        int size = readSize(byteBuffer);
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet(size);
        for (int i = 0; i < size; i++) {
            objectOpenHashSet.add(readUUID(byteBuffer));
        }
        return objectOpenHashSet;
    }

    static void writeUUIDSet(@NotNull ByteBuf byteBuffer, @NotNull ObjectSet<UUID> uuids) throws IOException {
        byteBuffer.writeInt(uuids.size());
        ObjectIterator it = uuids.iterator();
        while (it.hasNext()) {
            UUID uuid = (UUID) it.next();
            writeUUID(byteBuffer, uuid);
        }
    }

    static void writeString(@NotNull ByteBuf byteBuffer, @NotNull String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        byteBuffer.writeInt(bytes.length);
        byteBuffer.writeBytes(bytes);
    }

    @NotNull
    static String readString(@NotNull ByteBuf byteBuffer) {
        return new String(readByteArray(byteBuffer), StandardCharsets.UTF_8);
    }

    static void writeCloudItemStackList(@NotNull ByteBuf byteBuffer, @NotNull List<CloudItemStack> cloudItemStacks) throws IOException {
        byteBuffer.writeInt(cloudItemStacks.size());
        for (CloudItemStack cloudItemStack : cloudItemStacks) {
            cloudItemStack.write(byteBuffer);
        }
    }

    @NotNull
    static ObjectList<CloudItemStack> readCloudItemStackList(@NotNull ByteBuf byteBuffer) throws IOException {
        int size = readSize(byteBuffer);
        ObjectArrayList objectArrayList = new ObjectArrayList(size);
        for (int i = 0; i < size; i++) {
            objectArrayList.add(new CloudItemStack(byteBuffer));
        }
        return objectArrayList;
    }

    static void writeMatchDataList(@NotNull ByteBuf byteBuffer, @NotNull ObjectList<MatchData> matchDataList) throws IOException {
        byteBuffer.writeInt(matchDataList.size());
        ObjectListIterator it = matchDataList.iterator();
        while (it.hasNext()) {
            MatchData matchData = (MatchData) it.next();
            matchData.write(byteBuffer);
        }
    }

    @NotNull
    static ObjectList<MatchData> readMatchDataList(@NotNull ByteBuf byteBuffer) throws IOException {
        int size = readSize(byteBuffer);
        ObjectArrayList objectArrayList = new ObjectArrayList(size);
        for (int i = 0; i < size; i++) {
            objectArrayList.add(MatchData.readInstanceFromStream(byteBuffer));
        }
        return objectArrayList;
    }

    @NotNull
    static <T extends Enum<T>> EnumSet<T> readEnumSet(@NotNull ByteBuf byteBuffer, @NotNull Class<T> enumClass) throws IOException {
        int size = readSize(byteBuffer);
        EnumSet<T> enumSet = EnumSet.noneOf(enumClass);
        for (int i = 0; i < size; i++) {
            enumSet.add(readEnum(byteBuffer, enumClass));
        }
        return enumSet;
    }

    static <T extends Enum<T>> void writeEnumSet(@NotNull ByteBuf byteBuffer, @NotNull EnumSet<T> enumSet) throws IOException {
        byteBuffer.writeInt(enumSet.size());
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            writeEnum(byteBuffer, (Enum) it.next());
        }
    }

    @NotNull
    static <T extends Enum<T>> ObjectList<Map.Entry<UUID, EnumSet<T>>> readEnumSetMap(@NotNull ByteBuf byteBuffer, @NotNull Class<T> enumClass) throws IOException {
        int size = readSize(byteBuffer);
        ObjectArrayList objectArrayList = new ObjectArrayList(size);
        for (int i = 0; i < size; i++) {
            UUID uuid = readUUID(byteBuffer);
            EnumSet<T> enumSet = readEnumSet(byteBuffer, enumClass);
            objectArrayList.add(Map.entry(uuid, enumSet));
        }
        return objectArrayList;
    }

    static <T extends Enum<T>> void writeEnumSetMap(@NotNull ByteBuf byteBuffer, @NotNull List<Map.Entry<UUID, EnumSet<T>>> enumSetMap) throws IOException {
        byteBuffer.writeInt(enumSetMap.size());
        for (Map.Entry<UUID, EnumSet<T>> entry : enumSetMap) {
            writeUUID(byteBuffer, entry.getKey());
            writeEnumSet(byteBuffer, entry.getValue());
        }
    }

    @Nullable
    static Challenge readChallenge(@NotNull ByteBuf byteBuffer) throws IOException {
        return ChallengeRegistry.readChallenge(byteBuffer);
    }

    static void writeChallenge(@NotNull Challenge challenge, @NotNull ByteBuf byteBuffer) throws IOException {
        ChallengeRegistry.writeChallenge(challenge, byteBuffer);
    }

    @NotNull
    static ObjectList<Challenge> readChallengeList(@NotNull ByteBuf byteBuffer) throws IOException {
        int size = readSize(byteBuffer);
        ObjectArrayList objectArrayList = new ObjectArrayList(size);
        for (int i = 0; i < size; i++) {
            Challenge challenge = readChallenge(byteBuffer);
            if (challenge != null) {
                objectArrayList.add(challenge);
            }
        }
        return objectArrayList;
    }

    static void writeChallengeList(@NotNull ByteBuf byteBuffer, @NotNull List<Challenge> challenges) throws IOException {
        byteBuffer.writeInt(challenges.size());
        for (Challenge challenge : challenges) {
            writeChallenge(challenge, byteBuffer);
        }
    }
}
