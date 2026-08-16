package com.boehmod.bflib.cloud.common.p001mm.report;

import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/mm/report/MatchReportDataRegistry.class */
public final class MatchReportDataRegistry {

    @NotNull
    private static final Logger LOGGER = LogManager.getLogger("MatchReportDataRegistry");

    @NotNull
    private static final Int2ObjectMap<Class<? extends IMatchReportData>> HASH_TO_CLASS_MAP = Int2ObjectMaps.synchronize(new Int2ObjectOpenHashMap());

    @NotNull
    private static final Object2ObjectMap<Class<? extends IMatchReportData>, PacketIdentifier> CLASS_TO_IDENTIFIER_MAP = Object2ObjectMaps.synchronize(new Object2ObjectOpenHashMap());

    static {
        registerMatchReportData(DominationMatchReportData.f7ID, DominationMatchReportData.class);
        registerMatchReportData(FreeForAllMatchReportData.f8ID, FreeForAllMatchReportData.class);
        registerMatchReportData(OffensiveMatchReportData.f9ID, OffensiveMatchReportData.class);
    }

    private MatchReportDataRegistry() {
    }

    public static void registerMatchReportData(@NotNull PacketIdentifier identifier, @NotNull Class<? extends IMatchReportData> dataClass) {
        int hash = identifier.hash();
        if (HASH_TO_CLASS_MAP.containsKey(hash)) {
            Class<? extends IMatchReportData> existing = (Class) HASH_TO_CLASS_MAP.get(hash);
            if (!existing.equals(dataClass)) {
                LOGGER.error("[MatchReportDataRegistry] Collision detected! Hash '{}' is already assigned to '{}' and cannot be reassigned to '{}'.", Integer.valueOf(hash), existing.getName(), dataClass.getName());
                throw new IllegalStateException("Hash collision detected for match report data identifier: " + String.valueOf(identifier));
            }
        }
        HASH_TO_CLASS_MAP.put(hash, dataClass);
        CLASS_TO_IDENTIFIER_MAP.put(dataClass, identifier);
    }

    public static void writeMatchReportData(@NotNull IMatchReportData data, @NotNull ByteBuf byteBuffer) throws IOException {
        PacketIdentifier identifier = (PacketIdentifier) CLASS_TO_IDENTIFIER_MAP.get(data.getClass());
        if (identifier == null) {
            throw new IOException("Unrecognized match report data class: " + data.getClass().getName());
        }
        byteBuffer.writeInt(identifier.hash());
        data.write(byteBuffer);
    }

    @Nullable
    public static IMatchReportData readMatchReportData(@NotNull ByteBuf byteBuffer) throws IOException {
        int hash = byteBuffer.readInt();
        Class<? extends IMatchReportData> dataClass = (Class) HASH_TO_CLASS_MAP.get(hash);
        if (dataClass == null) {
            LOGGER.error("[MatchReportDataRegistry] Failed to find match report data class for hash '{}'.", Integer.valueOf(hash));
            return null;
        }
        try {
            return (IMatchReportData) dataClass.getConstructor(ByteBuf.class).newInstance(byteBuffer);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            LOGGER.error("[MatchReportDataRegistry] Failed to instantiate match report data for class '{}'.", dataClass.getName(), e);
            return null;
        }
    }
}
