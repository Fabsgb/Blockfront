package com.boehmod.bflib.cloud.common.reward;

import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/reward/RewardRegistry.class */
public final class RewardRegistry {

    @NotNull
    private static final Logger LOGGER = LogManager.getLogger("RewardRegistry");

    @NotNull
    private static final Int2ObjectMap<Class<? extends RewardType>> HASH_TO_CLASS_MAP = Int2ObjectMaps.synchronize(new Int2ObjectOpenHashMap());

    @NotNull
    private static final Object2ObjectMap<Class<? extends RewardType>, PacketIdentifier> CLASS_TO_IDENTIFIER_MAP = Object2ObjectMaps.synchronize(new Object2ObjectOpenHashMap());

    static {
        registerRewardType(ExpRewardType.ID, ExpRewardType.class);
        registerRewardType(ItemRewardType.ID, ItemRewardType.class);
        registerRewardType(RandomItemRewardType.ID, RandomItemRewardType.class);
    }

    private RewardRegistry() {
    }

    public static void registerRewardType(@NotNull PacketIdentifier identifier, @NotNull Class<? extends RewardType> rewardClass) {
        int hash = identifier.hash();
        if (HASH_TO_CLASS_MAP.containsKey(hash)) {
            Class<? extends RewardType> existing = (Class) HASH_TO_CLASS_MAP.get(hash);
            if (!existing.equals(rewardClass)) {
                LOGGER.error("[RewardRegistry] Collision detected! Hash '{}' is already assigned to '{}' and cannot be reassigned to '{}'.", Integer.valueOf(hash), existing.getName(), rewardClass.getName());
                throw new IllegalStateException("Hash collision detected for reward type identifier: " + String.valueOf(identifier));
            }
        }
        LOGGER.info("[RewardRegistry] Registering reward type '{}' with hash '{}'.", rewardClass.getName(), Integer.valueOf(hash));
        HASH_TO_CLASS_MAP.put(hash, rewardClass);
        CLASS_TO_IDENTIFIER_MAP.put(rewardClass, identifier);
    }

    public static void writeRewardType(@NotNull RewardType rewardType, @NotNull ByteBuf byteBuffer) throws IOException {
        PacketIdentifier identifier = (PacketIdentifier) CLASS_TO_IDENTIFIER_MAP.get(rewardType.getClass());
        if (identifier == null) {
            throw new IOException("Unrecognized reward type class: " + rewardType.getClass().getName());
        }
        byteBuffer.writeInt(identifier.hash());
        rewardType.write(byteBuffer);
    }

    @Nullable
    public static RewardType readRewardType(@NotNull ByteBuf byteBuffer) throws IOException {
        int hash = byteBuffer.readInt();
        Class<? extends RewardType> rewardClass = (Class) HASH_TO_CLASS_MAP.get(hash);
        if (rewardClass == null) {
            LOGGER.error("[RewardRegistry] Failed to find reward type class for hash '{}'.", Integer.valueOf(hash));
            return null;
        }
        try {
            return (RewardType) rewardClass.getConstructor(ByteBuf.class).newInstance(byteBuffer);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            LOGGER.error("[RewardRegistry] Failed to instantiate reward type for class '{}'.", rewardClass.getName(), e);
            return null;
        }
    }

    public static void writeRewardTypeList(@NotNull ByteBuf byteBuffer, @NotNull ObjectList<RewardType> rewardTypes) throws IOException {
        byteBuffer.writeInt(rewardTypes.size());
        ObjectListIterator it = rewardTypes.iterator();
        while (it.hasNext()) {
            RewardType rewardType = (RewardType) it.next();
            writeRewardType(rewardType, byteBuffer);
        }
    }

    @NotNull
    public static ObjectList<RewardType> readRewardTypeList(@NotNull ByteBuf byteBuffer) throws IOException {
        int size = byteBuffer.readInt();
        ObjectArrayList objectArrayList = new ObjectArrayList(size);
        for (int i = 0; i < size; i++) {
            RewardType rewardType = readRewardType(byteBuffer);
            if (rewardType != null) {
                objectArrayList.add(rewardType);
            }
        }
        return objectArrayList;
    }
}
