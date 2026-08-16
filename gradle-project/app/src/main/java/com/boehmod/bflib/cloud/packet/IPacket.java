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
import io.netty.buffer.ByteBufUtil;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntListIterator;
import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/packet/IPacket.class */
public interface IPacket {
    public static final int MAX_BYTE_ARRAY_SIZE = 1048576;
    public static final int MAX_PRESIZE = 1024;
    public static final ClassValue<Enum<?>[]> ENUM_CONSTANTS = new ClassValue<Enum<?>[]>() { // from class: com.boehmod.bflib.cloud.packet.IPacket.1
        @Override // java.lang.ClassValue
        protected /* bridge */ /* synthetic */ Enum<?>[] computeValue(@NotNull Class cls) {
            return computeValue((Class<?>) cls);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ClassValue
        protected Enum<?>[] computeValue(@NotNull Class<?> type) {
            return (Enum[]) type.getEnumConstants();
        }
    };

    void writePacketToBuffer(@NotNull ByteBuf byteBuf) throws IOException;

    @NotNull
    PacketIdentifier getPacketIdentifier();

    @NotNull
    static Map<UUID, PublicPlayerStatus> readStatusMap(@NotNull ByteBuf byteBuffer) throws IOException {
        return readMap(byteBuffer, IPacket::readUUID, PublicPlayerStatus::new);
    }

    static void writeStatusMap(@NotNull ByteBuf byteBuffer, @NotNull Map<UUID, PublicPlayerStatus> statusMap) throws IOException {
        writeMap(byteBuffer, statusMap, IPacket::writeUUID, (buffer, status) -> {
            status.encode(buffer);
        });
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

    static int presize(int size) {
        return Math.min(Math.max(size, 0), 1024);
    }

    @NotNull
    static <T> ObjectList<T> readList(@NotNull ByteBuf byteBuffer, @NotNull ByteBufReader<T> reader) throws IOException {
        int size = readSize(byteBuffer);
        ObjectArrayList objectArrayList = new ObjectArrayList(presize(size));
        for (int i = 0; i < size; i++) {
            objectArrayList.add(reader.read(byteBuffer));
        }
        return objectArrayList;
    }

    @NotNull
    static <T> ObjectList<T> readListSkippingNulls(@NotNull ByteBuf byteBuffer, @NotNull ByteBufReader<T> reader) throws IOException {
        int size = readSize(byteBuffer);
        ObjectArrayList objectArrayList = new ObjectArrayList(presize(size));
        for (int i = 0; i < size; i++) {
            T element = reader.read(byteBuffer);
            if (element != null) {
                objectArrayList.add(element);
            }
        }
        return objectArrayList;
    }

    @NotNull
    static <T> ObjectSet<T> readSet(@NotNull ByteBuf byteBuffer, @NotNull ByteBufReader<T> reader) throws IOException {
        int size = readSize(byteBuffer);
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet(presize(size));
        for (int i = 0; i < size; i++) {
            objectOpenHashSet.add(reader.read(byteBuffer));
        }
        return objectOpenHashSet;
    }

    @NotNull
    static <K, V> Map<K, V> readMap(@NotNull ByteBuf byteBuffer, @NotNull ByteBufReader<K> keyReader, @NotNull ByteBufReader<V> valueReader) throws IOException {
        int size = readSize(byteBuffer);
        Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap(presize(size));
        for (int i = 0; i < size; i++) {
            K key = keyReader.read(byteBuffer);
            V value = valueReader.read(byteBuffer);
            object2ObjectOpenHashMap.put(key, value);
        }
        return object2ObjectOpenHashMap;
    }

    static <T> void writeCollection(@NotNull ByteBuf byteBuffer, @NotNull Collection<T> collection, @NotNull ByteBufWriter<T> writer) throws IOException {
        byteBuffer.writeInt(collection.size());
        for (T element : collection) {
            writer.write(byteBuffer, element);
        }
    }

    static <K, V> void writeMap(@NotNull ByteBuf byteBuffer, @NotNull Map<K, V> map, @NotNull ByteBufWriter<K> keyWriter, @NotNull ByteBufWriter<V> valueWriter) throws IOException {
        byteBuffer.writeInt(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            keyWriter.write(byteBuffer, entry.getKey());
            valueWriter.write(byteBuffer, entry.getValue());
        }
    }

    static byte[] readByteArray(@NotNull ByteBuf byteBuffer) {
        int length = byteBuffer.readInt();
        if (length < 0 || length > 1048576 || length > byteBuffer.readableBytes()) {
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
        ObjectArrayList objectArrayList = new ObjectArrayList(presize(size));
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
        Object2BooleanOpenHashMap object2BooleanOpenHashMap = new Object2BooleanOpenHashMap(presize(size));
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
        ObjectArrayList objectArrayList = new ObjectArrayList(presize(size));
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
        IntArrayList intArrayList = new IntArrayList(presize(size));
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
    static <T extends Enum<T>> T readEnum(@NotNull ByteBuf byteBuf, @NotNull Class<T> cls) throws IOException {
        byte b = byteBuf.readByte();
        Enum[] enumArr = ENUM_CONSTANTS.get(cls);
        if (b < 0 || b >= enumArr.length) {
            throw new InvalidEnumReadException("Invalid ordinal value for enum type " + cls.getName() + ": " + b + " (valid range: 0 - " + (enumArr.length - 1) + ")");
        }
        return (T) enumArr[b];
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
        return readSet(byteBuffer, IPacket::readUUID);
    }

    static void writeUUIDSet(@NotNull ByteBuf byteBuffer, @NotNull ObjectSet<UUID> uuids) throws IOException {
        writeCollection(byteBuffer, uuids, IPacket::writeUUID);
    }

    static void writeString(@NotNull ByteBuf byteBuffer, @NotNull String str) {
        int lengthIndex = byteBuffer.writerIndex();
        byteBuffer.writeInt(0);
        int written = ByteBufUtil.writeUtf8(byteBuffer, str);
        byteBuffer.setInt(lengthIndex, written);
    }

    @NotNull
    static String readString(@NotNull ByteBuf byteBuffer) {
        int length = byteBuffer.readInt();
        if (length < 0 || length > 1048576 || length > byteBuffer.readableBytes()) {
            throw new IllegalArgumentException("Invalid string length: " + length);
        }
        String str = byteBuffer.toString(byteBuffer.readerIndex(), length, StandardCharsets.UTF_8);
        byteBuffer.skipBytes(length);
        return str;
    }

    static void writeCloudItemStackList(@NotNull ByteBuf byteBuffer, @NotNull List<CloudItemStack> cloudItemStacks) throws IOException {
        writeCollection(byteBuffer, cloudItemStacks, (buffer, cloudItemStack) -> {
            cloudItemStack.write(buffer);
        });
    }

    @NotNull
    static ObjectList<CloudItemStack> readCloudItemStackList(@NotNull ByteBuf byteBuffer) throws IOException {
        return readList(byteBuffer, CloudItemStack::new);
    }

    static void writeMatchDataList(@NotNull ByteBuf byteBuffer, @NotNull ObjectList<MatchData> matchDataList) throws IOException {
        writeCollection(byteBuffer, matchDataList, (buffer, matchData) -> {
            matchData.write(buffer);
        });
    }

    @NotNull
    static ObjectList<MatchData> readMatchDataList(@NotNull ByteBuf byteBuffer) throws IOException {
        return readList(byteBuffer, MatchData::readInstanceFromStream);
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
        return readList(byteBuffer, buffer -> {
            return Map.entry(readUUID(buffer), readEnumSet(buffer, enumClass));
        });
    }

    static <T extends Enum<T>> void writeEnumSetMap(@NotNull ByteBuf byteBuffer, @NotNull List<Map.Entry<UUID, EnumSet<T>>> enumSetMap) throws IOException {
        writeCollection(byteBuffer, enumSetMap, (buffer, entry) -> {
            writeUUID(buffer, (UUID) entry.getKey());
            writeEnumSet(buffer, (EnumSet) entry.getValue());
        });
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
        return readListSkippingNulls(byteBuffer, IPacket::readChallenge);
    }

    static void writeChallengeList(@NotNull ByteBuf byteBuffer, @NotNull List<Challenge> challenges) throws IOException {
        writeCollection(byteBuffer, challenges, (buffer, challenge) -> {
            writeChallenge(challenge, buffer);
        });
    }
}
